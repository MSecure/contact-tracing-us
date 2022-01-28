package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name = ScreenContainerViewManager.REACT_CLASS)
public class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> {
    public static final String REACT_CLASS = "RNSScreenContainer";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren, com.facebook.react.uimanager.ViewGroupManager
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void addView(ScreenContainer screenContainer, View view, int i) {
        if (view instanceof Screen) {
            Screen screen = (Screen) view;
            ScreenFragment adapt = screenContainer.adapt(screen);
            screen.setFragment(adapt);
            screenContainer.mScreenFragments.add(i, adapt);
            screen.setContainer(screenContainer);
            screenContainer.markUpdated();
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenContainer createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenContainer(themedReactContext);
    }

    public View getChildAt(ScreenContainer screenContainer, int i) {
        return screenContainer.mScreenFragments.get(i).mScreenView;
    }

    public int getChildCount(ScreenContainer screenContainer) {
        return screenContainer.getScreenCount();
    }

    public void removeAllViews(ScreenContainer screenContainer) {
        screenContainer.removeAllScreens();
    }

    public void removeViewAt(ScreenContainer screenContainer, int i) {
        screenContainer.removeScreenAt(i);
    }
}
