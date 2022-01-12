package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzef extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzef> CREATOR = new zzeg();
    public zzcr zza;
    public zzcm zzb;

    public zzef() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzef) {
            zzef zzef = (zzef) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzef.zza) && ReactYogaConfigProvider.equal(this.zzb, zzef.zzb);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        zzcr zzcr = this.zza;
        ReactYogaConfigProvider.writeIBinder(parcel, 1, zzcr == null ? null : zzcr.asBinder(), false);
        ReactYogaConfigProvider.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzef(zzee zzee) {
    }

    public zzef(IBinder iBinder, IBinder iBinder2) {
        zzcr zzcr;
        zzcm zzcm = null;
        if (iBinder == null) {
            zzcr = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            if (queryLocalInterface instanceof zzcr) {
                zzcr = (zzcr) queryLocalInterface;
            } else {
                zzcr = new zzcq(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            if (queryLocalInterface2 instanceof zzcm) {
                zzcm = (zzcm) queryLocalInterface2;
            } else {
                zzcm = new zzco(iBinder2);
            }
        }
        this.zza = zzcr;
        this.zzb = zzcm;
    }
}
