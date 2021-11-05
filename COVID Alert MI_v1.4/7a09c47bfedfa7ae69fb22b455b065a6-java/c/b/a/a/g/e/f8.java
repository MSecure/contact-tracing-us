package c.b.a.a.g.e;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.connection.zzo;
import java.util.Arrays;

public final class f8 extends a {
    public static final Parcelable.Creator<f8> CREATOR = new e8();

    /* renamed from: b  reason: collision with root package name */
    public String f3563b;

    /* renamed from: c  reason: collision with root package name */
    public int f3564c;

    /* renamed from: d  reason: collision with root package name */
    public zzo f3565d;

    public f8() {
    }

    public f8(String str, int i, zzo zzo) {
        this.f3563b = str;
        this.f3564c = i;
        this.f3565d = zzo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f8) {
            f8 f8Var = (f8) obj;
            return t.j1(this.f3563b, f8Var.f3563b) && t.j1(Integer.valueOf(this.f3564c), Integer.valueOf(f8Var.f3564c)) && t.j1(this.f3565d, f8Var.f3565d);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3563b, Integer.valueOf(this.f3564c), this.f3565d});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f3563b, false);
        t.q3(parcel, 2, this.f3564c);
        t.v3(parcel, 3, this.f3565d, i, false);
        t.w4(parcel, m);
    }
}
