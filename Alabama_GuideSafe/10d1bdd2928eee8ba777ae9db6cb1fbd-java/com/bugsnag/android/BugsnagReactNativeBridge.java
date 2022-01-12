package com.bugsnag.android;

import com.bugsnag.android.StateEvent;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Observable;
import java.util.Observer;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BugsnagReactNativeBridge.kt */
public final class BugsnagReactNativeBridge implements Observer {
    public final Function1<MessageEvent, Unit> cb;
    public final Client client;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super com.bugsnag.android.MessageEvent, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BugsnagReactNativeBridge(Client client2, Function1<? super MessageEvent, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(client2, "client");
        Intrinsics.checkParameterIsNotNull(function1, "cb");
        this.client = client2;
        this.cb = function1;
    }

    public void update(Observable observable, Object obj) {
        MessageEvent messageEvent;
        Intrinsics.checkParameterIsNotNull(observable, "observable");
        if (obj instanceof StateEvent) {
            if (obj instanceof StateEvent.UpdateContext) {
                messageEvent = new MessageEvent(BugsnagReactNative.UPDATE_CONTEXT, ((StateEvent.UpdateContext) obj).context);
            } else if ((obj instanceof StateEvent.AddMetadata) || (obj instanceof StateEvent.ClearMetadataSection) || (obj instanceof StateEvent.ClearMetadataValue)) {
                messageEvent = new MessageEvent(BugsnagReactNative.UPDATE_METADATA, this.client.metadataState.metadata.toMap());
            } else if (obj instanceof StateEvent.UpdateUser) {
                StateEvent.UpdateUser updateUser = (StateEvent.UpdateUser) obj;
                messageEvent = new MessageEvent(BugsnagReactNative.UPDATE_USER, MoreExecutors.mapOf(new Pair("id", updateUser.user.id), new Pair("email", updateUser.user.email), new Pair("name", updateUser.user.name)));
            } else {
                messageEvent = null;
            }
            if (messageEvent != null) {
                this.cb.invoke(messageEvent);
            }
        }
    }
}
