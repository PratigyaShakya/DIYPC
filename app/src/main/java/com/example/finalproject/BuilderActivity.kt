package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.lang.NullPointerException
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_builder.*
import kotlinx.android.synthetic.main.viewholder.*

class BuilderActivity: AppCompatActivity() {

    private val TAG = javaClass.name

    private val db = FirebaseFirestore.getInstance()
    private var adapter : FirestoreRecyclerAdapter<ProductList, ProductListViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_builder)



        val query: Query = FirebaseFirestore.getInstance()
            .collection("Parts")
            .orderBy("name")
            .limit(50)

        val options: FirestoreRecyclerOptions<ProductList> = FirestoreRecyclerOptions.Builder<ProductList>()
            .setQuery(query, ProductList::class.java)
            .build()

        adapter = object : FirestoreRecyclerAdapter<ProductList, ProductListViewHolder>(options){
            override fun onBindViewHolder(
                holder: ProductListViewHolder,
                position: Int,
                model: ProductList
            ) {
                holder.name.text = model.name
            }

            override fun onCreateViewHolder(group: ViewGroup, i: Int): ProductListViewHolder {
                val view = LayoutInflater.from(group.context)
                    .inflate(R.layout.viewholder, group, false)
                return ProductListViewHolder(view)
            }
        }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        /*floating_button1.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }*/
    }

    override fun onStart(){
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop(){
        super.onStop()
        adapter?.stopListening()

    }
}
