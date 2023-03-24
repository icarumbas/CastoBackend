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
@RequestMapping("/icons")
class IconsController @Autowired constructor(
    private val iconsStorageService: IconsStorageService,
) {
    @GetMapping(path = ["/{ticker}"])
    fun getIcon(
        @PathVariable ticker: String,
        @RequestParam(required = false) extension: String?,
    ): ResponseEntity<ByteArray> {
        val resource = iconsStorageService.getIconResource(ticker, extension ?: "png")

        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .header("SERVER_PATH", resource.url.toString())
            .body(resource.contentAsByteArray)
    }

    @PostMapping(path = ["/remove/{ticker}"])
    fun removeIcon(
        @PathVariable ticker: String,
        @RequestParam(required = false) extension: String?,
    ): ResponseEntity<String> {
        iconsStorageService.removeIcon(ticker, extension)
        return ResponseEntity.ok("Successfully removed icon $ticker")
    }

    @PostMapping(path = ["/remove-all"])
    fun removeIcon(): ResponseEntity<String> {
        iconsStorageService.removeAll()
        return ResponseEntity.ok("Successfully removed all icons")
    }

    @PostMapping(
        path = ["/save"],
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

    @GetMapping("/list")
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