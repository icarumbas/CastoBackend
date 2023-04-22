package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.files.LocalFileStorageService
import com.icarumbas.casto.storage.files.StorageFileNotFoundException
import com.icarumbas.casto.utils.*
import com.icarumbas.casto.core.utils.beforeFirstDot
import com.icarumbas.casto.core.utils.extension
import com.icarumbas.casto.core.utils.nameWithoutExtension
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
        return fileStorageService.loadAsResource(ticker.uppercase(), iconExtension.value, folderPath)
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
        val iconExtension = file.extension?.toIconExtension() ?:
            throw IllegalArgumentException("Unknown extension: ${file.extension}")
        val ticker = file.nameWithoutExtension?.beforeFirstDot ?:
            throw IllegalArgumentException("Unknown symbol: ${file.originalFilename}")

        val filePath = fileStorageService
            .getPath(ticker.uppercase(), iconExtension.value, iconExtension.folderPath())
        fileStorageService.store(file, filePath)

        if (iconExtension == IconExtension.SVG) {
            if (filePath.toFile().exists()) {
                val pngParams = IconExtension.PNG
                val pngIconFile = fileStorageService
                    .getPath(ticker.uppercase(), pngParams.value, pngParams.folderPath())
                    .toFile()
                pngIconFile.createNewFile()
                val data = svgParser.svgToPng(filePath.toFile())
                Files.write(pngIconFile.toPath(), data)
            }
        }
    }

    fun removeIcon(ticker: String, extension: String?) {
        fun remove(extension: IconExtension) {
            val folderPath = extension.folderPath()
            val path = fileStorageService.getPath(ticker.uppercase(), extension.value, folderPath)
            fileStorageService.delete(path)
        }

        if (extension != null) {
            val iconExtension = extension.toIconExtension()
                ?: throw StorageFileNotFoundException("Unknown extension: $extension")
            remove(iconExtension)
        } else {
            remove(IconExtension.SVG)
            remove(IconExtension.PNG)
        }
    }

    fun removeAll() {
        fileStorageService.deleteContents(pngIconsPath)
        fileStorageService.deleteContents(svgIconsPath)
    }

}