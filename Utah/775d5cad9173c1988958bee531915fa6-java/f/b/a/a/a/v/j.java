package f.b.a.a.a.v;

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
import e.q.e0;
import e.q.f0;
import e.q.g0;
import f.b.a.a.a.s.e0.a;
import f.b.a.a.a.t.o;
import g.b.a.c.b.d;
import gov.ut.covid19.exposurenotifications.R;

public class j extends l {
    public o b0;
    public a c0;

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = s().inflate(R.layout.fragment_exposure_checks, (ViewGroup) null, false);
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
                    this.b0 = new o(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void U() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.exposure_checks_activity_title);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String w = f.a.a.a.a.w("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = i2.a.get(w);
            if (!ExposureHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(w, ExposureHomeViewModel.class) : ((d) l2).a(ExposureHomeViewModel.class);
                e0 put = i2.a.put(w, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.b0.c.setOnClickListener(new a(this));
            i iVar = new i(t0(), this.c0);
            t0();
            this.b0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.b0.b.setAdapter(iVar);
            ((ExposureHomeViewModel) e0Var).f336e.f(G(), new b(this, iVar));
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
