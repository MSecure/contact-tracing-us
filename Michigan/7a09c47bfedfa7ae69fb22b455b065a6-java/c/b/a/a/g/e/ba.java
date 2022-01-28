package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

public final class ba extends a {
    public static final Parcelable.Creator<ba> CREATOR = new z9();

    /* renamed from: b  reason: collision with root package name */
    public final int f3516b;

    /* renamed from: c  reason: collision with root package name */
    public final int f3517c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f3518d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f3519e;

    public ba(int i, int i2, byte[] bArr, boolean z) {
        this.f3516b = i;
        this.f3517c = i2;
        this.f3518d = bArr;
        this.f3519e = z;
    }

    public ba(int i, byte[] bArr) {
        this.f3516b = 1;
        this.f3517c = i;
        this.f3518d = bArr;
        this.f3519e = false;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3517c);
        t.l3(parcel, 2, this.f3518d, false);
        t.j3(parcel, 3, this.f3519e);
        t.q3(parcel, 1000, this.f3516b);
        t.w4(parcel, m);
    }
}
