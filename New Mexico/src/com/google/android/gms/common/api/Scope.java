package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e.b.a.m;
import f.b.a.c.b.l.m;
import f.b.a.c.b.m.n.a;
/* loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new m();
    public final int b;
    public final String c;

    public Scope(int i2, String str) {
        m.e.p(str, "scopeUri must not be null or empty");
        this.b = i2;
        this.c = str;
    }

    public Scope(@RecentlyNonNull String str) {
        m.e.p(str, "scopeUri must not be null or empty");
        this.b = 1;
        this.c = str;
    }

    @Override // java.lang.Object
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

    @Override // java.lang.Object
    @RecentlyNonNull
    public final int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Object
    @RecentlyNonNull
    public final String toString() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i2) {
        int j2 = m.e.j2(parcel, 20293);
        int i3 = this.b;
        m.e.n2(parcel, 1, 4);
        parcel.writeInt(i3);
        m.e.g2(parcel, 2, this.c, false);
        m.e.o2(parcel, j2);
    }
}
