package org.pathcheck.covidsafepaths.exposurenotifications.utils;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Result.kt */
public class Error {
    public final int code;
    public final String message;

    public Error(int i, String str, Throwable th, int i2) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.code = i;
        this.message = str;
    }
}
