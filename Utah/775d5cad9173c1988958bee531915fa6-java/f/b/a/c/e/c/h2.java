package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public final class h2 extends a {
    public static final Parcelable.Creator<h2> CREATOR = new i2();
    public f b;
    public DiagnosisKeysDataMapping c;

    public h2() {
    }

    public h2(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.b = f.a.I(iBinder);
        this.c = diagnosisKeysDataMapping;
    }

    public /* synthetic */ h2(g2 g2Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h2) {
            h2 h2Var = (h2) obj;
            return m.e.W(this.b, h2Var.b) && m.e.W(this.c, h2Var.c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        m.e.U1(parcel, 1, this.b.asBinder(), false);
        m.e.X1(parcel, 2, this.c, i2, false);
        m.e.g2(parcel, b2);
    }
}
