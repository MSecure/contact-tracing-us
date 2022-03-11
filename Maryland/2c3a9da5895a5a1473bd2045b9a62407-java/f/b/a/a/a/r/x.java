package f.b.a.a.a.r;

import android.view.View;
import android.widget.EditText;
import e.b.a.m;

public final /* synthetic */ class x implements View.OnClickListener {
    public final /* synthetic */ x3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2269d;

    public /* synthetic */ x(x3 x3Var, View view, EditText editText) {
        this.b = x3Var;
        this.c = view;
        this.f2269d = editText;
    }

    public final void onClick(View view) {
        x3 x3Var = this.b;
        View view2 = this.c;
        EditText editText = this.f2269d;
        m.h.B0(x3Var.n0(), view2);
        x3Var.b0.k(editText.getText().toString(), false);
    }
}
