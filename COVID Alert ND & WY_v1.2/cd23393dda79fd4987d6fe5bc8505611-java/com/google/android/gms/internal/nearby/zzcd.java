package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zzcd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcd> CREATOR = new zzce();
    private List<TemporaryExposureKey> zza;
    private IStatusCallback zzb;
    private List<ParcelFileDescriptor> zzc;
    private ExposureConfiguration zzd;
    private String zze;

    private zzcd() {
    }

    zzcd(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, ExposureConfiguration exposureConfiguration, String str) {
        this(list, IStatusCallback.Stub.asInterface(iBinder), list2, exposureConfiguration, str);
    }

    private zzcd(List<TemporaryExposureKey> list, IStatusCallback iStatusCallback, List<ParcelFileDescriptor> list2, ExposureConfiguration exposureConfiguration, String str) {
        this.zza = list;
        this.zzb = iStatusCallback;
        this.zzc = list2;
        this.zzd = exposureConfiguration;
        this.zze = str;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcd) {
            zzcd zzcd = (zzcd) obj;
            return Objects.equal(this.zza, zzcd.zza) && Objects.equal(this.zzb, zzcd.zzb) && Objects.equal(this.zzc, zzcd.zzc) && Objects.equal(this.zzd, zzcd.zzd) && Objects.equal(this.zze, zzcd.zze);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
