package com.google.android.gms.internal.nearby;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.nearby.Nearby;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public abstract class zzgn<R extends Result> extends BaseImplementation.ApiMethodImpl<R, zzdd> {
    public zzgn(GoogleApiClient googleApiClient) {
        super(Nearby.CONNECTIONS_API, googleApiClient);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.android.gms.internal.nearby.zzgn<R extends com.google.android.gms.common.api.Result> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }
}
