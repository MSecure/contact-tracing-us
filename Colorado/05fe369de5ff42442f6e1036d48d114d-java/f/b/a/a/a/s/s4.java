package f.b.a.a.a.s;

import android.content.DialogInterface;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.f.a.a;
import e.t.n.d;
import f.b.a.a.a.b0.a0;
import f.b.a.a.a.b0.b0;
import f.b.a.a.a.b0.i0;
import f.b.b.f.a.q;
import f.b.b.f.a.u;
import java.util.concurrent.ExecutorService;

public final /* synthetic */ class s4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ z4 b;
    public final /* synthetic */ int c;

    public /* synthetic */ s4(z4 z4Var, int i2) {
        this.b = z4Var;
        this.c = i2;
    }

    public final void onClick(DialogInterface dialogInterface, int i2) {
        z4 z4Var = this.b;
        int i3 = this.c;
        int i4 = q6.c0;
        NotifyHomeViewModel notifyHomeViewModel = z4Var.c;
        i0 i0Var = notifyHomeViewModel.f400e;
        long e2 = z4Var.f2401e.remove(i3).e();
        a0 a0Var = (a0) i0Var.a;
        u a = d.a(a0Var.a, true, new b0(a0Var, e2));
        m5 m5Var = new m5(notifyHomeViewModel);
        ExecutorService executorService = notifyHomeViewModel.f401f;
        ((a) a).a(new q(a, m5Var), executorService);
        z4Var.a.b();
    }
}
