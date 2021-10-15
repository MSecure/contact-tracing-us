package c.b.a.a.g.b;

import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;

public final class t3 extends q3 {
    public static int e(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            return p3.d(i);
        }
        if (i2 == 1) {
            return p3.h(i, n3.a(bArr, j));
        }
        if (i2 == 2) {
            return p3.e(i, n3.a(bArr, j), n3.a(bArr, j + 1));
        }
        throw new AssertionError();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ba, code lost:
        return -1;
     */
    @Override // c.b.a.a.g.b.q3
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
                    if (n3.a(bArr, j2) < 0) {
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
                    byte a2 = n3.a(bArr, j4);
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
                                byte a3 = n3.a(bArr, j4);
                                if (a3 > -65) {
                                    break;
                                }
                                if ((((a3 + 112) + (b2 << 28)) >> 30) != 0) {
                                    break;
                                }
                                long j7 = j6 + 1;
                                if (n3.a(bArr, j6) > -65) {
                                    break;
                                }
                                j4 = j7 + 1;
                                if (n3.a(bArr, j7) > -65) {
                                    break;
                                }
                            } else {
                                return e(bArr, b2, j4, i7);
                            }
                        } else if (i7 >= 2) {
                            i6 = i7 - 2;
                            long j8 = j4 + 1;
                            byte a4 = n3.a(bArr, j4);
                            if (a4 > -65 || ((b2 == -32 && a4 < -96) || (b2 == -19 && a4 >= -96))) {
                                break;
                            }
                            j4 = j8 + 1;
                            if (n3.a(bArr, j8) > -65) {
                                break;
                            }
                        } else {
                            return e(bArr, b2, j4, i7);
                        }
                    } else if (i7 != 0) {
                        i6 = i7 - 1;
                        if (b2 < -62) {
                            break;
                        }
                        long j9 = j4 + 1;
                        if (n3.a(bArr, j4) > -65) {
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
    @Override // c.b.a.a.g.b.q3
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
                n3.g(bArr, j3, (byte) charAt);
                i4++;
                j3 = 1 + j3;
            } else if (i4 != length) {
                return (int) j3;
            } else {
                while (i4 < length) {
                    char charAt3 = charSequence.charAt(i4);
                    if (charAt3 < c3 && j3 < j4) {
                        long j6 = j3 + j5;
                        n3.g(bArr, j3, (byte) charAt3);
                        j2 = j5;
                        j = j6;
                        c2 = c3;
                    } else if (charAt3 < 2048 && j3 <= j4 - 2) {
                        long j7 = j3 + j5;
                        n3.g(bArr, j3, (byte) ((charAt3 >>> 6) | 960));
                        long j8 = j7 + j5;
                        n3.g(bArr, j7, (byte) ((charAt3 & '?') | RecyclerView.a0.FLAG_IGNORE));
                        c2 = 128;
                        j = j8;
                        j2 = j5;
                    } else if ((charAt3 < 55296 || 57343 < charAt3) && j3 <= j4 - 3) {
                        long j9 = j3 + j5;
                        n3.g(bArr, j3, (byte) ((charAt3 >>> '\f') | 480));
                        long j10 = j9 + j5;
                        n3.g(bArr, j9, (byte) (((charAt3 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                        n3.g(bArr, j10, (byte) ((charAt3 & '?') | RecyclerView.a0.FLAG_IGNORE));
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
                                n3.g(bArr, j3, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                c2 = 128;
                                n3.g(bArr, j11, (byte) (((codePoint >>> 12) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                long j13 = j12 + 1;
                                n3.g(bArr, j12, (byte) (((codePoint >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                j2 = 1;
                                j = j13 + 1;
                                n3.g(bArr, j13, (byte) ((codePoint & 63) | RecyclerView.a0.FLAG_IGNORE));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new s3(i4 - 1, length);
                    } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt3, charSequence.charAt(i3)))) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j3);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    } else {
                        throw new s3(i4, length);
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

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0045 A[LOOP:1: B:10:0x0045->B:35:0x011d, LOOP_START, PHI: r2 r4 r9 r14 
      PHI: (r2v3 long) = (r2v1 long), (r2v4 long) binds: [B:8:0x003f, B:35:0x011d] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v5 long) = (r4v4 long), (r4v7 long) binds: [B:8:0x003f, B:35:0x011d] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r9v4 int) = (r9v3 int), (r9v6 int) binds: [B:8:0x003f, B:35:0x011d] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r14v1 char) = (r14v0 char), (r14v2 char) binds: [B:8:0x003f, B:35:0x011d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0041  */
    @Override // c.b.a.a.g.b.q3
    public final void c(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        long j;
        char c2;
        long j2;
        int i2;
        char charAt;
        ByteBuffer byteBuffer2 = byteBuffer;
        long k = n3.f3369f.k(byteBuffer2, n3.j);
        long position = ((long) byteBuffer.position()) + k;
        long limit = ((long) byteBuffer.limit()) + k;
        int length = charSequence.length();
        if (((long) length) <= limit - position) {
            int i3 = 0;
            while (true) {
                char c3 = 128;
                if (i3 < length && (charAt = charSequence.charAt(i3)) < 128) {
                    n3.f3369f.b(position, (byte) charAt);
                    i3++;
                    position = 1 + position;
                } else if (i3 != length) {
                    i = (int) (position - k);
                } else {
                    while (i3 < length) {
                        char charAt2 = charSequence.charAt(i3);
                        if (charAt2 >= c3 || position >= limit) {
                            if (charAt2 >= 2048 || position > limit - 2) {
                                j = k;
                                if ((charAt2 < 55296 || 57343 < charAt2) && position <= limit - 3) {
                                    long j3 = position + 1;
                                    n3.f3369f.b(position, (byte) ((charAt2 >>> '\f') | 480));
                                    long j4 = j3 + 1;
                                    n3.f3369f.b(j3, (byte) (((charAt2 >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                    n3.f3369f.b(j4, (byte) ((charAt2 & '?') | RecyclerView.a0.FLAG_IGNORE));
                                    j2 = j4 + 1;
                                } else if (position <= limit - 4) {
                                    int i4 = i3 + 1;
                                    if (i4 != length) {
                                        char charAt3 = charSequence.charAt(i4);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            long j5 = position + 1;
                                            n3.f3369f.b(position, (byte) ((codePoint >>> 18) | 240));
                                            long j6 = j5 + 1;
                                            n3.f3369f.b(j5, (byte) (((codePoint >>> 12) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                            long j7 = j6 + 1;
                                            n3.f3369f.b(j6, (byte) (((codePoint >>> 6) & 63) | RecyclerView.a0.FLAG_IGNORE));
                                            j2 = j7 + 1;
                                            c2 = 128;
                                            n3.f3369f.b(j7, (byte) ((codePoint & 63) | RecyclerView.a0.FLAG_IGNORE));
                                            i3 = i4;
                                        } else {
                                            i3 = i4;
                                        }
                                    }
                                    throw new s3(i3 - 1, length);
                                } else if (55296 > charAt2 || charAt2 > 57343 || ((i2 = i3 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i2)))) {
                                    StringBuilder sb = new StringBuilder(46);
                                    sb.append("Failed writing ");
                                    sb.append(charAt2);
                                    sb.append(" at index ");
                                    sb.append(position);
                                    throw new ArrayIndexOutOfBoundsException(sb.toString());
                                } else {
                                    throw new s3(i3, length);
                                }
                            } else {
                                j = k;
                                long j8 = position + 1;
                                n3.f3369f.b(position, (byte) ((charAt2 >>> 6) | 960));
                                j2 = j8 + 1;
                                n3.f3369f.b(j8, (byte) ((charAt2 & '?') | RecyclerView.a0.FLAG_IGNORE));
                            }
                            c2 = 128;
                        } else {
                            n3.f3369f.b(position, (byte) charAt2);
                            c2 = 128;
                            j2 = position + 1;
                            j = k;
                        }
                        i3++;
                        c3 = c2;
                        position = j2;
                        k = j;
                    }
                    i = (int) (position - k);
                    byteBuffer2 = byteBuffer;
                }
            }
            if (i3 != length) {
            }
            byteBuffer2.position(i);
            return;
        }
        char charAt4 = charSequence.charAt(length - 1);
        int limit2 = byteBuffer.limit();
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Failed writing ");
        sb2.append(charAt4);
        sb2.append(" at index ");
        sb2.append(limit2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }
}
