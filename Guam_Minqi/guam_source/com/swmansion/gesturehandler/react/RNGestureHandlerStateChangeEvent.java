package com.swmansion.gesturehandler.react;

import androidx.core.util.Pools$SynchronizedPool;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.GestureHandler;

public class RNGestureHandlerStateChangeEvent extends Event<RNGestureHandlerStateChangeEvent> {
    public static final Pools$SynchronizedPool<RNGestureHandlerStateChangeEvent> EVENTS_POOL = new Pools$SynchronizedPool<>(7);
    public WritableMap mExtraData;

    public static RNGestureHandlerStateChangeEvent obtain(GestureHandler gestureHandler, int i, int i2, RNGestureHandlerEventDataExtractor rNGestureHandlerEventDataExtractor) {
        RNGestureHandlerStateChangeEvent acquire = EVENTS_POOL.acquire();
        if (acquire == null) {
            acquire = new RNGestureHandlerStateChangeEvent();
        }
        super.init(gestureHandler.mView.getId());
        WritableMap createMap = Arguments.createMap();
        acquire.mExtraData = createMap;
        if (rNGestureHandlerEventDataExtractor != null) {
            rNGestureHandlerEventDataExtractor.extractEventData(gestureHandler, createMap);
        }
        acquire.mExtraData.putInt("handlerTag", gestureHandler.mTag);
        acquire.mExtraData.putInt("state", i);
        acquire.mExtraData.putInt("oldState", i2);
        return acquire;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(this.mViewTag, "onGestureHandlerStateChange", this.mExtraData);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public short getCoalescingKey() {
        return 0;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "onGestureHandlerStateChange";
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void onDispose() {
        this.mExtraData = null;
        EVENTS_POOL.release(this);
    }
}
