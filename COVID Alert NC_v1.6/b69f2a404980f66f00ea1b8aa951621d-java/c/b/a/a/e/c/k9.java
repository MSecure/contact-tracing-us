package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import java.util.Arrays;

public final class k9 extends a {
    public static final Parcelable.Creator<k9> CREATOR = new o9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2638b;

    /* renamed from: c  reason: collision with root package name */
    public c7 f2639c;

    /* renamed from: d  reason: collision with root package name */
    public String f2640d;

    /* renamed from: e  reason: collision with root package name */
    public long f2641e;
    public DiscoveryOptions f;
    public e7 g;

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
        this.f2638b = m7Var;
        this.f2639c = c7Var;
        this.f2640d = str;
        this.f2641e = j;
        this.f = discoveryOptions;
        this.g = e7Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k9) {
            k9 k9Var = (k9) obj;
            return i.j.X(this.f2638b, k9Var.f2638b) && i.j.X(this.f2639c, k9Var.f2639c) && i.j.X(this.f2640d, k9Var.f2640d) && i.j.X(Long.valueOf(this.f2641e), Long.valueOf(k9Var.f2641e)) && i.j.X(this.f, k9Var.f) && i.j.X(this.g, k9Var.g);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2638b, this.f2639c, this.f2640d, Long.valueOf(this.f2641e), this.f, this.g});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2638b;
        IBinder iBinder = null;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        c7 c7Var = this.f2639c;
        i.j.t1(parcel, 2, c7Var == null ? null : c7Var.asBinder(), false);
        i.j.z1(parcel, 3, this.f2640d, false);
        i.j.x1(parcel, 4, this.f2641e);
        i.j.y1(parcel, 5, this.f, i, false);
        e7 e7Var = this.g;
        if (e7Var != null) {
            iBinder = e7Var.asBinder();
        }
        i.j.t1(parcel, 6, iBinder, false);
        i.j.F1(parcel, e2);
    }

    public k9(m9 m9Var) {
    }
}
