package com.neqsoft.reso.os;

import androidx.collection.SparseArrayCompat;

public enum OsVersion {
  BASE("1.0"),
  BASE_1_1("1.1"),
  CUPCAKE("Cupcake"),
  DONUT("Donut"),
  ECLAIR("Eclair"),
  ECLAIR_0_1("Eclair"),
  ECLAIR_MR1("Eclair"),
  FROYO("FROYO"),
  GINGERBREAD("Gingerbread"),
  GINGERBREAD_MR1("Gingerbread"),
  HONEYCOMB("Honeycomb"),
  HONEYCOMB_MR1("Honeycomb"),
  HONEYCOMB_MR2("Honeycomb"),
  ICE_CREAM_SANDWICH("Ice cream sandwich"),
  ICE_CREAM_SANDWICH_MR1("Ice cream sandwich"),
  JELLY_BEAN("Jelly bean"),
  JELLY_BEAN_MR1("Jelly bean"),
  JELLY_BEAN_MR2("Jelly bean"),
  KITKAT("Kitkat"),
  KITKAT_WATCH("Kitkat"),
  LOLLIPOP("Lollipop"),
  LOLLIPOP_MR1("Lollipop"),
  MARSHMALLOW("Marshmallow"),
  NOUGAT("Nougat"),
  N_MR1("Nougat"),
  Oreo("Oreo"),
  O_MR1("Oreo"),
  Pie("Pie"),
  Q("Q");

  private static final SparseArrayCompat<OsVersion> VALUES;

  static {
    SparseArrayCompat<OsVersion> values = new SparseArrayCompat<>();
    int length = OsVersion.values().length;
    OsVersion[] osValues = OsVersion.values();
    for (int x = 0; x < length; x++) {
      values.put(x, osValues[x]);
    }
    VALUES = values;
  }

  private String value;

  OsVersion(final String value) {
    this.value = value;
  }

  public static OsVersion get(int sdkValue) {
    return VALUES.get(sdkValue - 1);
  }

  public String getValue() {
    return value;
  }
}
