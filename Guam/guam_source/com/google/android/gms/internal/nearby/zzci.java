package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzci extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzci> CREATOR = new zzcn();
    public zzdq zza;

    public zzci() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzci) {
            return ReactYogaConfigProvider.equal(this.zza, ((zzci) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzci(zzcl zzcl) {
    }

    public zzci(IBinder iBinder) {
        zzdq zzdq;
        if (iBinder == null) {
            zzdq = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            if (queryLocalInterface instanceof zzdq) {
                zzdq = (zzdq) queryLocalInterface;
            } else {
                zzdq = new zzds(iBinder);
            }
        }
        this.zza = zzdq;
    }
}
