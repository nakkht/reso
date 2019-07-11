package com.neqsoft.reso.os;

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

public class OsFragment extends Fragment {

  private OsViewModel osViewModel;
  private OsRecyclerAdapter osRecyclerAdapter;

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
    RecyclerView recyclerView = view.findViewById(R.id.osRv);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    osRecyclerAdapter = new OsRecyclerAdapter();
    recyclerView.setAdapter(osRecyclerAdapter);
  }

  private void display(final Os os) {
    osRecyclerAdapter.submit(os);
  }
}
