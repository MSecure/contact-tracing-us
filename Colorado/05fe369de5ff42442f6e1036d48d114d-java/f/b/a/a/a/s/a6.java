package f.b.a.a.a.s;

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
import f.b.a.a.a.i.n;
import f.b.a.a.a.j.e0;
import f.b.a.e.k.q;
import gov.co.cdphe.exposurenotifications.R;

public class a6 extends r5 {
    public final TextWatcher e0 = new a();
    public final TextWatcher f0 = new b();
    public e0 g0;

    public class a extends n {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            a6.this.g0.f2175h.setVisibility(8);
            a6 a6Var = a6.this;
            a6Var.O0(a6Var.g0.o.isChecked());
        }
    }

    public class b extends n {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
            a6 a6Var = a6.this;
            a6Var.O0(a6Var.g0.o.isChecked());
        }
    }

    @Override // f.b.a.a.a.m.z0, f.b.a.a.a.s.r5
    public boolean A0() {
        super.A0();
        N0();
        return true;
    }

    public final void N0() {
        String str = "";
        String obj = this.g0.f2174g.getText() == null ? str : this.g0.f2174g.getText().toString();
        if (this.g0.m.getText() != null) {
            str = this.g0.m.getText().toString();
        }
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", obj);
        this.a0.H.b("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", str);
    }

    public final void O0(boolean z) {
        e0 e0Var = this.g0;
        e0Var.c.setEnabled(z && !TextUtils.isEmpty(e0Var.m.getText()) && !TextUtils.isEmpty(this.g0.f2174g.getText()));
    }

    @Override // e.m.a.m
    public View P(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
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
                                                                this.g0 = new e0(linearLayout2, button, button2, linearLayout, imageButton, button3, noAutofillTextInputEditText, textView, textView2, viewSwitcher, nestedScrollView, textView3, noAutofillTextInputEditText2, textView4, checkBox);
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

    @Override // e.m.a.m
    public void R() {
        this.D = true;
        this.g0 = null;
    }

    @Override // e.m.a.m
    public void Y() {
        this.D = true;
        this.g0.f2174g.removeTextChangedListener(this.e0);
        this.g0.m.removeTextChangedListener(this.f0);
    }

    @Override // e.m.a.m
    public void c0() {
        this.D = true;
        this.g0.f2174g.addTextChangedListener(this.e0);
        this.g0.m.addTextChangedListener(this.f0);
    }

    @Override // f.b.a.a.a.m.z0, e.m.a.m, f.b.a.a.a.s.r5
    public void g0(View view, Bundle bundle) {
        super.g0(view, bundle);
        o0().setTitle(R.string.get_verification_code_title);
        e0 e0Var = this.g0;
        J0(e0Var.f2178k, e0Var.f2171d);
        if (!TextUtils.isEmpty(A(R.string.self_report_phone_number))) {
            this.g0.f2176i.setText(R.string.self_report_phone_number);
        }
        if (!TextUtils.isEmpty(A(R.string.self_report_test_date))) {
            this.g0.n.setText(R.string.self_report_test_date);
        }
        if (!TextUtils.isEmpty(A(R.string.self_report_checkbox))) {
            this.g0.o.setText(R.string.self_report_checkbox);
        }
        this.g0.f2174g.setOnEditorActionListener(new y0(this));
        this.g0.m.setOnClickListener(new a1(this));
        this.g0.o.setOnCheckedChangeListener(new t0(this));
        this.g0.c.setOnClickListener(new b1(this, view));
        this.g0.f2173f.setOnClickListener(new e1(this, view));
        this.a0.f().f(C(), new w0(this));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.a0;
        m.h.G0(shareDiagnosisViewModel.f(), new n3(shareDiagnosisViewModel, ShareDiagnosisViewModel.b.GET_CODE)).f(C(), new d1(this, view));
        this.a0.o.f(C(), new v0(this));
        this.a0.F.f(C(), new r0(this));
        this.a0.E.f(C(), new q0(this));
        q<Long> E0 = E0("ShareDiagnosisGetCodeFragment.DATE_PICKER_TAG");
        if (E0 != null) {
            E0.m0.clear();
            E0.m0.add(new z0(this));
        }
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_PHONE_NUMBER", null).f(C(), new c1(this));
        this.a0.H.a("ShareDiagnosisViewModel.SAVED_STATE_GET_CODE_TEST_DATE", null).f(C(), new u0(this));
        this.a0.g().f(C(), new f1(this));
    }
}
