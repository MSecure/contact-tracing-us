package f.b.a.c.h.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.l.i;
import f.b.a.c.b.m.n.a;

public final class c extends a implements i {
    public static final Parcelable.Creator<c> CREATOR = new b();
    public final int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public Intent f2539d;

    public c() {
        this.b = 2;
        this.c = 0;
        this.f2539d = null;
    }

    public c(int i2, int i3, Intent intent) {
        this.b = i2;
        this.c = i3;
        this.f2539d = intent;
    }

    @Override // f.b.a.c.b.l.i
    public final Status getStatus() {
        return this.c == 0 ? Status.f409g : Status.f411i;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.b;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        int i4 = this.c;
        m.h.L1(parcel, 2, 4);
        parcel.writeInt(i4);
        m.h.D1(parcel, 3, this.f2539d, i2, false);
        m.h.M1(parcel, H1);
    }
}
