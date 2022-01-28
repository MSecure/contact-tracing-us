package c.b.a.a.g.e;

import b.e.a;
import b.e.c;
import b.e.g;
import b.e.h;
import b.x.t;
import c.b.a.a.d.k.d;
import c.b.a.a.d.k.o.k;
import c.b.a.a.d.k.o.m;
import c.b.a.a.d.k.o.s;
import c.b.a.a.j.b0;
import c.b.a.a.j.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class l3 {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<m3, l3> f3635d = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Set<k.a<?>>> f3636a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final Set<k.a<?>> f3637b = new c();

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Object> f3638c = new a();

    /* JADX WARN: Incorrect args count in method signature: (Lc/b/a/a/d/k/d<*>;Lc/b/a/a/d/k/a$d;)Lc/b/a/a/g/e/l3; */
    public static synchronized l3 b(d dVar) {
        l3 l3Var;
        synchronized (l3.class) {
            m3 m3Var = new m3(dVar);
            if (!(((h) f3635d).e(m3Var) >= 0)) {
                ((h) f3635d).put(m3Var, new l3());
            }
            l3Var = (l3) ((h) f3635d).getOrDefault(m3Var, null);
        }
        return l3Var;
    }

    public final synchronized <T> k<T> a(d<?> dVar, T t, String str) {
        k kVar;
        kVar = (k<L>) dVar.registerListener(t, str);
        k.a<L> aVar = kVar.f3020c;
        t.D(aVar, "Key must not be null");
        k.a<L> aVar2 = aVar;
        Set<k.a<?>> set = this.f3636a.get(str);
        if (set == null) {
            set = new c<>();
            this.f3636a.put(str, set);
        }
        set.add(aVar2);
        return kVar;
    }

    public final synchronized i<Boolean> c(d<?> dVar, k.a<?> aVar) {
        String str;
        this.f3637b.remove(aVar);
        Iterator<String> it = this.f3636a.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                str = null;
                break;
            }
            str = it.next();
            Set<k.a<?>> set = this.f3636a.get(str);
            if (set.contains(aVar)) {
                set.remove(aVar);
                break;
            }
        }
        if (str != null) {
            Iterator<Map.Entry<String, Object>> it2 = this.f3638c.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it2.next();
                if (t.Y(next.getValue(), str).equals(aVar)) {
                    this.f3638c.remove(next.getKey());
                    break;
                }
            }
        }
        return dVar.doUnregisterEventListener(aVar);
    }

    public final synchronized i<Void> d(d<?> dVar, m mVar, s sVar) {
        b0 b0Var;
        k.a<?> listenerKey = mVar.getListenerKey();
        t.D(listenerKey, "Key must not be null");
        this.f3637b.add(listenerKey);
        i<Void> doRegisterEventListener = dVar.doRegisterEventListener(mVar, sVar);
        n3 n3Var = new n3(this, dVar, listenerKey);
        b0Var = (b0) doRegisterEventListener;
        if (b0Var != null) {
            b0Var.c(c.b.a.a.j.k.f4110a, n3Var);
        } else {
            throw null;
        }
        return b0Var;
    }

    public final synchronized i<Void> e(d<?> dVar, String str) {
        c cVar = new c();
        Set<k.a<?>> set = this.f3636a.get(str);
        if (set == null) {
            return t.i3(cVar);
        }
        c cVar2 = new c();
        cVar2.addAll(set);
        Iterator it = cVar2.iterator();
        while (true) {
            g.a aVar = (g.a) it;
            if (aVar.hasNext()) {
                k.a<?> aVar2 = (k.a) aVar.next();
                if (this.f3637b.contains(aVar2)) {
                    cVar.add(c(dVar, aVar2));
                }
            } else {
                this.f3636a.remove(str);
                return t.i3(cVar);
            }
        }
    }

    public final Object f(String str) {
        if (!this.f3638c.containsKey(str)) {
            this.f3638c.put(str, new Object());
        }
        return this.f3638c.get(str);
    }
}
