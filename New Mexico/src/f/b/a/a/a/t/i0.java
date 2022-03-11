package f.b.a.a.a.t;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import e.r.l;
import e.r.q;
import e.r.t;
/* loaded from: classes.dex */
public class i0<S, T> extends q<Pair<S, T>> {
    public S m = null;
    public T n = null;

    /* loaded from: classes.dex */
    public interface a<S, T> {
        void a(S s, T t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i0(LiveData<S> liveData, LiveData<T> liveData2) {
        m(liveData, new t() { // from class: f.b.a.a.a.t.n
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.r.t
            public final void a(Object obj) {
                i0 i0Var = i0.this;
                i0Var.m = obj;
                T t = i0Var.n;
                if (obj != 0 && t != 0) {
                    i0Var.l(Pair.create(obj, t));
                }
            }
        });
        m(liveData2, new t() { // from class: f.b.a.a.a.t.m
            /* JADX WARN: Multi-variable type inference failed */
            @Override // e.r.t
            public final void a(Object obj) {
                i0 i0Var = i0.this;
                i0Var.n = obj;
                S s = i0Var.m;
                if (s != 0 && obj != 0) {
                    i0Var.l(Pair.create(s, obj));
                }
            }
        });
    }

    public void n(l lVar, a<? super S, ? super T> aVar) {
        f(lVar, new l(aVar));
    }
}
