package com.facebook.imageformat;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ImageFormatChecker {
    public static ImageFormatChecker sInstance;
    public List<ImageFormat.FormatChecker> mCustomImageFormatCheckers;
    public final ImageFormat.FormatChecker mDefaultFormatChecker = new DefaultImageFormatChecker();
    public int mMaxHeaderLength;

    public ImageFormatChecker() {
        updateMaxHeaderLength();
    }

    public static ImageFormat getImageFormat(InputStream inputStream) throws IOException {
        int i;
        ImageFormatChecker instance = getInstance();
        if (inputStream != null) {
            int i2 = instance.mMaxHeaderLength;
            byte[] bArr = new byte[i2];
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i2 >= i2);
            if (inputStream.markSupported()) {
                try {
                    inputStream.mark(i2);
                    i = AppCompatDelegateImpl.ConfigurationImplApi17.read(inputStream, bArr, 0, i2);
                } finally {
                    inputStream.reset();
                }
            } else {
                i = AppCompatDelegateImpl.ConfigurationImplApi17.read(inputStream, bArr, 0, i2);
            }
            ImageFormat determineFormat = instance.mDefaultFormatChecker.determineFormat(bArr, i);
            if (!(determineFormat == null || determineFormat == ImageFormat.UNKNOWN)) {
                return determineFormat;
            }
            List<ImageFormat.FormatChecker> list = instance.mCustomImageFormatCheckers;
            if (list != null) {
                for (ImageFormat.FormatChecker formatChecker : list) {
                    ImageFormat determineFormat2 = formatChecker.determineFormat(bArr, i);
                    if (!(determineFormat2 == null || determineFormat2 == ImageFormat.UNKNOWN)) {
                        return determineFormat2;
                    }
                }
            }
            return ImageFormat.UNKNOWN;
        }
        throw null;
    }

    public static ImageFormat getImageFormat_WrapIOException(InputStream inputStream) {
        try {
            return getImageFormat(inputStream);
        } catch (IOException e) {
            AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(e);
            throw new RuntimeException(e);
        }
    }

    public static synchronized ImageFormatChecker getInstance() {
        ImageFormatChecker imageFormatChecker;
        synchronized (ImageFormatChecker.class) {
            if (sInstance == null) {
                sInstance = new ImageFormatChecker();
            }
            imageFormatChecker = sInstance;
        }
        return imageFormatChecker;
    }

    public final void updateMaxHeaderLength() {
        this.mMaxHeaderLength = this.mDefaultFormatChecker.getHeaderSize();
        List<ImageFormat.FormatChecker> list = this.mCustomImageFormatCheckers;
        if (list != null) {
            for (ImageFormat.FormatChecker formatChecker : list) {
                this.mMaxHeaderLength = Math.max(this.mMaxHeaderLength, formatChecker.getHeaderSize());
            }
        }
    }
}
