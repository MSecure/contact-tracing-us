package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final /* synthetic */ class zzw implements RemoteCall {
    private final zzt zza;
    private final List zzb;
    private final ExposureConfiguration zzc;
    private final String zzd;

    zzw(zzt zzt, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.zza = zzt;
        this.zzb = list;
        this.zzc = exposureConfiguration;
        this.zzd = str;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
        zzt zzt = this.zza;
        List<File> list = this.zzb;
        ExposureConfiguration exposureConfiguration = this.zzc;
        String str = this.zzd;
        zzr zzr = (zzr) obj;
        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
        ArrayList arrayList = new ArrayList(list.size());
        try {
            for (File file : list) {
                arrayList.add(ParcelFileDescriptor.open(file, 268435456));
            }
            ((zzbq) zzr.getService()).zza(new zzcf().zza(arrayList).zza(exposureConfiguration).zza(new zzaf(zzt, arrayList, taskCompletionSource)).zza(str).zza());
        } catch (FileNotFoundException e) {
            TaskUtil.setResultOrApiException(new Status((int) ExposureNotificationStatusCodes.FAILED_DISK_IO, e.getMessage()), taskCompletionSource);
        }
    }
}
