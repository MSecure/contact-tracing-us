package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import com.facebook.react.uimanager.BaseViewManager;

public abstract class Visibility extends Transition {
    public static final String[] sTransitionProperties = {"android:visibility:visibility", "android:visibility:parent"};
    public int mMode = 3;

    public static class DisappearListener extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public boolean mCanceled = false;
        public final int mFinalVisibility;
        public boolean mLayoutSuppressed;
        public final ViewGroup mParent;
        public final boolean mSuppressLayout;
        public final View mView;

        public DisappearListener(View view, int i, boolean z) {
            this.mView = view;
            this.mFinalVisibility = i;
            this.mParent = (ViewGroup) view.getParent();
            this.mSuppressLayout = z;
            suppressLayout(true);
        }

        public final void hideViewWhenNotCanceled() {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, this.mFinalVisibility);
                ViewGroup viewGroup = this.mParent;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            suppressLayout(false);
        }

        public void onAnimationCancel(Animator animator) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator animator) {
            hideViewWhenNotCanceled();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.mCanceled) {
                ViewUtils.IMPL.setTransitionVisibility(this.mView, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            hideViewWhenNotCanceled();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            suppressLayout(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            suppressLayout(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }

        public final void suppressLayout(boolean z) {
            ViewGroup viewGroup;
            if (this.mSuppressLayout && this.mLayoutSuppressed != z && (viewGroup = this.mParent) != null) {
                this.mLayoutSuppressed = z;
                ViewGroupUtils.suppressLayout(viewGroup, z);
            }
        }
    }

    public static class VisibilityInfo {
        public ViewGroup mEndParent;
        public int mEndVisibility;
        public boolean mFadeIn;
        public ViewGroup mStartParent;
        public int mStartVisibility;
        public boolean mVisibilityChange;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public final void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put("android:visibility:visibility", Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put("android:visibility:parent", transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e1, code lost:
        if (r12.mCanRemoveViews != false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    @Override // androidx.transition.Transition
    public Animator createAnimator(final ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean z;
        View view;
        boolean z2;
        View view2;
        Float f;
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        Animator animator = null;
        if (visibilityChangeInfo.mVisibilityChange && !(visibilityChangeInfo.mStartParent == null && visibilityChangeInfo.mEndParent == null)) {
            if (!visibilityChangeInfo.mFadeIn) {
                int i = visibilityChangeInfo.mEndVisibility;
                if ((this.mMode & 2) == 2 && transitionValues != null) {
                    final View view3 = transitionValues.view;
                    View view4 = transitionValues2 != null ? transitionValues2.view : null;
                    final View view5 = (View) view3.getTag(R$id.save_overlay_view);
                    if (view5 != null) {
                        view = null;
                        z = true;
                    } else {
                        if (view4 == null || view4.getParent() == null) {
                            if (view4 != null) {
                                view2 = null;
                                z2 = false;
                                if (z2) {
                                    if (view3.getParent() != null) {
                                        if (view3.getParent() instanceof View) {
                                            View view6 = (View) view3.getParent();
                                            if (!getVisibilityChangeInfo(getTransitionValues(view6, true), getMatchedTransitionValues(view6, true)).mVisibilityChange) {
                                                view4 = TransitionUtils.copyViewImage(viewGroup, view3, view6);
                                            } else {
                                                int id = view6.getId();
                                                if (view6.getParent() == null) {
                                                    if (id != -1) {
                                                        if (viewGroup.findViewById(id) != null) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    view = view2;
                                    view5 = view3;
                                }
                                z = false;
                                view5 = view4;
                                view = view2;
                            }
                        } else if (i == 4 || view3 == view4) {
                            z2 = false;
                            view2 = view4;
                            view4 = null;
                            if (z2) {
                            }
                            z = false;
                            view5 = view4;
                            view = view2;
                        }
                        view4 = null;
                        view2 = null;
                        z2 = true;
                        if (z2) {
                        }
                        z = false;
                        view5 = view4;
                        view = view2;
                    }
                    if (view5 != null) {
                        if (!z) {
                            int[] iArr = (int[]) transitionValues.values.get("android:visibility:screenLocation");
                            int i2 = iArr[0];
                            int i3 = iArr[1];
                            int[] iArr2 = new int[2];
                            viewGroup.getLocationOnScreen(iArr2);
                            view5.offsetLeftAndRight((i2 - iArr2[0]) - view5.getLeft());
                            view5.offsetTopAndBottom((i3 - iArr2[1]) - view5.getTop());
                            viewGroup.getOverlay().add(view5);
                        }
                        animator = onDisappear(viewGroup, view5, transitionValues, transitionValues2);
                        if (!z) {
                            if (animator == null) {
                                viewGroup.getOverlay().remove(view5);
                            } else {
                                view3.setTag(R$id.save_overlay_view, view5);
                                addListener(new TransitionListenerAdapter() {
                                    /* class androidx.transition.Visibility.AnonymousClass1 */

                                    @Override // androidx.transition.Transition.TransitionListener
                                    public void onTransitionEnd(Transition transition) {
                                        view3.setTag(R$id.save_overlay_view, null);
                                        viewGroup.getOverlay().remove(view5);
                                        transition.removeListener(this);
                                    }

                                    @Override // androidx.transition.Transition.TransitionListener, androidx.transition.TransitionListenerAdapter
                                    public void onTransitionPause(Transition transition) {
                                        viewGroup.getOverlay().remove(view5);
                                    }

                                    @Override // androidx.transition.Transition.TransitionListener, androidx.transition.TransitionListenerAdapter
                                    public void onTransitionResume(Transition transition) {
                                        if (view5.getParent() == null) {
                                            viewGroup.getOverlay().add(view5);
                                        } else {
                                            Visibility.this.cancel();
                                        }
                                    }
                                });
                            }
                        }
                    } else if (view != null) {
                        int visibility = view.getVisibility();
                        ViewUtils.IMPL.setTransitionVisibility(view, 0);
                        animator = onDisappear(viewGroup, view, transitionValues, transitionValues2);
                        if (animator != null) {
                            DisappearListener disappearListener = new DisappearListener(view, i, true);
                            animator.addListener(disappearListener);
                            animator.addPauseListener(disappearListener);
                            addListener(disappearListener);
                        } else {
                            ViewUtils.IMPL.setTransitionVisibility(view, visibility);
                        }
                    }
                }
            } else if ((this.mMode & 1) != 1 || transitionValues2 == null) {
                return null;
            } else {
                if (transitionValues == null) {
                    View view7 = (View) transitionValues2.view.getParent();
                    if (getVisibilityChangeInfo(getMatchedTransitionValues(view7, false), getTransitionValues(view7, false)).mVisibilityChange) {
                        return null;
                    }
                }
                View view8 = transitionValues2.view;
                Fade fade = (Fade) this;
                float f2 = BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
                float floatValue = (transitionValues == null || (f = (Float) transitionValues.values.get("android:fade:transitionAlpha")) == null) ? 0.0f : f.floatValue();
                if (floatValue != 1.0f) {
                    f2 = floatValue;
                }
                return fade.createAnimation(view8, f2, 1.0f);
            }
        }
        return animator;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public final VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.mVisibilityChange = false;
        visibilityInfo.mFadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey("android:visibility:visibility")) {
            visibilityInfo.mStartVisibility = -1;
            visibilityInfo.mStartParent = null;
        } else {
            visibilityInfo.mStartVisibility = ((Integer) transitionValues.values.get("android:visibility:visibility")).intValue();
            visibilityInfo.mStartParent = (ViewGroup) transitionValues.values.get("android:visibility:parent");
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey("android:visibility:visibility")) {
            visibilityInfo.mEndVisibility = -1;
            visibilityInfo.mEndParent = null;
        } else {
            visibilityInfo.mEndVisibility = ((Integer) transitionValues2.values.get("android:visibility:visibility")).intValue();
            visibilityInfo.mEndParent = (ViewGroup) transitionValues2.values.get("android:visibility:parent");
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.mEndVisibility == 0) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            } else if (transitionValues2 == null && visibilityInfo.mStartVisibility == 0) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            }
        } else if (visibilityInfo.mStartVisibility == visibilityInfo.mEndVisibility && visibilityInfo.mStartParent == visibilityInfo.mEndParent) {
            return visibilityInfo;
        } else {
            int i = visibilityInfo.mStartVisibility;
            int i2 = visibilityInfo.mEndVisibility;
            if (i != i2) {
                if (i == 0) {
                    visibilityInfo.mFadeIn = false;
                    visibilityInfo.mVisibilityChange = true;
                } else if (i2 == 0) {
                    visibilityInfo.mFadeIn = true;
                    visibilityInfo.mVisibilityChange = true;
                }
            } else if (visibilityInfo.mEndParent == null) {
                visibilityInfo.mFadeIn = false;
                visibilityInfo.mVisibilityChange = true;
            } else if (visibilityInfo.mStartParent == null) {
                visibilityInfo.mFadeIn = true;
                visibilityInfo.mVisibilityChange = true;
            }
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.values.containsKey("android:visibility:visibility") != transitionValues.values.containsKey("android:visibility:visibility")) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.mVisibilityChange) {
            return false;
        }
        if (visibilityChangeInfo.mStartVisibility == 0 || visibilityChangeInfo.mEndVisibility == 0) {
            return true;
        }
        return false;
    }

    public abstract Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2);
}
