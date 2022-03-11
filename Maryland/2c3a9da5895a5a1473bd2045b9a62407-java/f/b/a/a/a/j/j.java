package f.b.a.a.a.j;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.f.d;
import e.b.a.m;
import e.m.a.l;
import e.m.a.m;
import e.m.a.n;
import e.m.a.o;
import e.p.b0;
import f.b.a.a.a.l.b;
import f.b.a.a.a.u.s;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class j extends l {
    public static final /* synthetic */ int Y = 0;
    public ExposureNotificationViewModel X;

    public static j C0(j jVar, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("handleApiErrorLiveEvents", z);
        bundle.putBoolean("handleResolutions", z2);
        jVar.s0(bundle);
        return jVar;
    }

    public abstract void A0(View view, View view2, ExposureNotificationViewModel.a aVar, boolean z);

    public void B0(s.c cVar) {
        this.X.f348l.a(cVar);
    }

    public void D0(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.X.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        boolean z;
        boolean z2;
        ExposureNotificationViewModel exposureNotificationViewModel = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        this.X = exposureNotificationViewModel;
        exposureNotificationViewModel.c.f(B(), new d(this));
        Bundle bundle2 = this.f1632g;
        if (bundle2 == null) {
            Log.w("MainEdgeCaseFragment", "Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
            z = true;
        } else {
            z = bundle2.getBoolean("handleApiErrorLiveEvents", true);
        }
        if (z) {
            this.X.f345i.f(B(), new e(this));
        }
        Bundle bundle3 = this.f1632g;
        if (bundle3 == null) {
            Log.w("MainEdgeCaseFragment", "Constructing EdgeCaseFragment with non-argument constructor might lead to unexpected behavior, consider using  EdgeCaseFragment.newInstance(...) instead.");
            z2 = true;
        } else {
            z2 = bundle3.getBoolean("handleResolutions", true);
        }
        if (z2) {
            ExposureNotificationViewModel exposureNotificationViewModel2 = this.X;
            Objects.requireNonNull(exposureNotificationViewModel2);
            d dVar = new d();
            b bVar = new b(exposureNotificationViewModel2);
            m mVar = new m(this);
            if (this.b <= 1) {
                AtomicReference atomicReference = new AtomicReference();
                n nVar = new n(this, mVar, atomicReference, dVar, bVar);
                if (this.b >= 0) {
                    nVar.a();
                } else {
                    this.V.add(nVar);
                }
                exposureNotificationViewModel2.f346j.f(this, new f.b.a.a.a.l.s(exposureNotificationViewModel2, new o(this, atomicReference, dVar)));
                return;
            }
            throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
        }
    }

    public void y0(Button button) {
        int i2 = 0;
        if (!(m.h.K(k()) != null)) {
            i2 = 8;
        }
        button.setVisibility(i2);
        button.setOnClickListener(new b(this));
    }

    public void z0(Button button) {
        button.setVisibility(0);
        button.setOnClickListener(new a(this));
    }
}
