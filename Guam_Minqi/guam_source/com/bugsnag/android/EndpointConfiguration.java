package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: EndpointConfiguration.kt */
public final class EndpointConfiguration {
    public final String notify;
    public final String sessions;

    public EndpointConfiguration(String str, String str2, int i) {
        String str3 = null;
        String str4 = (i & 1) != 0 ? "https://notify.bugsnag.com" : null;
        str3 = (i & 2) != 0 ? "https://sessions.bugsnag.com" : str3;
        Intrinsics.checkParameterIsNotNull(str4, "notify");
        Intrinsics.checkParameterIsNotNull(str3, "sessions");
        this.notify = str4;
        this.sessions = str3;
    }

    public EndpointConfiguration(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "notify");
        Intrinsics.checkParameterIsNotNull(str2, "sessions");
        this.notify = str;
        this.sessions = str2;
    }
}
