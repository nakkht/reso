package com.neqsoft.reso.cpu

data class CpuInfo(
        val name: String?,
        val architecture: String?,
        val coreCountPhysical: Int?,
        val coreCountLogical: Int?,
        val l1CacheSizeInBytes: Int?,
        val l2CacheSizeInBytes: Int?,
        val endianess: Endianess?,
        val frequency: Long?,
        val processes: List<Process>?
)