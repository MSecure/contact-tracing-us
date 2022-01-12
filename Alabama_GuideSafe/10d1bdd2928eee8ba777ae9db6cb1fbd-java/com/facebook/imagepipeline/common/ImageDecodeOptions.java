package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.transformation.BitmapTransformation;

public class ImageDecodeOptions {
    public static final ImageDecodeOptions DEFAULTS = new ImageDecodeOptions(new ImageDecodeOptionsBuilder());
    public final Bitmap.Config bitmapConfig;
    public final BitmapTransformation bitmapTransformation;
    public final ColorSpace colorSpace;
    public final ImageDecoder customImageDecoder;
    public final boolean decodeAllFrames = false;
    public final boolean decodePreviewFrame = false;
    public final boolean forceStaticImage = false;
    public final int minDecodeIntervalMs;
    public final boolean useLastFrameForPreview = false;

    public ImageDecodeOptions(ImageDecodeOptionsBuilder imageDecodeOptionsBuilder) {
        this.minDecodeIntervalMs = imageDecodeOptionsBuilder.mMinDecodeIntervalMs;
        this.bitmapConfig = imageDecodeOptionsBuilder.mBitmapConfig;
        this.customImageDecoder = null;
        this.bitmapTransformation = null;
        this.colorSpace = null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ImageDecodeOptions.class != obj.getClass()) {
            return false;
        }
        ImageDecodeOptions imageDecodeOptions = (ImageDecodeOptions) obj;
        return this.decodePreviewFrame == imageDecodeOptions.decodePreviewFrame && this.useLastFrameForPreview == imageDecodeOptions.useLastFrameForPreview && this.decodeAllFrames == imageDecodeOptions.decodeAllFrames && this.forceStaticImage == imageDecodeOptions.forceStaticImage && this.bitmapConfig == imageDecodeOptions.bitmapConfig && this.customImageDecoder == imageDecodeOptions.customImageDecoder && this.bitmapTransformation == imageDecodeOptions.bitmapTransformation && this.colorSpace == imageDecodeOptions.colorSpace;
    }

    public int hashCode() {
        int ordinal = (this.bitmapConfig.ordinal() + (((((((((this.minDecodeIntervalMs * 31) + (this.decodePreviewFrame ? 1 : 0)) * 31) + (this.useLastFrameForPreview ? 1 : 0)) * 31) + (this.decodeAllFrames ? 1 : 0)) * 31) + (this.forceStaticImage ? 1 : 0)) * 31)) * 31;
        ImageDecoder imageDecoder = this.customImageDecoder;
        int i = 0;
        int hashCode = (ordinal + (imageDecoder != null ? imageDecoder.hashCode() : 0)) * 31;
        BitmapTransformation bitmapTransformation2 = this.bitmapTransformation;
        int hashCode2 = (hashCode + (bitmapTransformation2 != null ? bitmapTransformation2.hashCode() : 0)) * 31;
        ColorSpace colorSpace2 = this.colorSpace;
        if (colorSpace2 != null) {
            i = colorSpace2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return String.format(null, "%d-%b-%b-%b-%b-%b-%s-%s-%s", Integer.valueOf(this.minDecodeIntervalMs), Boolean.valueOf(this.decodePreviewFrame), Boolean.valueOf(this.useLastFrameForPreview), Boolean.valueOf(this.decodeAllFrames), Boolean.valueOf(this.forceStaticImage), this.bitmapConfig.name(), this.customImageDecoder, this.bitmapTransformation, this.colorSpace);
    }
}
