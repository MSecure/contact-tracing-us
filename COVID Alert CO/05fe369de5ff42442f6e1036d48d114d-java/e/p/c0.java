package e.p;

import androidx.lifecycle.LiveData;
import e.p.q;

public final class c0 implements t<X> {
    public LiveData<Y> a;
    public final /* synthetic */ e.c.a.c.a b;
    public final /* synthetic */ q c;

    public class a implements t<Y> {
        public a() {
        }

        @Override // e.p.t
        public void a(Y y) {
            c0.this.c.l(y);
        }
    }

    public c0(e.c.a.c.a aVar, q qVar) {
        this.b = aVar;
        this.c = qVar;
    }

    @Override // e.p.t
    public void a(X x) {
        q.a<?> l2;
        LiveData<Y> liveData = (LiveData) this.b.a(x);
        LiveData<Y> liveData2 = this.a;
        if (liveData2 != liveData) {
            if (!(liveData2 == null || (l2 = this.c.f1539l.l(liveData2)) == null)) {
                l2.a.k(l2);
            }
            this.a = liveData;
            if (liveData != null) {
                this.c.m(liveData, new a());
            }
        }
    }
}
