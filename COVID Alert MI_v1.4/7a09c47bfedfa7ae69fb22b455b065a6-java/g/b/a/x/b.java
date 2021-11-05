package g.b.a.x;

import b.x.t;
import c.a.a.a.a;
import g.b.a.d;
import g.b.a.e;
import g.b.a.f;
import g.b.a.h;
import g.b.a.q;
import g.b.a.t.m;
import g.b.a.x.e;
import g.b.a.x.f;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class b extends f implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public final long[] f6681b;

    /* renamed from: c  reason: collision with root package name */
    public final q[] f6682c;

    /* renamed from: d  reason: collision with root package name */
    public final long[] f6683d;

    /* renamed from: e  reason: collision with root package name */
    public final f[] f6684e;

    /* renamed from: f  reason: collision with root package name */
    public final q[] f6685f;

    /* renamed from: g  reason: collision with root package name */
    public final e[] f6686g;
    public final ConcurrentMap<Integer, d[]> h = new ConcurrentHashMap();

    public b(long[] jArr, q[] qVarArr, long[] jArr2, q[] qVarArr2, e[] eVarArr) {
        f fVar;
        this.f6681b = jArr;
        this.f6682c = qVarArr;
        this.f6683d = jArr2;
        this.f6685f = qVarArr2;
        this.f6686g = eVarArr;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < jArr2.length) {
            int i2 = i + 1;
            d dVar = new d(jArr2[i], qVarArr2[i], qVarArr2[i2]);
            if (dVar.d()) {
                arrayList.add(dVar.f6693b);
                fVar = dVar.b();
            } else {
                arrayList.add(dVar.b());
                fVar = dVar.f6693b;
            }
            arrayList.add(fVar);
            i = i2;
        }
        this.f6684e = (f[]) arrayList.toArray(new f[arrayList.size()]);
    }

    private Object writeReplace() {
        return new a((byte) 1, this);
    }

    @Override // g.b.a.x.f
    public q a(d dVar) {
        long j = dVar.f6404b;
        if (this.f6686g.length > 0) {
            long[] jArr = this.f6683d;
            if (j > jArr[jArr.length - 1]) {
                q[] qVarArr = this.f6685f;
                d[] g2 = g(e.h0(t.t1(((long) qVarArr[qVarArr.length - 1].f6447c) + j, 86400)).f6409b);
                d dVar2 = null;
                for (int i = 0; i < g2.length; i++) {
                    dVar2 = g2[i];
                    if (j < dVar2.f6693b.H(dVar2.f6694c)) {
                        return dVar2.f6694c;
                    }
                }
                return dVar2.f6695d;
            }
        }
        int binarySearch = Arrays.binarySearch(this.f6683d, j);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f6685f[binarySearch + 1];
    }

    @Override // g.b.a.x.f
    public d b(f fVar) {
        Object h2 = h(fVar);
        if (h2 instanceof d) {
            return (d) h2;
        }
        return null;
    }

    @Override // g.b.a.x.f
    public List<q> c(f fVar) {
        Object h2 = h(fVar);
        if (!(h2 instanceof d)) {
            return Collections.singletonList((q) h2);
        }
        d dVar = (d) h2;
        if (dVar.d()) {
            return Collections.emptyList();
        }
        return Arrays.asList(dVar.f6694c, dVar.f6695d);
    }

    @Override // g.b.a.x.f
    public boolean d(d dVar) {
        int binarySearch = Arrays.binarySearch(this.f6681b, dVar.f6404b);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return !this.f6682c[binarySearch + 1].equals(a(dVar));
    }

    @Override // g.b.a.x.f
    public boolean e() {
        return this.f6683d.length == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return Arrays.equals(this.f6681b, bVar.f6681b) && Arrays.equals(this.f6682c, bVar.f6682c) && Arrays.equals(this.f6683d, bVar.f6683d) && Arrays.equals(this.f6685f, bVar.f6685f) && Arrays.equals(this.f6686g, bVar.f6686g);
        } else if (!(obj instanceof f.a)) {
            return false;
        } else {
            if (e()) {
                q a2 = a(d.f6403d);
                d dVar = d.f6403d;
                if (a2.equals(((f.a) obj).f6706b)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // g.b.a.x.f
    public boolean f(g.b.a.f fVar, q qVar) {
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
        e[] eVarArr = this.f6686g;
        d[] dVarArr2 = new d[eVarArr.length];
        for (int i3 = 0; i3 < eVarArr.length; i3++) {
            e eVar2 = eVarArr[i3];
            byte b2 = eVar2.f6697c;
            if (b2 < 0) {
                h hVar = eVar2.f6696b;
                eVar = e.g0(i, hVar, hVar.A(m.f6476d.F((long) i)) + 1 + eVar2.f6697c);
                g.b.a.b bVar = eVar2.f6698d;
                if (bVar != null) {
                    eVar = eVar.i(new g.b.a.w.h(1, bVar, null));
                }
            } else {
                eVar = e.g0(i, eVar2.f6696b, b2);
                g.b.a.b bVar2 = eVar2.f6698d;
                if (bVar2 != null) {
                    eVar = eVar.i(t.i2(bVar2));
                }
            }
            g.b.a.f Y = g.b.a.f.Y(eVar.l0((long) eVar2.f6700f), eVar2.f6699e);
            e.a aVar = eVar2.f6701g;
            q qVar = eVar2.h;
            q qVar2 = eVar2.i;
            int ordinal = aVar.ordinal();
            if (ordinal == 0) {
                i2 = qVar2.f6447c;
                qVar = q.f6446g;
            } else if (ordinal != 2) {
                dVarArr2[i3] = new d(Y, eVar2.i, eVar2.j);
            } else {
                i2 = qVar2.f6447c;
            }
            Y = Y.d0((long) (i2 - qVar.f6447c));
            dVarArr2[i3] = new d(Y, eVar2.i, eVar2.j);
        }
        if (i < 2100) {
            this.h.putIfAbsent(valueOf, dVarArr2);
        }
        return dVarArr2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r9.V(r3.b()) != false) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        if (r9.V(r3.b()) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007c, code lost:
        r4 = r3;
     */
    public final Object h(g.b.a.f fVar) {
        Object obj;
        int i;
        int i2 = 0;
        if (this.f6686g.length > 0) {
            g.b.a.f[] fVarArr = this.f6684e;
            g.b.a.f fVar2 = fVarArr[fVarArr.length - 1];
            Object obj2 = null;
            if (fVar != null) {
                if (!(fVar2 instanceof g.b.a.f) ? fVar.f6414b.P() > fVar2.f6414b.P() || (i == 0 && fVar.f6415c.Y() > fVar2.f6415c.Y()) : fVar.T(fVar2) > 0) {
                    d[] g2 = g(fVar.f6414b.f6409b);
                    int length = g2.length;
                    while (i2 < length) {
                        d dVar = g2[i2];
                        g.b.a.f fVar3 = dVar.f6693b;
                        boolean d2 = dVar.d();
                        boolean V = fVar.V(fVar3);
                        if (d2) {
                            if (!V) {
                            }
                            obj = dVar.f6694c;
                            if (!(obj instanceof d) || obj.equals(dVar.f6694c)) {
                                return obj;
                            }
                            i2++;
                            obj2 = obj;
                        } else if (V) {
                        }
                        obj = dVar.f6695d;
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
        int binarySearch = Arrays.binarySearch(this.f6684e, fVar);
        if (binarySearch == -1) {
            return this.f6685f[0];
        }
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        } else {
            g.b.a.f[] fVarArr2 = this.f6684e;
            if (binarySearch < fVarArr2.length - 1) {
                int i3 = binarySearch + 1;
                if (fVarArr2[binarySearch].equals(fVarArr2[i3])) {
                    binarySearch = i3;
                }
            }
        }
        if ((binarySearch & 1) != 0) {
            return this.f6685f[(binarySearch / 2) + 1];
        }
        g.b.a.f[] fVarArr3 = this.f6684e;
        g.b.a.f fVar4 = fVarArr3[binarySearch];
        g.b.a.f fVar5 = fVarArr3[binarySearch + 1];
        q[] qVarArr = this.f6685f;
        int i4 = binarySearch / 2;
        q qVar = qVarArr[i4];
        q qVar2 = qVarArr[i4 + 1];
        return qVar2.f6447c > qVar.f6447c ? new d(fVar4, qVar, qVar2) : new d(fVar5, qVar, qVar2);
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.f6681b) ^ Arrays.hashCode(this.f6682c)) ^ Arrays.hashCode(this.f6683d)) ^ Arrays.hashCode(this.f6685f)) ^ Arrays.hashCode(this.f6686g);
    }

    public String toString() {
        StringBuilder h2 = a.h("StandardZoneRules[currentStandardOffset=");
        q[] qVarArr = this.f6682c;
        h2.append(qVarArr[qVarArr.length - 1]);
        h2.append("]");
        return h2.toString();
    }
}
