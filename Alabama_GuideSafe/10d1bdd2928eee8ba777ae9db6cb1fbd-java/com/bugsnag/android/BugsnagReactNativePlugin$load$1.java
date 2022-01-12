package com.bugsnag.android;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BugsnagReactNativePlugin.kt */
public final class BugsnagReactNativePlugin$load$1 extends Lambda implements Function1<MessageEvent, Unit> {
    public final /* synthetic */ BugsnagReactNativePlugin this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BugsnagReactNativePlugin$load$1(BugsnagReactNativePlugin bugsnagReactNativePlugin) {
        super(1);
        this.this$0 = bugsnagReactNativePlugin;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MessageEvent messageEvent) {
        MessageEvent messageEvent2 = messageEvent;
        Intrinsics.checkParameterIsNotNull(messageEvent2, "it");
        Function1<? super MessageEvent, Unit> function1 = this.this$0.jsCallback;
        if (function1 != null) {
            function1.invoke(messageEvent2);
        }
        return Unit.INSTANCE;
    }
}
