package f.b.a.c.b.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.base.R$string;
import e.e.h;
import e.i.e.b;
import e.i.e.e;
import f.b.a.c.b.p.a;
import java.util.Locale;

public final class p {
    public static final h<String, String> a = new h<>();
    public static Locale b;

    public static String a(Context context, int i2) {
        String str;
        Resources resources = context.getResources();
        switch (i2) {
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
                return b(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return b(context, "common_google_play_services_network_error_title");
            case 8:
                str = "Internal error occurred. Please see logs for detailed information";
                break;
            case 9:
                str = "Google Play services is invalid. Cannot recover.";
                break;
            case 10:
                str = "Developer error occurred. Please see logs for detailed information";
                break;
            case 11:
                str = "The application is not licensed to the user.";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(i2);
                str = sb.toString();
                break;
            case 16:
                str = "One of the API components you attempted to connect to is not available.";
                break;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return b(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return b(context, "common_google_play_services_restricted_profile_title");
        }
        Log.e("GoogleApiAvailability", str);
        return null;
    }

    public static String b(Context context, String str) {
        b bVar;
        Resources resources;
        h<String, String> hVar = a;
        synchronized (hVar) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                bVar = new b(new e(configuration.getLocales()));
            } else {
                bVar = b.a(configuration.locale);
            }
            Locale locale = bVar.a.get(0);
            if (!locale.equals(b)) {
                hVar.clear();
                b = locale;
            }
            String orDefault = hVar.getOrDefault(str, null);
            if (orDefault != null) {
                return orDefault;
            }
            int i2 = f.b.a.c.b.h.c;
            try {
                resources = context.getPackageManager().getResourcesForApplication("com.google.android.gms");
            } catch (PackageManager.NameNotFoundException unused) {
                resources = null;
            }
            if (resources == null) {
                return null;
            }
            int identifier = resources.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = resources.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            hVar.put(str, string);
            return string;
        }
    }

    public static String c(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String b2 = b(context, str);
        if (b2 == null) {
            b2 = resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, b2, str2);
    }

    public static String d(Context context) {
        String packageName = context.getPackageName();
        try {
            a a2 = f.b.a.c.b.p.b.a(context);
            return a2.a.getPackageManager().getApplicationLabel(a2.a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String e(Context context, int i2) {
        Resources resources = context.getResources();
        String d2 = d(context);
        if (i2 == 1) {
            return resources.getString(R$string.common_google_play_services_install_text, d2);
        } else if (i2 != 2) {
            if (i2 == 3) {
                return resources.getString(R$string.common_google_play_services_enable_text, d2);
            } else if (i2 == 5) {
                return c(context, "common_google_play_services_invalid_account_text", d2);
            } else {
                if (i2 == 7) {
                    return c(context, "common_google_play_services_network_error_text", d2);
                }
                if (i2 == 9) {
                    return resources.getString(R$string.common_google_play_services_unsupported_text, d2);
                } else if (i2 == 20) {
                    return c(context, "common_google_play_services_restricted_profile_text", d2);
                } else {
                    switch (i2) {
                        case 16:
                            return c(context, "common_google_play_services_api_unavailable_text", d2);
                        case 17:
                            return c(context, "common_google_play_services_sign_in_failed_text", d2);
                        case 18:
                            return resources.getString(R$string.common_google_play_services_updating_text, d2);
                        default:
                            return resources.getString(com.google.android.gms.common.R$string.common_google_play_services_unknown_issue, d2);
                    }
                }
            }
        } else if (f.b.a.c.b.o.b.l1(context)) {
            return resources.getString(R$string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R$string.common_google_play_services_update_text, d2);
        }
    }
}
