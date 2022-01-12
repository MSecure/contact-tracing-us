package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name = ScreenStackViewManager.REACT_CLASS)
public class ScreenStackViewManager extends ViewGroupManager<ScreenStack> {
    public static final String REACT_CLASS = "RNSScreenStack";

    private void prepareOutTransition(Screen screen) {
        startTransitionRecursive(screen);
    }

    private void startTransitionRecursive(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            viewGroup.startViewTransition(childAt);
            if (childAt instanceof ViewGroup) {
                startTransitionRecursive((ViewGroup) childAt);
            }
        }
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren, com.facebook.react.uimanager.ViewGroupManager
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void addView(ScreenStack screenStack, View view, int i) {
        if (view instanceof Screen) {
            Screen screen = (Screen) view;
            if (screenStack != null) {
                ScreenStackFragment screenStackFragment = new ScreenStackFragment(screen);
                screen.setFragment(screenStackFragment);
                screenStack.mScreenFragments.add(i, screenStackFragment);
                screen.setContainer(screenStack);
                screenStack.markUpdated();
                return;
            }
            throw null;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreen");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ScreenStack createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenStack(themedReactContext);
    }

    public View getChildAt(ScreenStack screenStack, int i) {
        return screenStack.mScreenFragments.get(i).mScreenView;
    }

    public int getChildCount(ScreenStack screenStack) {
        return screenStack.getScreenCount();
    }

    public void removeViewAt(ScreenStack screenStack, int i) {
        prepareOutTransition(screenStack.mScreenFragments.get(i).mScreenView);
        screenStack.removeScreenAt(i);
    }
}
