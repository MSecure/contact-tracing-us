package c.b.a.a.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import c.b.a.a.c.l.h0;
import c.b.a.a.c.n.c;
import c.b.a.a.c.o.b;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f2295a = 12451000;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f2296b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicBoolean f2297c = new AtomicBoolean();

    @Deprecated
    public static String a(int i) {
        return a.s(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fe A[SYNTHETIC] */
    @Deprecated
    public static int b(Context context, int i) {
        boolean z;
        String packageName;
        String str;
        String str2;
        int i2;
        try {
            context.getResources().getString(i.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f2297c.get()) {
            synchronized (h0.f2466a) {
                if (!h0.f2467b) {
                    h0.f2467b = true;
                    try {
                        Bundle bundle = b.a(context).f2499a.getPackageManager().getApplicationInfo(context.getPackageName(), RecyclerView.d0.FLAG_IGNORE).metaData;
                        if (bundle != null) {
                            bundle.getString("com.google.app.id");
                            h0.f2468c = bundle.getInt("com.google.android.gms.version");
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("MetadataValueReader", "This should never happen.", e2);
                    }
                }
            }
            int i3 = h0.f2468c;
            if (i3 == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (i3 != 12451000) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(f2295a);
                sb.append(" but found ");
                sb.append(i3);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        if (!c.w1(context)) {
            if (c.f2495c == null) {
                c.f2495c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (!c.f2495c.booleanValue()) {
                z = true;
                i.j.i(i < 0);
                packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = null;
                if (z) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                    } catch (PackageManager.NameNotFoundException unused2) {
                        str2 = String.valueOf(packageName);
                        str = " requires the Google Play Store, but it is missing.";
                    }
                }
                PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                i.j.s(context);
                synchronized (h.class) {
                    if (h.f2298a == null) {
                        synchronized (r.class) {
                            if (r.f2502a == null) {
                                r.f2502a = context.getApplicationContext();
                            }
                        }
                        h.f2298a = new h(context);
                    }
                }
                if (!h.b(packageInfo2, true)) {
                    str2 = String.valueOf(packageName);
                    str = " requires Google Play services, but their signature is invalid.";
                } else if (!z || (h.b(packageInfo, true) && packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                    int i4 = packageInfo2.versionCode;
                    int i5 = -1;
                    if (i4 == -1) {
                        i2 = -1;
                    } else {
                        i2 = i4 / 1000;
                    }
                    if (i != -1) {
                        i5 = i / 1000;
                    }
                    if (i2 < i5) {
                        String.valueOf(packageName).length();
                        return 2;
                    }
                    ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                    if (applicationInfo == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            Log.wtf("GooglePlayServicesUtil", String.valueOf(packageName).concat(" requires Google Play services, but they're missing when getting application info."), e3);
                            return 1;
                        }
                    }
                    if (!applicationInfo.enabled) {
                        return 3;
                    }
                    return 0;
                } else {
                    str2 = String.valueOf(packageName);
                    str = " requires Google Play Store, but its signature is invalid.";
                }
                str2.concat(str);
                return 9;
            }
        }
        z = false;
        i.j.i(i < 0);
        packageName = context.getPackageName();
        PackageManager packageManager2 = context.getPackageManager();
        PackageInfo packageInfo3 = null;
        if (z) {
        }
        try {
            PackageInfo packageInfo22 = packageManager2.getPackageInfo("com.google.android.gms", 64);
            i.j.s(context);
            synchronized (h.class) {
            }
        } catch (PackageManager.NameNotFoundException unused3) {
            String.valueOf(packageName).concat(" requires Google Play services, but they are missing.");
            return 1;
        }
    }

    @TargetApi(21)
    public static boolean c(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        try {
            for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(sessionInfo.getAppPackageName())) {
                    return true;
                }
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, RecyclerView.d0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled) {
                Bundle applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName());
                if (!(applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile")))) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static boolean d(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }
}
