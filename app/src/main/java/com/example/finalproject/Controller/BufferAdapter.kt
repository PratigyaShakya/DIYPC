package com.example.finalproject.Controller

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.finalproject.*
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions


class BufferAdapter(options: FirestoreRecyclerOptions<BufferModelActivity>, private val context: Context) :
    FirestoreRecyclerAdapter<BufferModelActivity, BufferViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BufferViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_buffer_viewholder, parent, false)
        return BufferViewHolder(view)
    }

    override fun onBindViewHolder(holder: BufferViewHolder, position: Int, model: BufferModelActivity) {
        // Fires when the user clicks the row in recycler view
      /* holder.itemView.setOnClickListener {
            val intent = Intent(context, BufferActivity::class.java).apply {
                putExtra("Build Show Page", model)
            }
            context.startActivity(intent)
        }*/
        holder.name.text = model.name

    }

}