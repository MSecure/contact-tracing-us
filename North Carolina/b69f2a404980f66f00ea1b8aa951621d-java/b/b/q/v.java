package b.b.q;

import android.annotation.SuppressLint;
import android.view.View;
import b.b.p.i.p;
import b.b.q.w;

public class v extends h0 {
    public final /* synthetic */ w.d k;
    public final /* synthetic */ w l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(w wVar, View view, w.d dVar) {
        super(view);
        this.l = wVar;
        this.k = dVar;
    }

    @Override // b.b.q.h0
    public p b() {
        return this.k;
    }

    @Override // b.b.q.h0
    @SuppressLint({"SyntheticAccessor"})
    public boolean c() {
        if (this.l.getInternalPopup().c()) {
            return true;
        }
        this.l.b();
        return true;
    }
}
