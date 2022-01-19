package com.facebook.react.modules.debug;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.TreeMap;

public class FpsDebugFrameCallback extends ChoreographerCompat.FrameCallback {
    public int m4PlusFrameStutters = 0;
    public ChoreographerCompat mChoreographer;
    public final DidJSUpdateUiDuringFrameDetector mDidJSUpdateUiDuringFrameDetector;
    public int mExpectedNumFramesPrev = 0;
    public long mFirstFrameTime = -1;
    public boolean mIsRecordingFpsInfoAtEachFrame = false;
    public long mLastFrameTime = -1;
    public int mNumFrameCallbacks = 0;
    public int mNumFrameCallbacksWithBatchDispatches = 0;
    public final ReactContext mReactContext;
    public boolean mShouldStop = false;
    public TreeMap<Long, FpsInfo> mTimeToFps;
    public final UIManagerModule mUIManagerModule;

    public static class FpsInfo {
        public final double fps;
        public final double jsFps;
        public final int totalExpectedFrames;
        public final int totalFrames;
        public final int totalJsFrames;
        public final int totalTimeMs;

        public FpsInfo(int i, int i2, int i3, int i4, double d, double d2, int i5) {
            this.totalFrames = i;
            this.totalJsFrames = i2;
            this.totalExpectedFrames = i3;
            this.fps = d;
            this.jsFps = d2;
            this.totalTimeMs = i5;
        }
    }

    public FpsDebugFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
        this.mUIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.mDidJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0047, code lost:
        if (com.facebook.react.modules.debug.DidJSUpdateUiDuringFrameDetector.hasEventBetweenTimestamps(r4.mViewHierarchyUpdateEnqueuedEvents, r0, r14) == false) goto L_0x0049;
     */
    @Override // com.facebook.react.modules.core.ChoreographerCompat.FrameCallback
    public void doFrame(long j) {
        boolean z;
        if (!this.mShouldStop) {
            if (this.mFirstFrameTime == -1) {
                this.mFirstFrameTime = j;
            }
            long j2 = this.mLastFrameTime;
            this.mLastFrameTime = j;
            DidJSUpdateUiDuringFrameDetector didJSUpdateUiDuringFrameDetector = this.mDidJSUpdateUiDuringFrameDetector;
            synchronized (didJSUpdateUiDuringFrameDetector) {
                boolean hasEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetector.hasEventBetweenTimestamps(didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateFinishedEvents, j2, j);
                long lastEventBetweenTimestamps = DidJSUpdateUiDuringFrameDetector.getLastEventBetweenTimestamps(didJSUpdateUiDuringFrameDetector.mTransitionToIdleEvents, j2, j);
                long lastEventBetweenTimestamps2 = DidJSUpdateUiDuringFrameDetector.getLastEventBetweenTimestamps(didJSUpdateUiDuringFrameDetector.mTransitionToBusyEvents, j2, j);
                z = false;
                boolean z2 = (lastEventBetweenTimestamps == -1 && lastEventBetweenTimestamps2 == -1) ? didJSUpdateUiDuringFrameDetector.mWasIdleAtEndOfLastFrame : lastEventBetweenTimestamps > lastEventBetweenTimestamps2;
                if (!hasEventBetweenTimestamps) {
                    if (z2) {
                    }
                    DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mTransitionToIdleEvents, j);
                    DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mTransitionToBusyEvents, j);
                    DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateEnqueuedEvents, j);
                    DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateFinishedEvents, j);
                    didJSUpdateUiDuringFrameDetector.mWasIdleAtEndOfLastFrame = z2;
                }
                z = true;
                DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mTransitionToIdleEvents, j);
                DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mTransitionToBusyEvents, j);
                DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateEnqueuedEvents, j);
                DidJSUpdateUiDuringFrameDetector.cleanUp(didJSUpdateUiDuringFrameDetector.mViewHierarchyUpdateFinishedEvents, j);
                didJSUpdateUiDuringFrameDetector.mWasIdleAtEndOfLastFrame = z2;
            }
            if (z) {
                this.mNumFrameCallbacksWithBatchDispatches++;
            }
            this.mNumFrameCallbacks++;
            int expectedNumFrames = getExpectedNumFrames();
            if ((expectedNumFrames - this.mExpectedNumFramesPrev) - 1 >= 4) {
                this.m4PlusFrameStutters++;
            }
            if (this.mIsRecordingFpsInfoAtEachFrame) {
                AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(this.mTimeToFps);
                this.mTimeToFps.put(Long.valueOf(System.currentTimeMillis()), new FpsInfo(this.mNumFrameCallbacks - 1, this.mNumFrameCallbacksWithBatchDispatches - 1, expectedNumFrames, this.m4PlusFrameStutters, getFPS(), getJSFPS(), ((int) (((double) this.mLastFrameTime) - ((double) this.mFirstFrameTime))) / 1000000));
            }
            this.mExpectedNumFramesPrev = expectedNumFrames;
            ChoreographerCompat choreographerCompat = this.mChoreographer;
            if (choreographerCompat != null) {
                choreographerCompat.postFrameCallback(this);
            }
        }
    }

    public int getExpectedNumFrames() {
        return (int) ((((double) (((int) (((double) this.mLastFrameTime) - ((double) this.mFirstFrameTime))) / 1000000)) / 16.9d) + 1.0d);
    }

    public double getFPS() {
        long j = this.mLastFrameTime;
        long j2 = this.mFirstFrameTime;
        if (j == j2) {
            return 0.0d;
        }
        return (((double) (this.mNumFrameCallbacks - 1)) * 1.0E9d) / ((double) (j - j2));
    }

    public double getJSFPS() {
        long j = this.mLastFrameTime;
        long j2 = this.mFirstFrameTime;
        if (j == j2) {
            return 0.0d;
        }
        return (((double) (this.mNumFrameCallbacksWithBatchDispatches - 1)) * 1.0E9d) / ((double) (j - j2));
    }

    public void reset() {
        this.mFirstFrameTime = -1;
        this.mLastFrameTime = -1;
        this.mNumFrameCallbacks = 0;
        this.m4PlusFrameStutters = 0;
        this.mNumFrameCallbacksWithBatchDispatches = 0;
        this.mIsRecordingFpsInfoAtEachFrame = false;
        this.mTimeToFps = null;
    }

    public void start() {
        this.mShouldStop = false;
        this.mReactContext.getCatalystInstance().addBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        this.mUIManagerModule.setViewHierarchyUpdateDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        UiThreadUtil.runOnUiThread(new Runnable() {
            /* class com.facebook.react.modules.debug.FpsDebugFrameCallback.AnonymousClass1 */

            public void run() {
                FpsDebugFrameCallback fpsDebugFrameCallback = FpsDebugFrameCallback.this;
                UiThreadUtil.assertOnUiThread();
                if (ChoreographerCompat.sInstance == null) {
                    ChoreographerCompat.sInstance = new ChoreographerCompat();
                }
                fpsDebugFrameCallback.mChoreographer = ChoreographerCompat.sInstance;
                FpsDebugFrameCallback.this.mChoreographer.postFrameCallback(this);
            }
        });
    }

    public void stop() {
        this.mShouldStop = true;
        this.mReactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        this.mUIManagerModule.setViewHierarchyUpdateDebugListener(null);
    }
}
