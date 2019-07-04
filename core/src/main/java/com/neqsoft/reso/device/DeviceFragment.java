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
import static androidx.lifecycle.ViewModelProviders.of;

public class DeviceFragment extends Fragment {

  private TextView deviceNameTv, screenResolutionTv;
  private AppCompatImageView arrowIv;
  private boolean isExpanded = false;
  private Group bottomGroup;
  private DeviceViewModel deviceViewModel;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getActivity() != null) {
      deviceViewModel = of(this, new DeviceViewModel.Factory(getActivity().getApplicationContext())).get(DeviceViewModel.class);
    }
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_device, container, false);
    bind(view);
    deviceViewModel.getDeviceInfo(getActivity()).observe(this, this::setupDevice);
    return view;
  }

  private void bind(View view) {
    TextView titleTv = view.findViewById(R.id.titleTv);
    titleTv.setText(R.string.hardware_information);
    screenResolutionTv = view.findViewById(R.id.screenResolutionLayout).findViewById(R.id.infoTv);
    deviceNameTv = view.findViewById(R.id.deviceNameLayout).findViewById(R.id.infoTv);
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

  private void setupDevice(Device device) {
    deviceNameTv.setText(device.getName());
    screenResolutionTv.setText(device.getScreenResolution().toString());
  }
}
