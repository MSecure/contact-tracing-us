package c.b.a.a.c.l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import b.e.h;
import c.b.a.a.c.f;
import c.b.a.a.c.i;
import c.b.a.a.c.n.c;
import c.b.a.a.c.o.a;
import c.b.a.a.c.o.b;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final h<String, String> f2447a = new h<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            a a2 = b.a(context);
            return a2.f2499a.getPackageManager().getApplicationLabel(a2.f2499a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(c.b.a.a.b.b.common_google_play_services_notification_channel_name);
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        String a2 = a(context);
        if (i == 1) {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_install_text, a2);
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(c.b.a.a.b.b.common_google_play_services_enable_text, a2);
            } else if (i == 5) {
                return f(context, "common_google_play_services_invalid_account_text", a2);
            } else {
                if (i == 7) {
                    return f(context, "common_google_play_services_network_error_text", a2);
                }
                if (i == 9) {
                    return resources.getString(c.b.a.a.b.b.common_google_play_services_unsupported_text, a2);
                } else if (i == 20) {
                    return f(context, "common_google_play_services_restricted_profile_text", a2);
                } else {
                    switch (i) {
                        case 16:
                            return f(context, "common_google_play_services_api_unavailable_text", a2);
                        case 17:
                            return f(context, "common_google_play_services_sign_in_failed_text", a2);
                        case 18:
                            return resources.getString(c.b.a.a.b.b.common_google_play_services_updating_text, a2);
                        default:
                            return resources.getString(i.common_google_play_services_unknown_issue, a2);
                    }
                }
            }
        } else if (c.w1(context)) {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_update_text, a2);
        }
    }

    public static String d(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(c.b.a.a.b.b.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return e(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return e(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return e(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return e(context, "common_google_play_services_restricted_profile_title");
    }

    public static String e(Context context, String str) {
        synchronized (f2447a) {
            String orDefault = f2447a.getOrDefault(str, null);
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
            f2447a.put(str, string);
            return string;
        }
    }

    public static String f(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String e2 = e(context, str);
        if (e2 == null) {
            e2 = resources.getString(i.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, e2, str2);
    }
}
