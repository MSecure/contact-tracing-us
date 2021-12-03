package f.b.a.a.a.m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultRegistry;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import e.a.e.f.d;
import e.b.a.j;
import e.m.a.e0;
import e.m.a.m;
import e.p.f0;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Objects;

public abstract class y0 extends j {
    public ExposureNotificationViewModel q;
    public BroadcastReceiver r = null;
    public f.b.a.a.a.j.a s;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            y0.this.q.e();
        }
    }

    public void A(z0 z0Var) {
        e.m.a.a aVar = new e.m.a.a(p());
        aVar.f(R.id.main_fragment, z0Var, "MAIN_FRAGMENT_TAG");
        aVar.c(null);
        aVar.f1471f = 4097;
        aVar.d();
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        z0 z0Var = (z0) p().I("MAIN_FRAGMENT_TAG");
        if (z0Var == null || !z0Var.A0()) {
            this.f5h.b();
        }
    }

    @Override // androidx.activity.ComponentActivity, e.m.a.r, e.i.a.h
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ExposureNotificationViewModel exposureNotificationViewModel = (ExposureNotificationViewModel) new f0(this).a(ExposureNotificationViewModel.class);
        this.q = exposureNotificationViewModel;
        Objects.requireNonNull(exposureNotificationViewModel);
        d dVar = new d();
        a aVar = new a(exposureNotificationViewModel);
        ActivityResultRegistry activityResultRegistry = this.f7j;
        StringBuilder i2 = f.a.a.a.a.i("activity_rq#");
        i2.append(this.f6i.getAndIncrement());
        exposureNotificationViewModel.o.f(this, new u(exposureNotificationViewModel, activityResultRegistry.d(i2.toString(), this, dVar, aVar)));
        View inflate = getLayoutInflater().inflate(R.layout.activity_exposure_notification, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.main_fragment);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) inflate;
            this.s = new f.b.a.a.a.j.a(frameLayout2, frameLayout);
            setContentView(frameLayout2);
            if (bundle != null) {
                m J = p().J(bundle, "BaseActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
                Objects.requireNonNull(J);
                z((z0) J);
                return;
            }
            Intent intent = getIntent();
            y(intent.getAction(), intent.getExtras(), intent.getData(), false);
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.main_fragment)));
    }

    @Override // e.b.a.j, e.m.a.r
    public void onDestroy() {
        super.onDestroy();
        this.s = null;
    }

    @Override // e.m.a.r
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        p().X(null, 1);
        y(intent.getAction(), intent.getExtras(), intent.getData(), true);
    }

    @Override // e.m.a.r
    public void onPause() {
        super.onPause();
        BroadcastReceiver broadcastReceiver = this.r;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.r = null;
        }
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.b.a, e.m.a.r
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.m.a.r
    public void onResume() {
        super.onResume();
        this.q.e();
        if (this.r == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            a aVar = new a();
            this.r = aVar;
            registerReceiver(aVar, intentFilter);
        }
    }

    @Override // androidx.activity.ComponentActivity, e.i.a.h
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        e0 p = p();
        z0 z0Var = (z0) p().I("MAIN_FRAGMENT_TAG");
        Objects.requireNonNull(z0Var);
        p.a0(bundle, "BaseActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY", z0Var);
    }

    @Override // e.b.a.j
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }

    public abstract void y(String str, Bundle bundle, Uri uri, boolean z);

    public void z(z0 z0Var) {
        e.m.a.a aVar = new e.m.a.a(p());
        aVar.f(R.id.main_fragment, z0Var, "MAIN_FRAGMENT_TAG");
        aVar.f1471f = 4097;
        aVar.d();
    }
}
