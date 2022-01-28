package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.o;
import c.b.a.a.c.l.s.a;
import java.util.Arrays;

public class c extends a {
    public static final Parcelable.Creator<c> CREATOR = new q();

    /* renamed from: b  reason: collision with root package name */
    public final String f2286b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public final int f2287c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2288d;

    public c(String str, int i, long j) {
        this.f2286b = str;
        this.f2287c = i;
        this.f2288d = j;
    }

    public c(String str, long j) {
        this.f2286b = str;
        this.f2288d = j;
        this.f2287c = -1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.f2286b;
            if (((str == null || !str.equals(cVar.f2286b)) && (this.f2286b != null || cVar.f2286b != null)) || p() != cVar.p()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2286b, Long.valueOf(p())});
    }

    public long p() {
        long j = this.f2288d;
        return j == -1 ? (long) this.f2287c : j;
    }

    public String toString() {
        o j1 = i.j.j1(this);
        j1.a("name", this.f2286b);
        j1.a("version", Long.valueOf(p()));
        return j1.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, this.f2286b, false);
        i.j.u1(parcel, 2, this.f2287c);
        i.j.x1(parcel, 3, p());
        i.j.F1(parcel, e2);
    }
}
