package b.z.y.p.e;

import b.z.m;
import b.z.y.p.f.d;
import b.z.y.r.p;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T> implements b.z.y.p.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f2035a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public T f2036b;

    /* renamed from: c  reason: collision with root package name */
    public d<T> f2037c;

    /* renamed from: d  reason: collision with root package name */
    public a f2038d;

    public interface a {
    }

    public c(d<T> dVar) {
        this.f2037c = dVar;
    }

    @Override // b.z.y.p.a
    public void a(T t) {
        this.f2036b = t;
        e(this.f2038d, t);
    }

    public abstract boolean b(p pVar);

    public abstract boolean c(T t);

    public void d(Iterable<p> iterable) {
        this.f2035a.clear();
        for (p pVar : iterable) {
            if (b(pVar)) {
                this.f2035a.add(pVar.f2091a);
            }
        }
        if (this.f2035a.isEmpty()) {
            this.f2037c.b(this);
        } else {
            d<T> dVar = this.f2037c;
            synchronized (dVar.f2044c) {
                if (dVar.f2045d.add(this)) {
                    if (dVar.f2045d.size() == 1) {
                        dVar.f2046e = dVar.a();
                        m.c().a(d.f, String.format("%s: initial state = %s", dVar.getClass().getSimpleName(), dVar.f2046e), new Throwable[0]);
                        dVar.d();
                    }
                    a(dVar.f2046e);
                }
            }
        }
        e(this.f2038d, this.f2036b);
    }

    public final void e(a aVar, T t) {
        if (!(this.f2035a.isEmpty() || aVar == null)) {
            if (t == null || c(t)) {
                List<String> list = this.f2035a;
                b.z.y.p.d dVar = (b.z.y.p.d) aVar;
                synchronized (dVar.f2034c) {
                    if (dVar.f2032a != null) {
                        dVar.f2032a.e(list);
                    }
                }
                return;
            }
            List<String> list2 = this.f2035a;
            b.z.y.p.d dVar2 = (b.z.y.p.d) aVar;
            synchronized (dVar2.f2034c) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (dVar2.a(str)) {
                        m.c().a(b.z.y.p.d.f2031d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                if (dVar2.f2032a != null) {
                    dVar2.f2032a.c(arrayList);
                }
            }
        }
    }
}
