package f.b.a.a.a.x;

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
import e.a.e.c;
import e.a.e.f.d;
import e.b.a.j;
import e.r.f0;
import e.r.t;
import f.b.a.c.b.l.b;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public abstract class z0 extends j {
    public ExposureNotificationViewModel q;
    public BroadcastReceiver r = null;
    public f.b.a.a.a.u.a s;

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
            z0.this = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            z0.this.q.e();
        }
    }

    public void A(a1 a1Var) {
        e.o.a.a aVar = new e.o.a.a(q());
        aVar.g(R.id.main_fragment, a1Var, "MAIN_FRAGMENT_TAG");
        aVar.f1829f = 4097;
        aVar.d();
    }

    public void B(a1 a1Var) {
        e.o.a.a aVar = new e.o.a.a(q());
        aVar.g(R.id.main_fragment, a1Var, "MAIN_FRAGMENT_TAG");
        aVar.c(null);
        aVar.f1829f = 4097;
        aVar.d();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        a1 a1Var = (a1) q().I("MAIN_FRAGMENT_TAG");
        if (a1Var == null || !a1Var.I0()) {
            this.f5h.b();
        }
    }

    @Override // e.o.a.r, androidx.activity.ComponentActivity, e.j.a.g, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ExposureNotificationViewModel exposureNotificationViewModel = (ExposureNotificationViewModel) new f0(this).a(ExposureNotificationViewModel.class);
        this.q = exposureNotificationViewModel;
        Objects.requireNonNull(exposureNotificationViewModel);
        d dVar = new d();
        a aVar = new a(exposureNotificationViewModel);
        ActivityResultRegistry activityResultRegistry = this.f7j;
        StringBuilder h2 = f.a.a.a.a.h("activity_rq#");
        h2.append(this.f6i.getAndIncrement());
        exposureNotificationViewModel.o.f(this, new t(activityResultRegistry.d(h2.toString(), this, dVar, aVar)) { // from class: f.b.a.a.a.x.u
            public final /* synthetic */ c b;

            {
                this.b = r2;
            }

            @Override // e.r.t
            public final void a(Object obj) {
                ExposureNotificationViewModel.this.g((b) obj, this.b);
            }
        });
        View inflate = getLayoutInflater().inflate(R.layout.activity_exposure_notification, (ViewGroup) null, false);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.main_fragment);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) inflate;
            this.s = new f.b.a.a.a.u.a(frameLayout2, frameLayout);
            setContentView(frameLayout2);
            if (bundle != null) {
                a1 a1Var = (a1) q().K(bundle, "BaseActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY");
                if (a1Var != null) {
                    A(a1Var);
                    return;
                }
                return;
            }
            Intent intent = getIntent();
            z(intent.getAction(), intent.getExtras(), intent.getData(), false);
            return;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.main_fragment)));
    }

    @Override // e.b.a.j, e.o.a.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.s = null;
    }

    @Override // e.o.a.r, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        q().Y(null, 1);
        z(intent.getAction(), intent.getExtras(), intent.getData(), true);
    }

    @Override // e.o.a.r, android.app.Activity
    public void onPause() {
        super.onPause();
        BroadcastReceiver broadcastReceiver = this.r;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.r = null;
        }
    }

    @Override // e.o.a.r, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // e.o.a.r, android.app.Activity
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

    @Override // androidx.activity.ComponentActivity, e.j.a.g, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a1 a1Var = (a1) q().I("MAIN_FRAGMENT_TAG");
        if (a1Var != null) {
            q().b0(bundle, "BaseActivity.SAVED_INSTANCE_STATE_FRAGMENT_KEY", a1Var);
        }
    }

    @Override // e.b.a.j, android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getWindow().getDecorView().sendAccessibilityEvent(32);
    }

    public abstract void z(String str, Bundle bundle, Uri uri, boolean z);
}
