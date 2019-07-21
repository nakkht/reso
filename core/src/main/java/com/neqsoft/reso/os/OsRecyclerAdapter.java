package com.neqsoft.reso.os;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.neqsoft.reso.R;
import com.neqsoft.reso.utils.view.HeaderViewHolder;
import com.neqsoft.reso.utils.view.InfoViewHolder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.LayoutInflater.from;
import static com.neqsoft.reso.os.Os.PROPERTY_COUNT;
import static java.lang.String.format;
import static java.lang.String.valueOf;
import static java.util.Locale.getDefault;

class OsRecyclerAdapter extends RecyclerView.Adapter {

  static final int HEADER_ITEM_TYPE = 0;
  static final int INFO_ITEM_TYPE = 1;

  @Nullable
  private Os os;

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
        setupOsVersion((InfoViewHolder) holder);
        break;
      case 2:
        setupSdkVersion((InfoViewHolder) holder);
        break;
      case 3:
        setupCodeName((InfoViewHolder) holder);
        break;
      case 4:
        setupKernelVersion((InfoViewHolder) holder);
        break;
      case 5:
        setupKernel((InfoViewHolder) holder);
        break;
      case 6:
        setupArchitecture((InfoViewHolder) holder);
        break;
      case 7:
        setupBootloaderVersion((InfoViewHolder) holder);
        break;
      case 8:
        setupSafeModeInfo((InfoViewHolder) holder);
        break;
      case 9:
        setupBootDateTime((InfoViewHolder) holder);
        break;
      case 10:
        setupUptime((InfoViewHolder) holder);
        break;
      default:
        setupHeader((HeaderViewHolder) holder);
        break;
    }
  }

  private void setupUptime(InfoViewHolder holder) {
    Context context = holder.itemView.getContext();
    holder.setTitle(context.getString(R.string.uptime));
    if (os == null) return;

    int days = os.getUptimeDays();
    int hours = os.getUptimeHours();
    int minutes = os.getUptimeMinutes();
    int seconds = os.getUptimeSeconds();
    String dayString = context.getResources().getQuantityString(R.plurals.day, days);
    String hourString = context.getResources().getQuantityString(R.plurals.hour, hours);
    String minuteString = context.getResources().getQuantityString(R.plurals.minute, minutes);
    String secondString = context.getResources().getQuantityString(R.plurals.seconds, seconds);
    String text = context.getString(R.string.placeholder_time, days, dayString, hours, hourString,
                                    minutes, minuteString, seconds, secondString);
    holder.setInfo(text);
  }

  private void setupBootDateTime(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.boot_date_time));
    if (os == null) return;
    holder.setInfo(os.getFormattedBootTime());
  }

  private void setupSafeModeInfo(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.safe_mode));
    if (os == null) return;
    holder.setInfo(valueOf(os.isSafeMode()));
  }

  private void setupBootloaderVersion(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.bootloader_version));
    if (os == null) return;
    holder.setInfo(os.getBootloaderVersion());
  }

  private void setupArchitecture(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.architecture));
    if (os == null) return;
    holder.setInfo(os.getArchitecture());
  }

  private void setupKernel(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.kernel_version));
    if (os == null) return;
    holder.setInfo(os.getKernelName());
  }

  private void setupKernelVersion(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.kernel_version));
    if (os == null) return;
    holder.setInfo(os.getKernelVersion());
  }

  private void setupCodeName(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.code_name));
    if (os == null) return;
    holder.setInfo(os.getOsVersion().getValue());
  }

  private void setupSdkVersion(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.sdk_version));
    if (os == null) return;
    holder.setInfo(format(getDefault(), "%d", os.getSdkVersion()));
  }

  private void setupOsVersion(InfoViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.os_version));
    holder.setInfo(os != null ? os.getOsVersion().getValue() : "");
  }

  private void setupHeader(HeaderViewHolder holder) {
    holder.setTitle(holder.itemView.getContext().getString(R.string.os_information));
  }

  @Override
  public int getItemCount() {
    return PROPERTY_COUNT + 1;
  }

  @Override
  public int getItemViewType(int position) {
    return position == 0 ? HEADER_ITEM_TYPE : INFO_ITEM_TYPE;
  }

  public void submit(@Nullable Os os) {
    this.os = os;
    notifyDataSetChanged();
  }
}

