package e.s.a;

import androidx.recyclerview.widget.RecyclerView;
import e.s.a.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class a implements n.a {
    public e.i.h.b<b> a = new e.i.h.b<>(30);
    public final ArrayList<b> b = new ArrayList<>();
    public final ArrayList<b> c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public final AbstractC0049a f1772d;

    /* renamed from: e  reason: collision with root package name */
    public final n f1773e;

    /* renamed from: f  reason: collision with root package name */
    public int f1774f = 0;

    /* renamed from: e.s.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0049a {
    }

    public static class b {
        public int a;
        public int b;
        public Object c;

        /* renamed from: d  reason: collision with root package name */
        public int f1775d;

        public b(int i2, int i3, int i4, Object obj) {
            this.a = i2;
            this.b = i3;
            this.f1775d = i4;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.a;
            if (i2 != bVar.a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f1775d - this.b) == 1 && this.f1775d == bVar.b && this.b == bVar.f1775d) {
                return true;
            }
            if (this.f1775d != bVar.f1775d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            Object obj3 = bVar.c;
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
            return (((this.a * 31) + this.b) * 31) + this.f1775d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i2 = this.a;
            sb.append(i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.f1775d);
            sb.append(",p:");
            sb.append(this.c);
            sb.append("]");
            return sb.toString();
        }
    }

    public a(AbstractC0049a aVar) {
        this.f1772d = aVar;
        this.f1773e = new n(this);
    }

    public final boolean a(int i2) {
        int size = this.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                if (f(bVar.f1775d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.b;
                int i6 = bVar.f1775d + i5;
                while (i5 < i6) {
                    if (f(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((t) this.f1772d).a(this.c.get(i2));
        }
        l(this.c);
        this.f1774f = 0;
    }

    public void c() {
        b();
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                ((t) this.f1772d).a(bVar);
                ((t) this.f1772d).d(bVar.b, bVar.f1775d);
            } else if (i3 == 2) {
                ((t) this.f1772d).a(bVar);
                AbstractC0049a aVar = this.f1772d;
                int i4 = bVar.b;
                int i5 = bVar.f1775d;
                t tVar = (t) aVar;
                tVar.a.R(i4, i5, true);
                RecyclerView recyclerView = tVar.a;
                recyclerView.l0 = true;
                recyclerView.i0.c += i5;
            } else if (i3 == 4) {
                ((t) this.f1772d).a(bVar);
                ((t) this.f1772d).c(bVar.b, bVar.f1775d, bVar.c);
            } else if (i3 == 8) {
                ((t) this.f1772d).a(bVar);
                ((t) this.f1772d).e(bVar.b, bVar.f1775d);
            }
        }
        l(this.b);
        this.f1774f = 0;
    }

    public final void d(b bVar) {
        int i2;
        int i3 = bVar.a;
        if (i3 == 1 || i3 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.b, i3);
        int i4 = bVar.b;
        int i5 = bVar.a;
        if (i5 == 2) {
            i2 = 0;
        } else if (i5 == 4) {
            i2 = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f1775d; i7++) {
            int m2 = m((i2 * i7) + bVar.b, bVar.a);
            int i8 = bVar.a;
            if (i8 == 2 ? m2 == m : i8 == 4 && m2 == m + 1) {
                i6++;
            } else {
                b h2 = h(i8, m, i6, bVar.c);
                e(h2, i4);
                k(h2);
                if (bVar.a == 4) {
                    i4 += i6;
                }
                m = m2;
                i6 = 1;
            }
        }
        Object obj = bVar.c;
        k(bVar);
        if (i6 > 0) {
            b h3 = h(bVar.a, m, i6, obj);
            e(h3, i4);
            k(h3);
        }
    }

    public void e(b bVar, int i2) {
        ((t) this.f1772d).a(bVar);
        int i3 = bVar.a;
        if (i3 == 2) {
            AbstractC0049a aVar = this.f1772d;
            int i4 = bVar.f1775d;
            t tVar = (t) aVar;
            tVar.a.R(i2, i4, true);
            RecyclerView recyclerView = tVar.a;
            recyclerView.l0 = true;
            recyclerView.i0.c += i4;
        } else if (i3 == 4) {
            ((t) this.f1772d).c(i2, bVar.f1775d, bVar.c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int f(int i2, int i3) {
        int size = this.c.size();
        while (i3 < size) {
            b bVar = this.c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                int i5 = bVar.b;
                if (i5 == i2) {
                    i2 = bVar.f1775d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f1775d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f1775d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f1775d;
                }
            }
            i3++;
        }
        return i2;
    }

    public boolean g() {
        return this.b.size() > 0;
    }

    public b h(int i2, int i3, int i4, Object obj) {
        b a2 = this.a.a();
        if (a2 == null) {
            return new b(i2, i3, i4, obj);
        }
        a2.a = i2;
        a2.b = i3;
        a2.f1775d = i4;
        a2.c = obj;
        return a2;
    }

    public final void i(b bVar) {
        this.c.add(bVar);
        int i2 = bVar.a;
        if (i2 == 1) {
            ((t) this.f1772d).d(bVar.b, bVar.f1775d);
        } else if (i2 == 2) {
            AbstractC0049a aVar = this.f1772d;
            t tVar = (t) aVar;
            tVar.a.R(bVar.b, bVar.f1775d, false);
            tVar.a.l0 = true;
        } else if (i2 == 4) {
            ((t) this.f1772d).c(bVar.b, bVar.f1775d, bVar.c);
        } else if (i2 == 8) {
            ((t) this.f1772d).e(bVar.b, bVar.f1775d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x014c, code lost:
        if (r4 > r12.b) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0176, code lost:
        if (r4 >= r12.b) goto L_0x0178;
     */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0123  */
    public void j() {
        char c2;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        boolean z4;
        b bVar;
        int i5;
        int i6;
        n nVar = this.f1773e;
        ArrayList<b> arrayList = this.b;
        Objects.requireNonNull(nVar);
        while (true) {
            int size = arrayList.size() - 1;
            boolean z5 = false;
            while (true) {
                if (size < 0) {
                    size = -1;
                    break;
                }
                if (arrayList.get(size).a != 8) {
                    z5 = true;
                } else if (z5) {
                    break;
                }
                size--;
            }
            b bVar2 = null;
            if (size == -1) {
                break;
            }
            int i7 = size + 1;
            b bVar3 = arrayList.get(size);
            b bVar4 = arrayList.get(i7);
            int i8 = bVar4.a;
            if (i8 == 1) {
                int i9 = bVar3.f1775d;
                int i10 = bVar4.b;
                int i11 = i9 < i10 ? -1 : 0;
                int i12 = bVar3.b;
                if (i12 < i10) {
                    i11++;
                }
                if (i10 <= i12) {
                    bVar3.b = i12 + bVar4.f1775d;
                }
                int i13 = bVar4.b;
                if (i13 <= i9) {
                    bVar3.f1775d = i9 + bVar4.f1775d;
                }
                bVar4.b = i13 + i11;
                arrayList.set(size, bVar4);
                arrayList.set(i7, bVar3);
            } else if (i8 == 2) {
                int i14 = bVar3.b;
                int i15 = bVar3.f1775d;
                int i16 = bVar4.b;
                if (i14 < i15) {
                    if (i16 == i14 && bVar4.f1775d == i15 - i14) {
                        z4 = false;
                    } else {
                        z3 = false;
                        z2 = false;
                        if (i15 < i16) {
                            bVar4.b = i16 - 1;
                        } else {
                            int i17 = bVar4.f1775d;
                            if (i15 < i16 + i17) {
                                bVar4.f1775d = i17 - 1;
                                bVar3.a = 2;
                                bVar3.f1775d = 1;
                                if (bVar4.f1775d == 0) {
                                    arrayList.remove(i7);
                                    ((a) nVar.a).k(bVar4);
                                }
                            }
                        }
                        i2 = bVar3.b;
                        i3 = bVar4.b;
                        if (i2 <= i3) {
                            bVar4.b = i3 + 1;
                        } else {
                            int i18 = i3 + bVar4.f1775d;
                            if (i2 < i18) {
                                bVar2 = ((a) nVar.a).h(2, i2 + 1, i18 - i2, null);
                                bVar4.f1775d = bVar3.b - bVar4.b;
                            }
                        }
                        if (z3) {
                            arrayList.set(size, bVar4);
                            arrayList.remove(i7);
                            ((a) nVar.a).k(bVar3);
                        } else {
                            if (z2) {
                                if (bVar2 != null) {
                                    int i19 = bVar3.b;
                                    if (i19 > bVar2.b) {
                                        bVar3.b = i19 - bVar2.f1775d;
                                    }
                                    int i20 = bVar3.f1775d;
                                    if (i20 > bVar2.b) {
                                        bVar3.f1775d = i20 - bVar2.f1775d;
                                    }
                                }
                                int i21 = bVar3.b;
                                if (i21 > bVar4.b) {
                                    bVar3.b = i21 - bVar4.f1775d;
                                }
                                i4 = bVar3.f1775d;
                            } else {
                                if (bVar2 != null) {
                                    int i22 = bVar3.b;
                                    if (i22 >= bVar2.b) {
                                        bVar3.b = i22 - bVar2.f1775d;
                                    }
                                    int i23 = bVar3.f1775d;
                                    if (i23 >= bVar2.b) {
                                        bVar3.f1775d = i23 - bVar2.f1775d;
                                    }
                                }
                                int i24 = bVar3.b;
                                if (i24 >= bVar4.b) {
                                    bVar3.b = i24 - bVar4.f1775d;
                                }
                                i4 = bVar3.f1775d;
                            }
                            bVar3.f1775d = i4 - bVar4.f1775d;
                            arrayList.set(size, bVar4);
                            if (bVar3.b != bVar3.f1775d) {
                                arrayList.set(i7, bVar3);
                            } else {
                                arrayList.remove(i7);
                            }
                            if (bVar2 != null) {
                                arrayList.add(size, bVar2);
                            }
                        }
                    }
                } else if (i16 == i15 + 1 && bVar4.f1775d == i14 - i15) {
                    z4 = true;
                } else {
                    z3 = false;
                    z2 = true;
                    if (i15 < i16) {
                    }
                    i2 = bVar3.b;
                    i3 = bVar4.b;
                    if (i2 <= i3) {
                    }
                    if (z3) {
                    }
                }
                z2 = z4;
                z3 = true;
                if (i15 < i16) {
                }
                i2 = bVar3.b;
                i3 = bVar4.b;
                if (i2 <= i3) {
                }
                if (z3) {
                }
            } else if (i8 == 4) {
                int i25 = bVar3.f1775d;
                int i26 = bVar4.b;
                if (i25 < i26) {
                    bVar4.b = i26 - 1;
                } else {
                    int i27 = bVar4.f1775d;
                    if (i25 < i26 + i27) {
                        bVar4.f1775d = i27 - 1;
                        bVar = ((a) nVar.a).h(4, bVar3.b, 1, bVar4.c);
                        i5 = bVar3.b;
                        i6 = bVar4.b;
                        if (i5 > i6) {
                            bVar4.b = i6 + 1;
                        } else {
                            int i28 = i6 + bVar4.f1775d;
                            if (i5 < i28) {
                                int i29 = i28 - i5;
                                bVar2 = ((a) nVar.a).h(4, i5 + 1, i29, bVar4.c);
                                bVar4.f1775d -= i29;
                            }
                        }
                        arrayList.set(i7, bVar3);
                        if (bVar4.f1775d <= 0) {
                            arrayList.set(size, bVar4);
                        } else {
                            arrayList.remove(size);
                            ((a) nVar.a).k(bVar4);
                        }
                        if (bVar != null) {
                            arrayList.add(size, bVar);
                        }
                        if (bVar2 == null) {
                            arrayList.add(size, bVar2);
                        }
                    }
                }
                bVar = null;
                i5 = bVar3.b;
                i6 = bVar4.b;
                if (i5 > i6) {
                }
                arrayList.set(i7, bVar3);
                if (bVar4.f1775d <= 0) {
                }
                if (bVar != null) {
                }
                if (bVar2 == null) {
                }
            }
        }
        int size2 = this.b.size();
        for (int i30 = 0; i30 < size2; i30++) {
            b bVar5 = this.b.get(i30);
            int i31 = bVar5.a;
            if (i31 == 1) {
                i(bVar5);
            } else if (i31 == 2) {
                int i32 = bVar5.b;
                int i33 = bVar5.f1775d + i32;
                int i34 = i32;
                int i35 = 0;
                char c3 = 65535;
                while (i34 < i33) {
                    if (((t) this.f1772d).b(i34) != null || a(i34)) {
                        if (c3 == 0) {
                            d(h(2, i32, i35, null));
                            z = true;
                        } else {
                            z = false;
                        }
                        c2 = 1;
                    } else {
                        if (c3 == 1) {
                            i(h(2, i32, i35, null));
                            z = true;
                        } else {
                            z = false;
                        }
                        c2 = 0;
                    }
                    if (z) {
                        i34 -= i35;
                        i33 -= i35;
                        i35 = 1;
                    } else {
                        i35++;
                    }
                    i34++;
                    c3 = c2;
                }
                if (i35 != bVar5.f1775d) {
                    k(bVar5);
                    bVar5 = h(2, i32, i35, null);
                }
                if (c3 == 0) {
                    d(bVar5);
                } else {
                    i(bVar5);
                }
            } else if (i31 == 4) {
                int i36 = bVar5.b;
                int i37 = bVar5.f1775d + i36;
                int i38 = i36;
                int i39 = 0;
                char c4 = 65535;
                while (i36 < i37) {
                    if (((t) this.f1772d).b(i36) != null || a(i36)) {
                        if (c4 == 0) {
                            d(h(4, i38, i39, bVar5.c));
                            i38 = i36;
                            i39 = 0;
                        }
                        c4 = 1;
                    } else {
                        if (c4 == 1) {
                            i(h(4, i38, i39, bVar5.c));
                            i38 = i36;
                            i39 = 0;
                        }
                        c4 = 0;
                    }
                    i39++;
                    i36++;
                }
                if (i39 != bVar5.f1775d) {
                    Object obj = bVar5.c;
                    k(bVar5);
                    bVar5 = h(4, i38, i39, obj);
                }
                if (c4 == 0) {
                    d(bVar5);
                } else {
                    i(bVar5);
                }
            } else if (i31 == 8) {
                i(bVar5);
            }
        }
        this.b.clear();
    }

    public void k(b bVar) {
        bVar.c = null;
        this.a.b(bVar);
    }

    public void l(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            k(list.get(i2));
        }
        list.clear();
    }

    public final int m(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = this.c.get(size);
            int i10 = bVar.a;
            if (i10 == 8) {
                int i11 = bVar.b;
                int i12 = bVar.f1775d;
                if (i11 < i12) {
                    i6 = i11;
                    i5 = i12;
                } else {
                    i5 = i11;
                    i6 = i12;
                }
                if (i2 < i6 || i2 > i5) {
                    if (i2 < i11) {
                        if (i3 == 1) {
                            bVar.b = i11 + 1;
                            i7 = i12 + 1;
                        } else if (i3 == 2) {
                            bVar.b = i11 - 1;
                            i7 = i12 - 1;
                        }
                        bVar.f1775d = i7;
                    }
                } else if (i6 == i11) {
                    if (i3 == 1) {
                        i9 = i12 + 1;
                    } else {
                        if (i3 == 2) {
                            i9 = i12 - 1;
                        }
                        i2++;
                    }
                    bVar.f1775d = i9;
                    i2++;
                } else {
                    if (i3 == 1) {
                        i8 = i11 + 1;
                    } else {
                        if (i3 == 2) {
                            i8 = i11 - 1;
                        }
                        i2--;
                    }
                    bVar.b = i8;
                    i2--;
                }
            } else {
                int i13 = bVar.b;
                if (i13 > i2) {
                    if (i3 == 1) {
                        i4 = i13 + 1;
                    } else if (i3 == 2) {
                        i4 = i13 - 1;
                    }
                    bVar.b = i4;
                } else if (i10 == 1) {
                    i2 -= bVar.f1775d;
                } else if (i10 == 2) {
                    i2 += bVar.f1775d;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.c.get(size2);
            if (bVar2.a == 8) {
                int i14 = bVar2.f1775d;
                if (i14 != bVar2.b && i14 >= 0) {
                }
            } else if (bVar2.f1775d > 0) {
            }
            this.c.remove(size2);
            k(bVar2);
        }
        return i2;
    }
}
