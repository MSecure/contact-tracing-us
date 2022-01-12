package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzej extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzej> CREATOR = new zzek();
    public List<TemporaryExposureKey> zza;
    public IStatusCallback zzb;
    public List<ParcelFileDescriptor> zzc;
    public ExposureConfiguration zzd;
    public String zze;
    public zzcu zzf;

    public zzej() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzej) {
            zzej zzej = (zzej) obj;
            return ReactYogaConfigProvider.equal(this.zza, zzej.zza) && ReactYogaConfigProvider.equal(this.zzb, zzej.zzb) && ReactYogaConfigProvider.equal(this.zzc, zzej.zzc) && ReactYogaConfigProvider.equal(this.zzd, zzej.zzd) && ReactYogaConfigProvider.equal(this.zze, zzej.zze) && ReactYogaConfigProvider.equal(this.zzf, zzej.zzf);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeTypedList(parcel, 1, this.zza, false);
        ReactYogaConfigProvider.writeIBinder(parcel, 2, this.zzb.asBinder(), false);
        ReactYogaConfigProvider.writeTypedList(parcel, 3, this.zzc, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 4, this.zzd, i, false);
        ReactYogaConfigProvider.writeString(parcel, 5, this.zze, false);
        zzcu zzcu = this.zzf;
        ReactYogaConfigProvider.writeIBinder(parcel, 6, zzcu == null ? null : zzcu.asBinder(), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzej(zzei zzei) {
    }

    public zzej(List<TemporaryExposureKey> list, IBinder iBinder, List<ParcelFileDescriptor> list2, ExposureConfiguration exposureConfiguration, String str, IBinder iBinder2) {
        zzcu zzcu;
        IStatusCallback asInterface = IStatusCallback.Stub.asInterface(iBinder);
        if (iBinder2 == null) {
            zzcu = null;
        } else {
            IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
            if (queryLocalInterface instanceof zzcu) {
                zzcu = (zzcu) queryLocalInterface;
            } else {
                zzcu = new zzcw(iBinder2);
            }
        }
        this.zza = list;
        this.zzb = asInterface;
        this.zzc = list2;
        this.zzd = exposureConfiguration;
        this.zze = str;
        this.zzf = zzcu;
    }
}
