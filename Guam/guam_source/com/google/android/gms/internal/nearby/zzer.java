package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzer extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzer> CREATOR = new zzes();
    public IStatusCallback zza;
    public ExposureConfiguration zzb;

    public zzer() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzer) {
            zzer zzer = (zzer) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzer.zza) && ReactYogaConfigProvider.equal(this.zzb, zzer.zzb);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeIBinder(parcel, 3, this.zza.asBinder(), false);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, this.zzb, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzer(zzeq zzeq) {
    }

    public zzer(IBinder iBinder, ExposureConfiguration exposureConfiguration) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
        this.zzb = exposureConfiguration;
    }
}
