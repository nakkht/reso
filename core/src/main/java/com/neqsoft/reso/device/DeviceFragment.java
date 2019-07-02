package com.neqsoft.reso.device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class DeviceFragment extends Fragment {

  private TextView deviceNameTv;
  private AppCompatImageView arrowIv;
  private boolean isExpanded = false;
  private Group bottomGroup;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_device, container, false);
    bind(view);
    return view;
  }

  private void bind(View view) {
    deviceNameTv = view.findViewById(R.id.deviceNameTv).findViewById(R.id.infoTv);
    arrowIv = view.findViewById(R.id.arrowIv);
    view.findViewById(R.id.topGroup).setOnClickListener(v -> changeState());
    bottomGroup = view.findViewById(R.id.bottomGroup);
  }

  private void changeState() {
    if (isExpanded)
      collapse();
    else
      expand();
    isExpanded = !isExpanded;
  }

  private void expand() {
    arrowIv.animate().rotation(180);
    bottomGroup.setVisibility(VISIBLE);
  }

  private void collapse() {
    arrowIv.animate().rotation(0);
    bottomGroup.setVisibility(GONE);
  }
}
