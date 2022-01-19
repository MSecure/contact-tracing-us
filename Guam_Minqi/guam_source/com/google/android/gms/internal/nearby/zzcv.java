package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzcv extends zzb implements zzct {
    public zzcv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
    }

    @Override // com.google.android.gms.internal.nearby.zzct
    public final void zza(Status status, List<DailySummary> list) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, status);
        a_.writeList(list);
        zzc(1, a_);
    }
}
