package f.b.a.a.a.s;

import com.google.android.material.radiobutton.MaterialRadioButton;
import e.p.t;
import f.b.a.a.a.b0.v0;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class l2 implements t {
    public final /* synthetic */ l6 a;

    public /* synthetic */ l2(l6 l6Var) {
        this.a = l6Var;
    }

    @Override // e.p.t
    public final void a(Object obj) {
        MaterialRadioButton materialRadioButton;
        l6 l6Var = this.a;
        l lVar = (l) obj;
        Objects.requireNonNull(l6Var);
        if (lVar.b()) {
            int ordinal = ((v0.i) lVar.a()).ordinal();
            if (ordinal == 0) {
                materialRadioButton = l6Var.e0.f2201g.c;
            } else if (ordinal == 1) {
                materialRadioButton = l6Var.e0.f2201g.f2159e;
            } else if (ordinal == 2) {
                materialRadioButton = l6Var.e0.f2201g.b;
            } else {
                throw new IllegalStateException("Failed to map vaccination status to radio button id");
            }
            materialRadioButton.setChecked(true);
        }
    }
}
