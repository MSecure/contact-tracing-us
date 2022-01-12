package com.bugsnag.android;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: ThreadType.kt */
public final class ThreadType extends Enum<ThreadType> {
    public static final /* synthetic */ ThreadType[] $VALUES;
    public static final ThreadType ANDROID;
    public final String desc;

    static {
        ThreadType threadType = new ThreadType("ANDROID", 0, "android");
        ANDROID = threadType;
        $VALUES = new ThreadType[]{threadType, new ThreadType("REACTNATIVEJS", 1, "reactnativejs")};
    }

    public ThreadType(String str, int i, String str2) {
        this.desc = str2;
    }

    public static ThreadType valueOf(String str) {
        return (ThreadType) Enum.valueOf(ThreadType.class, str);
    }

    public static ThreadType[] values() {
        return (ThreadType[]) $VALUES.clone();
    }
}
