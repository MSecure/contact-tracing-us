package com.bugsnag.android;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
/* compiled from: ThreadSendPolicy.kt */
public final class ThreadSendPolicy extends Enum<ThreadSendPolicy> {
    public static final /* synthetic */ ThreadSendPolicy[] $VALUES;
    public static final ThreadSendPolicy ALWAYS;
    public static final Companion Companion = new Companion(null);
    public static final ThreadSendPolicy UNHANDLED_ONLY;

    /* compiled from: ThreadSendPolicy.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        ThreadSendPolicy threadSendPolicy = new ThreadSendPolicy("ALWAYS", 0);
        ALWAYS = threadSendPolicy;
        ThreadSendPolicy threadSendPolicy2 = new ThreadSendPolicy("UNHANDLED_ONLY", 1);
        UNHANDLED_ONLY = threadSendPolicy2;
        $VALUES = new ThreadSendPolicy[]{threadSendPolicy, threadSendPolicy2, new ThreadSendPolicy("NEVER", 2)};
    }

    public ThreadSendPolicy(String str, int i) {
    }

    public static ThreadSendPolicy valueOf(String str) {
        return (ThreadSendPolicy) Enum.valueOf(ThreadSendPolicy.class, str);
    }

    public static ThreadSendPolicy[] values() {
        return (ThreadSendPolicy[]) $VALUES.clone();
    }
}
