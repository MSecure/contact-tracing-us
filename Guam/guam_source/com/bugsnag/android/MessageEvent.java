package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessageEvent.kt */
public final class MessageEvent {
    public final Object data;
    public final String type;

    public MessageEvent(String str, Object obj) {
        Intrinsics.checkParameterIsNotNull(str, "type");
        this.type = str;
        this.data = obj;
    }
}
