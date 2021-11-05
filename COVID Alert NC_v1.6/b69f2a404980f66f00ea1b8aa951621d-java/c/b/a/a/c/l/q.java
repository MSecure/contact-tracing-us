package c.b.a.a.c.l;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.j;
import c.b.a.a.c.l.s.a;

public class q extends a {
    public static final Parcelable.Creator<q> CREATOR = new y();

    /* renamed from: b  reason: collision with root package name */
    public final int f2478b;

    /* renamed from: c  reason: collision with root package name */
    public IBinder f2479c;

    /* renamed from: d  reason: collision with root package name */
    public c.b.a.a.c.a f2480d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2481e;
    public boolean f;

    public q(int i, IBinder iBinder, c.b.a.a.c.a aVar, boolean z, boolean z2) {
        this.f2478b = i;
        this.f2479c = iBinder;
        this.f2480d = aVar;
        this.f2481e = z;
        this.f = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f2480d.equals(qVar.f2480d) && p().equals(qVar.p());
    }

    public j p() {
        return j.a.d(this.f2479c);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2478b);
        i.j.t1(parcel, 2, this.f2479c, false);
        i.j.y1(parcel, 3, this.f2480d, i, false);
        i.j.o1(parcel, 4, this.f2481e);
        i.j.o1(parcel, 5, this.f);
        i.j.F1(parcel, e2);
    }
}
