package f.b.a.a.a.d0;

import com.google.android.material.radiobutton.MaterialRadioButton;
import e.q.t;
import f.b.a.a.a.l0.v0;
import f.b.b.a.l;
import java.util.Objects;

public final /* synthetic */ class l2 implements t {
    public final /* synthetic */ k6 a;

    public /* synthetic */ l2(k6 k6Var) {
        this.a = k6Var;
    }

    @Override // e.q.t
    public final void a(Object obj) {
        MaterialRadioButton materialRadioButton;
        k6 k6Var = this.a;
        l lVar = (l) obj;
        Objects.requireNonNull(k6Var);
        if (lVar.b()) {
            int ordinal = ((v0.i) lVar.a()).ordinal();
            if (ordinal == 0) {
                materialRadioButton = k6Var.f0.f2396g.c;
            } else if (ordinal == 1) {
                materialRadioButton = k6Var.f0.f2396g.f2354e;
            } else if (ordinal == 2) {
                materialRadioButton = k6Var.f0.f2396g.b;
            } else {
                throw new IllegalStateException("Failed to map vaccination status to radio button id");
            }
            materialRadioButton.setChecked(true);
        }
    }
}
