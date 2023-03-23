package com.icarumbas.casto.icons

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
class IconsController @Autowired constructor(
    private val iconsStorageService: IconsStorageService,
) {
    @GetMapping(
        path = ["icon/{ticker}"]
    )
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
}