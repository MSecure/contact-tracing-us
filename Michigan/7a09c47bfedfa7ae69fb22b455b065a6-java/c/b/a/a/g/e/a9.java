package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.connection.ConnectionOptions;
import java.util.Arrays;

public final class a9 extends a {
    public static final Parcelable.Creator<a9> CREATOR = new e9();

    /* renamed from: b  reason: collision with root package name */
    public m7 f3503b;

    /* renamed from: c  reason: collision with root package name */
    public w6 f3504c;

    /* renamed from: d  reason: collision with root package name */
    public b7 f3505d;

    /* renamed from: e  reason: collision with root package name */
    public String f3506e;

    /* renamed from: f  reason: collision with root package name */
    public String f3507f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3508g;
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
        this.f3503b = m7Var;
        this.f3504c = w6Var;
        this.f3505d = b7Var;
        this.f3506e = str;
        this.f3507f = str2;
        this.f3508g = bArr;
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
            return t.j1(this.f3503b, a9Var.f3503b) && t.j1(this.f3504c, a9Var.f3504c) && t.j1(this.f3505d, a9Var.f3505d) && t.j1(this.f3506e, a9Var.f3506e) && t.j1(this.f3507f, a9Var.f3507f) && Arrays.equals(this.f3508g, a9Var.f3508g) && t.j1(this.h, a9Var.h) && Arrays.equals(this.i, a9Var.i) && t.j1(this.j, a9Var.j);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3503b, this.f3504c, this.f3505d, this.f3506e, this.f3507f, Integer.valueOf(Arrays.hashCode(this.f3508g)), this.h, Integer.valueOf(Arrays.hashCode(this.i)), this.j});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        m7 m7Var = this.f3503b;
        IBinder iBinder = null;
        t.p3(parcel, 1, m7Var == null ? null : m7Var.asBinder(), false);
        w6 w6Var = this.f3504c;
        t.p3(parcel, 2, w6Var == null ? null : w6Var.asBinder(), false);
        b7 b7Var = this.f3505d;
        t.p3(parcel, 3, b7Var == null ? null : b7Var.asBinder(), false);
        t.w3(parcel, 4, this.f3506e, false);
        t.w3(parcel, 5, this.f3507f, false);
        t.l3(parcel, 6, this.f3508g, false);
        x6 x6Var = this.h;
        if (x6Var != null) {
            iBinder = x6Var.asBinder();
        }
        t.p3(parcel, 7, iBinder, false);
        t.l3(parcel, 8, this.i, false);
        t.v3(parcel, 9, this.j, i2, false);
        t.w4(parcel, m);
    }

    public a9(c9 c9Var) {
    }
}
