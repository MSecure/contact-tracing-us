package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class v1 extends a {
    public static final Parcelable.Creator<v1> CREATOR = new w1();
    public v0 b;
    public w0 c;

    public v1() {
    }

    public v1(IBinder iBinder, IBinder iBinder2) {
        w0 w0Var;
        v0 v0Var = null;
        if (iBinder == null) {
            w0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            w0Var = queryLocalInterface instanceof w0 ? (w0) queryLocalInterface : new w0(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            v0Var = queryLocalInterface2 instanceof v0 ? (v0) queryLocalInterface2 : new t0(iBinder2);
        }
        this.c = w0Var;
        this.b = v0Var;
    }

    public /* synthetic */ v1(u1 u1Var) {
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            if (m.e.X(this.c, v1Var.c) && m.e.X(this.b, v1Var.b)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.c, this.b});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder iBinder;
        int j2 = m.e.j2(parcel, 20293);
        w0 w0Var = this.c;
        if (w0Var == null) {
            iBinder = null;
        } else {
            iBinder = w0Var.a;
        }
        m.e.c2(parcel, 1, iBinder, false);
        m.e.c2(parcel, 2, this.b.asBinder(), false);
        m.e.o2(parcel, j2);
    }
}
