package e.c.a.x;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.c.a.d;
import e.c.a.e;
import e.c.a.f;
import e.c.a.h;
import e.c.a.q;
import e.c.a.t.m;
import e.c.a.x.e;
import e.c.a.x.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b extends f implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final long[] f5196b;

    /* renamed from: c  reason: collision with root package name */
    public final q[] f5197c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f5198d;

    /* renamed from: e  reason: collision with root package name */
    public final f[] f5199e;
    public final q[] f;
    public final e[] g;
    public final ConcurrentMap<Integer, d[]> h = new ConcurrentHashMap();

    public b(long[] jArr, q[] qVarArr, long[] jArr2, q[] qVarArr2, e[] eVarArr) {
        f fVar;
        this.f5196b = jArr;
        this.f5197c = qVarArr;
        this.f5198d = jArr2;
        this.f = qVarArr2;
        this.g = eVarArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jArr2.length) {
            int i2 = i + 1;
            d dVar = new d(jArr2[i], qVarArr2[i], qVarArr2[i2]);
            if (dVar.d()) {
                arrayList.add(dVar.f5206b);
                fVar = dVar.b();
            } else {
                arrayList.add(dVar.b());
                fVar = dVar.f5206b;
            }
            arrayList.add(fVar);
            i = i2;
        }
        this.f5199e = (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    private Object writeReplace() {
        return new a((byte) 1, this);
    }

    @Override // e.c.a.x.f
    public q a(d dVar) {
        long j = dVar.f4967b;
        if (this.g.length > 0) {
            long[] jArr = this.f5198d;
            if (j > jArr[jArr.length - 1]) {
                q[] qVarArr = this.f;
                d[] g2 = g(e.R(c.R0(((long) qVarArr[qVarArr.length - 1].f5002b) + j, 86400)).f4970b);
                d dVar2 = null;
                for (int i = 0; i < g2.length; i++) {
                    dVar2 = g2[i];
                    if (j < dVar2.f5206b.x(dVar2.f5207c)) {
                        return dVar2.f5207c;
                    }
                }
                return dVar2.f5208d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f5198d, j);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f[binarySearch + 1];
    }

    @Override // e.c.a.x.f
    public d b(f fVar) {
        Object h2 = h(fVar);
        if (h2 instanceof d) {
            return (d) h2;
        }
        return null;
    }

    @Override // e.c.a.x.f
    public List<q> c(f fVar) {
        Object h2 = h(fVar);
        if (!(h2 instanceof d)) {
            return Collections.singletonList((q) h2);
        }
        d dVar = (d) h2;
        if (dVar.d()) {
            return Collections.emptyList();
        }
        return Arrays.asList(dVar.f5207c, dVar.f5208d);
    }

    @Override // e.c.a.x.f
    public boolean d(d dVar) {
        int binarySearch = Arrays.binarySearch(this.f5196b, dVar.f4967b);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return !this.f5197c[binarySearch + 1].equals(a(dVar));
    }

    @Override // e.c.a.x.f
    public boolean e() {
        return this.f5198d.length == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return Arrays.equals(this.f5196b, bVar.f5196b) && Arrays.equals(this.f5197c, bVar.f5197c) && Arrays.equals(this.f5198d, bVar.f5198d) && Arrays.equals(this.f, bVar.f) && Arrays.equals(this.g, bVar.g);
        } else if (!(obj instanceof f.a)) {
            return false;
        } else {
            if (e()) {
                q a2 = a(d.f4966d);
                d dVar = d.f4966d;
                if (a2.equals(((f.a) obj).f5217b)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // e.c.a.x.f
    public boolean f(e.c.a.f fVar, q qVar) {
        return c(fVar).contains(qVar);
    }

    public final d[] g(int i) {
        e eVar;
        int i2;
        Integer valueOf = Integer.valueOf(i);
        d[] dVarArr = this.h.get(valueOf);
        if (dVarArr != null) {
            return dVarArr;
        }
        e[] eVarArr = this.g;
        d[] dVarArr2 = new d[eVarArr.length];
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            e eVar2 = eVarArr[i3];
            byte b2 = eVar2.f5210c;
            if (b2 < 0) {
                h hVar = eVar2.f5209b;
                eVar = e.Q(i, hVar, hVar.u(m.f5027d.x((long) i)) + 1 + eVar2.f5210c);
                e.c.a.b bVar = eVar2.f5211d;
                if (bVar != null) {
                    eVar = eVar.g(new e.c.a.w.h(1, bVar, null));
                }
            } else {
                eVar = e.Q(i, eVar2.f5209b, b2);
                e.c.a.b bVar2 = eVar2.f5211d;
                if (bVar2 != null) {
                    eVar = eVar.g(c.F1(bVar2));
                }
            }
            e.c.a.f I = e.c.a.f.I(eVar.V((long) eVar2.f), eVar2.f5212e);
            e.a aVar = eVar2.g;
            q qVar = eVar2.h;
            q qVar2 = eVar2.i;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i2 = qVar2.f5002b;
                qVar = q.f;
            } else if (ordinal != 2) {
                dVarArr2[i3] = new d(I, eVar2.i, eVar2.j);
            } else {
                i2 = qVar2.f5002b;
            }
            I = I.N((long) (i2 - qVar.f5002b));
            dVarArr2[i3] = new d(I, eVar2.i, eVar2.j);
        }
        if (i < 2100) {
            this.h.putIfAbsent(valueOf, dVarArr2);
        }
        return dVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r9.F(r3.b()) != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        if (r9.F(r3.b()) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        r4 = r3;
     */
    public final Object h(e.c.a.f fVar) {
        Object obj;
        int i;
        int i2 = 0;
        if (this.g.length > 0) {
            e.c.a.f[] fVarArr = this.f5199e;
            e.c.a.f fVar2 = fVarArr[fVarArr.length - 1];
            Object obj2 = null;
            if (fVar != null) {
                if (!(fVar2 instanceof e.c.a.f) ? fVar.f4975b.z() > fVar2.f4975b.z() || (i == 0 && fVar.f4976c.I() > fVar2.f4976c.I()) : fVar.D(fVar2) > 0) {
                    d[] g2 = g(fVar.f4975b.f4970b);
                    int length = g2.length;
                    while (i2 < length) {
                        d dVar = g2[i2];
                        e.c.a.f fVar3 = dVar.f5206b;
                        boolean d2 = dVar.d();
                        boolean F = fVar.F(fVar3);
                        if (d2) {
                            if (!F) {
                            }
                            obj = dVar.f5207c;
                            if (!(obj instanceof d) || obj.equals(dVar.f5207c)) {
                                return obj;
                            }
                            i2++;
                            obj2 = obj;
                        } else if (F) {
                        }
                        obj = dVar.f5208d;
                        if (!(obj instanceof d)) {
                        }
                        return obj;
                    }
                    return obj2;
                }
            } else {
                throw null;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f5199e, fVar);
        if (binarySearch == -1) {
            return this.f[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            e.c.a.f[] fVarArr2 = this.f5199e;
            if (binarySearch < fVarArr2.length - 1) {
                int i3 = binarySearch + 1;
                if (fVarArr2[binarySearch].equals(fVarArr2[i3])) {
                    binarySearch = i3;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.f[(binarySearch / 2) + 1];
        }
        e.c.a.f[] fVarArr3 = this.f5199e;
        e.c.a.f fVar4 = fVarArr3[binarySearch];
        e.c.a.f fVar5 = fVarArr3[binarySearch + 1];
        q[] qVarArr = this.f;
        int i4 = binarySearch / 2;
        q qVar = qVarArr[i4];
        q qVar2 = qVarArr[i4 + 1];
        return qVar2.f5002b > qVar.f5002b ? new d(fVar4, qVar, qVar2) : new d(fVar5, qVar, qVar2);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.f5196b) ^ Arrays.hashCode(this.f5197c)) ^ Arrays.hashCode(this.f5198d)) ^ Arrays.hashCode(this.f)) ^ Arrays.hashCode(this.g);
    }

    public String toString() {
        StringBuilder g2 = a.g("StandardZoneRules[currentStandardOffset=");
        q[] qVarArr = this.f5197c;
        g2.append(qVarArr[qVarArr.length - 1]);
        g2.append("]");
        return g2.toString();
    }
}
