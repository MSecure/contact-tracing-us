package f.b.a.e.p;

import android.view.ViewTreeObserver;

public class f implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ d b;

    public f(d dVar) {
        this.b = dVar;
    }

    public boolean onPreDraw() {
        d dVar = this.b;
        float rotation = dVar.q.getRotation();
        if (dVar.f2934k == rotation) {
            return true;
        }
        dVar.f2934k = rotation;
        dVar.u();
        return true;
    }
}
