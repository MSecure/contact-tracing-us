package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.BaseViewManager;
import java.util.Map;

public class ChangeBounds extends Transition {
    public static final Property<View, PointF> BOTTOM_RIGHT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "bottomRight") {
        /* class androidx.transition.ChangeBounds.AnonymousClass4 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ViewUtils.setLeftTopRightBottom(view2, view2.getLeft(), view2.getTop(), Math.round(pointF2.x), Math.round(pointF2.y));
        }
    };
    public static final Property<ViewBounds, PointF> BOTTOM_RIGHT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "bottomRight") {
        /* class androidx.transition.ChangeBounds.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            ViewBounds viewBounds2 = viewBounds;
            PointF pointF2 = pointF;
            if (viewBounds2 != null) {
                viewBounds2.mRight = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                viewBounds2.mBottom = round;
                int i = viewBounds2.mBottomRightCalls + 1;
                viewBounds2.mBottomRightCalls = i;
                if (viewBounds2.mTopLeftCalls == i) {
                    ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, viewBounds2.mTop, viewBounds2.mRight, round);
                    viewBounds2.mTopLeftCalls = 0;
                    viewBounds2.mBottomRightCalls = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    };
    public static final Property<Drawable, PointF> DRAWABLE_ORIGIN_PROPERTY = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") {
        /* class androidx.transition.ChangeBounds.AnonymousClass1 */
        public Rect mBounds = new Rect();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.mBounds);
            Rect rect = this.mBounds;
            return new PointF((float) rect.left, (float) rect.top);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(Drawable drawable, PointF pointF) {
            Drawable drawable2 = drawable;
            PointF pointF2 = pointF;
            drawable2.copyBounds(this.mBounds);
            this.mBounds.offsetTo(Math.round(pointF2.x), Math.round(pointF2.y));
            drawable2.setBounds(this.mBounds);
        }
    };
    public static final Property<View, PointF> POSITION_PROPERTY = new Property<View, PointF>(PointF.class, "position") {
        /* class androidx.transition.ChangeBounds.AnonymousClass6 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            int round = Math.round(pointF2.x);
            int round2 = Math.round(pointF2.y);
            ViewUtils.setLeftTopRightBottom(view2, round, round2, view2.getWidth() + round, view2.getHeight() + round2);
        }
    };
    public static final Property<View, PointF> TOP_LEFT_ONLY_PROPERTY = new Property<View, PointF>(PointF.class, "topLeft") {
        /* class androidx.transition.ChangeBounds.AnonymousClass5 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(View view) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(View view, PointF pointF) {
            View view2 = view;
            PointF pointF2 = pointF;
            ViewUtils.setLeftTopRightBottom(view2, Math.round(pointF2.x), Math.round(pointF2.y), view2.getRight(), view2.getBottom());
        }
    };
    public static final Property<ViewBounds, PointF> TOP_LEFT_PROPERTY = new Property<ViewBounds, PointF>(PointF.class, "topLeft") {
        /* class androidx.transition.ChangeBounds.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public PointF get(ViewBounds viewBounds) {
            return null;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(ViewBounds viewBounds, PointF pointF) {
            ViewBounds viewBounds2 = viewBounds;
            PointF pointF2 = pointF;
            if (viewBounds2 != null) {
                viewBounds2.mLeft = Math.round(pointF2.x);
                int round = Math.round(pointF2.y);
                viewBounds2.mTop = round;
                int i = viewBounds2.mTopLeftCalls + 1;
                viewBounds2.mTopLeftCalls = i;
                if (i == viewBounds2.mBottomRightCalls) {
                    ViewUtils.setLeftTopRightBottom(viewBounds2.mView, viewBounds2.mLeft, round, viewBounds2.mRight, viewBounds2.mBottom);
                    viewBounds2.mTopLeftCalls = 0;
                    viewBounds2.mBottomRightCalls = 0;
                    return;
                }
                return;
            }
            throw null;
        }
    };
    public static RectEvaluator sRectEvaluator = new RectEvaluator();
    public static final String[] sTransitionProperties = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public boolean mReparent = false;
    public boolean mResizeClip = false;
    public int[] mTempLocation = new int[2];

    public static class ViewBounds {
        public int mBottom;
        public int mBottomRightCalls;
        public int mLeft;
        public int mRight;
        public int mTop;
        public int mTopLeftCalls;
        public View mView;

        public ViewBounds(View view) {
            this.mView = view;
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (ViewCompat.isLaidOut(view) || view.getWidth() != 0 || view.getHeight() != 0) {
            transitionValues.values.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            transitionValues.values.put("android:changeBounds:parent", transitionValues.view.getParent());
            if (this.mReparent) {
                transitionValues.view.getLocationInWindow(this.mTempLocation);
                transitionValues.values.put("android:changeBounds:windowX", Integer.valueOf(this.mTempLocation[0]));
                transitionValues.values.put("android:changeBounds:windowY", Integer.valueOf(this.mTempLocation[1]));
            }
            if (this.mResizeClip) {
                transitionValues.values.put("android:changeBounds:clip", view.getClipBounds());
            }
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        final View view;
        Animator animator;
        ObjectAnimator objectAnimator;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator2;
        TransitionValues matchedTransitionValues;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = transitionValues2.view;
        if (!this.mReparent || ((matchedTransitionValues = getMatchedTransitionValues(viewGroup2, true)) != null ? viewGroup3 == matchedTransitionValues.view : viewGroup2 == viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.values.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) transitionValues2.values.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) transitionValues.values.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) transitionValues2.values.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (!(i7 == i8 && i9 == i10)) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            if (!this.mResizeClip) {
                view = view2;
                ViewUtils.setLeftTopRightBottom(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animator = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(view, POSITION_PROPERTY, this.mPathMotion.getPath((float) i3, (float) i5, (float) i4, (float) i6));
                    } else {
                        final ViewBounds viewBounds = new ViewBounds(view);
                        ObjectAnimator ofPointF = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(viewBounds, TOP_LEFT_PROPERTY, this.mPathMotion.getPath((float) i3, (float) i5, (float) i4, (float) i6));
                        ObjectAnimator ofPointF2 = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(viewBounds, BOTTOM_RIGHT_PROPERTY, this.mPathMotion.getPath((float) i7, (float) i9, (float) i8, (float) i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(ofPointF, ofPointF2);
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            /* class androidx.transition.ChangeBounds.AnonymousClass7 */
                            public ViewBounds mViewBounds = viewBounds;
                        });
                        animator = animatorSet;
                    }
                } else if (i3 == i4 && i5 == i6) {
                    animator = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(view, BOTTOM_RIGHT_ONLY_PROPERTY, this.mPathMotion.getPath((float) i7, (float) i9, (float) i8, (float) i10));
                } else {
                    animator = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(view, TOP_LEFT_ONLY_PROPERTY, this.mPathMotion.getPath((float) i3, (float) i5, (float) i4, (float) i6));
                }
            } else {
                view = view2;
                ViewUtils.setLeftTopRightBottom(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                if (i3 == i4 && i5 == i6) {
                    objectAnimator = null;
                } else {
                    objectAnimator = AppCompatDelegateImpl.ConfigurationImplApi17.ofPointF(view, POSITION_PROPERTY, this.mPathMotion.getPath((float) i3, (float) i5, (float) i4, (float) i6));
                }
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (!rect.equals(rect6)) {
                    ViewCompat.setClipBounds(view, rect);
                    RectEvaluator rectEvaluator = sRectEvaluator;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                    ofObject.addListener(new AnimatorListenerAdapter() {
                        /* class androidx.transition.ChangeBounds.AnonymousClass8 */
                        public boolean mIsCanceled;

                        public void onAnimationCancel(Animator animator) {
                            this.mIsCanceled = true;
                        }

                        public void onAnimationEnd(Animator animator) {
                            if (!this.mIsCanceled) {
                                ViewCompat.setClipBounds(view, rect5);
                                ViewUtils.setLeftTopRightBottom(view, i4, i6, i8, i10);
                            }
                        }
                    });
                    objectAnimator2 = ofObject;
                } else {
                    objectAnimator2 = null;
                }
                animator = TransitionUtils.mergeAnimators(objectAnimator, objectAnimator2);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                ViewGroupUtils.suppressLayout(viewGroup4, true);
                addListener(new TransitionListenerAdapter() {
                    /* class androidx.transition.ChangeBounds.AnonymousClass9 */
                    public boolean mCanceled = false;

                    @Override // androidx.transition.Transition.TransitionListener, androidx.transition.TransitionListenerAdapter
                    public void onTransitionCancel(Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                        this.mCanceled = true;
                    }

                    @Override // androidx.transition.Transition.TransitionListener
                    public void onTransitionEnd(Transition transition) {
                        if (!this.mCanceled) {
                            ViewGroupUtils.suppressLayout(viewGroup4, false);
                        }
                        transition.removeListener(this);
                    }

                    @Override // androidx.transition.Transition.TransitionListener, androidx.transition.TransitionListenerAdapter
                    public void onTransitionPause(Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, false);
                    }

                    @Override // androidx.transition.Transition.TransitionListener, androidx.transition.TransitionListenerAdapter
                    public void onTransitionResume(Transition transition) {
                        ViewGroupUtils.suppressLayout(viewGroup4, true);
                    }
                });
            }
            return animator;
        }
        int intValue = ((Integer) transitionValues.values.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues.values.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues2.values.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues2.values.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.mTempLocation);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        final float transitionAlpha = ViewUtils.getTransitionAlpha(view2);
        ViewUtils.IMPL.setTransitionAlpha(view2, BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        viewGroup.getOverlay().add(bitmapDrawable);
        PathMotion pathMotion = this.mPathMotion;
        int[] iArr = this.mTempLocation;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolder.ofObject(DRAWABLE_ORIGIN_PROPERTY, (TypeConverter) null, pathMotion.getPath((float) (intValue - iArr[0]), (float) (intValue2 - iArr[1]), (float) (intValue3 - iArr[0]), (float) (intValue4 - iArr[1]))));
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            /* class androidx.transition.ChangeBounds.AnonymousClass10 */

            public void onAnimationEnd(Animator animator) {
                ViewOverlayImpl overlay = ViewUtils.getOverlay(viewGroup);
                ((ViewOverlayApi18) overlay).mViewOverlay.remove(bitmapDrawable);
                ViewUtils.IMPL.setTransitionAlpha(view2, transitionAlpha);
            }
        });
        return ofPropertyValuesHolder;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
