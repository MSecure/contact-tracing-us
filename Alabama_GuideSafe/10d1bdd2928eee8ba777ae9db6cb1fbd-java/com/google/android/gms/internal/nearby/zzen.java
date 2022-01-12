package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzen extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzen> CREATOR = new zzeo();
    public IStatusCallback zza;
    public DiagnosisKeysDataMapping zzb;

    public zzen() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzen) {
            zzen zzen = (zzen) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzen.zza) && ReactYogaConfigProvider.equal(this.zzb, zzen.zzb);
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

    public zzen(zzem zzem) {
    }

    public zzen(IBinder iBinder, DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
        this.zzb = diagnosisKeysDataMapping;
    }
}
