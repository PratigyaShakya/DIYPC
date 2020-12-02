package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_builder.*

class BuilderActivity: AppCompatActivity() {

    private val TAG = javaClass.name
    private val db = FirebaseFirestore.getInstance()
    private lateinit var productListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)

        val query: Query = FirebaseFirestore.getInstance()
            .collection("CPU")
            .orderBy("name")
            .limit(50)

       // query.addSnapshotListener

        val options: FirestoreRecyclerOptions<ProductList> = FirestoreRecyclerOptions.Builder<ProductList>()
            .setQuery(query, ProductList::class.java)
            .build()

        productListAdapter = ProductListAdapter(options, this)
        recyclerView.adapter = productListAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
    override fun onStart(){
        super.onStart()
        productListAdapter.startListening()
    }
    override fun onStop(){
        super.onStop()
        productListAdapter.stopListening()
    }
}
