package f.b.a.a.a.r;

import android.util.Log;
import e.b.a.m;
import f.a.a.a.a;
import f.b.a.a.a.s.d;
import f.b.a.a.a.s.h;
import f.b.a.c.b.o.b;
import f.b.a.c.i.c0;
import f.b.a.c.i.i;
import f.b.b.a.g;
import f.b.c.k.f;
import f.b.c.k.o;
import f.b.c.k.q;
import f.b.c.k.s.e;
import f.b.c.k.s.f0;
import f.b.c.k.s.h0;
import f.b.c.k.s.i0;
import f.b.c.k.s.n;
import f.b.c.k.s.x;
import f.b.c.k.u.k;
import f.b.c.k.u.l;
import f.b.c.k.u.p.c;
import f.b.c.k.u.p.j;
import f.b.c.k.u.p.m;
import f.b.c.k.x.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

public final /* synthetic */ class h implements g {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ c0 c;

    public /* synthetic */ h(b0 b0Var, String str, c0 c0Var) {
        this.a = b0Var;
        this.b = str;
        this.c = c0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01dd, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01de, code lost:
        continue;
     */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        c0 c0Var;
        h0 h0Var;
        boolean z;
        boolean z2;
        f.b.c.k.u.h next;
        b0 b0Var = this.a;
        String str = this.b;
        c0 c0Var2 = this.c;
        v vVar = (v) obj;
        y yVar = b0Var.f2198d;
        Objects.requireNonNull(yVar);
        boolean b2 = c0Var2.b();
        long a2 = c0Var2.a();
        d b3 = vVar.b();
        f.b.a.a.a.s.g prioParameters = vVar.a().getPrioParameters();
        if (b3.getResponseStatus().getStatusCode() != h.c.OK) {
            StringBuilder h2 = a.h("Cannot write failed response: ");
            h2.append(b3.getResponseStatus().getErrorDetails());
            Log.w("PrioFirestoreRepository", h2.toString());
            c0Var = new c0();
            c0Var.r();
        } else {
            String uuid = UUID.randomUUID().toString();
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("payload", yVar.a(vVar, uuid, c0Var2));
                if (!yVar.a.c(str, hashMap, prioParameters, b3, a2)) {
                    c0Var = new c0();
                    c0Var.r();
                }
            } catch (Exception e2) {
                Log.w("PrioFirestoreRepository", "Device attestation failed, requireAttestation=" + b2, e2);
                if (b2) {
                    c0 c0Var3 = new c0();
                    c0Var3.p(e2);
                    c0Var = c0Var3;
                }
            }
            StringBuilder h3 = a.h("uuid");
            h3.append(yVar.f2238e.nextInt(100));
            String sb = h3.toString();
            f fVar = yVar.b;
            Objects.requireNonNull(fVar);
            b.C(sb, "Provided collection path must not be null.");
            if (fVar.f2991h == null) {
                synchronized (fVar.b) {
                    if (fVar.f2991h == null) {
                        f.b.c.k.u.b bVar = fVar.b;
                        String str2 = fVar.c;
                        f.b.c.k.h hVar = fVar.f2990g;
                        fVar.f2991h = new n(fVar.a, new e(bVar, str2, hVar.a, hVar.b), hVar, fVar.f2987d, fVar.f2988e, fVar.f2992i);
                    }
                }
            }
            l s = l.s(sb);
            x a3 = x.a(s);
            if (s.n() % 2 == 1) {
                b.C(uuid, "Provided document path must not be null.");
                l lVar = (l) a3.f3067e.a(l.s(uuid));
                if (lVar.n() % 2 == 0) {
                    f.b.c.k.u.f fVar2 = new f.b.c.k.u.f(lVar);
                    String b4 = y.f2235g.b(yVar.c.b());
                    b.C(b4, "Provided collection path must not be null.");
                    l lVar2 = (l) fVar2.b.a(l.s(b4));
                    x a4 = x.a(lVar2);
                    if (lVar2.n() % 2 == 1) {
                        b.C(str, "Provided document path must not be null.");
                        l lVar3 = (l) a4.f3067e.a(l.s(str));
                        if (lVar3.n() % 2 == 0) {
                            f.b.c.k.u.f fVar3 = new f.b.c.k.u.f(lVar3);
                            o oVar = o.c;
                            b.C(hashMap, "Provided data must not be null.");
                            b.C(oVar, "Provided options must not be null.");
                            if (oVar.a) {
                                q qVar = fVar.f2989f;
                                c cVar = oVar.b;
                                Objects.requireNonNull(qVar);
                                f0 f0Var = new f0(i0.MergeSet);
                                k a5 = qVar.a(hashMap, f0Var.a());
                                if (cVar != null) {
                                    Iterator<f.b.c.k.u.h> it = cVar.a.iterator();
                                    do {
                                        z = false;
                                        if (it.hasNext()) {
                                            next = it.next();
                                            Iterator<f.b.c.k.u.h> it2 = f0Var.b.iterator();
                                            while (true) {
                                                if (it2.hasNext()) {
                                                    if (next.m(it2.next())) {
                                                        break;
                                                    }
                                                } else {
                                                    Iterator<f.b.c.k.u.p.d> it3 = f0Var.c.iterator();
                                                    while (true) {
                                                        if (it3.hasNext()) {
                                                            if (next.m(it3.next().a)) {
                                                                break;
                                                            }
                                                        } else {
                                                            continue;
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            ArrayList arrayList = new ArrayList();
                                            Iterator<f.b.c.k.u.p.d> it4 = f0Var.c.iterator();
                                            while (it4.hasNext()) {
                                                f.b.c.k.u.p.d next2 = it4.next();
                                                f.b.c.k.u.h hVar2 = next2.a;
                                                Iterator<f.b.c.k.u.h> it5 = cVar.a.iterator();
                                                while (true) {
                                                    if (it5.hasNext()) {
                                                        if (it5.next().m(hVar2)) {
                                                            z2 = true;
                                                            break;
                                                        }
                                                    } else {
                                                        z2 = false;
                                                        break;
                                                    }
                                                }
                                                if (z2) {
                                                    arrayList.add(next2);
                                                }
                                            }
                                            h0Var = new h0(a5, cVar, Collections.unmodifiableList(arrayList));
                                        }
                                    } while (z);
                                    StringBuilder h4 = a.h("Field '");
                                    h4.append(next.c());
                                    h4.append("' is specified in your field mask but not in your input data.");
                                    throw new IllegalArgumentException(h4.toString());
                                }
                                h0Var = new h0(a5, new c(f0Var.b), Collections.unmodifiableList(f0Var.c));
                            } else {
                                q qVar2 = fVar.f2989f;
                                Objects.requireNonNull(qVar2);
                                f0 f0Var2 = new f0(i0.Set);
                                h0Var = new h0(qVar2.a(hashMap, f0Var2.a()), null, Collections.unmodifiableList(f0Var2.c));
                            }
                            n nVar = fVar.f2991h;
                            f.b.c.k.u.p.k kVar = f.b.c.k.u.p.k.c;
                            ArrayList arrayList2 = new ArrayList();
                            c cVar2 = h0Var.b;
                            if (cVar2 != null) {
                                arrayList2.add(new j(fVar3, h0Var.a, cVar2, kVar));
                            } else {
                                arrayList2.add(new m(fVar3, h0Var.a, kVar));
                            }
                            if (!h0Var.c.isEmpty()) {
                                arrayList2.add(new f.b.c.k.u.p.n(fVar3, h0Var.c));
                            }
                            synchronized (nVar.c.a) {
                            }
                            i iVar = new i();
                            nVar.c.b(new f.b.c.k.s.j(nVar, arrayList2, iVar));
                            c0<TResult> c0Var4 = iVar.a;
                            Executor executor = f.b.c.k.x.j.b;
                            f.b.a.c.i.a<Void, Void> aVar = r.b;
                            Objects.requireNonNull(c0Var4);
                            c0 c0Var5 = new c0();
                            c0Var4.b.b(new f.b.a.c.i.l(executor, aVar, c0Var5));
                            c0Var4.t();
                            c0Var = c0Var5;
                        } else {
                            throw new IllegalArgumentException(a.n(lVar3, a.h("Invalid document reference. Document references must have an even number of segments, but "), " has "));
                        }
                    } else {
                        throw new IllegalArgumentException(a.n(lVar2, a.h("Invalid collection reference. Collection references must have an odd number of segments, but "), " has "));
                    }
                } else {
                    throw new IllegalArgumentException(a.n(lVar, a.h("Invalid document reference. Document references must have an even number of segments, but "), " has "));
                }
            } else {
                throw new IllegalArgumentException(a.n(s, a.h("Invalid collection reference. Collection references must have an odd number of segments, but "), " has "));
            }
        }
        return f.b.b.f.a.l.x(m.h.g0(c0Var, y.f2234f, yVar.f2237d));
    }
}
