package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public interface zzct extends IInterface {
    void zza(Status status, List<DailySummary> list) throws RemoteException;
}
