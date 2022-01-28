package f.b.a.a.a.l;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.p.e0;
import e.p.f0;
import e.p.g0;
import f.b.a.a.a.i.f0.a;
import f.b.a.a.a.j.o;
import gov.co.cdphe.exposurenotifications.R;

public class j extends m {
    public o a0;
    public a b0;

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = q().inflate(R.layout.fragment_exposure_checks, (ViewGroup) null, false);
        int i2 = R.id.checks_recycler_view;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.checks_recycler_view);
        if (recyclerView != null) {
            i2 = 16908332;
            ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
            if (imageButton != null) {
                i2 = R.id.no_recent_exposure_checks;
                TextView textView = (TextView) inflate.findViewById(R.id.no_recent_exposure_checks);
                if (textView != null) {
                    FrameLayout frameLayout = (FrameLayout) inflate;
                    this.a0 = new o(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.m
    public void Q() {
        this.D = true;
        this.a0 = null;
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.exposure_checks_activity_title);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String c = f.a.a.a.a.c("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = i2.a.get(c);
            if (!ExposureHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(c, ExposureHomeViewModel.class) : l2.a(ExposureHomeViewModel.class);
                e0 put = i2.a.put(c, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.a0.c.setOnClickListener(new a(this));
            i iVar = new i(p0(), this.b0);
            p0();
            this.a0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.a0.b.setAdapter(iVar);
            ((ExposureHomeViewModel) e0Var).f331e.f(C(), new b(this, iVar));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
