package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import android.os.Handler

class MainActivity : AppCompatActivity() {



    class MainActivity : AppCompatActivity() {

        private val TAG = javaClass.name

        private val db = FirebaseFirestore.getInstance()


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
        }
    }
}