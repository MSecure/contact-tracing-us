package com.facebook.react.views.drawer;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.viewmanagers.AndroidDrawerLayoutManagerDelegate;
import com.facebook.react.views.drawer.events.DrawerClosedEvent;
import com.facebook.react.views.drawer.events.DrawerOpenedEvent;
import com.facebook.react.views.drawer.events.DrawerSlideEvent;
import com.facebook.react.views.drawer.events.DrawerStateChangedEvent;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;
import java.util.ArrayList;
import java.util.Map;

@ReactModule(name = ReactDrawerLayoutManager.REACT_CLASS)
public class ReactDrawerLayoutManager extends ViewGroupManager<ReactDrawerLayout> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    public final ViewManagerDelegate<ReactDrawerLayout> mDelegate = new AndroidDrawerLayoutManagerDelegate(this);

    public static class DrawerEventEmitter implements DrawerLayout.DrawerListener {
        public final DrawerLayout mDrawerLayout;
        public final EventDispatcher mEventDispatcher;

        public DrawerEventEmitter(DrawerLayout drawerLayout, EventDispatcher eventDispatcher) {
            this.mDrawerLayout = drawerLayout;
            this.mEventDispatcher = eventDispatcher;
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerClosed(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerClosedEvent(this.mDrawerLayout.getId()));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerOpened(View view) {
            this.mEventDispatcher.dispatchEvent(new DrawerOpenedEvent(this.mDrawerLayout.getId()));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerSlide(View view, float f) {
            this.mEventDispatcher.dispatchEvent(new DrawerSlideEvent(this.mDrawerLayout.getId(), f));
        }

        @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
        public void onDrawerStateChanged(int i) {
            this.mEventDispatcher.dispatchEvent(new DrawerStateChangedEvent(this.mDrawerLayout.getId(), i));
        }
    }

    private void setDrawerPositionInternal(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_LEFT)) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
        } else if (str.equals(RNGestureHandlerModule.KEY_HIT_SLOP_RIGHT)) {
            reactDrawerLayout.mDrawerPosition = 8388613;
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("drawerPosition must be 'left' or 'right', received", str));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("openDrawer", 1, "closeDrawer", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactDrawerLayout> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("topDrawerSlide", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDrawerSlide"), "topDrawerOpen", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDrawerOpen"), "topDrawerClose", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDrawerClose"), "topDrawerStateChanged", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onDrawerStateChanged"));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map getExportedViewConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("DrawerPosition", AppCompatDelegateImpl.ConfigurationImplApi17.of("Left", 8388611, "Right", 8388613));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren, com.facebook.react.uimanager.ViewGroupManager
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setDrawerBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    public void setKeyboardDismissMode(ReactDrawerLayout reactDrawerLayout, String str) {
    }

    public void setStatusBarBackgroundColor(ReactDrawerLayout reactDrawerLayout, Integer num) {
    }

    public void addEventEmitters(ThemedReactContext themedReactContext, ReactDrawerLayout reactDrawerLayout) {
        DrawerEventEmitter drawerEventEmitter = new DrawerEventEmitter(reactDrawerLayout, ((UIManagerModule) themedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher());
        if (reactDrawerLayout != null) {
            if (reactDrawerLayout.mListeners == null) {
                reactDrawerLayout.mListeners = new ArrayList();
            }
            reactDrawerLayout.mListeners.add(drawerEventEmitter);
            return;
        }
        throw null;
    }

    public void addView(ReactDrawerLayout reactDrawerLayout, View view, int i) {
        if (getChildCount(reactDrawerLayout) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        } else if (i == 0 || i == 1) {
            reactDrawerLayout.addView(view, i);
            reactDrawerLayout.setDrawerProperties();
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline6("The only valid indices for drawer's child are 0 or 1. Got ", i, " instead."));
        }
    }

    public void closeDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.closeDrawer();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactDrawerLayout createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactDrawerLayout(themedReactContext);
    }

    public void openDrawer(ReactDrawerLayout reactDrawerLayout) {
        reactDrawerLayout.openDrawer();
    }

    @ReactProp(name = "drawerLockMode")
    public void setDrawerLockMode(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null || "unlocked".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(0);
        } else if ("locked-closed".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(1);
        } else if ("locked-open".equals(str)) {
            reactDrawerLayout.setDrawerLockMode(2);
        } else {
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline10("Unknown drawerLockMode ", str));
        }
    }

    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, String str) {
        if (str == null) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
            return;
        }
        setDrawerPositionInternal(reactDrawerLayout, str);
    }

    @ReactProp(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, float f) {
        int i;
        if (Float.isNaN(f)) {
            i = -1;
        } else {
            i = Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
        }
        reactDrawerLayout.mDrawerWidth = i;
        reactDrawerLayout.setDrawerProperties();
    }

    public void setElevation(ReactDrawerLayout reactDrawerLayout, float f) {
        reactDrawerLayout.setDrawerElevation(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f));
    }

    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, int i, ReadableArray readableArray) {
        if (i == 1) {
            reactDrawerLayout.openDrawer();
        } else if (i == 2) {
            reactDrawerLayout.closeDrawer();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e  */
    public void receiveCommand(ReactDrawerLayout reactDrawerLayout, String str, ReadableArray readableArray) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode != -258774775) {
            if (hashCode == -83186725 && str.equals("openDrawer")) {
                c = 0;
                if (c == 0) {
                    reactDrawerLayout.openDrawer();
                    return;
                } else if (c == 1) {
                    reactDrawerLayout.closeDrawer();
                    return;
                } else {
                    return;
                }
            }
        } else if (str.equals("closeDrawer")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    @ReactProp(name = "drawerPosition")
    public void setDrawerPosition(ReactDrawerLayout reactDrawerLayout, Dynamic dynamic) {
        if (dynamic.isNull()) {
            reactDrawerLayout.mDrawerPosition = 8388611;
            reactDrawerLayout.setDrawerProperties();
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 == asInt || 8388613 == asInt) {
                reactDrawerLayout.mDrawerPosition = asInt;
                reactDrawerLayout.setDrawerProperties();
                return;
            }
            throw new JSApplicationIllegalArgumentException(GeneratedOutlineSupport.outline5("Unknown drawerPosition ", asInt));
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(reactDrawerLayout, dynamic.asString());
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    public void setDrawerWidth(ReactDrawerLayout reactDrawerLayout, Float f) {
        reactDrawerLayout.mDrawerWidth = f == null ? -1 : Math.round(AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(f.floatValue()));
        reactDrawerLayout.setDrawerProperties();
    }
}
