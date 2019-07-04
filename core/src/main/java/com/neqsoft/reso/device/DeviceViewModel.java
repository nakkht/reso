package com.neqsoft.reso.device;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import static android.os.Build.MANUFACTURER;
import static android.os.Build.MODEL;
import static android.os.Build.VERSION.RELEASE;

public class DeviceViewModel extends ViewModel {

  private final Context applicationContext;
  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<Device> deviceData;

  public DeviceViewModel(final Context applicationContext) {
    this.applicationContext = applicationContext;
    backgroundExecutor = Executors.newCachedThreadPool();
    deviceData = new MutableLiveData<>();
  }

  public LiveData<Device> getDeviceInfo(@Nullable final Activity activity) {
    backgroundExecutor.execute(() -> {
      Device device = getDeviceData(activity);
      deviceData.postValue(device);
    });
    return deviceData;
  }

  protected String getDeviceName() {
    return MANUFACTURER + " " + MODEL + " " + RELEASE;
  }

  private Device getDeviceData(@Nullable final Activity activity) {
    Device device = new Device();
    device.setName(getDeviceName());
    if (activity != null) {
      Pair<Integer, Integer> resolution = getScreenResolution(activity);
      device.setScreenWidth(resolution.first != null ? resolution.first : 0);
      device.setScreenHeight(resolution.second != null ? resolution.second : 0);
    }
    return device;
  }

  private Pair<Integer, Integer> getScreenResolution(final Activity activity) {
    Display display = activity.getWindowManager().getDefaultDisplay();
    DisplayMetrics realMetrics = new DisplayMetrics();
    display.getRealMetrics(realMetrics);
    return new Pair<>(realMetrics.widthPixels, realMetrics.heightPixels);
  }

  public static class Factory extends ViewModelProvider.NewInstanceFactory {

    private final Context applicationContext;

    public Factory(Context applicationContext) {
      this.applicationContext = applicationContext;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
      //noinspection unchecked
      return (T) new DeviceViewModel(applicationContext);
    }
  }
}
