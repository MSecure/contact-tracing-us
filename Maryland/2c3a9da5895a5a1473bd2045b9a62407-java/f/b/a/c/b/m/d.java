package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.n.a;

public class d extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<d> CREATOR = new a0();
    public final m b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2542d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f2543e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2544f;

    public d(m mVar, boolean z, boolean z2, int[] iArr, int i2) {
        this.b = mVar;
        this.c = z;
        this.f2542d = z2;
        this.f2543e = iArr;
        this.f2544f = i2;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int I1 = m.h.I1(parcel, 20293);
        m.h.E1(parcel, 1, this.b, i2, false);
        boolean z = this.c;
        m.h.M1(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2542d;
        m.h.M1(parcel, 3, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.h.C1(parcel, 4, this.f2543e, false);
        int i3 = this.f2544f;
        m.h.M1(parcel, 5, 4);
        parcel.writeInt(i3);
        m.h.N1(parcel, I1);
    }
}
