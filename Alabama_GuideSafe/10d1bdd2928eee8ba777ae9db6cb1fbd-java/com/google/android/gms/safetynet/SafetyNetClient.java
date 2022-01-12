package com.google.android.gms.safetynet;

import android.content.Context;
import android.os.Looper;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;

public class SafetyNetClient extends GoogleApi<Api.ApiOptions.NoOptions> {
    /* JADX WARNING: Illegal instructions before constructor call */
    public SafetyNetClient(Context context) {
        super(context, r0, null, new GoogleApi.Settings(r1, null, Looper.getMainLooper()));
        Api<Api.ApiOptions.NoOptions> api = SafetyNet.API;
        ApiExceptionMapper apiExceptionMapper = new ApiExceptionMapper();
        ReactYogaConfigProvider.checkNotNull(apiExceptionMapper, "StatusExceptionMapper must not be null.");
    }
}
