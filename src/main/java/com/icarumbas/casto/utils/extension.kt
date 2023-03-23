package com.icarumbas.casto.utils

import org.springframework.web.multipart.MultipartFile

/**
 * Returns the extension of this file (not including the dot), or an empty string if it doesn't have one.
 */
val MultipartFile.extension: String
    get() = name.substringAfterLast('.', "")

/**
 * Returns file's name without an extension.
 */
public val MultipartFile.nameWithoutExtension: String
    get() = originalFilename.substringBeforeLast(".")