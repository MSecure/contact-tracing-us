package com.facebook.react.views.viewpager;

import android.view.View;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.AndroidViewPagerManagerDelegate;
import com.facebook.react.views.viewpager.ReactViewPager;
import java.util.Map;

@ReactModule(name = ReactViewPagerManager.REACT_CLASS)
public class ReactViewPagerManager extends ViewGroupManager<ReactViewPager> {
    public static final int COMMAND_SET_PAGE = 1;
    public static final int COMMAND_SET_PAGE_WITHOUT_ANIMATION = 2;
    public static final String REACT_CLASS = "AndroidViewPager";
    public final ViewManagerDelegate<ReactViewPager> mDelegate = new AndroidViewPagerManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("setPage", 1, "setPageWithoutAnimation", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ViewManagerDelegate<ReactViewPager> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return AppCompatDelegateImpl.ConfigurationImplApi17.of("topPageScroll", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onPageScroll"), "topPageScrollStateChanged", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onPageScrollStateChanged"), "topPageSelected", AppCompatDelegateImpl.ConfigurationImplApi17.of("registrationName", "onPageSelected"));
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.uimanager.ViewManager
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.IViewManagerWithChildren, com.facebook.react.uimanager.ViewGroupManager
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    public void setInitialPage(ReactViewPager reactViewPager, int i) {
    }

    public void setKeyboardDismissMode(ReactViewPager reactViewPager, String str) {
    }

    public void setPage(ReactViewPager reactViewPager, int i) {
    }

    public void setPageWithoutAnimation(ReactViewPager reactViewPager, int i) {
    }

    public void addView(ReactViewPager reactViewPager, View view, int i) {
        ReactViewPager.Adapter adapter = reactViewPager.getAdapter();
        adapter.mViews.add(i, view);
        adapter.notifyDataSetChanged();
        ReactViewPager.this.setOffscreenPageLimit(adapter.mViews.size());
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public ReactViewPager createViewInstance(ThemedReactContext themedReactContext) {
        return new ReactViewPager(themedReactContext);
    }

    public View getChildAt(ReactViewPager reactViewPager, int i) {
        return reactViewPager.getAdapter().mViews.get(i);
    }

    public int getChildCount(ReactViewPager reactViewPager) {
        return reactViewPager.getViewCountInAdapter();
    }

    public void removeViewAt(ReactViewPager reactViewPager, int i) {
        ReactViewPager.Adapter adapter = reactViewPager.getAdapter();
        adapter.mViews.remove(i);
        adapter.notifyDataSetChanged();
        ReactViewPager.this.setOffscreenPageLimit(adapter.mViews.size());
    }

    @ReactProp(defaultInt = 0, name = "pageMargin")
    public void setPageMargin(ReactViewPager reactViewPager, int i) {
        reactViewPager.setPageMargin((int) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP((float) i));
    }

    @ReactProp(defaultBoolean = false, name = "peekEnabled")
    public void setPeekEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setClipToPadding(!z);
    }

    @ReactProp(defaultBoolean = true, name = "scrollEnabled")
    public void setScrollEnabled(ReactViewPager reactViewPager, boolean z) {
        reactViewPager.setScrollEnabled(z);
    }

    public void receiveCommand(ReactViewPager reactViewPager, int i, ReadableArray readableArray) {
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactViewPager);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray);
        if (i == 1) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
        } else if (i == 2) {
            reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
        } else {
            throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", Integer.valueOf(i), ReactViewPagerManager.class.getSimpleName()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
    public void receiveCommand(ReactViewPager reactViewPager, String str, ReadableArray readableArray) {
        char c;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactViewPager);
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(readableArray);
        int hashCode = str.hashCode();
        if (hashCode != -445763635) {
            if (hashCode == 1984860689 && str.equals("setPage")) {
                c = 0;
                if (c == 0) {
                    reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), true);
                    return;
                } else if (c == 1) {
                    reactViewPager.setCurrentItemFromJs(readableArray.getInt(0), false);
                    return;
                } else {
                    throw new IllegalArgumentException(String.format("Unsupported command %d received by %s.", str, ReactViewPagerManager.class.getSimpleName()));
                }
            }
        } else if (str.equals("setPageWithoutAnimation")) {
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }
}
