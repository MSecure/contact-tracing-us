package f.b.a.a.a.w;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import e.r.e0;
import e.r.f0;
import e.r.g0;
import e.r.t;
import f.a.a.a.a;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.u.z;
import g.b.a.c.b.d;
import gov.nm.covid19.exposurenotifications.R;
import l.b.a.f;
import l.b.a.g;
import l.b.a.h;
import l.b.a.r;
/* loaded from: classes.dex */
public class o extends n {
    public z b0;
    public ExposureHomeViewModel c0;

    @Override // f.b.a.a.a.x.a1
    public boolean I0() {
        w().X();
        return true;
    }

    public final void L0(String str) {
        this.b0.f2490g.setOnClickListener(new View.OnClickListener(str) { // from class: f.b.a.a.a.w.f
            public final /* synthetic */ String c;

            {
                this.c = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o oVar = o.this;
                b.a(oVar.b0.a, this.c);
            }
        });
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                        this.b0 = new z(frameLayout, textView, textView2, textView3, textView4, textView5, button, button2, imageButton);
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

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        a1.f fVar = a1.f.SEEN;
        super.m0(view, bundle);
        u0().setTitle(R.string.possible_exposures_activity_title);
        f0.b l2 = l();
        g0 i2 = i();
        String canonicalName = ExposureHomeViewModel.class.getCanonicalName();
        if (canonicalName != null) {
            String x = a.x("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
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
            this.c0 = (ExposureHomeViewModel) e0Var;
            this.b0.f2492i.setContentDescription(F(R.string.navigate_up));
            this.b0.f2492i.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.w.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o.this.w().X();
                }
            });
            this.b0.f2491h.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.w.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    o oVar = o.this;
                    b.a(oVar.b0.a, oVar.F(R.string.how_exposure_notifications_work_actual_link));
                }
            });
            this.c0.c.f2318i.f(H(), new t() { // from class: f.b.a.a.a.w.d
                @Override // e.r.t
                public final void a(Object obj) {
                    o.this.b0.f2488e.setVisibility(((a1.f) obj) != a1.f.DISMISSED ? 0 : 8);
                }
            });
            this.c0.c.f2319j.f(H(), new t() { // from class: f.b.a.a.a.w.h
                @Override // e.r.t
                public final void a(Object obj) {
                    o.this.b0.c.setVisibility(((a1.f) obj) != a1.f.DISMISSED ? 0 : 8);
                }
            });
            this.c0.c.f2317h.f(H(), new t() { // from class: f.b.a.a.a.w.e
                @Override // e.r.t
                public final void a(Object obj) {
                    int i3;
                    int i4;
                    o oVar = o.this;
                    f.b.a.a.a.j0.d dVar = (f.b.a.a.a.j0.d) obj;
                    boolean booleanValue = Boolean.valueOf(oVar.c0.c.g()).booleanValue();
                    z zVar = oVar.b0;
                    TextView textView = zVar.f2487d;
                    TextView textView2 = zVar.f2489f;
                    Button button = zVar.f2490g;
                    ExposureHomeViewModel exposureHomeViewModel = oVar.c0;
                    Context v0 = oVar.v0();
                    l.b.a.e c = exposureHomeViewModel.f338g.c();
                    f.b.a.a.a.t.p0.a aVar = m0.a;
                    l.b.a.d c2 = l.b.a.d.c(g.F(f.R(dVar.a()), h.f4620h).w(r.f4641g), c);
                    long j2 = 1;
                    if (c2.b < 0) {
                        m0.a.c("Negative time since exposure!");
                    } else {
                        j2 = Math.max(1L, c2.s());
                    }
                    textView.setText(v0.getResources().getQuantityString(R.plurals.days_from_start_of_exposure, (int) j2, Long.valueOf(j2)));
                    if (booleanValue) {
                        i4 = R.string.exposure_details_url_revoked;
                        button.setText(R.string.exposure_details_url_revoked);
                        i3 = R.string.exposure_details_text_revoked;
                    } else {
                        int b = dVar.b();
                        if (b == 1) {
                            i4 = R.string.exposure_details_url_1;
                            button.setText(R.string.exposure_details_url_1);
                            i3 = R.string.exposure_details_text_1;
                        } else if (b == 2) {
                            i4 = R.string.exposure_details_url_2;
                            button.setText(R.string.exposure_details_url_2);
                            i3 = R.string.exposure_details_text_2;
                        } else if (b == 3) {
                            i4 = R.string.exposure_details_url_3;
                            button.setText(R.string.exposure_details_url_3);
                            i3 = R.string.exposure_details_text_3;
                        } else if (b == 4) {
                            i4 = R.string.exposure_details_url_4;
                            button.setText(R.string.exposure_details_url_4);
                            i3 = R.string.exposure_details_text_4;
                        } else {
                            return;
                        }
                    }
                    textView2.setText(i3);
                    oVar.L0(oVar.F(i4));
                }
            });
            if (bundle == null) {
                ExposureHomeViewModel exposureHomeViewModel = this.c0;
                a1.f fVar2 = a1.f.DISMISSED;
                exposureHomeViewModel.d(fVar, fVar2);
                this.c0.c(fVar, fVar2);
            }
            ExposureHomeViewModel exposureHomeViewModel2 = this.c0;
            a1.f fVar3 = a1.f.NEW;
            exposureHomeViewModel2.d(fVar3, fVar);
            this.c0.c(fVar3, fVar);
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
}
