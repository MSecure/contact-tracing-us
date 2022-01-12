package com.th3rdwave.safeareacontext;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class InsetsChangeEvent extends Event<InsetsChangeEvent> {
    public Rect mFrame;
    public EdgeInsets mInsets;

    public InsetsChangeEvent(int i, EdgeInsets edgeInsets, Rect rect) {
        super(i);
        this.mInsets = edgeInsets;
        this.mFrame = rect;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableMap createMap = Arguments.createMap();
        EdgeInsets edgeInsets = this.mInsets;
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(edgeInsets.top));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(edgeInsets.right));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(edgeInsets.bottom));
        createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(edgeInsets.left));
        createMap.putMap("insets", createMap2);
        Rect rect = this.mFrame;
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("x", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(rect.x));
        createMap3.putDouble("y", (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(rect.y));
        createMap3.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(rect.width));
        createMap3.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(rect.height));
        createMap.putMap("frame", createMap3);
        rCTEventEmitter.receiveEvent(this.mViewTag, "topInsetsChange", createMap);
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return "topInsetsChange";
    }
}
