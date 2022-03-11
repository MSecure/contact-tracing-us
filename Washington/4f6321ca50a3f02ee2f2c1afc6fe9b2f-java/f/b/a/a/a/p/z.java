package f.b.a.a.a.p;

import android.view.View;
import android.widget.EditText;
import e.b.a.m;

public final /* synthetic */ class z implements View.OnClickListener {
    public final /* synthetic */ l3 b;
    public final /* synthetic */ View c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EditText f2197d;

    public /* synthetic */ z(l3 l3Var, View view, EditText editText) {
        this.b = l3Var;
        this.c = view;
        this.f2197d = editText;
    }

    public final void onClick(View view) {
        l3 l3Var = this.b;
        View view2 = this.c;
        EditText editText = this.f2197d;
        m.h.C0(l3Var.n0(), view2);
        l3Var.Z.k(editText.getText().toString(), false);
    }
}
