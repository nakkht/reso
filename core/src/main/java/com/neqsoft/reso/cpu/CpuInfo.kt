package com.neqsoft.reso.cpu

data class CpuInfo(
        val name: String? = null,
        val architecture: String? = null,
        val coreCountPhysical: Int = -1,
        val coreCountLogical: Int = -1,
        val l1CacheSizeInBytes: Int = -1,
        val l2CacheSizeInBytes: Int = -1,
        val endianess: Endianess? = null,
        val frequency: Long = -1,
        val processes: List<Process>? = null
)