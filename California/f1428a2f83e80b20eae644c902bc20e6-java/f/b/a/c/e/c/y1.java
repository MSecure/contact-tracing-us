package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class y1 extends a {
    public static final Parcelable.Creator<y1> CREATOR = new z1();
    public f b;
    public DiagnosisKeysDataMapping c;

    public y1() {
    }

    public y1(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.b = f.a.E(iBinder);
        this.c = diagnosisKeysDataMapping;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            y1 y1Var = (y1) obj;
            return m.h.U(this.b, y1Var.b) && m.h.U(this.c, y1Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.A1(parcel, 1, this.b.asBinder(), false);
        m.h.D1(parcel, 2, this.c, i2, false);
        m.h.M1(parcel, H1);
    }

    public y1(x1 x1Var) {
    }
}
