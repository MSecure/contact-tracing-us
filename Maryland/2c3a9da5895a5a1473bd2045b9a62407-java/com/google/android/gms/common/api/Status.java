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
    public static final Status f424g = new Status(0, null);
    @RecentlyNonNull

    /* renamed from: h  reason: collision with root package name */
    public static final Status f425h = new Status(15, null);
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public static final Status f426i = new Status(16, null);
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f427d;

    /* renamed from: e  reason: collision with root package name */
    public final PendingIntent f428e;

    /* renamed from: f  reason: collision with root package name */
    public final f.b.a.c.b.a f429f;

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, f.b.a.c.b.a aVar) {
        this.b = i2;
        this.c = i3;
        this.f427d = str;
        this.f428e = pendingIntent;
        this.f429f = aVar;
    }

    public Status(@RecentlyNonNull int i2, String str) {
        this.b = 1;
        this.c = i2;
        this.f427d = str;
        this.f428e = null;
        this.f429f = null;
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
        return this.b == status.b && this.c == status.c && m.h.U(this.f427d, status.f427d) && m.h.U(this.f428e, status.f428e) && m.h.U(this.f429f, status.f429f);
    }

    @Override // f.b.a.c.b.l.i
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.f427d, this.f428e, this.f429f});
    }

    @RecentlyNonNull
    public final String toString() {
        l lVar = new l(this, null);
        String str = this.f427d;
        if (str == null) {
            str = m.h.n0(this.c);
        }
        lVar.a("statusCode", str);
        lVar.a("resolution", this.f428e);
        return lVar.toString();
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int I1 = m.h.I1(parcel, 20293);
        int i3 = this.c;
        m.h.M1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.F1(parcel, 2, this.f427d, false);
        m.h.E1(parcel, 3, this.f428e, i2, false);
        m.h.E1(parcel, 4, this.f429f, i2, false);
        int i4 = this.b;
        m.h.M1(parcel, 1000, 4);
        parcel.writeInt(i4);
        m.h.N1(parcel, I1);
    }
}
