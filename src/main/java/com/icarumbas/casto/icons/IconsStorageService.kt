package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.LocalFileStorageService
import com.icarumbas.casto.storage.StorageFileNotFoundException
import com.icarumbas.casto.utils.*
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.lang.IllegalArgumentException
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Stream

@Service
class IconsStorageService(
    private val fileStorageService: LocalFileStorageService,
    @Qualifier("pngIconsPath") private val pngIconsPath: Path,
    @Qualifier("svgIconsPath") private val svgIconsPath: Path,
    @Qualifier("baseIconsPath") private val baseIconsPath: Path,
    private val svgParser: SvgParser,
) {
    enum class IconExtension(val value: String) {
        SVG(".svg"),
        PNG(".png"),
    }

    private fun IconExtension.folderPath(): Path =
        when (this) {
            IconExtension.SVG -> svgIconsPath
            IconExtension.PNG -> pngIconsPath
        }

    private fun String.toIconExtension(): IconExtension? =
        IconExtension.values().find { it.name == uppercase() }

    init {
        fileStorageService.createDirectories(pngIconsPath, svgIconsPath)
    }

    fun getIconResource(ticker: String, extension: String): Resource {
        val iconExtension = extension.toIconExtension() ?:
            throw StorageFileNotFoundException("Unknown extension: $extension")
        val folderPath = iconExtension.folderPath()
        return fileStorageService.loadAsResource(ticker, iconExtension.value, folderPath)
    }

    fun getIconPath(ticker: String, extension: String): Path {
        val iconExtension = extension.toIconExtension() ?:
            throw StorageFileNotFoundException("Unknown extension: $extension")
        val folderPath = iconExtension.folderPath()
        return fileStorageService.getPath(ticker, iconExtension.value, folderPath)
    }

    fun listFiles(extension: String?): Stream<Path> {
        return if (extension != null) {
            val iconExtension = extension.toIconExtension()
                ?: throw StorageFileNotFoundException("Unknown extension: $extension")
            val folderPath = iconExtension.folderPath()
            fileStorageService.listFiles(folderPath)
        } else {
            val pngStream = fileStorageService.listFiles(pngIconsPath)
            val svgStream = fileStorageService.listFiles(svgIconsPath)
            Stream.concat(pngStream, svgStream)
        }
    }

    fun storeIcon(file: MultipartFile) {
        val iconExtension = file.extension.toIconExtension() ?:
            throw IllegalArgumentException("Unknown extension: ${file.extension}")
        val folderPath = iconExtension.folderPath()
        val path = fileStorageService.store(file, folderPath, file.originalFilename.uppercase())

        if (iconExtension == IconExtension.SVG) {
            if (path != null) {
                val ticker = file.nameWithoutExtension
                val pngParams = IconExtension.PNG
                val pngIconFile = fileStorageService
                    .getPath(ticker.uppercase(), pngParams.value, pngParams.folderPath())
                    .toFile()

                if (!pngIconFile.exists()) {
                    pngIconFile.createNewFile()
                    val data = svgParser.svgToPng(path.toFile())
                    Files.write(pngIconFile.toPath(), data)
                }
            }
        }
    }


}