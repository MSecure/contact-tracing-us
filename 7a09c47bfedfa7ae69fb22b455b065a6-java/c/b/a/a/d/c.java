package c.b.a.a.d;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.m.m;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public class c extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<c> CREATOR = new r();

    /* renamed from: b  reason: collision with root package name */
    public final String f2923b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public final int f2924c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2925d;

    public c(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull long j) {
        this.f2923b = str;
        this.f2924c = i;
        this.f2925d = j;
    }

    public c(@RecentlyNonNull String str, @RecentlyNonNull long j) {
        this.f2923b = str;
        this.f2925d = j;
        this.f2924c = -1;
    }

    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            String str = this.f2923b;
            if (((str == null || !str.equals(cVar.f2923b)) && (this.f2923b != null || cVar.f2923b != null)) || t() != cVar.t()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @RecentlyNonNull
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2923b, Long.valueOf(t())});
    }

    @RecentlyNonNull
    public long t() {
        long j = this.f2925d;
        return j == -1 ? (long) this.f2924c : j;
    }

    @RecentlyNonNull
    public String toString() {
        m a3 = t.a3(this);
        a3.a("name", this.f2923b);
        a3.a("version", Long.valueOf(t()));
        return a3.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, this.f2923b, false);
        t.q3(parcel, 2, this.f2924c);
        t.t3(parcel, 3, t());
        t.w4(parcel, m);
    }
}
