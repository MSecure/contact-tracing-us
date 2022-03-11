package e.b.f;

import android.view.View;
import android.view.Window;
import e.b.e.i.a;

public class z0 implements View.OnClickListener {
    public final a b;
    public final /* synthetic */ a1 c;

    public z0(a1 a1Var) {
        this.c = a1Var;
        this.b = new a(a1Var.a.getContext(), 0, 16908332, 0, a1Var.f848i);
    }

    public void onClick(View view) {
        a1 a1Var = this.c;
        Window.Callback callback = a1Var.f851l;
        if (callback != null && a1Var.m) {
            callback.onMenuItemSelected(0, this.b);
        }
    }
}
