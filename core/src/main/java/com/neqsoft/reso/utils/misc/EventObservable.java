package com.neqsoft.reso.utils.misc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EventObservable<T> {

  @Nullable
  protected EventObserver<T> eventObserver;
  @Nullable
  protected T value;

  public void emit(@Nullable T value) {
    this.value = value;
    if (eventObserver == null) return;
    eventObserver.emit(value);
  }

  public void emit() {
    if (eventObserver == null) return;
    eventObserver.emit(null);
  }

  public void observe(@NonNull EventObserver<T> eventObserver) {
    this.eventObserver = eventObserver;
  }

  public void removeObserver() {
    this.eventObserver = null;
  }
}
