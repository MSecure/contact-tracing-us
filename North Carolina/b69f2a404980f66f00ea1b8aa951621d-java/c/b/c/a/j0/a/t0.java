package c.b.c.a.j0.a;

import androidx.recyclerview.widget.RecyclerView;
import c.b.a.a.c.n.c;
import c.b.c.a.j0.a.a0;
import c.b.c.a.j0.a.l;
import c.b.c.a.j0.a.q;
import c.b.c.a.j0.a.y;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class t0<T> implements f1<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = p1.o();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3642a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f3643b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3644c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3645d;

    /* renamed from: e  reason: collision with root package name */
    public final r0 f3646e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final v0 m;
    public final h0 n;
    public final l1<?, ?> o;
    public final r<?> p;
    public final m0 q;

    public t0(int[] iArr, Object[] objArr, int i2, int i3, r0 r0Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, v0 v0Var, h0 h0Var, l1<?, ?> l1Var, r<?> rVar, m0 m0Var) {
        this.f3642a = iArr;
        this.f3643b = objArr;
        this.f3644c = i2;
        this.f3645d = i3;
        this.g = r0Var instanceof y;
        this.h = z;
        this.f = rVar != null && (r0Var instanceof y.c);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = v0Var;
        this.n = h0Var;
        this.o = l1Var;
        this.p = rVar;
        this.f3646e = r0Var;
        this.q = m0Var;
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x028d  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02a7  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0359  */
    public static <T> t0<T> A(d1 d1Var, v0 v0Var, h0 h0Var, l1<?, ?> l1Var, r<?> rVar, m0 m0Var) {
        int i2;
        int i3;
        int[] iArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        String str;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        Field field;
        int i20;
        char charAt;
        int i21;
        Object obj;
        Field field2;
        Object obj2;
        Field field3;
        int i22;
        int i23;
        char charAt2;
        int i24;
        char charAt3;
        int i25;
        char charAt4;
        int i26;
        int i27;
        char charAt5;
        int i28;
        char charAt6;
        int i29;
        char charAt7;
        int i30;
        char charAt8;
        int i31;
        char charAt9;
        int i32;
        char charAt10;
        int i33;
        char charAt11;
        int i34;
        char charAt12;
        int i35;
        char charAt13;
        char charAt14;
        a1 a1Var = a1.PROTO3;
        int i36 = 0;
        boolean z2 = ((d1Var.f3541d & 1) == 1 ? a1.PROTO2 : a1Var) == a1Var;
        String str2 = d1Var.f3539b;
        int length = str2.length();
        int charAt15 = str2.charAt(0);
        if (charAt15 >= 55296) {
            int i37 = charAt15 & 8191;
            int i38 = 1;
            int i39 = 13;
            while (true) {
                i2 = i38 + 1;
                charAt14 = str2.charAt(i38);
                if (charAt14 < 55296) {
                    break;
                }
                i37 |= (charAt14 & 8191) << i39;
                i39 += 13;
                i38 = i2;
            }
            charAt15 = i37 | (charAt14 << i39);
        } else {
            i2 = 1;
        }
        int i40 = i2 + 1;
        int charAt16 = str2.charAt(i2);
        if (charAt16 >= 55296) {
            int i41 = charAt16 & 8191;
            int i42 = 13;
            while (true) {
                i35 = i40 + 1;
                charAt13 = str2.charAt(i40);
                if (charAt13 < 55296) {
                    break;
                }
                i41 |= (charAt13 & 8191) << i42;
                i42 += 13;
                i40 = i35;
            }
            charAt16 = i41 | (charAt13 << i42);
            i40 = i35;
        }
        if (charAt16 == 0) {
            i8 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            iArr = r;
            i7 = 0;
        } else {
            int i43 = i40 + 1;
            int charAt17 = str2.charAt(i40);
            if (charAt17 >= 55296) {
                int i44 = charAt17 & 8191;
                int i45 = 13;
                while (true) {
                    i34 = i43 + 1;
                    charAt12 = str2.charAt(i43);
                    if (charAt12 < 55296) {
                        break;
                    }
                    i44 |= (charAt12 & 8191) << i45;
                    i45 += 13;
                    i43 = i34;
                }
                charAt17 = i44 | (charAt12 << i45);
                i43 = i34;
            }
            int i46 = i43 + 1;
            int charAt18 = str2.charAt(i43);
            if (charAt18 >= 55296) {
                int i47 = charAt18 & 8191;
                int i48 = 13;
                while (true) {
                    i33 = i46 + 1;
                    charAt11 = str2.charAt(i46);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i47 |= (charAt11 & 8191) << i48;
                    i48 += 13;
                    i46 = i33;
                }
                charAt18 = i47 | (charAt11 << i48);
                i46 = i33;
            }
            int i49 = i46 + 1;
            i6 = str2.charAt(i46);
            if (i6 >= 55296) {
                int i50 = i6 & 8191;
                int i51 = 13;
                while (true) {
                    i32 = i49 + 1;
                    charAt10 = str2.charAt(i49);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i50 |= (charAt10 & 8191) << i51;
                    i51 += 13;
                    i49 = i32;
                }
                i6 = i50 | (charAt10 << i51);
                i49 = i32;
            }
            int i52 = i49 + 1;
            int charAt19 = str2.charAt(i49);
            if (charAt19 >= 55296) {
                int i53 = charAt19 & 8191;
                int i54 = 13;
                while (true) {
                    i31 = i52 + 1;
                    charAt9 = str2.charAt(i52);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i53 |= (charAt9 & 8191) << i54;
                    i54 += 13;
                    i52 = i31;
                }
                charAt19 = i53 | (charAt9 << i54);
                i52 = i31;
            }
            int i55 = i52 + 1;
            i4 = str2.charAt(i52);
            if (i4 >= 55296) {
                int i56 = i4 & 8191;
                int i57 = 13;
                while (true) {
                    i30 = i55 + 1;
                    charAt8 = str2.charAt(i55);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i56 |= (charAt8 & 8191) << i57;
                    i57 += 13;
                    i55 = i30;
                }
                i4 = i56 | (charAt8 << i57);
                i55 = i30;
            }
            int i58 = i55 + 1;
            int charAt20 = str2.charAt(i55);
            if (charAt20 >= 55296) {
                int i59 = charAt20 & 8191;
                int i60 = 13;
                while (true) {
                    i29 = i58 + 1;
                    charAt7 = str2.charAt(i58);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i59 |= (charAt7 & 8191) << i60;
                    i60 += 13;
                    i58 = i29;
                }
                charAt20 = i59 | (charAt7 << i60);
                i58 = i29;
            }
            int i61 = i58 + 1;
            int charAt21 = str2.charAt(i58);
            if (charAt21 >= 55296) {
                int i62 = charAt21 & 8191;
                int i63 = i61;
                int i64 = 13;
                while (true) {
                    i28 = i63 + 1;
                    charAt6 = str2.charAt(i63);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i62 |= (charAt6 & 8191) << i64;
                    i64 += 13;
                    i63 = i28;
                }
                charAt21 = i62 | (charAt6 << i64);
                i26 = i28;
            } else {
                i26 = i61;
            }
            int i65 = i26 + 1;
            int charAt22 = str2.charAt(i26);
            if (charAt22 >= 55296) {
                int i66 = charAt22 & 8191;
                int i67 = i65;
                int i68 = 13;
                while (true) {
                    i27 = i67 + 1;
                    charAt5 = str2.charAt(i67);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i66 |= (charAt5 & 8191) << i68;
                    i68 += 13;
                    i67 = i27;
                }
                charAt22 = i66 | (charAt5 << i68);
                i65 = i27;
            }
            int i69 = (charAt17 * 2) + charAt18;
            i7 = charAt19;
            i5 = i69;
            i3 = charAt22;
            i36 = charAt17;
            i40 = i65;
            iArr = new int[(charAt22 + charAt20 + charAt21)];
            i8 = charAt20;
        }
        Unsafe unsafe = s;
        Object[] objArr = d1Var.f3540c;
        Class<?> cls = d1Var.f3538a.getClass();
        int i70 = i5;
        int[] iArr2 = new int[(i4 * 3)];
        Object[] objArr2 = new Object[(i4 * 2)];
        int i71 = i3 + i8;
        int i72 = i3;
        int i73 = i40;
        int i74 = i71;
        int i75 = 0;
        int i76 = 0;
        while (i73 < length) {
            int i77 = i73 + 1;
            int charAt23 = str2.charAt(i73);
            if (charAt23 >= 55296) {
                int i78 = charAt23 & 8191;
                int i79 = i77;
                int i80 = 13;
                while (true) {
                    i25 = i79 + 1;
                    charAt4 = str2.charAt(i79);
                    i9 = i3;
                    if (charAt4 < 55296) {
                        break;
                    }
                    i78 |= (charAt4 & 8191) << i80;
                    i80 += 13;
                    i79 = i25;
                    i3 = i9;
                }
                charAt23 = i78 | (charAt4 << i80);
                i10 = i25;
            } else {
                i9 = i3;
                i10 = i77;
            }
            int i81 = i10 + 1;
            int charAt24 = str2.charAt(i10);
            if (charAt24 >= 55296) {
                int i82 = charAt24 & 8191;
                int i83 = i81;
                int i84 = 13;
                while (true) {
                    i24 = i83 + 1;
                    charAt3 = str2.charAt(i83);
                    z = z2;
                    if (charAt3 < 55296) {
                        break;
                    }
                    i82 |= (charAt3 & 8191) << i84;
                    i84 += 13;
                    i83 = i24;
                    z2 = z;
                }
                charAt24 = i82 | (charAt3 << i84);
                i11 = i24;
            } else {
                z = z2;
                i11 = i81;
            }
            int i85 = charAt24 & 255;
            if ((charAt24 & 1024) != 0) {
                iArr[i75] = i76;
                i75++;
            }
            if (i85 >= 51) {
                int i86 = i11 + 1;
                int charAt25 = str2.charAt(i11);
                char c2 = 55296;
                if (charAt25 >= 55296) {
                    int i87 = charAt25 & 8191;
                    int i88 = 13;
                    while (true) {
                        i23 = i86 + 1;
                        charAt2 = str2.charAt(i86);
                        if (charAt2 < c2) {
                            break;
                        }
                        i87 |= (charAt2 & 8191) << i88;
                        i88 += 13;
                        i86 = i23;
                        c2 = 55296;
                    }
                    charAt25 = i87 | (charAt2 << i88);
                    i86 = i23;
                }
                int i89 = i85 - 51;
                if (i89 == 9 || i89 == 17) {
                    i22 = i70 + 1;
                    objArr2[((i76 / 3) * 2) + 1] = objArr[i70];
                } else {
                    if (i89 == 12 && (charAt15 & 1) == 1) {
                        i22 = i70 + 1;
                        objArr2[((i76 / 3) * 2) + 1] = objArr[i70];
                    }
                    int i90 = charAt25 * 2;
                    obj = objArr[i90];
                    if (!(obj instanceof Field)) {
                        field2 = (Field) obj;
                    } else {
                        field2 = R(cls, (String) obj);
                        objArr[i90] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i91 = i90 + 1;
                    obj2 = objArr[i91];
                    if (!(obj2 instanceof Field)) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = R(cls, (String) obj2);
                        objArr[i91] = field3;
                    }
                    str = str2;
                    i16 = (int) unsafe.objectFieldOffset(field3);
                    i15 = objectFieldOffset;
                    i14 = i86;
                    i13 = 0;
                    i12 = charAt24;
                }
                i70 = i22;
                int i902 = charAt25 * 2;
                obj = objArr[i902];
                if (!(obj instanceof Field)) {
                }
                int objectFieldOffset2 = (int) unsafe.objectFieldOffset(field2);
                int i912 = i902 + 1;
                obj2 = objArr[i912];
                if (!(obj2 instanceof Field)) {
                }
                str = str2;
                i16 = (int) unsafe.objectFieldOffset(field3);
                i15 = objectFieldOffset2;
                i14 = i86;
                i13 = 0;
                i12 = charAt24;
            } else {
                int i92 = i70 + 1;
                Field R = R(cls, (String) objArr[i70]);
                if (i85 == 9 || i85 == 17) {
                    i12 = charAt24;
                    i17 = 1;
                    objArr2[((i76 / 3) * 2) + 1] = R.getType();
                } else {
                    if (i85 == 27 || i85 == 49) {
                        i12 = charAt24;
                        i17 = 1;
                        i21 = i92 + 1;
                        objArr2[((i76 / 3) * 2) + 1] = objArr[i92];
                    } else if (i85 == 12 || i85 == 30 || i85 == 44) {
                        i12 = charAt24;
                        i17 = 1;
                        if ((charAt15 & 1) == 1) {
                            i21 = i92 + 1;
                            objArr2[((i76 / 3) * 2) + 1] = objArr[i92];
                        }
                    } else if (i85 == 50) {
                        int i93 = i72 + 1;
                        iArr[i72] = i76;
                        int i94 = (i76 / 3) * 2;
                        int i95 = i92 + 1;
                        objArr2[i94] = objArr[i92];
                        if ((charAt24 & 2048) != 0) {
                            int i96 = i95 + 1;
                            objArr2[i94 + 1] = objArr[i95];
                            i72 = i93;
                            i12 = charAt24;
                            i18 = i96;
                        } else {
                            i72 = i93;
                            i18 = i95;
                            i12 = charAt24;
                        }
                        i17 = 1;
                        i15 = (int) unsafe.objectFieldOffset(R);
                        if ((charAt15 & 1) == i17 || i85 > 17) {
                            i19 = i18;
                            str = str2;
                            i14 = i11;
                            i16 = 0;
                            i13 = 0;
                        } else {
                            i14 = i11 + 1;
                            int charAt26 = str2.charAt(i11);
                            if (charAt26 >= 55296) {
                                int i97 = charAt26 & 8191;
                                int i98 = 13;
                                while (true) {
                                    i20 = i14 + 1;
                                    charAt = str2.charAt(i14);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i97 |= (charAt & 8191) << i98;
                                    i98 += 13;
                                    i14 = i20;
                                }
                                charAt26 = i97 | (charAt << i98);
                                i14 = i20;
                            }
                            int i99 = (charAt26 / 32) + (i36 * 2);
                            Object obj3 = objArr[i99];
                            i19 = i18;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = R(cls, (String) obj3);
                                objArr[i99] = field;
                            }
                            str = str2;
                            i16 = (int) unsafe.objectFieldOffset(field);
                            i13 = charAt26 % 32;
                        }
                        if (i85 >= 18 && i85 <= 49) {
                            iArr[i74] = i15;
                            i74++;
                        }
                        i70 = i19;
                    } else {
                        i12 = charAt24;
                        i17 = 1;
                    }
                    i18 = i21;
                    i15 = (int) unsafe.objectFieldOffset(R);
                    if ((charAt15 & 1) == i17) {
                    }
                    i19 = i18;
                    str = str2;
                    i14 = i11;
                    i16 = 0;
                    i13 = 0;
                    iArr[i74] = i15;
                    i74++;
                    i70 = i19;
                }
                i18 = i92;
                i15 = (int) unsafe.objectFieldOffset(R);
                if ((charAt15 & 1) == i17) {
                }
                i19 = i18;
                str = str2;
                i14 = i11;
                i16 = 0;
                i13 = 0;
                iArr[i74] = i15;
                i74++;
                i70 = i19;
            }
            int i100 = i76 + 1;
            iArr2[i76] = charAt23;
            int i101 = i100 + 1;
            iArr2[i100] = ((i12 & RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN) != 0 ? 536870912 : 0) | ((i12 & RecyclerView.d0.FLAG_TMP_DETACHED) != 0 ? 268435456 : 0) | (i85 << 20) | i15;
            int i102 = i101 + 1;
            iArr2[i101] = i16 | (i13 << 20);
            i73 = i14;
            unsafe = unsafe;
            i7 = i7;
            length = length;
            i3 = i9;
            z2 = z;
            i6 = i6;
            i76 = i102;
            str2 = str;
        }
        return new t0<>(iArr2, objArr2, i6, i7, d1Var.f3538a, z2, false, iArr, i3, i71, v0Var, h0Var, l1Var, rVar, m0Var);
    }

    public static long B(int i2) {
        return (long) (i2 & 1048575);
    }

    public static <T> boolean C(T t, long j2) {
        return ((Boolean) p1.n(t, j2)).booleanValue();
    }

    public static <T> double D(T t, long j2) {
        return ((Double) p1.n(t, j2)).doubleValue();
    }

    public static <T> float E(T t, long j2) {
        return ((Float) p1.n(t, j2)).floatValue();
    }

    public static <T> int F(T t, long j2) {
        return ((Integer) p1.n(t, j2)).intValue();
    }

    public static <T> long G(T t, long j2) {
        return ((Long) p1.n(t, j2)).longValue();
    }

    public static Field R(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int V(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static m1 p(Object obj) {
        y yVar = (y) obj;
        m1 m1Var = yVar.unknownFields;
        if (m1Var != m1.f) {
            return m1Var;
        }
        m1 b2 = m1.b();
        yVar.unknownFields = b2;
        return b2;
    }

    public static List<?> v(Object obj, long j2) {
        return (List) p1.n(obj, j2);
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lc/b/c/a/j0/a/p0;Lc/b/c/a/j0/a/v0;Lc/b/c/a/j0/a/h0;Lc/b/c/a/j0/a/l1<**>;Lc/b/c/a/j0/a/r<*>;Lc/b/c/a/j0/a/m0;)Lc/b/c/a/j0/a/t0<TT;>; */
    public static t0 z(p0 p0Var, v0 v0Var, h0 h0Var, l1 l1Var, r rVar, m0 m0Var) {
        if (p0Var instanceof d1) {
            return A((d1) p0Var, v0Var, h0Var, l1Var, rVar, m0Var);
        }
        j1 j1Var = (j1) p0Var;
        throw null;
    }

    public final <K, V> int H(T t, byte[] bArr, int i2, int i3, int i4, long j2, e eVar) {
        Unsafe unsafe = s;
        Object obj = this.f3643b[(i4 / 3) * 2];
        Object object = unsafe.getObject(t, j2);
        if (this.q.f(object)) {
            Object c2 = this.q.c(obj);
            this.q.a(c2, object);
            unsafe.putObject(t, j2, c2);
            object = c2;
        }
        this.q.h(obj);
        this.q.e(object);
        int z0 = c.z0(bArr, i2, eVar);
        int i5 = eVar.f3542a;
        if (i5 < 0 || i5 > i3 - z0) {
            throw b0.h();
        }
        throw null;
    }

    public final int I(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, e eVar) {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        Unsafe unsafe = s;
        long j4 = (long) (this.f3642a[i9 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(c.L(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(c.R(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = c.D0(bArr, i2, eVar);
                    j3 = eVar.f3543b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = c.z0(bArr, i2, eVar);
                    i11 = eVar.f3542a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(c.P(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(c.N(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = c.D0(bArr, i2, eVar);
                    obj3 = Boolean.valueOf(eVar.f3543b != 0);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    i10 = c.z0(bArr, i2, eVar);
                    int i12 = eVar.f3542a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || q1.f(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, a0.f3518a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw b0.c();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = c.V(o(i9), bArr, i2, i3, eVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = eVar.f3544c;
                    if (object != null) {
                        obj3 = a0.f(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = c.J(bArr, i2, eVar);
                    obj3 = eVar.f3544c;
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int z0 = c.z0(bArr, i2, eVar);
                    int i13 = eVar.f3542a;
                    a0.b bVar = (a0.b) this.f3643b[((i9 / 3) * 2) + 1];
                    if (bVar == null || bVar.a(i13)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        unsafe.putInt(t, j4, i5);
                    } else {
                        p(t).c(i4, Long.valueOf((long) i13));
                    }
                    return z0;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = c.z0(bArr, i2, eVar);
                    i11 = j.b(eVar.f3542a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = c.D0(bArr, i2, eVar);
                    j3 = j.c(eVar.f3543b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = c.T(o(i9), bArr, i2, i3, (i4 & -8) | 4, eVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = eVar.f3544c;
                    if (object2 != null) {
                        obj3 = a0.f(object2, obj3);
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

    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0372, code lost:
        if (r0 != r4) goto L_0x03c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x03c0, code lost:
        if (r0 != r14) goto L_0x03c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03d6, code lost:
        r9 = r32;
        r6 = r34;
        r2 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03f4  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    public int J(T t, byte[] bArr, int i2, int i3, int i4, e eVar) {
        Unsafe unsafe;
        T t2;
        t0<T> t0Var;
        Throwable th;
        byte b2;
        int i5;
        int i6;
        T t3;
        int i7;
        t0<T> t0Var2;
        int i8;
        int i9;
        int i10;
        Throwable th2;
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
        byte[] bArr2;
        int i29;
        byte[] bArr3;
        int i30;
        long j2;
        int i31;
        int i32;
        int i33;
        byte[] bArr4;
        Object obj;
        byte[] bArr5;
        int i34;
        t0<T> t0Var3 = this;
        T t4 = t;
        byte[] bArr6 = bArr;
        int i35 = i3;
        e eVar2 = eVar;
        Unsafe unsafe2 = s;
        int i36 = i2;
        int i37 = i4;
        int i38 = 0;
        int i39 = 0;
        int i40 = 0;
        int i41 = -1;
        int i42 = -1;
        while (true) {
            if (i36 < i35) {
                int i43 = i36 + 1;
                byte b3 = bArr6[i36];
                if (b3 < 0) {
                    int x0 = c.x0(b3, bArr6, i43, eVar2);
                    b2 = eVar2.f3542a;
                    i43 = x0;
                } else {
                    b2 = b3;
                }
                int i44 = b2 >>> 3;
                int i45 = b2 & 7;
                if (i44 > i41) {
                    int i46 = i38 / 3;
                    if (i44 < t0Var3.f3644c || i44 > t0Var3.f3645d) {
                        i6 = -1;
                        i5 = -1;
                        if (i5 != i6) {
                            i10 = i44;
                            i11 = i37;
                            i12 = i43;
                            unsafe = unsafe2;
                            i9 = 0;
                            th2 = null;
                            i8 = b2;
                        } else {
                            int i47 = t0Var3.f3642a[i5 + 1];
                            int V = V(i47);
                            long B = B(i47);
                            if (V <= 17) {
                                int i48 = t0Var3.f3642a[i5 + 2];
                                int i49 = 1 << (i48 >>> 20);
                                int i50 = i48 & 1048575;
                                if (i50 != i42) {
                                    if (i42 != -1) {
                                        unsafe2.putInt(t4, (long) i42, i40);
                                    }
                                    i22 = unsafe2.getInt(t4, (long) i50);
                                    i23 = i50;
                                } else {
                                    i22 = i40;
                                    i23 = i42;
                                }
                                switch (V) {
                                    case 0:
                                        i15 = i44;
                                        i14 = i23;
                                        i17 = b2;
                                        i24 = i5;
                                        i25 = i43;
                                        if (i45 == 1) {
                                            p1.t(t4, B, c.L(bArr, i25));
                                            i36 = i25 + 8;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 1:
                                        i15 = i44;
                                        i14 = i23;
                                        i17 = b2;
                                        i24 = i5;
                                        i25 = i43;
                                        if (i45 == 5) {
                                            p1.f.n(t4, B, c.R(bArr, i25));
                                            i36 = i25 + 4;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 2:
                                    case 3:
                                        i15 = i44;
                                        i28 = i5;
                                        i25 = i43;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr2 = bArr;
                                        if (i45 == 0) {
                                            i31 = c.D0(bArr2, i25, eVar2);
                                            j2 = eVar2.f3543b;
                                            bArr3 = bArr2;
                                            i29 = i28;
                                            unsafe2.putLong(t, B, j2);
                                            i30 = i22 | i49;
                                            i36 = i31;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                            break;
                                        }
                                        i27 = i28;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 4:
                                    case 11:
                                        i15 = i44;
                                        i28 = i5;
                                        i25 = i43;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr2 = bArr;
                                        if (i45 == 0) {
                                            i36 = c.z0(bArr2, i25, eVar2);
                                            i32 = eVar2.f3542a;
                                            unsafe2.putInt(t4, B, i32);
                                            i24 = i28;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i27 = i28;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 5:
                                    case 14:
                                        i15 = i44;
                                        i33 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr4 = bArr;
                                        if (i45 == 1) {
                                            unsafe2.putLong(t, B, c.P(bArr4, i43));
                                            i24 = i33;
                                            i25 = i43;
                                            i36 = i25 + 8;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i24 = i33;
                                        i25 = i43;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 6:
                                    case 13:
                                        i15 = i44;
                                        i33 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr4 = bArr;
                                        if (i45 == 5) {
                                            unsafe2.putInt(t4, B, c.N(bArr4, i43));
                                            i36 = i43 + 4;
                                            i30 = i22 | i49;
                                            bArr3 = bArr4;
                                            i29 = i33;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                            break;
                                        }
                                        i24 = i33;
                                        i25 = i43;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 7:
                                        i15 = i44;
                                        i33 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr4 = bArr;
                                        if (i45 == 0) {
                                            int D0 = c.D0(bArr4, i43, eVar2);
                                            p1.f.k(t4, B, eVar2.f3543b != 0);
                                            i36 = D0;
                                            i30 = i22 | i49;
                                            bArr3 = bArr4;
                                            i29 = i33;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                            break;
                                        }
                                        i24 = i33;
                                        i25 = i43;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 8:
                                        i15 = i44;
                                        i33 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr4 = bArr;
                                        if (i45 == 2) {
                                            i36 = (i47 & 536870912) == 0 ? c.r0(bArr4, i43, eVar2) : c.t0(bArr4, i43, eVar2);
                                            obj = eVar2.f3544c;
                                            unsafe2.putObject(t4, B, obj);
                                            i30 = i22 | i49;
                                            bArr3 = bArr4;
                                            i29 = i33;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                            break;
                                        }
                                        i24 = i33;
                                        i25 = i43;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 9:
                                        i15 = i44;
                                        i33 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr4 = bArr;
                                        if (i45 != 2) {
                                            i24 = i33;
                                            i25 = i43;
                                            i11 = i4;
                                            i12 = i25;
                                            i9 = i24;
                                            unsafe = unsafe2;
                                            i10 = i15;
                                            i42 = i14;
                                            th2 = null;
                                            i8 = i17;
                                            i40 = i22;
                                            break;
                                        } else {
                                            i36 = c.V(t0Var3.o(i33), bArr4, i43, i3, eVar2);
                                            if ((i22 & i49) != 0) {
                                                obj = a0.f(unsafe2.getObject(t4, B), eVar2.f3544c);
                                                unsafe2.putObject(t4, B, obj);
                                                i30 = i22 | i49;
                                                bArr3 = bArr4;
                                                i29 = i33;
                                                bArr6 = bArr3;
                                                i38 = i29;
                                                i39 = i17;
                                                i41 = i15;
                                                i42 = i14;
                                                i35 = i3;
                                                i40 = i30;
                                                i37 = i4;
                                                break;
                                            }
                                            obj = eVar2.f3544c;
                                            unsafe2.putObject(t4, B, obj);
                                            i30 = i22 | i49;
                                            bArr3 = bArr4;
                                            i29 = i33;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                        }
                                    case 10:
                                        i15 = i44;
                                        i28 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr5 = bArr;
                                        if (i45 == 2) {
                                            i36 = c.J(bArr5, i43, eVar2);
                                            unsafe2.putObject(t4, B, eVar2.f3544c);
                                            i24 = i28;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i27 = i28;
                                        i25 = i43;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 12:
                                        i15 = i44;
                                        i28 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr5 = bArr;
                                        if (i45 == 0) {
                                            i36 = c.z0(bArr5, i43, eVar2);
                                            i32 = eVar2.f3542a;
                                            a0.b m2 = t0Var3.m(i28);
                                            if (m2 != null && !m2.a(i32)) {
                                                p(t).c(i17, Long.valueOf((long) i32));
                                                i24 = i28;
                                                i26 = i22;
                                                i16 = i26;
                                                i13 = i24;
                                                break;
                                            }
                                            bArr2 = bArr5;
                                            unsafe2.putInt(t4, B, i32);
                                            i24 = i28;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                        }
                                        i27 = i28;
                                        i25 = i43;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 15:
                                        i15 = i44;
                                        i28 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr5 = bArr;
                                        if (i45 == 0) {
                                            i36 = c.z0(bArr5, i43, eVar2);
                                            i32 = j.b(eVar2.f3542a);
                                            bArr2 = bArr5;
                                            unsafe2.putInt(t4, B, i32);
                                            i24 = i28;
                                            i26 = i22 | i49;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        }
                                        i27 = i28;
                                        i25 = i43;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 16:
                                        i15 = i44;
                                        i28 = i5;
                                        i14 = i23;
                                        i17 = b2;
                                        bArr5 = bArr;
                                        if (i45 == 0) {
                                            i31 = c.D0(bArr5, i43, eVar2);
                                            j2 = j.c(eVar2.f3543b);
                                            bArr2 = bArr5;
                                            bArr3 = bArr2;
                                            i29 = i28;
                                            unsafe2.putLong(t, B, j2);
                                            i30 = i22 | i49;
                                            i36 = i31;
                                            bArr6 = bArr3;
                                            i38 = i29;
                                            i39 = i17;
                                            i41 = i15;
                                            i42 = i14;
                                            i35 = i3;
                                            i40 = i30;
                                            i37 = i4;
                                            break;
                                        }
                                        i27 = i28;
                                        i25 = i43;
                                        i24 = i27;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                    case 17:
                                        if (i45 == 3) {
                                            i15 = i44;
                                            i14 = i23;
                                            i17 = b2;
                                            i36 = c.T(t0Var3.o(i5), bArr, i43, i3, (i44 << 3) | 4, eVar);
                                            unsafe2.putObject(t4, B, (i22 & i49) == 0 ? eVar2.f3544c : a0.f(unsafe2.getObject(t4, B), eVar2.f3544c));
                                            i26 = i22 | i49;
                                            i24 = i5;
                                            i16 = i26;
                                            i13 = i24;
                                            break;
                                        } else {
                                            i15 = i44;
                                            i14 = i23;
                                            i17 = b2;
                                            i28 = i5;
                                            bArr5 = bArr;
                                            i27 = i28;
                                            i25 = i43;
                                            i24 = i27;
                                            i11 = i4;
                                            i12 = i25;
                                            i9 = i24;
                                            unsafe = unsafe2;
                                            i10 = i15;
                                            i42 = i14;
                                            th2 = null;
                                            i8 = i17;
                                            i40 = i22;
                                            break;
                                        }
                                    default:
                                        i15 = i44;
                                        i14 = i23;
                                        i17 = b2;
                                        i24 = i5;
                                        i25 = i43;
                                        i11 = i4;
                                        i12 = i25;
                                        i9 = i24;
                                        unsafe = unsafe2;
                                        i10 = i15;
                                        i42 = i14;
                                        th2 = null;
                                        i8 = i17;
                                        i40 = i22;
                                        break;
                                }
                            } else {
                                i15 = i44;
                                i16 = i40;
                                i17 = b2;
                                if (V != 27) {
                                    i19 = i42;
                                    i9 = i5;
                                    if (V <= 49) {
                                        th2 = null;
                                        i18 = i16;
                                        unsafe = unsafe2;
                                        i20 = i17;
                                        i10 = i15;
                                        i36 = L(t, bArr, i43, i3, i17, i15, i45, i9, (long) i47, V, B, eVar);
                                    } else {
                                        i21 = i43;
                                        i20 = i17;
                                        unsafe = unsafe2;
                                        i18 = i16;
                                        i10 = i15;
                                        th2 = null;
                                        if (V != 50) {
                                            i36 = I(t, bArr, i21, i3, i20, i10, i45, i47, V, B, i9, eVar);
                                        } else if (i45 == 2) {
                                            H(t, bArr, i21, i3, i9, B, eVar);
                                            throw null;
                                        }
                                    }
                                    t0Var2 = this;
                                    t3 = t;
                                    i8 = i20;
                                    i37 = i4;
                                    eVar2 = eVar;
                                    i7 = i10;
                                    i42 = i19;
                                    i38 = i9;
                                    i40 = i18;
                                    i39 = i8;
                                    t0Var3 = t0Var2;
                                    i41 = i7;
                                    t4 = t3;
                                    unsafe2 = unsafe;
                                    bArr6 = bArr;
                                    i35 = i3;
                                } else if (i45 == 2) {
                                    a0.c cVar = (a0.c) unsafe2.getObject(t4, B);
                                    if (!cVar.k()) {
                                        int size = cVar.size();
                                        cVar = cVar.g(size == 0 ? 10 : size * 2);
                                        unsafe2.putObject(t4, B, cVar);
                                    }
                                    i14 = i42;
                                    i13 = i5;
                                    i36 = c.X(t0Var3.o(i5), i17, bArr, i43, i3, cVar, eVar);
                                } else {
                                    i9 = i5;
                                    i19 = i42;
                                    i21 = i43;
                                    i20 = i17;
                                    unsafe = unsafe2;
                                    i18 = i16;
                                    i10 = i15;
                                    th2 = null;
                                }
                                i8 = i20;
                                i11 = i4;
                                i12 = i21;
                                i42 = i19;
                                i40 = i18;
                            }
                            i42 = i14;
                            i37 = i4;
                            i39 = i17;
                            i40 = i16;
                            i41 = i15;
                            i38 = i13;
                            bArr6 = bArr;
                            i35 = i3;
                        }
                        if (i8 == i11 || i11 == 0) {
                            t0Var2 = this;
                            if (!t0Var2.f) {
                                eVar2 = eVar;
                                if (eVar2.f3545d != q.a()) {
                                    i7 = i10;
                                    y.e<?, ?> eVar3 = eVar2.f3545d.f3632a.get(new q.a(t0Var2.f3646e, i7));
                                    if (eVar3 == null) {
                                        i36 = c.v0(i8, bArr, i12, i3, p(t), eVar);
                                        t3 = t;
                                        i37 = i11;
                                        i38 = i9;
                                        i39 = i8;
                                        t0Var3 = t0Var2;
                                        i41 = i7;
                                        t4 = t3;
                                        unsafe2 = unsafe;
                                        bArr6 = bArr;
                                        i35 = i3;
                                    } else {
                                        t.n();
                                        if (eVar3.f3678a != null) {
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                } else {
                                    t3 = t;
                                }
                            } else {
                                t3 = t;
                                eVar2 = eVar;
                            }
                            i7 = i10;
                            i36 = c.v0(i8, bArr, i12, i3, p(t), eVar);
                            i37 = i11;
                            i38 = i9;
                            i39 = i8;
                            t0Var3 = t0Var2;
                            i41 = i7;
                            t4 = t3;
                            unsafe2 = unsafe;
                            bArr6 = bArr;
                            i35 = i3;
                        } else {
                            t0Var = this;
                            t2 = t;
                            i36 = i12;
                            i37 = i11;
                            i39 = i8;
                            th = th2;
                        }
                    } else {
                        i34 = t0Var3.U(i44, i46);
                    }
                } else {
                    i34 = t0Var3.M(i44);
                }
                i5 = i34;
                i6 = -1;
                if (i5 != i6) {
                }
                if (i8 == i11) {
                }
                t0Var2 = this;
                if (!t0Var2.f) {
                }
                i7 = i10;
                i36 = c.v0(i8, bArr, i12, i3, p(t), eVar);
                i37 = i11;
                i38 = i9;
                i39 = i8;
                t0Var3 = t0Var2;
                i41 = i7;
                t4 = t3;
                unsafe2 = unsafe;
                bArr6 = bArr;
                i35 = i3;
            } else {
                unsafe = unsafe2;
                t2 = t4;
                t0Var = t0Var3;
                th = null;
            }
        }
        if (i42 != -1) {
            unsafe.putInt(t2, (long) i42, i40);
        }
        for (int i51 = t0Var.k; i51 < t0Var.l; i51++) {
            t0Var.l(t2, t0Var.j[i51], th, (l1<UT, UB>) t0Var.o);
        }
        if (i37 == 0) {
            if (i36 != i3) {
                throw b0.g();
            }
        } else if (i36 > i3 || i39 != i37) {
            throw b0.g();
        }
        return i36;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v19, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0109, code lost:
        if (r6 == 0) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c7, code lost:
        if (r0 != r8) goto L_0x0223;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x020f, code lost:
        if (r0 != r15) goto L_0x0223;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0052  */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final int K(T t, byte[] bArr, int i2, int i3, e eVar) {
        byte b2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Unsafe unsafe;
        int i9;
        int i10;
        int i11;
        int i12;
        long j2;
        long j3;
        int i13;
        long j4;
        int i14;
        Object obj;
        int i15;
        t0<T> t0Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i16 = i3;
        e eVar2 = eVar;
        Unsafe unsafe2 = s;
        int i17 = -1;
        int i18 = i2;
        int i19 = -1;
        int i20 = 0;
        while (i18 < i16) {
            int i21 = i18 + 1;
            byte b3 = bArr2[i18];
            if (b3 < 0) {
                i4 = c.x0(b3, bArr2, i21, eVar2);
                b2 = eVar2.f3542a;
            } else {
                b2 = b3;
                i4 = i21;
            }
            int i22 = b2 >>> 3;
            int i23 = b2 & 7;
            if (i22 > i19) {
                int i24 = i20 / 3;
                if (i22 < t0Var.f3644c || i22 > t0Var.f3645d) {
                    i5 = i17;
                    if (i5 != i17) {
                        i7 = i22;
                        i9 = i4;
                        unsafe = unsafe2;
                        i6 = i17;
                        i8 = 0;
                    } else {
                        int i25 = t0Var.f3642a[i5 + 1];
                        int V = V(i25);
                        long B = B(i25);
                        if (V <= 17) {
                            boolean z = true;
                            switch (V) {
                                case 0:
                                    i12 = i5;
                                    if (i23 == 1) {
                                        p1.t(t2, B, c.L(bArr2, i4));
                                        i18 = i4 + 8;
                                        i11 = i12;
                                        break;
                                    }
                                    i8 = i12;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 1:
                                    i12 = i5;
                                    if (i23 == 5) {
                                        p1.f.n(t2, B, c.R(bArr2, i4));
                                        i18 = i4 + 4;
                                        i11 = i12;
                                        break;
                                    }
                                    i8 = i12;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 2:
                                case 3:
                                    j3 = B;
                                    i12 = i5;
                                    if (i23 == 0) {
                                        i13 = c.D0(bArr2, i4, eVar2);
                                        j2 = eVar2.f3543b;
                                        unsafe2.putLong(t, j3, j2);
                                        i18 = i13;
                                        i11 = i12;
                                        break;
                                    }
                                    i8 = i12;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 4:
                                case 11:
                                    j4 = B;
                                    i12 = i5;
                                    break;
                                case 5:
                                case 14:
                                    if (i23 == 1) {
                                        i12 = i5;
                                        unsafe2.putLong(t, B, c.P(bArr2, i4));
                                        i18 = i4 + 8;
                                        i11 = i12;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 6:
                                case 13:
                                    if (i23 == 5) {
                                        unsafe2.putInt(t2, B, c.N(bArr2, i4));
                                        i18 = i4 + 4;
                                        i11 = i5;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 7:
                                    if (i23 == 0) {
                                        int D0 = c.D0(bArr2, i4, eVar2);
                                        if (eVar2.f3543b == 0) {
                                            z = false;
                                        }
                                        p1.f.k(t2, B, z);
                                        i18 = D0;
                                        i11 = i5;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 8:
                                    if (i23 == 2) {
                                        i18 = (536870912 & i25) == 0 ? c.r0(bArr2, i4, eVar2) : c.t0(bArr2, i4, eVar2);
                                        obj = eVar2.f3544c;
                                        unsafe2.putObject(t2, B, obj);
                                        i11 = i5;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 9:
                                    if (i23 == 2) {
                                        i18 = c.V(t0Var.o(i5), bArr2, i4, i16, eVar2);
                                        Object object = unsafe2.getObject(t2, B);
                                        if (object != null) {
                                            obj = a0.f(object, eVar2.f3544c);
                                            unsafe2.putObject(t2, B, obj);
                                            i11 = i5;
                                            break;
                                        }
                                        obj = eVar2.f3544c;
                                        unsafe2.putObject(t2, B, obj);
                                        i11 = i5;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 10:
                                    if (i23 == 2) {
                                        i18 = c.J(bArr2, i4, eVar2);
                                        obj = eVar2.f3544c;
                                        unsafe2.putObject(t2, B, obj);
                                        i11 = i5;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 12:
                                    if (i23 == 0) {
                                        j4 = B;
                                        i12 = i5;
                                        i18 = c.z0(bArr2, i4, eVar2);
                                        i14 = eVar2.f3542a;
                                        unsafe2.putInt(t2, j4, i14);
                                        i11 = i12;
                                        break;
                                    }
                                    i12 = i5;
                                    i8 = i12;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 15:
                                    if (i23 == 0) {
                                        i18 = c.z0(bArr2, i4, eVar2);
                                        i12 = i5;
                                        i14 = j.b(eVar2.f3542a);
                                        j4 = B;
                                        unsafe2.putInt(t2, j4, i14);
                                        i11 = i12;
                                        break;
                                    }
                                    i12 = i5;
                                    i8 = i12;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                case 16:
                                    if (i23 == 0) {
                                        i13 = c.D0(bArr2, i4, eVar2);
                                        j3 = B;
                                        i12 = i5;
                                        j2 = j.c(eVar2.f3543b);
                                        unsafe2.putLong(t, j3, j2);
                                        i18 = i13;
                                        i11 = i12;
                                        break;
                                    }
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                                default:
                                    i8 = i5;
                                    i7 = i22;
                                    i10 = i4;
                                    unsafe = unsafe2;
                                    i6 = -1;
                                    i9 = i10;
                                    break;
                            }
                        } else if (V == 27) {
                            if (i23 == 2) {
                                a0.c cVar = (a0.c) unsafe2.getObject(t2, B);
                                if (!cVar.k()) {
                                    int size = cVar.size();
                                    cVar = cVar.g(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t2, B, cVar);
                                }
                                i11 = i5;
                                i18 = c.X(t0Var.o(i5), b2, bArr, i4, i3, cVar, eVar);
                            }
                            i8 = i5;
                            i7 = i22;
                            i10 = i4;
                            unsafe = unsafe2;
                            i6 = -1;
                            i9 = i10;
                        } else {
                            i8 = i5;
                            if (V <= 49) {
                                i7 = i22;
                                unsafe = unsafe2;
                                i6 = -1;
                                i18 = L(t, bArr, i4, i3, b2, i22, i23, i8, (long) i25, V, B, eVar);
                            } else {
                                i7 = i22;
                                i10 = i4;
                                unsafe = unsafe2;
                                i6 = -1;
                                if (V == 50) {
                                    if (i23 == 2) {
                                        H(t, bArr, i10, i3, i8, B, eVar);
                                        throw null;
                                    }
                                    i9 = i10;
                                } else {
                                    i18 = I(t, bArr, i10, i3, b2, i7, i23, i25, V, B, i8, eVar);
                                }
                            }
                            i9 = i18;
                        }
                        i19 = i22;
                        i20 = i11;
                        i17 = -1;
                    }
                    i18 = c.v0(b2, bArr, i9, i3, p(t), eVar);
                    i20 = i8;
                    t0Var = this;
                    t2 = t;
                    bArr2 = bArr;
                    i16 = i3;
                    eVar2 = eVar;
                    unsafe2 = unsafe;
                    i19 = i7;
                    i17 = i6;
                } else {
                    i15 = t0Var.U(i22, i24);
                }
            } else {
                i15 = t0Var.M(i22);
            }
            i5 = i15;
            if (i5 != i17) {
            }
            i18 = c.v0(b2, bArr, i9, i3, p(t), eVar);
            i20 = i8;
            t0Var = this;
            t2 = t;
            bArr2 = bArr;
            i16 = i3;
            eVar2 = eVar;
            unsafe2 = unsafe;
            i19 = i7;
            i17 = i6;
        }
        if (i18 == i16) {
            return i18;
        }
        throw b0.g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0228, code lost:
        if (r30.f3543b != 0) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x022b, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x022c, code lost:
        r11.c(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x022f, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0231, code lost:
        r4 = c.b.a.a.c.n.c.z0(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0237, code lost:
        if (r21 == r30.f3542a) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x023b, code lost:
        r1 = c.b.a.a.c.n.c.D0(r18, r4, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0243, code lost:
        if (r30.f3543b == 0) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x0245, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0110, code lost:
        if (r4 == 0) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0113, code lost:
        r11.add(c.b.c.a.j0.a.i.h(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011b, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011d, code lost:
        r4 = c.b.a.a.c.n.c.z0(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        if (r21 == r30.f3542a) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0127, code lost:
        r1 = c.b.a.a.c.n.c.z0(r18, r4, r30);
        r4 = r30.f3542a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012d, code lost:
        if (r4 < 0) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0131, code lost:
        if (r4 > (r18.length - r1)) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        if (r4 != 0) goto L_0x0113;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0135, code lost:
        r11.add(c.b.c.a.j0.a.i.f3564c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        throw c.b.c.a.j0.a.b0.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0144, code lost:
        throw c.b.c.a.j0.a.b0.f();
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d8  */
    public final int L(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, e eVar) {
        int D0;
        int i9;
        int z0;
        int D02;
        int i10 = i2;
        a0.c cVar = (a0.c) s.getObject(t, j3);
        if (!cVar.k()) {
            int size = cVar.size();
            cVar = cVar.g(size == 0 ? 10 : size * 2);
            s.putObject(t, j3, cVar);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    return c.b0(bArr, i10, cVar, eVar);
                }
                if (i6 == 1) {
                    n nVar = (n) cVar;
                    double L = c.L(bArr, i2);
                    while (true) {
                        nVar.c(L);
                        int i11 = i10 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i10 = c.z0(bArr, i11, eVar);
                        if (i4 != eVar.f3542a) {
                            return i11;
                        }
                        L = c.L(bArr, i10);
                    }
                }
                break;
            case 19:
            case 36:
                if (i6 == 2) {
                    return c.h0(bArr, i10, cVar, eVar);
                }
                if (i6 == 5) {
                    w wVar = (w) cVar;
                    float R = c.R(bArr, i2);
                    while (true) {
                        wVar.c(R);
                        int i12 = i10 + 4;
                        if (i12 >= i3) {
                            return i12;
                        }
                        i10 = c.z0(bArr, i12, eVar);
                        if (i4 != eVar.f3542a) {
                            return i12;
                        }
                        R = c.R(bArr, i10);
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    return c.p0(bArr, i10, cVar, eVar);
                }
                if (i6 == 0) {
                    i0 i0Var = (i0) cVar;
                    do {
                        D0 = c.D0(bArr, i10, eVar);
                        i0Var.c(eVar.f3543b);
                        if (D0 >= i3) {
                            return D0;
                        }
                        i10 = c.z0(bArr, D0, eVar);
                    } while (i4 == eVar.f3542a);
                    return D0;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return c.n0(bArr, i10, cVar, eVar);
                }
                if (i6 == 0) {
                    return c.B0(i4, bArr, i2, i3, cVar, eVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    return c.f0(bArr, i10, cVar, eVar);
                }
                if (i6 == 1) {
                    i0 i0Var2 = (i0) cVar;
                    long P = c.P(bArr, i2);
                    while (true) {
                        i0Var2.c(P);
                        int i13 = i10 + 8;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i10 = c.z0(bArr, i13, eVar);
                        if (i4 != eVar.f3542a) {
                            return i13;
                        }
                        P = c.P(bArr, i10);
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    return c.d0(bArr, i10, cVar, eVar);
                }
                if (i6 == 5) {
                    z zVar = (z) cVar;
                    int N = c.N(bArr, i2);
                    while (true) {
                        zVar.c(N);
                        int i14 = i10 + 4;
                        if (i14 >= i3) {
                            return i14;
                        }
                        i10 = c.z0(bArr, i14, eVar);
                        if (i4 != eVar.f3542a) {
                            return i14;
                        }
                        N = c.N(bArr, i10);
                    }
                }
                break;
            case 25:
            case 42:
                if (i6 != 2) {
                    if (i6 == 0) {
                        f fVar = (f) cVar;
                        int D03 = c.D0(bArr, i10, eVar);
                        break;
                    }
                } else {
                    return c.Z(bArr, i10, cVar, eVar);
                }
                break;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int z02 = c.z0(bArr, i10, eVar);
                        int i15 = eVar.f3542a;
                        if (i15 >= 0) {
                            if (i15 != 0) {
                                String str = new String(bArr, z02, i15, a0.f3518a);
                                cVar.add(str);
                                z02 += i15;
                                if (z02 < i3) {
                                    int z03 = c.z0(bArr, z02, eVar);
                                    if (i4 != eVar.f3542a) {
                                        return z02;
                                    }
                                    z02 = c.z0(bArr, z03, eVar);
                                    i15 = eVar.f3542a;
                                    if (i15 >= 0) {
                                        if (i15 != 0) {
                                            str = new String(bArr, z02, i15, a0.f3518a);
                                            cVar.add(str);
                                            z02 += i15;
                                            if (z02 < i3) {
                                                return z02;
                                            }
                                        }
                                    }
                                    throw b0.f();
                                    return z02;
                                }
                                return z02;
                            }
                            cVar.add("");
                            if (z02 < i3) {
                            }
                            return z02;
                        }
                        throw b0.f();
                    }
                    int z04 = c.z0(bArr, i10, eVar);
                    int i16 = eVar.f3542a;
                    if (i16 >= 0) {
                        if (i16 != 0) {
                            int i17 = z04 + i16;
                            if (q1.f(bArr, z04, i17)) {
                                String str2 = new String(bArr, z04, i16, a0.f3518a);
                                cVar.add(str2);
                                z04 = i17;
                                if (z04 < i3) {
                                    int z05 = c.z0(bArr, z04, eVar);
                                    if (i4 != eVar.f3542a) {
                                        return z04;
                                    }
                                    z04 = c.z0(bArr, z05, eVar);
                                    int i18 = eVar.f3542a;
                                    if (i18 >= 0) {
                                        if (i18 != 0) {
                                            i17 = z04 + i18;
                                            if (q1.f(bArr, z04, i17)) {
                                                str2 = new String(bArr, z04, i18, a0.f3518a);
                                                cVar.add(str2);
                                                z04 = i17;
                                                if (z04 < i3) {
                                                    return z04;
                                                }
                                            }
                                            throw b0.c();
                                        }
                                    }
                                    throw b0.f();
                                    return z04;
                                }
                                return z04;
                            }
                            throw b0.c();
                        }
                        cVar.add("");
                        if (z04 < i3) {
                        }
                        return z04;
                    }
                    throw b0.f();
                }
                break;
            case 27:
                if (i6 == 2) {
                    return c.X(o(i7), i4, bArr, i2, i3, cVar, eVar);
                }
                break;
            case 28:
                if (i6 == 2) {
                    int z06 = c.z0(bArr, i10, eVar);
                    int i19 = eVar.f3542a;
                    if (i19 < 0) {
                        throw b0.f();
                    } else if (i19 > bArr.length - z06) {
                        throw b0.h();
                    }
                }
                break;
            case 30:
            case 44:
                if (i6 == 2) {
                    i9 = c.n0(bArr, i10, cVar, eVar);
                } else if (i6 == 0) {
                    i9 = c.B0(i4, bArr, i2, i3, cVar, eVar);
                }
                T t2 = t;
                m1 m1Var = t2.unknownFields;
                if (m1Var == m1.f) {
                    m1Var = null;
                }
                m1 m1Var2 = (m1) h1.z(i5, cVar, (a0.b) this.f3643b[((i7 / 3) * 2) + 1], m1Var, this.o);
                if (m1Var2 != null) {
                    t2.unknownFields = m1Var2;
                }
                return i9;
            case 33:
            case 47:
                if (i6 == 2) {
                    return c.j0(bArr, i10, cVar, eVar);
                }
                if (i6 == 0) {
                    z zVar2 = (z) cVar;
                    do {
                        z0 = c.z0(bArr, i10, eVar);
                        zVar2.c(j.b(eVar.f3542a));
                        if (z0 >= i3) {
                            return z0;
                        }
                        i10 = c.z0(bArr, z0, eVar);
                    } while (i4 == eVar.f3542a);
                    return z0;
                }
                break;
            case 34:
            case 48:
                if (i6 == 2) {
                    return c.l0(bArr, i10, cVar, eVar);
                }
                if (i6 == 0) {
                    i0 i0Var3 = (i0) cVar;
                    do {
                        D02 = c.D0(bArr, i10, eVar);
                        i0Var3.c(j.c(eVar.f3543b));
                        if (D02 >= i3) {
                            return D02;
                        }
                        i10 = c.z0(bArr, D02, eVar);
                    } while (i4 == eVar.f3542a);
                    return D02;
                }
                break;
            case 49:
                if (i6 == 3) {
                    f1 o2 = o(i7);
                    int i20 = (i4 & -8) | 4;
                    i10 = c.T(o2, bArr, i2, i3, i20, eVar);
                    while (true) {
                        cVar.add(eVar.f3544c);
                        if (i10 >= i3) {
                            break;
                        } else {
                            int z07 = c.z0(bArr, i10, eVar);
                            if (i4 != eVar.f3542a) {
                                break;
                            } else {
                                i10 = c.T(o2, bArr, z07, i3, i20, eVar);
                            }
                        }
                    }
                }
                break;
        }
        return i10;
    }

    public final int M(int i2) {
        if (i2 < this.f3644c || i2 > this.f3645d) {
            return -1;
        }
        return U(i2, 0);
    }

    public final <E> void N(Object obj, long j2, e1 e1Var, f1<E> f1Var, q qVar) {
        e1Var.O(this.n.c(obj, j2), f1Var, qVar);
    }

    public final <E> void O(Object obj, int i2, e1 e1Var, f1<E> f1Var, q qVar) {
        e1Var.P(this.n.c(obj, B(i2)), f1Var, qVar);
    }

    public final void P(Object obj, int i2, e1 e1Var) {
        Object obj2;
        long j2;
        if ((536870912 & i2) != 0) {
            j2 = B(i2);
            obj2 = e1Var.C();
        } else if (this.g) {
            j2 = B(i2);
            obj2 = e1Var.A();
        } else {
            j2 = B(i2);
            obj2 = e1Var.c();
        }
        p1.f.q(obj, j2, obj2);
    }

    public final void Q(Object obj, int i2, e1 e1Var) {
        if ((536870912 & i2) != 0) {
            e1Var.b(this.n.c(obj, B(i2)));
        } else {
            e1Var.J(this.n.c(obj, B(i2)));
        }
    }

    public final void S(T t, int i2) {
        if (!this.h) {
            int i3 = this.f3642a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            p1.f.o(t, j2, p1.l(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void T(T t, int i2, int i3) {
        p1.f.o(t, (long) (this.f3642a[i3 + 2] & 1048575), i2);
    }

    public final int U(int i2, int i3) {
        int length = (this.f3642a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f3642a[i5];
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

    public final int W(int i2) {
        return this.f3642a[i2 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04f7  */
    public final void X(T t, u1 u1Var) {
        Map.Entry<y.d, Object> entry;
        int length;
        int i2;
        int i3;
        if (this.f) {
            if (((s) this.p) != null) {
                u<y.d> uVar = t.extensions;
                if (!uVar.h()) {
                    entry = uVar.k().next();
                    int i4 = -1;
                    length = this.f3642a.length;
                    Unsafe unsafe = s;
                    i2 = 0;
                    int i5 = 0;
                    while (i2 < length) {
                        int W = W(i2);
                        int i6 = this.f3642a[i2];
                        int V = V(W);
                        if (this.h || V > 17) {
                            i3 = 0;
                        } else {
                            int i7 = this.f3642a[i2 + 2];
                            int i8 = i7 & 1048575;
                            if (i8 != i4) {
                                i5 = unsafe.getInt(t, (long) i8);
                                i4 = i8;
                            }
                            i3 = 1 << (i7 >>> 20);
                        }
                        if (entry != null) {
                            this.p.a(entry);
                            if (i6 >= 0) {
                                this.p.e(u1Var, entry);
                                throw null;
                            }
                        }
                        long B = B(W);
                        switch (V) {
                            case 0:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).c(i6, p1.j(t, B));
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 1:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).f(i6, p1.k(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 2:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).h(i6, unsafe.getLong(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 3:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).p(i6, unsafe.getLong(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 4:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).f3606a.T(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 5:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).e(i6, unsafe.getLong(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 6:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).d(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 7:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).a(i6, p1.f(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 8:
                                if ((i3 & i5) != 0) {
                                    Z(i6, unsafe.getObject(t, B), u1Var);
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 9:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).i(i6, unsafe.getObject(t, B), o(i2));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 10:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).b(i6, (i) unsafe.getObject(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 11:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).o(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 12:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).f3606a.T(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 13:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).k(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 14:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).l(i6, unsafe.getLong(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 15:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).m(i6, unsafe.getInt(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 16:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).n(i6, unsafe.getLong(t, B));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 17:
                                if ((i3 & i5) != 0) {
                                    ((m) u1Var).g(i6, unsafe.getObject(t, B), o(i2));
                                } else {
                                    continue;
                                }
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 18:
                                h1.J(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 19:
                                h1.N(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 20:
                                h1.Q(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 21:
                                h1.Y(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 22:
                                h1.P(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 23:
                                h1.M(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 24:
                                h1.L(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 25:
                                h1.H(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 26:
                                h1.W(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var);
                                break;
                            case 27:
                                h1.R(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, o(i2));
                                break;
                            case 28:
                                h1.I(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var);
                                break;
                            case 29:
                                h1.X(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 30:
                                h1.K(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 31:
                                h1.S(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 32:
                                h1.T(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 33:
                                h1.U(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 34:
                                h1.V(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, false);
                                continue;
                                i2 += 3;
                                length = length;
                                i4 = i4;
                            case 35:
                                h1.J(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 36:
                                h1.N(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 37:
                                h1.Q(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 38:
                                h1.Y(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 39:
                                h1.P(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 40:
                                h1.M(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 41:
                                h1.L(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 42:
                                h1.H(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 43:
                                h1.X(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 44:
                                h1.K(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 45:
                                h1.S(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 46:
                                h1.T(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 47:
                                h1.U(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 48:
                                h1.V(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, true);
                                break;
                            case 49:
                                h1.O(this.f3642a[i2], (List) unsafe.getObject(t, B), u1Var, o(i2));
                                break;
                            case 50:
                                Y(u1Var, i6, unsafe.getObject(t, B), i2);
                                break;
                            case 51:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).c(i6, D(t, B));
                                    break;
                                }
                                break;
                            case 52:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).f(i6, E(t, B));
                                    break;
                                }
                                break;
                            case 53:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).h(i6, G(t, B));
                                    break;
                                }
                                break;
                            case 54:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).p(i6, G(t, B));
                                    break;
                                }
                                break;
                            case 55:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).f3606a.T(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 56:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).e(i6, G(t, B));
                                    break;
                                }
                                break;
                            case 57:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).d(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 58:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).a(i6, C(t, B));
                                    break;
                                }
                                break;
                            case 59:
                                if (u(t, i6, i2)) {
                                    Z(i6, unsafe.getObject(t, B), u1Var);
                                    break;
                                }
                                break;
                            case 60:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).i(i6, unsafe.getObject(t, B), o(i2));
                                    break;
                                }
                                break;
                            case 61:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).b(i6, (i) unsafe.getObject(t, B));
                                    break;
                                }
                                break;
                            case 62:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).o(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 63:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).f3606a.T(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 64:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).k(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 65:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).l(i6, G(t, B));
                                    break;
                                }
                                break;
                            case 66:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).m(i6, F(t, B));
                                    break;
                                }
                                break;
                            case 67:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).n(i6, G(t, B));
                                    break;
                                }
                                break;
                            case 68:
                                if (u(t, i6, i2)) {
                                    ((m) u1Var).g(i6, unsafe.getObject(t, B), o(i2));
                                    break;
                                }
                                break;
                        }
                        i2 += 3;
                        length = length;
                        i4 = i4;
                    }
                    if (entry != null) {
                        a0((l1<UT, UB>) this.o, t, u1Var);
                        return;
                    } else {
                        this.p.e(u1Var, entry);
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        entry = null;
        int i42 = -1;
        length = this.f3642a.length;
        Unsafe unsafe2 = s;
        i2 = 0;
        int i52 = 0;
        while (i2 < length) {
        }
        if (entry != null) {
        }
    }

    public final <K, V> void Y(u1 u1Var, int i2, Object obj, int i3) {
        if (obj != null) {
            this.q.h(this.f3643b[(i3 / 3) * 2]);
            Map<?, ?> b2 = this.q.b(obj);
            m mVar = (m) u1Var;
            if (mVar.f3606a != null) {
                Iterator<Map.Entry<?, ?>> it = b2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<?, ?> next = it.next();
                    ((l.b) mVar.f3606a).V((i2 << 3) | 2);
                    next.getKey();
                    next.getValue();
                    throw null;
                }
                return;
            }
            throw null;
        }
    }

    public final void Z(int i2, Object obj, u1 u1Var) {
        if (obj instanceof String) {
            l.b bVar = (l.b) ((m) u1Var).f3606a;
            bVar.V((i2 << 3) | 2);
            bVar.a0((String) obj);
            return;
        }
        l.b bVar2 = (l.b) ((m) u1Var).f3606a;
        bVar2.V((i2 << 3) | 2);
        bVar2.Z((i) obj);
    }

    @Override // c.b.c.a.j0.a.f1
    public void a(T t, T t2) {
        if (t2 != null) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f3642a;
                if (i2 < iArr.length) {
                    int i3 = iArr[i2 + 1];
                    long B = B(i3);
                    int i4 = this.f3642a[i2];
                    switch (V(i3)) {
                        case 0:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                p1.t(t, B, p1.j(t2, B));
                                S(t, i2);
                                break;
                            }
                        case 1:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                p1.f.n(t, B, p1.k(t2, B));
                                S(t, i2);
                                break;
                            }
                        case 2:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.w(t, B, p1.m(t2, B));
                            S(t, i2);
                            break;
                        case 3:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.w(t, B, p1.m(t2, B));
                            S(t, i2);
                            break;
                        case 4:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 5:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.w(t, B, p1.m(t2, B));
                            S(t, i2);
                            break;
                        case 6:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 7:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                p1.f.k(t, B, p1.f(t2, B));
                                S(t, i2);
                                break;
                            }
                        case 8:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.q(t, B, p1.n(t2, B));
                            S(t, i2);
                            break;
                        case 9:
                        case 17:
                            x(t, t2, i2);
                            break;
                        case 10:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.q(t, B, p1.n(t2, B));
                            S(t, i2);
                            break;
                        case 11:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 12:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 13:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 14:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.w(t, B, p1.m(t2, B));
                            S(t, i2);
                            break;
                        case 15:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.f.o(t, B, p1.l(t2, B));
                            S(t, i2);
                            break;
                        case 16:
                            if (!s(t2, i2)) {
                                break;
                            }
                            p1.w(t, B, p1.m(t2, B));
                            S(t, i2);
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
                            this.n.b(t, t2, B);
                            break;
                        case 50:
                            h1.C(this.q, t, t2, B);
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
                            if (!u(t2, i4, i2)) {
                                break;
                            }
                            p1.f.q(t, B, p1.n(t2, B));
                            T(t, i4, i2);
                            break;
                        case 60:
                        case 68:
                            y(t, t2, i2);
                            break;
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                            if (!u(t2, i4, i2)) {
                                break;
                            }
                            p1.f.q(t, B, p1.n(t2, B));
                            T(t, i4, i2);
                            break;
                    }
                    i2 += 3;
                } else {
                    h1.D(this.o, t, t2);
                    if (this.f) {
                        h1.B(this.p, t, t2);
                        return;
                    }
                    return;
                }
            }
        } else {
            throw null;
        }
    }

    public final <UT, UB> void a0(l1<UT, UB> l1Var, T t, u1 u1Var) {
        if (((n1) l1Var) != null) {
            t.unknownFields.e(u1Var);
            return;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: c.b.c.a.j0.a.f1 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: c.b.c.a.j0.a.f1 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: c.b.c.a.j0.a.f1 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.c.a.j0.a.f1
    public final boolean b(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 < this.k) {
                int i6 = this.j[i4];
                int i7 = this.f3642a[i6];
                int W = W(i6);
                if (!this.h) {
                    int i8 = this.f3642a[i6 + 2];
                    int i9 = 1048575 & i8;
                    i2 = 1 << (i8 >>> 20);
                    if (i9 != i3) {
                        i5 = s.getInt(t, (long) i9);
                        i3 = i9;
                    }
                } else {
                    i2 = 0;
                }
                if (((268435456 & W) != 0) && !t(t, i6, i5, i2)) {
                    return false;
                }
                int V = V(W);
                if (V != 9 && V != 17) {
                    if (V != 27) {
                        if (V == 60 || V == 68) {
                            if (u(t, i7, i6) && !o(i6).b(p1.n(t, B(W)))) {
                                return false;
                            }
                        } else if (V != 49) {
                            if (V == 50 && !this.q.b(p1.n(t, B(W))).isEmpty()) {
                                this.q.h(this.f3643b[(i6 / 3) * 2]);
                                throw null;
                            }
                        }
                    }
                    List list = (List) p1.n(t, B(W));
                    if (!list.isEmpty()) {
                        f1 o2 = o(i6);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= list.size()) {
                                break;
                            } else if (!o2.b(list.get(i10))) {
                                z = false;
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                    if (!z) {
                        return false;
                    }
                } else if (t(t, i6, i5, i2) && !o(i6).b(p1.n(t, B(W)))) {
                    return false;
                }
                i4++;
            } else {
                if (this.f) {
                    if (((s) this.p) == null) {
                        throw null;
                    } else if (!t.extensions.i()) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (c.b.c.a.j0.a.h1.F(c.b.c.a.j0.a.p1.n(r10, r5), c.b.c.a.j0.a.p1.n(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        if (c.b.c.a.j0.a.h1.F(c.b.c.a.j0.a.p1.n(r10, r5), c.b.c.a.j0.a.p1.n(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (c.b.c.a.j0.a.p1.m(r10, r5) == c.b.c.a.j0.a.p1.m(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (c.b.c.a.j0.a.p1.m(r10, r5) == c.b.c.a.j0.a.p1.m(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00eb, code lost:
        if (c.b.c.a.j0.a.h1.F(c.b.c.a.j0.a.p1.n(r10, r5), c.b.c.a.j0.a.p1.n(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0101, code lost:
        if (c.b.c.a.j0.a.h1.F(c.b.c.a.j0.a.p1.n(r10, r5), c.b.c.a.j0.a.p1.n(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0117, code lost:
        if (c.b.c.a.j0.a.h1.F(c.b.c.a.j0.a.p1.n(r10, r5), c.b.c.a.j0.a.p1.n(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        if (c.b.c.a.j0.a.p1.f(r10, r5) == c.b.c.a.j0.a.p1.f(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014f, code lost:
        if (c.b.c.a.j0.a.p1.m(r10, r5) == c.b.c.a.j0.a.p1.m(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0161, code lost:
        if (c.b.c.a.j0.a.p1.l(r10, r5) == c.b.c.a.j0.a.p1.l(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0174, code lost:
        if (c.b.c.a.j0.a.p1.m(r10, r5) == c.b.c.a.j0.a.p1.m(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0187, code lost:
        if (c.b.c.a.j0.a.p1.m(r10, r5) == c.b.c.a.j0.a.p1.m(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a0, code lost:
        if (java.lang.Float.floatToIntBits(c.b.c.a.j0.a.p1.k(r10, r5)) == java.lang.Float.floatToIntBits(c.b.c.a.j0.a.p1.k(r11, r5))) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01bb, code lost:
        if (java.lang.Double.doubleToLongBits(c.b.c.a.j0.a.p1.j(r10, r5)) == java.lang.Double.doubleToLongBits(c.b.c.a.j0.a.p1.j(r11, r5))) goto L_0x01bf;
     */
    @Override // c.b.c.a.j0.a.f1
    public boolean c(T t, T t2) {
        int length = this.f3642a.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int i3 = this.f3642a[i2 + 1];
                long B = B(i3);
                switch (V(i3)) {
                    case 0:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (k(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (k(t, t2, i2)) {
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
                        z = h1.F(p1.n(t, B), p1.n(t2, B));
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
                        long j2 = (long) (this.f3642a[i2 + 2] & 1048575);
                        if (p1.l(t, j2) == p1.l(t2, j2)) {
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
                n1 n1Var = (n1) this.o;
                if (n1Var != null) {
                    m1 m1Var = t.unknownFields;
                    if (n1Var == null) {
                        throw null;
                    } else if (!m1Var.equals(t2.unknownFields)) {
                        return false;
                    } else {
                        if (!this.f) {
                            return true;
                        }
                        s sVar = (s) this.p;
                        if (sVar != null) {
                            u<y.d> uVar = t.extensions;
                            if (sVar != null) {
                                return uVar.equals(t2.extensions);
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

    @Override // c.b.c.a.j0.a.f1
    public int d(T t) {
        return this.h ? r(t) : q(t);
    }

    @Override // c.b.c.a.j0.a.f1
    public T e() {
        return (T) this.m.a(this.f3646e);
    }

    @Override // c.b.c.a.j0.a.f1
    public void f(T t) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long B = B(W(this.j[i3]));
            Object n2 = p1.n(t, B);
            if (n2 != null) {
                p1.f.q(t, B, this.q.g(n2));
            }
            i3++;
        }
        int length = this.j.length;
        while (i2 < length) {
            this.n.a(t, (long) this.j[i2]);
            i2++;
        }
        if (((n1) this.o) != null) {
            t.unknownFields.f3611e = false;
            if (!this.f) {
                return;
            }
            if (((s) this.p) != null) {
                t.extensions.l();
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00cc, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00de, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e0, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e4, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // c.b.c.a.j0.a.f1
    public int g(T t) {
        int i2;
        int i3;
        long j2;
        double d2;
        float f2;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.f3642a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int W = W(i5);
            int i6 = this.f3642a[i5];
            long B = B(W);
            int i7 = 37;
            switch (V(W)) {
                case 0:
                    i3 = i4 * 53;
                    d2 = p1.j(t, B);
                    j2 = Double.doubleToLongBits(d2);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    f2 = p1.k(t, B);
                    i2 = Float.floatToIntBits(f2);
                    i4 = i2 + i3;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i4 * 53;
                    j2 = p1.m(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i3 = i4 * 53;
                    i2 = p1.l(t, B);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    z = p1.f(t, B);
                    i2 = a0.c(z);
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) p1.n(t, B)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    obj = p1.n(t, B);
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
                    obj2 = p1.n(t, B);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 17:
                    obj = p1.n(t, B);
                    break;
                case 51:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        d2 = D(t, B);
                        j2 = Double.doubleToLongBits(d2);
                        i2 = a0.e(j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        f2 = E(t, B);
                        i2 = Float.floatToIntBits(f2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = G(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 54:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = G(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 55:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 56:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = G(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 57:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 58:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        z = C(t, B);
                        i2 = a0.c(z);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = ((String) p1.n(t, B)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 60:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    obj2 = p1.n(t, B);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 61:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    obj2 = p1.n(t, B);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 62:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 63:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 64:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 65:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = G(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 66:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = F(t, B);
                    i4 = i2 + i3;
                    break;
                case 67:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = G(t, B);
                    i2 = a0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 68:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    obj2 = p1.n(t, B);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
            }
        }
        int i8 = i4 * 53;
        if (((n1) this.o) != null) {
            int hashCode = t.unknownFields.hashCode() + i8;
            if (!this.f) {
                return hashCode;
            }
            int i9 = hashCode * 53;
            if (((s) this.p) != null) {
                return i9 + t.extensions.hashCode();
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.c.a.j0.a.f1
    public void h(T t, byte[] bArr, int i2, int i3, e eVar) {
        if (this.h) {
            K(t, bArr, i2, i3, eVar);
        } else {
            J(t, bArr, i2, i3, 0, eVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0533  */
    @Override // c.b.c.a.j0.a.f1
    public void i(T t, u1 u1Var) {
        Map.Entry<y.d, Object> entry;
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
        m mVar = (m) u1Var;
        if (mVar == null) {
            throw null;
        } else if (this.h) {
            if (this.f) {
                if (((s) this.p) != null) {
                    u<y.d> uVar = t.extensions;
                    if (!uVar.h()) {
                        entry = uVar.k().next();
                        length = this.f3642a.length;
                        for (i2 = 0; i2 < length; i2 += 3) {
                            int W = W(i2);
                            int i9 = this.f3642a[i2];
                            if (entry != null) {
                                this.p.a(entry);
                                if (i9 >= 0) {
                                    this.p.e(u1Var, entry);
                                    throw null;
                                }
                            }
                            switch (V(W)) {
                                case 0:
                                    if (s(t, i2)) {
                                        d2 = p1.j(t, B(W));
                                        mVar.c(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    if (s(t, i2)) {
                                        f2 = p1.k(t, B(W));
                                        mVar.f(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    if (s(t, i2)) {
                                        j2 = p1.m(t, B(W));
                                        mVar.h(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3:
                                    if (s(t, i2)) {
                                        j3 = p1.m(t, B(W));
                                        mVar.p(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 4:
                                    if (s(t, i2)) {
                                        i3 = p1.l(t, B(W));
                                        mVar.f3606a.T(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 5:
                                    if (s(t, i2)) {
                                        j4 = p1.m(t, B(W));
                                        mVar.e(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 6:
                                    if (s(t, i2)) {
                                        i4 = p1.l(t, B(W));
                                        mVar.d(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 7:
                                    if (s(t, i2)) {
                                        z = p1.f(t, B(W));
                                        mVar.a(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 8:
                                    if (!s(t, i2)) {
                                        break;
                                    }
                                    Z(i9, p1.n(t, B(W)), u1Var);
                                    break;
                                case 9:
                                    if (!s(t, i2)) {
                                        break;
                                    }
                                    mVar.i(i9, p1.n(t, B(W)), o(i2));
                                    break;
                                case 10:
                                    if (!s(t, i2)) {
                                        break;
                                    }
                                    mVar.b(i9, (i) p1.n(t, B(W)));
                                    break;
                                case 11:
                                    if (s(t, i2)) {
                                        i5 = p1.l(t, B(W));
                                        mVar.o(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 12:
                                    if (s(t, i2)) {
                                        i6 = p1.l(t, B(W));
                                        mVar.f3606a.T(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 13:
                                    if (s(t, i2)) {
                                        i7 = p1.l(t, B(W));
                                        mVar.k(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 14:
                                    if (s(t, i2)) {
                                        j5 = p1.m(t, B(W));
                                        mVar.l(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 15:
                                    if (s(t, i2)) {
                                        i8 = p1.l(t, B(W));
                                        mVar.m(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 16:
                                    if (s(t, i2)) {
                                        j6 = p1.m(t, B(W));
                                        mVar.n(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 17:
                                    if (!s(t, i2)) {
                                        break;
                                    }
                                    mVar.g(i9, p1.n(t, B(W)), o(i2));
                                    break;
                                case 18:
                                    h1.J(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 19:
                                    h1.N(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 20:
                                    h1.Q(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 21:
                                    h1.Y(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 22:
                                    h1.P(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 23:
                                    h1.M(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 24:
                                    h1.L(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 25:
                                    h1.H(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 26:
                                    h1.W(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var);
                                    break;
                                case 27:
                                    h1.R(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, o(i2));
                                    break;
                                case 28:
                                    h1.I(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var);
                                    break;
                                case 29:
                                    h1.X(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 30:
                                    h1.K(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 31:
                                    h1.S(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 32:
                                    h1.T(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 33:
                                    h1.U(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 34:
                                    h1.V(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, false);
                                    break;
                                case 35:
                                    h1.J(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 36:
                                    h1.N(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 37:
                                    h1.Q(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 38:
                                    h1.Y(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 39:
                                    h1.P(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 40:
                                    h1.M(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 41:
                                    h1.L(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 42:
                                    h1.H(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 43:
                                    h1.X(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 44:
                                    h1.K(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 45:
                                    h1.S(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 46:
                                    h1.T(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 47:
                                    h1.U(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 48:
                                    h1.V(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, true);
                                    break;
                                case 49:
                                    h1.O(this.f3642a[i2], (List) p1.n(t, B(W)), u1Var, o(i2));
                                    break;
                                case 50:
                                    Y(u1Var, i9, p1.n(t, B(W)), i2);
                                    break;
                                case 51:
                                    if (u(t, i9, i2)) {
                                        d2 = D(t, B(W));
                                        mVar.c(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 52:
                                    if (u(t, i9, i2)) {
                                        f2 = E(t, B(W));
                                        mVar.f(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 53:
                                    if (u(t, i9, i2)) {
                                        j2 = G(t, B(W));
                                        mVar.h(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 54:
                                    if (u(t, i9, i2)) {
                                        j3 = G(t, B(W));
                                        mVar.p(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 55:
                                    if (u(t, i9, i2)) {
                                        i3 = F(t, B(W));
                                        mVar.f3606a.T(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 56:
                                    if (u(t, i9, i2)) {
                                        j4 = G(t, B(W));
                                        mVar.e(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 57:
                                    if (u(t, i9, i2)) {
                                        i4 = F(t, B(W));
                                        mVar.d(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 58:
                                    if (u(t, i9, i2)) {
                                        z = C(t, B(W));
                                        mVar.a(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 59:
                                    if (!u(t, i9, i2)) {
                                        break;
                                    }
                                    Z(i9, p1.n(t, B(W)), u1Var);
                                    break;
                                case 60:
                                    if (!u(t, i9, i2)) {
                                        break;
                                    }
                                    mVar.i(i9, p1.n(t, B(W)), o(i2));
                                    break;
                                case 61:
                                    if (!u(t, i9, i2)) {
                                        break;
                                    }
                                    mVar.b(i9, (i) p1.n(t, B(W)));
                                    break;
                                case 62:
                                    if (u(t, i9, i2)) {
                                        i5 = F(t, B(W));
                                        mVar.o(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 63:
                                    if (u(t, i9, i2)) {
                                        i6 = F(t, B(W));
                                        mVar.f3606a.T(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 64:
                                    if (u(t, i9, i2)) {
                                        i7 = F(t, B(W));
                                        mVar.k(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 65:
                                    if (u(t, i9, i2)) {
                                        j5 = G(t, B(W));
                                        mVar.l(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 66:
                                    if (u(t, i9, i2)) {
                                        i8 = F(t, B(W));
                                        mVar.m(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 67:
                                    if (u(t, i9, i2)) {
                                        j6 = G(t, B(W));
                                        mVar.n(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 68:
                                    if (!u(t, i9, i2)) {
                                        break;
                                    }
                                    mVar.g(i9, p1.n(t, B(W)), o(i2));
                                    break;
                            }
                        }
                        if (entry != null) {
                            a0((l1<UT, UB>) this.o, t, u1Var);
                            return;
                        } else {
                            this.p.e(u1Var, entry);
                            throw null;
                        }
                    }
                } else {
                    throw null;
                }
            }
            entry = null;
            length = this.f3642a.length;
            while (i2 < length) {
            }
            if (entry != null) {
            }
        } else {
            X(t, u1Var);
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:36)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // c.b.c.a.j0.a.f1
    public void j(T r16, c.b.c.a.j0.a.e1 r17, c.b.c.a.j0.a.q r18) {
        /*
        // Method dump skipped, instructions count: 1376
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.a.j0.a.t0.j(java.lang.Object, c.b.c.a.j0.a.e1, c.b.c.a.j0.a.q):void");
    }

    public final boolean k(T t, T t2, int i2) {
        return s(t, i2) == s(t2, i2);
    }

    public final <UT, UB> UB l(Object obj, int i2, UB ub, l1<UT, UB> l1Var) {
        int[] iArr = this.f3642a;
        int i3 = iArr[i2];
        Object n2 = p1.n(obj, B(iArr[i2 + 1]));
        if (n2 == null) {
            return ub;
        }
        int i4 = (i2 / 3) * 2;
        a0.b bVar = (a0.b) this.f3643b[i4 + 1];
        if (bVar == null) {
            return ub;
        }
        Map<?, ?> e2 = this.q.e(n2);
        this.q.h(this.f3643b[i4]);
        for (Map.Entry<?, ?> entry : e2.entrySet()) {
            if (!bVar.a(((Integer) entry.getValue()).intValue())) {
                if (ub == null && ((n1) l1Var) == null) {
                    throw null;
                }
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
        return ub;
    }

    public final a0.b m(int i2) {
        return (a0.b) this.f3643b[((i2 / 3) * 2) + 1];
    }

    public final Object n(int i2) {
        return this.f3643b[(i2 / 3) * 2];
    }

    public final f1 o(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.f3643b;
        f1 f1Var = (f1) objArr[i3];
        if (f1Var != null) {
            return f1Var;
        }
        f1<T> a2 = b1.f3523c.a((Class) objArr[i3 + 1]);
        this.f3643b[i3] = a2;
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01ca, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01dc, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ed, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fe, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x020f, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0220, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0231, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0242, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0244, code lost:
        r2.putInt(r17, (long) r10, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0248, code lost:
        r5 = r5 + ((c.b.c.a.j0.a.l.I(r7) + c.b.c.a.j0.a.l.G(r8)) + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x037d, code lost:
        if ((r7 instanceof c.b.c.a.j0.a.i) != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x037f, code lost:
        r7 = c.b.c.a.j0.a.l.d(r8, (c.b.c.a.j0.a.i) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0386, code lost:
        r7 = c.b.c.a.j0.a.l.E(r8, (java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x038c, code lost:
        r5 = r5 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if ((r7 instanceof c.b.c.a.j0.a.i) != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x015e, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0170, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0182, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0194, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a6, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01b8, code lost:
        if (r16.i != false) goto L_0x0244;
     */
    public final int q(T t) {
        int i2;
        int i3;
        long j2;
        long j3;
        int i4;
        int a2;
        Object obj;
        int i5;
        int i6;
        int i7;
        long j4;
        int i8;
        Unsafe unsafe = s;
        int i9 = -1;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < this.f3642a.length; i12 += 3) {
            int W = W(i12);
            int i13 = this.f3642a[i12];
            int V = V(W);
            if (V <= 17) {
                i3 = this.f3642a[i12 + 2];
                int i14 = 1048575 & i3;
                i2 = 1 << (i3 >>> 20);
                if (i14 != i9) {
                    i11 = unsafe.getInt(t, (long) i14);
                    i9 = i14;
                }
            } else {
                i3 = (!this.i || V < v.DOUBLE_LIST_PACKED.f3661b || V > v.SINT64_LIST_PACKED.f3661b) ? 0 : this.f3642a[i12 + 2] & 1048575;
                i2 = 0;
            }
            long B = B(W);
            switch (V) {
                case 0:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.f(i13, 0.0d);
                    i10 += a2;
                    break;
                case 1:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.m(i13, 0.0f);
                    i10 += a2;
                    break;
                case 2:
                    if ((i11 & i2) != 0) {
                        j2 = unsafe.getLong(t, B);
                        a2 = l.s(i13, j2);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i11 & i2) != 0) {
                        j3 = unsafe.getLong(t, B);
                        a2 = l.J(i13, j3);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i11 & i2) != 0) {
                        i4 = unsafe.getInt(t, B);
                        a2 = l.q(i13, i4);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.k(i13, 0);
                    i10 += a2;
                    break;
                case 6:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.i(i13, 0);
                    i10 += a2;
                    break;
                case 7:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.a(i13, true);
                    i10 += a2;
                    break;
                case 8:
                    if ((i11 & i2) != 0) {
                        obj = unsafe.getObject(t, B);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = h1.o(i13, unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
                case 10:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.d(i13, (i) unsafe.getObject(t, B));
                    i10 += a2;
                    break;
                case 11:
                    if ((i11 & i2) != 0) {
                        i5 = unsafe.getInt(t, B);
                        a2 = l.H(i13, i5);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i11 & i2) != 0) {
                        i6 = unsafe.getInt(t, B);
                        a2 = l.h(i13, i6);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.w(i13, 0);
                    i10 += a2;
                    break;
                case 14:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.y(i13, 0);
                    i10 += a2;
                    break;
                case 15:
                    if ((i11 & i2) != 0) {
                        i7 = unsafe.getInt(t, B);
                        a2 = l.A(i13, i7);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i11 & i2) != 0) {
                        j4 = unsafe.getLong(t, B);
                        a2 = l.C(i13, j4);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    a2 = l.o(i13, (r0) unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
                case 18:
                case 23:
                case 32:
                    a2 = h1.h(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 19:
                case 24:
                case 31:
                    a2 = h1.f(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 20:
                    a2 = h1.m(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 21:
                    a2 = h1.x(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 22:
                    a2 = h1.k(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 25:
                    a2 = h1.a(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 26:
                    a2 = h1.u(i13, (List) unsafe.getObject(t, B));
                    i10 += a2;
                    break;
                case 27:
                    a2 = h1.p(i13, (List) unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
                case 28:
                    a2 = h1.c(i13, (List) unsafe.getObject(t, B));
                    i10 += a2;
                    break;
                case 29:
                    a2 = h1.v(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 30:
                    a2 = h1.d(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 33:
                    a2 = h1.q(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 34:
                    a2 = h1.s(i13, (List) unsafe.getObject(t, B), false);
                    i10 += a2;
                    break;
                case 35:
                    i8 = h1.i((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i8 = h1.g((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i8 = h1.n((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i8 = h1.y((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i8 = h1.l((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i8 = h1.i((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i8 = h1.g((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i8 = h1.b((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i8 = h1.w((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i8 = h1.e((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i8 = h1.g((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i8 = h1.i((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i8 = h1.r((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i8 = h1.t((List) unsafe.getObject(t, B));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    a2 = h1.j(i13, (List) unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
                case 50:
                    a2 = this.q.d(i13, unsafe.getObject(t, B), n(i12));
                    i10 += a2;
                    break;
                case 51:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.f(i13, 0.0d);
                    i10 += a2;
                    break;
                case 52:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.m(i13, 0.0f);
                    i10 += a2;
                    break;
                case 53:
                    if (u(t, i13, i12)) {
                        j2 = G(t, B);
                        a2 = l.s(i13, j2);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(t, i13, i12)) {
                        j3 = G(t, B);
                        a2 = l.J(i13, j3);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(t, i13, i12)) {
                        i4 = F(t, B);
                        a2 = l.q(i13, i4);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.k(i13, 0);
                    i10 += a2;
                    break;
                case 57:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.i(i13, 0);
                    i10 += a2;
                    break;
                case 58:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.a(i13, true);
                    i10 += a2;
                    break;
                case 59:
                    if (u(t, i13, i12)) {
                        obj = unsafe.getObject(t, B);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = h1.o(i13, unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
                case 61:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.d(i13, (i) unsafe.getObject(t, B));
                    i10 += a2;
                    break;
                case 62:
                    if (u(t, i13, i12)) {
                        i5 = F(t, B);
                        a2 = l.H(i13, i5);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(t, i13, i12)) {
                        i6 = F(t, B);
                        a2 = l.h(i13, i6);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.w(i13, 0);
                    i10 += a2;
                    break;
                case 65:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.y(i13, 0);
                    i10 += a2;
                    break;
                case 66:
                    if (u(t, i13, i12)) {
                        i7 = F(t, B);
                        a2 = l.A(i13, i7);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(t, i13, i12)) {
                        j4 = G(t, B);
                        a2 = l.C(i13, j4);
                        i10 += a2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    a2 = l.o(i13, (r0) unsafe.getObject(t, B), o(i12));
                    i10 += a2;
                    break;
            }
        }
        if (((n1) this.o) != null) {
            int a3 = t.unknownFields.a() + i10;
            if (!this.f) {
                return a3;
            }
            if (((s) this.p) != null) {
                u<y.d> uVar = t.extensions;
                int i15 = 0;
                for (int i16 = 0; i16 < uVar.f3652a.e(); i16++) {
                    Map.Entry<T, Object> d2 = uVar.f3652a.d(i16);
                    i15 += u.e(d2.getKey(), d2.getValue());
                }
                for (Map.Entry<T, Object> entry : uVar.f3652a.f()) {
                    i15 += u.e(entry.getKey(), entry.getValue());
                }
                return a3 + i15;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01cc, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01dd, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ee, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01ff, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0201, code lost:
        r0.putInt(r14, (long) r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0205, code lost:
        r3 = r3 + ((c.b.c.a.j0.a.l.I(r5) + c.b.c.a.j0.a.l.G(r6)) + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0338, code lost:
        if ((r4 instanceof c.b.c.a.j0.a.i) != false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x033b, code lost:
        r4 = c.b.c.a.j0.a.l.E(r6, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        if ((r4 instanceof c.b.c.a.j0.a.i) != false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x011b, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x013f, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0151, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0163, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0175, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0187, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0199, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01aa, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01bb, code lost:
        if (r13.i != false) goto L_0x0201;
     */
    public final int r(T t) {
        int i2;
        long j2;
        long j3;
        int i3;
        Object obj;
        int i4;
        int i5;
        int i6;
        long j4;
        int i7;
        Unsafe unsafe = s;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f3642a.length; i9 += 3) {
            int W = W(i9);
            int V = V(W);
            int i10 = this.f3642a[i9];
            long B = B(W);
            int i11 = (V < v.DOUBLE_LIST_PACKED.f3661b || V > v.SINT64_LIST_PACKED.f3661b) ? 0 : this.f3642a[i9 + 2] & 1048575;
            switch (V) {
                case 0:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.f(i10, 0.0d);
                    i8 += i2;
                    break;
                case 1:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.m(i10, 0.0f);
                    i8 += i2;
                    break;
                case 2:
                    if (s(t, i9)) {
                        j2 = p1.m(t, B);
                        i2 = l.s(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(t, i9)) {
                        j3 = p1.m(t, B);
                        i2 = l.J(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(t, i9)) {
                        i3 = p1.l(t, B);
                        i2 = l.q(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.k(i10, 0);
                    i8 += i2;
                    break;
                case 6:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.i(i10, 0);
                    i8 += i2;
                    break;
                case 7:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.a(i10, true);
                    i8 += i2;
                    break;
                case 8:
                    if (s(t, i9)) {
                        obj = p1.n(t, B);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = h1.o(i10, p1.n(t, B), o(i9));
                    i8 += i2;
                    break;
                case 10:
                    if (!s(t, i9)) {
                        break;
                    }
                    obj = p1.n(t, B);
                    i2 = l.d(i10, (i) obj);
                    i8 += i2;
                    break;
                case 11:
                    if (s(t, i9)) {
                        i4 = p1.l(t, B);
                        i2 = l.H(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(t, i9)) {
                        i5 = p1.l(t, B);
                        i2 = l.h(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.w(i10, 0);
                    i8 += i2;
                    break;
                case 14:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.y(i10, 0);
                    i8 += i2;
                    break;
                case 15:
                    if (s(t, i9)) {
                        i6 = p1.l(t, B);
                        i2 = l.A(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(t, i9)) {
                        j4 = p1.m(t, B);
                        i2 = l.C(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = l.o(i10, (r0) p1.n(t, B), o(i9));
                    i8 += i2;
                    break;
                case 18:
                case 23:
                case 32:
                    i2 = h1.h(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 19:
                case 24:
                case 31:
                    i2 = h1.f(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 20:
                    i2 = h1.m(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 21:
                    i2 = h1.x(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 22:
                    i2 = h1.k(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 25:
                    i2 = h1.a(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 26:
                    i2 = h1.u(i10, v(t, B));
                    i8 += i2;
                    break;
                case 27:
                    i2 = h1.p(i10, v(t, B), o(i9));
                    i8 += i2;
                    break;
                case 28:
                    i2 = h1.c(i10, v(t, B));
                    i8 += i2;
                    break;
                case 29:
                    i2 = h1.v(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 30:
                    i2 = h1.d(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 33:
                    i2 = h1.q(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 34:
                    i2 = h1.s(i10, v(t, B), false);
                    i8 += i2;
                    break;
                case 35:
                    i7 = h1.i((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i7 = h1.g((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i7 = h1.n((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i7 = h1.y((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i7 = h1.l((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i7 = h1.i((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i7 = h1.g((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i7 = h1.b((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i7 = h1.w((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i7 = h1.e((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i7 = h1.g((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i7 = h1.i((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i7 = h1.r((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i7 = h1.t((List) unsafe.getObject(t, B));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i2 = h1.j(i10, v(t, B), o(i9));
                    i8 += i2;
                    break;
                case 50:
                    i2 = this.q.d(i10, p1.n(t, B), n(i9));
                    i8 += i2;
                    break;
                case 51:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.f(i10, 0.0d);
                    i8 += i2;
                    break;
                case 52:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.m(i10, 0.0f);
                    i8 += i2;
                    break;
                case 53:
                    if (u(t, i10, i9)) {
                        j2 = G(t, B);
                        i2 = l.s(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(t, i10, i9)) {
                        j3 = G(t, B);
                        i2 = l.J(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(t, i10, i9)) {
                        i3 = F(t, B);
                        i2 = l.q(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.k(i10, 0);
                    i8 += i2;
                    break;
                case 57:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.i(i10, 0);
                    i8 += i2;
                    break;
                case 58:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.a(i10, true);
                    i8 += i2;
                    break;
                case 59:
                    if (u(t, i10, i9)) {
                        obj = p1.n(t, B);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = h1.o(i10, p1.n(t, B), o(i9));
                    i8 += i2;
                    break;
                case 61:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    obj = p1.n(t, B);
                    i2 = l.d(i10, (i) obj);
                    i8 += i2;
                    break;
                case 62:
                    if (u(t, i10, i9)) {
                        i4 = F(t, B);
                        i2 = l.H(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(t, i10, i9)) {
                        i5 = F(t, B);
                        i2 = l.h(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.w(i10, 0);
                    i8 += i2;
                    break;
                case 65:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.y(i10, 0);
                    i8 += i2;
                    break;
                case 66:
                    if (u(t, i10, i9)) {
                        i6 = F(t, B);
                        i2 = l.A(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(t, i10, i9)) {
                        j4 = G(t, B);
                        i2 = l.C(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = l.o(i10, (r0) p1.n(t, B), o(i9));
                    i8 += i2;
                    break;
            }
        }
        if (((n1) this.o) != null) {
            return t.unknownFields.a() + i8;
        }
        throw null;
    }

    public final boolean s(T t, int i2) {
        if (this.h) {
            int i3 = this.f3642a[i2 + 1];
            long B = B(i3);
            switch (V(i3)) {
                case 0:
                    return p1.j(t, B) != 0.0d;
                case 1:
                    return p1.k(t, B) != 0.0f;
                case 2:
                    return p1.m(t, B) != 0;
                case 3:
                    return p1.m(t, B) != 0;
                case 4:
                    return p1.l(t, B) != 0;
                case 5:
                    return p1.m(t, B) != 0;
                case 6:
                    return p1.l(t, B) != 0;
                case 7:
                    return p1.f(t, B);
                case 8:
                    Object n2 = p1.n(t, B);
                    if (n2 instanceof String) {
                        return !((String) n2).isEmpty();
                    }
                    if (n2 instanceof i) {
                        return !i.f3564c.equals(n2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return p1.n(t, B) != null;
                case 10:
                    return !i.f3564c.equals(p1.n(t, B));
                case 11:
                    return p1.l(t, B) != 0;
                case 12:
                    return p1.l(t, B) != 0;
                case 13:
                    return p1.l(t, B) != 0;
                case 14:
                    return p1.m(t, B) != 0;
                case 15:
                    return p1.l(t, B) != 0;
                case 16:
                    return p1.m(t, B) != 0;
                case 17:
                    return p1.n(t, B) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f3642a[i2 + 2];
            return (p1.l(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0;
        }
    }

    public final boolean t(T t, int i2, int i3, int i4) {
        return this.h ? s(t, i2) : (i3 & i4) != 0;
    }

    public final boolean u(T t, int i2, int i3) {
        return p1.l(t, (long) (this.f3642a[i3 + 2] & 1048575)) == i2;
    }

    public final <K, V> void w(Object obj, int i2, Object obj2, q qVar, e1 e1Var) {
        long B = B(this.f3642a[i2 + 1]);
        Object n2 = p1.n(obj, B);
        if (n2 == null) {
            n2 = this.q.c(obj2);
            p1.f.q(obj, B, n2);
        } else if (this.q.f(n2)) {
            Object c2 = this.q.c(obj2);
            this.q.a(c2, n2);
            p1.f.q(obj, B, c2);
            n2 = c2;
        }
        e1Var.N(this.q.e(n2), this.q.h(obj2), qVar);
    }

    public final void x(T t, T t2, int i2) {
        long B = B(this.f3642a[i2 + 1]);
        if (s(t2, i2)) {
            Object n2 = p1.n(t, B);
            Object n3 = p1.n(t2, B);
            if (n2 != null && n3 != null) {
                n3 = a0.f(n2, n3);
            } else if (n3 == null) {
                return;
            }
            p1.f.q(t, B, n3);
            S(t, i2);
        }
    }

    public final void y(T t, T t2, int i2) {
        int[] iArr = this.f3642a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long B = B(i3);
        if (u(t2, i4, i2)) {
            Object n2 = p1.n(t, B);
            Object n3 = p1.n(t2, B);
            if (n2 != null && n3 != null) {
                n3 = a0.f(n2, n3);
            } else if (n3 == null) {
                return;
            }
            p1.f.q(t, B, n3);
            T(t, i4, i2);
        }
    }
}
