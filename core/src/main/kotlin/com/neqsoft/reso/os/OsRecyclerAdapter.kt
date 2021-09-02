package com.neqsoft.reso.os

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R
import com.neqsoft.reso.utils.view.HeaderViewHolder
import com.neqsoft.reso.utils.view.InfoViewHolder
import java.util.*

class OsRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var os: Os? = null

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
            1 -> setupOsVersion(holder as InfoViewHolder)
            2 -> setupSdkVersion(holder as InfoViewHolder)
            3 -> setupCodeName(holder as InfoViewHolder)
            4 -> setupKernelVersion(holder as InfoViewHolder)
            5 -> setupKernel(holder as InfoViewHolder)
            6 -> setupArchitecture(holder as InfoViewHolder)
            7 -> setupBootloaderVersion(holder as InfoViewHolder)
            8 -> setupSafeModeInfo(holder as InfoViewHolder)
            9 -> setupBootDateTime(holder as InfoViewHolder)
            10 -> setupUptime(holder as InfoViewHolder)
            else -> setupHeader(holder as HeaderViewHolder)
        }
    }

    private fun setupUptime(holder: InfoViewHolder) {
        val context = holder.itemView.context
        holder.titleTv.text = context.getString(R.string.uptime)
        val days = os?.uptimeDays ?: 0
        val hours = os?.uptimeHours ?: 0
        val minutes = os?.uptimeMinutes ?: 0
        val seconds = os?.uptimeSeconds ?: 0
        val dayString = context.resources.getQuantityString(R.plurals.day, days)
        val hourString = context.resources.getQuantityString(R.plurals.hour, hours)
        val minuteString = context.resources.getQuantityString(R.plurals.minute, minutes)
        val secondString = context.resources.getQuantityString(R.plurals.seconds, seconds)
        val text = context.getString(R.string.placeholder_time, days, dayString, hours, hourString,
                minutes, minuteString, seconds, secondString)
        holder.infoTv.text = text
    }

    private fun setupBootDateTime(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.boot_date_time)
        holder.infoTv.text = os?.formattedBootTime
    }

    private fun setupSafeModeInfo(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.safe_mode)
        holder.infoTv.text = os?.isSafeMode.toString()
    }

    private fun setupBootloaderVersion(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.bootloader_version)
        holder.infoTv.text = os?.bootloaderVersion
    }

    private fun setupArchitecture(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.architecture)
        holder.titleTv.text = os?.architecture
    }

    private fun setupKernel(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.kernel_version)
        holder.titleTv.text = os?.kernelName
    }

    private fun setupKernelVersion(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.kernel_version)
        holder.infoTv.text = os?.kernelVersion
    }

    private fun setupCodeName(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.code_name)
        holder.infoTv.text = os?.osVersion?.value
    }

    private fun setupSdkVersion(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.sdk_version)
        holder.infoTv.text = String.format(Locale.getDefault(), "%d", os?.sdkVersion ?: 0)
    }

    private fun setupOsVersion(holder: InfoViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.os_version)
        holder.infoTv.text = os?.osVersion?.value ?: ""
    }

    private fun setupHeader(holder: HeaderViewHolder) {
        holder.titleTv.text = holder.itemView.context.getString(R.string.os_information)
    }

    override fun getItemCount(): Int {
        return Os.PROPERTY_COUNT + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) HEADER_ITEM_TYPE else INFO_ITEM_TYPE
    }

    fun submit(os: Os?) {
        this.os = os
        notifyDataSetChanged()
    }

    companion object {
        const val HEADER_ITEM_TYPE = 0
        const val INFO_ITEM_TYPE = 1
    }
}