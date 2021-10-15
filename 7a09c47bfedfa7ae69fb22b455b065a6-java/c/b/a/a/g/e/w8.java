package c.b.a.a.g.e;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class w8 extends a {
    public static final Parcelable.Creator<w8> CREATOR = new x8();

    /* renamed from: b  reason: collision with root package name */
    public long f3798b;

    /* renamed from: c  reason: collision with root package name */
    public int f3799c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3800d;

    /* renamed from: e  reason: collision with root package name */
    public ParcelFileDescriptor f3801e;

    /* renamed from: f  reason: collision with root package name */
    public String f3802f;

    /* renamed from: g  reason: collision with root package name */
    public long f3803g = -1;
    public ParcelFileDescriptor h;
    public Uri i;
    public long j = 0;

    public w8() {
    }

    public w8(long j2, int i2, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j3, ParcelFileDescriptor parcelFileDescriptor2, Uri uri, long j4) {
        this.f3798b = j2;
        this.f3799c = i2;
        this.f3800d = bArr;
        this.f3801e = parcelFileDescriptor;
        this.f3802f = str;
        this.f3803g = j3;
        this.h = parcelFileDescriptor2;
        this.i = uri;
        this.j = j4;
    }

    public w8(v8 v8Var) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w8) {
            w8 w8Var = (w8) obj;
            return t.j1(Long.valueOf(this.f3798b), Long.valueOf(w8Var.f3798b)) && t.j1(Integer.valueOf(this.f3799c), Integer.valueOf(w8Var.f3799c)) && Arrays.equals(this.f3800d, w8Var.f3800d) && t.j1(this.f3801e, w8Var.f3801e) && t.j1(this.f3802f, w8Var.f3802f) && t.j1(Long.valueOf(this.f3803g), Long.valueOf(w8Var.f3803g)) && t.j1(this.h, w8Var.h) && t.j1(this.i, w8Var.i) && t.j1(Long.valueOf(this.j), Long.valueOf(w8Var.j));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f3798b), Integer.valueOf(this.f3799c), Integer.valueOf(Arrays.hashCode(this.f3800d)), this.f3801e, this.f3802f, Long.valueOf(this.f3803g), this.h, this.i, Long.valueOf(this.j)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.t3(parcel, 1, this.f3798b);
        t.q3(parcel, 2, this.f3799c);
        t.l3(parcel, 3, this.f3800d, false);
        t.v3(parcel, 4, this.f3801e, i2, false);
        t.w3(parcel, 5, this.f3802f, false);
        t.t3(parcel, 6, this.f3803g);
        t.v3(parcel, 7, this.h, i2, false);
        t.v3(parcel, 8, this.i, i2, false);
        t.t3(parcel, 9, this.j);
        t.w4(parcel, m);
    }
}
