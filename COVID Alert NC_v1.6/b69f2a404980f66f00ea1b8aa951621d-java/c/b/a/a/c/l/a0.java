package c.b.a.a.c.l;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.c;
import c.b.a.a.c.l.s.a;

public final class a0 extends a {
    public static final Parcelable.Creator<a0> CREATOR = new z();

    /* renamed from: b  reason: collision with root package name */
    public Bundle f2417b;

    /* renamed from: c  reason: collision with root package name */
    public c[] f2418c;

    /* renamed from: d  reason: collision with root package name */
    public int f2419d;

    public a0() {
    }

    public a0(Bundle bundle, c[] cVarArr, int i) {
        this.f2417b = bundle;
        this.f2418c = cVarArr;
        this.f2419d = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.p1(parcel, 1, this.f2417b, false);
        i.j.A1(parcel, 2, this.f2418c, i, false);
        i.j.u1(parcel, 3, this.f2419d);
        i.j.F1(parcel, e2);
    }
}
