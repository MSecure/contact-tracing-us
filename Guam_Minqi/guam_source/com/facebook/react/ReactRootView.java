package com.facebook.react;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Trace;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.JSTouchDispatcher;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.gesturehandler.react.RNGestureHandlerModule;

public class ReactRootView extends FrameLayout implements RootView, ReactRoot {
    public final ReactAndroidHWInputDeviceHelper mAndroidHWInputDeviceHelper = new ReactAndroidHWInputDeviceHelper(this);
    public Bundle mAppProperties;
    public CustomGlobalLayoutListener mCustomGlobalLayoutListener;
    public int mHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
    public String mInitialUITemplate;
    public boolean mIsAttachedToInstance;
    public String mJSModuleName;
    public JSTouchDispatcher mJSTouchDispatcher;
    public int mLastHeight = 0;
    public int mLastWidth = 0;
    public ReactInstanceManager mReactInstanceManager;
    public ReactRootViewEventListener mRootViewEventListener;
    public int mRootViewTag;
    public boolean mShouldLogContentAppeared;
    public int mUIManagerType = 1;
    public final boolean mUseSurface = false;
    public boolean mWasMeasured = false;
    public int mWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);

    public class CustomGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {
        public int mDeviceRotation = 0;
        public int mKeyboardHeight = 0;
        public final int mMinKeyboardHeightDetected;
        public final Rect mVisibleViewArea;

        public CustomGlobalLayoutListener() {
            AppCompatDelegateImpl.ConfigurationImplApi17.initDisplayMetricsIfNotInitialized(ReactRootView.this.getContext().getApplicationContext());
            this.mVisibleViewArea = new Rect();
            this.mMinKeyboardHeightDetected = (int) AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(60.0f);
        }

        public final WritableMap createKeyboardEventPayload(double d, double d2, double d3, double d4) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_HEIGHT, d4);
            createMap2.putDouble("screenX", d2);
            createMap2.putDouble(RNGestureHandlerModule.KEY_HIT_SLOP_WIDTH, d3);
            createMap2.putDouble("screenY", d);
            createMap.putMap("endCoordinates", createMap2);
            createMap.putString("easing", "keyboard");
            createMap.putDouble("duration", 0.0d);
            return createMap;
        }

        public void onGlobalLayout() {
            String str;
            double d;
            String str2;
            ReactRootView reactRootView = ReactRootView.this;
            ReactInstanceManager reactInstanceManager = reactRootView.mReactInstanceManager;
            if (reactInstanceManager != null && reactRootView.mIsAttachedToInstance && reactInstanceManager.getCurrentReactContext() != null) {
                ReactRootView.this.getRootView().getWindowVisibleDisplayFrame(this.mVisibleViewArea);
                int i = AppCompatDelegateImpl.ConfigurationImplApi17.sWindowDisplayMetrics.heightPixels - this.mVisibleViewArea.bottom;
                boolean z = true;
                if (this.mKeyboardHeight != i && i > this.mMinKeyboardHeightDetected) {
                    this.mKeyboardHeight = i;
                    ReactRootView.this.sendEvent("keyboardDidShow", createKeyboardEventPayload((double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mVisibleViewArea.bottom), (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mVisibleViewArea.left), (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mVisibleViewArea.width()), (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mKeyboardHeight)));
                } else {
                    if (this.mKeyboardHeight != 0 && i <= this.mMinKeyboardHeightDetected) {
                        this.mKeyboardHeight = 0;
                        ReactRootView.this.sendEvent("keyboardDidHide", createKeyboardEventPayload((double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mVisibleViewArea.height()), 0.0d, (double) AppCompatDelegateImpl.ConfigurationImplApi17.toDIPFromPixel((float) this.mVisibleViewArea.width()), 0.0d));
                    }
                }
                int rotation = ((WindowManager) ReactRootView.this.getContext().getSystemService("window")).getDefaultDisplay().getRotation();
                if (this.mDeviceRotation != rotation) {
                    this.mDeviceRotation = rotation;
                    if (rotation != 0) {
                        if (rotation == 1) {
                            d = -90.0d;
                            str = "landscape-primary";
                        } else if (rotation == 2) {
                            d = 180.0d;
                            str2 = "portrait-secondary";
                        } else if (rotation == 3) {
                            d = 90.0d;
                            str = "landscape-secondary";
                        }
                        WritableMap createMap = Arguments.createMap();
                        createMap.putString("name", str);
                        createMap.putDouble("rotationDegrees", d);
                        createMap.putBoolean("isLandscape", z);
                        ReactRootView.this.sendEvent("namedOrientationDidChange", createMap);
                    } else {
                        d = 0.0d;
                        str2 = "portrait-primary";
                    }
                    z = false;
                    str = str2;
                    WritableMap createMap2 = Arguments.createMap();
                    createMap2.putString("name", str);
                    createMap2.putDouble("rotationDegrees", d);
                    createMap2.putBoolean("isLandscape", z);
                    ReactRootView.this.sendEvent("namedOrientationDidChange", createMap2);
                }
                ((DeviceInfoModule) ReactRootView.this.mReactInstanceManager.getCurrentReactContext().getNativeModule(DeviceInfoModule.class)).emitUpdateDimensionsEvent();
            }
        }
    }

    public interface ReactRootViewEventListener {
        void onAttachedToReactInstance(ReactRootView reactRootView);
    }

    public ReactRootView(Context context) {
        super(context);
        setClipChildren(false);
    }

    private CustomGlobalLayoutListener getCustomGlobalLayoutListener() {
        if (this.mCustomGlobalLayoutListener == null) {
            this.mCustomGlobalLayoutListener = new CustomGlobalLayoutListener();
        }
        return this.mCustomGlobalLayoutListener;
    }

    public final void attachToReactInstanceManager() {
        Trace.beginSection("attachToReactInstanceManager");
        if (!this.mIsAttachedToInstance) {
            try {
                this.mIsAttachedToInstance = true;
                ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(reactInstanceManager);
                ReactInstanceManager reactInstanceManager2 = reactInstanceManager;
                UiThreadUtil.assertOnUiThread();
                reactInstanceManager2.mAttachedReactRoots.add(this);
                getRootViewGroup().removeAllViews();
                getRootViewGroup().setId(-1);
                ReactContext currentReactContext = reactInstanceManager2.getCurrentReactContext();
                if (reactInstanceManager2.mCreateReactContextThread == null && currentReactContext != null) {
                    reactInstanceManager2.attachRootViewToInstance(this);
                }
                getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
                Trace.endSection();
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    public void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (StackOverflowError e) {
            handleException(e);
        }
    }

    public final void dispatchJSTouchEvent(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            this.mJSTouchDispatcher.handleTouchEvent(motionEvent, ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher());
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w("ReactRootView", "Unable to handle key event as the catalyst instance has not been attached");
            return super.dispatchKeyEvent(keyEvent);
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        if (reactAndroidHWInputDeviceHelper != null) {
            int keyCode = keyEvent.getKeyCode();
            int action = keyEvent.getAction();
            if ((action == 1 || action == 0) && ReactAndroidHWInputDeviceHelper.KEY_EVENTS_ACTIONS.containsKey(Integer.valueOf(keyCode))) {
                reactAndroidHWInputDeviceHelper.dispatchEvent(ReactAndroidHWInputDeviceHelper.KEY_EVENTS_ACTIONS.get(Integer.valueOf(keyCode)), reactAndroidHWInputDeviceHelper.mLastFocusedViewId, action);
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        throw null;
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        super.finalize();
        AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(!this.mIsAttachedToInstance, "The application this ReactRootView was rendering was not unmounted before the ReactRootView was garbage collected. This usually means that your application is leaking large amounts of memory. To solve this, make sure to call ReactRootView#unmountReactApplication in the onDestroy() of your hosting Activity or in the onDestroyView() of your hosting Fragment.");
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public Bundle getAppProperties() {
        return this.mAppProperties;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getHeightMeasureSpec() {
        return this.mHeightMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public String getInitialUITemplate() {
        return this.mInitialUITemplate;
    }

    public String getJSModuleName() {
        String str = this.mJSModuleName;
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(str);
        return str;
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactInstanceManager;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public ViewGroup getRootViewGroup() {
        return this;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getRootViewTag() {
        return this.mRootViewTag;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public String getSurfaceID() {
        Bundle appProperties = getAppProperties();
        if (appProperties != null) {
            return appProperties.getString("surfaceID");
        }
        return null;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getUIManagerType() {
        return this.mUIManagerType;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public int getWidthMeasureSpec() {
        return this.mWidthMeasureSpec;
    }

    @Override // com.facebook.react.uimanager.RootView
    public void handleException(Throwable th) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || reactInstanceManager.getCurrentReactContext() == null) {
            throw new RuntimeException(th);
        }
        this.mReactInstanceManager.getCurrentReactContext().handleException(new IllegalViewOperationException(th.getMessage(), this, th));
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mIsAttachedToInstance) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
            getViewTreeObserver().addOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    @Override // com.facebook.react.uimanager.RootView
    public void onChildStartedNativeGesture(MotionEvent motionEvent) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w("ReactRootView", "Unable to dispatch touch to JS as the catalyst instance has not been attached");
        } else if (this.mJSTouchDispatcher == null) {
            FLog.w("ReactRootView", "Unable to dispatch touch to JS before the dispatcher is available");
        } else {
            EventDispatcher eventDispatcher = ((UIManagerModule) this.mReactInstanceManager.getCurrentReactContext().getNativeModule(UIManagerModule.class)).getEventDispatcher();
            JSTouchDispatcher jSTouchDispatcher = this.mJSTouchDispatcher;
            if (!jSTouchDispatcher.mChildIsHandlingNativeGesture) {
                jSTouchDispatcher.dispatchCancelEvent(motionEvent, eventDispatcher);
                jSTouchDispatcher.mChildIsHandlingNativeGesture = true;
                jSTouchDispatcher.mTargetTag = -1;
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mIsAttachedToInstance) {
            getViewTreeObserver().removeOnGlobalLayoutListener(getCustomGlobalLayoutListener());
        }
    }

    public void onFocusChanged(boolean z, int i, Rect rect) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w("ReactRootView", "Unable to handle focus changed event as the catalyst instance has not been attached");
            super.onFocusChanged(z, i, rect);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        int i2 = reactAndroidHWInputDeviceHelper.mLastFocusedViewId;
        if (i2 != -1) {
            reactAndroidHWInputDeviceHelper.dispatchEvent("blur", i2, -1);
        }
        reactAndroidHWInputDeviceHelper.mLastFocusedViewId = -1;
        super.onFocusChanged(z, i, rect);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mUseSurface) {
            super.onLayout(z, i, i2, i3, i4);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0027 A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0037 A[Catch:{ all -> 0x00b2 }, LOOP:0: B:19:0x0031->B:21:0x0037, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006a A[Catch:{ all -> 0x00b2 }, LOOP:1: B:28:0x0064->B:30:0x006a, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0091 A[Catch:{ all -> 0x00b2 }] */
    public void onMeasure(int i, int i2) {
        boolean z;
        int mode;
        int i3;
        int mode2;
        int i4;
        int i5;
        if (this.mUseSurface) {
            super.onMeasure(i, i2);
            return;
        }
        Trace.beginSection("ReactRootView.onMeasure");
        try {
            if (i == this.mWidthMeasureSpec) {
                if (i2 == this.mHeightMeasureSpec) {
                    z = false;
                    this.mWidthMeasureSpec = i;
                    this.mHeightMeasureSpec = i2;
                    mode = View.MeasureSpec.getMode(i);
                    if (mode != Integer.MIN_VALUE) {
                        if (mode != 0) {
                            i3 = View.MeasureSpec.getSize(i);
                            mode2 = View.MeasureSpec.getMode(i2);
                            if (mode2 != Integer.MIN_VALUE) {
                                if (mode2 != 0) {
                                    i4 = View.MeasureSpec.getSize(i2);
                                    setMeasuredDimension(i3, i4);
                                    this.mWasMeasured = true;
                                    if (this.mReactInstanceManager == null && !this.mIsAttachedToInstance) {
                                        attachToReactInstanceManager();
                                    } else if (!(!z && this.mLastWidth == i3 && this.mLastHeight == i4)) {
                                        updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                                    }
                                    this.mLastWidth = i3;
                                    this.mLastHeight = i4;
                                }
                            }
                            i4 = 0;
                            for (int i6 = 0; i6 < getChildCount(); i6++) {
                                View childAt = getChildAt(i6);
                                i4 = Math.max(i4, childAt.getTop() + childAt.getMeasuredHeight() + childAt.getPaddingTop() + childAt.getPaddingBottom());
                            }
                            setMeasuredDimension(i3, i4);
                            this.mWasMeasured = true;
                            if (this.mReactInstanceManager == null) {
                            }
                            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                            this.mLastWidth = i3;
                            this.mLastHeight = i4;
                        }
                    }
                    i3 = 0;
                    for (i5 = 0; i5 < getChildCount(); i5++) {
                        View childAt2 = getChildAt(i5);
                        i3 = Math.max(i3, childAt2.getLeft() + childAt2.getMeasuredWidth() + childAt2.getPaddingLeft() + childAt2.getPaddingRight());
                    }
                    mode2 = View.MeasureSpec.getMode(i2);
                    if (mode2 != Integer.MIN_VALUE) {
                    }
                    i4 = 0;
                    while (i6 < getChildCount()) {
                    }
                    setMeasuredDimension(i3, i4);
                    this.mWasMeasured = true;
                    if (this.mReactInstanceManager == null) {
                    }
                    updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                    this.mLastWidth = i3;
                    this.mLastHeight = i4;
                }
            }
            z = true;
            this.mWidthMeasureSpec = i;
            this.mHeightMeasureSpec = i2;
            mode = View.MeasureSpec.getMode(i);
            if (mode != Integer.MIN_VALUE) {
            }
            i3 = 0;
            while (i5 < getChildCount()) {
            }
            mode2 = View.MeasureSpec.getMode(i2);
            if (mode2 != Integer.MIN_VALUE) {
            }
            i4 = 0;
            while (i6 < getChildCount()) {
            }
            setMeasuredDimension(i3, i4);
            this.mWasMeasured = true;
            if (this.mReactInstanceManager == null) {
            }
            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
            this.mLastWidth = i3;
            this.mLastHeight = i4;
        } finally {
            Trace.endSection();
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void onStage(int i) {
        if (i == 101) {
            this.mJSTouchDispatcher = new JSTouchDispatcher(this);
            ReactRootViewEventListener reactRootViewEventListener = this.mRootViewEventListener;
            if (reactRootViewEventListener != null) {
                reactRootViewEventListener.onAttachedToReactInstance(this);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        dispatchJSTouchEvent(motionEvent);
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (this.mShouldLogContentAppeared) {
            this.mShouldLogContentAppeared = false;
            String str = this.mJSModuleName;
            if (str != null) {
                ReactMarker.logMarker(ReactMarkerConstants.CONTENT_APPEARED, str, this.mRootViewTag);
            }
        }
    }

    public void requestChildFocus(View view, View view2) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null || !this.mIsAttachedToInstance || reactInstanceManager.getCurrentReactContext() == null) {
            FLog.w("ReactRootView", "Unable to handle child focus changed event as the catalyst instance has not been attached");
            super.requestChildFocus(view, view2);
            return;
        }
        ReactAndroidHWInputDeviceHelper reactAndroidHWInputDeviceHelper = this.mAndroidHWInputDeviceHelper;
        if (reactAndroidHWInputDeviceHelper.mLastFocusedViewId != view2.getId()) {
            int i = reactAndroidHWInputDeviceHelper.mLastFocusedViewId;
            if (i != -1) {
                reactAndroidHWInputDeviceHelper.dispatchEvent("blur", i, -1);
            }
            reactAndroidHWInputDeviceHelper.mLastFocusedViewId = view2.getId();
            reactAndroidHWInputDeviceHelper.dispatchEvent("focus", view2.getId(), -1);
        }
        super.requestChildFocus(view, view2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void runApplication() {
        Trace.beginSection("ReactRootView.runApplication");
        try {
            if (this.mReactInstanceManager != null) {
                if (this.mIsAttachedToInstance) {
                    ReactContext currentReactContext = this.mReactInstanceManager.getCurrentReactContext();
                    if (currentReactContext == null) {
                        Trace.endSection();
                        return;
                    }
                    CatalystInstance catalystInstance = currentReactContext.getCatalystInstance();
                    String jSModuleName = getJSModuleName();
                    if (!this.mUseSurface) {
                        if (this.mWasMeasured) {
                            updateRootLayoutSpecs(this.mWidthMeasureSpec, this.mHeightMeasureSpec);
                        }
                        WritableNativeMap writableNativeMap = new WritableNativeMap();
                        writableNativeMap.putDouble("rootTag", (double) getRootViewTag());
                        Bundle appProperties = getAppProperties();
                        if (appProperties != null) {
                            writableNativeMap.putMap("initialProps", Arguments.fromBundle(appProperties));
                        }
                        this.mShouldLogContentAppeared = true;
                        FLog.e("ReactRootView", "runApplication: call AppRegistry.runApplication");
                        ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).runApplication(jSModuleName, writableNativeMap);
                    }
                    Trace.endSection();
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    public void sendEvent(String str, WritableMap writableMap) {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactInstanceManager.getCurrentReactContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        }
    }

    public void setAppProperties(Bundle bundle) {
        UiThreadUtil.assertOnUiThread();
        this.mAppProperties = bundle;
        if (getRootViewTag() != 0) {
            runApplication();
        }
    }

    public void setEventListener(ReactRootViewEventListener reactRootViewEventListener) {
        this.mRootViewEventListener = reactRootViewEventListener;
    }

    public void setIsFabric(boolean z) {
        this.mUIManagerType = z ? 2 : 1;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setRootViewTag(int i) {
        this.mRootViewTag = i;
    }

    @Override // com.facebook.react.uimanager.ReactRoot
    public void setShouldLogContentAppeared(boolean z) {
        this.mShouldLogContentAppeared = z;
    }

    public void startReactApplication(ReactInstanceManager reactInstanceManager, String str, Bundle bundle) {
        Trace.beginSection("startReactApplication");
        try {
            UiThreadUtil.assertOnUiThread();
            AppCompatDelegateImpl.ConfigurationImplApi17.assertCondition(this.mReactInstanceManager == null, "This root view has already been attached to a catalyst instance manager");
            this.mReactInstanceManager = reactInstanceManager;
            this.mJSModuleName = str;
            this.mAppProperties = bundle;
            this.mInitialUITemplate = null;
            reactInstanceManager.createReactContextInBackground();
            attachToReactInstanceManager();
        } finally {
            Trace.endSection();
        }
    }

    public void unmountReactApplication() {
        UiThreadUtil.assertOnUiThread();
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null && this.mIsAttachedToInstance) {
            if (reactInstanceManager != null) {
                UiThreadUtil.assertOnUiThread();
                synchronized (reactInstanceManager.mAttachedReactRoots) {
                    if (reactInstanceManager.mAttachedReactRoots.contains(this)) {
                        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                        reactInstanceManager.mAttachedReactRoots.remove(this);
                        if (currentReactContext != null && currentReactContext.hasActiveCatalystInstance()) {
                            reactInstanceManager.detachViewFromInstance(this, currentReactContext.getCatalystInstance());
                        }
                    }
                }
                this.mIsAttachedToInstance = false;
            } else {
                throw null;
            }
        }
        this.mReactInstanceManager = null;
        this.mShouldLogContentAppeared = false;
    }

    public final void updateRootLayoutSpecs(int i, int i2) {
        UIManager uIManager;
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager == null) {
            FLog.w("ReactRootView", "Unable to update root layout specs for uninitialized ReactInstanceManager");
            return;
        }
        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
        if (currentReactContext != null && (uIManager = ReactYogaConfigProvider.getUIManager(currentReactContext, getUIManagerType())) != null) {
            uIManager.updateRootLayoutSpecs(getRootViewTag(), i, i2);
        }
    }
}
