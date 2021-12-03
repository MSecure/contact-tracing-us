package f.b.a.a.a.s;

import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import f.b.b.f.a.p;

public class m5 implements p<Void> {
    public final /* synthetic */ NotifyHomeViewModel a;

    public m5(NotifyHomeViewModel notifyHomeViewModel) {
        this.a = notifyHomeViewModel;
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        NotifyHomeViewModel.f398h.h("Failed to delete", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(Void r2) {
        this.a.c.j(null);
    }
}
