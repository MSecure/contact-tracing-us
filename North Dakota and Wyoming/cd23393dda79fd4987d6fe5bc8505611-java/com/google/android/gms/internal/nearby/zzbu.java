package com.google.android.gms.internal.nearby;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public interface zzbu extends IInterface {
    void zza(Status status, List<TemporaryExposureKey> list) throws RemoteException;
}
