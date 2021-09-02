package com.neqsoft.reso.info

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.neqsoft.reso.R
import com.neqsoft.reso.cpu.CpuInfoFragment
import com.neqsoft.reso.device.DeviceFragment
import com.neqsoft.reso.os.OsFragment

class InfoActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager
    private val deviceFragment: Fragment by lazy { DeviceFragment() }
    private val osFragment: Fragment by lazy { OsFragment() }
    private val cputFragment: Fragment by lazy { CpuInfoFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        setSupportActionBar(findViewById(R.id.toolbar))
        setupBottomNavigation()
        display(deviceFragment)
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.deviceItem -> {
                    display(deviceFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.osItem -> {
                    display(osFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.cpuItem -> {
                    display(cputFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun display(fragment: Fragment) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment).commit()
    }
}