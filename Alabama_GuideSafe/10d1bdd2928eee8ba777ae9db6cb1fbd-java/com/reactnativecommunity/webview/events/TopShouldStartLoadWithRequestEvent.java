package com.reactnativecommunity.webview.events;

import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TopShouldStartLoadWithRequestEvent.kt */
public final class TopShouldStartLoadWithRequestEvent extends Event<TopShouldStartLoadWithRequestEvent> {
    public final WritableMap mData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TopShouldStartLoadWithRequestEvent(int i, WritableMap writableMap) {
        super(i);
        Intrinsics.checkNotNullParameter(writableMap, "mData");
        this.mData = writableMap;
        writableMap.putString("navigationType", "other");
        this.mData.putBoolean("isTopFrame", true);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        Intrinsics.checkNotNullParameter(rCTEventEmitter, "rctEventEmitter");
        rCTEventEmitter.receiveEvent(this.mViewTag, "topShouldStartLoadWithRequest", this.mData);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topShouldStartLoadWithRequest";
    }
}
