package com.neqsoft.reso.device;

import androidx.annotation.Nullable;

import static java.lang.String.format;
import static java.util.Locale.getDefault;

public class Device {

  private static String[] aspectRatios = {"9:16", "16:9", "5:9", "3:5", "40:71", "5:8", "1:1", "4:3", "2:3", "5:3", "8:5", "19.5:9", "18:9"};
  private static float[] aspectRatioValues = {0.5625f, 1.7777f, 0.5555f, 0.6f, 0.5633f, 0.625f, 1f, 1.3333f, 0.6666f, 1.6666f, 1.6f, 2.1666f, 2f};

  @Nullable
  private String name;
  private int screenWidth, screenHeight;
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

  public int getDensity() {
    return density;
  }

  public void setDensity(int density) {
    this.density = density;
  }

  public String getAspectRatio() {
    return "";
  }

  public void setAspectRatio(float aspectRatio) {
    this.aspectRatio = aspectRatio;
  }
}
