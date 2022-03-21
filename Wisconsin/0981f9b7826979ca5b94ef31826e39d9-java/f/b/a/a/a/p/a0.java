package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ViewSwitcher;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.w.b0;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class a0 implements r {
    public final /* synthetic */ l3 a;
    public final /* synthetic */ Button b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2162d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Button f2163e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f2164f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f2165g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ViewSwitcher f2166h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ View f2167i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Button f2168j;

    public /* synthetic */ a0(l3 l3Var, Button button, View view, EditText editText, Button button2, View view2, View view3, ViewSwitcher viewSwitcher, View view4, Button button3) {
        this.a = l3Var;
        this.b = button;
        this.c = view;
        this.f2162d = editText;
        this.f2163e = button2;
        this.f2164f = view2;
        this.f2165g = view3;
        this.f2166h = viewSwitcher;
        this.f2167i = view4;
        this.f2168j = button3;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        l3 l3Var = this.a;
        Button button = this.b;
        View view = this.c;
        EditText editText = this.f2162d;
        Button button2 = this.f2163e;
        View view2 = this.f2164f;
        View view3 = this.f2165g;
        ViewSwitcher viewSwitcher = this.f2166h;
        View view4 = this.f2167i;
        Button button3 = this.f2168j;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(l3Var);
        button.setOnClickListener(new z(l3Var, view, editText));
        button2.setOnClickListener(new y(l3Var, view, b0Var));
        if (!m.h.q0(b0Var) || b0.c.SHARED.equals(b0Var.k())) {
            view2.setVisibility(8);
            viewSwitcher.setDisplayedChild(0);
        } else {
            view2.setVisibility(0);
            view2.announceForAccessibility(l3Var.z(R.string.share_test_identifier_verified));
            view3.setVisibility(8);
            editText.setEnabled(false);
            editText.setText(b0Var.n());
            viewSwitcher.setDisplayedChild(1);
        }
        if (button2.isAccessibilityFocused()) {
            button2.sendAccessibilityEvent(32);
        }
        view4.setOnClickListener(new d0(l3Var, view, b0Var));
        button3.setOnClickListener(new g0(l3Var, view, b0Var));
    }
}
