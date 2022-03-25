package e.b.e.i;

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
import e.b.a.m;
import e.i.d.a.b;

public class a implements b {
    public CharSequence a;
    public CharSequence b;
    public Intent c;

    /* renamed from: d  reason: collision with root package name */
    public char f755d;

    /* renamed from: e  reason: collision with root package name */
    public int f756e = 4096;

    /* renamed from: f  reason: collision with root package name */
    public char f757f;

    /* renamed from: g  reason: collision with root package name */
    public int f758g = 4096;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f759h;

    /* renamed from: i  reason: collision with root package name */
    public Context f760i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f761j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f762k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f763l = null;
    public PorterDuff.Mode m = null;
    public boolean n = false;
    public boolean o = false;
    public int p = 16;

    public a(Context context, int i2, int i3, int i4, CharSequence charSequence) {
        this.f760i = context;
        this.a = charSequence;
    }

    @Override // e.i.d.a.b
    public b a(e.i.i.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // e.i.d.a.b
    public e.i.i.b b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f759h;
        if (drawable == null) {
            return;
        }
        if (this.n || this.o) {
            Drawable w1 = m.h.w1(drawable);
            this.f759h = w1;
            Drawable mutate = w1.mutate();
            this.f759h = mutate;
            if (this.n) {
                mutate.setTintList(this.f763l);
            }
            if (this.o) {
                this.f759h.setTintMode(this.m);
            }
        }
    }

    @Override // e.i.d.a.b
    public boolean collapseActionView() {
        return false;
    }

    @Override // e.i.d.a.b
    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // e.i.d.a.b
    public View getActionView() {
        return null;
    }

    @Override // e.i.d.a.b
    public int getAlphabeticModifiers() {
        return this.f758g;
    }

    public char getAlphabeticShortcut() {
        return this.f757f;
    }

    @Override // e.i.d.a.b
    public CharSequence getContentDescription() {
        return this.f761j;
    }

    public int getGroupId() {
        return 0;
    }

    public Drawable getIcon() {
        return this.f759h;
    }

    @Override // e.i.d.a.b
    public ColorStateList getIconTintList() {
        return this.f763l;
    }

    @Override // e.i.d.a.b
    public PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    public Intent getIntent() {
        return this.c;
    }

    public int getItemId() {
        return 16908332;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // e.i.d.a.b
    public int getNumericModifiers() {
        return this.f756e;
    }

    public char getNumericShortcut() {
        return this.f755d;
    }

    public int getOrder() {
        return 0;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.a;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.b;
        return charSequence != null ? charSequence : this.a;
    }

    @Override // e.i.d.a.b
    public CharSequence getTooltipText() {
        return this.f762k;
    }

    public boolean hasSubMenu() {
        return false;
    }

    @Override // e.i.d.a.b
    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    public boolean isChecked() {
        return (this.p & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.p & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // e.i.d.a.b, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f757f = Character.toLowerCase(c2);
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f757f = Character.toLowerCase(c2);
        this.f758g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.p = (z ? 1 : 0) | (this.p & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.p = (z ? 2 : 0) | (this.p & -3);
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f761j = charSequence;
        return this;
    }

    @Override // e.i.d.a.b
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public b m2setContentDescription(CharSequence charSequence) {
        this.f761j = charSequence;
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.p = (z ? 16 : 0) | (this.p & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        Context context = this.f760i;
        Object obj = e.i.b.a.a;
        this.f759h = context.getDrawable(i2);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f759h = drawable;
        c();
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f763l = colorStateList;
        this.n = true;
        c();
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        c();
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.c = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f755d = c2;
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f755d = c2;
        this.f756e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f755d = c2;
        this.f757f = Character.toLowerCase(c3);
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f755d = c2;
        this.f756e = KeyEvent.normalizeMetaState(i2);
        this.f757f = Character.toLowerCase(c3);
        this.f758g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // e.i.d.a.b
    public void setShowAsAction(int i2) {
    }

    @Override // e.i.d.a.b
    public MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.a = this.f760i.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.a = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    @Override // e.i.d.a.b
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f762k = charSequence;
        return this;
    }

    @Override // e.i.d.a.b
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public b m3setTooltipText(CharSequence charSequence) {
        this.f762k = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.p & 8;
        if (z) {
            i2 = 0;
        }
        this.p = i3 | i2;
        return this;
    }

    @Override // e.i.d.a.b, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }
}
