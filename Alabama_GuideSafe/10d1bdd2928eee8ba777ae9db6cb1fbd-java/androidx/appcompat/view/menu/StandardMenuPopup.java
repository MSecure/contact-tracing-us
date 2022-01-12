package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;

public final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    public static final int ITEM_LAYOUT = R$layout.abc_popup_menu_item_layout;
    public final MenuAdapter mAdapter;
    public View mAnchorView;
    public final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener() {
        /* class androidx.appcompat.view.menu.StandardMenuPopup.AnonymousClass2 */

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = StandardMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    StandardMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                standardMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(standardMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public int mContentWidth;
    public final Context mContext;
    public int mDropDownGravity = 0;
    public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class androidx.appcompat.view.menu.StandardMenuPopup.AnonymousClass1 */

        public void onGlobalLayout() {
            if (StandardMenuPopup.this.isShowing()) {
                StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
                if (!standardMenuPopup.mPopup.mModal) {
                    View view = standardMenuPopup.mShownAnchorView;
                    if (view == null || !view.isShown()) {
                        StandardMenuPopup.this.dismiss();
                    } else {
                        StandardMenuPopup.this.mPopup.show();
                    }
                }
            }
        }
    };
    public boolean mHasContentWidth;
    public final MenuBuilder mMenu;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final MenuPopupWindow mPopup;
    public final int mPopupMaxWidth;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;
    public boolean mShowTitle;
    public View mShownAnchorView;
    public ViewTreeObserver mTreeObserver;
    public boolean mWasDismissed;

    public StandardMenuPopup(Context context, MenuBuilder menuBuilder, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mOverflowOnly = z;
        this.mAdapter = new MenuAdapter(menuBuilder, LayoutInflater.from(context), this.mOverflowOnly, ITEM_LAYOUT);
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        this.mPopup = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuBuilder.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        return this.mPopup.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return !this.mWasDismissed && this.mPopup.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder == this.mMenu) {
            dismiss();
            MenuPresenter.Callback callback = this.mPresenterCallback;
            if (callback != null) {
                callback.onCloseMenu(menuBuilder, z);
            }
        }
    }

    public void onDismiss() {
        this.mWasDismissed = true;
        this.mMenu.close(true);
        ViewTreeObserver viewTreeObserver = this.mTreeObserver;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.mTreeObserver = this.mShownAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
            this.mTreeObserver = null;
        }
        this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        int i;
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.mContext, subMenuBuilder, this.mShownAnchorView, this.mOverflowOnly, this.mPopupStyleAttr, this.mPopupStyleRes);
            menuPopupHelper.setPresenterCallback(this.mPresenterCallback);
            boolean shouldPreserveIconSpacing = MenuPopup.shouldPreserveIconSpacing(subMenuBuilder);
            menuPopupHelper.mForceShowIcon = shouldPreserveIconSpacing;
            MenuPopup menuPopup = menuPopupHelper.mPopup;
            if (menuPopup != null) {
                menuPopup.setForceShowIcon(shouldPreserveIconSpacing);
            }
            menuPopupHelper.mOnDismissListener = this.mOnDismissListener;
            this.mOnDismissListener = null;
            this.mMenu.close(false);
            MenuPopupWindow menuPopupWindow = this.mPopup;
            int i2 = menuPopupWindow.mDropDownHorizontalOffset;
            if (!menuPopupWindow.mDropDownVerticalOffsetSet) {
                i = 0;
            } else {
                i = menuPopupWindow.mDropDownVerticalOffset;
            }
            if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i2 += this.mAnchorView.getWidth();
            }
            if (!menuPopupHelper.isShowing()) {
                if (menuPopupHelper.mAnchorView == null) {
                    z = false;
                    if (z) {
                        MenuPresenter.Callback callback = this.mPresenterCallback;
                        if (callback != null) {
                            callback.onOpenSubMenu(subMenuBuilder);
                        }
                        return true;
                    }
                } else {
                    menuPopupHelper.showPopup(i2, i, true, true);
                }
            }
            z = true;
            if (z) {
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.mAdapter.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        this.mPopup.mDropDownHorizontalOffset = i;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setShowTitle(boolean z) {
        this.mShowTitle = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setVerticalOffset(int i) {
        MenuPopupWindow menuPopupWindow = this.mPopup;
        menuPopupWindow.mDropDownVerticalOffset = i;
        menuPopupWindow.mDropDownVerticalOffsetSet = true;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        View view;
        boolean z = true;
        if (!isShowing()) {
            if (this.mWasDismissed || (view = this.mAnchorView) == null) {
                z = false;
            } else {
                this.mShownAnchorView = view;
                this.mPopup.mPopup.setOnDismissListener(this);
                MenuPopupWindow menuPopupWindow = this.mPopup;
                menuPopupWindow.mItemClickListener = this;
                menuPopupWindow.setModal(true);
                View view2 = this.mShownAnchorView;
                boolean z2 = this.mTreeObserver == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.mTreeObserver = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
                view2.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
                MenuPopupWindow menuPopupWindow2 = this.mPopup;
                menuPopupWindow2.mDropDownAnchorView = view2;
                menuPopupWindow2.mDropDownGravity = this.mDropDownGravity;
                if (!this.mHasContentWidth) {
                    this.mContentWidth = MenuPopup.measureIndividualMenuWidth(this.mAdapter, null, this.mContext, this.mPopupMaxWidth);
                    this.mHasContentWidth = true;
                }
                this.mPopup.setContentWidth(this.mContentWidth);
                this.mPopup.mPopup.setInputMethodMode(2);
                MenuPopupWindow menuPopupWindow3 = this.mPopup;
                Rect rect = this.mEpicenterBounds;
                if (menuPopupWindow3 != null) {
                    menuPopupWindow3.mEpicenterBounds = rect != null ? new Rect(rect) : null;
                    this.mPopup.show();
                    DropDownListView dropDownListView = this.mPopup.mDropDownList;
                    dropDownListView.setOnKeyListener(this);
                    if (this.mShowTitle && this.mMenu.mHeaderTitle != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(this.mMenu.mHeaderTitle);
                        }
                        frameLayout.setEnabled(false);
                        dropDownListView.addHeaderView(frameLayout, null, false);
                    }
                    this.mPopup.setAdapter(this.mAdapter);
                    this.mPopup.show();
                } else {
                    throw null;
                }
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        MenuAdapter menuAdapter = this.mAdapter;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }
}
