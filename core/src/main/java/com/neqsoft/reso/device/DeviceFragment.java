package com.neqsoft.reso.device;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DeviceFragment extends Fragment {

  private Display display;
  @Nullable
  private DeviceViewModel deviceViewModel;
  @Nullable
  private DeviceRecyclerAdapter deviceRecyclerAdapter;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    if (getActivity() != null)
      display = getActivity().getWindowManager().getDefaultDisplay();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    deviceViewModel = new ViewModelProvider(this).get(DeviceViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_device, container, false);
    bind(view);
    if (deviceViewModel != null)
      deviceViewModel.getDeviceInfo(display).observe(getViewLifecycleOwner(), this::display);
    return view;
  }

  private void bind(final View view) {
    RecyclerView recyclerView = view.findViewById(R.id.deviceRv);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    deviceRecyclerAdapter = new DeviceRecyclerAdapter();
    recyclerView.setAdapter(deviceRecyclerAdapter);
  }

  private void display(@Nullable Device device) {
    if (deviceRecyclerAdapter != null)
      deviceRecyclerAdapter.submit(device);
  }
}
