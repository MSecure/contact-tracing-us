package b.b.p.i;

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
import b.i.g.a.b;

public class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final int f505a;

    /* renamed from: b  reason: collision with root package name */
    public final int f506b;

    /* renamed from: c  reason: collision with root package name */
    public final int f507c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f508d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f509e;
    public Intent f;
    public char g;
    public int h = 4096;
    public char i;
    public int j = 4096;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;
    public ColorStateList o = null;
    public PorterDuff.Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    public a(Context context, int i2, int i3, int i4, CharSequence charSequence) {
        this.l = context;
        this.f505a = i3;
        this.f506b = i2;
        this.f507c = i4;
        this.f508d = charSequence;
    }

    @Override // b.i.g.a.b
    public b a(b.i.l.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.g.a.b
    public b.i.l.b b() {
        return null;
    }

    public final void c() {
        if (this.k == null) {
            return;
        }
        if (this.q || this.r) {
            Drawable drawable = this.k;
            this.k = drawable;
            Drawable mutate = drawable.mutate();
            this.k = mutate;
            if (this.q) {
                mutate.setTintList(this.o);
            }
            if (this.r) {
                this.k.setTintMode(this.p);
            }
        }
    }

    @Override // b.i.g.a.b
    public boolean collapseActionView() {
        return false;
    }

    @Override // b.i.g.a.b
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.g.a.b
    public View getActionView() {
        return null;
    }

    @Override // b.i.g.a.b
    public int getAlphabeticModifiers() {
        return this.j;
    }

    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // b.i.g.a.b
    public CharSequence getContentDescription() {
        return this.m;
    }

    public int getGroupId() {
        return this.f506b;
    }

    public Drawable getIcon() {
        return this.k;
    }

    @Override // b.i.g.a.b
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // b.i.g.a.b
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    public Intent getIntent() {
        return this.f;
    }

    public int getItemId() {
        return this.f505a;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // b.i.g.a.b
    public int getNumericModifiers() {
        return this.h;
    }

    public char getNumericShortcut() {
        return this.g;
    }

    public int getOrder() {
        return this.f507c;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f508d;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f509e;
        return charSequence != null ? charSequence : this.f508d;
    }

    @Override // b.i.g.a.b
    public CharSequence getTooltipText() {
        return this.n;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override // b.i.g.a.b
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.g.a.b, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.i = Character.toLowerCase(c2);
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & -3);
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // b.i.g.a.b
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public b m0setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.k = b.i.e.a.c(this.l, i2);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        c();
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        c();
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.g = c2;
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.g = c2;
        this.i = Character.toLowerCase(c3);
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.g = c2;
        this.h = KeyEvent.normalizeMetaState(i2);
        this.i = Character.toLowerCase(c3);
        this.j = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // b.i.g.a.b
    public void setShowAsAction(int i2) {
    }

    @Override // b.i.g.a.b
    public MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f508d = this.l.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f508d = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f509e = charSequence;
        return this;
    }

    @Override // b.i.g.a.b
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // b.i.g.a.b
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public b m1setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.s & 8;
        if (z) {
            i2 = 0;
        }
        this.s = i3 | i2;
        return this;
    }

    @Override // b.i.g.a.b, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }
}
