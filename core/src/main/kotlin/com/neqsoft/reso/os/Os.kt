package com.neqsoft.reso.os

import java.text.SimpleDateFormat
import java.util.*

data class Os(
        var sdkVersion: Int = 0,
        var version: String?,
        var kernelVersion: String?,
        var kernelName: String?,
        var architecture: String?,
        var bootloaderVersion: String?,
        var isSafeMode: Boolean = false,
        var bootTimeInMillis: Long = 0,
        var uptime: Long = 0
) {
    val uptimeDays: Int get() = (uptime / DAY).toInt()

    val uptimeHours: Int get() = (uptime / HOUR).toInt() % 24

    val uptimeMinutes: Int get() = (uptime / MINUTE).toInt() % 60

    val uptimeSeconds: Int get() = (uptime / 1000).toInt() % 60

    val osVersion: OsVersion get() = OsVersion.get(sdkVersion)

    val formattedBootTime: String
        get() = SimpleDateFormat(DATE_TIME_FORMAT, Locale.getDefault()).format(Date(bootTimeInMillis))

    companion object {
        const val PROPERTY_COUNT = 10
        private const val DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm"
        private const val DAY = 24 * 60 * 60 * 1000
        private const val HOUR = 60 * 60 * 1000
        private const val MINUTE = 60 * 60 * 1000
    }
}