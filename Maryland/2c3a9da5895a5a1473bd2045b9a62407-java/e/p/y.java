package e.p;

import androidx.lifecycle.LiveData;
import e.p.o;

public final class y implements r<X> {
    public LiveData<Y> a;
    public final /* synthetic */ e.c.a.c.a b;
    public final /* synthetic */ o c;

    public class a implements r<Y> {
        public a() {
        }

        @Override // e.p.r
        public void a(Y y) {
            y.this.c.l(y);
        }
    }

    public y(e.c.a.c.a aVar, o oVar) {
        this.b = aVar;
        this.c = oVar;
    }

    @Override // e.p.r
    public void a(X x) {
        o.a<?> l2;
        LiveData<Y> liveData = (LiveData) this.b.a(x);
        LiveData<Y> liveData2 = this.a;
        if (liveData2 != liveData) {
            if (!(liveData2 == null || (l2 = this.c.f1730l.l(liveData2)) == null)) {
                l2.a.k(l2);
            }
            this.a = liveData;
            if (liveData != null) {
                this.c.m(liveData, new a());
            }
        }
    }
}
