package androidx.fragment.app;

import android.view.View;
import e.n.a.m;
import e.q.h;
import e.q.j;
import e.q.l;

public class Fragment$5 implements j {
    public final /* synthetic */ m a;

    public Fragment$5(m mVar) {
        this.a = mVar;
    }

    @Override // e.q.j
    public void d(l lVar, h.a aVar) {
        View view;
        if (aVar == h.a.ON_STOP && (view = this.a.F) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
