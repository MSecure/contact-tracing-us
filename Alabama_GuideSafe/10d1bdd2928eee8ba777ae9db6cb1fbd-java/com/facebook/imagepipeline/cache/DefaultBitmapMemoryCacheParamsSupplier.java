package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;

public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static final long PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5);
    public final ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.mActivityManager = activityManager;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int min = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        return new MemoryCacheParams(min < 33554432 ? 4194304 : min < 67108864 ? 6291456 : min / 4, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, PARAMS_CHECK_INTERVAL_MS);
    }
}
