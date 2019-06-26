package com.neqsoft.reso.utils.misc;

import androidx.annotation.Nullable;

public interface EventObserver<T> {

  void emit(@Nullable T value);
}