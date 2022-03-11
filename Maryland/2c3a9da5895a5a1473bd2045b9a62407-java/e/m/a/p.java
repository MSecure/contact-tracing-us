package e.m.a;

import android.os.Bundle;
import android.os.Parcelable;
import e.p.g;
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
        } while (r.p(this.a.o(), g.b.CREATED));
        this.a.f1679l.e(g.a.ON_STOP);
        Parcelable h0 = this.a.f1678k.a.f1585e.h0();
        if (h0 != null) {
            bundle.putParcelable("android:support:fragments", h0);
        }
        return bundle;
    }
}
