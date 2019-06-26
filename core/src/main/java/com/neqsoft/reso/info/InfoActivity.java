package com.neqsoft.reso.info;

import android.os.Bundle;

import com.neqsoft.reso.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class InfoActivity extends AppCompatActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_info);
    setSupportActionBar(findViewById(R.id.toolbar));
    setuRecyclerview();
  }

  private void setuRecyclerview() {
    RecyclerView recyclerView = findViewById(R.id.infoRecyclerView);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    InfoAdapter infoAdapter = new InfoAdapter(generateInfoList());
    recyclerView.setAdapter(infoAdapter);
  }

  private List<String> generateInfoList() {
    List<String> infoTypeTitles = new ArrayList<>();
    InfoType[] infoTypes = InfoType.values();
    for (InfoType infoType : infoTypes) {
      if (infoType == InfoType.HARDWARE) {
        infoTypeTitles.add(getString(R.string.hardware_information));
      }
    }
    return infoTypeTitles;
  }
}
