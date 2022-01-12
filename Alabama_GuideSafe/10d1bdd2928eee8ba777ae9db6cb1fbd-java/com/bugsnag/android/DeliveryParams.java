package com.bugsnag.android;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeliveryParams.kt */
public final class DeliveryParams {
    public final String endpoint;
    public final Map<String, String> headers;

    public DeliveryParams(String str, Map<String, String> map) {
        Intrinsics.checkParameterIsNotNull(str, "endpoint");
        Intrinsics.checkParameterIsNotNull(map, "headers");
        this.endpoint = str;
        this.headers = map;
    }
}
