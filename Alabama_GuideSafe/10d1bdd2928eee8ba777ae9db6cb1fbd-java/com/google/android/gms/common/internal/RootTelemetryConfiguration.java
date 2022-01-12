package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzv();
    public final int zza;
    public final boolean zzb;
    public final boolean zzc;
    public final int zzd;
    public final int zze;

    public RootTelemetryConfiguration(@RecentlyNonNull int i, @RecentlyNonNull boolean z, @RecentlyNonNull boolean z2, @RecentlyNonNull int i2, @RecentlyNonNull int i3) {
        this.zza = i;
        this.zzb = z;
        this.zzc = z2;
        this.zzd = i2;
        this.zze = i3;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zza);
        ReactYogaConfigProvider.writeBoolean(parcel, 2, this.zzb);
        ReactYogaConfigProvider.writeBoolean(parcel, 3, this.zzc);
        ReactYogaConfigProvider.writeInt(parcel, 4, this.zzd);
        ReactYogaConfigProvider.writeInt(parcel, 5, this.zze);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
