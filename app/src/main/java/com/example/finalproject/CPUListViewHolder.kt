package com.example.finalproject

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CPUListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var imageDetailed: TextView = view.findViewById(R.id.ImageDetailed)
    var name: TextView = view.findViewById(R.id.cpuNameDetailed)
    var price: TextView = view.findViewById(R.id.cpuPriceDetailed)
    var boostClock: TextView = view.findViewById(R.id.cpuBoostClockDetailed)
    var coreClock: TextView = view.findViewById(R.id.cpuCoreClockDetailed)
    var corecount: TextView=view.findViewById(R.id.cpuCoreCountDetailed)
    var tdp: TextView = view.findViewById(R.id.cpuTDPDetailed)
}