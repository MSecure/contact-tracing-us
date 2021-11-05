package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.k.q;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.internal.ReflectedParcelable;

public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new q();

    /* renamed from: b  reason: collision with root package name */
    public final int f4429b;

    /* renamed from: c  reason: collision with root package name */
    public final String f4430c;

    public Scope(int i, String str) {
        i.j.o(str, "scopeUri must not be null or empty");
        this.f4429b = i;
        this.f4430c = str;
    }

    public Scope(String str) {
        i.j.o(str, "scopeUri must not be null or empty");
        this.f4429b = 1;
        this.f4430c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f4430c.equals(((Scope) obj).f4430c);
    }

    public final int hashCode() {
        return this.f4430c.hashCode();
    }

    public final String toString() {
        return this.f4430c;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.f4429b);
        i.j.z1(parcel, 2, this.f4430c, false);
        i.j.F1(parcel, e2);
    }
}
