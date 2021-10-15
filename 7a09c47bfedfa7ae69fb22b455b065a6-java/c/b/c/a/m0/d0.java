package c.b.c.a.m0;

import c.a.a.a.a;
import java.util.Arrays;

public final class d0 {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f5117a = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f5118b = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f5119c = {67108863, 33554431};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f5120d = {26, 25};

    public static byte[] a(long[] jArr) {
        long[] copyOf = Arrays.copyOf(jArr, 10);
        for (int i = 0; i < 2; i++) {
            int i2 = 0;
            while (i2 < 9) {
                long j = copyOf[i2] & (copyOf[i2] >> 31);
                int[] iArr = f5120d;
                int i3 = i2 & 1;
                int i4 = -((int) (j >> iArr[i3]));
                copyOf[i2] = copyOf[i2] + ((long) (i4 << iArr[i3]));
                i2++;
                copyOf[i2] = copyOf[i2] - ((long) i4);
            }
            int i5 = -((int) (((copyOf[9] >> 31) & copyOf[9]) >> 25));
            copyOf[9] = copyOf[9] + ((long) (i5 << 25));
            copyOf[0] = copyOf[0] - ((long) (i5 * 19));
        }
        int i6 = -((int) ((copyOf[0] & (copyOf[0] >> 31)) >> 26));
        copyOf[0] = copyOf[0] + ((long) (i6 << 26));
        copyOf[1] = copyOf[1] - ((long) i6);
        for (int i7 = 0; i7 < 2; i7++) {
            int i8 = 0;
            while (i8 < 9) {
                int i9 = i8 & 1;
                copyOf[i8] = copyOf[i8] & ((long) f5119c[i9]);
                i8++;
                copyOf[i8] = copyOf[i8] + ((long) ((int) (copyOf[i8] >> f5120d[i9])));
            }
        }
        copyOf[9] = copyOf[9] & 33554431;
        copyOf[0] = copyOf[0] + ((long) (((int) (copyOf[9] >> 25)) * 19));
        int i10 = ~((((int) copyOf[0]) - 67108845) >> 31);
        for (int i11 = 1; i11 < 10; i11++) {
            int i12 = ~(((int) copyOf[i11]) ^ f5119c[i11 & 1]);
            int i13 = i12 & (i12 << 16);
            int i14 = i13 & (i13 << 8);
            int i15 = i14 & (i14 << 4);
            int i16 = i15 & (i15 << 2);
            i10 &= (i16 & (i16 << 1)) >> 31;
        }
        copyOf[0] = copyOf[0] - ((long) (67108845 & i10));
        long j2 = (long) (33554431 & i10);
        copyOf[1] = copyOf[1] - j2;
        for (int i17 = 2; i17 < 10; i17 += 2) {
            copyOf[i17] = copyOf[i17] - ((long) (67108863 & i10));
            int i18 = i17 + 1;
            copyOf[i18] = copyOf[i18] - j2;
        }
        for (int i19 = 0; i19 < 10; i19++) {
            copyOf[i19] = copyOf[i19] << f5118b[i19];
        }
        byte[] bArr = new byte[32];
        for (int i20 = 0; i20 < 10; i20++) {
            int[] iArr2 = f5117a;
            int i21 = iArr2[i20];
            bArr[i21] = (byte) ((int) (((long) bArr[i21]) | (copyOf[i20] & 255)));
            int i22 = iArr2[i20] + 1;
            bArr[i22] = (byte) ((int) (((long) bArr[i22]) | ((copyOf[i20] >> 8) & 255)));
            int i23 = iArr2[i20] + 2;
            bArr[i23] = (byte) ((int) (((long) bArr[i23]) | ((copyOf[i20] >> 16) & 255)));
            int i24 = iArr2[i20] + 3;
            bArr[i24] = (byte) ((int) (((long) bArr[i24]) | ((copyOf[i20] >> 24) & 255)));
        }
        return bArr;
    }

    public static long[] b(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i = 0; i < 10; i++) {
            int[] iArr = f5117a;
            jArr[i] = ((((((long) (bArr[iArr[i]] & 255)) | (((long) (bArr[iArr[i] + 1] & 255)) << 8)) | (((long) (bArr[iArr[i] + 2] & 255)) << 16)) | (((long) (bArr[iArr[i] + 3] & 255)) << 24)) >> f5118b[i]) & ((long) f5119c[i & 1]);
        }
        return jArr;
    }

    public static void c(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr2[0] * jArr3[1];
        long j2 = (jArr2[0] * jArr3[2]) + (jArr2[1] * 2 * jArr3[1]);
        long j3 = (jArr2[0] * jArr3[3]) + (jArr2[2] * jArr3[1]) + (jArr2[1] * jArr3[2]);
        long j4 = (jArr2[0] * jArr3[4]) + (((jArr2[3] * jArr3[1]) + (jArr2[1] * jArr3[3])) * 2) + (jArr2[2] * jArr3[2]);
        long j5 = (jArr2[0] * jArr3[5]) + (jArr2[4] * jArr3[1]) + (jArr2[1] * jArr3[4]) + (jArr2[3] * jArr3[2]) + (jArr2[2] * jArr3[3]);
        long j6 = (jArr2[0] * jArr3[6]) + (jArr2[4] * jArr3[2]) + (jArr2[2] * jArr3[4]) + a.j(jArr2[5], jArr3[1], (jArr2[1] * jArr3[5]) + (jArr2[3] * jArr3[3]), 2);
        long j7 = (jArr2[0] * jArr3[7]) + (jArr2[6] * jArr3[1]) + (jArr2[1] * jArr3[6]) + (jArr2[5] * jArr3[2]) + (jArr2[2] * jArr3[5]) + (jArr2[4] * jArr3[3]) + (jArr2[3] * jArr3[4]);
        long j8 = (jArr2[0] * jArr3[8]) + (jArr2[6] * jArr3[2]) + (jArr2[2] * jArr3[6]) + (((jArr2[7] * jArr3[1]) + (jArr2[1] * jArr3[7]) + (jArr2[5] * jArr3[3]) + (jArr2[3] * jArr3[5])) * 2) + (jArr2[4] * jArr3[4]);
        long j9 = (jArr2[0] * jArr3[9]) + (jArr2[8] * jArr3[1]) + (jArr2[1] * jArr3[8]) + (jArr2[7] * jArr3[2]) + (jArr2[2] * jArr3[7]) + (jArr2[6] * jArr3[3]) + (jArr2[3] * jArr3[6]) + (jArr2[5] * jArr3[4]) + (jArr2[4] * jArr3[5]);
        long j10 = (jArr2[2] * jArr3[8]) + (jArr2[6] * jArr3[4]) + (jArr2[4] * jArr3[6]) + a.j(jArr2[9], jArr3[1], (jArr2[1] * jArr3[9]) + (jArr2[7] * jArr3[3]) + (jArr2[3] * jArr3[7]) + (jArr2[5] * jArr3[5]), 2);
        long j11 = (jArr2[2] * jArr3[9]) + (jArr2[8] * jArr3[3]) + (jArr2[3] * jArr3[8]) + (jArr2[7] * jArr3[4]) + (jArr2[4] * jArr3[7]) + (jArr2[6] * jArr3[5]) + (jArr2[5] * jArr3[6]);
        long j12 = (jArr2[4] * jArr3[8]) + (((jArr2[9] * jArr3[3]) + (jArr2[3] * jArr3[9]) + (jArr2[7] * jArr3[5]) + (jArr2[5] * jArr3[7])) * 2) + (jArr2[6] * jArr3[6]);
        long j13 = (jArr2[4] * jArr3[9]) + (jArr2[8] * jArr3[5]) + (jArr2[5] * jArr3[8]) + (jArr2[7] * jArr3[6]) + (jArr2[6] * jArr3[7]);
        long j14 = jArr2[7] * jArr3[7];
        d(new long[]{jArr2[0] * jArr3[0], (jArr2[1] * jArr3[0]) + j, (jArr2[2] * jArr3[0]) + j2, (jArr2[3] * jArr3[0]) + j3, (jArr2[4] * jArr3[0]) + j4, (jArr2[5] * jArr3[0]) + j5, (jArr2[6] * jArr3[0]) + j6, (jArr2[7] * jArr3[0]) + j7, (jArr2[8] * jArr3[0]) + j8, (jArr2[9] * jArr3[0]) + j9, (jArr2[8] * jArr3[2]) + j10, (jArr2[9] * jArr3[2]) + j11, (jArr2[8] * jArr3[4]) + j12, (jArr2[9] * jArr3[4]) + j13, (jArr2[8] * jArr3[6]) + (jArr2[6] * jArr3[8]) + a.j(jArr2[9], jArr3[5], (jArr2[5] * jArr3[9]) + j14, 2), (jArr2[9] * jArr3[6]) + (jArr2[6] * jArr3[9]) + (jArr2[8] * jArr3[7]) + (jArr2[7] * jArr3[8]), (((jArr2[9] * jArr3[7]) + (jArr2[7] * jArr3[9])) * 2) + (jArr2[8] * jArr3[8]), (jArr2[9] * jArr3[8]) + (jArr2[8] * jArr3[9]), jArr2[9] * 2 * jArr3[9]}, jArr);
    }

    public static void d(long[] jArr, long[] jArr2) {
        long[] jArr3 = jArr;
        if (jArr3.length != 19) {
            long[] jArr4 = new long[19];
            System.arraycopy(jArr3, 0, jArr4, 0, jArr3.length);
            jArr3 = jArr4;
        }
        jArr3[8] = jArr3[8] + (jArr3[18] << 4);
        jArr3[8] = jArr3[8] + (jArr3[18] << 1);
        jArr3[8] = jArr3[8] + jArr3[18];
        jArr3[7] = jArr3[7] + (jArr3[17] << 4);
        jArr3[7] = jArr3[7] + (jArr3[17] << 1);
        jArr3[7] = jArr3[7] + jArr3[17];
        jArr3[6] = jArr3[6] + (jArr3[16] << 4);
        jArr3[6] = jArr3[6] + (jArr3[16] << 1);
        jArr3[6] = jArr3[6] + jArr3[16];
        jArr3[5] = jArr3[5] + (jArr3[15] << 4);
        jArr3[5] = jArr3[5] + (jArr3[15] << 1);
        jArr3[5] = jArr3[5] + jArr3[15];
        jArr3[4] = jArr3[4] + (jArr3[14] << 4);
        jArr3[4] = jArr3[4] + (jArr3[14] << 1);
        jArr3[4] = jArr3[4] + jArr3[14];
        jArr3[3] = jArr3[3] + (jArr3[13] << 4);
        jArr3[3] = jArr3[3] + (jArr3[13] << 1);
        jArr3[3] = jArr3[3] + jArr3[13];
        jArr3[2] = jArr3[2] + (jArr3[12] << 4);
        jArr3[2] = jArr3[2] + (jArr3[12] << 1);
        jArr3[2] = jArr3[2] + jArr3[12];
        jArr3[1] = jArr3[1] + (jArr3[11] << 4);
        jArr3[1] = jArr3[1] + (jArr3[11] << 1);
        jArr3[1] = jArr3[1] + jArr3[11];
        jArr3[0] = jArr3[0] + (jArr3[10] << 4);
        jArr3[0] = jArr3[0] + (jArr3[10] << 1);
        jArr3[0] = jArr3[0] + jArr3[10];
        jArr3[10] = 0;
        int i = 0;
        while (i < 10) {
            long j = jArr3[i] / 67108864;
            jArr3[i] = jArr3[i] - (j << 26);
            int i2 = i + 1;
            jArr3[i2] = jArr3[i2] + j;
            long j2 = jArr3[i2] / 33554432;
            jArr3[i2] = jArr3[i2] - (j2 << 25);
            i += 2;
            jArr3[i] = jArr3[i] + j2;
        }
        jArr3[0] = jArr3[0] + (jArr3[10] << 4);
        jArr3[0] = jArr3[0] + (jArr3[10] << 1);
        jArr3[0] = jArr3[0] + jArr3[10];
        jArr3[10] = 0;
        long j3 = jArr3[0] / 67108864;
        jArr3[0] = jArr3[0] - (j3 << 26);
        jArr3[1] = jArr3[1] + j3;
        System.arraycopy(jArr3, 0, jArr2, 0, 10);
    }

    public static void e(long[] jArr, long[] jArr2) {
        d(new long[]{jArr2[0] * jArr2[0], jArr2[0] * 2 * jArr2[1], a.j(jArr2[0], jArr2[2], jArr2[1] * jArr2[1], 2), a.j(jArr2[0], jArr2[3], jArr2[1] * jArr2[2], 2), (jArr2[0] * 2 * jArr2[4]) + (jArr2[1] * 4 * jArr2[3]) + (jArr2[2] * jArr2[2]), a.j(jArr2[0], jArr2[5], (jArr2[1] * jArr2[4]) + (jArr2[2] * jArr2[3]), 2), a.j(jArr2[1] * 2, jArr2[5], (jArr2[0] * jArr2[6]) + (jArr2[2] * jArr2[4]) + (jArr2[3] * jArr2[3]), 2), a.j(jArr2[0], jArr2[7], (jArr2[1] * jArr2[6]) + (jArr2[2] * jArr2[5]) + (jArr2[3] * jArr2[4]), 2), (((((jArr2[3] * jArr2[5]) + (jArr2[1] * jArr2[7])) * 2) + (jArr2[0] * jArr2[8]) + (jArr2[2] * jArr2[6])) * 2) + (jArr2[4] * jArr2[4]), a.j(jArr2[0], jArr2[9], (jArr2[1] * jArr2[8]) + (jArr2[2] * jArr2[7]) + (jArr2[3] * jArr2[6]) + (jArr2[4] * jArr2[5]), 2), ((((jArr2[1] * jArr2[9]) + (jArr2[3] * jArr2[7])) * 2) + (jArr2[2] * jArr2[8]) + (jArr2[4] * jArr2[6]) + (jArr2[5] * jArr2[5])) * 2, a.j(jArr2[2], jArr2[9], (jArr2[3] * jArr2[8]) + (jArr2[4] * jArr2[7]) + (jArr2[5] * jArr2[6]), 2), (((((jArr2[3] * jArr2[9]) + (jArr2[5] * jArr2[7])) * 2) + (jArr2[4] * jArr2[8])) * 2) + (jArr2[6] * jArr2[6]), a.j(jArr2[4], jArr2[9], (jArr2[5] * jArr2[8]) + (jArr2[6] * jArr2[7]), 2), a.j(jArr2[5] * 2, jArr2[9], (jArr2[6] * jArr2[8]) + (jArr2[7] * jArr2[7]), 2), a.j(jArr2[6], jArr2[9], jArr2[7] * jArr2[8], 2), (jArr2[7] * 4 * jArr2[9]) + (jArr2[8] * jArr2[8]), jArr2[8] * 2 * jArr2[9], jArr2[9] * 2 * jArr2[9]}, jArr);
    }

    public static void f(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] - jArr3[i];
        }
    }

    public static void g(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 10; i++) {
            jArr[i] = jArr2[i] + jArr3[i];
        }
    }
}
