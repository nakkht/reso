package com.neqsoft.reso.utils.view;

import android.view.View;
import android.widget.TextView;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

  private TextView titleTv;
  private AppCompatImageView arrowIv;

  public HeaderViewHolder(@NonNull View itemView) {
    super(itemView);
    titleTv = itemView.findViewById(R.id.titleTv);
    arrowIv = itemView.findViewById(R.id.arrowIv);
  }

  public void setTitle(@NonNull String title) {
    titleTv.setText(title);
  }
}
