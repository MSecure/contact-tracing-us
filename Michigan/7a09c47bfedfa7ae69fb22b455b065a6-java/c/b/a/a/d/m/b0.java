package c.b.a.a.d.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.c;
import c.b.a.a.d.m.o.a;

public final class b0 extends a {
    public static final Parcelable.Creator<b0> CREATOR = new a0();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f3083b;

    /* renamed from: c  reason: collision with root package name */
    public c[] f3084c;

    /* renamed from: d  reason: collision with root package name */
    public int f3085d;

    public b0() {
    }

    public b0(Bundle bundle, c[] cVarArr, int i) {
        this.f3083b = bundle;
        this.f3084c = cVarArr;
        this.f3085d = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.k3(parcel, 1, this.f3083b, false);
        t.y3(parcel, 2, this.f3084c, i, false);
        t.q3(parcel, 3, this.f3085d);
        t.v3(parcel, 4, null, i, false);
        t.w4(parcel, m);
    }
}
