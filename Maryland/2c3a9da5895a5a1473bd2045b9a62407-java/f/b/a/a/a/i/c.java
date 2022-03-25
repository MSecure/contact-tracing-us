package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.z.a;

public final class c implements a {
    public final FrameLayout a;
    public final TextView b;
    public final LinearLayout c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f2098d;

    /* renamed from: e  reason: collision with root package name */
    public final SwitchMaterial f2099e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageButton f2100f;

    public c(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, LinearLayout linearLayout, Button button, SwitchMaterial switchMaterial, ImageButton imageButton) {
        this.a = frameLayout;
        this.b = textView;
        this.c = linearLayout;
        this.f2098d = button;
        this.f2099e = switchMaterial;
        this.f2100f = imageButton;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
