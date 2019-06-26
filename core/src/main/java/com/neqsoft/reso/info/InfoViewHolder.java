package com.neqsoft.reso.info;

import android.view.View;
import android.widget.TextView;

import com.neqsoft.reso.R;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class InfoViewHolder extends RecyclerView.ViewHolder {

  protected TextView titleTv;
  protected AppCompatImageView arrowIv;

  public InfoViewHolder(@NonNull View itemView) {
    super(itemView);
    titleTv = itemView.findViewById(R.id.titleTv);
    arrowIv = itemView.findViewById(R.id.arrowIv);
  }
}
