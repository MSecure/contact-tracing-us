package e.b.f;

import android.view.View;
import e.b.e.i.p;
import e.b.f.w;

public class v extends h0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w.d f958k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w f959l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(w wVar, View view, w.d dVar) {
        super(view);
        this.f959l = wVar;
        this.f958k = dVar;
    }

    @Override // e.b.f.h0
    public p b() {
        return this.f958k;
    }

    @Override // e.b.f.h0
    public boolean c() {
        if (this.f959l.getInternalPopup().c()) {
            return true;
        }
        this.f959l.b();
        return true;
    }
}
