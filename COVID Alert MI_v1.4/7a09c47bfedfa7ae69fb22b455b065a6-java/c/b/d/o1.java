package c.b.d;

import b.x.t;
import c.b.d.g0;
import c.b.d.k0;
import c.b.d.n0;
import c.b.d.z;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class o1<T> implements d2<T> {
    public static final int[] r = new int[0];
    public static final Unsafe s = v2.q();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f5448a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f5449b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5450c;

    /* renamed from: d  reason: collision with root package name */
    public final int f5451d;

    /* renamed from: e  reason: collision with root package name */
    public final i1 f5452e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5453f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f5454g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int k;
    public final int l;
    public final r1 m;
    public final u0 n;
    public final p2<?, ?> o;
    public final a0<?> p;
    public final b1 q;

    public o1(int[] iArr, Object[] objArr, int i2, int i3, i1 i1Var, boolean z, boolean z2, int[] iArr2, int i4, int i5, r1 r1Var, u0 u0Var, p2<?, ?> p2Var, a0<?> a0Var, b1 b1Var) {
        this.f5448a = iArr;
        this.f5449b = objArr;
        this.f5450c = i2;
        this.f5451d = i3;
        this.f5454g = i1Var instanceof k0;
        this.h = z;
        this.f5453f = a0Var != null && a0Var.e(i1Var);
        this.i = z2;
        this.j = iArr2;
        this.k = i4;
        this.l = i5;
        this.m = r1Var;
        this.n = u0Var;
        this.o = p2Var;
        this.p = a0Var;
        this.f5452e = i1Var;
        this.q = b1Var;
    }

    public static long A(int i2) {
        return (long) (i2 & 1048575);
    }

    public static <T> boolean B(T t, long j2) {
        return ((Boolean) v2.p(t, j2)).booleanValue();
    }

    public static <T> double C(T t, long j2) {
        return ((Double) v2.p(t, j2)).doubleValue();
    }

    public static <T> float D(T t, long j2) {
        return ((Float) v2.p(t, j2)).floatValue();
    }

    public static <T> int E(T t, long j2) {
        return ((Integer) v2.p(t, j2)).intValue();
    }

    public static <T> long F(T t, long j2) {
        return ((Long) v2.p(t, j2)).longValue();
    }

    public static int T(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static r2 p(Object obj) {
        k0 k0Var = (k0) obj;
        r2 r2Var = k0Var.f5348b;
        if (r2Var != r2.f5781f) {
            return r2Var;
        }
        r2 b2 = r2.b();
        k0Var.f5348b = b2;
        return b2;
    }

    public static List<?> v(Object obj, long j2) {
        return (List) v2.p(obj, j2);
    }

    /* JADX WARN: Incorrect args count in method signature: <T:Ljava/lang/Object;>(Ljava/lang/Class<TT;>;Lc/b/d/g1;Lc/b/d/r1;Lc/b/d/u0;Lc/b/d/p2<**>;Lc/b/d/a0<*>;Lc/b/d/b1;)Lc/b/d/o1<TT;>; */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0186  */
    public static o1 z(g1 g1Var, r1 r1Var, u0 u0Var, p2 p2Var, a0 a0Var, b1 b1Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        e0[] e0VarArr;
        int i7;
        int i8;
        int i9;
        i2 i2Var;
        int i10;
        int ordinal;
        Class<?> cls;
        Object obj;
        boolean z;
        g0 g0Var;
        char c2;
        int i11;
        int i12;
        int i13;
        int r2;
        if (g1Var instanceof a2) {
            a2 a2Var = (a2) g1Var;
            throw null;
        }
        i2 i2Var2 = (i2) g1Var;
        boolean z2 = i2Var2.f5315a == y1.PROTO3;
        e0[] e0VarArr2 = i2Var2.f5318d;
        if (e0VarArr2.length == 0) {
            i3 = 0;
            i2 = 0;
        } else {
            i3 = e0VarArr2[0].f5252e;
            i2 = e0VarArr2[e0VarArr2.length - 1].f5252e;
        }
        int length = e0VarArr2.length;
        int[] iArr = new int[(length * 3)];
        Object[] objArr = new Object[(length * 2)];
        int i14 = 0;
        int i15 = 0;
        for (e0 e0Var : e0VarArr2) {
            g0 g0Var2 = e0Var.f5250c;
            if (g0Var2 == g0.MAP) {
                i14++;
            } else {
                int i16 = g0Var2.f5280c;
                if (i16 >= 18 && i16 <= 49) {
                    i15++;
                }
            }
        }
        int[] iArr2 = i14 > 0 ? new int[i14] : null;
        int[] iArr3 = i15 > 0 ? new int[i15] : null;
        int[] iArr4 = i2Var2.f5317c;
        if (iArr4 == null) {
            iArr4 = r;
        }
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i17 < e0VarArr2.length) {
            e0 e0Var2 = e0VarArr2[i17];
            int i22 = e0Var2.f5252e;
            v1 v1Var = e0Var2.j;
            if (v1Var != null) {
                e0VarArr = e0VarArr2;
                i13 = e0Var2.f5250c.f5280c + 51;
                i5 = i3;
                i4 = i2;
                int r3 = (int) v2.r(v1Var.f5893b);
                r2 = (int) v2.r(v1Var.f5892a);
                i12 = r3;
            } else {
                e0VarArr = e0VarArr2;
                i5 = i3;
                i4 = i2;
                g0 g0Var3 = e0Var2.f5250c;
                int r4 = (int) v2.r(e0Var2.f5249b);
                int i23 = g0Var3.f5280c;
                if (!z2) {
                    g0.a aVar = g0Var3.f5281d;
                    if (!aVar.f5287b) {
                        if (!(aVar == g0.a.MAP)) {
                            i6 = i23;
                            i9 = (int) v2.r(e0Var2.f5253f);
                            i7 = Integer.numberOfTrailingZeros(e0Var2.f5254g);
                            i8 = r4;
                            iArr[i18] = e0Var2.f5252e;
                            int i24 = i18 + 1;
                            if (e0Var2.i) {
                                i10 = 536870912;
                                i2Var = i2Var2;
                            } else {
                                i2Var = i2Var2;
                                i10 = 0;
                            }
                            iArr[i24] = (e0Var2.h ? 268435456 : 0) | i10 | (i6 << 20) | i8;
                            iArr[i18 + 2] = i9 | (i7 << 20);
                            ordinal = e0Var2.f5250c.ordinal();
                            if (ordinal != 9 || ordinal == 17) {
                                Field field = e0Var2.f5249b;
                                cls = field != null ? field.getType() : e0Var2.l;
                            } else {
                                cls = (ordinal == 27 || ordinal == 49) ? e0Var2.f5251d : null;
                            }
                            obj = e0Var2.m;
                            if (obj != null) {
                                int i25 = (i18 / 3) * 2;
                                objArr[i25] = obj;
                                if (cls != null) {
                                    objArr[i25 + 1] = cls;
                                } else {
                                    n0.d dVar = e0Var2.n;
                                    if (dVar != null) {
                                        objArr[i25 + 1] = dVar;
                                    }
                                }
                                z = true;
                            } else if (cls != null) {
                                z = true;
                                objArr[((i18 / 3) * 2) + 1] = cls;
                            } else {
                                z = true;
                                n0.d dVar2 = e0Var2.n;
                                if (dVar2 != null) {
                                    objArr[((i18 / 3) * 2) + 1] = dVar2;
                                }
                            }
                            if (i19 < iArr4.length && iArr4[i19] == i22) {
                                iArr4[i19] = i18;
                                i19++;
                            }
                            g0Var = e0Var2.f5250c;
                            if (g0Var == g0.MAP) {
                                iArr2[i20] = i18;
                                i20++;
                                c2 = '1';
                            } else {
                                int i26 = g0Var.f5280c;
                                c2 = '1';
                                if (i26 >= 18 && i26 <= 49) {
                                    iArr3[i21] = (int) v2.r(e0Var2.f5249b);
                                    i21++;
                                }
                            }
                            i17++;
                            i18 += 3;
                            e0VarArr2 = e0VarArr;
                            i3 = i5;
                            i2 = i4;
                            z2 = z2;
                            i2Var2 = i2Var;
                        }
                    }
                }
                i12 = r4;
                i13 = i23;
                Field field2 = e0Var2.k;
                if (field2 == null) {
                    i8 = i12;
                    i11 = i13;
                    i9 = 0;
                    i6 = i11;
                    i7 = 0;
                    iArr[i18] = e0Var2.f5252e;
                    int i242 = i18 + 1;
                    if (e0Var2.i) {
                    }
                    iArr[i242] = (e0Var2.h ? 268435456 : 0) | i10 | (i6 << 20) | i8;
                    iArr[i18 + 2] = i9 | (i7 << 20);
                    ordinal = e0Var2.f5250c.ordinal();
                    if (ordinal != 9) {
                    }
                    Field field3 = e0Var2.f5249b;
                    if (field3 != null) {
                    }
                    obj = e0Var2.m;
                    if (obj != null) {
                    }
                    iArr4[i19] = i18;
                    i19++;
                    g0Var = e0Var2.f5250c;
                    if (g0Var == g0.MAP) {
                    }
                    i17++;
                    i18 += 3;
                    e0VarArr2 = e0VarArr;
                    i3 = i5;
                    i2 = i4;
                    z2 = z2;
                    i2Var2 = i2Var;
                } else {
                    r2 = (int) v2.r(field2);
                }
            }
            i11 = i13;
            i9 = r2;
            i8 = i12;
            i6 = i11;
            i7 = 0;
            iArr[i18] = e0Var2.f5252e;
            int i2422 = i18 + 1;
            if (e0Var2.i) {
            }
            iArr[i2422] = (e0Var2.h ? 268435456 : 0) | i10 | (i6 << 20) | i8;
            iArr[i18 + 2] = i9 | (i7 << 20);
            ordinal = e0Var2.f5250c.ordinal();
            if (ordinal != 9) {
            }
            Field field32 = e0Var2.f5249b;
            if (field32 != null) {
            }
            obj = e0Var2.m;
            if (obj != null) {
            }
            iArr4[i19] = i18;
            i19++;
            g0Var = e0Var2.f5250c;
            if (g0Var == g0.MAP) {
            }
            i17++;
            i18 += 3;
            e0VarArr2 = e0VarArr;
            i3 = i5;
            i2 = i4;
            z2 = z2;
            i2Var2 = i2Var;
        }
        if (iArr2 == null) {
            iArr2 = r;
        }
        if (iArr3 == null) {
            iArr3 = r;
        }
        int[] iArr5 = new int[(iArr4.length + iArr2.length + iArr3.length)];
        System.arraycopy(iArr4, 0, iArr5, 0, iArr4.length);
        System.arraycopy(iArr2, 0, iArr5, iArr4.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr5, iArr4.length + iArr2.length, iArr3.length);
        return new o1(iArr, objArr, i3, i2, i2Var2.f5319e, z2, true, iArr5, iArr4.length, iArr4.length + iArr2.length, r1Var, u0Var, p2Var, a0Var, b1Var);
    }

    public final <K, V> int G(T t, byte[] bArr, int i2, int i3, int i4, long j2, f fVar) {
        Unsafe unsafe = s;
        Object obj = this.f5449b[(i4 / 3) * 2];
        Object object = unsafe.getObject(t, j2);
        if (this.q.f(object)) {
            Object c2 = this.q.c(obj);
            this.q.a(c2, object);
            unsafe.putObject(t, j2, c2);
            object = c2;
        }
        this.q.h(obj);
        this.q.e(object);
        int Y0 = t.Y0(bArr, i2, fVar);
        int i5 = fVar.f5257a;
        if (i5 < 0 || i5 > i3 - Y0) {
            throw o0.i();
        }
        throw null;
    }

    public final int H(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, f fVar) {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        Unsafe unsafe = s;
        long j4 = (long) (this.f5448a[i9 + 2] & 1048575);
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(t.k0(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(t.q0(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = t.c1(bArr, i2, fVar);
                    j3 = fVar.f5258b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = t.Y0(bArr, i2, fVar);
                    i11 = fVar.f5257a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(t.o0(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(t.m0(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = t.c1(bArr, i2, fVar);
                    obj3 = Boolean.valueOf(fVar.f5258b != 0);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 59:
                if (i6 == 2) {
                    i10 = t.Y0(bArr, i2, fVar);
                    int i12 = fVar.f5257a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || w2.h(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, n0.f5438a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw o0.c();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = t.u0(o(i9), bArr, i2, i3, fVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = fVar.f5259c;
                    if (object != null) {
                        obj3 = n0.f(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = t.i0(bArr, i2, fVar);
                    obj3 = fVar.f5259c;
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int Y0 = t.Y0(bArr, i2, fVar);
                    int i13 = fVar.f5257a;
                    n0.d dVar = (n0.d) this.f5449b[((i9 / 3) * 2) + 1];
                    if (dVar == null || dVar.a(i13)) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        unsafe.putInt(t, j4, i5);
                    } else {
                        p(t).c(i4, Long.valueOf((long) i13));
                    }
                    return Y0;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = t.Y0(bArr, i2, fVar);
                    i11 = k.b(fVar.f5257a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = t.c1(bArr, i2, fVar);
                    j3 = k.c(fVar.f5258b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = t.s0(o(i9), bArr, i2, i3, (i4 & -8) | 4, fVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = fVar.f5259c;
                    if (object2 != null) {
                        obj3 = n0.f(object2, obj3);
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
    public int I(T t, byte[] bArr, int i2, int i3, int i4, f fVar) {
        Unsafe unsafe;
        T t2;
        o1<T> o1Var;
        Throwable th;
        byte b2;
        int i5;
        int i6;
        T t3;
        int i7;
        o1<T> o1Var2;
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
        o1<T> o1Var3 = this;
        T t4 = t;
        byte[] bArr6 = bArr;
        int i35 = i3;
        f fVar2 = fVar;
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
                    int W0 = t.W0(b3, bArr6, i43, fVar2);
                    b2 = fVar2.f5257a;
                    i43 = W0;
                } else {
                    b2 = b3;
                }
                int i44 = b2 >>> 3;
                int i45 = b2 & 7;
                if (i44 > i41) {
                    int i46 = i38 / 3;
                    if (i44 < o1Var3.f5450c || i44 > o1Var3.f5451d) {
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
                            int i47 = o1Var3.f5448a[i5 + 1];
                            int T = T(i47);
                            long A = A(i47);
                            if (T <= 17) {
                                int i48 = o1Var3.f5448a[i5 + 2];
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
                                switch (T) {
                                    case 0:
                                        i15 = i44;
                                        i14 = i23;
                                        i17 = b2;
                                        i24 = i5;
                                        i25 = i43;
                                        if (i45 == 1) {
                                            v2.w(t4, A, t.k0(bArr, i25));
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
                                            v2.f5899f.q(t4, A, t.q0(bArr, i25));
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
                                            i31 = t.c1(bArr2, i25, fVar2);
                                            j2 = fVar2.f5258b;
                                            bArr3 = bArr2;
                                            i29 = i28;
                                            unsafe2.putLong(t, A, j2);
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
                                            i36 = t.Y0(bArr2, i25, fVar2);
                                            i32 = fVar2.f5257a;
                                            unsafe2.putInt(t4, A, i32);
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
                                            unsafe2.putLong(t, A, t.o0(bArr4, i43));
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
                                            unsafe2.putInt(t4, A, t.m0(bArr4, i43));
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
                                            int c1 = t.c1(bArr4, i43, fVar2);
                                            v2.f5899f.n(t4, A, fVar2.f5258b != 0);
                                            i36 = c1;
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
                                            i36 = (i47 & 536870912) == 0 ? t.Q0(bArr4, i43, fVar2) : t.S0(bArr4, i43, fVar2);
                                            obj = fVar2.f5259c;
                                            unsafe2.putObject(t4, A, obj);
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
                                            i36 = t.u0(o1Var3.o(i33), bArr4, i43, i3, fVar2);
                                            if ((i22 & i49) != 0) {
                                                obj = n0.f(unsafe2.getObject(t4, A), fVar2.f5259c);
                                                unsafe2.putObject(t4, A, obj);
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
                                            obj = fVar2.f5259c;
                                            unsafe2.putObject(t4, A, obj);
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
                                            i36 = t.i0(bArr5, i43, fVar2);
                                            unsafe2.putObject(t4, A, fVar2.f5259c);
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
                                            i36 = t.Y0(bArr5, i43, fVar2);
                                            i32 = fVar2.f5257a;
                                            n0.d m2 = o1Var3.m(i28);
                                            if (m2 != null && !m2.a(i32)) {
                                                p(t).c(i17, Long.valueOf((long) i32));
                                                i24 = i28;
                                                i26 = i22;
                                                i16 = i26;
                                                i13 = i24;
                                                break;
                                            }
                                            bArr2 = bArr5;
                                            unsafe2.putInt(t4, A, i32);
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
                                            i36 = t.Y0(bArr5, i43, fVar2);
                                            i32 = k.b(fVar2.f5257a);
                                            bArr2 = bArr5;
                                            unsafe2.putInt(t4, A, i32);
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
                                            i31 = t.c1(bArr5, i43, fVar2);
                                            j2 = k.c(fVar2.f5258b);
                                            bArr2 = bArr5;
                                            bArr3 = bArr2;
                                            i29 = i28;
                                            unsafe2.putLong(t, A, j2);
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
                                            i36 = t.s0(o1Var3.o(i5), bArr, i43, i3, (i44 << 3) | 4, fVar);
                                            unsafe2.putObject(t4, A, (i22 & i49) == 0 ? fVar2.f5259c : n0.f(unsafe2.getObject(t4, A), fVar2.f5259c));
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
                                if (T != 27) {
                                    i19 = i42;
                                    i9 = i5;
                                    if (T <= 49) {
                                        th2 = null;
                                        i18 = i16;
                                        unsafe = unsafe2;
                                        i20 = i17;
                                        i10 = i15;
                                        i36 = K(t, bArr, i43, i3, i17, i15, i45, i9, (long) i47, T, A, fVar);
                                    } else {
                                        i21 = i43;
                                        i20 = i17;
                                        unsafe = unsafe2;
                                        i18 = i16;
                                        i10 = i15;
                                        th2 = null;
                                        if (T != 50) {
                                            i36 = H(t, bArr, i21, i3, i20, i10, i45, i47, T, A, i9, fVar);
                                        } else if (i45 == 2) {
                                            G(t, bArr, i21, i3, i9, A, fVar);
                                            throw null;
                                        }
                                    }
                                    o1Var2 = this;
                                    t3 = t;
                                    i8 = i20;
                                    i37 = i4;
                                    fVar2 = fVar;
                                    i7 = i10;
                                    i42 = i19;
                                    i38 = i9;
                                    i40 = i18;
                                    i39 = i8;
                                    o1Var3 = o1Var2;
                                    i41 = i7;
                                    t4 = t3;
                                    unsafe2 = unsafe;
                                    bArr6 = bArr;
                                    i35 = i3;
                                } else if (i45 == 2) {
                                    n0.h hVar = (n0.h) unsafe2.getObject(t4, A);
                                    if (!hVar.m()) {
                                        int size = hVar.size();
                                        hVar = hVar.i(size == 0 ? 10 : size * 2);
                                        unsafe2.putObject(t4, A, hVar);
                                    }
                                    i14 = i42;
                                    i13 = i5;
                                    i36 = t.w0(o1Var3.o(i5), i17, bArr, i43, i3, hVar, fVar);
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
                            o1Var2 = this;
                            if (!o1Var2.f5453f) {
                                fVar2 = fVar;
                                if (fVar2.f5260d != z.a()) {
                                    i7 = i10;
                                    k0.d<?, ?> dVar = fVar2.f5260d.f5943a.get(new z.a(o1Var2.f5452e, i7));
                                    if (dVar == null) {
                                        i36 = t.U0(i8, bArr, i12, i3, p(t), fVar);
                                        t3 = t;
                                        i37 = i11;
                                        i38 = i9;
                                        i39 = i8;
                                        o1Var3 = o1Var2;
                                        i41 = i7;
                                        t4 = t3;
                                        unsafe2 = unsafe;
                                        bArr6 = bArr;
                                        i35 = i3;
                                    } else {
                                        t.k();
                                        if (dVar.f5354a != null) {
                                            throw th2;
                                        }
                                        throw th2;
                                    }
                                } else {
                                    t3 = t;
                                }
                            } else {
                                t3 = t;
                                fVar2 = fVar;
                            }
                            i7 = i10;
                            i36 = t.U0(i8, bArr, i12, i3, p(t), fVar);
                            i37 = i11;
                            i38 = i9;
                            i39 = i8;
                            o1Var3 = o1Var2;
                            i41 = i7;
                            t4 = t3;
                            unsafe2 = unsafe;
                            bArr6 = bArr;
                            i35 = i3;
                        } else {
                            o1Var = this;
                            t2 = t;
                            i36 = i12;
                            i37 = i11;
                            i39 = i8;
                            th = th2;
                        }
                    } else {
                        i34 = o1Var3.S(i44, i46);
                    }
                } else {
                    i34 = o1Var3.L(i44);
                }
                i5 = i34;
                i6 = -1;
                if (i5 != i6) {
                }
                if (i8 == i11) {
                }
                o1Var2 = this;
                if (!o1Var2.f5453f) {
                }
                i7 = i10;
                i36 = t.U0(i8, bArr, i12, i3, p(t), fVar);
                i37 = i11;
                i38 = i9;
                i39 = i8;
                o1Var3 = o1Var2;
                i41 = i7;
                t4 = t3;
                unsafe2 = unsafe;
                bArr6 = bArr;
                i35 = i3;
            } else {
                unsafe = unsafe2;
                t2 = t4;
                o1Var = o1Var3;
                th = null;
            }
        }
        if (i42 != -1) {
            unsafe.putInt(t2, (long) i42, i40);
        }
        for (int i51 = o1Var.k; i51 < o1Var.l; i51++) {
            o1Var.l(t2, o1Var.j[i51], th, (p2<UT, UB>) o1Var.o);
        }
        if (i37 == 0) {
            if (i36 != i3) {
                throw o0.g();
            }
        } else if (i36 > i3 || i39 != i37) {
            throw o0.g();
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
    public final int J(T t, byte[] bArr, int i2, int i3, f fVar) {
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
        o1<T> o1Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i16 = i3;
        f fVar2 = fVar;
        Unsafe unsafe2 = s;
        int i17 = -1;
        int i18 = i2;
        int i19 = -1;
        int i20 = 0;
        while (i18 < i16) {
            int i21 = i18 + 1;
            byte b3 = bArr2[i18];
            if (b3 < 0) {
                i4 = t.W0(b3, bArr2, i21, fVar2);
                b2 = fVar2.f5257a;
            } else {
                b2 = b3;
                i4 = i21;
            }
            int i22 = b2 >>> 3;
            int i23 = b2 & 7;
            if (i22 > i19) {
                int i24 = i20 / 3;
                if (i22 < o1Var.f5450c || i22 > o1Var.f5451d) {
                    i5 = i17;
                    if (i5 != i17) {
                        i7 = i22;
                        i9 = i4;
                        unsafe = unsafe2;
                        i6 = i17;
                        i8 = 0;
                    } else {
                        int i25 = o1Var.f5448a[i5 + 1];
                        int T = T(i25);
                        long A = A(i25);
                        if (T <= 17) {
                            boolean z = true;
                            switch (T) {
                                case 0:
                                    i12 = i5;
                                    if (i23 == 1) {
                                        v2.w(t2, A, t.k0(bArr2, i4));
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
                                        v2.f5899f.q(t2, A, t.q0(bArr2, i4));
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
                                    j3 = A;
                                    i12 = i5;
                                    if (i23 == 0) {
                                        i13 = t.c1(bArr2, i4, fVar2);
                                        j2 = fVar2.f5258b;
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
                                    j4 = A;
                                    i12 = i5;
                                    break;
                                case 5:
                                case 14:
                                    if (i23 == 1) {
                                        i12 = i5;
                                        unsafe2.putLong(t, A, t.o0(bArr2, i4));
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
                                        unsafe2.putInt(t2, A, t.m0(bArr2, i4));
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
                                        int c1 = t.c1(bArr2, i4, fVar2);
                                        if (fVar2.f5258b == 0) {
                                            z = false;
                                        }
                                        v2.f5899f.n(t2, A, z);
                                        i18 = c1;
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
                                        i18 = (536870912 & i25) == 0 ? t.Q0(bArr2, i4, fVar2) : t.S0(bArr2, i4, fVar2);
                                        obj = fVar2.f5259c;
                                        unsafe2.putObject(t2, A, obj);
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
                                        i18 = t.u0(o1Var.o(i5), bArr2, i4, i16, fVar2);
                                        Object object = unsafe2.getObject(t2, A);
                                        if (object != null) {
                                            obj = n0.f(object, fVar2.f5259c);
                                            unsafe2.putObject(t2, A, obj);
                                            i11 = i5;
                                            break;
                                        }
                                        obj = fVar2.f5259c;
                                        unsafe2.putObject(t2, A, obj);
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
                                        i18 = t.i0(bArr2, i4, fVar2);
                                        obj = fVar2.f5259c;
                                        unsafe2.putObject(t2, A, obj);
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
                                        j4 = A;
                                        i12 = i5;
                                        i18 = t.Y0(bArr2, i4, fVar2);
                                        i14 = fVar2.f5257a;
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
                                        i18 = t.Y0(bArr2, i4, fVar2);
                                        i12 = i5;
                                        i14 = k.b(fVar2.f5257a);
                                        j4 = A;
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
                                        i13 = t.c1(bArr2, i4, fVar2);
                                        j3 = A;
                                        i12 = i5;
                                        j2 = k.c(fVar2.f5258b);
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
                        } else if (T == 27) {
                            if (i23 == 2) {
                                n0.h hVar = (n0.h) unsafe2.getObject(t2, A);
                                if (!hVar.m()) {
                                    int size = hVar.size();
                                    hVar = hVar.i(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t2, A, hVar);
                                }
                                i11 = i5;
                                i18 = t.w0(o1Var.o(i5), b2, bArr, i4, i3, hVar, fVar);
                            }
                            i8 = i5;
                            i7 = i22;
                            i10 = i4;
                            unsafe = unsafe2;
                            i6 = -1;
                            i9 = i10;
                        } else {
                            i8 = i5;
                            if (T <= 49) {
                                i7 = i22;
                                unsafe = unsafe2;
                                i6 = -1;
                                i18 = K(t, bArr, i4, i3, b2, i22, i23, i8, (long) i25, T, A, fVar);
                            } else {
                                i7 = i22;
                                i10 = i4;
                                unsafe = unsafe2;
                                i6 = -1;
                                if (T == 50) {
                                    if (i23 == 2) {
                                        G(t, bArr, i10, i3, i8, A, fVar);
                                        throw null;
                                    }
                                    i9 = i10;
                                } else {
                                    i18 = H(t, bArr, i10, i3, b2, i7, i23, i25, T, A, i8, fVar);
                                }
                            }
                            i9 = i18;
                        }
                        i19 = i22;
                        i20 = i11;
                        i17 = -1;
                    }
                    i18 = t.U0(b2, bArr, i9, i3, p(t), fVar);
                    i20 = i8;
                    o1Var = this;
                    t2 = t;
                    bArr2 = bArr;
                    i16 = i3;
                    fVar2 = fVar;
                    unsafe2 = unsafe;
                    i19 = i7;
                    i17 = i6;
                } else {
                    i15 = o1Var.S(i22, i24);
                }
            } else {
                i15 = o1Var.L(i22);
            }
            i5 = i15;
            if (i5 != i17) {
            }
            i18 = t.U0(b2, bArr, i9, i3, p(t), fVar);
            i20 = i8;
            o1Var = this;
            t2 = t;
            bArr2 = bArr;
            i16 = i3;
            fVar2 = fVar;
            unsafe2 = unsafe;
            i19 = i7;
            i17 = i6;
        }
        if (i18 == i16) {
            return i18;
        }
        throw o0.g();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0228, code lost:
        if (r30.f5258b != 0) goto L_0x0245;
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
        r4 = b.x.t.Y0(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0237, code lost:
        if (r21 == r30.f5257a) goto L_0x023b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x023b, code lost:
        r1 = b.x.t.c1(r18, r4, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0243, code lost:
        if (r30.f5258b == 0) goto L_0x022b;
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
        r11.add(c.b.d.j.g(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011b, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x011d, code lost:
        r4 = b.x.t.Y0(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0123, code lost:
        if (r21 == r30.f5257a) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0127, code lost:
        r1 = b.x.t.Y0(r18, r4, r30);
        r4 = r30.f5257a;
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
        r11.add(c.b.d.j.f5320c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013f, code lost:
        throw c.b.d.o0.i();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0144, code lost:
        throw c.b.d.o0.f();
     */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d8  */
    public final int K(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, f fVar) {
        int c1;
        int i9;
        int Y0;
        int c12;
        int i10 = i2;
        n0.h hVar = (n0.h) s.getObject(t, j3);
        if (!hVar.m()) {
            int size = hVar.size();
            hVar = hVar.i(size == 0 ? 10 : size * 2);
            s.putObject(t, j3, hVar);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    return t.A0(bArr, i10, hVar, fVar);
                }
                if (i6 == 1) {
                    t tVar = (t) hVar;
                    double k0 = t.k0(bArr, i2);
                    while (true) {
                        tVar.c(k0);
                        int i11 = i10 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i10 = t.Y0(bArr, i11, fVar);
                        if (i4 != fVar.f5257a) {
                            return i11;
                        }
                        k0 = t.k0(bArr, i10);
                    }
                }
                break;
            case 19:
            case 36:
                if (i6 == 2) {
                    return t.G0(bArr, i10, hVar, fVar);
                }
                if (i6 == 5) {
                    h0 h0Var = (h0) hVar;
                    float q0 = t.q0(bArr, i2);
                    while (true) {
                        h0Var.c(q0);
                        int i12 = i10 + 4;
                        if (i12 >= i3) {
                            return i12;
                        }
                        i10 = t.Y0(bArr, i12, fVar);
                        if (i4 != fVar.f5257a) {
                            return i12;
                        }
                        q0 = t.q0(bArr, i10);
                    }
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    return t.O0(bArr, i10, hVar, fVar);
                }
                if (i6 == 0) {
                    v0 v0Var = (v0) hVar;
                    do {
                        c1 = t.c1(bArr, i10, fVar);
                        v0Var.c(fVar.f5258b);
                        if (c1 >= i3) {
                            return c1;
                        }
                        i10 = t.Y0(bArr, c1, fVar);
                    } while (i4 == fVar.f5257a);
                    return c1;
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return t.M0(bArr, i10, hVar, fVar);
                }
                if (i6 == 0) {
                    return t.a1(i4, bArr, i2, i3, hVar, fVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    return t.E0(bArr, i10, hVar, fVar);
                }
                if (i6 == 1) {
                    v0 v0Var2 = (v0) hVar;
                    long o0 = t.o0(bArr, i2);
                    while (true) {
                        v0Var2.c(o0);
                        int i13 = i10 + 8;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i10 = t.Y0(bArr, i13, fVar);
                        if (i4 != fVar.f5257a) {
                            return i13;
                        }
                        o0 = t.o0(bArr, i10);
                    }
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    return t.C0(bArr, i10, hVar, fVar);
                }
                if (i6 == 5) {
                    m0 m0Var = (m0) hVar;
                    int m0 = t.m0(bArr, i2);
                    while (true) {
                        m0Var.c(m0);
                        int i14 = i10 + 4;
                        if (i14 >= i3) {
                            return i14;
                        }
                        i10 = t.Y0(bArr, i14, fVar);
                        if (i4 != fVar.f5257a) {
                            return i14;
                        }
                        m0 = t.m0(bArr, i10);
                    }
                }
                break;
            case 25:
            case 42:
                if (i6 != 2) {
                    if (i6 == 0) {
                        g gVar = (g) hVar;
                        int c13 = t.c1(bArr, i10, fVar);
                        break;
                    }
                } else {
                    return t.y0(bArr, i10, hVar, fVar);
                }
                break;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int Y02 = t.Y0(bArr, i10, fVar);
                        int i15 = fVar.f5257a;
                        if (i15 >= 0) {
                            if (i15 != 0) {
                                String str = new String(bArr, Y02, i15, n0.f5438a);
                                hVar.add(str);
                                Y02 += i15;
                                if (Y02 < i3) {
                                    int Y03 = t.Y0(bArr, Y02, fVar);
                                    if (i4 != fVar.f5257a) {
                                        return Y02;
                                    }
                                    Y02 = t.Y0(bArr, Y03, fVar);
                                    i15 = fVar.f5257a;
                                    if (i15 >= 0) {
                                        if (i15 != 0) {
                                            str = new String(bArr, Y02, i15, n0.f5438a);
                                            hVar.add(str);
                                            Y02 += i15;
                                            if (Y02 < i3) {
                                                return Y02;
                                            }
                                        }
                                    }
                                    throw o0.f();
                                    return Y02;
                                }
                                return Y02;
                            }
                            hVar.add("");
                            if (Y02 < i3) {
                            }
                            return Y02;
                        }
                        throw o0.f();
                    }
                    int Y04 = t.Y0(bArr, i10, fVar);
                    int i16 = fVar.f5257a;
                    if (i16 >= 0) {
                        if (i16 != 0) {
                            int i17 = Y04 + i16;
                            if (w2.h(bArr, Y04, i17)) {
                                String str2 = new String(bArr, Y04, i16, n0.f5438a);
                                hVar.add(str2);
                                Y04 = i17;
                                if (Y04 < i3) {
                                    int Y05 = t.Y0(bArr, Y04, fVar);
                                    if (i4 != fVar.f5257a) {
                                        return Y04;
                                    }
                                    Y04 = t.Y0(bArr, Y05, fVar);
                                    int i18 = fVar.f5257a;
                                    if (i18 >= 0) {
                                        if (i18 != 0) {
                                            i17 = Y04 + i18;
                                            if (w2.h(bArr, Y04, i17)) {
                                                str2 = new String(bArr, Y04, i18, n0.f5438a);
                                                hVar.add(str2);
                                                Y04 = i17;
                                                if (Y04 < i3) {
                                                    return Y04;
                                                }
                                            }
                                            throw o0.c();
                                        }
                                    }
                                    throw o0.f();
                                    return Y04;
                                }
                                return Y04;
                            }
                            throw o0.c();
                        }
                        hVar.add("");
                        if (Y04 < i3) {
                        }
                        return Y04;
                    }
                    throw o0.f();
                }
                break;
            case 27:
                if (i6 == 2) {
                    return t.w0(o(i7), i4, bArr, i2, i3, hVar, fVar);
                }
                break;
            case 28:
                if (i6 == 2) {
                    int Y06 = t.Y0(bArr, i10, fVar);
                    int i19 = fVar.f5257a;
                    if (i19 < 0) {
                        throw o0.f();
                    } else if (i19 > bArr.length - Y06) {
                        throw o0.i();
                    }
                }
                break;
            case 30:
            case 44:
                if (i6 == 2) {
                    i9 = t.M0(bArr, i10, hVar, fVar);
                } else if (i6 == 0) {
                    i9 = t.a1(i4, bArr, i2, i3, hVar, fVar);
                }
                T t2 = t;
                r2 r2Var = t2.f5348b;
                if (r2Var == r2.f5781f) {
                    r2Var = null;
                }
                r2 r2Var2 = (r2) f2.z(i5, hVar, (n0.d) this.f5449b[((i7 / 3) * 2) + 1], r2Var, this.o);
                if (r2Var2 != null) {
                    t2.f5348b = r2Var2;
                }
                return i9;
            case 33:
            case 47:
                if (i6 == 2) {
                    return t.I0(bArr, i10, hVar, fVar);
                }
                if (i6 == 0) {
                    m0 m0Var2 = (m0) hVar;
                    do {
                        Y0 = t.Y0(bArr, i10, fVar);
                        m0Var2.c(k.b(fVar.f5257a));
                        if (Y0 >= i3) {
                            return Y0;
                        }
                        i10 = t.Y0(bArr, Y0, fVar);
                    } while (i4 == fVar.f5257a);
                    return Y0;
                }
                break;
            case 34:
            case 48:
                if (i6 == 2) {
                    return t.K0(bArr, i10, hVar, fVar);
                }
                if (i6 == 0) {
                    v0 v0Var3 = (v0) hVar;
                    do {
                        c12 = t.c1(bArr, i10, fVar);
                        v0Var3.c(k.c(fVar.f5258b));
                        if (c12 >= i3) {
                            return c12;
                        }
                        i10 = t.Y0(bArr, c12, fVar);
                    } while (i4 == fVar.f5257a);
                    return c12;
                }
                break;
            case 49:
                if (i6 == 3) {
                    d2 o2 = o(i7);
                    int i20 = (i4 & -8) | 4;
                    i10 = t.s0(o2, bArr, i2, i3, i20, fVar);
                    while (true) {
                        hVar.add(fVar.f5259c);
                        if (i10 >= i3) {
                            break;
                        } else {
                            int Y07 = t.Y0(bArr, i10, fVar);
                            if (i4 != fVar.f5257a) {
                                break;
                            } else {
                                i10 = t.s0(o2, bArr, Y07, i3, i20, fVar);
                            }
                        }
                    }
                }
                break;
        }
        return i10;
    }

    public final int L(int i2) {
        if (i2 < this.f5450c || i2 > this.f5451d) {
            return -1;
        }
        return S(i2, 0);
    }

    public final <E> void M(Object obj, long j2, b2 b2Var, d2<E> d2Var, z zVar) {
        b2Var.M(this.n.c(obj, j2), d2Var, zVar);
    }

    public final <E> void N(Object obj, int i2, b2 b2Var, d2<E> d2Var, z zVar) {
        b2Var.P(this.n.c(obj, A(i2)), d2Var, zVar);
    }

    public final void O(Object obj, int i2, b2 b2Var) {
        Object obj2;
        long j2;
        if ((536870912 & i2) != 0) {
            j2 = A(i2);
            obj2 = b2Var.A();
        } else if (this.f5454g) {
            j2 = A(i2);
            obj2 = b2Var.y();
        } else {
            j2 = A(i2);
            obj2 = b2Var.c();
        }
        v2.f5899f.t(obj, j2, obj2);
    }

    public final void P(Object obj, int i2, b2 b2Var) {
        if ((536870912 & i2) != 0) {
            b2Var.b(this.n.c(obj, A(i2)));
        } else {
            b2Var.H(this.n.c(obj, A(i2)));
        }
    }

    public final void Q(T t, int i2) {
        if (!this.h) {
            int i3 = this.f5448a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            v2.f5899f.r(t, j2, v2.n(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void R(T t, int i2, int i3) {
        v2.f5899f.r(t, (long) (this.f5448a[i3 + 2] & 1048575), i2);
    }

    public final int S(int i2, int i3) {
        int length = (this.f5448a.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f5448a[i5];
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

    public final int U(int i2) {
        return this.f5448a[i2 + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:171:0x0538  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    public final void V(T t, y2 y2Var) {
        Map.Entry<?, Object> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i2;
        Map.Entry<?, Object> entry2;
        int i3;
        if (this.f5453f) {
            f0<?> c2 = this.p.c(t);
            if (!c2.s()) {
                it = c2.w();
                entry = it.next();
                int i4 = -1;
                length = this.f5448a.length;
                Unsafe unsafe = s;
                i2 = 0;
                int i5 = 0;
                while (i2 < length) {
                    int U = U(i2);
                    int i6 = this.f5448a[i2];
                    int T = T(U);
                    if (this.h || T > 17) {
                        entry2 = entry;
                        i3 = 0;
                    } else {
                        int i7 = this.f5448a[i2 + 2];
                        int i8 = i7 & 1048575;
                        if (i8 != i4) {
                            i5 = unsafe.getInt(t, (long) i8);
                            i4 = i8;
                        }
                        i3 = 1 << (i7 >>> 20);
                        entry2 = entry;
                    }
                    while (entry2 != null && this.p.a(entry2) <= i6) {
                        this.p.j(y2Var, entry2);
                        entry2 = it.hasNext() ? it.next() : null;
                    }
                    long A = A(U);
                    switch (T) {
                        case 0:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.c0(i6, v2.l(t, A));
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 1:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).e(i6, v2.m(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 2:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.u0(i6, unsafe.getLong(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 3:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.u0(i6, unsafe.getLong(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 4:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.i0(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 5:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.f0(i6, unsafe.getLong(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 6:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.d0(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 7:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.Y(i6, v2.g(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 8:
                            if ((i3 & i5) != 0) {
                                X(i6, unsafe.getObject(t, A), y2Var);
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 9:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).h(i6, unsafe.getObject(t, A), o(i2));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 10:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.a0(i6, (j) unsafe.getObject(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 11:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.s0(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 12:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.i0(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 13:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.d0(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 14:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f5437a.f0(i6, unsafe.getLong(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 15:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).j(i6, unsafe.getInt(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 16:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).k(i6, unsafe.getLong(t, A));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 17:
                            if ((i3 & i5) != 0) {
                                ((n) y2Var).f(i6, unsafe.getObject(t, A), o(i2));
                            } else {
                                continue;
                            }
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 18:
                            f2.J(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 19:
                            f2.N(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 20:
                            f2.R(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 21:
                            f2.a0(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 22:
                            f2.Q(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 23:
                            f2.M(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 24:
                            f2.L(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 25:
                            f2.H(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 26:
                            f2.Y(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var);
                            break;
                        case 27:
                            f2.T(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, o(i2));
                            break;
                        case 28:
                            f2.I(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var);
                            break;
                        case 29:
                            f2.Z(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 30:
                            f2.K(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 31:
                            f2.U(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 32:
                            f2.V(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 33:
                            f2.W(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 34:
                            f2.X(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, false);
                            continue;
                            i2 += 3;
                            i4 = i4;
                            entry = entry2;
                        case 35:
                            f2.J(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 36:
                            f2.N(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 37:
                            f2.R(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 38:
                            f2.a0(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 39:
                            f2.Q(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 40:
                            f2.M(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 41:
                            f2.L(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 42:
                            f2.H(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 43:
                            f2.Z(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 44:
                            f2.K(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 45:
                            f2.U(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 46:
                            f2.V(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 47:
                            f2.W(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 48:
                            f2.X(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, true);
                            break;
                        case 49:
                            f2.P(this.f5448a[i2], (List) unsafe.getObject(t, A), y2Var, o(i2));
                            break;
                        case 50:
                            W(y2Var, i6, unsafe.getObject(t, A), i2);
                            break;
                        case 51:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.c0(i6, C(t, A));
                                break;
                            }
                            break;
                        case 52:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).e(i6, D(t, A));
                                break;
                            }
                            break;
                        case 53:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.u0(i6, F(t, A));
                                break;
                            }
                            break;
                        case 54:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.u0(i6, F(t, A));
                                break;
                            }
                            break;
                        case 55:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.i0(i6, E(t, A));
                                break;
                            }
                            break;
                        case 56:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.f0(i6, F(t, A));
                                break;
                            }
                            break;
                        case 57:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.d0(i6, E(t, A));
                                break;
                            }
                            break;
                        case 58:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.Y(i6, B(t, A));
                                break;
                            }
                            break;
                        case 59:
                            if (u(t, i6, i2)) {
                                X(i6, unsafe.getObject(t, A), y2Var);
                                break;
                            }
                            break;
                        case 60:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).h(i6, unsafe.getObject(t, A), o(i2));
                                break;
                            }
                            break;
                        case 61:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.a0(i6, (j) unsafe.getObject(t, A));
                                break;
                            }
                            break;
                        case 62:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.s0(i6, E(t, A));
                                break;
                            }
                            break;
                        case 63:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.i0(i6, E(t, A));
                                break;
                            }
                            break;
                        case 64:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.d0(i6, E(t, A));
                                break;
                            }
                            break;
                        case 65:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f5437a.f0(i6, F(t, A));
                                break;
                            }
                            break;
                        case 66:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).j(i6, E(t, A));
                                break;
                            }
                            break;
                        case 67:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).k(i6, F(t, A));
                                break;
                            }
                            break;
                        case 68:
                            if (u(t, i6, i2)) {
                                ((n) y2Var).f(i6, unsafe.getObject(t, A), o(i2));
                                break;
                            }
                            break;
                    }
                    i2 += 3;
                    i4 = i4;
                    entry = entry2;
                }
                while (entry != null) {
                    this.p.j(y2Var, entry);
                    entry = it.hasNext() ? it.next() : null;
                }
                p2<?, ?> p2Var = this.o;
                p2Var.s(p2Var.g(t), y2Var);
            }
        }
        it = null;
        entry = null;
        int i42 = -1;
        length = this.f5448a.length;
        Unsafe unsafe2 = s;
        i2 = 0;
        int i52 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        p2<?, ?> p2Var2 = this.o;
        p2Var2.s(p2Var2.g(t), y2Var);
    }

    public final <K, V> void W(y2 y2Var, int i2, Object obj, int i3) {
        if (obj != null) {
            this.q.h(this.f5449b[(i3 / 3) * 2]);
            Map<?, ?> b2 = this.q.b(obj);
            n nVar = (n) y2Var;
            if (nVar.f5437a != null) {
                Iterator<Map.Entry<?, ?>> it = b2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<?, ?> next = it.next();
                    nVar.f5437a.r0(i2, 2);
                    next.getKey();
                    next.getValue();
                    throw null;
                }
                return;
            }
            throw null;
        }
    }

    public final void X(int i2, Object obj, y2 y2Var) {
        if (obj instanceof String) {
            ((n) y2Var).f5437a.p0(i2, (String) obj);
            return;
        }
        ((n) y2Var).f5437a.a0(i2, (j) obj);
    }

    @Override // c.b.d.d2
    public void a(T t, T t2) {
        if (t2 != null) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.f5448a;
                if (i2 < iArr.length) {
                    int i3 = iArr[i2 + 1];
                    long A = A(i3);
                    int i4 = this.f5448a[i2];
                    switch (T(i3)) {
                        case 0:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                v2.w(t, A, v2.l(t2, A));
                                Q(t, i2);
                                break;
                            }
                        case 1:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                v2.f5899f.q(t, A, v2.m(t2, A));
                                Q(t, i2);
                                break;
                            }
                        case 2:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.z(t, A, v2.o(t2, A));
                            Q(t, i2);
                            break;
                        case 3:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.z(t, A, v2.o(t2, A));
                            Q(t, i2);
                            break;
                        case 4:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 5:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.z(t, A, v2.o(t2, A));
                            Q(t, i2);
                            break;
                        case 6:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 7:
                            if (!s(t2, i2)) {
                                break;
                            } else {
                                v2.f5899f.n(t, A, v2.g(t2, A));
                                Q(t, i2);
                                break;
                            }
                        case 8:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.t(t, A, v2.p(t2, A));
                            Q(t, i2);
                            break;
                        case 9:
                        case 17:
                            x(t, t2, i2);
                            break;
                        case 10:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.t(t, A, v2.p(t2, A));
                            Q(t, i2);
                            break;
                        case 11:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 12:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 13:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 14:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.z(t, A, v2.o(t2, A));
                            Q(t, i2);
                            break;
                        case 15:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.f5899f.r(t, A, v2.n(t2, A));
                            Q(t, i2);
                            break;
                        case 16:
                            if (!s(t2, i2)) {
                                break;
                            }
                            v2.z(t, A, v2.o(t2, A));
                            Q(t, i2);
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
                            this.n.b(t, t2, A);
                            break;
                        case 50:
                            f2.C(this.q, t, t2, A);
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
                            v2.f5899f.t(t, A, v2.p(t2, A));
                            R(t, i4, i2);
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
                            v2.f5899f.t(t, A, v2.p(t2, A));
                            R(t, i4, i2);
                            break;
                    }
                    i2 += 3;
                } else {
                    f2.D(this.o, t, t2);
                    if (this.f5453f) {
                        a0<?> a0Var = this.p;
                        f0<?> c2 = a0Var.c(t2);
                        if (!c2.s()) {
                            a0Var.d(t).y(c2);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        } else {
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0041, code lost:
        if (c.b.d.f2.F(c.b.d.v2.p(r10, r5), c.b.d.v2.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0065, code lost:
        if (c.b.d.f2.F(c.b.d.v2.p(r10, r5), c.b.d.v2.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
        if (c.b.d.v2.o(r10, r5) == c.b.d.v2.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008b, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (c.b.d.v2.o(r10, r5) == c.b.d.v2.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b1, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c3, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d5, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00eb, code lost:
        if (c.b.d.f2.F(c.b.d.v2.p(r10, r5), c.b.d.v2.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0101, code lost:
        if (c.b.d.f2.F(c.b.d.v2.p(r10, r5), c.b.d.v2.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0117, code lost:
        if (c.b.d.f2.F(c.b.d.v2.p(r10, r5), c.b.d.v2.p(r11, r5)) != false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0129, code lost:
        if (c.b.d.v2.g(r10, r5) == c.b.d.v2.g(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013b, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014f, code lost:
        if (c.b.d.v2.o(r10, r5) == c.b.d.v2.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0161, code lost:
        if (c.b.d.v2.n(r10, r5) == c.b.d.v2.n(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0174, code lost:
        if (c.b.d.v2.o(r10, r5) == c.b.d.v2.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0187, code lost:
        if (c.b.d.v2.o(r10, r5) == c.b.d.v2.o(r11, r5)) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01a0, code lost:
        if (java.lang.Float.floatToIntBits(c.b.d.v2.m(r10, r5)) == java.lang.Float.floatToIntBits(c.b.d.v2.m(r11, r5))) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01bb, code lost:
        if (java.lang.Double.doubleToLongBits(c.b.d.v2.l(r10, r5)) == java.lang.Double.doubleToLongBits(c.b.d.v2.l(r11, r5))) goto L_0x01bf;
     */
    @Override // c.b.d.d2
    public boolean b(T t, T t2) {
        int length = this.f5448a.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int i3 = this.f5448a[i2 + 1];
                long A = A(i3);
                switch (T(i3)) {
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
                        z = f2.F(v2.p(t, A), v2.p(t2, A));
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
                        long j2 = (long) (this.f5448a[i2 + 2] & 1048575);
                        if (v2.n(t, j2) == v2.n(t2, j2)) {
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
                if (this.f5453f) {
                    return this.p.c(t).equals(this.p.c(t2));
                }
                return true;
            }
        }
    }

    @Override // c.b.d.d2
    public T c() {
        return (T) this.m.a(this.f5452e);
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
    @Override // c.b.d.d2
    public int d(T t) {
        int i2;
        int i3;
        long j2;
        double d2;
        float f2;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.f5448a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 3) {
            int U = U(i5);
            int i6 = this.f5448a[i5];
            long A = A(U);
            int i7 = 37;
            switch (T(U)) {
                case 0:
                    i3 = i4 * 53;
                    d2 = v2.l(t, A);
                    j2 = Double.doubleToLongBits(d2);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    f2 = v2.m(t, A);
                    i2 = Float.floatToIntBits(f2);
                    i4 = i2 + i3;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i4 * 53;
                    j2 = v2.o(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i3 = i4 * 53;
                    i2 = v2.n(t, A);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    z = v2.g(t, A);
                    i2 = n0.c(z);
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) v2.p(t, A)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    obj = v2.p(t, A);
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
                    obj2 = v2.p(t, A);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 17:
                    obj = v2.p(t, A);
                    break;
                case 51:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        d2 = C(t, A);
                        j2 = Double.doubleToLongBits(d2);
                        i2 = n0.e(j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        f2 = D(t, A);
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
                    j2 = F(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 54:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = F(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 55:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 56:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = F(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 57:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 58:
                    if (u(t, i6, i5)) {
                        i3 = i4 * 53;
                        z = B(t, A);
                        i2 = n0.c(z);
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
                    i2 = ((String) v2.p(t, A)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 60:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    obj2 = v2.p(t, A);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 61:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    obj2 = v2.p(t, A);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 62:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 63:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 64:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 65:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = F(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 66:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = E(t, A);
                    i4 = i2 + i3;
                    break;
                case 67:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = F(t, A);
                    i2 = n0.e(j2);
                    i4 = i2 + i3;
                    break;
                case 68:
                    if (!u(t, i6, i5)) {
                        break;
                    }
                    obj2 = v2.p(t, A);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
            }
        }
        int hashCode = this.o.g(t).hashCode() + (i4 * 53);
        return this.f5453f ? (hashCode * 53) + this.p.c(t).hashCode() : hashCode;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v3, resolved type: c.b.d.d2 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: c.b.d.d2 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: c.b.d.d2 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.d.d2
    public final boolean e(T t) {
        int i2;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i4 >= this.k) {
                return !this.f5453f || this.p.c(t).t();
            }
            int i6 = this.j[i4];
            int i7 = this.f5448a[i6];
            int U = U(i6);
            if (!this.h) {
                int i8 = this.f5448a[i6 + 2];
                int i9 = 1048575 & i8;
                i2 = 1 << (i8 >>> 20);
                if (i9 != i3) {
                    i5 = s.getInt(t, (long) i9);
                    i3 = i9;
                }
            } else {
                i2 = 0;
            }
            if (((268435456 & U) != 0) && !t(t, i6, i5, i2)) {
                return false;
            }
            int T = T(U);
            if (T != 9 && T != 17) {
                if (T != 27) {
                    if (T == 60 || T == 68) {
                        if (u(t, i7, i6) && !o(i6).e(v2.p(t, A(U)))) {
                            return false;
                        }
                    } else if (T != 49) {
                        if (T == 50 && !this.q.b(v2.p(t, A(U))).isEmpty()) {
                            this.q.h(this.f5449b[(i6 / 3) * 2]);
                            throw null;
                        }
                    }
                }
                List list = (List) v2.p(t, A(U));
                if (!list.isEmpty()) {
                    d2 o2 = o(i6);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!o2.e(list.get(i10))) {
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
            } else if (t(t, i6, i5, i2) && !o(i6).e(v2.p(t, A(U)))) {
                return false;
            }
            i4++;
        }
    }

    @Override // c.b.d.d2
    public int f(T t) {
        return this.h ? r(t) : q(t);
    }

    @Override // c.b.d.d2
    public void g(T t) {
        int i2;
        int i3 = this.k;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            long A = A(U(this.j[i3]));
            Object p2 = v2.p(t, A);
            if (p2 != null) {
                v2.f5899f.t(t, A, this.q.g(p2));
            }
            i3++;
        }
        int length = this.j.length;
        while (i2 < length) {
            this.n.a(t, (long) this.j[i2]);
            i2++;
        }
        this.o.j(t);
        if (this.f5453f) {
            this.p.f(t);
        }
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.instructions.IfNode.isSame(IfNode.java:122)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // c.b.d.d2
    public void h(T r17, c.b.d.b2 r18, c.b.d.z r19) {
        /*
        // Method dump skipped, instructions count: 1430
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.d.o1.h(java.lang.Object, c.b.d.b2, c.b.d.z):void");
    }

    @Override // c.b.d.d2
    public void i(T t, byte[] bArr, int i2, int i3, f fVar) {
        if (this.h) {
            J(t, bArr, i2, i3, fVar);
        } else {
            I(t, bArr, i2, i3, 0, fVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x054a  */
    @Override // c.b.d.d2
    public void j(T t, y2 y2Var) {
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
        n nVar = (n) y2Var;
        if (nVar == null) {
            throw null;
        } else if (this.h) {
            if (this.f5453f) {
                f0<?> c2 = this.p.c(t);
                if (!c2.s()) {
                    it = c2.w();
                    entry = it.next();
                    length = this.f5448a.length;
                    for (i2 = 0; i2 < length; i2 += 3) {
                        int U = U(i2);
                        int i9 = this.f5448a[i2];
                        while (entry != null && this.p.a(entry) <= i9) {
                            this.p.j(y2Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        switch (T(U)) {
                            case 0:
                                if (s(t, i2)) {
                                    d2 = v2.l(t, A(U));
                                    nVar.f5437a.c0(i9, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 1:
                                if (s(t, i2)) {
                                    f2 = v2.m(t, A(U));
                                    nVar.e(i9, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 2:
                                if (s(t, i2)) {
                                    j2 = v2.o(t, A(U));
                                    nVar.f5437a.u0(i9, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 3:
                                if (s(t, i2)) {
                                    j3 = v2.o(t, A(U));
                                    nVar.f5437a.u0(i9, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 4:
                                if (s(t, i2)) {
                                    i3 = v2.n(t, A(U));
                                    nVar.f5437a.i0(i9, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 5:
                                if (s(t, i2)) {
                                    j4 = v2.o(t, A(U));
                                    nVar.f5437a.f0(i9, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 6:
                                if (s(t, i2)) {
                                    i4 = v2.n(t, A(U));
                                    nVar.f5437a.d0(i9, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 7:
                                if (s(t, i2)) {
                                    z = v2.g(t, A(U));
                                    nVar.f5437a.Y(i9, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 8:
                                if (!s(t, i2)) {
                                    break;
                                }
                                X(i9, v2.p(t, A(U)), y2Var);
                                break;
                            case 9:
                                if (!s(t, i2)) {
                                    break;
                                }
                                nVar.h(i9, v2.p(t, A(U)), o(i2));
                                break;
                            case 10:
                                if (!s(t, i2)) {
                                    break;
                                }
                                nVar.f5437a.a0(i9, (j) v2.p(t, A(U)));
                                break;
                            case 11:
                                if (s(t, i2)) {
                                    i5 = v2.n(t, A(U));
                                    nVar.f5437a.s0(i9, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 12:
                                if (s(t, i2)) {
                                    i6 = v2.n(t, A(U));
                                    nVar.f5437a.i0(i9, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 13:
                                if (s(t, i2)) {
                                    i7 = v2.n(t, A(U));
                                    nVar.f5437a.d0(i9, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 14:
                                if (s(t, i2)) {
                                    j5 = v2.o(t, A(U));
                                    nVar.f5437a.f0(i9, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 15:
                                if (s(t, i2)) {
                                    i8 = v2.n(t, A(U));
                                    nVar.j(i9, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 16:
                                if (s(t, i2)) {
                                    j6 = v2.o(t, A(U));
                                    nVar.k(i9, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 17:
                                if (!s(t, i2)) {
                                    break;
                                }
                                nVar.f(i9, v2.p(t, A(U)), o(i2));
                                break;
                            case 18:
                                f2.J(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 19:
                                f2.N(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 20:
                                f2.R(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 21:
                                f2.a0(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 22:
                                f2.Q(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 23:
                                f2.M(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 24:
                                f2.L(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 25:
                                f2.H(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 26:
                                f2.Y(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var);
                                break;
                            case 27:
                                f2.T(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, o(i2));
                                break;
                            case 28:
                                f2.I(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var);
                                break;
                            case 29:
                                f2.Z(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 30:
                                f2.K(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 31:
                                f2.U(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 32:
                                f2.V(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 33:
                                f2.W(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 34:
                                f2.X(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, false);
                                break;
                            case 35:
                                f2.J(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 36:
                                f2.N(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 37:
                                f2.R(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 38:
                                f2.a0(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 39:
                                f2.Q(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 40:
                                f2.M(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 41:
                                f2.L(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 42:
                                f2.H(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 43:
                                f2.Z(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 44:
                                f2.K(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 45:
                                f2.U(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 46:
                                f2.V(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 47:
                                f2.W(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 48:
                                f2.X(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, true);
                                break;
                            case 49:
                                f2.P(this.f5448a[i2], (List) v2.p(t, A(U)), y2Var, o(i2));
                                break;
                            case 50:
                                W(y2Var, i9, v2.p(t, A(U)), i2);
                                break;
                            case 51:
                                if (u(t, i9, i2)) {
                                    d2 = C(t, A(U));
                                    nVar.f5437a.c0(i9, d2);
                                    break;
                                } else {
                                    break;
                                }
                            case 52:
                                if (u(t, i9, i2)) {
                                    f2 = D(t, A(U));
                                    nVar.e(i9, f2);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                if (u(t, i9, i2)) {
                                    j2 = F(t, A(U));
                                    nVar.f5437a.u0(i9, j2);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                if (u(t, i9, i2)) {
                                    j3 = F(t, A(U));
                                    nVar.f5437a.u0(i9, j3);
                                    break;
                                } else {
                                    break;
                                }
                            case 55:
                                if (u(t, i9, i2)) {
                                    i3 = E(t, A(U));
                                    nVar.f5437a.i0(i9, i3);
                                    break;
                                } else {
                                    break;
                                }
                            case 56:
                                if (u(t, i9, i2)) {
                                    j4 = F(t, A(U));
                                    nVar.f5437a.f0(i9, j4);
                                    break;
                                } else {
                                    break;
                                }
                            case 57:
                                if (u(t, i9, i2)) {
                                    i4 = E(t, A(U));
                                    nVar.f5437a.d0(i9, i4);
                                    break;
                                } else {
                                    break;
                                }
                            case 58:
                                if (u(t, i9, i2)) {
                                    z = B(t, A(U));
                                    nVar.f5437a.Y(i9, z);
                                    break;
                                } else {
                                    break;
                                }
                            case 59:
                                if (!u(t, i9, i2)) {
                                    break;
                                }
                                X(i9, v2.p(t, A(U)), y2Var);
                                break;
                            case 60:
                                if (!u(t, i9, i2)) {
                                    break;
                                }
                                nVar.h(i9, v2.p(t, A(U)), o(i2));
                                break;
                            case 61:
                                if (!u(t, i9, i2)) {
                                    break;
                                }
                                nVar.f5437a.a0(i9, (j) v2.p(t, A(U)));
                                break;
                            case 62:
                                if (u(t, i9, i2)) {
                                    i5 = E(t, A(U));
                                    nVar.f5437a.s0(i9, i5);
                                    break;
                                } else {
                                    break;
                                }
                            case 63:
                                if (u(t, i9, i2)) {
                                    i6 = E(t, A(U));
                                    nVar.f5437a.i0(i9, i6);
                                    break;
                                } else {
                                    break;
                                }
                            case 64:
                                if (u(t, i9, i2)) {
                                    i7 = E(t, A(U));
                                    nVar.f5437a.d0(i9, i7);
                                    break;
                                } else {
                                    break;
                                }
                            case 65:
                                if (u(t, i9, i2)) {
                                    j5 = F(t, A(U));
                                    nVar.f5437a.f0(i9, j5);
                                    break;
                                } else {
                                    break;
                                }
                            case 66:
                                if (u(t, i9, i2)) {
                                    i8 = E(t, A(U));
                                    nVar.j(i9, i8);
                                    break;
                                } else {
                                    break;
                                }
                            case 67:
                                if (u(t, i9, i2)) {
                                    j6 = F(t, A(U));
                                    nVar.k(i9, j6);
                                    break;
                                } else {
                                    break;
                                }
                            case 68:
                                if (!u(t, i9, i2)) {
                                    break;
                                }
                                nVar.f(i9, v2.p(t, A(U)), o(i2));
                                break;
                        }
                    }
                    while (entry != null) {
                        this.p.j(y2Var, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    p2<?, ?> p2Var = this.o;
                    p2Var.s(p2Var.g(t), y2Var);
                }
            }
            it = null;
            entry = null;
            length = this.f5448a.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            p2<?, ?> p2Var2 = this.o;
            p2Var2.s(p2Var2.g(t), y2Var);
        } else {
            V(t, y2Var);
        }
    }

    public final boolean k(T t, T t2, int i2) {
        return s(t, i2) == s(t2, i2);
    }

    public final <UT, UB> UB l(Object obj, int i2, UB ub, p2<UT, UB> p2Var) {
        int[] iArr = this.f5448a;
        int i3 = iArr[i2];
        Object p2 = v2.p(obj, A(iArr[i2 + 1]));
        if (p2 == null) {
            return ub;
        }
        int i4 = (i2 / 3) * 2;
        n0.d dVar = (n0.d) this.f5449b[i4 + 1];
        if (dVar == null) {
            return ub;
        }
        Map<?, ?> e2 = this.q.e(p2);
        this.q.h(this.f5449b[i4]);
        for (Map.Entry<?, ?> entry : e2.entrySet()) {
            if (!dVar.a(((Integer) entry.getValue()).intValue())) {
                if (ub == null) {
                    p2Var.m();
                }
                entry.getKey();
                entry.getValue();
                throw null;
            }
        }
        return ub;
    }

    public final n0.d m(int i2) {
        return (n0.d) this.f5449b[((i2 / 3) * 2) + 1];
    }

    public final Object n(int i2) {
        return this.f5449b[(i2 / 3) * 2];
    }

    public final d2 o(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.f5449b;
        d2 d2Var = (d2) objArr[i3];
        if (d2Var != null) {
            return d2Var;
        }
        d2<T> a2 = z1.f5964c.a((Class) objArr[i3 + 1]);
        this.f5449b[i3] = a2;
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
        r5 = r5 + ((c.b.d.m.P(r7) + c.b.d.m.N(r8)) + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x037d, code lost:
        if ((r7 instanceof c.b.d.j) != false) goto L_0x037f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x037f, code lost:
        r7 = c.b.d.m.f(r8, (c.b.d.j) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0386, code lost:
        r7 = c.b.d.m.L(r8, (java.lang.String) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x038c, code lost:
        r5 = r5 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c1, code lost:
        if ((r7 instanceof c.b.d.j) != false) goto L_0x037f;
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
        int c2;
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
        for (int i12 = 0; i12 < this.f5448a.length; i12 += 3) {
            int U = U(i12);
            int i13 = this.f5448a[i12];
            int T = T(U);
            if (T <= 17) {
                i3 = this.f5448a[i12 + 2];
                int i14 = 1048575 & i3;
                i2 = 1 << (i3 >>> 20);
                if (i14 != i9) {
                    i11 = unsafe.getInt(t, (long) i14);
                    i9 = i14;
                }
            } else {
                i3 = (!this.i || T < g0.DOUBLE_LIST_PACKED.f5280c || T > g0.SINT64_LIST_PACKED.f5280c) ? 0 : this.f5448a[i12 + 2] & 1048575;
                i2 = 0;
            }
            long A = A(U);
            switch (T) {
                case 0:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.h(i13, 0.0d);
                    i10 += c2;
                    break;
                case 1:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.o(i13, 0.0f);
                    i10 += c2;
                    break;
                case 2:
                    if ((i11 & i2) != 0) {
                        j2 = unsafe.getLong(t, A);
                        c2 = m.u(i13, j2);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i11 & i2) != 0) {
                        j3 = unsafe.getLong(t, A);
                        c2 = m.Q(i13, j3);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i11 & i2) != 0) {
                        i4 = unsafe.getInt(t, A);
                        c2 = m.s(i13, i4);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.m(i13, 0);
                    i10 += c2;
                    break;
                case 6:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.k(i13, 0);
                    i10 += c2;
                    break;
                case 7:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.c(i13, true);
                    i10 += c2;
                    break;
                case 8:
                    if ((i11 & i2) != 0) {
                        obj = unsafe.getObject(t, A);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = f2.o(i13, unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
                case 10:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.f(i13, (j) unsafe.getObject(t, A));
                    i10 += c2;
                    break;
                case 11:
                    if ((i11 & i2) != 0) {
                        i5 = unsafe.getInt(t, A);
                        c2 = m.O(i13, i5);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i11 & i2) != 0) {
                        i6 = unsafe.getInt(t, A);
                        c2 = m.j(i13, i6);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.D(i13, 0);
                    i10 += c2;
                    break;
                case 14:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.F(i13, 0);
                    i10 += c2;
                    break;
                case 15:
                    if ((i11 & i2) != 0) {
                        i7 = unsafe.getInt(t, A);
                        c2 = m.H(i13, i7);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i11 & i2) != 0) {
                        j4 = unsafe.getLong(t, A);
                        c2 = m.J(i13, j4);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i11 & i2) == 0) {
                        break;
                    }
                    c2 = m.q(i13, (i1) unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
                case 18:
                case 23:
                case 32:
                    c2 = f2.h(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 19:
                case 24:
                case 31:
                    c2 = f2.f(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 20:
                    c2 = f2.m(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 21:
                    c2 = f2.x(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 22:
                    c2 = f2.k(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 25:
                    c2 = f2.a(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 26:
                    c2 = f2.u(i13, (List) unsafe.getObject(t, A));
                    i10 += c2;
                    break;
                case 27:
                    c2 = f2.p(i13, (List) unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
                case 28:
                    c2 = f2.c(i13, (List) unsafe.getObject(t, A));
                    i10 += c2;
                    break;
                case 29:
                    c2 = f2.v(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 30:
                    c2 = f2.d(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 33:
                    c2 = f2.q(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 34:
                    c2 = f2.s(i13, (List) unsafe.getObject(t, A), false);
                    i10 += c2;
                    break;
                case 35:
                    i8 = f2.i((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i8 = f2.g((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i8 = f2.n((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i8 = f2.y((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i8 = f2.l((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i8 = f2.i((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i8 = f2.g((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i8 = f2.b((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i8 = f2.w((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i8 = f2.e((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i8 = f2.g((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i8 = f2.i((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i8 = f2.r((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i8 = f2.t((List) unsafe.getObject(t, A));
                    if (i8 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    c2 = f2.j(i13, (List) unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
                case 50:
                    c2 = this.q.d(i13, unsafe.getObject(t, A), n(i12));
                    i10 += c2;
                    break;
                case 51:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.h(i13, 0.0d);
                    i10 += c2;
                    break;
                case 52:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.o(i13, 0.0f);
                    i10 += c2;
                    break;
                case 53:
                    if (u(t, i13, i12)) {
                        j2 = F(t, A);
                        c2 = m.u(i13, j2);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(t, i13, i12)) {
                        j3 = F(t, A);
                        c2 = m.Q(i13, j3);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(t, i13, i12)) {
                        i4 = E(t, A);
                        c2 = m.s(i13, i4);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.m(i13, 0);
                    i10 += c2;
                    break;
                case 57:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.k(i13, 0);
                    i10 += c2;
                    break;
                case 58:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.c(i13, true);
                    i10 += c2;
                    break;
                case 59:
                    if (u(t, i13, i12)) {
                        obj = unsafe.getObject(t, A);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = f2.o(i13, unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
                case 61:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.f(i13, (j) unsafe.getObject(t, A));
                    i10 += c2;
                    break;
                case 62:
                    if (u(t, i13, i12)) {
                        i5 = E(t, A);
                        c2 = m.O(i13, i5);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(t, i13, i12)) {
                        i6 = E(t, A);
                        c2 = m.j(i13, i6);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.D(i13, 0);
                    i10 += c2;
                    break;
                case 65:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.F(i13, 0);
                    i10 += c2;
                    break;
                case 66:
                    if (u(t, i13, i12)) {
                        i7 = E(t, A);
                        c2 = m.H(i13, i7);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(t, i13, i12)) {
                        j4 = F(t, A);
                        c2 = m.J(i13, j4);
                        i10 += c2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!u(t, i13, i12)) {
                        break;
                    }
                    c2 = m.q(i13, (i1) unsafe.getObject(t, A), o(i12));
                    i10 += c2;
                    break;
            }
        }
        p2<?, ?> p2Var = this.o;
        int h2 = p2Var.h(p2Var.g(t)) + i10;
        return this.f5453f ? h2 + this.p.c(t).p() : h2;
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
        r3 = r3 + ((c.b.d.m.P(r5) + c.b.d.m.N(r6)) + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0338, code lost:
        if ((r4 instanceof c.b.d.j) != false) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x033b, code lost:
        r4 = c.b.d.m.L(r6, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        if ((r4 instanceof c.b.d.j) != false) goto L_0x0310;
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
        for (int i9 = 0; i9 < this.f5448a.length; i9 += 3) {
            int U = U(i9);
            int T = T(U);
            int i10 = this.f5448a[i9];
            long A = A(U);
            int i11 = (T < g0.DOUBLE_LIST_PACKED.f5280c || T > g0.SINT64_LIST_PACKED.f5280c) ? 0 : this.f5448a[i9 + 2] & 1048575;
            switch (T) {
                case 0:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.h(i10, 0.0d);
                    i8 += i2;
                    break;
                case 1:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.o(i10, 0.0f);
                    i8 += i2;
                    break;
                case 2:
                    if (s(t, i9)) {
                        j2 = v2.o(t, A);
                        i2 = m.u(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(t, i9)) {
                        j3 = v2.o(t, A);
                        i2 = m.Q(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(t, i9)) {
                        i3 = v2.n(t, A);
                        i2 = m.s(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.m(i10, 0);
                    i8 += i2;
                    break;
                case 6:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.k(i10, 0);
                    i8 += i2;
                    break;
                case 7:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.c(i10, true);
                    i8 += i2;
                    break;
                case 8:
                    if (s(t, i9)) {
                        obj = v2.p(t, A);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = f2.o(i10, v2.p(t, A), o(i9));
                    i8 += i2;
                    break;
                case 10:
                    if (!s(t, i9)) {
                        break;
                    }
                    obj = v2.p(t, A);
                    i2 = m.f(i10, (j) obj);
                    i8 += i2;
                    break;
                case 11:
                    if (s(t, i9)) {
                        i4 = v2.n(t, A);
                        i2 = m.O(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(t, i9)) {
                        i5 = v2.n(t, A);
                        i2 = m.j(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.D(i10, 0);
                    i8 += i2;
                    break;
                case 14:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.F(i10, 0);
                    i8 += i2;
                    break;
                case 15:
                    if (s(t, i9)) {
                        i6 = v2.n(t, A);
                        i2 = m.H(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(t, i9)) {
                        j4 = v2.o(t, A);
                        i2 = m.J(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (!s(t, i9)) {
                        break;
                    }
                    i2 = m.q(i10, (i1) v2.p(t, A), o(i9));
                    i8 += i2;
                    break;
                case 18:
                case 23:
                case 32:
                    i2 = f2.h(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 19:
                case 24:
                case 31:
                    i2 = f2.f(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 20:
                    i2 = f2.m(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 21:
                    i2 = f2.x(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 22:
                    i2 = f2.k(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 25:
                    i2 = f2.a(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 26:
                    i2 = f2.u(i10, v(t, A));
                    i8 += i2;
                    break;
                case 27:
                    i2 = f2.p(i10, v(t, A), o(i9));
                    i8 += i2;
                    break;
                case 28:
                    i2 = f2.c(i10, v(t, A));
                    i8 += i2;
                    break;
                case 29:
                    i2 = f2.v(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 30:
                    i2 = f2.d(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 33:
                    i2 = f2.q(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 34:
                    i2 = f2.s(i10, v(t, A), false);
                    i8 += i2;
                    break;
                case 35:
                    i7 = f2.i((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i7 = f2.g((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i7 = f2.n((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i7 = f2.y((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i7 = f2.l((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i7 = f2.i((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i7 = f2.g((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i7 = f2.b((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i7 = f2.w((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i7 = f2.e((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i7 = f2.g((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i7 = f2.i((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i7 = f2.r((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i7 = f2.t((List) unsafe.getObject(t, A));
                    if (i7 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i2 = f2.j(i10, v(t, A), o(i9));
                    i8 += i2;
                    break;
                case 50:
                    i2 = this.q.d(i10, v2.p(t, A), n(i9));
                    i8 += i2;
                    break;
                case 51:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.h(i10, 0.0d);
                    i8 += i2;
                    break;
                case 52:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.o(i10, 0.0f);
                    i8 += i2;
                    break;
                case 53:
                    if (u(t, i10, i9)) {
                        j2 = F(t, A);
                        i2 = m.u(i10, j2);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(t, i10, i9)) {
                        j3 = F(t, A);
                        i2 = m.Q(i10, j3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(t, i10, i9)) {
                        i3 = E(t, A);
                        i2 = m.s(i10, i3);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.m(i10, 0);
                    i8 += i2;
                    break;
                case 57:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.k(i10, 0);
                    i8 += i2;
                    break;
                case 58:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.c(i10, true);
                    i8 += i2;
                    break;
                case 59:
                    if (u(t, i10, i9)) {
                        obj = v2.p(t, A);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = f2.o(i10, v2.p(t, A), o(i9));
                    i8 += i2;
                    break;
                case 61:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    obj = v2.p(t, A);
                    i2 = m.f(i10, (j) obj);
                    i8 += i2;
                    break;
                case 62:
                    if (u(t, i10, i9)) {
                        i4 = E(t, A);
                        i2 = m.O(i10, i4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(t, i10, i9)) {
                        i5 = E(t, A);
                        i2 = m.j(i10, i5);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.D(i10, 0);
                    i8 += i2;
                    break;
                case 65:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.F(i10, 0);
                    i8 += i2;
                    break;
                case 66:
                    if (u(t, i10, i9)) {
                        i6 = E(t, A);
                        i2 = m.H(i10, i6);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(t, i10, i9)) {
                        j4 = F(t, A);
                        i2 = m.J(i10, j4);
                        i8 += i2;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!u(t, i10, i9)) {
                        break;
                    }
                    i2 = m.q(i10, (i1) v2.p(t, A), o(i9));
                    i8 += i2;
                    break;
            }
        }
        p2<?, ?> p2Var = this.o;
        return p2Var.h(p2Var.g(t)) + i8;
    }

    public final boolean s(T t, int i2) {
        if (this.h) {
            int i3 = this.f5448a[i2 + 1];
            long A = A(i3);
            switch (T(i3)) {
                case 0:
                    return v2.l(t, A) != 0.0d;
                case 1:
                    return v2.m(t, A) != 0.0f;
                case 2:
                    return v2.o(t, A) != 0;
                case 3:
                    return v2.o(t, A) != 0;
                case 4:
                    return v2.n(t, A) != 0;
                case 5:
                    return v2.o(t, A) != 0;
                case 6:
                    return v2.n(t, A) != 0;
                case 7:
                    return v2.g(t, A);
                case 8:
                    Object p2 = v2.p(t, A);
                    if (p2 instanceof String) {
                        return !((String) p2).isEmpty();
                    }
                    if (p2 instanceof j) {
                        return !j.f5320c.equals(p2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return v2.p(t, A) != null;
                case 10:
                    return !j.f5320c.equals(v2.p(t, A));
                case 11:
                    return v2.n(t, A) != 0;
                case 12:
                    return v2.n(t, A) != 0;
                case 13:
                    return v2.n(t, A) != 0;
                case 14:
                    return v2.o(t, A) != 0;
                case 15:
                    return v2.n(t, A) != 0;
                case 16:
                    return v2.o(t, A) != 0;
                case 17:
                    return v2.p(t, A) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f5448a[i2 + 2];
            return (v2.n(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0;
        }
    }

    public final boolean t(T t, int i2, int i3, int i4) {
        return this.h ? s(t, i2) : (i3 & i4) != 0;
    }

    public final boolean u(T t, int i2, int i3) {
        return v2.n(t, (long) (this.f5448a[i3 + 2] & 1048575)) == i2;
    }

    public final <K, V> void w(Object obj, int i2, Object obj2, z zVar, b2 b2Var) {
        long A = A(this.f5448a[i2 + 1]);
        Object p2 = v2.p(obj, A);
        if (p2 == null) {
            p2 = this.q.c(obj2);
            v2.f5899f.t(obj, A, p2);
        } else if (this.q.f(p2)) {
            Object c2 = this.q.c(obj2);
            this.q.a(c2, p2);
            v2.f5899f.t(obj, A, c2);
            p2 = c2;
        }
        b2Var.J(this.q.e(p2), this.q.h(obj2), zVar);
    }

    public final void x(T t, T t2, int i2) {
        long A = A(this.f5448a[i2 + 1]);
        if (s(t2, i2)) {
            Object p2 = v2.p(t, A);
            Object p3 = v2.p(t2, A);
            if (p2 != null && p3 != null) {
                p3 = n0.f(p2, p3);
            } else if (p3 == null) {
                return;
            }
            v2.f5899f.t(t, A, p3);
            Q(t, i2);
        }
    }

    public final void y(T t, T t2, int i2) {
        int[] iArr = this.f5448a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long A = A(i3);
        if (u(t2, i4, i2)) {
            Object p2 = v2.p(t, A);
            Object p3 = v2.p(t2, A);
            if (p2 != null && p3 != null) {
                p3 = n0.f(p2, p3);
            } else if (p3 == null) {
                return;
            }
            v2.f5899f.t(t, A, p3);
            R(t, i4, i2);
        }
    }
}
