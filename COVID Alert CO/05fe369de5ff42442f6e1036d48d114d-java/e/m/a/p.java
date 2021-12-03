package e.m.a;

import android.os.Bundle;
import android.os.Parcelable;
import e.p.h;
import e.u.a;

public class p implements a.b {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    @Override // e.u.a.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (r.q(this.a.p(), h.b.CREATED));
        this.a.f1494l.e(h.a.ON_STOP);
        Parcelable e0 = this.a.f1493k.a.f1408e.e0();
        if (e0 != null) {
            bundle.putParcelable("android:support:fragments", e0);
        }
        return bundle;
    }
}
