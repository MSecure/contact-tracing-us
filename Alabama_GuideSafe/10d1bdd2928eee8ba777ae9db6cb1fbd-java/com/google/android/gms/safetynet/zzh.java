package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    public final int zzk;
    public final boolean zzl;

    public zzh(int i, boolean z) {
        this.zzk = i;
        this.zzl = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zzk);
        ReactYogaConfigProvider.writeBoolean(parcel, 3, this.zzl);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
