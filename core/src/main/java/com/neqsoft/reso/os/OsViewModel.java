package com.neqsoft.reso.os;

import android.os.Build;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static java.lang.System.getProperty;

public class OsViewModel extends ViewModel {

  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<Os> osData;

  public OsViewModel() {
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
      osData.postValue(os);
    });
    return osData;
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
}
