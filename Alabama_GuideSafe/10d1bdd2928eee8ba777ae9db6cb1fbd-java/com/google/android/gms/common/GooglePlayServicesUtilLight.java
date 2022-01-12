package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.wrappers.Wrappers;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class GooglePlayServicesUtilLight {
    @RecentlyNonNull
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    public static final AtomicBoolean zze = new AtomicBoolean();

    @Deprecated
    public static String getErrorString(@RecentlyNonNull int i) {
        return ConnectionResult.zza(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0113 A[SYNTHETIC] */
    @RecentlyNonNull
    @Deprecated
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, @RecentlyNonNull int i) {
        boolean z;
        String packageName;
        int i2;
        try {
            context.getResources().getString(R$string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !zze.get()) {
            synchronized (zzt.zza) {
                if (!zzt.zzb) {
                    zzt.zzb = true;
                    try {
                        Bundle bundle = Wrappers.packageManager(context).zza.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            bundle.getString("com.google.app.id");
                            zzt.zzd = bundle.getInt("com.google.android.gms.version");
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        Log.wtf("MetadataValueReader", "This should never happen.", e);
                    }
                }
            }
            int i3 = zzt.zzd;
            if (i3 == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (i3 != 12451000) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(GOOGLE_PLAY_SERVICES_VERSION_CODE);
                sb.append(" but found ");
                sb.append(i3);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        if (!ReactYogaConfigProvider.isWearableWithoutPlayStore(context)) {
            if (ReactYogaConfigProvider.zzf == null) {
                ReactYogaConfigProvider.zzf = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (!ReactYogaConfigProvider.zzf.booleanValue()) {
                z = true;
                ReactYogaConfigProvider.checkArgument(i < 0);
                packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = null;
                if (z) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires the Google Play Store, but it is missing."));
                    }
                }
                PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                ReactYogaConfigProvider.checkNotNull(context);
                synchronized (GoogleSignatureVerifier.class) {
                    if (GoogleSignatureVerifier.zza == null) {
                        synchronized (zzc.class) {
                            if (zzc.zzc == null) {
                                zzc.zzc = context.getApplicationContext();
                            } else {
                                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                            }
                        }
                        GoogleSignatureVerifier.zza = new GoogleSignatureVerifier(context);
                    }
                }
                if (!GoogleSignatureVerifier.zza(packageInfo2, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but their signature is invalid."));
                } else {
                    if (z) {
                        ReactYogaConfigProvider.checkNotNull(packageInfo);
                        if (!GoogleSignatureVerifier.zza(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play Store, but its signature is invalid."));
                        }
                    }
                    int i4 = packageInfo2.versionCode;
                    int i5 = -1;
                    if (i4 == -1) {
                        i2 = -1;
                    } else {
                        i2 = i4 / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                    }
                    if (i != -1) {
                        i5 = i / RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
                    }
                    if (i2 < i5) {
                        int i6 = packageInfo2.versionCode;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 82);
                        sb2.append("Google Play services out of date for ");
                        sb2.append(packageName);
                        sb2.append(".  Requires ");
                        sb2.append(i);
                        sb2.append(" but found ");
                        sb2.append(i6);
                        Log.w("GooglePlayServicesUtil", sb2.toString());
                        return 2;
                    }
                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e2);
                            return 1;
                        }
                    }
                    if (!applicationInfo.enabled) {
                        return 3;
                    }
                    return 0;
                }
                return 9;
            }
        }
        z = false;
        ReactYogaConfigProvider.checkArgument(i < 0);
        packageName = context.getPackageName();
        PackageManager packageManager2 = context.getPackageManager();
        PackageInfo packageInfo3 = null;
        if (z) {
        }
        try {
            PackageInfo packageInfo22 = packageManager2.getPackageInfo("com.google.android.gms", 64);
            ReactYogaConfigProvider.checkNotNull(context);
            synchronized (GoogleSignatureVerifier.class) {
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            Log.w("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they are missing."));
            return 1;
        }
    }

    @RecentlyNonNull
    @Deprecated
    public static boolean isUserRecoverableError(@RecentlyNonNull int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }
}
