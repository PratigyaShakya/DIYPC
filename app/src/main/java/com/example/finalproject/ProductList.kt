package com.example.finalproject

import java.io.Serializable

data class  ProductList(
    val name: String = "",
    val image: String="",
    val price: Double = 0.0,
    val boostClock: String = "",
    val coreClock: String = "",
    val coreCount: String = "",
    val tdp:String = ""
    ): Serializable