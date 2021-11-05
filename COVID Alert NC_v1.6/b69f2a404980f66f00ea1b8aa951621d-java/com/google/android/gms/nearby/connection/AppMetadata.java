package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import java.util.List;

@Deprecated
public final class AppMetadata extends a {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zze();
    public final List<AppIdentifier> zza;

    public AppMetadata(List<AppIdentifier> list) {
        i.j.t(list, "Must specify application identifiers");
        this.zza = list;
        if (list.size() == 0) {
            throw new IllegalArgumentException("Application identifiers cannot be empty");
        }
    }

    public final List<AppIdentifier> getAppIdentifiers() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.B1(parcel, 1, getAppIdentifiers(), false);
        i.j.F1(parcel, e2);
    }
}
