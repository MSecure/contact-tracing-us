package com.google.android.gms.nearby;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class zza {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    private static final Feature zzd;
    private static final Feature[] zze;

    static {
        Feature feature = new Feature("nearby_sharing", 30);
        zzd = feature;
        Feature feature2 = new Feature("nearby_connections", 3);
        zza = feature2;
        Feature feature3 = new Feature("nearby_exposure_notification", 3);
        zzb = feature3;
        Feature feature4 = new Feature("nearby_exposure_notification_1p", 1);
        zzc = feature4;
        zze = new Feature[]{feature, feature2, feature3, feature4};
    }
}
