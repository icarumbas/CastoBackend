package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.FileStorageService
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.nio.file.Path

private const val PNG_ICONS_FOLDER_NAME = "icons/png"
private const val PNG_EXTENSION = ".png"

@Service
class PngIconsStorageService @Autowired constructor(
    private val fileStorageService: FileStorageService,
    @Resource(name = "baseFilePath")
    private val baseFilePath: Path,
): IconsStorageService(fileStorageService, baseFilePath, PNG_ICONS_FOLDER_NAME, PNG_EXTENSION)