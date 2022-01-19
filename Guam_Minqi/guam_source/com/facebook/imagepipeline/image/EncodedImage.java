package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.media.ExifInterface;
import android.os.Build;
import android.util.Pair;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.TiffUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncodedImage implements Closeable {
    public BytesRange mBytesRange;
    public ColorSpace mColorSpace;
    public int mExifOrientation = 0;
    public int mHeight = -1;
    public ImageFormat mImageFormat = ImageFormat.UNKNOWN;
    public final Supplier<FileInputStream> mInputStreamSupplier;
    public final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;
    public int mRotationAngle = -1;
    public int mSampleSize = 1;
    public int mStreamSize = -1;
    public int mWidth = -1;

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(CloseableReference.isValid(closeableReference));
        this.mPooledByteBufferRef = closeableReference.clone();
        this.mInputStreamSupplier = null;
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        EncodedImage encodedImage2 = null;
        if (encodedImage != null) {
            Supplier<FileInputStream> supplier = encodedImage.mInputStreamSupplier;
            if (supplier != null) {
                encodedImage2 = new EncodedImage(supplier, encodedImage.mStreamSize);
            } else {
                CloseableReference cloneOrNull = CloseableReference.cloneOrNull(encodedImage.mPooledByteBufferRef);
                if (cloneOrNull != null) {
                    try {
                        encodedImage2 = new EncodedImage(cloneOrNull);
                    } catch (Throwable th) {
                        CloseableReference.closeSafely(cloneOrNull);
                        throw th;
                    }
                }
                CloseableReference.closeSafely(cloneOrNull);
            }
            if (encodedImage2 != null) {
                encodedImage2.copyMetaDataFrom(encodedImage);
            }
        }
        return encodedImage2;
    }

    public static void closeSafely(EncodedImage encodedImage) {
        if (encodedImage != null) {
            CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
        }
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        encodedImage.parseMetaDataIfNeeded();
        this.mImageFormat = encodedImage.mImageFormat;
        encodedImage.parseMetaDataIfNeeded();
        this.mWidth = encodedImage.mWidth;
        encodedImage.parseMetaDataIfNeeded();
        this.mHeight = encodedImage.mHeight;
        this.mRotationAngle = encodedImage.getRotationAngle();
        encodedImage.parseMetaDataIfNeeded();
        this.mExifOrientation = encodedImage.mExifOrientation;
        this.mSampleSize = encodedImage.mSampleSize;
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.mBytesRange;
        encodedImage.parseMetaDataIfNeeded();
        this.mColorSpace = encodedImage.mColorSpace;
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public String getFirstBytesAsHexString(int i) {
        CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.read(0, bArr, 0, min);
            byteBufferRef.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i2 = 0; i2 < min; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    public InputStream getInputStream() {
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
        } finally {
            cloneOrNull.close();
        }
    }

    public int getRotationAngle() {
        parseMetaDataIfNeeded();
        return this.mRotationAngle;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference == null || closeableReference.get() == null) {
            return this.mStreamSize;
        }
        return this.mPooledByteBufferRef.get().size();
    }

    public synchronized boolean isValid() {
        return CloseableReference.isValid(this.mPooledByteBufferRef) || this.mInputStreamSupplier != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a2, code lost:
        if (r1 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x013b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x01ba A[SYNTHETIC, Splitter:B:120:0x01ba] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x015d A[Catch:{ IOException -> 0x0164 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x015e A[Catch:{ IOException -> 0x0164 }] */
    public void parseMetaData() {
        Pair<Integer, Integer> pair;
        int i;
        int readPackedInt;
        Throwable th;
        IOException e;
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = imageFormat_WrapIOException;
        boolean z = true;
        int i2 = 0;
        InputStream inputStream = null;
        if (DefaultImageFormats.isStaticWebpFormat(imageFormat_WrapIOException) || imageFormat_WrapIOException == DefaultImageFormats.WEBP_ANIMATED) {
            InputStream inputStream2 = getInputStream();
            byte[] bArr = new byte[4];
            try {
                inputStream2.read(bArr);
                if (AppCompatDelegateImpl.ConfigurationImplApi17.compare(bArr, "RIFF")) {
                    AppCompatDelegateImpl.ConfigurationImplApi17.getInt(inputStream2);
                    inputStream2.read(bArr);
                    if (AppCompatDelegateImpl.ConfigurationImplApi17.compare(bArr, "WEBP")) {
                        inputStream2.read(bArr);
                        StringBuilder sb = new StringBuilder();
                        for (int i3 = 0; i3 < 4; i3++) {
                            sb.append((char) bArr[i3]);
                        }
                        String sb2 = sb.toString();
                        if ("VP8 ".equals(sb2)) {
                            pair = AppCompatDelegateImpl.ConfigurationImplApi17.getVP8Dimension(inputStream2);
                        } else if ("VP8L".equals(sb2)) {
                            pair = AppCompatDelegateImpl.ConfigurationImplApi17.getVP8LDimension(inputStream2);
                        } else if ("VP8X".equals(sb2)) {
                            inputStream2.skip(8);
                            pair = new Pair<>(Integer.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.read3Bytes(inputStream2) + 1), Integer.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.read3Bytes(inputStream2) + 1));
                        }
                        try {
                            inputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                        }
                        if (pair != null) {
                            this.mWidth = ((Integer) pair.first).intValue();
                            this.mHeight = ((Integer) pair.second).intValue();
                        }
                    }
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            } catch (Throwable th2) {
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th2;
            }
            try {
                inputStream2.close();
                pair = null;
            } catch (IOException e5) {
                e = e5;
                pair = null;
            }
            if (pair != null) {
            }
        } else {
            try {
                InputStream inputStream3 = getInputStream();
                try {
                    ImageMetaData decodeDimensionsAndColorSpace = BitmapUtil.decodeDimensionsAndColorSpace(inputStream3);
                    this.mColorSpace = decodeDimensionsAndColorSpace.mColorSpace;
                    Pair<Integer, Integer> pair2 = decodeDimensionsAndColorSpace.mDimensions;
                    if (pair2 != null) {
                        this.mWidth = ((Integer) pair2.first).intValue();
                        this.mHeight = ((Integer) pair2.second).intValue();
                    }
                    try {
                        inputStream3.close();
                    } catch (IOException unused) {
                    }
                    pair = decodeDimensionsAndColorSpace.mDimensions;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                if (inputStream != null) {
                }
                throw th;
            }
        }
        if (imageFormat_WrapIOException == DefaultImageFormats.JPEG || this.mRotationAngle != -1) {
            if (imageFormat_WrapIOException == DefaultImageFormats.HEIF || this.mRotationAngle != -1) {
                this.mRotationAngle = 0;
            }
            InputStream inputStream4 = getInputStream();
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    i2 = new ExifInterface(inputStream4).getAttributeInt("Orientation", 1);
                } catch (IOException e6) {
                    if (((FLogDefaultLoggingDelegate) FLog.sHandler).isLoggable(3)) {
                        ((FLogDefaultLoggingDelegate) FLog.sHandler).println(3, "HeifExifUtil", "Failed reading Heif Exif orientation -> ignoring", e6);
                    }
                }
            } else {
                FLog.d("HeifExifUtil", "Trying to read Heif Exif information before Android N -> ignoring");
            }
            this.mExifOrientation = i2;
            this.mRotationAngle = AppCompatDelegateImpl.ConfigurationImplApi17.getAutoRotateAngleFromOrientation(i2);
            return;
        } else if (pair != null) {
            InputStream inputStream5 = getInputStream();
            if (inputStream5 != null) {
                while (true) {
                    try {
                        if (AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 1, false) != 255) {
                            break;
                        }
                        int i4 = 255;
                        while (i4 == 255) {
                            i4 = AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 1, false);
                        }
                        if (i4 == 225) {
                            break;
                        } else if (i4 != 216) {
                            if (i4 != 1) {
                                if (i4 == 217) {
                                    break;
                                } else if (i4 == 218) {
                                    break;
                                } else {
                                    inputStream5.skip((long) (AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 2, false) - 2));
                                }
                            }
                        }
                    } catch (IOException unused3) {
                    }
                }
                if (z && (readPackedInt = AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 2, false) - 2) > 6) {
                    int readPackedInt2 = AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 4, false);
                    int readPackedInt3 = AppCompatDelegateImpl.ConfigurationImplApi17.readPackedInt(inputStream5, 2, false);
                    i = (readPackedInt - 4) - 2;
                    if (readPackedInt2 == 1165519206 && readPackedInt3 == 0) {
                        if (i == 0) {
                            i2 = TiffUtil.readOrientationFromTIFF(inputStream5, i);
                        }
                        this.mExifOrientation = i2;
                        this.mRotationAngle = AppCompatDelegateImpl.ConfigurationImplApi17.getAutoRotateAngleFromOrientation(i2);
                        return;
                    }
                }
                i = 0;
                if (i == 0) {
                }
                this.mExifOrientation = i2;
                this.mRotationAngle = AppCompatDelegateImpl.ConfigurationImplApi17.getAutoRotateAngleFromOrientation(i2);
                return;
            }
            throw null;
        } else {
            return;
        }
        e.printStackTrace();
        if (pair != null) {
        }
        if (imageFormat_WrapIOException == DefaultImageFormats.JPEG) {
        }
        if (imageFormat_WrapIOException == DefaultImageFormats.HEIF) {
        }
        this.mRotationAngle = 0;
    }

    public final void parseMetaDataIfNeeded() {
        if (this.mWidth < 0 || this.mHeight < 0) {
            parseMetaData();
        }
    }

    public static boolean isValid(EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i) {
        if (supplier != null) {
            this.mPooledByteBufferRef = null;
            this.mInputStreamSupplier = supplier;
            this.mStreamSize = i;
            return;
        }
        throw null;
    }
}
