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
/* loaded from: classes.dex */
public final class y1 extends a {
    public static final Parcelable.Creator<y1> CREATOR = new z1();
    public List<TemporaryExposureKey> b;
    public f c;

    /* renamed from: d */
    public List<ParcelFileDescriptor> f2788d;

    /* renamed from: e */
    public b f2789e;

    /* renamed from: f */
    public String f2790f;

    /* renamed from: g */
    public b1 f2791g;

    public y1() {
    }

    public /* synthetic */ y1(x1 x1Var) {
    }

    public y1(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, b bVar, String str, IBinder iBinder2) {
        b1 b1Var;
        f U = f.a.U(iBinder);
        if (iBinder2 == null) {
            b1Var = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            b1Var = queryLocalInterface instanceof b1 ? (b1) queryLocalInterface : new a1(iBinder2);
        }
        this.b = list;
        this.c = U;
        this.f2788d = list2;
        this.f2789e = bVar;
        this.f2790f = str;
        this.f2791g = b1Var;
    }

    @Override // java.lang.Object
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y1) {
            y1 y1Var = (y1) obj;
            if (m.e.X(this.b, y1Var.b) && m.e.X(this.c, y1Var.c) && m.e.X(this.f2788d, y1Var.f2788d) && m.e.X(this.f2789e, y1Var.f2789e) && m.e.X(this.f2790f, y1Var.f2790f) && m.e.X(this.f2791g, y1Var.f2791g)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f2788d, this.f2789e, this.f2790f, this.f2791g});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.i2(parcel, 1, this.b, false);
        m.e.c2(parcel, 2, this.c.asBinder(), false);
        m.e.i2(parcel, 3, this.f2788d, false);
        m.e.f2(parcel, 4, this.f2789e, i2, false);
        m.e.g2(parcel, 5, this.f2790f, false);
        b1 b1Var = this.f2791g;
        m.e.c2(parcel, 6, b1Var == null ? null : b1Var.asBinder(), false);
        m.e.o2(parcel, j2);
    }
}
