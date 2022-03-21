package f.b.a.a.a.p;

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
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import com.google.android.material.progressindicator.ProgressIndicator;
import e.b.a.m;
import e.p.b0;
import f.b.a.a.a.h.g;
import f.b.a.c.b.o.b;
import f.b.b.a.l;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public class l3 extends y2 {
    public static final /* synthetic */ int a0 = 0;
    public ShareDiagnosisViewModel Z;

    public class a extends g {
        public final /* synthetic */ Button b;
        public final /* synthetic */ EditText c;

        public a(l3 l3Var, Button button, EditText editText) {
            this.b = button;
            this.c = editText;
        }

        public void afterTextChanged(Editable editable) {
            this.b.setEnabled(!TextUtils.isEmpty(this.c.getText()));
        }
    }

    @Override // e.m.a.l
    public View Q(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_diagnosis_code, viewGroup, false);
    }

    @Override // e.m.a.l
    public void g0(View view, Bundle bundle) {
        t2 t2Var;
        g().setTitle(R.string.verify_test_result_title);
        this.Z = (ShareDiagnosisViewModel) new b0(g()).a(ShareDiagnosisViewModel.class);
        EditText editText = (EditText) view.findViewById(R.id.share_test_identifier);
        ViewSwitcher viewSwitcher = (ViewSwitcher) view.findViewById(R.id.share_advance_switcher);
        Button button = (Button) view.findViewById(R.id.share_next_button);
        Button button2 = (Button) view.findViewById(R.id.share_verify_button);
        Button button3 = (Button) view.findViewById(R.id.share_previous_button);
        Button button4 = (Button) view.findViewById(R.id.learn_more_button);
        View findViewById = view.findViewById(16908332);
        View findViewById2 = view.findViewById(R.id.share_test_verified);
        View findViewById3 = view.findViewById(R.id.share_test_error);
        TextView textView = (TextView) view.findViewById(R.id.share_test_error_text);
        View findViewById4 = view.findViewById(R.id.verify_mask);
        ProgressIndicator progressIndicator = (ProgressIndicator) view.findViewById(R.id.verify_progress_indicator);
        button2.setEnabled(!TextUtils.isEmpty(editText.getText()));
        editText.addTextChangedListener(new a(this, button2, editText));
        this.Z.f376i.f(B(), new h0((ViewSwitcher) view.findViewById(R.id.share_verify_switcher)));
        this.Z.n.f(B(), new c0(findViewById4, progressIndicator));
        this.Z.e().f(B(), new a0(this, button2, view, editText, button, findViewById2, findViewById3, viewSwitcher, findViewById, button3));
        findViewById.setContentDescription(z(R.string.btn_cancel));
        button4.setOnClickListener(new f0(this));
        this.Z.f378k.f(B(), new e0(this));
        m.h.R(this.Z.u).f(B(), new b0(findViewById3, findViewById2, textView, editText, viewSwitcher));
        ShareDiagnosisViewModel shareDiagnosisViewModel = this.Z;
        Intent intent = (Intent) this.f1620g.getParcelable("ShareDiagnosisActivity.ACTIVITY_START_INTENT");
        Objects.requireNonNull(shareDiagnosisViewModel);
        f.b.b.a.a<Object> aVar = f.b.b.a.a.b;
        if (intent == null || intent.getData() == null) {
            t2Var = new t2(true, aVar);
        } else if (shareDiagnosisViewModel.y) {
            t2Var = new t2(true, aVar);
        } else {
            String value = new UrlQuerySanitizer(intent.getData().toString()).getValue("c");
            if (b.i1(value)) {
                t2Var = new t2(true, aVar);
            } else {
                shareDiagnosisViewModel.y = true;
                shareDiagnosisViewModel.k(value, true);
                t2Var = new t2(false, l.c(value));
            }
        }
        if (t2Var.b.b()) {
            editText.setText(t2Var.b.a());
        }
        if (t2Var.a) {
            progressIndicator.b();
            findViewById4.setVisibility(8);
            return;
        }
        if (progressIndicator.f540f > 0) {
            progressIndicator.removeCallbacks(progressIndicator.f546l);
            progressIndicator.postDelayed(progressIndicator.f546l, (long) progressIndicator.f540f);
        } else {
            progressIndicator.f546l.run();
        }
        findViewById4.setVisibility(0);
    }
}
