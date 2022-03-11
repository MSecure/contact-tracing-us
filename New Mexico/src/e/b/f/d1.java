package e.b.f;

import android.view.View;
import android.view.Window;
import e.b.e.i.a;
/* loaded from: classes.dex */
public class d1 implements View.OnClickListener {
    public final a b;
    public final /* synthetic */ e1 c;

    public d1(e1 e1Var) {
        this.c = e1Var;
        this.b = new a(e1Var.a.getContext(), 0, 16908332, 0, e1Var.f940i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e1 e1Var = this.c;
        Window.Callback callback = e1Var.f943l;
        if (callback != null && e1Var.m) {
            callback.onMenuItemSelected(0, this.b);
        }
    }
}
