package f.b.a.c.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.l.i;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public final class c extends a implements i {
    public static final Parcelable.Creator<c> CREATOR = new b();
    public final int b;
    public int c;

    /* renamed from: d */
    public Intent f2833d;

    public c() {
        this.b = 2;
        this.c = 0;
        this.f2833d = null;
    }

    public c(int i2, int i3, Intent intent) {
        this.b = i2;
        this.c = i3;
        this.f2833d = intent;
    }

    @Override // f.b.a.c.b.l.i
    public final Status getStatus() {
        return this.c == 0 ? Status.f458g : Status.f460i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.e.n2(parcel, 2, 4);
        parcel.writeInt(i4);
        m.e.f2(parcel, 3, this.f2833d, i2, false);
        m.e.o2(parcel, j2);
    }
}
