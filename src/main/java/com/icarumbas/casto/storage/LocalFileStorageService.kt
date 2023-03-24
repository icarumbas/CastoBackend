package com.icarumbas.casto.storage

import org.apache.commons.io.FileUtils
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import java.util.stream.Stream


@Service
class LocalFileStorageService : FileStorageService {

    override fun store(file: File, folderPath: Path) {
        return store(folderPath, file.inputStream())
    }

    override fun store(file: MultipartFile, folderPath: Path) {
        return store(folderPath, file.inputStream)
    }

    override fun getPath(name: String, extension: String, folderPath: Path): Path {
        return folderPath.resolve("$name$extension")
    }

    override fun loadAsResource(name: String, extension: String, folderPath: Path): Resource {
        return try {
            val file = getPath(name, extension, folderPath)
            val resource: Resource = UrlResource(file.toUri())
            if (resource.exists() || resource.isReadable) {
                resource
            } else {
                throw StorageFileNotFoundException("Could not read file: $name.$extension")
            }
        } catch (e: MalformedURLException) {
            throw StorageFileNotFoundException("Could not read file: $name.$extension", e)
        }
    }

    override fun delete(path: Path) {
        FileSystemUtils.deleteRecursively(path)
    }

    override fun deleteContents(path: Path) {
        FileUtils.cleanDirectory(path.toFile())
    }

    override fun createDirectories(vararg folderPaths: Path) {
        folderPaths.forEach { path ->
            try {
                Files.createDirectories(path)
            } catch (e: IOException) {
                throw StorageException("Could not create directories for path: $path", e)
            }
        }
    }

    override fun listFiles(folderPath: Path): Stream<Path> {
        return try {
            Files.walk(folderPath, 1)
                .filter { path: Path -> path != folderPath }
                .map(folderPath::relativize)
        } catch (e: IOException) {
            throw StorageException("Failed to read stored files", e)
        }
    }

    private fun store(folderPath: Path, inputStream: InputStream) {
        try {
            inputStream.use {
                Files.copy(
                    it, folderPath,
                    StandardCopyOption.REPLACE_EXISTING
                )
            }
        } catch (e: IOException) {
            throw StorageException("Failed to store file.", e)
        }
    }
}