package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.swiperefresh.RefreshEvent;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;

public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild {
    public static final int[] LAYOUT_ATTRS = {16842766};
    public static final String LOG_TAG = SwipeRefreshLayout.class.getSimpleName();
    public int mActivePointerId = -1;
    public Animation mAlphaMaxAnimation;
    public Animation mAlphaStartAnimation;
    public final Animation mAnimateToCorrectPosition = new Animation() {
        /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass6 */

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (!swipeRefreshLayout.mUsingCustomStart) {
                i = swipeRefreshLayout.mSpinnerOffsetEnd - Math.abs(swipeRefreshLayout.mOriginalOffsetTop);
            } else {
                i = swipeRefreshLayout.mSpinnerOffsetEnd;
            }
            SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
            int i2 = swipeRefreshLayout2.mFrom;
            SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((i2 + ((int) (((float) (i - i2)) * f))) - swipeRefreshLayout2.mCircleView.getTop());
            CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.mProgress;
            float f2 = 1.0f - f;
            CircularProgressDrawable.Ring ring = circularProgressDrawable.mRing;
            if (f2 != ring.mArrowScale) {
                ring.mArrowScale = f2;
            }
            circularProgressDrawable.invalidateSelf();
        }
    };
    public final Animation mAnimateToStartPosition = new Animation() {
        /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass7 */

        public void applyTransformation(float f, Transformation transformation) {
            SwipeRefreshLayout.this.moveToStart(f);
        }
    };
    public OnChildScrollUpCallback mChildScrollUpCallback;
    public int mCircleDiameter;
    public CircleImageView mCircleView;
    public int mCircleViewIndex = -1;
    public int mCurrentTargetOffsetTop;
    public int mCustomSlingshotDistance;
    public final DecelerateInterpolator mDecelerateInterpolator;
    public int mFrom;
    public float mInitialDownY;
    public float mInitialMotionY;
    public boolean mIsBeingDragged;
    public OnRefreshListener mListener;
    public int mMediumAnimationDuration;
    public boolean mNestedScrollInProgress;
    public final NestedScrollingChildHelper mNestedScrollingChildHelper;
    public final NestedScrollingParentHelper mNestedScrollingParentHelper;
    public boolean mNotify;
    public int mOriginalOffsetTop;
    public final int[] mParentOffsetInWindow = new int[2];
    public final int[] mParentScrollConsumed = new int[2];
    public CircularProgressDrawable mProgress;
    public Animation.AnimationListener mRefreshListener = new Animation.AnimationListener() {
        /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass1 */

        public void onAnimationEnd(Animation animation) {
            OnRefreshListener onRefreshListener;
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            if (swipeRefreshLayout.mRefreshing) {
                swipeRefreshLayout.mProgress.setAlpha(255);
                SwipeRefreshLayout.this.mProgress.start();
                SwipeRefreshLayout swipeRefreshLayout2 = SwipeRefreshLayout.this;
                if (swipeRefreshLayout2.mNotify && (onRefreshListener = swipeRefreshLayout2.mListener) != null) {
                    SwipeRefreshLayoutManager.AnonymousClass1 r3 = (SwipeRefreshLayoutManager.AnonymousClass1) onRefreshListener;
                    EventDispatcher eventDispatcherForReactTag = ReactYogaConfigProvider.getEventDispatcherForReactTag(r2, r3.getId());
                    if (eventDispatcherForReactTag != null) {
                        eventDispatcherForReactTag.dispatchEvent(new RefreshEvent(r3.getId()));
                    }
                }
                SwipeRefreshLayout swipeRefreshLayout3 = SwipeRefreshLayout.this;
                swipeRefreshLayout3.mCurrentTargetOffsetTop = swipeRefreshLayout3.mCircleView.getTop();
                return;
            }
            swipeRefreshLayout.reset();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    };
    public boolean mRefreshing = false;
    public boolean mReturningToStart;
    public boolean mScale;
    public Animation mScaleAnimation;
    public Animation mScaleDownAnimation;
    public Animation mScaleDownToStartAnimation;
    public int mSpinnerOffsetEnd;
    public float mStartingScale;
    public View mTarget;
    public float mTotalDragDistance = -1.0f;
    public float mTotalUnconsumed;
    public int mTouchSlop;
    public boolean mUsingCustomStart;

    public interface OnChildScrollUpCallback {
        boolean canChildScrollUp(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface OnRefreshListener {
    }

    public SwipeRefreshLayout(Context context) {
        super(context, null);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
        this.mCircleView = new CircleImageView(getContext(), -328966);
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.mProgress = circularProgressDrawable;
        circularProgressDrawable.setStyle(1);
        this.mCircleView.setImageDrawable(this.mProgress);
        this.mCircleView.setVisibility(8);
        addView(this.mCircleView);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.mSpinnerOffsetEnd = i;
        this.mTotalDragDistance = (float) i;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper();
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i2 = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i2;
        this.mOriginalOffsetTop = i2;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i) {
        this.mCircleView.getBackground().setAlpha(i);
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        circularProgressDrawable.mRing.mAlpha = i;
        circularProgressDrawable.invalidateSelf();
    }

    public boolean canChildScrollUp() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.mChildScrollUpCallback;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.canChildScrollUp(this, this.mTarget);
        }
        View view = this.mTarget;
        if (view instanceof ListView) {
            return ((ListView) view).canScrollList(-1);
        }
        return view.canScrollVertically(-1);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public final void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.mCircleView)) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public final void finishSpinner(float f) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable.mRing;
        ring.mStartTrim = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        ring.mEndTrim = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        circularProgressDrawable.invalidateSelf();
        AnonymousClass5 r0 = null;
        if (!this.mScale) {
            r0 = new Animation.AnimationListener() {
                /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass5 */

                public void onAnimationEnd(Animation animation) {
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    if (!swipeRefreshLayout.mScale) {
                        swipeRefreshLayout.startScaleDownAnimation(null);
                    }
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            };
        }
        int i = this.mCurrentTargetOffsetTop;
        if (this.mScale) {
            this.mFrom = i;
            this.mStartingScale = this.mCircleView.getScaleX();
            AnonymousClass8 r1 = new Animation() {
                /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass8 */

                public void applyTransformation(float f, Transformation transformation) {
                    SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                    float f2 = swipeRefreshLayout.mStartingScale;
                    swipeRefreshLayout.setAnimationProgress(((-f2) * f) + f2);
                    SwipeRefreshLayout.this.moveToStart(f);
                }
            };
            this.mScaleDownToStartAnimation = r1;
            r1.setDuration(150);
            if (r0 != null) {
                this.mCircleView.mListener = r0;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mScaleDownToStartAnimation);
        } else {
            this.mFrom = i;
            this.mAnimateToStartPosition.reset();
            this.mAnimateToStartPosition.setDuration(200);
            this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
            if (r0 != null) {
                this.mCircleView.mListener = r0;
            }
            this.mCircleView.clearAnimation();
            this.mCircleView.startAnimation(this.mAnimateToStartPosition);
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        CircularProgressDrawable.Ring ring2 = circularProgressDrawable2.mRing;
        if (ring2.mShowArrow) {
            ring2.mShowArrow = false;
        }
        circularProgressDrawable2.invalidateSelf();
    }

    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mCircleViewIndex;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        return i2 >= i3 ? i2 + 1 : i2;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent(0);
    }

    public final boolean isAnimationRunning(Animation animation) {
        return animation != null && animation.hasStarted() && !animation.hasEnded();
    }

    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.mIsNestedScrollingEnabled;
    }

    public final void moveSpinner(float f) {
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable.mRing;
        if (!ring.mShowArrow) {
            ring.mShowArrow = true;
        }
        circularProgressDrawable.invalidateSelf();
        float min = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.mTotalDragDistance;
        int i = this.mCustomSlingshotDistance;
        if (i <= 0) {
            i = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        }
        float f2 = (float) i;
        double max2 = (double) (Math.max((float) BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, Math.min(abs, f2 * 2.0f) / f2) / 4.0f);
        float pow = ((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f;
        int i2 = this.mOriginalOffsetTop + ((int) ((f2 * min) + (f2 * pow * 2.0f)));
        if (this.mCircleView.getVisibility() != 0) {
            this.mCircleView.setVisibility(0);
        }
        if (!this.mScale) {
            this.mCircleView.setScaleX(1.0f);
            this.mCircleView.setScaleY(1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f / this.mTotalDragDistance));
        }
        if (f < this.mTotalDragDistance) {
            if (this.mProgress.mRing.mAlpha > 76 && !isAnimationRunning(this.mAlphaStartAnimation)) {
                this.mAlphaStartAnimation = startAlphaAnimation(this.mProgress.mRing.mAlpha, 76);
            }
        } else if (this.mProgress.mRing.mAlpha < 255 && !isAnimationRunning(this.mAlphaMaxAnimation)) {
            this.mAlphaMaxAnimation = startAlphaAnimation(this.mProgress.mRing.mAlpha, 255);
        }
        CircularProgressDrawable circularProgressDrawable2 = this.mProgress;
        float min2 = Math.min(0.8f, max * 0.8f);
        CircularProgressDrawable.Ring ring2 = circularProgressDrawable2.mRing;
        ring2.mStartTrim = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        ring2.mEndTrim = min2;
        circularProgressDrawable2.invalidateSelf();
        CircularProgressDrawable circularProgressDrawable3 = this.mProgress;
        float min3 = Math.min(1.0f, max);
        CircularProgressDrawable.Ring ring3 = circularProgressDrawable3.mRing;
        if (min3 != ring3.mArrowScale) {
            ring3.mArrowScale = min3;
        }
        circularProgressDrawable3.invalidateSelf();
        CircularProgressDrawable circularProgressDrawable4 = this.mProgress;
        circularProgressDrawable4.mRing.mRotation = ((pow * 2.0f) + ((max * 0.4f) - 16.0f)) * 0.5f;
        circularProgressDrawable4.invalidateSelf();
        setTargetOffsetTopAndBottom(i2 - this.mCurrentTargetOffsetTop);
    }

    public void moveToStart(float f) {
        int i = this.mFrom;
        setTargetOffsetTopAndBottom((i + ((int) (((float) (this.mOriginalOffsetTop - i)) * f))) - this.mCircleView.getTop());
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        ensureTarget();
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.mActivePointerId;
                    if (i == -1) {
                        Log.e(LOG_TAG, "Got ACTION_MOVE event but don't have an active pointer id.");
                        return false;
                    }
                    int findPointerIndex = motionEvent.findPointerIndex(i);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    startDragging(motionEvent.getY(findPointerIndex));
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCircleView.getTop());
            int pointerId = motionEvent.getPointerId(0);
            this.mActivePointerId = pointerId;
            this.mIsBeingDragged = false;
            int findPointerIndex2 = motionEvent.findPointerIndex(pointerId);
            if (findPointerIndex2 < 0) {
                return false;
            }
            this.mInitialDownY = motionEvent.getY(findPointerIndex2);
        }
        return this.mIsBeingDragged;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            View view = this.mTarget;
            if (view != null) {
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.mCircleView.getMeasuredWidth();
                int measuredHeight2 = this.mCircleView.getMeasuredHeight();
                int i5 = measuredWidth / 2;
                int i6 = measuredWidth2 / 2;
                int i7 = this.mCurrentTargetOffsetTop;
                this.mCircleView.layout(i5 - i6, i7, i5 + i6, measuredHeight2 + i7);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        View view = this.mTarget;
        if (view != null) {
            view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.mCircleView.measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.mCircleView) {
                    this.mCircleViewIndex = i3;
                    return;
                }
            }
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0) {
            float f = this.mTotalUnconsumed;
            if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                float f2 = (float) i2;
                if (f2 > f) {
                    iArr[1] = i2 - ((int) f);
                    this.mTotalUnconsumed = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                } else {
                    this.mTotalUnconsumed = f - f2;
                    iArr[1] = i2;
                }
                moveSpinner(this.mTotalUnconsumed);
            }
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER && Math.abs(i2 - iArr[1]) > 0) {
            this.mCircleView.setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = i4 + this.mParentOffsetInWindow[1];
        if (i5 < 0 && !canChildScrollUp()) {
            float abs = this.mTotalUnconsumed + ((float) Math.abs(i5));
            this.mTotalUnconsumed = abs;
            moveSpinner(abs);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.mNestedScrollAxesTouch = i;
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        this.mNestedScrollInProgress = true;
    }

    public final void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return isEnabled() && !this.mReturningToStart && !this.mRefreshing && (i & 2) != 0;
    }

    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(0);
        this.mNestedScrollInProgress = false;
        float f = this.mTotalUnconsumed;
        if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
            finishSpinner(f);
            this.mTotalUnconsumed = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        }
        stopNestedScroll();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        if (actionMasked == 0) {
            this.mActivePointerId = motionEvent.getPointerId(0);
            this.mIsBeingDragged = false;
        } else if (actionMasked == 1) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex < 0) {
                Log.e(LOG_TAG, "Got ACTION_UP event but don't have an active pointer id.");
                return false;
            }
            if (this.mIsBeingDragged) {
                this.mIsBeingDragged = false;
                finishSpinner((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f);
            }
            this.mActivePointerId = -1;
            return false;
        } else if (actionMasked == 2) {
            int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
            if (findPointerIndex2 < 0) {
                Log.e(LOG_TAG, "Got ACTION_MOVE event but have an invalid active pointer id.");
                return false;
            }
            float y = motionEvent.getY(findPointerIndex2);
            startDragging(y);
            if (this.mIsBeingDragged) {
                float f = (y - this.mInitialMotionY) * 0.5f;
                if (f <= BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                    return false;
                }
                moveSpinner(f);
            }
        } else if (actionMasked == 3) {
            return false;
        } else {
            if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(LOG_TAG, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
            }
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        View view = this.mTarget;
        if (view == null || ViewCompat.isNestedScrollingEnabled(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void reset() {
        this.mCircleView.clearAnimation();
        this.mProgress.stop();
        this.mCircleView.setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        } else {
            setTargetOffsetTopAndBottom(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop);
        }
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public void setAnimationProgress(float f) {
        this.mCircleView.setScaleX(f);
        this.mCircleView.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        CircularProgressDrawable circularProgressDrawable = this.mProgress;
        CircularProgressDrawable.Ring ring = circularProgressDrawable.mRing;
        ring.mColors = iArr;
        ring.setColorIndex(0);
        circularProgressDrawable.mRing.setColorIndex(0);
        circularProgressDrawable.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.getColor(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = (float) i;
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        NestedScrollingChildHelper nestedScrollingChildHelper = this.mNestedScrollingChildHelper;
        if (nestedScrollingChildHelper.mIsNestedScrollingEnabled) {
            ViewCompat.stopNestedScroll(nestedScrollingChildHelper.mView);
        }
        nestedScrollingChildHelper.mIsNestedScrollingEnabled = z;
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.mChildScrollUpCallback = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mListener = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.mCircleView.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.getColor(getContext(), i));
    }

    public void setRefreshing(boolean z) {
        int i;
        if (!z || this.mRefreshing == z) {
            setRefreshing(z, false);
            return;
        }
        this.mRefreshing = z;
        if (!this.mUsingCustomStart) {
            i = this.mSpinnerOffsetEnd + this.mOriginalOffsetTop;
        } else {
            i = this.mSpinnerOffsetEnd;
        }
        setTargetOffsetTopAndBottom(i - this.mCurrentTargetOffsetTop);
        this.mNotify = false;
        Animation.AnimationListener animationListener = this.mRefreshListener;
        this.mCircleView.setVisibility(0);
        this.mProgress.setAlpha(255);
        AnonymousClass2 r0 = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass2 */

            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.mScaleAnimation = r0;
        r0.setDuration((long) this.mMediumAnimationDuration);
        if (animationListener != null) {
            this.mCircleView.mListener = animationListener;
        }
        this.mCircleView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleAnimation);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 40.0f);
            }
            this.mCircleView.setImageDrawable(null);
            this.mProgress.setStyle(i);
            this.mCircleView.setImageDrawable(this.mProgress);
        }
    }

    public void setSlingshotDistance(int i) {
        this.mCustomSlingshotDistance = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        this.mCircleView.bringToFront();
        ViewCompat.offsetTopAndBottom(this.mCircleView, i);
        this.mCurrentTargetOffsetTop = this.mCircleView.getTop();
    }

    public final Animation startAlphaAnimation(final int i, final int i2) {
        AnonymousClass4 r0 = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass4 */

            public void applyTransformation(float f, Transformation transformation) {
                CircularProgressDrawable circularProgressDrawable = SwipeRefreshLayout.this.mProgress;
                int i = i;
                circularProgressDrawable.setAlpha((int) ((((float) (i2 - i)) * f) + ((float) i)));
            }
        };
        r0.setDuration(300);
        CircleImageView circleImageView = this.mCircleView;
        circleImageView.mListener = null;
        circleImageView.clearAnimation();
        this.mCircleView.startAnimation(r0);
        return r0;
    }

    public final void startDragging(float f) {
        float f2 = this.mInitialDownY;
        int i = this.mTouchSlop;
        if (f - f2 > ((float) i) && !this.mIsBeingDragged) {
            this.mInitialMotionY = f2 + ((float) i);
            this.mIsBeingDragged = true;
            this.mProgress.setAlpha(76);
        }
    }

    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i, 0);
    }

    public void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        AnonymousClass3 r0 = new Animation() {
            /* class androidx.swiperefreshlayout.widget.SwipeRefreshLayout.AnonymousClass3 */

            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation = r0;
        r0.setDuration(150);
        CircleImageView circleImageView = this.mCircleView;
        circleImageView.mListener = animationListener;
        circleImageView.clearAnimation();
        this.mCircleView.startAnimation(this.mScaleDownAnimation);
    }

    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll(0);
    }

    public final void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (z) {
                int i = this.mCurrentTargetOffsetTop;
                Animation.AnimationListener animationListener = this.mRefreshListener;
                this.mFrom = i;
                this.mAnimateToCorrectPosition.reset();
                this.mAnimateToCorrectPosition.setDuration(200);
                this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
                if (animationListener != null) {
                    this.mCircleView.mListener = animationListener;
                }
                this.mCircleView.clearAnimation();
                this.mCircleView.startAnimation(this.mAnimateToCorrectPosition);
                return;
            }
            startScaleDownAnimation(this.mRefreshListener);
        }
    }
}
