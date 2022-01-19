package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzec extends zzb implements zzea {
    public zzec(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.ITemporaryExposureKeyListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzea
    public final void zza(Status status, List<TemporaryExposureKey> list) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, status);
        a_.writeTypedList(list);
        zzc(1, a_);
    }
}
