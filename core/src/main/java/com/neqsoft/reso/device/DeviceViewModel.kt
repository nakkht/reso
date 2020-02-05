package com.neqsoft.reso.device

import android.os.Build
import android.os.Build.VERSION
import android.util.DisplayMetrics
import android.view.Display
import androidx.core.util.Pair
import androidx.lifecycle.ViewModel

class DeviceViewModel : ViewModel() {

    private val deviceName: String
        get() = Build.MANUFACTURER + " " + Build.MODEL + " " + VERSION.RELEASE

    fun getDeviceData(display: Display?): Device {
        val device = Device()
        device.name = deviceName
        val resolution = getScreenResolution(display)
        device.screenWidth = if (resolution.first != null) resolution.first!! else 0
        device.screenHeight = if (resolution.second != null) resolution.second!! else 0
        device.density = getDensity(display)
        device.aspectRatio = getAspectRatio(display)
        return device
    }

    private fun getAspectRatio(display: Display?): Float {
        val realMetrics = DisplayMetrics()
        display?.getRealMetrics(realMetrics)
        return realMetrics.widthPixels.toFloat() / realMetrics.heightPixels.toFloat()
    }

    private fun getDensity(display: Display?): Int {
        val realMetrics = DisplayMetrics()
        display?.getMetrics(realMetrics)
        return realMetrics.densityDpi
    }

    private fun getScreenResolution(display: Display?): Pair<Int?, Int?> {
        val realMetrics = DisplayMetrics()
        display?.getRealMetrics(realMetrics)
        return Pair(realMetrics.widthPixels, realMetrics.heightPixels)
    }
}