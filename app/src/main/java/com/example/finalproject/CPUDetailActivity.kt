package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.glide.GlideApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_detailed_view_cpu.*

class CPUDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_cpu)

        val cpuDetail = intent.getSerializableExtra("CPU Detail") as? ProductList ?: return
        cpuNameDetailed.text = cpuDetail.name
        cpuPriceDetailed.text = "$${cpuDetail.price}"
        cpuBoostClockDetailed.text = cpuDetail.boostClock
        cpuCoreClockDetailed.text = cpuDetail.coreClock
        cpuCoreCountDetailed.text = cpuDetail.coreCount
        cpuTDPDetailed.text = cpuDetail.tdp

        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(cpuDetail.image)
        GlideApp.with(this).load(storageReference).into(ImageDetailed)



    }
}