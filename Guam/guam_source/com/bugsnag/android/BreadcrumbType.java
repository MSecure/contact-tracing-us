package com.bugsnag.android;

/* compiled from: BreadcrumbType.kt */
public enum BreadcrumbType {
    ERROR("error"),
    LOG("log"),
    MANUAL("manual"),
    NAVIGATION("navigation"),
    PROCESS("process"),
    REQUEST("request"),
    STATE("state"),
    USER("user");
    
    public final String type;

    /* access modifiers changed from: public */
    BreadcrumbType(String str) {
        this.type = str;
    }

    public String toString() {
        return this.type;
    }
}
