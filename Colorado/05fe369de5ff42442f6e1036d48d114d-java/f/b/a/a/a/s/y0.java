package f.b.a.a.a.s;

import android.view.KeyEvent;
import android.widget.TextView;
import e.b.a.m;
import java.util.Objects;

public final /* synthetic */ class y0 implements TextView.OnEditorActionListener {
    public final /* synthetic */ a6 a;

    public /* synthetic */ y0(a6 a6Var) {
        this.a = a6Var;
    }

    public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        a6 a6Var = this.a;
        Objects.requireNonNull(a6Var);
        if (i2 != 6) {
            return false;
        }
        a6Var.g0.f2174g.clearFocus();
        m.h.H0(a6Var.p0(), a6Var.g0.f2174g);
        return true;
    }
}
