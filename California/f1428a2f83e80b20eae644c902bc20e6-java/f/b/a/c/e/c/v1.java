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
    public List<ParcelFileDescriptor> f2509d;

    /* renamed from: e  reason: collision with root package name */
    public b f2510e;

    /* renamed from: f  reason: collision with root package name */
    public String f2511f;

    /* renamed from: g  reason: collision with root package name */
    public u0 f2512g;

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
            return m.h.U(this.b, v1Var.b) && m.h.U(this.c, v1Var.c) && m.h.U(this.f2509d, v1Var.f2509d) && m.h.U(this.f2510e, v1Var.f2510e) && m.h.U(this.f2511f, v1Var.f2511f) && m.h.U(this.f2512g, v1Var.f2512g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2509d, this.f2510e, this.f2511f, this.f2512g});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.G1(parcel, 1, this.b, false);
        m.h.A1(parcel, 2, this.c.asBinder(), false);
        m.h.G1(parcel, 3, this.f2509d, false);
        m.h.D1(parcel, 4, this.f2510e, i2, false);
        m.h.E1(parcel, 5, this.f2511f, false);
        u0 u0Var = this.f2512g;
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
        this.f2509d = list2;
        this.f2510e = bVar;
        this.f2511f = str;
        this.f2512g = u0Var;
    }
}
