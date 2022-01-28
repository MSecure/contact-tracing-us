package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class p3 extends a {
    public static final Parcelable.Creator<p3> CREATOR = new q3();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2686b;

    /* renamed from: c  reason: collision with root package name */
    public w6 f2687c;

    /* renamed from: d  reason: collision with root package name */
    public String f2688d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f2689e;
    public l7 f;

    public p3() {
    }

    public p3(IBinder iBinder, IBinder iBinder2, String str, byte[] bArr, IBinder iBinder3) {
        m7 m7Var;
        w6 w6Var;
        l7 l7Var = null;
        if (iBinder == null) {
            m7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            m7Var = queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new p7(iBinder);
        }
        if (iBinder2 == null) {
            w6Var = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionEventListener");
            w6Var = queryLocalInterface2 instanceof w6 ? (w6) queryLocalInterface2 : new y6(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IPayloadListener");
            l7Var = queryLocalInterface3 instanceof l7 ? (l7) queryLocalInterface3 : new n7(iBinder3);
        }
        this.f2686b = m7Var;
        this.f2687c = w6Var;
        this.f2688d = str;
        this.f2689e = bArr;
        this.f = l7Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p3) {
            p3 p3Var = (p3) obj;
            return i.j.X(this.f2686b, p3Var.f2686b) && i.j.X(this.f2687c, p3Var.f2687c) && i.j.X(this.f2688d, p3Var.f2688d) && Arrays.equals(this.f2689e, p3Var.f2689e) && i.j.X(this.f, p3Var.f);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2686b, this.f2687c, this.f2688d, Integer.valueOf(Arrays.hashCode(this.f2689e)), this.f});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2686b;
        IBinder iBinder = null;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        w6 w6Var = this.f2687c;
        i.j.t1(parcel, 2, w6Var == null ? null : w6Var.asBinder(), false);
        i.j.z1(parcel, 3, this.f2688d, false);
        i.j.q1(parcel, 4, this.f2689e, false);
        l7 l7Var = this.f;
        if (l7Var != null) {
            iBinder = l7Var.asBinder();
        }
        i.j.t1(parcel, 5, iBinder, false);
        i.j.F1(parcel, e2);
    }

    public p3(o3 o3Var) {
    }
}
