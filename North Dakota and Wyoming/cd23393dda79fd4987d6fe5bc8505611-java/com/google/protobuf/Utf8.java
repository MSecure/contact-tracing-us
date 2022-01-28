package com.google.protobuf;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

/* access modifiers changed from: package-private */
public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = ((!UnsafeProcessor.isAvailable() || Android.isOnAndroidDevice()) ? new SafeProcessor() : new UnsafeProcessor());

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return processor.isValidUtf8(bArr, 0, bArr.length);
    }

    public static boolean isValidUtf8(byte[] bArr, int i, int i2) {
        return processor.isValidUtf8(bArr, i, i2);
    }

    public static int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
        return processor.partialIsValidUtf8(i, bArr, i2, i3);
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(byte[] bArr, int i, int i2) {
        byte b = bArr[i - 1];
        int i3 = i2 - i;
        if (i3 == 0) {
            return incompleteStateFor(b);
        }
        if (i3 == 1) {
            return incompleteStateFor(b, bArr[i]);
        }
        if (i3 == 2) {
            return incompleteStateFor(b, bArr[i], bArr[i + 1]);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: private */
    public static int incompleteStateFor(ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (i3 == 0) {
            return incompleteStateFor(i);
        }
        if (i3 == 1) {
            return incompleteStateFor(i, byteBuffer.get(i2));
        }
        if (i3 == 2) {
            return incompleteStateFor(i, byteBuffer.get(i2), byteBuffer.get(i2 + 1));
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public static class UnpairedSurrogateException extends IllegalArgumentException {
        UnpairedSurrogateException(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) < 128) {
            i++;
        }
        int i2 = length;
        while (true) {
            if (i < length) {
                char charAt = charSequence.charAt(i);
                if (charAt >= 2048) {
                    i2 += encodedLengthGeneral(charSequence, i);
                    break;
                }
                i2 += (127 - charAt) >>> 31;
                i++;
            } else {
                break;
            }
        }
        if (i2 >= length) {
            return i2;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i2) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 2048) {
                i2 += (127 - charAt) >>> 31;
            } else {
                i2 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i) >= 65536) {
                        i++;
                    } else {
                        throw new UnpairedSurrogateException(i, length);
                    }
                }
            }
            i++;
        }
        return i2;
    }

    static int encode(CharSequence charSequence, byte[] bArr, int i, int i2) {
        return processor.encodeUtf8(charSequence, bArr, i, i2);
    }

    static boolean isValidUtf8(ByteBuffer byteBuffer) {
        return processor.isValidUtf8(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    static int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
        return processor.partialIsValidUtf8(i, byteBuffer, i2, i3);
    }

    static String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(byteBuffer, i, i2);
    }

    static String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
        return processor.decodeUtf8(bArr, i, i2);
    }

    static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    /* access modifiers changed from: private */
    public static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int i, int i2) {
        int i3 = i2 - 7;
        int i4 = i;
        while (i4 < i3 && (byteBuffer.getLong(i4) & ASCII_MASK_LONG) == 0) {
            i4 += 8;
        }
        return i4 - i;
    }

    /* access modifiers changed from: package-private */
    public static abstract class Processor {
        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public abstract String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException;

        /* access modifiers changed from: package-private */
        public abstract int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2);

        /* access modifiers changed from: package-private */
        public abstract void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer);

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3);

        /* access modifiers changed from: package-private */
        public abstract int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3);

        Processor() {
        }

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(byte[] bArr, int i, int i2) {
            return partialIsValidUtf8(0, bArr, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        public final boolean isValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            return partialIsValidUtf8(0, byteBuffer, i, i2) == 0;
        }

        /* access modifiers changed from: package-private */
        public final int partialIsValidUtf8(int i, ByteBuffer byteBuffer, int i2, int i3) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                return partialIsValidUtf8(i, byteBuffer.array(), i2 + arrayOffset, arrayOffset + i3);
            } else if (byteBuffer.isDirect()) {
                return partialIsValidUtf8Direct(i, byteBuffer, i2, i3);
            } else {
                return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x004c, code lost:
            if (r8.get(r9) > -65) goto L_0x004e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x008b, code lost:
            if (r8.get(r9) > -65) goto L_0x008d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
            if (r8.get(r9) > -65) goto L_0x001d;
         */
        public final int partialIsValidUtf8Default(int i, ByteBuffer byteBuffer, int i2, int i3) {
            int i4;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b = (byte) i;
                if (b < -32) {
                    if (b >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b < -16) {
                    byte b2 = (byte) (~(i >> 8));
                    if (b2 == 0) {
                        int i5 = i2 + 1;
                        byte b3 = byteBuffer.get(i2);
                        if (i5 >= i3) {
                            return Utf8.incompleteStateFor(b, b3);
                        }
                        i2 = i5;
                        b2 = b3;
                    }
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) (~(i >> 8));
                    byte b5 = 0;
                    if (b4 == 0) {
                        int i6 = i2 + 1;
                        b4 = byteBuffer.get(i2);
                        if (i6 >= i3) {
                            return Utf8.incompleteStateFor(b, b4);
                        }
                        i2 = i6;
                    } else {
                        b5 = (byte) (i >> 16);
                    }
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = byteBuffer.get(i2);
                        if (i7 >= i3) {
                            return Utf8.incompleteStateFor(b, b4, b5);
                        }
                        i2 = i7;
                    }
                    if (b4 <= -65 && (((b << Ascii.FS) + (b4 + 112)) >> 30) == 0 && b5 <= -65) {
                        i4 = i2 + 1;
                    }
                    return -1;
                }
                i2 = i4;
            }
            return partialIsValidUtf8(byteBuffer, i2, i3);
        }

        private static int partialIsValidUtf8(ByteBuffer byteBuffer, int i, int i2) {
            int estimateConsecutiveAscii = i + Utf8.estimateConsecutiveAscii(byteBuffer, i, i2);
            while (estimateConsecutiveAscii < i2) {
                int i3 = estimateConsecutiveAscii + 1;
                byte b = byteBuffer.get(estimateConsecutiveAscii);
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b < -62 || byteBuffer.get(i3) > -65) {
                            return -1;
                        }
                        i3++;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                        }
                        int i4 = i3 + 1;
                        byte b2 = byteBuffer.get(i3);
                        if (b2 > -65 || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || byteBuffer.get(i4) > -65))) {
                            return -1;
                        }
                        estimateConsecutiveAscii = i4 + 1;
                    } else if (i3 >= i2 - 2) {
                        return Utf8.incompleteStateFor(byteBuffer, b, i3, i2 - i3);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = byteBuffer.get(i3);
                        if (b3 <= -65 && (((b << Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (byteBuffer.get(i5) <= -65) {
                                i3 = i6 + 1;
                                if (byteBuffer.get(i6) > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                estimateConsecutiveAscii = i3;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        public final String decodeUtf8(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if (byteBuffer.hasArray()) {
                return decodeUtf8(byteBuffer.array(), byteBuffer.arrayOffset() + i, i2);
            } else if (byteBuffer.isDirect()) {
                return decodeUtf8Direct(byteBuffer, i, i2);
            } else {
                return decodeUtf8Default(byteBuffer, i, i2);
            }
        }

        /* access modifiers changed from: package-private */
        public final String decodeUtf8Default(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = byteBuffer.get(i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = byteBuffer.get(i);
                    if (DecodeUtil.isOneByte(b2)) {
                        int i7 = i5 + 1;
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        while (i6 < i3) {
                            byte b3 = byteBuffer.get(i6);
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                        i = i6;
                        i5 = i7;
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i6 < i3) {
                            DecodeUtil.handleTwoBytes(b2, byteBuffer.get(i6), cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, byteBuffer.get(i6), byteBuffer.get(i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        byte b4 = byteBuffer.get(i6);
                        int i10 = i9 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, byteBuffer.get(i9), byteBuffer.get(i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* access modifiers changed from: package-private */
        public final void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                int arrayOffset = byteBuffer.arrayOffset();
                byteBuffer.position(Utf8.encode(charSequence, byteBuffer.array(), byteBuffer.position() + arrayOffset, byteBuffer.remaining()) - arrayOffset);
            } else if (byteBuffer.isDirect()) {
                encodeUtf8Direct(charSequence, byteBuffer);
            } else {
                encodeUtf8Default(charSequence, byteBuffer);
            }
        }

        /* access modifiers changed from: package-private */
        public final void encodeUtf8Default(CharSequence charSequence, ByteBuffer byteBuffer) {
            int length = charSequence.length();
            int position = byteBuffer.position();
            int i = 0;
            while (i < length) {
                try {
                    char charAt = charSequence.charAt(i);
                    if (charAt >= 128) {
                        break;
                    }
                    byteBuffer.put(position + i, (byte) charAt);
                    i++;
                } catch (IndexOutOfBoundsException unused) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                }
            }
            if (i == length) {
                byteBuffer.position(position + i);
                return;
            }
            position += i;
            while (i < length) {
                char charAt2 = charSequence.charAt(i);
                if (charAt2 < 128) {
                    byteBuffer.put(position, (byte) charAt2);
                } else if (charAt2 < 2048) {
                    int i2 = position + 1;
                    try {
                        byteBuffer.put(position, (byte) ((charAt2 >>> 6) | 192));
                        byteBuffer.put(i2, (byte) ((charAt2 & '?') | 128));
                        position = i2;
                    } catch (IndexOutOfBoundsException unused2) {
                        position = i2;
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                    }
                } else if (charAt2 < 55296 || 57343 < charAt2) {
                    int i3 = position + 1;
                    byteBuffer.put(position, (byte) ((charAt2 >>> '\f') | 224));
                    position = i3 + 1;
                    byteBuffer.put(i3, (byte) (((charAt2 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt2 & '?') | 128));
                } else {
                    int i4 = i + 1;
                    if (i4 != length) {
                        try {
                            char charAt3 = charSequence.charAt(i4);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i5 = position + 1;
                                try {
                                    byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                    int i6 = i5 + 1;
                                    byteBuffer.put(i5, (byte) (((codePoint >>> 12) & 63) | 128));
                                    int i7 = i6 + 1;
                                    byteBuffer.put(i6, (byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put(i7, (byte) ((codePoint & 63) | 128));
                                    position = i7;
                                    i = i4;
                                } catch (IndexOutOfBoundsException unused3) {
                                    position = i5;
                                    i = i4;
                                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                                }
                            } else {
                                i = i4;
                            }
                        } catch (IndexOutOfBoundsException unused4) {
                            i = i4;
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(i) + " at index " + (byteBuffer.position() + Math.max(i, (position - byteBuffer.position()) + 1)));
                        }
                    }
                    throw new UnpairedSurrogateException(i, length);
                }
                i++;
                position++;
            }
            byteBuffer.position(position);
        }
    }

    static final class SafeProcessor extends Processor {
        SafeProcessor() {
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0046, code lost:
            if (r8[r9] > -65) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x007f, code lost:
            if (r8[r9] > -65) goto L_0x0081;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            if (r8[r9] > -65) goto L_0x001b;
         */
        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
            int i4;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b = (byte) i;
                if (b < -32) {
                    if (b >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b < -16) {
                    byte b2 = (byte) (~(i >> 8));
                    if (b2 == 0) {
                        int i5 = i2 + 1;
                        byte b3 = bArr[i2];
                        if (i5 >= i3) {
                            return Utf8.incompleteStateFor(b, b3);
                        }
                        i2 = i5;
                        b2 = b3;
                    }
                    if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b4 = (byte) (~(i >> 8));
                    byte b5 = 0;
                    if (b4 == 0) {
                        int i6 = i2 + 1;
                        b4 = bArr[i2];
                        if (i6 >= i3) {
                            return Utf8.incompleteStateFor(b, b4);
                        }
                        i2 = i6;
                    } else {
                        b5 = (byte) (i >> 16);
                    }
                    if (b5 == 0) {
                        int i7 = i2 + 1;
                        b5 = bArr[i2];
                        if (i7 >= i3) {
                            return Utf8.incompleteStateFor(b, b4, b5);
                        }
                        i2 = i7;
                    }
                    if (b4 <= -65 && (((b << Ascii.FS) + (b4 + 112)) >> 30) == 0 && b5 <= -65) {
                        i4 = i2 + 1;
                    }
                    return -1;
                }
                i2 = i4;
            }
            return partialIsValidUtf8(bArr, i2, i3);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            return partialIsValidUtf8Default(i, byteBuffer, i2, i3);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = bArr[i];
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = bArr[i];
                    if (DecodeUtil.isOneByte(b2)) {
                        int i7 = i5 + 1;
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        while (i6 < i3) {
                            byte b3 = bArr[i6];
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                        i = i6;
                        i5 = i7;
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i6 < i3) {
                            DecodeUtil.handleTwoBytes(b2, bArr[i6], cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, bArr[i6], bArr[i8], cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        byte b4 = bArr[i6];
                        int i10 = i9 + 1;
                        DecodeUtil.handleFourBytes(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            return decodeUtf8Default(byteBuffer, i, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i2 + i;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            if (i7 == length) {
                return i + length;
            }
            int i8 = i + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 < 128 && i8 < i6) {
                    i4 = i8 + 1;
                    bArr[i8] = (byte) charAt2;
                } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                    int i9 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                    i8 = i9 + 1;
                    bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | 128);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | 128);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new UnpairedSurrogateException(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new UnpairedSurrogateException(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            encodeUtf8Default(charSequence, byteBuffer);
        }

        private static int partialIsValidUtf8(byte[] bArr, int i, int i2) {
            while (i < i2 && bArr[i] >= 0) {
                i++;
            }
            if (i >= i2) {
                return 0;
            }
            return partialIsValidUtf8NonAscii(bArr, i, i2);
        }

        private static int partialIsValidUtf8NonAscii(byte[] bArr, int i, int i2) {
            while (i < i2) {
                int i3 = i + 1;
                byte b = bArr[i];
                if (b < 0) {
                    if (b < -32) {
                        if (i3 >= i2) {
                            return b;
                        }
                        if (b >= -62) {
                            i = i3 + 1;
                            if (bArr[i3] > -65) {
                            }
                        }
                        return -1;
                    } else if (b < -16) {
                        if (i3 >= i2 - 1) {
                            return Utf8.incompleteStateFor(bArr, i3, i2);
                        }
                        int i4 = i3 + 1;
                        byte b2 = bArr[i3];
                        if (b2 <= -65 && ((b != -32 || b2 >= -96) && (b != -19 || b2 < -96))) {
                            i = i4 + 1;
                            if (bArr[i4] > -65) {
                            }
                        }
                        return -1;
                    } else if (i3 >= i2 - 2) {
                        return Utf8.incompleteStateFor(bArr, i3, i2);
                    } else {
                        int i5 = i3 + 1;
                        byte b3 = bArr[i3];
                        if (b3 <= -65 && (((b << Ascii.FS) + (b3 + 112)) >> 30) == 0) {
                            int i6 = i5 + 1;
                            if (bArr[i5] <= -65) {
                                i3 = i6 + 1;
                                if (bArr[i6] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i = i3;
            }
            return 0;
        }
    }

    static final class UnsafeProcessor extends Processor {
        UnsafeProcessor() {
        }

        static boolean isAvailable() {
            return UnsafeUtil.hasUnsafeArrayOperations() && UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0059, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x009e, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r13, r2) > -65) goto L_0x00a0;
         */
        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int i, byte[] bArr, int i2, int i3) {
            long j;
            byte b = 0;
            if ((i2 | i3 | (bArr.length - i3)) >= 0) {
                long j2 = (long) i2;
                long j3 = (long) i3;
                if (i != 0) {
                    if (j2 >= j3) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 < -32) {
                        if (b2 >= -62) {
                            long j4 = 1 + j2;
                            if (UnsafeUtil.getByte(bArr, j2) <= -65) {
                                j2 = j4;
                            }
                        }
                        return -1;
                    }
                    if (b2 < -16) {
                        byte b3 = (byte) (~(i >> 8));
                        if (b3 == 0) {
                            long j5 = j2 + 1;
                            b3 = UnsafeUtil.getByte(bArr, j2);
                            if (j5 >= j3) {
                                return Utf8.incompleteStateFor(b2, b3);
                            }
                            j2 = j5;
                        }
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            j = j2 + 1;
                        }
                        return -1;
                    }
                    byte b4 = (byte) (~(i >> 8));
                    if (b4 == 0) {
                        long j6 = j2 + 1;
                        b4 = UnsafeUtil.getByte(bArr, j2);
                        if (j6 >= j3) {
                            return Utf8.incompleteStateFor(b2, b4);
                        }
                        j2 = j6;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    if (b == 0) {
                        long j7 = j2 + 1;
                        b = UnsafeUtil.getByte(bArr, j2);
                        if (j7 >= j3) {
                            return Utf8.incompleteStateFor(b2, b4, b);
                        }
                        j2 = j7;
                    }
                    if (b4 <= -65 && (((b2 << Ascii.FS) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                        j = j2 + 1;
                    }
                    return -1;
                    j2 = j;
                }
                return partialIsValidUtf8(bArr, j2, (int) (j3 - j2));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0063, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x0068;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00a8, code lost:
            if (com.google.protobuf.UnsafeUtil.getByte(r2) > -65) goto L_0x00aa;
         */
        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int i, ByteBuffer byteBuffer, int i2, int i3) {
            long j;
            byte b = 0;
            if ((i2 | i3 | (byteBuffer.limit() - i3)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i2);
                long j2 = ((long) (i3 - i2)) + addressOffset;
                if (i != 0) {
                    if (addressOffset >= j2) {
                        return i;
                    }
                    byte b2 = (byte) i;
                    if (b2 < -32) {
                        if (b2 >= -62) {
                            long j3 = 1 + addressOffset;
                            if (UnsafeUtil.getByte(addressOffset) <= -65) {
                                addressOffset = j3;
                            }
                        }
                        return -1;
                    }
                    if (b2 < -16) {
                        byte b3 = (byte) (~(i >> 8));
                        if (b3 == 0) {
                            long j4 = addressOffset + 1;
                            b3 = UnsafeUtil.getByte(addressOffset);
                            if (j4 >= j2) {
                                return Utf8.incompleteStateFor(b2, b3);
                            }
                            addressOffset = j4;
                        }
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            j = addressOffset + 1;
                        }
                        return -1;
                    }
                    byte b4 = (byte) (~(i >> 8));
                    if (b4 == 0) {
                        long j5 = addressOffset + 1;
                        b4 = UnsafeUtil.getByte(addressOffset);
                        if (j5 >= j2) {
                            return Utf8.incompleteStateFor(b2, b4);
                        }
                        addressOffset = j5;
                    } else {
                        b = (byte) (i >> 16);
                    }
                    if (b == 0) {
                        long j6 = addressOffset + 1;
                        b = UnsafeUtil.getByte(addressOffset);
                        if (j6 >= j2) {
                            return Utf8.incompleteStateFor(b2, b4, b);
                        }
                        addressOffset = j6;
                    }
                    if (b4 <= -65 && (((b2 << Ascii.FS) + (b4 + 112)) >> 30) == 0 && b <= -65) {
                        j = addressOffset + 1;
                    }
                    return -1;
                    addressOffset = j;
                }
                return partialIsValidUtf8(addressOffset, (int) (j2 - addressOffset));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b = UnsafeUtil.getByte(bArr, (long) i);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    i++;
                    DecodeUtil.handleOneByte(b, cArr, i4);
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b2 = UnsafeUtil.getByte(bArr, (long) i);
                    if (DecodeUtil.isOneByte(b2)) {
                        int i7 = i5 + 1;
                        DecodeUtil.handleOneByte(b2, cArr, i5);
                        while (i6 < i3) {
                            byte b3 = UnsafeUtil.getByte(bArr, (long) i6);
                            if (!DecodeUtil.isOneByte(b3)) {
                                break;
                            }
                            i6++;
                            DecodeUtil.handleOneByte(b3, cArr, i7);
                            i7++;
                        }
                        i = i6;
                        i5 = i7;
                    } else if (DecodeUtil.isTwoBytes(b2)) {
                        if (i6 < i3) {
                            DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(bArr, (long) i6), cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (DecodeUtil.isThreeBytes(b2)) {
                        if (i6 < i3 - 1) {
                            int i8 = i6 + 1;
                            DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(bArr, (long) i6), UnsafeUtil.getByte(bArr, (long) i8), cArr, i5);
                            i = i8 + 1;
                            i5++;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    } else if (i6 < i3 - 2) {
                        int i9 = i6 + 1;
                        int i10 = i9 + 1;
                        DecodeUtil.handleFourBytes(b2, UnsafeUtil.getByte(bArr, (long) i6), UnsafeUtil.getByte(bArr, (long) i9), UnsafeUtil.getByte(bArr, (long) i10), cArr, i5);
                        i = i10 + 1;
                        i5 = i5 + 1 + 1;
                    } else {
                        throw InvalidProtocolBufferException.invalidUtf8();
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.Utf8.Processor
        public String decodeUtf8Direct(ByteBuffer byteBuffer, int i, int i2) throws InvalidProtocolBufferException {
            if ((i | i2 | ((byteBuffer.limit() - i) - i2)) >= 0) {
                long addressOffset = UnsafeUtil.addressOffset(byteBuffer) + ((long) i);
                long j = ((long) i2) + addressOffset;
                char[] cArr = new char[i2];
                int i3 = 0;
                while (addressOffset < j) {
                    byte b = UnsafeUtil.getByte(addressOffset);
                    if (!DecodeUtil.isOneByte(b)) {
                        break;
                    }
                    addressOffset++;
                    DecodeUtil.handleOneByte(b, cArr, i3);
                    i3++;
                }
                while (true) {
                    int i4 = i3;
                    while (addressOffset < j) {
                        long j2 = addressOffset + 1;
                        byte b2 = UnsafeUtil.getByte(addressOffset);
                        if (DecodeUtil.isOneByte(b2)) {
                            int i5 = i4 + 1;
                            DecodeUtil.handleOneByte(b2, cArr, i4);
                            while (j2 < j) {
                                byte b3 = UnsafeUtil.getByte(j2);
                                if (!DecodeUtil.isOneByte(b3)) {
                                    break;
                                }
                                j2++;
                                DecodeUtil.handleOneByte(b3, cArr, i5);
                                i5++;
                            }
                            i4 = i5;
                            addressOffset = j2;
                        } else if (DecodeUtil.isTwoBytes(b2)) {
                            if (j2 < j) {
                                addressOffset = j2 + 1;
                                DecodeUtil.handleTwoBytes(b2, UnsafeUtil.getByte(j2), cArr, i4);
                                i4++;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (DecodeUtil.isThreeBytes(b2)) {
                            if (j2 < j - 1) {
                                long j3 = j2 + 1;
                                DecodeUtil.handleThreeBytes(b2, UnsafeUtil.getByte(j2), UnsafeUtil.getByte(j3), cArr, i4);
                                i4++;
                                addressOffset = j3 + 1;
                            } else {
                                throw InvalidProtocolBufferException.invalidUtf8();
                            }
                        } else if (j2 < j - 2) {
                            long j4 = j2 + 1;
                            byte b4 = UnsafeUtil.getByte(j2);
                            long j5 = j4 + 1;
                            byte b5 = UnsafeUtil.getByte(j4);
                            addressOffset = j5 + 1;
                            DecodeUtil.handleFourBytes(b2, b4, b5, UnsafeUtil.getByte(j5), cArr, i4);
                            i3 = i4 + 1 + 1;
                        } else {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                    }
                    return new String(cArr, 0, i4);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence charSequence, byte[] bArr, int i, int i2) {
            long j;
            char c;
            long j2;
            int i3;
            char charAt;
            long j3 = (long) i;
            long j4 = ((long) i2) + j3;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i + i2));
            }
            int i4 = 0;
            while (true) {
                char c2 = 128;
                long j5 = 1;
                if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                    UnsafeUtil.putByte(bArr, j3, (byte) charAt);
                    i4++;
                    j3 = 1 + j3;
                } else if (i4 != length) {
                    return (int) j3;
                } else {
                    while (i4 < length) {
                        char charAt2 = charSequence.charAt(i4);
                        if (charAt2 < c2 && j3 < j4) {
                            long j6 = j3 + j5;
                            UnsafeUtil.putByte(bArr, j3, (byte) charAt2);
                            j2 = j5;
                            j = j6;
                            c = c2;
                        } else if (charAt2 < 2048 && j3 <= j4 - 2) {
                            long j7 = j3 + j5;
                            UnsafeUtil.putByte(bArr, j3, (byte) ((charAt2 >>> 6) | 960));
                            long j8 = j7 + j5;
                            UnsafeUtil.putByte(bArr, j7, (byte) ((charAt2 & '?') | 128));
                            c = 128;
                            j = j8;
                            j2 = j5;
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && j3 <= j4 - 3) {
                            long j9 = j3 + j5;
                            UnsafeUtil.putByte(bArr, j3, (byte) ((charAt2 >>> '\f') | 480));
                            long j10 = j9 + j5;
                            UnsafeUtil.putByte(bArr, j9, (byte) (((charAt2 >>> 6) & 63) | 128));
                            UnsafeUtil.putByte(bArr, j10, (byte) ((charAt2 & '?') | 128));
                            j = j10 + 1;
                            j2 = 1;
                            c = 128;
                        } else if (j3 <= j4 - 4) {
                            int i5 = i4 + 1;
                            if (i5 != length) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    long j11 = j3 + 1;
                                    UnsafeUtil.putByte(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                    long j12 = j11 + 1;
                                    c = 128;
                                    UnsafeUtil.putByte(bArr, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                    long j13 = j12 + 1;
                                    UnsafeUtil.putByte(bArr, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                                    j2 = 1;
                                    j = j13 + 1;
                                    UnsafeUtil.putByte(bArr, j13, (byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                } else {
                                    i4 = i5;
                                }
                            }
                            throw new UnpairedSurrogateException(i4 - 1, length);
                        } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                            throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j3);
                        } else {
                            throw new UnpairedSurrogateException(i4, length);
                        }
                        i4++;
                        c2 = c;
                        j3 = j;
                        j5 = j2;
                    }
                    return (int) j3;
                }
            }
            if (i4 != length) {
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0042 A[LOOP:1: B:11:0x0042->B:36:0x0107, LOOP_START, PHI: r2 r4 r6 r9 r12 
          PHI: (r2v2 long) = (r2v0 long), (r2v3 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v4 long) = (r4v3 long), (r4v6 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r6v3 long) = (r6v2 long), (r6v4 long) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r9v4 int) = (r9v3 int), (r9v6 int) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r12v1 char) = (r12v0 char), (r12v2 char) binds: [B:8:0x003a, B:36:0x0107] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x003c  */
        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
            long j;
            long j2;
            char c;
            int i;
            int i2;
            char charAt;
            long addressOffset = UnsafeUtil.addressOffset(byteBuffer);
            long position = ((long) byteBuffer.position()) + addressOffset;
            long limit = ((long) byteBuffer.limit()) + addressOffset;
            int length = charSequence.length();
            if (((long) length) <= limit - position) {
                int i3 = 0;
                while (true) {
                    char c2 = 128;
                    if (i3 < length && (charAt = charSequence.charAt(i3)) < 128) {
                        UnsafeUtil.putByte(position, (byte) charAt);
                        i3++;
                        position++;
                    } else if (i3 != length) {
                        byteBuffer.position((int) (position - addressOffset));
                        return;
                    } else {
                        while (i3 < length) {
                            char charAt2 = charSequence.charAt(i3);
                            if (charAt2 >= c2 || position >= limit) {
                                if (charAt2 >= 2048 || position > limit - 2) {
                                    j2 = addressOffset;
                                    if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                                        long j3 = position + 1;
                                        UnsafeUtil.putByte(position, (byte) ((charAt2 >>> '\f') | 480));
                                        long j4 = j3 + 1;
                                        UnsafeUtil.putByte(j3, (byte) (((charAt2 >>> 6) & 63) | 128));
                                        UnsafeUtil.putByte(j4, (byte) ((charAt2 & '?') | 128));
                                        position = j4 + 1;
                                    } else if (position <= limit - 4) {
                                        i = i3 + 1;
                                        if (i != length) {
                                            char charAt3 = charSequence.charAt(i);
                                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                                j = limit;
                                                long j5 = position + 1;
                                                UnsafeUtil.putByte(position, (byte) ((codePoint >>> 18) | 240));
                                                long j6 = j5 + 1;
                                                c = 128;
                                                UnsafeUtil.putByte(j5, (byte) (((codePoint >>> 12) & 63) | 128));
                                                long j7 = j6 + 1;
                                                UnsafeUtil.putByte(j6, (byte) (((codePoint >>> 6) & 63) | 128));
                                                UnsafeUtil.putByte(j7, (byte) ((codePoint & 63) | 128));
                                                position = j7 + 1;
                                            } else {
                                                i3 = i;
                                            }
                                        }
                                        throw new UnpairedSurrogateException(i3 - 1, length);
                                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i2 = i3 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i2)))) {
                                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + position);
                                    } else {
                                        throw new UnpairedSurrogateException(i3, length);
                                    }
                                } else {
                                    j2 = addressOffset;
                                    long j8 = position + 1;
                                    UnsafeUtil.putByte(position, (byte) ((charAt2 >>> 6) | 960));
                                    UnsafeUtil.putByte(j8, (byte) ((charAt2 & '?') | 128));
                                    position = j8 + 1;
                                }
                                j = limit;
                                i = i3;
                                c = 128;
                            } else {
                                UnsafeUtil.putByte(position, (byte) charAt2);
                                j = limit;
                                i = i3;
                                c = c2;
                                position++;
                                j2 = addressOffset;
                            }
                            c2 = c;
                            addressOffset = j2;
                            limit = j;
                            i3 = i + 1;
                        }
                        byteBuffer.position((int) (position - addressOffset));
                        return;
                    }
                }
                if (i3 != length) {
                }
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + byteBuffer.limit());
            }
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] bArr, long j, int i) {
            int i2 = 0;
            if (i < 16) {
                return 0;
            }
            while (i2 < i) {
                long j2 = 1 + j;
                if (UnsafeUtil.getByte(bArr, j) < 0) {
                    return i2;
                }
                i2++;
                j = j2;
            }
            return i;
        }

        private static int unsafeEstimateConsecutiveAscii(long j, int i) {
            if (i < 16) {
                return 0;
            }
            int i2 = 8 - (((int) j) & 7);
            int i3 = i2;
            while (i3 > 0) {
                long j2 = 1 + j;
                if (UnsafeUtil.getByte(j) < 0) {
                    return i2 - i3;
                }
                i3--;
                j = j2;
            }
            int i4 = i - i2;
            while (i4 >= 8 && (UnsafeUtil.getLong(j) & Utf8.ASCII_MASK_LONG) == 0) {
                j += 8;
                i4 -= 8;
            }
            return i - i4;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        private static int partialIsValidUtf8(byte[] bArr, long j, int i) {
            long j2;
            int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(bArr, j, i);
            int i2 = i - unsafeEstimateConsecutiveAscii;
            long j3 = j + ((long) unsafeEstimateConsecutiveAscii);
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j4 = j3 + 1;
                    b = UnsafeUtil.getByte(bArr, j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 = i3 - 3;
                            long j5 = j3 + 1;
                            byte b2 = UnsafeUtil.getByte(bArr, j3);
                            if (b2 > -65 || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j6 = j5 + 1;
                            if (UnsafeUtil.getByte(bArr, j5) > -65) {
                                break;
                            }
                            j2 = 1 + j6;
                            if (UnsafeUtil.getByte(bArr, j6) > -65) {
                                break;
                            }
                        } else {
                            return unsafeIncompleteStateFor(bArr, b, j3, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 = i3 - 2;
                        long j7 = j3 + 1;
                        byte b3 = UnsafeUtil.getByte(bArr, j3);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || (b == -19 && b3 >= -96))) {
                            break;
                        }
                        j2 = 1 + j7;
                        if (UnsafeUtil.getByte(bArr, j7) > -65) {
                            break;
                        }
                    } else {
                        return unsafeIncompleteStateFor(bArr, b, j3, i3);
                    }
                } else if (i3 != 0) {
                    i2 = i3 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = 1 + j3;
                    if (UnsafeUtil.getByte(bArr, j3) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j3 = j2;
            }
            return -1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            return -1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0063, code lost:
            return -1;
         */
        private static int partialIsValidUtf8(long j, int i) {
            long j2;
            int unsafeEstimateConsecutiveAscii = unsafeEstimateConsecutiveAscii(j, i);
            long j3 = j + ((long) unsafeEstimateConsecutiveAscii);
            int i2 = i - unsafeEstimateConsecutiveAscii;
            while (true) {
                byte b = 0;
                while (true) {
                    if (i2 <= 0) {
                        break;
                    }
                    long j4 = j3 + 1;
                    b = UnsafeUtil.getByte(j3);
                    if (b < 0) {
                        j3 = j4;
                        break;
                    }
                    i2--;
                    j3 = j4;
                }
                if (i2 == 0) {
                    return 0;
                }
                int i3 = i2 - 1;
                if (b >= -32) {
                    if (b >= -16) {
                        if (i3 >= 3) {
                            i2 = i3 - 3;
                            long j5 = j3 + 1;
                            byte b2 = UnsafeUtil.getByte(j3);
                            if (b2 > -65 || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j6 = j5 + 1;
                            if (UnsafeUtil.getByte(j5) > -65) {
                                break;
                            }
                            j2 = 1 + j6;
                            if (UnsafeUtil.getByte(j6) > -65) {
                                break;
                            }
                        } else {
                            return unsafeIncompleteStateFor(j3, b, i3);
                        }
                    } else if (i3 >= 2) {
                        i2 = i3 - 2;
                        long j7 = j3 + 1;
                        byte b3 = UnsafeUtil.getByte(j3);
                        if (b3 > -65 || ((b == -32 && b3 < -96) || (b == -19 && b3 >= -96))) {
                            break;
                        }
                        j2 = 1 + j7;
                        if (UnsafeUtil.getByte(j7) > -65) {
                            break;
                        }
                    } else {
                        return unsafeIncompleteStateFor(j3, b, i3);
                    }
                } else if (i3 != 0) {
                    i2 = i3 - 1;
                    if (b < -62) {
                        break;
                    }
                    j2 = 1 + j3;
                    if (UnsafeUtil.getByte(j3) > -65) {
                        break;
                    }
                } else {
                    return b;
                }
                j3 = j2;
            }
            return -1;
        }

        private static int unsafeIncompleteStateFor(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(bArr, j), UnsafeUtil.getByte(bArr, j + 1));
            }
            throw new AssertionError();
        }

        private static int unsafeIncompleteStateFor(long j, int i, int i2) {
            if (i2 == 0) {
                return Utf8.incompleteStateFor(i);
            }
            if (i2 == 1) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j));
            }
            if (i2 == 2) {
                return Utf8.incompleteStateFor(i, UnsafeUtil.getByte(j), UnsafeUtil.getByte(j + 1));
            }
            throw new AssertionError();
        }
    }

    /* access modifiers changed from: private */
    public static class DecodeUtil {
        private static char highSurrogate(int i) {
            return (char) ((i >>> 10) + okio.Utf8.HIGH_SURROGATE_HEADER);
        }

        private static boolean isNotTrailingByte(byte b) {
            return b > -65;
        }

        /* access modifiers changed from: private */
        public static boolean isOneByte(byte b) {
            return b >= 0;
        }

        /* access modifiers changed from: private */
        public static boolean isThreeBytes(byte b) {
            return b < -16;
        }

        /* access modifiers changed from: private */
        public static boolean isTwoBytes(byte b) {
            return b < -32;
        }

        private static char lowSurrogate(int i) {
            return (char) ((i & 1023) + okio.Utf8.LOG_SURROGATE_HEADER);
        }

        private static int trailingByteValue(byte b) {
            return b & okio.Utf8.REPLACEMENT_BYTE;
        }

        private DecodeUtil() {
        }

        /* access modifiers changed from: private */
        public static void handleOneByte(byte b, char[] cArr, int i) {
            cArr[i] = (char) b;
        }

        /* access modifiers changed from: private */
        public static void handleTwoBytes(byte b, byte b2, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (b < -62 || isNotTrailingByte(b2)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & Ascii.US) << 6) | trailingByteValue(b2));
        }

        /* access modifiers changed from: private */
        public static void handleThreeBytes(byte b, byte b2, byte b3, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || isNotTrailingByte(b3)))) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            cArr[i] = (char) (((b & Ascii.SI) << 12) | (trailingByteValue(b2) << 6) | trailingByteValue(b3));
        }

        /* access modifiers changed from: private */
        public static void handleFourBytes(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws InvalidProtocolBufferException {
            if (isNotTrailingByte(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || isNotTrailingByte(b3) || isNotTrailingByte(b4)) {
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            int trailingByteValue = ((b & 7) << 18) | (trailingByteValue(b2) << 12) | (trailingByteValue(b3) << 6) | trailingByteValue(b4);
            cArr[i] = highSurrogate(trailingByteValue);
            cArr[i + 1] = lowSurrogate(trailingByteValue);
        }
    }

    private Utf8() {
    }
}
