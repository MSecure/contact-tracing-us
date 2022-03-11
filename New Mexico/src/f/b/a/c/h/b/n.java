package f.b.a.c.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import e.b.a.m;
import f.b.a.c.b.m.n.a;
import f.b.a.c.b.m.v;
/* loaded from: classes.dex */
public final class n extends a {
    public static final Parcelable.Creator<n> CREATOR = new m();
    public final int b;
    public final f.b.a.c.b.a c;

    /* renamed from: d */
    public final v f2834d;

    public n() {
        f.b.a.c.b.a aVar = new f.b.a.c.b.a(8, null);
        this.b = 1;
        this.c = aVar;
        this.f2834d = null;
    }

    public n(int i2, f.b.a.c.b.a aVar, v vVar) {
        this.b = i2;
        this.c = aVar;
        this.f2834d = vVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.f2(parcel, 2, this.c, i2, false);
        m.e.f2(parcel, 3, this.f2834d, i2, false);
        m.e.o2(parcel, j2);
    }
}
