package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzch extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzch> CREATOR = new zzci();
    private IStatusCallback zza;
    private ExposureConfiguration zzb;

    private zzch() {
    }

    zzch(IBinder iBinder, ExposureConfiguration exposureConfiguration) {
        this(IStatusCallback.Stub.asInterface(iBinder), exposureConfiguration);
    }

    private zzch(IStatusCallback iStatusCallback, ExposureConfiguration exposureConfiguration) {
        this.zza = iStatusCallback;
        this.zzb = exposureConfiguration;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzch) {
            zzch zzch = (zzch) obj;
            return Objects.equal(this.zza, zzch.zza) && Objects.equal(this.zzb, zzch.zzb);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zza.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
