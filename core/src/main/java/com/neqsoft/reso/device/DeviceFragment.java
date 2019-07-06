package com.neqsoft.reso.device;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static androidx.lifecycle.ViewModelProviders.of;
import static java.lang.String.format;
import static java.util.Locale.getDefault;

public class DeviceFragment extends Fragment {

  private TextView deviceNameTv, screenResolutionTv, densityTv, aspectRatioTv;
  private AppCompatImageView arrowIv;
  private boolean isExpanded = false;
  private Group bottomGroup;
  private Display display;
  private DeviceViewModel deviceViewModel;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (getActivity() != null) {
      display = getActivity().getWindowManager().getDefaultDisplay();
    }
  }

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
    deviceViewModel.getDeviceInfo(display).observe(this, this::setupDevice);
    return view;
  }

  private void bind(final View view) {
    TextView titleTv = view.findViewById(R.id.titleTv);
    titleTv.setText(R.string.hardware_information);
    setupDeviceName(view);
    setupScreenResolution(view);
    setupDensity(view);
    setupAspectRatio(view);
    arrowIv = view.findViewById(R.id.arrowIv);
    view.findViewById(R.id.topGroup).setOnClickListener(v -> changeState());
    bottomGroup = view.findViewById(R.id.bottomGroup);
  }

  private void setupAspectRatio(final View view) {
    ConstraintLayout densityLayout = view.findViewById(R.id.aspectRatioLayout);
    aspectRatioTv = densityLayout.findViewById(R.id.infoTv);
    TextView titleTv = densityLayout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.aspect_ratio);
  }

  private void setupDensity(final View view) {
    ConstraintLayout densityLayout = view.findViewById(R.id.densityLayout);
    densityTv = densityLayout.findViewById(R.id.infoTv);
    TextView titleTv = densityLayout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.density);
  }

  private void setupScreenResolution(final View view) {
    ConstraintLayout screenResolutionLayout = view.findViewById(R.id.screenResolutionLayout);
    screenResolutionTv = screenResolutionLayout.findViewById(R.id.infoTv);
    TextView titleTv = screenResolutionLayout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.screen_resolution);
  }

  private void setupDeviceName(final View view) {
    ConstraintLayout deviceNameLayout = view.findViewById(R.id.deviceNameLayout);
    TextView titleTv = deviceNameLayout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.device_name);
    deviceNameTv = deviceNameLayout.findViewById(R.id.infoTv);
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
    screenResolutionTv.setText(device.getScreenResolution());
    densityTv.setText(format(getDefault(), "%ddpi", device.getDensity()));
    aspectRatioTv.setText(device.getAspectRatio());
  }
}
