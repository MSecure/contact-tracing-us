package f.b.a.a.a.s;

import android.widget.Button;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.t;
import f.b.a.a.a.s.c0;
import f.b.a.a.a.w.f1;
import f.b.a.a.a.w.m0;
import j.e;
import java.util.Objects;
import java.util.Set;

public final /* synthetic */ class l implements t {
    public final /* synthetic */ c0.a a;

    public /* synthetic */ l(c0.a aVar) {
        this.a = aVar;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        c0.a aVar = this.a;
        e eVar = (e) obj;
        A a2 = eVar.b;
        B b = eVar.c;
        C c = eVar.f4315d;
        f1 f1Var = ((m0) aVar).a;
        A a3 = a2;
        B b2 = b;
        C c2 = c;
        if (f1Var.b0 != null) {
            int i2 = 1;
            int i3 = a3 == ExposureNotificationViewModel.b.ENABLED ? 1 : 0;
            boolean equals = ShareDiagnosisViewModel.U.equals(c2);
            int i4 = (b2.b() != 0 || Boolean.valueOf(f1Var.c0.c.f()).booleanValue()) ? 0 : 1;
            int i5 = i3 ^ 1;
            f1Var.b0.f2408d.setDisplayedChild(i5);
            f1Var.b0.b.setDisplayedChild(i4 ^ 1);
            Button button = f1Var.b0.r.b;
            Objects.requireNonNull(f1Var.W);
            Set<ExposureNotificationViewModel.b> set = ShareDiagnosisViewModel.T;
            button.setEnabled(!set.contains(a3));
            Button button2 = f1Var.b0.n.c;
            Objects.requireNonNull(f1Var.W);
            button2.setEnabled(!set.contains(a3));
            f1Var.b0.f2410f.setVisibility(0);
            f1Var.b0.q.setVisibility(0);
            int i6 = 8;
            if (equals) {
                ViewFlipper viewFlipper = f1Var.b0.f2408d;
                if (i4 != 0) {
                    viewFlipper.setVisibility(8);
                    f1Var.b0.f2412h.setDisplayedChild(i5);
                } else {
                    viewFlipper.setVisibility(0);
                    f1Var.b0.f2412h.setDisplayedChild(2);
                }
                f1Var.b0.o.setVisibility(0);
                f1Var.b0.f2409e.setVisibility(0);
                f1Var.b0.c.setVisibility(8);
                f1Var.b0.b.setVisibility(8);
                f1Var.b0.n.c.setVisibility(8);
                f1Var.b0.n.b.setEnabled(true);
                f1Var.b0.n.b.setImportantForAccessibility(1);
                return;
            }
            int i7 = 3;
            if (i4 != 0) {
                f1Var.b0.f2408d.setVisibility(i3 != 0 ? 0 : 8);
                ViewFlipper viewFlipper2 = f1Var.b0.f2412h;
                if (i3 != 0) {
                    i2 = 3;
                }
                viewFlipper2.setDisplayedChild(i2);
            } else {
                f1Var.b0.f2408d.setVisibility(0);
                ViewFlipper viewFlipper3 = f1Var.b0.f2412h;
                if (i3 == 0) {
                    i7 = 2;
                }
                viewFlipper3.setDisplayedChild(i7);
            }
            f1Var.b0.o.setVisibility(i3 != 0 ? 8 : 0);
            f1Var.b0.f2409e.setVisibility(i3 != 0 ? 8 : 0);
            f1Var.b0.c.setVisibility(i3 != 0 ? 0 : 8);
            ViewFlipper viewFlipper4 = f1Var.b0.b;
            if (i3 != 0) {
                i6 = 0;
            }
            viewFlipper4.setVisibility(i6);
            f1Var.b0.n.c.setVisibility(0);
            f1Var.b0.n.b.setEnabled(false);
            f1Var.b0.n.b.setImportantForAccessibility(2);
        }
    }
}
