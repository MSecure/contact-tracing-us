package com.facebook.imageformat;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.webp.WebpSupportStatus;
import com.facebook.imageformat.ImageFormat;

public class DefaultImageFormatChecker implements ImageFormat.FormatChecker {
    public static final byte[] BMP_HEADER;
    public static final int BMP_HEADER_LENGTH;
    public static final byte[] GIF_HEADER_87A = AppCompatDelegateImpl.ConfigurationImplApi17.asciiBytes("GIF87a");
    public static final byte[] GIF_HEADER_89A = AppCompatDelegateImpl.ConfigurationImplApi17.asciiBytes("GIF89a");
    public static final int HEIF_HEADER_LENGTH;
    public static final String[] HEIF_HEADER_SUFFIXES = {"heic", "heix", "hevc", "hevx", "mif1", "msf1"};
    public static final byte[] ICO_HEADER;
    public static final int ICO_HEADER_LENGTH;
    public static final byte[] JPEG_HEADER;
    public static final int JPEG_HEADER_LENGTH;
    public static final byte[] PNG_HEADER;
    public static final int PNG_HEADER_LENGTH;
    public final int MAX_HEADER_LENGTH;

    static {
        byte[] bArr = {-1, -40, -1};
        JPEG_HEADER = bArr;
        JPEG_HEADER_LENGTH = bArr.length;
        byte[] bArr2 = {-119, 80, 78, 71, 13, 10, 26, 10};
        PNG_HEADER = bArr2;
        PNG_HEADER_LENGTH = bArr2.length;
        byte[] asciiBytes = AppCompatDelegateImpl.ConfigurationImplApi17.asciiBytes("BM");
        BMP_HEADER = asciiBytes;
        BMP_HEADER_LENGTH = asciiBytes.length;
        byte[] bArr3 = {0, 0, 1, 0};
        ICO_HEADER = bArr3;
        ICO_HEADER_LENGTH = bArr3.length;
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("ftyp");
        outline17.append(HEIF_HEADER_SUFFIXES[0]);
        HEIF_HEADER_LENGTH = AppCompatDelegateImpl.ConfigurationImplApi17.asciiBytes(outline17.toString()).length;
    }

    public DefaultImageFormatChecker() {
        int[] iArr = {21, 20, JPEG_HEADER_LENGTH, PNG_HEADER_LENGTH, 6, BMP_HEADER_LENGTH, ICO_HEADER_LENGTH, HEIF_HEADER_LENGTH};
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(true);
        int i = iArr[0];
        for (int i2 = 1; i2 < 8; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        this.MAX_HEADER_LENGTH = i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0146 A[LOOP:0: B:84:0x00f0->B:108:0x0146, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0144 A[SYNTHETIC] */
    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public final ImageFormat determineFormat(byte[] bArr, int i) {
        boolean z;
        boolean z2;
        int i2;
        int i3 = 0;
        if (WebpSupportStatus.isWebpHeader(bArr, 0, i)) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(WebpSupportStatus.isWebpHeader(bArr, 0, i));
            if (WebpSupportStatus.matchBytePattern(bArr, 12, WebpSupportStatus.WEBP_VP8_BYTES)) {
                return DefaultImageFormats.WEBP_SIMPLE;
            }
            if (WebpSupportStatus.matchBytePattern(bArr, 12, WebpSupportStatus.WEBP_VP8L_BYTES)) {
                return DefaultImageFormats.WEBP_LOSSLESS;
            }
            if (!(i >= 21 && WebpSupportStatus.matchBytePattern(bArr, 12, WebpSupportStatus.WEBP_VP8X_BYTES))) {
                return ImageFormat.UNKNOWN;
            }
            if (WebpSupportStatus.matchBytePattern(bArr, 12, WebpSupportStatus.WEBP_VP8X_BYTES) && ((bArr[20] & 2) == 2)) {
                return DefaultImageFormats.WEBP_ANIMATED;
            }
            boolean matchBytePattern = WebpSupportStatus.matchBytePattern(bArr, 12, WebpSupportStatus.WEBP_VP8X_BYTES);
            boolean z3 = (bArr[20] & 16) == 16;
            if (matchBytePattern && z3) {
                i3 = 1;
            }
            if (i3 != 0) {
                return DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA;
            }
            return DefaultImageFormats.WEBP_EXTENDED;
        }
        byte[] bArr2 = JPEG_HEADER;
        if (i >= bArr2.length && AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, bArr2)) {
            return DefaultImageFormats.JPEG;
        }
        byte[] bArr3 = PNG_HEADER;
        if (i >= bArr3.length && AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, bArr3)) {
            return DefaultImageFormats.PNG;
        }
        if (i >= 6 && (AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, GIF_HEADER_87A) || AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, GIF_HEADER_89A))) {
            return DefaultImageFormats.GIF;
        }
        byte[] bArr4 = BMP_HEADER;
        if (i < bArr4.length) {
            z = false;
        } else {
            z = AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, bArr4);
        }
        if (z) {
            return DefaultImageFormats.BMP;
        }
        byte[] bArr5 = ICO_HEADER;
        if (i < bArr5.length) {
            z2 = false;
        } else {
            z2 = AppCompatDelegateImpl.ConfigurationImplApi17.startsWithPattern(bArr, bArr5);
        }
        if (z2) {
            return DefaultImageFormats.ICO;
        }
        if (i >= HEIF_HEADER_LENGTH && bArr[3] >= 8) {
            String[] strArr = HEIF_HEADER_SUFFIXES;
            int length = strArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    i3 = 0;
                    break;
                }
                String str = strArr[i4];
                int length2 = bArr.length;
                byte[] asciiBytes = AppCompatDelegateImpl.ConfigurationImplApi17.asciiBytes("ftyp" + str);
                int i5 = HEIF_HEADER_LENGTH;
                if (asciiBytes != null) {
                    if (i5 <= length2) {
                        byte b = asciiBytes[i3];
                        int i6 = length2 - i5;
                        i2 = i3;
                        while (true) {
                            if (i2 > i6) {
                                break;
                            }
                            if (bArr[i2] != b) {
                                do {
                                    i2++;
                                    if (i2 > i6) {
                                        break;
                                    }
                                } while (bArr[i2] != b);
                            }
                            if (i2 <= i6) {
                                int i7 = i2 + 1;
                                int i8 = (i7 + i5) - 1;
                                int i9 = 1;
                                while (i7 < i8 && bArr[i7] == asciiBytes[i9]) {
                                    i7++;
                                    i9++;
                                }
                                if (i7 == i8) {
                                    break;
                                }
                            }
                            i2++;
                        }
                        if (i2 <= -1) {
                            i3 = 1;
                            break;
                        }
                        i4++;
                        i3 = 0;
                    }
                    i2 = -1;
                    if (i2 <= -1) {
                    }
                } else {
                    throw null;
                }
            }
        }
        if (i3 != 0) {
            return DefaultImageFormats.HEIF;
        }
        return ImageFormat.UNKNOWN;
    }

    @Override // com.facebook.imageformat.ImageFormat.FormatChecker
    public int getHeaderSize() {
        return this.MAX_HEADER_LENGTH;
    }
}
