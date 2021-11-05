package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import c.b.a.a.d.m.x;

public final class n extends a {
    public static final Parcelable.Creator<n> CREATOR = new m();

    /* renamed from: b  reason: collision with root package name */
    public final int f4094b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.a.a.d.a f4095c;

    /* renamed from: d  reason: collision with root package name */
    public final x f4096d;

    public n() {
        c.b.a.a.d.a aVar = new c.b.a.a.d.a(8, null);
        this.f4094b = 1;
        this.f4095c = aVar;
        this.f4096d = null;
    }

    public n(int i, c.b.a.a.d.a aVar, x xVar) {
        this.f4094b = i;
        this.f4095c = aVar;
        this.f4096d = xVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f4094b);
        t.v3(parcel, 2, this.f4095c, i, false);
        t.v3(parcel, 3, this.f4096d, i, false);
        t.w4(parcel, m);
    }
}
