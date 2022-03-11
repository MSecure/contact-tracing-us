package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b0 extends a {
    public static final Parcelable.Creator<b0> CREATOR = new c0();
    public e1 b;

    public b0() {
    }

    public b0(IBinder iBinder) {
        e1 e1Var;
        if (iBinder == null) {
            e1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeysDataMappingCallback");
            e1Var = queryLocalInterface instanceof e1 ? (e1) queryLocalInterface : new c1(iBinder);
        }
        this.b = e1Var;
    }

    public /* synthetic */ b0(a0 a0Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b0) {
            return m.e.X(this.b, ((b0) obj).b);
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
