package c.b.a.a.d.m;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.h;
import c.b.a.a.d.m.o.a;

public final class x extends a {
    public static final Parcelable.Creator<x> CREATOR = new z();

    /* renamed from: b  reason: collision with root package name */
    public final int f3164b;

    /* renamed from: c  reason: collision with root package name */
    public IBinder f3165c;

    /* renamed from: d  reason: collision with root package name */
    public c.b.a.a.d.a f3166d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3167e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f3168f;

    public x(int i, IBinder iBinder, c.b.a.a.d.a aVar, boolean z, boolean z2) {
        this.f3164b = i;
        this.f3165c = iBinder;
        this.f3166d = aVar;
        this.f3167e = z;
        this.f3168f = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f3166d.equals(xVar.f3166d) && t.j1(t(), xVar.t());
    }

    public final h t() {
        IBinder iBinder = this.f3165c;
        if (iBinder == null) {
            return null;
        }
        return h.a.f0(iBinder);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3164b);
        t.p3(parcel, 2, this.f3165c, false);
        t.v3(parcel, 3, this.f3166d, i, false);
        t.j3(parcel, 4, this.f3167e);
        t.j3(parcel, 5, this.f3168f);
        t.w4(parcel, m);
    }
}
