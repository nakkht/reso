package com.neqsoft.reso.utils.misc;

import androidx.annotation.Nullable;

public interface Observer<T> {

  void onChanged(@Nullable T value);
}
