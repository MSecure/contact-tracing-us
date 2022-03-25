package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.recyclerview.widget.RecyclerView;
import e.z.a;

public final class n implements a {
    public final LinearLayout a;
    public final LinearLayout b;
    public final Button c;

    /* renamed from: d  reason: collision with root package name */
    public final ViewFlipper f2115d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewFlipper f2116e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f2117f;

    public n(LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, Button button, ViewFlipper viewFlipper, ViewFlipper viewFlipper2, RecyclerView recyclerView) {
        this.a = linearLayout;
        this.b = linearLayout2;
        this.c = button;
        this.f2115d = viewFlipper;
        this.f2116e = viewFlipper2;
        this.f2117f = recyclerView;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
