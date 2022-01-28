package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;

@Deprecated
public final class AppIdentifier extends a {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zzc();
    public final String zza;

    public AppIdentifier(String str) {
        i.j.o(str, "Missing application identifier value");
        this.zza = str;
    }

    public final String getIdentifier() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.z1(parcel, 1, getIdentifier(), false);
        i.j.F1(parcel, e2);
    }
}
