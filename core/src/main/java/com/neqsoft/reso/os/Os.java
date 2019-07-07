package com.neqsoft.reso.os;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Locale.getDefault;

public class Os {

  private static final String TIME_FORMAT = "HH:mm:ss.SSS";

  private int sdkVersion;
  private String version;
  private String kernelVersion;
  private String kernelName;
  private String architecture;
  private String bootloaderVersion;
  private boolean isSafeMode;
  private long bootTimeInMillis;

  public String getBootTimeFormatted() {
    DateFormat formatter = new SimpleDateFormat(TIME_FORMAT, getDefault());
    return formatter.format(new Date(bootTimeInMillis));
  }

  public long getBootTime() {
    return bootTimeInMillis;
  }

  public void setBootTime(long bootTimeInMillis) {
    this.bootTimeInMillis = bootTimeInMillis;
  }

  public boolean isSafeMode() {
    return isSafeMode;
  }

  public void setSafeMode(boolean safeMode) {
    isSafeMode = safeMode;
  }

  public void setSdkVersion(int sdkVersion) {
    this.sdkVersion = sdkVersion;
  }

  public int getSdkVersion() {
    return sdkVersion;
  }

  public void setVersion(final String version) {
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public OsVersion getOsVersion() {
    return OsVersion.get(sdkVersion);
  }

  public String getKernelVersion() {
    return kernelVersion;
  }

  public void setKernelVersion(String kernelVersion) {
    this.kernelVersion = kernelVersion;
  }

  public String getKernelName() {
    return kernelName;
  }

  public void setKernelName(String kernelName) {
    this.kernelName = kernelName;
  }

  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public String getBootloaderVersion() {
    return bootloaderVersion;
  }

  public void setBootloaderVersion(String bootloaderVersion) {
    this.bootloaderVersion = bootloaderVersion;
  }
}
