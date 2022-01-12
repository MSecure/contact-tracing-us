package com.facebook.imagepipeline.transcoder;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.ImmutableList;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.OutputStream;

public class SimpleImageTranscoder implements ImageTranscoder {
    public final int mMaxBitmapSize;
    public final boolean mResizingEnabled;

    public SimpleImageTranscoder(boolean z, int i) {
        this.mResizingEnabled = z;
        this.mMaxBitmapSize = i;
    }

    public static Bitmap.CompressFormat getOutputFormat(ImageFormat imageFormat) {
        if (imageFormat == null) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.JPEG) {
            return Bitmap.CompressFormat.JPEG;
        }
        if (imageFormat == DefaultImageFormats.PNG) {
            return Bitmap.CompressFormat.PNG;
        }
        if (DefaultImageFormats.isStaticWebpFormat(imageFormat)) {
            return Bitmap.CompressFormat.WEBP;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canResize(EncodedImage encodedImage, RotationOptions rotationOptions, ResizeOptions resizeOptions) {
        if (rotationOptions == null) {
            rotationOptions = RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE;
        }
        if (!this.mResizingEnabled || AppCompatDelegateImpl.ConfigurationImplApi17.determineSampleSize(rotationOptions, resizeOptions, encodedImage, this.mMaxBitmapSize) <= 1) {
            return false;
        }
        return true;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public boolean canTranscode(ImageFormat imageFormat) {
        return imageFormat == DefaultImageFormats.HEIF || imageFormat == DefaultImageFormats.JPEG;
    }

    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public String getIdentifier() {
        return "SimpleImageTranscoder";
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d0 A[Catch:{ OutOfMemoryError -> 0x00dd }] */
    @Override // com.facebook.imagepipeline.transcoder.ImageTranscoder
    public ImageTranscodeResult transcode(EncodedImage encodedImage, OutputStream outputStream, RotationOptions rotationOptions, ResizeOptions resizeOptions, ImageFormat imageFormat, Integer num) {
        int i;
        Matrix matrix;
        Bitmap bitmap;
        Throwable th;
        OutOfMemoryError e;
        Integer num2 = num == null ? 85 : num;
        RotationOptions rotationOptions2 = rotationOptions == null ? RotationOptions.ROTATION_OPTIONS_AUTO_ROTATE : rotationOptions;
        int i2 = 1;
        if (!this.mResizingEnabled) {
            i = 1;
        } else {
            i = AppCompatDelegateImpl.ConfigurationImplApi17.determineSampleSize(rotationOptions2, resizeOptions, encodedImage, this.mMaxBitmapSize);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        try {
            Bitmap decodeStream = BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
            if (decodeStream == null) {
                FLog.e("SimpleImageTranscoder", "Couldn't decode the EncodedImage InputStream ! ");
                return new ImageTranscodeResult(2);
            }
            ImmutableList<Integer> immutableList = JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS;
            encodedImage.parseMetaDataIfNeeded();
            if (immutableList.contains(Integer.valueOf(encodedImage.mExifOrientation))) {
                int forceRotatedInvertedExifOrientation = JpegTranscoderUtils.getForceRotatedInvertedExifOrientation(rotationOptions2, encodedImage);
                matrix = new Matrix();
                if (forceRotatedInvertedExifOrientation == 2) {
                    matrix.setScale(-1.0f, 1.0f);
                } else if (forceRotatedInvertedExifOrientation == 7) {
                    matrix.setRotate(-90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (forceRotatedInvertedExifOrientation == 4) {
                    matrix.setRotate(180.0f);
                    matrix.postScale(-1.0f, 1.0f);
                } else if (forceRotatedInvertedExifOrientation == 5) {
                    matrix.setRotate(90.0f);
                    matrix.postScale(-1.0f, 1.0f);
                }
                if (matrix != null) {
                    try {
                        bitmap = Bitmap.createBitmap(decodeStream, 0, 0, decodeStream.getWidth(), decodeStream.getHeight(), matrix, false);
                    } catch (OutOfMemoryError e2) {
                        e = e2;
                        bitmap = decodeStream;
                        try {
                            FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                            ImageTranscodeResult imageTranscodeResult = new ImageTranscodeResult(2);
                            bitmap.recycle();
                            decodeStream.recycle();
                            return imageTranscodeResult;
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap.recycle();
                            decodeStream.recycle();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = decodeStream;
                        bitmap.recycle();
                        decodeStream.recycle();
                        throw th;
                    }
                } else {
                    bitmap = decodeStream;
                }
                bitmap.compress(getOutputFormat(null), num2.intValue(), outputStream);
                if (i > 1) {
                    i2 = 0;
                }
                ImageTranscodeResult imageTranscodeResult2 = new ImageTranscodeResult(i2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult2;
            }
            int rotationAngle = JpegTranscoderUtils.getRotationAngle(rotationOptions2, encodedImage);
            if (rotationAngle != 0) {
                matrix = new Matrix();
                matrix.setRotate((float) rotationAngle);
                if (matrix != null) {
                }
                bitmap.compress(getOutputFormat(null), num2.intValue(), outputStream);
                if (i > 1) {
                }
                ImageTranscodeResult imageTranscodeResult22 = new ImageTranscodeResult(i2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult22;
            }
            matrix = null;
            if (matrix != null) {
            }
            try {
                bitmap.compress(getOutputFormat(null), num2.intValue(), outputStream);
                if (i > 1) {
                }
                ImageTranscodeResult imageTranscodeResult222 = new ImageTranscodeResult(i2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult222;
            } catch (OutOfMemoryError e3) {
                e = e3;
                FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e);
                ImageTranscodeResult imageTranscodeResult3 = new ImageTranscodeResult(2);
                bitmap.recycle();
                decodeStream.recycle();
                return imageTranscodeResult3;
            }
        } catch (OutOfMemoryError e4) {
            FLog.e("SimpleImageTranscoder", "Out-Of-Memory during transcode", e4);
            return new ImageTranscodeResult(2);
        }
    }
}
