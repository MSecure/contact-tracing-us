package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.BaseViewManager;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent2, NestedScrollingParent3 {
    public static final int[] ATTRS = {R$attr.actionBarSize, 16842841};
    public int mActionBarHeight;
    public ActionBarContainer mActionBarTop;
    public ActionBarVisibilityCallback mActionBarVisibilityCallback;
    public final Runnable mAddActionBarHideOffset;
    public boolean mAnimatingForFling;
    public final Rect mBaseContentInsets = new Rect();
    public WindowInsetsCompat mBaseInnerInsets;
    public final Rect mBaseInnerInsetsRect = new Rect();
    public ContentFrameLayout mContent;
    public final Rect mContentInsets = new Rect();
    public ViewPropertyAnimator mCurrentActionBarTopAnimator;
    public DecorToolbar mDecorToolbar;
    public OverScroller mFlingEstimator;
    public boolean mHasNonEmbeddedTabs;
    public boolean mHideOnContentScroll;
    public int mHideOnContentScrollReference;
    public boolean mIgnoreWindowContentOverlay;
    public WindowInsetsCompat mInnerInsets;
    public final Rect mInnerInsetsRect = new Rect();
    public final Rect mLastBaseContentInsets = new Rect();
    public WindowInsetsCompat mLastBaseInnerInsets;
    public final Rect mLastBaseInnerInsetsRect = new Rect();
    public WindowInsetsCompat mLastInnerInsets;
    public final Rect mLastInnerInsetsRect = new Rect();
    public int mLastSystemUiVisibility;
    public boolean mOverlayMode;
    public final NestedScrollingParentHelper mParentHelper;
    public final Runnable mRemoveActionBarHideOffset;
    public final AnimatorListenerAdapter mTopAnimatorListener;
    public Drawable mWindowContentOverlay;
    public int mWindowVisibility = 0;

    public interface ActionBarVisibilityCallback {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.CONSUMED;
        this.mBaseInnerInsets = windowInsetsCompat;
        this.mLastBaseInnerInsets = windowInsetsCompat;
        this.mInnerInsets = windowInsetsCompat;
        this.mLastInnerInsets = windowInsetsCompat;
        this.mTopAnimatorListener = new AnimatorListenerAdapter() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass1 */

            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = null;
                actionBarOverlayLayout.mAnimatingForFling = false;
            }
        };
        this.mRemoveActionBarHideOffset = new Runnable() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass2 */

            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY(BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
            }
        };
        this.mAddActionBarHideOffset = new Runnable() {
            /* class androidx.appcompat.widget.ActionBarOverlayLayout.AnonymousClass3 */

            public void run() {
                ActionBarOverlayLayout.this.haltActionBarHideOffsetAnimations();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.mCurrentActionBarTopAnimator = actionBarOverlayLayout.mActionBarTop.animate().translationY((float) (-ActionBarOverlayLayout.this.mActionBarTop.getHeight())).setListener(ActionBarOverlayLayout.this.mTopAnimatorListener);
            }
        };
        init(context);
        this.mParentHelper = new NestedScrollingParentHelper();
    }

    public final boolean applyInsets(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z || ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin == (i4 = rect.left)) {
            z5 = false;
        } else {
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i4;
            z5 = true;
        }
        if (z2 && ((ViewGroup.MarginLayoutParams) layoutParams).topMargin != (i3 = rect.top)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = i3;
            z5 = true;
        }
        if (z4 && ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin != (i2 = rect.right)) {
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i2;
            z5 = true;
        }
        if (!z3 || ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin == (i = rect.bottom)) {
            return z5;
        }
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = i;
        return true;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean canShowOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void dismissPopups() {
        pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.mWindowContentOverlay != null && !this.mIgnoreWindowContentOverlay) {
            if (this.mActionBarTop.getVisibility() == 0) {
                i = (int) (this.mActionBarTop.getTranslationY() + ((float) this.mActionBarTop.getBottom()) + 0.5f);
            } else {
                i = 0;
            }
            this.mWindowContentOverlay.setBounds(0, i, getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + i);
            this.mWindowContentOverlay.draw(canvas);
        }
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    public void haltActionBarHideOffsetAnimations() {
        removeCallbacks(this.mRemoveActionBarHideOffset);
        removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean hideOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public final void init(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean z = false;
        this.mActionBarHeight = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.mWindowContentOverlay = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z = true;
        }
        this.mIgnoreWindowContentOverlay = z;
        this.mFlingEstimator = new OverScroller(context);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void initFeature(int i) {
        pullChildren();
        if (i == 2) {
            this.mDecorToolbar.initProgress();
        } else if (i == 5) {
            this.mDecorToolbar.initIndeterminateProgress();
        } else if (i == 109) {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowPending() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean isOverflowMenuShowing() {
        pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        pullChildren();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        boolean applyInsets = applyInsets(this.mActionBarTop, new Rect(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom()), true, true, false, true);
        ViewCompat.computeSystemWindowInsets(this, windowInsetsCompat, this.mBaseContentInsets);
        Rect rect = this.mBaseContentInsets;
        WindowInsetsCompat inset = windowInsetsCompat.mImpl.inset(rect.left, rect.top, rect.right, rect.bottom);
        this.mBaseInnerInsets = inset;
        boolean z = true;
        if (!this.mLastBaseInnerInsets.equals(inset)) {
            this.mLastBaseInnerInsets = this.mBaseInnerInsets;
            applyInsets = true;
        }
        if (!this.mLastBaseContentInsets.equals(this.mBaseContentInsets)) {
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
        } else {
            z = applyInsets;
        }
        if (z) {
            requestLayout();
        }
        return windowInsetsCompat.mImpl.consumeDisplayCutout().mImpl.consumeSystemWindowInsets().mImpl.consumeStableInsets().toWindowInsets();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        init(getContext());
        ViewCompat.requestApplyInsets(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        haltActionBarHideOffsetAnimations();
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    public void onMeasure(int i, int i2) {
        int i3;
        WindowInsetsCompat.BuilderImpl builderImpl;
        pullChildren();
        measureChildWithMargins(this.mActionBarTop, i, 0, i2, 0);
        LayoutParams layoutParams = (LayoutParams) this.mActionBarTop.getLayoutParams();
        int max = Math.max(0, this.mActionBarTop.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
        int max2 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.mActionBarTop.getMeasuredState());
        boolean z = (ViewCompat.getWindowSystemUiVisibility(this) & 256) != 0;
        if (z) {
            i3 = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs && this.mActionBarTop.getTabContainer() != null) {
                i3 += this.mActionBarHeight;
            }
        } else {
            i3 = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        WindowInsetsCompat windowInsetsCompat = this.mBaseInnerInsets;
        this.mInnerInsets = windowInsetsCompat;
        if (this.mOverlayMode || z) {
            Insets of = Insets.of(this.mInnerInsets.getSystemWindowInsetLeft(), this.mInnerInsets.getSystemWindowInsetTop() + i3, this.mInnerInsets.getSystemWindowInsetRight(), this.mInnerInsets.getSystemWindowInsetBottom() + 0);
            WindowInsetsCompat windowInsetsCompat2 = this.mInnerInsets;
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 30) {
                builderImpl = new WindowInsetsCompat.BuilderImpl30(windowInsetsCompat2);
            } else if (i4 >= 29) {
                builderImpl = new WindowInsetsCompat.BuilderImpl29(windowInsetsCompat2);
            } else {
                builderImpl = new WindowInsetsCompat.BuilderImpl20(windowInsetsCompat2);
            }
            builderImpl.setSystemWindowInsets(of);
            this.mInnerInsets = builderImpl.build();
        } else {
            Rect rect = this.mContentInsets;
            rect.top += i3;
            rect.bottom += 0;
            this.mInnerInsets = windowInsetsCompat.mImpl.inset(0, i3, 0, 0);
        }
        applyInsets(this.mContent, this.mContentInsets, true, true, true, true);
        if (!this.mLastInnerInsets.equals(this.mInnerInsets)) {
            WindowInsetsCompat windowInsetsCompat3 = this.mInnerInsets;
            this.mLastInnerInsets = windowInsetsCompat3;
            ViewCompat.dispatchApplyWindowInsets(this.mContent, windowInsetsCompat3);
        }
        measureChildWithMargins(this.mContent, i, 0, i2, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.mContent.getLayoutParams();
        int max3 = Math.max(max, this.mContent.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin);
        int max4 = Math.max(max2, this.mContent.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.mContent.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean z2 = false;
        if (!this.mHideOnContentScroll || !z) {
            return false;
        }
        this.mFlingEstimator.fling(0, 0, 0, (int) f2, 0, 0, RecyclerView.UNDEFINED_DURATION, Integer.MAX_VALUE);
        if (this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight()) {
            z2 = true;
        }
        if (z2) {
            haltActionBarHideOffsetAnimations();
            this.mAddActionBarHideOffset.run();
        } else {
            haltActionBarHideOffsetAnimations();
            this.mRemoveActionBarHideOffset.run();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 0) {
            onNestedPreScroll(view, i, i2, iArr);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        pullChildren();
        int i2 = this.mLastSystemUiVisibility ^ i;
        this.mLastSystemUiVisibility = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mContentAnimations = !z2;
            if (z || !z2) {
                WindowDecorActionBar windowDecorActionBar = (WindowDecorActionBar) this.mActionBarVisibilityCallback;
                if (windowDecorActionBar.mHiddenBySystem) {
                    windowDecorActionBar.mHiddenBySystem = false;
                    windowDecorActionBar.updateVisibility(true);
                }
            } else {
                WindowDecorActionBar windowDecorActionBar2 = (WindowDecorActionBar) actionBarVisibilityCallback;
                if (!windowDecorActionBar2.mHiddenBySystem) {
                    windowDecorActionBar2.mHiddenBySystem = true;
                    windowDecorActionBar2.updateVisibility(true);
                }
            }
        }
        if ((i2 & 256) != 0 && this.mActionBarVisibilityCallback != null) {
            ViewCompat.requestApplyInsets(this);
        }
    }

    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.mWindowVisibility = i;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null) {
            ((WindowDecorActionBar) actionBarVisibilityCallback).mCurWindowVisibility = i;
        }
    }

    public void pullChildren() {
        DecorToolbar decorToolbar;
        if (this.mContent == null) {
            this.mContent = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.mActionBarTop = (ActionBarContainer) findViewById(R$id.action_bar_container);
            View findViewById = findViewById(R$id.action_bar);
            if (findViewById instanceof DecorToolbar) {
                decorToolbar = (DecorToolbar) findViewById;
            } else if (findViewById instanceof Toolbar) {
                decorToolbar = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Can't make a decor toolbar out of ");
                outline15.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(outline15.toString());
            }
            this.mDecorToolbar = decorToolbar;
        }
    }

    public void setActionBarHideOffset(int i) {
        haltActionBarHideOffsetAnimations();
        this.mActionBarTop.setTranslationY((float) (-Math.max(0, Math.min(i, this.mActionBarTop.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            ((WindowDecorActionBar) this.mActionBarVisibilityCallback).mCurWindowVisibility = this.mWindowVisibility;
            int i = this.mLastSystemUiVisibility;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                ViewCompat.requestApplyInsets(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.mHasNonEmbeddedTabs = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.mHideOnContentScroll) {
            this.mHideOnContentScroll = z;
            if (!z) {
                haltActionBarHideOffsetAnimations();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i) {
        pullChildren();
        this.mDecorToolbar.setIcon(i);
    }

    public void setLogo(int i) {
        pullChildren();
        this.mDecorToolbar.setLogo(i);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setMenu(menu, callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setMenuPrepared() {
        pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean z) {
        this.mOverlayMode = z;
        this.mIgnoreWindowContentOverlay = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowCallback(Window.Callback callback) {
        pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public void setWindowTitle(CharSequence charSequence) {
        pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.appcompat.widget.DecorContentParent
    public boolean showOverflowMenu() {
        pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        WindowDecorActionBar windowDecorActionBar;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.mParentHelper.mNestedScrollAxesTouch = i;
        this.mHideOnContentScrollReference = getActionBarHideOffset();
        haltActionBarHideOffsetAnimations();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null && (viewPropertyAnimatorCompatSet = (windowDecorActionBar = (WindowDecorActionBar) actionBarVisibilityCallback).mCurrentShowAnim) != null) {
            viewPropertyAnimatorCompatSet.cancel();
            windowDecorActionBar.mCurrentShowAnim = null;
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.mActionBarTop.getVisibility() != 0) {
            return false;
        }
        return this.mHideOnContentScroll;
    }

    public void onStopNestedScroll(View view) {
        if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
            if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                haltActionBarHideOffsetAnimations();
                postDelayed(this.mRemoveActionBarHideOffset, 600);
            } else {
                haltActionBarHideOffsetAnimations();
                postDelayed(this.mAddActionBarHideOffset, 600);
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback != null && ((WindowDecorActionBar) actionBarVisibilityCallback) == null) {
            throw null;
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.mHideOnContentScrollReference + i2;
        this.mHideOnContentScrollReference = i5;
        setActionBarHideOffset(i5);
    }

    public void setIcon(Drawable drawable) {
        pullChildren();
        this.mDecorToolbar.setIcon(drawable);
    }
}
