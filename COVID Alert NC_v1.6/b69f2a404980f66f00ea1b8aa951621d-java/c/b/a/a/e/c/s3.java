package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class s3 extends a {
    public static final Parcelable.Creator<s3> CREATOR = new t3();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2711b;

    /* renamed from: c  reason: collision with root package name */
    public long f2712c;

    public s3() {
    }

    public s3(IBinder iBinder, long j) {
        m7 m7Var;
        if (iBinder == null) {
            m7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            m7Var = queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new p7(iBinder);
        }
        this.f2711b = m7Var;
        this.f2712c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s3) {
            s3 s3Var = (s3) obj;
            return i.j.X(this.f2711b, s3Var.f2711b) && i.j.X(Long.valueOf(this.f2712c), Long.valueOf(s3Var.f2712c));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2711b, Long.valueOf(this.f2712c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2711b;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        i.j.x1(parcel, 2, this.f2712c);
        i.j.F1(parcel, e2);
    }

    public s3(r3 r3Var) {
    }
}
