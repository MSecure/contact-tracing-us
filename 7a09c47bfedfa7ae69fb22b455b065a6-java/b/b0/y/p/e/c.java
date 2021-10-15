package b.b0.y.p.e;

import b.b0.m;
import b.b0.y.p.f.d;
import b.b0.y.r.p;
import java.util.ArrayList;
import java.util.List;

public abstract class c<T> implements b.b0.y.p.a<T> {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f1173a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public T f1174b;

    /* renamed from: c  reason: collision with root package name */
    public d<T> f1175c;

    /* renamed from: d  reason: collision with root package name */
    public a f1176d;

    public interface a {
    }

    public c(d<T> dVar) {
        this.f1175c = dVar;
    }

    @Override // b.b0.y.p.a
    public void a(T t) {
        this.f1174b = t;
        e(this.f1176d, t);
    }

    public abstract boolean b(p pVar);

    public abstract boolean c(T t);

    public void d(Iterable<p> iterable) {
        this.f1173a.clear();
        for (p pVar : iterable) {
            if (b(pVar)) {
                this.f1173a.add(pVar.f1234a);
            }
        }
        if (this.f1173a.isEmpty()) {
            this.f1175c.b(this);
        } else {
            d<T> dVar = this.f1175c;
            synchronized (dVar.f1184c) {
                if (dVar.f1185d.add(this)) {
                    if (dVar.f1185d.size() == 1) {
                        dVar.f1186e = dVar.a();
                        m.c().a(d.f1181f, String.format("%s: initial state = %s", dVar.getClass().getSimpleName(), dVar.f1186e), new Throwable[0]);
                        dVar.d();
                    }
                    a(dVar.f1186e);
                }
            }
        }
        e(this.f1176d, this.f1174b);
    }

    public final void e(a aVar, T t) {
        if (!(this.f1173a.isEmpty() || aVar == null)) {
            if (t == null || c(t)) {
                List<String> list = this.f1173a;
                b.b0.y.p.d dVar = (b.b0.y.p.d) aVar;
                synchronized (dVar.f1172c) {
                    if (dVar.f1170a != null) {
                        dVar.f1170a.e(list);
                    }
                }
                return;
            }
            List<String> list2 = this.f1173a;
            b.b0.y.p.d dVar2 = (b.b0.y.p.d) aVar;
            synchronized (dVar2.f1172c) {
                ArrayList arrayList = new ArrayList();
                for (String str : list2) {
                    if (dVar2.a(str)) {
                        m.c().a(b.b0.y.p.d.f1169d, String.format("Constraints met for %s", str), new Throwable[0]);
                        arrayList.add(str);
                    }
                }
                if (dVar2.f1170a != null) {
                    dVar2.f1170a.c(arrayList);
                }
            }
        }
    }
}
