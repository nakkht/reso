package com.neqsoft.reso.device;

import android.view.View;
import android.view.ViewGroup;

import com.neqsoft.reso.R;
import com.neqsoft.reso.utils.view.HeaderViewHolder;
import com.neqsoft.reso.utils.view.InfoViewHolder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;
import static com.neqsoft.reso.device.Device.PROPERTY_COUNT;

class DeviceRecyclerAdapter extends RecyclerView.Adapter {

  static final int HEADER_ITEM_TYPE = 0;
  static final int INFO_ITEM_TYPE = 1;

  @Nullable
  private Device device;

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    if (viewType == 0) {
      View view = from(parent.getContext()).inflate(R.layout.header_item_view, parent, false);
      return new HeaderViewHolder(view);
    } else {
      View view = from(parent.getContext()).inflate(R.layout.info_item_view, parent, false);
      return new InfoViewHolder(view);
    }
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    switch (position) {
      case 1:
        setupDeviceName((InfoViewHolder) holder);
        break;
      case 2:
        setupResolution((InfoViewHolder) holder);
        break;
      case 3:
        setupDensity((InfoViewHolder) holder);
        break;
      case 4:
        setupAspectRatio((InfoViewHolder) holder);
        break;
      default:
        setupHeader((HeaderViewHolder) holder);
        break;
    }
  }

  private void setupAspectRatio(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.aspect_ratio));
    holder.setInfo(device != null ? device.getFormattedAspectRatio() : "");
  }

  private void setupHeader(HeaderViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.hardware_information));
  }

  private void setupDensity(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.density));
    holder.setInfo(device != null ? device.getFormattedDensity() : "");
  }

  private void setupResolution(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.screen_resolution));
    holder.setInfo(device != null ? device.getFormattedScreenResolution() : "");
  }

  private void setupDeviceName(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.device_name));
    holder.setInfo(device != null ? device.getName() : "");
  }

  @Override
  public int getItemCount() {
    return PROPERTY_COUNT + 1;
  }

  @Override
  public int getItemViewType(int position) {
    return position == 0 ? HEADER_ITEM_TYPE : INFO_ITEM_TYPE;
  }

  public void submit(@Nullable Device device) {
    this.device = device;
    notifyDataSetChanged();
  }
}
