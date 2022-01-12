package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcj();
    public zzdy zza;
    public zzea zzb;

    public zzce() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzce) {
            zzce zzce = (zzce) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzce.zza) && ReactYogaConfigProvider.equal(this.zzb, zzce.zzb);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        zzdy zzdy = this.zza;
        if (zzdy == null) {
            iBinder = null;
        } else {
            iBinder = zzdy.asBinder();
        }
        ReactYogaConfigProvider.writeIBinder(parcel, 1, iBinder, false);
        ReactYogaConfigProvider.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzce(zzch zzch) {
    }

    public zzce(IBinder iBinder, IBinder iBinder2) {
        zzdy zzdy;
        zzea zzea = null;
        if (iBinder == null) {
            zzdy = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyHistoryResultListener");
            if (queryLocalInterface instanceof zzdy) {
                zzdy = (zzdy) queryLocalInterface;
            } else {
                zzdy = new zzeb(iBinder);
            }
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
            if (queryLocalInterface2 instanceof zzea) {
                zzea = (zzea) queryLocalInterface2;
            } else {
                zzea = new zzec(iBinder2);
            }
        }
        this.zza = zzdy;
        this.zzb = zzea;
    }
}
