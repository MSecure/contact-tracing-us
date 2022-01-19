package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.react.devsupport.FpsView;
import com.facebook.react.uimanager.BaseViewManager;

public class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] EMPTY_STATE_SET = new int[0];
    public static final int[] PRESSED_STATE_SET = {16842919};
    public int mAnimationState = 0;
    public int mDragState = 0;
    public final Runnable mHideRunnable = new Runnable() {
        /* class androidx.recyclerview.widget.FastScroller.AnonymousClass1 */

        public void run() {
            FastScroller fastScroller = FastScroller.this;
            int i = fastScroller.mAnimationState;
            if (i == 1) {
                fastScroller.mShowHideAnimator.cancel();
            } else if (i != 2) {
                return;
            }
            fastScroller.mAnimationState = 3;
            ValueAnimator valueAnimator = fastScroller.mShowHideAnimator;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            fastScroller.mShowHideAnimator.setDuration((long) FpsView.UPDATE_INTERVAL_MS);
            fastScroller.mShowHideAnimator.start();
        }
    };
    public float mHorizontalDragX;
    public final int[] mHorizontalRange = new int[2];
    public int mHorizontalThumbCenterX;
    public final StateListDrawable mHorizontalThumbDrawable;
    public final int mHorizontalThumbHeight;
    public int mHorizontalThumbWidth;
    public final Drawable mHorizontalTrackDrawable;
    public final int mHorizontalTrackHeight;
    public final int mMargin;
    public boolean mNeedHorizontalScrollbar = false;
    public boolean mNeedVerticalScrollbar = false;
    public final RecyclerView.OnScrollListener mOnScrollListener = new RecyclerView.OnScrollListener() {
        /* class androidx.recyclerview.widget.FastScroller.AnonymousClass2 */

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            FastScroller fastScroller = FastScroller.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = fastScroller.mRecyclerView.computeVerticalScrollRange();
            int i3 = fastScroller.mRecyclerViewHeight;
            fastScroller.mNeedVerticalScrollbar = computeVerticalScrollRange - i3 > 0 && i3 >= fastScroller.mScrollbarMinimumRange;
            int computeHorizontalScrollRange = fastScroller.mRecyclerView.computeHorizontalScrollRange();
            int i4 = fastScroller.mRecyclerViewWidth;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= fastScroller.mScrollbarMinimumRange;
            fastScroller.mNeedHorizontalScrollbar = z;
            if (fastScroller.mNeedVerticalScrollbar || z) {
                if (fastScroller.mNeedVerticalScrollbar) {
                    float f = (float) i3;
                    fastScroller.mVerticalThumbCenterY = (int) ((((f / 2.0f) + ((float) computeVerticalScrollOffset)) * f) / ((float) computeVerticalScrollRange));
                    fastScroller.mVerticalThumbHeight = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (fastScroller.mNeedHorizontalScrollbar) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i4;
                    fastScroller.mHorizontalThumbCenterX = (int) ((((f3 / 2.0f) + f2) * f3) / ((float) computeHorizontalScrollRange));
                    fastScroller.mHorizontalThumbWidth = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                int i5 = fastScroller.mState;
                if (i5 == 0 || i5 == 1) {
                    fastScroller.setState(1);
                }
            } else if (fastScroller.mState != 0) {
                fastScroller.setState(0);
            }
        }
    };
    public RecyclerView mRecyclerView;
    public int mRecyclerViewHeight = 0;
    public int mRecyclerViewWidth = 0;
    public final int mScrollbarMinimumRange;
    public final ValueAnimator mShowHideAnimator = ValueAnimator.ofFloat(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, 1.0f);
    public int mState = 0;
    public float mVerticalDragY;
    public final int[] mVerticalRange = new int[2];
    public int mVerticalThumbCenterY;
    public final StateListDrawable mVerticalThumbDrawable;
    public int mVerticalThumbHeight;
    public final int mVerticalThumbWidth;
    public final Drawable mVerticalTrackDrawable;
    public final int mVerticalTrackWidth;

    public class AnimatorListener extends AnimatorListenerAdapter {
        public boolean mCanceled = false;

        public AnimatorListener() {
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mCanceled) {
                this.mCanceled = false;
            } else if (((Float) FastScroller.this.mShowHideAnimator.getAnimatedValue()).floatValue() == BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.mAnimationState = 0;
                fastScroller.setState(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.mAnimationState = 2;
                fastScroller2.mRecyclerView.invalidate();
            }
        }
    }

    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.mVerticalThumbDrawable.setAlpha(floatValue);
            FastScroller.this.mVerticalTrackDrawable.setAlpha(floatValue);
            FastScroller.this.mRecyclerView.invalidate();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.mVerticalThumbDrawable = stateListDrawable;
        this.mVerticalTrackDrawable = drawable;
        this.mHorizontalThumbDrawable = stateListDrawable2;
        this.mHorizontalTrackDrawable = drawable2;
        this.mVerticalThumbWidth = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.mVerticalTrackWidth = Math.max(i, drawable.getIntrinsicWidth());
        this.mHorizontalThumbHeight = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.mHorizontalTrackHeight = Math.max(i, drawable2.getIntrinsicWidth());
        this.mScrollbarMinimumRange = i2;
        this.mMargin = i3;
        this.mVerticalThumbDrawable.setAlpha(255);
        this.mVerticalTrackDrawable.setAlpha(255);
        this.mShowHideAnimator.addListener(new AnimatorListener());
        this.mShowHideAnimator.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.mRecyclerView.removeOnItemTouchListener(this);
                this.mRecyclerView.removeOnScrollListener(this.mOnScrollListener);
                cancelHide();
            }
            this.mRecyclerView = recyclerView;
            recyclerView.addItemDecoration(this);
            this.mRecyclerView.addOnItemTouchListener(this);
            this.mRecyclerView.addOnScrollListener(this.mOnScrollListener);
        }
    }

    public final void cancelHide() {
        this.mRecyclerView.removeCallbacks(this.mHideRunnable);
    }

    public boolean isPointInsideHorizontalThumb(float f, float f2) {
        if (f2 >= ((float) (this.mRecyclerViewHeight - this.mHorizontalThumbHeight))) {
            int i = this.mHorizontalThumbCenterX;
            int i2 = this.mHorizontalThumbWidth;
            return f >= ((float) (i - (i2 / 2))) && f <= ((float) ((i2 / 2) + i));
        }
    }

    public boolean isPointInsideVerticalThumb(float f, float f2) {
        if (ViewCompat.getLayoutDirection(this.mRecyclerView) == 1) {
            if (f > ((float) (this.mVerticalThumbWidth / 2))) {
                return false;
            }
        } else if (f < ((float) (this.mRecyclerViewWidth - this.mVerticalThumbWidth))) {
            return false;
        }
        int i = this.mVerticalThumbCenterY;
        int i2 = this.mVerticalThumbHeight / 2;
        return f2 >= ((float) (i - i2)) && f2 <= ((float) (i2 + i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.mRecyclerViewWidth != this.mRecyclerView.getWidth() || this.mRecyclerViewHeight != this.mRecyclerView.getHeight()) {
            this.mRecyclerViewWidth = this.mRecyclerView.getWidth();
            this.mRecyclerViewHeight = this.mRecyclerView.getHeight();
            setState(0);
        } else if (this.mAnimationState != 0) {
            if (this.mNeedVerticalScrollbar) {
                int i = this.mRecyclerViewWidth;
                int i2 = this.mVerticalThumbWidth;
                int i3 = i - i2;
                int i4 = this.mVerticalThumbCenterY;
                int i5 = this.mVerticalThumbHeight;
                int i6 = i4 - (i5 / 2);
                this.mVerticalThumbDrawable.setBounds(0, 0, i2, i5);
                this.mVerticalTrackDrawable.setBounds(0, 0, this.mVerticalTrackWidth, this.mRecyclerViewHeight);
                boolean z = true;
                if (ViewCompat.getLayoutDirection(this.mRecyclerView) != 1) {
                    z = false;
                }
                if (z) {
                    this.mVerticalTrackDrawable.draw(canvas);
                    canvas.translate((float) this.mVerticalThumbWidth, (float) i6);
                    canvas.scale(-1.0f, 1.0f);
                    this.mVerticalThumbDrawable.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    canvas.translate((float) (-this.mVerticalThumbWidth), (float) (-i6));
                } else {
                    canvas.translate((float) i3, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                    this.mVerticalTrackDrawable.draw(canvas);
                    canvas.translate(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) i6);
                    this.mVerticalThumbDrawable.draw(canvas);
                    canvas.translate((float) (-i3), (float) (-i6));
                }
            }
            if (this.mNeedHorizontalScrollbar) {
                int i7 = this.mRecyclerViewHeight;
                int i8 = this.mHorizontalThumbHeight;
                int i9 = i7 - i8;
                int i10 = this.mHorizontalThumbCenterX;
                int i11 = this.mHorizontalThumbWidth;
                int i12 = i10 - (i11 / 2);
                this.mHorizontalThumbDrawable.setBounds(0, 0, i11, i8);
                this.mHorizontalTrackDrawable.setBounds(0, 0, this.mRecyclerViewWidth, this.mHorizontalTrackHeight);
                canvas.translate(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, (float) i9);
                this.mHorizontalTrackDrawable.draw(canvas);
                canvas.translate((float) i12, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
                this.mHorizontalThumbDrawable.draw(canvas);
                canvas.translate((float) (-i12), (float) (-i9));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.mState;
        if (i == 1) {
            boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
            boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (isPointInsideVerticalThumb || isPointInsideHorizontalThumb)) {
                if (isPointInsideHorizontalThumb) {
                    this.mDragState = 1;
                    this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                } else if (isPointInsideVerticalThumb) {
                    this.mDragState = 2;
                    this.mVerticalDragY = (float) ((int) motionEvent.getY());
                }
                setState(2);
                return true;
            }
        } else if (i == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.mState != 0) {
            if (motionEvent.getAction() == 0) {
                boolean isPointInsideVerticalThumb = isPointInsideVerticalThumb(motionEvent.getX(), motionEvent.getY());
                boolean isPointInsideHorizontalThumb = isPointInsideHorizontalThumb(motionEvent.getX(), motionEvent.getY());
                if (isPointInsideVerticalThumb || isPointInsideHorizontalThumb) {
                    if (isPointInsideHorizontalThumb) {
                        this.mDragState = 1;
                        this.mHorizontalDragX = (float) ((int) motionEvent.getX());
                    } else if (isPointInsideVerticalThumb) {
                        this.mDragState = 2;
                        this.mVerticalDragY = (float) ((int) motionEvent.getY());
                    }
                    setState(2);
                }
            } else if (motionEvent.getAction() == 1 && this.mState == 2) {
                this.mVerticalDragY = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                this.mHorizontalDragX = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                setState(1);
                this.mDragState = 0;
            } else if (motionEvent.getAction() == 2 && this.mState == 2) {
                show();
                if (this.mDragState == 1) {
                    float x = motionEvent.getX();
                    int[] iArr = this.mHorizontalRange;
                    int i = this.mMargin;
                    iArr[0] = i;
                    iArr[1] = this.mRecyclerViewWidth - i;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x));
                    if (Math.abs(((float) this.mHorizontalThumbCenterX) - max) >= 2.0f) {
                        int scrollTo = scrollTo(this.mHorizontalDragX, max, iArr, this.mRecyclerView.computeHorizontalScrollRange(), this.mRecyclerView.computeHorizontalScrollOffset(), this.mRecyclerViewWidth);
                        if (scrollTo != 0) {
                            this.mRecyclerView.scrollBy(scrollTo, 0);
                        }
                        this.mHorizontalDragX = max;
                    }
                }
                if (this.mDragState == 2) {
                    float y = motionEvent.getY();
                    int[] iArr2 = this.mVerticalRange;
                    int i2 = this.mMargin;
                    iArr2[0] = i2;
                    iArr2[1] = this.mRecyclerViewHeight - i2;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y));
                    if (Math.abs(((float) this.mVerticalThumbCenterY) - max2) >= 2.0f) {
                        int scrollTo2 = scrollTo(this.mVerticalDragY, max2, iArr2, this.mRecyclerView.computeVerticalScrollRange(), this.mRecyclerView.computeVerticalScrollOffset(), this.mRecyclerViewHeight);
                        if (scrollTo2 != 0) {
                            this.mRecyclerView.scrollBy(0, scrollTo2);
                        }
                        this.mVerticalDragY = max2;
                    }
                }
            }
        }
    }

    public final int scrollTo(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / ((float) i4)) * ((float) i5));
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    public void setState(int i) {
        if (i == 2 && this.mState != 2) {
            this.mVerticalThumbDrawable.setState(PRESSED_STATE_SET);
            cancelHide();
        }
        if (i == 0) {
            this.mRecyclerView.invalidate();
        } else {
            show();
        }
        if (this.mState == 2 && i != 2) {
            this.mVerticalThumbDrawable.setState(EMPTY_STATE_SET);
            cancelHide();
            this.mRecyclerView.postDelayed(this.mHideRunnable, (long) 1200);
        } else if (i == 1) {
            cancelHide();
            this.mRecyclerView.postDelayed(this.mHideRunnable, (long) 1500);
        }
        this.mState = i;
    }

    public void show() {
        int i = this.mAnimationState;
        if (i != 0) {
            if (i == 3) {
                this.mShowHideAnimator.cancel();
            } else {
                return;
            }
        }
        this.mAnimationState = 1;
        ValueAnimator valueAnimator = this.mShowHideAnimator;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.mShowHideAnimator.setDuration(500L);
        this.mShowHideAnimator.setStartDelay(0);
        this.mShowHideAnimator.start();
    }
}
