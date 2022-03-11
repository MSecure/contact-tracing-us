package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class e2 extends a {
    public static final Parcelable.Creator<e2> CREATOR = new f2();
    public f b;

    public e2() {
    }

    public e2(IBinder iBinder) {
        this.b = f.a.E(iBinder);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e2) {
            return m.h.U(this.b, ((e2) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.B1(parcel, 1, this.b.asBinder(), false);
        m.h.N1(parcel, I1);
    }

    public e2(d2 d2Var) {
    }
}
