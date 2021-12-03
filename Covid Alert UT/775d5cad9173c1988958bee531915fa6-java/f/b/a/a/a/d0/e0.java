package f.b.a.a.a.d0;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
import com.google.android.apps.exposurenotification.notify.ShareDiagnosisViewModel;
import e.q.t;
import f.b.a.a.a.l0.h0;
import gov.ut.covid19.exposurenotifications.R;

public final /* synthetic */ class e0 implements t {
    public final /* synthetic */ u5 a;
    public final /* synthetic */ LinearLayout b;
    public final /* synthetic */ LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2177d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewSwitcher f2178e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f2179f;

    public /* synthetic */ e0(u5 u5Var, LinearLayout linearLayout, LinearLayout linearLayout2, EditText editText, ViewSwitcher viewSwitcher, View view) {
        this.a = u5Var;
        this.b = linearLayout;
        this.c = linearLayout2;
        this.f2177d = editText;
        this.f2178e = viewSwitcher;
        this.f2179f = view;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        u5 u5Var = this.a;
        LinearLayout linearLayout = this.b;
        LinearLayout linearLayout2 = this.c;
        EditText editText = this.f2177d;
        ViewSwitcher viewSwitcher = this.f2178e;
        View view = this.f2179f;
        h0 h0Var = (h0) obj;
        ShareDiagnosisViewModel shareDiagnosisViewModel = u5Var.b0;
        if (shareDiagnosisViewModel.N) {
            shareDiagnosisViewModel.N = false;
        } else if (!a5.b(h0Var) || h0.c.SHARED.equals(h0Var.m())) {
            linearLayout2.setVisibility(8);
            viewSwitcher.setDisplayedChild(0);
        } else {
            u5Var.j0 = h0Var.p();
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            linearLayout2.announceForAccessibility(u5Var.E(R.string.share_test_identifier_verified));
            editText.setEnabled(u5Var.b0.M);
            editText.setText(h0Var.p());
            editText.setSelection(editText.getText().length());
            viewSwitcher.setDisplayedChild(1);
        }
        u5Var.i0.f2355d.setOnClickListener(new v(u5Var, view, h0Var));
    }
}
