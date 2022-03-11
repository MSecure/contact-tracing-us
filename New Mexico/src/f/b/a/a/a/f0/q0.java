package f.b.a.a.a.f0;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.home.ExposureNotificationViewModel;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.r.t;
import f.a.a.a.a;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.u.u;
import f.b.a.a.a.x.g1;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class q0 extends j0 {
    public u g0;
    public ExposureNotificationViewModel.b h0;
    public LinearLayout i0;
    public Button j0;
    public NestedScrollView k0;
    public boolean l0 = false;

    @Override // f.b.a.a.a.f0.f0
    public void J0() {
        a.o(this.a0.f424d.a, "ExposureNotificationSharedPreferences.IS_IN_APP_SMS_NOTICE_SEEN", true);
        if (ExposureNotificationViewModel.b.STORAGE_LOW.equals(this.h0)) {
            K0();
        } else {
            this.W.f();
        }
    }

    @Override // f.b.a.a.a.f0.f0
    public void M0() {
        this.a0.d(false);
        g1.M0(this);
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_disabled, viewGroup, false);
        int i2 = R.id.app_analytics_detail;
        TextView textView = (TextView) inflate.findViewById(R.id.app_analytics_detail);
        if (textView != null) {
            i2 = R.id.onboarding_app_analytics_switch;
            SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.onboarding_app_analytics_switch);
            if (switchMaterial != null) {
                i2 = R.id.onboarding_buttons;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.onboarding_buttons);
                if (linearLayout != null) {
                    i2 = R.id.onboarding_buttons_loading_switcher;
                    ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.onboarding_buttons_loading_switcher);
                    if (viewSwitcher != null) {
                        i2 = R.id.onboarding_exposure_notifications_detail;
                        TextView textView2 = (TextView) inflate.findViewById(R.id.onboarding_exposure_notifications_detail);
                        if (textView2 != null) {
                            i2 = R.id.onboarding_next_button;
                            Button button = (Button) inflate.findViewById(R.id.onboarding_next_button);
                            if (button != null) {
                                i2 = R.id.onboarding_no_thanks_button;
                                Button button2 = (Button) inflate.findViewById(R.id.onboarding_no_thanks_button);
                                if (button2 != null) {
                                    i2 = R.id.onboarding_progress_bar;
                                    ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.onboarding_progress_bar);
                                    if (progressBar != null) {
                                        i2 = R.id.onboarding_scroll;
                                        NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                                        if (nestedScrollView != null) {
                                            LinearLayout linearLayout2 = (LinearLayout) inflate;
                                            this.g0 = new u(linearLayout2, textView, switchMaterial, linearLayout, viewSwitcher, textView2, button, button2, progressBar, nestedScrollView);
                                            return linearLayout2;
                                        }
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

    @Override // e.o.a.m
    public void X() {
        this.D = true;
        this.g0 = null;
    }

    @Override // f.b.a.a.a.f0.f0, f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        u uVar = this.g0;
        this.i0 = uVar.f2476d;
        this.j0 = uVar.f2479g;
        this.k0 = uVar.f2482j;
        String F = F(R.string.learn_more);
        String F2 = F(R.string.app_analytics_link);
        f.b.a.a.a.t.p0.a aVar = b.a;
        f.b.a.a.a.o0.a aVar2 = new f.b.a.a.a.o0.a(F2);
        String G = G(R.string.onboarding_metrics_description, F);
        SpannableString spannableString = new SpannableString(G);
        int indexOf = G.indexOf(F);
        spannableString.setSpan(aVar2, indexOf, F.length() + indexOf, 33);
        this.g0.b.setText(spannableString);
        this.g0.b.setMovementMethod(LinkMovementMethod.getInstance());
        String F3 = F(R.string.learn_more);
        f.b.a.a.a.o0.a aVar3 = new f.b.a.a.a.o0.a(F(R.string.en_notification_info_link));
        String G2 = G(R.string.onboarding_exposure_notifications_description, F3);
        SpannableString spannableString2 = new SpannableString(G2);
        int indexOf2 = G2.indexOf(F3);
        spannableString2.setSpan(aVar3, indexOf2, F3.length() + indexOf2, 33);
        this.g0.f2478f.setText(spannableString2);
        this.g0.f2478f.setMovementMethod(LinkMovementMethod.getInstance());
        NestedScrollView nestedScrollView = this.k0;
        LinearLayout linearLayout = this.i0;
        Button button = this.j0;
        N0(nestedScrollView, linearLayout, button, false);
        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b(nestedScrollView, linearLayout, button) { // from class: f.b.a.a.a.f0.c
            public final /* synthetic */ NestedScrollView b;
            public final /* synthetic */ LinearLayout c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ Button f2235d;

            {
                this.b = r2;
                this.c = r3;
                this.f2235d = r4;
            }

            @Override // androidx.core.widget.NestedScrollView.b
            public final void a(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                f0 f0Var = f0.this;
                NestedScrollView nestedScrollView3 = this.b;
                LinearLayout linearLayout2 = this.c;
                Button button2 = this.f2235d;
                Objects.requireNonNull(f0Var);
                boolean z = false;
                if (nestedScrollView3.getChildAt(0).getBottom() <= nestedScrollView3.getScrollY() + nestedScrollView3.getHeight()) {
                    z = true;
                }
                f0Var.N0(nestedScrollView3, linearLayout2, button2, z);
            }
        });
        nestedScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(nestedScrollView, linearLayout, button) { // from class: f.b.a.a.a.f0.e
            public final /* synthetic */ NestedScrollView c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ LinearLayout f2236d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Button f2237e;

            {
                this.c = r2;
                this.f2236d = r3;
                this.f2237e = r4;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                f0 f0Var = f0.this;
                NestedScrollView nestedScrollView2 = this.c;
                LinearLayout linearLayout2 = this.f2236d;
                Button button2 = this.f2237e;
                Objects.requireNonNull(f0Var);
                if (nestedScrollView2.getMeasuredHeight() >= nestedScrollView2.getChildAt(0).getHeight()) {
                    f0Var.N0(nestedScrollView2, linearLayout2, button2, true);
                }
            }
        });
        this.W.f343f.f(H(), new t() { // from class: f.b.a.a.a.f0.r
            @Override // e.r.t
            public final void a(Object obj) {
                q0 q0Var = q0.this;
                Objects.requireNonNull(q0Var);
                if (((Boolean) obj).booleanValue()) {
                    OnboardingViewModel onboardingViewModel = q0Var.a0;
                    onboardingViewModel.f424d.t(q0Var.g0.c.isChecked());
                    q0Var.g0.f2477e.setDisplayedChild(1);
                    q0Var.a0.d(true);
                    if (q0Var.l0) {
                        u0.N0(q0Var);
                    } else {
                        g1.M0(q0Var);
                    }
                } else {
                    q0Var.g0.f2477e.setDisplayedChild(0);
                }
            }
        });
        this.W.f349l.f(H(), new t() { // from class: f.b.a.a.a.f0.o
            @Override // e.r.t
            public final void a(Object obj) {
                q0 q0Var = q0.this;
                Void r3 = (Void) obj;
                m.e.Z0(q0Var.F, q0Var.F(R.string.generic_error_message));
            }
        });
        this.W.m.f(H(), new t() { // from class: f.b.a.a.a.f0.s
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE  
                  (r1v1 'K' com.google.android.material.snackbar.Snackbar)
                  (wrap: int : ?: SGET   gov.nm.covid19.exposurenotifications.R.string.learn_more int)
                  (wrap: f.b.a.a.a.f0.p : 0x0014: CONSTRUCTOR  (r3v0 f.b.a.a.a.f0.p A[REMOVE]) = (r0v0 'q0Var' f.b.a.a.a.f0.q0), (r5v2 'view2' android.view.View) call: f.b.a.a.a.f0.p.<init>(f.b.a.a.a.f0.q0, android.view.View):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.google.android.material.snackbar.Snackbar.k(int, android.view.View$OnClickListener):com.google.android.material.snackbar.Snackbar in method: f.b.a.a.a.f0.s.a(java.lang.Object):void, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:122)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.a.a.a.f0.p, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:132)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:117)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:974)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:799)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:382)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                	... 18 more
                */
            @Override // e.r.t
            public final void a(java.lang.Object r5) {
                /*
                    r4 = this;
                    f.b.a.a.a.f0.q0 r0 = f.b.a.a.a.f0.q0.this
                    java.lang.Void r5 = (java.lang.Void) r5
                    android.view.View r5 = r0.F
                    if (r5 == 0) goto L_0x001d
                    r1 = 2131820937(0x7f110189, float:1.9274603E38)
                    com.google.android.material.snackbar.Snackbar r1 = e.b.a.m.e.K(r5, r1)
                    r2 = 2131820957(0x7f11019d, float:1.9274644E38)
                    f.b.a.a.a.f0.p r3 = new f.b.a.a.a.f0.p
                    r3.<init>(r0, r5)
                    r1.k(r2, r3)
                    r1.l()
                L_0x001d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: f.b.a.a.a.f0.s.a(java.lang.Object):void");
            }
        });
        this.W.c.f(H(), new t() { // from class: f.b.a.a.a.f0.u
            @Override // e.r.t
            public final void a(Object obj) {
                q0.this.h0 = (ExposureNotificationViewModel.b) obj;
            }
        });
        this.g0.f2480h.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                q0.this.L0();
            }
        });
        this.W.f341d.f(H(), new t() { // from class: f.b.a.a.a.f0.t
            @Override // e.r.t
            public final void a(Object obj) {
                q0 q0Var = q0.this;
                Boolean bool = (Boolean) obj;
                q0Var.j0.setEnabled(!bool.booleanValue());
                q0Var.g0.f2480h.setEnabled(!bool.booleanValue());
                int i2 = 0;
                q0Var.g0.f2481i.setVisibility(bool.booleanValue() ? 0 : 4);
                Button button2 = q0Var.j0;
                if (bool.booleanValue()) {
                    i2 = 4;
                }
                button2.setVisibility(i2);
            }
        });
        OnboardingViewModel onboardingViewModel = this.a0;
        m.e.X0(m.e.V(onboardingViewModel.f424d.f2316g), new e0(onboardingViewModel)).f(H(), new t() { // from class: f.b.a.a.a.f0.v
            @Override // e.r.t
            public final void a(Object obj) {
                q0 q0Var = q0.this;
                Objects.requireNonNull(q0Var);
                q0Var.l0 = ((Boolean) obj).booleanValue();
            }
        });
        this.a0.c(v0());
    }
}
