package com.neqsoft.reso.os

import android.app.Application
import android.os.Build
import android.os.SystemClock
import androidx.lifecycle.AndroidViewModel

open class OsViewModel(application: Application) : AndroidViewModel(application) {

    private val osData: Os? = null

    fun getOsData(): Os {

        return Os(
                sdkVersion = Build.VERSION.SDK_INT,
                version = Build.VERSION.RELEASE,
                kernelVersion = kernelVersion,
                kernelName = kernelName,
                architecture = architecture,
                bootloaderVersion = Build.BOOTLOADER,
                isSafeMode = getApplication<Application>().packageManager.isSafeMode,
                bootTimeInMillis = calculateBootTime,
                uptime = SystemClock.elapsedRealtime())
    }

    private val calculateBootTime: Long get() = System.currentTimeMillis() - SystemClock.elapsedRealtime()

    private val kernelVersion: String? get() = System.getProperty("os.version")

    private val kernelName: String? get() = System.getProperty("os.name")

    private val architecture: String? get() = System.getProperty("os.arch")
}