package f.b.a.d.a;

import e.b.a.m;
import f.a.a.a.a;
import f.b.a.a.a.f0.q;
import f.b.a.c.i.c0;
import f.b.a.c.i.i;
import f.b.a.d.a.i0.b;
import f.b.a.d.a.i0.d;
import f.b.a.d.a.i0.e;
import f.b.b.a.g;
import f.b.c.k.f;
import f.b.c.k.o;
import f.b.c.k.s.f0;
import f.b.c.k.s.h0;
import f.b.c.k.s.i0;
import f.b.c.k.s.n;
import f.b.c.k.s.x;
import f.b.c.k.u.h;
import f.b.c.k.u.k;
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
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final /* synthetic */ class l implements g {
    public final /* synthetic */ g0 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ h0 c;

    public /* synthetic */ l(g0 g0Var, String str, h0 h0Var) {
        this.a = g0Var;
        this.b = str;
        this.c = h0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01f8, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01f9, code lost:
        continue;
     */
    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        c0 c0Var;
        h0 h0Var;
        boolean z;
        boolean z2;
        h next;
        g0 g0Var = this.a;
        String str = this.b;
        h0 h0Var2 = this.c;
        y yVar = (y) obj;
        c0 c0Var2 = g0Var.f2803d;
        Objects.requireNonNull(c0Var2);
        boolean b2 = h0Var2.b();
        long a2 = h0Var2.a();
        b b3 = yVar.b();
        d f2 = yVar.a().f();
        if (b3.d().g() != e.c.OK) {
            d0 d0Var = c0Var2.c;
            StringBuilder h2 = a.h("Cannot write failed response: ");
            h2.append(b3.d().f());
            ((q) d0Var).a.g(h2.toString());
            c0Var = new c0();
            c0Var.s();
        } else {
            String uuid = UUID.randomUUID().toString();
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("payload", c0Var2.a(yVar, uuid, h0Var2));
                if (!c0Var2.a.a(str, hashMap, f2, b3, a2) && b2) {
                    c0Var = new c0();
                    c0Var.s();
                }
            } catch (Exception e2) {
                ((q) c0Var2.c).a.h("Device attestation failed, requireAttestation=" + b2, e2);
                if (b2) {
                    c0 c0Var3 = new c0();
                    c0Var3.q(e2);
                    c0Var = c0Var3;
                }
            }
            ((q) c0Var2.c).a.a(a.w("Writing packets to Firestore for metric=", str));
            String str2 = "uuid" + c0Var2.f2801e.nextInt(100);
            f fVar = c0Var2.b;
            Objects.requireNonNull(fVar);
            f.b.a.c.b.o.b.B(str2, "Provided collection path must not be null.");
            if (fVar.f3245h == null) {
                synchronized (fVar.b) {
                    if (fVar.f3245h == null) {
                        f.b.c.k.u.b bVar = fVar.b;
                        String str3 = fVar.c;
                        f.b.c.k.h hVar = fVar.f3244g;
                        fVar.f3245h = new n(fVar.a, new f.b.c.k.s.e(bVar, str3, hVar.a, hVar.b), hVar, fVar.f3241d, fVar.f3242e, fVar.f3246i);
                    }
                }
            }
            f.b.c.k.u.l s = f.b.c.k.u.l.s(str2);
            x a3 = x.a(s);
            if (s.n() % 2 == 1) {
                f.b.a.c.b.o.b.B(uuid, "Provided document path must not be null.");
                f.b.c.k.u.l lVar = (f.b.c.k.u.l) a3.f3321e.a(f.b.c.k.u.l.s(uuid));
                if (lVar.n() % 2 == 0) {
                    f.b.c.k.u.f fVar2 = new f.b.c.k.u.f(lVar);
                    String b4 = c0.f2798g.b(l.b.a.e.y());
                    f.b.a.c.b.o.b.B(b4, "Provided collection path must not be null.");
                    f.b.c.k.u.l lVar2 = (f.b.c.k.u.l) fVar2.b.a(f.b.c.k.u.l.s(b4));
                    x a4 = x.a(lVar2);
                    if (lVar2.n() % 2 == 1) {
                        f.b.a.c.b.o.b.B(str, "Provided document path must not be null.");
                        f.b.c.k.u.l lVar3 = (f.b.c.k.u.l) a4.f3321e.a(f.b.c.k.u.l.s(str));
                        if (lVar3.n() % 2 == 0) {
                            f.b.c.k.u.f fVar3 = new f.b.c.k.u.f(lVar3);
                            o oVar = o.c;
                            f.b.a.c.b.o.b.B(hashMap, "Provided data must not be null.");
                            f.b.a.c.b.o.b.B(oVar, "Provided options must not be null.");
                            if (oVar.a) {
                                f.b.c.k.q qVar = fVar.f3243f;
                                c cVar = oVar.b;
                                Objects.requireNonNull(qVar);
                                f0 f0Var = new f0(i0.MergeSet);
                                k a5 = qVar.a(hashMap, f0Var.a());
                                if (cVar != null) {
                                    Iterator<h> it = cVar.a.iterator();
                                    do {
                                        z = false;
                                        if (it.hasNext()) {
                                            next = it.next();
                                            Iterator<h> it2 = f0Var.b.iterator();
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
                                                h hVar2 = next2.a;
                                                Iterator<h> it5 = cVar.a.iterator();
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
                                    StringBuilder h3 = a.h("Field '");
                                    h3.append(next.c());
                                    h3.append("' is specified in your field mask but not in your input data.");
                                    throw new IllegalArgumentException(h3.toString());
                                }
                                h0Var = new h0(a5, new c(f0Var.b), Collections.unmodifiableList(f0Var.c));
                            } else {
                                f.b.c.k.q qVar2 = fVar.f3243f;
                                Objects.requireNonNull(qVar2);
                                f0 f0Var2 = new f0(i0.Set);
                                h0Var = new h0(qVar2.a(hashMap, f0Var2.a()), null, Collections.unmodifiableList(f0Var2.c));
                            }
                            n nVar = fVar.f3245h;
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
                            c0Var4.u();
                            c0Var = c0Var5;
                        } else {
                            throw new IllegalArgumentException(a.q(lVar3, a.h("Invalid document reference. Document references must have an even number of segments, but "), " has "));
                        }
                    } else {
                        throw new IllegalArgumentException(a.q(lVar2, a.h("Invalid collection reference. Collection references must have an odd number of segments, but "), " has "));
                    }
                } else {
                    throw new IllegalArgumentException(a.q(lVar, a.h("Invalid document reference. Document references must have an even number of segments, but "), " has "));
                }
            } else {
                throw new IllegalArgumentException(a.q(s, a.h("Invalid collection reference. Collection references must have an odd number of segments, but "), " has "));
            }
        }
        l.b.a.d dVar = c0.f2797f;
        ScheduledExecutorService scheduledExecutorService = c0Var2.f2800d;
        return f.b.b.f.a.l.x(f.b.b.f.a.l.x(m.e.l0(new f.b.a.d.a.j0.b(c0Var, scheduledExecutorService))).A(dVar.t(), TimeUnit.MILLISECONDS, scheduledExecutorService));
    }
}
