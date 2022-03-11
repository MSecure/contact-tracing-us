package f.b.a.a.a.r;

import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
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
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.textfield.TextInputEditText;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.h.g;
import f.b.a.a.a.i.u;
import f.b.b.a.l;
import f.b.b.a.t;
import gov.md.covid19.exposurenotifications.R;
import java.util.Objects;

public class x3 extends j3 {
    public static final /* synthetic */ int c0 = 0;
    public u a0;
    public ShareDiagnosisViewModel b0;

    public class a extends g {
        public final /* synthetic */ EditText b;

        public a(EditText editText) {
            this.b = editText;
        }

        public void afterTextChanged(Editable editable) {
            x3.this.a0.f2143k.setEnabled(!TextUtils.isEmpty(this.b.getText()));
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_share_diagnosis_code, viewGroup, false);
        int i2 = 16908332;
        ImageButton imageButton = (ImageButton) inflate.findViewById(16908332);
        if (imageButton != null) {
            i2 = R.id.learn_more_button;
            Button button = (Button) inflate.findViewById(R.id.learn_more_button);
            if (button != null) {
                i2 = R.id.share_advance_switcher;
                ViewSwitcher viewSwitcher = (ViewSwitcher) inflate.findViewById(R.id.share_advance_switcher);
                if (viewSwitcher != null) {
                    i2 = R.id.share_next_button;
                    Button button2 = (Button) inflate.findViewById(R.id.share_next_button);
                    if (button2 != null) {
                        i2 = R.id.share_previous_button;
                        Button button3 = (Button) inflate.findViewById(R.id.share_previous_button);
                        if (button3 != null) {
                            i2 = R.id.share_test_error;
                            LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.share_test_error);
                            if (linearLayout != null) {
                                i2 = R.id.share_test_error_text;
                                TextView textView = (TextView) inflate.findViewById(R.id.share_test_error_text);
                                if (textView != null) {
                                    i2 = R.id.share_test_identifier;
                                    TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(R.id.share_test_identifier);
                                    if (textInputEditText != null) {
                                        i2 = R.id.share_test_verified;
                                        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.share_test_verified);
                                        if (linearLayout2 != null) {
                                            i2 = R.id.share_verify_button;
                                            Button button4 = (Button) inflate.findViewById(R.id.share_verify_button);
                                            if (button4 != null) {
                                                i2 = R.id.share_verify_switcher;
                                                ViewSwitcher viewSwitcher2 = (ViewSwitcher) inflate.findViewById(R.id.share_verify_switcher);
                                                if (viewSwitcher2 != null) {
                                                    i2 = R.id.verify_mask;
                                                    RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.verify_mask);
                                                    if (relativeLayout != null) {
                                                        i2 = R.id.verify_progress_indicator;
                                                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) inflate.findViewById(R.id.verify_progress_indicator);
                                                        if (circularProgressIndicator != null) {
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) inflate;
                                                            this.a0 = new u(relativeLayout2, imageButton, button, viewSwitcher, button2, button3, linearLayout, textView, textInputEditText, linearLayout2, button4, viewSwitcher2, relativeLayout, circularProgressIndicator);
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
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // e.m.a.l
    public void R() {
        this.D = true;
        this.a0 = null;
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        e3 e3Var;
        g().setTitle(R.string.verify_test_result_title);
        this.b0 = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        u uVar = this.a0;
        TextInputEditText textInputEditText = uVar.f2141i;
        LinearLayout linearLayout = uVar.f2142j;
        LinearLayout linearLayout2 = uVar.f2139g;
        uVar.f2143k.setEnabled(!TextUtils.isEmpty(textInputEditText.getText()));
        textInputEditText.addTextChangedListener(new a(textInputEditText));
        this.b0.f392k.f(B(), new a0(this));
        this.b0.p.f(B(), new w(this));
        this.b0.e().f(B(), new f0(this, view, textInputEditText, linearLayout, linearLayout2));
        this.a0.b.setContentDescription(z(R.string.btn_cancel));
        this.a0.c.setOnClickListener(new u(this));
        this.b0.m.f(B(), new b0(this));
        m.h.R(this.b0.w).f(B(), new z(this, linearLayout2, linearLayout, textInputEditText));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.b0;
        Intent intent = (Intent) this.f1632g.getParcelable("ShareDiagnosisActivity.ACTIVITY_START_INTENT");
        Objects.requireNonNull(shareDiagnosisViewModel);
        f.b.b.a.a<Object> aVar = f.b.b.a.a.b;
        if (intent == null || intent.getData() == null) {
            e3Var = new e3(true, aVar);
        } else if (shareDiagnosisViewModel.A) {
            e3Var = new e3(true, aVar);
        } else {
            String value = new UrlQuerySanitizer(intent.getData().toString()).getValue("c");
            if (t.a(value)) {
                e3Var = new e3(true, aVar);
            } else {
                shareDiagnosisViewModel.A = true;
                shareDiagnosisViewModel.k(value, true);
                e3Var = new e3(false, l.c(value));
            }
        }
        if (e3Var.b.b()) {
            textInputEditText.setText(e3Var.b.a());
        }
        if (e3Var.a) {
            this.a0.n.b();
            this.a0.m.setVisibility(8);
        } else {
            CircularProgressIndicator circularProgressIndicator = this.a0.n;
            if (circularProgressIndicator.f2805f > 0) {
                circularProgressIndicator.removeCallbacks(circularProgressIndicator.f2811l);
                circularProgressIndicator.postDelayed(circularProgressIndicator.f2811l, (long) circularProgressIndicator.f2805f);
            } else {
                circularProgressIndicator.f2811l.run();
            }
            this.a0.m.setVisibility(0);
        }
        ShareDiagnosisViewModel shareDiagnosisViewModel2 = this.b0;
        ShareDiagnosisViewModel.d dVar = ShareDiagnosisViewModel.d.CODE;
        m.h.A0(shareDiagnosisViewModel2.e(), new b3(shareDiagnosisViewModel2, dVar)).f(B(), new e0(this, view));
        ShareDiagnosisViewModel shareDiagnosisViewModel3 = this.b0;
        m.h.A0(shareDiagnosisViewModel3.e(), new z2(shareDiagnosisViewModel3, dVar)).f(B(), new d0(this, view));
    }
}
