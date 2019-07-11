package com.neqsoft.reso.os;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Locale.getDefault;

public class Os {

  static final int PROPERTY_COUNT = 10;

  private static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm";
  private static final int DAY = 24 * 60 * 60 * 1000;
  private static final int HOUR = 60 * 60 * 1000;
  private static final int MINUTE = 60 * 60 * 1000;

  private int sdkVersion;
  private String version;
  private String kernelVersion;
  private String kernelName;
  private String architecture;
  private String bootloaderVersion;
  private boolean isSafeMode;
  private long bootTimeInMillis;
  private long uptime;

  public int getUptimeDays() {
    return (int) (uptime / DAY);
  }

  public int getUptimeHours() {
    return (int) (uptime / HOUR) % 24;
  }

  public int getUptimeMinutes() {
    return (int) (uptime / MINUTE) % 60;
  }

  public int getUptimeSeconds() {
    return (int) (uptime / 1000) % 60;
  }

  public void setUptime(long uptime) {
    this.uptime = uptime;
  }

  public String getFormattedBootTime() {
    DateFormat formatter = new SimpleDateFormat(DATE_TIME_FORMAT, getDefault());
    return formatter.format(new Date(bootTimeInMillis));
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
