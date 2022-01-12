package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;

public class ImageDecodeOptionsBuilder {
    public Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    public int mMinDecodeIntervalMs = 100;
}
