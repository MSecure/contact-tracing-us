package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.b;
import java.util.Arrays;

public final class b2 extends a {
    public static final Parcelable.Creator<b2> CREATOR = new c2();
    public f b;
    public b c;

    public b2() {
    }

    public b2(IBinder iBinder, b bVar) {
        this.b = f.a.E(iBinder);
        this.c = bVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b2) {
            b2 b2Var = (b2) obj;
            return m.h.U(this.b, b2Var.b) && m.h.U(this.c, b2Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.B1(parcel, 3, this.b.asBinder(), false);
        m.h.E1(parcel, 4, this.c, i2, false);
        m.h.N1(parcel, I1);
    }

    public b2(a2 a2Var) {
    }
}
