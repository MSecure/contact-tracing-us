package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.zza;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final /* synthetic */ class zzah {
    public final zzt zza;
    public final List zzb;
    public final ExposureConfiguration zzc;
    public final String zzd;

    public zzah(zzt zzt, List list, ExposureConfiguration exposureConfiguration, String str) {
        this.zza = zzt;
        this.zzb = list;
        this.zzc = exposureConfiguration;
        this.zzd = str;
    }

    public final Object then(Task task) {
        zzt zzt = this.zza;
        List list = this.zzb;
        ExposureConfiguration exposureConfiguration = this.zzc;
        String str = this.zzd;
        if (zzt == null) {
            throw null;
        } else if (((Long) task.getResult()).longValue() >= 17203704004L) {
            DiagnosisKeyFileProvider diagnosisKeyFileProvider = new DiagnosisKeyFileProvider(list);
            TaskApiCall.Builder builder = TaskApiCall.builder();
            builder.zaa = new zzag(zzt, exposureConfiguration, diagnosisKeyFileProvider, str);
            builder.zac = new Feature[]{zza.zzi};
            return zzt.zaa(1, builder.build());
        } else {
            TaskApiCall.Builder builder2 = TaskApiCall.builder();
            builder2.zaa = new zzad(zzt, list, exposureConfiguration, str);
            builder2.zac = new Feature[]{zza.zzb};
            return zzt.zaa(1, builder2.build());
        }
    }
}
