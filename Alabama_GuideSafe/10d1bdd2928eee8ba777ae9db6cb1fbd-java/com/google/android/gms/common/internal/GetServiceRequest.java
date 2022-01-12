package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class GetServiceRequest extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zze();
    public String zza;
    public IBinder zzb;
    public Scope[] zzc;
    public Bundle zzd;
    public Account zze;
    public Feature[] zzf;
    public Feature[] zzg;
    public boolean zzh;
    public final int zzi;
    public final int zzj;
    public int zzk;
    public boolean zzl;
    public int zzm;

    public GetServiceRequest(@RecentlyNonNull int i) {
        this.zzi = 5;
        this.zzk = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzj = i;
        this.zzl = true;
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zzi);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zzj);
        ReactYogaConfigProvider.writeInt(parcel, 3, this.zzk);
        ReactYogaConfigProvider.writeString(parcel, 4, this.zza, false);
        ReactYogaConfigProvider.writeIBinder(parcel, 5, this.zzb, false);
        ReactYogaConfigProvider.writeTypedArray(parcel, 6, this.zzc, i, false);
        ReactYogaConfigProvider.writeBundle(parcel, 7, this.zzd, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 8, this.zze, i, false);
        ReactYogaConfigProvider.writeTypedArray(parcel, 10, this.zzf, i, false);
        ReactYogaConfigProvider.writeTypedArray(parcel, 11, this.zzg, i, false);
        ReactYogaConfigProvider.writeBoolean(parcel, 12, this.zzl);
        ReactYogaConfigProvider.writeInt(parcel, 13, this.zzm);
        ReactYogaConfigProvider.writeBoolean(parcel, 14, this.zzh);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z, int i4, boolean z2) {
        this.zzi = i;
        this.zzj = i2;
        this.zzk = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zza = "com.google.android.gms";
        } else {
            this.zza = str;
        }
        if (i < 2) {
            this.zze = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzb = iBinder;
            this.zze = account;
        }
        this.zzc = scopeArr;
        this.zzd = bundle;
        this.zzf = featureArr;
        this.zzg = featureArr2;
        this.zzl = z;
        this.zzm = i4;
        this.zzh = z2;
    }
}
