package com.google.android.apps.exposurenotification.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.m.a.f0;
import e.m.a.l;
import e.p.b0;
import f.b.a.a.a.i.d;
import f.b.a.a.a.l.i0;
import f.b.a.a.a.l.l0;
import f.b.a.a.a.l.p0;
import f.b.a.a.a.u.s;
import f.b.a.a.a.y.q0;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public final class ExposureNotificationActivity extends i0 {
    public d s;
    public ExposureNotificationViewModel t;
    public final BroadcastReceiver u = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            ExposureNotificationActivity.this.t.d();
        }
    }

    @Override // androidx.activity.ComponentActivity, f.b.a.a.a.l.i0, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = getLayoutInflater().inflate(R.layout.activity_exposure_notification, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.home_fragment);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) inflate;
            this.s = new d(frameLayout2, frameLayout);
            setContentView(frameLayout2);
            this.t = (ExposureNotificationViewModel) new b0(this).a(ExposureNotificationViewModel.class);
            if (bundle == null) {
                ExposureHomeViewModel exposureHomeViewModel = (ExposureHomeViewModel) new b0(this).a(ExposureHomeViewModel.class);
                q0.f fVar = q0.f.SEEN;
                q0.f fVar2 = q0.f.DISMISSED;
                exposureHomeViewModel.d(fVar, fVar2);
                exposureHomeViewModel.c(fVar, fVar2);
                if (getIntent() != null && "com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION".equals(getIntent().getAction())) {
                    ExposureNotificationViewModel exposureNotificationViewModel = this.t;
                    exposureNotificationViewModel.f344h.l(exposureNotificationViewModel.n.b(), q0.g.CLICKED, exposureNotificationViewModel.f344h.b());
                }
            }
            this.t.e(this);
            if (bundle != null) {
                e.m.a.a aVar = new e.m.a.a(o());
                l K = o().K(bundle, "ExposureNotificationActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
                Objects.requireNonNull(K);
                aVar.f(R.id.home_fragment, K, "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
                aVar.c();
            } else {
                e.m.a.a aVar2 = new e.m.a.a(o());
                aVar2.f(R.id.home_fragment, new p0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
                aVar2.c();
                ExposureNotificationViewModel exposureNotificationViewModel2 = this.t;
                exposureNotificationViewModel2.f348l.a(s.c.APP_OPENED);
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            registerReceiver(this.u, intentFilter);
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.home_fragment)));
    }

    @Override // e.b.a.j, e.m.a.r
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.u);
    }

    @Override // e.m.a.r
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        for (l lVar : o().N()) {
            if (lVar instanceof l0) {
                l0 l0Var = (l0) lVar;
                if (l0Var.F == null) {
                    Log.w("HomeFragment", "Unable to set the tab");
                } else {
                    l0Var.b0.setCurrentItem(0);
                }
            }
        }
        if ("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION".equals(intent.getAction())) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.t;
            exposureNotificationViewModel.f344h.l(exposureNotificationViewModel.n.b(), q0.g.CLICKED, exposureNotificationViewModel.f344h.b());
        }
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.b.a, e.m.a.r
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.m.a.r
    public void onResume() {
        super.onResume();
        this.t.d();
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.h
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        f0 o = o();
        l J = o().J("ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        Objects.requireNonNull(J);
        o.d0(bundle, "ExposureNotificationActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY", J);
    }

    @Override // e.b.a.j
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }
}
