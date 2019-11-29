package com.neqsoft.reso.cpu;

import androidx.annotation.Nullable;

public class CpuInfo {

  @Nullable
  private String name;

  @Nullable
  private String architecture;

  private int coreCountPhysical;
  private int coreCountLogical;

  private int l1CacheSizeInBytes;
  private int l2CacheSizeInBytes;

  private Endianess endianess;


}
