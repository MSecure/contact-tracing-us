package f.b.a.a.a.h;

import android.util.Log;
import e.p.j;
import e.p.r;
import java.util.concurrent.atomic.AtomicBoolean;

public class q<T> extends e.p.q<T> {

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f2096l = new AtomicBoolean(false);

    @Override // androidx.lifecycle.LiveData
    public void f(j jVar, r<? super T> rVar) {
        if (e()) {
            Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.f(jVar, new d(this, rVar));
    }

    @Override // androidx.lifecycle.LiveData, e.p.q
    public void j(T t) {
        this.f2096l.set(true);
        super.j(t);
    }

    @Override // androidx.lifecycle.LiveData, e.p.q
    public void l(T t) {
        this.f2096l.set(true);
        super.l(t);
    }
}
