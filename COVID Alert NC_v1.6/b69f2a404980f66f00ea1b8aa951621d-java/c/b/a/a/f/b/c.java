package c.b.a.a.f.b;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.api.Status;

public final class c extends a implements i {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* renamed from: b  reason: collision with root package name */
    public final int f2835b;

    /* renamed from: c  reason: collision with root package name */
    public int f2836c;

    /* renamed from: d  reason: collision with root package name */
    public Intent f2837d;

    public c() {
        this.f2835b = 2;
        this.f2836c = 0;
        this.f2837d = null;
    }

    public c(int i, int i2, Intent intent) {
        this.f2835b = i;
        this.f2836c = i2;
        this.f2837d = intent;
    }

    @Override // c.b.a.a.c.k.i
    public final Status getStatus() {
        return this.f2836c == 0 ? Status.f : Status.i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f2835b);
        i.j.u1(parcel, 2, this.f2836c);
        i.j.y1(parcel, 3, this.f2837d, i, false);
        i.j.F1(parcel, e2);
    }
}
