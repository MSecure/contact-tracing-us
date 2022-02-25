package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.n.a;

public class m extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<m> CREATOR = new l0();
    public final int b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f2477d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2478e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2479f;

    public m(@RecentlyNonNull int i2, @RecentlyNonNull boolean z, @RecentlyNonNull boolean z2, @RecentlyNonNull int i3, @RecentlyNonNull int i4) {
        this.b = i2;
        this.c = z;
        this.f2477d = z2;
        this.f2478e = i3;
        this.f2479f = i4;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        boolean z = this.c;
        m.h.L1(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2477d;
        m.h.L1(parcel, 3, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i4 = this.f2478e;
        m.h.L1(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2479f;
        m.h.L1(parcel, 5, 4);
        parcel.writeInt(i5);
        m.h.M1(parcel, H1);
    }
}
