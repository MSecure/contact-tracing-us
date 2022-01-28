package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzau extends zza implements zzcu {
    public final /* synthetic */ DiagnosisKeyFileProvider zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzau(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        super("com.google.android.gms.nearby.exposurenotification.internal.IDiagnosisKeyFileSupplier");
        this.zza = diagnosisKeyFileProvider;
    }

    @Override // com.google.android.gms.internal.nearby.zza
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        ParcelFileDescriptor parcelFileDescriptor;
        boolean z = false;
        if (i == 1) {
            DiagnosisKeyFileProvider diagnosisKeyFileProvider = this.zza;
            if (diagnosisKeyFileProvider.zzb.size() > diagnosisKeyFileProvider.zza) {
                z = true;
            }
            parcel2.writeNoException();
            zzd.zza(parcel2, z);
        } else if (i == 2) {
            try {
                DiagnosisKeyFileProvider diagnosisKeyFileProvider2 = this.zza;
                List<File> list = diagnosisKeyFileProvider2.zzb;
                int i3 = diagnosisKeyFileProvider2.zza;
                diagnosisKeyFileProvider2.zza = i3 + 1;
                parcelFileDescriptor = ParcelFileDescriptor.open(list.get(i3), 268435456);
            } catch (FileNotFoundException unused) {
                parcelFileDescriptor = null;
            }
            parcel2.writeNoException();
            zzd.zzb(parcel2, parcelFileDescriptor);
        } else if (i != 3) {
            return false;
        } else {
            parcel2.writeNoException();
            zzd.zza(parcel2, true);
        }
        return true;
    }
}
