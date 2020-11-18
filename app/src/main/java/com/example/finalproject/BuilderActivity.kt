package com.example.finalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

class BuilderActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    private val db = FirebaseFirestore.getInstance()

   // private  var adapter : FirestoreRecyclerAdapter<Build, BuildViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

    }

}
