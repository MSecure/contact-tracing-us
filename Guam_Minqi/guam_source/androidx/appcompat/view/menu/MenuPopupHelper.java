package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewCompat;

public class MenuPopupHelper {
    public View mAnchorView;
    public final Context mContext;
    public int mDropDownGravity = 8388611;
    public boolean mForceShowIcon;
    public final PopupWindow.OnDismissListener mInternalOnDismissListener = new PopupWindow.OnDismissListener() {
        /* class androidx.appcompat.view.menu.MenuPopupHelper.AnonymousClass1 */

        public void onDismiss() {
            MenuPopupHelper.this.onDismiss();
        }
    };
    public final MenuBuilder mMenu;
    public PopupWindow.OnDismissListener mOnDismissListener;
    public final boolean mOverflowOnly;
    public MenuPopup mPopup;
    public final int mPopupStyleAttr;
    public final int mPopupStyleRes;
    public MenuPresenter.Callback mPresenterCallback;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.mContext = context;
        this.mMenu = menuBuilder;
        this.mAnchorView = view;
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
    }

    public MenuPopup getPopup() {
        MenuPopup menuPopup;
        if (this.mPopup == null) {
            Display defaultDisplay = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= this.mContext.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width)) {
                menuPopup = new CascadingMenuPopup(this.mContext, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            } else {
                menuPopup = new StandardMenuPopup(this.mContext, this.mMenu, this.mAnchorView, this.mPopupStyleAttr, this.mPopupStyleRes, this.mOverflowOnly);
            }
            menuPopup.addMenu(this.mMenu);
            menuPopup.setOnDismissListener(this.mInternalOnDismissListener);
            menuPopup.setAnchorView(this.mAnchorView);
            menuPopup.setCallback(this.mPresenterCallback);
            menuPopup.setForceShowIcon(this.mForceShowIcon);
            menuPopup.setGravity(this.mDropDownGravity);
            this.mPopup = menuPopup;
        }
        return this.mPopup;
    }

    public boolean isShowing() {
        MenuPopup menuPopup = this.mPopup;
        return menuPopup != null && menuPopup.isShowing();
    }

    public void onDismiss() {
        this.mPopup = null;
        PopupWindow.OnDismissListener onDismissListener = this.mOnDismissListener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void setPresenterCallback(MenuPresenter.Callback callback) {
        this.mPresenterCallback = callback;
        MenuPopup menuPopup = this.mPopup;
        if (menuPopup != null) {
            menuPopup.setCallback(callback);
        }
    }

    public final void showPopup(int i, int i2, boolean z, boolean z2) {
        MenuPopup popup = getPopup();
        popup.setShowTitle(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.mDropDownGravity, ViewCompat.getLayoutDirection(this.mAnchorView)) & 7) == 5) {
                i -= this.mAnchorView.getWidth();
            }
            popup.setHorizontalOffset(i);
            popup.setVerticalOffset(i2);
            int i3 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            popup.mEpicenterBounds = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        popup.show();
    }

    public boolean tryShow() {
        if (isShowing()) {
            return true;
        }
        if (this.mAnchorView == null) {
            return false;
        }
        showPopup(0, 0, false, false);
        return true;
    }
}
