package com.facebook.imagepipeline.transcoder;

import com.facebook.imageformat.ImageFormat;
import java.lang.reflect.InvocationTargetException;

public class MultiImageTranscoderFactory implements ImageTranscoderFactory {
    public final Integer mImageTranscoderType;
    public final int mMaxBitmapSize;
    public final ImageTranscoderFactory mPrimaryImageTranscoderFactory;
    public final boolean mUseDownSamplingRatio;

    public MultiImageTranscoderFactory(int i, boolean z, ImageTranscoderFactory imageTranscoderFactory, Integer num) {
        this.mMaxBitmapSize = i;
        this.mUseDownSamplingRatio = z;
        this.mPrimaryImageTranscoderFactory = imageTranscoderFactory;
        this.mImageTranscoderType = num;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoderFactory
    public ImageTranscoder createImageTranscoder(ImageFormat imageFormat, boolean z) {
        ImageTranscoder imageTranscoder;
        ImageTranscoderFactory imageTranscoderFactory = this.mPrimaryImageTranscoderFactory;
        ImageTranscoder imageTranscoder2 = null;
        if (imageTranscoderFactory == null) {
            imageTranscoder = null;
        } else {
            imageTranscoder = imageTranscoderFactory.createImageTranscoder(imageFormat, z);
        }
        if (imageTranscoder == null) {
            Integer num = this.mImageTranscoderType;
            if (num != null) {
                int intValue = num.intValue();
                if (intValue == 0) {
                    imageTranscoder2 = getNativeImageTranscoder(imageFormat, z);
                } else if (intValue == 1) {
                    imageTranscoder2 = new SimpleImageTranscoder(z, this.mMaxBitmapSize);
                } else {
                    throw new IllegalArgumentException("Invalid ImageTranscoderType");
                }
            }
            imageTranscoder = imageTranscoder2;
        }
        if (imageTranscoder == null) {
            imageTranscoder = getNativeImageTranscoder(imageFormat, z);
        }
        return imageTranscoder == null ? new SimpleImageTranscoder(z, this.mMaxBitmapSize) : imageTranscoder;
    }

    public final ImageTranscoder getNativeImageTranscoder(ImageFormat imageFormat, boolean z) {
        int i = this.mMaxBitmapSize;
        boolean z2 = this.mUseDownSamplingRatio;
        try {
            return ((ImageTranscoderFactory) Class.forName("com.facebook.imagepipeline.nativecode.NativeJpegTranscoderFactory").getConstructor(Integer.TYPE, Boolean.TYPE).newInstance(Integer.valueOf(i), Boolean.valueOf(z2))).createImageTranscoder(imageFormat, z);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
            throw new RuntimeException("Dependency ':native-imagetranscoder' is needed to use the default native image transcoder.", e);
        }
    }
}
