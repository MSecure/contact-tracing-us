package h.a.n1;

import f.b.b.a.k;
import h.a.a;
import h.a.c1;
import h.a.h0;
import h.a.n;
import h.a.o;
import h.a.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class a extends h0 {

    /* renamed from: g  reason: collision with root package name */
    public static final a.c<d<o>> f4268g = new a.c<>("state-info");

    /* renamed from: h  reason: collision with root package name */
    public static final c1 f4269h = c1.f3832f.g("no subchannels ready");
    public final h0.d b;
    public final Map<v, h0.h> c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Random f4270d;

    /* renamed from: e  reason: collision with root package name */
    public n f4271e;

    /* renamed from: f  reason: collision with root package name */
    public e f4272f = new b(f4269h);

    /* renamed from: h.a.n1.a$a  reason: collision with other inner class name */
    public class C0151a implements h0.j {
        public final /* synthetic */ h0.h a;

        public C0151a(h0.h hVar) {
            this.a = hVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: h.a.o */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.a.h0.j
        public void a(o oVar) {
            a aVar = a.this;
            h0.h hVar = this.a;
            Map<v, h0.h> map = aVar.c;
            List<v> a2 = hVar.a();
            boolean z = true;
            if (a2.size() != 1) {
                z = false;
            }
            f.b.a.c.b.o.b.G(z, "%s does not have exactly one group", a2);
            if (map.get(new v(a2.get(0).a, h.a.a.b)) == hVar) {
                if (oVar.a == n.IDLE) {
                    hVar.d();
                }
                a.e(hVar).a = oVar;
                aVar.g();
            }
        }
    }

    public static final class b extends e {
        public final c1 a;

        public b(c1 c1Var) {
            super(null);
            f.b.a.c.b.o.b.z(c1Var, "status");
            this.a = c1Var;
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            if (this.a.e()) {
                return h0.e.f3855e;
            }
            return h0.e.a(this.a);
        }

        @Override // h.a.n1.a.e
        public boolean b(e eVar) {
            if (eVar instanceof b) {
                b bVar = (b) eVar;
                if (f.b.a.c.b.o.b.m0(this.a, bVar.a) || (this.a.e() && bVar.a.e())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            k kVar = new k(b.class.getSimpleName(), null);
            kVar.d("status", this.a);
            return kVar.toString();
        }
    }

    public static final class c extends e {
        public static final AtomicIntegerFieldUpdater<c> c = AtomicIntegerFieldUpdater.newUpdater(c.class, "b");
        public final List<h0.h> a;
        private volatile int b;

        public c(List<h0.h> list, int i2) {
            super(null);
            f.b.a.c.b.o.b.o(!list.isEmpty(), "empty list");
            this.a = list;
            this.b = i2 - 1;
        }

        @Override // h.a.h0.i
        public h0.e a(h0.f fVar) {
            int size = this.a.size();
            AtomicIntegerFieldUpdater<c> atomicIntegerFieldUpdater = c;
            int incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                int i2 = incrementAndGet % size;
                atomicIntegerFieldUpdater.compareAndSet(this, incrementAndGet, i2);
                incrementAndGet = i2;
            }
            return h0.e.b(this.a.get(incrementAndGet));
        }

        @Override // h.a.n1.a.e
        public boolean b(e eVar) {
            if (!(eVar instanceof c)) {
                return false;
            }
            c cVar = (c) eVar;
            return cVar == this || (this.a.size() == cVar.a.size() && new HashSet(this.a).containsAll(cVar.a));
        }

        public String toString() {
            k kVar = new k(c.class.getSimpleName(), null);
            kVar.d("list", this.a);
            return kVar.toString();
        }
    }

    public static final class d<T> {
        public T a;

        public d(T t) {
            this.a = t;
        }
    }

    public static abstract class e extends h0.i {
        public e(C0151a aVar) {
        }

        public abstract boolean b(e eVar);
    }

    public a(h0.d dVar) {
        f.b.a.c.b.o.b.z(dVar, "helper");
        this.b = dVar;
        this.f4270d = new Random();
    }

    public static d<o> e(h0.h hVar) {
        h.a.a b2 = hVar.b();
        Object obj = b2.a.get(f4268g);
        f.b.a.c.b.o.b.z(obj, "STATE_INFO");
        return (d) obj;
    }

    @Override // h.a.h0
    public void a(c1 c1Var) {
        n nVar = n.TRANSIENT_FAILURE;
        e eVar = this.f4272f;
        if (!(eVar instanceof c)) {
            eVar = new b(c1Var);
        }
        h(nVar, eVar);
    }

    @Override // h.a.h0
    public void b(h0.g gVar) {
        List<v> list = gVar.a;
        Set<v> keySet = this.c.keySet();
        HashMap hashMap = new HashMap(list.size() * 2);
        for (v vVar : list) {
            hashMap.put(new v(vVar.a, h.a.a.b), vVar);
        }
        Set keySet2 = hashMap.keySet();
        HashSet hashSet = new HashSet(keySet);
        hashSet.removeAll(keySet2);
        for (Map.Entry entry : hashMap.entrySet()) {
            v vVar2 = (v) entry.getKey();
            v vVar3 = (v) entry.getValue();
            h0.h hVar = this.c.get(vVar2);
            if (hVar != null) {
                hVar.g(Collections.singletonList(vVar3));
            } else {
                a.b a = h.a.a.a();
                a.b(f4268g, new d(o.a(n.IDLE)));
                h0.d dVar = this.b;
                h0.b.a aVar = new h0.b.a();
                aVar.a = Collections.singletonList(vVar3);
                h.a.a a2 = a.a();
                f.b.a.c.b.o.b.z(a2, "attrs");
                aVar.b = a2;
                h0.h a3 = dVar.a(new h0.b(aVar.a, a2, aVar.c, null));
                f.b.a.c.b.o.b.z(a3, "subchannel");
                a3.f(new C0151a(a3));
                this.c.put(vVar2, a3);
                a3.d();
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(this.c.remove((v) it.next()));
        }
        g();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            h0.h hVar2 = (h0.h) it2.next();
            hVar2.e();
            e(hVar2).a = (T) o.a(n.SHUTDOWN);
        }
    }

    @Override // h.a.h0
    public void d() {
        for (h0.h hVar : f()) {
            hVar.e();
            e(hVar).a = (T) o.a(n.SHUTDOWN);
        }
    }

    public Collection<h0.h> f() {
        return this.c.values();
    }

    public final void g() {
        boolean z;
        n nVar = n.CONNECTING;
        n nVar2 = n.READY;
        Collection<h0.h> f2 = f();
        ArrayList arrayList = new ArrayList(f2.size());
        Iterator<h0.h> it = f2.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            h0.h next = it.next();
            if (e(next).a.a == nVar2) {
                z = true;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            c1 c1Var = f4269h;
            for (h0.h hVar : f()) {
                T t = e(hVar).a;
                n nVar3 = t.a;
                if (nVar3 == nVar || nVar3 == n.IDLE) {
                    z = true;
                }
                if (c1Var == f4269h || !c1Var.e()) {
                    c1Var = t.b;
                }
            }
            if (!z) {
                nVar = n.TRANSIENT_FAILURE;
            }
            h(nVar, new b(c1Var));
            return;
        }
        h(nVar2, new c(arrayList, this.f4270d.nextInt(arrayList.size())));
    }

    public final void h(n nVar, e eVar) {
        if (nVar != this.f4271e || !eVar.b(this.f4272f)) {
            this.b.d(nVar, eVar);
            this.f4271e = nVar;
            this.f4272f = eVar;
        }
    }
}
