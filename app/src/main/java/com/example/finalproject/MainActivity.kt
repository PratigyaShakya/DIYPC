package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
=======
import android.os.Handler
>>>>>>> SplashScreen-Shawn

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