package com.facebook.react.modules.core;

import com.facebook.fbreact.specs.NativeTimingSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskEventListener;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.modules.core.ReactChoreographer;
import java.util.Iterator;
import okhttp3.internal.ws.RealWebSocket;

@ReactModule(name = TimingModule.NAME)
public final class TimingModule extends NativeTimingSpec implements LifecycleEventListener, HeadlessJsTaskEventListener {
    public static final String NAME = "Timing";
    public final JavaTimerManager mJavaTimerManager;

    public class BridgeTimerManager implements JavaScriptTimerManager {
        public BridgeTimerManager() {
        }
    }

    public TimingModule(ReactApplicationContext reactApplicationContext, DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        this.mJavaTimerManager = new JavaTimerManager(reactApplicationContext, new BridgeTimerManager(), ReactChoreographer.getInstance(), devSupportManager);
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void createTimer(double d, double d2, double d3, boolean z) {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        int i = (int) d;
        int i2 = (int) d2;
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        if (javaTimerManager != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = (long) d3;
            if (javaTimerManager.mDevSupportManager.getDevSupportEnabled() && Math.abs(j - currentTimeMillis) > RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS && (reactApplicationContextIfActiveOrWarn = TimingModule.this.getReactApplicationContextIfActiveOrWarn()) != null) {
                ((JSTimers) reactApplicationContextIfActiveOrWarn.getJSModule(JSTimers.class)).emitTimeDriftWarning("Debugger and device times have drifted by more than 60s. Please correct this by running adb shell \"date `date +%m%d%H%M%Y.%S`\" on your debugger machine.");
            }
            long max = Math.max(0L, (j - currentTimeMillis) + ((long) i2));
            if (i2 != 0 || z) {
                javaTimerManager.createTimer(i, max, z);
                return;
            }
            WritableArray createArray = Arguments.createArray();
            createArray.pushInt(i);
            ReactApplicationContext reactApplicationContextIfActiveOrWarn2 = TimingModule.this.getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn2 != null) {
                ((JSTimers) reactApplicationContextIfActiveOrWarn2.getJSModule(JSTimers.class)).callTimers(createArray);
                return;
            }
            return;
        }
        throw null;
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void deleteTimer(double d) {
        this.mJavaTimerManager.deleteTimer((int) d);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public boolean hasActiveTimersInRange(long j) {
        boolean z;
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        synchronized (javaTimerManager.mTimerGuard) {
            JavaTimerManager.Timer peek = javaTimerManager.mTimers.peek();
            if (peek == null) {
                return false;
            }
            if (!(!peek.mRepeat && ((long) peek.mInterval) < j)) {
                Iterator<JavaTimerManager.Timer> it = javaTimerManager.mTimers.iterator();
                while (it.hasNext()) {
                    JavaTimerManager.Timer next = it.next();
                    if (next.mRepeat || ((long) next.mInterval) >= j) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                    }
                }
                return false;
            }
            return true;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).mHeadlessJsTaskEventListeners.add(this);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        HeadlessJsTaskContext.getInstance(getReactApplicationContext()).mHeadlessJsTaskEventListeners.remove(this);
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.clearFrameCallback();
        if (javaTimerManager.mFrameIdleCallbackPosted) {
            javaTimerManager.mReactChoreographer.removeFrameCallback(ReactChoreographer.CallbackType.IDLE_EVENT, javaTimerManager.mIdleFrameCallback);
            javaTimerManager.mFrameIdleCallbackPosted = false;
        }
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskFinish(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskFinish();
    }

    @Override // com.facebook.react.jstasks.HeadlessJsTaskEventListener
    public void onHeadlessJsTaskStart(int i) {
        this.mJavaTimerManager.onHeadlessJsTaskStart();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.clearFrameCallback();
        javaTimerManager.maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.isPaused.set(true);
        javaTimerManager.clearFrameCallback();
        javaTimerManager.maybeIdleCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        JavaTimerManager javaTimerManager = this.mJavaTimerManager;
        javaTimerManager.isPaused.set(false);
        if (!javaTimerManager.mFrameCallbackPosted) {
            javaTimerManager.mReactChoreographer.postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, javaTimerManager.mTimerFrameCallback);
            javaTimerManager.mFrameCallbackPosted = true;
        }
        javaTimerManager.maybeSetChoreographerIdleCallback();
    }

    @Override // com.facebook.fbreact.specs.NativeTimingSpec
    public void setSendIdleEvents(boolean z) {
        this.mJavaTimerManager.setSendIdleEvents(z);
    }
}
