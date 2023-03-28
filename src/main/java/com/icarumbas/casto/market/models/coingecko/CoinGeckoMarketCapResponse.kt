package com.icarumbas.casto.market.models.coingecko


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoinGeckoMarketCapResponse(
    @SerialName("aed")
    val aed: Long,
    @SerialName("ars")
    val ars: Long,
    @SerialName("aud")
    val aud: Long,
    @SerialName("bch")
    val bch: Int,
    @SerialName("bdt")
    val bdt: Long,
    @SerialName("bhd")
    val bhd: Long,
    @SerialName("bits")
    val bits: Long,
    @SerialName("bmd")
    val bmd: Long,
    @SerialName("bnb")
    val bnb: Int,
    @SerialName("brl")
    val brl: Long,
    @SerialName("btc")
    val btc: Int,
    @SerialName("cad")
    val cad: Long,
    @SerialName("chf")
    val chf: Long,
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
    val eos: Long,
    @SerialName("eth")
    val eth: Int,
    @SerialName("eur")
    val eur: Long,
    @SerialName("gbp")
    val gbp: Long,
    @SerialName("hkd")
    val hkd: Long,
    @SerialName("huf")
    val huf: Long,
    @SerialName("idr")
    val idr: Long,
    @SerialName("ils")
    val ils: Long,
    @SerialName("inr")
    val inr: Long,
    @SerialName("jpy")
    val jpy: Long,
    @SerialName("krw")
    val krw: Long,
    @SerialName("kwd")
    val kwd: Long,
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
    val myr: Long,
    @SerialName("ngn")
    val ngn: Long,
    @SerialName("nok")
    val nok: Long,
    @SerialName("nzd")
    val nzd: Long,
    @SerialName("php")
    val php: Long,
    @SerialName("pkr")
    val pkr: Long,
    @SerialName("pln")
    val pln: Long,
    @SerialName("rub")
    val rub: Long,
    @SerialName("sar")
    val sar: Long,
    @SerialName("sats")
    val sats: Long,
    @SerialName("sek")
    val sek: Long,
    @SerialName("sgd")
    val sgd: Long,
    @SerialName("thb")
    val thb: Long,
    @SerialName("try")
    val tryX: Long,
    @SerialName("twd")
    val twd: Long,
    @SerialName("uah")
    val uah: Long,
    @SerialName("usd")
    val usd: Long,
    @SerialName("vef")
    val vef: Int,
    @SerialName("vnd")
    val vnd: Long,
    @SerialName("xag")
    val xag: Int,
    @SerialName("xau")
    val xau: Int,
    @SerialName("xdr")
    val xdr: Long,
    @SerialName("xlm")
    val xlm: Long,
    @SerialName("xrp")
    val xrp: Long,
    @SerialName("yfi")
    val yfi: Int,
    @SerialName("zar")
    val zar: Long
)