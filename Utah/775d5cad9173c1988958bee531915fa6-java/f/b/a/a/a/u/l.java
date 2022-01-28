package f.b.a.a.a.u;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.f.d;
import e.b.a.m;
import f.b.a.a.a.g0.n;
import f.b.a.a.a.s.d0.a;
import f.b.a.a.a.w.z0;
import java.util.Objects;

public abstract class l extends z0 {
    public static final a X = a.e("MainEdgeCaseFragment");

    public static l L0(l lVar, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handleApiErrorLiveEvents", z);
        bundle.putBoolean("handleResolutions", z2);
        lVar.y0(bundle);
        return lVar;
    }

    public void G0(Button button) {
        int i2 = 0;
        if (!(m.e.N(j()) != null)) {
            i2 = 8;
        }
        button.setVisibility(i2);
        button.setOnClickListener(new b(this));
    }

    public void H0(Button button) {
        button.setVisibility(0);
        button.setOnClickListener(new a(this));
    }

    public void I0(Button button, boolean z) {
        button.setVisibility(0);
        button.setEnabled(!z);
        button.setOnClickListener(new d(this));
    }

    public abstract void J0(View view, View view2, ExposureNotificationViewModel.b bVar, boolean z);

    public void K0(n.c cVar) {
        this.W.s.a(cVar);
    }

    public void M0(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        boolean z;
        super.k0(view, bundle);
        this.W.f346k.n(G(), new g(this));
        Bundle bundle2 = this.f1727g;
        boolean z2 = true;
        if (bundle2 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
            z = true;
        } else {
            z = bundle2.getBoolean("handleApiErrorLiveEvents", true);
        }
        if (z) {
            this.W.f347l.f(G(), new f(this));
            this.W.m.f(G(), new e(this, view));
        }
        Bundle bundle3 = this.f1727g;
        if (bundle3 == null) {
            X.g("Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
        } else {
            z2 = bundle3.getBoolean("handleResolutions", true);
        }
        if (z2) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.W;
            Objects.requireNonNull(exposureNotificationViewModel);
            exposureNotificationViewModel.o.f(this, new f.b.a.a.a.w.m(exposureNotificationViewModel, r0(new d(), new f.b.a.a.a.w.a(exposureNotificationViewModel))));
        }
    }
}
