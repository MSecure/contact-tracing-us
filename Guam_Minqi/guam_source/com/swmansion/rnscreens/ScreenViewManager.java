package com.swmansion.rnscreens;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.rnscreens.Screen;
import java.util.Map;

@ReactModule(name = ScreenViewManager.REACT_CLASS)
public class ScreenViewManager extends ViewGroupManager<Screen> {
    public static final String REACT_CLASS = "RNSScreen";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("topDismissed", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDismissed"), "topAppear", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onAppear"), "topFinishTransitioning", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onFinishTransitioning"));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(defaultFloat = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = AppStateModule.APP_STATE_ACTIVE)
    public void setActive(Screen screen, float f) {
        screen.setActive(f != BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        screen.setGestureEnabled(z);
    }

    @ReactProp(name = "stackAnimation")
    public void setStackAnimation(Screen screen, String str) {
        if (str == null || "default".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.DEFAULT);
        } else if ("none".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.NONE);
        } else if ("fade".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.FADE);
        }
    }

    @ReactProp(name = "stackPresentation")
    public void setStackPresentation(Screen screen, String str) {
        if ("push".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.PUSH);
        } else if ("modal".equals(str) || "containedModal".equals(str) || "fullScreenModal".equals(str) || "formSheet".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.MODAL);
        } else if ("transparentModal".equals(str) || "containedTransparentModal".equals(str)) {
            screen.setStackPresentation(Screen.StackPresentation.TRANSPARENT_MODAL);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline8("Unknown presentation type ", str));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        return new Screen(themedReactContext);
    }
}
