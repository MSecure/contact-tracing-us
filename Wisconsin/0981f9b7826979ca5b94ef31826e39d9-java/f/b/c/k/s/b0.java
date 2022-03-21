package f.b.c.k.s;

import f.b.a.c.i.i;
import f.b.c.g.a.d;
import f.b.c.g.a.f;
import f.b.c.k.s.g;
import f.b.c.k.t.d1;
import f.b.c.k.t.h0;
import f.b.c.k.t.j0;
import f.b.c.k.t.l;
import f.b.c.k.t.m;
import f.b.c.k.t.o;
import f.b.c.k.t.p;
import f.b.c.k.t.q;
import f.b.c.k.t.r;
import f.b.c.k.u.f;
import f.b.c.k.u.j;
import f.b.c.k.u.p.g;
import f.b.c.k.w.g0;
import f.b.c.k.w.l0;
import f.b.c.k.w.o0;
import f.b.c.k.w.s0;
import f.b.c.k.x.m;
import h.a.c1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

public class b0 implements l0.c {
    public final r a;
    public final l0 b;
    public final Map<x, z> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<Integer, List<x>> f3007d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final int f3008e;

    /* renamed from: f  reason: collision with root package name */
    public final Queue<f> f3009f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Map<f, Integer> f3010g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Map<Integer, a> f3011h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public final j0 f3012i = new j0();

    /* renamed from: j  reason: collision with root package name */
    public final Map<f.b.c.k.r.f, Map<Integer, i<Void>>> f3013j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public final Map<Integer, List<i<Void>>> f3014k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f3015l = new d0(1, 1);
    public f.b.c.k.r.f m;
    public b n;

    public static class a {
        public final f a;
        public boolean b;

        public a(f fVar) {
            this.a = fVar;
        }
    }

    public interface b {
    }

    public b0(r rVar, l0 l0Var, f.b.c.k.r.f fVar, int i2) {
        this.a = rVar;
        this.b = l0Var;
        this.f3008e = i2;
        this.m = fVar;
        this.f3014k = new HashMap();
    }

    @Override // f.b.c.k.w.l0.c
    public void a(int i2, c1 c1Var) {
        g("handleRejectedWrite");
        r rVar = this.a;
        d<f, f.b.c.k.u.i> dVar = (d) rVar.a.g("Reject batch", new m(rVar, i2));
        if (!dVar.isEmpty()) {
            i(c1Var, "Write failed at %s", dVar.k().b);
        }
        j(i2, c1Var);
        m(i2);
        h(dVar, null);
    }

    @Override // f.b.c.k.w.l0.c
    public void b(g0 g0Var) {
        g("handleRemoteEvent");
        for (Map.Entry<Integer, o0> entry : g0Var.b.entrySet()) {
            o0 value = entry.getValue();
            a aVar = this.f3011h.get(entry.getKey());
            if (aVar != null) {
                f.b.a.c.b.o.b.a1(value.f3160e.size() + (value.f3159d.size() + value.c.size()) <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.c.size() > 0) {
                    aVar.b = true;
                } else if (value.f3159d.size() > 0) {
                    f.b.a.c.b.o.b.a1(aVar.b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.f3160e.size() > 0) {
                    f.b.a.c.b.o.b.a1(aVar.b, "Received remove for limbo target document without add.", new Object[0]);
                    aVar.b = false;
                }
            }
        }
        r rVar = this.a;
        Objects.requireNonNull(rVar);
        h((d) rVar.a.g("Apply remote event", new o(rVar, g0Var, g0Var.a)), g0Var);
    }

    @Override // f.b.c.k.w.l0.c
    public void c(g gVar) {
        g("handleSuccessfulWrite");
        j(gVar.a.a, null);
        m(gVar.a.a);
        r rVar = this.a;
        h((d) rVar.a.g("Acknowledge batch", new l(rVar, gVar)), null);
    }

    @Override // f.b.c.k.w.l0.c
    public f.b.c.g.a.f<f> d(int i2) {
        a aVar = this.f3011h.get(Integer.valueOf(i2));
        if (aVar != null && aVar.b) {
            return f.c.h(aVar.a);
        }
        f.b.c.g.a.f<f> fVar = f.c;
        if (this.f3007d.containsKey(Integer.valueOf(i2))) {
            for (x xVar : this.f3007d.get(Integer.valueOf(i2))) {
                if (this.c.containsKey(xVar)) {
                    Objects.requireNonNull(this.c.get(xVar));
                    throw null;
                }
            }
        }
        return fVar;
    }

    @Override // f.b.c.k.w.l0.c
    public void e(int i2, c1 c1Var) {
        g("handleRejectedListen");
        a aVar = this.f3011h.get(Integer.valueOf(i2));
        f fVar = aVar != null ? aVar.a : null;
        if (fVar != null) {
            this.f3010g.remove(fVar);
            this.f3011h.remove(Integer.valueOf(i2));
            k();
            f.b.c.k.u.m mVar = f.b.c.k.u.m.c;
            b(new g0(mVar, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(fVar, new j(fVar, mVar, false)), Collections.singleton(fVar)));
            return;
        }
        r rVar = this.a;
        rVar.a.h("Release target", new q(rVar, i2));
        for (x xVar : this.f3007d.get(Integer.valueOf(i2))) {
            this.c.remove(xVar);
            if (!c1Var.e()) {
                g gVar = (g) this.n;
                g.a aVar2 = gVar.a.get(xVar);
                if (aVar2 != null) {
                    Iterator<y> it = aVar2.a.iterator();
                    if (it.hasNext()) {
                        f.b.c.k.x.r.b(c1Var);
                        Objects.requireNonNull(it.next());
                        throw null;
                    }
                }
                gVar.a.remove(xVar);
                i(c1Var, "Listen for %s failed", xVar);
            }
        }
        this.f3007d.remove(Integer.valueOf(i2));
        f.b.c.g.a.f<f> d2 = this.f3012i.d(i2);
        this.f3012i.g(i2);
        Iterator<f> it2 = d2.iterator();
        while (true) {
            f.a aVar3 = (f.a) it2;
            if (aVar3.hasNext()) {
                f.b.c.k.u.f fVar2 = (f.b.c.k.u.f) aVar3.next();
                if (!this.f3012i.c(fVar2)) {
                    l(fVar2);
                }
            } else {
                return;
            }
        }
    }

    @Override // f.b.c.k.w.l0.c
    public void f(v vVar) {
        g("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<x, z>> it = this.c.entrySet().iterator();
        if (!it.hasNext()) {
            ((g) this.n).a(arrayList);
            for (g.a aVar : ((g) this.n).a.values()) {
                for (y yVar : aVar.a) {
                    yVar.a = vVar;
                }
            }
            return;
        }
        Objects.requireNonNull(it.next().getValue());
        throw null;
    }

    public final void g(String str) {
        f.b.a.c.b.o.b.a1(this.n != null, "Trying to call %s before setting callback", str);
    }

    public final void h(d<f.b.c.k.u.f, f.b.c.k.u.i> dVar, g0 g0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<x, z>> it = this.c.entrySet().iterator();
        if (!it.hasNext()) {
            ((g) this.n).a(arrayList);
            r rVar = this.a;
            rVar.a.h("notifyLocalViewChanges", new p(rVar, arrayList2));
            return;
        }
        Objects.requireNonNull(it.next().getValue());
        throw null;
    }

    public final void i(c1 c1Var, String str, Object... objArr) {
        c1.b bVar = c1Var.a;
        String str2 = c1Var.b;
        if (str2 == null) {
            str2 = "";
        }
        if ((bVar == c1.b.FAILED_PRECONDITION && str2.contains("requires an index")) || bVar == c1.b.PERMISSION_DENIED) {
            f.b.c.k.x.m.a(m.a.WARN, "Firestore", "%s: %s", String.format(str, objArr), c1Var);
        }
    }

    public final void j(int i2, c1 c1Var) {
        Integer valueOf;
        i<Void> iVar;
        Map<Integer, i<Void>> map = this.f3013j.get(this.m);
        if (map != null && (iVar = map.get((valueOf = Integer.valueOf(i2)))) != null) {
            if (c1Var != null) {
                iVar.a.p(f.b.c.k.x.r.b(c1Var));
            } else {
                iVar.a.q(null);
            }
            map.remove(valueOf);
        }
    }

    public final void k() {
        while (!this.f3009f.isEmpty() && this.f3010g.size() < this.f3008e) {
            f.b.c.k.u.f remove = this.f3009f.remove();
            d0 d0Var = this.f3015l;
            int i2 = d0Var.a;
            d0Var.a = i2 + 2;
            this.f3011h.put(Integer.valueOf(i2), new a(remove));
            this.f3010g.put(remove, Integer.valueOf(i2));
            l0 l0Var = this.b;
            c0 d2 = x.a(remove.b).d();
            h0 h0Var = h0.LIMBO_RESOLUTION;
            f.b.c.k.u.m mVar = f.b.c.k.u.m.c;
            d1 d1Var = new d1(d2, i2, -1, h0Var, mVar, mVar, s0.q);
            Objects.requireNonNull(l0Var);
            Integer valueOf = Integer.valueOf(d1Var.b);
            if (!l0Var.c.containsKey(valueOf)) {
                l0Var.c.put(valueOf, d1Var);
                if (l0Var.g()) {
                    l0Var.i();
                } else if (l0Var.f3151f.c()) {
                    l0Var.f(d1Var);
                }
            }
        }
    }

    public final void l(f.b.c.k.u.f fVar) {
        Integer num = this.f3010g.get(fVar);
        if (num != null) {
            l0 l0Var = this.b;
            int intValue = num.intValue();
            f.b.a.c.b.o.b.a1(l0Var.c.remove(Integer.valueOf(intValue)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(intValue));
            if (l0Var.f3151f.c()) {
                l0Var.e(intValue);
            }
            if (l0Var.c.isEmpty()) {
                if (l0Var.f3151f.c()) {
                    l0Var.f3151f.e();
                } else if (l0Var.f3150e) {
                    l0Var.f3149d.c(v.UNKNOWN);
                }
            }
            this.f3010g.remove(fVar);
            this.f3011h.remove(num);
            k();
        }
    }

    public final void m(int i2) {
        if (this.f3014k.containsKey(Integer.valueOf(i2))) {
            for (i<Void> iVar : this.f3014k.get(Integer.valueOf(i2))) {
                iVar.a.q(null);
            }
            this.f3014k.remove(Integer.valueOf(i2));
        }
    }
}
