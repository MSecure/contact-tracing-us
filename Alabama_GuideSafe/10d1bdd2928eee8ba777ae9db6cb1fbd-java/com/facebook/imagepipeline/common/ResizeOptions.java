package com.facebook.imagepipeline.common;

import androidx.appcompat.app.AppCompatDelegateImpl;

public class ResizeOptions {
    public final int height;
    public final float maxBitmapSize;
    public final float roundUpFraction;
    public final int width;

    public ResizeOptions(int i, int i2) {
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i2 <= 0 ? false : z);
        this.width = i;
        this.height = i2;
        this.maxBitmapSize = 2048.0f;
        this.roundUpFraction = 0.6666667f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ResizeOptions)) {
            return false;
        }
        ResizeOptions resizeOptions = (ResizeOptions) obj;
        return this.width == resizeOptions.width && this.height == resizeOptions.height;
    }

    public int hashCode() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.hashCode(this.width, this.height);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.width), Integer.valueOf(this.height));
    }
}
