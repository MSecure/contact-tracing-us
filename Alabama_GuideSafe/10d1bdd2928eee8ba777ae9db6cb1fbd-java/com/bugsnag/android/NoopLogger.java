package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NoopLogger.kt */
public final class NoopLogger implements Logger {
    public static final NoopLogger INSTANCE = new NoopLogger();

    @Override // com.bugsnag.android.Logger
    public void d(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    @Override // com.bugsnag.android.Logger
    public void i(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(str, "msg");
    }

    @Override // com.bugsnag.android.Logger
    public void e(String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
    }

    @Override // com.bugsnag.android.Logger
    public void w(String str, Throwable th) {
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
        Intrinsics.checkParameterIsNotNull(str, "msg");
        Intrinsics.checkParameterIsNotNull(th, "throwable");
    }
}
