package f.b.a.a.a.e0;

import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import f.b.b.f.a.p;
/* loaded from: classes.dex */
public class a6 implements p<Void> {
    public final /* synthetic */ NotifyHomeViewModel a;

    public a6(NotifyHomeViewModel notifyHomeViewModel) {
        this.a = notifyHomeViewModel;
    }

    @Override // f.b.b.f.a.p
    public void a(Void r2) {
        this.a.c.j(null);
    }

    @Override // f.b.b.f.a.p
    public void b(Throwable th) {
        NotifyHomeViewModel.f401h.h("Failed to delete", th);
    }
}
