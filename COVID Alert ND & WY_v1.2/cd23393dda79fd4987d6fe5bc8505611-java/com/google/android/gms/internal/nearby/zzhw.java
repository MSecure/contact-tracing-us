package com.google.android.gms.internal.nearby;

import android.nfc.NfcAdapter;
import android.nfc.Tag;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final /* synthetic */ class zzhw implements NfcAdapter.ReaderCallback {
    private final zzhx zza;

    zzhw(zzhx zzhx) {
        this.zza = zzhx;
    }

    public final void onTagDiscovered(Tag tag) {
        this.zza.zza(tag);
    }
}
