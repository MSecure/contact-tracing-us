package f.b.a.a.a.i;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import e.z.a;

public final class b implements a {
    public final FrameLayout a;
    public final Button b;
    public final SwitchMaterial c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageButton f2097d;

    public b(FrameLayout frameLayout, Button button, SwitchMaterial switchMaterial, ImageButton imageButton) {
        this.a = frameLayout;
        this.b = button;
        this.c = switchMaterial;
        this.f2097d = imageButton;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
