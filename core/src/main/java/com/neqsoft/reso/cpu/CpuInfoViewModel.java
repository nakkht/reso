package com.neqsoft.reso.cpu;

import java.util.concurrent.ExecutorService;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import static java.util.concurrent.Executors.newCachedThreadPool;

public class CpuInfoViewModel extends ViewModel {

  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<CpuInfo> cpuInfo;

  public CpuInfoViewModel() {
    backgroundExecutor = newCachedThreadPool();
    cpuInfo = new MutableLiveData<>();
  }

  public LiveData<CpuInfo> getCpuInfo() {
    backgroundExecutor.execute(() -> {

    });
    return cpuInfo;
  }
}
