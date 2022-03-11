package f.b.a.c.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.R$string;
import e.b.a.m;
import f.a.a.a.a;
import f.b.a.c.b.m.g0;
import f.b.a.c.b.m.j0;
import f.b.a.c.b.o.b;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public class e {
    @RecentlyNonNull
    public static final int a = 12451000;
    public static final e b = new e();

    static {
        AtomicBoolean atomicBoolean = i.a;
    }

    @RecentlyNullable
    public Intent a(Context context, @RecentlyNonNull int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            if (context == null || !b.a1(context)) {
                StringBuilder h2 = a.h("gcore_");
                h2.append(a);
                h2.append("-");
                if (!TextUtils.isEmpty(str)) {
                    h2.append(str);
                }
                h2.append("-");
                if (context != null) {
                    h2.append(context.getPackageName());
                }
                h2.append("-");
                if (context != null) {
                    try {
                        f.b.a.c.b.p.a a2 = f.b.a.c.b.p.b.a(context);
                        h2.append(a2.a.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb = h2.toString();
                int i3 = g0.a;
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            int i4 = g0.a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i2 != 3) {
            return null;
        } else {
            int i5 = g0.a;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:2|124|3|5|(4:9|24|21|(2:23|(2:25|26))(2:27|28))|32|(4:34|(3:36|(1:41)(1:40)|42)|43|(14:45|(1:48)(1:49)|50|(2:116|52)|126|54|55|f3|67|(1:69)(8:(2:71|(1:75))|77|(1:79)(1:80)|(1:82)|(1:84)(4:85|(2:128|87)|89|(1:91)(1:92))|98|(2:(5:101|114|102|103|(2:104|(2:106|(1:130))(2:131|108)))|109)(0)|(1:111)(1:132))|76|98|(0)(0)|(0)(0)))|46|(0)(0)|50|(0)|126|54|55|f3) */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x017c, code lost:
        r12 = java.lang.String.valueOf(r3);
        r0 = " requires Google Play services, but they are missing.";
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c6 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ca  */
    @RecentlyNonNull
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int b(@RecentlyNonNull Context context, @RecentlyNonNull int i2) {
        boolean z;
        int i3;
        int i4;
        String valueOf;
        String str;
        AtomicBoolean atomicBoolean = i.a;
        try {
            context.getResources().getString(R$string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
        }
        boolean z2 = true;
        if (!"com.google.android.gms".equals(context.getPackageName()) && !i.b.get()) {
            synchronized (j0.a) {
                if (!j0.b) {
                    j0.b = true;
                    try {
                        Bundle bundle = f.b.a.c.b.p.b.a(context).a.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                        if (bundle != null) {
                            bundle.getString("com.google.app.id");
                            j0.c = bundle.getInt("com.google.android.gms.version");
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                }
            }
            int i5 = j0.c;
            if (i5 == 0) {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            } else if (i5 != 12451000) {
                StringBuilder sb = new StringBuilder(320);
                sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                sb.append(12451000);
                sb.append(" but found ");
                sb.append(i5);
                sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw new IllegalStateException(sb.toString());
            }
        }
        if (!b.a1(context)) {
            if (b.c == null) {
                b.c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
            }
            if (!b.c.booleanValue()) {
                z = true;
                m.e.h(i2 < 0);
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = null;
                if (z) {
                    try {
                        packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                    } catch (PackageManager.NameNotFoundException unused3) {
                        valueOf = String.valueOf(packageName);
                        str = " requires the Google Play Store, but it is missing.";
                    }
                }
                PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                synchronized (j.class) {
                    if (j.a == null) {
                        synchronized (s.class) {
                            if (s.a == null) {
                                s.a = context.getApplicationContext();
                            }
                        }
                        j.a = new j(context);
                    }
                }
                if (!j.b(packageInfo2, true)) {
                    valueOf = String.valueOf(packageName);
                    str = " requires Google Play services, but their signature is invalid.";
                } else {
                    if (z) {
                        Objects.requireNonNull(packageInfo, "null reference");
                        if (!j.b(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0])) {
                            valueOf = String.valueOf(packageName);
                            str = " requires Google Play Store, but its signature is invalid.";
                        }
                    }
                    int i6 = packageInfo2.versionCode;
                    int i7 = -1;
                    if (i6 == -1) {
                        i4 = -1;
                    } else {
                        i4 = i6 / 1000;
                    }
                    if (i2 != -1) {
                        i7 = i2 / 1000;
                    }
                    if (i4 < i7) {
                        String.valueOf(packageName).length();
                        i3 = 2;
                    } else {
                        ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                        if (applicationInfo == null) {
                            try {
                                applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                            } catch (PackageManager.NameNotFoundException unused4) {
                                String str2 = String.valueOf(packageName);
                                String str3 = " requires Google Play services, but they're missing when getting application info.";
                                str2.concat(str3);
                                i3 = 1;
                                if (i3 != 18) {
                                }
                                if (z2) {
                                }
                            }
                        }
                        i3 = !applicationInfo.enabled ? 3 : 0;
                    }
                    if (i3 != 18) {
                        if (i3 == 1) {
                            try {
                                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if ("com.google.android.gms".equals(it.next().getAppPackageName())) {
                                            break;
                                        }
                                    } else {
                                        z2 = context.getPackageManager().getApplicationInfo("com.google.android.gms", 8192).enabled;
                                        break;
                                    }
                                }
                            } catch (PackageManager.NameNotFoundException | Exception unused5) {
                            }
                        }
                        z2 = false;
                    }
                    if (z2) {
                        return 18;
                    }
                    return i3;
                }
                valueOf.concat(str);
                i3 = 9;
                if (i3 != 18) {
                }
                if (z2) {
                }
            }
        }
        z = false;
        m.e.h(i2 < 0);
        String packageName2 = context.getPackageName();
        PackageManager packageManager2 = context.getPackageManager();
        PackageInfo packageInfo3 = null;
        if (z) {
        }
        PackageInfo packageInfo22 = packageManager2.getPackageInfo("com.google.android.gms", 64);
        synchronized (j.class) {
        }
    }
}
