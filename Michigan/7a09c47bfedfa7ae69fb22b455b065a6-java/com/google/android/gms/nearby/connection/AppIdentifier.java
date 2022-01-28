package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;

@Deprecated
public final class AppIdentifier extends a {
    public static final Parcelable.Creator<AppIdentifier> CREATOR = new zzc();
    public final String zza;

    public AppIdentifier(String str) {
        t.A(str, "Missing application identifier value");
        this.zza = str;
    }

    public final String getIdentifier() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.w3(parcel, 1, getIdentifier(), false);
        t.w4(parcel, m);
    }
}
