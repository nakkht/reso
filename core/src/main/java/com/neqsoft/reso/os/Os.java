package com.neqsoft.reso.os;

public class Os {

  private int sdkVersion;
  private String version;

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
}
