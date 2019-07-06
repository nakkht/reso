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

public class OsFragment extends Fragment {

  private OsViewModel osViewModel;
  private TextView osVersionTv;
  private AppCompatImageView arrowIv;
  private boolean isExpanded = false;
  private Group bottomGroup;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    osViewModel = of(this).get(OsViewModel.class);
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
  }

  private void setupOsVersion(final View view) {
    ConstraintLayout osVersionLayout = view.findViewById(R.id.osVersionLayout);
    osVersionTv = osVersionLayout.findViewById(R.id.infoTv);
    TextView titleTv = osVersionLayout.findViewById(R.id.titleTv);
    titleTv.setText(R.string.os_version);
  }

  private void display(final Os os) {
    osVersionTv.setText(os.getVersion());
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
