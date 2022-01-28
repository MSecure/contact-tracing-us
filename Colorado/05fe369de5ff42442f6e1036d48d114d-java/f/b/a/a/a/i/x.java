package f.b.a.a.a.i;

import android.util.Pair;
import androidx.lifecycle.LiveData;
import e.p.l;
import e.p.q;

public class x<S, T> extends q<Pair<S, T>> {
    public S m = null;
    public T n = null;

    public interface a<S, T> {
        void a(S s, T t);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: androidx.lifecycle.LiveData<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public x(LiveData<S> liveData, LiveData<T> liveData2) {
        m(liveData, new e(this));
        m(liveData2, new d(this));
    }

    public void n(l lVar, a<? super S, ? super T> aVar) {
        f(lVar, new c(aVar));
    }
}
