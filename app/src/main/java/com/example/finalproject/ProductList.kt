package com.example.finalproject

import java.io.Serializable

data class  ProductList(
    val name: String = "",
    val cpuLogo: String="",
    val price: String = "",
    val boostClock: Double = 0.0,
    val coreClock: Double = 0.0,
    val coreCount: Double = 0.0,
    val tdp:Double = 0.0
    ): Serializable