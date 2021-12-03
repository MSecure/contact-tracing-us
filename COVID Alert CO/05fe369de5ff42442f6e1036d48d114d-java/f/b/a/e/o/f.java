package f.b.a.e.o;

import android.view.ViewTreeObserver;

public class f implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ d b;

    public f(d dVar) {
        this.b = dVar;
    }

    public boolean onPreDraw() {
        d dVar = this.b;
        float rotation = dVar.s.getRotation();
        if (dVar.m == rotation) {
            return true;
        }
        dVar.m = rotation;
        dVar.s();
        return true;
    }
}
