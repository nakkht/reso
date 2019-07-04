package com.neqsoft.reso.device;

import androidx.annotation.Nullable;

import static java.lang.String.format;
import static java.util.Locale.getDefault;

public class Device {

  @Nullable
  private String name;
  private int screenWidth, screenHeight;
  private int screenSize;
  private int density;
  private float aspectRatio;

  @Nullable
  public String getName() {
    return name;
  }

  public void setName(@Nullable String name) {
    this.name = name;
  }

  public void setScreenWidth(int screenWidth) {
    this.screenWidth = screenWidth;
  }

  public String getScreenResolution() {
    return format(getDefault(), "%dx%d", screenWidth, screenHeight);
  }

  public void setScreenHeight(int screenHeight) {
    this.screenHeight = screenHeight;
  }

  public int getScreenSize() {
    return screenSize;
  }

  public void setScreenSize(int screenSize) {
    this.screenSize = screenSize;
  }

  public int getDensity() {
    return density;
  }

  public void setDensity(int density) {
    this.density = density;
  }

  public float getAspectRatio() {
    return aspectRatio;
  }

  public void setAspectRatio(float aspectRatio) {
    this.aspectRatio = aspectRatio;
  }
}
