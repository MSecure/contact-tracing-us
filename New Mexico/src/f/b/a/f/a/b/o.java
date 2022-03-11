package f.b.a.f.a.b;

import android.os.Bundle;
import f.b.a.f.a.h.n;
/* loaded from: classes.dex */
public final class o extends k<Void> {
    public final /* synthetic */ s c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(s sVar, n<Void> nVar) {
        super(sVar, nVar);
        this.c = sVar;
    }

    @Override // f.b.a.f.a.b.k, f.b.a.f.a.e.h0
    public final void v(Bundle bundle, Bundle bundle2) {
        super.v(bundle, bundle2);
        if (!this.c.f3291f.compareAndSet(true, false)) {
            s.f3287g.e("Expected keepingAlive to be true, but was false.", new Object[0]);
        }
        if (bundle.getBoolean("keep_alive")) {
            this.c.c();
        }
    }
}
