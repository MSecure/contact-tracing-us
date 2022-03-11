package f.b.c.k.s;

import f.b.a.c.b.o.b;
import f.b.a.c.i.i;
import f.b.c.g.a.d;
import f.b.c.g.a.f;
import f.b.c.k.r.f;
import f.b.c.k.s.g;
import f.b.c.k.t.d1;
import f.b.c.k.t.h0;
import f.b.c.k.t.j0;
import f.b.c.k.t.r;
import f.b.c.k.u.m;
import f.b.c.k.u.p.e;
import f.b.c.k.u.p.g;
import f.b.c.k.u.p.h;
import f.b.c.k.w.g0;
import f.b.c.k.w.l0;
import f.b.c.k.w.o0;
import f.b.c.k.w.s0;
import f.b.c.k.x.m;
import f.b.c.k.x.n;
import f.b.g.j;
import h.a.c1;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
/* loaded from: classes.dex */
public class b0 implements l0.c {
    public final r a;
    public final l0 b;

    /* renamed from: e */
    public final int f3517e;
    public f m;
    public b n;
    public final Map<x, z> c = new HashMap();

    /* renamed from: d */
    public final Map<Integer, List<x>> f3516d = new HashMap();

    /* renamed from: f */
    public final Queue<f.b.c.k.u.f> f3518f = new ArrayDeque();

    /* renamed from: g */
    public final Map<f.b.c.k.u.f, Integer> f3519g = new HashMap();

    /* renamed from: h */
    public final Map<Integer, a> f3520h = new HashMap();

    /* renamed from: i */
    public final j0 f3521i = new j0();

    /* renamed from: j */
    public final Map<f, Map<Integer, i<Void>>> f3522j = new HashMap();

    /* renamed from: l */
    public final d0 f3524l = new d0(1, 1);

    /* renamed from: k */
    public final Map<Integer, List<i<Void>>> f3523k = new HashMap();

    /* loaded from: classes.dex */
    public static class a {
        public final f.b.c.k.u.f a;
        public boolean b;

        public a(f.b.c.k.u.f fVar) {
            this.a = fVar;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public b0(r rVar, l0 l0Var, f fVar, int i2) {
        this.a = rVar;
        this.b = l0Var;
        this.f3517e = i2;
        this.m = fVar;
    }

    @Override // f.b.c.k.w.l0.c
    public void a(int i2, c1 c1Var) {
        g("handleRejectedWrite");
        r rVar = this.a;
        d<f.b.c.k.u.f, f.b.c.k.u.i> dVar = (d) rVar.a.g("Reject batch", new n(rVar, i2) { // from class: f.b.c.k.t.m
            public final r a;
            public final int b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.c.k.x.n
            public Object get() {
                r rVar2 = this.a;
                f.b.c.k.u.p.f i3 = rVar2.b.i(this.b);
                b.P0(i3 != null, "Attempt to reject nonexistent batch!", new Object[0]);
                rVar2.b.j(i3);
                rVar2.b.c();
                g gVar = rVar2.f3608d;
                return gVar.b(gVar.a.d(i3.b()));
            }
        });
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
            a aVar = this.f3520h.get(entry.getKey());
            if (aVar != null) {
                f.b.a.c.b.o.b.P0(value.f3669e.size() + (value.f3668d.size() + value.c.size()) <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.c.size() > 0) {
                    aVar.b = true;
                } else if (value.f3668d.size() > 0) {
                    f.b.a.c.b.o.b.P0(aVar.b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.f3669e.size() > 0) {
                    f.b.a.c.b.o.b.P0(aVar.b, "Received remove for limbo target document without add.", new Object[0]);
                    aVar.b = false;
                }
            }
        }
        r rVar = this.a;
        Objects.requireNonNull(rVar);
        h((d) rVar.a.g("Apply remote event", new n(rVar, g0Var, g0Var.a) { // from class: f.b.c.k.t.o
            public final r a;
            public final g0 b;
            public final m c;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            /* JADX WARN: Removed duplicated region for block: B:58:0x015a A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:60:0x00d1 A[SYNTHETIC] */
            @Override // f.b.c.k.x.n
            /* Code decompiled incorrectly, please refer to instructions dump */
            public Object get() {
                r rVar2 = this.a;
                g0 g0Var2 = this.b;
                m mVar = this.c;
                int i2 = r.f3607k;
                Map<Integer, o0> map = g0Var2.b;
                long d2 = rVar2.a.c().d();
                Iterator<Map.Entry<Integer, o0>> it = map.entrySet().iterator();
                while (true) {
                    boolean z = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<Integer, o0> next = it.next();
                    int intValue = next.getKey().intValue();
                    o0 value2 = next.getValue();
                    d1 d1Var = rVar2.f3612h.get(intValue);
                    if (d1Var != null) {
                        rVar2.f3611g.c(value2.f3669e, intValue);
                        rVar2.f3611g.b(value2.c, intValue);
                        j jVar = value2.a;
                        if (!jVar.isEmpty()) {
                            d1 b2 = d1Var.a(jVar, g0Var2.a).b(d2);
                            rVar2.f3612h.put(intValue, b2);
                            b.P0(!b2.f3598g.isEmpty(), "Attempted to persist query data with empty resume token", new Object[0]);
                            if (!d1Var.f3598g.isEmpty() && b2.f3596e.b.b - d1Var.f3596e.b.b < r.f3606j) {
                                if (value2.f3669e.size() + value2.f3668d.size() + value2.c.size() <= 0) {
                                    z = false;
                                }
                            }
                            if (z) {
                                rVar2.f3611g.d(b2);
                            }
                        }
                    }
                }
                HashMap hashMap = new HashMap();
                Map<f.b.c.k.u.f, f.b.c.k.u.i> map2 = g0Var2.f3653d;
                Set<f.b.c.k.u.f> set = g0Var2.f3654e;
                Map<f.b.c.k.u.f, f.b.c.k.u.i> d3 = rVar2.c.d(map2.keySet());
                for (Map.Entry<f.b.c.k.u.f, f.b.c.k.u.i> entry2 : map2.entrySet()) {
                    f.b.c.k.u.f key = entry2.getKey();
                    f.b.c.k.u.i value3 = entry2.getValue();
                    f.b.c.k.u.i iVar = d3.get(key);
                    if ((value3 instanceof f.b.c.k.u.j) && value3.b.equals(m.c)) {
                        rVar2.c.c(value3.a);
                    } else if (iVar == null || value3.b.compareTo(iVar.b) > 0 || (value3.b.compareTo(iVar.b) == 0 && iVar.a())) {
                        b.P0(!m.c.equals(g0Var2.a), "Cannot add a document when the remote version is zero", new Object[0]);
                        rVar2.c.a(value3, g0Var2.a);
                    } else {
                        f.b.c.k.x.m.a(m.a.DEBUG, "LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, iVar.b, value3.b);
                        if (!set.contains(key)) {
                            rVar2.a.c().b(key);
                        }
                    }
                    hashMap.put(key, value3);
                    if (!set.contains(key)) {
                    }
                }
                f.b.c.k.u.m a2 = rVar2.f3611g.a();
                if (!mVar.equals(f.b.c.k.u.m.c)) {
                    b.P0(mVar.compareTo(a2) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", mVar, a2);
                    rVar2.f3611g.e(mVar);
                }
                return rVar2.f3608d.b(hashMap);
            }
        }), g0Var);
    }

    @Override // f.b.c.k.w.l0.c
    public void c(g gVar) {
        g("handleSuccessfulWrite");
        j(gVar.a.a, null);
        m(gVar.a.a);
        r rVar = this.a;
        h((d) rVar.a.g("Acknowledge batch", new n(rVar, gVar) { // from class: f.b.c.k.t.l
            public final r a;
            public final g b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.c.k.x.n
            public Object get() {
                r rVar2 = this.a;
                g gVar2 = this.b;
                int i2 = r.f3607k;
                f.b.c.k.u.p.f fVar = gVar2.a;
                rVar2.b.b(fVar, gVar2.f3629d);
                f.b.c.k.u.p.f fVar2 = gVar2.a;
                Iterator it = ((HashSet) fVar2.b()).iterator();
                while (it.hasNext()) {
                    f.b.c.k.u.f fVar3 = (f.b.c.k.u.f) it.next();
                    f.b.c.k.u.i b2 = rVar2.c.b(fVar3);
                    f.b.c.k.u.m i3 = gVar2.f3630e.i(fVar3);
                    b.P0(i3 != null, "docVersions should contain every doc in the write.", new Object[0]);
                    if (b2 == null || b2.b.compareTo(i3) < 0) {
                        if (b2 != null) {
                            b.P0(b2.a.equals(fVar3), "applyToRemoteDocument: key %s doesn't match maybeDoc key %s", fVar3, b2.a);
                        }
                        int size = fVar2.f3628d.size();
                        List<h> list = gVar2.c;
                        b.P0(list.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(list.size()));
                        f.b.c.k.u.i iVar = b2;
                        for (int i4 = 0; i4 < size; i4++) {
                            e eVar = fVar2.f3628d.get(i4);
                            if (eVar.a.equals(fVar3)) {
                                iVar = eVar.b(iVar, list.get(i4));
                            }
                        }
                        if (iVar == null) {
                            b.P0(b2 == null, "Mutation batch %s applied to document %s resulted in null.", fVar2, b2);
                        } else {
                            rVar2.c.a(iVar, gVar2.b);
                        }
                    }
                }
                rVar2.b.j(fVar2);
                rVar2.b.c();
                g gVar3 = rVar2.f3608d;
                return gVar3.b(gVar3.a.d(fVar.b()));
            }
        }), null);
    }

    @Override // f.b.c.k.w.l0.c
    public f.b.c.g.a.f<f.b.c.k.u.f> d(int i2) {
        a aVar = this.f3520h.get(Integer.valueOf(i2));
        if (aVar != null && aVar.b) {
            return f.b.c.k.u.f.c.h(aVar.a);
        }
        f.b.c.g.a.f<f.b.c.k.u.f> fVar = f.b.c.k.u.f.c;
        if (this.f3516d.containsKey(Integer.valueOf(i2))) {
            for (x xVar : this.f3516d.get(Integer.valueOf(i2))) {
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
        a aVar = this.f3520h.get(Integer.valueOf(i2));
        f.b.c.k.u.f fVar = aVar != null ? aVar.a : null;
        if (fVar != null) {
            this.f3519g.remove(fVar);
            this.f3520h.remove(Integer.valueOf(i2));
            k();
            f.b.c.k.u.m mVar = f.b.c.k.u.m.c;
            b(new g0(mVar, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(fVar, new f.b.c.k.u.j(fVar, mVar, false)), Collections.singleton(fVar)));
            return;
        }
        r rVar = this.a;
        rVar.a.h("Release target", new Runnable(rVar, i2) { // from class: f.b.c.k.t.q
            public final r b;
            public final int c;

            {
                this.b = r1;
                this.c = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                r rVar2 = this.b;
                int i3 = this.c;
                d1 d1Var = rVar2.f3612h.get(i3);
                b.P0(d1Var != null, "Tried to release nonexistent target: %s", Integer.valueOf(i3));
                Iterator<f.b.c.k.u.f> it = rVar2.f3610f.g(i3).iterator();
                while (true) {
                    f.a aVar2 = (f.a) it;
                    if (aVar2.hasNext()) {
                        rVar2.a.c().i((f.b.c.k.u.f) aVar2.next());
                    } else {
                        rVar2.a.c().f(d1Var);
                        rVar2.f3612h.remove(i3);
                        rVar2.f3613i.remove(d1Var.a);
                        return;
                    }
                }
            }
        });
        for (x xVar : this.f3516d.get(Integer.valueOf(i2))) {
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
        this.f3516d.remove(Integer.valueOf(i2));
        f.b.c.g.a.f<f.b.c.k.u.f> d2 = this.f3521i.d(i2);
        this.f3521i.g(i2);
        Iterator<f.b.c.k.u.f> it2 = d2.iterator();
        while (true) {
            f.a aVar3 = (f.a) it2;
            if (aVar3.hasNext()) {
                f.b.c.k.u.f fVar2 = (f.b.c.k.u.f) aVar3.next();
                if (!this.f3521i.c(fVar2)) {
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
        f.b.a.c.b.o.b.P0(this.n != null, "Trying to call %s before setting callback", str);
    }

    public final void h(d<f.b.c.k.u.f, f.b.c.k.u.i> dVar, g0 g0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<x, z>> it = this.c.entrySet().iterator();
        if (!it.hasNext()) {
            ((g) this.n).a(arrayList);
            r rVar = this.a;
            rVar.a.h("notifyLocalViewChanges", new Runnable(rVar, arrayList2) { // from class: f.b.c.k.t.p
                public final r b;
                public final List c;

                {
                    this.b = r1;
                    this.c = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    r rVar2 = this.b;
                    List<s> list = this.c;
                    int i2 = r.f3607k;
                    for (s sVar : list) {
                        int i3 = sVar.a;
                        rVar2.f3610f.b(sVar.c, i3);
                        f.b.c.g.a.f<f.b.c.k.u.f> fVar = sVar.f3621d;
                        Iterator<f.b.c.k.u.f> it2 = fVar.iterator();
                        while (true) {
                            f.a aVar = (f.a) it2;
                            if (!aVar.hasNext()) {
                                break;
                            }
                            rVar2.a.c().i((f.b.c.k.u.f) aVar.next());
                        }
                        rVar2.f3610f.f(fVar, i3);
                        if (!sVar.b) {
                            d1 d1Var = rVar2.f3612h.get(i3);
                            b.P0(d1Var != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(i3));
                            f.b.c.k.u.m mVar = d1Var.f3596e;
                            rVar2.f3612h.put(i3, new d1(d1Var.a, d1Var.b, d1Var.c, d1Var.f3595d, mVar, mVar, d1Var.f3598g));
                        }
                    }
                }
            });
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
        Map<Integer, i<Void>> map = this.f3522j.get(this.m);
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
        while (!this.f3518f.isEmpty() && this.f3519g.size() < this.f3517e) {
            f.b.c.k.u.f remove = this.f3518f.remove();
            d0 d0Var = this.f3524l;
            int i2 = d0Var.a;
            d0Var.a = i2 + 2;
            this.f3520h.put(Integer.valueOf(i2), new a(remove));
            this.f3519g.put(remove, Integer.valueOf(i2));
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
                } else if (l0Var.f3660f.c()) {
                    l0Var.f(d1Var);
                }
            }
        }
    }

    public final void l(f.b.c.k.u.f fVar) {
        Integer num = this.f3519g.get(fVar);
        if (num != null) {
            l0 l0Var = this.b;
            int intValue = num.intValue();
            f.b.a.c.b.o.b.P0(l0Var.c.remove(Integer.valueOf(intValue)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(intValue));
            if (l0Var.f3660f.c()) {
                l0Var.e(intValue);
            }
            if (l0Var.c.isEmpty()) {
                if (l0Var.f3660f.c()) {
                    l0Var.f3660f.e();
                } else if (l0Var.f3659e) {
                    l0Var.f3658d.c(v.UNKNOWN);
                }
            }
            this.f3519g.remove(fVar);
            this.f3520h.remove(num);
            k();
        }
    }

    public final void m(int i2) {
        if (this.f3523k.containsKey(Integer.valueOf(i2))) {
            for (i<Void> iVar : this.f3523k.get(Integer.valueOf(i2))) {
                iVar.a.r(null);
            }
            this.f3523k.remove(Integer.valueOf(i2));
        }
    }
}
