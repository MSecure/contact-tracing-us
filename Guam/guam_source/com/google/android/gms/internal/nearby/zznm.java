package com.google.android.gms.internal.nearby;

import android.database.ContentObserver;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zznm extends ContentObserver {
    public zznm() {
        super(null);
    }

    public final void onChange(boolean z) {
        zznj.zze.set(true);
    }
}
