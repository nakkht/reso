package com.neqsoft.reso.os;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OsViewModel extends ViewModel {

  private final ExecutorService backgroundExecutor;
  private final MutableLiveData<Os> osData;

  public OsViewModel() {
    backgroundExecutor = Executors.newCachedThreadPool();
    osData = new MutableLiveData<>();
  }


  public LiveData<Os> getOsData() {
    backgroundExecutor.execute(() -> {

    });
    return osData;
  }
}
