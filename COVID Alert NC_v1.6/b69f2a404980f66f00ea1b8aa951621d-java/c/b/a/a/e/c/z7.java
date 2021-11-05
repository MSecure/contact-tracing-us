package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class z7 extends a {
    public static final Parcelable.Creator<z7> CREATOR = new y7();

    /* renamed from: b  reason: collision with root package name */
    public String f2822b;

    /* renamed from: c  reason: collision with root package name */
    public String f2823c;

    /* renamed from: d  reason: collision with root package name */
    public String f2824d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2825e;
    public byte[] f;
    public byte[] g;
    public byte[] h;
    public boolean i;

    public z7() {
    }

    public z7(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2) {
        this.f2822b = str;
        this.f2823c = str2;
        this.f2824d = str3;
        this.f2825e = z;
        this.f = bArr;
        this.g = bArr2;
        this.h = bArr3;
        this.i = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z7) {
            z7 z7Var = (z7) obj;
            return i.j.X(this.f2822b, z7Var.f2822b) && i.j.X(this.f2823c, z7Var.f2823c) && i.j.X(this.f2824d, z7Var.f2824d) && i.j.X(Boolean.valueOf(this.f2825e), Boolean.valueOf(z7Var.f2825e)) && Arrays.equals(this.f, z7Var.f) && Arrays.equals(this.g, z7Var.g) && Arrays.equals(this.h, z7Var.h) && i.j.X(Boolean.valueOf(this.i), Boolean.valueOf(z7Var.i));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2822b, this.f2823c, this.f2824d, Boolean.valueOf(this.f2825e), Integer.valueOf(Arrays.hashCode(this.f)), Integer.valueOf(Arrays.hashCode(this.g)), Integer.valueOf(Arrays.hashCode(this.h)), Boolean.valueOf(this.i)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2822b, false);
        i.j.z1(parcel, 2, this.f2823c, false);
        i.j.z1(parcel, 3, this.f2824d, false);
        i.j.o1(parcel, 4, this.f2825e);
        i.j.q1(parcel, 5, this.f, false);
        i.j.q1(parcel, 6, this.g, false);
        i.j.q1(parcel, 7, this.h, false);
        i.j.o1(parcel, 8, this.i);
        i.j.F1(parcel, e2);
    }
}
