package e.r;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import e.c.a.b.b;
import e.r.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends h {
    public final WeakReference<l> c;
    public e.c.a.b.a<k, a> a = new e.c.a.b.a<>();

    /* renamed from: d */
    public int f1894d = 0;

    /* renamed from: e */
    public boolean f1895e = false;

    /* renamed from: f */
    public boolean f1896f = false;

    /* renamed from: g */
    public ArrayList<h.b> f1897g = new ArrayList<>();
    public h.b b = h.b.INITIALIZED;

    /* renamed from: h */
    public final boolean f1898h = true;

    /* loaded from: classes.dex */
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
            h.b a = aVar.a();
            this.a = m.f(this.a, a);
            this.b.d(lVar, aVar);
            this.a = a;
        }
    }

    public m(l lVar) {
        this.c = new WeakReference<>(lVar);
    }

    public static h.b f(h.b bVar, h.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // e.r.h
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
            boolean z = this.f1894d != 0 || this.f1895e;
            h.b c = c(kVar);
            this.f1894d++;
            while (aVar.a.compareTo(c) < 0 && this.a.f1074f.containsKey(kVar)) {
                this.f1897g.add(aVar.a);
                h.a b = h.a.b(aVar.a);
                if (b != null) {
                    aVar.a(lVar, b);
                    h();
                    c = c(kVar);
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("no event up from ");
                    h2.append(aVar.a);
                    throw new IllegalStateException(h2.toString());
                }
            }
            if (!z) {
                j();
            }
            this.f1894d--;
        }
    }

    @Override // e.r.h
    public void b(k kVar) {
        d("removeObserver");
        this.a.l(kVar);
    }

    public final h.b c(k kVar) {
        e.c.a.b.a<k, a> aVar = this.a;
        h.b bVar = null;
        b.c<k, a> cVar = aVar.f1074f.containsKey(kVar) ? aVar.f1074f.get(kVar).f1078e : null;
        h.b bVar2 = cVar != null ? cVar.c.a : null;
        if (!this.f1897g.isEmpty()) {
            ArrayList<h.b> arrayList = this.f1897g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return f(f(this.b, bVar2), bVar);
    }

    public final void d(String str) {
        if (this.f1898h && !e.c.a.a.a.d().b()) {
            throw new IllegalStateException(f.a.a.a.a.c("Method ", str, " must be called on the main thread"));
        }
    }

    public void e(h.a aVar) {
        d("handleLifecycleEvent");
        g(aVar.a());
    }

    public final void g(h.b bVar) {
        if (this.b != bVar) {
            this.b = bVar;
            if (this.f1895e || this.f1894d != 0) {
                this.f1896f = true;
                return;
            }
            this.f1895e = true;
            j();
            this.f1895e = false;
        }
    }

    public final void h() {
        ArrayList<h.b> arrayList = this.f1897g;
        arrayList.remove(arrayList.size() - 1);
    }

    public void i(h.b bVar) {
        d("setCurrentState");
        g(bVar);
    }

    public final void j() {
        h.b bVar;
        l lVar = this.c.get();
        if (lVar != null) {
            while (true) {
                e.c.a.b.a<k, a> aVar = this.a;
                boolean z = true;
                if (!(aVar.f1076e == 0 || (aVar.b.c.a == (bVar = aVar.c.c.a) && this.b == bVar))) {
                    z = false;
                }
                this.f1896f = false;
                if (!z) {
                    if (this.b.compareTo(aVar.b.c.a) < 0) {
                        e.c.a.b.a<k, a> aVar2 = this.a;
                        b.C0022b bVar2 = new b.C0022b(aVar2.c, aVar2.b);
                        aVar2.f1075d.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.f1896f) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar3 = (a) entry.getValue();
                            while (aVar3.a.compareTo(this.b) > 0 && !this.f1896f && this.a.contains((k) entry.getKey())) {
                                int ordinal = aVar3.a.ordinal();
                                h.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : h.a.ON_PAUSE : h.a.ON_STOP : h.a.ON_DESTROY;
                                if (aVar4 != null) {
                                    this.f1897g.add(aVar4.a());
                                    aVar3.a(lVar, aVar4);
                                    h();
                                } else {
                                    StringBuilder h2 = f.a.a.a.a.h("no event down from ");
                                    h2.append(aVar3.a);
                                    throw new IllegalStateException(h2.toString());
                                }
                            }
                        }
                    }
                    b.c<k, a> cVar = this.a.c;
                    if (!this.f1896f && cVar != null && this.b.compareTo(cVar.c.a) > 0) {
                        b<k, a>.d i2 = this.a.i();
                        while (i2.hasNext() && !this.f1896f) {
                            Map.Entry entry2 = (Map.Entry) i2.next();
                            a aVar5 = (a) entry2.getValue();
                            while (aVar5.a.compareTo(this.b) < 0 && !this.f1896f && this.a.contains((k) entry2.getKey())) {
                                this.f1897g.add(aVar5.a);
                                h.a b = h.a.b(aVar5.a);
                                if (b != null) {
                                    aVar5.a(lVar, b);
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
