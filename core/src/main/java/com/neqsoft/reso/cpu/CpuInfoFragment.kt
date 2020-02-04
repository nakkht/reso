package com.neqsoft.reso.cpu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R

class CpuInfoFragment : Fragment() {
    private val cpuInfoRecyclerAdapter: CpuInfoRecyclerAdapter? = null
    private var cpuInfoViewModel: CpuInfoViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cpuInfoViewModel = ViewModelProvider(this).get(CpuInfoViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_cpu_info, container, false)
        bind(view)
        return view
    }

    private fun bind(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.cpuInfoRv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = cpuInfoRecyclerAdapter
    }

    private fun display(cpuInfo: CpuInfo?) {
        cpuInfoRecyclerAdapter?.submit(cpuInfo)
    }
}