package com.swmansion.gesturehandler;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.views.view.ReactViewGroup;
import com.swmansion.gesturehandler.react.RNGestureHandlerInteractionManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRegistry;
import com.swmansion.gesturehandler.react.RNViewConfigurationHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GestureHandlerOrchestrator {
    public static final Comparator<GestureHandler> sHandlersComparator = new Comparator<GestureHandler>() {
        /* class com.swmansion.gesturehandler.GestureHandlerOrchestrator.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
            GestureHandler gestureHandler3 = gestureHandler;
            GestureHandler gestureHandler4 = gestureHandler2;
            if ((gestureHandler3.mIsActive && gestureHandler4.mIsActive) || (gestureHandler3.mIsAwaiting && gestureHandler4.mIsAwaiting)) {
                return Integer.signum(gestureHandler4.mActivationIndex - gestureHandler3.mActivationIndex);
            }
            if (!gestureHandler3.mIsActive) {
                if (!gestureHandler4.mIsActive) {
                    if (!gestureHandler3.mIsAwaiting) {
                        if (!gestureHandler4.mIsAwaiting) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
            return -1;
        }
    };
    public static final Matrix sInverseMatrix = new Matrix();
    public static final float[] sMatrixTransformCoords = new float[2];
    public static final float[] sTempCoords = new float[2];
    public static final PointF sTempPoint = new PointF();
    public int mActivationIndex = 0;
    public final GestureHandler[] mAwaitingHandlers = new GestureHandler[20];
    public int mAwaitingHandlersCount = 0;
    public boolean mFinishedHandlersCleanupScheduled = false;
    public final GestureHandler[] mGestureHandlers = new GestureHandler[20];
    public int mGestureHandlersCount = 0;
    public final GestureHandlerRegistry mHandlerRegistry;
    public final GestureHandler[] mHandlersToCancel = new GestureHandler[20];
    public int mHandlingChangeSemaphore = 0;
    public boolean mIsHandlingTouch = false;
    public float mMinAlphaForTraversal = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    public final GestureHandler[] mPreparedHandlers = new GestureHandler[20];
    public final ViewConfigurationHelper mViewConfigHelper;
    public final ViewGroup mWrapperView;

    public GestureHandlerOrchestrator(ViewGroup viewGroup, GestureHandlerRegistry gestureHandlerRegistry, ViewConfigurationHelper viewConfigurationHelper) {
        this.mWrapperView = viewGroup;
        this.mHandlerRegistry = gestureHandlerRegistry;
        this.mViewConfigHelper = viewConfigurationHelper;
    }

    public static boolean isFinished(int i) {
        return i == 3 || i == 1 || i == 5;
    }

    public static boolean isTransformedTouchPointInView(float f, float f2, View view) {
        return f >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f <= ((float) view.getWidth()) && f2 >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && f2 < ((float) view.getHeight());
    }

    public static boolean shouldHandlerBeCancelledBy(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        boolean z;
        int i = 0;
        while (true) {
            int[] iArr = gestureHandler.mTrackedPointerIDs;
            if (i < iArr.length) {
                if (iArr[i] != -1 && gestureHandler2.mTrackedPointerIDs[i] != -1) {
                    z = true;
                    break;
                }
                i++;
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            return false;
        }
        if (gestureHandler == gestureHandler2 || gestureHandler.shouldRecognizeSimultaneously(gestureHandler2) || gestureHandler2.shouldRecognizeSimultaneously(gestureHandler)) {
            return false;
        }
        if (gestureHandler == gestureHandler2 || (!gestureHandler.mIsAwaiting && gestureHandler.mState != 4)) {
            return true;
        }
        return gestureHandler.shouldBeCancelledBy(gestureHandler2);
    }

    public static boolean shouldHandlerWaitForOther(GestureHandler gestureHandler, GestureHandler gestureHandler2) {
        boolean z;
        RNGestureHandlerInteractionManager rNGestureHandlerInteractionManager;
        int[] iArr;
        if (gestureHandler == gestureHandler2) {
            return false;
        }
        if (gestureHandler != null) {
            if (gestureHandler2 != gestureHandler && (rNGestureHandlerInteractionManager = gestureHandler.mInteractionController) != null && (iArr = rNGestureHandlerInteractionManager.mWaitForRelations.get(gestureHandler.mTag)) != null) {
                int i = 0;
                while (true) {
                    if (i >= iArr.length) {
                        break;
                    } else if (iArr[i] == gestureHandler2.mTag) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            z = false;
            return z || gestureHandler2.shouldRequireToWaitForFailure(gestureHandler);
        }
        throw null;
    }

    public static boolean shouldHandlerlessViewBecomeTouchTarget(View view, float[] fArr) {
        return (!(view instanceof ViewGroup) || view.getBackground() != null) && isTransformedTouchPointInView(fArr[0], fArr[1], view);
    }

    public static void transformTouchPointToViewCoords(float f, float f2, ViewGroup viewGroup, View view, PointF pointF) {
        float scrollX = (f + ((float) viewGroup.getScrollX())) - ((float) view.getLeft());
        float scrollY = (f2 + ((float) viewGroup.getScrollY())) - ((float) view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            float[] fArr = sMatrixTransformCoords;
            fArr[0] = scrollX;
            fArr[1] = scrollY;
            Matrix matrix2 = sInverseMatrix;
            matrix.invert(matrix2);
            matrix2.mapPoints(fArr);
            float f3 = fArr[0];
            scrollY = fArr[1];
            scrollX = f3;
        }
        pointF.set(scrollX, scrollY);
    }

    public final void cleanupAwaitingHandlers() {
        int i = 0;
        for (int i2 = 0; i2 < this.mAwaitingHandlersCount; i2++) {
            GestureHandler[] gestureHandlerArr = this.mAwaitingHandlers;
            if (gestureHandlerArr[i2].mIsAwaiting) {
                gestureHandlerArr[i] = gestureHandlerArr[i2];
                i++;
            }
        }
        this.mAwaitingHandlersCount = i;
    }

    public final void cleanupFinishedHandlers() {
        boolean z = false;
        for (int i = this.mGestureHandlersCount - 1; i >= 0; i--) {
            GestureHandler gestureHandler = this.mGestureHandlers[i];
            if (isFinished(gestureHandler.mState) && !gestureHandler.mIsAwaiting) {
                this.mGestureHandlers[i] = null;
                gestureHandler.mView = null;
                gestureHandler.mOrchestrator = null;
                Arrays.fill(gestureHandler.mTrackedPointerIDs, -1);
                gestureHandler.mTrackedPointersCount = 0;
                gestureHandler.onReset();
                gestureHandler.mIsActive = false;
                gestureHandler.mIsAwaiting = false;
                gestureHandler.mActivationIndex = Integer.MAX_VALUE;
                z = true;
            }
        }
        if (z) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.mGestureHandlersCount; i3++) {
                GestureHandler[] gestureHandlerArr = this.mGestureHandlers;
                if (gestureHandlerArr[i3] != null) {
                    gestureHandlerArr[i2] = gestureHandlerArr[i3];
                    i2++;
                }
            }
            this.mGestureHandlersCount = i2;
        }
        this.mFinishedHandlersCleanupScheduled = false;
    }

    public final void extractCoordsForView(View view, MotionEvent motionEvent, float[] fArr) {
        if (view == this.mWrapperView) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
        } else if (view == null || !(view.getParent() instanceof ViewGroup)) {
            throw new IllegalArgumentException("Parent is null? View is no longer in the tree");
        } else {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            extractCoordsForView(viewGroup, motionEvent, fArr);
            PointF pointF = sTempPoint;
            transformTouchPointToViewCoords(fArr[0], fArr[1], viewGroup, view, pointF);
            fArr[0] = pointF.x;
            fArr[1] = pointF.y;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0095 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0096 A[SYNTHETIC] */
    public final boolean extractGestureHandlers(ViewGroup viewGroup, float[] fArr, int i) {
        View view;
        boolean z;
        boolean traverseWithPointerEvents;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            if (((RNViewConfigurationHelper) this.mViewConfigHelper) != null) {
                if (viewGroup instanceof ReactViewGroup) {
                    view = viewGroup.getChildAt(((ReactViewGroup) viewGroup).getZIndexMappedChildIndex(childCount));
                } else {
                    view = viewGroup.getChildAt(childCount);
                }
                if (view.getVisibility() == 0 && view.getAlpha() >= this.mMinAlphaForTraversal) {
                    PointF pointF = sTempPoint;
                    transformTouchPointToViewCoords(fArr[0], fArr[1], viewGroup, view, pointF);
                    float f = fArr[0];
                    float f2 = fArr[1];
                    fArr[0] = pointF.x;
                    fArr[1] = pointF.y;
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) view;
                        if (((RNViewConfigurationHelper) this.mViewConfigHelper) == null) {
                            throw null;
                        } else if (!(!viewGroup2.getClipChildren() ? viewGroup2 instanceof ReactViewGroup ? "hidden".equals(((ReactViewGroup) viewGroup2).getOverflow()) : false : true)) {
                            z = false;
                            traverseWithPointerEvents = (z || isTransformedTouchPointInView(fArr[0], fArr[1], view)) ? traverseWithPointerEvents(view, fArr, i) : false;
                            fArr[0] = f;
                            fArr[1] = f2;
                            if (!traverseWithPointerEvents) {
                                return true;
                            }
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    fArr[0] = f;
                    fArr[1] = f2;
                    if (!traverseWithPointerEvents) {
                    }
                }
            } else {
                throw null;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    public final boolean recordViewHandlersForPointer(View view, float[] fArr, int i) {
        ArrayList<GestureHandler> arrayList;
        RNGestureHandlerRegistry rNGestureHandlerRegistry = (RNGestureHandlerRegistry) this.mHandlerRegistry;
        synchronized (rNGestureHandlerRegistry) {
            int id = view.getId();
            synchronized (rNGestureHandlerRegistry) {
                arrayList = rNGestureHandlerRegistry.mHandlersForView.get(id);
            }
            if (arrayList != null) {
                return false;
            }
            int size = arrayList.size();
            boolean z = false;
            for (int i2 = 0; i2 < size; i2++) {
                GestureHandler gestureHandler = arrayList.get(i2);
                if (gestureHandler.mEnabled && gestureHandler.isWithinBounds(view, fArr[0], fArr[1])) {
                    int i3 = 0;
                    while (true) {
                        int i4 = this.mGestureHandlersCount;
                        if (i3 >= i4) {
                            GestureHandler[] gestureHandlerArr = this.mGestureHandlers;
                            if (i4 < gestureHandlerArr.length) {
                                this.mGestureHandlersCount = i4 + 1;
                                gestureHandlerArr[i4] = gestureHandler;
                                gestureHandler.mIsActive = false;
                                gestureHandler.mIsAwaiting = false;
                                gestureHandler.mActivationIndex = Integer.MAX_VALUE;
                                if (gestureHandler.mView == null && gestureHandler.mOrchestrator == null) {
                                    Arrays.fill(gestureHandler.mTrackedPointerIDs, -1);
                                    gestureHandler.mTrackedPointersCount = 0;
                                    gestureHandler.mState = 0;
                                    gestureHandler.mView = view;
                                    gestureHandler.mOrchestrator = this;
                                } else {
                                    throw new IllegalStateException("Already prepared or hasn't been reset");
                                }
                            } else {
                                throw new IllegalStateException("Too many recognizers");
                            }
                        } else if (this.mGestureHandlers[i3] == gestureHandler) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    int[] iArr = gestureHandler.mTrackedPointerIDs;
                    if (iArr[i] == -1) {
                        int i5 = 0;
                        while (i5 < gestureHandler.mTrackedPointersCount) {
                            int i6 = 0;
                            while (true) {
                                int[] iArr2 = gestureHandler.mTrackedPointerIDs;
                                if (i6 < iArr2.length && iArr2[i6] != i5) {
                                    i6++;
                                }
                            }
                            if (i6 == gestureHandler.mTrackedPointerIDs.length) {
                                break;
                            }
                            i5++;
                        }
                        iArr[i] = i5;
                        gestureHandler.mTrackedPointersCount++;
                    }
                    z = true;
                }
            }
            return z;
        }
        if (arrayList != null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r5 == com.facebook.react.uimanager.PointerEvents.BOX_ONLY) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0042  */
    public final boolean traverseWithPointerEvents(View view, float[] fArr, int i) {
        PointerEventsConfig pointerEventsConfig;
        PointerEventsConfig pointerEventsConfig2 = PointerEventsConfig.AUTO;
        PointerEventsConfig pointerEventsConfig3 = PointerEventsConfig.BOX_ONLY;
        PointerEventsConfig pointerEventsConfig4 = PointerEventsConfig.BOX_NONE;
        PointerEventsConfig pointerEventsConfig5 = PointerEventsConfig.NONE;
        if (((RNViewConfigurationHelper) this.mViewConfigHelper) != null) {
            PointerEvents pointerEvents = PointerEvents.AUTO;
            PointerEvents pointerEvents2 = view instanceof ReactPointerEventsView ? ((ReactPointerEventsView) view).getPointerEvents() : pointerEvents;
            if (!view.isEnabled()) {
                if (pointerEvents2 != pointerEvents) {
                }
                pointerEventsConfig = pointerEventsConfig4;
                if (pointerEventsConfig != pointerEventsConfig5) {
                    return false;
                }
                if (pointerEventsConfig == pointerEventsConfig3) {
                    if (recordViewHandlersForPointer(view, fArr, i) || shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
                        return true;
                    }
                    return false;
                } else if (pointerEventsConfig == pointerEventsConfig4) {
                    if (view instanceof ViewGroup) {
                        return extractGestureHandlers((ViewGroup) view, fArr, i);
                    }
                    return false;
                } else if (pointerEventsConfig == pointerEventsConfig2) {
                    boolean extractGestureHandlers = view instanceof ViewGroup ? extractGestureHandlers((ViewGroup) view, fArr, i) : false;
                    if (recordViewHandlersForPointer(view, fArr, i) || extractGestureHandlers || shouldHandlerlessViewBecomeTouchTarget(view, fArr)) {
                        return true;
                    }
                    return false;
                } else {
                    StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unknown pointer event type: ");
                    outline17.append(pointerEventsConfig.toString());
                    throw new IllegalArgumentException(outline17.toString());
                }
            }
            int ordinal = pointerEvents2.ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    pointerEventsConfig = ordinal != 2 ? pointerEventsConfig2 : pointerEventsConfig3;
                    if (pointerEventsConfig != pointerEventsConfig5) {
                    }
                }
                pointerEventsConfig = pointerEventsConfig4;
                if (pointerEventsConfig != pointerEventsConfig5) {
                }
            }
            pointerEventsConfig = pointerEventsConfig5;
            if (pointerEventsConfig != pointerEventsConfig5) {
            }
        } else {
            throw null;
        }
    }

    public final void tryActivate(GestureHandler gestureHandler) {
        boolean z;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= this.mGestureHandlersCount) {
                z = false;
                break;
            }
            GestureHandler gestureHandler2 = this.mGestureHandlers[i2];
            if (!isFinished(gestureHandler2.mState) && shouldHandlerWaitForOther(gestureHandler, gestureHandler2)) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            while (true) {
                int i3 = this.mAwaitingHandlersCount;
                if (i >= i3) {
                    GestureHandler[] gestureHandlerArr = this.mAwaitingHandlers;
                    if (i3 < gestureHandlerArr.length) {
                        this.mAwaitingHandlersCount = i3 + 1;
                        gestureHandlerArr[i3] = gestureHandler;
                        gestureHandler.mIsAwaiting = true;
                        int i4 = this.mActivationIndex;
                        this.mActivationIndex = i4 + 1;
                        gestureHandler.mActivationIndex = i4;
                        return;
                    }
                    throw new IllegalStateException("Too many recognizers");
                } else if (this.mAwaitingHandlers[i] != gestureHandler) {
                    i++;
                } else {
                    return;
                }
            }
        } else {
            int i5 = gestureHandler.mState;
            gestureHandler.mIsAwaiting = false;
            gestureHandler.mIsActive = true;
            int i6 = this.mActivationIndex;
            this.mActivationIndex = i6 + 1;
            gestureHandler.mActivationIndex = i6;
            int i7 = 0;
            for (int i8 = 0; i8 < this.mGestureHandlersCount; i8++) {
                GestureHandler gestureHandler3 = this.mGestureHandlers[i8];
                if (shouldHandlerBeCancelledBy(gestureHandler3, gestureHandler)) {
                    this.mHandlersToCancel[i7] = gestureHandler3;
                    i7++;
                }
            }
            for (int i9 = i7 - 1; i9 >= 0; i9--) {
                this.mHandlersToCancel[i9].cancel();
            }
            for (int i10 = this.mAwaitingHandlersCount - 1; i10 >= 0; i10--) {
                GestureHandler gestureHandler4 = this.mAwaitingHandlers[i10];
                if (shouldHandlerBeCancelledBy(gestureHandler4, gestureHandler)) {
                    gestureHandler4.cancel();
                    gestureHandler4.mIsAwaiting = false;
                }
            }
            cleanupAwaitingHandlers();
            gestureHandler.dispatchStateChange(4, 2);
            if (i5 != 4) {
                gestureHandler.dispatchStateChange(5, 4);
                if (i5 != 5) {
                    gestureHandler.dispatchStateChange(0, 5);
                }
            }
            gestureHandler.mIsAwaiting = false;
        }
    }
}
