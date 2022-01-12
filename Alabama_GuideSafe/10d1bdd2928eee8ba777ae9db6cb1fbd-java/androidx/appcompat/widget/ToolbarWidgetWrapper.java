package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import com.facebook.react.uimanager.BaseViewManager;

public class ToolbarWidgetWrapper implements DecorToolbar {
    public ActionMenuPresenter mActionMenuPresenter;
    public View mCustomView;
    public int mDefaultNavigationContentDescription = 0;
    public Drawable mDefaultNavigationIcon;
    public int mDisplayOpts;
    public CharSequence mHomeDescription;
    public Drawable mIcon;
    public Drawable mLogo;
    public boolean mMenuPrepared;
    public Drawable mNavIcon;
    public int mNavigationMode = 0;
    public CharSequence mSubtitle;
    public View mTabView;
    public CharSequence mTitle;
    public boolean mTitleSet;
    public Toolbar mToolbar;
    public Window.Callback mWindowCallback;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        int i;
        Drawable drawable;
        int i2 = R$string.abc_action_bar_up_description;
        this.mToolbar = toolbar;
        this.mTitle = toolbar.getTitle();
        this.mSubtitle = toolbar.getSubtitle();
        this.mTitleSet = this.mTitle != null;
        this.mNavIcon = toolbar.getNavigationIcon();
        String str = null;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.mDefaultNavigationIcon = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence text = obtainStyledAttributes.getText(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = obtainStyledAttributes.getText(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.mSubtitle = text2;
                if ((this.mDisplayOpts & 8) != 0) {
                    this.mToolbar.setSubtitle(text2);
                }
            }
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_logo);
            if (drawable2 != null) {
                this.mLogo = drawable2;
                updateToolbarLogo();
            }
            Drawable drawable3 = obtainStyledAttributes.getDrawable(R$styleable.ActionBar_icon);
            if (drawable3 != null) {
                this.mIcon = drawable3;
                updateToolbarLogo();
            }
            if (this.mNavIcon == null && (drawable = this.mDefaultNavigationIcon) != null) {
                this.mNavIcon = drawable;
                updateNavigationIcon();
            }
            setDisplayOptions(obtainStyledAttributes.getInt(R$styleable.ActionBar_displayOptions, 0));
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(this.mToolbar.getContext()).inflate(resourceId, (ViewGroup) this.mToolbar, false);
                View view = this.mCustomView;
                if (!(view == null || (this.mDisplayOpts & 16) == 0)) {
                    this.mToolbar.removeView(view);
                }
                this.mCustomView = inflate;
                if (!(inflate == null || (this.mDisplayOpts & 16) == 0)) {
                    this.mToolbar.addView(inflate);
                }
                setDisplayOptions(this.mDisplayOpts | 16);
            }
            int layoutDimension = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = this.mToolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                this.mToolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                Toolbar toolbar2 = this.mToolbar;
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                toolbar2.ensureContentInsets();
                toolbar2.mContentInsets.setRelative(max, max2);
            }
            int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Toolbar toolbar3 = this.mToolbar;
                Context context = toolbar3.getContext();
                toolbar3.mTitleTextAppearance = resourceId2;
                TextView textView = toolbar3.mTitleTextView;
                if (textView != null) {
                    textView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Toolbar toolbar4 = this.mToolbar;
                Context context2 = toolbar4.getContext();
                toolbar4.mSubtitleTextAppearance = resourceId3;
                TextView textView2 = toolbar4.mSubtitleTextView;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                this.mToolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (this.mToolbar.getNavigationIcon() != null) {
                i = 15;
                this.mDefaultNavigationIcon = this.mToolbar.getNavigationIcon();
            } else {
                i = 11;
            }
            this.mDisplayOpts = i;
        }
        obtainStyledAttributes.mWrapped.recycle();
        if (i2 != this.mDefaultNavigationContentDescription) {
            this.mDefaultNavigationContentDescription = i2;
            if (TextUtils.isEmpty(this.mToolbar.getNavigationContentDescription())) {
                int i3 = this.mDefaultNavigationContentDescription;
                this.mHomeDescription = i3 != 0 ? getContext().getString(i3) : str;
                updateHomeAccessibility();
            }
        }
        this.mHomeDescription = this.mToolbar.getNavigationContentDescription();
        this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            /* class androidx.appcompat.widget.ToolbarWidgetWrapper.AnonymousClass1 */
            public final ActionMenuItem mNavItem = new ActionMenuItem(ToolbarWidgetWrapper.this.mToolbar.getContext(), 0, 16908332, 0, ToolbarWidgetWrapper.this.mTitle);

            public void onClick(View view) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.mWindowCallback;
                if (callback != null && toolbarWidgetWrapper.mMenuPrepared) {
                    callback.onMenuItemSelected(0, this.mNavItem);
                }
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean canShowOverflowMenu() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.mToolbar;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.mMenuView) != null && actionMenuView.mReserveOverflow;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void collapseActionView() {
        MenuItemImpl menuItemImpl;
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mToolbar.mExpandedMenuPresenter;
        if (expandedActionViewMenuPresenter == null) {
            menuItemImpl = null;
        } else {
            menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem;
        }
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.mToolbar.mMenuView;
        if (actionMenuView != null && (actionMenuPresenter = actionMenuView.mPresenter) != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Context getContext() {
        return this.mToolbar.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getDisplayOptions() {
        return this.mDisplayOpts;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public Menu getMenu() {
        return this.mToolbar.getMenu();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public int getNavigationMode() {
        return this.mNavigationMode;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public CharSequence getTitle() {
        return this.mToolbar.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewGroup getViewGroup() {
        return this.mToolbar;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hasExpandedActionView() {
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.mToolbar.mExpandedMenuPresenter;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.mCurrentExpandedItem == null) ? false : true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean hideOverflowMenu() {
        ActionMenuView actionMenuView = this.mToolbar.mMenuView;
        if (actionMenuView != null) {
            ActionMenuPresenter actionMenuPresenter = actionMenuView.mPresenter;
            if (actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initIndeterminateProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void initProgress() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowPending() {
        boolean z;
        ActionMenuView actionMenuView = this.mToolbar.mMenuView;
        if (actionMenuView != null) {
            ActionMenuPresenter actionMenuPresenter = actionMenuView.mPresenter;
            if (actionMenuPresenter != null) {
                if (actionMenuPresenter.mPostedOpenRunnable != null || actionMenuPresenter.isOverflowMenuShowing()) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean isOverflowMenuShowing() {
        return this.mToolbar.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setCollapsible(boolean z) {
        this.mToolbar.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setDisplayOptions(int i) {
        View view;
        int i2 = this.mDisplayOpts ^ i;
        this.mDisplayOpts = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    updateHomeAccessibility();
                }
                updateNavigationIcon();
            }
            if ((i2 & 3) != 0) {
                updateToolbarLogo();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.mToolbar.setTitle(this.mTitle);
                    this.mToolbar.setSubtitle(this.mSubtitle);
                } else {
                    this.mToolbar.setTitle((CharSequence) null);
                    this.mToolbar.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) != 0 && (view = this.mCustomView) != null) {
                if ((i & 16) != 0) {
                    this.mToolbar.addView(view);
                } else {
                    this.mToolbar.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setEmbeddedTabView(ScrollingTabContainerView scrollingTabContainerView) {
        Toolbar toolbar;
        View view = this.mTabView;
        if (view != null && view.getParent() == (toolbar = this.mToolbar)) {
            toolbar.removeView(this.mTabView);
        }
        this.mTabView = null;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setHomeButtonEnabled(boolean z) {
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(int i) {
        this.mIcon = i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setLogo(int i) {
        this.mLogo = i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null;
        updateToolbarLogo();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        MenuItemImpl menuItemImpl;
        if (this.mActionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.mToolbar.getContext());
            this.mActionMenuPresenter = actionMenuPresenter;
            if (actionMenuPresenter == null) {
                throw null;
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = this.mActionMenuPresenter;
        actionMenuPresenter2.mCallback = callback;
        Toolbar toolbar = this.mToolbar;
        MenuBuilder menuBuilder = (MenuBuilder) menu;
        if (menuBuilder != null || toolbar.mMenuView != null) {
            toolbar.ensureMenuView();
            MenuBuilder menuBuilder2 = toolbar.mMenuView.mMenu;
            if (menuBuilder2 != menuBuilder) {
                if (menuBuilder2 != null) {
                    menuBuilder2.removeMenuPresenter(toolbar.mOuterActionMenuPresenter);
                    menuBuilder2.removeMenuPresenter(toolbar.mExpandedMenuPresenter);
                }
                if (toolbar.mExpandedMenuPresenter == null) {
                    toolbar.mExpandedMenuPresenter = new Toolbar.ExpandedActionViewMenuPresenter();
                }
                actionMenuPresenter2.mExpandedActionViewsExclusive = true;
                if (menuBuilder != null) {
                    menuBuilder.addMenuPresenter(actionMenuPresenter2, toolbar.mPopupContext);
                    menuBuilder.addMenuPresenter(toolbar.mExpandedMenuPresenter, toolbar.mPopupContext);
                } else {
                    actionMenuPresenter2.initForMenu(toolbar.mPopupContext, null);
                    Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = toolbar.mExpandedMenuPresenter;
                    MenuBuilder menuBuilder3 = expandedActionViewMenuPresenter.mMenu;
                    if (!(menuBuilder3 == null || (menuItemImpl = expandedActionViewMenuPresenter.mCurrentExpandedItem) == null)) {
                        menuBuilder3.collapseItemActionView(menuItemImpl);
                    }
                    expandedActionViewMenuPresenter.mMenu = null;
                    actionMenuPresenter2.updateMenuView(true);
                    toolbar.mExpandedMenuPresenter.updateMenuView(true);
                }
                toolbar.mMenuView.setPopupTheme(toolbar.mPopupTheme);
                toolbar.mMenuView.setPresenter(actionMenuPresenter2);
                toolbar.mOuterActionMenuPresenter = actionMenuPresenter2;
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        Toolbar toolbar = this.mToolbar;
        toolbar.mActionMenuPresenterCallback = callback;
        toolbar.mMenuBuilderCallback = callback2;
        ActionMenuView actionMenuView = toolbar.mMenuView;
        if (actionMenuView != null) {
            actionMenuView.mActionMenuPresenterCallback = callback;
            actionMenuView.mMenuBuilderCallback = callback2;
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setMenuPrepared() {
        this.mMenuPrepared = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setNavigationIcon(Drawable drawable) {
        this.mNavIcon = drawable;
        updateNavigationIcon();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setTitle(CharSequence charSequence) {
        this.mTitleSet = true;
        this.mTitle = charSequence;
        if ((this.mDisplayOpts & 8) != 0) {
            this.mToolbar.setTitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setVisibility(int i) {
        this.mToolbar.setVisibility(i);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowCallback(Window.Callback callback) {
        this.mWindowCallback = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.mTitleSet) {
            this.mTitle = charSequence;
            if ((this.mDisplayOpts & 8) != 0) {
                this.mToolbar.setTitle(charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(final int i, long j) {
        ViewPropertyAnimatorCompat animate = ViewCompat.animate(this.mToolbar);
        animate.alpha(i == 0 ? 1.0f : BaseViewManager.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        animate.setDuration(j);
        AnonymousClass2 r4 = new ViewPropertyAnimatorListenerAdapter() {
            /* class androidx.appcompat.widget.ToolbarWidgetWrapper.AnonymousClass2 */
            public boolean mCanceled = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationCancel(View view) {
                this.mCanceled = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationEnd(View view) {
                if (!this.mCanceled) {
                    ToolbarWidgetWrapper.this.mToolbar.setVisibility(i);
                }
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.mToolbar.setVisibility(0);
            }
        };
        View view = animate.mView.get();
        if (view != null) {
            animate.setListenerInternal(view, r4);
        }
        return animate;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public boolean showOverflowMenu() {
        return this.mToolbar.showOverflowMenu();
    }

    public final void updateHomeAccessibility() {
        if ((this.mDisplayOpts & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.mHomeDescription)) {
            this.mToolbar.setNavigationContentDescription(this.mDefaultNavigationContentDescription);
        } else {
            this.mToolbar.setNavigationContentDescription(this.mHomeDescription);
        }
    }

    public final void updateNavigationIcon() {
        if ((this.mDisplayOpts & 4) != 0) {
            Toolbar toolbar = this.mToolbar;
            Drawable drawable = this.mNavIcon;
            if (drawable == null) {
                drawable = this.mDefaultNavigationIcon;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.mToolbar.setNavigationIcon((Drawable) null);
    }

    public final void updateToolbarLogo() {
        Drawable drawable;
        int i = this.mDisplayOpts;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.mLogo;
            if (drawable == null) {
                drawable = this.mIcon;
            }
        } else {
            drawable = this.mIcon;
        }
        this.mToolbar.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public void setIcon(Drawable drawable) {
        this.mIcon = drawable;
        updateToolbarLogo();
    }
}
