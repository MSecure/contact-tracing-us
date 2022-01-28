package c.b.a.a.g.e;

import android.os.Parcel;
import b.x.t;
import c.b.a.a.d.k.o.e;
import com.google.android.gms.common.api.Status;

public final class p4 extends a implements m7 {

    /* renamed from: a  reason: collision with root package name */
    public final e<Status> f3684a;

    public p4(e<Status> eVar) {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
        t.C(eVar);
        this.f3684a = eVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: e0 */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        Status c2 = v3.c(parcel.readInt());
        if (c2.t()) {
            this.f3684a.setResult(c2);
            return true;
        }
        this.f3684a.setFailedResult(c2);
        return true;
    }
}
