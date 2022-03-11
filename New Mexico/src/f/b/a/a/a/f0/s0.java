package f.b.a.a.a.f0;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.onboarding.OnboardingViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.b.a.m;
import e.r.f0;
import e.r.s;
import e.r.t;
import f.b.a.a.a.o0.b;
import f.b.a.a.a.t.p0.a;
import f.b.a.a.a.u.v;
import f.b.a.a.a.x.g1;
import f.b.a.c.i.f;
import f.b.b.a.l;
import gov.nm.covid19.exposurenotifications.R;
import java.util.Objects;
/* loaded from: classes.dex */
public class s0 extends k0 {
    public v b0;
    public OnboardingViewModel c0;
    public RelativeLayout d0;
    public Button e0;
    public NestedScrollView f0;
    public boolean g0 = false;

    public final void L0(boolean z) {
        RelativeLayout relativeLayout;
        float f2;
        if (z) {
            this.e0.setText(R.string.btn_got_it);
            this.e0.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0 s0Var = s0.this;
                    s0Var.c0.d(true);
                    if (s0Var.b0.c.getVisibility() == 0) {
                        OnboardingViewModel onboardingViewModel = s0Var.c0;
                        onboardingViewModel.f424d.t(s0Var.b0.f2483d.isChecked());
                    }
                    if (s0Var.g0) {
                        u0.N0(s0Var);
                    } else {
                        g1.M0(s0Var);
                    }
                }
            });
            relativeLayout = this.d0;
            f2 = 0.0f;
        } else {
            this.e0.setText(R.string.btn_continue);
            this.e0.setOnClickListener(new View.OnClickListener() { // from class: f.b.a.a.a.f0.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s0.this.f0.q(130);
                }
            });
            relativeLayout = this.d0;
            f2 = B().getDimension(R.dimen.bottom_button_container_elevation);
        }
        relativeLayout.setElevation(f2);
        if (this.e0.isAccessibilityFocused()) {
            this.e0.sendAccessibilityEvent(32);
        }
    }

    @Override // e.o.a.m
    public View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_onboarding_permission_enabled, viewGroup, false);
        int i2 = R.id.app_analytics_detail;
        TextView textView = (TextView) inflate.findViewById(R.id.app_analytics_detail);
        if (textView != null) {
            i2 = R.id.app_analytics_section;
            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.app_analytics_section);
            if (linearLayout != null) {
                i2 = R.id.onboarding_app_analytics_switch;
                SwitchMaterial switchMaterial = (SwitchMaterial) inflate.findViewById(R.id.onboarding_app_analytics_switch);
                if (switchMaterial != null) {
                    i2 = R.id.onboarding_buttons;
                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.onboarding_buttons);
                    if (relativeLayout != null) {
                        i2 = R.id.onboarding_next_button;
                        Button button = (Button) inflate.findViewById(R.id.onboarding_next_button);
                        if (button != null) {
                            i2 = R.id.onboarding_scroll;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.onboarding_scroll);
                            if (nestedScrollView != null) {
                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                this.b0 = new v(linearLayout2, textView, linearLayout, switchMaterial, relativeLayout, button, nestedScrollView);
                                return linearLayout2;
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
        this.b0 = null;
    }

    @Override // e.o.a.m
    public void i0() {
        this.D = true;
        OnboardingViewModel onboardingViewModel = this.c0;
        onboardingViewModel.c.a().f(new f(v0().getResources()) { // from class: f.b.a.a.a.f0.d0
            public final /* synthetic */ Resources b;

            {
                this.b = r2;
            }

            @Override // f.b.a.c.i.f
            public final void a(Object obj) {
                Boolean bool;
                s<l<Boolean>> sVar;
                Bundle bundle;
                OnboardingViewModel onboardingViewModel2 = OnboardingViewModel.this;
                Resources resources = this.b;
                f.b.a.c.f.b.f fVar = (f.b.a.c.f.b.f) obj;
                Objects.requireNonNull(onboardingViewModel2);
                if (resources.getBoolean(R.bool.enx_enableV1toENXMigration)) {
                    sVar = onboardingViewModel2.f428h;
                    boolean z = false;
                    if (!(fVar == null || (bundle = fVar.b) == null)) {
                        z = bundle.containsKey("METRICS_OPT_IN");
                    }
                    bool = Boolean.valueOf(!z);
                } else {
                    sVar = onboardingViewModel2.f428h;
                    bool = Boolean.FALSE;
                }
                sVar.j(l.c(bool));
            }
        });
    }

    @Override // f.b.a.a.a.x.a1, e.o.a.m
    public void m0(View view, Bundle bundle) {
        super.m0(view, bundle);
        this.c0 = (OnboardingViewModel) new f0(this).a(OnboardingViewModel.class);
        v vVar = this.b0;
        this.d0 = vVar.f2484e;
        this.e0 = vVar.f2485f;
        this.f0 = vVar.f2486g;
        String F = F(R.string.learn_more);
        String F2 = F(R.string.app_analytics_link);
        a aVar = b.a;
        f.b.a.a.a.o0.a aVar2 = new f.b.a.a.a.o0.a(F2);
        String G = G(R.string.onboarding_metrics_description, F);
        SpannableString spannableString = new SpannableString(G);
        int indexOf = G.indexOf(F);
        spannableString.setSpan(aVar2, indexOf, F.length() + indexOf, 33);
        this.b0.b.setText(spannableString);
        this.b0.b.setMovementMethod(LinkMovementMethod.getInstance());
        this.c0.f428h.f(H(), new t() { // from class: f.b.a.a.a.f0.z
            @Override // e.r.t
            public final void a(Object obj) {
                s0 s0Var = s0.this;
                l lVar = (l) obj;
                Objects.requireNonNull(s0Var);
                if (lVar.b()) {
                    s0Var.b0.c.setVisibility(((Boolean) lVar.a()).booleanValue() ? 0 : 8);
                }
            }
        });
        L0(false);
        this.f0.setOnScrollChangeListener(new NestedScrollView.b() { // from class: f.b.a.a.a.f0.y
            @Override // androidx.core.widget.NestedScrollView.b
            public final void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                s0 s0Var = s0.this;
                if (s0Var.f0.getChildAt(0).getBottom() <= s0Var.f0.getScrollY() + s0Var.f0.getHeight()) {
                    s0Var.L0(true);
                } else {
                    s0Var.L0(false);
                }
            }
        });
        this.f0.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: f.b.a.a.a.f0.x
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                s0 s0Var = s0.this;
                if (s0Var.f0.getMeasuredHeight() >= s0Var.f0.getChildAt(0).getHeight()) {
                    s0Var.L0(true);
                }
            }
        });
        OnboardingViewModel onboardingViewModel = this.c0;
        m.e.X0(m.e.V(onboardingViewModel.f424d.f2316g), new e0(onboardingViewModel)).f(H(), new t() { // from class: f.b.a.a.a.f0.b0
            @Override // e.r.t
            public final void a(Object obj) {
                s0 s0Var = s0.this;
                Objects.requireNonNull(s0Var);
                s0Var.g0 = ((Boolean) obj).booleanValue();
            }
        });
        this.c0.c(v0());
    }
}
