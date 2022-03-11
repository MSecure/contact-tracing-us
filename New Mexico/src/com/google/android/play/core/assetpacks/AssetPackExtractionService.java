package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import f.b.a.c.b.o.b;
import f.b.a.f.a.b.m3;
import f.b.a.f.a.b.n1;
import f.b.a.f.a.b.s0;
import f.b.a.f.a.b.w;
/* loaded from: classes.dex */
public class AssetPackExtractionService extends Service {
    public w b;

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.b;
    }

    @Override // android.app.Service
    public final void onCreate() {
        s0 s0Var;
        super.onCreate();
        Context applicationContext = getApplicationContext();
        synchronized (n1.class) {
            if (n1.a == null) {
                Context applicationContext2 = applicationContext.getApplicationContext();
                if (applicationContext2 != null) {
                    applicationContext = applicationContext2;
                }
                m3 m3Var = new m3(applicationContext);
                b.M1(m3Var, m3.class);
                n1.a = new s0(m3Var);
            }
            s0Var = n1.a;
        }
        this.b = s0Var.B.a();
    }
}
