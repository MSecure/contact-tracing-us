package com.bugsnag.android;

import com.bugsnag.android.AnrPlugin;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnrPlugin.kt */
public final class AnrPlugin$load$loaded$1 implements OnErrorCallback {
    public static final AnrPlugin$load$loaded$1 INSTANCE = new AnrPlugin$load$loaded$1();

    @Override // com.bugsnag.android.OnErrorCallback
    public final boolean onError(Event event) {
        Intrinsics.checkParameterIsNotNull(event, "it");
        Error error = event.impl.errors.get(0);
        Intrinsics.checkExpressionValueIsNotNull(error, "error");
        error.setErrorClass("AnrLinkError");
        AnrPlugin.Companion unused = AnrPlugin.Companion;
        error.impl.errorMessage = AnrPlugin.LOAD_ERR_MSG;
        return true;
    }
}
