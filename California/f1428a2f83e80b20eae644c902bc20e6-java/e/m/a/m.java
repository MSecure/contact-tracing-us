package e.m.a;

import android.os.Bundle;
import android.os.Parcelable;
import e.p.g;
import e.u.a;

public class m implements a.b {
    public final /* synthetic */ o a;

    public m(o oVar) {
        this.a = oVar;
    }

    @Override // e.u.a.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (o.o(this.a.n(), g.b.CREATED));
        this.a.f1652k.e(g.a.ON_STOP);
        Parcelable h0 = this.a.f1651j.a.f1694e.h0();
        if (h0 != null) {
            bundle.putParcelable("android:support:fragments", h0);
        }
        return bundle;
    }
}
