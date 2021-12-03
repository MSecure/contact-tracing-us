package f.b.a.a.a.s;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.p.t;
import f.b.a.a.a.b0.h0;
import gov.co.cdphe.exposurenotifications.R;

public final /* synthetic */ class e0 implements t {
    public final /* synthetic */ v5 a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2372d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewSwitcher f2373e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f2374f;

    public /* synthetic */ e0(v5 v5Var, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ViewSwitcher viewSwitcher, View view) {
        this.a = v5Var;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.f2372d = editText;
        this.f2373e = viewSwitcher;
        this.f2374f = view;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        v5 v5Var = this.a;
        LinearLayout linearLayout = this.b;
        LinearLayout linearLayout2 = this.c;
        EditText editText = this.f2372d;
        ViewSwitcher viewSwitcher = this.f2373e;
        View view = this.f2374f;
        h0 h0Var = (h0) obj;
        ShareDiagnosisViewModel shareDiagnosisViewModel = v5Var.a0;
        if (shareDiagnosisViewModel.N) {
            shareDiagnosisViewModel.N = false;
        } else if (!a5.b(h0Var) || h0.c.SHARED.equals(h0Var.m())) {
            linearLayout2.setVisibility(8);
            viewSwitcher.setDisplayedChild(0);
        } else {
            v5Var.i0 = h0Var.p();
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            linearLayout2.announceForAccessibility(v5Var.A(R.string.share_test_identifier_verified));
            editText.setEnabled(v5Var.a0.M);
            editText.setText(h0Var.p());
            editText.setSelection(editText.getText().length());
            viewSwitcher.setDisplayedChild(1);
        }
        v5Var.h0.f2160d.setOnClickListener(new v(v5Var, view, h0Var));
    }
}
