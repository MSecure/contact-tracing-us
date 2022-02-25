package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import e.p.r;
import f.b.a.a.a.w.b0;
import gov.ca.covid19.exposurenotifications.R;
import java.util.Objects;

public final /* synthetic */ class k1 implements r {
    public final /* synthetic */ w3 a;
    public final /* synthetic */ Button b;
    public final /* synthetic */ Button c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f2180d;

    public /* synthetic */ k1(w3 w3Var, Button button, Button button2, View view) {
        this.a = w3Var;
        this.b = button;
        this.c = button2;
        this.f2180d = view;
    }

    @Override // e.p.r
    public final void a(Object obj) {
        int i2;
        w3 w3Var = this.a;
        Button button = this.b;
        Button button2 = this.c;
        View view = this.f2180d;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(w3Var);
        b0.e m = b0Var.m();
        if (!b0.e.NOT_ATTEMPTED.equals(m)) {
            int ordinal = m.ordinal();
            if (ordinal == 1) {
                i2 = R.id.hasTraveledConfirmed;
            } else if (ordinal == 2) {
                i2 = R.id.hasTraveledNoTravel;
            } else if (ordinal == 3) {
                i2 = R.id.hasTraveledNoAnswer;
            } else {
                throw new IllegalStateException("Failed to map travel status to radio button id");
            }
            ((RadioButton) w3Var.F.findViewById(i2)).setChecked(true);
            button.setOnClickListener(new i1(w3Var, b0Var));
            button.setEnabled(true);
        }
        button2.setOnClickListener(new j1(w3Var, view, b0Var));
    }
}
