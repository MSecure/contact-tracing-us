package f.b.a.c.b;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.l;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
/* loaded from: classes.dex */
public class c extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<c> CREATOR = new r();
    public final String b;
    @Deprecated
    public final int c;

    /* renamed from: d */
    public final long f2669d;

    public c(@RecentlyNonNull String str, @RecentlyNonNull int i2, @RecentlyNonNull long j2) {
        this.b = str;
        this.c = i2;
        this.f2669d = j2;
    }

    public c(@RecentlyNonNull String str, @RecentlyNonNull long j2) {
        this.b = str;
        this.f2669d = j2;
        this.c = -1;
    }

    @RecentlyNonNull
    public long d() {
        long j2 = this.f2669d;
        return j2 == -1 ? (long) this.c : j2;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.b;
            if (((str != null && str.equals(cVar.b)) || (this.b == null && cVar.b == null)) && d() == cVar.d()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, Long.valueOf(d())});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public String toString() {
        l lVar = new l(this, null);
        lVar.a("name", this.b);
        lVar.a("version", Long.valueOf(d()));
        return lVar.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.g2(parcel, 1, this.b, false);
        int i3 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i3);
        long d2 = d();
        m.e.n2(parcel, 3, 8);
        parcel.writeLong(d2);
        m.e.o2(parcel, j2);
    }
}
