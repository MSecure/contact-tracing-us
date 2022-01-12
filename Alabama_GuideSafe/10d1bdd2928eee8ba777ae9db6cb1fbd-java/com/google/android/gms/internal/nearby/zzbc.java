package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbh();
    public zzct zza;
    public DailySummariesConfig zzb;

    public zzbc() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbc) {
            zzbc zzbc = (zzbc) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzbc.zza) && ReactYogaConfigProvider.equal(this.zzb, zzbc.zzb);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        ReactYogaConfigProvider.writeParcelable(parcel, 2, this.zzb, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzbc(zzbf zzbf) {
    }

    public zzbc(IBinder iBinder, DailySummariesConfig dailySummariesConfig) {
        zzct zzct;
        if (iBinder == null) {
            zzct = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            if (queryLocalInterface instanceof zzct) {
                zzct = (zzct) queryLocalInterface;
            } else {
                zzct = new zzcv(iBinder);
            }
        }
        this.zza = zzct;
        this.zzb = dailySummariesConfig;
    }
}
