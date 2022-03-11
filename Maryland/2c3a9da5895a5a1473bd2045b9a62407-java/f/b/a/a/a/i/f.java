package f.b.a.a.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.z.a;

public final class f implements a {
    public final FrameLayout a;
    public final ImageButton b;
    public final TextView c;

    /* renamed from: d  reason: collision with root package name */
    public final SwitchMaterial f2101d;

    public f(FrameLayout frameLayout, ImageButton imageButton, TextView textView, SwitchMaterial switchMaterial, TextView textView2, FrameLayout frameLayout2) {
        this.a = frameLayout;
        this.b = imageButton;
        this.c = textView;
        this.f2101d = switchMaterial;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
