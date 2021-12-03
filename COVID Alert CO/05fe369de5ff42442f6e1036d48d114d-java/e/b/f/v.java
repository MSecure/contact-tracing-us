package e.b.f;

import android.view.View;
import e.b.e.i.p;
import e.b.f.w;

public class v extends h0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w.d f948k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w f949l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(w wVar, View view, w.d dVar) {
        super(view);
        this.f949l = wVar;
        this.f948k = dVar;
    }

    @Override // e.b.f.h0
    public p b() {
        return this.f948k;
    }

    @Override // e.b.f.h0
    public boolean c() {
        if (this.f949l.getInternalPopup().c()) {
            return true;
        }
        this.f949l.b();
        return true;
    }
}
