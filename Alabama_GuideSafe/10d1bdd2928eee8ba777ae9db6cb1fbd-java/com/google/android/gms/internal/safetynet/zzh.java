package com.google.android.gms.internal.safetynet;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;

public abstract class zzh extends zzb implements zzg {
    public zzh() {
        super("com.google.android.gms.safetynet.internal.ISafetyNetCallbacks");
    }

    @Override // com.google.android.gms.internal.safetynet.zzb
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((zzs) this).zzag.setResult(new zzk$zza((Status) zzc.zza(parcel, Status.CREATOR), (zza) zzc.zza(parcel, zza.CREATOR)));
            return true;
        } else if (i == 2) {
            parcel.readString();
            throw new UnsupportedOperationException();
        } else if (i == 3) {
            Status status = (Status) zzc.zza(parcel, Status.CREATOR);
            SafeBrowsingData safeBrowsingData = (SafeBrowsingData) zzc.zza(parcel, SafeBrowsingData.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 4) {
            Status status2 = (Status) zzc.zza(parcel, Status.CREATOR);
            parcel.readInt();
            throw new UnsupportedOperationException();
        } else if (i == 6) {
            Status status3 = (Status) zzc.zza(parcel, Status.CREATOR);
            zzf zzf = (zzf) zzc.zza(parcel, zzf.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 8) {
            Status status4 = (Status) zzc.zza(parcel, Status.CREATOR);
            zzd zzd = (zzd) zzc.zza(parcel, zzd.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 15) {
            Status status5 = (Status) zzc.zza(parcel, Status.CREATOR);
            com.google.android.gms.safetynet.zzh zzh = (com.google.android.gms.safetynet.zzh) zzc.zza(parcel, com.google.android.gms.safetynet.zzh.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 10) {
            Status status6 = (Status) zzc.zza(parcel, Status.CREATOR);
            parcel.readInt();
            throw new UnsupportedOperationException();
        } else if (i != 11) {
            return false;
        } else {
            Status status7 = (Status) zzc.zza(parcel, Status.CREATOR);
            throw new UnsupportedOperationException();
        }
    }
}
