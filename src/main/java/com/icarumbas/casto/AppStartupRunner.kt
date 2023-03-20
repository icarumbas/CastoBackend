package com.icarumbas.casto

import com.icarumbas.casto.icons.SvgIconsParser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppStartupRunner @Autowired constructor(
    private val svgIconsParser: SvgIconsParser
): ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        svgIconsParser.run()
    }
}