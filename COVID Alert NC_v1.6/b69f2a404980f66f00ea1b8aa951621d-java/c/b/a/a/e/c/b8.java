package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class b8 extends a {
    public static final Parcelable.Creator<b8> CREATOR = new a8();

    /* renamed from: b  reason: collision with root package name */
    public String f2528b;

    /* renamed from: c  reason: collision with root package name */
    public int f2529c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f2530d;

    public b8() {
    }

    public b8(String str, int i, byte[] bArr) {
        this.f2528b = str;
        this.f2529c = i;
        this.f2530d = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b8) {
            b8 b8Var = (b8) obj;
            return i.j.X(this.f2528b, b8Var.f2528b) && i.j.X(Integer.valueOf(this.f2529c), Integer.valueOf(b8Var.f2529c)) && Arrays.equals(this.f2530d, b8Var.f2530d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2528b, Integer.valueOf(this.f2529c), Integer.valueOf(Arrays.hashCode(this.f2530d))});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2528b, false);
        i.j.u1(parcel, 2, this.f2529c);
        i.j.q1(parcel, 3, this.f2530d, false);
        i.j.F1(parcel, e2);
    }
}
