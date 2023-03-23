package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.FileStorageService
import com.icarumbas.casto.storage.StorageFileNotFoundException
import com.icarumbas.casto.utils.*
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.core.io.Resource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Path

@Service
class IconsStorageService(
    private val fileStorageService: FileStorageService,
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
        safeValueOf<IconExtension>(uppercase())

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

    fun storeIcon(file: MultipartFile) {
        val extension = file.extension.lowercase()
        val iconExtension = safeValueOf<IconExtension>(extension.uppercase()) ?: return
        val folderPath = iconExtension.folderPath()
        val path = fileStorageService.store(file, folderPath)

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