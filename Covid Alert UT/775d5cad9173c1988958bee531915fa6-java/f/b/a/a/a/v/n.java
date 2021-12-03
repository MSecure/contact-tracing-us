package f.b.a.a.a.v;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.q.e0;
import e.q.f0;
import e.q.g0;
import f.a.a.a.a;
import f.b.a.a.a.l0.v0;
import f.b.a.a.a.t.w;
import g.b.a.c.b.d;
import gov.ut.covid19.exposurenotifications.R;

public class n extends m {
    public w b0;
    public ExposureHomeViewModel c0;

    @Override // f.b.a.a.a.w.z0
    public boolean F0() {
        v().W();
        return true;
    }

    public final void I0(String str) {
        this.b0.f2432g.setOnClickListener(new e(this, str));
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_possible_exposure, viewGroup, false);
        int i2 = R.id.activity_title;
        TextView textView = (TextView) inflate.findViewById(R.id.activity_title);
        if (textView != null) {
            i2 = R.id.exposure_date_new_badge;
            TextView textView2 = (TextView) inflate.findViewById(R.id.exposure_date_new_badge);
            if (textView2 != null) {
                i2 = R.id.exposure_details_date_exposed_text;
                TextView textView3 = (TextView) inflate.findViewById(R.id.exposure_details_date_exposed_text);
                if (textView3 != null) {
                    i2 = R.id.exposure_details_new_badge;
                    TextView textView4 = (TextView) inflate.findViewById(R.id.exposure_details_new_badge);
                    if (textView4 != null) {
                        i2 = R.id.exposure_details_text;
                        TextView textView5 = (TextView) inflate.findViewById(R.id.exposure_details_text);
                        if (textView5 != null) {
                            i2 = R.id.exposure_details_url_button;
                            Button button = (Button) inflate.findViewById(R.id.exposure_details_url_button);
                            if (button != null) {
                                i2 = R.id.exposure_notification_explanation_button;
                                Button button2 = (Button) inflate.findViewById(R.id.exposure_notification_explanation_button);
                                if (button2 != null) {
                                    i2 = 16908332;
                                    ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                                    if (imageButton != null) {
                                        FrameLayout frameLayout = (FrameLayout) inflate;
                                        this.b0 = new w(frameLayout, textView, textView2, textView3, textView4, textView5, button, button2, imageButton);
                                        return frameLayout;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        v0.f fVar = v0.f.SEEN;
        super.k0(view, bundle);
        s0().setTitle(R.string.possible_exposures_activity_title);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String w = a.w("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
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
            this.c0 = (ExposureHomeViewModel) e0Var;
            this.b0.f2434i.setContentDescription(E(R.string.navigate_up));
            this.b0.f2434i.setOnClickListener(new h(this));
            this.b0.f2433h.setOnClickListener(new f(this));
            this.c0.c.f2317i.f(G(), new c(this));
            this.c0.c.f2318j.f(G(), new g(this));
            this.c0.c.f2316h.f(G(), new d(this));
            if (bundle == null) {
                ExposureHomeViewModel exposureHomeViewModel = this.c0;
                v0.f fVar2 = v0.f.DISMISSED;
                exposureHomeViewModel.d(fVar, fVar2);
                this.c0.c(fVar, fVar2);
            }
            ExposureHomeViewModel exposureHomeViewModel2 = this.c0;
            v0.f fVar3 = v0.f.NEW;
            exposureHomeViewModel2.d(fVar3, fVar);
            this.c0.c(fVar3, fVar);
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
