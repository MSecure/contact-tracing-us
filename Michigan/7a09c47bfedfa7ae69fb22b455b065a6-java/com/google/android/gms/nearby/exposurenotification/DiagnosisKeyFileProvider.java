package com.google.android.gms.nearby.exposurenotification;

import c.b.a.a.g.e.na;
import java.io.File;
import java.util.List;

public class DiagnosisKeyFileProvider {
    public int zza = 0;
    public final List<File> zzb;

    public DiagnosisKeyFileProvider(List<File> list) {
        this.zzb = na.q(list);
    }

    public final boolean zza() {
        return this.zzb.size() > this.zza;
    }

    public final File zzb() {
        List<File> list = this.zzb;
        int i = this.zza;
        this.zza = i + 1;
        return list.get(i);
    }
}
