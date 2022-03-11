package f.b.a.c.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import e.b.a.m;
import f.b.a.c.b.l.l.f;
import f.b.a.c.b.m.n.a;
import f.b.a.c.f.b.b;
import java.util.Arrays;
import java.util.List;

public final class w1 extends a {
    public static final Parcelable.Creator<w1> CREATOR = new x1();
    public List<TemporaryExposureKey> b;
    public f c;

    /* renamed from: d  reason: collision with root package name */
    public List<ParcelFileDescriptor> f2599d;

    /* renamed from: e  reason: collision with root package name */
    public b f2600e;

    /* renamed from: f  reason: collision with root package name */
    public String f2601f;

    /* renamed from: g  reason: collision with root package name */
    public z0 f2602g;

    public w1() {
    }

    public /* synthetic */ w1(v1 v1Var) {
    }

    public w1(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, b bVar, String str, IBinder iBinder2) {
        z0 z0Var;
        f G = f.a.G(iBinder);
        if (iBinder2 == null) {
            z0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            z0Var = queryLocalInterface instanceof z0 ? (z0) queryLocalInterface : new y0(iBinder2);
        }
        this.b = list;
        this.c = G;
        this.f2599d = list2;
        this.f2600e = bVar;
        this.f2601f = str;
        this.f2602g = z0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w1) {
            w1 w1Var = (w1) obj;
            return m.h.U(this.b, w1Var.b) && m.h.U(this.c, w1Var.c) && m.h.U(this.f2599d, w1Var.f2599d) && m.h.U(this.f2600e, w1Var.f2600e) && m.h.U(this.f2601f, w1Var.f2601f) && m.h.U(this.f2602g, w1Var.f2602g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2599d, this.f2600e, this.f2601f, this.f2602g});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.H1(parcel, 1, this.b, false);
        m.h.B1(parcel, 2, this.c.asBinder(), false);
        m.h.H1(parcel, 3, this.f2599d, false);
        m.h.E1(parcel, 4, this.f2600e, i2, false);
        m.h.F1(parcel, 5, this.f2601f, false);
        z0 z0Var = this.f2602g;
        m.h.B1(parcel, 6, z0Var == null ? null : z0Var.asBinder(), false);
        m.h.N1(parcel, I1);
    }
}
