package f.b.g;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public final class w1 {
    public static final a a;

    /* loaded from: classes.dex */
    public static abstract class a {
        public abstract String a(byte[] bArr, int i2, int i3);

        public final String b(ByteBuffer byteBuffer, int i2, int i3) {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (i2 < i4) {
                    byte b = byteBuffer.get(i2);
                    if (!f.b.a.c.b.o.b.b(b)) {
                        break;
                    }
                    i2++;
                    i5++;
                    cArr[i5] = (char) b;
                }
                int i6 = i5;
                while (i2 < i4) {
                    int i7 = i2 + 1;
                    byte b2 = byteBuffer.get(i2);
                    if (f.b.a.c.b.o.b.b(b2)) {
                        int i8 = i6 + 1;
                        cArr[i6] = (char) b2;
                        while (i7 < i4) {
                            byte b3 = byteBuffer.get(i7);
                            if (!f.b.a.c.b.o.b.b(b3)) {
                                break;
                            }
                            i7++;
                            cArr[i8] = (char) b3;
                            i8++;
                        }
                        i2 = i7;
                        i6 = i8;
                    } else if (f.b.a.c.b.o.b.c(b2)) {
                        if (i7 < i4) {
                            i2 = i7 + 1;
                            i6++;
                            f.b.a.c.b.o.b.d(b2, byteBuffer.get(i7), cArr, i6);
                        } else {
                            throw d0.c();
                        }
                    } else if (f.b.a.c.b.o.b.e(b2)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            i2 = i9 + 1;
                            i6++;
                            f.b.a.c.b.o.b.f(b2, byteBuffer.get(i7), byteBuffer.get(i9), cArr, i6);
                        } else {
                            throw d0.c();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b4 = byteBuffer.get(i7);
                        int i11 = i10 + 1;
                        i2 = i11 + 1;
                        f.b.a.c.b.o.b.a(b2, b4, byteBuffer.get(i10), byteBuffer.get(i11), cArr, i6);
                        i6 = i6 + 1 + 1;
                    } else {
                        throw d0.c();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        public abstract String c(ByteBuffer byteBuffer, int i2, int i3);

        public abstract int d(CharSequence charSequence, byte[] bArr, int i2, int i3);

        public abstract int e(int i2, byte[] bArr, int i3, int i4);
    }

    /* loaded from: classes.dex */
    public static final class b extends a {
        @Override // f.b.g.w1.a
        public String a(byte[] bArr, int i2, int i3) {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (i2 < i4) {
                    byte b = bArr[i2];
                    if (!f.b.a.c.b.o.b.b(b)) {
                        break;
                    }
                    i2++;
                    i5++;
                    cArr[i5] = (char) b;
                }
                int i6 = i5;
                while (i2 < i4) {
                    int i7 = i2 + 1;
                    byte b2 = bArr[i2];
                    if (f.b.a.c.b.o.b.b(b2)) {
                        int i8 = i6 + 1;
                        cArr[i6] = (char) b2;
                        while (i7 < i4) {
                            byte b3 = bArr[i7];
                            if (!f.b.a.c.b.o.b.b(b3)) {
                                break;
                            }
                            i7++;
                            cArr[i8] = (char) b3;
                            i8++;
                        }
                        i2 = i7;
                        i6 = i8;
                    } else if (f.b.a.c.b.o.b.c(b2)) {
                        if (i7 < i4) {
                            i2 = i7 + 1;
                            i6++;
                            f.b.a.c.b.o.b.d(b2, bArr[i7], cArr, i6);
                        } else {
                            throw d0.c();
                        }
                    } else if (f.b.a.c.b.o.b.e(b2)) {
                        if (i7 < i4 - 1) {
                            int i9 = i7 + 1;
                            i2 = i9 + 1;
                            i6++;
                            f.b.a.c.b.o.b.f(b2, bArr[i7], bArr[i9], cArr, i6);
                        } else {
                            throw d0.c();
                        }
                    } else if (i7 < i4 - 2) {
                        int i10 = i7 + 1;
                        byte b4 = bArr[i7];
                        int i11 = i10 + 1;
                        i2 = i11 + 1;
                        f.b.a.c.b.o.b.a(b2, b4, bArr[i10], bArr[i11], cArr, i6);
                        i6 = i6 + 1 + 1;
                    } else {
                        throw d0.c();
                    }
                }
                return new String(cArr, 0, i6);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        @Override // f.b.g.w1.a
        public String c(ByteBuffer byteBuffer, int i2, int i3) {
            return b(byteBuffer, i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // f.b.g.w1.a
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int d(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            int i4;
            int i5;
            char charAt;
            int length = charSequence.length();
            int i6 = i3 + i2;
            int i7 = 0;
            while (i7 < length && (i5 = i7 + i2) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
                bArr[i5] = (byte) charAt;
                i7++;
            }
            int i8 = i2 + i7;
            while (i7 < length) {
                char charAt2 = charSequence.charAt(i7);
                if (charAt2 >= 128 || i8 >= i6) {
                    if (charAt2 < 2048 && i8 <= i6 - 2) {
                        int i9 = i8 + 1;
                        bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                        i8 = i9 + 1;
                        bArr[i9] = (byte) ((charAt2 & '?') | 128);
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                        int i10 = i8 + 1;
                        bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                        int i11 = i10 + 1;
                        bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                        i8 = i11 + 1;
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
                            } else {
                                i7 = i12;
                            }
                        }
                        throw new c(i7 - 1, length);
                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                    } else {
                        throw new c(i7, length);
                    }
                    i7++;
                } else {
                    i8++;
                    bArr[i8] = (byte) charAt2;
                }
                i7++;
            }
            return i8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        @Override // f.b.g.w1.a
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int e(int i2, byte[] bArr, int i3, int i4) {
            byte b;
            int i5;
            if (i2 != 0) {
                if (i3 >= i4) {
                    return i2;
                }
                byte b2 = (byte) i2;
                if (b2 < -32) {
                    if (b2 >= -62) {
                        i5 = i3 + 1;
                    }
                    return -1;
                } else if (b2 < -16) {
                    byte b3 = (byte) (~(i2 >> 8));
                    if (b3 == 0) {
                        int i6 = i3 + 1;
                        byte b4 = bArr[i3];
                        if (i6 >= i4) {
                            return w1.f(b2, b4);
                        }
                        i3 = i6;
                        b3 = b4;
                    }
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i5 = i3 + 1;
                    }
                    return -1;
                } else {
                    byte b5 = (byte) (~(i2 >> 8));
                    if (b5 == 0) {
                        int i7 = i3 + 1;
                        b5 = bArr[i3];
                        if (i7 >= i4) {
                            return w1.f(b2, b5);
                        }
                        i3 = i7;
                        b = 0;
                    } else {
                        b = (byte) (i2 >> 16);
                    }
                    if (b == 0) {
                        int i8 = i3 + 1;
                        byte b6 = bArr[i3];
                        if (i8 >= i4) {
                            return w1.g(b2, b5, b6);
                        }
                        i3 = i8;
                        b = b6;
                    }
                    if (b5 <= -65) {
                        if ((((b5 + 112) + (b2 << 28)) >> 30) == 0 && b <= -65) {
                            i5 = i3 + 1;
                        }
                    }
                    return -1;
                }
                i3 = i5;
            }
            while (i3 < i4 && bArr[i3] >= 0) {
                i3++;
            }
            if (i3 >= i4) {
                return 0;
            }
            while (i3 < i4) {
                int i9 = i3 + 1;
                byte b7 = bArr[i3];
                if (b7 >= 0) {
                    i3 = i9;
                } else if (b7 < -32) {
                    if (i9 >= i4) {
                        return b7;
                    }
                    if (b7 >= -62) {
                        i3 = i9 + 1;
                        if (bArr[i9] > -65) {
                        }
                    }
                    return -1;
                } else if (b7 < -16) {
                    if (i9 >= i4 - 1) {
                        return w1.a(bArr, i9, i4);
                    }
                    int i10 = i9 + 1;
                    byte b8 = bArr[i9];
                    if (b8 <= -65 && ((b7 != -32 || b8 >= -96) && (b7 != -19 || b8 < -96))) {
                        i3 = i10 + 1;
                        if (bArr[i10] > -65) {
                        }
                    }
                    return -1;
                } else if (i9 >= i4 - 2) {
                    return w1.a(bArr, i9, i4);
                } else {
                    int i11 = i9 + 1;
                    byte b9 = bArr[i9];
                    if (b9 <= -65) {
                        if ((((b9 + 112) + (b7 << 28)) >> 30) == 0) {
                            int i12 = i11 + 1;
                            if (bArr[i11] <= -65) {
                                i3 = i12 + 1;
                                if (bArr[i12] > -65) {
                                }
                            }
                        }
                    }
                    return -1;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends IllegalArgumentException {
        public c(int i2, int i3) {
            super("Unpaired surrogate at index " + i2 + " of " + i3);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends a {
        public static int f(byte[] bArr, int i2, long j2, int i3) {
            if (i3 == 0) {
                return w1.e(i2);
            }
            if (i3 == 1) {
                return w1.f(i2, v1.i(bArr, j2));
            }
            if (i3 == 2) {
                return w1.g(i2, v1.i(bArr, j2), v1.i(bArr, j2 + 1));
            }
            throw new AssertionError();
        }

        @Override // f.b.g.w1.a
        public String a(byte[] bArr, int i2, int i3) {
            if ((i2 | i3 | ((bArr.length - i2) - i3)) >= 0) {
                int i4 = i2 + i3;
                char[] cArr = new char[i3];
                int i5 = 0;
                while (i2 < i4) {
                    byte i6 = v1.i(bArr, (long) i2);
                    if (!f.b.a.c.b.o.b.b(i6)) {
                        break;
                    }
                    i2++;
                    i5++;
                    cArr[i5] = (char) i6;
                }
                int i7 = i5;
                while (i2 < i4) {
                    int i8 = i2 + 1;
                    byte i9 = v1.i(bArr, (long) i2);
                    if (f.b.a.c.b.o.b.b(i9)) {
                        int i10 = i7 + 1;
                        cArr[i7] = (char) i9;
                        while (i8 < i4) {
                            byte i11 = v1.i(bArr, (long) i8);
                            if (!f.b.a.c.b.o.b.b(i11)) {
                                break;
                            }
                            i8++;
                            cArr[i10] = (char) i11;
                            i10++;
                        }
                        i2 = i8;
                        i7 = i10;
                    } else if (f.b.a.c.b.o.b.c(i9)) {
                        if (i8 < i4) {
                            i2 = i8 + 1;
                            i7++;
                            f.b.a.c.b.o.b.d(i9, v1.i(bArr, (long) i8), cArr, i7);
                        } else {
                            throw d0.c();
                        }
                    } else if (f.b.a.c.b.o.b.e(i9)) {
                        if (i8 < i4 - 1) {
                            int i12 = i8 + 1;
                            i2 = i12 + 1;
                            i7++;
                            f.b.a.c.b.o.b.f(i9, v1.i(bArr, (long) i8), v1.i(bArr, (long) i12), cArr, i7);
                        } else {
                            throw d0.c();
                        }
                    } else if (i8 < i4 - 2) {
                        int i13 = i8 + 1;
                        int i14 = i13 + 1;
                        i2 = i14 + 1;
                        f.b.a.c.b.o.b.a(i9, v1.i(bArr, (long) i8), v1.i(bArr, (long) i13), v1.i(bArr, (long) i14), cArr, i7);
                        i7 = i7 + 1 + 1;
                    } else {
                        throw d0.c();
                    }
                }
                return new String(cArr, 0, i7);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        @Override // f.b.g.w1.a
        public String c(ByteBuffer byteBuffer, int i2, int i3) {
            if ((i2 | i3 | ((byteBuffer.limit() - i2) - i3)) >= 0) {
                long a = v1.a(byteBuffer) + ((long) i2);
                long j2 = ((long) i3) + a;
                char[] cArr = new char[i3];
                int i4 = 0;
                while (a < j2) {
                    byte h2 = v1.h(a);
                    if (!f.b.a.c.b.o.b.b(h2)) {
                        break;
                    }
                    a++;
                    i4++;
                    cArr[i4] = (char) h2;
                }
                while (true) {
                    int i5 = i4;
                    while (a < j2) {
                        long j3 = a + 1;
                        byte h3 = v1.h(a);
                        if (f.b.a.c.b.o.b.b(h3)) {
                            cArr[i5] = (char) h3;
                            i5++;
                            a = j3;
                            while (a < j2) {
                                byte h4 = v1.h(a);
                                if (!f.b.a.c.b.o.b.b(h4)) {
                                    break;
                                }
                                a++;
                                cArr[i5] = (char) h4;
                                i5++;
                            }
                        } else if (f.b.a.c.b.o.b.c(h3)) {
                            if (j3 < j2) {
                                a = j3 + 1;
                                i5++;
                                f.b.a.c.b.o.b.d(h3, v1.h(j3), cArr, i5);
                            } else {
                                throw d0.c();
                            }
                        } else if (f.b.a.c.b.o.b.e(h3)) {
                            if (j3 < j2 - 1) {
                                long j4 = j3 + 1;
                                a = j4 + 1;
                                i5++;
                                f.b.a.c.b.o.b.f(h3, v1.h(j3), v1.h(j4), cArr, i5);
                            } else {
                                throw d0.c();
                            }
                        } else if (j3 < j2 - 2) {
                            long j5 = j3 + 1;
                            byte h5 = v1.h(j3);
                            long j6 = j5 + 1;
                            byte h6 = v1.h(j5);
                            a = j6 + 1;
                            f.b.a.c.b.o.b.a(h3, h5, h6, v1.h(j6), cArr, i5);
                            i4 = i5 + 1 + 1;
                        } else {
                            throw d0.c();
                        }
                    }
                    return new String(cArr, 0, i5);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i2), Integer.valueOf(i3)));
        }

        @Override // f.b.g.w1.a
        public int d(CharSequence charSequence, byte[] bArr, int i2, int i3) {
            char c;
            long j2;
            int i4;
            char charAt;
            long j3 = (long) i2;
            long j4 = ((long) i3) + j3;
            int length = charSequence.length();
            if (length > i3 || bArr.length - i3 < i2) {
                StringBuilder h2 = f.a.a.a.a.h("Failed writing ");
                h2.append(charSequence.charAt(length - 1));
                h2.append(" at index ");
                h2.append(i2 + i3);
                throw new ArrayIndexOutOfBoundsException(h2.toString());
            }
            int i5 = 0;
            while (true) {
                c = 128;
                j2 = 1;
                if (i5 >= length || (charAt = charSequence.charAt(i5)) >= 128) {
                    break;
                }
                j3 = 1 + j3;
                v1.s(bArr, j3, (byte) charAt);
                i5++;
            }
            if (i5 == length) {
                return (int) j3;
            }
            while (i5 < length) {
                char charAt2 = charSequence.charAt(i5);
                if (charAt2 >= c || j3 >= j4) {
                    if (charAt2 < 2048 && j3 <= j4 - 2) {
                        long j5 = j3 + j2;
                        v1.s(bArr, j3, (byte) ((charAt2 >>> 6) | 960));
                        j3 = j5 + j2;
                        v1.s(bArr, j5, (byte) ((charAt2 & '?') | 128));
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && j3 <= j4 - 3) {
                        long j6 = j3 + j2;
                        v1.s(bArr, j3, (byte) ((charAt2 >>> '\f') | 480));
                        long j7 = j2 + j6;
                        v1.s(bArr, j6, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j3 = j7 + 1;
                        v1.s(bArr, j7, (byte) ((charAt2 & '?') | 128));
                        j2 = 1;
                    } else if (j3 <= j4 - 4) {
                        int i6 = i5 + 1;
                        if (i6 != length) {
                            char charAt3 = charSequence.charAt(i6);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j8 = j3 + 1;
                                v1.s(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                long j9 = 1 + j8;
                                v1.s(bArr, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j10 = 1 + j9;
                                v1.s(bArr, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                j2 = 1;
                                j3 = j10 + 1;
                                v1.s(bArr, j10, (byte) ((codePoint & 63) | 128));
                                i5 = i6;
                            } else {
                                i5 = i6;
                            }
                        }
                        throw new c(i5 - 1, length);
                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i4 = i5 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i4)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j3);
                    } else {
                        throw new c(i5, length);
                    }
                    i5++;
                    c = 128;
                } else {
                    j3 += j2;
                    v1.s(bArr, j3, (byte) charAt2);
                }
                i5++;
                c = 128;
            }
            return (int) j3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:133:?, code lost:
            return f(r25, r2, r8, r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0036, code lost:
            if (f.b.g.v1.i(r25, r8) > -65) goto L_0x003d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
            if (f.b.g.v1.i(r25, r8) > -65) goto L_0x0069;
         */
        @Override // f.b.g.w1.a
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int e(int i2, byte[] bArr, int i3, int i4) {
            int i5;
            byte b;
            long j2;
            if ((i3 | i4 | (bArr.length - i4)) >= 0) {
                long j3 = (long) i3;
                long j4 = (long) i4;
                if (i2 != 0) {
                    if (j3 >= j4) {
                        return i2;
                    }
                    byte b2 = (byte) i2;
                    if (b2 < -32) {
                        if (b2 >= -62) {
                            j2 = j3 + 1;
                        }
                        return -1;
                    } else if (b2 < -16) {
                        byte b3 = (byte) (~(i2 >> 8));
                        if (b3 == 0) {
                            long j5 = j3 + 1;
                            b3 = v1.i(bArr, j3);
                            if (j5 >= j4) {
                                return w1.f(b2, b3);
                            }
                            j3 = j5;
                        }
                        if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                            j2 = j3 + 1;
                        }
                        return -1;
                    } else {
                        byte b4 = (byte) (~(i2 >> 8));
                        if (b4 == 0) {
                            long j6 = j3 + 1;
                            b4 = v1.i(bArr, j3);
                            if (j6 >= j4) {
                                return w1.f(b2, b4);
                            }
                            j3 = j6;
                            b = 0;
                        } else {
                            b = (byte) (i2 >> 16);
                        }
                        if (b == 0) {
                            long j7 = j3 + 1;
                            b = v1.i(bArr, j3);
                            if (j7 >= j4) {
                                return w1.g(b2, b4, b);
                            }
                            j3 = j7;
                        }
                        if (b4 <= -65 && (((b4 + 112) + (b2 << 28)) >> 30) == 0 && b <= -65) {
                            long j8 = j3 + 1;
                            if (v1.i(bArr, j3) <= -65) {
                                j3 = j8;
                            }
                        }
                        return -1;
                    }
                    j3 = j2;
                }
                int i6 = (int) (j4 - j3);
                if (i6 >= 16) {
                    long j9 = j3;
                    i5 = 0;
                    while (true) {
                        if (i5 >= i6) {
                            i5 = i6;
                            break;
                        }
                        long j10 = j9 + 1;
                        if (v1.i(bArr, j9) < 0) {
                            break;
                        }
                        i5++;
                        j9 = j10;
                    }
                } else {
                    i5 = 0;
                }
                int i7 = i6 - i5;
                long j11 = j3 + ((long) i5);
                while (true) {
                    byte b5 = 0;
                    while (true) {
                        if (i7 <= 0) {
                            break;
                        }
                        long j12 = j11 + 1;
                        byte i8 = v1.i(bArr, j11);
                        if (i8 < 0) {
                            j11 = j12;
                            b5 = i8;
                            break;
                        }
                        i7--;
                        j11 = j12;
                        b5 = i8;
                    }
                    if (i7 != 0) {
                        int i9 = i7 - 1;
                        if (b5 >= -32) {
                            if (b5 >= -16) {
                                if (i9 >= 3) {
                                    i7 = i9 - 3;
                                    long j13 = j11 + 1;
                                    byte i10 = v1.i(bArr, j11);
                                    if (i10 > -65 || (((i10 + 112) + (b5 << 28)) >> 30) != 0) {
                                        break;
                                    }
                                    long j14 = j13 + 1;
                                    if (v1.i(bArr, j13) > -65) {
                                        break;
                                    }
                                    j11 = j14 + 1;
                                    if (v1.i(bArr, j14) > -65) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else if (i9 >= 2) {
                                i7 = i9 - 2;
                                long j15 = j11 + 1;
                                byte i11 = v1.i(bArr, j11);
                                if (i11 > -65 || ((b5 == -32 && i11 < -96) || (b5 == -19 && i11 >= -96))) {
                                    break;
                                }
                                j11 = j15 + 1;
                                if (v1.i(bArr, j15) > -65) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (i9 != 0) {
                            i7 = i9 - 1;
                            if (b5 < -62) {
                                break;
                            }
                            j11++;
                            if (v1.i(bArr, j11) > -65) {
                                break;
                            }
                        } else {
                            return b5;
                        }
                    } else {
                        return 0;
                    }
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
    }

    static {
        a = (!(v1.f3955h && v1.f3954g) || d.a()) ? new b() : new d();
    }

    public static int a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
        if (i4 == 0) {
            return e(b2);
        }
        if (i4 == 1) {
            return f(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return g(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static String b(byte[] bArr, int i2, int i3) {
        return a.a(bArr, i2, i3);
    }

    public static int c(CharSequence charSequence, byte[] bArr, int i2, int i3) {
        return a.d(charSequence, bArr, i2, i3);
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) >= 65536) {
                                i3++;
                            } else {
                                throw new c(i3, length2);
                            }
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        StringBuilder h2 = f.a.a.a.a.h("UTF-8 length does not fit in int: ");
        h2.append(((long) i4) + 4294967296L);
        throw new IllegalArgumentException(h2.toString());
    }

    public static int e(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    public static int f(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    public static int g(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }

    public static boolean h(byte[] bArr, int i2, int i3) {
        return a.e(0, bArr, i2, i3) == 0;
    }
}
