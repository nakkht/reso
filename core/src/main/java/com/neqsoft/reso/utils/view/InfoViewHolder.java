package com.neqsoft.reso.utils.view;

import android.view.View;
import android.widget.TextView;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class InfoViewHolder extends RecyclerView.ViewHolder {

  private TextView titleTv, infoTv;

  public InfoViewHolder(@NonNull View itemView) {
    super(itemView);
    titleTv = itemView.findViewById(R.id.titleTv);
    infoTv = itemView.findViewById(R.id.infoTv);
  }

  public void setTitle(@NonNull String title) {
    titleTv.setText(title);
  }

  public void setInfo(@Nullable String info) {
    infoTv.setText(info);
  }
}
