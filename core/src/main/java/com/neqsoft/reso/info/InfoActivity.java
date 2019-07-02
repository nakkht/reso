package com.neqsoft.reso.info;

import android.os.Bundle;

import com.neqsoft.reso.R;
import com.neqsoft.reso.device.Device;
import com.neqsoft.reso.device.DeviceViewModel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static androidx.lifecycle.ViewModelProviders.of;

public class InfoActivity extends AppCompatActivity {

  private DeviceViewModel deviceViewModel;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    setSupportActionBar(findViewById(R.id.toolbar));
    deviceViewModel = of(this, new DeviceViewModel.Factory(getApplicationContext())).get(DeviceViewModel.class);
    deviceViewModel.getDeviceInfo().observe(this::setupDevice);
  }

  private void setupDevice(@Nullable Device device) {

  }
}
