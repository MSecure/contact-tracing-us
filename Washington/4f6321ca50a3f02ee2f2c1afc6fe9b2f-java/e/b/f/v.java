package e.b.f;

import android.view.View;
import e.b.e.i.p;
import e.b.f.w;

public class v extends h0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ w.d f954k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ w f955l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(w wVar, View view, w.d dVar) {
        super(view);
        this.f955l = wVar;
        this.f954k = dVar;
    }

    @Override // e.b.f.h0
    public p b() {
        return this.f954k;
    }

    @Override // e.b.f.h0
    public boolean c() {
        if (this.f955l.getInternalPopup().c()) {
            return true;
        }
        this.f955l.b();
        return true;
    }
}
