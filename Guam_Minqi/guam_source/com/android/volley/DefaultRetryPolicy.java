package com.android.volley;

public class DefaultRetryPolicy {
    public final float mBackoffMultiplier = 1.0f;
    public int mCurrentRetryCount;
    public int mCurrentTimeoutMs = 2500;
    public final int mMaxNumRetries = 1;
}
