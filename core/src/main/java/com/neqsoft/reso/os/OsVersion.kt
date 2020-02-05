package com.neqsoft.reso.os

enum class OsVersion(val value: String) {

    UNKNOWN("Unknown"),
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

    companion object {

        private val VALUES: List<OsVersion> by lazy { values().map { it } }

        fun get(sdkValue: Int): OsVersion {
            return VALUES[sdkValue]
        }
    }
}