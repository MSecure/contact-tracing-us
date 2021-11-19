package com.google.android.gms.internal.nearby;

import android.database.ContentObserver;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
final class zzlc extends ContentObserver {
    zzlc(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        zzkz.zza().set(true);
    }
}
