package c.b.a.b.c0;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
public class j extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    public int f2953b;

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f2953b = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f2953b;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f2953b = i;
    }
}
