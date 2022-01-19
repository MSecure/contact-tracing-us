package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.internal.view.SupportMenuItem;

public class ActionMenuItem implements SupportMenuItem {
    public CharSequence mContentDescription;
    public Context mContext;
    public int mFlags = 16;
    public final int mGroup;
    public boolean mHasIconTint = false;
    public boolean mHasIconTintMode = false;
    public Drawable mIconDrawable;
    public ColorStateList mIconTintList = null;
    public PorterDuff.Mode mIconTintMode = null;
    public final int mId;
    public Intent mIntent;
    public final int mOrdering;
    public char mShortcutAlphabeticChar;
    public int mShortcutAlphabeticModifiers = 4096;
    public char mShortcutNumericChar;
    public int mShortcutNumericModifiers = 4096;
    public CharSequence mTitle;
    public CharSequence mTitleCondensed;
    public CharSequence mTooltipText;

    public ActionMenuItem(Context context, int i, int i2, int i3, CharSequence charSequence) {
        this.mContext = context;
        this.mId = i2;
        this.mGroup = i;
        this.mOrdering = i3;
        this.mTitle = charSequence;
    }

    public final void applyIconTint() {
        if (this.mIconDrawable == null) {
            return;
        }
        if (this.mHasIconTint || this.mHasIconTintMode) {
            Drawable drawable = this.mIconDrawable;
            this.mIconDrawable = drawable;
            Drawable mutate = drawable.mutate();
            this.mIconDrawable = mutate;
            if (this.mHasIconTint) {
                mutate.setTintList(this.mIconTintList);
            }
            if (this.mHasIconTintMode) {
                this.mIconDrawable.setTintMode(this.mIconTintMode);
            }
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public View getActionView() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        return this.mIconDrawable;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mOrdering;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return null;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        return charSequence != null ? charSequence : this.mTitle;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.mFlags & 1) != 0;
    }

    public boolean isChecked() {
        return (this.mFlags & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    public boolean isVisible() {
        return (this.mFlags & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.mFlags = (z ? 1 : 0) | (this.mFlags & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.mFlags = (z ? 2 : 0) | (this.mFlags & -3);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.mFlags = (z ? 16 : 0) | (this.mFlags & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.mIconDrawable = drawable;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        applyIconTint();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.mShortcutNumericChar = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.mShortcutNumericChar = c;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public void setShowAsAction(int i) {
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i = 8;
        int i2 = this.mFlags & 8;
        if (z) {
            i = 0;
        }
        this.mFlags = i2 | i;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public SupportMenuItem m1setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.mTitle = this.mContext.getResources().getString(i);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public SupportMenuItem m2setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.mIconDrawable = ContextCompat.getDrawable(this.mContext, i);
        applyIconTint();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState(i);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
