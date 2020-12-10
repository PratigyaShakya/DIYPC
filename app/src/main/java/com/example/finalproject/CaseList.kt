package com.example.finalproject

import java.io.Serializable

data class CaseList (
    val name : String = "",
    val image : String = "",
    val price : Double = 0.0,
    val color : String = "",
    val formfactor : String = "",
    val manufacturer : String = "",
    val fans : Double = 0.0,
    val rgb : Boolean,
    val temperedglass : Boolean
): Serializable
