package com.neqsoft.reso.os;

public class Os {

  private int sdkVersion;
  private String version;
  private String kernelVersion;
  private String kernelName;
  private String architecture;

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
}
