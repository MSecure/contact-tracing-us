package com.google.android.apps.exposurenotification.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.m.a.c0;
import e.m.a.l;
import f.b.a.a.a.j.b;
import f.b.a.a.a.j.b0;
import f.b.a.a.a.j.e0;
import f.b.a.a.a.j.i0;
import f.b.a.a.a.s.s;
import f.b.a.a.a.w.k0;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public final class ExposureNotificationActivity extends b0 {
    public ExposureNotificationViewModel r;
    public final BroadcastReceiver s = new a();

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            ExposureNotificationActivity.this.r.d();
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1111) {
            if (i3 == -1) {
                this.r.g();
            } else {
                this.r.f();
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o, e.i.a.f, f.b.a.a.a.j.b0
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_exposure_notification);
        this.r = (ExposureNotificationViewModel) new e.p.b0(this).a(ExposureNotificationViewModel.class);
        if (bundle == null) {
            ExposureHomeViewModel exposureHomeViewModel = (ExposureHomeViewModel) new e.p.b0(this).a(ExposureHomeViewModel.class);
            k0.f fVar = k0.f.SEEN;
            k0.f fVar2 = k0.f.DISMISSED;
            exposureHomeViewModel.d(fVar, fVar2);
            exposureHomeViewModel.c(fVar, fVar2);
            if (getIntent() != null && "com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION".equals(getIntent().getAction())) {
                ExposureNotificationViewModel exposureNotificationViewModel = this.r;
                exposureNotificationViewModel.f334g.k(exposureNotificationViewModel.o.b(), k0.g.CLICKED);
            }
        }
        this.r.f336i.f(this, new b(this));
        if (bundle != null) {
            e.m.a.a aVar = new e.m.a.a(n());
            l K = n().K(bundle, "ExposureNotificationActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
            Objects.requireNonNull(K);
            aVar.f(R.id.home_fragment, K, "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
            aVar.c();
        } else {
            e.m.a.a aVar2 = new e.m.a.a(n());
            aVar2.f(R.id.home_fragment, new i0(), "ExposureNotificationActivity.HOME_FRAGMENT_TAG");
            aVar2.c();
            ExposureNotificationViewModel exposureNotificationViewModel2 = this.r;
            exposureNotificationViewModel2.m.a(s.c.APP_OPENED);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.location.PROVIDERS_CHANGED");
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        registerReceiver(this.s, intentFilter);
    }

    @Override // e.b.a.j, e.m.a.o
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.s);
    }

    @Override // e.m.a.o
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        for (l lVar : n().N()) {
            if (lVar instanceof e0) {
                View view = ((e0) lVar).F;
                if (view == null) {
                    Log.w("HomeFragment", "Unable to set the tab");
                } else {
                    ((ViewPager2) view.findViewById(R.id.view_pager)).setCurrentItem(0);
                }
            }
        }
        if ("com.google.android.apps.exposurenotification.ACTION_LAUNCH_FROM_EXPOSURE_NOTIFICATION".equals(intent.getAction())) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.r;
            exposureNotificationViewModel.f334g.k(exposureNotificationViewModel.o.b(), k0.g.CLICKED);
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.o
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.m.a.o
    public void onResume() {
        super.onResume();
        this.r.d();
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.f
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        c0 n = n();
        l J = n().J("ExposureNotificationActivity.HOME_FRAGMENT_TAG");
        Objects.requireNonNull(J);
        n.d0(bundle, "ExposureNotificationActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY", J);
    }

    @Override // e.b.a.j
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }
}
