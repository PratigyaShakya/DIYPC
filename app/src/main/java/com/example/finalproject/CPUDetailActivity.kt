package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.glide.GlideApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import kotlinx.android.synthetic.main.activity_buffer.*
import kotlinx.android.synthetic.main.activity_detailed_view_cpu.*
import kotlinx.android.synthetic.main.activity_detailed_view_motherboard.*


class CPUDetailActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    private var term = ""
    private var cost = 0.0
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

        //Get name for additional term to open URL.
        term = cpuDetail.name
        cost = cpuDetail.price

        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(cpuDetail.image)
        GlideApp.with(this).load(storageReference).into(ImageDetailed)

        //detail: String = cpuNameDetailed.toString()
        bottomNavigationBufferCPU.selectedItemId = R.id.addBuild
        bottomNavigationBufferCPU.setOnNavigationItemReselectedListener {
            when(it.itemId) {
                R.id.addBuild ->{
                    Toast.makeText(this, "Added to build", Toast.LENGTH_SHORT)
                }
            }
        }

    }

    //Open CPU search in Amazon
    fun toBrowser(item: MenuItem) {
        val baseURL = "https://www.amazon.com/s?k=$term"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(baseURL)
        startActivity(intent)
    }

    //Add CPU to User Collection
    fun toBuild(item: MenuItem) {
        db.collection("CustBuild").document("CPU").set({
            "name" to term
            "price" to cost
        });
    }
}