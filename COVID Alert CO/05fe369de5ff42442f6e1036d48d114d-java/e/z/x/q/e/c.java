package e.z.x.q.e;

import e.z.l;
import e.z.x.q.f.d;
import e.z.x.s.o;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T> implements e.z.x.q.a<T> {
    public final List<String> a = new ArrayList();
    public T b;
    public d<T> c;

    /* renamed from: d  reason: collision with root package name */
    public a f1960d;

    public interface a {
    }

    public c(d<T> dVar) {
        this.c = dVar;
    }

    @Override // e.z.x.q.a
    public void a(T t) {
        this.b = t;
        e(this.f1960d, t);
    }

    public abstract boolean b(o oVar);

    public abstract boolean c(T t);

    public void d(Iterable<o> iterable) {
        this.a.clear();
        for (o oVar : iterable) {
            if (b(oVar)) {
                this.a.add(oVar.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.b(this);
        } else {
            d<T> dVar = this.c;
            synchronized (dVar.c) {
                if (dVar.f1968d.add(this)) {
                    if (dVar.f1968d.size() == 1) {
                        dVar.f1969e = dVar.a();
                        l.c().a(d.f1967f, String.format("%s: initial state = %s", dVar.getClass().getSimpleName(), dVar.f1969e), new Throwable[0]);
                        dVar.d();
                    }
                    a(dVar.f1969e);
                }
            }
        }
        e(this.f1960d, this.b);
    }

    public final void e(a aVar, T t) {
        if (!(this.a.isEmpty() || aVar == null)) {
            if (t == null || c(t)) {
                List<String> list = this.a;
                e.z.x.q.d dVar = (e.z.x.q.d) aVar;
                synchronized (dVar.c) {
                    e.z.x.q.c cVar = dVar.a;
                    if (cVar != null) {
                        cVar.e(list);
                    }
                }
                return;
            }
            List<String> list2 = this.a;
            e.z.x.q.d dVar2 = (e.z.x.q.d) aVar;
            synchronized (dVar2.c) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (dVar2.a(str)) {
                        l.c().a(e.z.x.q.d.f1959d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                e.z.x.q.c cVar2 = dVar2.a;
                if (cVar2 != null) {
                    cVar2.c(arrayList);
                }
            }
        }
    }
}
