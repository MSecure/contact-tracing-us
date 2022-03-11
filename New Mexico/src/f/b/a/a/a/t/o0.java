package f.b.a.a.a.t;

import androidx.lifecycle.LiveData;
import e.r.q;
import e.r.t;
import j.e;
/* loaded from: classes.dex */
public class o0<R, S, T> extends q<e<R, S, T>> {
    public R m = null;
    public S n = null;
    public T o = null;

    /* loaded from: classes.dex */
    public interface a<R, S, T> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(LiveData<R> liveData, LiveData<S> liveData2, LiveData<T> liveData3) {
        m(liveData, new t() { // from class: f.b.a.a.a.t.t
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                o0Var.m = obj;
                o0Var.n();
            }
        });
        m(liveData2, new t() { // from class: f.b.a.a.a.t.s
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                o0Var.n = obj;
                o0Var.n();
            }
        });
        m(liveData3, new t() { // from class: f.b.a.a.a.t.v
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.r.t
            public final void a(Object obj) {
                o0 o0Var = o0.this;
                o0Var.o = obj;
                o0Var.n();
            }
        });
    }

    public final void n() {
        R r = this.m;
        S s = this.n;
        T t = this.o;
        if (r != null && s != null && t != null) {
            l(new e(r, s, t));
        }
    }
}
