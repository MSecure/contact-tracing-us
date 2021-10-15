package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class b8 extends a {
    public static final Parcelable.Creator<b8> CREATOR = new a8();

    /* renamed from: b  reason: collision with root package name */
    public String f3513b;

    /* renamed from: c  reason: collision with root package name */
    public int f3514c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3515d;

    public b8() {
    }

    public b8(String str, int i, byte[] bArr) {
        this.f3513b = str;
        this.f3514c = i;
        this.f3515d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b8) {
            b8 b8Var = (b8) obj;
            return t.j1(this.f3513b, b8Var.f3513b) && t.j1(Integer.valueOf(this.f3514c), Integer.valueOf(b8Var.f3514c)) && Arrays.equals(this.f3515d, b8Var.f3515d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3513b, Integer.valueOf(this.f3514c), Integer.valueOf(Arrays.hashCode(this.f3515d))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3513b, false);
        t.q3(parcel, 2, this.f3514c);
        t.l3(parcel, 3, this.f3515d, false);
        t.w4(parcel, m);
    }
}
