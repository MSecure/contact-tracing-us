package c.b.a.b.b0;

import android.view.ViewTreeObserver;

public class g implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ e f4186b;

    public g(e eVar) {
        this.f4186b = eVar;
    }

    public boolean onPreDraw() {
        e eVar = this.f4186b;
        float rotation = eVar.t.getRotation();
        if (eVar.n == rotation) {
            return true;
        }
        eVar.n = rotation;
        eVar.s();
        return true;
    }
}
