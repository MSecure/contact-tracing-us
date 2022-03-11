package e.r;

import androidx.lifecycle.LiveData;
import e.r.q;
/* loaded from: classes.dex */
public final class c0 implements t<X> {
    public LiveData<Y> a;
    public final /* synthetic */ e.c.a.c.a b;
    public final /* synthetic */ q c;

    /* loaded from: classes.dex */
    public class a implements t<Y> {
        public a() {
        }

        @Override // e.r.t
        public void a(Y y) {
            c0.this.c.l(y);
        }
    }

    public c0(e.c.a.c.a aVar, q qVar) {
        this.b = aVar;
        this.c = qVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.r.t
    public void a(X x) {
        q.a aVar;
        LiveData<Y> liveData = (LiveData) this.b.a(x);
        Object obj = this.a;
        if (obj != liveData) {
            if (!(obj == null || (aVar = (q.a) this.c.f1899l.l(obj)) == null)) {
                aVar.a.k(aVar);
            }
            this.a = liveData;
            if (liveData != 0) {
                this.c.m(liveData, new a());
            }
        }
    }
}
