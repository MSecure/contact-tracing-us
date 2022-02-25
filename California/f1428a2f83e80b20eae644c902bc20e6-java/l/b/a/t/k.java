package l.b.a.t;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.b.a.a;
import l.b.a.b;
import l.b.a.g;
import l.b.a.l;
import l.b.a.w.d;
import l.b.a.w.f;
import l.b.a.w.i;
import l.b.a.w.j;
import l.b.a.w.m;
import l.b.a.w.n;
import l.b.a.w.o;

public final class k extends a<k> implements Serializable {
    public static final Integer[] A;
    public static final Integer[] B = new Integer[f4075j.length];
    public static final Integer[] C = new Integer[f4076k.length];
    public static final Integer[] D = new Integer[f4077l.length];
    public static final Integer[] E = new Integer[p.length];

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f4074i;

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f4075j = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4076k = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f4077l = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    public static final int[] m = {0, 1, 0, 1, 0, 1, 1};
    public static final int[] n = {1, 9999, 11, 51, 5, 29, 354};
    public static final int[] o = {1, 9999, 11, 52, 6, 30, 355};
    public static final int[] p = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    public static final char q;
    public static final String r = File.pathSeparator;
    public static final String s;
    public static final HashMap<Integer, Integer[]> t = new HashMap<>();
    public static final HashMap<Integer, Integer[]> u = new HashMap<>();
    public static final HashMap<Integer, Integer[]> v = new HashMap<>();
    public static final Long[] w = new Long[334];
    public static final Integer[] x = new Integer[m.length];
    public static final Integer[] y = new Integer[n.length];
    public static final Integer[] z = new Integer[o.length];
    public final transient l b;
    public final transient int c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f4078d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f4079e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f4080f;

    /* renamed from: g  reason: collision with root package name */
    public final transient b f4081g;

    /* renamed from: h  reason: collision with root package name */
    public final long f4082h;

    static {
        int[] iArr = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
        f4074i = iArr;
        char c2 = File.separatorChar;
        q = c2;
        s = "org" + c2 + "threeten" + c2 + "bp" + c2 + "chrono";
        A = new Integer[iArr.length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr2 = f4074i;
            if (i3 >= iArr2.length) {
                break;
            }
            A[i3] = Integer.valueOf(iArr2[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            int[] iArr3 = f4075j;
            if (i4 >= iArr3.length) {
                break;
            }
            B[i4] = Integer.valueOf(iArr3[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr4 = f4076k;
            if (i5 >= iArr4.length) {
                break;
            }
            C[i5] = Integer.valueOf(iArr4[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr5 = f4077l;
            if (i6 >= iArr5.length) {
                break;
            }
            D[i6] = Integer.valueOf(iArr5[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            int[] iArr6 = p;
            if (i7 >= iArr6.length) {
                break;
            }
            E[i7] = Integer.valueOf(iArr6[i7]);
            i7++;
        }
        int i8 = 0;
        while (true) {
            Long[] lArr = w;
            if (i8 >= lArr.length) {
                break;
            }
            lArr[i8] = Long.valueOf((long) (i8 * 10631));
            i8++;
        }
        int i9 = 0;
        while (true) {
            int[] iArr7 = m;
            if (i9 >= iArr7.length) {
                break;
            }
            x[i9] = Integer.valueOf(iArr7[i9]);
            i9++;
        }
        int i10 = 0;
        while (true) {
            int[] iArr8 = n;
            if (i10 >= iArr8.length) {
                break;
            }
            y[i10] = Integer.valueOf(iArr8[i10]);
            i10++;
        }
        while (true) {
            int[] iArr9 = o;
            if (i2 < iArr9.length) {
                z[i2] = Integer.valueOf(iArr9[i2]);
                i2++;
            } else {
                try {
                    R();
                    return;
                } catch (IOException | ParseException unused) {
                    return;
                }
            }
        }
    }

    public k(long j2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Long l2;
        int i8;
        long j3 = j2 - -492148;
        if (j3 >= 0) {
            Long[] lArr = w;
            for (int i9 = 0; i9 < lArr.length; i9++) {
                try {
                    if (j3 < lArr[i9].longValue()) {
                        i7 = i9 - 1;
                        break;
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    i8 = ((int) j3) / 10631;
                }
            }
            i8 = ((int) j3) / 10631;
            i7 = i8;
            try {
                l2 = w[i7];
            } catch (ArrayIndexOutOfBoundsException unused2) {
                l2 = null;
            }
            int longValue = (int) (j3 - (l2 == null ? Long.valueOf((long) (i7 * 10631)) : l2).longValue());
            int L = L(i7, (long) longValue);
            i6 = I(i7, longValue, L);
            i5 = (i7 * 30) + L + 1;
            i4 = K(i6, i5);
            i3 = H(i6, i4, i5) + 1;
            i2 = 1;
        } else {
            int i10 = (int) j3;
            int i11 = i10 / 10631;
            int i12 = i10 % 10631;
            if (i12 == 0) {
                i12 = -10631;
                i11++;
            }
            int L2 = L(i11, (long) i12);
            int I = I(i11, i12, L2);
            i5 = 1 - ((i11 * 30) - L2);
            i6 = M((long) i5) ? I + 355 : I + 354;
            i4 = K(i6, i5);
            i3 = H(i6, i4, i5) + 1;
            i2 = 0;
        }
        int i13 = (int) ((j3 + 5) % 7);
        int[] iArr = {i2, i5, i4 + 1, i3, i6 + 1, i13 + (i13 <= 0 ? 7 : 0)};
        int i14 = iArr[1];
        if (i14 < 1 || i14 > 9999) {
            throw new a("Invalid year of Hijrah Era");
        }
        int i15 = iArr[2];
        if (i15 < 1 || i15 > 12) {
            throw new a("Invalid month of Hijrah date");
        }
        E(iArr[3]);
        int i16 = iArr[4];
        if (i16 < 1 || i16 > z[6].intValue()) {
            throw new a("Invalid day of year of Hijrah date");
        }
        this.b = l.q(iArr[0]);
        int i17 = iArr[1];
        this.c = i17;
        this.f4078d = iArr[2];
        this.f4079e = iArr[3];
        this.f4080f = iArr[4];
        this.f4081g = b.r(iArr[5]);
        this.f4082h = j2;
        M((long) i17);
    }

    public static void E(int i2) {
        if (i2 < 1 || i2 > z[5].intValue()) {
            throw new a("Invalid day of month of Hijrah date, day " + i2 + " greater than " + z[5].intValue() + " or less than 1");
        }
    }

    public static Integer[] F(int i2) {
        Integer[] numArr;
        try {
            numArr = v.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? E : numArr;
    }

    public static Integer[] G(int i2) {
        Integer[] numArr;
        try {
            numArr = t.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? M((long) i2) ? B : A : numArr;
    }

    public static int H(int i2, int i3, int i4) {
        Integer num;
        Integer[] G = G(i4);
        if (i2 < 0) {
            i2 = M((long) i4) ? i2 + 355 : i2 + 354;
            if (i3 <= 0) {
                return i2;
            }
            num = G[i3];
        } else if (i3 <= 0) {
            return i2;
        } else {
            num = G[i3];
        }
        return i2 - num.intValue();
    }

    public static int I(int i2, int i3, int i4) {
        Integer[] F = F(i2);
        return i3 > 0 ? i3 - F[i4].intValue() : F[i4].intValue() + i3;
    }

    public static long J(int i2, int i3, int i4) {
        Long l2;
        int i5 = i2 - 1;
        int i6 = i5 / 30;
        int i7 = i5 % 30;
        int intValue = F(i6)[Math.abs(i7)].intValue();
        if (i7 < 0) {
            intValue = -intValue;
        }
        try {
            l2 = w[i6];
        } catch (ArrayIndexOutOfBoundsException unused) {
            l2 = null;
        }
        if (l2 == null) {
            l2 = Long.valueOf((long) (i6 * 10631));
        }
        return (((l2.longValue() + ((long) intValue)) - 492148) - 1) + ((long) G(i2)[i3 - 1].intValue()) + ((long) i4);
    }

    public static int K(int i2, int i3) {
        Integer[] G = G(i3);
        int i4 = 0;
        if (i2 >= 0) {
            while (i4 < G.length) {
                if (i2 < G[i4].intValue()) {
                    return i4 - 1;
                }
                i4++;
            }
            return 11;
        }
        int i5 = M((long) i3) ? i2 + 355 : i2 + 354;
        while (i4 < G.length) {
            if (i5 < G[i4].intValue()) {
                return i4 - 1;
            }
            i4++;
        }
        return 11;
    }

    public static int L(int i2, long j2) {
        Integer[] F = F(i2);
        int i3 = 0;
        int i4 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i4 == 0) {
            return 0;
        }
        if (i4 > 0) {
            while (i3 < F.length) {
                if (j2 < ((long) F[i3].intValue())) {
                    return i3 - 1;
                }
                i3++;
            }
            return 29;
        }
        long j3 = -j2;
        while (i3 < F.length) {
            if (j3 <= ((long) F[i3].intValue())) {
                return i3 - 1;
            }
            i3++;
        }
        return 29;
    }

    public static boolean M(long j2) {
        if (j2 <= 0) {
            j2 = -j2;
        }
        return ((j2 * 11) + 14) % 30 < 11;
    }

    public static k N(int i2, int i3, int i4) {
        return i2 >= 1 ? O(l.AH, i2, i3, i4) : O(l.BEFORE_AH, 1 - i2, i3, i4);
    }

    public static k O(l lVar, int i2, int i3, int i4) {
        f.b.a.c.b.o.b.B1(lVar, "era");
        if (i2 < 1 || i2 > 9999) {
            throw new a("Invalid year of Hijrah Era");
        } else if (i3 < 1 || i3 > 12) {
            throw new a("Invalid month of Hijrah date");
        } else {
            E(i4);
            if (lVar != l.AH) {
                i2 = 1 - i2;
            }
            return new k(J(i2, i3, i4));
        }
    }

    public static void P(String str, int i2) {
        StringTokenizer stringTokenizer;
        int i3 = i2;
        StringTokenizer stringTokenizer2 = new StringTokenizer(str, ";");
        while (stringTokenizer2.hasMoreTokens()) {
            String nextToken = stringTokenizer2.nextToken();
            int indexOf = nextToken.indexOf(58);
            if (indexOf != -1) {
                try {
                    int parseInt = Integer.parseInt(nextToken.substring(indexOf + 1, nextToken.length()));
                    int indexOf2 = nextToken.indexOf(45);
                    if (indexOf2 != -1) {
                        String substring = nextToken.substring(0, indexOf2);
                        String substring2 = nextToken.substring(indexOf2 + 1, indexOf);
                        int indexOf3 = substring.indexOf(47);
                        int indexOf4 = substring2.indexOf(47);
                        if (indexOf3 != -1) {
                            String substring3 = substring.substring(0, indexOf3);
                            String substring4 = substring.substring(indexOf3 + 1, substring.length());
                            try {
                                int parseInt2 = Integer.parseInt(substring3);
                                try {
                                    int parseInt3 = Integer.parseInt(substring4);
                                    if (indexOf4 != -1) {
                                        String substring5 = substring2.substring(0, indexOf4);
                                        String substring6 = substring2.substring(indexOf4 + 1, substring2.length());
                                        try {
                                            int parseInt4 = Integer.parseInt(substring5);
                                            try {
                                                int parseInt5 = Integer.parseInt(substring6);
                                                if (parseInt2 == -1 || parseInt3 == -1 || parseInt4 == -1 || parseInt5 == -1) {
                                                    throw new ParseException(f.a.a.a.a.r("Unknown error at line ", i2, "."), i2);
                                                } else if (parseInt2 < 1) {
                                                    throw new IllegalArgumentException("startYear < 1");
                                                } else if (parseInt4 < 1) {
                                                    throw new IllegalArgumentException("endYear < 1");
                                                } else if (parseInt3 < 0 || parseInt3 > 11) {
                                                    throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
                                                } else if (parseInt5 < 0 || parseInt5 > 11) {
                                                    throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
                                                } else if (parseInt4 > 9999) {
                                                    throw new IllegalArgumentException("endYear > 9999");
                                                } else if (parseInt4 < parseInt2) {
                                                    throw new IllegalArgumentException("startYear > endYear");
                                                } else if (parseInt4 != parseInt2 || parseInt5 >= parseInt3) {
                                                    boolean M = M((long) parseInt2);
                                                    Integer[] numArr = t.get(Integer.valueOf(parseInt2));
                                                    if (numArr == null) {
                                                        if (!M) {
                                                            numArr = new Integer[f4074i.length];
                                                            int i4 = 0;
                                                            while (true) {
                                                                int[] iArr = f4074i;
                                                                if (i4 >= iArr.length) {
                                                                    break;
                                                                }
                                                                numArr[i4] = Integer.valueOf(iArr[i4]);
                                                                i4++;
                                                            }
                                                        } else {
                                                            numArr = new Integer[f4075j.length];
                                                            int i5 = 0;
                                                            while (true) {
                                                                int[] iArr2 = f4075j;
                                                                if (i5 >= iArr2.length) {
                                                                    break;
                                                                }
                                                                numArr[i5] = Integer.valueOf(iArr2[i5]);
                                                                i5++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr2 = new Integer[numArr.length];
                                                    for (int i6 = 0; i6 < 12; i6++) {
                                                        if (i6 > parseInt3) {
                                                            numArr2[i6] = Integer.valueOf(numArr[i6].intValue() - parseInt);
                                                        } else {
                                                            numArr2[i6] = Integer.valueOf(numArr[i6].intValue());
                                                        }
                                                    }
                                                    t.put(Integer.valueOf(parseInt2), numArr2);
                                                    Integer[] numArr3 = u.get(Integer.valueOf(parseInt2));
                                                    if (numArr3 == null) {
                                                        if (!M) {
                                                            numArr3 = new Integer[f4076k.length];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int[] iArr3 = f4076k;
                                                                if (i7 >= iArr3.length) {
                                                                    break;
                                                                }
                                                                numArr3[i7] = Integer.valueOf(iArr3[i7]);
                                                                i7++;
                                                            }
                                                        } else {
                                                            numArr3 = new Integer[f4077l.length];
                                                            int i8 = 0;
                                                            while (true) {
                                                                int[] iArr4 = f4077l;
                                                                if (i8 >= iArr4.length) {
                                                                    break;
                                                                }
                                                                numArr3[i8] = Integer.valueOf(iArr4[i8]);
                                                                i8++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr4 = new Integer[numArr3.length];
                                                    for (int i9 = 0; i9 < 12; i9++) {
                                                        if (i9 == parseInt3) {
                                                            numArr4[i9] = Integer.valueOf(numArr3[i9].intValue() - parseInt);
                                                        } else {
                                                            numArr4[i9] = Integer.valueOf(numArr3[i9].intValue());
                                                        }
                                                    }
                                                    u.put(Integer.valueOf(parseInt2), numArr4);
                                                    if (parseInt2 != parseInt4) {
                                                        int i10 = parseInt2 - 1;
                                                        int i11 = i10 / 30;
                                                        int i12 = i10 % 30;
                                                        Integer[] numArr5 = v.get(Integer.valueOf(i11));
                                                        if (numArr5 == null) {
                                                            int length = p.length;
                                                            Integer[] numArr6 = new Integer[length];
                                                            for (int i13 = 0; i13 < length; i13++) {
                                                                numArr6[i13] = Integer.valueOf(p[i13]);
                                                            }
                                                            numArr5 = numArr6;
                                                        }
                                                        for (int i14 = i12 + 1; i14 < p.length; i14++) {
                                                            numArr5[i14] = Integer.valueOf(numArr5[i14].intValue() - parseInt);
                                                        }
                                                        v.put(Integer.valueOf(i11), numArr5);
                                                        int i15 = parseInt4 - 1;
                                                        int i16 = i15 / 30;
                                                        if (i11 != i16) {
                                                            int i17 = i11 + 1;
                                                            while (true) {
                                                                Long[] lArr = w;
                                                                if (i17 >= lArr.length) {
                                                                    break;
                                                                }
                                                                lArr[i17] = Long.valueOf(lArr[i17].longValue() - ((long) parseInt));
                                                                i17++;
                                                                stringTokenizer2 = stringTokenizer2;
                                                            }
                                                            StringTokenizer stringTokenizer3 = stringTokenizer2;
                                                            int i18 = i16 + 1;
                                                            while (true) {
                                                                Long[] lArr2 = w;
                                                                if (i18 >= lArr2.length) {
                                                                    break;
                                                                }
                                                                lArr2[i18] = Long.valueOf(lArr2[i18].longValue() + ((long) parseInt));
                                                                i18++;
                                                                stringTokenizer3 = stringTokenizer3;
                                                            }
                                                            stringTokenizer = stringTokenizer3;
                                                        } else {
                                                            stringTokenizer = stringTokenizer2;
                                                        }
                                                        int i19 = i15 % 30;
                                                        Integer[] numArr7 = v.get(Integer.valueOf(i16));
                                                        if (numArr7 == null) {
                                                            int length2 = p.length;
                                                            Integer[] numArr8 = new Integer[length2];
                                                            for (int i20 = 0; i20 < length2; i20++) {
                                                                numArr8[i20] = Integer.valueOf(p[i20]);
                                                            }
                                                            numArr7 = numArr8;
                                                        }
                                                        while (true) {
                                                            i19++;
                                                            if (i19 >= p.length) {
                                                                break;
                                                            }
                                                            numArr7[i19] = Integer.valueOf(numArr7[i19].intValue() + parseInt);
                                                        }
                                                        v.put(Integer.valueOf(i16), numArr7);
                                                    } else {
                                                        stringTokenizer = stringTokenizer2;
                                                    }
                                                    boolean M2 = M((long) parseInt4);
                                                    Integer[] numArr9 = t.get(Integer.valueOf(parseInt4));
                                                    if (numArr9 == null) {
                                                        if (!M2) {
                                                            numArr9 = new Integer[f4074i.length];
                                                            int i21 = 0;
                                                            while (true) {
                                                                int[] iArr5 = f4074i;
                                                                if (i21 >= iArr5.length) {
                                                                    break;
                                                                }
                                                                numArr9[i21] = Integer.valueOf(iArr5[i21]);
                                                                i21++;
                                                            }
                                                        } else {
                                                            numArr9 = new Integer[f4075j.length];
                                                            int i22 = 0;
                                                            while (true) {
                                                                int[] iArr6 = f4075j;
                                                                if (i22 >= iArr6.length) {
                                                                    break;
                                                                }
                                                                numArr9[i22] = Integer.valueOf(iArr6[i22]);
                                                                i22++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr10 = new Integer[numArr9.length];
                                                    for (int i23 = 0; i23 < 12; i23++) {
                                                        if (i23 > parseInt5) {
                                                            numArr10[i23] = Integer.valueOf(numArr9[i23].intValue() + parseInt);
                                                        } else {
                                                            numArr10[i23] = Integer.valueOf(numArr9[i23].intValue());
                                                        }
                                                    }
                                                    t.put(Integer.valueOf(parseInt4), numArr10);
                                                    Integer[] numArr11 = u.get(Integer.valueOf(parseInt4));
                                                    if (numArr11 == null) {
                                                        if (!M2) {
                                                            numArr11 = new Integer[f4076k.length];
                                                            int i24 = 0;
                                                            while (true) {
                                                                int[] iArr7 = f4076k;
                                                                if (i24 >= iArr7.length) {
                                                                    break;
                                                                }
                                                                numArr11[i24] = Integer.valueOf(iArr7[i24]);
                                                                i24++;
                                                            }
                                                        } else {
                                                            numArr11 = new Integer[f4077l.length];
                                                            int i25 = 0;
                                                            while (true) {
                                                                int[] iArr8 = f4077l;
                                                                if (i25 >= iArr8.length) {
                                                                    break;
                                                                }
                                                                numArr11[i25] = Integer.valueOf(iArr8[i25]);
                                                                i25++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr12 = new Integer[numArr11.length];
                                                    for (int i26 = 0; i26 < 12; i26++) {
                                                        if (i26 == parseInt5) {
                                                            numArr12[i26] = Integer.valueOf(numArr11[i26].intValue() + parseInt);
                                                        } else {
                                                            numArr12[i26] = Integer.valueOf(numArr11[i26].intValue());
                                                        }
                                                    }
                                                    HashMap<Integer, Integer[]> hashMap = u;
                                                    hashMap.put(Integer.valueOf(parseInt4), numArr12);
                                                    Integer[] numArr13 = hashMap.get(Integer.valueOf(parseInt2));
                                                    Integer[] numArr14 = hashMap.get(Integer.valueOf(parseInt4));
                                                    HashMap<Integer, Integer[]> hashMap2 = t;
                                                    int intValue = numArr13[parseInt3].intValue();
                                                    int intValue2 = numArr14[parseInt5].intValue();
                                                    int intValue3 = numArr13[11].intValue() + hashMap2.get(Integer.valueOf(parseInt2))[11].intValue();
                                                    int intValue4 = numArr14[11].intValue() + hashMap2.get(Integer.valueOf(parseInt4))[11].intValue();
                                                    Integer[] numArr15 = z;
                                                    int intValue5 = numArr15[5].intValue();
                                                    Integer[] numArr16 = y;
                                                    int intValue6 = numArr16[5].intValue();
                                                    if (intValue5 < intValue) {
                                                        intValue5 = intValue;
                                                    }
                                                    if (intValue5 < intValue2) {
                                                        intValue5 = intValue2;
                                                    }
                                                    numArr15[5] = Integer.valueOf(intValue5);
                                                    if (intValue6 <= intValue) {
                                                        intValue = intValue6;
                                                    }
                                                    if (intValue <= intValue2) {
                                                        intValue2 = intValue;
                                                    }
                                                    numArr16[5] = Integer.valueOf(intValue2);
                                                    int intValue7 = numArr15[6].intValue();
                                                    int intValue8 = numArr16[6].intValue();
                                                    if (intValue7 < intValue3) {
                                                        intValue7 = intValue3;
                                                    }
                                                    if (intValue7 < intValue4) {
                                                        intValue7 = intValue4;
                                                    }
                                                    numArr15[6] = Integer.valueOf(intValue7);
                                                    if (intValue8 <= intValue3) {
                                                        intValue3 = intValue8;
                                                    }
                                                    if (intValue3 <= intValue4) {
                                                        intValue4 = intValue3;
                                                    }
                                                    numArr16[6] = Integer.valueOf(intValue4);
                                                    stringTokenizer2 = stringTokenizer;
                                                    i3 = i2;
                                                } else {
                                                    throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
                                                }
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException(f.a.a.a.a.r("End month is not properly set at line ", i3, "."), i3);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException(f.a.a.a.a.r("End year is not properly set at line ", i3, "."), i3);
                                        }
                                    } else {
                                        throw new ParseException(f.a.a.a.a.r("End year/month has incorrect format at line ", i3, "."), i3);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException(f.a.a.a.a.r("Start month is not properly set at line ", i3, "."), i3);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException(f.a.a.a.a.r("Start year is not properly set at line ", i3, "."), i3);
                            }
                        } else {
                            throw new ParseException(f.a.a.a.a.r("Start year/month has incorrect format at line ", i3, "."), i3);
                        }
                    } else {
                        throw new ParseException(f.a.a.a.a.r("Start and end year/month has incorrect format at line ", i3, "."), i3);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException(f.a.a.a.a.r("Offset is not properly set at line ", i3, "."), i3);
                }
            } else {
                throw new ParseException(f.a.a.a.a.r("Offset has incorrect format at line ", i3, "."), i3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0104 A[SYNTHETIC, Splitter:B:50:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static void R() {
        InputStream inputStream;
        Throwable th;
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = "hijrah_deviation.cfg";
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        BufferedReader bufferedReader = null;
        if (property2 != null) {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                StringBuilder h2 = f.a.a.a.a.h(property2);
                h2.append(System.getProperty("file.separator"));
                property2 = h2.toString();
            }
            StringBuilder h3 = f.a.a.a.a.h(property2);
            h3.append(q);
            h3.append(property);
            File file = new File(h3.toString());
            if (file.exists()) {
                try {
                    inputStream = new FileInputStream(file);
                    if (inputStream != null) {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                            int i2 = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine != null) {
                                        i2++;
                                        P(readLine.trim(), i2);
                                    } else {
                                        bufferedReader2.close();
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    bufferedReader = bufferedReader2;
                                    if (bufferedReader != null) {
                                        bufferedReader.close();
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (bufferedReader != null) {
                            }
                            throw th;
                        }
                    } else {
                        return;
                    }
                } catch (IOException e2) {
                    throw e2;
                }
            }
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), r);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String nextToken = stringTokenizer.nextToken();
                File file2 = new File(nextToken);
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        StringBuilder h4 = f.a.a.a.a.h(nextToken);
                        char c2 = q;
                        h4.append(c2);
                        String str = s;
                        h4.append(str);
                        if (new File(h4.toString(), property).exists()) {
                            try {
                                inputStream = new FileInputStream(nextToken + c2 + str + c2 + property);
                                break;
                            } catch (IOException e3) {
                                throw e3;
                            }
                        }
                    } else {
                        try {
                            zipFile = new ZipFile(file2);
                        } catch (IOException unused) {
                            zipFile = null;
                        }
                        if (zipFile != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(s);
                            char c3 = q;
                            sb.append(c3);
                            sb.append(property);
                            String sb2 = sb.toString();
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry == null) {
                                if (c3 == '/') {
                                    sb2 = sb2.replace('/', '\\');
                                } else if (c3 == '\\') {
                                    sb2 = sb2.replace('\\', '/');
                                }
                                entry = zipFile.getEntry(sb2);
                            }
                            if (entry != null) {
                                try {
                                    inputStream = zipFile.getInputStream(entry);
                                    break;
                                } catch (IOException e4) {
                                    throw e4;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (inputStream != null) {
            }
        }
        inputStream = null;
        if (inputStream != null) {
        }
    }

    public static k S(int i2, int i3, int i4) {
        int intValue = G(i2)[i3 - 1].intValue();
        if (i4 > intValue) {
            i4 = intValue;
        }
        return N(i2, i3, i4);
    }

    private Object readResolve() {
        return new k(this.f4082h);
    }

    private Object writeReplace() {
        return new u((byte) 3, this);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<k> A(long j2, m mVar) {
        return (k) super.v(j2, mVar);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<k> B(long j2) {
        return new k(this.f4082h + j2);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<k> C(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.f4078d - 1) + ((int) j2);
        int i3 = i2 / 12;
        int i4 = i2 % 12;
        while (i4 < 0) {
            i4 += 12;
            i3 = f.b.a.c.b.o.b.K1(i3, 1);
        }
        return O(this.b, f.b.a.c.b.o.b.G1(this.c, i3), i4 + 1, this.f4079e);
    }

    /* Return type fixed from 'l.b.a.t.a' to match base method */
    @Override // l.b.a.t.a
    public a<k> D(long j2) {
        if (j2 == 0) {
            return this;
        }
        return O(this.b, f.b.a.c.b.o.b.G1(this.c, (int) j2), this.f4078d, this.f4079e);
    }

    public k Q(long j2) {
        return new k(this.f4082h + j2);
    }

    /* renamed from: T */
    public k z(j jVar, long j2) {
        if (!(jVar instanceof l.b.a.w.a)) {
            return (k) jVar.c(this, j2);
        }
        l.b.a.w.a aVar = (l.b.a.w.a) jVar;
        aVar.f4182e.b(j2, aVar);
        int i2 = (int) j2;
        switch (aVar.ordinal()) {
            case 15:
                return Q(j2 - ((long) this.f4081g.q()));
            case 16:
                return Q(j2 - i(l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return Q(j2 - i(l.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                return S(this.c, this.f4078d, i2);
            case 19:
                int i3 = i2 - 1;
                return S(this.c, (i3 / 30) + 1, (i3 % 30) + 1);
            case 20:
                return new k((long) i2);
            case 21:
                return Q((j2 - i(l.b.a.w.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 22:
                return Q((j2 - i(l.b.a.w.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 23:
                return S(this.c, i2, this.f4079e);
            case 24:
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
            case 25:
                if (this.c < 1) {
                    i2 = 1 - i2;
                }
                return S(i2, this.f4078d, this.f4079e);
            case 26:
                return S(i2, this.f4078d, this.f4079e);
            case 27:
                return S(1 - this.c, this.f4078d, this.f4079e);
        }
    }

    @Override // l.b.a.v.c, l.b.a.w.e
    public o a(j jVar) {
        long j2;
        int i2;
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.l(this);
        }
        if (f(jVar)) {
            l.b.a.w.a aVar = (l.b.a.w.a) jVar;
            int ordinal = aVar.ordinal();
            Integer[] numArr = null;
            if (ordinal == 18) {
                int i3 = this.f4078d - 1;
                int i4 = this.c;
                try {
                    numArr = u.get(Integer.valueOf(i4));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                if (numArr == null) {
                    numArr = M((long) i4) ? D : C;
                }
                j2 = (long) numArr[i3].intValue();
            } else if (ordinal == 19) {
                int i5 = this.c;
                int i6 = i5 - 1;
                int i7 = i6 / 30;
                try {
                    numArr = v.get(Integer.valueOf(i7));
                } catch (ArrayIndexOutOfBoundsException unused2) {
                }
                if (numArr != null) {
                    int i8 = i6 % 30;
                    if (i8 == 29) {
                        Long[] lArr = w;
                        i2 = (lArr[i7 + 1].intValue() - lArr[i7].intValue()) - numArr[i8].intValue();
                    } else {
                        i2 = numArr[i8 + 1].intValue() - numArr[i8].intValue();
                    }
                } else {
                    i2 = M((long) i5) ? 355 : 354;
                }
                j2 = (long) i2;
            } else if (ordinal == 21) {
                j2 = 5;
            } else if (ordinal != 25) {
                j jVar2 = j.f4070d;
                return aVar.f4182e;
            } else {
                j2 = 1000;
            }
            return o.d(1, j2);
        }
        throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
    }

    @Override // l.b.a.w.d, l.b.a.t.b
    public d e(f fVar) {
        return (k) j.f4070d.e(fVar.n(this));
    }

    @Override // l.b.a.w.d, l.b.a.t.b, l.b.a.v.b
    public d h(long j2, m mVar) {
        return (k) super.h(j2, mVar);
    }

    @Override // l.b.a.w.e
    public long i(j jVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!(jVar instanceof l.b.a.w.a)) {
            return jVar.f(this);
        }
        switch (((l.b.a.w.a) jVar).ordinal()) {
            case 15:
                i2 = this.f4081g.q();
                break;
            case 16:
                i4 = this.f4079e;
                i3 = (i4 - 1) % 7;
                i2 = i3 + 1;
                break;
            case 17:
                i4 = this.f4080f;
                i3 = (i4 - 1) % 7;
                i2 = i3 + 1;
                break;
            case 18:
                i2 = this.f4079e;
                break;
            case 19:
                i2 = this.f4080f;
                break;
            case 20:
                return x();
            case 21:
                i5 = this.f4079e;
                i3 = (i5 - 1) / 7;
                i2 = i3 + 1;
                break;
            case 22:
                i5 = this.f4080f;
                i3 = (i5 - 1) / 7;
                i2 = i3 + 1;
                break;
            case 23:
                i2 = this.f4078d;
                break;
            case 24:
            default:
                throw new n(f.a.a.a.a.d("Unsupported field: ", jVar));
            case 25:
            case 26:
                i2 = this.c;
                break;
            case 27:
                return (long) this.b.ordinal();
        }
        return (long) i2;
    }

    @Override // l.b.a.w.d, l.b.a.t.a, l.b.a.t.b
    public d m(long j2, m mVar) {
        return (k) super.v(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public final c<k> q(g gVar) {
        return new d(this, gVar);
    }

    @Override // l.b.a.t.b
    public h s() {
        return j.f4070d;
    }

    @Override // l.b.a.t.b
    public i t() {
        return this.b;
    }

    @Override // l.b.a.t.b
    public b u(long j2, m mVar) {
        return (k) super.h(j2, mVar);
    }

    @Override // l.b.a.t.a, l.b.a.t.b
    public b v(long j2, m mVar) {
        return (k) super.v(j2, mVar);
    }

    @Override // l.b.a.t.b
    public b w(i iVar) {
        return (k) j.f4070d.e(((l) iVar).b(this));
    }

    @Override // l.b.a.t.b
    public long x() {
        return J(this.c, this.f4078d, this.f4079e);
    }

    @Override // l.b.a.t.b
    public b y(f fVar) {
        return (k) j.f4070d.e(fVar.n(this));
    }
}
