package f.b.a.a.a.p;

import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.n.a.b;
import e.p.u;
import f.b.a.a.a.w.c0;
import i.a.a;

public final class h3 implements b<NotifyHomeViewModel> {
    public final a<c0> a;

    public h3(a<c0> aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'e.p.a0' to match base method */
    @Override // e.n.a.b
    public NotifyHomeViewModel a(u uVar) {
        return new NotifyHomeViewModel(this.a.get());
    }
}
