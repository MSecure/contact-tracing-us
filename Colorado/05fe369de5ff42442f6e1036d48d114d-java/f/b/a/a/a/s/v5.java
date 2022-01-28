package f.b.a.a.a.s;

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
import e.p.y;
import f.b.a.a.a.i.n;
import f.b.a.a.a.i.v;
import f.b.a.a.a.j.d0;
import f.b.b.a.l;
import f.b.b.a.o;
import f.b.b.a.t;
import gov.co.cdphe.exposurenotifications.R;
import java.util.Locale;
import java.util.Objects;

public class v5 extends e5 {
    public static final /* synthetic */ int k0 = 0;
    public final TextWatcher g0 = new a();
    public d0 h0;
    public String i0 = null;
    public BroadcastReceiver j0 = null;

    public class a extends n {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            String str;
            d0 d0Var = v5.this.h0;
            d0Var.n.setEnabled(!TextUtils.isEmpty(d0Var.f2168l.getText()));
            if (v5.this.h0.f2168l.getText() == null) {
                str = "";
            } else {
                str = v5.this.h0.f2168l.getText().toString();
            }
            v5 v5Var = v5.this;
            v5Var.h0.f2162f.setDisplayedChild(str.equals(v5Var.i0) ? 1 : 0);
            v5 v5Var2 = v5.this;
            v5Var2.h0.m.setVisibility(str.equals(v5Var2.i0) ? 0 : 8);
            if (str.equals(v5.this.i0)) {
                v5.this.h0.f2166j.setVisibility(8);
                v5.this.a0.D.j("");
            }
        }
    }

    public class b extends BroadcastReceiver {
        public final /* synthetic */ EditText a;

        public b(v5 v5Var, EditText editText) {
            this.a = editText;
        }

        public void onReceive(Context context, Intent intent) {
            l<String> c = v.c(intent.getData());
            if (c.b()) {
                this.a.setText(c.a());
                EditText editText = this.a;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5
    public boolean A0() {
        super.A0();
        N0();
        return true;
    }

    public final void N0() {
        String obj = this.h0.f2168l.getText() == null ? "" : this.h0.f2168l.getText().toString();
        boolean z = false;
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", Boolean.valueOf(this.h0.f2166j.getVisibility() == 0));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        if (this.h0.m.getVisibility() == 0) {
            z = true;
        }
        shareDiagnosisViewModel.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", Boolean.valueOf(z));
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", Integer.valueOf(this.h0.f2162f.getDisplayedChild()));
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.valueOf(this.h0.f2168l.isEnabled()));
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", obj);
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", this.i0);
        this.a0.N = true;
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                                                            this.h0 = new d0(relativeLayout2, linearLayout, textView, imageButton, button, viewSwitcher, nestedScrollView, button2, button3, linearLayout2, textView2, noAutofillTextInputEditText, linearLayout3, button4, viewSwitcher2, textView3, relativeLayout, circularProgressIndicator);
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

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.h0 = null;
    }

    @Override // e.m.a.m
    public void Y() {
        this.D = true;
        this.h0.f2168l.removeTextChangedListener(this.g0);
        if (this.j0 != null) {
            p0().unregisterReceiver(this.j0);
            this.j0 = null;
        }
    }

    @Override // e.m.a.m
    public void c0() {
        this.D = true;
        this.h0.f2168l.addTextChangedListener(this.g0);
        if (m.h.C0(p0()) && this.j0 == null) {
            NoAutofillTextInputEditText noAutofillTextInputEditText = this.h0.f2168l;
            String lowerCase = "us-co.en.express".toLowerCase(Locale.ROOT);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.nearby.exposurenotification.ACTION_VERIFICATION_LINK");
            intentFilter.addDataScheme("https");
            intentFilter.addDataAuthority(lowerCase, null);
            this.j0 = new b(this, noAutofillTextInputEditText);
            p0().registerReceiver(this.j0, intentFilter, "com.google.android.gms.nearby.exposurenotification.EXPOSURE_CALLBACK", null);
        }
    }

    @Override // e.m.a.m
    public void d0(Bundle bundle) {
        N0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x015f  */
    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5, e.m.a.m
    public void g0(View view, Bundle bundle) {
        String str;
        x4 x4Var;
        int i2;
        RelativeLayout relativeLayout;
        super.g0(view, bundle);
        o0().setTitle(R.string.verify_test_result_title);
        d0 d0Var = this.h0;
        J0(d0Var.f2163g, d0Var.b);
        d0 d0Var2 = this.h0;
        NoAutofillTextInputEditText noAutofillTextInputEditText = d0Var2.f2168l;
        LinearLayout linearLayout = d0Var2.m;
        LinearLayout linearLayout2 = d0Var2.f2166j;
        ViewSwitcher viewSwitcher = d0Var2.f2162f;
        if (d0Var2.f2164h.isAccessibilityFocused()) {
            this.h0.f2164h.sendAccessibilityEvent(32);
        }
        this.h0.n.setEnabled(!TextUtils.isEmpty(noAutofillTextInputEditText.getText()));
        if (x5.SELF_REPORT.equals(this.a0.I)) {
            this.h0.c.setText(B(R.string.enter_code_help, A(R.string.health_authority_name)));
        }
        this.h0.n.setOnClickListener(new x(this, view, noAutofillTextInputEditText));
        this.a0.o.f(C(), new a0(this));
        this.a0.u.f(C(), new i0(this));
        this.a0.f().f(C(), new e0(this, linearLayout2, linearLayout, noAutofillTextInputEditText, viewSwitcher, view));
        this.h0.f2161e.setOnClickListener(new z(this, view));
        this.a0.q.f(C(), new k0(this));
        this.a0.D.f(C(), new j0(this, linearLayout2, linearLayout, noAutofillTextInputEditText));
        Bundle bundle2 = this.v.f1454g;
        if (bundle2 == null) {
            str = null;
        } else {
            str = bundle2.getString("BaseFragment.CODE_FROM_DEEP_LINK", null);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
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
                this.h0.r.b();
                relativeLayout = this.h0.q;
                i2 = 8;
            } else {
                CircularProgressIndicator circularProgressIndicator = this.h0.r;
                if (circularProgressIndicator.f2910f > 0) {
                    circularProgressIndicator.removeCallbacks(circularProgressIndicator.f2916l);
                    circularProgressIndicator.postDelayed(circularProgressIndicator.f2916l, (long) circularProgressIndicator.f2910f);
                } else {
                    circularProgressIndicator.f2916l.run();
                }
                relativeLayout = this.h0.q;
                i2 = 0;
            }
            relativeLayout.setVisibility(i2);
            ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.a0;
            ShareDiagnosisViewModel.b bVar = ShareDiagnosisViewModel.b.CODE;
            m.h.G0(shareDiagnosisViewModel2.f(), new t3(shareDiagnosisViewModel2, bVar)).f(C(), new l0(this, view));
            ShareDiagnosisViewModel shareDiagnosisViewModel3 = this.a0;
            m.h.G0(shareDiagnosisViewModel3.f(), new n3(shareDiagnosisViewModel3, bVar)).f(C(), new d0(this, view));
            y yVar = this.a0.H;
            Boolean bool = Boolean.FALSE;
            yVar.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool).f(C(), new f0(linearLayout2));
            this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool).f(C(), new h0(linearLayout));
            this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(C(), new b(noAutofillTextInputEditText));
            this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(C(), new c0(this, noAutofillTextInputEditText));
            this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(C(), new w(viewSwitcher));
            this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(C(), new g0(this));
            this.a0.g().f(C(), new m0(this));
        }
        if (x4Var.b.b()) {
        }
        if (!x4Var.a) {
        }
        relativeLayout.setVisibility(i2);
        ShareDiagnosisViewModel shareDiagnosisViewModel22 = this.a0;
        ShareDiagnosisViewModel.b bVar2 = ShareDiagnosisViewModel.b.CODE;
        m.h.G0(shareDiagnosisViewModel22.f(), new t3(shareDiagnosisViewModel22, bVar2)).f(C(), new l0(this, view));
        ShareDiagnosisViewModel shareDiagnosisViewModel32 = this.a0;
        m.h.G0(shareDiagnosisViewModel32.f(), new n3(shareDiagnosisViewModel32, bVar2)).f(C(), new d0(this, view));
        y yVar2 = this.a0.H;
        Boolean bool2 = Boolean.FALSE;
        yVar2.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_INVALID", bool2).f(C(), new f0(linearLayout2));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_IS_VERIFIED", bool2).f(C(), new h0(linearLayout));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT_IS_ENABLED", Boolean.TRUE).f(C(), new b(noAutofillTextInputEditText));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_CODE_INPUT", null).f(C(), new c0(this, noAutofillTextInputEditText));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_SHARE_ADVANCE_SWITCHER_CHILD", -1).f(C(), new w(viewSwitcher));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_VERIFIED_CODE", null).f(C(), new g0(this));
        this.a0.g().f(C(), new m0(this));
    }
}
