package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD

class MainActivity : AppCompatActivity() {
=======
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.name

    private val db = FirebaseFirestore.getInstance()

>>>>>>> pratigya-dev
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}