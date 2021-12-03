package f.b.a.a.a.s;

import androidx.lifecycle.LiveData;
import e.q.q;
import j.e;

public class c0<R, S, T> extends q<e<R, S, T>> {
    public R m = null;
    public S n = null;
    public T o = null;

    public interface a<R, S, T> {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: androidx.lifecycle.LiveData<R> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: androidx.lifecycle.LiveData<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public c0(LiveData<R> liveData, LiveData<S> liveData2, LiveData<T> liveData3) {
        m(liveData, new k(this));
        m(liveData2, new j(this));
        m(liveData3, new m(this));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: f.b.a.a.a.s.c0<R, S, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void n() {
        R r = this.m;
        S s = this.n;
        T t = this.o;
        if (r != null && s != null && t != null) {
            l(new e(r, s, t));
        }
    }
}
