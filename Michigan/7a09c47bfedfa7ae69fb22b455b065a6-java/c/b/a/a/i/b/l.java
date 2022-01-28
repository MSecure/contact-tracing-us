package c.b.a.a.i.b;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import c.b.a.a.d.m.w;

public final class l extends a {
    public static final Parcelable.Creator<l> CREATOR = new k();

    /* renamed from: b  reason: collision with root package name */
    public final int f4092b;

    /* renamed from: c  reason: collision with root package name */
    public final w f4093c;

    public l(int i, w wVar) {
        this.f4092b = i;
        this.f4093c = wVar;
    }

    public l(w wVar) {
        this.f4092b = 1;
        this.f4093c = wVar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f4092b);
        t.v3(parcel, 2, this.f4093c, i, false);
        t.w4(parcel, m);
    }
}
