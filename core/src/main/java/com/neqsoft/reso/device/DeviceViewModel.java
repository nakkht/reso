package com.neqsoft.reso.device;

import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
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

  public LiveData<Device> getDeviceInfo() {
    backgroundExecutor.execute(() -> {
      Device device = new Device();
      device.setName(getDeviceName());
      deviceData.postValue(device);
    });
    return deviceData;
  }

  protected String getDeviceName() {
    return MANUFACTURER + " " + MODEL + " " + RELEASE;
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
