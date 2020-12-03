package com.example.finalproject

import java.io.Serializable

data class  ProductList(
    val name: String = "",
    val cpuLogo: String="",
    val price: String = "",
    val boostClock: String = "",
    val coreClock: String = "",
    val coreCount: String = "",
    val tdp:String = ""
    ): Serializable