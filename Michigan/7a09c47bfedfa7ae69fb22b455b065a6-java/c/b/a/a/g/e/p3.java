package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class p3 extends a {
    public static final Parcelable.Creator<p3> CREATOR = new q3();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3679b;

    /* renamed from: c  reason: collision with root package name */
    public w6 f3680c;

    /* renamed from: d  reason: collision with root package name */
    public String f3681d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3682e;

    /* renamed from: f  reason: collision with root package name */
    public l7 f3683f;

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
        this.f3679b = m7Var;
        this.f3680c = w6Var;
        this.f3681d = str;
        this.f3682e = bArr;
        this.f3683f = l7Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p3) {
            p3 p3Var = (p3) obj;
            return t.j1(this.f3679b, p3Var.f3679b) && t.j1(this.f3680c, p3Var.f3680c) && t.j1(this.f3681d, p3Var.f3681d) && Arrays.equals(this.f3682e, p3Var.f3682e) && t.j1(this.f3683f, p3Var.f3683f);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3679b, this.f3680c, this.f3681d, Integer.valueOf(Arrays.hashCode(this.f3682e)), this.f3683f});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        m7 m7Var = this.f3679b;
        IBinder iBinder = null;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        w6 w6Var = this.f3680c;
        t.p3(parcel, 2, w6Var == null ? null : w6Var.asBinder(), false);
        t.w3(parcel, 3, this.f3681d, false);
        t.l3(parcel, 4, this.f3682e, false);
        l7 l7Var = this.f3683f;
        if (l7Var != null) {
            iBinder = l7Var.asBinder();
        }
        t.p3(parcel, 5, iBinder, false);
        t.w4(parcel, m);
    }

    public p3(o3 o3Var) {
    }
}
