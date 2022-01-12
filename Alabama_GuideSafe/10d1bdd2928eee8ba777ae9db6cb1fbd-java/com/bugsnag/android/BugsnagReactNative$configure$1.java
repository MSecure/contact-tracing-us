package com.bugsnag.android;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: BugsnagReactNative.kt */
public final class BugsnagReactNative$configure$1 extends Lambda implements Function1<MessageEvent, Unit> {
    public final /* synthetic */ BugsnagReactNative this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BugsnagReactNative$configure$1(BugsnagReactNative bugsnagReactNative) {
        super(1);
        this.this$0 = bugsnagReactNative;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MessageEvent messageEvent) {
        MessageEvent messageEvent2 = messageEvent;
        Intrinsics.checkNotNullParameter(messageEvent2, "it");
        this.this$0.emitEvent(messageEvent2);
        return Unit.INSTANCE;
    }
}
