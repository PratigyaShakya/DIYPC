package com.example.finalproject
import java.io.Serializable

data class MotherboardList(
    val image: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val manufacturer: String = "",
    val formFactor: String = "",
    val ramChannels: Double = 0.0,
    val ramType: String = "",
    val socketType: String = ""
): Serializable