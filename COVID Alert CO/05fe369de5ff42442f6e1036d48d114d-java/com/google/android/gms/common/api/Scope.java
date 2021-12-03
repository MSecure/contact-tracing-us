package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.l.m;
import f.b.a.c.b.m.n.a;

public final class Scope extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new m();
    public final int b;
    public final String c;

    public Scope(int i2, String str) {
        m.h.n(str, "scopeUri must not be null or empty");
        this.b = i2;
        this.c = str;
    }

    public Scope(@RecentlyNonNull String str) {
        m.h.n(str, "scopeUri must not be null or empty");
        this.b = 1;
        this.c = str;
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.c.equals(((Scope) obj).c);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.c.hashCode();
    }

    @RecentlyNonNull
    public final String toString() {
        return this.c;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int O1 = m.h.O1(parcel, 20293);
        int i3 = this.b;
        m.h.S1(parcel, 1, 4);
        parcel.writeInt(i3);
        m.h.L1(parcel, 2, this.c, false);
        m.h.T1(parcel, O1);
    }
}
