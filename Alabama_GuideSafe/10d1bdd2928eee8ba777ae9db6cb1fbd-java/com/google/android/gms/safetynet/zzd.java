package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    public final long zzf;
    public final HarmfulAppsData[] zzg;
    public final int zzh;
    public final boolean zzi;

    public zzd(long j, HarmfulAppsData[] harmfulAppsDataArr, int i, boolean z) {
        this.zzf = j;
        this.zzg = harmfulAppsDataArr;
        this.zzi = z;
        if (z) {
            this.zzh = i;
        } else {
            this.zzh = -1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeLong(parcel, 2, this.zzf);
        ReactYogaConfigProvider.writeTypedArray(parcel, 3, this.zzg, i, false);
        ReactYogaConfigProvider.writeInt(parcel, 4, this.zzh);
        ReactYogaConfigProvider.writeBoolean(parcel, 5, this.zzi);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
