package f.b.a.a.a.t;

import e.r.l;
import e.r.s;
import e.r.t;
import f.b.a.a.a.t.p0.a;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class l0<T> extends s<T> {
    public static final a m = a.e("SingleLiveEvent");

    /* renamed from: l */
    public final AtomicBoolean f2393l = new AtomicBoolean(false);

    @Override // androidx.lifecycle.LiveData
    public void f(l lVar, t<? super T> tVar) {
        if (e()) {
            m.g("Multiple observers registered but only one will be notified of changes.");
        }
        super.f(lVar, new t(tVar) { // from class: f.b.a.a.a.t.p
            public final /* synthetic */ t b;

            {
                this.b = r2;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                l0 l0Var = l0.this;
                t tVar2 = this.b;
                if (l0Var.f2393l.compareAndSet(true, false)) {
                    tVar2.a(obj);
                }
            }
        });
    }

    @Override // e.r.s, androidx.lifecycle.LiveData
    public void j(T t) {
        this.f2393l.set(true);
        super.j(t);
    }

    @Override // e.r.s, androidx.lifecycle.LiveData
    public void l(T t) {
        this.f2393l.set(true);
        super.l(t);
    }
}
