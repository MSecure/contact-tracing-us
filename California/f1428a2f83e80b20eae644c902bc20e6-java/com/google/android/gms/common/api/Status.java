package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.l.i;
import f.b.a.c.b.l.n;
import f.b.a.c.b.m.l;
import f.b.a.c.b.m.n.a;
import java.util.Arrays;
import java.util.Objects;

public final class Status extends a implements i, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new n();
    @RecentlyNonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Status f409g = new Status(0, null);
    @RecentlyNonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Status f410h = new Status(15, null);
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public static final Status f411i = new Status(16, null);
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f412d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f413e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.c.b.a f414f;

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, f.b.a.c.b.a aVar) {
        this.b = i2;
        this.c = i3;
        this.f412d = str;
        this.f413e = pendingIntent;
        this.f414f = aVar;
    }

    public Status(@RecentlyNonNull int i2, String str) {
        this.b = 1;
        this.c = i2;
        this.f412d = str;
        this.f413e = null;
        this.f414f = null;
    }

    @RecentlyNonNull
    public final boolean d() {
        return this.c <= 0;
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.b == status.b && this.c == status.c && m.h.U(this.f412d, status.f412d) && m.h.U(this.f413e, status.f413e) && m.h.U(this.f414f, status.f414f);
    }

    public final void g(@RecentlyNonNull Activity activity, @RecentlyNonNull int i2) {
        PendingIntent pendingIntent = this.f413e;
        if (pendingIntent != null) {
            Objects.requireNonNull(pendingIntent, "null reference");
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    @Override // f.b.a.c.b.l.i
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.f412d, this.f413e, this.f414f});
    }

    @RecentlyNonNull
    public final String toString() {
        l lVar = new l(this, null);
        String str = this.f412d;
        if (str == null) {
            str = m.h.m0(this.c);
        }
        lVar.a("statusCode", str);
        lVar.a("resolution", this.f413e);
        return lVar.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int H1 = m.h.H1(parcel, 20293);
        int i3 = this.c;
        m.h.L1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.E1(parcel, 2, this.f412d, false);
        m.h.D1(parcel, 3, this.f413e, i2, false);
        m.h.D1(parcel, 4, this.f414f, i2, false);
        int i4 = this.b;
        m.h.L1(parcel, 1000, 4);
        parcel.writeInt(i4);
        m.h.M1(parcel, H1);
    }
}
