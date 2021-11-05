package c.b.a.a.f.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.p;
import c.b.a.a.c.l.s.a;

public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* renamed from: b  reason: collision with root package name */
    public final int f2840b;

    /* renamed from: c  reason: collision with root package name */
    public final p f2841c;

    public l(int i, p pVar) {
        this.f2840b = i;
        this.f2841c = pVar;
    }

    public l(p pVar) {
        this.f2840b = 1;
        this.f2841c = pVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2840b);
        i.j.y1(parcel, 2, this.f2841c, i, false);
        i.j.F1(parcel, e2);
    }
}
