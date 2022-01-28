package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.soloader.SoLoader;

@DoNotStrip
public class NativeBlurFilter {
    static {
        SoLoader.loadLibrary("native-filters");
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i, int i2) {
        if (bitmap != null) {
            boolean z = true;
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0);
            if (i2 <= 0) {
                z = false;
            }
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
            nativeIterativeBoxBlur(bitmap, i, i2);
            return;
        }
        throw null;
    }

    @DoNotStrip
    public static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);
}
