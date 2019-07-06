package com.neqsoft.reso.device;

import android.util.DisplayMetrics;
import android.view.Display;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static android.os.Build.MANUFACTURER;
import static android.os.Build.MODEL;
import static android.os.Build.VERSION.RELEASE;

public class DeviceViewModel extends ViewModel {

  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<Device> deviceData;

  public DeviceViewModel() {
    backgroundExecutor = Executors.newCachedThreadPool();
    deviceData = new MutableLiveData<>();
  }

  public LiveData<Device> getDeviceInfo(@NonNull final Display display) {
    backgroundExecutor.execute(() -> {
      Device device = getDeviceData(display);
      deviceData.postValue(device);
    });
    return deviceData;
  }

  protected String getDeviceName() {
    return MANUFACTURER + " " + MODEL + " " + RELEASE;
  }

  private Device getDeviceData(@NonNull final Display display) {
    Device device = new Device();
    device.setName(getDeviceName());
    Pair<Integer, Integer> resolution = getScreenResolution(display);
    device.setScreenWidth(resolution.first != null ? resolution.first : 0);
    device.setScreenHeight(resolution.second != null ? resolution.second : 0);
    device.setDensity(getDensity(display));
    device.setAspectRatio(getAspectRatio(display));
    return device;
  }

  private float getAspectRatio(final Display display) {
    DisplayMetrics realMetrics = new DisplayMetrics();
    display.getRealMetrics(realMetrics);
    return (float) realMetrics.widthPixels / (float) realMetrics.heightPixels;

  }

  private int getDensity(@NonNull final Display display) {
    DisplayMetrics realMetrics = new DisplayMetrics();
    display.getMetrics(realMetrics);
    return realMetrics.densityDpi;
  }

  private Pair<Integer, Integer> getScreenResolution(@NonNull final Display display) {
    DisplayMetrics realMetrics = new DisplayMetrics();
    display.getRealMetrics(realMetrics);
    return new Pair<>(realMetrics.widthPixels, realMetrics.heightPixels);
  }
}
