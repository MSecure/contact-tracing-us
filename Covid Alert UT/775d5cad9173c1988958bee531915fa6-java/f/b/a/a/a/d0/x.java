package f.b.a.a.a.d0;

import android.view.View;
import android.widget.EditText;
import e.b.a.m;

public final /* synthetic */ class x implements View.OnClickListener {
    public final /* synthetic */ u5 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2194d;

    public /* synthetic */ x(u5 u5Var, View view, EditText editText) {
        this.b = u5Var;
        this.c = view;
        this.f2194d = editText;
    }

    public final void onClick(View view) {
        u5 u5Var = this.b;
        View view2 = this.c;
        EditText editText = this.f2194d;
        m.e.S0(u5Var.t0(), view2);
        u5Var.b0.u(editText.getText().toString(), false);
    }
}
