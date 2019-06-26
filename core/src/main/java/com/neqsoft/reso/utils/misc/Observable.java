package com.neqsoft.reso.utils.misc;

import androidx.annotation.Nullable;

public class Observable<T> {

  @Nullable
  protected Observer<T> observer;
  @Nullable
  protected T value;

  public Observable() {}

  public Observable(@Nullable T value) {
    this.value = value;
  }

  final public void set(@Nullable T value) {
    if (this.value == value) return;
    this.value = value;
    notifyChange();
  }

  private void notifyChange() {
    if (observer == null) return;
    observer.onChanged(value);
  }

  public void observe(@Nullable Observer<T> observer) {
    if (observer == null) return;
    this.observer = observer;
    observer.onChanged(value);
  }

  public void removeObserver() {
    this.observer = null;
  }
}