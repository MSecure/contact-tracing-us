package c.b.a.a.d.m;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import b.e.h;
import b.i.h.e;
import b.x.t;
import c.b.a.a.b.b;
import c.b.a.a.d.f;
import c.b.a.a.d.i;
import c.b.a.a.d.p.a;
import java.util.Locale;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final h<String, String> f3148a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    public static Locale f3149b;

    public static String a(Context context) {
        return context.getResources().getString(b.common_google_play_services_notification_channel_name);
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(b.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(b.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(b.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return c(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return c(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return c(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return c(context, "common_google_play_services_restricted_profile_title");
    }

    public static String c(Context context, String str) {
        b.i.h.b bVar;
        synchronized (f3148a) {
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT >= 24) {
                bVar = new b.i.h.b(new e(configuration.getLocales()));
            } else {
                bVar = b.i.h.b.a(configuration.locale);
            }
            Locale locale = bVar.f1767a.get(0);
            if (!locale.equals(f3149b)) {
                f3148a.clear();
                f3149b = locale;
            }
            String orDefault = f3148a.getOrDefault(str, null);
            if (orDefault != null) {
                return orDefault;
            }
            Resources e2 = f.e(context);
            if (e2 == null) {
                return null;
            }
            int identifier = e2.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Missing resource: ".concat(valueOf);
                } else {
                    new String("Missing resource: ");
                }
                return null;
            }
            String string = e2.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                if (valueOf2.length() != 0) {
                    "Got empty resource: ".concat(valueOf2);
                } else {
                    new String("Got empty resource: ");
                }
                return null;
            }
            f3148a.put(str, string);
            return string;
        }
    }

    public static String d(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String c2 = c(context, str);
        if (c2 == null) {
            c2 = resources.getString(i.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, c2, str2);
    }

    public static String e(Context context) {
        String packageName = context.getPackageName();
        try {
            a a2 = c.b.a.a.d.p.b.a(context);
            return a2.f3180a.getPackageManager().getApplicationLabel(a2.f3180a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String f(Context context, int i) {
        Resources resources = context.getResources();
        String e2 = e(context);
        if (i == 1) {
            return resources.getString(b.common_google_play_services_install_text, e2);
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(b.common_google_play_services_enable_text, e2);
            } else if (i == 5) {
                return d(context, "common_google_play_services_invalid_account_text", e2);
            } else {
                if (i == 7) {
                    return d(context, "common_google_play_services_network_error_text", e2);
                }
                if (i == 9) {
                    return resources.getString(b.common_google_play_services_unsupported_text, e2);
                } else if (i == 20) {
                    return d(context, "common_google_play_services_restricted_profile_text", e2);
                } else {
                    switch (i) {
                        case 16:
                            return d(context, "common_google_play_services_api_unavailable_text", e2);
                        case 17:
                            return d(context, "common_google_play_services_sign_in_failed_text", e2);
                        case 18:
                            return resources.getString(b.common_google_play_services_updating_text, e2);
                        default:
                            return resources.getString(i.common_google_play_services_unknown_issue, e2);
                    }
                }
            }
        } else if (t.Z1(context)) {
            return resources.getString(b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(b.common_google_play_services_update_text, e2);
        }
    }
}
