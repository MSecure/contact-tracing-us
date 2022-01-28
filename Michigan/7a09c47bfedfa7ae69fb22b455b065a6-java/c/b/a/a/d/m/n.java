package c.b.a.a.d.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.m.o.a;

public class n extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<n> CREATOR = new n0();

    /* renamed from: b  reason: collision with root package name */
    public final int f3143b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3144c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3145d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3146e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3147f;

    public n(@RecentlyNonNull int i, @RecentlyNonNull boolean z, @RecentlyNonNull boolean z2, @RecentlyNonNull int i2, @RecentlyNonNull int i3) {
        this.f3143b = i;
        this.f3144c = z;
        this.f3145d = z2;
        this.f3146e = i2;
        this.f3147f = i3;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f3143b);
        t.j3(parcel, 2, this.f3144c);
        t.j3(parcel, 3, this.f3145d);
        t.q3(parcel, 4, this.f3146e);
        t.q3(parcel, 5, this.f3147f);
        t.w4(parcel, m);
    }
}
