package com.example.finalproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MotherboardListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var name : TextView = view.findViewById(R.id.motherboardNameDetailed)
    var image : TextView = view.findViewById(R.id.motherboardImageDetailed)
    var price : TextView = view.findViewById(R.id.motherboardPriceDetailed)
    var manufacturer : TextView = view.findViewById(R.id.motherboardManufacturerDetailed)
    var formfactor : TextView = view.findViewById(R.id.motherboardformFactorDetailed)
    var ramchannels : TextView = view.findViewById(R.id.motherboardRamChannelsDetailed)
    var ramtype : TextView = view.findViewById(R.id.motherboardRamTypeDetailed)
    var sockettype : TextView = view.findViewById(R.id.motherboardSocketTypeDetailed)
}
