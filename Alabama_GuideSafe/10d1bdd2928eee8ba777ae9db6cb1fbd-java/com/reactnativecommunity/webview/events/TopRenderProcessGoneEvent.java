package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopRenderProcessGoneEvent.kt */
public final class TopRenderProcessGoneEvent extends Event<TopRenderProcessGoneEvent> {
    public final WritableMap mEventData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopRenderProcessGoneEvent(int i, WritableMap writableMap) {
        super(i);
        Intrinsics.checkNotNullParameter(writableMap, "mEventData");
        this.mEventData = writableMap;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(this.mViewTag, "topRenderProcessGone", this.mEventData);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topRenderProcessGone";
    }
}
