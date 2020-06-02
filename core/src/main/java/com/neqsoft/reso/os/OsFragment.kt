package com.neqsoft.reso.os

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.neqsoft.reso.R

class OsFragment : Fragment() {

    private var osViewModel: OsViewModel? = null
    private var osRecyclerAdapter: OsRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        osViewModel = ViewModelProvider(this).get(OsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_os, container, false)
        bind(view)
        val osData = osViewModel?.getOsData()
        display(osData)
        return view
    }

    private fun bind(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.osRv)
        recyclerView.layoutManager = LinearLayoutManager(context)
        osRecyclerAdapter = OsRecyclerAdapter()
        recyclerView.adapter = osRecyclerAdapter
    }

    private fun display(os: Os?) {
        osRecyclerAdapter?.submit(os)
    }
}