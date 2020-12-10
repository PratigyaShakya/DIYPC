package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.glide.GlideApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_detailed_view_cpu.*
import kotlinx.android.synthetic.main.activity_detailed_view_motherboard.*

class MotherboardDetailedActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_motherboard)

        // Binding other fields
        val motherboardDetail = intent.getSerializableExtra("Motherboard Detail") as? MotherboardList ?: return
        motherboardNameDetailed.text = motherboardDetail.name
        motherboardPriceDetailed.text = "$${motherboardDetail.price.toString()}"
        motherboardformFactorDetailed.text = motherboardDetail.formfactor
        motherboardManufacturerDetailed.text = motherboardDetail.manufacturer
        motherboardRamChannelsDetailed.text = motherboardDetail.ramchannels.toString()
        motherboardRamTypeDetailed.text = motherboardDetail.ramtype
        motherboardSocketTypeDetailed.text = motherboardDetail.sockettype


        // binding logo using Glide generated API
        val storageReference = Firebase.storage.getReferenceFromUrl(motherboardDetail.image)
        GlideApp.with(this).load(storageReference).into(motherboardImageDetailed)

    }
}