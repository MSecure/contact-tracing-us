package c.b.a.a.d.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.m.o.a;

public class d extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<d> CREATOR = new c0();

    /* renamed from: b  reason: collision with root package name */
    public final n f3099b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3100c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3101d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f3102e;

    /* renamed from: f  reason: collision with root package name */
    public final int f3103f;

    public d(n nVar, boolean z, boolean z2, int[] iArr, int i) {
        this.f3099b = nVar;
        this.f3100c = z;
        this.f3101d = z2;
        this.f3102e = iArr;
        this.f3103f = i;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int m = t.m(parcel);
        t.v3(parcel, 1, this.f3099b, i, false);
        t.j3(parcel, 2, this.f3100c);
        t.j3(parcel, 3, this.f3101d);
        t.r3(parcel, 4, this.f3102e, false);
        t.q3(parcel, 5, this.f3103f);
        t.w4(parcel, m);
    }
}
