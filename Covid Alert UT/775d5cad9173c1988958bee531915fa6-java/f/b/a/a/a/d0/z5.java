package f.b.a.a.a.d0;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.core.widget.NestedScrollView;
import com.google.android.apps.exposurenotification.common.ui.NoAutofillTextInputEditText;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.b.a.m;
import f.b.a.a.a.s.n;
import f.b.a.a.a.t.e0;
import f.b.a.e.l.q;
import gov.ut.covid19.exposurenotifications.R;

public class z5 extends q5 {
    public final TextWatcher f0 = new a();
    public final TextWatcher g0 = new b();
    public e0 h0;

    public class a extends n {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            z5.this.h0.f2370h.setVisibility(8);
            z5 z5Var = z5.this;
            z5Var.U0(z5Var.h0.o.isChecked());
        }
    }

    public class b extends n {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            z5 z5Var = z5.this;
            z5Var.U0(z5Var.h0.o.isChecked());
        }
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5
    public boolean F0() {
        super.F0();
        T0();
        return true;
    }

    @Override // e.n.a.m
    public View T(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_get_code, viewGroup, false);
        int i2 = R.id.btn_previous;
        Button button = (Button) inflate.findViewById(R.id.btn_previous);
        if (button != null) {
            i2 = R.id.btn_send_code;
            Button button2 = (Button) inflate.findViewById(R.id.btn_send_code);
            if (button2 != null) {
                i2 = R.id.button_container;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.button_container);
                if (linearLayout != null) {
                    i2 = 16908332;
                    ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
                    if (imageButton != null) {
                        i2 = R.id.learn_more_button;
                        Button button3 = (Button) inflate.findViewById(R.id.learn_more_button);
                        if (button3 != null) {
                            i2 = R.id.phone_number;
                            NoAutofillTextInputEditText noAutofillTextInputEditText = (NoAutofillTextInputEditText) inflate.findViewById(R.id.phone_number);
                            if (noAutofillTextInputEditText != null) {
                                i2 = R.id.phone_number_error;
                                TextView textView = (TextView) inflate.findViewById(R.id.phone_number_error);
                                if (textView != null) {
                                    i2 = R.id.phone_number_help;
                                    TextView textView2 = (TextView) inflate.findViewById(R.id.phone_number_help);
                                    if (textView2 != null) {
                                        i2 = R.id.send_code_switcher;
                                        ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.send_code_switcher);
                                        if (viewSwitcher != null) {
                                            i2 = R.id.share_diagnosis_scroll_view;
                                            NestedScrollView nestedScrollView = (NestedScrollView) inflate.findViewById(R.id.share_diagnosis_scroll_view);
                                            if (nestedScrollView != null) {
                                                i2 = R.id.step_x_of_y_text_view;
                                                TextView textView3 = (TextView) inflate.findViewById(R.id.step_x_of_y_text_view);
                                                if (textView3 != null) {
                                                    i2 = R.id.test_date;
                                                    NoAutofillTextInputEditText noAutofillTextInputEditText2 = (NoAutofillTextInputEditText) inflate.findViewById(R.id.test_date);
                                                    if (noAutofillTextInputEditText2 != null) {
                                                        i2 = R.id.test_date_help;
                                                        TextView textView4 = (TextView) inflate.findViewById(R.id.test_date_help);
                                                        if (textView4 != null) {
                                                            i2 = R.id.tested_for_covid_checkbox;
                                                            CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.tested_for_covid_checkbox);
                                                            if (checkBox != null) {
                                                                LinearLayout linearLayout2 = (LinearLayout) inflate;
                                                                this.h0 = new e0(linearLayout2, button, button2, linearLayout, imageButton, button3, noAutofillTextInputEditText, textView, textView2, viewSwitcher, nestedScrollView, textView3, noAutofillTextInputEditText2, textView4, checkBox);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final void T0() {
        String str = "";
        String obj = this.h0.f2369g.getText() == null ? str : this.h0.f2369g.getText().toString();
        if (this.h0.m.getText() != null) {
            str = this.h0.m.getText().toString();
        }
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", obj);
        this.b0.H.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", str);
    }

    public final void U0(boolean z) {
        e0 e0Var = this.h0;
        e0Var.c.setEnabled(z && !TextUtils.isEmpty(e0Var.m.getText()) && !TextUtils.isEmpty(this.h0.f2369g.getText()));
    }

    @Override // e.n.a.m
    public void V() {
        this.D = true;
        this.h0 = null;
    }

    @Override // e.n.a.m
    public void c0() {
        this.D = true;
        this.h0.f2369g.removeTextChangedListener(this.f0);
        this.h0.m.removeTextChangedListener(this.g0);
    }

    @Override // e.n.a.m
    public void g0() {
        this.D = true;
        this.h0.f2369g.addTextChangedListener(this.f0);
        this.h0.m.addTextChangedListener(this.g0);
    }

    @Override // f.b.a.a.a.w.z0, f.b.a.a.a.d0.q5, e.n.a.m
    public void k0(View view, Bundle bundle) {
        super.k0(view, bundle);
        s0().setTitle(R.string.get_verification_code_title);
        e0 e0Var = this.h0;
        P0(e0Var.f2373k, e0Var.f2366d);
        if (!TextUtils.isEmpty(E(R.string.self_report_phone_number))) {
            this.h0.f2371i.setText(R.string.self_report_phone_number);
        }
        if (!TextUtils.isEmpty(E(R.string.self_report_test_date))) {
            this.h0.n.setText(R.string.self_report_test_date);
        }
        if (!TextUtils.isEmpty(E(R.string.self_report_checkbox))) {
            this.h0.o.setText(R.string.self_report_checkbox);
        }
        this.h0.f2369g.setOnEditorActionListener(new y0(this));
        this.h0.m.setOnClickListener(new a1(this));
        this.h0.o.setOnCheckedChangeListener(new t0(this));
        this.h0.c.setOnClickListener(new b1(this, view));
        this.h0.f2368f.setOnClickListener(new e1(this, view));
        this.b0.f().f(G(), new w0(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        m.e.R0(shareDiagnosisViewModel.f(), new n3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.GET_CODE)).f(G(), new d1(this, view));
        this.b0.o.f(G(), new v0(this));
        this.b0.F.f(G(), new r0(this));
        this.b0.E.f(G(), new q0(this));
        q<Long> K0 = K0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
        if (K0 != null) {
            K0.m0.clear();
            K0.m0.add(new z0(this));
        }
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", null).f(G(), new c1(this));
        this.b0.H.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", null).f(G(), new u0(this));
        this.b0.g().f(G(), new f1(this));
    }
}
