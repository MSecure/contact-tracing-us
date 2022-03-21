package f.b.a.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.l;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;

public class c extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<c> CREATOR = new r();
    public final String b;
    @Deprecated
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2405d;

    public c(@RecentlyNonNull String str, @RecentlyNonNull int i2, @RecentlyNonNull long j2) {
        this.b = str;
        this.c = i2;
        this.f2405d = j2;
    }

    public c(@RecentlyNonNull String str, @RecentlyNonNull long j2) {
        this.b = str;
        this.f2405d = j2;
        this.c = -1;
    }

    @RecentlyNonNull
    public long d() {
        long j2 = this.f2405d;
        return j2 == -1 ? (long) this.c : j2;
    }

    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.b;
            if (((str == null || !str.equals(cVar.b)) && (this.b != null || cVar.b != null)) || d() != cVar.d()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @RecentlyNonNull
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Long.valueOf(d())});
    }

    @RecentlyNonNull
    public String toString() {
        l lVar = new l(this, null);
        lVar.a("name", this.b);
        lVar.a("version", Long.valueOf(d()));
        return lVar.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int H1 = m.h.H1(parcel, 20293);
        m.h.E1(parcel, 1, this.b, false);
        int i3 = this.c;
        m.h.L1(parcel, 2, 4);
        parcel.writeInt(i3);
        long d2 = d();
        m.h.L1(parcel, 3, 8);
        parcel.writeLong(d2);
        m.h.M1(parcel, H1);
    }
}
