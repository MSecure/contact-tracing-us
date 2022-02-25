package f.b.a.a.a.p;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import e.p.a0;
import e.p.b0;
import e.p.c0;
import f.a.a.a.a;
import gov.ca.covid19.exposurenotifications.R;

public class f3 extends v2 {
    public static final /* synthetic */ int b0 = 0;
    public ExposureNotificationViewModel Z;
    public NotifyHomeViewModel a0;

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_notify_home, viewGroup, false);
    }

    @Override // e.m.a.l
    public void c0() {
        this.D = true;
        this.Z.d();
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        this.Z = (ExposureNotificationViewModel) new b0(m0()).a(ExposureNotificationViewModel.class);
        b0.b k2 = k();
        c0 h2 = h();
        String canonicalName = NotifyHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String t = a.t("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            a0 a0Var = h2.a.get(t);
            if (!NotifyHomeViewModel.class.isInstance(a0Var)) {
                a0Var = k2 instanceof b0.c ? ((b0.c) k2).c(t, NotifyHomeViewModel.class) : k2.a(NotifyHomeViewModel.class);
                a0 put = h2.a.put(t, a0Var);
                if (put != null) {
                    put.a();
                }
            } else if (k2 instanceof b0.e) {
                ((b0.e) k2).b(a0Var);
            }
            this.a0 = (NotifyHomeViewModel) a0Var;
            this.Z.c.f(B(), new d(this));
            Button button = (Button) view.findViewById(R.id.start_api_button);
            button.setOnClickListener(new l(this));
            this.Z.f331d.f(B(), new c(button));
            ((Button) view.findViewById(R.id.fragment_notify_share_button)).setOnClickListener(new e(this));
            u2 u2Var = new u2(new k(this));
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.W);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.notify_recycler_view);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(u2Var);
            view.findViewById(R.id.ble_settings_button).setOnClickListener(new g(this));
            view.findViewById(R.id.location_settings_button).setOnClickListener(new j(this));
            view.findViewById(R.id.location_ble_settings_button).setOnClickListener(new h(this));
            view.findViewById(R.id.manage_storage_button).setOnClickListener(new f(this));
            this.a0.c.f(B(), new i(view.findViewById(R.id.diagnosis_history_container), u2Var));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public final void z0() {
        w0(new Intent("com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS"));
    }
}
