package com.swmansion.rnscreens;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;

@ReactModule(name = ScreenStackHeaderSubviewManager.REACT_CLASS)
public class ScreenStackHeaderSubviewManager extends ReactViewManager {
    public static final String REACT_CLASS = "RNSScreenStackHeaderSubview";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "type")
    public void setType(ScreenStackHeaderSubview screenStackHeaderSubview, String str) {
        if (RNGestureHandlerModule.KEY_HIT_SLOP_LEFT.equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.LEFT);
        } else if ("center".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.CENTER);
        } else if (RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT.equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.RIGHT);
        } else if ("back".equals(str)) {
            screenStackHeaderSubview.setType(ScreenStackHeaderSubview.Type.BACK);
        }
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    public ReactViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenStackHeaderSubview(themedReactContext);
    }
}
