package f.b.a.a.a.r;

import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.y.d0;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class t3 implements b<NotifyHomeViewModel> {
    public final a<d0> a;
    public final a<ExecutorService> b;

    public t3(a<d0> aVar, a<ExecutorService> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public NotifyHomeViewModel a(u uVar) {
        return new NotifyHomeViewModel(this.a.get(), this.b.get());
    }
}
