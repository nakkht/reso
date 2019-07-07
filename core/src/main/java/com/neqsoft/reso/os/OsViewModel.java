package com.neqsoft.reso.os;

import android.content.Context;
import android.os.Build;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import static android.os.SystemClock.elapsedRealtime;
import static java.lang.System.currentTimeMillis;
import static java.lang.System.getProperty;

public class OsViewModel extends ViewModel {

  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<Os> osData;
  private final Context applicationContext;

  public OsViewModel(final Context applicationContext) {
    this.applicationContext = applicationContext;
    backgroundExecutor = Executors.newCachedThreadPool();
    osData = new MutableLiveData<>();
  }

  public LiveData<Os> getOsData() {
    backgroundExecutor.execute(() -> {
      Os os = new Os();
      os.setSdkVersion(Build.VERSION.SDK_INT);
      os.setVersion(Build.VERSION.RELEASE);
      os.setKernelVersion(getKernelVersion());
      os.setKernelName(getKernelName());
      os.setArchitecture(getArchitecture());
      os.setBootloaderVersion(Build.BOOTLOADER);
      os.setSafeMode(applicationContext.getPackageManager().isSafeMode());
      os.setBootTime(calculateBootTime());
      osData.postValue(os);
    });
    return osData;
  }

  private long calculateBootTime() {
    return currentTimeMillis() - elapsedRealtime();
  }

  @Nullable
  public String getKernelVersion() {
    return getProperty("os.version");
  }

  @Nullable
  public String getKernelName() {
    return getProperty("os.name");
  }

  @Nullable
  public String getArchitecture() {
    return getProperty("os.arch");
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
      return (T) new OsViewModel(applicationContext);
    }
  }
}
