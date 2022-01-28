package com.google.android.gms.internal.nearby;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzad implements RemoteCall {
    public final zzt zza;
    public final List zzb;
    public final ExposureConfiguration zzc;
    public final String zzd;

    public zzad(zzt zzt, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.zza = zzt;
        this.zzb = list;
        this.zzc = exposureConfiguration;
        this.zzd = str;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final void accept(Object obj, Object obj2) {
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
            zzej zzej = new zzej(null);
            zzej.zzc = arrayList;
            zzej.zzd = exposureConfiguration;
            zzej.zzb = new zzav(arrayList, taskCompletionSource);
            zzej.zze = str;
            ((zzdv) zzr.getService()).zza(zzej);
        } catch (FileNotFoundException e) {
            Status status = new Status(39506, e.getMessage());
            if (status.isSuccess()) {
                taskCompletionSource.zza.zza((Object) null);
                return;
            }
            taskCompletionSource.zza.zza((Exception) new ApiException(status));
        }
    }
}
