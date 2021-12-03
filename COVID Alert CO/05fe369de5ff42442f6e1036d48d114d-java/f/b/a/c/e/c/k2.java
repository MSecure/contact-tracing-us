package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.b;
import java.util.Arrays;

public final class k2 extends a {
    public static final Parcelable.Creator<k2> CREATOR = new l2();
    public f b;
    public b c;

    public k2() {
    }

    public k2(IBinder iBinder, b bVar) {
        this.b = f.a.I(iBinder);
        this.c = bVar;
    }

    public /* synthetic */ k2(j2 j2Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            return m.h.U(this.b, k2Var.b) && m.h.U(this.c, k2Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.H1(parcel, 3, this.b.asBinder(), false);
        m.h.K1(parcel, 4, this.c, i2, false);
        m.h.T1(parcel, O1);
    }
}
