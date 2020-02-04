package com.neqsoft.reso.cpu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R
import com.neqsoft.reso.utils.view.InfoViewHolder

class CpuInfoRecyclerAdapter : RecyclerView.Adapter<InfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_item_view, parent, false)
        return InfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 0
    }

    fun submit(cpuInfo: CpuInfo?) {
        cpuInfo.toString()
    }
}