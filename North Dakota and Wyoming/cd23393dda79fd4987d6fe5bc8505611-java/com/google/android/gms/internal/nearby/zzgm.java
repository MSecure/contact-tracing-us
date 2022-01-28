package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzgm extends zzgn<Connections.StartAdvertisingResult> {
    private zzgm(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public /* synthetic */ Result createFailedResult(Status status) {
        return new zzgp(this, status);
    }

    /* synthetic */ zzgm(GoogleApiClient googleApiClient, zzft zzft) {
        this(googleApiClient);
    }
}
