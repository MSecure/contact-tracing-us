package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class NativeRoundingFilter {
    static {
        SoLoader.loadLibrary("native-filters");
    }

    @DoNotStrip
    public static native void nativeToCircleFilter(Bitmap bitmap, boolean z);

    @DoNotStrip
    public static native void nativeToCircleWithBorderFilter(Bitmap bitmap, int i, int i2, boolean z);
}
