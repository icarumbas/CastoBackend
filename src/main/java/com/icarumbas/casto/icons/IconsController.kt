package com.icarumbas.casto.icons

import com.icarumbas.casto.utils.SvgParser
import com.icarumbas.casto.utils.nameWithoutExtension
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import java.nio.file.Files


@RestController
class IconsController @Autowired constructor(
    private val pngIconsStorageService: PngIconsStorageService,
    private val svgIconsStorageService: SvgIconsStorageService,
    private val svgParser: SvgParser,
) {
    @GetMapping(
        "/{ticker}",
        MediaType.IMAGE_PNG_VALUE
    )
    fun getIcon(@PathVariable ticker: String): ResponseEntity<ByteArray> {
        val resource = pngIconsStorageService.getIconResource(ticker)
        return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_PNG)
            .body(resource.contentAsByteArray)
    }

    @PostMapping("/save-icon")
    fun handleIconUpload(
        @RequestParam("file") file: MultipartFile,
        redirectAttributes: RedirectAttributes
    ): String {
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

        redirectAttributes.addFlashAttribute(
            "message",
            "You successfully uploaded " + file.originalFilename + "!"
        )
        return "redirect:/"
    }
}