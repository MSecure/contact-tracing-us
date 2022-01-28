package com.bugsnag.android;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BugsnagReactNativePlugin.kt */
public final class BugsnagReactNativePlugin$ignoreJavaScriptExceptions$1 implements OnErrorCallback {
    public static final BugsnagReactNativePlugin$ignoreJavaScriptExceptions$1 INSTANCE = new BugsnagReactNativePlugin$ignoreJavaScriptExceptions$1();

    @Override // com.bugsnag.android.OnErrorCallback
    public final boolean onError(Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        Error error = event.impl.errors.get(0);
        Intrinsics.checkExpressionValueIsNotNull(error, "event.errors[0]");
        return !Intrinsics.areEqual(error.impl.errorClass, "com.facebook.react.common.JavascriptException");
    }
}
