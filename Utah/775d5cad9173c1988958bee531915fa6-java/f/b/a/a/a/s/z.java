package f.b.a.a.a.s;

import e.q.l;
import e.q.s;
import e.q.t;
import f.b.a.a.a.s.d0.a;
import java.util.concurrent.atomic.AtomicBoolean;

public class z<T> extends s<T> {
    public static final a m = a.e("SingleLiveEvent");

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f2346l = new AtomicBoolean(false);

    @Override // androidx.lifecycle.LiveData
    public void f(l lVar, t<? super T> tVar) {
        if (e()) {
            m.g("Multiple observers registered but only one will be notified of changes.");
        }
        super.f(lVar, new g(this, tVar));
    }

    @Override // androidx.lifecycle.LiveData, e.q.s
    public void j(T t) {
        this.f2346l.set(true);
        super.j(t);
    }

    @Override // androidx.lifecycle.LiveData, e.q.s
    public void l(T t) {
        this.f2346l.set(true);
        super.l(t);
    }
}
