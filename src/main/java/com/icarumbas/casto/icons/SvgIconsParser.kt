package com.icarumbas.casto.icons

import com.icarumbas.casto.utils.SvgParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component
import java.io.IOException
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes
import kotlin.io.path.Path
import kotlin.io.path.nameWithoutExtension


@Component
class SvgIconsParser @Autowired constructor(
    private val iconsStorageService: IconsStorageService,
    private val svgParser: SvgParser,
) {
    fun run() {
        val svgDir = Path(ClassPathResource("icons/svg").path)

        Files.walkFileTree(svgDir, object : SimpleFileVisitor<Path>() {
            override fun visitFile(file: Path, attrs: BasicFileAttributes): FileVisitResult {
                val filename = file.nameWithoutExtension
                val destPath = iconsStorageService.getPath(filename.uppercase())
                val destFile = destPath.toFile()

                if (!destFile.exists()) {
                    destFile.createNewFile()
                    val data = svgParser.svgToPng(file.toFile())
                    Files.write(destPath, data)
                }
                return FileVisitResult.CONTINUE
            }

            override fun postVisitDirectory(dir: Path, exc: IOException): FileVisitResult {
                return FileVisitResult.TERMINATE
            }
        })
    }
}