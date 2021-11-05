package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

public final class h9 extends a {
    public static final Parcelable.Creator<h9> CREATOR = new l9();

    /* renamed from: b  reason: collision with root package name */
    public r7 f3594b;

    /* renamed from: c  reason: collision with root package name */
    public t6 f3595c;

    /* renamed from: d  reason: collision with root package name */
    public String f3596d;

    /* renamed from: e  reason: collision with root package name */
    public String f3597e;

    /* renamed from: f  reason: collision with root package name */
    public long f3598f;

    /* renamed from: g  reason: collision with root package name */
    public AdvertisingOptions f3599g;
    public x6 h;
    public byte[] i;

    public h9() {
    }

    public h9(IBinder iBinder, IBinder iBinder2, String str, String str2, long j, AdvertisingOptions advertisingOptions, IBinder iBinder3, byte[] bArr) {
        r7 r7Var;
        t6 t6Var;
        x6 x6Var = null;
        if (iBinder == null) {
            r7Var = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IStartAdvertisingResultListener");
            r7Var = queryLocalInterface instanceof r7 ? (r7) queryLocalInterface : new t7(iBinder);
        }
        if (iBinder2 == null) {
            t6Var = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IAdvertisingCallback");
            t6Var = queryLocalInterface2 instanceof t6 ? (t6) queryLocalInterface2 : new v6(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IConnectionLifecycleListener");
            x6Var = queryLocalInterface3 instanceof x6 ? (x6) queryLocalInterface3 : new z6(iBinder3);
        }
        this.f3594b = r7Var;
        this.f3595c = t6Var;
        this.f3596d = str;
        this.f3597e = str2;
        this.f3598f = j;
        this.f3599g = advertisingOptions;
        this.h = x6Var;
        this.i = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h9) {
            h9 h9Var = (h9) obj;
            return t.j1(this.f3594b, h9Var.f3594b) && t.j1(this.f3595c, h9Var.f3595c) && t.j1(this.f3596d, h9Var.f3596d) && t.j1(this.f3597e, h9Var.f3597e) && t.j1(Long.valueOf(this.f3598f), Long.valueOf(h9Var.f3598f)) && t.j1(this.f3599g, h9Var.f3599g) && t.j1(this.h, h9Var.h) && Arrays.equals(this.i, h9Var.i);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3594b, this.f3595c, this.f3596d, this.f3597e, Long.valueOf(this.f3598f), this.f3599g, this.h, Integer.valueOf(Arrays.hashCode(this.i))});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        r7 r7Var = this.f3594b;
        IBinder iBinder = null;
        t.p3(parcel, 1, r7Var == null ? null : r7Var.asBinder(), false);
        t6 t6Var = this.f3595c;
        t.p3(parcel, 2, t6Var == null ? null : t6Var.asBinder(), false);
        t.w3(parcel, 3, this.f3596d, false);
        t.w3(parcel, 4, this.f3597e, false);
        t.t3(parcel, 5, this.f3598f);
        t.v3(parcel, 6, this.f3599g, i2, false);
        x6 x6Var = this.h;
        if (x6Var != null) {
            iBinder = x6Var.asBinder();
        }
        t.p3(parcel, 7, iBinder, false);
        t.l3(parcel, 8, this.i, false);
        t.w4(parcel, m);
    }

    public h9(j9 j9Var) {
    }
}
