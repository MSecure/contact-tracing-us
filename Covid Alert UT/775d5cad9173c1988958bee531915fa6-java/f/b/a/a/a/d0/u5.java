package f.b.a.a.a.d0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.common.ui.NoAutofillTextInputEditText;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import e.b.a.m;
import e.q.y;
import f.b.a.a.a.s.n;
import f.b.a.a.a.s.u;
import f.b.a.a.a.t.d0;
import f.b.b.a.l;
import f.b.b.a.o;
import f.b.b.a.t;
import gov.ut.covid19.exposurenotifications.R;
import java.util.Locale;
import java.util.Objects;

public class u5 extends e5 {
    public static final /* synthetic */ int l0 = 0;
    public final TextWatcher h0 = new a();
    public d0 i0;
    public String j0 = null;
    public BroadcastReceiver k0 = null;

    public class a extends n {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            String str;
            d0 d0Var = u5.this.i0;
            d0Var.n.setEnabled(!TextUtils.isEmpty(d0Var.f2363l.getText()));
            if (u5.this.i0.f2363l.getText() == null) {
                str = "";
            } else {
                str = u5.this.i0.f2363l.getText().toString();
            }
            u5 u5Var = u5.this;
            u5Var.i0.f2357f.setDisplayedChild(str.equals(u5Var.j0) ? 1 : 0);
            u5 u5Var2 = u5.this;
            u5Var2.i0.m.setVisibility(str.equals(u5Var2.j0) ? 0 : 8);
            if (str.equals(u5.this.j0)) {
                u5.this.i0.f2361j.setVisibility(8);
                u5.this.b0.D.j("");
            }
        }
    }

    public class b extends BroadcastReceiver {
        public final /* synthetic */ EditText a;

        public b(u5 u5Var, EditText editText) {
            this.a = editText;
        }

        public void onReceive(Context context, Intent intent) {
            l<String> c = u.c(intent.getData());
            if (c.b()) {
                this.a.setText(c.a());
                EditText editText = this.a;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    @Override // f.b.a.a.a.d0.q5, f.b.a.a.a.w.z0
    public boolean F0() {
        super.F0();
        T0();
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_code, viewGroup, false);
        int i2 = R.id.button_container;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
        if (linearLayout != null) {
            i2 = R.id.code_help;
            TextView textView = (TextView) inflate.findViewById(R.id.code_help);
            if (textView != null) {
                i2 = 16908332;
                ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                if (imageButton != null) {
                    i2 = R.id.learn_more_button;
                    Button button = (Button) inflate.findViewById(R.id.learn_more_button);
                    if (button != null) {
                        i2 = R.id.share_advance_switcher;
                        ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.share_advance_switcher);
                        if (viewSwitcher != null) {
                            i2 = R.id.share_diagnosis_scroll_view;
                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                            if (nestedScrollView != null) {
                                i2 = R.id.share_next_button;
                                Button button2 = (Button) inflate.findViewById(R.id.share_next_button);
                                if (button2 != null) {
                                    i2 = R.id.share_previous_button;
                                    Button button3 = (Button) inflate.findViewById(R.id.share_previous_button);
                                    if (button3 != null) {
                                        i2 = R.id.share_test_error;
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.share_test_error);
                                        if (linearLayout2 != null) {
                                            i2 = R.id.share_test_error_text;
                                            TextView textView2 = (TextView) inflate.findViewById(R.id.share_test_error_text);
                                            if (textView2 != null) {
                                                i2 = R.id.share_test_identifier;
                                                NoAutofillTextInputEditText noAutofillTextInputEditText = (NoAutofillTextInputEditText) inflate.findViewById(R.id.share_test_identifier);
                                                if (noAutofillTextInputEditText != null) {
                                                    i2 = R.id.share_test_verified;
                                                    LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.share_test_verified);
                                                    if (linearLayout3 != null) {
                                                        i2 = R.id.share_verify_button;
                                                        Button button4 = (Button) inflate.findViewById(R.id.share_verify_button);
                                                        if (button4 != null) {
                                                            i2 = R.id.share_verify_switcher;
                                                            ViewSwitcher viewSwitcher2 = (ViewSwitcher) inflate.findViewById(R.id.share_verify_switcher);
                                                            if (viewSwitcher2 != null) {
                                                                i2 = R.id.step_x_of_y_text_view;
                                                                TextView textView3 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                                if (textView3 != null) {
                                                                    i2 = R.id.verify_mask;
                                                                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.verify_mask);
                                                                    if (relativeLayout != null) {
                                                                        i2 = R.id.verify_progress_indicator;
                                                                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) inflate.findViewById(R.id.verify_progress_indicator);
                                                                        if (circularProgressIndicator != null) {
                                                                            RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
                                                                            this.i0 = new d0(relativeLayout2, linearLayout, textView, imageButton, button, viewSwitcher, nestedScrollView, button2, button3, linearLayout2, textView2, noAutofillTextInputEditText, linearLayout3, button4, viewSwitcher2, textView3, relativeLayout, circularProgressIndicator);
                                                                            return relativeLayout2;
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
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final void T0() {
        String obj = this.i0.f2363l.getText() == null ? "" : this.i0.f2363l.getText().toString();
        boolean z = false;
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.valueOf(this.i0.f2361j.getVisibility() == 0));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        if (this.i0.m.getVisibility() == 0) {
            z = true;
        }
        shareDiagnosisViewModel.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", Boolean.valueOf(z));
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", Integer.valueOf(this.i0.f2357f.getDisplayedChild()));
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.valueOf(this.i0.f2363l.isEnabled()));
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", obj);
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", this.j0);
        this.b0.N = true;
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.i0 = null;
    }

    @Override // e.n.a.m
    public void c0() {
        this.D = true;
        this.i0.f2363l.removeTextChangedListener(this.h0);
        if (this.k0 != null) {
            t0().unregisterReceiver(this.k0);
            this.k0 = null;
        }
    }

    @Override // e.n.a.m
    public void g0() {
        this.D = true;
        this.i0.f2363l.addTextChangedListener(this.h0);
        if (m.e.N0(t0()) && this.k0 == null) {
            NoAutofillTextInputEditText noAutofillTextInputEditText = this.i0.f2363l;
            String lowerCase = "us-ut.en.express".toLowerCase(Locale.ROOT);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.nearby.exposurenotification.ACTION_VERIFICATION_LINK");
            intentFilter.addDataScheme("https");
            intentFilter.addDataAuthority(lowerCase, null);
            this.k0 = new b(this, noAutofillTextInputEditText);
            t0().registerReceiver(this.k0, intentFilter, "com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK", null);
        }
    }

    @Override // e.n.a.m
    public void h0(Bundle bundle) {
        T0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x015f  */
    @Override // f.b.a.a.a.d0.q5, e.n.a.m, f.b.a.a.a.w.z0
    public void k0(View view, Bundle bundle) {
        String str;
        x4 x4Var;
        int i2;
        RelativeLayout relativeLayout;
        super.k0(view, bundle);
        s0().setTitle(R.string.verify_test_result_title);
        d0 d0Var = this.i0;
        P0(d0Var.f2358g, d0Var.b);
        d0 d0Var2 = this.i0;
        NoAutofillTextInputEditText noAutofillTextInputEditText = d0Var2.f2363l;
        LinearLayout linearLayout = d0Var2.m;
        LinearLayout linearLayout2 = d0Var2.f2361j;
        ViewSwitcher viewSwitcher = d0Var2.f2357f;
        if (d0Var2.f2359h.isAccessibilityFocused()) {
            this.i0.f2359h.sendAccessibilityEvent(32);
        }
        this.i0.n.setEnabled(!TextUtils.isEmpty(noAutofillTextInputEditText.getText()));
        if (w5.SELF_REPORT.equals(this.b0.I)) {
            this.i0.c.setText(F(R.string.enter_code_help, E(R.string.health_authority_name)));
        }
        this.i0.n.setOnClickListener(new x(this, view, noAutofillTextInputEditText));
        this.b0.o.f(G(), new a0(this));
        this.b0.u.f(G(), new i0(this));
        this.b0.f().f(G(), new e0(this, linearLayout2, linearLayout, noAutofillTextInputEditText, viewSwitcher, view));
        this.i0.f2356e.setOnClickListener(new z(this, view));
        this.b0.q.f(G(), new k0(this));
        this.b0.D.f(G(), new j0(this, linearLayout2, linearLayout, noAutofillTextInputEditText));
        Bundle bundle2 = this.v.f1727g;
        if (bundle2 == null) {
            str = null;
        } else {
            str = bundle2.getString("BaseFragment.CODE_FROM_DEEP_LINK", null);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        Objects.requireNonNull(shareDiagnosisViewModel);
        if (t.a(str)) {
            x4Var = new x4(true, f.b.b.a.a.b);
        } else if (shareDiagnosisViewModel.L) {
            x4Var = new x4(true, f.b.b.a.a.b);
        } else {
            shareDiagnosisViewModel.L = true;
            shareDiagnosisViewModel.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", str);
            shareDiagnosisViewModel.N = true;
            shareDiagnosisViewModel.u(str, true);
            Objects.requireNonNull(str);
            x4Var = new x4(false, new o(str));
            if (x4Var.b.b()) {
                noAutofillTextInputEditText.setText(x4Var.b.a());
                noAutofillTextInputEditText.setSelection(noAutofillTextInputEditText.getText().length());
            }
            if (!x4Var.a) {
                this.i0.r.b();
                relativeLayout = this.i0.q;
                i2 = 8;
            } else {
                CircularProgressIndicator circularProgressIndicator = this.i0.r;
                if (circularProgressIndicator.f2974f > 0) {
                    circularProgressIndicator.removeCallbacks(circularProgressIndicator.f2980l);
                    circularProgressIndicator.postDelayed(circularProgressIndicator.f2980l, (long) circularProgressIndicator.f2974f);
                } else {
                    circularProgressIndicator.f2980l.run();
                }
                relativeLayout = this.i0.q;
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
            ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.CODE;
            m.e.R0(shareDiagnosisViewModel2.f(), new t3(shareDiagnosisViewModel2, bVar)).f(G(), new l0(this, view));
            ShareDiagnosisViewModel shareDiagnosisViewModel3 = this.b0;
            m.e.R0(shareDiagnosisViewModel3.f(), new n3(shareDiagnosisViewModel3, bVar)).f(G(), new d0(this, view));
            y yVar = this.b0.H;
            Boolean bool = Boolean.FALSE;
            yVar.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool).f(G(), new f0(linearLayout2));
            this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool).f(G(), new h0(linearLayout));
            this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(G(), new b(noAutofillTextInputEditText));
            this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(G(), new c0(this, noAutofillTextInputEditText));
            this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(G(), new w(viewSwitcher));
            this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(G(), new g0(this));
            this.b0.g().f(G(), new m0(this));
        }
        if (x4Var.b.b()) {
        }
        if (!x4Var.a) {
        }
        relativeLayout.setVisibility(i2);
        ShareDiagnosisViewModel shareDiagnosisViewModel22 = this.b0;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.CODE;
        m.e.R0(shareDiagnosisViewModel22.f(), new t3(shareDiagnosisViewModel22, bVar2)).f(G(), new l0(this, view));
        ShareDiagnosisViewModel shareDiagnosisViewModel32 = this.b0;
        m.e.R0(shareDiagnosisViewModel32.f(), new n3(shareDiagnosisViewModel32, bVar2)).f(G(), new d0(this, view));
        y yVar2 = this.b0.H;
        Boolean bool2 = Boolean.FALSE;
        yVar2.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool2).f(G(), new f0(linearLayout2));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool2).f(G(), new h0(linearLayout));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(G(), new b(noAutofillTextInputEditText));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(G(), new c0(this, noAutofillTextInputEditText));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(G(), new w(viewSwitcher));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(G(), new g0(this));
        this.b0.g().f(G(), new m0(this));
    }
}
