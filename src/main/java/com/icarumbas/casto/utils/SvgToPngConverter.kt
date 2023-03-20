package com.icarumbas.casto.utils

import org.apache.batik.transcoder.SVGAbstractTranscoder
import org.apache.batik.transcoder.TranscoderInput
import org.apache.batik.transcoder.TranscoderOutput
import org.apache.batik.transcoder.image.PNGTranscoder
import org.springframework.stereotype.Component
import java.io.ByteArrayOutputStream
import java.io.File


interface SvgParser {
    fun svgToPng(svg: File): ByteArray
}

@Component
class BaticSvgParser : SvgParser {
    override fun svgToPng(svg: File): ByteArray {
        val transcoderInput = TranscoderInput(svg.toURI().toURL().toString())
        val resultByteStream = ByteArrayOutputStream()
        val transcoderOutput = TranscoderOutput(resultByteStream)

        val pngTranscoder = PNGTranscoder()
        pngTranscoder.addTranscodingHint(SVGAbstractTranscoder.KEY_HEIGHT, 256f)
        pngTranscoder.addTranscodingHint(SVGAbstractTranscoder.KEY_WIDTH, 256f)
        pngTranscoder.transcode(transcoderInput, transcoderOutput)

        resultByteStream.flush()
        val bytes = resultByteStream.toByteArray()
        resultByteStream.close()
        return bytes
    }
}