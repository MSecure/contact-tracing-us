package com.google.android.gms.common.api;

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

public final class Status extends a implements i, ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new n();
    @RecentlyNonNull

    /* renamed from: g  reason: collision with root package name */
    public static final Status f448g = new Status(0, null);
    @RecentlyNonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Status f449h = new Status(15, null);
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public static final Status f450i = new Status(16, null);
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f451d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f452e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.c.b.a f453f;

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, f.b.a.c.b.a aVar) {
        this.b = i2;
        this.c = i3;
        this.f451d = str;
        this.f452e = pendingIntent;
        this.f453f = aVar;
    }

    public Status(@RecentlyNonNull int i2, String str) {
        this.b = 1;
        this.c = i2;
        this.f451d = str;
        this.f452e = null;
        this.f453f = null;
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
        return this.b == status.b && this.c == status.c && m.e.W(this.f451d, status.f451d) && m.e.W(this.f452e, status.f452e) && m.e.W(this.f453f, status.f453f);
    }

    @Override // f.b.a.c.b.l.i
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.f451d, this.f452e, this.f453f});
    }

    @RecentlyNonNull
    public final String toString() {
        l lVar = new l(this, null);
        String str = this.f451d;
        if (str == null) {
            str = m.e.z0(this.c);
        }
        lVar.a("statusCode", str);
        lVar.a("resolution", this.f452e);
        return lVar.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int b2 = m.e.b2(parcel, 20293);
        int i3 = this.c;
        m.e.f2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.Y1(parcel, 2, this.f451d, false);
        m.e.X1(parcel, 3, this.f452e, i2, false);
        m.e.X1(parcel, 4, this.f453f, i2, false);
        int i4 = this.b;
        m.e.f2(parcel, 1000, 4);
        parcel.writeInt(i4);
        m.e.g2(parcel, b2);
    }
}
