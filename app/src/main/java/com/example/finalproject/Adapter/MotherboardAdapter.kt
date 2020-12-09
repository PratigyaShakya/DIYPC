package com.example.finalproject.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.*
import com.example.finalproject.glide.GlideApp
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MotherboardAdapter (options: FirestoreRecyclerOptions<MotherboardList>, private val context: Context) :
    FirestoreRecyclerAdapter<MotherboardList, ProductListViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cpu_list_viewholder, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int, model: MotherboardList) {
        // Fires when the user clicks the row in recycler view
        /*
        holder.itemView.setOnClickListener {
            val intent = Intent(context, CPUDetailActivity::class.java).apply {
                putExtra("CPU Detail", model)
            }
            context.startActivity(intent)
        }
         */

        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(model.image)
        GlideApp.with(holder.image).load(storageReference).into(holder.image)


        // binding everything together
        holder.name.text = model.name
        holder.price.text = "$${model.price}"
    }
}