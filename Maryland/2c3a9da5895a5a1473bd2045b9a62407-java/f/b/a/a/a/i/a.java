package f.b.a.a.a.i;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public final class a implements e.z.a {
    public final FrameLayout a;
    public final TextView b;
    public final ImageButton c;

    public a(FrameLayout frameLayout, TextView textView, ImageButton imageButton) {
        this.a = frameLayout;
        this.b = textView;
        this.c = imageButton;
    }

    @Override // e.z.a
    public View a() {
        return this.a;
    }
}
