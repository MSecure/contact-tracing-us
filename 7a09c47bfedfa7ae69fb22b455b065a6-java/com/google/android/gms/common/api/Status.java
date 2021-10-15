package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.k.c;
import c.b.a.a.d.k.i;
import c.b.a.a.d.k.r;
import c.b.a.a.d.m.m;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;

public final class Status extends a implements i, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new r();
    @RecentlyNonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Status f5979g = new Status(0, null);
    @RecentlyNonNull
    public static final Status h = new Status(14, null);
    @RecentlyNonNull
    public static final Status i = new Status(15, null);
    @RecentlyNonNull
    public static final Status j = new Status(16, null);

    /* renamed from: b  reason: collision with root package name */
    public final int f5980b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5981c;

    /* renamed from: d  reason: collision with root package name */
    public final String f5982d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f5983e;

    /* renamed from: f  reason: collision with root package name */
    public final c.b.a.a.d.a f5984f;

    static {
        new Status(8, null);
        new Status(17, null);
        new Status(18, null);
    }

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, c.b.a.a.d.a aVar) {
        this.f5980b = i2;
        this.f5981c = i3;
        this.f5982d = str;
        this.f5983e = pendingIntent;
        this.f5984f = aVar;
    }

    public Status(@RecentlyNonNull int i2, String str) {
        this.f5980b = 1;
        this.f5981c = i2;
        this.f5982d = str;
        this.f5983e = null;
        this.f5984f = null;
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f5980b == status.f5980b && this.f5981c == status.f5981c && t.j1(this.f5982d, status.f5982d) && t.j1(this.f5983e, status.f5983e) && t.j1(this.f5984f, status.f5984f);
    }

    @Override // c.b.a.a.d.k.i
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f5980b), Integer.valueOf(this.f5981c), this.f5982d, this.f5983e, this.f5984f});
    }

    @RecentlyNonNull
    public final boolean t() {
        return this.f5981c <= 0;
    }

    @RecentlyNonNull
    public final String toString() {
        m a3 = t.a3(this);
        String str = this.f5982d;
        if (str == null) {
            str = c.getStatusCodeString(this.f5981c);
        }
        a3.a("statusCode", str);
        a3.a("resolution", this.f5983e);
        return a3.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f5981c);
        t.w3(parcel, 2, this.f5982d, false);
        t.v3(parcel, 3, this.f5983e, i2, false);
        t.v3(parcel, 4, this.f5984f, i2, false);
        t.q3(parcel, 1000, this.f5980b);
        t.w4(parcel, m);
    }

    public final void x(@RecentlyNonNull Activity activity, @RecentlyNonNull int i2) {
        if (this.f5983e != null) {
            PendingIntent pendingIntent = this.f5983e;
            t.C(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public Status(@RecentlyNonNull int i2, String str, PendingIntent pendingIntent) {
        this.f5980b = 1;
        this.f5981c = i2;
        this.f5982d = str;
        this.f5983e = null;
        this.f5984f = null;
    }
}
