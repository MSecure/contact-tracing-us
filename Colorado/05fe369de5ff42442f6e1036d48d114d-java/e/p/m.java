package e.p;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import e.c.a.b.b;
import e.p.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class m extends h {
    public e.c.a.b.a<k, a> a = new e.c.a.b.a<>();
    public h.b b;
    public final WeakReference<l> c;

    /* renamed from: d  reason: collision with root package name */
    public int f1534d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1535e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1536f = false;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<h.b> f1537g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public final boolean f1538h;

    public static class a {
        public h.b a;
        public j b;

        public a(k kVar, h.b bVar) {
            j jVar;
            Map<Class<?>, Integer> map = p.a;
            boolean z = kVar instanceof j;
            boolean z2 = kVar instanceof e;
            if (z && z2) {
                jVar = new FullLifecycleObserverAdapter((e) kVar, (j) kVar);
            } else if (z2) {
                jVar = new FullLifecycleObserverAdapter((e) kVar, null);
            } else if (z) {
                jVar = (j) kVar;
            } else {
                Class<?> cls = kVar.getClass();
                if (p.c(cls) == 2) {
                    List<Constructor<? extends f>> list = p.b.get(cls);
                    if (list.size() == 1) {
                        jVar = new SingleGeneratedAdapterObserver(p.a(list.get(0), kVar));
                    } else {
                        f[] fVarArr = new f[list.size()];
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            fVarArr[i2] = p.a(list.get(i2), kVar);
                        }
                        jVar = new CompositeGeneratedAdaptersObserver(fVarArr);
                    }
                } else {
                    jVar = new ReflectiveGenericLifecycleObserver(kVar);
                }
            }
            this.b = jVar;
            this.a = bVar;
        }

        public void a(l lVar, h.a aVar) {
            h.b a2 = aVar.a();
            this.a = m.f(this.a, a2);
            this.b.d(lVar, aVar);
            this.a = a2;
        }
    }

    public m(l lVar) {
        this.c = new WeakReference<>(lVar);
        this.b = h.b.INITIALIZED;
        this.f1538h = true;
    }

    public static h.b f(h.b bVar, h.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // e.p.h
    public void a(k kVar) {
        l lVar;
        d("addObserver");
        h.b bVar = this.b;
        h.b bVar2 = h.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = h.b.INITIALIZED;
        }
        a aVar = new a(kVar, bVar2);
        if (this.a.k(kVar, aVar) == null && (lVar = this.c.get()) != null) {
            boolean z = this.f1534d != 0 || this.f1535e;
            h.b c2 = c(kVar);
            this.f1534d++;
            while (aVar.a.compareTo((Enum) c2) < 0 && this.a.f974f.containsKey(kVar)) {
                this.f1537g.add(aVar.a);
                h.a b2 = h.a.b(aVar.a);
                if (b2 != null) {
                    aVar.a(lVar, b2);
                    h();
                    c2 = c(kVar);
                } else {
                    StringBuilder i2 = f.a.a.a.a.i("no event up from ");
                    i2.append(aVar.a);
                    throw new IllegalStateException(i2.toString());
                }
            }
            if (!z) {
                j();
            }
            this.f1534d--;
        }
    }

    @Override // e.p.h
    public void b(k kVar) {
        d("removeObserver");
        this.a.l(kVar);
    }

    public final h.b c(k kVar) {
        e.c.a.b.a<k, a> aVar = this.a;
        h.b bVar = null;
        b.c<K, V> cVar = aVar.f974f.containsKey(kVar) ? aVar.f974f.get(kVar).f978e : null;
        h.b bVar2 = cVar != null ? cVar.c.a : null;
        if (!this.f1537g.isEmpty()) {
            ArrayList<h.b> arrayList = this.f1537g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return f(f(this.b, bVar2), bVar);
    }

    public final void d(String str) {
        if (this.f1538h && !e.c.a.a.a.d().b()) {
            throw new IllegalStateException(f.a.a.a.a.d("Method ", str, " must be called on the main thread"));
        }
    }

    public void e(h.a aVar) {
        d("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(h.b bVar) {
        if (this.b != bVar) {
            this.b = bVar;
            if (this.f1535e || this.f1534d != 0) {
                this.f1536f = true;
                return;
            }
            this.f1535e = true;
            j();
            this.f1535e = false;
        }
    }

    public final void h() {
        ArrayList<h.b> arrayList = this.f1537g;
        arrayList.remove(arrayList.size() - 1);
    }

    public void i(h.b bVar) {
        d("setCurrentState");
        g(bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: e.c.a.b.a<e.p.k, e.p.m$a> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v13, resolved type: e.c.a.b.a<e.p.k, e.p.m$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        h.b bVar;
        l lVar = this.c.get();
        if (lVar != null) {
            while (true) {
                e.c.a.b.a<k, a> aVar = this.a;
                boolean z = true;
                if (!(aVar.f976e == 0 || (aVar.b.c.a == (bVar = aVar.c.c.a) && this.b == bVar))) {
                    z = false;
                }
                this.f1536f = false;
                if (!z) {
                    if (this.b.compareTo((Enum) aVar.b.c.a) < 0) {
                        e.c.a.b.a<k, a> aVar2 = this.a;
                        b.C0021b bVar2 = new b.C0021b(aVar2.c, aVar2.b);
                        aVar2.f975d.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.f1536f) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar3 = (a) entry.getValue();
                            while (aVar3.a.compareTo((Enum) this.b) > 0 && !this.f1536f && this.a.contains(entry.getKey())) {
                                int ordinal = aVar3.a.ordinal();
                                h.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : h.a.ON_PAUSE : h.a.ON_STOP : h.a.ON_DESTROY;
                                if (aVar4 != null) {
                                    this.f1537g.add(aVar4.a());
                                    aVar3.a(lVar, aVar4);
                                    h();
                                } else {
                                    StringBuilder i2 = f.a.a.a.a.i("no event down from ");
                                    i2.append(aVar3.a);
                                    throw new IllegalStateException(i2.toString());
                                }
                            }
                        }
                    }
                    b.c<K, V> cVar = this.a.c;
                    if (!this.f1536f && cVar != null && this.b.compareTo((Enum) cVar.c.a) > 0) {
                        b<K, V>.d i3 = this.a.i();
                        while (i3.hasNext() && !this.f1536f) {
                            Map.Entry entry2 = (Map.Entry) i3.next();
                            a aVar5 = (a) entry2.getValue();
                            while (aVar5.a.compareTo((Enum) this.b) < 0 && !this.f1536f && this.a.contains(entry2.getKey())) {
                                this.f1537g.add(aVar5.a);
                                h.a b2 = h.a.b(aVar5.a);
                                if (b2 != null) {
                                    aVar5.a(lVar, b2);
                                    h();
                                } else {
                                    StringBuilder i4 = f.a.a.a.a.i("no event up from ");
                                    i4.append(aVar5.a);
                                    throw new IllegalStateException(i4.toString());
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
