package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.FileStorageService
import jakarta.annotation.Resource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.nio.file.Path

private const val SVG_ICONS_FOLDER_NAME = "icons/svg"
private const val SVG_EXTENSION = ".svg"

@Service
class SvgIconsStorageService @Autowired constructor(
    private val fileStorageService: FileStorageService,
    @Resource(name = "baseFilePath")
    private val baseFilePath: Path,
): IconsStorageService(fileStorageService, baseFilePath, SVG_ICONS_FOLDER_NAME, SVG_EXTENSION)