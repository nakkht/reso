package com.neqsoft.reso.device

import android.content.Context
import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R

class DeviceFragment : Fragment() {

    private var display: Display? = null
    private var deviceViewModel: DeviceViewModel? = null
    private var deviceRecyclerAdapter: DeviceRecyclerAdapter? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        display = activity?.windowManager?.defaultDisplay
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        deviceViewModel = ViewModelProvider(this).get(DeviceViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_device, container, false)
        bind(view)
        val device = deviceViewModel?.getDeviceData(display)
        display(device)
        return view
    }

    private fun bind(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.deviceRv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        deviceRecyclerAdapter = DeviceRecyclerAdapter()
        recyclerView.adapter = deviceRecyclerAdapter
    }

    private fun display(device: Device?) {
        deviceRecyclerAdapter?.submit(device)
    }
}