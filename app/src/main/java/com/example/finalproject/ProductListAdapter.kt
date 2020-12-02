package com.example.finalproject

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.glide.GlideApp
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class ProductListAdapter(options: FirestoreRecyclerOptions<ProductList>, private val context: Context) :
    FirestoreRecyclerAdapter<ProductList, ProductListViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cpu_list_viewholder, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int, model: ProductList) {
        // Fires when the user clicks the row in recycler view
       /* holder.itemView.setOnClickListener {
            val intent = Intent(context, CPUActivity::class.java).apply {
                putExtra("Anything could go here", model)
            }
            context.startActivity(intent)
        }*/

        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(model.cpuLogo)
        GlideApp.with(holder.cpuLogo).load(storageReference).into(holder.cpuLogo)


       // binding everything together
        holder.name.text = model.name
        holder.price.text = model.price
    }
}