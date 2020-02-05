package com.neqsoft.reso.utils.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R

class InfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    val infoTv: TextView = itemView.findViewById(R.id.infoTv)
}