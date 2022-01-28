package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import java.util.Arrays;

public final class k9 extends a {
    public static final Parcelable.Creator<k9> CREATOR = new o9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3626b;

    /* renamed from: c  reason: collision with root package name */
    public c7 f3627c;

    /* renamed from: d  reason: collision with root package name */
    public String f3628d;

    /* renamed from: e  reason: collision with root package name */
    public long f3629e;

    /* renamed from: f  reason: collision with root package name */
    public DiscoveryOptions f3630f;

    /* renamed from: g  reason: collision with root package name */
    public e7 f3631g;

    public k9() {
    }

    public k9(IBinder iBinder, IBinder iBinder2, String str, long j, DiscoveryOptions discoveryOptions, IBinder iBinder3) {
        m7 m7Var;
        c7 c7Var;
        e7 e7Var = null;
        if (iBinder == null) {
            m7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            m7Var = queryLocalInterface instanceof m7 ? (m7) queryLocalInterface : new p7(iBinder);
        }
        if (iBinder2 == null) {
            c7Var = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            c7Var = queryLocalInterface2 instanceof c7 ? (c7) queryLocalInterface2 : new f7(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            e7Var = queryLocalInterface3 instanceof e7 ? (e7) queryLocalInterface3 : new g7(iBinder3);
        }
        this.f3626b = m7Var;
        this.f3627c = c7Var;
        this.f3628d = str;
        this.f3629e = j;
        this.f3630f = discoveryOptions;
        this.f3631g = e7Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k9) {
            k9 k9Var = (k9) obj;
            return t.j1(this.f3626b, k9Var.f3626b) && t.j1(this.f3627c, k9Var.f3627c) && t.j1(this.f3628d, k9Var.f3628d) && t.j1(Long.valueOf(this.f3629e), Long.valueOf(k9Var.f3629e)) && t.j1(this.f3630f, k9Var.f3630f) && t.j1(this.f3631g, k9Var.f3631g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3626b, this.f3627c, this.f3628d, Long.valueOf(this.f3629e), this.f3630f, this.f3631g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        m7 m7Var = this.f3626b;
        IBinder iBinder = null;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        c7 c7Var = this.f3627c;
        t.p3(parcel, 2, c7Var == null ? null : c7Var.asBinder(), false);
        t.w3(parcel, 3, this.f3628d, false);
        t.t3(parcel, 4, this.f3629e);
        t.v3(parcel, 5, this.f3630f, i, false);
        e7 e7Var = this.f3631g;
        if (e7Var != null) {
            iBinder = e7Var.asBinder();
        }
        t.p3(parcel, 6, iBinder, false);
        t.w4(parcel, m);
    }

    public k9(m9 m9Var) {
    }
}
