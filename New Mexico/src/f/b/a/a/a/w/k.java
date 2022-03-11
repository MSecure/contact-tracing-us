package f.b.a.a.a.w;

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
import e.r.e0;
import e.r.f0;
import e.r.g0;
import e.r.t;
import f.b.a.a.a.n0.u0;
import f.b.a.a.a.t.q0.a;
import f.b.a.a.a.u.p;
import g.b.a.c.b.d;
import gov.nm.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class k extends m {
    public p b0;
    public a c0;

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = t().inflate(R.layout.fragment_exposure_checks, (ViewGroup) null, false);
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
                    this.b0 = new p(frameLayout, recyclerView, imageButton, textView);
                    return frameLayout;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void W() {
        this.D = true;
        this.b0 = null;
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u0().setTitle(R.string.exposure_checks_activity_title);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String x = f.a.a.a.a.x("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            e0 e0Var = i2.a.get(x);
            if (!ExposureHomeViewModel.class.isInstance(e0Var)) {
                e0Var = l2 instanceof f0.c ? ((f0.c) l2).c(x, ExposureHomeViewModel.class) : ((d) l2).a(ExposureHomeViewModel.class);
                e0 put = i2.a.put(x, e0Var);
                if (put != null) {
                    put.a();
                }
            } else if (l2 instanceof f0.e) {
                ((f0.e) l2).b(e0Var);
            }
            this.b0.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.w.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    k.this.u0().onBackPressed();
                }
            });
            j jVar = new j(v0(), this.c0);
            v0();
            this.b0.b.setLayoutManager(new LinearLayoutManager(1, false));
            this.b0.b.setAdapter(jVar);
            ((ExposureHomeViewModel) e0Var).f337f.f(H(), new t(jVar) { // from class: f.b.a.a.a.w.b
                public final /* synthetic */ j b;

                {
                    this.b = r2;
                }

                @Override // e.r.t
                public final void a(Object obj) {
                    k kVar = k.this;
                    j jVar2 = this.b;
                    List<u0> list = (List) obj;
                    Objects.requireNonNull(kVar);
                    if (list.isEmpty()) {
                        kVar.b0.b.setVisibility(8);
                        kVar.b0.f2463d.setVisibility(0);
                    } else {
                        kVar.b0.b.setVisibility(0);
                        kVar.b0.f2463d.setVisibility(8);
                    }
                    jVar2.f2494e = list;
                    jVar2.a.b();
                }
            });
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
