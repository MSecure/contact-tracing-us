package c.b.a.a.e.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.nearby.connection.zzo;
import java.util.Arrays;

public final class f8 extends a {
    public static final Parcelable.Creator<f8> CREATOR = new e8();

    /* renamed from: b  reason: collision with root package name */
    public String f2578b;

    /* renamed from: c  reason: collision with root package name */
    public int f2579c;

    /* renamed from: d  reason: collision with root package name */
    public zzo f2580d;

    public f8() {
    }

    public f8(String str, int i, zzo zzo) {
        this.f2578b = str;
        this.f2579c = i;
        this.f2580d = zzo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f8) {
            f8 f8Var = (f8) obj;
            return i.j.X(this.f2578b, f8Var.f2578b) && i.j.X(Integer.valueOf(this.f2579c), Integer.valueOf(f8Var.f2579c)) && i.j.X(this.f2580d, f8Var.f2580d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2578b, Integer.valueOf(this.f2579c), this.f2580d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2578b, false);
        i.j.u1(parcel, 2, this.f2579c);
        i.j.y1(parcel, 3, this.f2580d, i, false);
        i.j.F1(parcel, e2);
    }
}
