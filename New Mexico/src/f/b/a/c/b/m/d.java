package f.b.a.c.b.m;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public class d extends a {
    @RecentlyNonNull
    public static final Parcelable.Creator<d> CREATOR = new a0();
    public final m b;
    public final boolean c;

    /* renamed from: d */
    public final boolean f2726d;

    /* renamed from: e */
    public final int[] f2727e;

    /* renamed from: f */
    public final int f2728f;

    public d(m mVar, boolean z, boolean z2, int[] iArr, int i2) {
        this.b = mVar;
        this.c = z;
        this.f2726d = z2;
        this.f2727e = iArr;
        this.f2728f = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        m.e.f2(parcel, 1, this.b, i2, false);
        boolean z = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = this.f2726d;
        m.e.n2(parcel, 3, 4);
        parcel.writeInt(z2 ? 1 : 0);
        m.e.d2(parcel, 4, this.f2727e, false);
        int i3 = this.f2728f;
        m.e.n2(parcel, 5, 4);
        parcel.writeInt(i3);
        m.e.o2(parcel, j2);
    }
}
