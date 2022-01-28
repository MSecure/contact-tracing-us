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
    public List<ParcelFileDescriptor> f2693d;

    /* renamed from: e  reason: collision with root package name */
    public b f2694e;

    /* renamed from: f  reason: collision with root package name */
    public String f2695f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f2696g;

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
        this.f2693d = list2;
        this.f2694e = bVar;
        this.f2695f = str;
        this.f2696g = b1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            y1 y1Var = (y1) obj;
            return m.h.U(this.b, y1Var.b) && m.h.U(this.c, y1Var.c) && m.h.U(this.f2693d, y1Var.f2693d) && m.h.U(this.f2694e, y1Var.f2694e) && m.h.U(this.f2695f, y1Var.f2695f) && m.h.U(this.f2696g, y1Var.f2696g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2693d, this.f2694e, this.f2695f, this.f2696g});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int O1 = m.h.O1(parcel, 20293);
        m.h.N1(parcel, 1, this.b, false);
        m.h.H1(parcel, 2, this.c.asBinder(), false);
        m.h.N1(parcel, 3, this.f2693d, false);
        m.h.K1(parcel, 4, this.f2694e, i2, false);
        m.h.L1(parcel, 5, this.f2695f, false);
        b1 b1Var = this.f2696g;
        m.h.H1(parcel, 6, b1Var == null ? null : b1Var.asBinder(), false);
        m.h.T1(parcel, O1);
    }
}
