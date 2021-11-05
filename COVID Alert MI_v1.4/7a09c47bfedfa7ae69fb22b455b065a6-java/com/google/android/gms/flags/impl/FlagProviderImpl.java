package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import b.x.t;
import c.b.a.a.f.d.a;
import c.b.a.a.f.d.b;
import c.b.a.a.f.d.c;
import c.b.a.a.f.d.d;
import c.b.a.a.f.d.e;
import c.b.a.a.f.g;
import com.google.android.gms.common.util.DynamiteApi;

@DynamiteApi
public class FlagProviderImpl extends g {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5993a = false;

    /* renamed from: b  reason: collision with root package name */
    public SharedPreferences f5994b;

    @Override // c.b.a.a.f.f
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        if (!this.f5993a) {
            return z;
        }
        SharedPreferences sharedPreferences = this.f5994b;
        Boolean valueOf = Boolean.valueOf(z);
        try {
            valueOf = (Boolean) t.b4(new a(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                new String("Flag value not available, returning default: ");
            }
        }
        return valueOf.booleanValue();
    }

    @Override // c.b.a.a.f.f
    public int getIntFlagValue(String str, int i, int i2) {
        if (!this.f5993a) {
            return i;
        }
        SharedPreferences sharedPreferences = this.f5994b;
        Integer valueOf = Integer.valueOf(i);
        try {
            valueOf = (Integer) t.b4(new b(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                new String("Flag value not available, returning default: ");
            }
        }
        return valueOf.intValue();
    }

    @Override // c.b.a.a.f.f
    public long getLongFlagValue(String str, long j, int i) {
        if (!this.f5993a) {
            return j;
        }
        SharedPreferences sharedPreferences = this.f5994b;
        Long valueOf = Long.valueOf(j);
        try {
            valueOf = (Long) t.b4(new c(sharedPreferences, str, valueOf));
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf2);
            } else {
                new String("Flag value not available, returning default: ");
            }
        }
        return valueOf.longValue();
    }

    @Override // c.b.a.a.f.f
    public String getStringFlagValue(String str, String str2, int i) {
        if (!this.f5993a) {
            return str2;
        }
        try {
            return (String) t.b4(new d(this.f5994b, str, str2));
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Flag value not available, returning default: ".concat(valueOf);
                return str2;
            }
            new String("Flag value not available, returning default: ");
            return str2;
        }
    }

    @Override // c.b.a.a.f.f
    public void init(c.b.a.a.e.a aVar) {
        Context context = (Context) c.b.a.a.e.b.g0(aVar);
        if (!this.f5993a) {
            try {
                this.f5994b = e.a(context.createPackageContext("com.google.android.gms", 0));
                this.f5993a = true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
                } else {
                    new String("Could not retrieve sdk flags, continuing with defaults: ");
                }
            }
        }
    }
}
