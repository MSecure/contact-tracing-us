package c.b.a.a.g.h;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;

public final class n4 extends m4 {
    public static int d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return k4.b(i);
        }
        if (i2 == 1) {
            return k4.f(i, j4.a(bArr, j));
        }
        if (i2 == 2) {
            return k4.c(i, j4.a(bArr, j), j4.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        return -1;
     */
    @Override // c.b.a.a.g.h.m4
    public final int a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        if ((i2 | i3 | (bArr.length - i3)) >= 0) {
            long j = (long) i2;
            int i5 = (int) (((long) i3) - j);
            if (i5 >= 16) {
                i4 = 0;
                long j2 = j;
                while (true) {
                    if (i4 >= i5) {
                        i4 = i5;
                        break;
                    }
                    long j3 = j2 + 1;
                    if (j4.a(bArr, j2) < 0) {
                        break;
                    }
                    i4++;
                    j2 = j3;
                }
            } else {
                i4 = 0;
            }
            int i6 = i5 - i4;
            long j4 = j + ((long) i4);
            while (true) {
                byte b2 = 0;
                while (true) {
                    if (i6 <= 0) {
                        break;
                    }
                    long j5 = j4 + 1;
                    byte a2 = j4.a(bArr, j4);
                    if (a2 < 0) {
                        b2 = a2;
                        j4 = j5;
                        break;
                    }
                    i6--;
                    b2 = a2;
                    j4 = j5;
                }
                if (i6 != 0) {
                    int i7 = i6 - 1;
                    if (b2 >= -32) {
                        if (b2 >= -16) {
                            if (i7 >= 3) {
                                i6 = i7 - 3;
                                long j6 = j4 + 1;
                                byte a3 = j4.a(bArr, j4);
                                if (a3 > -65) {
                                    break;
                                }
                                if ((((a3 + 112) + (b2 << 28)) >> 30) != 0) {
                                    break;
                                }
                                long j7 = j6 + 1;
                                if (j4.a(bArr, j6) > -65) {
                                    break;
                                }
                                j4 = j7 + 1;
                                if (j4.a(bArr, j7) > -65) {
                                    break;
                                }
                            } else {
                                return d(bArr, b2, j4, i7);
                            }
                        } else if (i7 >= 2) {
                            i6 = i7 - 2;
                            long j8 = j4 + 1;
                            byte a4 = j4.a(bArr, j4);
                            if (a4 > -65 || ((b2 == -32 && a4 < -96) || (b2 == -19 && a4 >= -96))) {
                                break;
                            }
                            j4 = j8 + 1;
                            if (j4.a(bArr, j8) > -65) {
                                break;
                            }
                        } else {
                            return d(bArr, b2, j4, i7);
                        }
                    } else if (i7 != 0) {
                        i6 = i7 - 1;
                        if (b2 < -62) {
                            break;
                        }
                        long j9 = j4 + 1;
                        if (j4.a(bArr, j4) > -65) {
                            break;
                        }
                        j4 = j9;
                    } else {
                        return b2;
                    }
                } else {
                    return 0;
                }
            }
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:37:0x00fc, LOOP_START, PHI: r2 r3 r4 r11 
      PHI: (r2v4 int) = (r2v3 int), (r2v6 int) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r3v3 char) = (r3v2 char), (r3v4 char) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v3 long) = (r4v2 long), (r4v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r11v3 long) = (r11v2 long), (r11v5 long) binds: [B:10:0x002f, B:37:0x00fc] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // c.b.a.a.g.h.m4
    public final int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        char c2;
        long j2;
        int i3;
        char charAt;
        long j3 = (long) i;
        long j4 = ((long) i2) + j3;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            char c3 = 128;
            long j5 = 1;
            if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                j4.f(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            } else if (i4 != length) {
                return (int) j3;
            } else {
                while (i4 < length) {
                    char charAt3 = charSequence.charAt(i4);
                    if (charAt3 < c3 && j3 < j4) {
                        long j6 = j3 + j5;
                        j4.f(bArr, j3, (byte) charAt3);
                        j2 = j5;
                        j = j6;
                        c2 = c3;
                    } else if (charAt3 < 2048 && j3 <= j4 - 2) {
                        long j7 = j3 + j5;
                        j4.f(bArr, j3, (byte) ((charAt3 >>> 6) | 960));
                        long j8 = j7 + j5;
                        j4.f(bArr, j7, (byte) ((charAt3 & '?') | RecyclerView.a0.FLAG_IGNORE));
                        c2 = 128;
                        j = j8;
                        j2 = j5;
                    } else if ((charAt3 < 55296 || 57343 < charAt3) && j3 <= j4 - 3) {
                        long j9 = j3 + j5;
                        j4.f(bArr, j3, (byte) ((charAt3 >>> '\f') | 480));
                        long j10 = j9 + j5;
                        j4.f(bArr, j9, (byte) (((charAt3 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                        j4.f(bArr, j10, (byte) ((charAt3 & '?') | RecyclerView.a0.FLAG_IGNORE));
                        j = j10 + 1;
                        j2 = 1;
                        c2 = 128;
                    } else if (j3 <= j4 - 4) {
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char charAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j11 = j3 + 1;
                                j4.f(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                c2 = 128;
                                j4.f(bArr, j11, (byte) (((codePoint >>> 12) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                long j13 = j12 + 1;
                                j4.f(bArr, j12, (byte) (((codePoint >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                j2 = 1;
                                j = j13 + 1;
                                j4.f(bArr, j13, (byte) ((codePoint & 63) | RecyclerView.a0.FLAG_IGNORE));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new o4(i4 - 1, length);
                    } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j3);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    } else {
                        throw new o4(i4, length);
                    }
                    i4++;
                    c3 = c2;
                    j3 = j;
                    j5 = j2;
                }
                return (int) j3;
            }
        }
        if (i4 != length) {
        }
    }

    @Override // c.b.a.a.g.h.m4
    public final String c(byte[] bArr, int i, int i2) {
        if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
            int i3 = i + i2;
            char[] cArr = new char[i2];
            int i4 = 0;
            while (i < i3) {
                byte a2 = j4.a(bArr, (long) i);
                if (!t.N4(a2)) {
                    break;
                }
                i++;
                cArr[i4] = (char) a2;
                i4++;
            }
            int i5 = i4;
            while (i < i3) {
                int i6 = i + 1;
                byte a3 = j4.a(bArr, (long) i);
                if (t.N4(a3)) {
                    int i7 = i5 + 1;
                    cArr[i5] = (char) a3;
                    i = i6;
                    while (true) {
                        i5 = i7;
                        if (i >= i3) {
                            break;
                        }
                        byte a4 = j4.a(bArr, (long) i);
                        if (!t.N4(a4)) {
                            break;
                        }
                        i++;
                        i7 = i5 + 1;
                        cArr[i5] = (char) a4;
                    }
                } else {
                    if (!(a3 < -32)) {
                        if (a3 < -16) {
                            if (i6 < i3 - 1) {
                                int i8 = i6 + 1;
                                t.u4(a3, j4.a(bArr, (long) i6), j4.a(bArr, (long) i8), cArr, i5);
                                i = i8 + 1;
                                i5++;
                            } else {
                                throw c2.f();
                            }
                        } else if (i6 < i3 - 2) {
                            int i9 = i6 + 1;
                            int i10 = i9 + 1;
                            t.t4(a3, j4.a(bArr, (long) i6), j4.a(bArr, (long) i9), j4.a(bArr, (long) i10), cArr, i5);
                            i5 = i5 + 1 + 1;
                            i = i10 + 1;
                        } else {
                            throw c2.f();
                        }
                    } else if (i6 < i3) {
                        t.v4(a3, j4.a(bArr, (long) i6), cArr, i5);
                        i = i6 + 1;
                        i5++;
                    } else {
                        throw c2.f();
                    }
                }
            }
            return new String(cArr, 0, i5);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
    }
}
