package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppWithState.kt */
public final class AppWithState extends App {
    public Number duration;
    public Number durationInForeground;
    public Boolean inForeground;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppWithState(ImmutableConfig immutableConfig, String str, String str2, String str3, String str4, String str5, Number number, Number number2, Boolean bool) {
        super(str, str2, str3, str4, str5, immutableConfig.buildUuid, immutableConfig.appType, immutableConfig.versionCode);
        Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
        this.duration = number;
        this.durationInForeground = number2;
        this.inForeground = bool;
    }

    @Override // com.bugsnag.android.App
    public void serialiseFields$bugsnag_android_core_release(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        super.serialiseFields$bugsnag_android_core_release(jsonStream);
        jsonStream.name("duration");
        jsonStream.value(this.duration);
        jsonStream.name("durationInForeground");
        jsonStream.value(this.durationInForeground);
        jsonStream.name("inForeground");
        jsonStream.value(this.inForeground);
    }

    public AppWithState(String str, String str2, String str3, String str4, String str5, String str6, String str7, Number number, Number number2, Number number3, Boolean bool) {
        super(str, str2, str3, str4, str5, str6, str7, number);
        this.duration = number2;
        this.durationInForeground = number3;
        this.inForeground = bool;
    }
}
