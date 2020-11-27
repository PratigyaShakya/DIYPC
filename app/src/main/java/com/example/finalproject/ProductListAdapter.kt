package com.example.finalproject

import android.content.Context
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
            .inflate(R.layout.product_list_viewholder, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int, model: ProductList) {
        // binding logo using Glide generated API
        val storageReference= Firebase.storage.getReferenceFromUrl(model.logo)
        GlideApp.with(holder.logo).load(storageReference).into(holder.logo)


       // binding everything together

        holder.name.text = model.name
    }
}