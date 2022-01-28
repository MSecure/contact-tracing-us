package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import java.util.List;

@Deprecated
public final class AppMetadata extends a {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zze();
    public final List<AppIdentifier> zza;

    public AppMetadata(List<AppIdentifier> list) {
        t.D(list, "Must specify application identifiers");
        this.zza = list;
        if (list.size() == 0) {
            throw new IllegalArgumentException("Application identifiers cannot be empty");
        }
    }

    public final List<AppIdentifier> getAppIdentifiers() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.z3(parcel, 1, getAppIdentifiers(), false);
        t.w4(parcel, m);
    }
}
