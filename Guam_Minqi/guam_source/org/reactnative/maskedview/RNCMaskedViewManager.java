package org.reactnative.maskedview;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

public class RNCMaskedViewManager extends ViewGroupManager<RNCMaskedView> {
    public static final String REACT_CLASS = "RNCMaskedView";

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNCMaskedView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNCMaskedView(themedReactContext);
    }
}
