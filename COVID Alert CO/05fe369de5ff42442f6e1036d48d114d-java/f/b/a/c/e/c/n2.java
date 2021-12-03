package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class n2 extends a {
    public static final Parcelable.Creator<n2> CREATOR = new o2();
    public f b;

    public n2() {
    }

    public n2(IBinder iBinder) {
        this.b = f.a.I(iBinder);
    }

    public /* synthetic */ n2(m2 m2Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof n2) {
            return m.h.U(this.b, ((n2) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.H1(parcel, 1, this.b.asBinder(), false);
        m.h.T1(parcel, O1);
    }
}
