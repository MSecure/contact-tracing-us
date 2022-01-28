package androidx.fragment.app;

import android.view.View;
import e.m.a.m;
import e.p.h;
import e.p.j;
import e.p.l;

public class Fragment$5 implements j {
    public final /* synthetic */ m a;

    public Fragment$5(m mVar) {
        this.a = mVar;
    }

    @Override // e.p.j
    public void d(l lVar, h.a aVar) {
        View view;
        if (aVar == h.a.ON_STOP && (view = this.a.F) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
