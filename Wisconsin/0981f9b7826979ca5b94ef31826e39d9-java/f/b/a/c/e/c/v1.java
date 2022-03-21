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

public final class v1 extends a {
    public static final Parcelable.Creator<v1> CREATOR = new w1();
    public List<TemporaryExposureKey> b;
    public f c;

    /* renamed from: d  reason: collision with root package name */
    public List<ParcelFileDescriptor> f2517d;

    /* renamed from: e  reason: collision with root package name */
    public b f2518e;

    /* renamed from: f  reason: collision with root package name */
    public String f2519f;

    /* renamed from: g  reason: collision with root package name */
    public u0 f2520g;

    public v1() {
    }

    public v1(u1 u1Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v1) {
            v1 v1Var = (v1) obj;
            return m.h.U(this.b, v1Var.b) && m.h.U(this.c, v1Var.c) && m.h.U(this.f2517d, v1Var.f2517d) && m.h.U(this.f2518e, v1Var.f2518e) && m.h.U(this.f2519f, v1Var.f2519f) && m.h.U(this.f2520g, v1Var.f2520g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2517d, this.f2518e, this.f2519f, this.f2520g});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.G1(parcel, 1, this.b, false);
        m.h.A1(parcel, 2, this.c.asBinder(), false);
        m.h.G1(parcel, 3, this.f2517d, false);
        m.h.D1(parcel, 4, this.f2518e, i2, false);
        m.h.E1(parcel, 5, this.f2519f, false);
        u0 u0Var = this.f2520g;
        m.h.A1(parcel, 6, u0Var == null ? null : u0Var.asBinder(), false);
        m.h.M1(parcel, H1);
    }

    public v1(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, b bVar, String str, IBinder iBinder2) {
        u0 u0Var;
        f E = f.a.E(iBinder);
        if (iBinder2 == null) {
            u0Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            u0Var = queryLocalInterface instanceof u0 ? (u0) queryLocalInterface : new w0(iBinder2);
        }
        this.b = list;
        this.c = E;
        this.f2517d = list2;
        this.f2518e = bVar;
        this.f2519f = str;
        this.f2520g = u0Var;
    }
}
