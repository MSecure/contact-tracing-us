package f.b.a.a.a.r;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.f.a.a;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ f3 b;
    public final /* synthetic */ int c;

    public /* synthetic */ i(f3 f3Var, int i2) {
        this.b = f3Var;
        this.c = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        f3 f3Var = this.b;
        int i3 = this.c;
        int i4 = q3.d0;
        NotifyHomeViewModel notifyHomeViewModel = f3Var.f2248d;
        u<Void> a = notifyHomeViewModel.f382e.a(f3Var.c.remove(i3).e());
        s3 s3Var = new s3(notifyHomeViewModel);
        ExecutorService executorService = notifyHomeViewModel.f383f;
        ((a) a).a(new q(a, s3Var), executorService);
        f3Var.a.b();
    }
}
