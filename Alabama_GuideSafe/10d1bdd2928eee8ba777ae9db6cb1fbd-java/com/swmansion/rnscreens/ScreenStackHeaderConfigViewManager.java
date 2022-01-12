package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

@ReactModule(name = ScreenStackHeaderConfigViewManager.REACT_CLASS)
public class ScreenStackHeaderConfigViewManager extends ViewGroupManager<ScreenStackHeaderConfig> {
    public static final String REACT_CLASS = "RNSScreenStackHeaderConfig";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren, com.facebook.react.uimanager.ViewGroupManager
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @ReactProp(name = "backButtonInCustomView")
    public void setBackButtonInCustomView(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setBackButtonInCustomView(z);
    }

    @ReactProp(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(ScreenStackHeaderConfig screenStackHeaderConfig, Integer num) {
        screenStackHeaderConfig.setBackgroundColor(num);
    }

    @ReactProp(customType = "Color", name = "color")
    public void setColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.setTintColor(i);
    }

    @ReactProp(name = RNGestureHandlerModule.KEY_DIRECTION)
    public void setDirection(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        screenStackHeaderConfig.setDirection(str);
    }

    @ReactProp(name = "hidden")
    public void setHidden(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHidden(z);
    }

    @ReactProp(name = "hideBackButton")
    public void setHideBackButton(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHideBackButton(z);
    }

    @ReactProp(name = "hideShadow")
    public void setHideShadow(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setHideShadow(z);
    }

    @ReactProp(name = DialogModule.KEY_TITLE)
    public void setTitle(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        screenStackHeaderConfig.setTitle(str);
    }

    @ReactProp(customType = "Color", name = "titleColor")
    public void setTitleColor(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.setTitleColor(i);
    }

    @ReactProp(name = "titleFontFamily")
    public void setTitleFontFamily(ScreenStackHeaderConfig screenStackHeaderConfig, String str) {
        screenStackHeaderConfig.setTitleFontFamily(str);
    }

    @ReactProp(name = "titleFontSize")
    public void setTitleFontSize(ScreenStackHeaderConfig screenStackHeaderConfig, float f) {
        screenStackHeaderConfig.setTitleFontSize(f);
    }

    @ReactProp(name = "topInsetEnabled")
    public void setTopInsetEnabled(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setTopInsetEnabled(z);
    }

    @ReactProp(name = "translucent")
    public void setTranslucent(ScreenStackHeaderConfig screenStackHeaderConfig, boolean z) {
        screenStackHeaderConfig.setTranslucent(z);
    }

    public void addView(ScreenStackHeaderConfig screenStackHeaderConfig, View view, int i) {
        if (view instanceof ScreenStackHeaderSubview) {
            screenStackHeaderConfig.mConfigSubviews.add(i, (ScreenStackHeaderSubview) view);
            screenStackHeaderConfig.maybeUpdate();
            return;
        }
        throw new JSApplicationCausedNativeException("Config children should be of type RNSScreenStackHeaderSubview");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStackHeaderConfig createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenStackHeaderConfig(themedReactContext);
    }

    public View getChildAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        return screenStackHeaderConfig.mConfigSubviews.get(i);
    }

    public int getChildCount(ScreenStackHeaderConfig screenStackHeaderConfig) {
        return screenStackHeaderConfig.getConfigSubviewsCount();
    }

    public void onAfterUpdateTransaction(ScreenStackHeaderConfig screenStackHeaderConfig) {
        super.onAfterUpdateTransaction((View) screenStackHeaderConfig);
        screenStackHeaderConfig.onUpdate();
    }

    public void onDropViewInstance(ScreenStackHeaderConfig screenStackHeaderConfig) {
        screenStackHeaderConfig.mDestroyed = true;
    }

    public void removeAllViews(ScreenStackHeaderConfig screenStackHeaderConfig) {
        screenStackHeaderConfig.mConfigSubviews.clear();
        screenStackHeaderConfig.maybeUpdate();
    }

    public void removeViewAt(ScreenStackHeaderConfig screenStackHeaderConfig, int i) {
        screenStackHeaderConfig.mConfigSubviews.remove(i);
        screenStackHeaderConfig.maybeUpdate();
    }
}
