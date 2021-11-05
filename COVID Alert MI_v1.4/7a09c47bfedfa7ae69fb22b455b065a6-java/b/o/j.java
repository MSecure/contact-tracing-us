package b.o;

import android.annotation.SuppressLint;
import b.c.a.b.b;
import b.o.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class j extends f {

    /* renamed from: a  reason: collision with root package name */
    public b.c.a.b.a<h, a> f2220a = new b.c.a.b.a<>();

    /* renamed from: b  reason: collision with root package name */
    public f.b f2221b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<i> f2222c;

    /* renamed from: d  reason: collision with root package name */
    public int f2223d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2224e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2225f = false;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<f.b> f2226g = new ArrayList<>();
    public final boolean h;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public f.b f2227a;

        /* renamed from: b  reason: collision with root package name */
        public g f2228b;

        public a(h hVar, f.b bVar) {
            this.f2228b = m.d(hVar);
            this.f2227a = bVar;
        }

        public void a(i iVar, f.a aVar) {
            f.b b2 = aVar.b();
            this.f2227a = j.f(this.f2227a, b2);
            this.f2228b.d(iVar, aVar);
            this.f2227a = b2;
        }
    }

    public j(i iVar) {
        this.f2222c = new WeakReference<>(iVar);
        this.f2221b = f.b.INITIALIZED;
        this.h = true;
    }

    public static f.b f(f.b bVar, f.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // b.o.f
    public void a(h hVar) {
        i iVar;
        d("addObserver");
        f.b bVar = this.f2221b;
        f.b bVar2 = f.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = f.b.INITIALIZED;
        }
        a aVar = new a(hVar, bVar2);
        if (this.f2220a.g(hVar, aVar) == null && (iVar = this.f2222c.get()) != null) {
            boolean z = this.f2223d != 0 || this.f2224e;
            f.b c2 = c(hVar);
            this.f2223d++;
            while (aVar.f2227a.compareTo((Enum) c2) < 0 && this.f2220a.f1348f.containsKey(hVar)) {
                this.f2226g.add(aVar.f2227a);
                f.a d2 = f.a.d(aVar.f2227a);
                if (d2 != null) {
                    aVar.a(iVar, d2);
                    h();
                    c2 = c(hVar);
                } else {
                    StringBuilder h2 = c.a.a.a.a.h("no event up from ");
                    h2.append(aVar.f2227a);
                    throw new IllegalStateException(h2.toString());
                }
            }
            if (!z) {
                i();
            }
            this.f2223d--;
        }
    }

    @Override // b.o.f
    public void b(h hVar) {
        d("removeObserver");
        this.f2220a.h(hVar);
    }

    public final f.b c(h hVar) {
        b.c.a.b.a<h, a> aVar = this.f2220a;
        f.b bVar = null;
        b.c<K, V> cVar = aVar.f1348f.containsKey(hVar) ? aVar.f1348f.get(hVar).f1356e : null;
        f.b bVar2 = cVar != null ? ((a) cVar.getValue()).f2227a : null;
        if (!this.f2226g.isEmpty()) {
            ArrayList<f.b> arrayList = this.f2226g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return f(f(this.f2221b, bVar2), bVar);
    }

    @SuppressLint({"RestrictedApi"})
    public final void d(String str) {
        if (this.h && !b.c.a.a.a.d().b()) {
            throw new IllegalStateException(c.a.a.a.a.c("Method ", str, " must be called on the main thread"));
        }
    }

    public void e(f.a aVar) {
        d("handleLifecycleEvent");
        g(aVar.b());
    }

    public final void g(f.b bVar) {
        if (this.f2221b != bVar) {
            this.f2221b = bVar;
            if (this.f2224e || this.f2223d != 0) {
                this.f2225f = true;
                return;
            }
            this.f2224e = true;
            i();
            this.f2224e = false;
        }
    }

    public final void h() {
        ArrayList<f.b> arrayList = this.f2226g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: b.c.a.b.a<b.o.h, b.o.j$a> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v13, resolved type: b.c.a.b.a<b.o.h, b.o.j$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void i() {
        f.b bVar;
        i iVar = this.f2222c.get();
        if (iVar != null) {
            while (true) {
                b.c.a.b.a<h, a> aVar = this.f2220a;
                boolean z = true;
                if (!(aVar.f1352e == 0 || (aVar.f1349b.f1354c.f2227a == (bVar = aVar.f1350c.f1354c.f2227a) && this.f2221b == bVar))) {
                    z = false;
                }
                this.f2225f = false;
                if (!z) {
                    if (this.f2221b.compareTo((Enum) this.f2220a.f1349b.f1354c.f2227a) < 0) {
                        b.c.a.b.a<h, a> aVar2 = this.f2220a;
                        b.C0021b bVar2 = new b.C0021b(aVar2.f1350c, aVar2.f1349b);
                        aVar2.f1351d.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.f2225f) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar3 = (a) entry.getValue();
                            while (aVar3.f2227a.compareTo((Enum) this.f2221b) > 0 && !this.f2225f && this.f2220a.contains(entry.getKey())) {
                                int ordinal = aVar3.f2227a.ordinal();
                                f.a aVar4 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : f.a.ON_PAUSE : f.a.ON_STOP : f.a.ON_DESTROY;
                                if (aVar4 != null) {
                                    this.f2226g.add(aVar4.b());
                                    aVar3.a(iVar, aVar4);
                                    h();
                                } else {
                                    StringBuilder h2 = c.a.a.a.a.h("no event down from ");
                                    h2.append(aVar3.f2227a);
                                    throw new IllegalStateException(h2.toString());
                                }
                            }
                        }
                    }
                    b.c<K, V> cVar = this.f2220a.f1350c;
                    if (!this.f2225f && cVar != null && this.f2221b.compareTo((Enum) cVar.f1354c.f2227a) > 0) {
                        b<K, V>.d c2 = this.f2220a.c();
                        while (c2.hasNext() && !this.f2225f) {
                            Map.Entry entry2 = (Map.Entry) c2.next();
                            a aVar5 = (a) entry2.getValue();
                            while (aVar5.f2227a.compareTo((Enum) this.f2221b) < 0 && !this.f2225f && this.f2220a.contains(entry2.getKey())) {
                                this.f2226g.add(aVar5.f2227a);
                                f.a d2 = f.a.d(aVar5.f2227a);
                                if (d2 != null) {
                                    aVar5.a(iVar, d2);
                                    h();
                                } else {
                                    StringBuilder h3 = c.a.a.a.a.h("no event up from ");
                                    h3.append(aVar5.f2227a);
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
