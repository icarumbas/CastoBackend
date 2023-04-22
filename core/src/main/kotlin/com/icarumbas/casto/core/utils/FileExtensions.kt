package com.icarumbas.casto.core.utils

import org.springframework.web.multipart.MultipartFile

/**
 * Returns the extension of this file (not including the dot), or an empty string if it doesn't have one.
 */
val MultipartFile.extension: String?
    get() = originalFilename?.substringAfterLast('.', "")

/**
 * Returns file's name without an extension.
 */
val MultipartFile.nameWithoutExtension: String?
    get() = originalFilename?.substringBeforeLast(".")

val String.beforeFirstDot: String
    get() = substringBefore(".")