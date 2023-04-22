package com.icarumbas.casto.crypto

import java.util.*
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun hmacSha256(msg: String, key: String): ByteArray {
    val alg = "HmacSHA256"
    val signingKey = SecretKeySpec(key.toByteArray(), alg)
    val mac = Mac.getInstance(alg)
    mac.init(signingKey)

    return mac.doFinal(msg.toByteArray())
}

fun bytesToHexUTF8(bytes: ByteArray): String {
    val formatter = Formatter()
    bytes.forEach { formatter.format("%02x", it) }
    return formatter.toString()
}