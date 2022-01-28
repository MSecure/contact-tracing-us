package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.ReactHitSlopView;

public class TouchTargetHelper {
    public static final float[] mEventCoords = new float[2];
    public static final Matrix mInverseMatrix = new Matrix();
    public static final float[] mMatrixTransformCoords = new float[2];
    public static final PointF mTempPoint = new PointF();

    public static int findTargetTagAndCoordinatesForTouch(float f, float f2, ViewGroup viewGroup, float[] fArr, int[] iArr) {
        int i;
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        fArr[0] = f;
        fArr[1] = f2;
        View findTouchTargetView = findTouchTargetView(fArr, viewGroup);
        while (findTouchTargetView != null && findTouchTargetView.getId() <= 0) {
            findTouchTargetView = (View) findTouchTargetView.getParent();
        }
        if (findTouchTargetView == null) {
            return id;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (findTouchTargetView instanceof ReactCompoundView) {
            i = ((ReactCompoundView) findTouchTargetView).reactTagForTouch(f3, f4);
        } else {
            i = findTouchTargetView.getId();
        }
        return i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0125, code lost:
        if (((com.facebook.react.uimanager.ReactCompoundView) r4).reactTagForTouch(r14[0], r14[1]) != r4.getId()) goto L_0x0148;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0167 A[SYNTHETIC] */
    public static View findTouchTargetView(float[] fArr, ViewGroup viewGroup) {
        boolean z;
        int childCount = viewGroup.getChildCount();
        ReactZIndexedViewGroup reactZIndexedViewGroup = viewGroup instanceof ReactZIndexedViewGroup ? (ReactZIndexedViewGroup) viewGroup : null;
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = viewGroup.getChildAt(reactZIndexedViewGroup != null ? reactZIndexedViewGroup.getZIndexMappedChildIndex(i) : i);
            PointF pointF = mTempPoint;
            float f = fArr[0];
            float f2 = fArr[1];
            float scrollX = (f + ((float) viewGroup.getScrollX())) - ((float) childAt.getLeft());
            float scrollY = (f2 + ((float) viewGroup.getScrollY())) - ((float) childAt.getTop());
            Matrix matrix = childAt.getMatrix();
            if (!matrix.isIdentity()) {
                float[] fArr2 = mMatrixTransformCoords;
                fArr2[0] = scrollX;
                fArr2[1] = scrollY;
                Matrix matrix2 = mInverseMatrix;
                matrix.invert(matrix2);
                matrix2.mapPoints(fArr2);
                scrollX = fArr2[0];
                scrollY = fArr2[1];
            }
            if (childAt instanceof ReactHitSlopView) {
                ReactHitSlopView reactHitSlopView = (ReactHitSlopView) childAt;
                if (reactHitSlopView.getHitSlopRect() != null) {
                    Rect hitSlopRect = reactHitSlopView.getHitSlopRect();
                    if (scrollX >= ((float) (-hitSlopRect.left)) && scrollX < ((float) ((childAt.getRight() - childAt.getLeft()) + hitSlopRect.right)) && scrollY >= ((float) (-hitSlopRect.top)) && scrollY < ((float) ((childAt.getBottom() - childAt.getTop()) + hitSlopRect.bottom))) {
                        pointF.set(scrollX, scrollY);
                        z = true;
                        if (!z) {
                            float f3 = fArr[0];
                            float f4 = fArr[1];
                            fArr[0] = pointF.x;
                            fArr[1] = pointF.y;
                            PointerEvents pointerEvents = PointerEvents.BOX_NONE;
                            PointerEvents pointerEvents2 = PointerEvents.BOX_ONLY;
                            PointerEvents pointerEvents3 = PointerEvents.NONE;
                            PointerEvents pointerEvents4 = PointerEvents.AUTO;
                            PointerEvents pointerEvents5 = childAt instanceof ReactPointerEventsView ? ((ReactPointerEventsView) childAt).getPointerEvents() : pointerEvents4;
                            if (!childAt.isEnabled()) {
                                if (pointerEvents5 == pointerEvents4) {
                                    pointerEvents5 = pointerEvents;
                                } else if (pointerEvents5 == pointerEvents2) {
                                    pointerEvents5 = pointerEvents3;
                                }
                            }
                            if (pointerEvents5 != pointerEvents3) {
                                if (pointerEvents5 != pointerEvents2) {
                                    if (pointerEvents5 == pointerEvents) {
                                        if (childAt instanceof ViewGroup) {
                                            View findTouchTargetView = findTouchTargetView(fArr, (ViewGroup) childAt);
                                            if (findTouchTargetView != childAt) {
                                                childAt = findTouchTargetView;
                                            } else if (childAt instanceof ReactCompoundView) {
                                            }
                                        }
                                    } else if (pointerEvents5 != pointerEvents4) {
                                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("Unknown pointer event type: ");
                                        outline15.append(pointerEvents5.toString());
                                        throw new JSApplicationIllegalArgumentException(outline15.toString());
                                    } else if ((!(childAt instanceof ReactCompoundViewGroup) || !((ReactCompoundViewGroup) childAt).interceptsTouchEvent(fArr[0], fArr[1])) && (childAt instanceof ViewGroup)) {
                                        childAt = findTouchTargetView(fArr, (ViewGroup) childAt);
                                    }
                                }
                                if (childAt == null) {
                                    return childAt;
                                }
                                fArr[0] = f3;
                                fArr[1] = f4;
                            }
                            childAt = null;
                            if (childAt == null) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            if (scrollX >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && scrollX < ((float) (childAt.getRight() - childAt.getLeft())) && scrollY >= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && scrollY < ((float) (childAt.getBottom() - childAt.getTop()))) {
                pointF.set(scrollX, scrollY);
                z = true;
                if (!z) {
                }
            }
            z = false;
            if (!z) {
            }
        }
        return viewGroup;
    }
}
