package b.r.d;

import androidx.recyclerview.widget.RecyclerView;
import b.r.d.x;
import java.util.ArrayList;
import java.util.List;

public class a implements x.a {

    /* renamed from: a  reason: collision with root package name */
    public b.i.k.b<b> f2282a = new b.i.k.b<>(30);

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<b> f2283b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList<b> f2284c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final AbstractC0044a f2285d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2286e;

    /* renamed from: f  reason: collision with root package name */
    public final x f2287f;

    /* renamed from: g  reason: collision with root package name */
    public int f2288g = 0;

    /* renamed from: b.r.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0044a {
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2289a;

        /* renamed from: b  reason: collision with root package name */
        public int f2290b;

        /* renamed from: c  reason: collision with root package name */
        public Object f2291c;

        /* renamed from: d  reason: collision with root package name */
        public int f2292d;

        public b(int i, int i2, int i3, Object obj) {
            this.f2289a = i;
            this.f2290b = i2;
            this.f2292d = i3;
            this.f2291c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f2289a;
            if (i != bVar.f2289a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f2292d - this.f2290b) == 1 && this.f2292d == bVar.f2290b && this.f2290b == bVar.f2292d) {
                return true;
            }
            if (this.f2292d != bVar.f2292d || this.f2290b != bVar.f2290b) {
                return false;
            }
            Object obj2 = this.f2291c;
            Object obj3 = bVar.f2291c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f2289a * 31) + this.f2290b) * 31) + this.f2292d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.f2289a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f2290b);
            sb.append("c:");
            sb.append(this.f2292d);
            sb.append(",p:");
            sb.append(this.f2291c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(AbstractC0044a aVar) {
        this.f2285d = aVar;
        this.f2286e = false;
        this.f2287f = new x(this);
    }

    public final boolean a(int i) {
        int size = this.f2284c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f2284c.get(i2);
            int i3 = bVar.f2289a;
            if (i3 == 8) {
                if (f(bVar.f2292d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f2290b;
                int i5 = bVar.f2292d + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        int size = this.f2284c.size();
        for (int i = 0; i < size; i++) {
            ((c0) this.f2285d).a(this.f2284c.get(i));
        }
        l(this.f2284c);
        this.f2288g = 0;
    }

    public void c() {
        b();
        int size = this.f2283b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f2283b.get(i);
            int i2 = bVar.f2289a;
            if (i2 == 1) {
                ((c0) this.f2285d).a(bVar);
                ((c0) this.f2285d).d(bVar.f2290b, bVar.f2292d);
            } else if (i2 == 2) {
                ((c0) this.f2285d).a(bVar);
                AbstractC0044a aVar = this.f2285d;
                int i3 = bVar.f2290b;
                int i4 = bVar.f2292d;
                c0 c0Var = (c0) aVar;
                c0Var.f2305a.S(i3, i4, true);
                RecyclerView recyclerView = c0Var.f2305a;
                recyclerView.k0 = true;
                recyclerView.h0.f345c += i4;
            } else if (i2 == 4) {
                ((c0) this.f2285d).a(bVar);
                ((c0) this.f2285d).c(bVar.f2290b, bVar.f2292d, bVar.f2291c);
            } else if (i2 == 8) {
                ((c0) this.f2285d).a(bVar);
                ((c0) this.f2285d).e(bVar.f2290b, bVar.f2292d);
            }
        }
        l(this.f2283b);
        this.f2288g = 0;
    }

    public final void d(b bVar) {
        int i;
        int i2 = bVar.f2289a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.f2290b, i2);
        int i3 = bVar.f2290b;
        int i4 = bVar.f2289a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.f2292d; i6++) {
            int m2 = m((i * i6) + bVar.f2290b, bVar.f2289a);
            int i7 = bVar.f2289a;
            if (i7 == 2 ? m2 == m : i7 == 4 && m2 == m + 1) {
                i5++;
            } else {
                b h = h(bVar.f2289a, m, i5, bVar.f2291c);
                e(h, i3);
                if (!this.f2286e) {
                    h.f2291c = null;
                    this.f2282a.b(h);
                }
                if (bVar.f2289a == 4) {
                    i3 += i5;
                }
                i5 = 1;
                m = m2;
            }
        }
        Object obj = bVar.f2291c;
        if (!this.f2286e) {
            bVar.f2291c = null;
            this.f2282a.b(bVar);
        }
        if (i5 > 0) {
            b h2 = h(bVar.f2289a, m, i5, obj);
            e(h2, i3);
            if (!this.f2286e) {
                h2.f2291c = null;
                this.f2282a.b(h2);
            }
        }
    }

    public void e(b bVar, int i) {
        ((c0) this.f2285d).a(bVar);
        int i2 = bVar.f2289a;
        if (i2 == 2) {
            AbstractC0044a aVar = this.f2285d;
            int i3 = bVar.f2292d;
            c0 c0Var = (c0) aVar;
            c0Var.f2305a.S(i, i3, true);
            RecyclerView recyclerView = c0Var.f2305a;
            recyclerView.k0 = true;
            recyclerView.h0.f345c += i3;
        } else if (i2 == 4) {
            ((c0) this.f2285d).c(i, bVar.f2292d, bVar.f2291c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int f(int i, int i2) {
        int size = this.f2284c.size();
        while (i2 < size) {
            b bVar = this.f2284c.get(i2);
            int i3 = bVar.f2289a;
            if (i3 == 8) {
                int i4 = bVar.f2290b;
                if (i4 == i) {
                    i = bVar.f2292d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f2292d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f2290b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f2292d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f2292d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean g() {
        return this.f2283b.size() > 0;
    }

    public b h(int i, int i2, int i3, Object obj) {
        b a2 = this.f2282a.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.f2289a = i;
        a2.f2290b = i2;
        a2.f2292d = i3;
        a2.f2291c = obj;
        return a2;
    }

    public final void i(b bVar) {
        this.f2284c.add(bVar);
        int i = bVar.f2289a;
        if (i == 1) {
            ((c0) this.f2285d).d(bVar.f2290b, bVar.f2292d);
        } else if (i == 2) {
            AbstractC0044a aVar = this.f2285d;
            c0 c0Var = (c0) aVar;
            c0Var.f2305a.S(bVar.f2290b, bVar.f2292d, false);
            c0Var.f2305a.k0 = true;
        } else if (i == 4) {
            ((c0) this.f2285d).c(bVar.f2290b, bVar.f2292d, bVar.f2291c);
        } else if (i == 8) {
            ((c0) this.f2285d).e(bVar.f2290b, bVar.f2292d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0193, code lost:
        if (r6 >= r12.f2290b) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0169, code lost:
        if (r6 > r12.f2290b) goto L_0x0195;
     */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0140  */
    public void j() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        int i2;
        int i3;
        int i4;
        b bVar;
        int i5;
        b bVar2;
        int i6;
        int i7;
        b bVar3;
        x xVar = this.f2287f;
        ArrayList<b> arrayList = this.f2283b;
        if (xVar != null) {
            while (true) {
                int size = arrayList.size() - 1;
                boolean z5 = false;
                while (true) {
                    if (size < 0) {
                        size = -1;
                        break;
                    }
                    if (arrayList.get(size).f2289a != 8) {
                        z5 = true;
                    } else if (z5) {
                        break;
                    }
                    size--;
                }
                if (size == -1) {
                    break;
                }
                int i8 = size + 1;
                b bVar4 = arrayList.get(size);
                b bVar5 = arrayList.get(i8);
                int i9 = bVar5.f2289a;
                if (i9 == 1) {
                    int i10 = bVar4.f2292d < bVar5.f2290b ? -1 : 0;
                    if (bVar4.f2290b < bVar5.f2290b) {
                        i10++;
                    }
                    int i11 = bVar5.f2290b;
                    int i12 = bVar4.f2290b;
                    if (i11 <= i12) {
                        bVar4.f2290b = i12 + bVar5.f2292d;
                    }
                    int i13 = bVar5.f2290b;
                    int i14 = bVar4.f2292d;
                    if (i13 <= i14) {
                        bVar4.f2292d = i14 + bVar5.f2292d;
                    }
                    bVar5.f2290b += i10;
                    arrayList.set(size, bVar5);
                    arrayList.set(i8, bVar4);
                } else if (i9 == 2) {
                    int i15 = bVar4.f2290b;
                    int i16 = bVar4.f2292d;
                    int i17 = bVar5.f2290b;
                    if (i15 < i16) {
                        if (i17 == i15 && bVar5.f2292d == i16 - i15) {
                            z4 = true;
                            z3 = false;
                            i = bVar4.f2292d;
                            i2 = bVar5.f2290b;
                            if (i < i2) {
                                bVar5.f2290b = i2 - 1;
                            } else {
                                int i18 = bVar5.f2292d;
                                if (i < i2 + i18) {
                                    bVar5.f2292d = i18 - 1;
                                    bVar4.f2289a = 2;
                                    bVar4.f2292d = 1;
                                    if (bVar5.f2292d == 0) {
                                        arrayList.remove(i8);
                                        a aVar = (a) xVar.f2451a;
                                        if (!aVar.f2286e) {
                                            bVar5.f2291c = null;
                                            aVar.f2282a.b(bVar5);
                                        }
                                    }
                                }
                            }
                            i3 = bVar4.f2290b;
                            i4 = bVar5.f2290b;
                            if (i3 <= i4) {
                                bVar5.f2290b = i4 + 1;
                            } else {
                                int i19 = i4 + bVar5.f2292d;
                                if (i3 < i19) {
                                    bVar = ((a) xVar.f2451a).h(2, i3 + 1, i19 - i3, null);
                                    bVar5.f2292d = bVar4.f2290b - bVar5.f2290b;
                                    if (!z4) {
                                        arrayList.set(size, bVar5);
                                        arrayList.remove(i8);
                                        a aVar2 = (a) xVar.f2451a;
                                        if (!aVar2.f2286e) {
                                            bVar4.f2291c = null;
                                            aVar2.f2282a.b(bVar4);
                                        }
                                    } else {
                                        if (z3) {
                                            if (bVar != null) {
                                                int i20 = bVar4.f2290b;
                                                if (i20 > bVar.f2290b) {
                                                    bVar4.f2290b = i20 - bVar.f2292d;
                                                }
                                                int i21 = bVar4.f2292d;
                                                if (i21 > bVar.f2290b) {
                                                    bVar4.f2292d = i21 - bVar.f2292d;
                                                }
                                            }
                                            int i22 = bVar4.f2290b;
                                            if (i22 > bVar5.f2290b) {
                                                bVar4.f2290b = i22 - bVar5.f2292d;
                                            }
                                            i5 = bVar4.f2292d;
                                        } else {
                                            if (bVar != null) {
                                                int i23 = bVar4.f2290b;
                                                if (i23 >= bVar.f2290b) {
                                                    bVar4.f2290b = i23 - bVar.f2292d;
                                                }
                                                int i24 = bVar4.f2292d;
                                                if (i24 >= bVar.f2290b) {
                                                    bVar4.f2292d = i24 - bVar.f2292d;
                                                }
                                            }
                                            int i25 = bVar4.f2290b;
                                            if (i25 >= bVar5.f2290b) {
                                                bVar4.f2290b = i25 - bVar5.f2292d;
                                            }
                                            i5 = bVar4.f2292d;
                                        }
                                        bVar4.f2292d = i5 - bVar5.f2292d;
                                        arrayList.set(size, bVar5);
                                        if (bVar4.f2290b != bVar4.f2292d) {
                                            arrayList.set(i8, bVar4);
                                        } else {
                                            arrayList.remove(i8);
                                        }
                                        if (bVar != null) {
                                            arrayList.add(size, bVar);
                                        }
                                    }
                                }
                            }
                            bVar = null;
                            if (!z4) {
                            }
                        } else {
                            z4 = false;
                        }
                    } else if (i17 == i16 + 1 && bVar5.f2292d == i15 - i16) {
                        z4 = true;
                    } else {
                        z3 = true;
                        z4 = false;
                        i = bVar4.f2292d;
                        i2 = bVar5.f2290b;
                        if (i < i2) {
                        }
                        i3 = bVar4.f2290b;
                        i4 = bVar5.f2290b;
                        if (i3 <= i4) {
                        }
                        bVar = null;
                        if (!z4) {
                        }
                    }
                    z3 = z4;
                    i = bVar4.f2292d;
                    i2 = bVar5.f2290b;
                    if (i < i2) {
                    }
                    i3 = bVar4.f2290b;
                    i4 = bVar5.f2290b;
                    if (i3 <= i4) {
                    }
                    bVar = null;
                    if (!z4) {
                    }
                } else if (i9 == 4) {
                    int i26 = bVar4.f2292d;
                    int i27 = bVar5.f2290b;
                    if (i26 < i27) {
                        bVar5.f2290b = i27 - 1;
                    } else {
                        int i28 = bVar5.f2292d;
                        if (i26 < i27 + i28) {
                            bVar5.f2292d = i28 - 1;
                            bVar2 = ((a) xVar.f2451a).h(4, bVar4.f2290b, 1, bVar5.f2291c);
                            i6 = bVar4.f2290b;
                            i7 = bVar5.f2290b;
                            if (i6 > i7) {
                                bVar5.f2290b = i7 + 1;
                            } else {
                                int i29 = i7 + bVar5.f2292d;
                                if (i6 < i29) {
                                    int i30 = i29 - i6;
                                    bVar3 = ((a) xVar.f2451a).h(4, i6 + 1, i30, bVar5.f2291c);
                                    bVar5.f2292d -= i30;
                                    arrayList.set(i8, bVar4);
                                    if (bVar5.f2292d > 0) {
                                        arrayList.set(size, bVar5);
                                    } else {
                                        arrayList.remove(size);
                                        a aVar3 = (a) xVar.f2451a;
                                        if (!aVar3.f2286e) {
                                            bVar5.f2291c = null;
                                            aVar3.f2282a.b(bVar5);
                                        }
                                    }
                                    if (bVar2 != null) {
                                        arrayList.add(size, bVar2);
                                    }
                                    if (bVar3 != null) {
                                        arrayList.add(size, bVar3);
                                    }
                                }
                            }
                            bVar3 = null;
                            arrayList.set(i8, bVar4);
                            if (bVar5.f2292d > 0) {
                            }
                            if (bVar2 != null) {
                            }
                            if (bVar3 != null) {
                            }
                        }
                    }
                    bVar2 = null;
                    i6 = bVar4.f2290b;
                    i7 = bVar5.f2290b;
                    if (i6 > i7) {
                    }
                    bVar3 = null;
                    arrayList.set(i8, bVar4);
                    if (bVar5.f2292d > 0) {
                    }
                    if (bVar2 != null) {
                    }
                    if (bVar3 != null) {
                    }
                }
            }
            int size2 = this.f2283b.size();
            for (int i31 = 0; i31 < size2; i31++) {
                b bVar6 = this.f2283b.get(i31);
                int i32 = bVar6.f2289a;
                if (i32 == 1) {
                    i(bVar6);
                } else if (i32 == 2) {
                    int i33 = bVar6.f2290b;
                    int i34 = bVar6.f2292d + i33;
                    int i35 = i33;
                    boolean z6 = true;
                    int i36 = 0;
                    while (i35 < i34) {
                        if (((c0) this.f2285d).b(i35) != null || a(i35)) {
                            if (!z6) {
                                d(h(2, i33, i36, null));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z = true;
                        } else {
                            if (z6) {
                                i(h(2, i33, i36, null));
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            z = false;
                        }
                        if (z2) {
                            i35 -= i36;
                            i34 -= i36;
                            i36 = 1;
                        } else {
                            i36++;
                        }
                        i35++;
                        z6 = z;
                    }
                    if (i36 != bVar6.f2292d) {
                        if (!this.f2286e) {
                            bVar6.f2291c = null;
                            this.f2282a.b(bVar6);
                        }
                        bVar6 = h(2, i33, i36, null);
                    }
                    if (!z6) {
                        d(bVar6);
                    } else {
                        i(bVar6);
                    }
                } else if (i32 == 4) {
                    int i37 = bVar6.f2290b;
                    int i38 = bVar6.f2292d + i37;
                    boolean z7 = true;
                    int i39 = i37;
                    int i40 = 0;
                    while (i37 < i38) {
                        if (((c0) this.f2285d).b(i37) != null || a(i37)) {
                            if (!z7) {
                                d(h(4, i39, i40, bVar6.f2291c));
                                i39 = i37;
                                i40 = 0;
                            }
                            z7 = true;
                        } else {
                            if (z7) {
                                i(h(4, i39, i40, bVar6.f2291c));
                                i39 = i37;
                                i40 = 0;
                            }
                            z7 = false;
                        }
                        i40++;
                        i37++;
                    }
                    if (i40 != bVar6.f2292d) {
                        Object obj = bVar6.f2291c;
                        if (!this.f2286e) {
                            bVar6.f2291c = null;
                            this.f2282a.b(bVar6);
                        }
                        bVar6 = h(4, i39, i40, obj);
                    }
                    if (!z7) {
                        d(bVar6);
                    } else {
                        i(bVar6);
                    }
                } else if (i32 == 8) {
                    i(bVar6);
                }
            }
            this.f2283b.clear();
            return;
        }
        throw null;
    }

    public void k(b bVar) {
        if (!this.f2286e) {
            bVar.f2291c = null;
            this.f2282a.b(bVar);
        }
    }

    public void l(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k(list.get(i));
        }
        list.clear();
    }

    public final int m(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        for (int size = this.f2284c.size() - 1; size >= 0; size--) {
            b bVar = this.f2284c.get(size);
            int i7 = bVar.f2289a;
            if (i7 == 8) {
                int i8 = bVar.f2290b;
                int i9 = bVar.f2292d;
                if (i8 >= i9) {
                    i9 = i8;
                    i8 = i9;
                }
                if (i < i8 || i > i9) {
                    int i10 = bVar.f2290b;
                    if (i < i10) {
                        if (i2 == 1) {
                            bVar.f2290b = i10 + 1;
                            i4 = bVar.f2292d + 1;
                        } else if (i2 == 2) {
                            bVar.f2290b = i10 - 1;
                            i4 = bVar.f2292d - 1;
                        }
                        bVar.f2292d = i4;
                    }
                } else {
                    int i11 = bVar.f2290b;
                    if (i8 == i11) {
                        if (i2 == 1) {
                            i6 = bVar.f2292d + 1;
                        } else {
                            if (i2 == 2) {
                                i6 = bVar.f2292d - 1;
                            }
                            i++;
                        }
                        bVar.f2292d = i6;
                        i++;
                    } else {
                        if (i2 == 1) {
                            i5 = i11 + 1;
                        } else {
                            if (i2 == 2) {
                                i5 = i11 - 1;
                            }
                            i--;
                        }
                        bVar.f2290b = i5;
                        i--;
                    }
                }
            } else {
                int i12 = bVar.f2290b;
                if (i12 > i) {
                    if (i2 == 1) {
                        i3 = i12 + 1;
                    } else if (i2 == 2) {
                        i3 = i12 - 1;
                    }
                    bVar.f2290b = i3;
                } else if (i7 == 1) {
                    i -= bVar.f2292d;
                } else if (i7 == 2) {
                    i += bVar.f2292d;
                }
            }
        }
        for (int size2 = this.f2284c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2284c.get(size2);
            if (bVar2.f2289a == 8) {
                int i13 = bVar2.f2292d;
                if (i13 == bVar2.f2290b || i13 < 0) {
                    this.f2284c.remove(size2);
                    if (this.f2286e) {
                    }
                }
            } else {
                if (bVar2.f2292d <= 0) {
                    this.f2284c.remove(size2);
                    if (this.f2286e) {
                    }
                }
            }
            bVar2.f2291c = null;
            this.f2282a.b(bVar2);
        }
        return i;
    }
}
