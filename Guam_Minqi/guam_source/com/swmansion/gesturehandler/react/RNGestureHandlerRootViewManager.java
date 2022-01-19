package com.swmansion.gesturehandler.react;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;

@ReactModule(name = RNGestureHandlerRootViewManager.REACT_CLASS)
public class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> {
    public static final String REACT_CLASS = "GestureHandlerRootView";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("onGestureHandlerEvent", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onGestureHandlerEvent"), "onGestureHandlerStateChange", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onGestureHandlerStateChange"));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNGestureHandlerRootView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNGestureHandlerRootView(themedReactContext);
    }

    public void onDropViewInstance(RNGestureHandlerRootView rNGestureHandlerRootView) {
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = rNGestureHandlerRootView.mRootHelper;
        if (rNGestureHandlerRootHelper != null) {
            rNGestureHandlerRootHelper.tearDown();
        }
    }
}
