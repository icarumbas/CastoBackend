package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.FileStorageService
import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Path
import kotlin.io.path.nameWithoutExtension


abstract class IconsStorageService(
    private val fileStorageService: FileStorageService,
    baseFilePath: Path,
    folderName: String,
    private val fileExtension: String,
) {

    private val iconsFolder = baseFilePath.resolve(folderName)

    init {
        fileStorageService.createDirectories(iconsFolder)
    }

    fun getIconResource(ticker: String): Resource {
        return fileStorageService.loadAsResource(ticker, fileExtension, iconsFolder)
    }

    fun getIconPath(ticker: String): Path {
        return fileStorageService.getPath(ticker, fileExtension, iconsFolder)
    }

    fun storeIcon(file: MultipartFile): Path? {
        return fileStorageService.store(file, iconsFolder)
    }

    fun storeIcon(file: File) {
        fileStorageService.store(file, iconsFolder)
    }
}