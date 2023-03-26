package com.icarumbas.casto.storage.files

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Path
import java.util.stream.Stream

interface FileStorageService {

    fun store(file: File, folderPath: Path)

    fun store(file: MultipartFile, folderPath: Path)

    fun getPath(name: String, extension: String, folderPath: Path): Path

    fun loadAsResource(name: String, extension: String, folderPath: Path): Resource

    fun delete(path: Path)

    fun deleteContents(path: Path)

    fun createDirectories(vararg folderPaths: Path)

    fun listFiles(folderPath: Path): Stream<Path>
}