package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class z7 extends a {
    public static final Parcelable.Creator<z7> CREATOR = new y7();

    /* renamed from: b  reason: collision with root package name */
    public String f3829b;

    /* renamed from: c  reason: collision with root package name */
    public String f3830c;

    /* renamed from: d  reason: collision with root package name */
    public String f3831d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3832e;

    /* renamed from: f  reason: collision with root package name */
    public byte[] f3833f;

    /* renamed from: g  reason: collision with root package name */
    public byte[] f3834g;
    public byte[] h;
    public boolean i;

    public z7() {
    }

    public z7(String str, String str2, String str3, boolean z, byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z2) {
        this.f3829b = str;
        this.f3830c = str2;
        this.f3831d = str3;
        this.f3832e = z;
        this.f3833f = bArr;
        this.f3834g = bArr2;
        this.h = bArr3;
        this.i = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z7) {
            z7 z7Var = (z7) obj;
            return t.j1(this.f3829b, z7Var.f3829b) && t.j1(this.f3830c, z7Var.f3830c) && t.j1(this.f3831d, z7Var.f3831d) && t.j1(Boolean.valueOf(this.f3832e), Boolean.valueOf(z7Var.f3832e)) && Arrays.equals(this.f3833f, z7Var.f3833f) && Arrays.equals(this.f3834g, z7Var.f3834g) && Arrays.equals(this.h, z7Var.h) && t.j1(Boolean.valueOf(this.i), Boolean.valueOf(z7Var.i));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3829b, this.f3830c, this.f3831d, Boolean.valueOf(this.f3832e), Integer.valueOf(Arrays.hashCode(this.f3833f)), Integer.valueOf(Arrays.hashCode(this.f3834g)), Integer.valueOf(Arrays.hashCode(this.h)), Boolean.valueOf(this.i)});
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3829b, false);
        t.w3(parcel, 2, this.f3830c, false);
        t.w3(parcel, 3, this.f3831d, false);
        t.j3(parcel, 4, this.f3832e);
        t.l3(parcel, 5, this.f3833f, false);
        t.l3(parcel, 6, this.f3834g, false);
        t.l3(parcel, 7, this.h, false);
        t.j3(parcel, 8, this.i);
        t.w4(parcel, m);
    }
}
