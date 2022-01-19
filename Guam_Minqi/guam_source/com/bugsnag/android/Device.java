package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Device.kt */
public class Device implements JsonStream.Streamable {
    public String[] cpuAbi;
    public String id;
    public Boolean jailbroken;
    public String locale;
    public String manufacturer;
    public String model;
    public String osName = "android";
    public String osVersion;
    public Map<String, Object> runtimeVersions;
    public Long totalMemory;

    public Device(DeviceBuildInfo deviceBuildInfo, String[] strArr, Boolean bool, String str, String str2, Long l, Map<String, Object> map) {
        Intrinsics.checkParameterIsNotNull(deviceBuildInfo, "buildInfo");
        this.cpuAbi = strArr;
        this.jailbroken = bool;
        this.id = str;
        this.locale = str2;
        this.totalMemory = l;
        this.runtimeVersions = map;
        this.manufacturer = deviceBuildInfo.manufacturer;
        this.model = deviceBuildInfo.model;
        this.osVersion = deviceBuildInfo.osVersion;
    }

    public void serializeFields$bugsnag_android_core_release(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.name("cpuAbi");
        jsonStream.value(this.cpuAbi);
        jsonStream.name("jailbroken");
        jsonStream.value(this.jailbroken);
        jsonStream.name("id");
        jsonStream.value(this.id);
        jsonStream.name("locale");
        jsonStream.value(this.locale);
        jsonStream.name("manufacturer");
        jsonStream.value(this.manufacturer);
        jsonStream.name("model");
        jsonStream.value(this.model);
        jsonStream.name("osName");
        jsonStream.value(this.osName);
        jsonStream.name("osVersion");
        jsonStream.value(this.osVersion);
        jsonStream.name("runtimeVersions");
        jsonStream.value(this.runtimeVersions);
        jsonStream.name("totalMemory");
        jsonStream.value((Number) this.totalMemory);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        serializeFields$bugsnag_android_core_release(jsonStream);
        jsonStream.endObject();
    }
}
