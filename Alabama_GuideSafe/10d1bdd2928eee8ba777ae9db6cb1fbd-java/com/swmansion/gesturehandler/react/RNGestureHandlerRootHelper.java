package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.views.modal.ReactModalHostView;
import com.google.common.util.concurrent.MoreExecutors;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.GestureHandlerOrchestrator;
import com.swmansion.gesturehandler.OnTouchEventListener;
import java.util.Arrays;

public class RNGestureHandlerRootHelper {
    public final ReactContext mContext;
    public final GestureHandler mJSGestureHandler;
    public final GestureHandlerOrchestrator mOrchestrator;
    public boolean mPassingTouch = false;
    public final ViewGroup mRootView;
    public boolean mShouldIntercept = false;

    public class RootViewGestureHandler extends GestureHandler {
        public RootViewGestureHandler(AnonymousClass1 r2) {
        }

        @Override // com.swmansion.gesturehandler.GestureHandler
        public void onCancel() {
            RNGestureHandlerRootHelper.this.mShouldIntercept = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 0);
            obtain.setAction(3);
            ViewGroup viewGroup = RNGestureHandlerRootHelper.this.mRootView;
            if (viewGroup instanceof ReactRootView) {
                ((ReactRootView) viewGroup).onChildStartedNativeGesture(obtain);
            } else {
                ((ReactModalHostView.DialogRootViewGroup) viewGroup).onChildStartedNativeGesture(obtain);
            }
        }

        @Override // com.swmansion.gesturehandler.GestureHandler
        public void onHandle(MotionEvent motionEvent) {
            if (this.mState == 0) {
                begin();
                RNGestureHandlerRootHelper.this.mShouldIntercept = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                end();
            }
        }
    }

    public RNGestureHandlerRootHelper(ReactContext reactContext, ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        if (id >= 1) {
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) reactContext.getNativeModule(RNGestureHandlerModule.class);
            RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
            UiThreadUtil.assertOnUiThread();
            ViewParent viewParent = viewGroup;
            while (viewParent != null && !(viewParent instanceof ReactRootView) && !(viewParent instanceof ReactModalHostView.DialogRootViewGroup)) {
                viewParent = viewParent.getParent();
            }
            if (viewParent != null) {
                this.mRootView = (ViewGroup) viewParent;
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("[GESTURE HANDLER] Initialize gesture handler for root view ");
                outline17.append(this.mRootView);
                Log.i("ReactNative", outline17.toString());
                this.mContext = reactContext;
                GestureHandlerOrchestrator gestureHandlerOrchestrator = new GestureHandlerOrchestrator(viewGroup, registry, new RNViewConfigurationHelper());
                this.mOrchestrator = gestureHandlerOrchestrator;
                gestureHandlerOrchestrator.mMinAlphaForTraversal = 0.1f;
                RootViewGestureHandler rootViewGestureHandler = new RootViewGestureHandler(null);
                this.mJSGestureHandler = rootViewGestureHandler;
                rootViewGestureHandler.mTag = -id;
                synchronized (registry) {
                    registry.mHandlers.put(rootViewGestureHandler.mTag, rootViewGestureHandler);
                }
                registry.attachHandlerToView(this.mJSGestureHandler.mTag, id);
                rNGestureHandlerModule.registerRootHelper(this);
                return;
            }
            throw new IllegalStateException("View " + viewGroup + " has not been mounted under ReactRootView");
        }
        throw new IllegalStateException("Expect view tag to be set for " + viewGroup);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r8v3, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (r11 == r3.mWrapperView) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01a4  */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        OnTouchEventListener<T> onTouchEventListener;
        int i3;
        int i4;
        MotionEvent motionEvent2;
        int i5;
        int i6;
        int pointerCount;
        int i7;
        int i8;
        int i9;
        int i10 = 1;
        this.mPassingTouch = true;
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.mOrchestrator;
        gestureHandlerOrchestrator.mIsHandlingTouch = true;
        int actionMasked = motionEvent.getActionMasked();
        int i11 = 5;
        int i12 = 3;
        int i13 = -1;
        boolean z = 0;
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            GestureHandlerOrchestrator.sTempCoords[0] = motionEvent.getX(actionIndex);
            GestureHandlerOrchestrator.sTempCoords[1] = motionEvent.getY(actionIndex);
            gestureHandlerOrchestrator.traverseWithPointerEvents(gestureHandlerOrchestrator.mWrapperView, GestureHandlerOrchestrator.sTempCoords, pointerId);
            gestureHandlerOrchestrator.extractGestureHandlers(gestureHandlerOrchestrator.mWrapperView, GestureHandlerOrchestrator.sTempCoords, pointerId);
        } else if (actionMasked == 3) {
            for (int i14 = gestureHandlerOrchestrator.mAwaitingHandlersCount - 1; i14 >= 0; i14--) {
                gestureHandlerOrchestrator.mAwaitingHandlers[i14].cancel();
            }
            int i15 = gestureHandlerOrchestrator.mGestureHandlersCount;
            for (int i16 = 0; i16 < i15; i16++) {
                gestureHandlerOrchestrator.mPreparedHandlers[i16] = gestureHandlerOrchestrator.mGestureHandlers[i16];
            }
            for (int i17 = i15 - 1; i17 >= 0; i17--) {
                gestureHandlerOrchestrator.mPreparedHandlers[i17].cancel();
            }
        }
        int i18 = gestureHandlerOrchestrator.mGestureHandlersCount;
        System.arraycopy(gestureHandlerOrchestrator.mGestureHandlers, 0, gestureHandlerOrchestrator.mPreparedHandlers, 0, i18);
        Arrays.sort(gestureHandlerOrchestrator.mPreparedHandlers, 0, i18, GestureHandlerOrchestrator.sHandlersComparator);
        int i19 = 0;
        while (i19 < i18) {
            GestureHandler gestureHandler = gestureHandlerOrchestrator.mPreparedHandlers[i19];
            View view = gestureHandler.mView;
            if (view != null) {
                if (view != gestureHandlerOrchestrator.mWrapperView) {
                    ViewParent parent = view.getParent();
                    while (parent != null && parent != gestureHandlerOrchestrator.mWrapperView) {
                        parent = parent.getParent();
                    }
                }
                i = i10;
                if (i != 0) {
                    gestureHandler.cancel();
                } else if (((!gestureHandler.mEnabled || (i9 = gestureHandler.mState) == i10 || i9 == i12 || i9 == i11 || gestureHandler.mTrackedPointersCount <= 0) ? z : i10) != 0) {
                    int actionMasked2 = motionEvent.getActionMasked();
                    if (!gestureHandler.mIsAwaiting || actionMasked2 != 2) {
                        float[] fArr = GestureHandlerOrchestrator.sTempCoords;
                        gestureHandlerOrchestrator.extractCoordsForView(gestureHandler.mView, motionEvent, fArr);
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        char c = z ? 1 : 0;
                        char c2 = z ? 1 : 0;
                        char c3 = z ? 1 : 0;
                        motionEvent.setLocation(fArr[c], fArr[i10]);
                        if (!(!gestureHandler.mEnabled || (i3 = gestureHandler.mState) == i12 || i3 == i10 || i3 == i11 || gestureHandler.mTrackedPointersCount < i10)) {
                            if (motionEvent.getPointerCount() == gestureHandler.mTrackedPointersCount) {
                                int i20 = z ? 1 : 0;
                                Object[] objArr = z ? 1 : 0;
                                Object[] objArr2 = z ? 1 : 0;
                                int i21 = i20;
                                while (true) {
                                    int[] iArr = gestureHandler.mTrackedPointerIDs;
                                    if (i21 >= iArr.length) {
                                        i4 = 0;
                                        break;
                                    }
                                    if (!(iArr[i21] == i13 || iArr[i21] == i21)) {
                                        break;
                                    }
                                    i21++;
                                }
                            }
                            i4 = i10;
                            if (i4 == 0) {
                                motionEvent2 = motionEvent;
                            } else {
                                int actionMasked3 = motionEvent.getActionMasked();
                                if (actionMasked3 == 0 || actionMasked3 == i11) {
                                    i8 = motionEvent.getActionIndex();
                                    if (gestureHandler.mTrackedPointerIDs[motionEvent.getPointerId(i8)] != i13) {
                                        if (gestureHandler.mTrackedPointersCount == i10) {
                                            i5 = i8;
                                            actionMasked3 = 0;
                                        } else {
                                            i5 = i8;
                                            actionMasked3 = i11;
                                        }
                                        i6 = gestureHandler.mTrackedPointersCount;
                                        if (GestureHandler.sPointerProps == null) {
                                            GestureHandler.sPointerProps = new MotionEvent.PointerProperties[12];
                                            GestureHandler.sPointerCoords = new MotionEvent.PointerCoords[12];
                                        }
                                        while (i6 > 0) {
                                            MotionEvent.PointerProperties[] pointerPropertiesArr = GestureHandler.sPointerProps;
                                            i6--;
                                            if (pointerPropertiesArr[i6] != null) {
                                                break;
                                            }
                                            pointerPropertiesArr[i6] = new MotionEvent.PointerProperties();
                                            GestureHandler.sPointerCoords[i6] = new MotionEvent.PointerCoords();
                                        }
                                        float x2 = motionEvent.getX();
                                        float y2 = motionEvent.getY();
                                        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                        pointerCount = motionEvent.getPointerCount();
                                        int i22 = actionMasked3;
                                        i7 = 0;
                                        int i23 = 0;
                                        while (i7 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i7);
                                            if (gestureHandler.mTrackedPointerIDs[pointerId2] != i13) {
                                                motionEvent.getPointerProperties(i7, GestureHandler.sPointerProps[i23]);
                                                GestureHandler.sPointerProps[i23].id = gestureHandler.mTrackedPointerIDs[pointerId2];
                                                motionEvent.getPointerCoords(i7, GestureHandler.sPointerCoords[i23]);
                                                if (i7 == i5) {
                                                    i22 |= i23 << 8;
                                                }
                                                i23++;
                                            }
                                            i7++;
                                            pointerCount = pointerCount;
                                            i13 = -1;
                                        }
                                        motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i22, i23, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                        motionEvent.setLocation(x2, y2);
                                        motionEvent2.setLocation(x2, y2);
                                    }
                                } else if (actionMasked3 == i10 || actionMasked3 == 6) {
                                    i8 = motionEvent.getActionIndex();
                                    if (gestureHandler.mTrackedPointerIDs[motionEvent.getPointerId(i8)] != i13) {
                                        if (gestureHandler.mTrackedPointersCount == i10) {
                                            i5 = i8;
                                            actionMasked3 = i10;
                                        } else {
                                            i5 = i8;
                                            actionMasked3 = 6;
                                        }
                                        i6 = gestureHandler.mTrackedPointersCount;
                                        if (GestureHandler.sPointerProps == null) {
                                        }
                                        while (i6 > 0) {
                                        }
                                        float x22 = motionEvent.getX();
                                        float y22 = motionEvent.getY();
                                        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                        pointerCount = motionEvent.getPointerCount();
                                        int i222 = actionMasked3;
                                        i7 = 0;
                                        int i232 = 0;
                                        while (i7 < pointerCount) {
                                        }
                                        motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i222, i232, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                        motionEvent.setLocation(x22, y22);
                                        motionEvent2.setLocation(x22, y22);
                                    }
                                } else {
                                    i5 = i13;
                                    i6 = gestureHandler.mTrackedPointersCount;
                                    if (GestureHandler.sPointerProps == null) {
                                    }
                                    while (i6 > 0) {
                                    }
                                    float x222 = motionEvent.getX();
                                    float y222 = motionEvent.getY();
                                    motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                    pointerCount = motionEvent.getPointerCount();
                                    int i2222 = actionMasked3;
                                    i7 = 0;
                                    int i2322 = 0;
                                    while (i7 < pointerCount) {
                                    }
                                    motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i2222, i2322, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                    motionEvent.setLocation(x222, y222);
                                    motionEvent2.setLocation(x222, y222);
                                }
                                i5 = i8;
                                actionMasked3 = 2;
                                i6 = gestureHandler.mTrackedPointersCount;
                                if (GestureHandler.sPointerProps == null) {
                                }
                                while (i6 > 0) {
                                }
                                float x2222 = motionEvent.getX();
                                float y2222 = motionEvent.getY();
                                motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                pointerCount = motionEvent.getPointerCount();
                                int i22222 = actionMasked3;
                                i7 = 0;
                                int i23222 = 0;
                                while (i7 < pointerCount) {
                                }
                                motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i22222, i23222, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                motionEvent.setLocation(x2222, y2222);
                                motionEvent2.setLocation(x2222, y2222);
                            }
                            gestureHandler.mX = motionEvent2.getX();
                            gestureHandler.mY = motionEvent2.getY();
                            gestureHandler.mNumberOfPointers = motionEvent2.getPointerCount();
                            boolean isWithinBounds = gestureHandler.isWithinBounds(gestureHandler.mView, gestureHandler.mX, gestureHandler.mY);
                            gestureHandler.mWithinBounds = isWithinBounds;
                            if (!gestureHandler.mShouldCancelWhenOutside || isWithinBounds) {
                                gestureHandler.mLastX = MoreExecutors.getLastPointerX(motionEvent2, true);
                                gestureHandler.mLastY = MoreExecutors.getLastPointerY(motionEvent2, true);
                                gestureHandler.mLastEventOffsetX = motionEvent2.getRawX() - motionEvent2.getX();
                                gestureHandler.mLastEventOffsetY = motionEvent2.getRawY() - motionEvent2.getY();
                                gestureHandler.onHandle(motionEvent2);
                                if (motionEvent2 != motionEvent) {
                                    motionEvent2.recycle();
                                }
                            } else {
                                int i24 = gestureHandler.mState;
                                if (i24 == 4) {
                                    gestureHandler.cancel();
                                } else if (i24 == 2) {
                                    gestureHandler.fail();
                                }
                            }
                        }
                        if (gestureHandler.mIsActive && (onTouchEventListener = gestureHandler.mListener) != null) {
                            RNGestureHandlerModule.this.onTouchEvent(gestureHandler, motionEvent);
                        }
                        motionEvent.setLocation(x, y);
                        i10 = 1;
                        if (actionMasked2 == 1 || actionMasked2 == 6) {
                            int pointerId3 = motionEvent.getPointerId(motionEvent.getActionIndex());
                            int[] iArr2 = gestureHandler.mTrackedPointerIDs;
                            i2 = -1;
                            if (iArr2[pointerId3] != -1) {
                                iArr2[pointerId3] = -1;
                                gestureHandler.mTrackedPointersCount--;
                            }
                            i19++;
                            i13 = i2;
                            i11 = 5;
                            i12 = 3;
                            z = 0;
                        } else {
                            i2 = -1;
                            i19++;
                            i13 = i2;
                            i11 = 5;
                            i12 = 3;
                            z = 0;
                        }
                    }
                }
                i2 = i13;
                i19++;
                i13 = i2;
                i11 = 5;
                i12 = 3;
                z = 0;
            }
            i = z;
            if (i != 0) {
            }
            i2 = i13;
            i19++;
            i13 = i2;
            i11 = 5;
            i12 = 3;
            z = 0;
        }
        gestureHandlerOrchestrator.mIsHandlingTouch = z;
        if (gestureHandlerOrchestrator.mFinishedHandlersCleanupScheduled && gestureHandlerOrchestrator.mHandlingChangeSemaphore == 0) {
            gestureHandlerOrchestrator.cleanupFinishedHandlers();
        }
        this.mPassingTouch = z;
        return this.mShouldIntercept;
    }

    public void requestDisallowInterceptTouchEvent() {
        GestureHandler gestureHandler;
        if (this.mOrchestrator != null && !this.mPassingTouch && (gestureHandler = this.mJSGestureHandler) != null && gestureHandler.mState == 2) {
            gestureHandler.activate();
            this.mJSGestureHandler.end();
        }
    }

    public void tearDown() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("[GESTURE HANDLER] Tearing down gesture handler registered for root view ");
        outline17.append(this.mRootView);
        Log.i("ReactNative", outline17.toString());
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) this.mContext.getNativeModule(RNGestureHandlerModule.class);
        rNGestureHandlerModule.getRegistry().dropHandler(this.mJSGestureHandler.mTag);
        rNGestureHandlerModule.unregisterRootHelper(this);
    }
}
