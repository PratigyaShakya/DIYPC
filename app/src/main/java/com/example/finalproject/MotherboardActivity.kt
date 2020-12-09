package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Adapter.MotherboardAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_builder.*
import kotlinx.android.synthetic.main.activity_list_part_builder.*

class MotherboardActivity: AppCompatActivity() {

    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()
    private lateinit var motherboardAdapter: MotherboardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

        val query: Query = FirebaseFirestore.getInstance()
            .collection("Motherboard")
            .orderBy("name")
            .limit(50)

        // query.addSnapshotListener
        val options: FirestoreRecyclerOptions<MotherboardList> = FirestoreRecyclerOptions.Builder<MotherboardList>()
            .setQuery(query, MotherboardList::class.java)
            .build()

        motherboardAdapter = MotherboardAdapter(options, this)
        recyclerView.adapter = motherboardAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
    override fun onStart(){
        super.onStart()
        motherboardAdapter.startListening()
    }
    override fun onStop(){
        super.onStop()
        motherboardAdapter.stopListening()
    }
}
