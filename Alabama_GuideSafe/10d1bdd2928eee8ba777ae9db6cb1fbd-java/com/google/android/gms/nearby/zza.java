package com.google.android.gms.nearby;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zza {
    public static final Feature zza = new Feature("nearby_connections", 3);
    public static final Feature zzb = new Feature("nearby_exposure_notification", 3);
    public static final Feature zzc = new Feature("nearby_exposure_notification_1p", 1);
    public static final Feature zzd = new Feature("nearby_exposure_notification_get_version", 1);
    public static final Feature zze = new Feature("nearby_exposure_notification_get_calibration_confidence", 1);
    public static final Feature zzf = new Feature("nearby_exposure_notification_get_day_summaries", 1);
    public static final Feature zzg = new Feature("nearby_exposure_notification_get_status", 1);
    public static final Feature zzh = new Feature("nearby_exposure_notification_diagnosis_keys_data_mapping", 1);
    public static final Feature zzi = new Feature("nearby_exposure_notification_diagnosis_key_file_supplier", 1);
    public static final Feature zzj = new Feature("nearby_exposure_notification_package_configuration", 1);
    public static final Feature zzk;
    public static final Feature zzl = new Feature("nearby_sharing", 30);
    public static final Feature zzm = new Feature("nearby_sharing_get_phone_numbers", 1);
    public static final Feature zzn = new Feature("nearby_sharing_ignore_consent", 2);
    public static final Feature zzo = new Feature("nearby_sharing_phonesky", 1);
    public static final Feature zzp = new Feature("nearby_fast_pair", 2);
    public static final Feature[] zzq;

    static {
        Feature feature = new Feature("nearby_connections_get_local_endpoint_id", 1);
        zzk = feature;
        zzq = new Feature[]{zzl, zzm, zzn, zzo, zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzp, feature};
    }
}
