package com.neqsoft.reso.device

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R
import com.neqsoft.reso.utils.view.HeaderViewHolder
import com.neqsoft.reso.utils.view.InfoViewHolder

class DeviceRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var device: Device? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == 0) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.header_item_view, parent, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.info_item_view, parent, false)
            InfoViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position) {
            1 -> setupDeviceName(holder as InfoViewHolder)
            2 -> setupResolution(holder as InfoViewHolder)
            3 -> setupDensity(holder as InfoViewHolder)
            4 -> setupAspectRatio(holder as InfoViewHolder)
            else -> setupHeader(holder as HeaderViewHolder)
        }
    }

    private fun setupAspectRatio(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.aspect_ratio)
        holder.infoTv.text = device?.formattedAspectRatio ?: ""
    }

    private fun setupHeader(holder: HeaderViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.hardware_information)
    }

    private fun setupDensity(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.density)
        holder.infoTv.text = device?.formattedDensity ?: ""
    }

    private fun setupResolution(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.screen_resolution)
        holder.infoTv.text = device?.formattedScreenResolution ?: ""
    }

    private fun setupDeviceName(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.device_name)
        holder.infoTv.text = device?.name ?: ""
    }

    override fun getItemCount(): Int {
        return Device.PROPERTY_COUNT + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_ITEM_TYPE else INFO_ITEM_TYPE
    }

    fun submit(device: Device?) {
        this.device = device
        notifyDataSetChanged()
    }

    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val INFO_ITEM_TYPE = 1
    }
}