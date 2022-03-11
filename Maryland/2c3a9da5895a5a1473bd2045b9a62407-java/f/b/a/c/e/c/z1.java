package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class z1 extends a {
    public static final Parcelable.Creator<z1> CREATOR = new a2();
    public f b;
    public DiagnosisKeysDataMapping c;

    public z1() {
    }

    public z1(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.b = f.a.G(iBinder);
        this.c = diagnosisKeysDataMapping;
    }

    public /* synthetic */ z1(y1 y1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z1) {
            z1 z1Var = (z1) obj;
            return m.h.U(this.b, z1Var.b) && m.h.U(this.c, z1Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.B1(parcel, 1, this.b.asBinder(), false);
        m.h.E1(parcel, 2, this.c, i2, false);
        m.h.N1(parcel, I1);
    }
}
