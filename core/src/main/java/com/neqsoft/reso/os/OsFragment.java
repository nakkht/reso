package com.neqsoft.reso.os;

import android.os.Bundle;
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
import static java.lang.String.valueOf;
import static java.util.Locale.getDefault;

public class OsFragment extends Fragment {

  private OsViewModel osViewModel;
  private TextView osVersionTv, sdkVersionTv, codeNameTv, architectureTv, kernelNameTv, kernelVersionTv,
      bootloaderVersionTv, safeModeTv, bootTimeTv;
  private AppCompatImageView arrowIv;
  private boolean isExpanded = false;
  private Group bottomGroup;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getActivity() != null)
      osViewModel = of(this, new OsViewModel.Factory(getActivity().getApplicationContext())).get(OsViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_os, container, false);
    bind(view);
    osViewModel.getOsData().observe(this, this::display);
    return view;
  }

  private void bind(final View view) {
    TextView titleTv = view.findViewById(R.id.titleTv);
    titleTv.setText(R.string.os_information);
    arrowIv = view.findViewById(R.id.arrowIv);
    view.findViewById(R.id.topGroup).setOnClickListener(v -> changeState());
    bottomGroup = view.findViewById(R.id.bottomGroup);
    setupOsVersion(view);
    setupSdkVersion(view);
    setupCodeName(view);
    setupKernelVersion(view);
    setupKernelName(view);
    setupArchitecture(view);
    setupBooloader(view);
    setupSafeMode(view);
    setupBootTime(view);
  }

  private void setupBootTime(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.bootTimeLayout);
    bootTimeTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.boot_time);
  }

  private void setupSafeMode(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.safeModeLayout);
    safeModeTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.safe_mode);
  }

  private void setupKernelVersion(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.kernelVersionLayout);
    kernelVersionTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.kernel_version);
  }

  private void setupKernelName(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.kernelNameLayout);
    kernelNameTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.kernel);
  }

  private void setupArchitecture(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.architectureLayout);
    architectureTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.architecture);
  }

  private void setupCodeName(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.codeNameLayout);
    codeNameTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.code_name);
  }

  private void setupOsVersion(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.osVersionLayout);
    osVersionTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.os_version);
  }

  private void setupSdkVersion(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.sdkVersionLayout);
    sdkVersionTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.sdk_version);
  }

  private void setupBooloader(final View view) {
    ConstraintLayout layout = view.findViewById(R.id.bootloaderVersionLayout);
    bootloaderVersionTv = layout.findViewById(R.id.infoTv);
    TextView titleTv = layout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.bootloader_version);
  }

  private void display(final Os os) {
    osVersionTv.setText(os.getVersion());
    sdkVersionTv.setText(format(getDefault(), "%d", os.getSdkVersion()));
    codeNameTv.setText(os.getOsVersion().getValue());
    kernelNameTv.setText(os.getKernelName());
    kernelVersionTv.setText(os.getKernelVersion());
    architectureTv.setText(os.getArchitecture());
    bootloaderVersionTv.setText(os.getBootloaderVersion());
    safeModeTv.setText(valueOf(os.isSafeMode()));
    bootTimeTv.setText(os.getBootTimeFormatted());
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
