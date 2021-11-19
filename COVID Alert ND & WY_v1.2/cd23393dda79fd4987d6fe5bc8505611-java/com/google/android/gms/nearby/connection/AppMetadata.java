package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

@Deprecated
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class AppMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zze();
    private final List<AppIdentifier> zza;

    public AppMetadata(List<AppIdentifier> list) {
        this.zza = (List) Preconditions.checkNotNull(list, "Must specify application identifiers");
        Preconditions.checkNotZero(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public final List<AppIdentifier> getAppIdentifiers() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, getAppIdentifiers(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
