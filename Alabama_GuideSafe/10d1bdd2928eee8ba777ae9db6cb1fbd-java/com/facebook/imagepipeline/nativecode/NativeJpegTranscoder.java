package com.facebook.imagepipeline.nativecode;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Closeables;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.ImmutableList;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@DoNotStrip
public class NativeJpegTranscoder implements ImageTranscoder {
    public int mMaxBitmapSize;
    public boolean mResizingEnabled;
    public boolean mUseDownsamplingRatio;

    static {
        AppCompatDelegateImpl.ConfigurationImplApi17.ensure();
    }

    public NativeJpegTranscoder(boolean z, int i, boolean z2) {
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i;
        this.mUseDownsamplingRatio = z2;
    }

    @DoNotStrip
    public static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @DoNotStrip
    public static native void nativeTranscodeJpegWithExifOrientation(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }
        return JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled) < 8;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return "NativeJpegTranscoder";
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) throws IOException {
        Throwable th;
        if (num == null) {
            num = 85;
        }
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }
        int determineSampleSize = AppCompatDelegateImpl.ConfigurationImplApi17.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize);
        InputStream inputStream = null;
        try {
            int softwareNumerator = JpegTranscoderUtils.getSoftwareNumerator(rotationOptions, resizeOptions, encodedImage, this.mResizingEnabled);
            int i = 1;
            int max = Math.max(1, 8 / determineSampleSize);
            if (this.mUseDownsamplingRatio) {
                softwareNumerator = max;
            }
            InputStream inputStream2 = encodedImage.getInputStream();
            try {
                ImmutableList<Integer> immutableList = JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS;
                encodedImage.parseMetaDataIfNeeded();
                if (immutableList.contains(Integer.valueOf(encodedImage.mExifOrientation))) {
                    int forceRotatedInvertedExifOrientation = JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage);
                    int intValue = num.intValue();
                    AppCompatDelegateImpl.ConfigurationImplApi17.ensure();
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(softwareNumerator >= 1);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(softwareNumerator <= 16);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(intValue >= 0);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(intValue <= 100);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(JpegTranscoderUtils.isExifOrientationAllowed(forceRotatedInvertedExifOrientation));
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument1((softwareNumerator == 8 && forceRotatedInvertedExifOrientation == 1) ? false : true, "no transformation requested");
                    if (inputStream2 == null) {
                        throw null;
                    } else if (outputStream != null) {
                        nativeTranscodeJpegWithExifOrientation(inputStream2, outputStream, forceRotatedInvertedExifOrientation, softwareNumerator, intValue);
                    } else {
                        throw null;
                    }
                } else {
                    int rotationAngle = JpegTranscoderUtils.getRotationAngle(rotationOptions, encodedImage);
                    int intValue2 = num.intValue();
                    AppCompatDelegateImpl.ConfigurationImplApi17.ensure();
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(softwareNumerator >= 1);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(softwareNumerator <= 16);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(intValue2 >= 0);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(intValue2 <= 100);
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(JpegTranscoderUtils.isRotationAngleAllowed(rotationAngle));
                    AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument1((softwareNumerator == 8 && rotationAngle == 0) ? false : true, "no transformation requested");
                    if (inputStream2 == null) {
                        throw null;
                    } else if (outputStream != null) {
                        nativeTranscodeJpeg(inputStream2, outputStream, rotationAngle, softwareNumerator, intValue2);
                    } else {
                        throw null;
                    }
                }
                Closeables.closeQuietly(inputStream2);
                if (determineSampleSize != 1) {
                    i = 0;
                }
                return new ImageTranscodeResult(i);
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStream2;
                Closeables.closeQuietly(inputStream);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Closeables.closeQuietly(inputStream);
            throw th;
        }
    }
}
