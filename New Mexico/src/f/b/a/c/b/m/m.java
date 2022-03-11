package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public class m extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<m> CREATOR = new l0();
    public final int b;
    public final boolean c;

    /* renamed from: d */
    public final boolean f2749d;

    /* renamed from: e */
    public final int f2750e;

    /* renamed from: f */
    public final int f2751f;

    public m(@RecentlyNonNull int i2, @RecentlyNonNull boolean z, @RecentlyNonNull boolean z2, @RecentlyNonNull int i3, @RecentlyNonNull int i4) {
        this.b = i2;
        this.c = z;
        this.f2749d = z2;
        this.f2750e = i3;
        this.f2751f = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        boolean z = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2749d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(z2 ? 1 : 0);
        int i4 = this.f2750e;
        m.e.n2(parcel, 4, 4);
        parcel.writeInt(i4);
        int i5 = this.f2751f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i5);
        m.e.o2(parcel, j2);
    }
}
