package l.b.a.y;

import f.a.a.a.a;
import g.b.a.c.c.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.e;
import l.b.a.f;
import l.b.a.g;
import l.b.a.i;
import l.b.a.r;
import l.b.a.u.m;
import l.b.a.x.h;
import l.b.a.y.e;
import l.b.a.y.f;

public final class b extends f implements Serializable {
    public final long[] b;
    public final r[] c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f4476d;

    /* renamed from: e  reason: collision with root package name */
    public final g[] f4477e;

    /* renamed from: f  reason: collision with root package name */
    public final r[] f4478f;

    /* renamed from: g  reason: collision with root package name */
    public final e[] f4479g;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentMap<Integer, d[]> f4480h = new ConcurrentHashMap();

    public b(long[] jArr, r[] rVarArr, long[] jArr2, r[] rVarArr2, e[] eVarArr) {
        g gVar;
        this.b = jArr;
        this.c = rVarArr;
        this.f4476d = jArr2;
        this.f4478f = rVarArr2;
        this.f4479g = eVarArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jArr2.length) {
            int i3 = i2 + 1;
            d dVar = new d(jArr2[i2], rVarArr2[i2], rVarArr2[i3]);
            if (dVar.b()) {
                arrayList.add(dVar.b);
                gVar = dVar.a();
            } else {
                arrayList.add(dVar.a());
                gVar = dVar.b;
            }
            arrayList.add(gVar);
            i2 = i3;
        }
        this.f4477e = (g[]) arrayList.toArray(new g[arrayList.size()]);
    }

    private Object writeReplace() {
        return new a((byte) 1, this);
    }

    @Override // l.b.a.y.f
    public r a(e eVar) {
        long j2 = eVar.b;
        if (this.f4479g.length > 0) {
            long[] jArr = this.f4476d;
            if (j2 > jArr[jArr.length - 1]) {
                r[] rVarArr = this.f4478f;
                d[] g2 = g(f.R(c.i(((long) rVarArr[rVarArr.length - 1].c) + j2, 86400)).b);
                d dVar = null;
                for (int i2 = 0; i2 < g2.length; i2++) {
                    dVar = g2[i2];
                    if (j2 < dVar.b.v(dVar.c)) {
                        return dVar.c;
                    }
                }
                return dVar.f4483d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f4476d, j2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f4478f[binarySearch + 1];
    }

    @Override // l.b.a.y.f
    public d b(g gVar) {
        Object h2 = h(gVar);
        if (h2 instanceof d) {
            return (d) h2;
        }
        return null;
    }

    @Override // l.b.a.y.f
    public List<r> c(g gVar) {
        Object h2 = h(gVar);
        if (!(h2 instanceof d)) {
            return Collections.singletonList((r) h2);
        }
        d dVar = (d) h2;
        if (dVar.b()) {
            return Collections.emptyList();
        }
        return Arrays.asList(dVar.c, dVar.f4483d);
    }

    @Override // l.b.a.y.f
    public boolean d(e eVar) {
        int binarySearch = Arrays.binarySearch(this.b, eVar.b);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return !this.c[binarySearch + 1].equals(a(eVar));
    }

    @Override // l.b.a.y.f
    public boolean e() {
        return this.f4476d.length == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return Arrays.equals(this.b, bVar.b) && Arrays.equals(this.c, bVar.c) && Arrays.equals(this.f4476d, bVar.f4476d) && Arrays.equals(this.f4478f, bVar.f4478f) && Arrays.equals(this.f4479g, bVar.f4479g);
        } else if (!(obj instanceof f.a) || !e() || !a(e.f4291d).equals(((f.a) obj).b)) {
            return false;
        } else {
            return true;
        }
    }

    @Override // l.b.a.y.f
    public boolean f(g gVar, r rVar) {
        return c(gVar).contains(rVar);
    }

    public final d[] g(int i2) {
        l.b.a.f fVar;
        int i3;
        Integer valueOf = Integer.valueOf(i2);
        d[] dVarArr = this.f4480h.get(valueOf);
        if (dVarArr != null) {
            return dVarArr;
        }
        e[] eVarArr = this.f4479g;
        d[] dVarArr2 = new d[eVarArr.length];
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            e eVar = eVarArr[i4];
            byte b2 = eVar.c;
            if (b2 < 0) {
                i iVar = eVar.b;
                fVar = l.b.a.f.Q(i2, iVar, iVar.s(m.f4343d.u((long) i2)) + 1 + eVar.c);
                l.b.a.c cVar = eVar.f4484d;
                if (cVar != null) {
                    fVar = fVar.y(new h(1, cVar, null));
                }
            } else {
                fVar = l.b.a.f.Q(i2, eVar.b, b2);
                l.b.a.c cVar2 = eVar.f4484d;
                if (cVar2 != null) {
                    fVar = fVar.y(c.s(cVar2));
                }
            }
            g F = g.F(fVar.V((long) eVar.f4486f), eVar.f4485e);
            e.a aVar = eVar.f4487g;
            r rVar = eVar.f4488h;
            r rVar2 = eVar.f4489i;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i3 = rVar2.c;
                rVar = r.f4321g;
            } else if (ordinal != 2) {
                dVarArr2[i4] = new d(F, eVar.f4489i, eVar.f4490j);
            } else {
                i3 = rVar2.c;
            }
            F = F.K((long) (i3 - rVar.c));
            dVarArr2[i4] = new d(F, eVar.f4489i, eVar.f4490j);
        }
        if (i2 < 2100) {
            this.f4480h.putIfAbsent(valueOf, dVarArr2);
        }
        return dVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0068, code lost:
        if (r9.D(r2.a()) != false) goto L_0x007d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        if (r9.D(r2.a()) != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
        r4 = r2;
     */
    public final Object h(g gVar) {
        Object obj;
        int i2;
        int i3 = 0;
        if (this.f4479g.length > 0) {
            g[] gVarArr = this.f4477e;
            g gVar2 = gVarArr[gVarArr.length - 1];
            Objects.requireNonNull(gVar);
            if (!(gVar2 instanceof g) ? gVar.b.x() > gVar2.b.x() || (i2 == 0 && gVar.c.E() > gVar2.c.E()) : gVar.B(gVar2) > 0) {
                d[] g2 = g(gVar.b.b);
                Object obj2 = null;
                int length = g2.length;
                while (i3 < length) {
                    d dVar = g2[i3];
                    g gVar3 = dVar.b;
                    boolean b2 = dVar.b();
                    boolean D = gVar.D(gVar3);
                    if (b2) {
                        if (!D) {
                        }
                        obj = dVar.c;
                        if (!(obj instanceof d) || obj.equals(dVar.c)) {
                            return obj;
                        }
                        i3++;
                        obj2 = obj;
                    } else if (D) {
                    }
                    obj = dVar.f4483d;
                    if (!(obj instanceof d)) {
                    }
                    return obj;
                }
                return obj2;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f4477e, gVar);
        if (binarySearch == -1) {
            return this.f4478f[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            g[] gVarArr2 = this.f4477e;
            if (binarySearch < gVarArr2.length - 1) {
                int i4 = binarySearch + 1;
                if (gVarArr2[binarySearch].equals(gVarArr2[i4])) {
                    binarySearch = i4;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.f4478f[(binarySearch / 2) + 1];
        }
        g[] gVarArr3 = this.f4477e;
        g gVar4 = gVarArr3[binarySearch];
        g gVar5 = gVarArr3[binarySearch + 1];
        r[] rVarArr = this.f4478f;
        int i5 = binarySearch / 2;
        r rVar = rVarArr[i5];
        r rVar2 = rVarArr[i5 + 1];
        return rVar2.c > rVar.c ? new d(gVar4, rVar, rVar2) : new d(gVar5, rVar, rVar2);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.b) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.f4476d)) ^ Arrays.hashCode(this.f4478f)) ^ Arrays.hashCode(this.f4479g);
    }

    public String toString() {
        StringBuilder i2 = a.i("StandardZoneRules[currentStandardOffset=");
        r[] rVarArr = this.c;
        i2.append(rVarArr[rVarArr.length - 1]);
        i2.append("]");
        return i2.toString();
    }
}
