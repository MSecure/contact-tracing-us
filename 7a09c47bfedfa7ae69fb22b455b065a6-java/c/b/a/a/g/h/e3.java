package c.b.a.a.g.h;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import c.b.a.a.g.h.b1;
import c.b.a.a.g.h.e1;
import c.b.a.a.g.h.t1;
import gov.michigan.MiCovidExposure.BuildConfig;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class e3<T> implements q3<T> {
    public static final int[] p = new int[0];
    public static final Unsafe q = j4.k();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3879a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f3880b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3881c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3882d;

    /* renamed from: e  reason: collision with root package name */
    public final c3 f3883e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3884f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3885g;
    public final int[] h;
    public final int i;
    public final int j;
    public final i3 k;
    public final m2 l;
    public final d4<?, ?> m;
    public final g1<?> n;
    public final v2 o;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IILc/b/a/a/g/h/c3;ZZ[IIILc/b/a/a/g/h/i3;Lc/b/a/a/g/h/m2;Lc/b/a/a/g/h/d4<**>;Lc/b/a/a/g/h/g1<*>;Lc/b/a/a/g/h/v2;)V */
    public e3(int[] iArr, Object[] objArr, int i2, int i3, c3 c3Var, boolean z, int[] iArr2, int i4, int i5, i3 i3Var, m2 m2Var, d4 d4Var, g1 g1Var, v2 v2Var) {
        this.f3879a = iArr;
        this.f3880b = objArr;
        this.f3881c = i2;
        this.f3882d = i3;
        boolean z2 = c3Var instanceof t1;
        this.f3885g = z;
        this.f3884f = g1Var != null && (c3Var instanceof t1.d);
        this.h = iArr2;
        this.i = i4;
        this.j = i5;
        this.k = i3Var;
        this.l = m2Var;
        this.m = d4Var;
        this.n = g1Var;
        this.f3883e = c3Var;
        this.o = v2Var;
    }

    public static List<?> G(Object obj, long j2) {
        return (List) j4.s(obj, j2);
    }

    public static <T> double H(T t, long j2) {
        return ((Double) j4.s(t, j2)).doubleValue();
    }

    public static <T> float I(T t, long j2) {
        return ((Float) j4.s(t, j2)).floatValue();
    }

    public static <T> int J(T t, long j2) {
        return ((Integer) j4.s(t, j2)).intValue();
    }

    public static <T> long K(T t, long j2) {
        return ((Long) j4.s(t, j2)).longValue();
    }

    public static <T> boolean L(T t, long j2) {
        return ((Boolean) j4.s(t, j2)).booleanValue();
    }

    public static c4 M(Object obj) {
        t1 t1Var = (t1) obj;
        c4 c4Var = t1Var.zzxz;
        if (c4Var != c4.f3851f) {
            return c4Var;
        }
        c4 e2 = c4.e();
        t1Var.zzxz = e2;
        return e2;
    }

    public static <T> e3<T> n(Class<T> cls, a3 a3Var, i3 i3Var, m2 m2Var, d4<?, ?> d4Var, g1<?> g1Var, v2 v2Var) {
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        o3 o3Var;
        int i13;
        String str;
        Object[] objArr;
        boolean z;
        int i14;
        int i15;
        int i16;
        Field field;
        int i17;
        char charAt;
        int i18;
        int i19;
        Field field2;
        Field field3;
        int i20;
        char charAt2;
        int i21;
        char charAt3;
        int i22;
        char charAt4;
        int i23;
        char charAt5;
        int i24;
        char charAt6;
        int i25;
        char charAt7;
        int i26;
        char charAt8;
        int i27;
        char charAt9;
        int i28;
        char charAt10;
        int i29;
        char charAt11;
        int i30;
        char charAt12;
        int i31;
        char charAt13;
        if (a3Var instanceof o3) {
            o3 o3Var2 = (o3) a3Var;
            int i32 = 0;
            boolean z2 = (o3Var2.f3987d & 1) == 1 ? true : true;
            String str2 = o3Var2.f3985b;
            int length = str2.length();
            if (str2.charAt(0) >= 55296) {
                int i33 = 1;
                while (true) {
                    i2 = i33 + 1;
                    if (str2.charAt(i33) < 55296) {
                        break;
                    }
                    i33 = i2;
                }
            } else {
                i2 = 1;
            }
            int i34 = i2 + 1;
            int charAt14 = str2.charAt(i2);
            if (charAt14 >= 55296) {
                int i35 = charAt14 & 8191;
                int i36 = 13;
                while (true) {
                    i31 = i34 + 1;
                    charAt13 = str2.charAt(i34);
                    if (charAt13 < 55296) {
                        break;
                    }
                    i35 |= (charAt13 & 8191) << i36;
                    i36 += 13;
                    i34 = i31;
                }
                charAt14 = i35 | (charAt13 << i36);
                i34 = i31;
            }
            if (charAt14 == 0) {
                i7 = 0;
                i6 = 0;
                i5 = 0;
                i4 = 0;
                i3 = 0;
                iArr = p;
                i8 = 0;
            } else {
                int i37 = i34 + 1;
                int charAt15 = str2.charAt(i34);
                if (charAt15 >= 55296) {
                    int i38 = charAt15 & 8191;
                    int i39 = 13;
                    while (true) {
                        i30 = i37 + 1;
                        charAt12 = str2.charAt(i37);
                        if (charAt12 < 55296) {
                            break;
                        }
                        i38 |= (charAt12 & 8191) << i39;
                        i39 += 13;
                        i37 = i30;
                    }
                    charAt15 = i38 | (charAt12 << i39);
                    i37 = i30;
                }
                int i40 = i37 + 1;
                int charAt16 = str2.charAt(i37);
                if (charAt16 >= 55296) {
                    int i41 = charAt16 & 8191;
                    int i42 = 13;
                    while (true) {
                        i29 = i40 + 1;
                        charAt11 = str2.charAt(i40);
                        if (charAt11 < 55296) {
                            break;
                        }
                        i41 |= (charAt11 & 8191) << i42;
                        i42 += 13;
                        i40 = i29;
                    }
                    charAt16 = i41 | (charAt11 << i42);
                    i40 = i29;
                }
                int i43 = i40 + 1;
                i7 = str2.charAt(i40);
                if (i7 >= 55296) {
                    int i44 = i7 & 8191;
                    int i45 = 13;
                    while (true) {
                        i28 = i43 + 1;
                        charAt10 = str2.charAt(i43);
                        if (charAt10 < 55296) {
                            break;
                        }
                        i44 |= (charAt10 & 8191) << i45;
                        i45 += 13;
                        i43 = i28;
                    }
                    i7 = i44 | (charAt10 << i45);
                    i43 = i28;
                }
                int i46 = i43 + 1;
                i6 = str2.charAt(i43);
                if (i6 >= 55296) {
                    int i47 = i6 & 8191;
                    int i48 = 13;
                    while (true) {
                        i27 = i46 + 1;
                        charAt9 = str2.charAt(i46);
                        if (charAt9 < 55296) {
                            break;
                        }
                        i47 |= (charAt9 & 8191) << i48;
                        i48 += 13;
                        i46 = i27;
                    }
                    i6 = i47 | (charAt9 << i48);
                    i46 = i27;
                }
                int i49 = i46 + 1;
                i5 = str2.charAt(i46);
                if (i5 >= 55296) {
                    int i50 = i5 & 8191;
                    int i51 = 13;
                    while (true) {
                        i26 = i49 + 1;
                        charAt8 = str2.charAt(i49);
                        if (charAt8 < 55296) {
                            break;
                        }
                        i50 |= (charAt8 & 8191) << i51;
                        i51 += 13;
                        i49 = i26;
                    }
                    i5 = i50 | (charAt8 << i51);
                    i49 = i26;
                }
                int i52 = i49 + 1;
                int charAt17 = str2.charAt(i49);
                if (charAt17 >= 55296) {
                    int i53 = charAt17 & 8191;
                    int i54 = 13;
                    while (true) {
                        i25 = i52 + 1;
                        charAt7 = str2.charAt(i52);
                        if (charAt7 < 55296) {
                            break;
                        }
                        i53 |= (charAt7 & 8191) << i54;
                        i54 += 13;
                        i52 = i25;
                    }
                    charAt17 = i53 | (charAt7 << i54);
                    i52 = i25;
                }
                int i55 = i52 + 1;
                int charAt18 = str2.charAt(i52);
                if (charAt18 >= 55296) {
                    int i56 = charAt18 & 8191;
                    int i57 = 13;
                    while (true) {
                        i24 = i55 + 1;
                        charAt6 = str2.charAt(i55);
                        if (charAt6 < 55296) {
                            break;
                        }
                        i56 |= (charAt6 & 8191) << i57;
                        i57 += 13;
                        i55 = i24;
                    }
                    charAt18 = i56 | (charAt6 << i57);
                    i55 = i24;
                }
                int i58 = i55 + 1;
                i3 = str2.charAt(i55);
                if (i3 >= 55296) {
                    int i59 = i3 & 8191;
                    int i60 = i58;
                    int i61 = 13;
                    while (true) {
                        i23 = i60 + 1;
                        charAt5 = str2.charAt(i60);
                        if (charAt5 < 55296) {
                            break;
                        }
                        i59 |= (charAt5 & 8191) << i61;
                        i61 += 13;
                        i60 = i23;
                    }
                    i3 = i59 | (charAt5 << i61);
                    i58 = i23;
                }
                i4 = (charAt15 << 1) + charAt16;
                i8 = charAt17;
                iArr = new int[(i3 + charAt17 + charAt18)];
                i32 = charAt15;
                i34 = i58;
            }
            Unsafe unsafe = q;
            Object[] objArr2 = o3Var2.f3986c;
            Class<?> cls2 = o3Var2.f3984a.getClass();
            int[] iArr2 = new int[(i5 * 3)];
            Object[] objArr3 = new Object[(i5 << 1)];
            int i62 = i3 + i8;
            int i63 = i3;
            int i64 = i34;
            int i65 = i62;
            int i66 = 0;
            int i67 = 0;
            while (i64 < length) {
                int i68 = i64 + 1;
                int charAt19 = str2.charAt(i64);
                if (charAt19 >= 55296) {
                    int i69 = charAt19 & 8191;
                    int i70 = i68;
                    int i71 = 13;
                    while (true) {
                        i22 = i70 + 1;
                        charAt4 = str2.charAt(i70);
                        i9 = i3;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i69 |= (charAt4 & 8191) << i71;
                        i71 += 13;
                        i70 = i22;
                        i3 = i9;
                    }
                    charAt19 = i69 | (charAt4 << i71);
                    i10 = i22;
                } else {
                    i9 = i3;
                    i10 = i68;
                }
                int i72 = i10 + 1;
                int charAt20 = str2.charAt(i10);
                if (charAt20 >= 55296) {
                    int i73 = charAt20 & 8191;
                    int i74 = i72;
                    int i75 = 13;
                    while (true) {
                        i21 = i74 + 1;
                        charAt3 = str2.charAt(i74);
                        i11 = i6;
                        if (charAt3 < 55296) {
                            break;
                        }
                        i73 |= (charAt3 & 8191) << i75;
                        i75 += 13;
                        i74 = i21;
                        i6 = i11;
                    }
                    charAt20 = i73 | (charAt3 << i75);
                    i12 = i21;
                } else {
                    i11 = i6;
                    i12 = i72;
                }
                int i76 = charAt20 & BuildConfig.VERSION_CODE;
                if ((charAt20 & 1024) != 0) {
                    iArr[i66] = i67;
                    i66++;
                }
                if (i76 >= 51) {
                    int i77 = i12 + 1;
                    int charAt21 = str2.charAt(i12);
                    char c2 = 55296;
                    if (charAt21 >= 55296) {
                        int i78 = 13;
                        int i79 = charAt21 & 8191;
                        int i80 = i77;
                        while (true) {
                            i20 = i80 + 1;
                            charAt2 = str2.charAt(i80);
                            if (charAt2 < c2) {
                                break;
                            }
                            i79 |= (charAt2 & 8191) << i78;
                            i78 += 13;
                            i80 = i20;
                            c2 = 55296;
                        }
                        charAt21 = i79 | (charAt2 << i78);
                        i19 = i20;
                    } else {
                        i19 = i77;
                    }
                    int i81 = i76 - 51;
                    o3Var = o3Var2;
                    if (i81 == 9 || i81 == 17) {
                        objArr3[((i67 / 3) << 1) + 1] = objArr2[i4];
                        i4++;
                    } else if (i81 == 12 && !z2) {
                        objArr3[((i67 / 3) << 1) + 1] = objArr2[i4];
                        i4++;
                    }
                    int i82 = charAt21 << 1;
                    Object obj = objArr2[i82];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = o(cls2, (String) obj);
                        objArr2[i82] = field2;
                    }
                    i15 = (int) unsafe.objectFieldOffset(field2);
                    int i83 = i82 + 1;
                    Object obj2 = objArr2[i83];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = o(cls2, (String) obj2);
                        objArr2[i83] = field3;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field3);
                    str = str2;
                    z = z2;
                    i12 = i19;
                    i13 = i4;
                    i16 = objectFieldOffset;
                    objArr = objArr3;
                    i14 = 0;
                } else {
                    o3Var = o3Var2;
                    int i84 = i4 + 1;
                    Field o2 = o(cls2, (String) objArr2[i4]);
                    if (i76 == 9 || i76 == 17) {
                        objArr3[((i67 / 3) << 1) + 1] = o2.getType();
                    } else {
                        if (i76 == 27 || i76 == 49) {
                            i18 = i84 + 1;
                            objArr3[((i67 / 3) << 1) + 1] = objArr2[i84];
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (!z2) {
                                i18 = i84 + 1;
                                objArr3[((i67 / 3) << 1) + 1] = objArr2[i84];
                            }
                        } else if (i76 == 50) {
                            int i85 = i63 + 1;
                            iArr[i63] = i67;
                            int i86 = (i67 / 3) << 1;
                            i18 = i84 + 1;
                            objArr3[i86] = objArr2[i84];
                            if ((charAt20 & 2048) != 0) {
                                i84 = i18 + 1;
                                objArr3[i86 + 1] = objArr2[i18];
                                objArr = objArr3;
                                i63 = i85;
                                z = z2;
                                i15 = (int) unsafe.objectFieldOffset(o2);
                                if ((charAt20 & 4096) == 4096 || i76 > 17) {
                                    i13 = i84;
                                    str = str2;
                                    i16 = 1048575;
                                    i14 = 0;
                                } else {
                                    int i87 = i12 + 1;
                                    int charAt22 = str2.charAt(i12);
                                    if (charAt22 >= 55296) {
                                        int i88 = charAt22 & 8191;
                                        int i89 = 13;
                                        while (true) {
                                            i17 = i87 + 1;
                                            charAt = str2.charAt(i87);
                                            if (charAt < 55296) {
                                                break;
                                            }
                                            i88 |= (charAt & 8191) << i89;
                                            i89 += 13;
                                            i87 = i17;
                                        }
                                        charAt22 = i88 | (charAt << i89);
                                        i87 = i17;
                                    }
                                    int i90 = (charAt22 / 32) + (i32 << 1);
                                    Object obj3 = objArr2[i90];
                                    i13 = i84;
                                    if (obj3 instanceof Field) {
                                        field = (Field) obj3;
                                    } else {
                                        field = o(cls2, (String) obj3);
                                        objArr2[i90] = field;
                                    }
                                    str = str2;
                                    i14 = charAt22 % 32;
                                    i16 = (int) unsafe.objectFieldOffset(field);
                                    i12 = i87;
                                }
                                if (i76 >= 18 && i76 <= 49) {
                                    iArr[i65] = i15;
                                    i65++;
                                }
                            } else {
                                i63 = i85;
                            }
                        }
                        i84 = i18;
                    }
                    z = z2;
                    objArr = objArr3;
                    i15 = (int) unsafe.objectFieldOffset(o2);
                    if ((charAt20 & 4096) == 4096) {
                    }
                    i13 = i84;
                    str = str2;
                    i16 = 1048575;
                    i14 = 0;
                    iArr[i65] = i15;
                    i65++;
                }
                int i91 = i67 + 1;
                iArr2[i67] = charAt19;
                int i92 = i91 + 1;
                iArr2[i91] = ((charAt20 & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0 ? 536870912 : 0) | ((charAt20 & RecyclerView.a0.FLAG_TMP_DETACHED) != 0 ? 268435456 : 0) | (i76 << 20) | i15;
                i67 = i92 + 1;
                iArr2[i92] = (i14 << 20) | i16;
                z2 = z;
                i64 = i12;
                i7 = i7;
                length = length;
                i3 = i9;
                i6 = i11;
                objArr3 = objArr;
                str2 = str;
                i4 = i13;
                o3Var2 = o3Var;
            }
            return new e3<>(iArr2, objArr3, i7, i6, o3Var2.f3984a, z2, iArr, i3, i62, i3Var, m2Var, d4Var, g1Var, v2Var);
        }
        z3 z3Var = (z3) a3Var;
        throw new NoSuchMethodError();
    }

    public static Field o(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + name.length() + String.valueOf(str).length() + 40);
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public static void p(int i2, Object obj, v4 v4Var) {
        if (obj instanceof String) {
            b1.b bVar = (b1.b) ((d1) v4Var).f3864a;
            bVar.k((i2 << 3) | 2);
            bVar.c0((String) obj);
            return;
        }
        b1.b bVar2 = (b1.b) ((d1) v4Var).f3864a;
        bVar2.k((i2 << 3) | 2);
        bVar2.Z((q0) obj);
    }

    public static <UT, UB> void q(d4<UT, UB> d4Var, T t, v4 v4Var) {
        if (((f4) d4Var) != null) {
            t.zzxz.c(v4Var);
            return;
        }
        throw null;
    }

    public final int A(int i2) {
        return this.f3879a[i2 + 1];
    }

    public final int B(int i2) {
        return this.f3879a[i2 + 2];
    }

    public final void C(T t, int i2, int i3) {
        j4.f3918f.e(t, (long) (this.f3879a[i3 + 2] & 1048575), i2);
    }

    public final boolean D(T t, int i2) {
        int[] iArr = this.f3879a;
        int i3 = iArr[i2 + 2];
        long j2 = (long) (i3 & 1048575);
        if (j2 == 1048575) {
            int i4 = iArr[i2 + 1];
            long j3 = (long) (i4 & 1048575);
            switch ((i4 & 267386880) >>> 20) {
                case 0:
                    return j4.r(t, j3) != 0.0d;
                case 1:
                    return j4.q(t, j3) != 0.0f;
                case 2:
                    return j4.o(t, j3) != 0;
                case 3:
                    return j4.o(t, j3) != 0;
                case 4:
                    return j4.m(t, j3) != 0;
                case 5:
                    return j4.o(t, j3) != 0;
                case 6:
                    return j4.m(t, j3) != 0;
                case 7:
                    return j4.p(t, j3);
                case 8:
                    Object s = j4.s(t, j3);
                    if (s instanceof String) {
                        return !((String) s).isEmpty();
                    }
                    if (s instanceof q0) {
                        return !q0.f4006c.equals(s);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return j4.s(t, j3) != null;
                case 10:
                    return !q0.f4006c.equals(j4.s(t, j3));
                case 11:
                    return j4.m(t, j3) != 0;
                case 12:
                    return j4.m(t, j3) != 0;
                case 13:
                    return j4.m(t, j3) != 0;
                case 14:
                    return j4.o(t, j3) != 0;
                case 15:
                    return j4.m(t, j3) != 0;
                case 16:
                    return j4.o(t, j3) != 0;
                case 17:
                    return j4.s(t, j3) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (j4.m(t, j2) & (1 << (i3 >>> 20))) != 0;
        }
    }

    public final boolean E(T t, T t2, int i2) {
        return D(t, i2) == D(t2, i2);
    }

    public final void F(T t, int i2) {
        int i3 = this.f3879a[i2 + 2];
        long j2 = (long) (1048575 & i3);
        if (j2 != 1048575) {
            j4.f3918f.e(t, j2, (1 << (i3 >>> 20)) | j4.m(t, j2));
        }
    }

    public final int N(int i2, int i3) {
        int length = (this.f3879a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f3879a[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }

    @Override // c.b.a.a.g.h.q3
    public final void a(T t) {
        int i2;
        int i3 = this.i;
        while (true) {
            i2 = this.j;
            if (i3 >= i2) {
                break;
            }
            long A = (long) (A(this.h[i3]) & 1048575);
            Object s = j4.s(t, A);
            if (s != null) {
                j4.e(t, A, this.o.g(s));
            }
            i3++;
        }
        int length = this.h.length;
        while (i2 < length) {
            this.l.b(t, (long) this.h[i2]);
            i2++;
        }
        if (((f4) this.m) != null) {
            t.zzxz.f3856e = false;
            if (!this.f3884f) {
                return;
            }
            if (((i1) this.n) != null) {
                t.zzyg.l();
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (c.b.a.a.g.h.s3.t(c.b.a.a.g.h.j4.s(r10, r6), c.b.a.a.g.h.j4.s(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (c.b.a.a.g.h.j4.o(r10, r6) == c.b.a.a.g.h.j4.o(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (c.b.a.a.g.h.j4.o(r10, r6) == c.b.a.a.g.h.j4.o(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (c.b.a.a.g.h.s3.t(c.b.a.a.g.h.j4.s(r10, r6), c.b.a.a.g.h.j4.s(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (c.b.a.a.g.h.s3.t(c.b.a.a.g.h.j4.s(r10, r6), c.b.a.a.g.h.j4.s(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (c.b.a.a.g.h.s3.t(c.b.a.a.g.h.j4.s(r10, r6), c.b.a.a.g.h.j4.s(r11, r6)) != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (c.b.a.a.g.h.j4.p(r10, r6) == c.b.a.a.g.h.j4.p(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
        if (c.b.a.a.g.h.j4.o(r10, r6) == c.b.a.a.g.h.j4.o(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0157, code lost:
        if (c.b.a.a.g.h.j4.m(r10, r6) == c.b.a.a.g.h.j4.m(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        if (c.b.a.a.g.h.j4.o(r10, r6) == c.b.a.a.g.h.j4.o(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017d, code lost:
        if (c.b.a.a.g.h.j4.o(r10, r6) == c.b.a.a.g.h.j4.o(r11, r6)) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0196, code lost:
        if (java.lang.Float.floatToIntBits(c.b.a.a.g.h.j4.q(r10, r6)) == java.lang.Float.floatToIntBits(c.b.a.a.g.h.j4.q(r11, r6))) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01b1, code lost:
        if (java.lang.Double.doubleToLongBits(c.b.a.a.g.h.j4.r(r10, r6)) == java.lang.Double.doubleToLongBits(c.b.a.a.g.h.j4.r(r11, r6))) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (c.b.a.a.g.h.s3.t(c.b.a.a.g.h.j4.s(r10, r6), c.b.a.a.g.h.j4.s(r11, r6)) != false) goto L_0x01b4;
     */
    @Override // c.b.a.a.g.h.q3
    public final boolean b(T t, T t2) {
        int length = this.f3879a.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int A = A(i2);
                long j2 = (long) (A & 1048575);
                switch ((A & 267386880) >>> 20) {
                    case 0:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (E(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                    case 50:
                        z = s3.t(j4.s(t, j2), j4.s(t2, j2));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        long B = (long) (B(i2) & 1048575);
                        if (j4.m(t, B) == j4.m(t2, B)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i2 += 3;
            } else {
                f4 f4Var = (f4) this.m;
                if (f4Var != null) {
                    c4 c4Var = t.zzxz;
                    if (f4Var == null) {
                        throw null;
                    } else if (!c4Var.equals(t2.zzxz)) {
                        return false;
                    } else {
                        if (!this.f3884f) {
                            return true;
                        }
                        i1 i1Var = (i1) this.n;
                        if (i1Var != null) {
                            j1<t1.c> j1Var = t.zzyg;
                            if (i1Var != null) {
                                return j1Var.equals(t2.zzyg);
                            }
                            throw null;
                        }
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
        }
    }

    @Override // c.b.a.a.g.h.q3
    public final T c() {
        return (T) this.k.a(this.f3883e);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // c.b.a.a.g.h.q3
    public final int d(T t) {
        int i2;
        int i3;
        long j2;
        double d2;
        float f2;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.f3879a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int A = A(i5);
            int i6 = this.f3879a[i5];
            long j3 = (long) (1048575 & A);
            int i7 = 37;
            switch ((A & 267386880) >>> 20) {
                case 0:
                    i3 = i4 * 53;
                    d2 = j4.r(t, j3);
                    j2 = Double.doubleToLongBits(d2);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    f2 = j4.q(t, j3);
                    i2 = Float.floatToIntBits(f2);
                    i4 = i2 + i3;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i4 * 53;
                    j2 = j4.o(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i3 = i4 * 53;
                    i2 = j4.m(t, j3);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    z = j4.p(t, j3);
                    i2 = u1.h(z);
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) j4.s(t, j3)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    obj = j4.s(t, j3);
                    break;
                case 10:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                    i3 = i4 * 53;
                    obj2 = j4.s(t, j3);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 17:
                    obj = j4.s(t, j3);
                    break;
                case 51:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        d2 = H(t, j3);
                        j2 = Double.doubleToLongBits(d2);
                        i2 = u1.e(j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        f2 = I(t, j3);
                        i2 = Float.floatToIntBits(f2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = K(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 54:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = K(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 55:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 56:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = K(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 57:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 58:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        z = L(t, j3);
                        i2 = u1.h(z);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = ((String) j4.s(t, j3)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 60:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    obj2 = j4.s(t, j3);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 61:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    obj2 = j4.s(t, j3);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 62:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 63:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 64:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 65:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = K(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 66:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = J(t, j3);
                    i4 = i2 + i3;
                    break;
                case 67:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = K(t, j3);
                    i2 = u1.e(j2);
                    i4 = i2 + i3;
                    break;
                case 68:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    obj2 = j4.s(t, j3);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
            }
        }
        int i8 = i4 * 53;
        if (((f4) this.m) != null) {
            int hashCode = t.zzxz.hashCode() + i8;
            if (!this.f3884f) {
                return hashCode;
            }
            int i9 = hashCode * 53;
            if (((i1) this.n) != null) {
                return i9 + t.zzyg.hashCode();
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f4, code lost:
        if ((r8 instanceof c.b.a.a.g.h.q0) != false) goto L_0x02f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x02fe, code lost:
        r8 = c.b.a.a.g.h.b1.f(r11, (java.lang.String) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x041e, code lost:
        if ((r3 instanceof c.b.a.a.g.h.q0) != false) goto L_0x067e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x067c, code lost:
        if ((r3 instanceof c.b.a.a.g.h.q0) != false) goto L_0x067e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x0685, code lost:
        r3 = c.b.a.a.g.h.b1.f(r12, (java.lang.String) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009e, code lost:
        if ((r8 instanceof c.b.a.a.g.h.q0) != false) goto L_0x02f6;
     */
    @Override // c.b.a.a.g.h.q3
    public final int e(T t) {
        int i2;
        int i3;
        long j2;
        long j3;
        int i4;
        Object obj;
        int i5;
        int i6;
        int i7;
        long j4;
        int i8;
        int i9;
        long j5;
        long j6;
        int i10;
        Object obj2;
        int i11;
        int i12;
        int i13;
        long j7;
        int i14;
        int i15 = 1048575;
        int i16 = 267386880;
        if (this.f3885g) {
            Unsafe unsafe = q;
            int i17 = 0;
            for (int i18 = 0; i18 < this.f3879a.length; i18 += 3) {
                int A = A(i18);
                int i19 = (A & 267386880) >>> 20;
                int[] iArr = this.f3879a;
                int i20 = iArr[i18];
                long j8 = (long) (A & 1048575);
                if (i19 >= o1.DOUBLE_LIST_PACKED.f3982b && i19 <= o1.SINT64_LIST_PACKED.f3982b) {
                    int i21 = iArr[i18 + 2];
                }
                switch (i19) {
                    case 0:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.h(i20);
                        i17 = i9 + i17;
                        break;
                    case 1:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.e(i20);
                        i17 = i9 + i17;
                        break;
                    case 2:
                        if (D(t, i18)) {
                            j5 = j4.o(t, j8);
                            i9 = b1.x(i20, j5);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (D(t, i18)) {
                            j6 = j4.o(t, j8);
                            i9 = b1.z(i20, j6);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (D(t, i18)) {
                            i10 = j4.m(t, j8);
                            i9 = b1.I(i20, i10);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.D(i20);
                        i17 = i9 + i17;
                        break;
                    case 6:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.L(i20);
                        i17 = i9 + i17;
                        break;
                    case 7:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.i(i20);
                        i17 = i9 + i17;
                        break;
                    case 8:
                        if (D(t, i18)) {
                            obj2 = j4.s(t, j8);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = s3.l(i20, j4.s(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                    case 10:
                        if (!D(t, i18)) {
                            break;
                        }
                        obj2 = j4.s(t, j8);
                        i9 = b1.t(i20, (q0) obj2);
                        i17 = i9 + i17;
                        break;
                    case 11:
                        if (D(t, i18)) {
                            i11 = j4.m(t, j8);
                            i9 = b1.J(i20, i11);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (D(t, i18)) {
                            i12 = j4.m(t, j8);
                            i9 = b1.N(i20, i12);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.M(i20);
                        i17 = i9 + i17;
                        break;
                    case 14:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.F(i20);
                        i17 = i9 + i17;
                        break;
                    case 15:
                        if (D(t, i18)) {
                            i13 = j4.m(t, j8);
                            i9 = b1.K(i20, i13);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (D(t, i18)) {
                            j7 = j4.o(t, j8);
                            i9 = b1.B(i20, j7);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (!D(t, i18)) {
                            break;
                        }
                        i9 = b1.u(i20, (c3) j4.s(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                    case 18:
                    case 23:
                    case 32:
                        i9 = s3.T(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 19:
                    case 24:
                    case 31:
                        i9 = s3.R(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 20:
                        i9 = s3.F(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 21:
                        i9 = s3.G(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 22:
                        i9 = s3.L(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 25:
                        i9 = s3.V(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 26:
                        i9 = s3.m(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 27:
                        i9 = s3.n(i20, G(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                    case 28:
                        i9 = s3.p(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 29:
                        i9 = s3.N(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 30:
                        i9 = s3.J(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 33:
                        i9 = s3.P(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 34:
                        i9 = s3.H(i20, G(t, j8));
                        i17 = i9 + i17;
                        break;
                    case 35:
                        i14 = s3.X((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 36:
                        i14 = s3.W((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 37:
                        i14 = s3.I((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 38:
                        i14 = s3.K((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 39:
                        i14 = s3.Q((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 40:
                        i14 = s3.X((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 41:
                        i14 = s3.W((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 42:
                        i14 = s3.Y((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 43:
                        i14 = s3.S((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 44:
                        i14 = s3.O((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 45:
                        i14 = s3.W((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 46:
                        i14 = s3.X((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 47:
                        i14 = s3.U((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 48:
                        i14 = s3.M((List) unsafe.getObject(t, j8));
                        if (i14 <= 0) {
                            break;
                        }
                        i17 = b1.o(i14) + b1.m(i20) + i14 + i17;
                        break;
                    case 49:
                        i9 = s3.q(i20, G(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                    case 50:
                        i9 = this.o.b(i20, j4.s(t, j8), y(i18));
                        i17 = i9 + i17;
                        break;
                    case 51:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.h(i20);
                        i17 = i9 + i17;
                        break;
                    case 52:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.e(i20);
                        i17 = i9 + i17;
                        break;
                    case 53:
                        if (w(t, i20, i18)) {
                            j5 = K(t, j8);
                            i9 = b1.x(i20, j5);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (w(t, i20, i18)) {
                            j6 = K(t, j8);
                            i9 = b1.z(i20, j6);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (w(t, i20, i18)) {
                            i10 = J(t, j8);
                            i9 = b1.I(i20, i10);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.D(i20);
                        i17 = i9 + i17;
                        break;
                    case 57:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.L(i20);
                        i17 = i9 + i17;
                        break;
                    case 58:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.i(i20);
                        i17 = i9 + i17;
                        break;
                    case 59:
                        if (w(t, i20, i18)) {
                            obj2 = j4.s(t, j8);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = s3.l(i20, j4.s(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                    case 61:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        obj2 = j4.s(t, j8);
                        i9 = b1.t(i20, (q0) obj2);
                        i17 = i9 + i17;
                        break;
                    case 62:
                        if (w(t, i20, i18)) {
                            i11 = J(t, j8);
                            i9 = b1.J(i20, i11);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (w(t, i20, i18)) {
                            i12 = J(t, j8);
                            i9 = b1.N(i20, i12);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.M(i20);
                        i17 = i9 + i17;
                        break;
                    case 65:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.F(i20);
                        i17 = i9 + i17;
                        break;
                    case 66:
                        if (w(t, i20, i18)) {
                            i13 = J(t, j8);
                            i9 = b1.K(i20, i13);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (w(t, i20, i18)) {
                            j7 = K(t, j8);
                            i9 = b1.B(i20, j7);
                            i17 = i9 + i17;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i9 = b1.u(i20, (c3) j4.s(t, j8), x(i18));
                        i17 = i9 + i17;
                        break;
                }
            }
            if (((f4) this.m) != null) {
                return t.zzxz.d() + i17;
            }
            throw null;
        }
        Unsafe unsafe2 = q;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 1048575;
        while (i24 < this.f3879a.length) {
            int A2 = A(i24);
            int[] iArr2 = this.f3879a;
            int i26 = iArr2[i24];
            int i27 = (A2 & i16) >>> 20;
            if (i27 <= 17) {
                int i28 = iArr2[i24 + 2];
                int i29 = i28 & i15;
                i2 = 1 << (i28 >>> 20);
                if (i29 != i25) {
                    i22 = unsafe2.getInt(t, (long) i29);
                    i25 = i29;
                }
            } else {
                i2 = 0;
            }
            long j9 = (long) (i15 & A2);
            switch (i27) {
                case 0:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.h(i26);
                    i23 += i3;
                    break;
                case 1:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.e(i26);
                    i23 += i3;
                    break;
                case 2:
                    if ((i22 & i2) != 0) {
                        j2 = unsafe2.getLong(t, j9);
                        i3 = b1.x(i26, j2);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i22 & i2) != 0) {
                        j3 = unsafe2.getLong(t, j9);
                        i3 = b1.z(i26, j3);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i22 & i2) != 0) {
                        i4 = unsafe2.getInt(t, j9);
                        i3 = b1.I(i26, i4);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.D(i26);
                    i23 += i3;
                    break;
                case 6:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.L(i26);
                    i23 += i3;
                    break;
                case 7:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.i(i26);
                    i23 += i3;
                    break;
                case 8:
                    if ((i22 & i2) != 0) {
                        obj = unsafe2.getObject(t, j9);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = s3.l(i26, unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
                case 10:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    obj = unsafe2.getObject(t, j9);
                    i3 = b1.t(i26, (q0) obj);
                    i23 += i3;
                    break;
                case 11:
                    if ((i22 & i2) != 0) {
                        i5 = unsafe2.getInt(t, j9);
                        i3 = b1.J(i26, i5);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i22 & i2) != 0) {
                        i6 = unsafe2.getInt(t, j9);
                        i3 = b1.N(i26, i6);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.M(i26);
                    i23 += i3;
                    break;
                case 14:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.F(i26);
                    i23 += i3;
                    break;
                case 15:
                    if ((i22 & i2) != 0) {
                        i7 = unsafe2.getInt(t, j9);
                        i3 = b1.K(i26, i7);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i22 & i2) != 0) {
                        j4 = unsafe2.getLong(t, j9);
                        i3 = b1.B(i26, j4);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i22 & i2) == 0) {
                        break;
                    }
                    i3 = b1.u(i26, (c3) unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
                case 18:
                case 23:
                case 32:
                    i3 = s3.T(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 19:
                case 24:
                case 31:
                    i3 = s3.R(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 20:
                    i3 = s3.F(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 21:
                    i3 = s3.G(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 22:
                    i3 = s3.L(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 25:
                    i3 = s3.V(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 26:
                    i3 = s3.m(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 27:
                    i3 = s3.n(i26, (List) unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
                case 28:
                    i3 = s3.p(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 29:
                    i3 = s3.N(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 30:
                    i3 = s3.J(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 33:
                    i3 = s3.P(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 34:
                    i3 = s3.H(i26, (List) unsafe2.getObject(t, j9));
                    i23 += i3;
                    break;
                case 35:
                    i8 = s3.X((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 36:
                    i8 = s3.W((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 37:
                    i8 = s3.I((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 38:
                    i8 = s3.K((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 39:
                    i8 = s3.Q((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 40:
                    i8 = s3.X((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 41:
                    i8 = s3.W((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 42:
                    i8 = s3.Y((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 43:
                    i8 = s3.S((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 44:
                    i8 = s3.O((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 45:
                    i8 = s3.W((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 46:
                    i8 = s3.X((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 47:
                    i8 = s3.U((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 48:
                    i8 = s3.M((List) unsafe2.getObject(t, j9));
                    if (i8 <= 0) {
                        break;
                    }
                    i23 = b1.o(i8) + b1.m(i26) + i8 + i23;
                    break;
                case 49:
                    i3 = s3.q(i26, (List) unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
                case 50:
                    i3 = this.o.b(i26, unsafe2.getObject(t, j9), y(i24));
                    i23 += i3;
                    break;
                case 51:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.h(i26);
                    i23 += i3;
                    break;
                case 52:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.e(i26);
                    i23 += i3;
                    break;
                case 53:
                    if (w(t, i26, i24)) {
                        j2 = K(t, j9);
                        i3 = b1.x(i26, j2);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (w(t, i26, i24)) {
                        j3 = K(t, j9);
                        i3 = b1.z(i26, j3);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (w(t, i26, i24)) {
                        i4 = J(t, j9);
                        i3 = b1.I(i26, i4);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.D(i26);
                    i23 += i3;
                    break;
                case 57:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.L(i26);
                    i23 += i3;
                    break;
                case 58:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.i(i26);
                    i23 += i3;
                    break;
                case 59:
                    if (w(t, i26, i24)) {
                        obj = unsafe2.getObject(t, j9);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = s3.l(i26, unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
                case 61:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    obj = unsafe2.getObject(t, j9);
                    i3 = b1.t(i26, (q0) obj);
                    i23 += i3;
                    break;
                case 62:
                    if (w(t, i26, i24)) {
                        i5 = J(t, j9);
                        i3 = b1.J(i26, i5);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (w(t, i26, i24)) {
                        i6 = J(t, j9);
                        i3 = b1.N(i26, i6);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.M(i26);
                    i23 += i3;
                    break;
                case 65:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.F(i26);
                    i23 += i3;
                    break;
                case 66:
                    if (w(t, i26, i24)) {
                        i7 = J(t, j9);
                        i3 = b1.K(i26, i7);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (w(t, i26, i24)) {
                        j4 = K(t, j9);
                        i3 = b1.B(i26, j4);
                        i23 += i3;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!w(t, i26, i24)) {
                        break;
                    }
                    i3 = b1.u(i26, (c3) unsafe2.getObject(t, j9), x(i24));
                    i23 += i3;
                    break;
            }
            i24 += 3;
            i15 = 1048575;
            i16 = 267386880;
        }
        if (((f4) this.m) != null) {
            int d2 = t.zzxz.d() + i23;
            if (!this.f3884f) {
                return d2;
            }
            if (((i1) this.n) != null) {
                j1<t1.c> j1Var = t.zzyg;
                int i30 = 0;
                for (int i31 = 0; i31 < j1Var.f3910a.h(); i31++) {
                    Map.Entry<T, Object> e2 = j1Var.f3910a.e(i31);
                    i30 += j1.i(e2.getKey(), e2.getValue());
                }
                for (Map.Entry<T, Object> entry : j1Var.f3910a.i()) {
                    i30 += j1.i(entry.getKey(), entry.getValue());
                }
                return d2 + i30;
            }
            throw null;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: c.b.a.a.g.h.q3 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v11, resolved type: c.b.a.a.g.h.q3 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v25, resolved type: c.b.a.a.g.h.q3 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.a.a.g.h.q3
    public final boolean f(T t) {
        int i2;
        int i3;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 < this.i) {
                int i7 = this.h[i6];
                int i8 = this.f3879a[i7];
                int A = A(i7);
                int i9 = this.f3879a[i7 + 2];
                int i10 = i9 & 1048575;
                int i11 = 1 << (i9 >>> 20);
                if (i10 != i4) {
                    if (i10 != 1048575) {
                        i5 = q.getInt(t, (long) i10);
                    }
                    i2 = i5;
                    i3 = i10;
                } else {
                    i3 = i4;
                    i2 = i5;
                }
                if (((268435456 & A) != 0) && !t(t, i7, i3, i2, i11)) {
                    return false;
                }
                int i12 = (267386880 & A) >>> 20;
                if (i12 != 9 && i12 != 17) {
                    if (i12 != 27) {
                        if (i12 == 60 || i12 == 68) {
                            if (w(t, i8, i7) && !x(i7).f(j4.s(t, (long) (A & 1048575)))) {
                                return false;
                            }
                        } else if (i12 != 49) {
                            if (i12 == 50 && !this.o.f(j4.s(t, (long) (A & 1048575))).isEmpty()) {
                                this.o.h(y(i7));
                                throw null;
                            }
                        }
                    }
                    List list = (List) j4.s(t, (long) (A & 1048575));
                    if (!list.isEmpty()) {
                        q3 x = x(i7);
                        int i13 = 0;
                        while (true) {
                            if (i13 >= list.size()) {
                                break;
                            } else if (!x.f(list.get(i13))) {
                                z = false;
                                break;
                            } else {
                                i13++;
                            }
                        }
                    }
                    if (!z) {
                        return false;
                    }
                } else if (t(t, i7, i3, i2, i11) && !x(i7).f(j4.s(t, (long) (A & 1048575)))) {
                    return false;
                }
                i6++;
                i4 = i3;
                i5 = i2;
            } else {
                if (this.f3884f) {
                    if (((i1) this.n) == null) {
                        throw null;
                    } else if (!t.zzyg.a()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v24, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02eb, code lost:
        if (r0 == r4) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0338, code lost:
        if (r0 == r14) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0353, code lost:
        r5 = r15;
        r6 = r21;
        r2 = r22;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.h.q3
    public final void g(T t, byte[] bArr, int i2, int i3, n0 n0Var) {
        byte b2;
        int i4;
        int i5;
        int i6;
        Unsafe unsafe;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        Object obj;
        int i32;
        int i33;
        int i34;
        int i35;
        e3<T> e3Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i36 = i3;
        n0 n0Var2 = n0Var;
        if (e3Var.f3885g) {
            Unsafe unsafe2 = q;
            int i37 = -1;
            int i38 = 0;
            int i39 = 1048575;
            int i40 = i2;
            int i41 = 1048575;
            int i42 = 0;
            int i43 = 0;
            int i44 = -1;
            while (i40 < i36) {
                int i45 = i40 + 1;
                byte b3 = bArr2[i40];
                if (b3 < 0) {
                    i4 = t.M3(b3, bArr2, i45, n0Var2);
                    b2 = n0Var2.f3967a;
                } else {
                    b2 = b3;
                    i4 = i45;
                }
                int i46 = b2 >>> 3;
                int i47 = b2 & 7;
                if (i46 > i44) {
                    int i48 = i42 / 3;
                    if (i46 >= e3Var.f3881c && i46 <= e3Var.f3882d) {
                        i35 = e3Var.N(i46, i48);
                    }
                    i5 = i37;
                    if (i5 == i37) {
                        i8 = i46;
                        i10 = i4;
                        i9 = i41;
                        i7 = i38;
                        unsafe = unsafe2;
                        i6 = i37;
                    } else {
                        int[] iArr = e3Var.f3879a;
                        int i49 = iArr[i5 + 1];
                        int i50 = (i49 & 267386880) >>> 20;
                        long j2 = (long) (i49 & i39);
                        if (i50 <= 17) {
                            int i51 = iArr[i5 + 2];
                            boolean z = true;
                            int i52 = 1 << (i51 >>> 20);
                            int i53 = 1048575;
                            int i54 = i51 & 1048575;
                            if (i54 != i41) {
                                if (i41 != 1048575) {
                                    unsafe2.putInt(t2, (long) i41, i43);
                                    i53 = 1048575;
                                }
                                if (i54 != i53) {
                                    i43 = unsafe2.getInt(t2, (long) i54);
                                }
                                i17 = i43;
                                i18 = i54;
                            } else {
                                i17 = i43;
                                i18 = i41;
                            }
                            switch (i50) {
                                case 0:
                                    i22 = i3;
                                    i19 = i5;
                                    i21 = i53;
                                    i20 = i4;
                                    i8 = i46;
                                    if (i47 == 1) {
                                        j4.c(t2, j2, t.y4(bArr2, i20));
                                        i40 = i20 + 8;
                                        i23 = i17 | i52;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 1:
                                    i22 = i3;
                                    i19 = i5;
                                    i21 = i53;
                                    i24 = i4;
                                    i8 = i46;
                                    if (i47 == 5) {
                                        j4.f3918f.b(t2, j2, t.D4(bArr2, i24));
                                        i27 = i24 + 4;
                                        i25 = i27;
                                        i26 = i17 | i52;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 2:
                                case 3:
                                    i22 = i3;
                                    i19 = i5;
                                    i21 = i53;
                                    i24 = i4;
                                    i8 = i46;
                                    if (i47 == 0) {
                                        i25 = t.r4(bArr2, i24, n0Var2);
                                        unsafe2.putLong(t, j2, n0Var2.f3968b);
                                        i26 = i17 | i52;
                                        i19 = i19;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 4:
                                case 11:
                                    i22 = i3;
                                    i19 = i5;
                                    i21 = i53;
                                    i24 = i4;
                                    i8 = i46;
                                    if (i47 == 0) {
                                        i27 = t.U3(bArr2, i24, n0Var2);
                                        unsafe2.putInt(t2, j2, n0Var2.f3967a);
                                        i25 = i27;
                                        i26 = i17 | i52;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 5:
                                case 14:
                                    i22 = i3;
                                    i28 = i5;
                                    i21 = i53;
                                    i29 = i4;
                                    i8 = i46;
                                    if (i47 == 1) {
                                        unsafe2.putLong(t, j2, t.x4(bArr2, i29));
                                        i27 = i29 + 8;
                                        i19 = i28;
                                        i25 = i27;
                                        i26 = i17 | i52;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i24 = i29;
                                    i19 = i28;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 6:
                                case 13:
                                    i22 = i3;
                                    i28 = i5;
                                    i21 = i53;
                                    i29 = i4;
                                    i8 = i46;
                                    if (i47 == 5) {
                                        unsafe2.putInt(t2, j2, t.n4(bArr2, i29));
                                        i40 = i29 + 4;
                                        i23 = i17 | i52;
                                        i42 = i28;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i24 = i29;
                                    i19 = i28;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 7:
                                    i22 = i3;
                                    i28 = i5;
                                    i21 = i53;
                                    i29 = i4;
                                    i8 = i46;
                                    if (i47 == 0) {
                                        i40 = t.r4(bArr2, i29, n0Var2);
                                        if (n0Var2.f3968b == 0) {
                                            z = false;
                                        }
                                        j4.f3918f.d(t2, j2, z);
                                        i23 = i17 | i52;
                                        i42 = i28;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i24 = i29;
                                    i19 = i28;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 8:
                                    i22 = i3;
                                    i30 = i5;
                                    i21 = i53;
                                    i31 = i4;
                                    i8 = i46;
                                    if (i47 == 2) {
                                        i27 = (i49 & 536870912) == 0 ? t.B4(bArr2, i31, n0Var2) : t.F4(bArr2, i31, n0Var2);
                                        obj = n0Var2.f3969c;
                                        unsafe2.putObject(t2, j2, obj);
                                        i19 = i30;
                                        i25 = i27;
                                        i26 = i17 | i52;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i24 = i31;
                                    i19 = i30;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 9:
                                    i30 = i5;
                                    i21 = i53;
                                    i31 = i4;
                                    i8 = i46;
                                    if (i47 == 2) {
                                        i22 = i3;
                                        i27 = t.Q3(e3Var.x(i30), bArr2, i31, i22, n0Var2);
                                        Object object = unsafe2.getObject(t2, j2);
                                        if (object != null) {
                                            obj = u1.f(object, n0Var2.f3969c);
                                            unsafe2.putObject(t2, j2, obj);
                                            i19 = i30;
                                            i25 = i27;
                                            i26 = i17 | i52;
                                            i23 = i26;
                                            i40 = i25;
                                            i42 = i19;
                                            i41 = i18;
                                            i36 = i22;
                                            i39 = i21;
                                            i38 = 0;
                                            i37 = -1;
                                            i43 = i23;
                                            i44 = i8;
                                        }
                                        obj = n0Var2.f3969c;
                                        unsafe2.putObject(t2, j2, obj);
                                        i19 = i30;
                                        i25 = i27;
                                        i26 = i17 | i52;
                                        i23 = i26;
                                        i40 = i25;
                                        i42 = i19;
                                        i41 = i18;
                                        i36 = i22;
                                        i39 = i21;
                                        i38 = 0;
                                        i37 = -1;
                                        i43 = i23;
                                        i44 = i8;
                                    }
                                    i24 = i31;
                                    i19 = i30;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 10:
                                    i30 = i5;
                                    i12 = i53;
                                    i31 = i4;
                                    i8 = i46;
                                    if (i47 == 2) {
                                        i32 = t.K4(bArr2, i31, n0Var2);
                                        unsafe2.putObject(t2, j2, n0Var2.f3969c);
                                        i33 = i32;
                                        int i55 = i17 | i52;
                                        i41 = i18;
                                        i11 = i30;
                                        i43 = i55;
                                        i40 = i33;
                                        break;
                                    }
                                    i24 = i31;
                                    i19 = i30;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 12:
                                    i30 = i5;
                                    i12 = i53;
                                    i31 = i4;
                                    i8 = i46;
                                    if (i47 == 0) {
                                        i32 = t.U3(bArr2, i31, n0Var2);
                                        i34 = n0Var2.f3967a;
                                        unsafe2.putInt(t2, j2, i34);
                                        i33 = i32;
                                        int i552 = i17 | i52;
                                        i41 = i18;
                                        i11 = i30;
                                        i43 = i552;
                                        i40 = i33;
                                        break;
                                    }
                                    i24 = i31;
                                    i19 = i30;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 15:
                                    i30 = i5;
                                    i12 = i53;
                                    i31 = i4;
                                    i8 = i46;
                                    if (i47 == 0) {
                                        i32 = t.U3(bArr2, i31, n0Var2);
                                        i34 = z0.a(n0Var2.f3967a);
                                        unsafe2.putInt(t2, j2, i34);
                                        i33 = i32;
                                        int i5522 = i17 | i52;
                                        i41 = i18;
                                        i11 = i30;
                                        i43 = i5522;
                                        i40 = i33;
                                        break;
                                    }
                                    i24 = i31;
                                    i19 = i30;
                                    i20 = i24;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                                case 16:
                                    if (i47 != 0) {
                                        i8 = i46;
                                        i20 = i4;
                                        i19 = i5;
                                        i10 = i20;
                                        i38 = i19;
                                        i9 = i18;
                                        unsafe = unsafe2;
                                        i43 = i17;
                                        i7 = 0;
                                        i6 = -1;
                                        break;
                                    } else {
                                        i33 = t.r4(bArr2, i4, n0Var2);
                                        i8 = i46;
                                        i30 = i5;
                                        i12 = i53;
                                        unsafe2.putLong(t, j2, z0.b(n0Var2.f3968b));
                                        int i55222 = i17 | i52;
                                        i41 = i18;
                                        i11 = i30;
                                        i43 = i55222;
                                        i40 = i33;
                                        break;
                                    }
                                default:
                                    i19 = i5;
                                    i20 = i4;
                                    i8 = i46;
                                    i10 = i20;
                                    i38 = i19;
                                    i9 = i18;
                                    unsafe = unsafe2;
                                    i43 = i17;
                                    i7 = 0;
                                    i6 = -1;
                                    break;
                            }
                        } else {
                            i8 = i46;
                            i12 = 1048575;
                            if (i50 != 27) {
                                i13 = i5;
                                if (i50 <= 49) {
                                    i14 = i43;
                                    i7 = 0;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i41;
                                    i40 = k(t, bArr, i4, i3, b2, i8, i47, i13, (long) i49, i50, j2, n0Var);
                                } else {
                                    i16 = i4;
                                    i14 = i43;
                                    unsafe = unsafe2;
                                    i9 = i41;
                                    i7 = 0;
                                    i6 = -1;
                                    if (i50 != 50) {
                                        i40 = j(t, bArr, i16, i3, b2, i8, i47, i49, i50, j2, i13, n0Var);
                                    } else if (i47 == 2) {
                                        l(t, bArr, i16, i3, i13, j2, n0Var);
                                        throw null;
                                    }
                                }
                                i15 = i40;
                                i10 = i15;
                                i43 = i14;
                                i38 = i13;
                            } else if (i47 == 2) {
                                z1 z1Var = (z1) unsafe2.getObject(t2, j2);
                                if (!z1Var.s()) {
                                    int size = z1Var.size();
                                    z1Var = z1Var.B(size == 0 ? 10 : size << 1);
                                    unsafe2.putObject(t2, j2, z1Var);
                                }
                                i11 = i5;
                                i40 = t.O3(e3Var.x(i5), b2, bArr, i4, i3, z1Var, n0Var);
                                i43 = i43;
                                i41 = i41;
                            } else {
                                i13 = i5;
                                i16 = i4;
                                i9 = i41;
                                i14 = i43;
                                unsafe = unsafe2;
                                i7 = 0;
                                i6 = -1;
                            }
                            i15 = i16;
                            i10 = i15;
                            i43 = i14;
                            i38 = i13;
                        }
                        i36 = i3;
                        i44 = i8;
                        i39 = i12;
                        i42 = i11;
                        i38 = 0;
                        i37 = -1;
                    }
                    i40 = t.K3(b2, bArr, i10, i3, M(t), n0Var);
                    i42 = i38;
                    i41 = i9;
                    e3Var = this;
                    t2 = t;
                    bArr2 = bArr;
                    i36 = i3;
                    n0Var2 = n0Var;
                    i44 = i8;
                    i38 = i7;
                    unsafe2 = unsafe;
                    i37 = i6;
                    i39 = 1048575;
                } else {
                    if (i46 >= e3Var.f3881c && i46 <= e3Var.f3882d) {
                        i35 = e3Var.N(i46, i38);
                    }
                    i5 = i37;
                    if (i5 == i37) {
                    }
                    i40 = t.K3(b2, bArr, i10, i3, M(t), n0Var);
                    i42 = i38;
                    i41 = i9;
                    e3Var = this;
                    t2 = t;
                    bArr2 = bArr;
                    i36 = i3;
                    n0Var2 = n0Var;
                    i44 = i8;
                    i38 = i7;
                    unsafe2 = unsafe;
                    i37 = i6;
                    i39 = 1048575;
                }
                i5 = i35;
                if (i5 == i37) {
                }
                i40 = t.K3(b2, bArr, i10, i3, M(t), n0Var);
                i42 = i38;
                i41 = i9;
                e3Var = this;
                t2 = t;
                bArr2 = bArr;
                i36 = i3;
                n0Var2 = n0Var;
                i44 = i8;
                i38 = i7;
                unsafe2 = unsafe;
                i37 = i6;
                i39 = 1048575;
            }
            if (i41 != i39) {
                unsafe2.putInt(t, (long) i41, i43);
            }
            if (i40 != i3) {
                throw c2.e();
            }
            return;
        }
        m(t, bArr, i2, i3, 0, n0Var);
    }

    @Override // c.b.a.a.g.h.q3
    public final void h(T t, T t2) {
        int i2;
        if (t2 != null) {
            for (int i3 = 0; i3 < this.f3879a.length; i3 += 3) {
                int A = A(i3);
                long j2 = (long) (1048575 & A);
                int i4 = this.f3879a[i3];
                switch ((A & 267386880) >>> 20) {
                    case 0:
                        if (D(t2, i3)) {
                            j4.c(t, j2, j4.r(t2, j2));
                            F(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (D(t2, i3)) {
                            j4.f3918f.b(t, j2, j4.q(t2, j2));
                            F(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.d(t, j2, j4.o(t2, j2));
                        F(t, i3);
                        break;
                    case 3:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.d(t, j2, j4.o(t2, j2));
                        F(t, i3);
                        break;
                    case 4:
                        if (!D(t2, i3)) {
                            break;
                        }
                        i2 = j4.m(t2, j2);
                        j4.f3918f.e(t, j2, i2);
                        F(t, i3);
                        break;
                    case 5:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.d(t, j2, j4.o(t2, j2));
                        F(t, i3);
                        break;
                    case 6:
                        if (!D(t2, i3)) {
                            break;
                        }
                        i2 = j4.m(t2, j2);
                        j4.f3918f.e(t, j2, i2);
                        F(t, i3);
                        break;
                    case 7:
                        if (D(t2, i3)) {
                            j4.f3918f.d(t, j2, j4.p(t2, j2));
                            F(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.e(t, j2, j4.s(t2, j2));
                        F(t, i3);
                        break;
                    case 9:
                    case 17:
                        s(t, t2, i3);
                        break;
                    case 10:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.e(t, j2, j4.s(t2, j2));
                        F(t, i3);
                        break;
                    case 11:
                        if (!D(t2, i3)) {
                            break;
                        }
                        i2 = j4.m(t2, j2);
                        j4.f3918f.e(t, j2, i2);
                        F(t, i3);
                        break;
                    case 12:
                        if (!D(t2, i3)) {
                            break;
                        }
                        i2 = j4.m(t2, j2);
                        j4.f3918f.e(t, j2, i2);
                        F(t, i3);
                        break;
                    case 13:
                        if (!D(t2, i3)) {
                            break;
                        }
                        i2 = j4.m(t2, j2);
                        j4.f3918f.e(t, j2, i2);
                        F(t, i3);
                        break;
                    case 14:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.d(t, j2, j4.o(t2, j2));
                        F(t, i3);
                        break;
                    case 15:
                        if (D(t2, i3)) {
                            i2 = j4.m(t2, j2);
                            j4.f3918f.e(t, j2, i2);
                            F(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (!D(t2, i3)) {
                            break;
                        }
                        j4.d(t, j2, j4.o(t2, j2));
                        F(t, i3);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.l.a(t, t2, j2);
                        break;
                    case 50:
                        s3.g(this.o, t, t2, j2);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!w(t2, i4, i3)) {
                            break;
                        }
                        j4.e(t, j2, j4.s(t2, j2));
                        C(t, i4, i3);
                        break;
                    case 60:
                    case 68:
                        v(t, t2, i3);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!w(t2, i4, i3)) {
                            break;
                        }
                        j4.e(t, j2, j4.s(t2, j2));
                        C(t, i4, i3);
                        break;
                }
            }
            s3.h(this.m, t, t2);
            if (this.f3884f) {
                s3.f(this.n, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x04bf  */
    @Override // c.b.a.a.g.h.q3
    public final void i(T t, v4 v4Var) {
        Map.Entry<t1.c, Object> entry;
        Iterator<Map.Entry<t1.c, Object>> it;
        int length;
        int i2;
        double d2;
        float f2;
        long j2;
        long j3;
        int i3;
        long j4;
        int i4;
        boolean z;
        int i5;
        int i6;
        int i7;
        long j5;
        int i8;
        long j6;
        d1 d1Var = (d1) v4Var;
        if (d1Var == null) {
            throw null;
        } else if (this.f3885g) {
            if (this.f3884f) {
                if (((i1) this.n) != null) {
                    j1<t1.c> j1Var = t.zzyg;
                    if (!j1Var.f3910a.isEmpty()) {
                        it = j1Var.b();
                        entry = it.next();
                        length = this.f3879a.length;
                        for (i2 = 0; i2 < length; i2 += 3) {
                            int A = A(i2);
                            int i9 = this.f3879a[i2];
                            while (entry != null && this.n.a(entry) <= i9) {
                                this.n.b(v4Var, entry);
                                entry = it.hasNext() ? it.next() : null;
                            }
                            switch ((267386880 & A) >>> 20) {
                                case 0:
                                    if (D(t, i2)) {
                                        d2 = j4.r(t, (long) (A & 1048575));
                                        d1Var.a(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    if (D(t, i2)) {
                                        f2 = j4.q(t, (long) (A & 1048575));
                                        d1Var.b(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    if (D(t, i2)) {
                                        j2 = j4.o(t, (long) (A & 1048575));
                                        d1Var.k(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3:
                                    if (D(t, i2)) {
                                        j3 = j4.o(t, (long) (A & 1048575));
                                        d1Var.c(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 4:
                                    if (D(t, i2)) {
                                        i3 = j4.m(t, (long) (A & 1048575));
                                        d1Var.f3864a.G(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 5:
                                    if (D(t, i2)) {
                                        j4 = j4.o(t, (long) (A & 1048575));
                                        d1Var.j(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 6:
                                    if (D(t, i2)) {
                                        i4 = j4.m(t, (long) (A & 1048575));
                                        d1Var.o(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 7:
                                    if (D(t, i2)) {
                                        z = j4.p(t, (long) (A & 1048575));
                                        d1Var.g(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 8:
                                    if (!D(t, i2)) {
                                        break;
                                    }
                                    p(i9, j4.s(t, (long) (A & 1048575)), v4Var);
                                    break;
                                case 9:
                                    if (!D(t, i2)) {
                                        break;
                                    }
                                    d1Var.f(i9, j4.s(t, (long) (A & 1048575)), x(i2));
                                    break;
                                case 10:
                                    if (!D(t, i2)) {
                                        break;
                                    }
                                    d1Var.d(i9, (q0) j4.s(t, (long) (A & 1048575)));
                                    break;
                                case 11:
                                    if (D(t, i2)) {
                                        i5 = j4.m(t, (long) (A & 1048575));
                                        d1Var.m(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 12:
                                    if (D(t, i2)) {
                                        i6 = j4.m(t, (long) (A & 1048575));
                                        d1Var.f3864a.G(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 13:
                                    if (D(t, i2)) {
                                        i7 = j4.m(t, (long) (A & 1048575));
                                        d1Var.p(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 14:
                                    if (D(t, i2)) {
                                        j5 = j4.o(t, (long) (A & 1048575));
                                        d1Var.l(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 15:
                                    if (D(t, i2)) {
                                        i8 = j4.m(t, (long) (A & 1048575));
                                        d1Var.n(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 16:
                                    if (D(t, i2)) {
                                        j6 = j4.o(t, (long) (A & 1048575));
                                        d1Var.h(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 17:
                                    if (!D(t, i2)) {
                                        break;
                                    }
                                    d1Var.i(i9, j4.s(t, (long) (A & 1048575)), x(i2));
                                    break;
                                case 18:
                                    s3.e(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 19:
                                    s3.k(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 20:
                                    s3.o(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 21:
                                    s3.r(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 22:
                                    s3.x(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 23:
                                    s3.u(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 24:
                                    s3.A(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 25:
                                    s3.E(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 26:
                                    s3.c(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var);
                                    break;
                                case 27:
                                    s3.d(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, x(i2));
                                    break;
                                case 28:
                                    s3.i(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var);
                                    break;
                                case 29:
                                    s3.y(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 30:
                                    s3.C(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 31:
                                    s3.B(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 32:
                                    s3.v(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 33:
                                    s3.z(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 34:
                                    s3.s(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, false);
                                    break;
                                case 35:
                                    s3.e(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 36:
                                    s3.k(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 37:
                                    s3.o(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 38:
                                    s3.r(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 39:
                                    s3.x(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 40:
                                    s3.u(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 41:
                                    s3.A(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 42:
                                    s3.E(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 43:
                                    s3.y(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 44:
                                    s3.C(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 45:
                                    s3.B(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 46:
                                    s3.v(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 47:
                                    s3.z(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 48:
                                    s3.s(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, true);
                                    break;
                                case 49:
                                    s3.j(this.f3879a[i2], (List) j4.s(t, (long) (A & 1048575)), v4Var, x(i2));
                                    break;
                                case 50:
                                    r(v4Var, i9, j4.s(t, (long) (A & 1048575)), i2);
                                    break;
                                case 51:
                                    if (w(t, i9, i2)) {
                                        d2 = H(t, (long) (A & 1048575));
                                        d1Var.a(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 52:
                                    if (w(t, i9, i2)) {
                                        f2 = I(t, (long) (A & 1048575));
                                        d1Var.b(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 53:
                                    if (w(t, i9, i2)) {
                                        j2 = K(t, (long) (A & 1048575));
                                        d1Var.k(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 54:
                                    if (w(t, i9, i2)) {
                                        j3 = K(t, (long) (A & 1048575));
                                        d1Var.c(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 55:
                                    if (w(t, i9, i2)) {
                                        i3 = J(t, (long) (A & 1048575));
                                        d1Var.f3864a.G(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 56:
                                    if (w(t, i9, i2)) {
                                        j4 = K(t, (long) (A & 1048575));
                                        d1Var.j(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 57:
                                    if (w(t, i9, i2)) {
                                        i4 = J(t, (long) (A & 1048575));
                                        d1Var.o(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 58:
                                    if (w(t, i9, i2)) {
                                        z = L(t, (long) (A & 1048575));
                                        d1Var.g(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 59:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    p(i9, j4.s(t, (long) (A & 1048575)), v4Var);
                                    break;
                                case 60:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    d1Var.f(i9, j4.s(t, (long) (A & 1048575)), x(i2));
                                    break;
                                case 61:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    d1Var.d(i9, (q0) j4.s(t, (long) (A & 1048575)));
                                    break;
                                case 62:
                                    if (w(t, i9, i2)) {
                                        i5 = J(t, (long) (A & 1048575));
                                        d1Var.m(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 63:
                                    if (w(t, i9, i2)) {
                                        i6 = J(t, (long) (A & 1048575));
                                        d1Var.f3864a.G(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 64:
                                    if (w(t, i9, i2)) {
                                        i7 = J(t, (long) (A & 1048575));
                                        d1Var.p(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 65:
                                    if (w(t, i9, i2)) {
                                        j5 = K(t, (long) (A & 1048575));
                                        d1Var.l(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 66:
                                    if (w(t, i9, i2)) {
                                        i8 = J(t, (long) (A & 1048575));
                                        d1Var.n(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 67:
                                    if (w(t, i9, i2)) {
                                        j6 = K(t, (long) (A & 1048575));
                                        d1Var.h(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 68:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    d1Var.i(i9, j4.s(t, (long) (A & 1048575)), x(i2));
                                    break;
                            }
                        }
                        while (entry != null) {
                            this.n.b(v4Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        q(this.m, t, v4Var);
                    }
                } else {
                    throw null;
                }
            }
            it = null;
            entry = null;
            length = this.f3879a.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            q(this.m, t, v4Var);
        } else {
            u(t, v4Var);
        }
    }

    public final int j(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, n0 n0Var) {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        Unsafe unsafe = q;
        long j4 = (long) (this.f3879a[i9 + 2] & 1048575);
        boolean z = true;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(t.y4(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(t.D4(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = t.r4(bArr, i2, n0Var);
                    j3 = n0Var.f3968b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = t.U3(bArr, i2, n0Var);
                    i11 = n0Var.f3967a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(t.x4(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(t.n4(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = t.r4(bArr, i2, n0Var);
                    if (n0Var.f3968b == 0) {
                        z = false;
                    }
                    obj3 = Boolean.valueOf(z);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    i10 = t.U3(bArr, i2, n0Var);
                    int i12 = n0Var.f3967a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || k4.d(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, u1.f4042a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw c2.f();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = t.Q3(x(i9), bArr, i2, i3, n0Var);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = n0Var.f3969c;
                    if (object != null) {
                        obj3 = u1.f(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = t.K4(bArr, i2, n0Var);
                    obj3 = n0Var.f3969c;
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int U3 = t.U3(bArr, i2, n0Var);
                    int i13 = n0Var.f3967a;
                    y1 y1Var = (y1) this.f3880b[((i9 / 3) << 1) + 1];
                    if (y1Var == null || y1Var.a(i13)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        i10 = U3;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    }
                    M(t).a(i4, Long.valueOf((long) i13));
                    return U3;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = t.U3(bArr, i2, n0Var);
                    i11 = z0.a(n0Var.f3967a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = t.r4(bArr, i2, n0Var);
                    j3 = z0.b(n0Var.f3968b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = t.P3(x(i9), bArr, i2, i3, (i4 & -8) | 4, n0Var);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = n0Var.f3969c;
                    if (object2 != null) {
                        obj3 = u1.f(object2, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            default:
                return i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0276, code lost:
        if (r30.f3968b != 0) goto L_0x0291;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0279, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x027a, code lost:
        r11.c(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x027d, code lost:
        if (r4 >= r20) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x027f, code lost:
        r6 = b.x.t.U3(r18, r4, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0285, code lost:
        if (r21 != r30.f3967a) goto L_0x03d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0287, code lost:
        r4 = b.x.t.r4(r18, r6, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x028f, code lost:
        if (r30.f3968b == 0) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0291, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0144, code lost:
        if (r4 == 0) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0147, code lost:
        r11.add(c.b.a.a.g.h.q0.a(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014f, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0151, code lost:
        r4 = b.x.t.U3(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0157, code lost:
        if (r21 != r30.f3967a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0159, code lost:
        r1 = b.x.t.U3(r18, r4, r30);
        r4 = r30.f3967a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x015f, code lost:
        if (r4 < 0) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0163, code lost:
        if (r4 > (r18.length - r1)) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0165, code lost:
        if (r4 != 0) goto L_0x0147;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0167, code lost:
        r11.add(c.b.a.a.g.h.q0.f4006c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0171, code lost:
        throw c.b.a.a.g.h.c2.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0176, code lost:
        throw c.b.a.a.g.h.c2.b();
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01c0  */
    public final int k(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, n0 n0Var) {
        int r4;
        int U3;
        int U32;
        int r42;
        int i9 = i2;
        z1 z1Var = (z1) q.getObject(t, j3);
        if (!z1Var.s()) {
            int size = z1Var.size();
            z1Var = z1Var.B(size == 0 ? 10 : size << 1);
            q.putObject(t, j3, z1Var);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    c1 c1Var = (c1) z1Var;
                    int U33 = t.U3(bArr, i9, n0Var);
                    int i10 = n0Var.f3967a + U33;
                    while (U33 < i10) {
                        c1Var.g(t.y4(bArr, U33));
                        U33 += 8;
                    }
                    if (U33 == i10) {
                        return U33;
                    }
                    throw c2.a();
                }
                if (i6 == 1) {
                    c1 c1Var2 = (c1) z1Var;
                    double y4 = t.y4(bArr, i2);
                    while (true) {
                        c1Var2.g(y4);
                        int i11 = i9 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i9 = t.U3(bArr, i11, n0Var);
                        if (i4 != n0Var.f3967a) {
                            return i11;
                        }
                        y4 = t.y4(bArr, i9);
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i6 == 2) {
                    p1 p1Var = (p1) z1Var;
                    int U34 = t.U3(bArr, i9, n0Var);
                    int i12 = n0Var.f3967a + U34;
                    while (U34 < i12) {
                        p1Var.g(t.D4(bArr, U34));
                        U34 += 4;
                    }
                    if (U34 == i12) {
                        return U34;
                    }
                    throw c2.a();
                }
                if (i6 == 5) {
                    p1 p1Var2 = (p1) z1Var;
                    float D4 = t.D4(bArr, i2);
                    while (true) {
                        p1Var2.g(D4);
                        int i13 = i9 + 4;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i9 = t.U3(bArr, i13, n0Var);
                        if (i4 != n0Var.f3967a) {
                            return i13;
                        }
                        D4 = t.D4(bArr, i9);
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    q2 q2Var = (q2) z1Var;
                    int U35 = t.U3(bArr, i9, n0Var);
                    int i14 = n0Var.f3967a + U35;
                    while (U35 < i14) {
                        U35 = t.r4(bArr, U35, n0Var);
                        q2Var.e(n0Var.f3968b);
                    }
                    if (U35 == i14) {
                        return U35;
                    }
                    throw c2.a();
                }
                if (i6 == 0) {
                    q2 q2Var2 = (q2) z1Var;
                    do {
                        r4 = t.r4(bArr, i9, n0Var);
                        q2Var2.e(n0Var.f3968b);
                        if (r4 >= i3) {
                            return r4;
                        }
                        i9 = t.U3(bArr, r4, n0Var);
                    } while (i4 == n0Var.f3967a);
                    return r4;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return t.V3(bArr, i9, z1Var, n0Var);
                }
                if (i6 == 0) {
                    return t.J3(i4, bArr, i2, i3, z1Var, n0Var);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    q2 q2Var3 = (q2) z1Var;
                    int U36 = t.U3(bArr, i9, n0Var);
                    int i15 = n0Var.f3967a + U36;
                    while (U36 < i15) {
                        q2Var3.e(t.x4(bArr, U36));
                        U36 += 8;
                    }
                    if (U36 == i15) {
                        return U36;
                    }
                    throw c2.a();
                }
                if (i6 == 1) {
                    q2 q2Var4 = (q2) z1Var;
                    long x4 = t.x4(bArr, i2);
                    while (true) {
                        q2Var4.e(x4);
                        int i16 = i9 + 8;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i9 = t.U3(bArr, i16, n0Var);
                        if (i4 != n0Var.f3967a) {
                            return i16;
                        }
                        x4 = t.x4(bArr, i9);
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    v1 v1Var = (v1) z1Var;
                    int U37 = t.U3(bArr, i9, n0Var);
                    int i17 = n0Var.f3967a + U37;
                    while (U37 < i17) {
                        v1Var.h(t.n4(bArr, U37));
                        U37 += 4;
                    }
                    if (U37 == i17) {
                        return U37;
                    }
                    throw c2.a();
                }
                if (i6 == 5) {
                    v1 v1Var2 = (v1) z1Var;
                    int n4 = t.n4(bArr, i2);
                    while (true) {
                        v1Var2.h(n4);
                        int i18 = i9 + 4;
                        if (i18 >= i3) {
                            return i18;
                        }
                        i9 = t.U3(bArr, i18, n0Var);
                        if (i4 != n0Var.f3967a) {
                            return i18;
                        }
                        n4 = t.n4(bArr, i9);
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i6 == 2) {
                    p0 p0Var = (p0) z1Var;
                    U3 = t.U3(bArr, i9, n0Var);
                    int i19 = n0Var.f3967a + U3;
                    while (U3 < i19) {
                        U3 = t.r4(bArr, U3, n0Var);
                        p0Var.c(n0Var.f3968b != 0);
                    }
                    if (U3 != i19) {
                        throw c2.a();
                    }
                    return U3;
                }
                if (i6 == 0) {
                    p0 p0Var2 = (p0) z1Var;
                    i9 = t.r4(bArr, i9, n0Var);
                    break;
                }
                return i9;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int U38 = t.U3(bArr, i9, n0Var);
                        int i20 = n0Var.f3967a;
                        if (i20 >= 0) {
                            if (i20 != 0) {
                                String str = new String(bArr, U38, i20, u1.f4042a);
                                z1Var.add(str);
                                U38 += i20;
                                if (U38 < i3) {
                                    int U39 = t.U3(bArr, U38, n0Var);
                                    if (i4 == n0Var.f3967a) {
                                        U38 = t.U3(bArr, U39, n0Var);
                                        i20 = n0Var.f3967a;
                                        if (i20 >= 0) {
                                            if (i20 != 0) {
                                                str = new String(bArr, U38, i20, u1.f4042a);
                                                z1Var.add(str);
                                                U38 += i20;
                                                if (U38 < i3) {
                                                    return U38;
                                                }
                                            }
                                        }
                                        throw c2.b();
                                    }
                                    return U38;
                                }
                                return U38;
                            }
                            z1Var.add("");
                            if (U38 < i3) {
                            }
                            return U38;
                        }
                        throw c2.b();
                    }
                    int U310 = t.U3(bArr, i9, n0Var);
                    int i21 = n0Var.f3967a;
                    if (i21 >= 0) {
                        if (i21 != 0) {
                            int i22 = U310 + i21;
                            if (k4.d(bArr, U310, i22)) {
                                String str2 = new String(bArr, U310, i21, u1.f4042a);
                                z1Var.add(str2);
                                U310 = i22;
                                if (U310 < i3) {
                                    int U311 = t.U3(bArr, U310, n0Var);
                                    if (i4 == n0Var.f3967a) {
                                        U310 = t.U3(bArr, U311, n0Var);
                                        int i23 = n0Var.f3967a;
                                        if (i23 >= 0) {
                                            if (i23 != 0) {
                                                i22 = U310 + i23;
                                                if (k4.d(bArr, U310, i22)) {
                                                    str2 = new String(bArr, U310, i23, u1.f4042a);
                                                    z1Var.add(str2);
                                                    U310 = i22;
                                                    if (U310 < i3) {
                                                        return U310;
                                                    }
                                                }
                                                throw c2.f();
                                            }
                                        }
                                        throw c2.b();
                                    }
                                    return U310;
                                }
                                return U310;
                            }
                            throw c2.f();
                        }
                        z1Var.add("");
                        if (U310 < i3) {
                        }
                        return U310;
                    }
                    throw c2.b();
                }
                return i9;
            case 27:
                if (i6 == 2) {
                    return t.O3(x(i7), i4, bArr, i2, i3, z1Var, n0Var);
                }
                return i9;
            case 28:
                if (i6 == 2) {
                    int U312 = t.U3(bArr, i9, n0Var);
                    int i24 = n0Var.f3967a;
                    if (i24 < 0) {
                        throw c2.b();
                    } else if (i24 > bArr.length - U312) {
                        throw c2.a();
                    }
                }
                return i9;
            case 30:
            case 44:
                if (i6 == 2) {
                    U3 = t.V3(bArr, i9, z1Var, n0Var);
                } else {
                    if (i6 == 0) {
                        U3 = t.J3(i4, bArr, i2, i3, z1Var, n0Var);
                    }
                    return i9;
                }
                T t2 = t;
                c4 c4Var = t2.zzxz;
                if (c4Var == c4.f3851f) {
                    c4Var = null;
                }
                c4 c4Var2 = (c4) s3.b(i5, z1Var, (y1) this.f3880b[((i7 / 3) << 1) + 1], c4Var, this.m);
                if (c4Var2 != null) {
                    t2.zzxz = c4Var2;
                }
                return U3;
            case 33:
            case 47:
                if (i6 == 2) {
                    v1 v1Var3 = (v1) z1Var;
                    int U313 = t.U3(bArr, i9, n0Var);
                    int i25 = n0Var.f3967a + U313;
                    while (U313 < i25) {
                        U313 = t.U3(bArr, U313, n0Var);
                        v1Var3.h(z0.a(n0Var.f3967a));
                    }
                    if (U313 == i25) {
                        return U313;
                    }
                    throw c2.a();
                }
                if (i6 == 0) {
                    v1 v1Var4 = (v1) z1Var;
                    do {
                        U32 = t.U3(bArr, i9, n0Var);
                        v1Var4.h(z0.a(n0Var.f3967a));
                        if (U32 >= i3) {
                            return U32;
                        }
                        i9 = t.U3(bArr, U32, n0Var);
                    } while (i4 == n0Var.f3967a);
                    return U32;
                }
                return i9;
            case 34:
            case 48:
                if (i6 == 2) {
                    q2 q2Var5 = (q2) z1Var;
                    int U314 = t.U3(bArr, i9, n0Var);
                    int i26 = n0Var.f3967a + U314;
                    while (U314 < i26) {
                        U314 = t.r4(bArr, U314, n0Var);
                        q2Var5.e(z0.b(n0Var.f3968b));
                    }
                    if (U314 == i26) {
                        return U314;
                    }
                    throw c2.a();
                }
                if (i6 == 0) {
                    q2 q2Var6 = (q2) z1Var;
                    do {
                        r42 = t.r4(bArr, i9, n0Var);
                        q2Var6.e(z0.b(n0Var.f3968b));
                        if (r42 >= i3) {
                            return r42;
                        }
                        i9 = t.U3(bArr, r42, n0Var);
                    } while (i4 == n0Var.f3967a);
                    return r42;
                }
                return i9;
            case 49:
                if (i6 == 3) {
                    q3 x = x(i7);
                    int i27 = (i4 & -8) | 4;
                    i9 = t.P3(x, bArr, i2, i3, i27, n0Var);
                    while (true) {
                        z1Var.add(n0Var.f3969c);
                        if (i9 < i3) {
                            int U315 = t.U3(bArr, i9, n0Var);
                            if (i4 == n0Var.f3967a) {
                                i9 = t.P3(x, bArr, U315, i3, i27, n0Var);
                            }
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    public final <K, V> int l(T t, byte[] bArr, int i2, int i3, int i4, long j2, n0 n0Var) {
        Unsafe unsafe = q;
        Object obj = this.f3880b[(i4 / 3) << 1];
        Object object = unsafe.getObject(t, j2);
        if (this.o.c(object)) {
            Object d2 = this.o.d(obj);
            this.o.e(d2, object);
            unsafe.putObject(t, j2, d2);
            object = d2;
        }
        this.o.h(obj);
        this.o.a(object);
        int U3 = t.U3(bArr, i2, n0Var);
        int i5 = n0Var.f3967a;
        if (i5 < 0 || i5 > i3 - U3) {
            throw c2.a();
        }
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v33 */
    /* JADX WARN: Type inference failed for: r10v29, types: [int] */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0436, code lost:
        if (r0 == r10) goto L_0x0493;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0491, code lost:
        if (r0 == r15) goto L_0x0493;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0493, code lost:
        r6 = r38;
        r2 = r0;
     */
    /* JADX WARNING: Unknown variable types count: 2 */
    public final int m(T t, byte[] bArr, int i2, int i3, int i4, n0 n0Var) {
        Unsafe unsafe;
        T t2;
        e3<T> e3Var;
        int i5;
        byte b2;
        ?? r3;
        int i6;
        int i7;
        int i8;
        boolean z;
        int i9;
        byte[] bArr2;
        T t3;
        int i10;
        n0 n0Var2;
        e3<T> e3Var2;
        int i11;
        boolean z2;
        boolean z3;
        int i12;
        int i13;
        Object obj;
        Object d2;
        long j2;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        byte b3;
        int i19;
        int i20;
        byte b4;
        int i21;
        long j3;
        int i22;
        int i23;
        char c2;
        boolean z4;
        byte b5;
        int i24;
        byte b6;
        byte b7;
        int i25;
        int i26;
        long j4;
        long j5;
        int i27;
        byte b8;
        int i28;
        int i29;
        Object obj2;
        long j6;
        int i30;
        long j7;
        long j8;
        Object obj3;
        T t4;
        e3<T> e3Var3 = this;
        T t5 = t;
        byte[] bArr3 = bArr;
        int i31 = i3;
        n0 n0Var3 = n0Var;
        Unsafe unsafe2 = q;
        int i32 = i2;
        int i33 = i4;
        byte[] bArr4 = bArr3;
        int i34 = -1;
        int i35 = 0;
        int i36 = 1048575;
        int i37 = 0;
        byte b9 = 0;
        while (true) {
            if (i32 < i31) {
                int i38 = i32 + 1;
                byte b10 = bArr4[i32];
                if (b10 < 0) {
                    i38 = t.M3(b10, bArr4, i38, n0Var3);
                    b10 = n0Var3.f3967a;
                }
                int i39 = b10 >>> 3;
                int i40 = b10 & 7;
                if (i39 > i34) {
                    i6 = (i39 < e3Var3.f3881c || i39 > e3Var3.f3882d) ? -1 : e3Var3.N(i39, i35 / 3);
                    r3 = 0;
                } else if (i39 < e3Var3.f3881c || i39 > e3Var3.f3882d) {
                    r3 = 0;
                    i6 = -1;
                } else {
                    r3 = 0;
                    i6 = e3Var3.N(i39, 0);
                }
                if (i6 == -1) {
                    z2 = r3;
                    i8 = i36;
                    i7 = i37;
                    i11 = i39;
                    unsafe = unsafe2;
                    i13 = i38;
                    b2 = b10;
                    z3 = true;
                    i12 = i33;
                    z = z2;
                } else {
                    int[] iArr = e3Var3.f3879a;
                    int i41 = iArr[i6 + 1];
                    int i42 = (i41 & 267386880) >>> 20;
                    long j9 = (long) (i41 & 1048575);
                    if (i42 <= 17) {
                        int i43 = iArr[i6 + 2];
                        int i44 = 1 << (i43 >>> 20);
                        int i45 = i43 & 1048575;
                        if (i45 != i36) {
                            if (i36 != 1048575) {
                                long j10 = (long) i36;
                                t4 = t;
                                j3 = j9;
                                unsafe2.putInt(t4, j10, i37);
                            } else {
                                t4 = t;
                                j3 = j9;
                            }
                            t5 = t4;
                            i22 = unsafe2.getInt(t4, (long) i45);
                            i23 = i45;
                        } else {
                            t5 = t;
                            j3 = j9;
                            i22 = i37;
                            i23 = i36;
                        }
                        switch (i42) {
                            case 0:
                                i8 = i23;
                                i18 = i39;
                                b5 = b10;
                                z4 = true;
                                c2 = 65535;
                                z2 = false;
                                i19 = i6;
                                if (i40 == 1) {
                                    j4.c(t5, j3, t.y4(bArr3, i38));
                                    i20 = i38 + 8;
                                    i24 = i22 | i44;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                }
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 1:
                                i8 = i23;
                                i18 = i39;
                                b5 = b10;
                                c2 = 65535;
                                z2 = false;
                                i19 = i6;
                                if (i40 == 5) {
                                    j4.f3918f.b(t5, j3, t.D4(bArr3, i38));
                                    i20 = i38 + 4;
                                    i24 = i22 | i44;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                }
                                z4 = true;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 2:
                            case 3:
                                i8 = i23;
                                i18 = i39;
                                b6 = b10;
                                c2 = 65535;
                                z2 = false;
                                i19 = i6;
                                j5 = j3;
                                if (i40 == 0) {
                                    i25 = t.r4(bArr3, i38, n0Var3);
                                    j4 = n0Var3.f3968b;
                                    b7 = b6;
                                    unsafe2.putLong(t, j5, j4);
                                    i26 = i22 | i44;
                                    i24 = i26;
                                    b5 = b7;
                                    i20 = i25;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                }
                                b5 = b6;
                                z4 = true;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 4:
                            case 11:
                                i8 = i23;
                                i18 = i39;
                                b6 = b10;
                                c2 = 65535;
                                z2 = false;
                                i19 = i6;
                                if (i40 == 0) {
                                    int U3 = t.U3(bArr3, i38, n0Var3);
                                    unsafe2.putInt(t5, j3, n0Var3.f3967a);
                                    i24 = i22 | i44;
                                    i20 = U3;
                                    b5 = b6;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                }
                                b5 = b6;
                                z4 = true;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 5:
                            case 14:
                                i8 = i23;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 1) {
                                    i18 = i39;
                                    i19 = i6;
                                    unsafe2.putLong(t, j3, t.x4(bArr3, i38));
                                    int i46 = i38 + 8;
                                    i26 = i22 | i44;
                                    b7 = b10;
                                    i25 = i46;
                                    i24 = i26;
                                    b5 = b7;
                                    i20 = i25;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                } else {
                                    i18 = i39;
                                    i19 = i6;
                                    z4 = true;
                                    b5 = b10;
                                    i12 = i4;
                                    z3 = z4;
                                    unsafe = unsafe2;
                                    i13 = i38;
                                    i7 = i22;
                                    i11 = i18;
                                    b2 = b5;
                                    z = i19;
                                    break;
                                }
                            case 6:
                            case 13:
                                i27 = i6;
                                i8 = i23;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 5) {
                                    unsafe2.putInt(t5, j3, t.n4(bArr3, i38));
                                    i20 = i38 + 4;
                                    i37 = i22 | i44;
                                    i18 = i39;
                                    i19 = i27;
                                    i36 = i8;
                                    b3 = b10;
                                    bArr4 = bArr3;
                                    break;
                                } else {
                                    b5 = b10;
                                    i18 = i39;
                                    i19 = i27;
                                    z4 = true;
                                    i12 = i4;
                                    z3 = z4;
                                    unsafe = unsafe2;
                                    i13 = i38;
                                    i7 = i22;
                                    i11 = i18;
                                    b2 = b5;
                                    z = i19;
                                    break;
                                }
                            case 7:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 0) {
                                    int r4 = t.r4(bArr3, i38, n0Var3);
                                    j4.f3918f.d(t5, j3, n0Var3.f3968b != 0);
                                    int i47 = i22 | i44;
                                    i33 = i4;
                                    i35 = i27;
                                    i31 = i3;
                                    i34 = i39;
                                    i36 = i8;
                                    b9 = b8;
                                    i37 = i47;
                                    i32 = r4;
                                    bArr4 = bArr3;
                                    continue;
                                }
                                i18 = i39;
                                b5 = b8;
                                i19 = i27;
                                z4 = true;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 8:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                j6 = j3;
                                c2 = 65535;
                                z2 = false;
                                i28 = i3;
                                if (i40 == 2) {
                                    i32 = (536870912 & i41) == 0 ? t.B4(bArr3, i38, n0Var3) : t.F4(bArr3, i38, n0Var3);
                                    obj2 = n0Var3.f3969c;
                                    unsafe2.putObject(t5, j6, obj2);
                                    i29 = i22 | i44;
                                    b9 = b8;
                                    i35 = i27;
                                    i31 = i28;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    i33 = i4;
                                    i37 = i29;
                                    i34 = i39;
                                }
                                i18 = i39;
                                b5 = b8;
                                i19 = i27;
                                z4 = true;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 9:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                j6 = j3;
                                c2 = 65535;
                                z2 = false;
                                if (i40 != 2) {
                                    i18 = i39;
                                    b5 = b8;
                                    i19 = i27;
                                    z4 = true;
                                    i12 = i4;
                                    z3 = z4;
                                    unsafe = unsafe2;
                                    i13 = i38;
                                    i7 = i22;
                                    i11 = i18;
                                    b2 = b5;
                                    z = i19;
                                    break;
                                } else {
                                    i28 = i3;
                                    i32 = t.Q3(e3Var3.x(i27), bArr3, i38, i28, n0Var3);
                                    if ((i22 & i44) != 0) {
                                        obj2 = u1.f(unsafe2.getObject(t5, j6), n0Var3.f3969c);
                                        unsafe2.putObject(t5, j6, obj2);
                                        i29 = i22 | i44;
                                        b9 = b8;
                                        i35 = i27;
                                        i31 = i28;
                                        bArr4 = bArr3;
                                        i36 = i8;
                                        i33 = i4;
                                        i37 = i29;
                                        i34 = i39;
                                    }
                                    obj2 = n0Var3.f3969c;
                                    unsafe2.putObject(t5, j6, obj2);
                                    i29 = i22 | i44;
                                    b9 = b8;
                                    i35 = i27;
                                    i31 = i28;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    i33 = i4;
                                    i37 = i29;
                                    i34 = i39;
                                }
                            case 10:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 2) {
                                    i32 = t.K4(bArr3, i38, n0Var3);
                                    unsafe2.putObject(t5, j3, n0Var3.f3969c);
                                    i29 = i22 | i44;
                                    i28 = i3;
                                    b9 = b8;
                                    i35 = i27;
                                    i31 = i28;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    i33 = i4;
                                    i37 = i29;
                                    i34 = i39;
                                }
                                b5 = b8;
                                i18 = i39;
                                z4 = true;
                                i19 = i27;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 12:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                j7 = j3;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 0) {
                                    i32 = t.U3(bArr3, i38, n0Var3);
                                    i30 = n0Var3.f3967a;
                                    y1 z5 = e3Var3.z(i27);
                                    if (z5 != null && !z5.a(i30)) {
                                        M(t).a(b8, Long.valueOf((long) i30));
                                        i18 = i39;
                                        bArr4 = bArr3;
                                        i37 = i22;
                                        b3 = b8;
                                        i19 = i27;
                                        i36 = i8;
                                        break;
                                    }
                                    unsafe2.putInt(t5, j7, i30);
                                    i29 = i22 | i44;
                                    i28 = i3;
                                    b9 = b8;
                                    i35 = i27;
                                    i31 = i28;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    i33 = i4;
                                    i37 = i29;
                                    i34 = i39;
                                }
                                b5 = b8;
                                i18 = i39;
                                z4 = true;
                                i19 = i27;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 15:
                                i27 = i6;
                                i8 = i23;
                                b8 = b10;
                                j7 = j3;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 0) {
                                    i32 = t.U3(bArr3, i38, n0Var3);
                                    i30 = z0.a(n0Var3.f3967a);
                                    unsafe2.putInt(t5, j7, i30);
                                    i29 = i22 | i44;
                                    i28 = i3;
                                    b9 = b8;
                                    i35 = i27;
                                    i31 = i28;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    i33 = i4;
                                    i37 = i29;
                                    i34 = i39;
                                }
                                b5 = b8;
                                i18 = i39;
                                z4 = true;
                                i19 = i27;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                            case 16:
                                i27 = i6;
                                b8 = b10;
                                j5 = j3;
                                c2 = 65535;
                                z2 = false;
                                if (i40 == 0) {
                                    int r42 = t.r4(bArr3, i38, n0Var3);
                                    i8 = i23;
                                    b6 = b8;
                                    j4 = z0.b(n0Var3.f3968b);
                                    i18 = i39;
                                    i25 = r42;
                                    i19 = i27;
                                    b7 = b6;
                                    unsafe2.putLong(t, j5, j4);
                                    i26 = i22 | i44;
                                    i24 = i26;
                                    b5 = b7;
                                    i20 = i25;
                                    i37 = i24;
                                    bArr4 = bArr3;
                                    i36 = i8;
                                    b3 = b5;
                                    break;
                                } else {
                                    i8 = i23;
                                    b5 = b8;
                                    i18 = i39;
                                    z4 = true;
                                    i19 = i27;
                                    i12 = i4;
                                    z3 = z4;
                                    unsafe = unsafe2;
                                    i13 = i38;
                                    i7 = i22;
                                    i11 = i18;
                                    b2 = b5;
                                    z = i19;
                                    break;
                                }
                            case 17:
                                if (i40 != 3) {
                                    c2 = 65535;
                                    z2 = false;
                                    i8 = i23;
                                    b5 = b10;
                                    i18 = i39;
                                    z4 = true;
                                    i19 = i6;
                                    i12 = i4;
                                    z3 = z4;
                                    unsafe = unsafe2;
                                    i13 = i38;
                                    i7 = i22;
                                    i11 = i18;
                                    b2 = b5;
                                    z = i19;
                                    break;
                                } else {
                                    i32 = t.P3(e3Var3.x(i6), bArr, i38, i3, (i39 << 3) | 4, n0Var);
                                    if ((i22 & i44) == 0) {
                                        obj3 = n0Var3.f3969c;
                                        j8 = j3;
                                    } else {
                                        j8 = j3;
                                        obj3 = u1.f(unsafe2.getObject(t5, j8), n0Var3.f3969c);
                                    }
                                    unsafe2.putObject(t5, j8, obj3);
                                    int i48 = i22 | i44;
                                    i31 = i3;
                                    i36 = i23;
                                    b9 = b10;
                                    i34 = i39;
                                    i35 = i6;
                                    bArr4 = bArr3;
                                    i37 = i48;
                                    i33 = i4;
                                    continue;
                                }
                            default:
                                i8 = i23;
                                i18 = i39;
                                b5 = b10;
                                z4 = true;
                                c2 = 65535;
                                z2 = false;
                                i19 = i6;
                                i12 = i4;
                                z3 = z4;
                                unsafe = unsafe2;
                                i13 = i38;
                                i7 = i22;
                                i11 = i18;
                                b2 = b5;
                                z = i19;
                                break;
                        }
                        i31 = i3;
                        i33 = i4;
                        i35 = i19;
                        b9 = b3;
                        i34 = i18;
                        bArr3 = bArr;
                    } else {
                        i18 = i39;
                        z2 = false;
                        t5 = t;
                        i19 = i6;
                        if (i42 != 27) {
                            i8 = i36;
                            i7 = i37;
                            if (i42 <= 49) {
                                b4 = b10;
                                i11 = i18;
                                z = i19;
                                unsafe = unsafe2;
                                z3 = true;
                                i32 = k(t, bArr, i38, i3, b10, i18, i40, i19, (long) i41, i42, j9, n0Var);
                            } else {
                                z3 = true;
                                b4 = b10;
                                unsafe = unsafe2;
                                i21 = i38;
                                i11 = i18;
                                z = i19;
                                if (i42 != 50) {
                                    i32 = j(t, bArr, i21, i3, b4, i11, i40, i41, i42, j9, z, n0Var);
                                } else if (i40 == 2) {
                                    l(t, bArr, i21, i3, z, j9, n0Var);
                                    throw null;
                                }
                            }
                            e3Var2 = this;
                            t3 = t;
                            bArr2 = bArr;
                            i9 = i3;
                            n0Var2 = n0Var;
                            b2 = b4;
                            i10 = i11;
                            i33 = i4;
                            n0Var3 = n0Var2;
                            i34 = i10;
                            bArr4 = bArr2;
                            i31 = i9;
                            i35 = z;
                            i36 = i8;
                            i37 = i7;
                            unsafe2 = unsafe;
                            e3Var3 = e3Var2;
                            b9 = b2;
                            t5 = t3;
                            bArr3 = bArr4;
                        } else if (i40 == 2) {
                            z1 z1Var = (z1) unsafe2.getObject(t5, j9);
                            if (!z1Var.s()) {
                                int size = z1Var.size();
                                z1Var = z1Var.B(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t5, j9, z1Var);
                            }
                            b3 = b10;
                            bArr4 = bArr4;
                            i36 = i36;
                            i37 = i37;
                            i20 = t.O3(e3Var3.x(i19), b3, bArr, i38, i3, z1Var, n0Var);
                        } else {
                            i8 = i36;
                            i7 = i37;
                            b4 = b10;
                            z3 = true;
                            unsafe = unsafe2;
                            i21 = i38;
                            i11 = i18;
                            z = i19;
                        }
                        i12 = i4;
                        i13 = i21;
                        b2 = b4;
                        z = z;
                    }
                    i32 = i20;
                    i31 = i3;
                    i33 = i4;
                    i35 = i19;
                    b9 = b3;
                    i34 = i18;
                    bArr3 = bArr;
                }
                if (b2 != i12 || i12 == 0) {
                    e3Var2 = this;
                    if (e3Var2.f3884f) {
                        n0Var2 = n0Var;
                        if (n0Var2.f3970d != e1.a()) {
                            i10 = i11;
                            t1.f<?, ?> fVar = n0Var2.f3970d.f3870a.get(new e1.a(e3Var2.f3883e, i10));
                            if (fVar == null) {
                                i32 = t.K3(b2, bArr, i13, i3, M(t), n0Var);
                                t3 = t;
                                bArr2 = bArr;
                                i9 = i3;
                            } else {
                                t3 = t;
                                T t6 = t3;
                                t6.k();
                                j1<t1.c> j1Var = t6.zzyg;
                                t1.c cVar = fVar.f4041b;
                                boolean z6 = cVar.f4038d;
                                p4 p4Var = cVar.f4037c;
                                if (p4Var != p4.ENUM) {
                                    switch (o0.f3976a[p4Var.ordinal()]) {
                                        case 1:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            obj = Double.valueOf(t.y4(bArr2, i13));
                                            i13 += 8;
                                            break;
                                        case 2:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            obj = Float.valueOf(t.D4(bArr2, i13));
                                            i13 += 4;
                                            break;
                                        case 3:
                                        case 4:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i14 = t.r4(bArr2, i13, n0Var2);
                                            j2 = n0Var2.f3968b;
                                            i13 = i14;
                                            obj = Long.valueOf(j2);
                                            break;
                                        case 5:
                                        case 6:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i16 = t.U3(bArr2, i13, n0Var2);
                                            i15 = n0Var2.f3967a;
                                            i13 = i16;
                                            obj = Integer.valueOf(i15);
                                            break;
                                        case 7:
                                        case 8:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            obj = Long.valueOf(t.x4(bArr2, i13));
                                            i13 += 8;
                                            break;
                                        case 9:
                                        case 10:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            obj = Integer.valueOf(t.n4(bArr2, i13));
                                            i13 += 4;
                                            break;
                                        case 11:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i13 = t.r4(bArr2, i13, n0Var2);
                                            if (n0Var2.f3968b == 0) {
                                                z3 = z2;
                                            }
                                            obj = Boolean.valueOf(z3);
                                            break;
                                        case 12:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i16 = t.U3(bArr2, i13, n0Var2);
                                            i15 = z0.a(n0Var2.f3967a);
                                            i13 = i16;
                                            obj = Integer.valueOf(i15);
                                            break;
                                        case 13:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i14 = t.r4(bArr2, i13, n0Var2);
                                            j2 = z0.b(n0Var2.f3968b);
                                            i13 = i14;
                                            obj = Long.valueOf(j2);
                                            break;
                                        case 14:
                                            throw new IllegalStateException("Shouldn't reach here.");
                                        case 15:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i17 = t.K4(bArr2, i13, n0Var2);
                                            i13 = i17;
                                            obj = n0Var2.f3969c;
                                            break;
                                        case 16:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i17 = t.B4(bArr2, i13, n0Var2);
                                            i13 = i17;
                                            obj = n0Var2.f3969c;
                                            break;
                                        case 17:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i17 = t.P3(n3.f3973c.a(fVar.f4040a.getClass()), bArr, i13, i3, (i10 << 3) | 4, n0Var);
                                            i13 = i17;
                                            obj = n0Var2.f3969c;
                                            break;
                                        case 18:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            i17 = t.Q3(n3.f3973c.a(fVar.f4040a.getClass()), bArr2, i13, i9, n0Var2);
                                            i13 = i17;
                                            obj = n0Var2.f3969c;
                                            break;
                                        default:
                                            bArr2 = bArr;
                                            i9 = i3;
                                            obj = null;
                                            break;
                                    }
                                    t1.c cVar2 = fVar.f4041b;
                                    if (!cVar2.f4038d) {
                                        int i49 = o0.f3976a[cVar2.f4037c.ordinal()];
                                        if ((i49 == 17 || i49 == 18) && (d2 = j1Var.d(fVar.f4041b)) != null) {
                                            obj = u1.f(d2, obj);
                                        }
                                        j1Var.e(fVar.f4041b, obj);
                                        i32 = i13;
                                    } else if (j1Var != null) {
                                        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
                                    } else {
                                        throw null;
                                    }
                                } else {
                                    t.U3(bArr, i13, n0Var2);
                                    throw null;
                                }
                            }
                            i33 = i12;
                            n0Var3 = n0Var2;
                            i34 = i10;
                            bArr4 = bArr2;
                            i31 = i9;
                            i35 = z;
                            i36 = i8;
                            i37 = i7;
                            unsafe2 = unsafe;
                            e3Var3 = e3Var2;
                            b9 = b2;
                            t5 = t3;
                            bArr3 = bArr4;
                        } else {
                            t3 = t;
                            bArr2 = bArr;
                            i9 = i3;
                        }
                    } else {
                        t3 = t;
                        bArr2 = bArr;
                        i9 = i3;
                        n0Var2 = n0Var;
                    }
                    i10 = i11;
                    i32 = t.K3(b2, bArr, i13, i3, M(t), n0Var);
                    i33 = i12;
                    n0Var3 = n0Var2;
                    i34 = i10;
                    bArr4 = bArr2;
                    i31 = i9;
                    i35 = z;
                    i36 = i8;
                    i37 = i7;
                    unsafe2 = unsafe;
                    e3Var3 = e3Var2;
                    b9 = b2;
                    t5 = t3;
                    bArr3 = bArr4;
                } else {
                    e3Var = this;
                    t2 = t;
                    i5 = i3;
                    i32 = i13;
                    i33 = i12;
                    i36 = i8;
                    i37 = i7;
                }
            } else {
                unsafe = unsafe2;
                t2 = t5;
                e3Var = e3Var3;
                i5 = i31;
                b2 = b9;
            }
        }
        if (i36 != 1048575) {
            unsafe.putInt(t2, (long) i36, i37);
        }
        for (int i50 = e3Var.i; i50 < e3Var.j; i50++) {
            int i51 = e3Var.h[i50];
            d4<?, ?> d4Var = e3Var.m;
            int[] iArr2 = e3Var.f3879a;
            int i52 = iArr2[i51];
            Object s = j4.s(t2, (long) (iArr2[i51 + 1] & 1048575));
            if (s != null) {
                int i53 = (i51 / 3) << 1;
                y1 y1Var = (y1) e3Var.f3880b[i53 + 1];
                if (y1Var == null) {
                    continue;
                } else {
                    Map<?, ?> a2 = e3Var.o.a(s);
                    e3Var.o.h(e3Var.f3880b[i53]);
                    for (Map.Entry<?, ?> entry : a2.entrySet()) {
                        if (!y1Var.a(((Integer) entry.getValue()).intValue())) {
                            if (((f4) d4Var) != null) {
                                entry.getKey();
                                entry.getValue();
                                throw null;
                            }
                            throw null;
                        }
                    }
                    continue;
                }
            }
        }
        if (i33 == 0) {
            if (i32 != i5) {
                throw c2.e();
            }
        } else if (i32 > i5 || b2 != i33) {
            throw c2.e();
        }
        return i32;
    }

    public final <K, V> void r(v4 v4Var, int i2, Object obj, int i3) {
        if (obj != null) {
            this.o.h(this.f3880b[(i3 / 3) << 1]);
            Map<?, ?> f2 = this.o.f(obj);
            d1 d1Var = (d1) v4Var;
            if (d1Var != null) {
                Iterator<Map.Entry<?, ?>> it = f2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<?, ?> next = it.next();
                    ((b1.b) d1Var.f3864a).k((i2 << 3) | 2);
                    next.getKey();
                    next.getValue();
                    throw null;
                }
                return;
            }
            throw null;
        }
    }

    public final void s(T t, T t2, int i2) {
        long j2 = (long) (this.f3879a[i2 + 1] & 1048575);
        if (D(t2, i2)) {
            Object s = j4.s(t, j2);
            Object s2 = j4.s(t2, j2);
            if (s != null && s2 != null) {
                j4.e(t, j2, u1.f(s, s2));
                F(t, i2);
            } else if (s2 != null) {
                j4.e(t, j2, s2);
                F(t, i2);
            }
        }
    }

    public final boolean t(T t, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? D(t, i2) : (i4 & i5) != 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0508  */
    public final void u(T t, v4 v4Var) {
        Map.Entry<t1.c, Object> entry;
        Iterator<Map.Entry<t1.c, Object>> it;
        int length;
        int i2;
        int i3;
        boolean z;
        if (this.f3884f) {
            if (((i1) this.n) != null) {
                j1<t1.c> j1Var = t.zzyg;
                if (!j1Var.f3910a.isEmpty()) {
                    it = j1Var.b();
                    entry = it.next();
                    length = this.f3879a.length;
                    Unsafe unsafe = q;
                    int i4 = 1048575;
                    int i5 = 0;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        int A = A(i2);
                        int[] iArr = this.f3879a;
                        int i6 = iArr[i2];
                        int i7 = (A & 267386880) >>> 20;
                        if (this.f3885g || i7 > 17) {
                            i3 = 0;
                        } else {
                            int i8 = iArr[i2 + 2];
                            int i9 = i8 & 1048575;
                            if (i9 != i4) {
                                i5 = unsafe.getInt(t, (long) i9);
                                i4 = i9;
                            }
                            i3 = 1 << (i8 >>> 20);
                        }
                        while (entry != null && this.n.a(entry) <= i6) {
                            this.n.b(v4Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        long j2 = (long) (A & 1048575);
                        switch (i7) {
                            case 0:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).a(i6, j4.r(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).b(i6, j4.q(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).k(i6, unsafe.getLong(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).c(i6, unsafe.getLong(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).f3864a.G(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).j(i6, unsafe.getLong(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).o(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).g(i6, j4.p(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if ((i3 & i5) != 0) {
                                    p(i6, unsafe.getObject(t, j2), v4Var);
                                    break;
                                } else {
                                    break;
                                }
                            case 9:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).f(i6, unsafe.getObject(t, j2), x(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 10:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).d(i6, (q0) unsafe.getObject(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 11:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).m(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).f3864a.G(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).p(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).l(i6, unsafe.getLong(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).n(i6, unsafe.getInt(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).h(i6, unsafe.getLong(t, j2));
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if ((i3 & i5) != 0) {
                                    ((d1) v4Var).i(i6, unsafe.getObject(t, j2), x(i2));
                                    break;
                                } else {
                                    break;
                                }
                            case 18:
                                z = false;
                                s3.e(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 19:
                                z = false;
                                s3.k(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 20:
                                z = false;
                                s3.o(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 21:
                                z = false;
                                s3.r(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 22:
                                z = false;
                                s3.x(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 23:
                                z = false;
                                s3.u(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 24:
                                z = false;
                                s3.A(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 25:
                                z = false;
                                s3.E(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 26:
                                s3.c(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var);
                                break;
                            case 27:
                                s3.d(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, x(i2));
                                break;
                            case 28:
                                s3.i(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var);
                                break;
                            case 29:
                                z = false;
                                s3.y(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 30:
                                z = false;
                                s3.C(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 31:
                                z = false;
                                s3.B(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 32:
                                z = false;
                                s3.v(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 33:
                                z = false;
                                s3.z(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 34:
                                z = false;
                                s3.s(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, false);
                                break;
                            case 35:
                                s3.e(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 36:
                                s3.k(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 37:
                                s3.o(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 38:
                                s3.r(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 39:
                                s3.x(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 40:
                                s3.u(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 41:
                                s3.A(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 42:
                                s3.E(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 43:
                                s3.y(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 44:
                                s3.C(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 45:
                                s3.B(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 46:
                                s3.v(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 47:
                                s3.z(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 48:
                                s3.s(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, true);
                                break;
                            case 49:
                                s3.j(this.f3879a[i2], (List) unsafe.getObject(t, j2), v4Var, x(i2));
                                break;
                            case 50:
                                r(v4Var, i6, unsafe.getObject(t, j2), i2);
                                break;
                            case 51:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).a(i6, H(t, j2));
                                }
                                break;
                            case 52:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).b(i6, I(t, j2));
                                }
                                break;
                            case 53:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).k(i6, K(t, j2));
                                }
                                break;
                            case 54:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).c(i6, K(t, j2));
                                }
                                break;
                            case 55:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).f3864a.G(i6, J(t, j2));
                                }
                                break;
                            case 56:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).j(i6, K(t, j2));
                                }
                                break;
                            case 57:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).o(i6, J(t, j2));
                                }
                                break;
                            case 58:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).g(i6, L(t, j2));
                                }
                                break;
                            case 59:
                                if (w(t, i6, i2)) {
                                    p(i6, unsafe.getObject(t, j2), v4Var);
                                }
                                break;
                            case 60:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).f(i6, unsafe.getObject(t, j2), x(i2));
                                }
                                break;
                            case 61:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).d(i6, (q0) unsafe.getObject(t, j2));
                                }
                                break;
                            case 62:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).m(i6, J(t, j2));
                                }
                                break;
                            case 63:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).f3864a.G(i6, J(t, j2));
                                }
                                break;
                            case 64:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).p(i6, J(t, j2));
                                }
                                break;
                            case 65:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).l(i6, K(t, j2));
                                }
                                break;
                            case 66:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).n(i6, J(t, j2));
                                }
                                break;
                            case 67:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).h(i6, K(t, j2));
                                }
                                break;
                            case 68:
                                if (w(t, i6, i2)) {
                                    ((d1) v4Var).i(i6, unsafe.getObject(t, j2), x(i2));
                                }
                                break;
                        }
                    }
                    while (entry != null) {
                        this.n.b(v4Var, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    q(this.m, t, v4Var);
                }
            } else {
                throw null;
            }
        }
        it = null;
        entry = null;
        length = this.f3879a.length;
        Unsafe unsafe2 = q;
        int i42 = 1048575;
        int i52 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        q(this.m, t, v4Var);
    }

    public final void v(T t, T t2, int i2) {
        int[] iArr = this.f3879a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (w(t2, i4, i2)) {
            Object s = j4.s(t, j2);
            Object s2 = j4.s(t2, j2);
            if (s != null && s2 != null) {
                j4.e(t, j2, u1.f(s, s2));
                C(t, i4, i2);
            } else if (s2 != null) {
                j4.e(t, j2, s2);
                C(t, i4, i2);
            }
        }
    }

    public final boolean w(T t, int i2, int i3) {
        return j4.m(t, (long) (this.f3879a[i3 + 2] & 1048575)) == i2;
    }

    public final q3 x(int i2) {
        int i3 = (i2 / 3) << 1;
        Object[] objArr = this.f3880b;
        q3 q3Var = (q3) objArr[i3];
        if (q3Var != null) {
            return q3Var;
        }
        q3<T> a2 = n3.f3973c.a((Class) objArr[i3 + 1]);
        this.f3880b[i3] = a2;
        return a2;
    }

    public final Object y(int i2) {
        return this.f3880b[(i2 / 3) << 1];
    }

    public final y1 z(int i2) {
        return (y1) this.f3880b[((i2 / 3) << 1) + 1];
    }
}
