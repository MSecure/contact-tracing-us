package f.b.a.a.a.r;

import android.util.Log;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import f.b.b.f.a.p;

public class s3 implements p<Void> {
    public final /* synthetic */ NotifyHomeViewModel a;

    public s3(NotifyHomeViewModel notifyHomeViewModel) {
        this.a = notifyHomeViewModel;
    }

    @Override // f.b.b.f.a.p
    public void a(Throwable th) {
        Log.w("NotifyHomeViewModel", "Failed to delete", th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // f.b.b.f.a.p
    public void b(Void r2) {
        this.a.c.j(null);
    }
}
