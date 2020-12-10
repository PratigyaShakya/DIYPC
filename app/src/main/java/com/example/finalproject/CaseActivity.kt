package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.Controller.CaseAdapter
import com.example.finalproject.Controller.MotherboardAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_builder.*

class CaseActivity: AppCompatActivity() {

    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()
    private lateinit var caseAdapter: CaseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

        val query: Query = FirebaseFirestore.getInstance()
            .collection("Case")
            .orderBy("name")
            .limit(50)

        // query.addSnapshotListener
        val options: FirestoreRecyclerOptions<CaseList> = FirestoreRecyclerOptions.Builder<CaseList>()
            .setQuery(query, CaseList::class.java)
            .build()

        caseAdapter = CaseAdapter(options, this)
        recyclerView.adapter = caseAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    override fun onStart(){
        super.onStart()
        caseAdapter.startListening()
    }
    override fun onStop(){
        super.onStop()
        caseAdapter.stopListening()
    }
}
