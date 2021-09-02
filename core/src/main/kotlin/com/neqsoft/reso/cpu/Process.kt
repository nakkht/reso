package com.neqsoft.reso.cpu

data class Process(
        val id: Int = -1,
        val timeStamp: Long = -1,
        val priority: Int = -1,
        val commandPath: String? = null
)
