package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class s3 extends a {
    public static final Parcelable.Creator<s3> CREATOR = new t3();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3705b;

    /* renamed from: c  reason: collision with root package name */
    public long f3706c;

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
        this.f3705b = m7Var;
        this.f3706c = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s3) {
            s3 s3Var = (s3) obj;
            return t.j1(this.f3705b, s3Var.f3705b) && t.j1(Long.valueOf(this.f3706c), Long.valueOf(s3Var.f3706c));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3705b, Long.valueOf(this.f3706c)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        m7 m7Var = this.f3705b;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        t.t3(parcel, 2, this.f3706c);
        t.w4(parcel, m);
    }

    public s3(r3 r3Var) {
    }
}
