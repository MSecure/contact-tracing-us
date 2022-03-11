package f.b.a.e.p;

import android.view.ViewTreeObserver;
/* loaded from: classes.dex */
public class f implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ d b;

    public f(d dVar) {
        this.b = dVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        d dVar = this.b;
        float rotation = dVar.r.getRotation();
        if (dVar.f2976k == rotation) {
            return true;
        }
        dVar.f2976k = rotation;
        dVar.u();
        return true;
    }
}
