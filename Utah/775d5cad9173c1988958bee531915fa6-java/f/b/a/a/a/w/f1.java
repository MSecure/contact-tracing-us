package f.b.a.a.a.w;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.NotifyHomeViewModel;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import com.google.android.material.card.MaterialCardView;
import e.b.a.m;
import e.i.a.n;
import e.n.a.e0;
import e.n.a.m;
import e.n.a.r;
import e.q.f0;
import f.b.a.a.a.s.a0;
import f.b.a.a.a.s.c0;
import f.b.a.a.a.s.e0.a;
import f.b.a.a.a.s.l;
import f.b.a.a.a.s.w;
import f.b.a.a.a.t.b;
import f.b.a.a.a.t.c;
import f.b.a.a.a.t.e;
import f.b.a.a.a.t.g;
import f.b.a.a.a.t.h;
import f.b.a.a.a.t.p;
import f.b.a.a.a.t.p0;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.d;

public class f1 extends d1 {
    public p b0;
    public ExposureHomeViewModel c0;
    public Animation d0;
    public Animation e0;
    public Animation f0;
    public a g0;

    public static void I0(m mVar) {
        mVar.v().X(null, 1);
        e.n.a.a aVar = new e.n.a.a(mVar.v());
        aVar.f(R.id.main_fragment, new f1(), "MAIN_FRAGMENT_TAG");
        aVar.f1744f = 4097;
        aVar.d();
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        int i3;
        View inflate = layoutInflater.inflate(R.layout.fragment_home_single_page, viewGroup, false);
        int i4 = R.id.check_exposure_status_section;
        ViewFlipper viewFlipper = (ViewFlipper) inflate.findViewById(R.id.check_exposure_status_section);
        if (viewFlipper != null) {
            i4 = R.id.check_exposure_status_section_title;
            TextView textView = (TextView) inflate.findViewById(R.id.check_exposure_status_section_title);
            if (textView != null) {
                i4 = R.id.en_status_flipper;
                ViewFlipper viewFlipper2 = (ViewFlipper) inflate.findViewById(R.id.en_status_flipper);
                if (viewFlipper2 != null) {
                    i4 = R.id.have_questions_section_title;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.have_questions_section_title);
                    if (textView2 != null) {
                        i4 = R.id.help_protect_community_section_title;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.help_protect_community_section_title);
                        if (textView3 != null) {
                            i4 = R.id.learn_how_en_works_layout;
                            View findViewById = inflate.findViewById(R.id.learn_how_en_works_layout);
                            if (findViewById != null) {
                                MaterialCardView materialCardView = (MaterialCardView) findViewById;
                                b bVar = new b(materialCardView, materialCardView);
                                ViewFlipper viewFlipper3 = (ViewFlipper) inflate.findViewById(R.id.main_ui_flipper);
                                if (viewFlipper3 != null) {
                                    View findViewById2 = inflate.findViewById(R.id.no_exposure_checkmark);
                                    if (findViewById2 != null) {
                                        ImageView imageView = (ImageView) findViewById2.findViewById(R.id.pulse_large);
                                        if (imageView != null) {
                                            ImageView imageView2 = (ImageView) findViewById2.findViewById(R.id.pulse_medium);
                                            if (imageView2 != null) {
                                                ImageView imageView3 = (ImageView) findViewById2.findViewById(R.id.pulse_small);
                                                if (imageView3 != null) {
                                                    p0 p0Var = new p0((FrameLayout) findViewById2, imageView, imageView2, imageView3);
                                                    View findViewById3 = inflate.findViewById(R.id.no_recent_exposure_layout);
                                                    if (findViewById3 != null) {
                                                        c a = c.a(findViewById3);
                                                        View findViewById4 = inflate.findViewById(R.id.no_recent_exposure_secondary_layout);
                                                        if (findViewById4 != null) {
                                                            c a2 = c.a(findViewById4);
                                                            View findViewById5 = inflate.findViewById(R.id.possible_exposure_layout);
                                                            if (findViewById5 != null) {
                                                                e a3 = e.a(findViewById5);
                                                                View findViewById6 = inflate.findViewById(R.id.possible_exposure_secondary_layout);
                                                                if (findViewById6 != null) {
                                                                    e a4 = e.a(findViewById6);
                                                                    View findViewById7 = inflate.findViewById(R.id.secondary_share_test_result_card);
                                                                    if (findViewById7 != null) {
                                                                        MaterialCardView materialCardView2 = (MaterialCardView) findViewById7;
                                                                        int i5 = R.id.notify_others_button;
                                                                        Button button = (Button) findViewById7.findViewById(R.id.notify_others_button);
                                                                        if (button != null) {
                                                                            Button button2 = (Button) findViewById7.findViewById(R.id.see_history_button);
                                                                            if (button2 != null) {
                                                                                h hVar = new h(materialCardView2, materialCardView2, button, button2);
                                                                                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.secondary_share_test_result_layout);
                                                                                if (linearLayout != null) {
                                                                                    ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.settings_button);
                                                                                    if (imageButton != null) {
                                                                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.share_app_layout);
                                                                                        if (linearLayout2 != null) {
                                                                                            View findViewById8 = inflate.findViewById(R.id.share_test_result_card);
                                                                                            if (findViewById8 != null) {
                                                                                                Button button3 = (Button) findViewById8.findViewById(R.id.notify_others_button);
                                                                                                if (button3 != null) {
                                                                                                    Button button4 = (Button) findViewById8.findViewById(R.id.see_history_button);
                                                                                                    if (button4 != null) {
                                                                                                        MaterialCardView materialCardView3 = (MaterialCardView) findViewById8;
                                                                                                        g gVar = new g(materialCardView3, button3, button4, materialCardView3);
                                                                                                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.single_page_edge_case_fragment);
                                                                                                        if (frameLayout != null) {
                                                                                                            LinearLayout linearLayout3 = (LinearLayout) inflate;
                                                                                                            this.b0 = new p(linearLayout3, viewFlipper, textView, viewFlipper2, textView2, textView3, bVar, viewFlipper3, p0Var, a, a2, a3, a4, hVar, linearLayout, imageButton, linearLayout2, gVar, frameLayout);
                                                                                                            return linearLayout3;
                                                                                                        }
                                                                                                        i2 = R.id.single_page_edge_case_fragment;
                                                                                                    } else {
                                                                                                        i5 = R.id.see_history_button;
                                                                                                    }
                                                                                                }
                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(findViewById8.getResources().getResourceName(i5)));
                                                                                            }
                                                                                            i2 = R.id.share_test_result_card;
                                                                                        } else {
                                                                                            i2 = R.id.share_app_layout;
                                                                                        }
                                                                                    } else {
                                                                                        i2 = R.id.settings_button;
                                                                                    }
                                                                                } else {
                                                                                    i2 = R.id.secondary_share_test_result_layout;
                                                                                }
                                                                            } else {
                                                                                i5 = R.id.see_history_button;
                                                                            }
                                                                        }
                                                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById7.getResources().getResourceName(i5)));
                                                                    }
                                                                    i2 = R.id.secondary_share_test_result_card;
                                                                } else {
                                                                    i2 = R.id.possible_exposure_secondary_layout;
                                                                }
                                                            } else {
                                                                i2 = R.id.possible_exposure_layout;
                                                            }
                                                        } else {
                                                            i2 = R.id.no_recent_exposure_secondary_layout;
                                                        }
                                                    } else {
                                                        i2 = R.id.no_recent_exposure_layout;
                                                    }
                                                    throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
                                                }
                                                i3 = R.id.pulse_small;
                                            } else {
                                                i3 = R.id.pulse_medium;
                                            }
                                        } else {
                                            i3 = R.id.pulse_large;
                                        }
                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById2.getResources().getResourceName(i3)));
                                    }
                                    i4 = R.id.no_exposure_checkmark;
                                } else {
                                    i4 = R.id.main_ui_flipper;
                                }
                                i2 = i4;
                                throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
                            }
                        }
                    }
                }
            }
        }
        i2 = i4;
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.n.a.m
    public void g0() {
        this.D = true;
        this.W.c();
    }

    @Override // f.b.a.a.a.w.z0, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        r s0 = s0();
        Context t0 = t0();
        f.b.a.a.a.s.d0.a aVar = a0.a;
        s0.setTitle(t0.getString(R.string.app_title));
        e0 h2 = h();
        this.c0 = (ExposureHomeViewModel) new f0(s0()).a(ExposureHomeViewModel.class);
        NotifyHomeViewModel notifyHomeViewModel = (NotifyHomeViewModel) new f0(s0()).a(NotifyHomeViewModel.class);
        if (m.e.N0(j())) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.W;
            if (exposureNotificationViewModel.w == null) {
                exposureNotificationViewModel.w = m.e.U(m.e.R0(new w(exposureNotificationViewModel.f341f, m.e.R0(new w(exposureNotificationViewModel.f345j.f2319k, exposureNotificationViewModel.f344i), n.a)), v.a));
            }
            exposureNotificationViewModel.w.f(G(), new h0(this));
        }
        this.b0.p.setOnClickListener(new z(this));
        this.b0.f2416l.f2365e.setOnClickListener(new e0(this));
        this.b0.f2416l.f2364d.setVisibility(0);
        this.b0.f2416l.f2365e.setVisibility(0);
        this.b0.r.b.setOnClickListener(new c0(this));
        this.b0.r.c.setOnClickListener(new k0(this));
        this.b0.f2414j.f2352f.setOnClickListener(new b0(this));
        this.b0.f2414j.f2351e.setVisibility(0);
        this.b0.f2414j.f2352f.setVisibility(0);
        this.b0.n.c.setOnClickListener(new g0(this));
        this.b0.n.b.setOnClickListener(new a0(this));
        this.b0.n.f2381d.setOnClickListener(new i0(this));
        this.b0.q.setOnClickListener(new o0(this));
        this.b0.f2411g.b.setOnClickListener(new f0(this));
        this.b0.f2415k.f2350d.setOnClickListener(new j0(this));
        this.b0.m.c.setOnClickListener(new l0(this));
        int dimension = (int) A().getDimension(R.dimen.padding_small);
        this.b0.f2414j.b.setPadding(0, dimension, 0, 0);
        this.b0.f2416l.b.setPadding(0, dimension, 0, 0);
        ExposureNotificationViewModel exposureNotificationViewModel2 = this.W;
        new c0(exposureNotificationViewModel2.c, this.c0.c.f2316h, exposureNotificationViewModel2.p).f(G(), new l(new m0(this)));
        this.c0.f336e.f(G(), new d0(this));
        notifyHomeViewModel.f395d.f(G(), new n0(this));
        this.d0 = AnimationUtils.loadAnimation(t0(), R.anim.pulsation_small);
        this.e0 = AnimationUtils.loadAnimation(t0(), R.anim.pulsation_medium);
        this.f0 = AnimationUtils.loadAnimation(t0(), R.anim.pulsation_large);
        this.b0.f2413i.f2417d.startAnimation(this.d0);
        this.b0.f2413i.c.startAnimation(this.e0);
        this.b0.f2413i.b.startAnimation(this.f0);
        if (h2.H(R.id.edge_case_fragment) == null) {
            f.b.a.a.a.u.p pVar = new f.b.a.a.a.u.p();
            f.b.a.a.a.u.l.L0(pVar, true, false);
            e.n.a.a aVar2 = new e.n.a.a(h2);
            aVar2.f(R.id.single_page_edge_case_fragment, pVar, null);
            aVar2.d();
        }
        ExposureHomeViewModel exposureHomeViewModel = this.c0;
        Context t02 = t0();
        Objects.requireNonNull(exposureHomeViewModel.f335d);
        new n(t02).b.cancel(null, 1);
        e.b0.w wVar = exposureHomeViewModel.f338g;
        d dVar = RestoreNotificationWorker.f427j;
        wVar.b("RestoreNotificationWork");
    }
}
