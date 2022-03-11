package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class h0 extends a {
    public static final Parcelable.Creator<h0> CREATOR = new i0();
    public p1 b;

    public h0() {
    }

    public h0(IBinder iBinder) {
        p1 p1Var;
        if (iBinder == null) {
            p1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IPackageConfigurationCallback");
            p1Var = queryLocalInterface instanceof p1 ? (p1) queryLocalInterface : new n1(iBinder);
        }
        this.b = p1Var;
    }

    public /* synthetic */ h0(g0 g0Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h0) {
            return m.e.X(this.b, ((h0) obj).b);
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.c2(parcel, 1, this.b.asBinder(), false);
        m.e.o2(parcel, j2);
    }
}
