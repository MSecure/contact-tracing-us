package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class b2 extends a {
    public static final Parcelable.Creator<b2> CREATOR = new c2();
    public f b;
    public boolean c;

    public b2() {
        this.c = false;
    }

    public b2(IBinder iBinder, boolean z) {
        this.b = f.a.I(iBinder);
        this.c = z;
    }

    public /* synthetic */ b2(a2 a2Var) {
        this.c = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b2) {
            b2 b2Var = (b2) obj;
            return m.h.U(this.b, b2Var.b) && m.h.U(Boolean.valueOf(this.c), Boolean.valueOf(b2Var.c));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Boolean.valueOf(this.c)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.H1(parcel, 1, this.b.asBinder(), false);
        boolean z = this.c;
        m.h.S1(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        m.h.T1(parcel, O1);
    }
}
