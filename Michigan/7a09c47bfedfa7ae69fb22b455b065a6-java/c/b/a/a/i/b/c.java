package c.b.a.a.i.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.k.i;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.api.Status;

public final class c extends a implements i {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: b  reason: collision with root package name */
    public final int f4087b;

    /* renamed from: c  reason: collision with root package name */
    public int f4088c;

    /* renamed from: d  reason: collision with root package name */
    public Intent f4089d;

    public c() {
        this.f4087b = 2;
        this.f4088c = 0;
        this.f4089d = null;
    }

    public c(int i, int i2, Intent intent) {
        this.f4087b = i;
        this.f4088c = i2;
        this.f4089d = intent;
    }

    @Override // c.b.a.a.d.k.i
    public final Status getStatus() {
        return this.f4088c == 0 ? Status.f5979g : Status.j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f4087b);
        t.q3(parcel, 2, this.f4088c);
        t.v3(parcel, 3, this.f4089d, i, false);
        t.w4(parcel, m);
    }
}
