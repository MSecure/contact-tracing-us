package c.b.a.a.e.c;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class w8 extends a {
    public static final Parcelable.Creator<w8> CREATOR = new x8();

    /* renamed from: b  reason: collision with root package name */
    public long f2793b;

    /* renamed from: c  reason: collision with root package name */
    public int f2794c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f2795d;

    /* renamed from: e  reason: collision with root package name */
    public ParcelFileDescriptor f2796e;
    public String f;
    public long g = -1;
    public ParcelFileDescriptor h;
    public Uri i;
    public long j = 0;

    public w8() {
    }

    public w8(long j2, int i2, byte[] bArr, ParcelFileDescriptor parcelFileDescriptor, String str, long j3, ParcelFileDescriptor parcelFileDescriptor2, Uri uri, long j4) {
        this.f2793b = j2;
        this.f2794c = i2;
        this.f2795d = bArr;
        this.f2796e = parcelFileDescriptor;
        this.f = str;
        this.g = j3;
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
            return i.j.X(Long.valueOf(this.f2793b), Long.valueOf(w8Var.f2793b)) && i.j.X(Integer.valueOf(this.f2794c), Integer.valueOf(w8Var.f2794c)) && Arrays.equals(this.f2795d, w8Var.f2795d) && i.j.X(this.f2796e, w8Var.f2796e) && i.j.X(this.f, w8Var.f) && i.j.X(Long.valueOf(this.g), Long.valueOf(w8Var.g)) && i.j.X(this.h, w8Var.h) && i.j.X(this.i, w8Var.i) && i.j.X(Long.valueOf(this.j), Long.valueOf(w8Var.j));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f2793b), Integer.valueOf(this.f2794c), Integer.valueOf(Arrays.hashCode(this.f2795d)), this.f2796e, this.f, Long.valueOf(this.g), this.h, this.i, Long.valueOf(this.j)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.x1(parcel, 1, this.f2793b);
        i.j.u1(parcel, 2, this.f2794c);
        i.j.q1(parcel, 3, this.f2795d, false);
        i.j.y1(parcel, 4, this.f2796e, i2, false);
        i.j.z1(parcel, 5, this.f, false);
        i.j.x1(parcel, 6, this.g);
        i.j.y1(parcel, 7, this.h, i2, false);
        i.j.y1(parcel, 8, this.i, i2, false);
        i.j.x1(parcel, 9, this.j);
        i.j.F1(parcel, e2);
    }
}
