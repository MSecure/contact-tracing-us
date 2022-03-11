package e.p;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import e.c.a.b.b;
import e.p.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class k extends g {
    public e.c.a.b.a<i, a> a = new e.c.a.b.a<>();
    public g.b b;
    public final WeakReference<j> c;

    /* renamed from: d  reason: collision with root package name */
    public int f1725d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1726e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1727f = false;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<g.b> f1728g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1729h;

    public static class a {
        public g.b a;
        public h b;

        public a(i iVar, g.b bVar) {
            h hVar;
            Map<Class<?>, Integer> map = n.a;
            boolean z = iVar instanceof h;
            boolean z2 = iVar instanceof d;
            if (z && z2) {
                hVar = new FullLifecycleObserverAdapter((d) iVar, (h) iVar);
            } else if (z2) {
                hVar = new FullLifecycleObserverAdapter((d) iVar, null);
            } else if (z) {
                hVar = (h) iVar;
            } else {
                Class<?> cls = iVar.getClass();
                if (n.c(cls) == 2) {
                    List<Constructor<? extends e>> list = n.b.get(cls);
                    if (list.size() == 1) {
                        hVar = new SingleGeneratedAdapterObserver(n.a(list.get(0), iVar));
                    } else {
                        e[] eVarArr = new e[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            eVarArr[i2] = n.a(list.get(i2), iVar);
                        }
                        hVar = new CompositeGeneratedAdaptersObserver(eVarArr);
                    }
                } else {
                    hVar = new ReflectiveGenericLifecycleObserver(iVar);
                }
            }
            this.b = hVar;
            this.a = bVar;
        }

        public void a(j jVar, g.a aVar) {
            g.b a2 = aVar.a();
            this.a = k.f(this.a, a2);
            this.b.d(jVar, aVar);
            this.a = a2;
        }
    }

    public k(j jVar) {
        this.c = new WeakReference<>(jVar);
        this.b = g.b.INITIALIZED;
        this.f1729h = true;
    }

    public static g.b f(g.b bVar, g.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // e.p.g
    public void a(i iVar) {
        j jVar;
        d("addObserver");
        g.b bVar = this.b;
        g.b bVar2 = g.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = g.b.INITIALIZED;
        }
        a aVar = new a(iVar, bVar2);
        if (this.a.k(iVar, aVar) == null && (jVar = this.c.get()) != null) {
            boolean z = this.f1725d != 0 || this.f1726e;
            g.b c2 = c(iVar);
            this.f1725d++;
            while (aVar.a.compareTo((Enum) c2) < 0 && this.a.f993f.containsKey(iVar)) {
                this.f1728g.add(aVar.a);
                g.a b2 = g.a.b(aVar.a);
                if (b2 != null) {
                    aVar.a(jVar, b2);
                    h();
                    c2 = c(iVar);
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("no event up from ");
                    h2.append(aVar.a);
                    throw new IllegalStateException(h2.toString());
                }
            }
            if (!z) {
                j();
            }
            this.f1725d--;
        }
    }

    @Override // e.p.g
    public void b(i iVar) {
        d("removeObserver");
        this.a.l(iVar);
    }

    public final g.b c(i iVar) {
        e.c.a.b.a<i, a> aVar = this.a;
        g.b bVar = null;
        b.c<K, V> cVar = aVar.f993f.containsKey(iVar) ? aVar.f993f.get(iVar).f997e : null;
        g.b bVar2 = cVar != null ? cVar.c.a : null;
        if (!this.f1728g.isEmpty()) {
            ArrayList<g.b> arrayList = this.f1728g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return f(f(this.b, bVar2), bVar);
    }

    public final void d(String str) {
        if (this.f1729h && !e.c.a.a.a.d().b()) {
            throw new IllegalStateException(f.a.a.a.a.c("Method ", str, " must be called on the main thread"));
        }
    }

    public void e(g.a aVar) {
        d("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(g.b bVar) {
        if (this.b != bVar) {
            this.b = bVar;
            if (this.f1726e || this.f1725d != 0) {
                this.f1727f = true;
                return;
            }
            this.f1726e = true;
            j();
            this.f1726e = false;
        }
    }

    public final void h() {
        ArrayList<g.b> arrayList = this.f1728g;
        arrayList.remove(arrayList.size() - 1);
    }

    public void i(g.b bVar) {
        d("setCurrentState");
        g(bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: e.c.a.b.a<e.p.i, e.p.k$a> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v13, resolved type: e.c.a.b.a<e.p.i, e.p.k$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        g.b bVar;
        j jVar = this.c.get();
        if (jVar != null) {
            while (true) {
                e.c.a.b.a<i, a> aVar = this.a;
                boolean z = true;
                if (!(aVar.f995e == 0 || (aVar.b.c.a == (bVar = aVar.c.c.a) && this.b == bVar))) {
                    z = false;
                }
                this.f1727f = false;
                if (!z) {
                    if (this.b.compareTo((Enum) aVar.b.c.a) < 0) {
                        e.c.a.b.a<i, a> aVar2 = this.a;
                        b.C0022b bVar2 = new b.C0022b(aVar2.c, aVar2.b);
                        aVar2.f994d.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.f1727f) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar3 = (a) entry.getValue();
                            while (aVar3.a.compareTo((Enum) this.b) > 0 && !this.f1727f && this.a.contains(entry.getKey())) {
                                int ordinal = aVar3.a.ordinal();
                                g.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : g.a.ON_PAUSE : g.a.ON_STOP : g.a.ON_DESTROY;
                                if (aVar4 != null) {
                                    this.f1728g.add(aVar4.a());
                                    aVar3.a(jVar, aVar4);
                                    h();
                                } else {
                                    StringBuilder h2 = f.a.a.a.a.h("no event down from ");
                                    h2.append(aVar3.a);
                                    throw new IllegalStateException(h2.toString());
                                }
                            }
                        }
                    }
                    b.c<K, V> cVar = this.a.c;
                    if (!this.f1727f && cVar != null && this.b.compareTo((Enum) cVar.c.a) > 0) {
                        b<K, V>.d i2 = this.a.i();
                        while (i2.hasNext() && !this.f1727f) {
                            Map.Entry entry2 = (Map.Entry) i2.next();
                            a aVar5 = (a) entry2.getValue();
                            while (aVar5.a.compareTo((Enum) this.b) < 0 && !this.f1727f && this.a.contains(entry2.getKey())) {
                                this.f1728g.add(aVar5.a);
                                g.a b2 = g.a.b(aVar5.a);
                                if (b2 != null) {
                                    aVar5.a(jVar, b2);
                                    h();
                                } else {
                                    StringBuilder h3 = f.a.a.a.a.h("no event up from ");
                                    h3.append(aVar5.a);
                                    throw new IllegalStateException(h3.toString());
                                }
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
