package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {
    public MenuPresenter.Callback mCallback;
    public Context mContext;
    public int mItemLayoutRes;
    public MenuBuilder mMenu;
    public int mMenuLayoutRes;
    public MenuView mMenuView;
    public Context mSystemContext;
    public LayoutInflater mSystemInflater;

    public BaseMenuPresenter(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        if (view instanceof MenuView.ItemView) {
            itemView = (MenuView.ItemView) view;
        } else {
            itemView = (MenuView.ItemView) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
        }
        ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) this;
        itemView.initialize(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) actionMenuPresenter.mMenuView);
        if (actionMenuPresenter.mPopupCallback == null) {
            actionMenuPresenter.mPopupCallback = new ActionMenuPresenter.ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(actionMenuPresenter.mPopupCallback);
        return (View) itemView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.MenuBuilder] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.mCallback;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        if (callback == null) {
            return false;
        }
        if (subMenuBuilder == null) {
            subMenuBuilder2 = this.mMenu;
        }
        return callback.onOpenSubMenu(subMenuBuilder2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void setCallback(MenuPresenter.Callback callback) {
        this.mCallback = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void updateMenuView(boolean z) {
        int i;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.mMenu;
            if (menuBuilder != null) {
                menuBuilder.flagActionItems();
                ArrayList<MenuItemImpl> visibleItems = this.mMenu.getVisibleItems();
                int size = visibleItems.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    MenuItemImpl menuItemImpl = visibleItems.get(i2);
                    if (menuItemImpl.isActionButton()) {
                        View childAt = viewGroup.getChildAt(i);
                        MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                        View itemView = getItemView(menuItemImpl, childAt, viewGroup);
                        if (menuItemImpl != itemData) {
                            itemView.setPressed(false);
                            itemView.jumpDrawablesToCurrentState();
                        }
                        if (itemView != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) itemView.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(itemView);
                            }
                            ((ViewGroup) this.mMenuView).addView(itemView, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == ((ActionMenuPresenter) this).mOverflowButton) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i);
                    z2 = true;
                }
                if (!z2) {
                    i++;
                }
            }
        }
    }
}
