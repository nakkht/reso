package com.neqsoft.reso.info;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.neqsoft.reso.R;
import com.neqsoft.reso.device.DeviceFragment;
import com.neqsoft.reso.os.OsFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class InfoActivity extends AppCompatActivity {

  @Nullable
  private Fragment deviceFragment, osFragment;
  private final FragmentManager fragmentManager;

  public InfoActivity() {
    fragmentManager = getSupportFragmentManager();
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    setSupportActionBar(findViewById(R.id.toolbar));
    setupBottomNavigation();
    displayDeviceView();
  }

  private void setupBottomNavigation() {
    BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
    bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
      if (menuItem.getItemId() == R.id.deviceItem) {
        displayDeviceView();
      } else {
        displayOsView();
      }
      return true;
    });
  }

  private void displayOsView() {
    osFragment = osFragment != null ? osFragment : new OsFragment();
    display(osFragment);
  }

  private void displayDeviceView() {
    deviceFragment = deviceFragment != null ? deviceFragment : new DeviceFragment();
    display(deviceFragment);
  }

  private void display(@NonNull final Fragment fragment) {
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.container, fragment).commit();
  }
}
