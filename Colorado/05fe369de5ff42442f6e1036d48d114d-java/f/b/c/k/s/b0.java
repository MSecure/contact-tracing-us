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
    public final Map<Integer, List<x>> f3198d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final int f3199e;

    /* renamed from: f  reason: collision with root package name */
    public final Queue<f> f3200f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    public final Map<f, Integer> f3201g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Map<Integer, a> f3202h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public final j0 f3203i = new j0();

    /* renamed from: j  reason: collision with root package name */
    public final Map<f.b.c.k.r.f, Map<Integer, i<Void>>> f3204j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    public final Map<Integer, List<i<Void>>> f3205k;

    /* renamed from: l  reason: collision with root package name */
    public final d0 f3206l = new d0(1, 1);
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
        this.f3199e = i2;
        this.m = fVar;
        this.f3205k = new HashMap();
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
            a aVar = this.f3202h.get(entry.getKey());
            if (aVar != null) {
                f.b.a.c.b.o.b.M0(value.f3351e.size() + (value.f3350d.size() + value.c.size()) <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.c.size() > 0) {
                    aVar.b = true;
                } else if (value.f3350d.size() > 0) {
                    f.b.a.c.b.o.b.M0(aVar.b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.f3351e.size() > 0) {
                    f.b.a.c.b.o.b.M0(aVar.b, "Received remove for limbo target document without add.", new Object[0]);
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
        a aVar = this.f3202h.get(Integer.valueOf(i2));
        if (aVar != null && aVar.b) {
            return f.c.h(aVar.a);
        }
        f.b.c.g.a.f<f> fVar = f.c;
        if (this.f3198d.containsKey(Integer.valueOf(i2))) {
            for (x xVar : this.f3198d.get(Integer.valueOf(i2))) {
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
        a aVar = this.f3202h.get(Integer.valueOf(i2));
        f fVar = aVar != null ? aVar.a : null;
        if (fVar != null) {
            this.f3201g.remove(fVar);
            this.f3202h.remove(Integer.valueOf(i2));
            k();
            f.b.c.k.u.m mVar = f.b.c.k.u.m.c;
            b(new g0(mVar, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(fVar, new j(fVar, mVar, false)), Collections.singleton(fVar)));
            return;
        }
        r rVar = this.a;
        rVar.a.h("Release target", new q(rVar, i2));
        for (x xVar : this.f3198d.get(Integer.valueOf(i2))) {
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
        this.f3198d.remove(Integer.valueOf(i2));
        f.b.c.g.a.f<f> d2 = this.f3203i.d(i2);
        this.f3203i.g(i2);
        Iterator<f> it2 = d2.iterator();
        while (true) {
            f.a aVar3 = (f.a) it2;
            if (aVar3.hasNext()) {
                f.b.c.k.u.f fVar2 = (f.b.c.k.u.f) aVar3.next();
                if (!this.f3203i.c(fVar2)) {
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
        f.b.a.c.b.o.b.M0(this.n != null, "Trying to call %s before setting callback", str);
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
        Map<Integer, i<Void>> map = this.f3204j.get(this.m);
        if (map != null && (iVar = map.get((valueOf = Integer.valueOf(i2)))) != null) {
            if (c1Var != null) {
                iVar.a.q(f.b.c.k.x.r.b(c1Var));
            } else {
                iVar.a.r(null);
            }
            map.remove(valueOf);
        }
    }

    public final void k() {
        while (!this.f3200f.isEmpty() && this.f3201g.size() < this.f3199e) {
            f.b.c.k.u.f remove = this.f3200f.remove();
            d0 d0Var = this.f3206l;
            int i2 = d0Var.a;
            d0Var.a = i2 + 2;
            this.f3202h.put(Integer.valueOf(i2), new a(remove));
            this.f3201g.put(remove, Integer.valueOf(i2));
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
                } else if (l0Var.f3342f.c()) {
                    l0Var.f(d1Var);
                }
            }
        }
    }

    public final void l(f.b.c.k.u.f fVar) {
        Integer num = this.f3201g.get(fVar);
        if (num != null) {
            l0 l0Var = this.b;
            int intValue = num.intValue();
            f.b.a.c.b.o.b.M0(l0Var.c.remove(Integer.valueOf(intValue)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(intValue));
            if (l0Var.f3342f.c()) {
                l0Var.e(intValue);
            }
            if (l0Var.c.isEmpty()) {
                if (l0Var.f3342f.c()) {
                    l0Var.f3342f.e();
                } else if (l0Var.f3341e) {
                    l0Var.f3340d.c(v.UNKNOWN);
                }
            }
            this.f3201g.remove(fVar);
            this.f3202h.remove(num);
            k();
        }
    }

    public final void m(int i2) {
        if (this.f3205k.containsKey(Integer.valueOf(i2))) {
            for (i<Void> iVar : this.f3205k.get(Integer.valueOf(i2))) {
                iVar.a.r(null);
            }
            this.f3205k.remove(Integer.valueOf(i2));
        }
    }
}
