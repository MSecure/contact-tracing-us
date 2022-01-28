package com.bugsnag.android;

import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceWithState.kt */
public final class DeviceWithState extends Device {
    public Long freeDisk;
    public Long freeMemory;
    public String orientation;
    public Date time;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceWithState(DeviceBuildInfo deviceBuildInfo, Boolean bool, String str, String str2, Long l, Map<String, Object> map, Long l2, Long l3, String str3, Date date) {
        super(deviceBuildInfo, deviceBuildInfo.cpuAbis, bool, str, str2, l, map);
        Intrinsics.checkParameterIsNotNull(deviceBuildInfo, "buildInfo");
        Intrinsics.checkParameterIsNotNull(map, "runtimeVersions");
        this.freeDisk = l2;
        this.freeMemory = l3;
        this.orientation = str3;
        this.time = date;
    }

    @Override // com.bugsnag.android.Device
    public void serializeFields$bugsnag_android_core_release(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        super.serializeFields$bugsnag_android_core_release(jsonStream);
        jsonStream.name("freeDisk");
        jsonStream.value((Number) this.freeDisk);
        jsonStream.name("freeMemory");
        jsonStream.value((Number) this.freeMemory);
        jsonStream.name("orientation");
        jsonStream.value(this.orientation);
        if (this.time != null) {
            jsonStream.name("time");
            Date date = this.time;
            if (date != null) {
                jsonStream.value(DateUtils.toIso8601(date));
            } else {
                Intrinsics.throwNpe();
                throw null;
            }
        }
    }
}
