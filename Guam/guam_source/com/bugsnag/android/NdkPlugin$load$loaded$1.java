package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: NdkPlugin.kt */
public final class NdkPlugin$load$loaded$1 implements OnErrorCallback {
    public static final NdkPlugin$load$loaded$1 INSTANCE = new NdkPlugin$load$loaded$1();

    @Override // com.bugsnag.android.OnErrorCallback
    public final boolean onError(Event event) {
        Intrinsics.checkParameterIsNotNull(event, "it");
        Error error = event.impl.errors.get(0);
        Intrinsics.checkExpressionValueIsNotNull(error, "error");
        error.setErrorClass("NdkLinkError");
        NdkPlugin.access$Companion();
        error.impl.errorMessage = NdkPlugin.LOAD_ERR_MSG;
        return true;
    }
}
