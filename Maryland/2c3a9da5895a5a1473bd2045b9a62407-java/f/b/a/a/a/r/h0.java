package f.b.a.a.a.r;

import android.widget.Button;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputEditText;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.y.c0;
import java.util.Objects;
import l.b.a.e;
import l.b.a.q;

public final /* synthetic */ class h0 implements r {
    public final /* synthetic */ c4 a;

    public /* synthetic */ h0(c4 c4Var) {
        this.a = c4Var;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        String str;
        TextInputEditText textInputEditText;
        e i2;
        MaterialRadioButton materialRadioButton;
        c4 c4Var = this.a;
        c0 c0Var = (c0) obj;
        Objects.requireNonNull(c4Var);
        if (c0Var.i() == null) {
            textInputEditText = c4Var.b0.f2150i;
            str = "";
        } else {
            textInputEditText = c4Var.b0.f2150i;
            str = c4Var.z0().b(c0Var.i());
        }
        textInputEditText.setText(str);
        if (c0Var.i() == null) {
            c4Var.C0();
        }
        int ordinal = c0Var.d().ordinal();
        boolean z = true;
        if (ordinal == 1) {
            materialRadioButton = c4Var.b0.f2146e;
        } else if (ordinal != 2) {
            if (ordinal == 3) {
                materialRadioButton = c4Var.b0.f2145d;
            }
            Button button = c4Var.b0.f2148g;
            a aVar = c4Var.a0;
            int ordinal2 = c0Var.d().ordinal();
            if (ordinal2 == 1 ? (i2 = c0Var.i()) == null || !m.h.x0(aVar, i2.A(q.f4166g).w().E()) : !(ordinal2 == 2 || ordinal2 == 3)) {
                z = false;
            }
            button.setEnabled(z);
        } else {
            materialRadioButton = c4Var.b0.b;
        }
        materialRadioButton.setChecked(true);
        Button button2 = c4Var.b0.f2148g;
        a aVar2 = c4Var.a0;
        int ordinal22 = c0Var.d().ordinal();
        z = false;
        button2.setEnabled(z);
    }
}
