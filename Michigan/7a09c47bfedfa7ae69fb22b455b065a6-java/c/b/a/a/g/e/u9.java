package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class u9 extends a {
    public static final Parcelable.Creator<u9> CREATOR = new w9();

    /* renamed from: b  reason: collision with root package name */
    public final int f3758b;

    /* renamed from: c  reason: collision with root package name */
    public final ParcelUuid f3759c;

    /* renamed from: d  reason: collision with root package name */
    public final ParcelUuid f3760d;

    /* renamed from: e  reason: collision with root package name */
    public final ParcelUuid f3761e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f3762f;

    /* renamed from: g  reason: collision with root package name */
    public final byte[] f3763g;
    public final int h;
    public final byte[] i;
    public final byte[] j;

    public u9(int i2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4) {
        this.f3758b = i2;
        this.f3759c = parcelUuid;
        this.f3760d = parcelUuid2;
        this.f3761e = parcelUuid3;
        this.f3762f = bArr;
        this.f3763g = bArr2;
        this.h = i3;
        this.i = bArr3;
        this.j = bArr4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && u9.class == obj.getClass()) {
            u9 u9Var = (u9) obj;
            return this.h == u9Var.h && Arrays.equals(this.i, u9Var.i) && Arrays.equals(this.j, u9Var.j) && t.j1(this.f3761e, u9Var.f3761e) && Arrays.equals(this.f3762f, u9Var.f3762f) && Arrays.equals(this.f3763g, u9Var.f3763g) && t.j1(this.f3759c, u9Var.f3759c) && t.j1(this.f3760d, u9Var.f3760d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.h), Integer.valueOf(Arrays.hashCode(this.i)), Integer.valueOf(Arrays.hashCode(this.j)), this.f3761e, Integer.valueOf(Arrays.hashCode(this.f3762f)), Integer.valueOf(Arrays.hashCode(this.f3763g)), this.f3759c, this.f3760d});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3758b);
        t.v3(parcel, 4, this.f3759c, i2, false);
        t.v3(parcel, 5, this.f3760d, i2, false);
        t.v3(parcel, 6, this.f3761e, i2, false);
        t.l3(parcel, 7, this.f3762f, false);
        t.l3(parcel, 8, this.f3763g, false);
        t.q3(parcel, 9, this.h);
        t.l3(parcel, 10, this.i, false);
        t.l3(parcel, 11, this.j, false);
        t.w4(parcel, m);
    }
}
