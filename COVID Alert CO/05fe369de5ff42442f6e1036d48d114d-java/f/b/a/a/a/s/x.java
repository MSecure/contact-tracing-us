package f.b.a.a.a.s;

import android.view.View;
import android.widget.EditText;
import e.b.a.m;

public final /* synthetic */ class x implements View.OnClickListener {
    public final /* synthetic */ v5 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2396d;

    public /* synthetic */ x(v5 v5Var, View view, EditText editText) {
        this.b = v5Var;
        this.c = view;
        this.f2396d = editText;
    }

    public final void onClick(View view) {
        v5 v5Var = this.b;
        View view2 = this.c;
        EditText editText = this.f2396d;
        m.h.H0(v5Var.p0(), view2);
        v5Var.a0.u(editText.getText().toString(), false);
    }
}
