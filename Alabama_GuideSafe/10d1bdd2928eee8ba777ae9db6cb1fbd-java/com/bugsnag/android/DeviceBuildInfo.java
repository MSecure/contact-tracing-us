package com.bugsnag.android;

/* compiled from: DeviceBuildInfo.kt */
public final class DeviceBuildInfo {
    public final Integer apiLevel;
    public final String brand;
    public final String[] cpuAbis;
    public final String fingerprint;
    public final String manufacturer;
    public final String model;
    public final String osBuild;
    public final String osVersion;
    public final String tags;

    public DeviceBuildInfo(String str, String str2, String str3, Integer num, String str4, String str5, String str6, String str7, String[] strArr) {
        this.manufacturer = str;
        this.model = str2;
        this.osVersion = str3;
        this.apiLevel = num;
        this.osBuild = str4;
        this.fingerprint = str5;
        this.tags = str6;
        this.brand = str7;
        this.cpuAbis = strArr;
    }
}
