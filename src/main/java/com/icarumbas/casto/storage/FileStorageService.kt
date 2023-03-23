package com.icarumbas.casto.storage

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
import java.nio.file.Paths
import java.nio.file.StandardCopyOption


@Service
class FileStorageService {

    fun store(file: File, folderPath: Path): Path? {
        return store(file.name, folderPath, file.inputStream())
    }

    fun store(file: MultipartFile, folderPath: Path, name: String = file.originalFilename): Path? {
        return store(name, folderPath, file.inputStream)
    }

    private fun store(fileName: String, folderPath: Path, inputStream: InputStream): Path? {
        try {
            val destinationFile = folderPath.resolve(
                Paths.get(fileName).normalize()
            ).normalize().toAbsolutePath()

            if (destinationFile.parent != folderPath.toAbsolutePath()) {
                // This is a security check
                throw StorageException(
                    "Cannot store file outside current directory."
                )
            }
            inputStream.use {
                Files.copy(
                    it, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING
                )
            }
            return destinationFile
        } catch (e: IOException) {
            throw StorageException("Failed to store file.", e)
        }
    }

    fun getPath(name: String, extension: String, folderPath: Path): Path {
        return folderPath.resolve("$name$extension")
    }

    fun loadAsResource(name: String, extension: String, folderPath: Path): Resource {
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

    fun deleteAll(folderPath: Path) {
        FileSystemUtils.deleteRecursively(folderPath.toFile())
    }

    fun createDirectories(vararg folderPaths: Path) {
        folderPaths.forEach { path ->
            try {
                Files.createDirectories(path)
            } catch (e: IOException) {
                throw StorageException("Could not create directories for path: $path", e)
            }
        }
    }
}