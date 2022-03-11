package f.b.a.a.a.x;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import androidx.biometric.BiometricPrompt$ResetCallbackObserver;
import androidx.biometric.R$string;
import com.google.android.apps.exposurenotification.exposure.ExposureHomeViewModel;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.apps.exposurenotification.restore.RestoreNotificationWorker;
import com.google.android.material.card.MaterialCardView;
import e.b.a.m;
import e.c0.q;
import e.d.e;
import e.d.p;
import e.d.t;
import e.d.u;
import e.d.w;
import e.o.a.e0;
import e.o.a.r;
import e.r.f0;
import f.b.a.a.a.e0.c7;
import f.b.a.a.a.e0.l6;
import f.b.a.a.a.h0.n;
import f.b.a.a.a.j0.d;
import f.b.a.a.a.l0.b1;
import f.b.a.a.a.n0.j0;
import f.b.a.a.a.n0.u0;
import f.b.a.a.a.t.i0;
import f.b.a.a.a.t.m0;
import f.b.a.a.a.t.o0;
import f.b.a.a.a.t.x;
import f.b.a.a.a.t.y;
import f.b.a.a.a.u.c;
import f.b.a.a.a.u.f;
import f.b.a.a.a.u.h;
import f.b.a.a.a.u.i;
import f.b.a.a.a.u.q;
import f.b.a.a.a.u.s0;
import f.b.a.a.a.v.l;
import f.b.a.a.a.w.k;
import f.b.a.a.a.w.o;
import f.b.a.a.a.x.g1;
import f.b.a.c.b.o.b;
import f.b.b.f.a.s;
import gov.nm.covid19.exposurenotifications.R;
import java.util.List;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class g1 extends e1 {
    public static final /* synthetic */ int j0;
    public q b0;
    public ExposureHomeViewModel c0;
    public Animation d0;
    public Animation e0;
    public Animation f0;
    public boolean g0;
    public f.b.a.a.a.t.q0.a h0;
    public y i0 = new a();

    /* loaded from: classes.dex */
    public class a implements y {
        public a() {
            g1.this = r1;
        }

        public void a(boolean z) {
            if (z) {
                g1 g1Var = g1.this;
                int i2 = g1.j0;
                Objects.requireNonNull(g1Var);
                c7 c7Var = new c7();
                r u0 = g1Var.u0();
                b.o(u0 instanceof z0);
                ((z0) u0).B(c7Var);
            } else {
                g1.this.g0 = false;
            }
            m.e.Y0(g1.this.u0(), g1.this.b0.a);
        }
    }

    public static void M0(e.o.a.m mVar) {
        mVar.w().Y(null, 1);
        e.o.a.a aVar = new e.o.a.a(mVar.w());
        aVar.g(R.id.main_fragment, new g1(), "MAIN_FRAGMENT_TAG");
        aVar.f1829f = 4097;
        aVar.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void L0() {
        boolean z;
        u uVar;
        r u0 = u0();
        b.o(u0 instanceof z0);
        z0 z0Var = (z0) u0;
        if (new p(new p.a(z0Var)).a(33023) != 0) {
            KeyguardManager keyguardManager = (KeyguardManager) z0Var.getSystemService("keyguard");
            if (Build.VERSION.SDK_INT < 23 ? keyguardManager == null || !keyguardManager.isKeyguardSecure() : keyguardManager == null || !keyguardManager.isDeviceSecure()) {
                z = false;
                if (z) {
                    c7 c7Var = new c7();
                    r u02 = u0();
                    b.o(u02 instanceof z0);
                    ((z0) u02).B(c7Var);
                    return;
                }
                this.g0 = true;
                x xVar = new x(this.i0);
                r g2 = g();
                e0 j2 = j();
                String str = null;
                u uVar2 = g2 != null ? (u) new f0(g2).a(u.class) : null;
                if (uVar2 != null) {
                    this.O.a(new BiometricPrompt$ResetCallbackObserver(uVar2));
                }
                if (uVar2 != null) {
                    uVar2.f1265d = xVar;
                }
                String string = v0().getResources().getString(R.string.see_history_device_authentication_title);
                if (TextUtils.isEmpty(string)) {
                    throw new IllegalArgumentException("Title must be set and non-empty.");
                } else if (m.e.T0(33023)) {
                    boolean N0 = m.e.N0(33023);
                    if (TextUtils.isEmpty(null) && !N0) {
                        throw new IllegalArgumentException("Negative text must be set and non-empty.");
                    } else if (TextUtils.isEmpty(null) || !N0) {
                        t tVar = new t(string, null, null, null, true, false, 33023);
                        if (j2 != null && !j2.T()) {
                            e eVar = (e) j2.I("androidx.biometric.BiometricFragment");
                            if (eVar == null) {
                                eVar = new e();
                                e.o.a.a aVar = new e.o.a.a(j2);
                                aVar.f(0, eVar, "androidx.biometric.BiometricFragment", 1);
                                aVar.e();
                                j2.C(true);
                                j2.J();
                            }
                            r g3 = eVar.g();
                            if (g3 != null) {
                                u uVar3 = eVar.X;
                                uVar3.f1266e = tVar;
                                int i2 = tVar.b;
                                if (i2 == 0) {
                                    i2 = 255;
                                }
                                int i3 = Build.VERSION.SDK_INT;
                                if (i3 < 23 || i3 >= 30 || i2 != 15) {
                                    uVar3.f1267f = null;
                                } else {
                                    uVar3.f1267f = w.a();
                                }
                                if (eVar.K0()) {
                                    uVar = eVar.X;
                                    str = eVar.F(R$string.confirm_device_credential_password);
                                } else {
                                    uVar = eVar.X;
                                }
                                uVar.f1271j = str;
                                if (eVar.K0() && new p(new p.a(g3)).a(255) != 0) {
                                    eVar.X.m = true;
                                    eVar.M0();
                                    return;
                                } else if (eVar.X.o) {
                                    eVar.W.postDelayed(new e.c(eVar), 600);
                                    return;
                                } else {
                                    eVar.Q0();
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        throw new IllegalArgumentException("Negative text must not be set if device credential authentication is allowed.");
                    }
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("Authenticator combination is unsupported on API ");
                    h2.append(Build.VERSION.SDK_INT);
                    h2.append(": ");
                    h2.append("BIOMETRIC_WEAK | DEVICE_CREDENTIAL");
                    throw new IllegalArgumentException(h2.toString());
                }
            }
        }
        z = true;
        if (z) {
        }
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                        i4 = R.id.health_authority_turndown_content;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.health_authority_turndown_content);
                        if (textView3 != null) {
                            i4 = R.id.help_protect_community_section_title;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.help_protect_community_section_title);
                            if (textView4 != null) {
                                i4 = R.id.learn_how_en_works;
                                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.learn_how_en_works);
                                if (linearLayout != null) {
                                    i4 = R.id.learn_how_en_works_layout;
                                    View findViewById = inflate.findViewById(R.id.learn_how_en_works_layout);
                                    if (findViewById != null) {
                                        MaterialCardView materialCardView = (MaterialCardView) findViewById;
                                        f.b.a.a.a.u.b bVar = new f.b.a.a.a.u.b(materialCardView, materialCardView);
                                        i4 = R.id.main_ui_flipper;
                                        ViewFlipper viewFlipper3 = (ViewFlipper) inflate.findViewById(R.id.main_ui_flipper);
                                        if (viewFlipper3 != null) {
                                            i4 = R.id.no_exposure_checkmark;
                                            View findViewById2 = inflate.findViewById(R.id.no_exposure_checkmark);
                                            if (findViewById2 != null) {
                                                ImageView imageView = (ImageView) findViewById2.findViewById(R.id.pulse_large);
                                                if (imageView != null) {
                                                    ImageView imageView2 = (ImageView) findViewById2.findViewById(R.id.pulse_medium);
                                                    if (imageView2 != null) {
                                                        ImageView imageView3 = (ImageView) findViewById2.findViewById(R.id.pulse_small);
                                                        if (imageView3 != null) {
                                                            s0 s0Var = new s0((FrameLayout) findViewById2, imageView, imageView2, imageView3);
                                                            View findViewById3 = inflate.findViewById(R.id.no_recent_exposure_layout);
                                                            if (findViewById3 != null) {
                                                                c a2 = c.a(findViewById3);
                                                                View findViewById4 = inflate.findViewById(R.id.no_recent_exposure_secondary_layout);
                                                                if (findViewById4 != null) {
                                                                    c a3 = c.a(findViewById4);
                                                                    View findViewById5 = inflate.findViewById(R.id.possible_exposure_layout);
                                                                    if (findViewById5 != null) {
                                                                        f.b.a.a.a.u.e a4 = f.b.a.a.a.u.e.a(findViewById5);
                                                                        View findViewById6 = inflate.findViewById(R.id.possible_exposure_secondary_layout);
                                                                        if (findViewById6 != null) {
                                                                            f.b.a.a.a.u.e a5 = f.b.a.a.a.u.e.a(findViewById6);
                                                                            View findViewById7 = inflate.findViewById(R.id.secondary_share_test_result_card);
                                                                            if (findViewById7 != null) {
                                                                                MaterialCardView materialCardView2 = (MaterialCardView) findViewById7;
                                                                                int i5 = R.id.notify_others_button;
                                                                                Button button = (Button) findViewById7.findViewById(R.id.notify_others_button);
                                                                                if (button != null) {
                                                                                    Button button2 = (Button) findViewById7.findViewById(R.id.see_history_button);
                                                                                    if (button2 != null) {
                                                                                        i iVar = new i(materialCardView2, materialCardView2, button, button2);
                                                                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.secondary_share_test_result_layout);
                                                                                        if (linearLayout2 != null) {
                                                                                            LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.see_test_results_in_turndown);
                                                                                            if (linearLayout3 != null) {
                                                                                                i2 = R.id.see_test_results_in_turndown_card;
                                                                                                View findViewById8 = inflate.findViewById(R.id.see_test_results_in_turndown_card);
                                                                                                if (findViewById8 != null) {
                                                                                                    MaterialCardView materialCardView3 = (MaterialCardView) findViewById8;
                                                                                                    f fVar = new f(materialCardView3, materialCardView3);
                                                                                                    i2 = R.id.settings_button;
                                                                                                    ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.settings_button);
                                                                                                    if (imageButton != null) {
                                                                                                        LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.share_app_layout);
                                                                                                        if (linearLayout4 != null) {
                                                                                                            i2 = R.id.share_test_result_card;
                                                                                                            View findViewById9 = inflate.findViewById(R.id.share_test_result_card);
                                                                                                            if (findViewById9 != null) {
                                                                                                                Button button3 = (Button) findViewById9.findViewById(R.id.notify_others_button);
                                                                                                                if (button3 != null) {
                                                                                                                    Button button4 = (Button) findViewById9.findViewById(R.id.see_history_button);
                                                                                                                    if (button4 != null) {
                                                                                                                        MaterialCardView materialCardView4 = (MaterialCardView) findViewById9;
                                                                                                                        h hVar = new h(materialCardView4, button3, button4, materialCardView4);
                                                                                                                        i2 = R.id.single_page_edge_case_fragment;
                                                                                                                        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.single_page_edge_case_fragment);
                                                                                                                        if (frameLayout != null) {
                                                                                                                            LinearLayout linearLayout5 = (LinearLayout) inflate;
                                                                                                                            this.b0 = new q(linearLayout5, viewFlipper, textView, viewFlipper2, textView2, textView3, textView4, linearLayout, bVar, viewFlipper3, s0Var, a2, a3, a4, a5, iVar, linearLayout2, linearLayout3, fVar, imageButton, linearLayout4, hVar, frameLayout);
                                                                                                                            return linearLayout5;
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        i5 = R.id.see_history_button;
                                                                                                                    }
                                                                                                                }
                                                                                                                throw new NullPointerException("Missing required view with ID: ".concat(findViewById9.getResources().getResourceName(i5)));
                                                                                                            }
                                                                                                        } else {
                                                                                                            i2 = R.id.share_app_layout;
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                i2 = R.id.see_test_results_in_turndown;
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
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        i2 = i4;
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.b0 = null;
    }

    @Override // e.o.a.m
    public void i0() {
        this.D = true;
        this.W.c();
    }

    @Override // e.o.a.m
    public void j0(Bundle bundle) {
        bundle.putBoolean("is_biometric_prompt_showing", this.g0);
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        r u0 = u0();
        Context v0 = v0();
        f.b.a.a.a.t.p0.a aVar = m0.a;
        u0.setTitle(v0.getString(R.string.app_title));
        e0 j2 = j();
        this.c0 = (ExposureHomeViewModel) new f0(u0()).a(ExposureHomeViewModel.class);
        if (m.e.S0(k())) {
            ExposureNotificationViewModel exposureNotificationViewModel = this.W;
            if (exposureNotificationViewModel.w == null) {
                exposureNotificationViewModel.w = m.e.V(m.e.X0(new i0(exposureNotificationViewModel.f343f, m.e.X0(new i0(exposureNotificationViewModel.f347j.f2320k, exposureNotificationViewModel.f346i), n.a)), v.a));
            }
            exposureNotificationViewModel.w.f(H(), new e.r.t() { // from class: f.b.a.a.a.x.h0
                @Override // e.r.t
                public final void a(Object obj) {
                    g1 g1Var = g1.this;
                    Objects.requireNonNull(g1Var);
                    if (((Boolean) obj).booleanValue()) {
                        g1Var.W.f347j.a.edit().putBoolean("ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", true).apply();
                        new i1().K0(g1Var.j(), "SmsInterceptNoticeDialogFragment");
                    }
                }
            });
        }
        this.b0.t.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                b1 b1Var = new b1();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(b1Var);
            }
        });
        this.b0.n.f2410e.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                o oVar = new o();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(oVar);
            }
        });
        this.b0.n.f2409d.setVisibility(0);
        this.b0.n.f2410e.setVisibility(0);
        this.b0.v.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                l6 l6Var = new l6();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(l6Var);
            }
        });
        this.b0.v.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1.this.L0();
            }
        });
        this.b0.f2473l.f2397f.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                k kVar = new k();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(kVar);
            }
        });
        this.b0.f2473l.f2396e.setVisibility(0);
        this.b0.f2473l.f2397f.setVisibility(0);
        this.b0.p.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                l6 l6Var = new l6();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(l6Var);
            }
        });
        this.b0.p.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                l6 l6Var = new l6();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(l6Var);
            }
        });
        this.b0.p.f2434d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1.this.L0();
            }
        });
        this.b0.u.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", g1Var.k().getString(R.string.settings_share_message, String.format(g1Var.k().getString(R.string.share_this_app_link), "gov.nm.covid19.exposurenotifications")));
                g1Var.F0(Intent.createChooser(intent, null));
                g1Var.W.s.a(n.c.SHARE_APP_CLICKED);
            }
        });
        this.b0.f2470i.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                f.b.a.a.a.o0.b.a(g1Var.w0(), g1Var.F(R.string.how_exposure_notifications_work_actual_link));
            }
        });
        this.b0.m.f2395d.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                k kVar = new k();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(kVar);
            }
        });
        this.b0.o.c.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1 g1Var = g1.this;
                Objects.requireNonNull(g1Var);
                o oVar = new o();
                r u02 = g1Var.u0();
                b.o(u02 instanceof z0);
                ((z0) u02).B(oVar);
            }
        });
        this.b0.s.b.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.x.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g1.this.L0();
            }
        });
        int dimension = (int) B().getDimension(R.dimen.padding_small);
        this.b0.f2473l.b.setPadding(0, dimension, 0, 0);
        this.b0.n.b.setPadding(0, dimension, 0, 0);
        ExposureNotificationViewModel exposureNotificationViewModel2 = this.W;
        new o0(exposureNotificationViewModel2.c, this.c0.c.f2317h, exposureNotificationViewModel2.p).f(H(), new e.r.t() { // from class: f.b.a.a.a.t.u
            @Override // e.r.t
            public final void a(Object obj) {
                o0.a aVar2 = o0.a.this;
                j.e eVar = (j.e) obj;
                A a2 = eVar.b;
                B b = eVar.c;
                C c = eVar.f4570d;
                g1 g1Var = ((f.b.a.a.a.x.m0) aVar2).a;
                ExposureNotificationViewModel.b bVar = (ExposureNotificationViewModel.b) a2;
                d dVar = (d) b;
                j0 j0Var = (j0) c;
                if (g1Var.b0 != null) {
                    int i2 = 1;
                    int i3 = 0;
                    int i4 = bVar == ExposureNotificationViewModel.b.ENABLED ? 1 : 0;
                    ExposureNotificationViewModel.b bVar2 = ExposureNotificationViewModel.b.PAUSED_NOT_IN_ALLOWLIST;
                    boolean z = (bVar == bVar2) && (TextUtils.isEmpty(g1Var.v0().getString(R.string.turndown_agency_message)) ^ true);
                    boolean z2 = bVar == ExposureNotificationViewModel.b.PAUSED_EN_NOT_SUPPORT || bVar == bVar2;
                    boolean equals = ShareDiagnosisViewModel.X.equals(j0Var);
                    int i5 = ((dVar.b() != 0 || Boolean.valueOf(g1Var.c0.c.g()).booleanValue()) && g1Var.c0.f335d.e()) ? 0 : 1;
                    int i6 = i4 ^ 1;
                    g1Var.b0.f2465d.setDisplayedChild(i6);
                    g1Var.b0.b.setDisplayedChild(i5 ^ 1);
                    Button button = g1Var.b0.v.b;
                    Objects.requireNonNull(g1Var.W);
                    Set<ExposureNotificationViewModel.b> set = ShareDiagnosisViewModel.W;
                    button.setEnabled(!set.contains(bVar));
                    Button button2 = g1Var.b0.p.c;
                    Objects.requireNonNull(g1Var.W);
                    button2.setEnabled(!set.contains(bVar));
                    int i7 = 8;
                    if (equals) {
                        ViewFlipper viewFlipper = g1Var.b0.f2465d;
                        if (i5 != 0) {
                            viewFlipper.setVisibility(8);
                            g1Var.b0.f2471j.setDisplayedChild(i6);
                        } else {
                            viewFlipper.setVisibility(0);
                            g1Var.b0.f2471j.setDisplayedChild(2);
                        }
                        LinearLayout linearLayout = g1Var.b0.r;
                        if (z2) {
                            linearLayout.setVisibility(0);
                            TextView textView = g1Var.b0.f2467f;
                            if (!z) {
                                i3 = 8;
                            }
                            textView.setVisibility(i3);
                            g1Var.b0.q.setVisibility(8);
                            g1Var.b0.f2466e.setVisibility(8);
                            g1Var.b0.f2469h.setVisibility(8);
                            g1Var.b0.f2468g.setVisibility(8);
                            g1Var.b0.u.setVisibility(8);
                        } else {
                            linearLayout.setVisibility(8);
                            g1Var.b0.f2467f.setVisibility(8);
                            g1Var.b0.q.setVisibility(0);
                            g1Var.b0.f2466e.setVisibility(0);
                            g1Var.b0.f2469h.setVisibility(0);
                            g1Var.b0.f2468g.setVisibility(0);
                            g1Var.b0.u.setVisibility(0);
                        }
                        g1Var.b0.c.setVisibility(8);
                        g1Var.b0.b.setVisibility(8);
                        g1Var.b0.p.c.setVisibility(8);
                        g1Var.b0.p.b.setEnabled(true);
                        g1Var.b0.p.b.setImportantForAccessibility(1);
                        return;
                    }
                    int i8 = 3;
                    if (i5 != 0) {
                        g1Var.b0.f2465d.setVisibility(i4 != 0 ? 0 : 8);
                        ViewFlipper viewFlipper2 = g1Var.b0.f2471j;
                        if (i4 != 0) {
                            i2 = 3;
                        }
                        viewFlipper2.setDisplayedChild(i2);
                    } else {
                        g1Var.b0.f2465d.setVisibility(0);
                        ViewFlipper viewFlipper3 = g1Var.b0.f2471j;
                        if (i4 == 0) {
                            i8 = 2;
                        }
                        viewFlipper3.setDisplayedChild(i8);
                    }
                    LinearLayout linearLayout2 = g1Var.b0.r;
                    if (z2) {
                        linearLayout2.setVisibility(0);
                        TextView textView2 = g1Var.b0.f2467f;
                        if (!z) {
                            i3 = 8;
                        }
                        textView2.setVisibility(i3);
                        g1Var.b0.q.setVisibility(8);
                        g1Var.b0.f2466e.setVisibility(8);
                        g1Var.b0.c.setVisibility(8);
                        g1Var.b0.b.setVisibility(8);
                        return;
                    }
                    linearLayout2.setVisibility(8);
                    g1Var.b0.f2467f.setVisibility(8);
                    g1Var.b0.f2469h.setVisibility(0);
                    g1Var.b0.f2468g.setVisibility(0);
                    g1Var.b0.u.setVisibility(0);
                    g1Var.b0.q.setVisibility(i4 != 0 ? 8 : 0);
                    g1Var.b0.f2466e.setVisibility(i4 != 0 ? 8 : 0);
                    g1Var.b0.c.setVisibility(i4 != 0 ? 0 : 8);
                    ViewFlipper viewFlipper4 = g1Var.b0.b;
                    if (i4 != 0) {
                        i7 = 0;
                    }
                    viewFlipper4.setVisibility(i7);
                    g1Var.b0.p.c.setVisibility(0);
                    g1Var.b0.p.b.setEnabled(false);
                    g1Var.b0.p.b.setImportantForAccessibility(2);
                }
            }
        });
        this.c0.f337f.f(H(), new e.r.t() { // from class: f.b.a.a.a.x.n0
            @Override // e.r.t
            public final void a(Object obj) {
                g1 g1Var = g1.this;
                List list = (List) obj;
                Objects.requireNonNull(g1Var);
                if (!list.isEmpty()) {
                    String a2 = m0.a(((u0) list.get(0)).a().G(), g1Var.h0.c(), g1Var.h0.b(), g1Var.v0());
                    g1Var.b0.f2473l.c.setText(g1Var.G(R.string.no_recent_exposure_card_content, a2));
                    g1Var.b0.m.c.setText(g1Var.G(R.string.no_recent_exposure_card_content, a2));
                    return;
                }
                g1Var.b0.f2473l.c.setText(g1Var.F(R.string.no_recent_exposure_card_content_no_checks));
                g1Var.b0.m.c.setText(g1Var.F(R.string.no_recent_exposure_card_content_no_checks));
            }
        });
        this.d0 = AnimationUtils.loadAnimation(v0(), R.anim.pulsation_small);
        this.e0 = AnimationUtils.loadAnimation(v0(), R.anim.pulsation_medium);
        this.f0 = AnimationUtils.loadAnimation(v0(), R.anim.pulsation_large);
        this.b0.f2472k.f2475d.startAnimation(this.d0);
        this.b0.f2472k.c.startAnimation(this.e0);
        this.b0.f2472k.b.startAnimation(this.f0);
        u uVar = null;
        if (j2.H(R.id.edge_case_fragment) == null) {
            f.b.a.a.a.v.p pVar = new f.b.a.a.a.v.p();
            l.O0(pVar, true, false);
            e.o.a.a aVar2 = new e.o.a.a(j2);
            aVar2.g(R.id.single_page_edge_case_fragment, pVar, null);
            aVar2.d();
        }
        ExposureHomeViewModel exposureHomeViewModel = this.c0;
        Context v02 = v0();
        e.c0.w wVar = exposureHomeViewModel.f339h;
        l.b.a.d dVar = RestoreNotificationWorker.m;
        f.b.b.f.a.l.x(((e.c0.a0.c) wVar.b("RestoreNotificationWork")).f1081d).z(new f.b.b.f.a.i(v02) { // from class: f.b.a.a.a.w.c
            public final /* synthetic */ Context b;

            {
                this.b = r2;
            }

            @Override // f.b.b.f.a.i
            public final f.b.b.f.a.u a(Object obj) {
                ExposureHomeViewModel exposureHomeViewModel2 = ExposureHomeViewModel.this;
                Context context = this.b;
                q.b.c cVar = (q.b.c) obj;
                Objects.requireNonNull(exposureHomeViewModel2.f336e);
                new e.j.a.n(context).b.cancel(null, 1);
                return s.c;
            }
        }, exposureHomeViewModel.f340i);
        if (bundle != null && bundle.getBoolean("is_biometric_prompt_showing", false)) {
            this.g0 = true;
            x xVar = new x(this.i0);
            r g2 = g();
            j();
            if (g2 != null) {
                uVar = (u) new f0(g2).a(u.class);
            }
            if (uVar != null) {
                this.O.a(new BiometricPrompt$ResetCallbackObserver(uVar));
            }
            if (uVar != null) {
                uVar.f1265d = xVar;
            }
        }
    }
}
