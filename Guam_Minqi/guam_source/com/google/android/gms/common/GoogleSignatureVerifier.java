package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class GoogleSignatureVerifier {
    public static GoogleSignatureVerifier zza;

    public GoogleSignatureVerifier(Context context) {
        context.getApplicationContext();
    }

    @RecentlyNonNull
    public static boolean zza(@RecentlyNonNull PackageInfo packageInfo, @RecentlyNonNull boolean z) {
        zzd zzd;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzd = zza(packageInfo, zzi.zza);
            } else {
                zzd = zza(packageInfo, zzi.zza[0]);
            }
            if (zzd != null) {
                return true;
            }
        }
        return false;
    }

    public static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdArr.length; i++) {
            if (zzdArr[i].equals(zzg)) {
                return zzdArr[i];
            }
        }
        return null;
    }
}
