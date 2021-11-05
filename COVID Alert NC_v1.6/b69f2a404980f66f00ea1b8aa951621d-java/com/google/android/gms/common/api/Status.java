package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.c;
import c.b.a.a.c.k.i;
import c.b.a.a.c.k.r;
import c.b.a.a.c.l.o;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class Status extends a implements i, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new r();
    public static final Status f = new Status(0);
    public static final Status g = new Status(14);
    public static final Status h = new Status(15);
    public static final Status i = new Status(16);

    /* renamed from: b  reason: collision with root package name */
    public final int f4431b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4432c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4433d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f4434e;

    static {
        new Status(8);
        new Status(17);
        new Status(18);
    }

    public Status(int i2) {
        this(1, i2, null, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent) {
        this.f4431b = i2;
        this.f4432c = i3;
        this.f4433d = str;
        this.f4434e = pendingIntent;
    }

    public Status(int i2, String str) {
        this(1, i2, str, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f4431b == status.f4431b && this.f4432c == status.f4432c && i.j.X(this.f4433d, status.f4433d) && i.j.X(this.f4434e, status.f4434e);
    }

    @Override // c.b.a.a.c.k.i
    public final Status getStatus() {
        return this;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f4431b), Integer.valueOf(this.f4432c), this.f4433d, this.f4434e});
    }

    public final boolean p() {
        return this.f4432c <= 0;
    }

    public final void q(Activity activity, int i2) {
        if (this.f4434e != null) {
            activity.startIntentSenderForResult(this.f4434e.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String toString() {
        o j1 = i.j.j1(this);
        String str = this.f4433d;
        if (str == null) {
            str = c.getStatusCodeString(this.f4432c);
        }
        j1.a("statusCode", str);
        j1.a("resolution", this.f4434e);
        return j1.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f4432c);
        i.j.z1(parcel, 2, this.f4433d, false);
        i.j.y1(parcel, 3, this.f4434e, i2, false);
        i.j.u1(parcel, 1000, this.f4431b);
        i.j.F1(parcel, e2);
    }
}
