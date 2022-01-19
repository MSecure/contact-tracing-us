package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int ITEM_LAYOUT = R$layout.abc_cascading_menu_item_layout;
    public View mAnchorView;
    public final View.OnAttachStateChangeListener mAttachStateChangeListener = new View.OnAttachStateChangeListener() {
        /* class androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass2 */

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = CascadingMenuPopup.this.mTreeObserver;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    CascadingMenuPopup.this.mTreeObserver = view.getViewTreeObserver();
                }
                CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
                cascadingMenuPopup.mTreeObserver.removeGlobalOnLayoutListener(cascadingMenuPopup.mGlobalLayoutListener);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public final Context mContext;
    public int mDropDownGravity;
    public boolean mForceShowIcon;
    public final ViewTreeObserver.OnGlobalLayoutListener mGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() {
        /* class androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass1 */

        public void onGlobalLayout() {
            if (CascadingMenuPopup.this.isShowing() && CascadingMenuPopup.this.mShowingMenus.size() > 0 && !CascadingMenuPopup.this.mShowingMenus.get(0).window.mModal) {
                View view = CascadingMenuPopup.this.mShownAnchorView;
                if (view == null || !view.isShown()) {
                    CascadingMenuPopup.this.dismiss();
                    return;
                }
                for (CascadingMenuInfo cascadingMenuInfo : CascadingMenuPopup.this.mShowingMenus) {
                    cascadingMenuInfo.window.show();
                }
            }
        }
    };
    public boolean mHasXOffset;
    public boolean mHasYOffset;
    public int mLastPosition;
    public final MenuItemHoverListener mMenuItemHoverListener = new MenuItemHoverListener() {
        /* class androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass3 */

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverEnter(final MenuBuilder menuBuilder, final MenuItem menuItem) {
            final CascadingMenuInfo cascadingMenuInfo = null;
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(null);
            int size = CascadingMenuPopup.this.mShowingMenus.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (menuBuilder == CascadingMenuPopup.this.mShowingMenus.get(i).menu) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < CascadingMenuPopup.this.mShowingMenus.size()) {
                    cascadingMenuInfo = CascadingMenuPopup.this.mShowingMenus.get(i2);
                }
                CascadingMenuPopup.this.mSubMenuHoverHandler.postAtTime(new Runnable() {
                    /* class androidx.appcompat.view.menu.CascadingMenuPopup.AnonymousClass3.AnonymousClass1 */

                    public void run() {
                        CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfo;
                        if (cascadingMenuInfo != null) {
                            CascadingMenuPopup.this.mShouldCloseImmediately = true;
                            cascadingMenuInfo.menu.close(false);
                            CascadingMenuPopup.this.mShouldCloseImmediately = false;
                        }
                        if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                            menuBuilder.performItemAction(menuItem, 4);
                        }
                    }
                }, menuBuilder, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
            CascadingMenuPopup.this.mSubMenuHoverHandler.removeCallbacksAndMessages(menuBuilder);
        }
    };
    public final int mMenuMaxWidth;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public final List<MenuBuilder> mPendingMenus = new ArrayList();
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;
    public int mRawDropDownGravity;
    public boolean mShouldCloseImmediately;
    public boolean mShowTitle;
    public final List<CascadingMenuInfo> mShowingMenus = new ArrayList();
    public View mShownAnchorView;
    public final Handler mSubMenuHoverHandler;
    public ViewTreeObserver mTreeObserver;
    public int mXOffset;
    public int mYOffset;

    public static class CascadingMenuInfo {
        public final MenuBuilder menu;
        public final int position;
        public final MenuPopupWindow window;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i) {
            this.window = menuPopupWindow;
            this.menu = menuBuilder;
            this.position = i;
        }
    }

    public CascadingMenuPopup(Context context, View view, int i, int i2, boolean z) {
        int i3 = 0;
        this.mRawDropDownGravity = 0;
        this.mDropDownGravity = 0;
        this.mContext = context;
        this.mAnchorView = view;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        this.mOverflowOnly = z;
        this.mForceShowIcon = false;
        this.mLastPosition = ViewCompat.getLayoutDirection(view) != 1 ? 1 : i3;
        Resources resources = context.getResources();
        this.mMenuMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.mSubMenuHoverHandler = new Handler();
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void addMenu(MenuBuilder menuBuilder) {
        menuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(menuBuilder);
        } else {
            this.mPendingMenus.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public boolean closeMenuOnSubMenuOpened() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        int size = this.mShowingMenus.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) this.mShowingMenus.toArray(new CascadingMenuInfo[size]);
            for (int i = size - 1; i >= 0; i--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i];
                if (cascadingMenuInfo.window.isShowing()) {
                    cascadingMenuInfo.window.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView getListView() {
        if (this.mShowingMenus.isEmpty()) {
            return null;
        }
        List<CascadingMenuInfo> list = this.mShowingMenus;
        return list.get(list.size() - 1).window.mDropDownList;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean isShowing() {
        return this.mShowingMenus.size() > 0 && this.mShowingMenus.get(0).window.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void onCloseMenu(MenuBuilder menuBuilder, boolean z) {
        int size = this.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuBuilder == this.mShowingMenus.get(i).menu) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            int i2 = i + 1;
            if (i2 < this.mShowingMenus.size()) {
                this.mShowingMenus.get(i2).menu.close(false);
            }
            CascadingMenuInfo remove = this.mShowingMenus.remove(i);
            remove.menu.removeMenuPresenter(this);
            if (this.mShouldCloseImmediately) {
                remove.window.mPopup.setExitTransition(null);
                remove.window.mPopup.setAnimationStyle(0);
            }
            remove.window.dismiss();
            int size2 = this.mShowingMenus.size();
            if (size2 > 0) {
                this.mLastPosition = this.mShowingMenus.get(size2 - 1).position;
            } else {
                this.mLastPosition = ViewCompat.getLayoutDirection(this.mAnchorView) == 1 ? 0 : 1;
            }
            if (size2 == 0) {
                dismiss();
                MenuPresenter.Callback callback = this.mPresenterCallback;
                if (callback != null) {
                    callback.onCloseMenu(menuBuilder, true);
                }
                ViewTreeObserver viewTreeObserver = this.mTreeObserver;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.mTreeObserver.removeGlobalOnLayoutListener(this.mGlobalLayoutListener);
                    }
                    this.mTreeObserver = null;
                }
                this.mShownAnchorView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
                this.mOnDismissListener.onDismiss();
            } else if (z) {
                this.mShowingMenus.get(0).menu.close(false);
            }
        }
    }

    public void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        int size = this.mShowingMenus.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = this.mShowingMenus.get(i);
            if (!cascadingMenuInfo.window.isShowing()) {
                break;
            }
            i++;
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.menu.close(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            if (subMenuBuilder == cascadingMenuInfo.menu) {
                cascadingMenuInfo.window.mDropDownList.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        subMenuBuilder.addMenuPresenter(this, this.mContext);
        if (isShowing()) {
            showMenu(subMenuBuilder);
        } else {
            this.mPendingMenus.add(subMenuBuilder);
        }
        MenuPresenter.Callback callback = this.mPresenterCallback;
        if (callback != null) {
            callback.onOpenSubMenu(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setAnchorView(View view) {
        if (this.mAnchorView != view) {
            this.mAnchorView = view;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(this.mRawDropDownGravity, ViewCompat.getLayoutDirection(view));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setGravity(int i) {
        if (this.mRawDropDownGravity != i) {
            this.mRawDropDownGravity = i;
            this.mDropDownGravity = Gravity.getAbsoluteGravity(i, ViewCompat.getLayoutDirection(this.mAnchorView));
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public void setHorizontalOffset(int i) {
        this.mHasXOffset = true;
        this.mXOffset = i;
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
        this.mHasYOffset = true;
        this.mYOffset = i;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        if (!isShowing()) {
            for (MenuBuilder menuBuilder : this.mPendingMenus) {
                showMenu(menuBuilder);
            }
            this.mPendingMenus.clear();
            View view = this.mAnchorView;
            this.mShownAnchorView = view;
            if (view != null) {
                boolean z = this.mTreeObserver == null;
                ViewTreeObserver viewTreeObserver = this.mShownAnchorView.getViewTreeObserver();
                this.mTreeObserver = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.mGlobalLayoutListener);
                }
                this.mShownAnchorView.addOnAttachStateChangeListener(this.mAttachStateChangeListener);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0141, code lost:
        if (((r9.getWidth() + r11[0]) + r4) > r10.right) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0147, code lost:
        if ((r11[0] - r4) < 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x014b, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b0  */
    public final void showMenu(MenuBuilder menuBuilder) {
        CascadingMenuInfo cascadingMenuInfo;
        int i;
        int i2;
        int i3;
        MenuItem menuItem;
        int i4;
        MenuAdapter menuAdapter;
        int firstVisiblePosition;
        LayoutInflater from = LayoutInflater.from(this.mContext);
        MenuAdapter menuAdapter2 = new MenuAdapter(menuBuilder, from, this.mOverflowOnly, ITEM_LAYOUT);
        if (!isShowing() && this.mForceShowIcon) {
            menuAdapter2.mForceShowIcon = true;
        } else if (isShowing()) {
            menuAdapter2.mForceShowIcon = MenuPopup.shouldPreserveIconSpacing(menuBuilder);
        }
        View view = null;
        int measureIndividualMenuWidth = MenuPopup.measureIndividualMenuWidth(menuAdapter2, null, this.mContext, this.mMenuMaxWidth);
        MenuPopupWindow menuPopupWindow = new MenuPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        menuPopupWindow.mHoverListener = this.mMenuItemHoverListener;
        menuPopupWindow.mItemClickListener = this;
        menuPopupWindow.mPopup.setOnDismissListener(this);
        menuPopupWindow.mDropDownAnchorView = this.mAnchorView;
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        menuPopupWindow.setModal(true);
        menuPopupWindow.mPopup.setInputMethodMode(2);
        menuPopupWindow.setAdapter(menuAdapter2);
        menuPopupWindow.setContentWidth(measureIndividualMenuWidth);
        menuPopupWindow.mDropDownGravity = this.mDropDownGravity;
        if (this.mShowingMenus.size() > 0) {
            List<CascadingMenuInfo> list = this.mShowingMenus;
            cascadingMenuInfo = list.get(list.size() - 1);
            MenuBuilder menuBuilder2 = cascadingMenuInfo.menu;
            int size = menuBuilder2.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    menuItem = null;
                    break;
                }
                menuItem = menuBuilder2.getItem(i5);
                if (menuItem.hasSubMenu() && menuBuilder == menuItem.getSubMenu()) {
                    break;
                }
                i5++;
            }
            if (menuItem != null) {
                DropDownListView dropDownListView = cascadingMenuInfo.window.mDropDownList;
                ListAdapter adapter = dropDownListView.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i4 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i4 = 0;
                }
                int count = menuAdapter.getCount();
                int i6 = 0;
                while (true) {
                    if (i6 >= count) {
                        i6 = -1;
                        break;
                    } else if (menuItem == menuAdapter.getItem(i6)) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i6 != -1 && (firstVisiblePosition = (i6 + i4) - dropDownListView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < dropDownListView.getChildCount()) {
                    view = dropDownListView.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                if (Build.VERSION.SDK_INT <= 28) {
                    Method method = MenuPopupWindow.sSetTouchModalMethod;
                    if (method != null) {
                        try {
                            method.invoke(menuPopupWindow.mPopup, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    menuPopupWindow.mPopup.setTouchModal(false);
                }
                menuPopupWindow.mPopup.setEnterTransition(null);
                List<CascadingMenuInfo> list2 = this.mShowingMenus;
                DropDownListView dropDownListView2 = list2.get(list2.size() - 1).window.mDropDownList;
                int[] iArr = new int[2];
                dropDownListView2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.mShownAnchorView.getWindowVisibleDisplayFrame(rect);
                if (this.mLastPosition == 1) {
                }
                int i7 = 1;
                boolean z = i7 == 1;
                this.mLastPosition = i7;
                if (Build.VERSION.SDK_INT >= 26) {
                    menuPopupWindow.mDropDownAnchorView = view;
                    i2 = 0;
                    i = 0;
                } else {
                    int[] iArr2 = new int[2];
                    this.mAnchorView.getLocationOnScreen(iArr2);
                    int[] iArr3 = new int[2];
                    view.getLocationOnScreen(iArr3);
                    if ((this.mDropDownGravity & 7) == 5) {
                        iArr2[0] = this.mAnchorView.getWidth() + iArr2[0];
                        iArr3[0] = view.getWidth() + iArr3[0];
                    }
                    i = iArr3[0] - iArr2[0];
                    i2 = iArr3[1] - iArr2[1];
                }
                if ((this.mDropDownGravity & 5) != 5) {
                    if (z) {
                        measureIndividualMenuWidth = view.getWidth();
                    }
                    i3 = i - measureIndividualMenuWidth;
                    menuPopupWindow.mDropDownHorizontalOffset = i3;
                    menuPopupWindow.mOverlapAnchorSet = true;
                    menuPopupWindow.mOverlapAnchor = true;
                    menuPopupWindow.setVerticalOffset(i2);
                } else if (!z) {
                    measureIndividualMenuWidth = view.getWidth();
                    i3 = i - measureIndividualMenuWidth;
                    menuPopupWindow.mDropDownHorizontalOffset = i3;
                    menuPopupWindow.mOverlapAnchorSet = true;
                    menuPopupWindow.mOverlapAnchor = true;
                    menuPopupWindow.setVerticalOffset(i2);
                }
                i3 = i + measureIndividualMenuWidth;
                menuPopupWindow.mDropDownHorizontalOffset = i3;
                menuPopupWindow.mOverlapAnchorSet = true;
                menuPopupWindow.mOverlapAnchor = true;
                menuPopupWindow.setVerticalOffset(i2);
            } else {
                if (this.mHasXOffset) {
                    menuPopupWindow.mDropDownHorizontalOffset = this.mXOffset;
                }
                if (this.mHasYOffset) {
                    menuPopupWindow.setVerticalOffset(this.mYOffset);
                }
                Rect rect2 = this.mEpicenterBounds;
                menuPopupWindow.mEpicenterBounds = rect2 != null ? new Rect(rect2) : null;
            }
            this.mShowingMenus.add(new CascadingMenuInfo(menuPopupWindow, menuBuilder, this.mLastPosition));
            menuPopupWindow.show();
            DropDownListView dropDownListView3 = menuPopupWindow.mDropDownList;
            dropDownListView3.setOnKeyListener(this);
            if (cascadingMenuInfo == null && this.mShowTitle && menuBuilder.mHeaderTitle != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView3, false);
                frameLayout.setEnabled(false);
                ((TextView) frameLayout.findViewById(16908310)).setText(menuBuilder.mHeaderTitle);
                dropDownListView3.addHeaderView(frameLayout, null, false);
                menuPopupWindow.show();
                return;
            }
            return;
        }
        cascadingMenuInfo = null;
        view = null;
        if (view == null) {
        }
        this.mShowingMenus.add(new CascadingMenuInfo(menuPopupWindow, menuBuilder, this.mLastPosition));
        menuPopupWindow.show();
        DropDownListView dropDownListView32 = menuPopupWindow.mDropDownList;
        dropDownListView32.setOnKeyListener(this);
        if (cascadingMenuInfo == null) {
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        for (CascadingMenuInfo cascadingMenuInfo : this.mShowingMenus) {
            ListAdapter adapter = cascadingMenuInfo.window.mDropDownList.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }
}
