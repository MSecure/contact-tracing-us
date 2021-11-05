package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import b.x.t;
import c.b.a.a.d.k.q;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new q();

    /* renamed from: b  reason: collision with root package name */
    public final int f5977b;

    /* renamed from: c  reason: collision with root package name */
    public final String f5978c;

    public Scope(int i, String str) {
        t.A(str, "scopeUri must not be null or empty");
        this.f5977b = i;
        this.f5978c = str;
    }

    public Scope(@RecentlyNonNull String str) {
        t.A(str, "scopeUri must not be null or empty");
        this.f5977b = 1;
        this.f5978c = str;
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f5978c.equals(((Scope) obj).f5978c);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.f5978c.hashCode();
    }

    @RecentlyNonNull
    public final String toString() {
        return this.f5978c;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int m = t.m(parcel);
        t.q3(parcel, 1, this.f5977b);
        t.w3(parcel, 2, this.f5978c, false);
        t.w4(parcel, m);
    }
}
