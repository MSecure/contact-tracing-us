package b.b.q;

import android.view.View;
import android.view.Window;
import b.b.p.i.a;

public class z0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final a f765b = new a(this.f766c.f590a.getContext(), 0, 16908332, 0, this.f766c.i);

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a1 f766c;

    public z0(a1 a1Var) {
        this.f766c = a1Var;
    }

    public void onClick(View view) {
        a1 a1Var = this.f766c;
        Window.Callback callback = a1Var.l;
        if (callback != null && a1Var.m) {
            callback.onMenuItemSelected(0, this.f765b);
        }
    }
}
