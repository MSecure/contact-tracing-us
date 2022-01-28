package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.n.a.b;
import e.p.y;
import f.b.a.a.a.b0.i0;
import i.a.a;
import java.util.concurrent.ExecutorService;

public final class n5 implements b<NotifyHomeViewModel> {
    public final a<i0> a;
    public final a<ExecutorService> b;

    public n5(a<i0> aVar, a<ExecutorService> aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    /* Return type fixed from 'e.p.e0' to match base method */
    @Override // e.n.a.b
    public NotifyHomeViewModel a(y yVar) {
        return new NotifyHomeViewModel(this.a.get(), this.b.get());
    }
}
