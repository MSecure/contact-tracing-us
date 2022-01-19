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
import com.horcrux.svg.PathParser;
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
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("[GESTURE HANDLER] Initialize gesture handler for root view ");
                outline15.append(this.mRootView);
                Log.i("ReactNative", outline15.toString());
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
    /* JADX DEBUG: Multi-variable search result rejected for r8v2, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009e, code lost:
        if (r11 == r3.mWrapperView) goto L_0x00a0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a5  */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i;
        OnTouchEventListener<T> onTouchEventListener;
        int i2;
        int i3;
        MotionEvent motionEvent2;
        int i4;
        int i5;
        int pointerCount;
        int i6;
        int i7;
        int i8;
        int i9 = 1;
        this.mPassingTouch = true;
        GestureHandlerOrchestrator gestureHandlerOrchestrator = this.mOrchestrator;
        gestureHandlerOrchestrator.mIsHandlingTouch = true;
        int actionMasked = motionEvent.getActionMasked();
        int i10 = 5;
        int i11 = 3;
        int i12 = -1;
        boolean z = 0;
        if (actionMasked == 0 || actionMasked == 5) {
            int actionIndex = motionEvent.getActionIndex();
            int pointerId = motionEvent.getPointerId(actionIndex);
            GestureHandlerOrchestrator.sTempCoords[0] = motionEvent.getX(actionIndex);
            GestureHandlerOrchestrator.sTempCoords[1] = motionEvent.getY(actionIndex);
            gestureHandlerOrchestrator.traverseWithPointerEvents(gestureHandlerOrchestrator.mWrapperView, GestureHandlerOrchestrator.sTempCoords, pointerId);
            gestureHandlerOrchestrator.extractGestureHandlers(gestureHandlerOrchestrator.mWrapperView, GestureHandlerOrchestrator.sTempCoords, pointerId);
        } else if (actionMasked == 3) {
            for (int i13 = gestureHandlerOrchestrator.mAwaitingHandlersCount - 1; i13 >= 0; i13--) {
                gestureHandlerOrchestrator.mAwaitingHandlers[i13].cancel();
            }
            int i14 = gestureHandlerOrchestrator.mGestureHandlersCount;
            for (int i15 = 0; i15 < i14; i15++) {
                gestureHandlerOrchestrator.mPreparedHandlers[i15] = gestureHandlerOrchestrator.mGestureHandlers[i15];
            }
            for (int i16 = i14 - 1; i16 >= 0; i16--) {
                gestureHandlerOrchestrator.mPreparedHandlers[i16].cancel();
            }
        }
        int i17 = gestureHandlerOrchestrator.mGestureHandlersCount;
        System.arraycopy(gestureHandlerOrchestrator.mGestureHandlers, 0, gestureHandlerOrchestrator.mPreparedHandlers, 0, i17);
        Arrays.sort(gestureHandlerOrchestrator.mPreparedHandlers, 0, i17, GestureHandlerOrchestrator.sHandlersComparator);
        int i18 = 0;
        while (i18 < i17) {
            GestureHandler gestureHandler = gestureHandlerOrchestrator.mPreparedHandlers[i18];
            View view = gestureHandler.mView;
            if (view != null) {
                if (view != gestureHandlerOrchestrator.mWrapperView) {
                    ViewParent parent = view.getParent();
                    while (parent != null && parent != gestureHandlerOrchestrator.mWrapperView) {
                        parent = parent.getParent();
                    }
                }
                i = i9;
                if (i != 0) {
                    gestureHandler.cancel();
                } else if (((!gestureHandler.mEnabled || (i8 = gestureHandler.mState) == i9 || i8 == i11 || i8 == i10 || gestureHandler.mTrackedPointersCount <= 0) ? z : i9) != 0) {
                    int actionMasked2 = motionEvent.getActionMasked();
                    if (!gestureHandler.mIsAwaiting || actionMasked2 != 2) {
                        float[] fArr = GestureHandlerOrchestrator.sTempCoords;
                        gestureHandlerOrchestrator.extractCoordsForView(gestureHandler.mView, motionEvent, fArr);
                        float x = motionEvent.getX();
                        float y = motionEvent.getY();
                        char c = z ? 1 : 0;
                        char c2 = z ? 1 : 0;
                        char c3 = z ? 1 : 0;
                        motionEvent.setLocation(fArr[c], fArr[i9]);
                        if (!(!gestureHandler.mEnabled || (i2 = gestureHandler.mState) == i11 || i2 == i9 || i2 == i10 || gestureHandler.mTrackedPointersCount < i9)) {
                            if (motionEvent.getPointerCount() == gestureHandler.mTrackedPointersCount) {
                                int i19 = z ? 1 : 0;
                                Object[] objArr = z ? 1 : 0;
                                Object[] objArr2 = z ? 1 : 0;
                                int i20 = i19;
                                while (true) {
                                    int[] iArr = gestureHandler.mTrackedPointerIDs;
                                    if (i20 >= iArr.length) {
                                        i3 = 0;
                                        break;
                                    }
                                    if (!(iArr[i20] == i12 || iArr[i20] == i20)) {
                                        break;
                                    }
                                    i20++;
                                }
                            }
                            i3 = i9;
                            if (i3 == 0) {
                                motionEvent2 = motionEvent;
                            } else {
                                int actionMasked3 = motionEvent.getActionMasked();
                                if (actionMasked3 == 0 || actionMasked3 == i10) {
                                    i7 = motionEvent.getActionIndex();
                                    if (gestureHandler.mTrackedPointerIDs[motionEvent.getPointerId(i7)] != i12) {
                                        if (gestureHandler.mTrackedPointersCount == i9) {
                                            i4 = i7;
                                            actionMasked3 = 0;
                                        } else {
                                            i4 = i7;
                                            actionMasked3 = i10;
                                        }
                                        i5 = gestureHandler.mTrackedPointersCount;
                                        if (GestureHandler.sPointerProps == null) {
                                            GestureHandler.sPointerProps = new MotionEvent.PointerProperties[11];
                                            GestureHandler.sPointerCoords = new MotionEvent.PointerCoords[11];
                                        }
                                        while (i5 > 0) {
                                            MotionEvent.PointerProperties[] pointerPropertiesArr = GestureHandler.sPointerProps;
                                            i5--;
                                            if (pointerPropertiesArr[i5] != null) {
                                                break;
                                            }
                                            pointerPropertiesArr[i5] = new MotionEvent.PointerProperties();
                                            GestureHandler.sPointerCoords[i5] = new MotionEvent.PointerCoords();
                                        }
                                        float x2 = motionEvent.getX();
                                        float y2 = motionEvent.getY();
                                        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                        pointerCount = motionEvent.getPointerCount();
                                        int i21 = actionMasked3;
                                        i6 = 0;
                                        int i22 = 0;
                                        while (i6 < pointerCount) {
                                            int pointerId2 = motionEvent.getPointerId(i6);
                                            if (gestureHandler.mTrackedPointerIDs[pointerId2] != i12) {
                                                motionEvent.getPointerProperties(i6, GestureHandler.sPointerProps[i22]);
                                                GestureHandler.sPointerProps[i22].id = gestureHandler.mTrackedPointerIDs[pointerId2];
                                                motionEvent.getPointerCoords(i6, GestureHandler.sPointerCoords[i22]);
                                                if (i6 == i4) {
                                                    i21 |= i22 << 8;
                                                }
                                                i22++;
                                            }
                                            i6++;
                                            pointerCount = pointerCount;
                                            i12 = -1;
                                        }
                                        motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i21, i22, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                        motionEvent.setLocation(x2, y2);
                                        motionEvent2.setLocation(x2, y2);
                                    }
                                } else if (actionMasked3 == i9 || actionMasked3 == 6) {
                                    i7 = motionEvent.getActionIndex();
                                    if (gestureHandler.mTrackedPointerIDs[motionEvent.getPointerId(i7)] != i12) {
                                        if (gestureHandler.mTrackedPointersCount == i9) {
                                            i4 = i7;
                                            actionMasked3 = i9;
                                        } else {
                                            i4 = i7;
                                            actionMasked3 = 6;
                                        }
                                        i5 = gestureHandler.mTrackedPointersCount;
                                        if (GestureHandler.sPointerProps == null) {
                                        }
                                        while (i5 > 0) {
                                        }
                                        float x22 = motionEvent.getX();
                                        float y22 = motionEvent.getY();
                                        motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                        pointerCount = motionEvent.getPointerCount();
                                        int i212 = actionMasked3;
                                        i6 = 0;
                                        int i222 = 0;
                                        while (i6 < pointerCount) {
                                        }
                                        motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i212, i222, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                        motionEvent.setLocation(x22, y22);
                                        motionEvent2.setLocation(x22, y22);
                                    }
                                } else {
                                    i4 = i12;
                                    i5 = gestureHandler.mTrackedPointersCount;
                                    if (GestureHandler.sPointerProps == null) {
                                    }
                                    while (i5 > 0) {
                                    }
                                    float x222 = motionEvent.getX();
                                    float y222 = motionEvent.getY();
                                    motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                    pointerCount = motionEvent.getPointerCount();
                                    int i2122 = actionMasked3;
                                    i6 = 0;
                                    int i2222 = 0;
                                    while (i6 < pointerCount) {
                                    }
                                    motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i2122, i2222, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                    motionEvent.setLocation(x222, y222);
                                    motionEvent2.setLocation(x222, y222);
                                }
                                i4 = i7;
                                actionMasked3 = 2;
                                i5 = gestureHandler.mTrackedPointersCount;
                                if (GestureHandler.sPointerProps == null) {
                                }
                                while (i5 > 0) {
                                }
                                float x2222 = motionEvent.getX();
                                float y2222 = motionEvent.getY();
                                motionEvent.setLocation(motionEvent.getRawX(), motionEvent.getRawY());
                                pointerCount = motionEvent.getPointerCount();
                                int i21222 = actionMasked3;
                                i6 = 0;
                                int i22222 = 0;
                                while (i6 < pointerCount) {
                                }
                                motionEvent2 = MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), i21222, i22222, GestureHandler.sPointerProps, GestureHandler.sPointerCoords, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
                                motionEvent.setLocation(x2222, y2222);
                                motionEvent2.setLocation(x2222, y2222);
                            }
                            gestureHandler.mX = motionEvent2.getX();
                            gestureHandler.mY = motionEvent2.getY();
                            gestureHandler.mNumberOfPointers = motionEvent2.getPointerCount();
                            boolean isWithinBounds = gestureHandler.isWithinBounds(gestureHandler.mView, gestureHandler.mX, gestureHandler.mY);
                            gestureHandler.mWithinBounds = isWithinBounds;
                            if (!gestureHandler.mShouldCancelWhenOutside || isWithinBounds) {
                                gestureHandler.mLastX = PathParser.getLastPointerX(motionEvent2, true);
                                gestureHandler.mLastY = PathParser.getLastPointerY(motionEvent2, true);
                                gestureHandler.mLastEventOffsetX = motionEvent2.getRawX() - motionEvent2.getX();
                                gestureHandler.mLastEventOffsetY = motionEvent2.getRawY() - motionEvent2.getY();
                                gestureHandler.onHandle(motionEvent2);
                                if (motionEvent2 != motionEvent) {
                                    motionEvent2.recycle();
                                }
                            } else {
                                int i23 = gestureHandler.mState;
                                if (i23 == 4) {
                                    gestureHandler.cancel();
                                } else if (i23 == 2) {
                                    gestureHandler.fail();
                                }
                            }
                        }
                        if (gestureHandler.mIsActive && (onTouchEventListener = gestureHandler.mListener) != null) {
                            RNGestureHandlerModule.this.onTouchEvent(gestureHandler, motionEvent);
                        }
                        motionEvent.setLocation(x, y);
                        if (actionMasked2 == 1 || actionMasked2 == 6) {
                            int pointerId3 = motionEvent.getPointerId(motionEvent.getActionIndex());
                            int[] iArr2 = gestureHandler.mTrackedPointerIDs;
                            i12 = -1;
                            if (iArr2[pointerId3] != -1) {
                                iArr2[pointerId3] = -1;
                                gestureHandler.mTrackedPointersCount--;
                            }
                        } else {
                            i12 = -1;
                        }
                    }
                }
                i18++;
                i9 = 1;
                i10 = 5;
                i11 = 3;
                z = 0;
            }
            i = z;
            if (i != 0) {
            }
            i18++;
            i9 = 1;
            i10 = 5;
            i11 = 3;
            z = 0;
        }
        gestureHandlerOrchestrator.mIsHandlingTouch = z;
        if (gestureHandlerOrchestrator.mFinishedHandlersCleanupScheduled && gestureHandlerOrchestrator.mHandlingChangeSemaphore == 0) {
            gestureHandlerOrchestrator.cleanupFinishedHandlers();
        }
        this.mPassingTouch = z;
        if (this.mShouldIntercept) {
            return true;
        }
        return z;
    }

    public void requestDisallowInterceptTouchEvent() {
        GestureHandler gestureHandler;
        if (this.mOrchestrator != null && !this.mPassingTouch && (gestureHandler = this.mJSGestureHandler) != null && gestureHandler.mState == 2) {
            gestureHandler.activate();
            this.mJSGestureHandler.end();
        }
    }

    public void tearDown() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("[GESTURE HANDLER] Tearing down gesture handler registered for root view ");
        outline15.append(this.mRootView);
        Log.i("ReactNative", outline15.toString());
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) this.mContext.getNativeModule(RNGestureHandlerModule.class);
        rNGestureHandlerModule.getRegistry().dropHandler(this.mJSGestureHandler.mTag);
        rNGestureHandlerModule.unregisterRootHelper(this);
    }
}
