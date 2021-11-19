package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcy> CREATOR = new zzda();

    zzcy() {
    }

    public final int hashCode() {
        return 0;
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof zzcy);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
    }
}
