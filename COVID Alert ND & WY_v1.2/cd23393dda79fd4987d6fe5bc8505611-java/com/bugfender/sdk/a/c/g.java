package com.bugfender.sdk.a.c;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.bugfender.android.BuildConfig;
import com.bugfender.sdk.a.a.e.c;
import com.bugfender.sdk.a.a.e.f.a;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class g implements a {
    private static final String d = "bg_device_id";
    private final Context a;
    private final com.bugfender.sdk.a.c.i.a b;
    private final SharedPreferences c;

    public g(Context context, com.bugfender.sdk.a.c.i.a aVar, SharedPreferences sharedPreferences) {
        c.a(context, "Context must be not null");
        this.c = sharedPreferences;
        this.b = aVar;
        this.a = context;
    }

    private PackageInfo t() {
        return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String a() {
        String string = this.c.getString(d, null);
        if (string != null) {
            return string;
        }
        String uuid = UUID.randomUUID().toString();
        SharedPreferences.Editor edit = this.c.edit();
        edit.putString(d, uuid);
        edit.commit();
        return uuid;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String b() {
        return this.a.getPackageName();
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String c() {
        try {
            return String.valueOf(t().versionCode);
        } catch (Exception unused) {
            return String.valueOf((int) BuildConfig.VERSION_CODE);
        }
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public long d() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j = (long) statFs.getBlockSize();
            j2 = (long) statFs.getAvailableBlocks();
        }
        return j2 * j;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String e() {
        return Build.MODEL;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String f() {
        String str;
        try {
            str = Settings.Secure.getString(this.a.getContentResolver(), "android_id");
        } catch (Exception unused) {
            str = null;
        }
        return str != null ? str : "";
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public boolean g() {
        return "true".equals(Settings.System.getString(this.a.getContentResolver(), "firebase.test.lab"));
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String h() {
        try {
            return String.valueOf(t().versionName);
        } catch (Exception unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public long i() {
        return this.b.a();
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public float j() {
        int a2;
        Intent registerReceiver = this.a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            if (intExtra == -1 || intExtra2 == -1) {
                a2 = a(50);
            } else {
                a2 = a(intExtra);
            }
        } else {
            a2 = a(50);
        }
        return (float) a2;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String k() {
        try {
            return TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            return "GMT+00:00";
        }
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public long l() {
        long j;
        long j2;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        if (Build.VERSION.SDK_INT >= 18) {
            j = statFs.getBlockSizeLong();
            j2 = statFs.getBlockCountLong();
        } else {
            j = (long) statFs.getBlockSize();
            j2 = (long) statFs.getBlockCount();
        }
        return j2 * j;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public long m() {
        return this.b.c();
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String n() {
        return Locale.getDefault().getLanguage();
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String o() {
        return "Android";
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String p() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    @Deprecated
    public String q() {
        try {
            PackageInfo packageInfo = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
            String str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            return str + "." + i;
        } catch (PackageManager.NameNotFoundException unused) {
            return BuildConfig.VERSION_NAME;
        }
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public long r() {
        return this.b.b();
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public int s() {
        return this.a.getResources().getConfiguration().orientation;
    }

    @Override // com.bugfender.sdk.a.a.e.f.a
    public String a(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (com.bugfender.sdk.a.c.h.a.c()) {
            ContentResolver contentResolver = this.a.getContentResolver();
            com.bugfender.sdk.a.c.h.a.h();
            str2 = Settings.Global.getString(contentResolver, "device_name");
        } else {
            str2 = Settings.System.getString(this.a.getContentResolver(), "device_name");
        }
        return TextUtils.isEmpty(str2) ? Build.MANUFACTURER : str2;
    }

    private int a(int i) {
        return i / 100;
    }
}
