package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class y8 extends a {
    public static final Parcelable.Creator<y8> CREATOR = new b9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2812b;

    /* renamed from: c  reason: collision with root package name */
    public String f2813c;

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
        this.f2812b = m7Var;
        this.f2813c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y8) {
            y8 y8Var = (y8) obj;
            return i.j.X(this.f2812b, y8Var.f2812b) && i.j.X(this.f2813c, y8Var.f2813c);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2812b, this.f2813c});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2812b;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        i.j.z1(parcel, 2, this.f2813c, false);
        i.j.F1(parcel, e2);
    }

    public y8(z8 z8Var) {
    }
}
