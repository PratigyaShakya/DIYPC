package com.example.finalproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BufferViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name: TextView = view.findViewById(R.id.buildName)
}