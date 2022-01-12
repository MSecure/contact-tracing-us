package com.swmansion.rnscreens;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.rnscreens.Screen;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = ScreenViewManager.REACT_CLASS)
public class ScreenViewManager extends ViewGroupManager<Screen> {
    public static final String REACT_CLASS = "RNSScreen";

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        Map of = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDismissed");
        Map of2 = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onWillAppear");
        Map of3 = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onAppear");
        Map of4 = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onWillDisappear");
        Map of5 = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDisappear");
        Map of6 = AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onFinishTransitioning");
        HashMap hashMap = new HashMap();
        hashMap.put("topDismissed", of);
        hashMap.put("topWillAppear", of2);
        hashMap.put("topAppear", of3);
        hashMap.put("topWillDisappear", of4);
        hashMap.put("topDisappear", of5);
        hashMap.put("topFinishTransitioning", of6);
        return hashMap;
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @ReactProp(name = "activityState")
    public void setActivityState(Screen screen, Integer num) {
        if (num != null) {
            if (num.intValue() == 0) {
                screen.setActivityState(Screen.ActivityState.INACTIVE);
            } else if (num.intValue() == 1) {
                screen.setActivityState(Screen.ActivityState.TRANSITIONING_OR_BELOW_TOP);
            } else if (num.intValue() == 2) {
                screen.setActivityState(Screen.ActivityState.ON_TOP);
            }
        }
    }

    @ReactProp(defaultBoolean = true, name = "gestureEnabled")
    public void setGestureEnabled(Screen screen, boolean z) {
        screen.setGestureEnabled(z);
    }

    @ReactProp(name = "replaceAnimation")
    public void setReplaceAnimation(Screen screen, String str) {
        if (str == null || "pop".equals(str)) {
            screen.setReplaceAnimation(Screen.ReplaceAnimation.POP);
        } else if ("push".equals(str)) {
            screen.setReplaceAnimation(Screen.ReplaceAnimation.PUSH);
        }
    }

    @ReactProp(name = "stackAnimation")
    public void setStackAnimation(Screen screen, String str) {
        if (str == null || "default".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.DEFAULT);
        } else if ("none".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.NONE);
        } else if ("fade".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.FADE);
        } else if ("slide_from_right".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.SLIDE_FROM_RIGHT);
        } else if ("slide_from_left".equals(str)) {
            screen.setStackAnimation(Screen.StackAnimation.SLIDE_FROM_LEFT);
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
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Unknown presentation type ", str));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Screen createViewInstance(ThemedReactContext themedReactContext) {
        return new Screen(themedReactContext);
    }
}
