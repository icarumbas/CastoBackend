package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.StorageException
import com.icarumbas.casto.storage.StorageFileNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import org.springframework.util.FileSystemUtils
import java.io.File
import java.io.IOException
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.stream.Stream


private const val ICONS_LOCATION = "/out/icons"
private const val ICONS_EXTENSION = ".png"

@Service
class IconsStorageService @Autowired constructor() {

    private val rootPath = System.getProperty("user.dir")
    private val iconsPath = Paths.get(rootPath, ICONS_LOCATION)

    init {
        try {
            Files.createDirectories(iconsPath)
        } catch (e: IOException) {
            throw StorageException("Could not initialize storage", e)
        }
    }

    fun store(file: File) {
        try {
            val destinationFile = iconsPath.resolve(
                Paths.get(file.name)
            ).normalize().toAbsolutePath()

            if (destinationFile.parent != iconsPath.toAbsolutePath()) {
                // This is a security check
                throw StorageException(
                    "Cannot store file outside current directory."
                )
            }
            file.inputStream().use { inputStream ->
                Files.copy(
                    inputStream, destinationFile,
                    StandardCopyOption.REPLACE_EXISTING
                )
            }
        } catch (e: IOException) {
            throw StorageException("Failed to store file.", e)
        }
    }

    fun loadAll(): Stream<Path> {
        return try {
            Files.walk(iconsPath, 1)
                .filter { path: Path -> path != iconsPath }
                .map { other: Path? -> iconsPath.relativize(other) }
        } catch (e: IOException) {
            throw StorageException("Failed to read stored files", e)
        }
    }

    fun getPath(ticker: String): Path {
        return iconsPath.resolve("$ticker.$ICONS_EXTENSION")
    }

    fun loadAsResource(ticker: String): Resource {
        return try {
            val file = getPath(ticker)
            val resource: Resource = UrlResource(file.toUri())
            if (resource.exists() || resource.isReadable) {
                resource
            } else {
                throw StorageFileNotFoundException(
                    "Could not read file: $ticker"
                )
            }
        } catch (e: MalformedURLException) {
            throw StorageFileNotFoundException("Could not read file: $ticker", e)
        }
    }

    fun deleteAll() {
        FileSystemUtils.deleteRecursively(iconsPath.toFile())
    }
}