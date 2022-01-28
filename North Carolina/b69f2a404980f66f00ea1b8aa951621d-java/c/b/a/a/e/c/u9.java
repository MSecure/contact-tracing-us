package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class u9 extends a {
    public static final Parcelable.Creator<u9> CREATOR = new w9();

    /* renamed from: b  reason: collision with root package name */
    public final int f2759b;

    /* renamed from: c  reason: collision with root package name */
    public final ParcelUuid f2760c;

    /* renamed from: d  reason: collision with root package name */
    public final ParcelUuid f2761d;

    /* renamed from: e  reason: collision with root package name */
    public final ParcelUuid f2762e;
    public final byte[] f;
    public final byte[] g;
    public final int h;
    public final byte[] i;
    public final byte[] j;

    public u9(int i2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i3, byte[] bArr3, byte[] bArr4) {
        this.f2759b = i2;
        this.f2760c = parcelUuid;
        this.f2761d = parcelUuid2;
        this.f2762e = parcelUuid3;
        this.f = bArr;
        this.g = bArr2;
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
            return this.h == u9Var.h && Arrays.equals(this.i, u9Var.i) && Arrays.equals(this.j, u9Var.j) && i.j.X(this.f2762e, u9Var.f2762e) && Arrays.equals(this.f, u9Var.f) && Arrays.equals(this.g, u9Var.g) && i.j.X(this.f2760c, u9Var.f2760c) && i.j.X(this.f2761d, u9Var.f2761d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.h), Integer.valueOf(Arrays.hashCode(this.i)), Integer.valueOf(Arrays.hashCode(this.j)), this.f2762e, Integer.valueOf(Arrays.hashCode(this.f)), Integer.valueOf(Arrays.hashCode(this.g)), this.f2760c, this.f2761d});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2759b);
        i.j.y1(parcel, 4, this.f2760c, i2, false);
        i.j.y1(parcel, 5, this.f2761d, i2, false);
        i.j.y1(parcel, 6, this.f2762e, i2, false);
        i.j.q1(parcel, 7, this.f, false);
        i.j.q1(parcel, 8, this.g, false);
        i.j.u1(parcel, 9, this.h);
        i.j.q1(parcel, 10, this.i, false);
        i.j.q1(parcel, 11, this.j, false);
        i.j.F1(parcel, e2);
    }
}
