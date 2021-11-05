package c.b.a.b.c0;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
public class p extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    public int f4224b;

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f4224b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f4224b;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f4224b = i;
    }
}
