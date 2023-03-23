package com.icarumbas.casto.icons

import com.icarumbas.casto.utils.SvgParser
import com.icarumbas.casto.utils.nameWithoutExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files


@RestController
class IconsController @Autowired constructor(
    private val pngIconsStorageService: PngIconsStorageService,
    private val svgIconsStorageService: SvgIconsStorageService,
    private val svgParser: SvgParser,
) {
    @GetMapping(
        path = ["icon/{ticker}"]
    )
    fun getIcon(@PathVariable ticker: String): ResponseEntity<ByteArray> {
        val resource = pngIconsStorageService.getIconResource(ticker)
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(resource.contentAsByteArray)
    }

    @GetMapping("/path/{ticker}")
    fun getIconServerPath(@PathVariable ticker: String): ResponseEntity<String> {
        val path = pngIconsStorageService.getIconPath(ticker)
        return ResponseEntity.ok()
            .body(path.toString())
    }

    @PostMapping(
        path = ["/save-icon"],
        consumes = [MediaType.MULTIPART_FORM_DATA_VALUE]
    )
    fun handleIconUpload(
        @RequestParam files: List<MultipartFile>
    ): String {
        files.forEach { file ->
            val svgFilePath = svgIconsStorageService.storeIcon(file)

            if (svgFilePath != null) {
                val ticker = file.nameWithoutExtension
                val pngIconFile = pngIconsStorageService
                    .getIconPath(ticker.uppercase())
                    .toFile()

                if (!pngIconFile.exists()) {
                    pngIconFile.createNewFile()
                    val data = svgParser.svgToPng(svgFilePath.toFile())
                    Files.write(pngIconFile.toPath(), data)
                }
            }
        }
        return "Files have been uploaded"
    }
}