package com.icarumbas.casto.storage

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Path
import java.util.stream.Stream

interface FileStorageService {

    fun store(file: File, folderPath: Path): Path?

    fun store(file: MultipartFile, folderPath: Path, name: String = file.originalFilename): Path?

    fun getPath(name: String, extension: String, folderPath: Path): Path

    fun loadAsResource(name: String, extension: String, folderPath: Path): Resource

    fun deleteAll(folderPath: Path)

    fun createDirectories(vararg folderPaths: Path)

    fun listFiles(folderPath: Path): Stream<Path>
}