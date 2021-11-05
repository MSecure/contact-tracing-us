package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class y8 extends a {
    public static final Parcelable.Creator<y8> CREATOR = new b9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3819b;

    /* renamed from: c  reason: collision with root package name */
    public String f3820c;

    public y8() {
    }

    public y8(IBinder iBinder, String str) {
        m7 m7Var;
        if (iBinder == null) {
            m7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            m7Var = queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new p7(iBinder);
        }
        this.f3819b = m7Var;
        this.f3820c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y8) {
            y8 y8Var = (y8) obj;
            return t.j1(this.f3819b, y8Var.f3819b) && t.j1(this.f3820c, y8Var.f3820c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3819b, this.f3820c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        m7 m7Var = this.f3819b;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        t.w3(parcel, 2, this.f3820c, false);
        t.w4(parcel, m);
    }

    public y8(z8 z8Var) {
    }
}
