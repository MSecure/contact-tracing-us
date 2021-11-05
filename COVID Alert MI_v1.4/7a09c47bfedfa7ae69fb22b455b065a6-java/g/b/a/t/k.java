package g.b.a.t;

import b.x.t;
import c.a.a.a.a;
import g.b.a.b;
import g.b.a.e;
import g.b.a.g;
import g.b.a.l;
import g.b.a.w.d;
import g.b.a.w.f;
import g.b.a.w.i;
import g.b.a.w.j;
import g.b.a.w.m;
import g.b.a.w.n;
import g.b.a.w.o;
import java.io.BufferedReader;
import java.io.DataInput;
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

public final class k extends a<k> implements Serializable {
    public static final Integer[] A = new Integer[i.length];
    public static final Integer[] B = new Integer[j.length];
    public static final Integer[] C = new Integer[k.length];
    public static final Integer[] D = new Integer[l.length];
    public static final Integer[] E = new Integer[p.length];
    public static final int[] i = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    public static final int[] j = {0, 30, 59, 89, 118, 148, 177, 207, 236, 266, 295, 325};
    public static final int[] k = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
    public static final int[] l = {30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
    public static final int[] m = {0, 1, 0, 1, 0, 1, 1};
    public static final int[] n = {1, 9999, 11, 51, 5, 29, 354};
    public static final int[] o = {1, 9999, 11, 52, 6, 30, 355};
    public static final int[] p = {0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
    public static final char q = File.separatorChar;
    public static final String r = File.pathSeparator;
    public static final String s;
    public static final HashMap<Integer, Integer[]> t = new HashMap<>();
    public static final HashMap<Integer, Integer[]> u = new HashMap<>();
    public static final HashMap<Integer, Integer[]> v = new HashMap<>();
    public static final Long[] w = new Long[334];
    public static final Integer[] x = new Integer[m.length];
    public static final Integer[] y = new Integer[n.length];
    public static final Integer[] z = new Integer[o.length];

    /* renamed from: b  reason: collision with root package name */
    public final transient l f6467b;

    /* renamed from: c  reason: collision with root package name */
    public final transient int f6468c;

    /* renamed from: d  reason: collision with root package name */
    public final transient int f6469d;

    /* renamed from: e  reason: collision with root package name */
    public final transient int f6470e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f6471f;

    /* renamed from: g  reason: collision with root package name */
    public final transient b f6472g;
    public final long h;

    static {
        StringBuilder h2 = a.h("org");
        h2.append(q);
        h2.append("threeten");
        h2.append(q);
        h2.append("bp");
        h2.append(q);
        h2.append("chrono");
        s = h2.toString();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = i;
            if (i3 >= iArr.length) {
                break;
            }
            A[i3] = Integer.valueOf(iArr[i3]);
            i3++;
        }
        int i4 = 0;
        while (true) {
            int[] iArr2 = j;
            if (i4 >= iArr2.length) {
                break;
            }
            B[i4] = Integer.valueOf(iArr2[i4]);
            i4++;
        }
        int i5 = 0;
        while (true) {
            int[] iArr3 = k;
            if (i5 >= iArr3.length) {
                break;
            }
            C[i5] = Integer.valueOf(iArr3[i5]);
            i5++;
        }
        int i6 = 0;
        while (true) {
            int[] iArr4 = l;
            if (i6 >= iArr4.length) {
                break;
            }
            D[i6] = Integer.valueOf(iArr4[i6]);
            i6++;
        }
        int i7 = 0;
        while (true) {
            int[] iArr5 = p;
            if (i7 >= iArr5.length) {
                break;
            }
            E[i7] = Integer.valueOf(iArr5[i7]);
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
            int[] iArr6 = m;
            if (i9 >= iArr6.length) {
                break;
            }
            x[i9] = Integer.valueOf(iArr6[i9]);
            i9++;
        }
        int i10 = 0;
        while (true) {
            int[] iArr7 = n;
            if (i10 >= iArr7.length) {
                break;
            }
            y[i10] = Integer.valueOf(iArr7[i10]);
            i10++;
        }
        while (true) {
            int[] iArr8 = o;
            if (i2 < iArr8.length) {
                z[i2] = Integer.valueOf(iArr8[i2]);
                i2++;
            } else {
                try {
                    j0();
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
            int d0 = d0(i7, (long) longValue);
            i6 = a0(i7, longValue, d0);
            i5 = (i7 * 30) + d0 + 1;
            i4 = c0(i6, i5);
            i3 = Z(i6, i4, i5) + 1;
            i2 = 1;
        } else {
            int i10 = (int) j3;
            int i11 = i10 / 10631;
            int i12 = i10 % 10631;
            if (i12 == 0) {
                i12 = -10631;
                i11++;
            }
            int d02 = d0(i11, (long) i12);
            int a0 = a0(i11, i12, d02);
            i5 = 1 - ((i11 * 30) - d02);
            i6 = e0((long) i5) ? a0 + 355 : a0 + 354;
            i4 = c0(i6, i5);
            i3 = Z(i6, i4, i5) + 1;
            i2 = 0;
        }
        int i13 = (int) ((j3 + 5) % 7);
        int[] iArr = {i2, i5, i4 + 1, i3, i6 + 1, i13 + (i13 <= 0 ? 7 : 0)};
        int i14 = iArr[1];
        if (i14 < 1 || i14 > 9999) {
            throw new g.b.a.a("Invalid year of Hijrah Era");
        }
        int i15 = iArr[2];
        if (i15 < 1 || i15 > 12) {
            throw new g.b.a.a("Invalid month of Hijrah date");
        }
        W(iArr[3]);
        int i16 = iArr[4];
        if (i16 < 1 || i16 > z[6].intValue()) {
            throw new g.b.a.a("Invalid day of year of Hijrah date");
        }
        this.f6467b = l.p(iArr[0]);
        this.f6468c = iArr[1];
        this.f6469d = iArr[2];
        this.f6470e = iArr[3];
        this.f6471f = iArr[4];
        this.f6472g = b.x(iArr[5]);
        this.h = j2;
        e0((long) this.f6468c);
    }

    public static void W(int i2) {
        if (i2 < 1 || i2 > z[5].intValue()) {
            StringBuilder i3 = a.i("Invalid day of month of Hijrah date, day ", i2, " greater than ");
            i3.append(z[5].intValue());
            i3.append(" or less than 1");
            throw new g.b.a.a(i3.toString());
        }
    }

    public static Integer[] X(int i2) {
        Integer[] numArr;
        try {
            numArr = v.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? E : numArr;
    }

    public static Integer[] Y(int i2) {
        Integer[] numArr;
        try {
            numArr = t.get(Integer.valueOf(i2));
        } catch (ArrayIndexOutOfBoundsException unused) {
            numArr = null;
        }
        return numArr == null ? e0((long) i2) ? B : A : numArr;
    }

    public static int Z(int i2, int i3, int i4) {
        Integer num;
        Integer[] Y = Y(i4);
        if (i2 < 0) {
            i2 = e0((long) i4) ? i2 + 355 : i2 + 354;
            if (i3 <= 0) {
                return i2;
            }
            num = Y[i3];
        } else if (i3 <= 0) {
            return i2;
        } else {
            num = Y[i3];
        }
        return i2 - num.intValue();
    }

    public static int a0(int i2, int i3, int i4) {
        Integer[] X = X(i2);
        return i3 > 0 ? i3 - X[i4].intValue() : X[i4].intValue() + i3;
    }

    public static long b0(int i2, int i3, int i4) {
        Long l2;
        int i5 = i2 - 1;
        int i6 = i5 / 30;
        int i7 = i5 % 30;
        int intValue = X(i6)[Math.abs(i7)].intValue();
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
        return (((l2.longValue() + ((long) intValue)) - 492148) - 1) + ((long) Y(i2)[i3 - 1].intValue()) + ((long) i4);
    }

    public static int c0(int i2, int i3) {
        Integer[] Y = Y(i3);
        int i4 = 0;
        if (i2 >= 0) {
            while (i4 < Y.length) {
                if (i2 < Y[i4].intValue()) {
                    return i4 - 1;
                }
                i4++;
            }
            return 11;
        }
        int i5 = e0((long) i3) ? i2 + 355 : i2 + 354;
        while (i4 < Y.length) {
            if (i5 < Y[i4].intValue()) {
                return i4 - 1;
            }
            i4++;
        }
        return 11;
    }

    public static int d0(int i2, long j2) {
        Integer[] X = X(i2);
        int i3 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        int i4 = 0;
        if (i3 == 0) {
            return 0;
        }
        if (i3 > 0) {
            while (i4 < X.length) {
                if (j2 < ((long) X[i4].intValue())) {
                    return i4 - 1;
                }
                i4++;
            }
            return 29;
        }
        long j3 = -j2;
        while (i4 < X.length) {
            if (j3 <= ((long) X[i4].intValue())) {
                return i4 - 1;
            }
            i4++;
        }
        return 29;
    }

    public static boolean e0(long j2) {
        if (j2 <= 0) {
            j2 = -j2;
        }
        return ((j2 * 11) + 14) % 30 < 11;
    }

    public static k f0(int i2, int i3, int i4) {
        return i2 >= 1 ? g0(l.AH, i2, i3, i4) : g0(l.BEFORE_AH, 1 - i2, i3, i4);
    }

    public static k g0(l lVar, int i2, int i3, int i4) {
        t.y2(lVar, "era");
        if (i2 < 1 || i2 > 9999) {
            throw new g.b.a.a("Invalid year of Hijrah Era");
        } else if (i3 < 1 || i3 > 12) {
            throw new g.b.a.a("Invalid month of Hijrah date");
        } else {
            W(i4);
            if (lVar != l.AH) {
                i2 = 1 - i2;
            }
            return new k(b0(i2, i3, i4));
        }
    }

    public static void h0(String str, int i2) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
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
                                                    throw new ParseException(a.o("Unknown error at line ", i2, "."), i2);
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
                                                    boolean e0 = e0((long) parseInt2);
                                                    Integer[] numArr = t.get(Integer.valueOf(parseInt2));
                                                    if (numArr == null) {
                                                        if (!e0) {
                                                            numArr = new Integer[i.length];
                                                            int i3 = 0;
                                                            while (true) {
                                                                int[] iArr = i;
                                                                if (i3 >= iArr.length) {
                                                                    break;
                                                                }
                                                                numArr[i3] = Integer.valueOf(iArr[i3]);
                                                                i3++;
                                                            }
                                                        } else {
                                                            numArr = new Integer[j.length];
                                                            int i4 = 0;
                                                            while (true) {
                                                                int[] iArr2 = j;
                                                                if (i4 >= iArr2.length) {
                                                                    break;
                                                                }
                                                                numArr[i4] = Integer.valueOf(iArr2[i4]);
                                                                i4++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr2 = new Integer[numArr.length];
                                                    for (int i5 = 0; i5 < 12; i5++) {
                                                        if (i5 > parseInt3) {
                                                            numArr2[i5] = Integer.valueOf(numArr[i5].intValue() - parseInt);
                                                        } else {
                                                            numArr2[i5] = Integer.valueOf(numArr[i5].intValue());
                                                        }
                                                    }
                                                    t.put(Integer.valueOf(parseInt2), numArr2);
                                                    Integer[] numArr3 = u.get(Integer.valueOf(parseInt2));
                                                    if (numArr3 == null) {
                                                        if (!e0) {
                                                            numArr3 = new Integer[k.length];
                                                            int i6 = 0;
                                                            while (true) {
                                                                int[] iArr3 = k;
                                                                if (i6 >= iArr3.length) {
                                                                    break;
                                                                }
                                                                numArr3[i6] = Integer.valueOf(iArr3[i6]);
                                                                i6++;
                                                            }
                                                        } else {
                                                            numArr3 = new Integer[l.length];
                                                            int i7 = 0;
                                                            while (true) {
                                                                int[] iArr4 = l;
                                                                if (i7 >= iArr4.length) {
                                                                    break;
                                                                }
                                                                numArr3[i7] = Integer.valueOf(iArr4[i7]);
                                                                i7++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr4 = new Integer[numArr3.length];
                                                    for (int i8 = 0; i8 < 12; i8++) {
                                                        if (i8 == parseInt3) {
                                                            numArr4[i8] = Integer.valueOf(numArr3[i8].intValue() - parseInt);
                                                        } else {
                                                            numArr4[i8] = Integer.valueOf(numArr3[i8].intValue());
                                                        }
                                                    }
                                                    u.put(Integer.valueOf(parseInt2), numArr4);
                                                    if (parseInt2 != parseInt4) {
                                                        int i9 = parseInt2 - 1;
                                                        int i10 = i9 / 30;
                                                        int i11 = i9 % 30;
                                                        Integer[] numArr5 = v.get(Integer.valueOf(i10));
                                                        if (numArr5 == null) {
                                                            int length = p.length;
                                                            Integer[] numArr6 = new Integer[length];
                                                            for (int i12 = 0; i12 < length; i12++) {
                                                                numArr6[i12] = Integer.valueOf(p[i12]);
                                                            }
                                                            numArr5 = numArr6;
                                                        }
                                                        for (int i13 = i11 + 1; i13 < p.length; i13++) {
                                                            numArr5[i13] = Integer.valueOf(numArr5[i13].intValue() - parseInt);
                                                        }
                                                        v.put(Integer.valueOf(i10), numArr5);
                                                        int i14 = parseInt4 - 1;
                                                        int i15 = i14 / 30;
                                                        if (i10 != i15) {
                                                            while (true) {
                                                                i10++;
                                                                Long[] lArr = w;
                                                                if (i10 >= lArr.length) {
                                                                    break;
                                                                }
                                                                lArr[i10] = Long.valueOf(lArr[i10].longValue() - ((long) parseInt));
                                                            }
                                                            int i16 = i15 + 1;
                                                            while (true) {
                                                                Long[] lArr2 = w;
                                                                if (i16 >= lArr2.length) {
                                                                    break;
                                                                }
                                                                lArr2[i16] = Long.valueOf(lArr2[i16].longValue() + ((long) parseInt));
                                                                i16++;
                                                            }
                                                        }
                                                        int i17 = i14 % 30;
                                                        Integer[] numArr7 = v.get(Integer.valueOf(i15));
                                                        if (numArr7 == null) {
                                                            int length2 = p.length;
                                                            Integer[] numArr8 = new Integer[length2];
                                                            for (int i18 = 0; i18 < length2; i18++) {
                                                                numArr8[i18] = Integer.valueOf(p[i18]);
                                                            }
                                                            numArr7 = numArr8;
                                                        }
                                                        while (true) {
                                                            i17++;
                                                            if (i17 >= p.length) {
                                                                break;
                                                            }
                                                            numArr7[i17] = Integer.valueOf(numArr7[i17].intValue() + parseInt);
                                                        }
                                                        v.put(Integer.valueOf(i15), numArr7);
                                                    }
                                                    boolean e02 = e0((long) parseInt4);
                                                    Integer[] numArr9 = t.get(Integer.valueOf(parseInt4));
                                                    if (numArr9 == null) {
                                                        if (!e02) {
                                                            numArr9 = new Integer[i.length];
                                                            int i19 = 0;
                                                            while (true) {
                                                                int[] iArr5 = i;
                                                                if (i19 >= iArr5.length) {
                                                                    break;
                                                                }
                                                                numArr9[i19] = Integer.valueOf(iArr5[i19]);
                                                                i19++;
                                                            }
                                                        } else {
                                                            numArr9 = new Integer[j.length];
                                                            int i20 = 0;
                                                            while (true) {
                                                                int[] iArr6 = j;
                                                                if (i20 >= iArr6.length) {
                                                                    break;
                                                                }
                                                                numArr9[i20] = Integer.valueOf(iArr6[i20]);
                                                                i20++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr10 = new Integer[numArr9.length];
                                                    for (int i21 = 0; i21 < 12; i21++) {
                                                        if (i21 > parseInt5) {
                                                            numArr10[i21] = Integer.valueOf(numArr9[i21].intValue() + parseInt);
                                                        } else {
                                                            numArr10[i21] = Integer.valueOf(numArr9[i21].intValue());
                                                        }
                                                    }
                                                    t.put(Integer.valueOf(parseInt4), numArr10);
                                                    Integer[] numArr11 = u.get(Integer.valueOf(parseInt4));
                                                    if (numArr11 == null) {
                                                        if (!e02) {
                                                            numArr11 = new Integer[k.length];
                                                            int i22 = 0;
                                                            while (true) {
                                                                int[] iArr7 = k;
                                                                if (i22 >= iArr7.length) {
                                                                    break;
                                                                }
                                                                numArr11[i22] = Integer.valueOf(iArr7[i22]);
                                                                i22++;
                                                            }
                                                        } else {
                                                            numArr11 = new Integer[l.length];
                                                            int i23 = 0;
                                                            while (true) {
                                                                int[] iArr8 = l;
                                                                if (i23 >= iArr8.length) {
                                                                    break;
                                                                }
                                                                numArr11[i23] = Integer.valueOf(iArr8[i23]);
                                                                i23++;
                                                            }
                                                        }
                                                    }
                                                    Integer[] numArr12 = new Integer[numArr11.length];
                                                    for (int i24 = 0; i24 < 12; i24++) {
                                                        if (i24 == parseInt5) {
                                                            numArr12[i24] = Integer.valueOf(numArr11[i24].intValue() + parseInt);
                                                        } else {
                                                            numArr12[i24] = Integer.valueOf(numArr11[i24].intValue());
                                                        }
                                                    }
                                                    u.put(Integer.valueOf(parseInt4), numArr12);
                                                    Integer[] numArr13 = u.get(Integer.valueOf(parseInt2));
                                                    Integer[] numArr14 = u.get(Integer.valueOf(parseInt4));
                                                    int intValue = numArr13[parseInt3].intValue();
                                                    int intValue2 = numArr14[parseInt5].intValue();
                                                    int intValue3 = numArr13[11].intValue() + t.get(Integer.valueOf(parseInt2))[11].intValue();
                                                    int intValue4 = numArr14[11].intValue() + t.get(Integer.valueOf(parseInt4))[11].intValue();
                                                    int intValue5 = z[5].intValue();
                                                    int intValue6 = y[5].intValue();
                                                    if (intValue5 < intValue) {
                                                        intValue5 = intValue;
                                                    }
                                                    if (intValue5 < intValue2) {
                                                        intValue5 = intValue2;
                                                    }
                                                    z[5] = Integer.valueOf(intValue5);
                                                    if (intValue6 <= intValue) {
                                                        intValue = intValue6;
                                                    }
                                                    if (intValue <= intValue2) {
                                                        intValue2 = intValue;
                                                    }
                                                    y[5] = Integer.valueOf(intValue2);
                                                    int intValue7 = z[6].intValue();
                                                    int intValue8 = y[6].intValue();
                                                    if (intValue7 < intValue3) {
                                                        intValue7 = intValue3;
                                                    }
                                                    if (intValue7 < intValue4) {
                                                        intValue7 = intValue4;
                                                    }
                                                    z[6] = Integer.valueOf(intValue7);
                                                    if (intValue8 <= intValue3) {
                                                        intValue3 = intValue8;
                                                    }
                                                    if (intValue3 <= intValue4) {
                                                        intValue4 = intValue3;
                                                    }
                                                    y[6] = Integer.valueOf(intValue4);
                                                } else {
                                                    throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
                                                }
                                            } catch (NumberFormatException unused) {
                                                throw new ParseException(a.o("End month is not properly set at line ", i2, "."), i2);
                                            }
                                        } catch (NumberFormatException unused2) {
                                            throw new ParseException(a.o("End year is not properly set at line ", i2, "."), i2);
                                        }
                                    } else {
                                        throw new ParseException(a.o("End year/month has incorrect format at line ", i2, "."), i2);
                                    }
                                } catch (NumberFormatException unused3) {
                                    throw new ParseException(a.o("Start month is not properly set at line ", i2, "."), i2);
                                }
                            } catch (NumberFormatException unused4) {
                                throw new ParseException(a.o("Start year is not properly set at line ", i2, "."), i2);
                            }
                        } else {
                            throw new ParseException(a.o("Start year/month has incorrect format at line ", i2, "."), i2);
                        }
                    } else {
                        throw new ParseException(a.o("Start and end year/month has incorrect format at line ", i2, "."), i2);
                    }
                } catch (NumberFormatException unused5) {
                    throw new ParseException(a.o("Offset is not properly set at line ", i2, "."), i2);
                }
            } else {
                throw new ParseException(a.o("Offset has incorrect format at line ", i2, "."), i2);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c A[SYNTHETIC, Splitter:B:50:0x010c] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:71:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    public static void j0() {
        InputStream inputStream;
        Throwable th;
        ZipFile zipFile;
        String property = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (property == null) {
            property = "hijrah_deviation.cfg";
        }
        String property2 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        BufferedReader bufferedReader = null;
        if (property2 == null) {
            StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("java.class.path"), r);
            while (true) {
                if (!stringTokenizer.hasMoreTokens()) {
                    break;
                }
                String nextToken = stringTokenizer.nextToken();
                File file = new File(nextToken);
                if (file.exists()) {
                    if (file.isDirectory()) {
                        StringBuilder h2 = a.h(nextToken);
                        h2.append(q);
                        h2.append(s);
                        if (new File(h2.toString(), property).exists()) {
                            try {
                                inputStream = new FileInputStream(nextToken + q + s + q + property);
                                break;
                            } catch (IOException e2) {
                                throw e2;
                            }
                        }
                    } else {
                        try {
                            zipFile = new ZipFile(file);
                        } catch (IOException unused) {
                            zipFile = null;
                        }
                        if (zipFile != null) {
                            String str = s + q + property;
                            ZipEntry entry = zipFile.getEntry(str);
                            if (entry == null) {
                                char c2 = q;
                                if (c2 == '/') {
                                    str = str.replace('/', '\\');
                                } else if (c2 == '\\') {
                                    str = str.replace('\\', '/');
                                }
                                entry = zipFile.getEntry(str);
                            }
                            if (entry != null) {
                                try {
                                    inputStream = zipFile.getInputStream(entry);
                                    break;
                                } catch (IOException e3) {
                                    throw e3;
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            if (property2.length() != 0 || !property2.endsWith(System.getProperty("file.separator"))) {
                StringBuilder h3 = a.h(property2);
                h3.append(System.getProperty("file.separator"));
                property2 = h3.toString();
            }
            StringBuilder h4 = a.h(property2);
            h4.append(q);
            h4.append(property);
            File file2 = new File(h4.toString());
            if (file2.exists()) {
                try {
                    inputStream = new FileInputStream(file2);
                    if (inputStream == null) {
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                            int i2 = 0;
                            while (true) {
                                try {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine != null) {
                                        i2++;
                                        h0(readLine.trim(), i2);
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
                } catch (IOException e4) {
                    throw e4;
                }
            }
        }
        inputStream = null;
        if (inputStream == null) {
        }
    }

    public static b k0(DataInput dataInput) {
        int readInt = dataInput.readInt();
        byte readByte = dataInput.readByte();
        byte readByte2 = dataInput.readByte();
        j jVar = j.f6463d;
        return f0(readInt, readByte, readByte2);
    }

    public static k l0(int i2, int i3, int i4) {
        int intValue = Y(i2)[i3 - 1].intValue();
        if (i4 > intValue) {
            i4 = intValue;
        }
        return f0(i2, i3, i4);
    }

    private Object readResolve() {
        return new k(this.h);
    }

    private Object writeReplace() {
        return new u((byte) 3, this);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public final c<k> A(g gVar) {
        return new d(this, gVar);
    }

    @Override // g.b.a.t.b
    public h D() {
        return j.f6463d;
    }

    @Override // g.b.a.t.b
    public i F() {
        return this.f6467b;
    }

    @Override // g.b.a.t.b
    public b G(long j2, m mVar) {
        return (k) super.m(j2, mVar);
    }

    @Override // g.b.a.t.b, g.b.a.t.a
    public b H(long j2, m mVar) {
        return (k) super.s(j2, mVar);
    }

    @Override // g.b.a.t.b
    public b L(i iVar) {
        return (k) j.f6463d.i(((l) iVar).a(this));
    }

    @Override // g.b.a.t.b
    public long P() {
        return b0(this.f6468c, this.f6469d, this.f6470e);
    }

    @Override // g.b.a.t.b
    public b Q(f fVar) {
        return (k) j.f6463d.i(fVar.t(this));
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<k> S(long j2, m mVar) {
        return (k) super.s(j2, mVar);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<k> T(long j2) {
        return new k(this.h + j2);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<k> U(long j2) {
        if (j2 == 0) {
            return this;
        }
        int i2 = (this.f6469d - 1) + ((int) j2);
        int i3 = i2 / 12;
        int i4 = i2 % 12;
        while (i4 < 0) {
            i4 += 12;
            i3 = t.G2(i3, 1);
        }
        return g0(this.f6467b, t.C2(this.f6468c, i3), i4 + 1, this.f6470e);
    }

    /* Return type fixed from 'g.b.a.t.a' to match base method */
    @Override // g.b.a.t.a
    public a<k> V(long j2) {
        if (j2 == 0) {
            return this;
        }
        return g0(this.f6467b, t.C2(this.f6468c, (int) j2), this.f6469d, this.f6470e);
    }

    @Override // g.b.a.w.e, g.b.a.v.c
    public o b(j jVar) {
        long j2;
        int i2;
        int i3;
        Integer num;
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.p(this);
        }
        if (k(jVar)) {
            g.b.a.w.a aVar = (g.b.a.w.a) jVar;
            int ordinal = aVar.ordinal();
            Integer[] numArr = null;
            if (ordinal == 18) {
                int i4 = this.f6469d - 1;
                int i5 = this.f6468c;
                try {
                    numArr = u.get(Integer.valueOf(i5));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
                if (numArr == null) {
                    numArr = e0((long) i5) ? D : C;
                }
                i2 = numArr[i4].intValue();
            } else if (ordinal != 19) {
                if (ordinal == 21) {
                    j2 = 5;
                } else if (ordinal != 25) {
                    j jVar2 = j.f6463d;
                    return aVar.f6633c;
                } else {
                    j2 = 1000;
                }
                return o.d(1, j2);
            } else {
                int i6 = this.f6468c;
                int i7 = i6 - 1;
                int i8 = i7 / 30;
                try {
                    numArr = v.get(Integer.valueOf(i8));
                } catch (ArrayIndexOutOfBoundsException unused2) {
                }
                if (numArr != null) {
                    int i9 = i7 % 30;
                    if (i9 == 29) {
                        i3 = w[i8 + 1].intValue() - w[i8].intValue();
                        num = numArr[i9];
                    } else {
                        i3 = numArr[i9 + 1].intValue();
                        num = numArr[i9];
                    }
                    i2 = i3 - num.intValue();
                } else {
                    i2 = e0((long) i6) ? 355 : 354;
                }
            }
            j2 = (long) i2;
            return o.d(1, j2);
        }
        throw new n(a.d("Unsupported field: ", jVar));
    }

    @Override // g.b.a.w.d, g.b.a.t.b
    public d i(f fVar) {
        return (k) j.f6463d.i(((e) fVar).t(this));
    }

    public k i0(long j2) {
        return new k(this.h + j2);
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.v.b
    public d m(long j2, m mVar) {
        return (k) super.m(j2, mVar);
    }

    /* renamed from: m0 */
    public k r(j jVar, long j2) {
        if (!(jVar instanceof g.b.a.w.a)) {
            return (k) jVar.f(this, j2);
        }
        g.b.a.w.a aVar = (g.b.a.w.a) jVar;
        aVar.f6633c.b(j2, aVar);
        int i2 = (int) j2;
        switch (aVar.ordinal()) {
            case 15:
                return i0(j2 - ((long) this.f6472g.p()));
            case 16:
                return i0(j2 - n(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 17:
                return i0(j2 - n(g.b.a.w.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 18:
                return l0(this.f6468c, this.f6469d, i2);
            case 19:
                int i3 = i2 - 1;
                return l0(this.f6468c, (i3 / 30) + 1, (i3 % 30) + 1);
            case 20:
                return new k((long) i2);
            case 21:
                return i0((j2 - n(g.b.a.w.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 22:
                return i0((j2 - n(g.b.a.w.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 23:
                return l0(this.f6468c, i2, this.f6470e);
            case 24:
            default:
                throw new n(a.d("Unsupported field: ", jVar));
            case 25:
                if (this.f6468c < 1) {
                    i2 = 1 - i2;
                }
                return l0(i2, this.f6469d, this.f6470e);
            case 26:
                return l0(i2, this.f6469d, this.f6470e);
            case 27:
                return l0(1 - this.f6468c, this.f6469d, this.f6470e);
        }
    }

    @Override // g.b.a.w.e
    public long n(j jVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!(jVar instanceof g.b.a.w.a)) {
            return jVar.k(this);
        }
        switch (((g.b.a.w.a) jVar).ordinal()) {
            case 15:
                i2 = this.f6472g.p();
                break;
            case 16:
                i4 = this.f6470e;
                i3 = (i4 - 1) % 7;
                i2 = i3 + 1;
                break;
            case 17:
                i4 = this.f6471f;
                i3 = (i4 - 1) % 7;
                i2 = i3 + 1;
                break;
            case 18:
                i2 = this.f6470e;
                break;
            case 19:
                i2 = this.f6471f;
                break;
            case 20:
                return P();
            case 21:
                i5 = this.f6470e;
                i3 = (i5 - 1) / 7;
                i2 = i3 + 1;
                break;
            case 22:
                i5 = this.f6471f;
                i3 = (i5 - 1) / 7;
                i2 = i3 + 1;
                break;
            case 23:
                i2 = this.f6469d;
                break;
            case 24:
            default:
                throw new n(a.d("Unsupported field: ", jVar));
            case 25:
            case 26:
                i2 = this.f6468c;
                break;
            case 27:
                return (long) this.f6467b.ordinal();
        }
        return (long) i2;
    }

    @Override // g.b.a.w.d, g.b.a.t.b, g.b.a.t.a
    public d s(long j2, m mVar) {
        return (k) super.s(j2, mVar);
    }
}
