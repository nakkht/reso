package com.neqsoft.reso.info;

import android.os.Bundle;

import com.neqsoft.reso.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    setSupportActionBar(findViewById(R.id.toolbar));
  }
}
