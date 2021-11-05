package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;

public final class ba extends a {
    public static final Parcelable.Creator<ba> CREATOR = new z9();

    /* renamed from: b  reason: collision with root package name */
    public final int f2531b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2532c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f2533d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f2534e;

    public ba(int i, int i2, byte[] bArr, boolean z) {
        this.f2531b = i;
        this.f2532c = i2;
        this.f2533d = bArr;
        this.f2534e = z;
    }

    public ba(int i, byte[] bArr) {
        this.f2531b = 1;
        this.f2532c = i;
        this.f2533d = bArr;
        this.f2534e = false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2532c);
        i.j.q1(parcel, 2, this.f2533d, false);
        i.j.o1(parcel, 3, this.f2534e);
        i.j.u1(parcel, 1000, this.f2531b);
        i.j.F1(parcel, e2);
    }
}
