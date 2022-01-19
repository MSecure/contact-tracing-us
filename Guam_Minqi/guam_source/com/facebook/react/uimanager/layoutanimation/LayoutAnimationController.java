package com.facebook.react.uimanager.layoutanimation;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.NativeViewHierarchyManager;

public class LayoutAnimationController {
    public static Handler sCompletionHandler;
    public Runnable mCompletionRunnable;
    public final AbstractLayoutAnimation mLayoutCreateAnimation = new LayoutCreateAnimation();
    public final AbstractLayoutAnimation mLayoutDeleteAnimation = new LayoutDeleteAnimation();
    public final SparseArray<LayoutHandlingAnimation> mLayoutHandlers = new SparseArray<>(0);
    public final AbstractLayoutAnimation mLayoutUpdateAnimation = new LayoutUpdateAnimation();
    public long mMaxAnimationDuration = -1;
    public boolean mShouldAnimateLayout;

    public void deleteView(View view, final LayoutAnimationListener layoutAnimationListener) {
        UiThreadUtil.assertOnUiThread();
        Animation createAnimation = this.mLayoutDeleteAnimation.createAnimation(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (createAnimation != null) {
            disableUserInteractions(view);
            createAnimation.setAnimationListener(new Animation.AnimationListener(this) {
                /* class com.facebook.react.uimanager.layoutanimation.LayoutAnimationController.AnonymousClass3 */

                public void onAnimationEnd(Animation animation) {
                    ((NativeViewHierarchyManager.AnonymousClass1) layoutAnimationListener).onAnimationEnd();
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
            long duration = createAnimation.getDuration();
            if (duration > this.mMaxAnimationDuration) {
                scheduleCompletionCallback(duration);
                this.mMaxAnimationDuration = duration;
            }
            view.startAnimation(createAnimation);
            return;
        }
        ((NativeViewHierarchyManager.AnonymousClass1) layoutAnimationListener).onAnimationEnd();
    }

    public final void disableUserInteractions(View view) {
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                disableUserInteractions(viewGroup.getChildAt(i));
            }
        }
    }

    public void reset() {
        this.mLayoutCreateAnimation.reset();
        this.mLayoutUpdateAnimation.reset();
        this.mLayoutDeleteAnimation.reset();
        this.mCompletionRunnable = null;
        this.mShouldAnimateLayout = false;
        this.mMaxAnimationDuration = -1;
    }

    public final void scheduleCompletionCallback(long j) {
        if (sCompletionHandler == null) {
            sCompletionHandler = new Handler(Looper.getMainLooper());
        }
        Runnable runnable = this.mCompletionRunnable;
        if (runnable != null) {
            sCompletionHandler.removeCallbacks(runnable);
            sCompletionHandler.postDelayed(this.mCompletionRunnable, j);
        }
    }

    public boolean shouldAnimateLayout(View view) {
        if (view == null) {
            return false;
        }
        if ((!this.mShouldAnimateLayout || view.getParent() == null) && this.mLayoutHandlers.get(view.getId()) == null) {
            return false;
        }
        return true;
    }
}
