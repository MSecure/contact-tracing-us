package com.swmansion.rnscreens;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.views.text.ReactFontManager;
import com.google.android.material.appbar.AppBarLayout;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.ArrayList;

public class ScreenStackHeaderConfig extends ViewGroup {
    public boolean mBackButtonInCustomView;
    public View.OnClickListener mBackClickListener = new View.OnClickListener() {
        /* class com.swmansion.rnscreens.ScreenStackHeaderConfig.AnonymousClass1 */

        public void onClick(View view) {
            ScreenStackFragment screenFragment = ScreenStackHeaderConfig.this.getScreenFragment();
            if (screenFragment != null) {
                ScreenStack screenStack = ScreenStackHeaderConfig.this.getScreenStack();
                if (screenStack == null || screenStack.getRootScreen() != screenFragment.mScreenView) {
                    screenFragment.dismiss();
                    return;
                }
                Fragment fragment = screenFragment.mParentFragment;
                if (fragment instanceof ScreenStackFragment) {
                    ((ScreenStackFragment) fragment).dismiss();
                }
            }
        }
    };
    public int mBackgroundColor;
    public final ArrayList<ScreenStackHeaderSubview> mConfigSubviews = new ArrayList<>(3);
    public int mDefaultStartInset;
    public int mDefaultStartInsetWithNavigation;
    public boolean mDestroyed;
    public boolean mIsAttachedToWindow = false;
    public boolean mIsBackButtonHidden;
    public boolean mIsHidden;
    public boolean mIsShadowHidden;
    public int mTintColor;
    public String mTitle;
    public int mTitleColor;
    public String mTitleFontFamily;
    public float mTitleFontSize;
    public final Toolbar mToolbar;

    public ScreenStackHeaderConfig(Context context) {
        super(context);
        setVisibility(8);
        Toolbar toolbar = new Toolbar(context, null);
        this.mToolbar = toolbar;
        this.mDefaultStartInset = toolbar.getContentInsetStart();
        this.mDefaultStartInsetWithNavigation = this.mToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            this.mToolbar.setBackgroundColor(typedValue.data);
        }
    }

    private Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        ScreenFragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ScreenStack getScreenStack() {
        Screen screen = getScreen();
        if (screen == null) {
            return null;
        }
        ScreenContainer container = screen.getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    private TextView getTitleTextView() {
        int childCount = this.mToolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(this.mToolbar.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public int getConfigSubviewsCount() {
        return this.mConfigSubviews.size();
    }

    public final void maybeUpdate() {
        if (getParent() != null && !this.mDestroyed) {
            onUpdate();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        onUpdate();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public void onUpdate() {
        AppCompatActivity appCompatActivity;
        Drawable navigationIcon;
        CharSequence charSequence;
        Toolbar toolbar;
        AppBarLayout appBarLayout;
        Screen screen = (Screen) getParent();
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || screenStack.getTopScreen() == screen;
        if (this.mIsAttachedToWindow && z && !this.mDestroyed && (appCompatActivity = (AppCompatActivity) getScreenFragment().getActivity()) != null) {
            if (!this.mIsHidden) {
                if (this.mToolbar.getParent() == null) {
                    ScreenStackFragment screenFragment = getScreenFragment();
                    Toolbar toolbar2 = this.mToolbar;
                    AppBarLayout appBarLayout2 = screenFragment.mAppBarLayout;
                    if (appBarLayout2 != null) {
                        appBarLayout2.addView(toolbar2);
                    }
                    screenFragment.mToolbar = toolbar2;
                    AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, -2);
                    layoutParams.scrollFlags = 0;
                    screenFragment.mToolbar.setLayoutParams(layoutParams);
                }
                Toolbar toolbar3 = this.mToolbar;
                AppCompatDelegateImpl appCompatDelegateImpl = (AppCompatDelegateImpl) appCompatActivity.getDelegate();
                if (appCompatDelegateImpl.mHost instanceof Activity) {
                    appCompatDelegateImpl.initWindowDecorActionBar();
                    ActionBar actionBar = appCompatDelegateImpl.mActionBar;
                    if (!(actionBar instanceof WindowDecorActionBar)) {
                        appCompatDelegateImpl.mMenuInflater = null;
                        if (actionBar != null) {
                            actionBar.onDestroy();
                        }
                        if (toolbar3 != null) {
                            Object obj = appCompatDelegateImpl.mHost;
                            if (obj instanceof Activity) {
                                charSequence = ((Activity) obj).getTitle();
                            } else {
                                charSequence = appCompatDelegateImpl.mTitle;
                            }
                            ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar3, charSequence, appCompatDelegateImpl.mAppCompatWindowCallback);
                            appCompatDelegateImpl.mActionBar = toolbarActionBar;
                            appCompatDelegateImpl.mWindow.setCallback(toolbarActionBar.mWindowCallback);
                        } else {
                            appCompatDelegateImpl.mActionBar = null;
                            appCompatDelegateImpl.mWindow.setCallback(appCompatDelegateImpl.mAppCompatWindowCallback);
                        }
                        appCompatDelegateImpl.invalidateOptionsMenu();
                    } else {
                        throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                    }
                }
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                this.mToolbar.setContentInsetStartWithNavigation(this.mDefaultStartInsetWithNavigation);
                Toolbar toolbar4 = this.mToolbar;
                int i = this.mDefaultStartInset;
                toolbar4.ensureContentInsets();
                toolbar4.mContentInsets.setRelative(i, i);
                supportActionBar.setDisplayHomeAsUpEnabled(getScreenFragment().canNavigateBack() && !this.mIsBackButtonHidden);
                this.mToolbar.setNavigationOnClickListener(this.mBackClickListener);
                ScreenStackFragment screenFragment2 = getScreenFragment();
                boolean z2 = this.mIsShadowHidden;
                if (screenFragment2.mShadowHidden != z2) {
                    screenFragment2.mAppBarLayout.setTargetElevation(z2 ? 0.0f : ScreenStackFragment.TOOLBAR_ELEVATION);
                    screenFragment2.mShadowHidden = z2;
                }
                supportActionBar.setTitle(this.mTitle);
                if (TextUtils.isEmpty(this.mTitle)) {
                    this.mToolbar.setContentInsetStartWithNavigation(0);
                }
                TextView titleTextView = getTitleTextView();
                int i2 = this.mTitleColor;
                if (i2 != 0) {
                    this.mToolbar.setTitleTextColor(i2);
                }
                if (titleTextView != null) {
                    if (this.mTitleFontFamily != null) {
                        titleTextView.setTypeface(ReactFontManager.getInstance().getTypeface(this.mTitleFontFamily, 0, 0, getContext().getAssets()));
                    }
                    float f = this.mTitleFontSize;
                    if (f > BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                        titleTextView.setTextSize(f);
                    }
                }
                int i3 = this.mBackgroundColor;
                if (i3 != 0) {
                    this.mToolbar.setBackgroundColor(i3);
                }
                if (!(this.mTintColor == 0 || (navigationIcon = this.mToolbar.getNavigationIcon()) == null)) {
                    navigationIcon.setColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP);
                }
                for (int childCount = this.mToolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                    if (this.mToolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                        this.mToolbar.removeViewAt(childCount);
                    }
                }
                int size = this.mConfigSubviews.size();
                for (int i4 = 0; i4 < size; i4++) {
                    ScreenStackHeaderSubview screenStackHeaderSubview = this.mConfigSubviews.get(i4);
                    ScreenStackHeaderSubview.Type type = screenStackHeaderSubview.getType();
                    if (type == ScreenStackHeaderSubview.Type.BACK) {
                        View childAt = screenStackHeaderSubview.getChildAt(0);
                        if (childAt instanceof ImageView) {
                            supportActionBar.setHomeAsUpIndicator(((ImageView) childAt).getDrawable());
                        } else {
                            throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                        }
                    } else {
                        Toolbar.LayoutParams layoutParams2 = new Toolbar.LayoutParams(-2, -1);
                        int ordinal = type.ordinal();
                        if (ordinal == 0) {
                            if (!this.mBackButtonInCustomView) {
                                this.mToolbar.setNavigationIcon((Drawable) null);
                            }
                            this.mToolbar.setTitle((CharSequence) null);
                            layoutParams2.gravity = 3;
                        } else if (ordinal == 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -1;
                            layoutParams2.gravity = 1;
                            this.mToolbar.setTitle((CharSequence) null);
                        } else if (ordinal == 2) {
                            layoutParams2.gravity = 5;
                        }
                        screenStackHeaderSubview.setLayoutParams(layoutParams2);
                        this.mToolbar.addView(screenStackHeaderSubview);
                    }
                }
            } else if (this.mToolbar.getParent() != null) {
                ScreenStackFragment screenFragment3 = getScreenFragment();
                if (!(screenFragment3.mAppBarLayout == null || (toolbar = screenFragment3.mToolbar) == null || toolbar.getParent() != (appBarLayout = screenFragment3.mAppBarLayout))) {
                    appBarLayout.removeView(screenFragment3.mToolbar);
                }
                screenFragment3.mToolbar = null;
            }
        }
    }

    public void setBackButtonInCustomView(boolean z) {
        this.mBackButtonInCustomView = z;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setHidden(boolean z) {
        this.mIsHidden = z;
    }

    public void setHideBackButton(boolean z) {
        this.mIsBackButtonHidden = z;
    }

    public void setHideShadow(boolean z) {
        this.mIsShadowHidden = z;
    }

    public void setTintColor(int i) {
        this.mTintColor = i;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public void setTitleFontFamily(String str) {
        this.mTitleFontFamily = str;
    }

    public void setTitleFontSize(float f) {
        this.mTitleFontSize = f;
    }
}
