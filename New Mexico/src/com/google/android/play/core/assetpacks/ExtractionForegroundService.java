package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import f.b.a.f.a.b.w0;
/* loaded from: classes.dex */
public class ExtractionForegroundService extends Service {
    public final IBinder b = new w0(this);

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.b;
    }
}
