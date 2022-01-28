package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import java.util.Arrays;

public final class a9 extends a {
    public static final Parcelable.Creator<a9> CREATOR = new e9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f2520b;

    /* renamed from: c  reason: collision with root package name */
    public w6 f2521c;

    /* renamed from: d  reason: collision with root package name */
    public b7 f2522d;

    /* renamed from: e  reason: collision with root package name */
    public String f2523e;
    public String f;
    public byte[] g;
    public x6 h;
    public byte[] i;
    public ConnectionOptions j;

    public a9() {
    }

    public a9(IBinder iBinder, IBinder iBinder2, IBinder iBinder3, String str, String str2, byte[] bArr, IBinder iBinder4, byte[] bArr2, ConnectionOptions connectionOptions) {
        m7 m7Var;
        w6 w6Var;
        b7 b7Var;
        x6 x6Var = null;
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
        if (iBinder3 == null) {
            b7Var = null;
        } else {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionResponseListener");
            b7Var = queryLocalInterface3 instanceof b7 ? (b7) queryLocalInterface3 : new d7(iBinder3);
        }
        if (iBinder4 != null) {
            IInterface queryLocalInterface4 = iBinder4.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            x6Var = queryLocalInterface4 instanceof x6 ? (x6) queryLocalInterface4 : new z6(iBinder4);
        }
        this.f2520b = m7Var;
        this.f2521c = w6Var;
        this.f2522d = b7Var;
        this.f2523e = str;
        this.f = str2;
        this.g = bArr;
        this.h = x6Var;
        this.i = bArr2;
        this.j = connectionOptions;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a9) {
            a9 a9Var = (a9) obj;
            return i.j.X(this.f2520b, a9Var.f2520b) && i.j.X(this.f2521c, a9Var.f2521c) && i.j.X(this.f2522d, a9Var.f2522d) && i.j.X(this.f2523e, a9Var.f2523e) && i.j.X(this.f, a9Var.f) && Arrays.equals(this.g, a9Var.g) && i.j.X(this.h, a9Var.h) && Arrays.equals(this.i, a9Var.i) && i.j.X(this.j, a9Var.j);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2520b, this.f2521c, this.f2522d, this.f2523e, this.f, Integer.valueOf(Arrays.hashCode(this.g)), this.h, Integer.valueOf(Arrays.hashCode(this.i)), this.j});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        m7 m7Var = this.f2520b;
        IBinder iBinder = null;
        i.j.t1(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        w6 w6Var = this.f2521c;
        i.j.t1(parcel, 2, w6Var == null ? null : w6Var.asBinder(), false);
        b7 b7Var = this.f2522d;
        i.j.t1(parcel, 3, b7Var == null ? null : b7Var.asBinder(), false);
        i.j.z1(parcel, 4, this.f2523e, false);
        i.j.z1(parcel, 5, this.f, false);
        i.j.q1(parcel, 6, this.g, false);
        x6 x6Var = this.h;
        if (x6Var != null) {
            iBinder = x6Var.asBinder();
        }
        i.j.t1(parcel, 7, iBinder, false);
        i.j.q1(parcel, 8, this.i, false);
        i.j.y1(parcel, 9, this.j, i2, false);
        i.j.F1(parcel, e2);
    }

    public a9(c9 c9Var) {
    }
}
