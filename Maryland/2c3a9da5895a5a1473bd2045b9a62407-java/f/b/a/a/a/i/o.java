package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.z.a;

public final class o implements a {
    public final ConstraintLayout a;
    public final TextView b;
    public final SwitchMaterial c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f2118d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewSwitcher f2119e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f2120f;

    /* renamed from: g  reason: collision with root package name */
    public final Button f2121g;

    /* renamed from: h  reason: collision with root package name */
    public final Button f2122h;

    /* renamed from: i  reason: collision with root package name */
    public final ProgressBar f2123i;

    /* renamed from: j  reason: collision with root package name */
    public final NestedScrollView f2124j;

    public o(ConstraintLayout constraintLayout, TextView textView, SwitchMaterial switchMaterial, LinearLayout linearLayout, ViewSwitcher viewSwitcher, TextView textView2, Button button, Button button2, ProgressBar progressBar, NestedScrollView nestedScrollView) {
        this.a = constraintLayout;
        this.b = textView;
        this.c = switchMaterial;
        this.f2118d = linearLayout;
        this.f2119e = viewSwitcher;
        this.f2120f = textView2;
        this.f2121g = button;
        this.f2122h = button2;
        this.f2123i = progressBar;
        this.f2124j = nestedScrollView;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
