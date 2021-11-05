package c.b.a.a.e.c;

import b.b.k.i;
import b.e.a;
import b.e.c;
import b.e.g;
import b.e.h;
import c.b.a.a.c.k.d;
import c.b.a.a.c.k.o.k;
import c.b.a.a.c.k.o.m;
import c.b.a.a.c.k.o.r;
import c.b.a.a.g.a0;
import c.b.a.a.g.j;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class l3 {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<m3, l3> f2645d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<k.a<?>>> f2646a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Set<k.a<?>> f2647b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f2648c = new a();

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/c/k/d<*>;Lc/b/a/a/c/k/a$d;)Lc/b/a/a/e/c/l3; */
    public static synchronized l3 b(d dVar) {
        l3 l3Var;
        synchronized (l3.class) {
            m3 m3Var = new m3(dVar);
            if (!(((h) f2645d).e(m3Var) >= 0)) {
                ((h) f2645d).put(m3Var, new l3());
            }
            l3Var = (l3) ((h) f2645d).getOrDefault(m3Var, null);
        }
        return l3Var;
    }

    public final synchronized <T> k<T> a(d<?> dVar, T t, String str) {
        k kVar;
        kVar = (k<L>) dVar.registerListener(t, str);
        k.a<L> aVar = kVar.f2377c;
        i.j.t(aVar, "Key must not be null");
        k.a<L> aVar2 = aVar;
        Set<k.a<?>> set = this.f2646a.get(str);
        if (set == null) {
            set = new c<>();
            this.f2646a.put(str, set);
        }
        set.add(aVar2);
        return kVar;
    }

    public final synchronized c.b.a.a.g.h<Boolean> c(d<?> dVar, k.a<?> aVar) {
        String str;
        this.f2647b.remove(aVar);
        Iterator<String> it = this.f2646a.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = it.next();
            Set<k.a<?>> set = this.f2646a.get(str);
            if (set.contains(aVar)) {
                set.remove(aVar);
                break;
            }
        }
        if (str != null) {
            Iterator<Map.Entry<String, Object>> it2 = this.f2648c.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it2.next();
                if (i.j.L(next.getValue(), str).equals(aVar)) {
                    this.f2648c.remove(next.getKey());
                    break;
                }
            }
        }
        return dVar.doUnregisterEventListener(aVar);
    }

    public final synchronized c.b.a.a.g.h<Void> d(d<?> dVar, m mVar, r rVar) {
        a0 a0Var;
        k.a<?> listenerKey = mVar.getListenerKey();
        i.j.t(listenerKey, "Key must not be null");
        this.f2647b.add(listenerKey);
        c.b.a.a.g.h<Void> doRegisterEventListener = dVar.doRegisterEventListener(mVar, rVar);
        n3 n3Var = new n3(this, dVar, listenerKey);
        a0Var = (a0) doRegisterEventListener;
        if (a0Var != null) {
            a0Var.c(j.f2857a, n3Var);
        } else {
            throw null;
        }
        return a0Var;
    }

    public final synchronized c.b.a.a.g.h<Void> e(d<?> dVar, String str) {
        c cVar = new c();
        Set<k.a<?>> set = this.f2646a.get(str);
        if (set == null) {
            return c.b.a.a.c.n.c.z2(cVar);
        }
        c cVar2 = new c();
        cVar2.addAll(set);
        Iterator it = cVar2.iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                k.a<?> aVar2 = (k.a) aVar.next();
                if (this.f2647b.contains(aVar2)) {
                    cVar.add(c(dVar, aVar2));
                }
            } else {
                this.f2646a.remove(str);
                return c.b.a.a.c.n.c.z2(cVar);
            }
        }
    }

    public final Object f(String str) {
        if (!this.f2648c.containsKey(str)) {
            this.f2648c.put(str, new Object());
        }
        return this.f2648c.get(str);
    }
}
