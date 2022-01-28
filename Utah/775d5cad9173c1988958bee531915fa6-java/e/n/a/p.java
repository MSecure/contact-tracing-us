package e.n.a;

import android.os.Bundle;
import android.os.Parcelable;
import e.q.h;
import e.v.a;

public class p implements a.b {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    @Override // e.v.a.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (r.r(this.a.q(), h.b.CREATED));
        this.a.f1767l.e(h.a.ON_STOP);
        Parcelable e0 = this.a.f1766k.a.f1680e.e0();
        if (e0 != null) {
            bundle.putParcelable("android:support:fragments", e0);
        }
        return bundle;
    }
}
