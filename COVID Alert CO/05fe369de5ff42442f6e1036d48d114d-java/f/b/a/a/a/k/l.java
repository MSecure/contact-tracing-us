package f.b.a.a.a.k;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.f.d;
import e.b.a.m;
import f.b.a.a.a.i.e0.a;
import f.b.a.a.a.m.z0;
import f.b.a.a.a.v.n;
import java.util.Objects;

public abstract class l extends z0 {
    public static final a X = a.e("MainEdgeCaseFragment");

    public static l G0(l lVar, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handleApiErrorLiveEvents", z);
        bundle.putBoolean("handleResolutions", z2);
        lVar.t0(bundle);
        return lVar;
    }

    public void B0(Button button) {
        int i2 = 0;
        if (!(m.h.L(j()) != null)) {
            i2 = 8;
        }
        button.setVisibility(i2);
        button.setOnClickListener(new b(this));
    }

    public void C0(Button button) {
        button.setVisibility(0);
        button.setOnClickListener(new a(this));
    }

    public void D0(Button button, boolean z) {
        button.setVisibility(0);
        button.setEnabled(!z);
        button.setOnClickListener(new d(this));
    }

    public abstract void E0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z);

    public void F0(n.c cVar) {
        this.W.s.a(cVar);
    }

    public void H0(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        boolean z;
        super.g0(view, bundle);
        this.W.f341k.n(C(), new g(this));
        Bundle bundle2 = this.f1454g;
        boolean z2 = true;
        if (bundle2 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
            z = true;
        } else {
            z = bundle2.getBoolean("handleApiErrorLiveEvents", true);
        }
        if (z) {
            this.W.f342l.f(C(), new f(this));
            this.W.m.f(C(), new e(this, view));
        }
        Bundle bundle3 = this.f1454g;
        if (bundle3 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
        } else {
            z2 = bundle3.getBoolean("handleResolutions", true);
        }
        if (z2) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.W;
            Objects.requireNonNull(exposureNotificationViewModel);
            exposureNotificationViewModel.o.f(this, new f.b.a.a.a.m.m(exposureNotificationViewModel, n0(new d(), new f.b.a.a.a.m.a(exposureNotificationViewModel))));
        }
    }
}
