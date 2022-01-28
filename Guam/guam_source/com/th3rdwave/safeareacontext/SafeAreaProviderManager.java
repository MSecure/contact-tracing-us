package com.th3rdwave.safeareacontext;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.MapBuilder$Builder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.horcrux.svg.PathParser;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import com.th3rdwave.safeareacontext.SafeAreaProvider;
import java.util.Map;

public class SafeAreaProviderManager extends ViewGroupManager<SafeAreaProvider> {
    public final ReactApplicationContext mContext;

    public SafeAreaProviderManager(ReactApplicationContext reactApplicationContext) {
        this.mContext = reactApplicationContext;
    }

    private Map<String, Object> getInitialWindowMetrics() {
        ViewGroup viewGroup;
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity == null || (viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView()) == null) {
            return null;
        }
        View findViewById = viewGroup.findViewById(16908290);
        EdgeInsets safeAreaInsets = PathParser.getSafeAreaInsets(viewGroup);
        Rect frame = PathParser.getFrame(viewGroup, findViewById);
        if (safeAreaInsets == null || frame == null) {
            return null;
        }
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("insets", AppCompatDelegateImpl.ConfigurationImplApi17.of(RNGestureHandlerModule.KEY_HIT_SLOP_TOP, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(safeAreaInsets.top)), RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(safeAreaInsets.right)), RNGestureHandlerModule.KEY_HIT_SLOP_BOTTOM, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(safeAreaInsets.bottom)), RNGestureHandlerModule.KEY_HIT_SLOP_LEFT, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(safeAreaInsets.left))), "frame", AppCompatDelegateImpl.ConfigurationImplApi17.of("x", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(frame.x)), "y", Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(frame.y)), RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(frame.width)), RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, Float.valueOf(AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel(frame.height))));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder$Builder builder = AppCompatDelegateImpl.ConfigurationImplApi17.builder();
        builder.put("topInsetsChange", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onInsetsChange"));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedViewConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("initialWindowMetrics", getInitialWindowMetrics());
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return "RNCSafeAreaProvider";
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, SafeAreaProvider safeAreaProvider) {
        final EventDispatcher eventDispatcher = ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        safeAreaProvider.setOnInsetsChangeListener(new SafeAreaProvider.OnInsetsChangeListener(this) {
            /* class com.th3rdwave.safeareacontext.SafeAreaProviderManager.AnonymousClass1 */

            @Override // com.th3rdwave.safeareacontext.SafeAreaProvider.OnInsetsChangeListener
            public void onInsetsChange(SafeAreaProvider safeAreaProvider, EdgeInsets edgeInsets, Rect rect) {
                eventDispatcher.dispatchEvent(new InsetsChangeEvent(safeAreaProvider.getId(), edgeInsets, rect));
            }
        });
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public SafeAreaProvider createViewInstance(ThemedReactContext themedReactContext) {
        return new SafeAreaProvider(themedReactContext);
    }
}
