package c.b.a.a.d.m;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.c;
import c.b.a.a.d.m.h;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.api.Scope;

public class e extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<e> CREATOR = new d0();

    /* renamed from: b  reason: collision with root package name */
    public final int f3104b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3105c;

    /* renamed from: d  reason: collision with root package name */
    public int f3106d;

    /* renamed from: e  reason: collision with root package name */
    public String f3107e;

    /* renamed from: f  reason: collision with root package name */
    public IBinder f3108f;

    /* renamed from: g  reason: collision with root package name */
    public Scope[] f3109g;
    public Bundle h;
    public Account i;
    public c[] j;
    public c[] k;
    public boolean l;
    public int m;
    public boolean n;

    public e(@RecentlyNonNull int i2) {
        this.f3104b = 5;
        this.f3106d = c.b.a.a.d.e.f2930a;
        this.f3105c = i2;
        this.l = true;
    }

    public e(int i2, int i3, int i4, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, c[] cVarArr, c[] cVarArr2, boolean z, int i5, boolean z2) {
        this.f3104b = i2;
        this.f3105c = i3;
        this.f3106d = i4;
        if ("com.google.android.gms".equals(str)) {
            this.f3107e = "com.google.android.gms";
        } else {
            this.f3107e = str;
        }
        if (i2 < 2) {
            this.i = iBinder != null ? a.g0(h.a.f0(iBinder)) : null;
        } else {
            this.f3108f = iBinder;
            this.i = account;
        }
        this.f3109g = scopeArr;
        this.h = bundle;
        this.j = cVarArr;
        this.k = cVarArr2;
        this.l = z;
        this.m = i5;
        this.n = z2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int m2 = t.m(parcel);
        t.q3(parcel, 1, this.f3104b);
        t.q3(parcel, 2, this.f3105c);
        t.q3(parcel, 3, this.f3106d);
        t.w3(parcel, 4, this.f3107e, false);
        t.p3(parcel, 5, this.f3108f, false);
        t.y3(parcel, 6, this.f3109g, i2, false);
        t.k3(parcel, 7, this.h, false);
        t.v3(parcel, 8, this.i, i2, false);
        t.y3(parcel, 10, this.j, i2, false);
        t.y3(parcel, 11, this.k, i2, false);
        t.j3(parcel, 12, this.l);
        t.q3(parcel, 13, this.m);
        t.j3(parcel, 14, this.n);
        t.w4(parcel, m2);
    }
}
