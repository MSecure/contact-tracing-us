package androidx.fragment.app;

import android.view.View;
import e.m.a.l;
import e.p.g;
import e.p.h;
import e.p.j;

public class Fragment$5 implements h {
    public final /* synthetic */ l a;

    public Fragment$5(l lVar) {
        this.a = lVar;
    }

    @Override // e.p.h
    public void d(j jVar, g.a aVar) {
        View view;
        if (aVar == g.a.ON_STOP && (view = this.a.F) != null) {
            view.cancelPendingInputEvents();
        }
    }
}
