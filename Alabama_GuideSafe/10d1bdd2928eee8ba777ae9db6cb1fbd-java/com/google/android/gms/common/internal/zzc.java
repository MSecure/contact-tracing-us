package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();
    public Bundle zza;
    public Feature[] zzb;
    public int zzc;

    public zzc(Bundle bundle, Feature[] featureArr, int i) {
        this.zza = bundle;
        this.zzb = featureArr;
        this.zzc = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeBundle(parcel, 1, this.zza, false);
        ReactYogaConfigProvider.writeTypedArray(parcel, 2, this.zzb, i, false);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zzc);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, null, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzc() {
    }
}
