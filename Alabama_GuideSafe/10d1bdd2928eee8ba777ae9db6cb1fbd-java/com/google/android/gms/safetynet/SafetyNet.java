package com.google.android.gms.safetynet;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.safetynet.zzx;

public final class SafetyNet {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final Api.AbstractClientBuilder<zzx, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
    public static final Api.ClientKey<zzx> CLIENT_KEY = new Api.ClientKey<>();

    static {
        zzk zzk = new zzk();
        CLIENT_BUILDER = zzk;
        API = new Api<>("SafetyNet.API", zzk, CLIENT_KEY);
    }

    public static SafetyNetClient getClient(Context context) {
        return new SafetyNetClient(context);
    }
}
