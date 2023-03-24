package com.icarumbas.casto.icons

import com.icarumbas.casto.storage.StorageFileNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Collectors


@RestController
class IconsController @Autowired constructor(
    private val iconsStorageService: IconsStorageService,
) {
    @GetMapping(path = ["icon/{ticker}"])
    fun getIcon(
        @PathVariable ticker: String,
        @RequestParam extension: String,
    ): ResponseEntity<ByteArray> {
        val resource = iconsStorageService.getIconResource(ticker, extension)

        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .header("SERVER_PATH", resource.url.toString())
            .body(resource.contentAsByteArray)
    }

    @PostMapping(
        path = ["/save-icon"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE]
    )
    fun handleIconUpload(
        @RequestParam files: List<MultipartFile>
    ): String {
        files.forEach { file ->
            iconsStorageService.storeIcon(file)
        }
        return "Files have been uploaded"
    }

    @GetMapping("/list-icons")
    fun listUploadedFiles(
        @RequestParam(required = false) extension: String?,
    ): ResponseEntity<List<String>> {
        val list = iconsStorageService.listFiles(extension)
            .map(Path::toString)
            .collect(Collectors.toList())
        return ResponseEntity.ok(list)
    }

    @ExceptionHandler(StorageFileNotFoundException::class)
    fun handleStorageFileNotFound(exc: StorageFileNotFoundException): ResponseEntity<*>? {
        return ResponseEntity.notFound().build<Any>()
    }
}