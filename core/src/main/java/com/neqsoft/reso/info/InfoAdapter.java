package com.neqsoft.reso.info;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.neqsoft.reso.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InfoAdapter extends RecyclerView.Adapter<InfoViewHolder> {

  @NonNull
  private final List<String> infoItems;

  public InfoAdapter(@NonNull List<String> infoItems) {
    this.infoItems = infoItems;
  }

  @NonNull
  @Override
  public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent, false);
    return new InfoViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
    holder.titleTv.setText(infoItems.get(position));
  }

  @Override
  public int getItemCount() {
    return infoItems.size();
  }
}
