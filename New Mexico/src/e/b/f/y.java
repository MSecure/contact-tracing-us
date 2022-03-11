package e.b.f;

import android.view.View;
import e.b.e.i.p;
import e.b.f.z;
/* loaded from: classes.dex */
public class y extends l0 {

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ z.d f1054k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ z f1055l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, View view, z.d dVar) {
        super(view);
        this.f1055l = zVar;
        this.f1054k = dVar;
    }

    @Override // e.b.f.l0
    public p b() {
        return this.f1054k;
    }

    @Override // e.b.f.l0
    public boolean c() {
        if (this.f1055l.getInternalPopup().c()) {
            return true;
        }
        this.f1055l.b();
        return true;
    }
}
