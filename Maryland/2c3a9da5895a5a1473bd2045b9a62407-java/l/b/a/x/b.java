package l.b.a.x;

import f.a.a.a.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import l.b.a.d;
import l.b.a.e;
import l.b.a.f;
import l.b.a.h;
import l.b.a.q;
import l.b.a.t.m;
import l.b.a.x.e;
import l.b.a.x.f;

public final class b extends f implements Serializable {
    public final long[] b;
    public final q[] c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f4321d;

    /* renamed from: e  reason: collision with root package name */
    public final f[] f4322e;

    /* renamed from: f  reason: collision with root package name */
    public final q[] f4323f;

    /* renamed from: g  reason: collision with root package name */
    public final e[] f4324g;

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentMap<Integer, d[]> f4325h = new ConcurrentHashMap();

    public b(long[] jArr, q[] qVarArr, long[] jArr2, q[] qVarArr2, e[] eVarArr) {
        f fVar;
        this.b = jArr;
        this.c = qVarArr;
        this.f4321d = jArr2;
        this.f4323f = qVarArr2;
        this.f4324g = eVarArr;
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < jArr2.length) {
            int i3 = i2 + 1;
            d dVar = new d(jArr2[i2], qVarArr2[i2], qVarArr2[i3]);
            if (dVar.b()) {
                arrayList.add(dVar.b);
                fVar = dVar.a();
            } else {
                arrayList.add(dVar.a());
                fVar = dVar.b;
            }
            arrayList.add(fVar);
            i2 = i3;
        }
        this.f4322e = (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    private Object writeReplace() {
        return new a((byte) 1, this);
    }

    @Override // l.b.a.x.f
    public q a(d dVar) {
        long j2 = dVar.b;
        if (this.f4324g.length > 0) {
            long[] jArr = this.f4321d;
            if (j2 > jArr[jArr.length - 1]) {
                q[] qVarArr = this.f4323f;
                d[] g2 = g(e.R(f.b.a.c.b.o.b.B0(((long) qVarArr[qVarArr.length - 1].c) + j2, 86400)).b);
                d dVar2 = null;
                for (int i2 = 0; i2 < g2.length; i2++) {
                    dVar2 = g2[i2];
                    if (j2 < dVar2.b.v(dVar2.c)) {
                        return dVar2.c;
                    }
                }
                return dVar2.f4328d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f4321d, j2);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f4323f[binarySearch + 1];
    }

    @Override // l.b.a.x.f
    public d b(f fVar) {
        Object h2 = h(fVar);
        if (h2 instanceof d) {
            return (d) h2;
        }
        return null;
    }

    @Override // l.b.a.x.f
    public List<q> c(f fVar) {
        Object h2 = h(fVar);
        if (!(h2 instanceof d)) {
            return Collections.singletonList((q) h2);
        }
        d dVar = (d) h2;
        if (dVar.b()) {
            return Collections.emptyList();
        }
        return Arrays.asList(dVar.c, dVar.f4328d);
    }

    @Override // l.b.a.x.f
    public boolean d(d dVar) {
        int binarySearch = Arrays.binarySearch(this.b, dVar.b);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return !this.c[binarySearch + 1].equals(a(dVar));
    }

    @Override // l.b.a.x.f
    public boolean e() {
        return this.f4321d.length == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return Arrays.equals(this.b, bVar.b) && Arrays.equals(this.c, bVar.c) && Arrays.equals(this.f4321d, bVar.f4321d) && Arrays.equals(this.f4323f, bVar.f4323f) && Arrays.equals(this.f4324g, bVar.f4324g);
        } else if (!(obj instanceof f.a) || !e() || !a(d.f4136d).equals(((f.a) obj).b)) {
            return false;
        } else {
            return true;
        }
    }

    @Override // l.b.a.x.f
    public boolean f(l.b.a.f fVar, q qVar) {
        return c(fVar).contains(qVar);
    }

    public final d[] g(int i2) {
        e eVar;
        int i3;
        Integer valueOf = Integer.valueOf(i2);
        d[] dVarArr = this.f4325h.get(valueOf);
        if (dVarArr != null) {
            return dVarArr;
        }
        e[] eVarArr = this.f4324g;
        d[] dVarArr2 = new d[eVarArr.length];
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            e eVar2 = eVarArr[i4];
            byte b2 = eVar2.c;
            if (b2 < 0) {
                h hVar = eVar2.b;
                eVar = e.Q(i2, hVar, hVar.s(m.f4188d.u((long) i2)) + 1 + eVar2.c);
                l.b.a.b bVar = eVar2.f4329d;
                if (bVar != null) {
                    eVar = eVar.y(new l.b.a.w.h(1, bVar, null));
                }
            } else {
                eVar = e.Q(i2, eVar2.b, b2);
                l.b.a.b bVar2 = eVar2.f4329d;
                if (bVar2 != null) {
                    eVar = eVar.y(f.b.a.c.b.o.b.r1(bVar2));
                }
            }
            l.b.a.f F = l.b.a.f.F(eVar.V((long) eVar2.f4331f), eVar2.f4330e);
            e.a aVar = eVar2.f4332g;
            q qVar = eVar2.f4333h;
            q qVar2 = eVar2.f4334i;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i3 = qVar2.c;
                qVar = q.f4166g;
            } else if (ordinal != 2) {
                dVarArr2[i4] = new d(F, eVar2.f4334i, eVar2.f4335j);
            } else {
                i3 = qVar2.c;
            }
            F = F.K((long) (i3 - qVar.c));
            dVarArr2[i4] = new d(F, eVar2.f4334i, eVar2.f4335j);
        }
        if (i2 < 2100) {
            this.f4325h.putIfAbsent(valueOf, dVarArr2);
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
    public final Object h(l.b.a.f fVar) {
        Object obj;
        int i2;
        int i3 = 0;
        if (this.f4324g.length > 0) {
            l.b.a.f[] fVarArr = this.f4322e;
            l.b.a.f fVar2 = fVarArr[fVarArr.length - 1];
            Objects.requireNonNull(fVar);
            if (!(fVar2 instanceof l.b.a.f) ? fVar.b.x() > fVar2.b.x() || (i2 == 0 && fVar.c.E() > fVar2.c.E()) : fVar.B(fVar2) > 0) {
                d[] g2 = g(fVar.b.b);
                Object obj2 = null;
                int length = g2.length;
                while (i3 < length) {
                    d dVar = g2[i3];
                    l.b.a.f fVar3 = dVar.b;
                    boolean b2 = dVar.b();
                    boolean D = fVar.D(fVar3);
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
                    obj = dVar.f4328d;
                    if (!(obj instanceof d)) {
                    }
                    return obj;
                }
                return obj2;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f4322e, fVar);
        if (binarySearch == -1) {
            return this.f4323f[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            l.b.a.f[] fVarArr2 = this.f4322e;
            if (binarySearch < fVarArr2.length - 1) {
                int i4 = binarySearch + 1;
                if (fVarArr2[binarySearch].equals(fVarArr2[i4])) {
                    binarySearch = i4;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.f4323f[(binarySearch / 2) + 1];
        }
        l.b.a.f[] fVarArr3 = this.f4322e;
        l.b.a.f fVar4 = fVarArr3[binarySearch];
        l.b.a.f fVar5 = fVarArr3[binarySearch + 1];
        q[] qVarArr = this.f4323f;
        int i5 = binarySearch / 2;
        q qVar = qVarArr[i5];
        q qVar2 = qVarArr[i5 + 1];
        return qVar2.c > qVar.c ? new d(fVar4, qVar, qVar2) : new d(fVar5, qVar, qVar2);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.b) ^ Arrays.hashCode(this.c)) ^ Arrays.hashCode(this.f4321d)) ^ Arrays.hashCode(this.f4323f)) ^ Arrays.hashCode(this.f4324g);
    }

    public String toString() {
        StringBuilder h2 = a.h("StandardZoneRules[currentStandardOffset=");
        q[] qVarArr = this.c;
        h2.append(qVarArr[qVarArr.length - 1]);
        h2.append("]");
        return h2.toString();
    }
}
