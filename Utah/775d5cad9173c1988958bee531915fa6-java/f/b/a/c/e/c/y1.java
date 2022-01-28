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

public final class y1 extends a {
    public static final Parcelable.Creator<y1> CREATOR = new z1();
    public List<TemporaryExposureKey> b;
    public f c;

    /* renamed from: d  reason: collision with root package name */
    public List<ParcelFileDescriptor> f2747d;

    /* renamed from: e  reason: collision with root package name */
    public b f2748e;

    /* renamed from: f  reason: collision with root package name */
    public String f2749f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f2750g;

    public y1() {
    }

    public /* synthetic */ y1(x1 x1Var) {
    }

    public y1(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, b bVar, String str, IBinder iBinder2) {
        b1 b1Var;
        f I = f.a.I(iBinder);
        if (iBinder2 == null) {
            b1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            b1Var = queryLocalInterface instanceof b1 ? (b1) queryLocalInterface : new a1(iBinder2);
        }
        this.b = list;
        this.c = I;
        this.f2747d = list2;
        this.f2748e = bVar;
        this.f2749f = str;
        this.f2750g = b1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            y1 y1Var = (y1) obj;
            return m.e.W(this.b, y1Var.b) && m.e.W(this.c, y1Var.c) && m.e.W(this.f2747d, y1Var.f2747d) && m.e.W(this.f2748e, y1Var.f2748e) && m.e.W(this.f2749f, y1Var.f2749f) && m.e.W(this.f2750g, y1Var.f2750g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2747d, this.f2748e, this.f2749f, this.f2750g});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int b2 = m.e.b2(parcel, 20293);
        m.e.a2(parcel, 1, this.b, false);
        m.e.U1(parcel, 2, this.c.asBinder(), false);
        m.e.a2(parcel, 3, this.f2747d, false);
        m.e.X1(parcel, 4, this.f2748e, i2, false);
        m.e.Y1(parcel, 5, this.f2749f, false);
        b1 b1Var = this.f2750g;
        m.e.U1(parcel, 6, b1Var == null ? null : b1Var.asBinder(), false);
        m.e.g2(parcel, b2);
    }
}
