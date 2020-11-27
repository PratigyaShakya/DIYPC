package com.example.finalproject

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class ProductListAdapter(options: FirestoreRecyclerOptions<ProductList>, private var resources: Resources) :
    FirestoreRecyclerAdapter<ProductList, ProductListViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_viewholder, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int, model: ProductList) {
        val resID = resources.getIdentifier(model.logo, "drawable", "com.example.finalproject")
        holder.logo.setImageResource(resID)
        holder.name.text = model.name
    }
}