package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoTotalVolumeResponse(
    @SerialName("aed")
    val aed: Int,
    @SerialName("ars")
    val ars: Long,
    @SerialName("aud")
    val aud: Int,
    @SerialName("bch")
    val bch: Int,
    @SerialName("bdt")
    val bdt: Long,
    @SerialName("bhd")
    val bhd: Int,
    @SerialName("bits")
    val bits: Long,
    @SerialName("bmd")
    val bmd: Int,
    @SerialName("bnb")
    val bnb: Int,
    @SerialName("brl")
    val brl: Int,
    @SerialName("btc")
    val btc: Int,
    @SerialName("cad")
    val cad: Int,
    @SerialName("chf")
    val chf: Int,
    @SerialName("clp")
    val clp: Long,
    @SerialName("cny")
    val cny: Long,
    @SerialName("czk")
    val czk: Long,
    @SerialName("dkk")
    val dkk: Long,
    @SerialName("dot")
    val dot: Int,
    @SerialName("eos")
    val eos: Int,
    @SerialName("eth")
    val eth: Int,
    @SerialName("eur")
    val eur: Int,
    @SerialName("gbp")
    val gbp: Int,
    @SerialName("hkd")
    val hkd: Long,
    @SerialName("huf")
    val huf: Long,
    @SerialName("idr")
    val idr: Long,
    @SerialName("ils")
    val ils: Int,
    @SerialName("inr")
    val inr: Long,
    @SerialName("jpy")
    val jpy: Long,
    @SerialName("krw")
    val krw: Long,
    @SerialName("kwd")
    val kwd: Int,
    @SerialName("link")
    val link: Int,
    @SerialName("lkr")
    val lkr: Long,
    @SerialName("ltc")
    val ltc: Int,
    @SerialName("mmk")
    val mmk: Long,
    @SerialName("mxn")
    val mxn: Long,
    @SerialName("myr")
    val myr: Int,
    @SerialName("ngn")
    val ngn: Long,
    @SerialName("nok")
    val nok: Long,
    @SerialName("nzd")
    val nzd: Int,
    @SerialName("php")
    val php: Long,
    @SerialName("pkr")
    val pkr: Long,
    @SerialName("pln")
    val pln: Int,
    @SerialName("rub")
    val rub: Long,
    @SerialName("sar")
    val sar: Int,
    @SerialName("sats")
    val sats: Long,
    @SerialName("sek")
    val sek: Long,
    @SerialName("sgd")
    val sgd: Int,
    @SerialName("thb")
    val thb: Long,
    @SerialName("try")
    val tryX: Long,
    @SerialName("twd")
    val twd: Long,
    @SerialName("uah")
    val uah: Long,
    @SerialName("usd")
    val usd: Int,
    @SerialName("vef")
    val vef: Int,
    @SerialName("vnd")
    val vnd: Long,
    @SerialName("xag")
    val xag: Int,
    @SerialName("xau")
    val xau: Int,
    @SerialName("xdr")
    val xdr: Int,
    @SerialName("xlm")
    val xlm: Long,
    @SerialName("xrp")
    val xrp: Int,
    @SerialName("yfi")
    val yfi: Int,
    @SerialName("zar")
    val zar: Long
)