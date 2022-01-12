package com.facebook.react.uimanager.events;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class ContentSizeChangeEvent extends Event<ContentSizeChangeEvent> {
    public final int mHeight;
    public final int mWidth;

    public ContentSizeChangeEvent(int i, int i2, int i3) {
        super(i);
        this.mWidth = i2;
        this.mHeight = i3;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mWidth));
        createMap.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mHeight));
        rCTEventEmitter.receiveEvent(this.mViewTag, "topContentSizeChange", createMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topContentSizeChange";
    }
}
