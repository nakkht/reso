package com.neqsoft.reso.cpu;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.lifecycle.ViewModelProviders.of;

public class CpuInfoFragment extends Fragment {

  @Nullable
  private CpuInfoRecyclerAdapter cpuInfoRecyclerAdapter;
  @Nullable
  private CpuInfoViewModel cpuInfoViewModel;

  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    cpuInfoViewModel = of(this).get(CpuInfoViewModel.class);
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_cpu_info, container, false);
    bind(view);
    if (cpuInfoViewModel != null)
      cpuInfoViewModel.getCpuInfo().observe(this, this::display);
    return view;
  }

  private void bind(final View view) {
    RecyclerView recyclerView = view.findViewById(R.id.cpuInfoRv);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(cpuInfoRecyclerAdapter);
  }

  private void display(@Nullable CpuInfo cpuInfo) {
    cpuInfoRecyclerAdapter.submit(cpuInfo);
  }
}
