package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import e.z.a;

public final class k implements a {
    public final LinearLayout a;
    public final Button b;
    public final TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f2104d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageButton f2105e;

    public k(LinearLayout linearLayout, Button button, TextView textView, TextView textView2, ImageButton imageButton) {
        this.a = linearLayout;
        this.b = button;
        this.c = textView;
        this.f2104d = textView2;
        this.f2105e = imageButton;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
