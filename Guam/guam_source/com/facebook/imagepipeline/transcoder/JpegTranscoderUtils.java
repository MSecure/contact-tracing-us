package com.facebook.imagepipeline.transcoder;

import com.facebook.common.internal.ImmutableList;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.Collections;

public class JpegTranscoderUtils {
    public static final ImmutableList<Integer> INVERTED_EXIF_ORIENTATIONS;

    static {
        ImmutableList<Integer> immutableList = new ImmutableList<>(4);
        Collections.addAll(immutableList, 2, 7, 4, 5);
        INVERTED_EXIF_ORIENTATIONS = immutableList;
    }

    public static int getForceRotatedInvertedExifOrientation(RotationOptions rotationOptions, EncodedImage encodedImage) {
        encodedImage.parseMetaDataIfNeeded();
        int indexOf = INVERTED_EXIF_ORIENTATIONS.indexOf(Integer.valueOf(encodedImage.mExifOrientation));
        if (indexOf >= 0) {
            int i = 0;
            if (!rotationOptions.useImageMetadata()) {
                i = rotationOptions.getForcedAngle();
            }
            ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
            return immutableList.get((indexOf + (i / 90)) % immutableList.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int getRotationAngle(RotationOptions rotationOptions, EncodedImage encodedImage) {
        int i = 0;
        if (!rotationOptions.rotationEnabled()) {
            return 0;
        }
        int rotationAngle = encodedImage.getRotationAngle();
        if (rotationAngle == 90 || rotationAngle == 180 || rotationAngle == 270) {
            i = encodedImage.getRotationAngle();
        }
        if (rotationOptions.useImageMetadata()) {
            return i;
        }
        return (rotationOptions.getForcedAngle() + i) % 360;
    }

    public static int getSoftwareNumerator(RotationOptions rotationOptions, ResizeOptions resizeOptions, EncodedImage encodedImage, boolean z) {
        int i;
        int i2;
        if (!z || resizeOptions == null) {
            return 8;
        }
        int rotationAngle = getRotationAngle(rotationOptions, encodedImage);
        ImmutableList<Integer> immutableList = INVERTED_EXIF_ORIENTATIONS;
        encodedImage.parseMetaDataIfNeeded();
        boolean z2 = false;
        int forceRotatedInvertedExifOrientation = immutableList.contains(Integer.valueOf(encodedImage.mExifOrientation)) ? getForceRotatedInvertedExifOrientation(rotationOptions, encodedImage) : 0;
        if (rotationAngle == 90 || rotationAngle == 270 || forceRotatedInvertedExifOrientation == 5 || forceRotatedInvertedExifOrientation == 7) {
            z2 = true;
        }
        if (z2) {
            encodedImage.parseMetaDataIfNeeded();
            i = encodedImage.mHeight;
        } else {
            encodedImage.parseMetaDataIfNeeded();
            i = encodedImage.mWidth;
        }
        if (z2) {
            encodedImage.parseMetaDataIfNeeded();
            i2 = encodedImage.mWidth;
        } else {
            encodedImage.parseMetaDataIfNeeded();
            i2 = encodedImage.mHeight;
        }
        float f = (float) i;
        float f2 = (float) i2;
        float max = Math.max(((float) resizeOptions.width) / f, ((float) resizeOptions.height) / f2);
        float f3 = resizeOptions.maxBitmapSize;
        if (f * max > f3) {
            max = f3 / f;
        }
        float f4 = resizeOptions.maxBitmapSize;
        if (f2 * max > f4) {
            max = f4 / f2;
        }
        int i3 = (int) ((max * 8.0f) + resizeOptions.roundUpFraction);
        if (i3 > 8) {
            return 8;
        }
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }

    public static boolean isExifOrientationAllowed(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static boolean isRotationAngleAllowed(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }
}
