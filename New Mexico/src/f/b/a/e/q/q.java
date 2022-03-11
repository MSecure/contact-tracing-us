package f.b.a.e.q;

import android.widget.ImageButton;
/* loaded from: classes.dex */
public class q extends ImageButton {
    public int b;

    public final void b(int i2, boolean z) {
        super.setVisibility(i2);
        if (z) {
            this.b = i2;
        }
    }

    public final int getUserSetVisibility() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        this.b = i2;
    }
}
