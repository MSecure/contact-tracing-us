package f.b.a.a.a.p;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import e.b.a.m;
import e.p.r;
import f.b.a.a.a.h.s.a;
import f.b.a.a.a.w.b0;
import gov.wi.covid19.exposurenotifications.R;
import java.util.Objects;
import l.b.a.e;
import l.b.a.q;

public final /* synthetic */ class l0 implements r {
    public final /* synthetic */ q3 a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Button f2181d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Button f2182e;

    public /* synthetic */ l0(q3 q3Var, EditText editText, View view, Button button, Button button2) {
        this.a = q3Var;
        this.b = editText;
        this.c = view;
        this.f2181d = button;
        this.f2182e = button2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008d  */
    @Override // e.p.r
    public final void a(Object obj) {
        a aVar;
        int ordinal;
        e i2;
        int i3;
        q3 q3Var = this.a;
        EditText editText = this.b;
        View view = this.c;
        Button button = this.f2181d;
        Button button2 = this.f2182e;
        b0 b0Var = (b0) obj;
        Objects.requireNonNull(q3Var);
        editText.setText(b0Var.i() == null ? "" : q3Var.z0().b(b0Var.i()));
        if (b0Var.i() == null) {
            q3Var.C0();
        }
        int ordinal2 = b0Var.d().ordinal();
        if (ordinal2 == 1) {
            i3 = R.id.has_symptoms_yes;
        } else if (ordinal2 != 2) {
            if (ordinal2 == 3) {
                i3 = R.id.has_symptoms_withheld;
            }
            aVar = q3Var.Z;
            ordinal = b0Var.d().ordinal();
            if (!(ordinal != 1 ? !((i2 = b0Var.i()) == null || !m.h.x0(aVar, i2.A(q.f4070g).w().D())) : ordinal == 2 || ordinal == 3)) {
                button.setEnabled(true);
                button.setOnClickListener(new o0(q3Var, b0Var));
            } else {
                button.setEnabled(false);
            }
            button2.setOnClickListener(new j0(q3Var, view, b0Var));
        } else {
            i3 = R.id.has_symptoms_no;
        }
        q3Var.D0(view, i3, true);
        aVar = q3Var.Z;
        ordinal = b0Var.d().ordinal();
        if (ordinal != 1) {
            if (!(ordinal != 1 ? !((i2 = b0Var.i()) == null || !m.h.x0(aVar, i2.A(q.f4070g).w().D())) : ordinal == 2 || ordinal == 3)) {
            }
            button2.setOnClickListener(new j0(q3Var, view, b0Var));
        }
        if (!(ordinal != 1 ? !((i2 = b0Var.i()) == null || !m.h.x0(aVar, i2.A(q.f4070g).w().D())) : ordinal == 2 || ordinal == 3)) {
        }
        button2.setOnClickListener(new j0(q3Var, view, b0Var));
        if (!(ordinal != 1 ? !((i2 = b0Var.i()) == null || !m.h.x0(aVar, i2.A(q.f4070g).w().D())) : ordinal == 2 || ordinal == 3)) {
        }
        button2.setOnClickListener(new j0(q3Var, view, b0Var));
    }
}
