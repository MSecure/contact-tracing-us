package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import java.util.Arrays;

public final class h9 extends a {
    public static final Parcelable.Creator<h9> CREATOR = new l9();

    /* renamed from: b  reason: collision with root package name */
    public r7 f2608b;

    /* renamed from: c  reason: collision with root package name */
    public t6 f2609c;

    /* renamed from: d  reason: collision with root package name */
    public String f2610d;

    /* renamed from: e  reason: collision with root package name */
    public String f2611e;
    public long f;
    public AdvertisingOptions g;
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
        this.f2608b = r7Var;
        this.f2609c = t6Var;
        this.f2610d = str;
        this.f2611e = str2;
        this.f = j;
        this.g = advertisingOptions;
        this.h = x6Var;
        this.i = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h9) {
            h9 h9Var = (h9) obj;
            return i.j.X(this.f2608b, h9Var.f2608b) && i.j.X(this.f2609c, h9Var.f2609c) && i.j.X(this.f2610d, h9Var.f2610d) && i.j.X(this.f2611e, h9Var.f2611e) && i.j.X(Long.valueOf(this.f), Long.valueOf(h9Var.f)) && i.j.X(this.g, h9Var.g) && i.j.X(this.h, h9Var.h) && Arrays.equals(this.i, h9Var.i);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2608b, this.f2609c, this.f2610d, this.f2611e, Long.valueOf(this.f), this.g, this.h, Integer.valueOf(Arrays.hashCode(this.i))});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        r7 r7Var = this.f2608b;
        IBinder iBinder = null;
        i.j.t1(parcel, 1, r7Var == null ? null : r7Var.asBinder(), false);
        t6 t6Var = this.f2609c;
        i.j.t1(parcel, 2, t6Var == null ? null : t6Var.asBinder(), false);
        i.j.z1(parcel, 3, this.f2610d, false);
        i.j.z1(parcel, 4, this.f2611e, false);
        i.j.x1(parcel, 5, this.f);
        i.j.y1(parcel, 6, this.g, i2, false);
        x6 x6Var = this.h;
        if (x6Var != null) {
            iBinder = x6Var.asBinder();
        }
        i.j.t1(parcel, 7, iBinder, false);
        i.j.q1(parcel, 8, this.i, false);
        i.j.F1(parcel, e2);
    }

    public h9(j9 j9Var) {
    }
}
