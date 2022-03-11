package f.b.g;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.g.c0;
import f.b.g.d0;
import f.b.g.j;
import f.b.g.m;
import f.b.g.m0;
import f.b.g.r;
import f.b.g.v;
import f.b.g.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import sun.misc.Unsafe;
/* loaded from: classes.dex */
public final class v0<T> implements j1<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = v1.q();
    public final int[] a;
    public final Object[] b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3942d;

    /* renamed from: e  reason: collision with root package name */
    public final t0 f3943e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f3944f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3945g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3946h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3947i;

    /* renamed from: j  reason: collision with root package name */
    public final int[] f3948j;

    /* renamed from: k  reason: collision with root package name */
    public final int f3949k;

    /* renamed from: l  reason: collision with root package name */
    public final int f3950l;
    public final x0 m;
    public final j0 n;
    public final r1<?, ?> o;
    public final s<?> p;
    public final o0 q;

    public v0(int[] iArr, Object[] objArr, int i2, int i3, t0 t0Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, x0 x0Var, j0 j0Var, r1<?, ?> r1Var, s<?> sVar, o0 o0Var) {
        this.a = iArr;
        this.b = objArr;
        this.c = i2;
        this.f3942d = i3;
        this.f3945g = t0Var instanceof z;
        this.f3946h = z;
        this.f3944f = sVar != null && sVar.e(t0Var);
        this.f3947i = z2;
        this.f3948j = iArr2;
        this.f3949k = i4;
        this.f3950l = i5;
        this.m = x0Var;
        this.n = j0Var;
        this.o = r1Var;
        this.p = sVar;
        this.f3943e = t0Var;
        this.q = o0Var;
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lf/b/g/r0;Lf/b/g/x0;Lf/b/g/j0;Lf/b/g/r1<**>;Lf/b/g/s<*>;Lf/b/g/o0;)Lf/b/g/v0<TT;>; */
    public static v0 A(r0 r0Var, x0 x0Var, j0 j0Var, r1 r1Var, s sVar, o0 o0Var) {
        if (r0Var instanceof g1) {
            return B((g1) r0Var, x0Var, j0Var, r1Var, sVar, o0Var);
        }
        o1 o1Var = (o1) r0Var;
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b2  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static <T> v0<T> B(g1 g1Var, x0 x0Var, j0 j0Var, r1<?, ?> r1Var, s<?> sVar, o0 o0Var) {
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
        int i12;
        int i13;
        int i14;
        int i15;
        String str;
        int i16;
        int i17;
        int i18;
        int i19;
        Field field;
        char charAt;
        int i20;
        Object obj;
        Field field2;
        Object obj2;
        Field field3;
        int i21;
        int i22;
        char charAt2;
        int i23;
        char charAt3;
        int i24;
        char charAt4;
        int i25;
        int i26;
        char charAt5;
        int i27;
        char charAt6;
        int i28;
        char charAt7;
        int i29;
        char charAt8;
        int i30;
        char charAt9;
        int i31;
        char charAt10;
        int i32;
        char charAt11;
        int i33;
        char charAt12;
        int i34;
        char charAt13;
        char charAt14;
        d1 d1Var = d1.PROTO3;
        int i35 = 0;
        boolean z2 = ((g1Var.f3868d & 1) == 1 ? d1.PROTO2 : d1Var) == d1Var;
        String str2 = g1Var.b;
        int length = str2.length();
        int charAt15 = str2.charAt(0);
        if (charAt15 >= 55296) {
            int i36 = charAt15 & 8191;
            int i37 = 1;
            int i38 = 13;
            while (true) {
                i2 = i37 + 1;
                charAt14 = str2.charAt(i37);
                if (charAt14 < 55296) {
                    break;
                }
                i36 |= (charAt14 & 8191) << i38;
                i38 += 13;
                i37 = i2;
            }
            charAt15 = i36 | (charAt14 << i38);
        } else {
            i2 = 1;
        }
        int i39 = i2 + 1;
        int charAt16 = str2.charAt(i2);
        if (charAt16 >= 55296) {
            int i40 = charAt16 & 8191;
            int i41 = 13;
            while (true) {
                i34 = i39 + 1;
                charAt13 = str2.charAt(i39);
                if (charAt13 < 55296) {
                    break;
                }
                i40 |= (charAt13 & 8191) << i41;
                i41 += 13;
                i39 = i34;
            }
            charAt16 = i40 | (charAt13 << i41);
            i39 = i34;
        }
        if (charAt16 == 0) {
            iArr = r;
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
        } else {
            int i42 = i39 + 1;
            int charAt17 = str2.charAt(i39);
            if (charAt17 >= 55296) {
                int i43 = charAt17 & 8191;
                int i44 = 13;
                while (true) {
                    i33 = i42 + 1;
                    charAt12 = str2.charAt(i42);
                    if (charAt12 < 55296) {
                        break;
                    }
                    i43 |= (charAt12 & 8191) << i44;
                    i44 += 13;
                    i42 = i33;
                }
                charAt17 = i43 | (charAt12 << i44);
                i42 = i33;
            }
            int i45 = i42 + 1;
            int charAt18 = str2.charAt(i42);
            if (charAt18 >= 55296) {
                int i46 = charAt18 & 8191;
                int i47 = 13;
                while (true) {
                    i32 = i45 + 1;
                    charAt11 = str2.charAt(i45);
                    if (charAt11 < 55296) {
                        break;
                    }
                    i46 |= (charAt11 & 8191) << i47;
                    i47 += 13;
                    i45 = i32;
                }
                charAt18 = i46 | (charAt11 << i47);
                i45 = i32;
            }
            int i48 = i45 + 1;
            i6 = str2.charAt(i45);
            if (i6 >= 55296) {
                int i49 = i6 & 8191;
                int i50 = 13;
                while (true) {
                    i31 = i48 + 1;
                    charAt10 = str2.charAt(i48);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i49 |= (charAt10 & 8191) << i50;
                    i50 += 13;
                    i48 = i31;
                }
                i6 = i49 | (charAt10 << i50);
                i48 = i31;
            }
            int i51 = i48 + 1;
            int charAt19 = str2.charAt(i48);
            if (charAt19 >= 55296) {
                int i52 = charAt19 & 8191;
                int i53 = 13;
                while (true) {
                    i30 = i51 + 1;
                    charAt9 = str2.charAt(i51);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i52 |= (charAt9 & 8191) << i53;
                    i53 += 13;
                    i51 = i30;
                }
                charAt19 = i52 | (charAt9 << i53);
                i51 = i30;
            }
            int i54 = i51 + 1;
            i4 = str2.charAt(i51);
            if (i4 >= 55296) {
                int i55 = i4 & 8191;
                int i56 = 13;
                while (true) {
                    i29 = i54 + 1;
                    charAt8 = str2.charAt(i54);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i55 |= (charAt8 & 8191) << i56;
                    i56 += 13;
                    i54 = i29;
                }
                i4 = i55 | (charAt8 << i56);
                i54 = i29;
            }
            int i57 = i54 + 1;
            int charAt20 = str2.charAt(i54);
            if (charAt20 >= 55296) {
                int i58 = charAt20 & 8191;
                int i59 = 13;
                while (true) {
                    i28 = i57 + 1;
                    charAt7 = str2.charAt(i57);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i58 |= (charAt7 & 8191) << i59;
                    i59 += 13;
                    i57 = i28;
                }
                charAt20 = i58 | (charAt7 << i59);
                i57 = i28;
            }
            int i60 = i57 + 1;
            int charAt21 = str2.charAt(i57);
            if (charAt21 >= 55296) {
                int i61 = charAt21 & 8191;
                int i62 = i60;
                int i63 = 13;
                while (true) {
                    i27 = i62 + 1;
                    charAt6 = str2.charAt(i62);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i61 |= (charAt6 & 8191) << i63;
                    i63 += 13;
                    i62 = i27;
                }
                charAt21 = i61 | (charAt6 << i63);
                i25 = i27;
            } else {
                i25 = i60;
            }
            int i64 = i25 + 1;
            int charAt22 = str2.charAt(i25);
            if (charAt22 >= 55296) {
                int i65 = charAt22 & 8191;
                int i66 = i64;
                int i67 = 13;
                while (true) {
                    i26 = i66 + 1;
                    charAt5 = str2.charAt(i66);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i65 |= (charAt5 & 8191) << i67;
                    i67 += 13;
                    i66 = i26;
                }
                charAt22 = i65 | (charAt5 << i67);
                i64 = i26;
            }
            iArr = new int[charAt22 + charAt20 + charAt21];
            i5 = (charAt17 * 2) + charAt18;
            i7 = charAt19;
            i3 = charAt22;
            i35 = charAt17;
            i39 = i64;
            i8 = charAt20;
        }
        Unsafe unsafe = s;
        Object[] objArr = g1Var.c;
        Class<?> cls = g1Var.a.getClass();
        int i68 = i5;
        int[] iArr2 = new int[i4 * 3];
        Object[] objArr2 = new Object[i4 * 2];
        int i69 = i3 + i8;
        int i70 = i3;
        int i71 = i39;
        int i72 = i69;
        int i73 = 0;
        int i74 = 0;
        while (i71 < length) {
            int i75 = i71 + 1;
            int charAt23 = str2.charAt(i71);
            if (charAt23 >= 55296) {
                int i76 = charAt23 & 8191;
                int i77 = i75;
                int i78 = 13;
                while (true) {
                    i24 = i77 + 1;
                    charAt4 = str2.charAt(i77);
                    i9 = i3;
                    if (charAt4 < 55296) {
                        break;
                    }
                    i76 |= (charAt4 & 8191) << i78;
                    i78 += 13;
                    i77 = i24;
                    i3 = i9;
                }
                charAt23 = i76 | (charAt4 << i78);
                i10 = i24;
            } else {
                i9 = i3;
                i10 = i75;
            }
            int i79 = i10 + 1;
            int charAt24 = str2.charAt(i10);
            if (charAt24 >= 55296) {
                int i80 = charAt24 & 8191;
                int i81 = i79;
                int i82 = 13;
                while (true) {
                    i23 = i81 + 1;
                    charAt3 = str2.charAt(i81);
                    z = z2;
                    if (charAt3 < 55296) {
                        break;
                    }
                    i80 |= (charAt3 & 8191) << i82;
                    i82 += 13;
                    i81 = i23;
                    z2 = z;
                }
                charAt24 = i80 | (charAt3 << i82);
                i11 = i23;
            } else {
                z = z2;
                i11 = i79;
            }
            int i83 = charAt24 & 255;
            if ((charAt24 & 1024) != 0) {
                i73++;
                iArr[i73] = i74;
            }
            if (i83 >= 51) {
                int i84 = i11 + 1;
                int charAt25 = str2.charAt(i11);
                char c = 55296;
                if (charAt25 >= 55296) {
                    int i85 = charAt25 & 8191;
                    int i86 = 13;
                    while (true) {
                        i22 = i84 + 1;
                        charAt2 = str2.charAt(i84);
                        if (charAt2 < c) {
                            break;
                        }
                        i85 |= (charAt2 & 8191) << i86;
                        i86 += 13;
                        i84 = i22;
                        c = 55296;
                    }
                    charAt25 = i85 | (charAt2 << i86);
                    i84 = i22;
                }
                int i87 = i83 - 51;
                if (i87 == 9 || i87 == 17) {
                    i21 = i68 + 1;
                    objArr2[((i74 / 3) * 2) + 1] = objArr[i68];
                } else {
                    if (i87 == 12 && (charAt15 & 1) == 1) {
                        i21 = i68 + 1;
                        objArr2[((i74 / 3) * 2) + 1] = objArr[i68];
                    }
                    int i88 = charAt25 * 2;
                    obj = objArr[i88];
                    if (!(obj instanceof Field)) {
                        field2 = (Field) obj;
                    } else {
                        field2 = S(cls, (String) obj);
                        objArr[i88] = field2;
                    }
                    i15 = (int) unsafe.objectFieldOffset(field2);
                    int i89 = i88 + 1;
                    obj2 = objArr[i89];
                    if (!(obj2 instanceof Field)) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = S(cls, (String) obj2);
                        objArr[i89] = field3;
                    }
                    i16 = (int) unsafe.objectFieldOffset(field3);
                    i12 = i84;
                    i14 = 0;
                    str = str2;
                    i13 = charAt24;
                }
                i68 = i21;
                int i882 = charAt25 * 2;
                obj = objArr[i882];
                if (!(obj instanceof Field)) {
                }
                i15 = (int) unsafe.objectFieldOffset(field2);
                int i892 = i882 + 1;
                obj2 = objArr[i892];
                if (!(obj2 instanceof Field)) {
                }
                i16 = (int) unsafe.objectFieldOffset(field3);
                i12 = i84;
                i14 = 0;
                str = str2;
                i13 = charAt24;
            } else {
                int i90 = i68 + 1;
                Field S = S(cls, (String) objArr[i68]);
                if (i83 == 9 || i83 == 17) {
                    i13 = charAt24;
                    i17 = 1;
                    objArr2[((i74 / 3) * 2) + 1] = S.getType();
                } else {
                    if (i83 == 27 || i83 == 49) {
                        i13 = charAt24;
                        i17 = 1;
                        i20 = i90 + 1;
                        objArr2[((i74 / 3) * 2) + 1] = objArr[i90];
                    } else if (i83 == 12 || i83 == 30 || i83 == 44) {
                        i13 = charAt24;
                        i17 = 1;
                        if ((charAt15 & 1) == 1) {
                            i20 = i90 + 1;
                            objArr2[((i74 / 3) * 2) + 1] = objArr[i90];
                        }
                    } else if (i83 == 50) {
                        int i91 = i70 + 1;
                        iArr[i70] = i74;
                        int i92 = (i74 / 3) * 2;
                        int i93 = i90 + 1;
                        objArr2[i92] = objArr[i90];
                        if ((charAt24 & 2048) != 0) {
                            i18 = i93 + 1;
                            objArr2[i92 + 1] = objArr[i93];
                            i70 = i91;
                            i13 = charAt24;
                        } else {
                            i70 = i91;
                            i18 = i93;
                            i13 = charAt24;
                        }
                        i17 = 1;
                        i15 = (int) unsafe.objectFieldOffset(S);
                        if ((charAt15 & 1) == i17 || i83 > 17) {
                            i19 = i18;
                            str = str2;
                            i12 = i11;
                            i16 = 0;
                            i14 = 0;
                        } else {
                            int i94 = i11 + 1;
                            int charAt26 = str2.charAt(i11);
                            if (charAt26 >= 55296) {
                                int i95 = charAt26 & 8191;
                                int i96 = 13;
                                while (true) {
                                    i12 = i94 + 1;
                                    charAt = str2.charAt(i94);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    i95 |= (charAt & 8191) << i96;
                                    i96 += 13;
                                    i94 = i12;
                                }
                                charAt26 = i95 | (charAt << i96);
                            } else {
                                i12 = i94;
                            }
                            int i97 = (charAt26 / 32) + (i35 * 2);
                            Object obj3 = objArr[i97];
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = S(cls, (String) obj3);
                                objArr[i97] = field;
                            }
                            i19 = i18;
                            str = str2;
                            i16 = (int) unsafe.objectFieldOffset(field);
                            i14 = charAt26 % 32;
                        }
                        if (i83 >= 18 && i83 <= 49) {
                            i72++;
                            iArr[i72] = i15;
                        }
                        i68 = i19;
                    } else {
                        i13 = charAt24;
                        i17 = 1;
                    }
                    i18 = i20;
                    i15 = (int) unsafe.objectFieldOffset(S);
                    if ((charAt15 & 1) == i17) {
                    }
                    i19 = i18;
                    str = str2;
                    i12 = i11;
                    i16 = 0;
                    i14 = 0;
                    if (i83 >= 18) {
                        i72++;
                        iArr[i72] = i15;
                    }
                    i68 = i19;
                }
                i18 = i90;
                i15 = (int) unsafe.objectFieldOffset(S);
                if ((charAt15 & 1) == i17) {
                }
                i19 = i18;
                str = str2;
                i12 = i11;
                i16 = 0;
                i14 = 0;
                if (i83 >= 18) {
                }
                i68 = i19;
            }
            int i98 = i74 + 1;
            iArr2[i74] = charAt23;
            int i99 = i98 + 1;
            iArr2[i98] = ((i13 & 512) != 0 ? 536870912 : 0) | ((i13 & 256) != 0 ? 268435456 : 0) | (i83 << 20) | i15;
            i74 = i99 + 1;
            iArr2[i99] = (i14 << 20) | i16;
            str2 = str;
            i7 = i7;
            length = length;
            i3 = i9;
            z2 = z;
            i71 = i12;
            i6 = i6;
        }
        return new v0<>(iArr2, objArr2, i6, i7, g1Var.a, z2, false, iArr, i3, i69, x0Var, j0Var, r1Var, sVar, o0Var);
    }

    public static long C(int i2) {
        return (long) (i2 & 1048575);
    }

    public static <T> boolean D(T t, long j2) {
        return ((Boolean) v1.p(t, j2)).booleanValue();
    }

    public static <T> double E(T t, long j2) {
        return ((Double) v1.p(t, j2)).doubleValue();
    }

    public static <T> float F(T t, long j2) {
        return ((Float) v1.p(t, j2)).floatValue();
    }

    public static <T> int G(T t, long j2) {
        return ((Integer) v1.p(t, j2)).intValue();
    }

    public static <T> long H(T t, long j2) {
        return ((Long) v1.p(t, j2)).longValue();
    }

    public static Field S(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder j2 = a.j("Field ", str, " for ");
            j2.append(cls.getName());
            j2.append(" not found. Known fields are ");
            j2.append(Arrays.toString(declaredFields));
            throw new RuntimeException(j2.toString());
        }
    }

    public static int W(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static s1 q(Object obj) {
        z zVar = (z) obj;
        s1 s1Var = zVar.unknownFields;
        if (s1Var != s1.f3937f) {
            return s1Var;
        }
        s1 e2 = s1.e();
        zVar.unknownFields = e2;
        return e2;
    }

    public static List<?> w(Object obj, long j2) {
        return (List) v1.p(obj, j2);
    }

    public final <K, V> int I(T t, byte[] bArr, int i2, int i3, int i4, long j2, f fVar) {
        int i5;
        int i6;
        Unsafe unsafe = s;
        Object obj = this.b[(i4 / 3) * 2];
        Object object = unsafe.getObject(t, j2);
        if (this.q.f(object)) {
            Object c = this.q.c(obj);
            this.q.a(c, object);
            unsafe.putObject(t, j2, c);
            object = c;
        }
        m0.a<?, ?> h2 = this.q.h(obj);
        Map<?, ?> e2 = this.q.e(object);
        int h0 = b.h0(bArr, i2, fVar);
        int i7 = fVar.a;
        if (i7 < 0 || i7 > i3 - h0) {
            throw d0.h();
        }
        int i8 = h0 + i7;
        Object obj2 = (K) h2.b;
        V v = h2.f3926d;
        while (h0 < i8) {
            int i9 = h0 + 1;
            byte b = bArr[h0];
            if (b < 0) {
                i5 = b.g0(b, bArr, i9, fVar);
                i6 = fVar.a;
            } else {
                i5 = i9;
                i6 = b;
            }
            int i10 = (i6 == 1 ? 1 : 0) >>> 3;
            int i11 = (i6 == 1 ? 1 : 0) & 7;
            if (i10 != 1) {
                if (i10 == 2) {
                    y1 y1Var = h2.c;
                    if (i11 == y1Var.c) {
                        h0 = l(bArr, i5, i3, y1Var, h2.f3926d.getClass(), fVar);
                        v = (V) fVar.c;
                    }
                }
                h0 = b.r1(i6, bArr, i5, i3, fVar);
            } else {
                y1 y1Var2 = h2.a;
                if (i11 == y1Var2.c) {
                    h0 = l(bArr, i5, i3, y1Var2, null, fVar);
                    obj2 = (K) fVar.c;
                    v = (V) v;
                } else {
                    h0 = b.r1(i6, bArr, i5, i3, fVar);
                }
            }
        }
        if (h0 == i8) {
            e2.put(obj2, v);
            return i8;
        }
        throw d0.g();
    }

    public final int J(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, f fVar) {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        Unsafe unsafe = s;
        long j4 = (long) (this.a[i9 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(Double.longBitsToDouble(b.P(bArr, i2)));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(Float.intBitsToFloat(b.O(bArr, i2)));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = b.j0(bArr, i2, fVar);
                    j3 = fVar.b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = b.h0(bArr, i2, fVar);
                    i11 = fVar.a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(b.P(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(b.O(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = b.j0(bArr, i2, fVar);
                    obj3 = Boolean.valueOf(fVar.b != 0);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    i10 = b.h0(bArr, i2, fVar);
                    int i12 = fVar.a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || w1.h(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, c0.a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw d0.c();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = b.R(p(i9), bArr, i2, i3, fVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = fVar.c;
                    if (object != null) {
                        obj3 = c0.c(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = b.M(bArr, i2, fVar);
                    obj3 = fVar.c;
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int h0 = b.h0(bArr, i2, fVar);
                    int i13 = fVar.a;
                    c0.e eVar = (c0.e) this.b[((i9 / 3) * 2) + 1];
                    if (eVar == null || eVar.isInRange(i13)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        unsafe.putInt(t, j4, i5);
                    } else {
                        q(t).f(i4, Long.valueOf((long) i13));
                    }
                    return h0;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = b.h0(bArr, i2, fVar);
                    i11 = k.b(fVar.a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = b.j0(bArr, i2, fVar);
                    j3 = k.c(fVar.b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = b.Q(p(i9), bArr, i2, i3, (i4 & -8) | 4, fVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = fVar.c;
                    if (object2 != null) {
                        obj3 = c0.c(object2, obj3);
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

    /* JADX WARN: Code restructure failed: missing block: B:122:0x0311, code lost:
        if (r0 != r6) goto L_0x0367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0344, code lost:
        if (r0 != r15) goto L_0x0367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0365, code lost:
        if (r0 != r15) goto L_0x0367;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0367, code lost:
        r10 = r26;
        r13 = r27;
        r9 = r29;
        r1 = r31;
        r11 = r32;
        r7 = r21;
        r12 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x037b, code lost:
        r9 = r29;
        r8 = r31;
        r2 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int K(T t, byte[] bArr, int i2, int i3, int i4, f fVar) {
        Unsafe unsafe;
        T t2;
        v0<T> v0Var;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        v0<T> v0Var2;
        T t3;
        int i16;
        int i17;
        f fVar2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        long j2;
        int i23;
        long j3;
        int i24;
        long j4;
        f fVar3;
        int i25;
        Object obj;
        long j5;
        long j6;
        Object obj2;
        long j7;
        int i26;
        v0<T> v0Var3 = this;
        T t4 = t;
        byte[] bArr2 = bArr;
        int i27 = i3;
        f fVar4 = fVar;
        Unsafe unsafe2 = s;
        int i28 = i2;
        int i29 = i4;
        int i30 = -1;
        int i31 = 0;
        int i32 = 0;
        int i33 = -1;
        int i34 = 0;
        while (true) {
            if (i28 < i27) {
                int i35 = i28 + 1;
                byte b = bArr2[i28];
                if (b < 0) {
                    i5 = b.g0(b, bArr2, i35, fVar4);
                    i6 = fVar4.a;
                } else {
                    i6 = b;
                    i5 = i35;
                }
                int i36 = i6 >>> 3;
                int i37 = i6 & 7;
                if (i36 > i30) {
                    int i38 = i31 / 3;
                    if (i36 < v0Var3.c || i36 > v0Var3.f3942d) {
                        i8 = -1;
                        i7 = -1;
                        if (i7 != i8) {
                            i11 = i36;
                            i15 = i5;
                            i12 = i33;
                            i10 = i34;
                            unsafe = unsafe2;
                            i9 = 0;
                            i14 = i29;
                            i13 = i6;
                        } else {
                            int i39 = v0Var3.a[i7 + 1];
                            int W = W(i39);
                            long C = C(i39);
                            if (W <= 17) {
                                int i40 = v0Var3.a[i7 + 2];
                                int i41 = 1 << (i40 >>> 20);
                                int i42 = i40 & 1048575;
                                if (i42 != i33) {
                                    i21 = i41;
                                    if (i33 != -1) {
                                        unsafe2.putInt(t4, (long) i33, i34);
                                    }
                                    i34 = unsafe2.getInt(t4, (long) i42);
                                    i33 = i42;
                                } else {
                                    i21 = i41;
                                }
                                switch (W) {
                                    case 0:
                                        fVar2 = fVar;
                                        i18 = i7;
                                        i19 = i36;
                                        i17 = i6;
                                        if (i37 == 1) {
                                            v1.v(t4, C, Double.longBitsToDouble(b.P(bArr2, i5)));
                                            i22 = i5 + 8;
                                            i28 = i22;
                                            i34 |= i21;
                                            break;
                                        }
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 1:
                                        fVar2 = fVar;
                                        i18 = i7;
                                        i19 = i36;
                                        i17 = i6;
                                        if (i37 == 5) {
                                            v1.f3953f.p(t4, C, Float.intBitsToFloat(b.O(bArr2, i5)));
                                            i22 = i5 + 4;
                                            i28 = i22;
                                            i34 |= i21;
                                            break;
                                        }
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 2:
                                    case 3:
                                        fVar2 = fVar;
                                        i18 = i7;
                                        i19 = i36;
                                        i17 = i6;
                                        j3 = C;
                                        if (i37 == 0) {
                                            i23 = b.j0(bArr2, i5, fVar2);
                                            j2 = fVar2.b;
                                            unsafe2.putLong(t, j3, j2);
                                            i34 |= i21;
                                            i28 = i23;
                                            break;
                                        }
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 4:
                                    case 11:
                                        fVar2 = fVar;
                                        i18 = i7;
                                        i19 = i36;
                                        i17 = i6;
                                        if (i37 == 0) {
                                            i28 = b.h0(bArr2, i5, fVar2);
                                            i24 = fVar2.a;
                                            j4 = C;
                                            unsafe2.putInt(t4, j4, i24);
                                            i34 |= i21;
                                            break;
                                        }
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 5:
                                    case 14:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 1) {
                                            fVar2 = fVar3;
                                            i17 = i25;
                                            unsafe2.putLong(t, C, b.P(bArr2, i5));
                                            i22 = i5 + 8;
                                            i28 = i22;
                                            i34 |= i21;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 6:
                                    case 13:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 5) {
                                            unsafe2.putInt(t4, C, b.O(bArr2, i5));
                                            i28 = i5 + 4;
                                            i34 |= i21;
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 7:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 0) {
                                            i28 = b.j0(bArr2, i5, fVar3);
                                            v1.f3953f.m(t4, C, fVar3.b != 0);
                                            i34 |= i21;
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 8:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 2) {
                                            i28 = (536870912 & i39) == 0 ? b.d0(bArr2, i5, fVar3) : b.e0(bArr2, i5, fVar3);
                                            obj = fVar3.c;
                                            j5 = C;
                                            unsafe2.putObject(t4, j5, obj);
                                            i34 |= i21;
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 9:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        j5 = C;
                                        fVar3 = fVar;
                                        if (i37 == 2) {
                                            i28 = b.R(v0Var3.p(i18), bArr2, i5, i27, fVar3);
                                            obj = (i34 & i21) == 0 ? fVar3.c : c0.c(unsafe2.getObject(t4, j5), fVar3.c);
                                            unsafe2.putObject(t4, j5, obj);
                                            i34 |= i21;
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 10:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 2) {
                                            i28 = b.M(bArr2, i5, fVar3);
                                            unsafe2.putObject(t4, C, fVar3.c);
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            i34 |= i21;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 12:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        j6 = C;
                                        fVar3 = fVar;
                                        if (i37 == 0) {
                                            i28 = b.h0(bArr2, i5, fVar3);
                                            i24 = fVar3.a;
                                            c0.e n = v0Var3.n(i18);
                                            if (n != null && !n.isInRange(i24)) {
                                                q(t).f(i25, Long.valueOf((long) i24));
                                                i17 = i25;
                                                fVar2 = fVar3;
                                                break;
                                            }
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            j4 = j6;
                                            unsafe2.putInt(t4, j4, i24);
                                            i34 |= i21;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 15:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        j6 = C;
                                        fVar3 = fVar;
                                        if (i37 == 0) {
                                            i28 = b.h0(bArr2, i5, fVar3);
                                            i24 = k.b(fVar3.a);
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            j4 = j6;
                                            unsafe2.putInt(t4, j4, i24);
                                            i34 |= i21;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 16:
                                        i18 = i7;
                                        i19 = i36;
                                        i25 = i6;
                                        fVar3 = fVar;
                                        if (i37 == 0) {
                                            i23 = b.j0(bArr2, i5, fVar3);
                                            j2 = k.c(fVar3.b);
                                            i17 = i25;
                                            fVar2 = fVar3;
                                            j3 = C;
                                            unsafe2.putLong(t, j3, j2);
                                            i34 |= i21;
                                            i28 = i23;
                                            break;
                                        }
                                        i17 = i25;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                    case 17:
                                        if (i37 == 3) {
                                            i18 = i7;
                                            i19 = i36;
                                            i28 = b.Q(v0Var3.p(i7), bArr, i5, i3, (i36 << 3) | 4, fVar);
                                            if ((i34 & i21) == 0) {
                                                j7 = C;
                                                obj2 = fVar.c;
                                            } else {
                                                j7 = C;
                                                obj2 = c0.c(unsafe2.getObject(t4, j7), fVar.c);
                                            }
                                            unsafe2.putObject(t4, j7, obj2);
                                            i34 |= i21;
                                            fVar2 = fVar;
                                            i17 = i6;
                                            break;
                                        } else {
                                            i18 = i7;
                                            i19 = i36;
                                            i25 = i6;
                                            fVar3 = fVar;
                                            i17 = i25;
                                            i15 = i5;
                                            i12 = i33;
                                            i10 = i34;
                                            unsafe = unsafe2;
                                            i11 = i19;
                                            i9 = i18;
                                            i13 = i17;
                                            i14 = i4;
                                            break;
                                        }
                                    default:
                                        i18 = i7;
                                        i19 = i36;
                                        i17 = i6;
                                        i15 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                        i13 = i17;
                                        i14 = i4;
                                        break;
                                }
                                i32 = i17;
                                i29 = i4;
                                i30 = i19;
                                i31 = i18;
                                fVar4 = fVar2;
                                i27 = i3;
                            } else {
                                fVar2 = fVar;
                                i18 = i7;
                                i19 = i36;
                                i17 = i6;
                                if (W == 27) {
                                    if (i37 == 2) {
                                        c0.i iVar = (c0.i) unsafe2.getObject(t4, C);
                                        if (!iVar.g()) {
                                            int size = iVar.size();
                                            iVar = iVar.d(size == 0 ? 10 : size * 2);
                                            unsafe2.putObject(t4, C, iVar);
                                        }
                                        i28 = b.S(v0Var3.p(i18), i17, bArr, i5, i3, iVar, fVar);
                                        i32 = i17;
                                        i29 = i4;
                                        i30 = i19;
                                        i31 = i18;
                                        fVar4 = fVar2;
                                        i27 = i3;
                                    } else {
                                        i20 = i5;
                                        i12 = i33;
                                        i10 = i34;
                                        unsafe = unsafe2;
                                        i11 = i19;
                                        i9 = i18;
                                    }
                                } else if (W <= 49) {
                                    i12 = i33;
                                    i10 = i34;
                                    unsafe = unsafe2;
                                    i11 = i19;
                                    i9 = i18;
                                    i28 = M(t, bArr, i5, i3, i17, i19, i37, i18, (long) i39, W, C, fVar);
                                } else {
                                    i20 = i5;
                                    i12 = i33;
                                    i10 = i34;
                                    unsafe = unsafe2;
                                    i11 = i19;
                                    i9 = i18;
                                    if (W != 50) {
                                        i28 = J(t, bArr, i20, i3, i17, i11, i37, i39, W, C, i9, fVar);
                                    } else if (i37 == 2) {
                                        i28 = I(t, bArr, i20, i3, i9, C, fVar);
                                    }
                                }
                                i13 = i17;
                                i14 = i4;
                                i15 = i20;
                            }
                        }
                        if (i13 == i14 || i14 == 0) {
                            v0Var2 = this;
                            if (!v0Var2.f3944f) {
                                fVar4 = fVar;
                                if (fVar4.f3862d != r.a()) {
                                    t0 t0Var = v0Var2.f3943e;
                                    r1<?, ?> r1Var = v0Var2.o;
                                    i16 = i11;
                                    z.e<?, ?> eVar = fVar4.f3862d.a.get(new r.a(t0Var, i16));
                                    if (eVar == null) {
                                        i28 = b.f0(i13, bArr, i15, i3, q(t), fVar);
                                        t3 = t;
                                    } else {
                                        t3 = t;
                                        z.c cVar = (z.c) t3;
                                        cVar.b();
                                        i28 = b.N(i13, bArr, i15, i3, cVar, eVar, r1Var, fVar);
                                    }
                                    i29 = i14;
                                    i33 = i12;
                                    i34 = i10;
                                    i31 = i9;
                                    i32 = i13;
                                    v0Var3 = v0Var2;
                                    i30 = i16;
                                    t4 = t3;
                                    unsafe2 = unsafe;
                                    bArr2 = bArr;
                                    i27 = i3;
                                } else {
                                    t3 = t;
                                }
                            } else {
                                t3 = t;
                                fVar4 = fVar;
                            }
                            i16 = i11;
                            i28 = b.f0(i13, bArr, i15, i3, q(t), fVar);
                            i29 = i14;
                            i33 = i12;
                            i34 = i10;
                            i31 = i9;
                            i32 = i13;
                            v0Var3 = v0Var2;
                            i30 = i16;
                            t4 = t3;
                            unsafe2 = unsafe;
                            bArr2 = bArr;
                            i27 = i3;
                        } else {
                            v0Var = this;
                            t2 = t;
                            i28 = i15;
                            i29 = i14;
                            i32 = i13;
                            i33 = i12;
                            i34 = i10;
                        }
                    } else {
                        i26 = v0Var3.V(i36, i38);
                    }
                } else {
                    i26 = v0Var3.N(i36);
                }
                i7 = i26;
                i8 = -1;
                if (i7 != i8) {
                }
                if (i13 == i14) {
                }
                v0Var2 = this;
                if (!v0Var2.f3944f) {
                }
                i16 = i11;
                i28 = b.f0(i13, bArr, i15, i3, q(t), fVar);
                i29 = i14;
                i33 = i12;
                i34 = i10;
                i31 = i9;
                i32 = i13;
                v0Var3 = v0Var2;
                i30 = i16;
                t4 = t3;
                unsafe2 = unsafe;
                bArr2 = bArr;
                i27 = i3;
            } else {
                unsafe = unsafe2;
                t2 = t4;
                v0Var = v0Var3;
            }
        }
        if (i33 != -1) {
            unsafe.putInt(t2, (long) i33, i34);
        }
        s1 s1Var = null;
        for (int i43 = v0Var.f3949k; i43 < v0Var.f3950l; i43++) {
            s1Var = (s1) v0Var.m(t2, v0Var.f3948j[i43], s1Var, v0Var.o);
        }
        if (s1Var != null) {
            v0Var.o.n(t2, s1Var);
        }
        if (i29 == 0) {
            if (i28 != i3) {
                throw d0.g();
            }
        } else if (i28 > i3 || i32 != i29) {
            throw d0.g();
        }
        return i28;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        if (r3 == 0) goto L_0x00f6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01a9, code lost:
        if (r1 != r9) goto L_0x01fe;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01c6, code lost:
        if (r1 != r9) goto L_0x01fe;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01ea, code lost:
        if (r1 != r9) goto L_0x01fe;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ed, code lost:
        r16 = r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int L(T t, byte[] bArr, int i2, int i3, f fVar) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        long j2;
        int i11;
        Object obj;
        int i12;
        Unsafe unsafe = s;
        int i13 = -1;
        v0<T> v0Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i14 = i2;
        int i15 = i3;
        f fVar2 = fVar;
        int i16 = -1;
        int i17 = 0;
        while (i14 < i15) {
            int i18 = i14 + 1;
            byte b = bArr2[i14];
            int i19 = b;
            if (b < 0) {
                i18 = b.g0(b, bArr2, i18, fVar2);
                i19 = fVar2.a;
            }
            int i20 = (i19 == 1 ? 1 : 0) >>> 3;
            int i21 = (i19 == 1 ? 1 : 0) & 7;
            if (i20 > i16) {
                int i22 = i17 / 3;
                if (i20 < v0Var.c || i20 > v0Var.f3942d) {
                    i4 = -1;
                    if (i4 != i13) {
                        i5 = i20;
                        i7 = i18;
                        i4 = 0;
                    } else {
                        int i23 = v0Var.a[i4 + 1];
                        int W = W(i23);
                        long C = C(i23);
                        if (W <= 17) {
                            boolean z = true;
                            switch (W) {
                                case 0:
                                    i9 = i4;
                                    if (i21 == 1) {
                                        v1.v(t2, C, Double.longBitsToDouble(b.P(bArr2, i18)));
                                        i14 = i18 + 8;
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i5 = i20;
                                    i4 = i9;
                                    i8 = i18;
                                    break;
                                case 1:
                                    i9 = i4;
                                    if (i21 == 5) {
                                        v1.f3953f.p(t2, C, Float.intBitsToFloat(b.O(bArr2, i18)));
                                        i14 = i18 + 4;
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i5 = i20;
                                    i4 = i9;
                                    i8 = i18;
                                    break;
                                case 2:
                                case 3:
                                    i9 = i4;
                                    if (i21 == 0) {
                                        i10 = b.j0(bArr2, i18, fVar2);
                                        j2 = fVar2.b;
                                        unsafe.putLong(t, C, j2);
                                        i14 = i10;
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i5 = i20;
                                    i4 = i9;
                                    i8 = i18;
                                    break;
                                case 4:
                                case 11:
                                    i9 = i4;
                                    break;
                                case 5:
                                case 14:
                                    if (i21 == 1) {
                                        i9 = i4;
                                        unsafe.putLong(t, C, b.P(bArr2, i18));
                                        i14 = i18 + 8;
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 6:
                                case 13:
                                    if (i21 == 5) {
                                        unsafe.putInt(t2, C, b.O(bArr2, i18));
                                        i14 = i18 + 4;
                                        i5 = i20;
                                        bArr2 = bArr2;
                                        i17 = i4;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 7:
                                    if (i21 == 0) {
                                        i14 = b.j0(bArr2, i18, fVar2);
                                        if (fVar2.b == 0) {
                                            z = false;
                                        }
                                        v1.f3953f.m(t2, C, z);
                                        i5 = i20;
                                        bArr2 = bArr2;
                                        i17 = i4;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 8:
                                    if (i21 == 2) {
                                        i14 = (536870912 & i23) == 0 ? b.d0(bArr2, i18, fVar2) : b.e0(bArr2, i18, fVar2);
                                        obj = fVar2.c;
                                        unsafe.putObject(t2, C, obj);
                                        i5 = i20;
                                        bArr2 = bArr2;
                                        i17 = i4;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 9:
                                    if (i21 == 2) {
                                        i14 = b.R(v0Var.p(i4), bArr2, i18, i15, fVar2);
                                        Object object = unsafe.getObject(t2, C);
                                        if (object != null) {
                                            obj = c0.c(object, fVar2.c);
                                            unsafe.putObject(t2, C, obj);
                                            i5 = i20;
                                            bArr2 = bArr2;
                                            i17 = i4;
                                            break;
                                        }
                                        obj = fVar2.c;
                                        unsafe.putObject(t2, C, obj);
                                        i5 = i20;
                                        bArr2 = bArr2;
                                        i17 = i4;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 10:
                                    if (i21 == 2) {
                                        i14 = b.M(bArr2, i18, fVar2);
                                        obj = fVar2.c;
                                        unsafe.putObject(t2, C, obj);
                                        i5 = i20;
                                        bArr2 = bArr2;
                                        i17 = i4;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                case 12:
                                    if (i21 == 0) {
                                        i9 = i4;
                                        i14 = b.h0(bArr2, i18, fVar2);
                                        i11 = fVar2.a;
                                        unsafe.putInt(t2, C, i11);
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i9 = i4;
                                    i5 = i20;
                                    i4 = i9;
                                    i8 = i18;
                                    break;
                                case 15:
                                    if (i21 == 0) {
                                        i14 = b.h0(bArr2, i18, fVar2);
                                        i11 = k.b(fVar2.a);
                                        i9 = i4;
                                        unsafe.putInt(t2, C, i11);
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i9 = i4;
                                    i5 = i20;
                                    i4 = i9;
                                    i8 = i18;
                                    break;
                                case 16:
                                    if (i21 == 0) {
                                        i10 = b.j0(bArr2, i18, fVar2);
                                        j2 = k.c(fVar2.b);
                                        i9 = i4;
                                        unsafe.putLong(t, C, j2);
                                        i14 = i10;
                                        i5 = i20;
                                        i17 = i9;
                                        break;
                                    }
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                                default:
                                    i5 = i20;
                                    i8 = i18;
                                    break;
                            }
                            i16 = i5;
                            i13 = -1;
                            bArr2 = bArr2;
                        } else if (W == 27) {
                            if (i21 == 2) {
                                c0.i iVar = (c0.i) unsafe.getObject(t2, C);
                                if (!iVar.g()) {
                                    int size = iVar.size();
                                    iVar = iVar.d(size == 0 ? 10 : size * 2);
                                    unsafe.putObject(t2, C, iVar);
                                }
                                i5 = i20;
                                i14 = b.S(v0Var.p(i4), i19, bArr, i18, i3, iVar, fVar);
                                bArr2 = bArr2;
                                i17 = i4;
                                i16 = i5;
                                i13 = -1;
                                bArr2 = bArr2;
                            }
                            i5 = i20;
                            i8 = i18;
                        } else {
                            i5 = i20;
                            i8 = i18;
                            if (W <= 49) {
                                i6 = M(t, bArr, i8, i3, i19, i5, i21, i4, (long) i23, W, C, fVar);
                            } else if (W != 50) {
                                i6 = J(t, bArr, i8, i3, i19, i5, i21, i23, W, C, i4, fVar);
                            } else if (i21 == 2) {
                                i6 = I(t, bArr, i8, i3, i4, C, fVar);
                            }
                            i17 = i4;
                            i16 = i5;
                            i13 = -1;
                            bArr2 = bArr2;
                        }
                        i7 = i8;
                    }
                    i6 = b.f0(i19, bArr, i7, i3, q(t), fVar);
                    v0Var = this;
                    t2 = t;
                    bArr2 = bArr;
                    i15 = i3;
                    fVar2 = fVar;
                    i14 = i6;
                    i17 = i4;
                    i16 = i5;
                    i13 = -1;
                    bArr2 = bArr2;
                } else {
                    i12 = v0Var.V(i20, i22);
                }
            } else {
                i12 = v0Var.N(i20);
            }
            i4 = i12;
            if (i4 != i13) {
            }
            i6 = b.f0(i19, bArr, i7, i3, q(t), fVar);
            v0Var = this;
            t2 = t;
            bArr2 = bArr;
            i15 = i3;
            fVar2 = fVar;
            i14 = i6;
            i17 = i4;
            i16 = i5;
            i13 = -1;
            bArr2 = bArr2;
        }
        if (i14 == i15) {
            return i14;
        }
        throw d0.g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:121:0x0235, code lost:
        if (r32.b != 0) goto L_0x0252;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0238, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0239, code lost:
        r12.i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x023c, code lost:
        if (r1 >= r22) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x023e, code lost:
        r4 = f.b.a.c.b.o.b.h0(r3, r1, r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0244, code lost:
        if (r2 == r32.a) goto L_0x0248;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0248, code lost:
        r1 = f.b.a.c.b.o.b.j0(r3, r4, r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0250, code lost:
        if (r32.b == 0) goto L_0x0238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0252, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:?, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0110, code lost:
        if (r4 == 0) goto L_0x0135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0113, code lost:
        r12.add(f.b.g.j.m(r3, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x011b, code lost:
        if (r1 >= r22) goto L_?;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x011d, code lost:
        r4 = f.b.a.c.b.o.b.h0(r3, r1, r32);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0123, code lost:
        if (r2 == r32.a) goto L_0x0127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0127, code lost:
        r1 = f.b.a.c.b.o.b.h0(r3, r4, r32);
        r4 = r32.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x012d, code lost:
        if (r4 < 0) goto L_0x0140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0131, code lost:
        if (r4 > (r3.length - r1)) goto L_0x013b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0133, code lost:
        if (r4 != 0) goto L_0x0113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0135, code lost:
        r12.add(f.b.g.j.c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013f, code lost:
        throw f.b.g.d0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0144, code lost:
        throw f.b.g.d0.f();
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018e  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int M(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, f fVar) {
        int j0;
        byte[] bArr2;
        int i9;
        String str;
        int i10;
        int i11;
        String str2;
        int i12;
        int h0;
        int j02;
        byte[] bArr3 = bArr;
        int i13 = i2;
        int i14 = i4;
        Unsafe unsafe = s;
        c0.i iVar = (c0.i) unsafe.getObject(t, j3);
        if (!iVar.g()) {
            int size = iVar.size();
            iVar = iVar.d(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j3, iVar);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    return b.U(bArr3, i13, iVar, fVar);
                }
                if (i6 == 1) {
                    o oVar = (o) iVar;
                    long P = b.P(bArr, i2);
                    while (true) {
                        oVar.i(Double.longBitsToDouble(P));
                        int i15 = i13 + 8;
                        if (i15 >= i3) {
                            return i15;
                        }
                        i13 = b.h0(bArr3, i15, fVar);
                        if (i14 != fVar.a) {
                            return i15;
                        }
                        P = b.P(bArr3, i13);
                    }
                }
                break;
            case 19:
            case 36:
                if (i6 == 2) {
                    return b.X(bArr3, i13, iVar, fVar);
                }
                if (i6 == 5) {
                    x xVar = (x) iVar;
                    int O = b.O(bArr, i2);
                    while (true) {
                        xVar.i(Float.intBitsToFloat(O));
                        int i16 = i13 + 4;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i13 = b.h0(bArr3, i16, fVar);
                        if (i14 != fVar.a) {
                            return i16;
                        }
                        O = b.O(bArr3, i13);
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    return b.b0(bArr3, i13, iVar, fVar);
                }
                if (i6 == 0) {
                    k0 k0Var = (k0) iVar;
                    do {
                        j0 = b.j0(bArr3, i13, fVar);
                        k0Var.i(fVar.b);
                        if (j0 >= i3) {
                            return j0;
                        }
                        i13 = b.h0(bArr3, j0, fVar);
                    } while (i14 == fVar.a);
                    return j0;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return b.a0(bArr3, i13, iVar, fVar);
                }
                if (i6 == 0) {
                    return b.i0(i4, bArr, i2, i3, iVar, fVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    return b.W(bArr3, i13, iVar, fVar);
                }
                if (i6 == 1) {
                    k0 k0Var2 = (k0) iVar;
                    long P2 = b.P(bArr, i2);
                    while (true) {
                        k0Var2.i(P2);
                        int i17 = i13 + 8;
                        if (i17 >= i3) {
                            return i17;
                        }
                        i13 = b.h0(bArr3, i17, fVar);
                        if (i14 != fVar.a) {
                            return i17;
                        }
                        P2 = b.P(bArr3, i13);
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    return b.V(bArr3, i13, iVar, fVar);
                }
                if (i6 == 5) {
                    b0 b0Var = (b0) iVar;
                    int O2 = b.O(bArr, i2);
                    while (true) {
                        b0Var.i(O2);
                        int i18 = i13 + 4;
                        if (i18 >= i3) {
                            return i18;
                        }
                        i13 = b.h0(bArr3, i18, fVar);
                        if (i14 != fVar.a) {
                            return i18;
                        }
                        O2 = b.O(bArr3, i13);
                    }
                }
                break;
            case 25:
            case 42:
                if (i6 != 2) {
                    if (i6 == 0) {
                        h hVar = (h) iVar;
                        int j03 = b.j0(bArr3, i13, fVar);
                        break;
                    }
                } else {
                    return b.T(bArr3, i13, iVar, fVar);
                }
                break;
            case 26:
                if (i6 == 2) {
                    String str3 = "";
                    if ((j2 & 536870912) == 0) {
                        i13 = b.h0(bArr3, i13, fVar);
                        int i19 = fVar.a;
                        if (i19 >= 0) {
                            if (i19 != 0) {
                                String str4 = new String(bArr3, i13, i19, c0.a);
                                iVar.add(str4);
                                i13 += i19;
                                if (i13 < i3) {
                                    int h02 = b.h0(bArr3, i13, fVar);
                                    if (i14 == fVar.a) {
                                        i13 = b.h0(bArr3, h02, fVar);
                                        i19 = fVar.a;
                                        if (i19 < 0) {
                                            throw d0.f();
                                        } else if (i19 != 0) {
                                            str4 = new String(bArr3, i13, i19, c0.a);
                                            iVar.add(str4);
                                            i13 += i19;
                                            if (i13 < i3) {
                                            }
                                        }
                                    }
                                }
                            }
                            iVar.add(str3);
                            if (i13 < i3) {
                            }
                        } else {
                            throw d0.f();
                        }
                    } else {
                        int h03 = b.h0(bArr3, i13, fVar);
                        int i20 = fVar.a;
                        if (i20 < 0) {
                            throw d0.f();
                        } else if (i20 == 0) {
                            str = str3;
                            i10 = h03;
                            bArr2 = bArr3;
                            i9 = i14;
                            iVar.add(str);
                            if (i10 >= i3) {
                                int h04 = b.h0(bArr2, i10, fVar);
                                if (i9 != fVar.a) {
                                    return i10;
                                }
                                i10 = b.h0(bArr2, h04, fVar);
                                int i21 = fVar.a;
                                if (i21 < 0) {
                                    throw d0.f();
                                }
                                if (i21 != 0) {
                                    i11 = i10 + i21;
                                    if (w1.h(bArr2, i10, i11)) {
                                        str2 = new String(bArr2, i10, i21, c0.a);
                                        str3 = str;
                                        i14 = i9;
                                        bArr3 = bArr2;
                                        iVar.add(str2);
                                        bArr2 = bArr3;
                                        i9 = i14;
                                        str = str3;
                                        i10 = i11;
                                        if (i10 >= i3) {
                                            return i10;
                                        }
                                    } else {
                                        throw d0.c();
                                    }
                                }
                                iVar.add(str);
                                if (i10 >= i3) {
                                }
                            }
                        } else {
                            i11 = h03 + i20;
                            if (w1.h(bArr3, h03, i11)) {
                                str2 = new String(bArr3, h03, i20, c0.a);
                                iVar.add(str2);
                                bArr2 = bArr3;
                                i9 = i14;
                                str = str3;
                                i10 = i11;
                                if (i10 >= i3) {
                                }
                            } else {
                                throw d0.c();
                            }
                        }
                    }
                }
                break;
            case 27:
                if (i6 == 2) {
                    return b.S(p(i7), i4, bArr, i2, i3, iVar, fVar);
                }
                break;
            case 28:
                if (i6 == 2) {
                    int h05 = b.h0(bArr3, i13, fVar);
                    int i22 = fVar.a;
                    if (i22 < 0) {
                        throw d0.f();
                    } else if (i22 > bArr3.length - h05) {
                        throw d0.h();
                    }
                }
                break;
            case 30:
            case 44:
                if (i6 == 2) {
                    i12 = b.a0(bArr3, i13, iVar, fVar);
                } else if (i6 == 0) {
                    i12 = b.i0(i4, bArr, i2, i3, iVar, fVar);
                }
                z zVar = (z) t;
                s1 s1Var = zVar.unknownFields;
                if (s1Var == s1.f3937f) {
                    s1Var = null;
                }
                s1 s1Var2 = (s1) l1.z(i5, iVar, (c0.e) this.b[((i7 / 3) * 2) + 1], s1Var, this.o);
                if (s1Var2 != null) {
                    zVar.unknownFields = s1Var2;
                }
                return i12;
            case 33:
            case 47:
                if (i6 == 2) {
                    return b.Y(bArr3, i13, iVar, fVar);
                }
                if (i6 == 0) {
                    b0 b0Var2 = (b0) iVar;
                    do {
                        h0 = b.h0(bArr3, i13, fVar);
                        b0Var2.i(k.b(fVar.a));
                        if (h0 >= i3) {
                            return h0;
                        }
                        i13 = b.h0(bArr3, h0, fVar);
                    } while (i14 == fVar.a);
                    return h0;
                }
                break;
            case 34:
            case 48:
                if (i6 == 2) {
                    return b.Z(bArr3, i13, iVar, fVar);
                }
                if (i6 == 0) {
                    k0 k0Var3 = (k0) iVar;
                    do {
                        j02 = b.j0(bArr3, i13, fVar);
                        k0Var3.i(k.c(fVar.b));
                        if (j02 >= i3) {
                            return j02;
                        }
                        i13 = b.h0(bArr3, j02, fVar);
                    } while (i14 == fVar.a);
                    return j02;
                }
                break;
            case 49:
                if (i6 == 3) {
                    j1 p = p(i7);
                    int i23 = (i14 & -8) | 4;
                    i13 = b.Q(p, bArr, i2, i3, i23, fVar);
                    while (true) {
                        iVar.add(fVar.c);
                        if (i13 >= i3) {
                            break;
                        } else {
                            int h06 = b.h0(bArr3, i13, fVar);
                            if (i14 != fVar.a) {
                                break;
                            } else {
                                i13 = b.Q(p, bArr, h06, i3, i23, fVar);
                            }
                        }
                    }
                }
                break;
        }
        return i13;
    }

    public final int N(int i2) {
        if (i2 < this.c || i2 > this.f3942d) {
            return -1;
        }
        return V(i2, 0);
    }

    public final <E> void O(Object obj, long j2, h1 h1Var, j1<E> j1Var, r rVar) {
        h1Var.s(this.n.c(obj, j2), j1Var, rVar);
    }

    public final <E> void P(Object obj, int i2, h1 h1Var, j1<E> j1Var, r rVar) {
        h1Var.K(this.n.c(obj, C(i2)), j1Var, rVar);
    }

    public final void Q(Object obj, int i2, h1 h1Var) {
        Object obj2;
        long j2;
        if ((536870912 & i2) != 0) {
            j2 = C(i2);
            obj2 = h1Var.E();
        } else if (this.f3945g) {
            j2 = C(i2);
            obj2 = h1Var.C();
        } else {
            j2 = C(i2);
            obj2 = h1Var.e();
        }
        v1.f3953f.s(obj, j2, obj2);
    }

    public final void R(Object obj, int i2, h1 h1Var) {
        if ((536870912 & i2) != 0) {
            h1Var.c(this.n.c(obj, C(i2)));
        } else {
            h1Var.N(this.n.c(obj, C(i2)));
        }
    }

    public final void T(T t, int i2) {
        if (!this.f3946h) {
            int i3 = this.a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            v1.f3953f.q(t, j2, v1.n(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void U(T t, int i2, int i3) {
        v1.f3953f.q(t, (long) (this.a[i3 + 2] & 1048575), i2);
    }

    public final int V(int i2, int i3) {
        int length = (this.a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.a[i5];
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

    public final int X(int i2) {
        return this.a[i2 + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0534  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void Y(T t, a2 a2Var) {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i2;
        Map.Entry<?, Object> entry2;
        int i3;
        if (this.f3944f) {
            v<?> c = this.p.c(t);
            if (!c.i()) {
                it = c.l();
                entry = it.next();
                int i4 = -1;
                length = this.a.length;
                Unsafe unsafe = s;
                i2 = 0;
                int i5 = 0;
                while (i2 < length) {
                    int X = X(i2);
                    int i6 = this.a[i2];
                    int W = W(X);
                    if (this.f3946h || W > 17) {
                        entry2 = entry;
                        i3 = 0;
                    } else {
                        int i7 = this.a[i2 + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i4) {
                            i5 = unsafe.getInt(t, (long) i8);
                            i4 = i8;
                        }
                        i3 = 1 << (i7 >>> 20);
                        entry2 = entry;
                    }
                    while (entry2 != null && this.p.a(entry2) <= i6) {
                        this.p.j(a2Var, entry2);
                        entry2 = it.hasNext() ? it.next() : null;
                    }
                    long C = C(X);
                    switch (W) {
                        case 0:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a(i6, v1.l(t, C));
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 1:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).b(i6, v1.m(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 2:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.b0(i6, unsafe.getLong(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 3:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.b0(i6, unsafe.getLong(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 4:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.Q(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 5:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.O(i6, unsafe.getLong(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 6:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.M(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 7:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.I(i6, v1.g(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 8:
                            if ((i3 & i5) != 0) {
                                a0(i6, unsafe.getObject(t, C), a2Var);
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 9:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).d(i6, unsafe.getObject(t, C), p(i2));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 10:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.K(i6, (j) unsafe.getObject(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 11:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.Z(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 12:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.Q(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 13:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.M(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 14:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).a.O(i6, unsafe.getLong(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 15:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).f(i6, unsafe.getInt(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 16:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).g(i6, unsafe.getLong(t, C));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 17:
                            if ((i3 & i5) != 0) {
                                ((n) a2Var).c(i6, unsafe.getObject(t, C), p(i2));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 18:
                            l1.G(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 19:
                            l1.K(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 20:
                            l1.N(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 21:
                            l1.V(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 22:
                            l1.M(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 23:
                            l1.J(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 24:
                            l1.I(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 25:
                            l1.E(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 26:
                            l1.T(this.a[i2], (List) unsafe.getObject(t, C), a2Var);
                            break;
                        case 27:
                            l1.O(this.a[i2], (List) unsafe.getObject(t, C), a2Var, p(i2));
                            break;
                        case 28:
                            l1.F(this.a[i2], (List) unsafe.getObject(t, C), a2Var);
                            break;
                        case 29:
                            l1.U(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 30:
                            l1.H(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 31:
                            l1.P(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 32:
                            l1.Q(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 33:
                            l1.R(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 34:
                            l1.S(this.a[i2], (List) unsafe.getObject(t, C), a2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 35:
                            l1.G(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 36:
                            l1.K(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 37:
                            l1.N(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 38:
                            l1.V(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 39:
                            l1.M(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 40:
                            l1.J(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 41:
                            l1.I(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 42:
                            l1.E(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 43:
                            l1.U(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 44:
                            l1.H(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 45:
                            l1.P(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 46:
                            l1.Q(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 47:
                            l1.R(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 48:
                            l1.S(this.a[i2], (List) unsafe.getObject(t, C), a2Var, true);
                            break;
                        case 49:
                            l1.L(this.a[i2], (List) unsafe.getObject(t, C), a2Var, p(i2));
                            break;
                        case 50:
                            Z(a2Var, i6, unsafe.getObject(t, C), i2);
                            break;
                        case 51:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a(i6, E(t, C));
                                break;
                            }
                            break;
                        case 52:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).b(i6, F(t, C));
                                break;
                            }
                            break;
                        case 53:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.b0(i6, H(t, C));
                                break;
                            }
                            break;
                        case 54:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.b0(i6, H(t, C));
                                break;
                            }
                            break;
                        case 55:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.Q(i6, G(t, C));
                                break;
                            }
                            break;
                        case 56:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.O(i6, H(t, C));
                                break;
                            }
                            break;
                        case 57:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.M(i6, G(t, C));
                                break;
                            }
                            break;
                        case 58:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.I(i6, D(t, C));
                                break;
                            }
                            break;
                        case 59:
                            if (v(t, i6, i2)) {
                                a0(i6, unsafe.getObject(t, C), a2Var);
                                break;
                            }
                            break;
                        case 60:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).d(i6, unsafe.getObject(t, C), p(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.K(i6, (j) unsafe.getObject(t, C));
                                break;
                            }
                            break;
                        case 62:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.Z(i6, G(t, C));
                                break;
                            }
                            break;
                        case 63:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.Q(i6, G(t, C));
                                break;
                            }
                            break;
                        case 64:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.M(i6, G(t, C));
                                break;
                            }
                            break;
                        case 65:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).a.O(i6, H(t, C));
                                break;
                            }
                            break;
                        case 66:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).f(i6, G(t, C));
                                break;
                            }
                            break;
                        case 67:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).g(i6, H(t, C));
                                break;
                            }
                            break;
                        case 68:
                            if (v(t, i6, i2)) {
                                ((n) a2Var).c(i6, unsafe.getObject(t, C), p(i2));
                                break;
                            }
                            break;
                    }
                    i2 += 3;
                    i4 = i4;
                    entry = entry2;
                }
                while (entry != null) {
                    this.p.j(a2Var, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                r1<?, ?> r1Var = this.o;
                r1Var.s(r1Var.g(t), a2Var);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.a.length;
        Unsafe unsafe2 = s;
        i2 = 0;
        int i52 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        r1<?, ?> r1Var2 = this.o;
        r1Var2.s(r1Var2.g(t), a2Var);
    }

    public final <K, V> void Z(a2 a2Var, int i2, Object obj, int i3) {
        if (obj != null) {
            m0.a<?, ?> h2 = this.q.h(this.b[(i3 / 3) * 2]);
            Map<?, ?> b = this.q.b(obj);
            n nVar = (n) a2Var;
            Objects.requireNonNull(nVar.a);
            for (Map.Entry<?, ?> entry : b.entrySet()) {
                nVar.a.Y(i2, 2);
                nVar.a.a0(m0.a(h2, entry.getKey(), entry.getValue()));
                m mVar = nVar.a;
                Object key = entry.getKey();
                Object value = entry.getValue();
                v.q(mVar, h2.a, 1, key);
                v.q(mVar, h2.c, 2, value);
            }
        }
    }

    @Override // f.b.g.j1
    public void a(T t, T t2) {
        Objects.requireNonNull(t2);
        int i2 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i2 < iArr.length) {
                int i3 = iArr[i2 + 1];
                long C = C(i3);
                int i4 = this.a[i2];
                switch (W(i3)) {
                    case 0:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            v1.v(t, C, v1.l(t2, C));
                            T(t, i2);
                            break;
                        }
                    case 1:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            v1.f3953f.p(t, C, v1.m(t2, C));
                            T(t, i2);
                            break;
                        }
                    case 2:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.y(t, C, v1.o(t2, C));
                        T(t, i2);
                        break;
                    case 3:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.y(t, C, v1.o(t2, C));
                        T(t, i2);
                        break;
                    case 4:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 5:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.y(t, C, v1.o(t2, C));
                        T(t, i2);
                        break;
                    case 6:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 7:
                        if (!t(t2, i2)) {
                            break;
                        } else {
                            v1.f3953f.m(t, C, v1.g(t2, C));
                            T(t, i2);
                            break;
                        }
                    case 8:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.s(t, C, v1.p(t2, C));
                        T(t, i2);
                        break;
                    case 9:
                    case 17:
                        y(t, t2, i2);
                        break;
                    case 10:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.s(t, C, v1.p(t2, C));
                        T(t, i2);
                        break;
                    case 11:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 12:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 13:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 14:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.y(t, C, v1.o(t2, C));
                        T(t, i2);
                        break;
                    case 15:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.f3953f.q(t, C, v1.n(t2, C));
                        T(t, i2);
                        break;
                    case 16:
                        if (!t(t2, i2)) {
                            break;
                        }
                        v1.y(t, C, v1.o(t2, C));
                        T(t, i2);
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
                        this.n.b(t, t2, C);
                        break;
                    case 50:
                        o0 o0Var = this.q;
                        Class<?> cls = l1.a;
                        v1.f3953f.s(t, C, o0Var.a(v1.p(t, C), v1.p(t2, C)));
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
                        if (!v(t2, i4, i2)) {
                            break;
                        }
                        v1.f3953f.s(t, C, v1.p(t2, C));
                        U(t, i4, i2);
                        break;
                    case 60:
                    case 68:
                        z(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!v(t2, i4, i2)) {
                            break;
                        }
                        v1.f3953f.s(t, C, v1.p(t2, C));
                        U(t, i4, i2);
                        break;
                }
                i2 += 3;
            } else {
                r1<?, ?> r1Var = this.o;
                Class<?> cls2 = l1.a;
                r1Var.o(t, r1Var.k(r1Var.g(t), r1Var.g(t2)));
                if (this.f3944f) {
                    l1.B(this.p, t, t2);
                    return;
                }
                return;
            }
        }
    }

    public final void a0(int i2, Object obj, a2 a2Var) {
        if (obj instanceof String) {
            ((n) a2Var).a.W(i2, (String) obj);
            return;
        }
        ((n) a2Var).a.K(i2, (j) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v16, types: [f.b.g.j1] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v3, types: [f.b.g.j1] */
    /* JADX WARN: Type inference failed for: r4v5, types: [f.b.g.j1] */
    /* JADX WARN: Type inference failed for: r4v6, types: [f.b.g.j1] */
    /* JADX WARN: Unknown variable types count: 1 */
    @Override // f.b.g.j1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean b(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.f3949k) {
                return !this.f3944f || this.p.c(t).j();
            }
            int i6 = this.f3948j[i4];
            int i7 = this.a[i6];
            int X = X(i6);
            if (!this.f3946h) {
                int i8 = this.a[i6 + 2];
                int i9 = 1048575 & i8;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = s.getInt(t, (long) i9);
                    i3 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & X) != 0) && !u(t, i6, i5, i2)) {
                return false;
            }
            int W = W(X);
            if (W != 9 && W != 17) {
                if (W != 27) {
                    if (W == 60 || W == 68) {
                        if (v(t, i7, i6) && !p(i6).b(v1.p(t, C(X)))) {
                            return false;
                        }
                    } else if (W != 49) {
                        if (W != 50) {
                            continue;
                        } else {
                            Map<?, ?> b = this.q.b(v1.p(t, C(X)));
                            if (!b.isEmpty()) {
                                if (this.q.h(this.b[(i6 / 3) * 2]).c.b == z1.MESSAGE) {
                                    j1<T> j1Var = 0;
                                    Iterator<?> it = b.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (j1Var == null) {
                                            j1Var = e1.c.a(next.getClass());
                                        }
                                        boolean b2 = j1Var.b(next);
                                        j1Var = j1Var;
                                        if (!b2) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) v1.p(t, C(X));
                if (!list.isEmpty()) {
                    ?? p = p(i6);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!p.b(list.get(i10))) {
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
            } else if (u(t, i6, i5, i2) && !p(i6).b(v1.p(t, C(X)))) {
                return false;
            }
            i4++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        r0 = r16.f3949k;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007b, code lost:
        if (r0 >= r16.f3950l) goto L_0x0088;
     */
    /* JADX WARN: Code restructure failed: missing block: B:336:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007d, code lost:
        r14 = m(r17, r16.f3948j[r0], r14, r11);
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0088, code lost:
        if (r14 == null) goto L_?;
     */
    @Override // f.b.g.j1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void c(T t, h1 h1Var, r rVar) {
        long C;
        Object valueOf;
        int g2;
        long C2;
        long D;
        long C3;
        int j2;
        Object c;
        long C4;
        Object P;
        j0 j0Var;
        long C5;
        j0 j0Var2;
        long C6;
        j0 j0Var3;
        long C7;
        j0 j0Var4;
        long C8;
        j0 j0Var5;
        long C9;
        j0 j0Var6;
        long C10;
        j0 j0Var7;
        long C11;
        j0 j0Var8;
        long C12;
        j0 j0Var9;
        long C13;
        List<Integer> c2;
        j0 j0Var10;
        long C14;
        j0 j0Var11;
        long C15;
        j0 j0Var12;
        long C16;
        j0 j0Var13;
        long C17;
        Objects.requireNonNull(rVar);
        r1 r1Var = this.o;
        s<?> sVar = this.p;
        Object obj = null;
        v<?> vVar = null;
        while (true) {
            try {
                int M = h1Var.M();
                int N = N(M);
                if (N >= 0) {
                    int X = X(N);
                    try {
                        switch (W(X)) {
                            case 0:
                                v1.v(t, C(X), h1Var.readDouble());
                                T(t, N);
                                break;
                            case 1:
                                v1.w(t, C(X), h1Var.readFloat());
                                T(t, N);
                                break;
                            case 2:
                                C2 = C(X);
                                D = h1Var.D();
                                v1.y(t, C2, D);
                                T(t, N);
                                break;
                            case 3:
                                C2 = C(X);
                                D = h1Var.l();
                                v1.y(t, C2, D);
                                T(t, N);
                                break;
                            case 4:
                                C3 = C(X);
                                j2 = h1Var.j();
                                v1.x(t, C3, j2);
                                T(t, N);
                                break;
                            case 5:
                                C2 = C(X);
                                D = h1Var.n();
                                v1.y(t, C2, D);
                                T(t, N);
                                break;
                            case 6:
                                C3 = C(X);
                                j2 = h1Var.F();
                                v1.x(t, C3, j2);
                                T(t, N);
                                break;
                            case 7:
                                v1.r(t, C(X), h1Var.J());
                                T(t, N);
                                break;
                            case 8:
                                Q(t, X, h1Var);
                                T(t, N);
                                break;
                            case 9:
                                if (t(t, N)) {
                                    c = c0.c(v1.p(t, C(X)), h1Var.P(p(N), rVar));
                                    v1.z(t, C(X), c);
                                    break;
                                } else {
                                    C4 = C(X);
                                    P = h1Var.P(p(N), rVar);
                                    v1.z(t, C4, P);
                                    T(t, N);
                                    break;
                                }
                            case 10:
                                C4 = C(X);
                                P = h1Var.e();
                                v1.z(t, C4, P);
                                T(t, N);
                                break;
                            case 11:
                                C3 = C(X);
                                j2 = h1Var.i();
                                v1.x(t, C3, j2);
                                T(t, N);
                                break;
                            case 12:
                                g2 = h1Var.g();
                                c0.e n = n(N);
                                if (n != null && !n.isInRange(g2)) {
                                    obj = l1.D(M, g2, obj, r1Var);
                                    break;
                                }
                                v1.x(t, C(X), g2);
                                T(t, N);
                                break;
                            case 13:
                                C3 = C(X);
                                j2 = h1Var.u();
                                v1.x(t, C3, j2);
                                T(t, N);
                                break;
                            case 14:
                                C2 = C(X);
                                D = h1Var.O();
                                v1.y(t, C2, D);
                                T(t, N);
                                break;
                            case 15:
                                C3 = C(X);
                                j2 = h1Var.q();
                                v1.x(t, C3, j2);
                                T(t, N);
                                break;
                            case 16:
                                C2 = C(X);
                                D = h1Var.t();
                                v1.y(t, C2, D);
                                T(t, N);
                                break;
                            case 17:
                                if (t(t, N)) {
                                    c = c0.c(v1.p(t, C(X)), h1Var.d(p(N), rVar));
                                    v1.z(t, C(X), c);
                                    break;
                                } else {
                                    C4 = C(X);
                                    P = h1Var.d(p(N), rVar);
                                    v1.z(t, C4, P);
                                    T(t, N);
                                    break;
                                }
                            case 18:
                                j0Var = this.n;
                                C5 = C(X);
                                h1Var.x(j0Var.c(t, C5));
                                break;
                            case 19:
                                j0Var2 = this.n;
                                C6 = C(X);
                                h1Var.h(j0Var2.c(t, C6));
                                break;
                            case 20:
                                j0Var3 = this.n;
                                C7 = C(X);
                                h1Var.z(j0Var3.c(t, C7));
                                break;
                            case 21:
                                j0Var4 = this.n;
                                C8 = C(X);
                                h1Var.b(j0Var4.c(t, C8));
                                break;
                            case 22:
                                j0Var5 = this.n;
                                C9 = C(X);
                                h1Var.H(j0Var5.c(t, C9));
                                break;
                            case 23:
                                j0Var6 = this.n;
                                C10 = C(X);
                                h1Var.G(j0Var6.c(t, C10));
                                break;
                            case 24:
                                j0Var7 = this.n;
                                C11 = C(X);
                                h1Var.m(j0Var7.c(t, C11));
                                break;
                            case 25:
                                j0Var8 = this.n;
                                C12 = C(X);
                                h1Var.A(j0Var8.c(t, C12));
                                break;
                            case 26:
                                R(t, X, h1Var);
                                break;
                            case 27:
                                P(t, X, h1Var, p(N), rVar);
                                break;
                            case 28:
                                h1Var.v(this.n.c(t, C(X)));
                                break;
                            case 29:
                                j0Var9 = this.n;
                                C13 = C(X);
                                h1Var.w(j0Var9.c(t, C13));
                                break;
                            case 30:
                                c2 = this.n.c(t, C(X));
                                h1Var.L(c2);
                                obj = l1.z(M, c2, n(N), obj, r1Var);
                                break;
                            case 31:
                                j0Var10 = this.n;
                                C14 = C(X);
                                h1Var.o(j0Var10.c(t, C14));
                                break;
                            case 32:
                                j0Var11 = this.n;
                                C15 = C(X);
                                h1Var.B(j0Var11.c(t, C15));
                                break;
                            case 33:
                                j0Var12 = this.n;
                                C16 = C(X);
                                h1Var.f(j0Var12.c(t, C16));
                                break;
                            case 34:
                                j0Var13 = this.n;
                                C17 = C(X);
                                h1Var.r(j0Var13.c(t, C17));
                                break;
                            case 35:
                                j0Var = this.n;
                                C5 = C(X);
                                h1Var.x(j0Var.c(t, C5));
                                break;
                            case 36:
                                j0Var2 = this.n;
                                C6 = C(X);
                                h1Var.h(j0Var2.c(t, C6));
                                break;
                            case 37:
                                j0Var3 = this.n;
                                C7 = C(X);
                                h1Var.z(j0Var3.c(t, C7));
                                break;
                            case 38:
                                j0Var4 = this.n;
                                C8 = C(X);
                                h1Var.b(j0Var4.c(t, C8));
                                break;
                            case 39:
                                j0Var5 = this.n;
                                C9 = C(X);
                                h1Var.H(j0Var5.c(t, C9));
                                break;
                            case 40:
                                j0Var6 = this.n;
                                C10 = C(X);
                                h1Var.G(j0Var6.c(t, C10));
                                break;
                            case 41:
                                j0Var7 = this.n;
                                C11 = C(X);
                                h1Var.m(j0Var7.c(t, C11));
                                break;
                            case 42:
                                j0Var8 = this.n;
                                C12 = C(X);
                                h1Var.A(j0Var8.c(t, C12));
                                break;
                            case 43:
                                j0Var9 = this.n;
                                C13 = C(X);
                                h1Var.w(j0Var9.c(t, C13));
                                break;
                            case 44:
                                c2 = this.n.c(t, C(X));
                                h1Var.L(c2);
                                obj = l1.z(M, c2, n(N), obj, r1Var);
                                break;
                            case 45:
                                j0Var10 = this.n;
                                C14 = C(X);
                                h1Var.o(j0Var10.c(t, C14));
                                break;
                            case 46:
                                j0Var11 = this.n;
                                C15 = C(X);
                                h1Var.B(j0Var11.c(t, C15));
                                break;
                            case 47:
                                j0Var12 = this.n;
                                C16 = C(X);
                                h1Var.f(j0Var12.c(t, C16));
                                break;
                            case 48:
                                j0Var13 = this.n;
                                C17 = C(X);
                                h1Var.r(j0Var13.c(t, C17));
                                break;
                            case 49:
                                O(t, C(X), h1Var, p(N), rVar);
                                break;
                            case 50:
                                x(t, N, o(N), rVar, h1Var);
                                break;
                            case 51:
                                C = C(X);
                                valueOf = Double.valueOf(h1Var.readDouble());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 52:
                                C = C(X);
                                valueOf = Float.valueOf(h1Var.readFloat());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 53:
                                C = C(X);
                                valueOf = Long.valueOf(h1Var.D());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 54:
                                C = C(X);
                                valueOf = Long.valueOf(h1Var.l());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 55:
                                C = C(X);
                                valueOf = Integer.valueOf(h1Var.j());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 56:
                                C = C(X);
                                valueOf = Long.valueOf(h1Var.n());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 57:
                                C = C(X);
                                valueOf = Integer.valueOf(h1Var.F());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 58:
                                C = C(X);
                                valueOf = Boolean.valueOf(h1Var.J());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 59:
                                Q(t, X, h1Var);
                                U(t, M, N);
                                break;
                            case 60:
                                if (v(t, M, N)) {
                                    valueOf = c0.c(v1.p(t, C(X)), h1Var.P(p(N), rVar));
                                    C = C(X);
                                    v1.z(t, C, valueOf);
                                    U(t, M, N);
                                    break;
                                } else {
                                    v1.z(t, C(X), h1Var.P(p(N), rVar));
                                    T(t, N);
                                    U(t, M, N);
                                }
                            case 61:
                                C = C(X);
                                valueOf = h1Var.e();
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 62:
                                C = C(X);
                                valueOf = Integer.valueOf(h1Var.i());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 63:
                                g2 = h1Var.g();
                                c0.e n2 = n(N);
                                if (n2 != null && !n2.isInRange(g2)) {
                                    obj = l1.D(M, g2, obj, r1Var);
                                    break;
                                } else {
                                    C = C(X);
                                    valueOf = Integer.valueOf(g2);
                                    v1.z(t, C, valueOf);
                                    U(t, M, N);
                                    break;
                                }
                            case 64:
                                C = C(X);
                                valueOf = Integer.valueOf(h1Var.u());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 65:
                                C = C(X);
                                valueOf = Long.valueOf(h1Var.O());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 66:
                                C = C(X);
                                valueOf = Integer.valueOf(h1Var.q());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 67:
                                C = C(X);
                                valueOf = Long.valueOf(h1Var.t());
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            case 68:
                                C = C(X);
                                valueOf = h1Var.d(p(N), rVar);
                                v1.z(t, C, valueOf);
                                U(t, M, N);
                                break;
                            default:
                                if (obj == null) {
                                    obj = r1Var.m();
                                }
                                if (r1Var.l(obj, h1Var)) {
                                    break;
                                } else {
                                    for (int i2 = this.f3949k; i2 < this.f3950l; i2++) {
                                        obj = m(t, this.f3948j[i2], obj, r1Var);
                                    }
                                    if (obj == null) {
                                        return;
                                    }
                                }
                                break;
                        }
                    } catch (d0.a unused) {
                        if (!r1Var.p(h1Var)) {
                            if (obj == null) {
                                obj = r1Var.f(t);
                            }
                            if (!r1Var.l(obj, h1Var)) {
                                for (int i3 = this.f3949k; i3 < this.f3950l; i3++) {
                                    obj = m(t, this.f3948j[i3], obj, r1Var);
                                }
                                if (obj == null) {
                                    return;
                                }
                            }
                        } else if (!h1Var.p()) {
                            for (int i4 = this.f3949k; i4 < this.f3950l; i4++) {
                                obj = m(t, this.f3948j[i4], obj, r1Var);
                            }
                            if (obj == null) {
                                return;
                            }
                        }
                    }
                } else if (M == Integer.MAX_VALUE) {
                    for (int i5 = this.f3949k; i5 < this.f3950l; i5++) {
                        obj = m(t, this.f3948j[i5], obj, r1Var);
                    }
                    if (obj == null) {
                        return;
                    }
                } else {
                    Object b = !this.f3944f ? null : sVar.b(rVar, this.f3943e, M);
                    if (b != null) {
                        if (vVar == null) {
                            vVar = sVar.d(t);
                        }
                        obj = sVar.g(h1Var, b, rVar, vVar, obj, r1Var);
                    } else if (!r1Var.p(h1Var)) {
                        if (obj == null) {
                            obj = r1Var.f(t);
                        }
                        if (r1Var.l(obj, h1Var)) {
                        }
                    } else if (h1Var.p()) {
                    }
                }
            } catch (Throwable th) {
                for (int i6 = this.f3949k; i6 < this.f3950l; i6++) {
                    obj = m(t, this.f3948j[i6], obj, r1Var);
                }
                if (obj != null) {
                    r1Var.n(t, obj);
                }
                throw th;
            }
        }
        r1Var.n(t, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (f.b.g.l1.C(f.b.g.v1.p(r10, r5), f.b.g.v1.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        if (f.b.g.l1.C(f.b.g.v1.p(r10, r5), f.b.g.v1.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (f.b.g.v1.o(r10, r5) == f.b.g.v1.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (f.b.g.v1.o(r10, r5) == f.b.g.v1.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b1, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c3, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d5, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00eb, code lost:
        if (f.b.g.l1.C(f.b.g.v1.p(r10, r5), f.b.g.v1.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0101, code lost:
        if (f.b.g.l1.C(f.b.g.v1.p(r10, r5), f.b.g.v1.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0117, code lost:
        if (f.b.g.l1.C(f.b.g.v1.p(r10, r5), f.b.g.v1.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0129, code lost:
        if (f.b.g.v1.g(r10, r5) == f.b.g.v1.g(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x013b, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x014f, code lost:
        if (f.b.g.v1.o(r10, r5) == f.b.g.v1.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0161, code lost:
        if (f.b.g.v1.n(r10, r5) == f.b.g.v1.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0174, code lost:
        if (f.b.g.v1.o(r10, r5) == f.b.g.v1.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0187, code lost:
        if (f.b.g.v1.o(r10, r5) == f.b.g.v1.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01a0, code lost:
        if (java.lang.Float.floatToIntBits(f.b.g.v1.m(r10, r5)) == java.lang.Float.floatToIntBits(f.b.g.v1.m(r11, r5))) goto L_0x01bf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01bb, code lost:
        if (java.lang.Double.doubleToLongBits(f.b.g.v1.l(r10, r5)) == java.lang.Double.doubleToLongBits(f.b.g.v1.l(r11, r5))) goto L_0x01bf;
     */
    @Override // f.b.g.j1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean d(T t, T t2) {
        int length = this.a.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int i3 = this.a[i2 + 1];
                long C = C(i3);
                switch (W(i3)) {
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
                        z = l1.C(v1.p(t, C), v1.p(t2, C));
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
                        long j2 = (long) (this.a[i2 + 2] & 1048575);
                        if (v1.n(t, j2) == v1.n(t2, j2)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i2 += 3;
            } else if (!this.o.g(t).equals(this.o.g(t2))) {
                return false;
            } else {
                if (this.f3944f) {
                    return this.p.c(t).equals(this.p.c(t2));
                }
                return true;
            }
        }
    }

    @Override // f.b.g.j1
    public void e(T t, byte[] bArr, int i2, int i3, f fVar) {
        if (this.f3946h) {
            L(t, bArr, i2, i3, fVar);
        } else {
            K(t, bArr, i2, i3, 0, fVar);
        }
    }

    @Override // f.b.g.j1
    public int f(T t) {
        return this.f3946h ? s(t) : r(t);
    }

    @Override // f.b.g.j1
    public T g() {
        return (T) this.m.a(this.f3943e);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0579  */
    @Override // f.b.g.j1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void h(T t, a2 a2Var) {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
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
        Objects.requireNonNull(a2Var);
        if (this.f3946h) {
            if (this.f3944f) {
                v<?> c = this.p.c(t);
                if (!c.i()) {
                    it = c.l();
                    entry = it.next();
                    length = this.a.length;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        int X = X(i2);
                        int i9 = this.a[i2];
                        while (entry != null && this.p.a(entry) <= i9) {
                            this.p.j(a2Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch (W(X)) {
                            case 0:
                                if (t(t, i2)) {
                                    d2 = v1.l(t, C(X));
                                    ((n) a2Var).a(i9, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (t(t, i2)) {
                                    f2 = v1.m(t, C(X));
                                    ((n) a2Var).b(i9, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (t(t, i2)) {
                                    j2 = v1.o(t, C(X));
                                    ((n) a2Var).a.b0(i9, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (t(t, i2)) {
                                    j3 = v1.o(t, C(X));
                                    ((n) a2Var).a.b0(i9, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (t(t, i2)) {
                                    i3 = v1.n(t, C(X));
                                    ((n) a2Var).a.Q(i9, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (t(t, i2)) {
                                    j4 = v1.o(t, C(X));
                                    ((n) a2Var).a.O(i9, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (t(t, i2)) {
                                    i4 = v1.n(t, C(X));
                                    ((n) a2Var).a.M(i9, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (t(t, i2)) {
                                    z = v1.g(t, C(X));
                                    ((n) a2Var).a.I(i9, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!t(t, i2)) {
                                    break;
                                }
                                a0(i9, v1.p(t, C(X)), a2Var);
                                break;
                            case 9:
                                if (!t(t, i2)) {
                                    break;
                                }
                                ((n) a2Var).d(i9, v1.p(t, C(X)), p(i2));
                                break;
                            case 10:
                                if (!t(t, i2)) {
                                    break;
                                }
                                ((n) a2Var).a.K(i9, (j) v1.p(t, C(X)));
                                break;
                            case 11:
                                if (t(t, i2)) {
                                    i5 = v1.n(t, C(X));
                                    ((n) a2Var).a.Z(i9, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (t(t, i2)) {
                                    i6 = v1.n(t, C(X));
                                    ((n) a2Var).a.Q(i9, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (t(t, i2)) {
                                    i7 = v1.n(t, C(X));
                                    ((n) a2Var).a.M(i9, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (t(t, i2)) {
                                    j5 = v1.o(t, C(X));
                                    ((n) a2Var).a.O(i9, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (t(t, i2)) {
                                    i8 = v1.n(t, C(X));
                                    ((n) a2Var).f(i9, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (t(t, i2)) {
                                    j6 = v1.o(t, C(X));
                                    ((n) a2Var).g(i9, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!t(t, i2)) {
                                    break;
                                }
                                ((n) a2Var).c(i9, v1.p(t, C(X)), p(i2));
                                break;
                            case 18:
                                l1.G(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 19:
                                l1.K(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 20:
                                l1.N(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 21:
                                l1.V(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 22:
                                l1.M(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 23:
                                l1.J(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 24:
                                l1.I(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 25:
                                l1.E(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 26:
                                l1.T(this.a[i2], (List) v1.p(t, C(X)), a2Var);
                                break;
                            case 27:
                                l1.O(this.a[i2], (List) v1.p(t, C(X)), a2Var, p(i2));
                                break;
                            case 28:
                                l1.F(this.a[i2], (List) v1.p(t, C(X)), a2Var);
                                break;
                            case 29:
                                l1.U(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 30:
                                l1.H(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 31:
                                l1.P(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 32:
                                l1.Q(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 33:
                                l1.R(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 34:
                                l1.S(this.a[i2], (List) v1.p(t, C(X)), a2Var, false);
                                break;
                            case 35:
                                l1.G(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 36:
                                l1.K(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 37:
                                l1.N(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 38:
                                l1.V(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 39:
                                l1.M(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 40:
                                l1.J(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 41:
                                l1.I(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 42:
                                l1.E(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 43:
                                l1.U(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 44:
                                l1.H(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 45:
                                l1.P(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 46:
                                l1.Q(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 47:
                                l1.R(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 48:
                                l1.S(this.a[i2], (List) v1.p(t, C(X)), a2Var, true);
                                break;
                            case 49:
                                l1.L(this.a[i2], (List) v1.p(t, C(X)), a2Var, p(i2));
                                break;
                            case 50:
                                Z(a2Var, i9, v1.p(t, C(X)), i2);
                                break;
                            case 51:
                                if (v(t, i9, i2)) {
                                    d2 = E(t, C(X));
                                    ((n) a2Var).a(i9, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (v(t, i9, i2)) {
                                    f2 = F(t, C(X));
                                    ((n) a2Var).b(i9, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (v(t, i9, i2)) {
                                    j2 = H(t, C(X));
                                    ((n) a2Var).a.b0(i9, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (v(t, i9, i2)) {
                                    j3 = H(t, C(X));
                                    ((n) a2Var).a.b0(i9, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (v(t, i9, i2)) {
                                    i3 = G(t, C(X));
                                    ((n) a2Var).a.Q(i9, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (v(t, i9, i2)) {
                                    j4 = H(t, C(X));
                                    ((n) a2Var).a.O(i9, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (v(t, i9, i2)) {
                                    i4 = G(t, C(X));
                                    ((n) a2Var).a.M(i9, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (v(t, i9, i2)) {
                                    z = D(t, C(X));
                                    ((n) a2Var).a.I(i9, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!v(t, i9, i2)) {
                                    break;
                                }
                                a0(i9, v1.p(t, C(X)), a2Var);
                                break;
                            case 60:
                                if (!v(t, i9, i2)) {
                                    break;
                                }
                                ((n) a2Var).d(i9, v1.p(t, C(X)), p(i2));
                                break;
                            case 61:
                                if (!v(t, i9, i2)) {
                                    break;
                                }
                                ((n) a2Var).a.K(i9, (j) v1.p(t, C(X)));
                                break;
                            case 62:
                                if (v(t, i9, i2)) {
                                    i5 = G(t, C(X));
                                    ((n) a2Var).a.Z(i9, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (v(t, i9, i2)) {
                                    i6 = G(t, C(X));
                                    ((n) a2Var).a.Q(i9, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (v(t, i9, i2)) {
                                    i7 = G(t, C(X));
                                    ((n) a2Var).a.M(i9, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (v(t, i9, i2)) {
                                    j5 = H(t, C(X));
                                    ((n) a2Var).a.O(i9, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (v(t, i9, i2)) {
                                    i8 = G(t, C(X));
                                    ((n) a2Var).f(i9, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (v(t, i9, i2)) {
                                    j6 = H(t, C(X));
                                    ((n) a2Var).g(i9, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!v(t, i9, i2)) {
                                    break;
                                }
                                ((n) a2Var).c(i9, v1.p(t, C(X)), p(i2));
                                break;
                        }
                    }
                    while (entry != null) {
                        this.p.j(a2Var, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    r1<?, ?> r1Var = this.o;
                    r1Var.s(r1Var.g(t), a2Var);
                    return;
                }
            }
            it = null;
            entry = null;
            length = this.a.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            r1<?, ?> r1Var2 = this.o;
            r1Var2.s(r1Var2.g(t), a2Var);
            return;
        }
        Y(t, a2Var);
    }

    @Override // f.b.g.j1
    public void i(T t) {
        int i2;
        int i3 = this.f3949k;
        while (true) {
            i2 = this.f3950l;
            if (i3 >= i2) {
                break;
            }
            long C = C(X(this.f3948j[i3]));
            Object p = v1.p(t, C);
            if (p != null) {
                v1.f3953f.s(t, C, this.q.g(p));
            }
            i3++;
        }
        int length = this.f3948j.length;
        while (i2 < length) {
            this.n.a(t, (long) this.f3948j[i2]);
            i2++;
        }
        this.o.j(t);
        if (this.f3944f) {
            this.p.f(t);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cc, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00de, code lost:
        if (r3 != null) goto L_0x00e0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e0, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e4, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // f.b.g.j1
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int j(T t) {
        int i2;
        int i3;
        long j2;
        double d2;
        float f2;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int X = X(i5);
            int i6 = this.a[i5];
            long C = C(X);
            int i7 = 37;
            switch (W(X)) {
                case 0:
                    i3 = i4 * 53;
                    d2 = v1.l(t, C);
                    j2 = Double.doubleToLongBits(d2);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    f2 = v1.m(t, C);
                    i2 = Float.floatToIntBits(f2);
                    i4 = i2 + i3;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i4 * 53;
                    j2 = v1.o(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i3 = i4 * 53;
                    i2 = v1.n(t, C);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    z = v1.g(t, C);
                    i2 = c0.a(z);
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) v1.p(t, C)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    obj = v1.p(t, C);
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
                    obj2 = v1.p(t, C);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 17:
                    obj = v1.p(t, C);
                    break;
                case 51:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        d2 = E(t, C);
                        j2 = Double.doubleToLongBits(d2);
                        i2 = c0.b(j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        f2 = F(t, C);
                        i2 = Float.floatToIntBits(f2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = H(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 54:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = H(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 55:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 56:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = H(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 57:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 58:
                    if (v(t, i6, i5)) {
                        i3 = i4 * 53;
                        z = D(t, C);
                        i2 = c0.a(z);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = ((String) v1.p(t, C)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 60:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    obj2 = v1.p(t, C);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 61:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    obj2 = v1.p(t, C);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 62:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 63:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 64:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 65:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = H(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 66:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = G(t, C);
                    i4 = i2 + i3;
                    break;
                case 67:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = H(t, C);
                    i2 = c0.b(j2);
                    i4 = i2 + i3;
                    break;
                case 68:
                    if (!v(t, i6, i5)) {
                        break;
                    }
                    obj2 = v1.p(t, C);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
            }
        }
        int hashCode = this.o.g(t).hashCode() + (i4 * 53);
        return this.f3944f ? (hashCode * 53) + this.p.c(t).hashCode() : hashCode;
    }

    public final boolean k(T t, T t2, int i2) {
        return t(t, i2) == t(t2, i2);
    }

    public final int l(byte[] bArr, int i2, int i3, y1 y1Var, Class<?> cls, f fVar) {
        Object obj;
        Object obj2;
        Object obj3;
        int i4;
        long j2;
        int i5;
        switch (y1Var.ordinal()) {
            case 0:
                obj = Double.valueOf(Double.longBitsToDouble(b.P(bArr, i2)));
                fVar.c = obj;
                return i2 + 8;
            case 1:
                obj2 = Float.valueOf(Float.intBitsToFloat(b.O(bArr, i2)));
                fVar.c = obj2;
                return i2 + 4;
            case 2:
            case 3:
                i4 = b.j0(bArr, i2, fVar);
                j2 = fVar.b;
                obj3 = Long.valueOf(j2);
                fVar.c = obj3;
                return i4;
            case 4:
            case 12:
            case 13:
                i4 = b.h0(bArr, i2, fVar);
                i5 = fVar.a;
                obj3 = Integer.valueOf(i5);
                fVar.c = obj3;
                return i4;
            case 5:
            case 15:
                obj = Long.valueOf(b.P(bArr, i2));
                fVar.c = obj;
                return i2 + 8;
            case 6:
            case 14:
                obj2 = Integer.valueOf(b.O(bArr, i2));
                fVar.c = obj2;
                return i2 + 4;
            case 7:
                i4 = b.j0(bArr, i2, fVar);
                obj3 = Boolean.valueOf(fVar.b != 0);
                fVar.c = obj3;
                return i4;
            case 8:
                return b.e0(bArr, i2, fVar);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return b.R(e1.c.a(cls), bArr, i2, i3, fVar);
            case 11:
                return b.M(bArr, i2, fVar);
            case 16:
                i4 = b.h0(bArr, i2, fVar);
                i5 = k.b(fVar.a);
                obj3 = Integer.valueOf(i5);
                fVar.c = obj3;
                return i4;
            case 17:
                i4 = b.j0(bArr, i2, fVar);
                j2 = k.c(fVar.b);
                obj3 = Long.valueOf(j2);
                fVar.c = obj3;
                return i4;
        }
    }

    public final <UT, UB> UB m(Object obj, int i2, UB ub, r1<UT, UB> r1Var) {
        int[] iArr = this.a;
        int i3 = iArr[i2];
        Object p = v1.p(obj, C(iArr[i2 + 1]));
        if (p == null) {
            return ub;
        }
        int i4 = (i2 / 3) * 2;
        c0.e eVar = (c0.e) this.b[i4 + 1];
        if (eVar == null) {
            return ub;
        }
        Map<?, ?> e2 = this.q.e(p);
        m0.a<?, ?> h2 = this.q.h(this.b[i4]);
        Iterator<Map.Entry<?, ?>> it = e2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<?, ?> next = it.next();
            if (!eVar.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = r1Var.m();
                }
                int a = m0.a(h2, next.getKey(), next.getValue());
                byte[] bArr = new byte[a];
                Logger logger = m.b;
                m.c cVar = new m.c(bArr, 0, a);
                try {
                    Object key = next.getKey();
                    Object value = next.getValue();
                    v.q(cVar, h2.a, 1, key);
                    v.q(cVar, h2.c, 2, value);
                    cVar.b();
                    r1Var.d(ub, i3, new j.h(bArr));
                    it.remove();
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    public final c0.e n(int i2) {
        return (c0.e) this.b[((i2 / 3) * 2) + 1];
    }

    public final Object o(int i2) {
        return this.b[(i2 / 3) * 2];
    }

    public final j1 p(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.b;
        j1 j1Var = (j1) objArr[i3];
        if (j1Var != null) {
            return j1Var;
        }
        j1<T> a = e1.c.a((Class) objArr[i3 + 1]);
        this.b[i3] = a;
        return a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01d0, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01e1, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f2, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0203, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0214, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0225, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0227, code lost:
        r2.putInt(r17, (long) r10, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x022b, code lost:
        r5 = r5 + ((f.b.g.m.A(r7) + f.b.g.m.y(r8)) + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0371, code lost:
        if ((r7 instanceof f.b.g.j) != false) goto L_0x0373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0373, code lost:
        r7 = f.b.g.m.d(r8, (f.b.g.j) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x037a, code lost:
        r7 = f.b.g.m.w(r8, (java.lang.String) r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0380, code lost:
        r5 = r5 + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c1, code lost:
        if ((r7 instanceof f.b.g.j) != false) goto L_0x0373;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013f, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0151, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0175, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0187, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0199, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ad, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01bf, code lost:
        if (r16.f3947i != false) goto L_0x0227;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int r(T t) {
        int i2;
        int i3;
        int i4;
        long j2;
        long j3;
        int i5;
        Object obj;
        int i6;
        int i7;
        int i8;
        long j4;
        int i9;
        Unsafe unsafe = s;
        int i10 = -1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.a.length; i13 += 3) {
            int X = X(i13);
            int i14 = this.a[i13];
            int W = W(X);
            if (W <= 17) {
                i3 = this.a[i13 + 2];
                int i15 = 1048575 & i3;
                i2 = 1 << (i3 >>> 20);
                if (i15 != i10) {
                    i12 = unsafe.getInt(t, (long) i15);
                    i10 = i15;
                }
            } else {
                i3 = (!this.f3947i || W < w.DOUBLE_LIST_PACKED.b || W > w.SINT64_LIST_PACKED.b) ? 0 : this.a[i13 + 2] & 1048575;
                i2 = 0;
            }
            long C = C(X);
            switch (W) {
                case 0:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.f(i14, 0.0d);
                    i11 += i4;
                    break;
                case 1:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.j(i14, 0.0f);
                    i11 += i4;
                    break;
                case 2:
                    if ((i12 & i2) != 0) {
                        j2 = unsafe.getLong(t, C);
                        i4 = m.n(i14, j2);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i12 & i2) != 0) {
                        j3 = unsafe.getLong(t, C);
                        i4 = m.B(i14, j3);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i12 & i2) != 0) {
                        i5 = unsafe.getInt(t, C);
                        i4 = m.l(i14, i5);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.i(i14, 0);
                    i11 += i4;
                    break;
                case 6:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.h(i14, 0);
                    i11 += i4;
                    break;
                case 7:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.c(i14, true);
                    i11 += i4;
                    break;
                case 8:
                    if ((i12 & i2) != 0) {
                        obj = unsafe.getObject(t, C);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = l1.n(i14, unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
                case 10:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.d(i14, (j) unsafe.getObject(t, C));
                    i11 += i4;
                    break;
                case 11:
                    if ((i12 & i2) != 0) {
                        i6 = unsafe.getInt(t, C);
                        i4 = m.z(i14, i6);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i12 & i2) != 0) {
                        i7 = unsafe.getInt(t, C);
                        i4 = m.g(i14, i7);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.q(i14, 0);
                    i11 += i4;
                    break;
                case 14:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.r(i14, 0);
                    i11 += i4;
                    break;
                case 15:
                    if ((i12 & i2) != 0) {
                        i8 = unsafe.getInt(t, C);
                        i4 = m.s(i14, i8);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i12 & i2) != 0) {
                        j4 = unsafe.getLong(t, C);
                        i4 = m.u(i14, j4);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i12 & i2) == 0) {
                        break;
                    }
                    i4 = m.k(i14, (t0) unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
                case 18:
                case 23:
                case 32:
                    i4 = l1.g(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 19:
                case 24:
                case 31:
                    i4 = l1.e(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 20:
                    i4 = l1.l(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 21:
                    i4 = l1.w(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 22:
                    i4 = l1.j(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 25:
                    i4 = l1.a(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 26:
                    i4 = l1.t(i14, (List) unsafe.getObject(t, C));
                    i11 += i4;
                    break;
                case 27:
                    i4 = l1.o(i14, (List) unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
                case 28:
                    i4 = l1.b(i14, (List) unsafe.getObject(t, C));
                    i11 += i4;
                    break;
                case 29:
                    i4 = l1.u(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 30:
                    i4 = l1.c(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 33:
                    i4 = l1.p(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 34:
                    i4 = l1.r(i14, (List) unsafe.getObject(t, C), false);
                    i11 += i4;
                    break;
                case 35:
                    i9 = l1.h((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i9 = l1.f((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i9 = l1.m((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i9 = l1.x((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i9 = l1.k((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i9 = l1.h((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i9 = l1.f((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    Class<?> cls = l1.a;
                    i9 = ((List) unsafe.getObject(t, C)).size();
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i9 = l1.v((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i9 = l1.d((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i9 = l1.f((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i9 = l1.h((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i9 = l1.q((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i9 = l1.s((List) unsafe.getObject(t, C));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i4 = l1.i(i14, (List) unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
                case 50:
                    i4 = this.q.d(i14, unsafe.getObject(t, C), o(i13));
                    i11 += i4;
                    break;
                case 51:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.f(i14, 0.0d);
                    i11 += i4;
                    break;
                case 52:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.j(i14, 0.0f);
                    i11 += i4;
                    break;
                case 53:
                    if (v(t, i14, i13)) {
                        j2 = H(t, C);
                        i4 = m.n(i14, j2);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i14, i13)) {
                        j3 = H(t, C);
                        i4 = m.B(i14, j3);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i14, i13)) {
                        i5 = G(t, C);
                        i4 = m.l(i14, i5);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.i(i14, 0);
                    i11 += i4;
                    break;
                case 57:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.h(i14, 0);
                    i11 += i4;
                    break;
                case 58:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.c(i14, true);
                    i11 += i4;
                    break;
                case 59:
                    if (v(t, i14, i13)) {
                        obj = unsafe.getObject(t, C);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = l1.n(i14, unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
                case 61:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.d(i14, (j) unsafe.getObject(t, C));
                    i11 += i4;
                    break;
                case 62:
                    if (v(t, i14, i13)) {
                        i6 = G(t, C);
                        i4 = m.z(i14, i6);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i14, i13)) {
                        i7 = G(t, C);
                        i4 = m.g(i14, i7);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.q(i14, 0);
                    i11 += i4;
                    break;
                case 65:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.r(i14, 0);
                    i11 += i4;
                    break;
                case 66:
                    if (v(t, i14, i13)) {
                        i8 = G(t, C);
                        i4 = m.s(i14, i8);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i14, i13)) {
                        j4 = H(t, C);
                        i4 = m.u(i14, j4);
                        i11 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!v(t, i14, i13)) {
                        break;
                    }
                    i4 = m.k(i14, (t0) unsafe.getObject(t, C), p(i13));
                    i11 += i4;
                    break;
            }
        }
        int i16 = 0;
        r1<?, ?> r1Var = this.o;
        int h2 = r1Var.h(r1Var.g(t)) + i11;
        if (!this.f3944f) {
            return h2;
        }
        v<?> c = this.p.c(t);
        for (int i17 = 0; i17 < c.a.d(); i17++) {
            Map.Entry<?, Object> c2 = c.a.c(i17);
            i16 += v.f((v.a) c2.getKey(), c2.getValue());
        }
        for (Map.Entry<?, Object> entry : c.a.e()) {
            i16 += v.f((v.a) entry.getKey(), entry.getValue());
        }
        return h2 + i16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x01ce, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01df, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f0, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0201, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0203, code lost:
        r0.putInt(r14, (long) r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0207, code lost:
        r3 = ((f.b.g.m.A(r5) + f.b.g.m.y(r6)) + r5) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x033b, code lost:
        if ((r4 instanceof f.b.g.j) != false) goto L_0x0313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x033e, code lost:
        r4 = f.b.g.m.w(r6, (java.lang.String) r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009f, code lost:
        if ((r4 instanceof f.b.g.j) != false) goto L_0x0313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x011b, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x012d, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x013f, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0151, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0163, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0175, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0189, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x019b, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01ac, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01bd, code lost:
        if (r13.f3947i != false) goto L_0x0203;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final int s(T t) {
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
        for (int i9 = 0; i9 < this.a.length; i9 += 3) {
            int X = X(i9);
            int W = W(X);
            int i10 = this.a[i9];
            long C = C(X);
            int i11 = (W < w.DOUBLE_LIST_PACKED.b || W > w.SINT64_LIST_PACKED.b) ? 0 : this.a[i9 + 2] & 1048575;
            switch (W) {
                case 0:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.f(i10, 0.0d);
                    i8 += i2;
                    break;
                case 1:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.j(i10, 0.0f);
                    i8 += i2;
                    break;
                case 2:
                    if (t(t, i9)) {
                        j2 = v1.o(t, C);
                        i2 = m.n(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (t(t, i9)) {
                        j3 = v1.o(t, C);
                        i2 = m.B(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (t(t, i9)) {
                        i3 = v1.n(t, C);
                        i2 = m.l(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.i(i10, 0);
                    i8 += i2;
                    break;
                case 6:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.h(i10, 0);
                    i8 += i2;
                    break;
                case 7:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.c(i10, true);
                    i8 += i2;
                    break;
                case 8:
                    if (t(t, i9)) {
                        obj = v1.p(t, C);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = l1.n(i10, v1.p(t, C), p(i9));
                    i8 += i2;
                    break;
                case 10:
                    if (!t(t, i9)) {
                        break;
                    }
                    obj = v1.p(t, C);
                    i2 = m.d(i10, (j) obj);
                    i8 += i2;
                    break;
                case 11:
                    if (t(t, i9)) {
                        i4 = v1.n(t, C);
                        i2 = m.z(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (t(t, i9)) {
                        i5 = v1.n(t, C);
                        i2 = m.g(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.q(i10, 0);
                    i8 += i2;
                    break;
                case 14:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.r(i10, 0);
                    i8 += i2;
                    break;
                case 15:
                    if (t(t, i9)) {
                        i6 = v1.n(t, C);
                        i2 = m.s(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (t(t, i9)) {
                        j4 = v1.o(t, C);
                        i2 = m.u(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (!t(t, i9)) {
                        break;
                    }
                    i2 = m.k(i10, (t0) v1.p(t, C), p(i9));
                    i8 += i2;
                    break;
                case 18:
                case 23:
                case 32:
                    i2 = l1.g(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 19:
                case 24:
                case 31:
                    i2 = l1.e(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 20:
                    i2 = l1.l(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 21:
                    i2 = l1.w(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 22:
                    i2 = l1.j(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 25:
                    i2 = l1.a(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 26:
                    i2 = l1.t(i10, w(t, C));
                    i8 += i2;
                    break;
                case 27:
                    i2 = l1.o(i10, w(t, C), p(i9));
                    i8 += i2;
                    break;
                case 28:
                    i2 = l1.b(i10, w(t, C));
                    i8 += i2;
                    break;
                case 29:
                    i2 = l1.u(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 30:
                    i2 = l1.c(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 33:
                    i2 = l1.p(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 34:
                    i2 = l1.r(i10, w(t, C), false);
                    i8 += i2;
                    break;
                case 35:
                    i7 = l1.h((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i7 = l1.f((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i7 = l1.m((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i7 = l1.x((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i7 = l1.k((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i7 = l1.h((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i7 = l1.f((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    Class<?> cls = l1.a;
                    i7 = ((List) unsafe.getObject(t, C)).size();
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i7 = l1.v((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i7 = l1.d((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i7 = l1.f((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i7 = l1.h((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i7 = l1.q((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i7 = l1.s((List) unsafe.getObject(t, C));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i2 = l1.i(i10, w(t, C), p(i9));
                    i8 += i2;
                    break;
                case 50:
                    i2 = this.q.d(i10, v1.p(t, C), o(i9));
                    i8 += i2;
                    break;
                case 51:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.f(i10, 0.0d);
                    i8 += i2;
                    break;
                case 52:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.j(i10, 0.0f);
                    i8 += i2;
                    break;
                case 53:
                    if (v(t, i10, i9)) {
                        j2 = H(t, C);
                        i2 = m.n(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (v(t, i10, i9)) {
                        j3 = H(t, C);
                        i2 = m.B(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (v(t, i10, i9)) {
                        i3 = G(t, C);
                        i2 = m.l(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.i(i10, 0);
                    i8 += i2;
                    break;
                case 57:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.h(i10, 0);
                    i8 += i2;
                    break;
                case 58:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.c(i10, true);
                    i8 += i2;
                    break;
                case 59:
                    if (v(t, i10, i9)) {
                        obj = v1.p(t, C);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = l1.n(i10, v1.p(t, C), p(i9));
                    i8 += i2;
                    break;
                case 61:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    obj = v1.p(t, C);
                    i2 = m.d(i10, (j) obj);
                    i8 += i2;
                    break;
                case 62:
                    if (v(t, i10, i9)) {
                        i4 = G(t, C);
                        i2 = m.z(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (v(t, i10, i9)) {
                        i5 = G(t, C);
                        i2 = m.g(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.q(i10, 0);
                    i8 += i2;
                    break;
                case 65:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.r(i10, 0);
                    i8 += i2;
                    break;
                case 66:
                    if (v(t, i10, i9)) {
                        i6 = G(t, C);
                        i2 = m.s(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (v(t, i10, i9)) {
                        j4 = H(t, C);
                        i2 = m.u(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!v(t, i10, i9)) {
                        break;
                    }
                    i2 = m.k(i10, (t0) v1.p(t, C), p(i9));
                    i8 += i2;
                    break;
            }
        }
        r1<?, ?> r1Var = this.o;
        return r1Var.h(r1Var.g(t)) + i8;
    }

    public final boolean t(T t, int i2) {
        if (this.f3946h) {
            int i3 = this.a[i2 + 1];
            long C = C(i3);
            switch (W(i3)) {
                case 0:
                    if (v1.l(t, C) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (v1.m(t, C) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (v1.o(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (v1.o(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (v1.o(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return v1.g(t, C);
                case 8:
                    Object p = v1.p(t, C);
                    if (p instanceof String) {
                        return !((String) p).isEmpty();
                    }
                    if (p instanceof j) {
                        return !j.c.equals(p);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (v1.p(t, C) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    return !j.c.equals(v1.p(t, C));
                case 11:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (v1.o(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (v1.n(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (v1.o(t, C) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (v1.p(t, C) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.a[i2 + 2];
            if ((v1.n(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0) {
                return true;
            }
            return false;
        }
    }

    public final boolean u(T t, int i2, int i3, int i4) {
        return this.f3946h ? t(t, i2) : (i3 & i4) != 0;
    }

    public final boolean v(T t, int i2, int i3) {
        return v1.n(t, (long) (this.a[i3 + 2] & 1048575)) == i2;
    }

    public final <K, V> void x(Object obj, int i2, Object obj2, r rVar, h1 h1Var) {
        long C = C(this.a[i2 + 1]);
        Object p = v1.p(obj, C);
        if (p == null) {
            p = this.q.c(obj2);
            v1.f3953f.s(obj, C, p);
        } else if (this.q.f(p)) {
            Object c = this.q.c(obj2);
            this.q.a(c, p);
            v1.f3953f.s(obj, C, c);
            p = c;
        }
        h1Var.a(this.q.e(p), this.q.h(obj2), rVar);
    }

    public final void y(T t, T t2, int i2) {
        long C = C(this.a[i2 + 1]);
        if (t(t2, i2)) {
            Object p = v1.p(t, C);
            Object p2 = v1.p(t2, C);
            if (p != null && p2 != null) {
                p2 = c0.c(p, p2);
            } else if (p2 == null) {
                return;
            }
            v1.f3953f.s(t, C, p2);
            T(t, i2);
        }
    }

    public final void z(T t, T t2, int i2) {
        int[] iArr = this.a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long C = C(i3);
        if (v(t2, i4, i2)) {
            Object p = v1.p(t, C);
            Object p2 = v1.p(t2, C);
            if (p != null && p2 != null) {
                p2 = c0.c(p, p2);
            } else if (p2 == null) {
                return;
            }
            v1.f3953f.s(t, C, p2);
            U(t, i4, i2);
        }
    }
}
