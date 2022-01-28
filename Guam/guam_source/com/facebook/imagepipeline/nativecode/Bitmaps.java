package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.DoNotStrip;

@DoNotStrip
public class Bitmaps {
    static {
        ImagePipelineNativeLoader.load();
    }

    public static void copyBitmap(Bitmap bitmap, Bitmap bitmap2) {
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(bitmap2.getConfig() == bitmap.getConfig());
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(bitmap.isMutable());
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(bitmap.getWidth() == bitmap2.getWidth());
        if (bitmap.getHeight() != bitmap2.getHeight()) {
            z = false;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
        nativeCopyBitmap(bitmap, bitmap.getRowBytes(), bitmap2, bitmap2.getRowBytes(), bitmap.getHeight());
    }

    @DoNotStrip
    public static native void nativeCopyBitmap(Bitmap bitmap, int i, Bitmap bitmap2, int i2, int i3);
}
