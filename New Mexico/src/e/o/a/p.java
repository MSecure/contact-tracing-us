package e.o.a;

import android.os.Bundle;
import android.os.Parcelable;
import e.r.h;
import e.w.a;
/* loaded from: classes.dex */
public class p implements a.b {
    public final /* synthetic */ r a;

    public p(r rVar) {
        this.a = rVar;
    }

    @Override // e.w.a.b
    public Bundle a() {
        Bundle bundle = new Bundle();
        do {
        } while (r.r(this.a.q(), h.b.CREATED));
        this.a.f1852l.e(h.a.ON_STOP);
        Parcelable f0 = this.a.f1851k.a.f1765e.f0();
        if (f0 != null) {
            bundle.putParcelable("android:support:fragments", f0);
        }
        return bundle;
    }
}
