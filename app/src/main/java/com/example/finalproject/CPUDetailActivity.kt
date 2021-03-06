package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.glide.GlideApp
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_detailed_view_cpu.*


class CPUDetailActivity : AppCompatActivity() {

    var term = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view_cpu)

        val cpuDetail = intent.getSerializableExtra("CPU Detail") as? ProductList ?: return
        cpuNameDetailed.text = cpuDetail.name
        cpuPriceDetailed.text = "$${cpuDetail.price}"
        cpuBoostClockDetailed.text = "${cpuDetail.boostClock}GHz"
        cpuCoreClockDetailed.text = "${cpuDetail.coreClock}GHz"
        cpuCoreCountDetailed.text = cpuDetail.coreCount
        cpuTDPDetailed.text = cpuDetail.tdp

        //Get name for additional term to open URL.
        term = cpuDetail.name


        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(cpuDetail.image)
        GlideApp.with(this).load(storageReference).into(ImageDetailed)



        //detail: String = cpuNameDetailed.toString()


    }

    //Open CPU search in Amazon
    fun toBrowser(item: MenuItem) {
        val baseURL = "https://www.amazon.com/s?k=$term"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(baseURL)
        startActivity(intent)
    }
}