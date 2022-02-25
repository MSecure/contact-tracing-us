package f.b.a.a.a.p;

import android.widget.Button;
import android.widget.ViewFlipper;
import e.p.r;

public final /* synthetic */ class w implements r {
    public final /* synthetic */ ViewFlipper a;
    public final /* synthetic */ Button b;

    public /* synthetic */ w(ViewFlipper viewFlipper, Button button) {
        this.a = viewFlipper;
        this.b = button;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        int i2;
        ViewFlipper viewFlipper = this.a;
        Button button = this.b;
        int i3 = j3.a0;
        if (((Boolean) obj).booleanValue()) {
            i2 = 0;
            viewFlipper.setDisplayedChild(0);
        } else {
            viewFlipper.setDisplayedChild(1);
            i2 = 4;
        }
        button.setVisibility(i2);
    }
}
