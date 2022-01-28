package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.os.Build;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

@TargetApi(21)
public abstract class DefaultDecoder implements PlatformDecoder {
    public static final byte[] EOI_TAIL = {-1, -39};
    public static final Class<?> TAG = DefaultDecoder.class;
    public final BitmapPool mBitmapPool;
    public final Pools$SynchronizedPool<ByteBuffer> mDecodeBuffers;
    public final PreverificationHelper mPreverificationHelper;

    public DefaultDecoder(BitmapPool bitmapPool, int i, Pools$SynchronizedPool pools$SynchronizedPool) {
        this.mPreverificationHelper = Build.VERSION.SDK_INT >= 26 ? new PreverificationHelper() : null;
        this.mBitmapPool = bitmapPool;
        this.mDecodeBuffers = pools$SynchronizedPool;
        for (int i2 = 0; i2 < i; i2++) {
            this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
        }
    }

    public static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.mSampleSize;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException();
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, ColorSpace colorSpace) {
        BitmapFactory.Options decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        boolean z = decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888;
        try {
            return decodeFromStream(encodedImage.getInputStream(), decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z) {
                return decodeFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, colorSpace);
            }
            throw e;
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:35:0x007f */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.graphics.Bitmap] */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        com.facebook.common.logging.FLog.e(com.facebook.imagepipeline.platform.DefaultDecoder.TAG, "Could not decode region %s, decoding full bitmap instead.", (java.lang.Object[]) new java.lang.Object[]{r11});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0095, code lost:
        if (r1 != null) goto L_0x0097;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0097, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009b, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x009c, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008a */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final CloseableReference<Bitmap> decodeFromStream(InputStream inputStream, BitmapFactory.Options options, Rect rect, ColorSpace colorSpace) {
        Bitmap bitmap;
        Bitmap bitmap2;
        BitmapRegionDecoder bitmapRegionDecoder;
        PreverificationHelper preverificationHelper;
        BitmapRegionDecoder bitmapRegionDecoder2 = null;
        if (inputStream != null) {
            int i = options.outWidth;
            int i2 = options.outHeight;
            if (rect != 0) {
                i = rect.width() / options.inSampleSize;
                i2 = rect.height() / options.inSampleSize;
            }
            boolean z = Build.VERSION.SDK_INT >= 26 && (preverificationHelper = this.mPreverificationHelper) != null && preverificationHelper.shouldUseHardwareBitmapConfig(options.inPreferredConfig);
            if (rect != 0 || !z) {
                if (rect != 0 && z) {
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                }
                bitmap = (Bitmap) this.mBitmapPool.get(getBitmapSize(i, i2, options));
                if (bitmap == null) {
                    throw new NullPointerException("BitmapPool.get returned null");
                }
            } else {
                options.inMutable = false;
                bitmap = null;
            }
            options.inBitmap = bitmap;
            if (Build.VERSION.SDK_INT >= 26) {
                if (colorSpace == null) {
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                }
                options.inPreferredColorSpace = colorSpace;
            }
            ByteBuffer acquire = this.mDecodeBuffers.acquire();
            if (acquire == null) {
                acquire = ByteBuffer.allocate(16384);
            }
            try {
                options.inTempStorage = acquire.array();
                if (!(rect == 0 || bitmap == null)) {
                    try {
                        bitmap.reconfigure(i, i2, options.inPreferredConfig);
                        bitmapRegionDecoder = BitmapRegionDecoder.newInstance(inputStream, true);
                        rect = bitmapRegionDecoder.decodeRegion(rect, options);
                        bitmapRegionDecoder.recycle();
                        bitmap2 = rect;
                    } catch (IOException unused) {
                        bitmapRegionDecoder = null;
                    } catch (Throwable th) {
                        Throwable th2 = th;
                        if (bitmapRegionDecoder2 != null) {
                            bitmapRegionDecoder2.recycle();
                        }
                        throw th2;
                    }
                    if (bitmap2 == null) {
                        bitmap2 = BitmapFactory.decodeStream(inputStream, null, options);
                    }
                    this.mDecodeBuffers.release(acquire);
                    if (bitmap != null || bitmap == bitmap2) {
                        return CloseableReference.of(bitmap2, this.mBitmapPool);
                    }
                    this.mBitmapPool.release(bitmap);
                    bitmap2.recycle();
                    throw new IllegalStateException();
                }
                bitmap2 = null;
                if (bitmap2 == null) {
                }
                this.mDecodeBuffers.release(acquire);
                if (bitmap != null) {
                }
                return CloseableReference.of(bitmap2, this.mBitmapPool);
            } catch (IllegalArgumentException e) {
                if (bitmap != null) {
                    this.mBitmapPool.release(bitmap);
                }
                try {
                    inputStream.reset();
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                    if (decodeStream != null) {
                        CloseableReference<Bitmap> of = CloseableReference.of(decodeStream, SimpleBitmapReleaser.getInstance());
                        this.mDecodeBuffers.release(acquire);
                        return of;
                    }
                    throw e;
                } catch (IOException unused2) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                if (bitmap != null) {
                    this.mBitmapPool.release(bitmap);
                }
                throw e2;
            } catch (Throwable th3) {
                this.mDecodeBuffers.release(acquire);
                throw th3;
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0058  */
    @Override // com.facebook.imagepipeline.platform.PlatformDecoder
    public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage encodedImage, Bitmap.Config config, Rect rect, int i, ColorSpace colorSpace) {
        boolean z;
        BitmapFactory.Options decodeOptionsForStream;
        boolean z2 = false;
        if (encodedImage.mImageFormat == DefaultImageFormats.JPEG && encodedImage.mInputStreamSupplier == null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(encodedImage.mPooledByteBufferRef);
            PooledByteBuffer pooledByteBuffer = encodedImage.mPooledByteBufferRef.get();
            if (!(pooledByteBuffer.read(i - 2) == -1 && pooledByteBuffer.read(i - 1) == -39)) {
                z = false;
                decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
                TailAppendingInputStream inputStream = encodedImage.getInputStream();
                AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(inputStream);
                if (encodedImage.getSize() > i) {
                    inputStream = new LimitedInputStream(inputStream, i);
                }
                if (!z) {
                    inputStream = new TailAppendingInputStream(inputStream, EOI_TAIL);
                }
                if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
                    z2 = true;
                }
                return decodeFromStream(inputStream, decodeOptionsForStream, rect, colorSpace);
            }
        }
        z = true;
        decodeOptionsForStream = getDecodeOptionsForStream(encodedImage, config);
        TailAppendingInputStream inputStream2 = encodedImage.getInputStream();
        AppCompatDelegateImpl.ConfigurationImplApi17.checkNotNull1(inputStream2);
        if (encodedImage.getSize() > i) {
        }
        if (!z) {
        }
        if (decodeOptionsForStream.inPreferredConfig != Bitmap.Config.ARGB_8888) {
        }
        try {
            return decodeFromStream(inputStream2, decodeOptionsForStream, rect, colorSpace);
        } catch (RuntimeException e) {
            if (z2) {
                return decodeJPEGFromEncodedImageWithColorSpace(encodedImage, Bitmap.Config.ARGB_8888, rect, i, colorSpace);
            }
            throw e;
        }
    }

    public abstract int getBitmapSize(int i, int i2, BitmapFactory.Options options);
}
