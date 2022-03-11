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
/* loaded from: classes.dex */
public final class Status extends a implements i, ReflectedParcelable {
    public final int b;
    public final int c;

    /* renamed from: d */
    public final String f461d;

    /* renamed from: e */
    public final PendingIntent f462e;

    /* renamed from: f */
    public final f.b.a.c.b.a f463f;
    @RecentlyNonNull

    /* renamed from: g */
    public static final Status f458g = new Status(0, null);
    @RecentlyNonNull

    /* renamed from: h */
    public static final Status f459h = new Status(15, null);
    @RecentlyNonNull

    /* renamed from: i */
    public static final Status f460i = new Status(16, null);
    @RecentlyNonNull
    public static final Parcelable.Creator<Status> CREATOR = new n();

    public Status(int i2, int i3, String str, PendingIntent pendingIntent, f.b.a.c.b.a aVar) {
        this.b = i2;
        this.c = i3;
        this.f461d = str;
        this.f462e = pendingIntent;
        this.f463f = aVar;
    }

    public Status(@RecentlyNonNull int i2, String str) {
        this.b = 1;
        this.c = i2;
        this.f461d = str;
        this.f462e = null;
        this.f463f = null;
    }

    @RecentlyNonNull
    public final boolean d() {
        return this.c <= 0;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.b == status.b && this.c == status.c && m.e.X(this.f461d, status.f461d) && m.e.X(this.f462e, status.f462e) && m.e.X(this.f463f, status.f463f);
    }

    @Override // f.b.a.c.b.l.i
    @RecentlyNonNull
    public final Status getStatus() {
        return this;
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), this.f461d, this.f462e, this.f463f});
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        l lVar = new l(this, null);
        String str = this.f461d;
        if (str == null) {
            str = m.e.B0(this.c);
        }
        lVar.a("statusCode", str);
        lVar.a("resolution", this.f462e);
        return lVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.c;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.g2(parcel, 2, this.f461d, false);
        m.e.f2(parcel, 3, this.f462e, i2, false);
        m.e.f2(parcel, 4, this.f463f, i2, false);
        int i4 = this.b;
        m.e.n2(parcel, 1000, 4);
        parcel.writeInt(i4);
        m.e.o2(parcel, j2);
    }
}
