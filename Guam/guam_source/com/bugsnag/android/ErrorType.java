package com.bugsnag.android;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: ErrorType.kt */
public final class ErrorType extends Enum<ErrorType> {
    public static final /* synthetic */ ErrorType[] $VALUES;
    public static final ErrorType ANDROID;
    public static final ErrorType C;
    public final String desc;

    static {
        ErrorType errorType = new ErrorType("ANDROID", 0, "android");
        ANDROID = errorType;
        ErrorType errorType2 = new ErrorType("C", 2, "c");
        C = errorType2;
        $VALUES = new ErrorType[]{errorType, new ErrorType("REACTNATIVEJS", 1, "reactnativejs"), errorType2};
    }

    public ErrorType(String str, int i, String str2) {
        this.desc = str2;
    }

    public static ErrorType valueOf(String str) {
        return (ErrorType) Enum.valueOf(ErrorType.class, str);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) $VALUES.clone();
    }
}
