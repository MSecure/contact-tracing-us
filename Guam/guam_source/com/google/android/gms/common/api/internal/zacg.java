package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zacg extends TaskApiCall<A, ResultT> {
    public final /* synthetic */ TaskApiCall.Builder zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacg(TaskApiCall.Builder builder, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i, null);
        this.zaa = builder;
    }
}
