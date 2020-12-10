package com.example.finalproject
import java.io.Serializable

data class MotherboardList(
    val image: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val manufacturer: String = "",
    val formfactor: String = "",
    val ramchannels: Double = 0.0,
    val ramtype: String = "",
    val sockettype: String = ""
): Serializable