package f.b.a.a.a.r;

import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.y.c0;
import gov.md.covid19.exposurenotifications.R;

public final /* synthetic */ class f0 implements r {
    public final /* synthetic */ x3 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ EditText c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2246d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ LinearLayout f2247e;

    public /* synthetic */ f0(x3 x3Var, View view, EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.a = x3Var;
        this.b = view;
        this.c = editText;
        this.f2246d = linearLayout;
        this.f2247e = linearLayout2;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        x3 x3Var = this.a;
        View view = this.b;
        EditText editText = this.c;
        LinearLayout linearLayout = this.f2246d;
        LinearLayout linearLayout2 = this.f2247e;
        c0 c0Var = (c0) obj;
        x3Var.a0.f2143k.setOnClickListener(new x(x3Var, view, editText));
        if (!m.h.r0(c0Var) || c0.c.SHARED.equals(c0Var.k())) {
            linearLayout.setVisibility(8);
            x3Var.a0.f2136d.setDisplayedChild(0);
        } else {
            linearLayout.setVisibility(0);
            linearLayout.announceForAccessibility(x3Var.z(R.string.share_test_identifier_verified));
            linearLayout2.setVisibility(8);
            editText.setEnabled(false);
            editText.setText(c0Var.n());
            x3Var.a0.f2136d.setDisplayedChild(1);
        }
        if (x3Var.a0.f2137e.isAccessibilityFocused()) {
            x3Var.a0.f2137e.sendAccessibilityEvent(32);
        }
        x3Var.a0.b.setOnClickListener(new v(x3Var, view, c0Var));
    }
}
