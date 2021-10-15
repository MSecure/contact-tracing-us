package c.b.a.a.g.b;

import androidx.recyclerview.widget.RecyclerView;
import b.x.t;
import c.b.a.a.g.b.z0;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

public final class h2<T> implements u2<T> {
    public static final Unsafe r = n3.j();

    /* renamed from: a  reason: collision with root package name */
    public final int[] f3299a;

    /* renamed from: b  reason: collision with root package name */
    public final Object[] f3300b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3301c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3302d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3303e;

    /* renamed from: f  reason: collision with root package name */
    public final e2 f3304f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3305g;
    public final boolean h;
    public final boolean i;
    public final int[] j;
    public final int[] k;
    public final int[] l;
    public final k2 m;
    public final p1 n;
    public final h3<?, ?> o;
    public final m0<?> p;
    public final z1 q;

    /* JADX WARN: Incorrect args count in method signature: ([I[Ljava/lang/Object;IIILc/b/a/a/g/b/e2;ZZ[I[I[ILc/b/a/a/g/b/k2;Lc/b/a/a/g/b/p1;Lc/b/a/a/g/b/h3<**>;Lc/b/a/a/g/b/m0<*>;Lc/b/a/a/g/b/z1;)V */
    public h2(int[] iArr, Object[] objArr, int i2, int i3, int i4, e2 e2Var, boolean z, int[] iArr2, int[] iArr3, int[] iArr4, k2 k2Var, p1 p1Var, h3 h3Var, m0 m0Var, z1 z1Var) {
        this.f3299a = iArr;
        this.f3300b = objArr;
        this.f3301c = i2;
        this.f3302d = i3;
        this.f3303e = i4;
        boolean z2 = e2Var instanceof z0;
        this.h = z;
        this.f3305g = m0Var != null && (e2Var instanceof z0.c);
        this.i = false;
        this.j = iArr2;
        this.k = iArr3;
        this.l = iArr4;
        this.m = k2Var;
        this.n = p1Var;
        this.o = h3Var;
        this.p = m0Var;
        this.f3304f = e2Var;
        this.q = z1Var;
    }

    public static <E> List<E> J(Object obj, long j2) {
        return (List) n3.t(obj, j2);
    }

    public static <T> double K(T t, long j2) {
        return ((Double) n3.t(t, j2)).doubleValue();
    }

    public static <T> float L(T t, long j2) {
        return ((Float) n3.t(t, j2)).floatValue();
    }

    public static <T> int M(T t, long j2) {
        return ((Integer) n3.t(t, j2)).intValue();
    }

    public static <T> long N(T t, long j2) {
        return ((Long) n3.t(t, j2)).longValue();
    }

    public static <T> boolean O(T t, long j2) {
        return ((Boolean) n3.t(t, j2)).booleanValue();
    }

    public static i3 P(Object obj) {
        z0 z0Var = (z0) obj;
        i3 i3Var = z0Var.zzjp;
        if (i3Var != i3.f3314f) {
            return i3Var;
        }
        i3 e2 = i3.e();
        z0Var.zzjp = e2;
        return e2;
    }

    public static int a(u2<?> u2Var, int i2, byte[] bArr, int i3, int i4, e1<?> e1Var, u uVar) {
        int l2 = l(u2Var, bArr, i3, i4, uVar);
        while (true) {
            e1Var.add(uVar.f3426c);
            if (l2 >= i4) {
                break;
            }
            int S3 = t.S3(bArr, l2, uVar);
            if (i2 != uVar.f3424a) {
                break;
            }
            l2 = l(u2Var, bArr, S3, i4, uVar);
        }
        return l2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: c.b.a.a.g.b.h2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static int k(u2 u2Var, byte[] bArr, int i2, int i3, int i4, u uVar) {
        h2 h2Var = (h2) u2Var;
        Object a2 = h2Var.m.a(h2Var.f3304f);
        int p2 = h2Var.p(a2, bArr, i2, i3, i4, uVar);
        h2Var.i(a2);
        uVar.f3426c = a2;
        return p2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: c.b.a.a.g.b.u2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static int l(u2 u2Var, byte[] bArr, int i2, int i3, u uVar) {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = t.L3(b2, bArr, i4, uVar);
            b3 = uVar.f3424a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw f1.a();
        }
        Object c2 = u2Var.c();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        u2Var.h(c2, bArr, i4, i5, uVar);
        u2Var.i(c2);
        uVar.f3426c = c2;
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01a1 A[EDGE_INSN: B:102:0x01a1->B:98:0x01a1 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0190  */
    public static <T> h2<T> q(Class<T> cls, c2 c2Var, k2 k2Var, p1 p1Var, h3<?, ?> h3Var, m0<?> m0Var, z1 z1Var) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        Object obj;
        int i11;
        Field field;
        Field field2;
        Field field3;
        if (c2Var instanceof r2) {
            r2 r2Var = (r2) c2Var;
            int i12 = 1;
            int i13 = 2;
            boolean z2 = (r2Var.f3404b.f3409d & 1) == 1 ? true : true;
            s2 s2Var = r2Var.f3404b;
            if (s2Var.f3410e == 0) {
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                int i14 = s2Var.h;
                int i15 = s2Var.i;
                i4 = s2Var.l;
                i3 = i14;
                i2 = i15;
            }
            int[] iArr = new int[(i4 << 2)];
            Object[] objArr = new Object[(i4 << 1)];
            int i16 = r2Var.f3404b.j;
            int[] iArr2 = i16 > 0 ? new int[i16] : null;
            int i17 = r2Var.f3404b.m;
            int[] iArr3 = i17 > 0 ? new int[i17] : null;
            s2 s2Var2 = r2Var.f3404b;
            if (s2Var2.a()) {
                int i18 = s2Var2.x;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                while (true) {
                    if (i18 >= r2Var.f3404b.k || i19 >= ((i18 - i3) << i13)) {
                        if ((s2Var2.z > u0.MAP.f3432b ? i12 : 0) != 0) {
                            int i22 = s2Var2.A << i12;
                            Object obj2 = s2Var2.f3407b[i22];
                            if (obj2 instanceof Field) {
                                field2 = (Field) obj2;
                            } else {
                                field2 = s2.b(s2Var2.f3408c, (String) obj2);
                                s2Var2.f3407b[i22] = field2;
                            }
                            i8 = (int) n3.b(field2);
                            int i23 = (s2Var2.A << i12) + i12;
                            Object obj3 = s2Var2.f3407b[i23];
                            if (obj3 instanceof Field) {
                                field3 = (Field) obj3;
                            } else {
                                field3 = s2.b(s2Var2.f3408c, (String) obj3);
                                s2Var2.f3407b[i23] = field3;
                            }
                            i9 = (int) n3.b(field3);
                        } else {
                            i8 = (int) n3.b(s2Var2.C);
                            if (s2Var2.e()) {
                                int i24 = (s2Var2.B / 32) + (s2Var2.f3411f << 1);
                                Object obj4 = s2Var2.f3407b[i24];
                                if (obj4 instanceof Field) {
                                    field = (Field) obj4;
                                } else {
                                    field = s2.b(s2Var2.f3408c, (String) obj4);
                                    s2Var2.f3407b[i24] = field;
                                }
                                i9 = (int) n3.b(field);
                                i7 = s2Var2.B % 32;
                                iArr[i19] = s2Var2.x;
                                int i25 = i19 + 1;
                                z = z2;
                                if (!((s2Var2.y & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0)) {
                                    i10 = 536870912;
                                    i5 = i2;
                                } else {
                                    i5 = i2;
                                    i10 = 0;
                                }
                                iArr[i25] = i8 | (!((s2Var2.y & RecyclerView.a0.FLAG_TMP_DETACHED) == 0) ? 268435456 : 0) | i10 | (s2Var2.z << 20);
                                iArr[i19 + 2] = i9 | (i7 << 20);
                                obj = s2Var2.F;
                                if (obj == null) {
                                    int i26 = (i19 / 4) << 1;
                                    objArr[i26] = obj;
                                    Object obj5 = s2Var2.D;
                                    if (obj5 != null) {
                                        objArr[i26 + 1] = obj5;
                                    } else {
                                        Object obj6 = s2Var2.E;
                                        if (obj6 != null) {
                                            objArr[i26 + 1] = obj6;
                                        }
                                    }
                                    i6 = 1;
                                } else {
                                    Object obj7 = s2Var2.D;
                                    if (obj7 != null) {
                                        i6 = 1;
                                        objArr[((i19 / 4) << 1) + 1] = obj7;
                                    } else {
                                        i6 = 1;
                                        Object obj8 = s2Var2.E;
                                        if (obj8 != null) {
                                            objArr[((i19 / 4) << 1) + 1] = obj8;
                                        }
                                    }
                                }
                                i11 = s2Var2.z;
                                u0 u0Var = u0.MAP;
                                if (i11 != 50) {
                                    iArr2[i20] = i19;
                                    i20++;
                                } else if (i11 >= 18 && i11 <= 49) {
                                    iArr3[i21] = iArr[i25] & 1048575;
                                    i21++;
                                }
                                if (s2Var2.a()) {
                                    break;
                                }
                                i18 = s2Var2.x;
                            } else {
                                i9 = 0;
                            }
                        }
                        i7 = 0;
                        iArr[i19] = s2Var2.x;
                        int i252 = i19 + 1;
                        z = z2;
                        if (!((s2Var2.y & RecyclerView.a0.FLAG_ADAPTER_POSITION_UNKNOWN) == 0)) {
                        }
                        iArr[i252] = i8 | (!((s2Var2.y & RecyclerView.a0.FLAG_TMP_DETACHED) == 0) ? 268435456 : 0) | i10 | (s2Var2.z << 20);
                        iArr[i19 + 2] = i9 | (i7 << 20);
                        obj = s2Var2.F;
                        if (obj == null) {
                        }
                        i11 = s2Var2.z;
                        u0 u0Var2 = u0.MAP;
                        if (i11 != 50) {
                        }
                        if (s2Var2.a()) {
                        }
                    } else {
                        for (int i27 = 0; i27 < 4; i27++) {
                            iArr[i19 + i27] = -1;
                        }
                        i6 = i12;
                        i5 = i2;
                        z = z2;
                    }
                    i19 += 4;
                    i12 = i6;
                    z2 = z;
                    i2 = i5;
                    i13 = 2;
                }
            } else {
                i5 = i2;
                z = z2;
            }
            s2 s2Var3 = r2Var.f3404b;
            return new h2<>(iArr, objArr, i3, i5, s2Var3.k, r2Var.f3403a, z, s2Var3.n, iArr2, iArr3, k2Var, p1Var, h3Var, m0Var, z1Var);
        }
        f3 f3Var = (f3) c2Var;
        throw new NoSuchMethodError();
    }

    public static void r(int i2, Object obj, b4 b4Var) {
        if (obj instanceof String) {
            ((i0) b4Var).f3309a.k(i2, (String) obj);
            return;
        }
        ((i0) b4Var).f3309a.h(i2, (y) obj);
    }

    public static <UT, UB> void s(h3<UT, UB> h3Var, T t, b4 b4Var) {
        if (((j3) h3Var) != null) {
            t.zzjp.d(b4Var);
            return;
        }
        throw null;
    }

    public final d1<?> A(int i2) {
        return (d1) this.f3300b[((i2 / 4) << 1) + 1];
    }

    public final int B(int i2) {
        return this.f3299a[i2 + 1];
    }

    public final int C(int i2) {
        return this.f3299a[i2 + 2];
    }

    public final int D(int i2) {
        int i3 = this.f3301c;
        if (i2 >= i3) {
            int i4 = this.f3303e;
            if (i2 < i4) {
                int i5 = (i2 - i3) << 2;
                if (this.f3299a[i5] == i2) {
                    return i5;
                }
                return -1;
            } else if (i2 <= this.f3302d) {
                int i6 = i4 - i3;
                int length = (this.f3299a.length / 4) - 1;
                while (i6 <= length) {
                    int i7 = (length + i6) >>> 1;
                    int i8 = i7 << 2;
                    int i9 = this.f3299a[i8];
                    if (i2 == i9) {
                        return i8;
                    }
                    if (i2 < i9) {
                        length = i7 - 1;
                    } else {
                        i6 = i7 + 1;
                    }
                }
            }
        }
        return -1;
    }

    public final void E(T t, int i2) {
        if (!this.h) {
            int i3 = this.f3299a[i2 + 2];
            long j2 = (long) (i3 & 1048575);
            n3.f3369f.e(t, j2, n3.o(t, j2) | (1 << (i3 >>> 20)));
        }
    }

    public final void F(T t, int i2, int i3) {
        n3.f3369f.e(t, (long) (this.f3299a[i3 + 2] & 1048575), i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0532  */
    public final void G(T t, b4 b4Var) {
        Map.Entry<z0.d, Object> entry;
        Iterator<Map.Entry<z0.d, Object>> it;
        int length;
        int i2;
        int i3;
        int i4;
        if (this.f3305g) {
            if (((n0) this.p) != null) {
                q0<z0.d> q0Var = t.zzjv;
                if (!q0Var.a()) {
                    it = q0Var.c();
                    entry = it.next();
                    int i5 = -1;
                    length = this.f3299a.length;
                    Unsafe unsafe = r;
                    int i6 = 0;
                    for (i2 = 0; i2 < length; i2 = i3 + 4) {
                        int B = B(i2);
                        int[] iArr = this.f3299a;
                        int i7 = iArr[i2];
                        int i8 = (267386880 & B) >>> 20;
                        if (this.h || i8 > 17) {
                            i3 = i2;
                            i4 = 0;
                        } else {
                            int i9 = iArr[i2 + 2];
                            int i10 = i9 & 1048575;
                            i3 = i2;
                            if (i10 != i5) {
                                i6 = unsafe.getInt(t, (long) i10);
                                i5 = i10;
                            }
                            i4 = 1 << (i9 >>> 20);
                        }
                        while (entry != null && this.p.a(entry) <= i7) {
                            this.p.b(b4Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        long j2 = (long) (B & 1048575);
                        switch (i8) {
                            case 0:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).a(i7, n3.s(t, j2));
                                    continue;
                                }
                            case 1:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).b(i7, n3.r(t, j2));
                                } else {
                                    continue;
                                }
                            case 2:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.g(i7, unsafe.getLong(t, j2));
                                } else {
                                    continue;
                                }
                            case 3:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.g(i7, unsafe.getLong(t, j2));
                                } else {
                                    continue;
                                }
                            case 4:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.G(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 5:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.H(i7, unsafe.getLong(t, j2));
                                } else {
                                    continue;
                                }
                            case 6:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.Q(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 7:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.v(i7, n3.q(t, j2));
                                } else {
                                    continue;
                                }
                            case 8:
                                if ((i4 & i6) != 0) {
                                    r(i7, unsafe.getObject(t, j2), b4Var);
                                } else {
                                    continue;
                                }
                            case 9:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).d(i7, unsafe.getObject(t, j2), y(i3));
                                } else {
                                    continue;
                                }
                            case 10:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.h(i7, (y) unsafe.getObject(t, j2));
                                } else {
                                    continue;
                                }
                            case 11:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.L(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 12:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.G(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 13:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.Q(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 14:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f3309a.H(i7, unsafe.getLong(t, j2));
                                } else {
                                    continue;
                                }
                            case 15:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).g(i7, unsafe.getInt(t, j2));
                                } else {
                                    continue;
                                }
                            case 16:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).e(i7, unsafe.getLong(t, j2));
                                } else {
                                    continue;
                                }
                            case 17:
                                if ((i4 & i6) != 0) {
                                    ((i0) b4Var).f(i7, unsafe.getObject(t, j2), y(i3));
                                } else {
                                    continue;
                                }
                            case 18:
                                w2.f(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 19:
                                w2.m(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 20:
                                w2.r(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 21:
                                w2.x(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 22:
                                w2.H(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 23:
                                w2.C(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 24:
                                w2.M(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 25:
                                w2.P(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 26:
                                w2.d(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var);
                                break;
                            case 27:
                                w2.e(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, y(i3));
                                break;
                            case 28:
                                w2.k(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var);
                                break;
                            case 29:
                                w2.J(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 30:
                                w2.O(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 31:
                                w2.N(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 32:
                                w2.F(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 33:
                                w2.L(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 34:
                                w2.A(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, false);
                                continue;
                            case 35:
                                w2.f(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 36:
                                w2.m(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 37:
                                w2.r(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 38:
                                w2.x(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 39:
                                w2.H(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 40:
                                w2.C(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 41:
                                w2.M(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 42:
                                w2.P(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 43:
                                w2.J(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 44:
                                w2.O(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 45:
                                w2.N(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 46:
                                w2.F(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 47:
                                w2.L(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 48:
                                w2.A(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, true);
                                break;
                            case 49:
                                w2.l(this.f3299a[i3], (List) unsafe.getObject(t, j2), b4Var, y(i3));
                                break;
                            case 50:
                                t(b4Var, i7, unsafe.getObject(t, j2), i3);
                                break;
                            case 51:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).a(i7, K(t, j2));
                                    break;
                                }
                                break;
                            case 52:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).b(i7, L(t, j2));
                                    break;
                                }
                                break;
                            case 53:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.g(i7, N(t, j2));
                                    break;
                                }
                                break;
                            case 54:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.g(i7, N(t, j2));
                                    break;
                                }
                                break;
                            case 55:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.G(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 56:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.H(i7, N(t, j2));
                                    break;
                                }
                                break;
                            case 57:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.Q(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 58:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.v(i7, O(t, j2));
                                    break;
                                }
                                break;
                            case 59:
                                if (w(t, i7, i3)) {
                                    r(i7, unsafe.getObject(t, j2), b4Var);
                                    break;
                                }
                                break;
                            case 60:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).d(i7, unsafe.getObject(t, j2), y(i3));
                                    break;
                                }
                                break;
                            case 61:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.h(i7, (y) unsafe.getObject(t, j2));
                                    break;
                                }
                                break;
                            case 62:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.L(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 63:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.G(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 64:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.Q(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 65:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f3309a.H(i7, N(t, j2));
                                    break;
                                }
                                break;
                            case 66:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).g(i7, M(t, j2));
                                    break;
                                }
                                break;
                            case 67:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).e(i7, N(t, j2));
                                    break;
                                }
                                break;
                            case 68:
                                if (w(t, i7, i3)) {
                                    ((i0) b4Var).f(i7, unsafe.getObject(t, j2), y(i3));
                                    break;
                                }
                                break;
                        }
                    }
                    while (entry != null) {
                        this.p.b(b4Var, entry);
                        entry = it.hasNext() ? it.next() : null;
                    }
                    s(this.o, t, b4Var);
                }
            } else {
                throw null;
            }
        }
        it = null;
        entry = null;
        int i52 = -1;
        length = this.f3299a.length;
        Unsafe unsafe2 = r;
        int i62 = 0;
        while (i2 < length) {
        }
        while (entry != null) {
        }
        s(this.o, t, b4Var);
    }

    public final void H(T t, T t2, int i2) {
        int[] iArr = this.f3299a;
        int i3 = iArr[i2 + 1];
        int i4 = iArr[i2];
        long j2 = (long) (i3 & 1048575);
        if (w(t2, i4, i2)) {
            Object t3 = n3.t(t, j2);
            Object t4 = n3.t(t2, j2);
            if (t3 != null && t4 != null) {
                n3.f(t, j2, b1.d(t3, t4));
                F(t, i4, i2);
            } else if (t4 != null) {
                n3.f(t, j2, t4);
                F(t, i4, i2);
            }
        }
    }

    public final boolean I(T t, T t2, int i2) {
        return v(t, i2) == v(t2, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (c.b.a.a.g.b.w2.y(c.b.a.a.g.b.n3.t(r10, r6), c.b.a.a.g.b.n3.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (c.b.a.a.g.b.w2.y(c.b.a.a.g.b.n3.t(r10, r6), c.b.a.a.g.b.n3.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (c.b.a.a.g.b.w2.y(c.b.a.a.g.b.n3.t(r10, r6), c.b.a.a.g.b.n3.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (c.b.a.a.g.b.w2.y(c.b.a.a.g.b.n3.t(r10, r6), c.b.a.a.g.b.n3.t(r11, r6)) != false) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (c.b.a.a.g.b.n3.q(r10, r6) == c.b.a.a.g.b.n3.q(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0146, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0157, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016a, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017d, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018e, code lost:
        if (c.b.a.a.g.b.n3.o(r10, r6) == c.b.a.a.g.b.n3.o(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a1, code lost:
        if (c.b.a.a.g.b.n3.p(r10, r6) == c.b.a.a.g.b.n3.p(r11, r6)) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (c.b.a.a.g.b.w2.y(c.b.a.a.g.b.n3.t(r10, r6), c.b.a.a.g.b.n3.t(r11, r6)) != false) goto L_0x01a4;
     */
    @Override // c.b.a.a.g.b.u2
    public final boolean b(T t, T t2) {
        int length = this.f3299a.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < length) {
                int B = B(i2);
                long j2 = (long) (B & 1048575);
                switch ((B & 267386880) >>> 20) {
                    case 0:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 1:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 2:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 3:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 4:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 5:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 6:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 7:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 8:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 9:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 10:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 11:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 12:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 13:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 14:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 15:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 16:
                        if (I(t, t2, i2)) {
                            break;
                        }
                        z = false;
                        break;
                    case 17:
                        if (I(t, t2, i2)) {
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
                        z = w2.y(n3.t(t, j2), n3.t(t2, j2));
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
                        long C = (long) (C(i2) & 1048575);
                        if (n3.o(t, C) == n3.o(t2, C)) {
                            break;
                        }
                        z = false;
                        break;
                }
                if (!z) {
                    return false;
                }
                i2 += 4;
            } else {
                j3 j3Var = (j3) this.o;
                if (j3Var != null) {
                    i3 i3Var = t.zzjp;
                    if (j3Var == null) {
                        throw null;
                    } else if (!i3Var.equals(t2.zzjp)) {
                        return false;
                    } else {
                        if (!this.f3305g) {
                            return true;
                        }
                        n0 n0Var = (n0) this.p;
                        if (n0Var != null) {
                            q0<z0.d> q0Var = t.zzjv;
                            if (n0Var != null) {
                                return q0Var.equals(t2.zzjv);
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

    @Override // c.b.a.a.g.b.u2
    public final T c() {
        return (T) this.m.a(this.f3304f);
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
    @Override // c.b.a.a.g.b.u2
    public final int d(T t) {
        int i2;
        int i3;
        long j2;
        double d2;
        float f2;
        boolean z;
        Object obj;
        Object obj2;
        int length = this.f3299a.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5 += 4) {
            int B = B(i5);
            int i6 = this.f3299a[i5];
            long j3 = (long) (1048575 & B);
            int i7 = 37;
            switch ((B & 267386880) >>> 20) {
                case 0:
                    i3 = i4 * 53;
                    d2 = n3.s(t, j3);
                    j2 = Double.doubleToLongBits(d2);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 1:
                    i3 = i4 * 53;
                    f2 = n3.r(t, j3);
                    i2 = Float.floatToIntBits(f2);
                    i4 = i2 + i3;
                    break;
                case 2:
                case 3:
                case 5:
                case 14:
                case 16:
                    i3 = i4 * 53;
                    j2 = n3.p(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 4:
                case 6:
                case 11:
                case 12:
                case 13:
                case 15:
                    i3 = i4 * 53;
                    i2 = n3.o(t, j3);
                    i4 = i2 + i3;
                    break;
                case 7:
                    i3 = i4 * 53;
                    z = n3.q(t, j3);
                    i2 = b1.f(z);
                    i4 = i2 + i3;
                    break;
                case 8:
                    i3 = i4 * 53;
                    i2 = ((String) n3.t(t, j3)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 9:
                    obj = n3.t(t, j3);
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
                    obj2 = n3.t(t, j3);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 17:
                    obj = n3.t(t, j3);
                    break;
                case 51:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        d2 = K(t, j3);
                        j2 = Double.doubleToLongBits(d2);
                        i2 = b1.h(j2);
                        i4 = i2 + i3;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        f2 = L(t, j3);
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
                    j2 = N(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 54:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = N(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 55:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 56:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = N(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 57:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 58:
                    if (w(t, i6, i5)) {
                        i3 = i4 * 53;
                        z = O(t, j3);
                        i2 = b1.f(z);
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
                    i2 = ((String) n3.t(t, j3)).hashCode();
                    i4 = i2 + i3;
                    break;
                case 60:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    obj2 = n3.t(t, j3);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 61:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    obj2 = n3.t(t, j3);
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
                case 62:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 63:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 64:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 65:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = N(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 66:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    i2 = M(t, j3);
                    i4 = i2 + i3;
                    break;
                case 67:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    i3 = i4 * 53;
                    j2 = N(t, j3);
                    i2 = b1.h(j2);
                    i4 = i2 + i3;
                    break;
                case 68:
                    if (!w(t, i6, i5)) {
                        break;
                    }
                    obj2 = n3.t(t, j3);
                    i3 = i4 * 53;
                    i2 = obj2.hashCode();
                    i4 = i2 + i3;
                    break;
            }
        }
        int i8 = i4 * 53;
        if (((j3) this.o) != null) {
            int hashCode = t.zzjp.hashCode() + i8;
            if (!this.f3305g) {
                return hashCode;
            }
            int i9 = hashCode * 53;
            if (((n0) this.p) != null) {
                return i9 + t.zzjv.hashCode();
            }
            throw null;
        }
        throw null;
    }

    @Override // c.b.a.a.g.b.u2
    public final void e(T t, T t2) {
        int i2;
        if (t2 != null) {
            for (int i3 = 0; i3 < this.f3299a.length; i3 += 4) {
                int B = B(i3);
                long j2 = (long) (1048575 & B);
                int i4 = this.f3299a[i3];
                switch ((B & 267386880) >>> 20) {
                    case 0:
                        if (v(t2, i3)) {
                            n3.d(t, j2, n3.s(t2, j2));
                            E(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 1:
                        if (v(t2, i3)) {
                            n3.f3369f.d(t, j2, n3.r(t2, j2));
                            E(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 2:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.e(t, j2, n3.p(t2, j2));
                        E(t, i3);
                        break;
                    case 3:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.e(t, j2, n3.p(t2, j2));
                        E(t, i3);
                        break;
                    case 4:
                        if (!v(t2, i3)) {
                            break;
                        }
                        i2 = n3.o(t2, j2);
                        n3.f3369f.e(t, j2, i2);
                        E(t, i3);
                        break;
                    case 5:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.e(t, j2, n3.p(t2, j2));
                        E(t, i3);
                        break;
                    case 6:
                        if (!v(t2, i3)) {
                            break;
                        }
                        i2 = n3.o(t2, j2);
                        n3.f3369f.e(t, j2, i2);
                        E(t, i3);
                        break;
                    case 7:
                        if (v(t2, i3)) {
                            n3.f3369f.g(t, j2, n3.q(t2, j2));
                            E(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 8:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.f(t, j2, n3.t(t2, j2));
                        E(t, i3);
                        break;
                    case 9:
                    case 17:
                        u(t, t2, i3);
                        break;
                    case 10:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.f(t, j2, n3.t(t2, j2));
                        E(t, i3);
                        break;
                    case 11:
                        if (!v(t2, i3)) {
                            break;
                        }
                        i2 = n3.o(t2, j2);
                        n3.f3369f.e(t, j2, i2);
                        E(t, i3);
                        break;
                    case 12:
                        if (!v(t2, i3)) {
                            break;
                        }
                        i2 = n3.o(t2, j2);
                        n3.f3369f.e(t, j2, i2);
                        E(t, i3);
                        break;
                    case 13:
                        if (!v(t2, i3)) {
                            break;
                        }
                        i2 = n3.o(t2, j2);
                        n3.f3369f.e(t, j2, i2);
                        E(t, i3);
                        break;
                    case 14:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.e(t, j2, n3.p(t2, j2));
                        E(t, i3);
                        break;
                    case 15:
                        if (v(t2, i3)) {
                            i2 = n3.o(t2, j2);
                            n3.f3369f.e(t, j2, i2);
                            E(t, i3);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (!v(t2, i3)) {
                            break;
                        }
                        n3.e(t, j2, n3.p(t2, j2));
                        E(t, i3);
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
                        this.n.b(t, t2, j2);
                        break;
                    case 50:
                        w2.h(this.q, t, t2, j2);
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
                        n3.f(t, j2, n3.t(t2, j2));
                        F(t, i4, i3);
                        break;
                    case 60:
                    case 68:
                        H(t, t2, i3);
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
                        n3.f(t, j2, n3.t(t2, j2));
                        F(t, i4, i3);
                        break;
                }
            }
            if (!this.h) {
                w2.i(this.o, t, t2);
                if (this.f3305g) {
                    w2.g(this.p, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v7, resolved type: c.b.a.a.g.b.u2 */
    /* JADX DEBUG: Multi-variable search result rejected for r10v8, resolved type: c.b.a.a.g.b.u2 */
    /* JADX DEBUG: Multi-variable search result rejected for r9v18, resolved type: c.b.a.a.g.b.u2 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.b.a.a.g.b.u2
    public final boolean f(T t) {
        int i2;
        int i3;
        boolean z;
        int[] iArr = this.j;
        if (!(iArr == null || iArr.length == 0)) {
            int i4 = -1;
            int i5 = 0;
            for (int i6 : iArr) {
                int D = D(i6);
                int B = B(D);
                if (!this.h) {
                    int i7 = this.f3299a[D + 2];
                    int i8 = i7 & 1048575;
                    i3 = 1 << (i7 >>> 20);
                    if (i8 != i4) {
                        i2 = i6;
                        i5 = r.getInt(t, (long) i8);
                        i4 = i8;
                    } else {
                        i2 = i6;
                    }
                } else {
                    i2 = i6;
                    i3 = 0;
                }
                if (((268435456 & B) != 0) && !x(t, D, i5, i3)) {
                    return false;
                }
                int i9 = (267386880 & B) >>> 20;
                if (i9 != 9 && i9 != 17) {
                    if (i9 != 27) {
                        if (i9 == 60 || i9 == 68) {
                            if (w(t, i2, D) && !y(D).f(n3.t(t, (long) (B & 1048575)))) {
                                return false;
                            }
                        } else if (i9 != 49) {
                            if (i9 == 50 && !this.q.c(n3.t(t, (long) (B & 1048575))).isEmpty()) {
                                this.q.d(z(D));
                                throw null;
                            }
                        }
                    }
                    List list = (List) n3.t(t, (long) (B & 1048575));
                    if (!list.isEmpty()) {
                        u2 y = y(D);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= list.size()) {
                                break;
                            } else if (!y.f(list.get(i10))) {
                                z = false;
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                        return false;
                    }
                } else if (x(t, D, i5, i3) && !y(D).f(n3.t(t, (long) (B & 1048575)))) {
                    return false;
                }
            }
            if (this.f3305g) {
                if (((n0) this.p) == null) {
                    throw null;
                } else if (!t.zzjv.b()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x04cf  */
    @Override // c.b.a.a.g.b.u2
    public final void g(T t, b4 b4Var) {
        Map.Entry<z0.d, Object> entry;
        Iterator<Map.Entry<z0.d, Object>> it;
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
        i0 i0Var = (i0) b4Var;
        if (i0Var == null) {
            throw null;
        } else if (this.h) {
            if (this.f3305g) {
                if (((n0) this.p) != null) {
                    q0<z0.d> q0Var = t.zzjv;
                    if (!q0Var.a()) {
                        it = q0Var.c();
                        entry = it.next();
                        length = this.f3299a.length;
                        for (i2 = 0; i2 < length; i2 += 4) {
                            int B = B(i2);
                            int i9 = this.f3299a[i2];
                            while (entry != null && this.p.a(entry) <= i9) {
                                this.p.b(b4Var, entry);
                                entry = it.hasNext() ? it.next() : null;
                            }
                            switch ((267386880 & B) >>> 20) {
                                case 0:
                                    if (v(t, i2)) {
                                        d2 = n3.s(t, (long) (B & 1048575));
                                        i0Var.a(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    if (v(t, i2)) {
                                        f2 = n3.r(t, (long) (B & 1048575));
                                        i0Var.b(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    if (v(t, i2)) {
                                        j2 = n3.p(t, (long) (B & 1048575));
                                        i0Var.f3309a.g(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3:
                                    if (v(t, i2)) {
                                        j3 = n3.p(t, (long) (B & 1048575));
                                        i0Var.f3309a.g(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 4:
                                    if (v(t, i2)) {
                                        i3 = n3.o(t, (long) (B & 1048575));
                                        i0Var.f3309a.G(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 5:
                                    if (v(t, i2)) {
                                        j4 = n3.p(t, (long) (B & 1048575));
                                        i0Var.f3309a.H(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 6:
                                    if (v(t, i2)) {
                                        i4 = n3.o(t, (long) (B & 1048575));
                                        i0Var.f3309a.Q(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 7:
                                    if (v(t, i2)) {
                                        z = n3.q(t, (long) (B & 1048575));
                                        i0Var.f3309a.v(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 8:
                                    if (!v(t, i2)) {
                                        break;
                                    }
                                    r(i9, n3.t(t, (long) (B & 1048575)), b4Var);
                                    break;
                                case 9:
                                    if (!v(t, i2)) {
                                        break;
                                    }
                                    i0Var.d(i9, n3.t(t, (long) (B & 1048575)), y(i2));
                                    break;
                                case 10:
                                    if (!v(t, i2)) {
                                        break;
                                    }
                                    i0Var.f3309a.h(i9, (y) n3.t(t, (long) (B & 1048575)));
                                    break;
                                case 11:
                                    if (v(t, i2)) {
                                        i5 = n3.o(t, (long) (B & 1048575));
                                        i0Var.f3309a.L(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 12:
                                    if (v(t, i2)) {
                                        i6 = n3.o(t, (long) (B & 1048575));
                                        i0Var.f3309a.G(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 13:
                                    if (v(t, i2)) {
                                        i7 = n3.o(t, (long) (B & 1048575));
                                        i0Var.f3309a.Q(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 14:
                                    if (v(t, i2)) {
                                        j5 = n3.p(t, (long) (B & 1048575));
                                        i0Var.f3309a.H(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 15:
                                    if (v(t, i2)) {
                                        i8 = n3.o(t, (long) (B & 1048575));
                                        i0Var.g(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 16:
                                    if (v(t, i2)) {
                                        j6 = n3.p(t, (long) (B & 1048575));
                                        i0Var.e(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 17:
                                    if (!v(t, i2)) {
                                        break;
                                    }
                                    i0Var.f(i9, n3.t(t, (long) (B & 1048575)), y(i2));
                                    break;
                                case 18:
                                    w2.f(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 19:
                                    w2.m(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 20:
                                    w2.r(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 21:
                                    w2.x(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 22:
                                    w2.H(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 23:
                                    w2.C(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 24:
                                    w2.M(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 25:
                                    w2.P(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 26:
                                    w2.d(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var);
                                    break;
                                case 27:
                                    w2.e(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, y(i2));
                                    break;
                                case 28:
                                    w2.k(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var);
                                    break;
                                case 29:
                                    w2.J(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 30:
                                    w2.O(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 31:
                                    w2.N(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 32:
                                    w2.F(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 33:
                                    w2.L(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 34:
                                    w2.A(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, false);
                                    break;
                                case 35:
                                    w2.f(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 36:
                                    w2.m(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 37:
                                    w2.r(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 38:
                                    w2.x(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 39:
                                    w2.H(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 40:
                                    w2.C(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 41:
                                    w2.M(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 42:
                                    w2.P(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 43:
                                    w2.J(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 44:
                                    w2.O(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 45:
                                    w2.N(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 46:
                                    w2.F(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 47:
                                    w2.L(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 48:
                                    w2.A(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, true);
                                    break;
                                case 49:
                                    w2.l(this.f3299a[i2], (List) n3.t(t, (long) (B & 1048575)), b4Var, y(i2));
                                    break;
                                case 50:
                                    t(b4Var, i9, n3.t(t, (long) (B & 1048575)), i2);
                                    break;
                                case 51:
                                    if (w(t, i9, i2)) {
                                        d2 = K(t, (long) (B & 1048575));
                                        i0Var.a(i9, d2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 52:
                                    if (w(t, i9, i2)) {
                                        f2 = L(t, (long) (B & 1048575));
                                        i0Var.b(i9, f2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 53:
                                    if (w(t, i9, i2)) {
                                        j2 = N(t, (long) (B & 1048575));
                                        i0Var.f3309a.g(i9, j2);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 54:
                                    if (w(t, i9, i2)) {
                                        j3 = N(t, (long) (B & 1048575));
                                        i0Var.f3309a.g(i9, j3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 55:
                                    if (w(t, i9, i2)) {
                                        i3 = M(t, (long) (B & 1048575));
                                        i0Var.f3309a.G(i9, i3);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 56:
                                    if (w(t, i9, i2)) {
                                        j4 = N(t, (long) (B & 1048575));
                                        i0Var.f3309a.H(i9, j4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 57:
                                    if (w(t, i9, i2)) {
                                        i4 = M(t, (long) (B & 1048575));
                                        i0Var.f3309a.Q(i9, i4);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 58:
                                    if (w(t, i9, i2)) {
                                        z = O(t, (long) (B & 1048575));
                                        i0Var.f3309a.v(i9, z);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 59:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    r(i9, n3.t(t, (long) (B & 1048575)), b4Var);
                                    break;
                                case 60:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    i0Var.d(i9, n3.t(t, (long) (B & 1048575)), y(i2));
                                    break;
                                case 61:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    i0Var.f3309a.h(i9, (y) n3.t(t, (long) (B & 1048575)));
                                    break;
                                case 62:
                                    if (w(t, i9, i2)) {
                                        i5 = M(t, (long) (B & 1048575));
                                        i0Var.f3309a.L(i9, i5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 63:
                                    if (w(t, i9, i2)) {
                                        i6 = M(t, (long) (B & 1048575));
                                        i0Var.f3309a.G(i9, i6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 64:
                                    if (w(t, i9, i2)) {
                                        i7 = M(t, (long) (B & 1048575));
                                        i0Var.f3309a.Q(i9, i7);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 65:
                                    if (w(t, i9, i2)) {
                                        j5 = N(t, (long) (B & 1048575));
                                        i0Var.f3309a.H(i9, j5);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 66:
                                    if (w(t, i9, i2)) {
                                        i8 = M(t, (long) (B & 1048575));
                                        i0Var.g(i9, i8);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 67:
                                    if (w(t, i9, i2)) {
                                        j6 = N(t, (long) (B & 1048575));
                                        i0Var.e(i9, j6);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 68:
                                    if (!w(t, i9, i2)) {
                                        break;
                                    }
                                    i0Var.f(i9, n3.t(t, (long) (B & 1048575)), y(i2));
                                    break;
                            }
                        }
                        while (entry != null) {
                            this.p.b(b4Var, entry);
                            entry = it.hasNext() ? it.next() : null;
                        }
                        s(this.o, t, b4Var);
                    }
                } else {
                    throw null;
                }
            }
            it = null;
            entry = null;
            length = this.f3299a.length;
            while (i2 < length) {
            }
            while (entry != null) {
            }
            s(this.o, t, b4Var);
        } else {
            G(t, b4Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v27, types: [int] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d1, code lost:
        if (r7 == 0) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        r0 = b.x.t.S3(r12, r10, r11);
        r1 = r11.f3424a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x016a, code lost:
        if (r0 == r10) goto L_0x01a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a6, code lost:
        if (r0 == r15) goto L_0x01a8;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // c.b.a.a.g.b.u2
    public final void h(T t, byte[] bArr, int i2, int i3, u uVar) {
        byte b2;
        int i4;
        Unsafe unsafe;
        int i5;
        int i6;
        long j2;
        int i7;
        Object obj;
        h2<T> h2Var = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i8 = i3;
        u uVar2 = uVar;
        if (h2Var.h) {
            Unsafe unsafe2 = r;
            int i9 = i2;
            while (i9 < i8) {
                int i10 = i9 + 1;
                byte b3 = bArr2[i9];
                if (b3 < 0) {
                    i4 = t.L3(b3, bArr2, i10, uVar2);
                    b2 = uVar2.f3424a;
                } else {
                    b2 = b3;
                    i4 = i10;
                }
                int i11 = b2 >>> 3;
                int i12 = b2 & 7;
                int D = h2Var.D(i11);
                if (D >= 0) {
                    int i13 = h2Var.f3299a[D + 1];
                    int i14 = (267386880 & i13) >>> 20;
                    long j3 = (long) (1048575 & i13);
                    if (i14 <= 17) {
                        boolean z = true;
                        switch (i14) {
                            case 0:
                                if (i12 == 1) {
                                    n3.d(t2, j3, t.I4(bArr2, i4));
                                    i9 = i4 + 8;
                                    break;
                                }
                                break;
                            case 1:
                                if (i12 == 5) {
                                    n3.f3369f.d(t2, j3, t.L4(bArr2, i4));
                                    i9 = i4 + 4;
                                    break;
                                }
                                break;
                            case 2:
                            case 3:
                                if (i12 == 0) {
                                    i7 = t.q4(bArr2, i4, uVar2);
                                    j2 = uVar2.f3425b;
                                    unsafe2.putLong(t, j3, j2);
                                    i9 = i7;
                                    break;
                                }
                                break;
                            case 5:
                            case 14:
                                if (i12 == 1) {
                                    unsafe2.putLong(t, j3, t.G4(bArr2, i4));
                                    i9 = i4 + 8;
                                    break;
                                }
                                break;
                            case 6:
                            case 13:
                                if (i12 == 5) {
                                    unsafe2.putInt(t2, j3, t.z4(bArr2, i4));
                                    i9 = i4 + 4;
                                    break;
                                }
                                break;
                            case 7:
                                if (i12 == 0) {
                                    i9 = t.q4(bArr2, i4, uVar2);
                                    if (uVar2.f3425b == 0) {
                                        z = false;
                                    }
                                    n3.f3369f.g(t2, j3, z);
                                    break;
                                }
                                break;
                            case 8:
                                if (i12 == 2) {
                                    i9 = (536870912 & i13) == 0 ? t.A4(bArr2, i4, uVar2) : t.E4(bArr2, i4, uVar2);
                                    obj = uVar2.f3426c;
                                    unsafe2.putObject(t2, j3, obj);
                                    break;
                                }
                                break;
                            case 9:
                                if (i12 == 2) {
                                    i9 = l(h2Var.y(D), bArr2, i4, i8, uVar2);
                                    Object object = unsafe2.getObject(t2, j3);
                                    if (object != null) {
                                        obj = b1.d(object, uVar2.f3426c);
                                        unsafe2.putObject(t2, j3, obj);
                                        break;
                                    }
                                    obj = uVar2.f3426c;
                                    unsafe2.putObject(t2, j3, obj);
                                }
                                break;
                            case 10:
                                if (i12 == 2) {
                                    i9 = t.J4(bArr2, i4, uVar2);
                                    obj = uVar2.f3426c;
                                    unsafe2.putObject(t2, j3, obj);
                                    break;
                                }
                                break;
                            case 15:
                                if (i12 == 0) {
                                    i9 = t.S3(bArr2, i4, uVar2);
                                    int i15 = f0.b(uVar2.f3424a);
                                    unsafe2.putInt(t2, j3, i15);
                                    break;
                                }
                                break;
                            case 16:
                                if (i12 == 0) {
                                    i7 = t.q4(bArr2, i4, uVar2);
                                    j2 = f0.a(uVar2.f3425b);
                                    unsafe2.putLong(t, j3, j2);
                                    i9 = i7;
                                    break;
                                }
                                break;
                        }
                    } else if (i14 != 27) {
                        if (i14 <= 49) {
                            unsafe = unsafe2;
                            i9 = n(t, bArr, i4, i3, b2, i11, i12, D, (long) i13, i14, j3, uVar);
                        } else {
                            unsafe = unsafe2;
                            i6 = i4;
                            if (i14 == 50) {
                                if (i12 == 2) {
                                    o(t, bArr, i6, i3, D, j3, uVar);
                                    throw null;
                                }
                                i5 = i6;
                                i9 = t.H3(b2, bArr, i5, i3, P(t), uVar);
                                h2Var = this;
                                t2 = t;
                                bArr2 = bArr;
                                i8 = i3;
                                uVar2 = uVar;
                                unsafe2 = unsafe;
                            } else {
                                i9 = m(t, bArr, i6, i3, b2, i11, i12, i13, i14, j3, D, uVar);
                            }
                        }
                        i5 = i9;
                        i9 = t.H3(b2, bArr, i5, i3, P(t), uVar);
                        h2Var = this;
                        t2 = t;
                        bArr2 = bArr;
                        i8 = i3;
                        uVar2 = uVar;
                        unsafe2 = unsafe;
                    } else if (i12 == 2) {
                        e1 e1Var = (e1) unsafe2.getObject(t2, j3);
                        if (!e1Var.y()) {
                            int size = e1Var.size();
                            e1Var = e1Var.r(size == 0 ? 10 : size << 1);
                            unsafe2.putObject(t2, j3, e1Var);
                        }
                        i9 = a(h2Var.y(D), b2, bArr, i4, i3, e1Var, uVar);
                    }
                }
                unsafe = unsafe2;
                i6 = i4;
                i5 = i6;
                i9 = t.H3(b2, bArr, i5, i3, P(t), uVar);
                h2Var = this;
                t2 = t;
                bArr2 = bArr;
                i8 = i3;
                uVar2 = uVar;
                unsafe2 = unsafe;
            }
            if (i9 != i8) {
                throw f1.d();
            }
            return;
        }
        p(t, bArr, i2, i3, 0, uVar);
    }

    @Override // c.b.a.a.g.b.u2
    public final void i(T t) {
        int[] iArr = this.k;
        if (iArr != null) {
            for (int i2 : iArr) {
                long B = (long) (B(i2) & 1048575);
                Object t2 = n3.t(t, B);
                if (t2 != null) {
                    n3.f(t, B, this.q.a(t2));
                }
            }
        }
        int[] iArr2 = this.l;
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                this.n.a(t, (long) i3);
            }
        }
        if (((j3) this.o) != null) {
            t.zzjp.f3319e = false;
            if (!this.f3305g) {
                return;
            }
            if (((n0) this.p) != null) {
                q0<z0.d> q0Var = t.zzjv;
                if (!q0Var.f3396b) {
                    q0Var.f3395a.j();
                    q0Var.f3396b = true;
                    return;
                }
                return;
            }
            throw null;
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01ce, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01df, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f0, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0201, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0203, code lost:
        r2.putInt(r17, (long) r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0207, code lost:
        r7 = ((c.b.a.a.g.b.g0.j0(r9) + c.b.a.a.g.b.g0.h0(r11)) + r9) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x0334, code lost:
        if ((r8 instanceof c.b.a.a.g.b.y) != false) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x033e, code lost:
        r8 = c.b.a.a.g.b.g0.p(r11, (java.lang.String) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0473, code lost:
        if ((r4 instanceof c.b.a.a.g.b.y) != false) goto L_0x0710;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x04f1, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x0503, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:278:0x0515, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0527, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0539, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x054b, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x055d, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x056f, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x0580, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:306:0x0591, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:310:0x05a2, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:314:0x05b3, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x05c4, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x05d5, code lost:
        if (r16.i != false) goto L_0x05d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x05d7, code lost:
        r2.putInt(r17, (long) r11, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05db, code lost:
        r8 = ((c.b.a.a.g.b.g0.j0(r4) + c.b.a.a.g.b.g0.h0(r12)) + r4) + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x070e, code lost:
        if ((r4 instanceof c.b.a.a.g.b.y) != false) goto L_0x0710;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0717, code lost:
        r4 = c.b.a.a.g.b.g0.p(r12, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a1, code lost:
        if ((r8 instanceof c.b.a.a.g.b.y) != false) goto L_0x0336;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x011d, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x012f, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0141, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0153, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0165, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0177, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0189, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x019b, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01ac, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01bd, code lost:
        if (r16.i != false) goto L_0x0203;
     */
    @Override // c.b.a.a.g.b.u2
    public final int j(T t) {
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
        int i10;
        long j5;
        long j6;
        int i11;
        Object obj2;
        int i12;
        int i13;
        int i14;
        long j7;
        int i15;
        int i16 = 267386880;
        if (this.h) {
            Unsafe unsafe = r;
            int i17 = 0;
            for (int i18 = 0; i18 < this.f3299a.length; i18 += 4) {
                int B = B(i18);
                int i19 = (B & 267386880) >>> 20;
                int[] iArr = this.f3299a;
                int i20 = iArr[i18];
                long j8 = (long) (B & 1048575);
                int i21 = (i19 < u0.DOUBLE_LIST_PACKED.f3432b || i19 > u0.SINT64_LIST_PACKED.f3432b) ? 0 : iArr[i18 + 2] & 1048575;
                switch (i19) {
                    case 0:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.y(i20);
                        i17 += i10;
                        break;
                    case 1:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.o(i20);
                        i17 += i10;
                        break;
                    case 2:
                        if (v(t, i18)) {
                            j5 = n3.p(t, j8);
                            i10 = g0.I(i20, j5);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        if (v(t, i18)) {
                            j6 = n3.p(t, j8);
                            i10 = g0.N(i20, j6);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (v(t, i18)) {
                            i11 = n3.o(t, j8);
                            i10 = g0.S(i20, i11);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.R(i20);
                        i17 += i10;
                        break;
                    case 6:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.a0(i20);
                        i17 += i10;
                        break;
                    case 7:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.A(i20);
                        i17 += i10;
                        break;
                    case 8:
                        if (v(t, i18)) {
                            obj2 = n3.t(t, j8);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = w2.n(i20, n3.t(t, j8), y(i18));
                        i17 += i10;
                        break;
                    case 10:
                        if (!v(t, i18)) {
                            break;
                        }
                        obj2 = n3.t(t, j8);
                        i10 = g0.B(i20, (y) obj2);
                        i17 += i10;
                        break;
                    case 11:
                        if (v(t, i18)) {
                            i12 = n3.o(t, j8);
                            i10 = g0.W(i20, i12);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        if (v(t, i18)) {
                            i13 = n3.o(t, j8);
                            i10 = g0.d0(i20, i13);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.c0(i20);
                        i17 += i10;
                        break;
                    case 14:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.V(i20);
                        i17 += i10;
                        break;
                    case 15:
                        if (v(t, i18)) {
                            i14 = n3.o(t, j8);
                            i10 = g0.Z(i20, i14);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        if (v(t, i18)) {
                            j7 = n3.p(t, j8);
                            i10 = g0.O(i20, j7);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        if (!v(t, i18)) {
                            break;
                        }
                        i10 = g0.D(i20, (e2) n3.t(t, j8), y(i18));
                        i17 += i10;
                        break;
                    case 18:
                    case 23:
                    case 32:
                        i10 = w2.Y(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 19:
                    case 24:
                    case 31:
                        i10 = w2.X(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 20:
                        i10 = w2.Q(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 21:
                        i10 = w2.R(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 22:
                        i10 = w2.U(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 25:
                        i10 = w2.Z(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 26:
                        i10 = w2.o(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 27:
                        i10 = w2.p(i20, J(t, j8), y(i18));
                        i17 += i10;
                        break;
                    case 28:
                        i10 = w2.t(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 29:
                        i10 = w2.V(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 30:
                        i10 = w2.T(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 33:
                        i10 = w2.W(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 34:
                        i10 = w2.S(i20, J(t, j8));
                        i17 += i10;
                        break;
                    case 35:
                        i15 = w2.I((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 36:
                        i15 = w2.G((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 37:
                        i15 = w2.a((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 38:
                        i15 = w2.j((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 39:
                        i15 = w2.z((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 40:
                        i15 = w2.I((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 41:
                        i15 = w2.G((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 42:
                        i15 = w2.K((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 43:
                        i15 = w2.B((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 44:
                        i15 = w2.v((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 45:
                        i15 = w2.G((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 46:
                        i15 = w2.I((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 47:
                        i15 = w2.E((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        i15 = w2.q((List) unsafe.getObject(t, j8));
                        if (i15 <= 0) {
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i10 = w2.u(i20, J(t, j8), y(i18));
                        i17 += i10;
                        break;
                    case 50:
                        i10 = this.q.b(i20, n3.t(t, j8), z(i18));
                        i17 += i10;
                        break;
                    case 51:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.y(i20);
                        i17 += i10;
                        break;
                    case 52:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.o(i20);
                        i17 += i10;
                        break;
                    case 53:
                        if (w(t, i20, i18)) {
                            j5 = N(t, j8);
                            i10 = g0.I(i20, j5);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 54:
                        if (w(t, i20, i18)) {
                            j6 = N(t, j8);
                            i10 = g0.N(i20, j6);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 55:
                        if (w(t, i20, i18)) {
                            i11 = M(t, j8);
                            i10 = g0.S(i20, i11);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 56:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.R(i20);
                        i17 += i10;
                        break;
                    case 57:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.a0(i20);
                        i17 += i10;
                        break;
                    case 58:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.A(i20);
                        i17 += i10;
                        break;
                    case 59:
                        if (w(t, i20, i18)) {
                            obj2 = n3.t(t, j8);
                            break;
                        } else {
                            break;
                        }
                    case 60:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = w2.n(i20, n3.t(t, j8), y(i18));
                        i17 += i10;
                        break;
                    case 61:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        obj2 = n3.t(t, j8);
                        i10 = g0.B(i20, (y) obj2);
                        i17 += i10;
                        break;
                    case 62:
                        if (w(t, i20, i18)) {
                            i12 = M(t, j8);
                            i10 = g0.W(i20, i12);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 63:
                        if (w(t, i20, i18)) {
                            i13 = M(t, j8);
                            i10 = g0.d0(i20, i13);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 64:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.c0(i20);
                        i17 += i10;
                        break;
                    case 65:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.V(i20);
                        i17 += i10;
                        break;
                    case 66:
                        if (w(t, i20, i18)) {
                            i14 = M(t, j8);
                            i10 = g0.Z(i20, i14);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 67:
                        if (w(t, i20, i18)) {
                            j7 = N(t, j8);
                            i10 = g0.O(i20, j7);
                            i17 += i10;
                            break;
                        } else {
                            break;
                        }
                    case 68:
                        if (!w(t, i20, i18)) {
                            break;
                        }
                        i10 = g0.D(i20, (e2) n3.t(t, j8), y(i18));
                        i17 += i10;
                        break;
                }
            }
            if (((j3) this.o) != null) {
                return t.zzjp.a() + i17;
            }
            throw null;
        }
        Unsafe unsafe2 = r;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        while (i23 < this.f3299a.length) {
            int B2 = B(i23);
            int[] iArr2 = this.f3299a;
            int i26 = iArr2[i23];
            int i27 = (i16 & B2) >>> 20;
            if (i27 <= 17) {
                i3 = iArr2[i23 + 2];
                int i28 = i3 & 1048575;
                i2 = 1 << (i3 >>> 20);
                if (i28 != i22) {
                    i25 = unsafe2.getInt(t, (long) i28);
                    i22 = i28;
                }
            } else {
                i3 = (!this.i || i27 < u0.DOUBLE_LIST_PACKED.f3432b || i27 > u0.SINT64_LIST_PACKED.f3432b) ? 0 : iArr2[i23 + 2] & 1048575;
                i2 = 0;
            }
            long j9 = (long) (B2 & 1048575);
            switch (i27) {
                case 0:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.y(i26);
                    i24 += i4;
                    break;
                case 1:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.o(i26);
                    i24 += i4;
                    break;
                case 2:
                    if ((i25 & i2) != 0) {
                        j2 = unsafe2.getLong(t, j9);
                        i4 = g0.I(i26, j2);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i25 & i2) != 0) {
                        j3 = unsafe2.getLong(t, j9);
                        i4 = g0.N(i26, j3);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i25 & i2) != 0) {
                        i5 = unsafe2.getInt(t, j9);
                        i4 = g0.S(i26, i5);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.R(i26);
                    i24 += i4;
                    break;
                case 6:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.a0(i26);
                    i24 += i4;
                    break;
                case 7:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.A(i26);
                    i24 += i4;
                    break;
                case 8:
                    if ((i25 & i2) != 0) {
                        obj = unsafe2.getObject(t, j9);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = w2.n(i26, unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
                case 10:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    obj = unsafe2.getObject(t, j9);
                    i4 = g0.B(i26, (y) obj);
                    i24 += i4;
                    break;
                case 11:
                    if ((i25 & i2) != 0) {
                        i6 = unsafe2.getInt(t, j9);
                        i4 = g0.W(i26, i6);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i25 & i2) != 0) {
                        i7 = unsafe2.getInt(t, j9);
                        i4 = g0.d0(i26, i7);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.c0(i26);
                    i24 += i4;
                    break;
                case 14:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.V(i26);
                    i24 += i4;
                    break;
                case 15:
                    if ((i25 & i2) != 0) {
                        i8 = unsafe2.getInt(t, j9);
                        i4 = g0.Z(i26, i8);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i25 & i2) != 0) {
                        j4 = unsafe2.getLong(t, j9);
                        i4 = g0.O(i26, j4);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i25 & i2) == 0) {
                        break;
                    }
                    i4 = g0.D(i26, (e2) unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
                case 18:
                case 23:
                case 32:
                    i4 = w2.Y(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 19:
                case 24:
                case 31:
                    i4 = w2.X(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 20:
                    i4 = w2.Q(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 21:
                    i4 = w2.R(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 22:
                    i4 = w2.U(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 25:
                    i4 = w2.Z(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 26:
                    i4 = w2.o(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 27:
                    i4 = w2.p(i26, (List) unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
                case 28:
                    i4 = w2.t(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 29:
                    i4 = w2.V(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 30:
                    i4 = w2.T(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 33:
                    i4 = w2.W(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 34:
                    i4 = w2.S(i26, (List) unsafe2.getObject(t, j9));
                    i24 += i4;
                    break;
                case 35:
                    i9 = w2.I((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 36:
                    i9 = w2.G((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 37:
                    i9 = w2.a((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 38:
                    i9 = w2.j((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 39:
                    i9 = w2.z((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 40:
                    i9 = w2.I((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 41:
                    i9 = w2.G((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 42:
                    i9 = w2.K((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 43:
                    i9 = w2.B((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 44:
                    i9 = w2.v((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 45:
                    i9 = w2.G((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 46:
                    i9 = w2.I((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 47:
                    i9 = w2.E((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 48:
                    i9 = w2.q((List) unsafe2.getObject(t, j9));
                    if (i9 <= 0) {
                        break;
                    } else {
                        break;
                    }
                case 49:
                    i4 = w2.u(i26, (List) unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
                case 50:
                    i4 = this.q.b(i26, unsafe2.getObject(t, j9), z(i23));
                    i24 += i4;
                    break;
                case 51:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.y(i26);
                    i24 += i4;
                    break;
                case 52:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.o(i26);
                    i24 += i4;
                    break;
                case 53:
                    if (w(t, i26, i23)) {
                        j2 = N(t, j9);
                        i4 = g0.I(i26, j2);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (w(t, i26, i23)) {
                        j3 = N(t, j9);
                        i4 = g0.N(i26, j3);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (w(t, i26, i23)) {
                        i5 = M(t, j9);
                        i4 = g0.S(i26, i5);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.R(i26);
                    i24 += i4;
                    break;
                case 57:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.a0(i26);
                    i24 += i4;
                    break;
                case 58:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.A(i26);
                    i24 += i4;
                    break;
                case 59:
                    if (w(t, i26, i23)) {
                        obj = unsafe2.getObject(t, j9);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = w2.n(i26, unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
                case 61:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    obj = unsafe2.getObject(t, j9);
                    i4 = g0.B(i26, (y) obj);
                    i24 += i4;
                    break;
                case 62:
                    if (w(t, i26, i23)) {
                        i6 = M(t, j9);
                        i4 = g0.W(i26, i6);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (w(t, i26, i23)) {
                        i7 = M(t, j9);
                        i4 = g0.d0(i26, i7);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.c0(i26);
                    i24 += i4;
                    break;
                case 65:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.V(i26);
                    i24 += i4;
                    break;
                case 66:
                    if (w(t, i26, i23)) {
                        i8 = M(t, j9);
                        i4 = g0.Z(i26, i8);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (w(t, i26, i23)) {
                        j4 = N(t, j9);
                        i4 = g0.O(i26, j4);
                        i24 += i4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (!w(t, i26, i23)) {
                        break;
                    }
                    i4 = g0.D(i26, (e2) unsafe2.getObject(t, j9), y(i23));
                    i24 += i4;
                    break;
            }
            i23 += 4;
            i16 = 267386880;
            i22 = i22;
        }
        if (((j3) this.o) != null) {
            int a2 = t.zzjp.a() + i24;
            if (!this.f3305g) {
                return a2;
            }
            if (((n0) this.p) != null) {
                q0<z0.d> q0Var = t.zzjv;
                int i29 = 0;
                for (int i30 = 0; i30 < q0Var.f3395a.f(); i30++) {
                    Map.Entry<FieldDescriptorType, Object> d2 = q0Var.f3395a.d(i30);
                    i29 += q0.g(d2.getKey(), d2.getValue());
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : q0Var.f3395a.g()) {
                    i29 += q0.g(entry.getKey(), entry.getValue());
                }
                return a2 + i29;
            }
            throw null;
        }
        throw null;
    }

    public final int m(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, int i9, u uVar) {
        int i10;
        Object obj;
        Object obj2;
        Object obj3;
        long j3;
        int i11;
        int i12;
        Unsafe unsafe = r;
        long j4 = (long) (this.f3299a[i9 + 2] & 1048575);
        boolean z = true;
        switch (i8) {
            case 51:
                if (i6 == 1) {
                    obj = Double.valueOf(t.I4(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 52:
                if (i6 == 5) {
                    obj2 = Float.valueOf(t.L4(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 53:
            case 54:
                if (i6 == 0) {
                    i10 = t.q4(bArr, i2, uVar);
                    j3 = uVar.f3425b;
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 55:
            case 62:
                if (i6 == 0) {
                    i10 = t.S3(bArr, i2, uVar);
                    i11 = uVar.f3424a;
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 56:
            case 65:
                if (i6 == 1) {
                    obj = Long.valueOf(t.G4(bArr, i2));
                    unsafe.putObject(t, j2, obj);
                    i10 = i2 + 8;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 57:
            case 64:
                if (i6 == 5) {
                    obj2 = Integer.valueOf(t.z4(bArr, i2));
                    unsafe.putObject(t, j2, obj2);
                    i10 = i2 + 4;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 58:
                if (i6 == 0) {
                    i10 = t.q4(bArr, i2, uVar);
                    if (uVar.f3425b == 0) {
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
                    i10 = t.S3(bArr, i2, uVar);
                    i12 = uVar.f3424a;
                    if (i12 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else if ((i7 & 536870912) == 0 || p3.f(bArr, i10, i10 + i12)) {
                        unsafe.putObject(t, j2, new String(bArr, i10, i12, b1.f3229a));
                        i10 += i12;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    } else {
                        throw f1.e();
                    }
                }
                return i2;
            case 60:
                if (i6 == 2) {
                    i10 = l(y(i9), bArr, i2, i3, uVar);
                    Object object = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = uVar.f3426c;
                    if (object != null) {
                        obj3 = b1.d(object, obj3);
                    }
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 61:
                if (i6 == 2) {
                    i10 = t.S3(bArr, i2, uVar);
                    i12 = uVar.f3424a;
                    if (i12 == 0) {
                        obj3 = y.f3474c;
                        unsafe.putObject(t, j2, obj3);
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    }
                    unsafe.putObject(t, j2, y.a(bArr, i10, i12));
                    i10 += i12;
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 63:
                if (i6 == 0) {
                    int S3 = t.S3(bArr, i2, uVar);
                    int i13 = uVar.f3424a;
                    d1 d1Var = (d1) this.f3300b[((i9 / 4) << 1) + 1];
                    if (d1Var == null || d1Var.a(i13) != null) {
                        unsafe.putObject(t, j2, Integer.valueOf(i13));
                        i10 = S3;
                        unsafe.putInt(t, j4, i5);
                        return i10;
                    }
                    P(t).b(i4, Long.valueOf((long) i13));
                    return S3;
                }
                return i2;
            case 66:
                if (i6 == 0) {
                    i10 = t.S3(bArr, i2, uVar);
                    i11 = f0.b(uVar.f3424a);
                    obj3 = Integer.valueOf(i11);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 67:
                if (i6 == 0) {
                    i10 = t.q4(bArr, i2, uVar);
                    j3 = f0.a(uVar.f3425b);
                    obj3 = Long.valueOf(j3);
                    unsafe.putObject(t, j2, obj3);
                    unsafe.putInt(t, j4, i5);
                    return i10;
                }
                return i2;
            case 68:
                if (i6 == 3) {
                    i10 = k(y(i9), bArr, i2, i3, (i4 & -8) | 4, uVar);
                    Object object2 = unsafe.getInt(t, j4) == i5 ? unsafe.getObject(t, j2) : null;
                    obj3 = uVar.f3426c;
                    if (object2 != null) {
                        obj3 = b1.d(object2, obj3);
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

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0244, code lost:
        if (r30.f3425b != 0) goto L_0x0261;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0247, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0248, code lost:
        r11.c(r11.f3439d, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x024d, code lost:
        if (r4 >= r20) goto L_0x03b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x024f, code lost:
        r6 = b.x.t.S3(r18, r4, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0255, code lost:
        if (r21 != r30.f3424a) goto L_0x03b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0257, code lost:
        r4 = b.x.t.q4(r18, r6, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x025f, code lost:
        if (r30.f3425b == 0) goto L_0x0247;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0261, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0146, code lost:
        if (r4 == 0) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0149, code lost:
        r11.add(c.b.a.a.g.b.y.a(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0153, code lost:
        r4 = b.x.t.S3(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0159, code lost:
        if (r21 != r30.f3424a) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x015b, code lost:
        r1 = b.x.t.S3(r18, r4, r30);
        r4 = r30.f3424a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0161, code lost:
        if (r4 != 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0163, code lost:
        r11.add(c.b.a.a.g.b.y.f3474c);
     */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01e0  */
    public final int n(T t, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, long j2, int i8, long j3, u uVar) {
        int q4;
        int S3;
        int S32;
        int q42;
        int i9 = i2;
        e1 e1Var = (e1) r.getObject(t, j3);
        if (!e1Var.y()) {
            int size = e1Var.size();
            e1Var = e1Var.r(size == 0 ? 10 : size << 1);
            r.putObject(t, j3, e1Var);
        }
        switch (i8) {
            case 18:
            case 35:
                if (i6 == 2) {
                    j0 j0Var = (j0) e1Var;
                    int S33 = t.S3(bArr, i9, uVar);
                    int i10 = uVar.f3424a + S33;
                    while (S33 < i10) {
                        j0Var.c(j0Var.f3329d, t.I4(bArr, S33));
                        S33 += 8;
                    }
                    if (S33 == i10) {
                        return S33;
                    }
                    throw f1.a();
                }
                if (i6 == 1) {
                    j0 j0Var2 = (j0) e1Var;
                    double I4 = t.I4(bArr, i2);
                    while (true) {
                        j0Var2.c(j0Var2.f3329d, I4);
                        int i11 = i9 + 8;
                        if (i11 >= i3) {
                            return i11;
                        }
                        i9 = t.S3(bArr, i11, uVar);
                        if (i4 != uVar.f3424a) {
                            return i11;
                        }
                        I4 = t.I4(bArr, i9);
                    }
                }
                return i9;
            case 19:
            case 36:
                if (i6 == 2) {
                    x0 x0Var = (x0) e1Var;
                    int S34 = t.S3(bArr, i9, uVar);
                    int i12 = uVar.f3424a + S34;
                    while (S34 < i12) {
                        x0Var.c(x0Var.f3464d, t.L4(bArr, S34));
                        S34 += 4;
                    }
                    if (S34 == i12) {
                        return S34;
                    }
                    throw f1.a();
                }
                if (i6 == 5) {
                    x0 x0Var2 = (x0) e1Var;
                    float L4 = t.L4(bArr, i2);
                    while (true) {
                        x0Var2.c(x0Var2.f3464d, L4);
                        int i13 = i9 + 4;
                        if (i13 >= i3) {
                            return i13;
                        }
                        i9 = t.S3(bArr, i13, uVar);
                        if (i4 != uVar.f3424a) {
                            return i13;
                        }
                        L4 = t.L4(bArr, i9);
                    }
                }
                return i9;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i6 == 2) {
                    t1 t1Var = (t1) e1Var;
                    int S35 = t.S3(bArr, i9, uVar);
                    int i14 = uVar.f3424a + S35;
                    while (S35 < i14) {
                        S35 = t.q4(bArr, S35, uVar);
                        t1Var.h(t1Var.f3417d, uVar.f3425b);
                    }
                    if (S35 == i14) {
                        return S35;
                    }
                    throw f1.a();
                }
                if (i6 == 0) {
                    t1 t1Var2 = (t1) e1Var;
                    do {
                        q4 = t.q4(bArr, i9, uVar);
                        t1Var2.h(t1Var2.f3417d, uVar.f3425b);
                        if (q4 >= i3) {
                            return q4;
                        }
                        i9 = t.S3(bArr, q4, uVar);
                    } while (i4 == uVar.f3424a);
                    return q4;
                }
                return i9;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i6 == 2) {
                    return t.T3(bArr, i9, e1Var, uVar);
                }
                if (i6 == 0) {
                    return t.G3(i4, bArr, i2, i3, e1Var, uVar);
                }
                return i9;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i6 == 2) {
                    t1 t1Var3 = (t1) e1Var;
                    int S36 = t.S3(bArr, i9, uVar);
                    int i15 = uVar.f3424a + S36;
                    while (S36 < i15) {
                        t1Var3.h(t1Var3.f3417d, t.G4(bArr, S36));
                        S36 += 8;
                    }
                    if (S36 == i15) {
                        return S36;
                    }
                    throw f1.a();
                }
                if (i6 == 1) {
                    t1 t1Var4 = (t1) e1Var;
                    long G4 = t.G4(bArr, i2);
                    while (true) {
                        t1Var4.h(t1Var4.f3417d, G4);
                        int i16 = i9 + 8;
                        if (i16 >= i3) {
                            return i16;
                        }
                        i9 = t.S3(bArr, i16, uVar);
                        if (i4 != uVar.f3424a) {
                            return i16;
                        }
                        G4 = t.G4(bArr, i9);
                    }
                }
                return i9;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i6 == 2) {
                    a1 a1Var = (a1) e1Var;
                    int S37 = t.S3(bArr, i9, uVar);
                    int i17 = uVar.f3424a + S37;
                    while (S37 < i17) {
                        a1Var.h(a1Var.f3215d, t.z4(bArr, S37));
                        S37 += 4;
                    }
                    if (S37 == i17) {
                        return S37;
                    }
                    throw f1.a();
                }
                if (i6 == 5) {
                    a1 a1Var2 = (a1) e1Var;
                    int z4 = t.z4(bArr, i2);
                    while (true) {
                        a1Var2.h(a1Var2.f3215d, z4);
                        int i18 = i9 + 4;
                        if (i18 >= i3) {
                            return i18;
                        }
                        i9 = t.S3(bArr, i18, uVar);
                        if (i4 != uVar.f3424a) {
                            return i18;
                        }
                        z4 = t.z4(bArr, i9);
                    }
                }
                return i9;
            case 25:
            case 42:
                if (i6 == 2) {
                    v vVar = (v) e1Var;
                    S3 = t.S3(bArr, i9, uVar);
                    int i19 = uVar.f3424a + S3;
                    while (S3 < i19) {
                        S3 = t.q4(bArr, S3, uVar);
                        vVar.c(vVar.f3439d, uVar.f3425b != 0);
                    }
                    if (S3 != i19) {
                        throw f1.a();
                    }
                    return S3;
                }
                if (i6 == 0) {
                    v vVar2 = (v) e1Var;
                    i9 = t.q4(bArr, i9, uVar);
                    break;
                }
                return i9;
            case 26:
                if (i6 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int S38 = t.S3(bArr, i9, uVar);
                        int i20 = uVar.f3424a;
                        if (i20 != 0) {
                            String str = new String(bArr, S38, i20, b1.f3229a);
                            e1Var.add(str);
                            S38 += i20;
                            if (S38 < i3) {
                                int S39 = t.S3(bArr, S38, uVar);
                                if (i4 == uVar.f3424a) {
                                    S38 = t.S3(bArr, S39, uVar);
                                    i20 = uVar.f3424a;
                                    if (i20 != 0) {
                                        str = new String(bArr, S38, i20, b1.f3229a);
                                        e1Var.add(str);
                                        S38 += i20;
                                        if (S38 < i3) {
                                            return S38;
                                        }
                                    }
                                }
                                return S38;
                            }
                            return S38;
                        }
                        e1Var.add("");
                        if (S38 < i3) {
                        }
                        return S38;
                    }
                    int S310 = t.S3(bArr, i9, uVar);
                    int i21 = uVar.f3424a;
                    if (i21 != 0) {
                        int i22 = S310 + i21;
                        if (p3.f(bArr, S310, i22)) {
                            String str2 = new String(bArr, S310, i21, b1.f3229a);
                            e1Var.add(str2);
                            S310 = i22;
                            if (S310 < i3) {
                                int S311 = t.S3(bArr, S310, uVar);
                                if (i4 == uVar.f3424a) {
                                    S310 = t.S3(bArr, S311, uVar);
                                    int i23 = uVar.f3424a;
                                    if (i23 != 0) {
                                        i22 = S310 + i23;
                                        if (p3.f(bArr, S310, i22)) {
                                            str2 = new String(bArr, S310, i23, b1.f3229a);
                                            e1Var.add(str2);
                                            S310 = i22;
                                            if (S310 < i3) {
                                                return S310;
                                            }
                                        }
                                        throw f1.e();
                                    }
                                }
                                return S310;
                            }
                            return S310;
                        }
                        throw f1.e();
                    }
                    e1Var.add("");
                    if (S310 < i3) {
                    }
                    return S310;
                }
                return i9;
            case 27:
                if (i6 == 2) {
                    return a(y(i7), i4, bArr, i2, i3, e1Var, uVar);
                }
                return i9;
            case 28:
                if (i6 == 2) {
                    int S312 = t.S3(bArr, i9, uVar);
                    int i24 = uVar.f3424a;
                    break;
                }
                return i9;
            case 30:
            case 44:
                if (i6 == 2) {
                    S3 = t.T3(bArr, i9, e1Var, uVar);
                } else {
                    if (i6 == 0) {
                        S3 = t.G3(i4, bArr, i2, i3, e1Var, uVar);
                    }
                    return i9;
                }
                T t2 = t;
                i3 i3Var = t2.zzjp;
                if (i3Var == i3.f3314f) {
                    i3Var = null;
                }
                i3 i3Var2 = (i3) w2.c(i5, e1Var, (d1) this.f3300b[((i7 / 4) << 1) + 1], i3Var, this.o);
                if (i3Var2 != null) {
                    t2.zzjp = i3Var2;
                }
                return S3;
            case 33:
            case 47:
                if (i6 == 2) {
                    a1 a1Var3 = (a1) e1Var;
                    int S313 = t.S3(bArr, i9, uVar);
                    int i25 = uVar.f3424a + S313;
                    while (S313 < i25) {
                        S313 = t.S3(bArr, S313, uVar);
                        a1Var3.h(a1Var3.f3215d, f0.b(uVar.f3424a));
                    }
                    if (S313 == i25) {
                        return S313;
                    }
                    throw f1.a();
                }
                if (i6 == 0) {
                    a1 a1Var4 = (a1) e1Var;
                    do {
                        S32 = t.S3(bArr, i9, uVar);
                        a1Var4.h(a1Var4.f3215d, f0.b(uVar.f3424a));
                        if (S32 >= i3) {
                            return S32;
                        }
                        i9 = t.S3(bArr, S32, uVar);
                    } while (i4 == uVar.f3424a);
                    return S32;
                }
                return i9;
            case 34:
            case 48:
                if (i6 == 2) {
                    t1 t1Var5 = (t1) e1Var;
                    int S314 = t.S3(bArr, i9, uVar);
                    int i26 = uVar.f3424a + S314;
                    while (S314 < i26) {
                        S314 = t.q4(bArr, S314, uVar);
                        t1Var5.h(t1Var5.f3417d, f0.a(uVar.f3425b));
                    }
                    if (S314 == i26) {
                        return S314;
                    }
                    throw f1.a();
                }
                if (i6 == 0) {
                    t1 t1Var6 = (t1) e1Var;
                    do {
                        q42 = t.q4(bArr, i9, uVar);
                        t1Var6.h(t1Var6.f3417d, f0.a(uVar.f3425b));
                        if (q42 >= i3) {
                            return q42;
                        }
                        i9 = t.S3(bArr, q42, uVar);
                    } while (i4 == uVar.f3424a);
                    return q42;
                }
                return i9;
            case 49:
                if (i6 == 3) {
                    u2 y = y(i7);
                    int i27 = (i4 & -8) | 4;
                    i9 = k(y, bArr, i2, i3, i27, uVar);
                    while (true) {
                        e1Var.add(uVar.f3426c);
                        if (i9 < i3) {
                            int S315 = t.S3(bArr, i9, uVar);
                            if (i4 == uVar.f3424a) {
                                i9 = k(y, bArr, S315, i3, i27, uVar);
                            }
                        }
                    }
                }
                return i9;
            default:
                return i9;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: <K:Ljava/lang/Object;V:Ljava/lang/Object;>(TT;[BIIIIJLc/b/a/a/g/b/u;)I */
    public final int o(Object obj, byte[] bArr, int i2, int i3, int i4, long j2, u uVar) {
        Unsafe unsafe = r;
        Object obj2 = this.f3300b[(i4 / 4) << 1];
        Object object = unsafe.getObject(obj, j2);
        if (this.q.f(object)) {
            Object g2 = this.q.g(obj2);
            this.q.h(g2, object);
            unsafe.putObject(obj, j2, g2);
            object = g2;
        }
        this.q.d(obj2);
        this.q.e(object);
        int S3 = t.S3(bArr, i2, uVar);
        int i5 = uVar.f3424a;
        if (i5 < 0 || i5 > i3 - S3) {
            throw f1.a();
        }
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02ef, code lost:
        if (r0 == r2) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0339, code lost:
        if (r0 == r15) goto L_0x033b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x033d, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r1 = r33;
        r13 = r34;
        r11 = r35;
        r9 = r36;
        r6 = r19;
        r7 = r26;
        r10 = r27;
        r8 = -1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x036a A[ADDED_TO_REGION] */
    public final int p(T t, byte[] bArr, int i2, int i3, int i4, u uVar) {
        Unsafe unsafe;
        int i5;
        T t2;
        d1<?> A;
        byte b2;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        byte[] bArr2;
        int i12;
        int i13;
        boolean z;
        byte[] bArr3;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        long j2;
        Object obj;
        int i20;
        int i21;
        long j3;
        Object obj2;
        h2<T> h2Var = this;
        T t3 = t;
        byte[] bArr4 = bArr;
        int i22 = i3;
        int i23 = i4;
        u uVar2 = uVar;
        Unsafe unsafe2 = r;
        int i24 = -1;
        int i25 = i2;
        int i26 = -1;
        int i27 = 0;
        int i28 = 0;
        while (true) {
            if (i25 < i22) {
                int i29 = i25 + 1;
                byte b3 = bArr4[i25];
                if (b3 < 0) {
                    i6 = t.L3(b3, bArr4, i29, uVar2);
                    b2 = uVar2.f3424a;
                } else {
                    b2 = b3;
                    i6 = i29;
                }
                int i30 = b2 >>> 3;
                int i31 = b2 & 7;
                int D = h2Var.D(i30);
                if (D != i24) {
                    int[] iArr = h2Var.f3299a;
                    int i32 = iArr[D + 1];
                    int i33 = (i32 & 267386880) >>> 20;
                    long j4 = (long) (i32 & 1048575);
                    if (i33 <= 17) {
                        int i34 = iArr[D + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i26) {
                            if (i26 != -1) {
                                unsafe2.putInt(t3, (long) i26, i28);
                            }
                            i28 = unsafe2.getInt(t3, (long) i36);
                            i26 = i36;
                        }
                        switch (i33) {
                            case 0:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                z = true;
                                i13 = i26;
                                if (i31 == 1) {
                                    n3.d(t3, j4, t.I4(bArr3, i6));
                                    i19 = i6 + 8;
                                    i18 = i19;
                                    i17 = i28 | i35;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5 && i5 != 0) {
                                    i25 = i6;
                                    i27 = i7;
                                    break;
                                } else {
                                    i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                    h2Var = this;
                                    t3 = t;
                                    bArr4 = bArr;
                                    i22 = i3;
                                    i23 = i5;
                                    i27 = i7;
                                    unsafe2 = unsafe;
                                    i24 = -1;
                                    uVar2 = uVar;
                                    break;
                                }
                            case 1:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                i13 = i26;
                                if (i31 == 5) {
                                    n3.f3369f.d(t3, j4, t.L4(bArr3, i6));
                                    i19 = i6 + 4;
                                    i18 = i19;
                                    i17 = i28 | i35;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 2:
                            case 3:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                i13 = i26;
                                if (i31 == 0) {
                                    i15 = t.q4(bArr3, i6, uVar2);
                                    unsafe2.putLong(t, j4, uVar2.f3425b);
                                    i16 = i28 | i35;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 4:
                            case 11:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                i13 = i26;
                                if (i31 == 0) {
                                    i18 = t.S3(bArr3, i6, uVar2);
                                    unsafe2.putInt(t3, j4, uVar2.f3424a);
                                    i17 = i28 | i35;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 5:
                            case 14:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                i13 = i26;
                                if (i31 == 1) {
                                    unsafe2.putLong(t, j4, t.G4(bArr3, i6));
                                    i19 = i6 + 8;
                                    i18 = i19;
                                    i17 = i28 | i35;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                } else {
                                    z = true;
                                    i5 = i4;
                                    unsafe = unsafe2;
                                    i7 = i12;
                                    i26 = i13;
                                    if (i7 != i5) {
                                    }
                                    i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                    h2Var = this;
                                    t3 = t;
                                    bArr4 = bArr;
                                    i22 = i3;
                                    i23 = i5;
                                    i27 = i7;
                                    unsafe2 = unsafe;
                                    i24 = -1;
                                    uVar2 = uVar;
                                    break;
                                }
                                break;
                            case 6:
                            case 13:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                i13 = i26;
                                if (i31 == 5) {
                                    unsafe2.putInt(t3, j4, t.z4(bArr3, i6));
                                    i19 = i6 + 4;
                                    i18 = i19;
                                    i17 = i28 | i35;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 7:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                if (i31 == 0) {
                                    i18 = t.q4(bArr3, i6, uVar2);
                                    n3.f3369f.g(t3, j4, uVar2.f3425b != 0);
                                    i17 = i28 | i35;
                                    i13 = i26;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 8:
                                bArr3 = bArr;
                                i14 = i3;
                                i12 = b2;
                                j2 = j4;
                                if (i31 == 2) {
                                    i18 = (i32 & 536870912) == 0 ? t.A4(bArr3, i6, uVar2) : t.E4(bArr3, i6, uVar2);
                                    obj = uVar2.f3426c;
                                    unsafe2.putObject(t3, j2, obj);
                                    i17 = i28 | i35;
                                    i13 = i26;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 9:
                                bArr3 = bArr;
                                i12 = b2;
                                j2 = j4;
                                if (i31 == 2) {
                                    i14 = i3;
                                    i18 = l(h2Var.y(D), bArr3, i6, i14, uVar2);
                                    if ((i28 & i35) != 0) {
                                        obj = b1.d(unsafe2.getObject(t3, j2), uVar2.f3426c);
                                        unsafe2.putObject(t3, j2, obj);
                                        i17 = i28 | i35;
                                        i13 = i26;
                                        i15 = i18;
                                        i16 = i17;
                                        i28 = i16;
                                        i25 = i15;
                                        i27 = i12;
                                        bArr4 = bArr3;
                                        i26 = i13;
                                        i24 = -1;
                                        i22 = i14;
                                        i23 = i4;
                                        break;
                                    }
                                    obj = uVar2.f3426c;
                                    unsafe2.putObject(t3, j2, obj);
                                    i17 = i28 | i35;
                                    i13 = i26;
                                    i15 = i18;
                                    i16 = i17;
                                    i28 = i16;
                                    i25 = i15;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 10:
                                bArr2 = bArr;
                                i12 = b2;
                                if (i31 == 2) {
                                    i21 = t.J4(bArr2, i6, uVar2);
                                    unsafe2.putObject(t3, j4, uVar2.f3426c);
                                    i28 |= i35;
                                    i20 = i21;
                                    i25 = i20;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 12:
                                bArr2 = bArr;
                                i12 = b2;
                                if (i31 == 0) {
                                    i20 = t.S3(bArr2, i6, uVar2);
                                    int i37 = uVar2.f3424a;
                                    d1<?> A2 = h2Var.A(D);
                                    if (A2 == null || A2.a(i37) != null) {
                                        unsafe2.putInt(t3, j4, i37);
                                        i28 |= i35;
                                    } else {
                                        P(t).b(i12, Long.valueOf((long) i37));
                                    }
                                    i25 = i20;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 15:
                                bArr2 = bArr;
                                i12 = b2;
                                if (i31 == 0) {
                                    i21 = t.S3(bArr2, i6, uVar2);
                                    unsafe2.putInt(t3, j4, f0.b(uVar2.f3424a));
                                    i28 |= i35;
                                    i20 = i21;
                                    i25 = i20;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 16:
                                i12 = b2;
                                bArr3 = bArr;
                                if (i31 == 0) {
                                    int q4 = t.q4(bArr3, i6, uVar2);
                                    unsafe2.putLong(t, j4, f0.a(uVar2.f3425b));
                                    i28 |= i35;
                                    i13 = i26;
                                    i25 = q4;
                                    i14 = i3;
                                    i27 = i12;
                                    bArr4 = bArr3;
                                    i26 = i13;
                                    i24 = -1;
                                    i22 = i14;
                                    i23 = i4;
                                    break;
                                }
                                i13 = i26;
                                z = true;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                            case 17:
                                if (i31 == 3) {
                                    i25 = k(h2Var.y(D), bArr, i6, i3, (i30 << 3) | 4, uVar);
                                    if ((i28 & i35) == 0) {
                                        obj2 = uVar2.f3426c;
                                        j3 = j4;
                                    } else {
                                        j3 = j4;
                                        obj2 = b1.d(unsafe2.getObject(t3, j3), uVar2.f3426c);
                                    }
                                    unsafe2.putObject(t3, j3, obj2);
                                    i28 |= i35;
                                    i22 = i3;
                                    i23 = i4;
                                    i27 = b2;
                                    i24 = -1;
                                    bArr4 = bArr;
                                    break;
                                } else {
                                    i12 = b2;
                                    i13 = i26;
                                    z = true;
                                    i5 = i4;
                                    unsafe = unsafe2;
                                    i7 = i12;
                                    i26 = i13;
                                    if (i7 != i5) {
                                    }
                                    i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                    h2Var = this;
                                    t3 = t;
                                    bArr4 = bArr;
                                    i22 = i3;
                                    i23 = i5;
                                    i27 = i7;
                                    unsafe2 = unsafe;
                                    i24 = -1;
                                    uVar2 = uVar;
                                    break;
                                }
                                break;
                            default:
                                i12 = b2;
                                z = true;
                                i13 = i26;
                                i5 = i4;
                                unsafe = unsafe2;
                                i7 = i12;
                                i26 = i13;
                                if (i7 != i5) {
                                }
                                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                h2Var = this;
                                t3 = t;
                                bArr4 = bArr;
                                i22 = i3;
                                i23 = i5;
                                i27 = i7;
                                unsafe2 = unsafe;
                                i24 = -1;
                                uVar2 = uVar;
                                break;
                        }
                    } else {
                        bArr2 = bArr;
                        i12 = b2;
                        i10 = i26;
                        if (i33 != 27) {
                            if (i33 <= 49) {
                                i9 = i28;
                                unsafe = unsafe2;
                                i8 = i12;
                                i25 = n(t, bArr, i6, i3, i12, i30, i31, D, (long) i32, i33, j4, uVar);
                            } else {
                                i11 = i6;
                                i9 = i28;
                                unsafe = unsafe2;
                                i8 = i12;
                                if (i33 == 50) {
                                    if (i31 == 2) {
                                        o(t, bArr, i11, i3, D, j4, uVar);
                                        throw null;
                                    }
                                    i6 = i11;
                                    i7 = i8;
                                    i5 = i4;
                                    i26 = i10;
                                    i28 = i9;
                                    if (i7 != i5) {
                                    }
                                    i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                                    h2Var = this;
                                    t3 = t;
                                    bArr4 = bArr;
                                    i22 = i3;
                                    i23 = i5;
                                    i27 = i7;
                                    unsafe2 = unsafe;
                                    i24 = -1;
                                    uVar2 = uVar;
                                } else {
                                    i25 = m(t, bArr, i11, i3, i8, i30, i31, i32, i33, j4, D, uVar);
                                }
                            }
                            i6 = i25;
                            i7 = i8;
                            i5 = i4;
                            i26 = i10;
                            i28 = i9;
                            if (i7 != i5) {
                            }
                            i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                            h2Var = this;
                            t3 = t;
                            bArr4 = bArr;
                            i22 = i3;
                            i23 = i5;
                            i27 = i7;
                            unsafe2 = unsafe;
                            i24 = -1;
                            uVar2 = uVar;
                        } else if (i31 == 2) {
                            e1 e1Var = (e1) unsafe2.getObject(t3, j4);
                            if (!e1Var.y()) {
                                int size = e1Var.size();
                                e1Var = e1Var.r(size == 0 ? 10 : size << 1);
                                unsafe2.putObject(t3, j4, e1Var);
                            }
                            i25 = a(h2Var.y(D), i12, bArr, i6, i3, e1Var, uVar);
                            i26 = i10;
                        } else {
                            i11 = i6;
                            i9 = i28;
                            unsafe = unsafe2;
                            i8 = i12;
                        }
                    }
                    i23 = i4;
                    i27 = i12;
                    bArr4 = bArr2;
                    i24 = -1;
                    i22 = i3;
                } else {
                    i11 = i6;
                    i8 = b2;
                    i10 = i26;
                    i9 = i28;
                    unsafe = unsafe2;
                }
                i6 = i11;
                i7 = i8;
                i5 = i4;
                i26 = i10;
                i28 = i9;
                if (i7 != i5) {
                }
                i25 = t.H3(i7, bArr, i6, i3, P(t), uVar);
                h2Var = this;
                t3 = t;
                bArr4 = bArr;
                i22 = i3;
                i23 = i5;
                i27 = i7;
                unsafe2 = unsafe;
                i24 = -1;
                uVar2 = uVar;
            } else {
                unsafe = unsafe2;
                i5 = i23;
            }
        }
        if (i26 != -1) {
            t2 = t;
            unsafe.putInt(t2, (long) i26, i28);
        } else {
            t2 = t;
        }
        int[] iArr2 = this.k;
        if (iArr2 != null) {
            for (int i38 : iArr2) {
                h3<?, ?> h3Var = this.o;
                int i39 = this.f3299a[i38];
                Object t4 = n3.t(t2, (long) (B(i38) & 1048575));
                if (!(t4 == null || (A = A(i38)) == null)) {
                    Map<?, ?> e2 = this.q.e(t4);
                    this.q.d(this.f3300b[(i38 / 4) << 1]);
                    for (Map.Entry<?, ?> entry : e2.entrySet()) {
                        if (A.a(((Integer) entry.getValue()).intValue()) == null) {
                            if (((j3) h3Var) != null) {
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
        if (i5 == 0) {
            if (i25 != i3) {
                throw f1.d();
            }
        } else if (i25 > i3 || i27 != i5) {
            throw f1.d();
        }
        return i25;
    }

    public final <K, V> void t(b4 b4Var, int i2, Object obj, int i3) {
        if (obj != null) {
            this.q.d(this.f3300b[(i3 / 4) << 1]);
            Map<?, ?> c2 = this.q.c(obj);
            i0 i0Var = (i0) b4Var;
            if (i0Var != null) {
                Iterator<Map.Entry<?, ?>> it = c2.entrySet().iterator();
                if (it.hasNext()) {
                    Map.Entry<?, ?> next = it.next();
                    i0Var.f3309a.s(i2, 2);
                    next.getKey();
                    next.getValue();
                    throw null;
                }
                return;
            }
            throw null;
        }
    }

    public final void u(T t, T t2, int i2) {
        long j2 = (long) (this.f3299a[i2 + 1] & 1048575);
        if (v(t2, i2)) {
            Object t3 = n3.t(t, j2);
            Object t4 = n3.t(t2, j2);
            if (t3 != null && t4 != null) {
                n3.f(t, j2, b1.d(t3, t4));
                E(t, i2);
            } else if (t4 != null) {
                n3.f(t, j2, t4);
                E(t, i2);
            }
        }
    }

    public final boolean v(T t, int i2) {
        if (this.h) {
            int i3 = this.f3299a[i2 + 1];
            long j2 = (long) (i3 & 1048575);
            switch ((i3 & 267386880) >>> 20) {
                case 0:
                    return n3.s(t, j2) != 0.0d;
                case 1:
                    return n3.r(t, j2) != 0.0f;
                case 2:
                    return n3.p(t, j2) != 0;
                case 3:
                    return n3.p(t, j2) != 0;
                case 4:
                    return n3.o(t, j2) != 0;
                case 5:
                    return n3.p(t, j2) != 0;
                case 6:
                    return n3.o(t, j2) != 0;
                case 7:
                    return n3.q(t, j2);
                case 8:
                    Object t2 = n3.t(t, j2);
                    if (t2 instanceof String) {
                        return !((String) t2).isEmpty();
                    }
                    if (t2 instanceof y) {
                        return !y.f3474c.equals(t2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return n3.t(t, j2) != null;
                case 10:
                    return !y.f3474c.equals(n3.t(t, j2));
                case 11:
                    return n3.o(t, j2) != 0;
                case 12:
                    return n3.o(t, j2) != 0;
                case 13:
                    return n3.o(t, j2) != 0;
                case 14:
                    return n3.p(t, j2) != 0;
                case 15:
                    return n3.o(t, j2) != 0;
                case 16:
                    return n3.p(t, j2) != 0;
                case 17:
                    return n3.t(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int i4 = this.f3299a[i2 + 2];
            return (n3.o(t, (long) (i4 & 1048575)) & (1 << (i4 >>> 20))) != 0;
        }
    }

    public final boolean w(T t, int i2, int i3) {
        return n3.o(t, (long) (this.f3299a[i3 + 2] & 1048575)) == i2;
    }

    public final boolean x(T t, int i2, int i3, int i4) {
        return this.h ? v(t, i2) : (i3 & i4) != 0;
    }

    public final u2 y(int i2) {
        int i3 = (i2 / 4) << 1;
        Object[] objArr = this.f3300b;
        u2 u2Var = (u2) objArr[i3];
        if (u2Var != null) {
            return u2Var;
        }
        u2<T> a2 = p2.f3390c.a((Class) objArr[i3 + 1]);
        this.f3300b[i3] = a2;
        return a2;
    }

    public final Object z(int i2) {
        return this.f3300b[(i2 / 4) << 1];
    }
}
