package com.neqsoft.reso.utils.view

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    val arrowIv: AppCompatImageView = itemView.findViewById(R.id.arrowIv)
}