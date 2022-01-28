package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.q;
import c.b.a.a.c.l.s.a;

public final class n extends a {
    public static final Parcelable.Creator<n> CREATOR = new m();

    /* renamed from: b  reason: collision with root package name */
    public final int f2842b;

    /* renamed from: c  reason: collision with root package name */
    public final c.b.a.a.c.a f2843c;

    /* renamed from: d  reason: collision with root package name */
    public final q f2844d;

    public n() {
        c.b.a.a.c.a aVar = new c.b.a.a.c.a(8, null);
        this.f2842b = 1;
        this.f2843c = aVar;
        this.f2844d = null;
    }

    public n(int i, c.b.a.a.c.a aVar, q qVar) {
        this.f2842b = i;
        this.f2843c = aVar;
        this.f2844d = qVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2842b);
        i.j.y1(parcel, 2, this.f2843c, i, false);
        i.j.y1(parcel, 3, this.f2844d, i, false);
        i.j.F1(parcel, e2);
    }
}
