package com.bugfender.sdk.a.a.g;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

public class b implements a<String> {
    public static final long b = -1;
    public static final String c = "";
    public static final boolean d = false;
    public static final int e = -1;
    public static final String f = ".copy";
    public static final String g = "first.time.boolean.key";
    private static final String h = "resend.keys.boolean.key";
    private SharedPreferences a;

    public b(Context context) {
        this.a = context.getSharedPreferences("bugfender.device.key", 0);
    }

    private boolean g(String str) {
        return str.contains(f);
    }

    private String h(String str) {
        return str + f;
    }

    private boolean i(String str) {
        return str.equalsIgnoreCase(g) || str.equalsIgnoreCase(h);
    }

    /* renamed from: e */
    public Integer a(String str) {
        return Integer.valueOf(this.a.getInt(str, -1));
    }

    /* renamed from: f */
    public String d(String str) {
        return this.a.getString(str, "");
    }

    @Override // com.bugfender.sdk.a.a.g.a
    public boolean b(String str) {
        SharedPreferences.Editor b2 = b();
        b2.remove(str);
        return b2.commit();
    }

    /* renamed from: c */
    public boolean b(String str) {
        return this.a.getBoolean(str, false);
    }

    /* renamed from: d */
    public Float c(String str) {
        return Float.valueOf(this.a.getFloat(str, -1.0f));
    }

    private boolean c() {
        boolean z = this.a.getBoolean(g, true);
        if (z) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putBoolean(g, false);
            edit.commit();
        }
        return z;
    }

    private boolean d() {
        boolean z = this.a.getBoolean(h, true);
        if (z) {
            SharedPreferences.Editor edit = this.a.edit();
            edit.putBoolean(h, false);
            edit.apply();
        }
        return z;
    }

    private SharedPreferences.Editor b() {
        return this.a.edit();
    }

    private boolean b(String str, String str2) {
        return d(h(str)).equalsIgnoreCase(str2);
    }

    public boolean a(String str, Boolean bool) {
        if (b(str, bool)) {
            return true;
        }
        SharedPreferences.Editor b2 = b();
        b2.putBoolean(str, bool.booleanValue());
        b2.putBoolean(h(str), bool.booleanValue());
        return b2.commit();
    }

    private boolean b(String str, Integer num) {
        return a(h(str)).equals(num);
    }

    private boolean b(String str, Float f2) {
        return c(h(str)).equals(f2);
    }

    private boolean b(String str, Boolean bool) {
        if (!c() && b(h(str)) == bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public boolean a(String str, String str2) {
        if (b(str, str2)) {
            return true;
        }
        SharedPreferences.Editor b2 = b();
        b2.putString(str, str2);
        b2.putString(h(str), str2);
        return b2.commit();
    }

    public boolean a(String str, Integer num) {
        if (b(str, num)) {
            return true;
        }
        SharedPreferences.Editor b2 = b();
        b2.putInt(str, num.intValue());
        b2.putInt(h(str), num.intValue());
        return b2.commit();
    }

    public boolean a(String str, Float f2) {
        if (b(str, f2)) {
            return true;
        }
        SharedPreferences.Editor b2 = b();
        b2.putFloat(str, f2.floatValue());
        b2.putFloat(h(str), f2.floatValue());
        return b2.commit();
    }

    @Override // com.bugfender.sdk.a.a.g.a
    public boolean a(String str) {
        SharedPreferences.Editor b2 = b();
        b2.remove(str);
        b2.remove(h(str));
        return b2.commit();
    }

    @Override // com.bugfender.sdk.a.a.g.a
    public Map<String, ?> a() {
        return a(false);
    }

    @Override // com.bugfender.sdk.a.a.g.a
    public Map<String, ?> a(boolean z) {
        HashMap hashMap = new HashMap();
        Map<String, ?> all = this.a.getAll();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        for (String str : all.keySet()) {
            Object obj = all.get(str);
            if (i(str)) {
                hashMap2.put(str, obj);
            } else if (g(str)) {
                hashMap3.put(str.replace(f, ""), obj);
            } else {
                hashMap.put(str, obj);
            }
        }
        if (z || d()) {
            hashMap.putAll(hashMap3);
        }
        return hashMap;
    }
}
