package c.b.a.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.Arrays;

public final class d extends a {
    public static final Parcelable.Creator<d> CREATOR = new e();

    /* renamed from: b  reason: collision with root package name */
    public final boolean f2907b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2908c;

    /* renamed from: d  reason: collision with root package name */
    public final long f2909d;

    public d(boolean z, long j, long j2) {
        this.f2907b = z;
        this.f2908c = j;
        this.f2909d = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return this.f2907b == dVar.f2907b && this.f2908c == dVar.f2908c && this.f2909d == dVar.f2909d;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f2907b), Long.valueOf(this.f2908c), Long.valueOf(this.f2909d)});
    }

    public final String toString() {
        return "CollectForDebugParcelable[skipPersistentStorage: " + this.f2907b + ",collectForDebugStartTimeMillis: " + this.f2908c + ",collectForDebugExpiryTimeMillis: " + this.f2909d + "]";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.j3(parcel, 1, this.f2907b);
        t.t3(parcel, 2, this.f2909d);
        t.t3(parcel, 3, this.f2908c);
        t.w4(parcel, m);
    }
}
