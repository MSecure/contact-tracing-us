package f.b.a.a.a.d0;

import android.view.KeyEvent;
import android.widget.TextView;
import e.b.a.m;
import java.util.Objects;

public final /* synthetic */ class y0 implements TextView.OnEditorActionListener {
    public final /* synthetic */ z5 a;

    public /* synthetic */ y0(z5 z5Var) {
        this.a = z5Var;
    }

    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        z5 z5Var = this.a;
        Objects.requireNonNull(z5Var);
        if (i2 != 6) {
            return false;
        }
        z5Var.h0.f2369g.clearFocus();
        m.e.S0(z5Var.t0(), z5Var.h0.f2369g);
        return true;
    }
}
