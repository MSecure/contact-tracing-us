package c.b.a.a.e.c;

import android.os.Parcel;
import b.b.k.i;
import c.b.a.a.c.k.o.e;
import com.google.android.gms.common.api.Status;

public final class p4 extends a implements m7 {

    /* renamed from: a  reason: collision with root package name */
    public final e<Status> f2690a;

    public p4(e<Status> eVar) {
        super("com.google.android.gms.nearby.internal.connection.IResultListener");
        i.j.s(eVar);
        this.f2690a = eVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 2) {
            return false;
        }
        Status c2 = v3.c(parcel.readInt());
        if (c2.p()) {
            this.f2690a.setResult(c2);
            return true;
        }
        this.f2690a.setFailedResult(c2);
        return true;
    }
}
