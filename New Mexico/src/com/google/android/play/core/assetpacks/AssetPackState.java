package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import f.b.a.c.b.o.b;
import f.b.a.f.a.b.b0;
import f.b.a.f.a.b.d1;
import f.b.a.f.a.b.i0;
import f.b.a.f.a.b.m2;
/* loaded from: classes.dex */
public abstract class AssetPackState {
    public static AssetPackState h(String str, int i2, int i3, long j2, long j3, double d2, int i4, String str2, String str3) {
        return new i0(str, i2, i3, j2, j3, (int) Math.rint(100.0d * d2), i4, str2, str3);
    }

    public static AssetPackState i(Bundle bundle, String str, d1 d1Var, m2 m2Var, b0 b0Var) {
        double doubleValue;
        int i2;
        int a = b0Var.a(bundle.getInt(b.G1("status", str)), str);
        int i3 = bundle.getInt(b.G1("error_code", str));
        long j2 = bundle.getLong(b.G1("bytes_downloaded", str));
        long j3 = bundle.getLong(b.G1("total_bytes_to_download", str));
        synchronized (d1Var) {
            Double d2 = d1Var.a.get(str);
            doubleValue = d2 == null ? 0.0d : d2.doubleValue();
        }
        long j4 = bundle.getLong(b.G1("pack_version", str));
        long j5 = bundle.getLong(b.G1("pack_base_version", str));
        int i4 = 4;
        if (a == 4) {
            if (j5 == 0 || j5 == j4) {
                a = 4;
            } else {
                i2 = 2;
                return h(str, i4, i3, j2, j3, doubleValue, i2, bundle.getString(b.G1("pack_version_tag", str), String.valueOf(bundle.getInt("app_version_code"))), m2Var.a(str));
            }
        }
        i4 = a;
        i2 = 1;
        return h(str, i4, i3, j2, j3, doubleValue, i2, bundle.getString(b.G1("pack_version_tag", str), String.valueOf(bundle.getInt("app_version_code"))), m2Var.a(str));
    }

    public abstract long a();

    public abstract int b();

    public abstract String c();

    public abstract int d();

    public abstract long e();

    public abstract int f();

    public abstract int g();

    public abstract String j();

    public abstract String k();
}
