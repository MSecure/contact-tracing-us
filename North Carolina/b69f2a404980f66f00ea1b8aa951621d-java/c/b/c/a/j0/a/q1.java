package c.b.c.a.j0.a;

import androidx.recyclerview.widget.RecyclerView;

public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3635a = ((!(p1.h && p1.g) || d.a()) ? new b() : new d());

    public static abstract class a {
        public abstract String a(byte[] bArr, int i, int i2);

        public abstract int b(CharSequence charSequence, byte[] bArr, int i, int i2);

        public abstract int c(int i, byte[] bArr, int i2, int i3);
    }

    public static final class b extends a {
        @Override // c.b.c.a.j0.a.q1.a
        public String a(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte b2 = bArr[i];
                    if (!c.b.a.a.c.n.c.c(b2)) {
                        break;
                    }
                    i++;
                    cArr[i4] = (char) b2;
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte b3 = bArr[i];
                    if (c.b.a.a.c.n.c.c(b3)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) b3;
                        i = i6;
                        while (true) {
                            i5 = i7;
                            if (i >= i3) {
                                break;
                            }
                            byte b4 = bArr[i];
                            if (!c.b.a.a.c.n.c.c(b4)) {
                                break;
                            }
                            i++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) b4;
                        }
                    } else {
                        if (!(b3 < -32)) {
                            if (b3 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    c.b.a.a.c.n.c.i(b3, bArr[i6], bArr[i8], cArr, i5);
                                    i = i8 + 1;
                                    i5++;
                                } else {
                                    throw b0.c();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                byte b5 = bArr[i6];
                                int i10 = i9 + 1;
                                c.b.a.a.c.n.c.a(b3, b5, bArr[i9], bArr[i10], cArr, i5);
                                i5 = i5 + 1 + 1;
                                i = i10 + 1;
                            } else {
                                throw b0.c();
                            }
                        } else if (i6 < i3) {
                            c.b.a.a.c.n.c.f(b3, bArr[i6], cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw b0.c();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        @Override // c.b.c.a.j0.a.q1.a
        public int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
                    bArr[i9] = (byte) ((charAt2 & '?') | RecyclerView.d0.FLAG_IGNORE);
                    i7++;
                } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                    int i10 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 >>> '\f') | 480);
                    int i11 = i10 + 1;
                    bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | RecyclerView.d0.FLAG_IGNORE);
                    i4 = i11 + 1;
                    bArr[i11] = (byte) ((charAt2 & '?') | RecyclerView.d0.FLAG_IGNORE);
                } else if (i8 <= i6 - 4) {
                    int i12 = i7 + 1;
                    if (i12 != charSequence.length()) {
                        char charAt3 = charSequence.charAt(i12);
                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                            int i13 = i8 + 1;
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            int i14 = i13 + 1;
                            bArr[i13] = (byte) (((codePoint >>> 12) & 63) | RecyclerView.d0.FLAG_IGNORE);
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) (((codePoint >>> 6) & 63) | RecyclerView.d0.FLAG_IGNORE);
                            i8 = i15 + 1;
                            bArr[i15] = (byte) ((codePoint & 63) | RecyclerView.d0.FLAG_IGNORE);
                            i7 = i12;
                            i7++;
                        } else {
                            i7 = i12;
                        }
                    }
                    throw new c(i7 - 1, length);
                } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                    throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i8);
                } else {
                    throw new c(i7, length);
                }
                i8 = i4;
                i7++;
            }
            return i8;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0047, code lost:
            if (r13[r14] > -65) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0082, code lost:
            if (r13[r14] > -65) goto L_0x0084;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            if (r13[r14] > -65) goto L_0x0022;
         */
        @Override // c.b.c.a.j0.a.q1.a
        public int c(int i, byte[] bArr, int i2, int i3) {
            byte b2;
            int i4;
            if (i != 0) {
                if (i2 >= i3) {
                    return i;
                }
                byte b3 = (byte) i;
                if (b3 < -32) {
                    if (b3 >= -62) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else if (b3 < -16) {
                    byte b4 = (byte) (~(i >> 8));
                    if (b4 == 0) {
                        int i5 = i2 + 1;
                        byte b5 = bArr[i2];
                        if (i5 >= i3) {
                            return q1.a(b3, b5);
                        }
                        i2 = i5;
                        b4 = b5;
                    }
                    if (b4 <= -65 && ((b3 != -32 || b4 >= -96) && (b3 != -19 || b4 < -96))) {
                        i4 = i2 + 1;
                    }
                    return -1;
                } else {
                    byte b6 = (byte) (~(i >> 8));
                    if (b6 == 0) {
                        int i6 = i2 + 1;
                        b6 = bArr[i2];
                        if (i6 >= i3) {
                            return q1.a(b3, b6);
                        }
                        i2 = i6;
                        b2 = 0;
                    } else {
                        b2 = (byte) (i >> 16);
                    }
                    if (b2 == 0) {
                        int i7 = i2 + 1;
                        byte b7 = bArr[i2];
                        if (i7 >= i3) {
                            return q1.e(b3, b6, b7);
                        }
                        i2 = i7;
                        b2 = b7;
                    }
                    if (b6 <= -65) {
                        if ((((b6 + 112) + (b3 << 28)) >> 30) == 0 && b2 <= -65) {
                            i4 = i2 + 1;
                        }
                    }
                    return -1;
                }
                i2 = i4;
            }
            while (i2 < i3 && bArr[i2] >= 0) {
                i2++;
            }
            if (i2 >= i3) {
                return 0;
            }
            while (i2 < i3) {
                int i8 = i2 + 1;
                byte b8 = bArr[i2];
                if (b8 < 0) {
                    if (b8 >= -32) {
                        if (b8 < -16) {
                            if (i8 < i3 - 1) {
                                int i9 = i8 + 1;
                                byte b9 = bArr[i8];
                                if (b9 <= -65 && ((b8 != -32 || b9 >= -96) && (b8 != -19 || b9 < -96))) {
                                    i2 = i9 + 1;
                                    if (bArr[i9] > -65) {
                                    }
                                }
                            }
                        } else if (i8 < i3 - 2) {
                            int i10 = i8 + 1;
                            byte b10 = bArr[i8];
                            if (b10 <= -65) {
                                if ((((b10 + 112) + (b8 << 28)) >> 30) == 0) {
                                    int i11 = i10 + 1;
                                    if (bArr[i10] <= -65) {
                                        i2 = i11 + 1;
                                        if (bArr[i11] > -65) {
                                        }
                                    }
                                }
                            }
                        }
                        return q1.b(bArr, i8, i3);
                    } else if (i8 >= i3) {
                        return b8;
                    } else {
                        if (b8 >= -62) {
                            i2 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    return -1;
                }
                i2 = i8;
            }
            return 0;
        }
    }

    public static class c extends IllegalArgumentException {
        public c(int i, int i2) {
            super("Unpaired surrogate at index " + i + " of " + i2);
        }
    }

    public static final class d extends a {
        public static int d(byte[] bArr, int i, long j, int i2) {
            if (i2 == 0) {
                return q1.c(i);
            }
            if (i2 == 1) {
                return q1.a(i, p1.g(bArr, j));
            }
            if (i2 == 2) {
                return q1.e(i, p1.g(bArr, j), p1.g(bArr, j + 1));
            }
            throw new AssertionError();
        }

        @Override // c.b.c.a.j0.a.q1.a
        public String a(byte[] bArr, int i, int i2) {
            if ((i | i2 | ((bArr.length - i) - i2)) >= 0) {
                int i3 = i + i2;
                char[] cArr = new char[i2];
                int i4 = 0;
                while (i < i3) {
                    byte g = p1.g(bArr, (long) i);
                    if (!c.b.a.a.c.n.c.c(g)) {
                        break;
                    }
                    i++;
                    cArr[i4] = (char) g;
                    i4++;
                }
                int i5 = i4;
                while (i < i3) {
                    int i6 = i + 1;
                    byte g2 = p1.g(bArr, (long) i);
                    if (c.b.a.a.c.n.c.c(g2)) {
                        int i7 = i5 + 1;
                        cArr[i5] = (char) g2;
                        i = i6;
                        while (true) {
                            i5 = i7;
                            if (i >= i3) {
                                break;
                            }
                            byte g3 = p1.g(bArr, (long) i);
                            if (!c.b.a.a.c.n.c.c(g3)) {
                                break;
                            }
                            i++;
                            i7 = i5 + 1;
                            cArr[i5] = (char) g3;
                        }
                    } else {
                        if (!(g2 < -32)) {
                            if (g2 < -16) {
                                if (i6 < i3 - 1) {
                                    int i8 = i6 + 1;
                                    c.b.a.a.c.n.c.i(g2, p1.g(bArr, (long) i6), p1.g(bArr, (long) i8), cArr, i5);
                                    i = i8 + 1;
                                    i5++;
                                } else {
                                    throw b0.c();
                                }
                            } else if (i6 < i3 - 2) {
                                int i9 = i6 + 1;
                                int i10 = i9 + 1;
                                c.b.a.a.c.n.c.a(g2, p1.g(bArr, (long) i6), p1.g(bArr, (long) i9), p1.g(bArr, (long) i10), cArr, i5);
                                i5 = i5 + 1 + 1;
                                i = i10 + 1;
                            } else {
                                throw b0.c();
                            }
                        } else if (i6 < i3) {
                            c.b.a.a.c.n.c.f(g2, p1.g(bArr, (long) i6), cArr, i5);
                            i = i6 + 1;
                            i5++;
                        } else {
                            throw b0.c();
                        }
                    }
                }
                return new String(cArr, 0, i5);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0031  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0033 A[LOOP:1: B:13:0x0033->B:38:0x00f3, LOOP_START, PHI: r2 r3 r4 r11 
          PHI: (r2v3 int) = (r2v2 int), (r2v5 int) binds: [B:10:0x002f, B:38:0x00f3] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r3v2 char) = (r3v1 char), (r3v3 char) binds: [B:10:0x002f, B:38:0x00f3] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r4v3 long) = (r4v2 long), (r4v4 long) binds: [B:10:0x002f, B:38:0x00f3] A[DONT_GENERATE, DONT_INLINE]
          PHI: (r11v3 long) = (r11v2 long), (r11v4 long) binds: [B:10:0x002f, B:38:0x00f3] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // c.b.c.a.j0.a.q1.a
        public int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
            int i3;
            long j;
            char charAt;
            long j2 = (long) i;
            long j3 = ((long) i2) + j2;
            int length = charSequence.length();
            if (length > i2 || bArr.length - i2 < i) {
                StringBuilder g = c.a.a.a.a.g("Failed writing ");
                g.append(charSequence.charAt(length - 1));
                g.append(" at index ");
                g.append(i + i2);
                throw new ArrayIndexOutOfBoundsException(g.toString());
            }
            int i4 = 0;
            while (true) {
                char c2 = 128;
                long j4 = 1;
                if (i4 < length && (charAt = charSequence.charAt(i4)) < 128) {
                    p1.q(bArr, j2, (byte) charAt);
                    i4++;
                    j2 = 1 + j2;
                } else if (i4 != length) {
                    return (int) j2;
                } else {
                    while (i4 < length) {
                        char charAt2 = charSequence.charAt(i4);
                        if (charAt2 >= c2 || j2 >= j3) {
                            if (charAt2 < 2048 && j2 <= j3 - 2) {
                                long j5 = j2 + j4;
                                p1.q(bArr, j2, (byte) ((charAt2 >>> 6) | 960));
                                j = j5 + j4;
                                p1.q(bArr, j5, (byte) ((charAt2 & '?') | RecyclerView.d0.FLAG_IGNORE));
                            } else if ((charAt2 < 55296 || 57343 < charAt2) && j2 <= j3 - 3) {
                                long j6 = j2 + j4;
                                p1.q(bArr, j2, (byte) ((charAt2 >>> '\f') | 480));
                                long j7 = j4 + j6;
                                p1.q(bArr, j6, (byte) (((charAt2 >>> 6) & 63) | RecyclerView.d0.FLAG_IGNORE));
                                j = 1 + j7;
                                p1.q(bArr, j7, (byte) ((charAt2 & '?') | RecyclerView.d0.FLAG_IGNORE));
                                j4 = 1;
                            } else if (j2 <= j3 - 4) {
                                int i5 = i4 + 1;
                                if (i5 != length) {
                                    char charAt3 = charSequence.charAt(i5);
                                    if (Character.isSurrogatePair(charAt2, charAt3)) {
                                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                                        long j8 = j2 + 1;
                                        p1.q(bArr, j2, (byte) ((codePoint >>> 18) | 240));
                                        long j9 = 1 + j8;
                                        p1.q(bArr, j8, (byte) (((codePoint >>> 12) & 63) | RecyclerView.d0.FLAG_IGNORE));
                                        long j10 = 1 + j9;
                                        p1.q(bArr, j9, (byte) (((codePoint >>> 6) & 63) | RecyclerView.d0.FLAG_IGNORE));
                                        j4 = 1;
                                        p1.q(bArr, j10, (byte) ((codePoint & 63) | RecyclerView.d0.FLAG_IGNORE));
                                        i4 = i5;
                                        c2 = 128;
                                        j2 = j10 + 1;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                throw new c(i4 - 1, length);
                            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i4 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j2);
                            } else {
                                throw new c(i4, length);
                            }
                            c2 = 128;
                            j2 = j;
                        } else {
                            p1.q(bArr, j2, (byte) charAt2);
                            j2 += j4;
                        }
                        i4++;
                    }
                    return (int) j2;
                }
            }
            if (i4 != length) {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            if (c.b.c.a.j0.a.p1.g(r25, r8) > -65) goto L_0x003d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:?, code lost:
            return d(r25, r2, r8, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0067, code lost:
            if (c.b.c.a.j0.a.p1.g(r25, r8) > -65) goto L_0x0069;
         */
        @Override // c.b.c.a.j0.a.q1.a
        public int c(int i, byte[] bArr, int i2, int i3) {
            int i4;
            byte b2;
            long j;
            if ((i2 | i3 | (bArr.length - i3)) >= 0) {
                long j2 = (long) i2;
                long j3 = (long) i3;
                if (i != 0) {
                    if (j2 >= j3) {
                        return i;
                    }
                    byte b3 = (byte) i;
                    if (b3 < -32) {
                        if (b3 >= -62) {
                            j = j2 + 1;
                        }
                        return -1;
                    } else if (b3 < -16) {
                        byte b4 = (byte) (~(i >> 8));
                        if (b4 == 0) {
                            long j4 = j2 + 1;
                            b4 = p1.g(bArr, j2);
                            if (j4 >= j3) {
                                return q1.a(b3, b4);
                            }
                            j2 = j4;
                        }
                        if (b4 <= -65 && ((b3 != -32 || b4 >= -96) && (b3 != -19 || b4 < -96))) {
                            j = j2 + 1;
                        }
                        return -1;
                    } else {
                        byte b5 = (byte) (~(i >> 8));
                        if (b5 == 0) {
                            long j5 = j2 + 1;
                            b5 = p1.g(bArr, j2);
                            if (j5 >= j3) {
                                return q1.a(b3, b5);
                            }
                            j2 = j5;
                            b2 = 0;
                        } else {
                            b2 = (byte) (i >> 16);
                        }
                        if (b2 == 0) {
                            long j6 = j2 + 1;
                            b2 = p1.g(bArr, j2);
                            if (j6 >= j3) {
                                return q1.e(b3, b5, b2);
                            }
                            j2 = j6;
                        }
                        if (b5 <= -65) {
                            if ((((b5 + 112) + (b3 << 28)) >> 30) == 0 && b2 <= -65) {
                                long j7 = j2 + 1;
                                if (p1.g(bArr, j2) <= -65) {
                                    j2 = j7;
                                }
                            }
                        }
                        return -1;
                    }
                    j2 = j;
                }
                int i5 = (int) (j3 - j2);
                if (i5 >= 16) {
                    long j8 = j2;
                    i4 = 0;
                    while (true) {
                        if (i4 >= i5) {
                            i4 = i5;
                            break;
                        }
                        long j9 = j8 + 1;
                        if (p1.g(bArr, j8) < 0) {
                            break;
                        }
                        i4++;
                        j8 = j9;
                    }
                } else {
                    i4 = 0;
                }
                int i6 = i5 - i4;
                long j10 = j2 + ((long) i4);
                while (true) {
                    byte b6 = 0;
                    while (true) {
                        if (i6 <= 0) {
                            break;
                        }
                        long j11 = j10 + 1;
                        byte g = p1.g(bArr, j10);
                        if (g < 0) {
                            j10 = j11;
                            b6 = g;
                            break;
                        }
                        i6--;
                        j10 = j11;
                        b6 = g;
                    }
                    if (i6 != 0) {
                        int i7 = i6 - 1;
                        if (b6 >= -32) {
                            if (b6 >= -16) {
                                if (i7 >= 3) {
                                    i6 = i7 - 3;
                                    long j12 = j10 + 1;
                                    byte g2 = p1.g(bArr, j10);
                                    if (g2 > -65) {
                                        break;
                                    }
                                    if ((((g2 + 112) + (b6 << 28)) >> 30) != 0) {
                                        break;
                                    }
                                    long j13 = j12 + 1;
                                    if (p1.g(bArr, j12) > -65) {
                                        break;
                                    }
                                    long j14 = j13 + 1;
                                    if (p1.g(bArr, j13) > -65) {
                                        break;
                                    }
                                    j10 = j14;
                                } else {
                                    break;
                                }
                            } else if (i7 >= 2) {
                                i6 = i7 - 2;
                                long j15 = j10 + 1;
                                byte g3 = p1.g(bArr, j10);
                                if (g3 > -65 || ((b6 == -32 && g3 < -96) || (b6 == -19 && g3 >= -96))) {
                                    break;
                                }
                                j10 = j15 + 1;
                                if (p1.g(bArr, j15) > -65) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else if (i7 != 0) {
                            i6 = i7 - 1;
                            if (b6 < -62) {
                                break;
                            }
                            long j16 = j10 + 1;
                            if (p1.g(bArr, j10) > -65) {
                                break;
                            }
                            j10 = j16;
                        } else {
                            return b6;
                        }
                    } else {
                        return 0;
                    }
                }
                return -1;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
    }

    public static int a(int i, int i2) {
        if (i > -12 || i2 > -65) {
            return -1;
        }
        return i ^ (i2 << 8);
    }

    public static int b(byte[] bArr, int i, int i2) {
        byte b2 = bArr[i - 1];
        int i3 = i2 - i;
        int i4 = -1;
        if (i3 == 0) {
            if (b2 > -12) {
                b2 = -1;
            }
            return b2;
        } else if (i3 == 1) {
            byte b3 = bArr[i];
            if (b2 <= -12 && b3 <= -65) {
                i4 = b2 ^ (b3 << 8);
            }
            return i4;
        } else if (i3 == 2) {
            return e(b2, bArr[i], bArr[i + 1]);
        } else {
            throw new AssertionError();
        }
    }

    public static int c(int i) {
        if (i > -12) {
            return -1;
        }
        return i;
    }

    public static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) >= 65536) {
                                i2++;
                            } else {
                                throw new c(i2, length2);
                            }
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        StringBuilder g = c.a.a.a.a.g("UTF-8 length does not fit in int: ");
        g.append(((long) i3) + 4294967296L);
        throw new IllegalArgumentException(g.toString());
    }

    public static int e(int i, int i2, int i3) {
        if (i > -12 || i2 > -65 || i3 > -65) {
            return -1;
        }
        return (i ^ (i2 << 8)) ^ (i3 << 16);
    }

    public static boolean f(byte[] bArr, int i, int i2) {
        return f3635a.c(0, bArr, i, i2) == 0;
    }
}
