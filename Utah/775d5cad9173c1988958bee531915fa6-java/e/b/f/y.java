package e.b.f;

import android.view.View;
import e.b.e.i.p;
import e.b.f.z;

public class y extends l0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ z.d f990k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ z f991l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(z zVar, View view, z.d dVar) {
        super(view);
        this.f991l = zVar;
        this.f990k = dVar;
    }

    @Override // e.b.f.l0
    public p b() {
        return this.f990k;
    }

    @Override // e.b.f.l0
    public boolean c() {
        if (this.f991l.getInternalPopup().c()) {
            return true;
        }
        this.f991l.b();
        return true;
    }
}
