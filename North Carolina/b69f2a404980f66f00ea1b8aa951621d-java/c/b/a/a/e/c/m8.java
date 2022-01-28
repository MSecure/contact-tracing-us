package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public final class m8 extends a {
    public static final Parcelable.Creator<m8> CREATOR = new l8();

    /* renamed from: b  reason: collision with root package name */
    public String f2666b;

    /* renamed from: c  reason: collision with root package name */
    public w8 f2667c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2668d;

    public m8() {
    }

    public m8(String str, w8 w8Var, boolean z) {
        this.f2666b = str;
        this.f2667c = w8Var;
        this.f2668d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m8) {
            m8 m8Var = (m8) obj;
            return i.j.X(this.f2666b, m8Var.f2666b) && i.j.X(this.f2667c, m8Var.f2667c) && i.j.X(Boolean.valueOf(this.f2668d), Boolean.valueOf(m8Var.f2668d));
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2666b, this.f2667c, Boolean.valueOf(this.f2668d)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2666b, false);
        i.j.y1(parcel, 2, this.f2667c, i, false);
        i.j.o1(parcel, 3, this.f2668d);
        i.j.F1(parcel, e2);
    }
}
