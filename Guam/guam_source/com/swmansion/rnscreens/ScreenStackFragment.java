package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import com.facebook.react.uimanager.BaseViewManager;
import com.google.android.material.appbar.AppBarLayout;

public class ScreenStackFragment extends ScreenFragment {
    public static final float TOOLBAR_ELEVATION = AppCompatDelegateImpl.ConfigurationImplApi17.toPixelFromDIP(4.0f);
    public AppBarLayout mAppBarLayout;
    public boolean mShadowHidden;
    public Toolbar mToolbar;

    public static class NotifyingCoordinatorLayout extends CoordinatorLayout {
        public final ScreenFragment mFragment;

        public NotifyingCoordinatorLayout(Context context, ScreenFragment screenFragment) {
            super(context, null);
            this.mFragment = screenFragment;
        }

        public void onAnimationEnd() {
            super.onAnimationEnd();
            this.mFragment.onViewAnimationEnd();
        }
    }

    @SuppressLint({"ValidFragment"})
    public ScreenStackFragment(Screen screen) {
        super(screen);
    }

    public boolean canNavigateBack() {
        ScreenContainer container = this.mScreenView.getContainer();
        if (!(container instanceof ScreenStack)) {
            throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
        } else if (((ScreenStack) container).getRootScreen() != this.mScreenView) {
            return true;
        } else {
            Fragment fragment = this.mParentFragment;
            if (fragment instanceof ScreenStackFragment) {
                return ((ScreenStackFragment) fragment).canNavigateBack();
            }
            return false;
        }
    }

    public void dismiss() {
        ScreenContainer container = this.mScreenView.getContainer();
        if (container instanceof ScreenStack) {
            ScreenStack screenStack = (ScreenStack) container;
            screenStack.mDismissed.add(this);
            screenStack.markUpdated();
            return;
        }
        throw new IllegalStateException("ScreenStackFragment added into a non-stack container");
    }

    @Override // androidx.fragment.app.Fragment
    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (!z || i != 0) {
            return null;
        }
        ViewParent parent = this.mView.getParent();
        if (!(parent instanceof ScreenStack)) {
            return null;
        }
        ScreenStack screenStack = (ScreenStack) parent;
        if (screenStack.mRemovalTransitionStarted) {
            return null;
        }
        screenStack.dispatchOnFinishTransitioning();
        return null;
    }

    @Override // androidx.fragment.app.Fragment, com.swmansion.rnscreens.ScreenFragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        NotifyingCoordinatorLayout notifyingCoordinatorLayout = new NotifyingCoordinatorLayout(getContext(), this);
        CoordinatorLayout.LayoutParams layoutParams = new CoordinatorLayout.LayoutParams(-1, -1);
        layoutParams.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        this.mScreenView.setLayoutParams(layoutParams);
        Screen screen = this.mScreenView;
        ScreenFragment.recycleView(screen);
        notifyingCoordinatorLayout.addView(screen);
        AppBarLayout appBarLayout = new AppBarLayout(getContext());
        this.mAppBarLayout = appBarLayout;
        appBarLayout.setBackgroundColor(0);
        this.mAppBarLayout.setLayoutParams(new AppBarLayout.LayoutParams(-1, -2));
        notifyingCoordinatorLayout.addView(this.mAppBarLayout);
        if (this.mShadowHidden) {
            this.mAppBarLayout.setTargetElevation(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        }
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            AppBarLayout appBarLayout2 = this.mAppBarLayout;
            ScreenFragment.recycleView(toolbar);
            appBarLayout2.addView(toolbar);
        }
        return notifyingCoordinatorLayout;
    }

    @Override // com.swmansion.rnscreens.ScreenFragment
    public void onViewAnimationEnd() {
        super.onViewAnimationEnd();
        ViewParent parent = this.mView.getParent();
        if (parent instanceof ScreenStack) {
            ScreenStack screenStack = (ScreenStack) parent;
            if (!screenStack.mRemovalTransitionStarted) {
                screenStack.dispatchOnFinishTransitioning();
            }
        }
    }
}
