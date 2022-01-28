package com.bugsnag.android;

/* compiled from: ErrorTypes.kt */
public final class ErrorTypes {
    public boolean anrs;
    public boolean ndkCrashes;
    public boolean unhandledExceptions;
    public boolean unhandledRejections;

    public ErrorTypes(boolean z) {
        this.anrs = z;
        this.ndkCrashes = z;
        this.unhandledExceptions = z;
        this.unhandledRejections = z;
    }

    public ErrorTypes(boolean z, boolean z2, boolean z3, boolean z4) {
        this.anrs = z;
        this.ndkCrashes = z2;
        this.unhandledExceptions = z3;
        this.unhandledRejections = z4;
    }
}
