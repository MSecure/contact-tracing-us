package c.b.a.a.c.l;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.c;
import c.b.a.a.c.e;
import c.b.a.a.c.l.j;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.api.Scope;

public class f extends a {
    public static final Parcelable.Creator<f> CREATOR = new b0();

    /* renamed from: b  reason: collision with root package name */
    public final int f2451b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2452c;

    /* renamed from: d  reason: collision with root package name */
    public int f2453d;

    /* renamed from: e  reason: collision with root package name */
    public String f2454e;
    public IBinder f;
    public Scope[] g;
    public Bundle h;
    public Account i;
    public c[] j;
    public c[] k;
    public boolean l;
    public int m;

    public f(int i2) {
        this.f2451b = 4;
        this.f2453d = e.f2293a;
        this.f2452c = i2;
        this.l = true;
    }

    public f(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5) {
        this.f2451b = i2;
        this.f2452c = i3;
        this.f2453d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f2454e = "com.google.android.gms";
        } else {
            this.f2454e = str;
        }
        if (i2 < 2) {
            this.i = iBinder != null ? a.e(j.a.d(iBinder)) : null;
        } else {
            this.f = iBinder;
            this.i = account;
        }
        this.g = scopeArr;
        this.h = bundle;
        this.j = cVarArr;
        this.k = cVarArr2;
        this.l = z;
        this.m = i5;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2451b);
        i.j.u1(parcel, 2, this.f2452c);
        i.j.u1(parcel, 3, this.f2453d);
        i.j.z1(parcel, 4, this.f2454e, false);
        i.j.t1(parcel, 5, this.f, false);
        i.j.A1(parcel, 6, this.g, i2, false);
        i.j.p1(parcel, 7, this.h, false);
        i.j.y1(parcel, 8, this.i, i2, false);
        i.j.A1(parcel, 10, this.j, i2, false);
        i.j.A1(parcel, 11, this.k, i2, false);
        i.j.o1(parcel, 12, this.l);
        i.j.u1(parcel, 13, this.m);
        i.j.F1(parcel, e2);
    }
}
