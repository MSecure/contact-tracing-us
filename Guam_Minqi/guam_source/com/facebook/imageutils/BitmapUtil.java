package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.Pair;
import androidx.core.util.Pools$SynchronizedPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class BitmapUtil {
    public static final Pools$SynchronizedPool<ByteBuffer> DECODE_BUFFERS = new Pools$SynchronizedPool<>(12);

    /* renamed from: com.facebook.imageutils.BitmapUtil$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = iArr;
            iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 4;
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGBA_F16.ordinal()] = 5;
        }
    }

    public static Pair<Integer, Integer> decodeDimensions(InputStream inputStream) {
        ByteBuffer acquire = DECODE_BUFFERS.acquire();
        if (acquire == null) {
            acquire = ByteBuffer.allocate(16384);
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            options.inTempStorage = acquire.array();
            Pair<Integer, Integer> pair = null;
            BitmapFactory.decodeStream(inputStream, null, options);
            if (options.outWidth != -1) {
                if (options.outHeight != -1) {
                    pair = new Pair<>(Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                }
            }
            return pair;
        } finally {
            DECODE_BUFFERS.release(acquire);
        }
    }

    public static ImageMetaData decodeDimensionsAndColorSpace(InputStream inputStream) {
        ColorSpace colorSpace = null;
        if (inputStream != null) {
            ByteBuffer acquire = DECODE_BUFFERS.acquire();
            if (acquire == null) {
                acquire = ByteBuffer.allocate(16384);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            try {
                options.inTempStorage = acquire.array();
                BitmapFactory.decodeStream(inputStream, null, options);
                if (Build.VERSION.SDK_INT >= 26) {
                    colorSpace = options.outColorSpace;
                }
                return new ImageMetaData(options.outWidth, options.outHeight, colorSpace);
            } finally {
                DECODE_BUFFERS.release(acquire);
            }
        } else {
            throw null;
        }
    }

    public static int getPixelSizeForBitmapConfig(Bitmap.Config config) {
        int i = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()];
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3 || i == 4) {
            return 2;
        }
        if (i == 5) {
            return 8;
        }
        throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
    }

    public static int getSizeInByteForBitmap(int i, int i2, Bitmap.Config config) {
        return getPixelSizeForBitmapConfig(config) * i * i2;
    }

    @SuppressLint({"NewApi"})
    public static int getSizeInBytes(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        try {
            return bitmap.getAllocationByteCount();
        } catch (NullPointerException unused) {
            return bitmap.getByteCount();
        }
    }
}
