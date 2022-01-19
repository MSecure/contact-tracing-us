package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.LocaleListCompat;
import androidx.core.os.LocaleListPlatformWrapper;
import com.facebook.react.modules.network.NetworkingModule;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.base.R$string;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zac {
    public static final SimpleArrayMap<String, String> zaa = new SimpleArrayMap<>();
    public static Locale zab;

    public static String zaa(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(R$string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R$string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R$string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zaa(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zaa(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zaa(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zaa(context, "common_google_play_services_restricted_profile_title");
        }
    }

    public static String zab(Context context) {
        String packageName = context.getPackageName();
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(context);
            return packageManager.zza.getPackageManager().getApplicationLabel(packageManager.zza.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zac(Context context, int i) {
        Resources resources = context.getResources();
        String zab2 = zab(context);
        if (i == 1) {
            return resources.getString(R$string.common_google_play_services_install_text, zab2);
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R$string.common_google_play_services_enable_text, zab2);
            } else if (i == 5) {
                return zaa(context, "common_google_play_services_invalid_account_text", zab2);
            } else {
                if (i == 7) {
                    return zaa(context, "common_google_play_services_network_error_text", zab2);
                }
                if (i == 9) {
                    return resources.getString(R$string.common_google_play_services_unsupported_text, zab2);
                } else if (i == 20) {
                    return zaa(context, "common_google_play_services_restricted_profile_text", zab2);
                } else {
                    switch (i) {
                        case 16:
                            return zaa(context, "common_google_play_services_api_unavailable_text", zab2);
                        case 17:
                            return zaa(context, "common_google_play_services_sign_in_failed_text", zab2);
                        case 18:
                            return resources.getString(R$string.common_google_play_services_updating_text, zab2);
                        default:
                            return resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, zab2);
                    }
                }
            }
        } else if (ReactYogaConfigProvider.isWearableWithoutPlayStore(context)) {
            return resources.getString(R$string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R$string.common_google_play_services_update_text, zab2);
        }
    }

    public static String zaa(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context, str);
        if (zaa2 == null) {
            zaa2 = resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zaa2, str2);
    }

    public static String zaa(Context context, String str) {
        LocaleListCompat localeListCompat;
        synchronized (zaa) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                localeListCompat = new LocaleListCompat(new LocaleListPlatformWrapper(configuration.getLocales()));
            } else {
                localeListCompat = LocaleListCompat.create(configuration.locale);
            }
            Locale locale = localeListCompat.mImpl.get(0);
            if (!locale.equals(zab)) {
                zaa.clear();
                zab = locale;
            }
            String orDefault = zaa.getOrDefault(str, null);
            if (orDefault != null) {
                return orDefault;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, NetworkingModule.REQUEST_BODY_KEY_STRING, "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            zaa.put(str, string);
            return string;
        }
    }

    public static String zaa(Context context) {
        return context.getResources().getString(R$string.common_google_play_services_notification_channel_name);
    }
}
