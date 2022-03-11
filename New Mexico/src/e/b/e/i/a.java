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
import e.j.b.a;
import e.j.e.a.b;
import e.j.j.d;
/* loaded from: classes.dex */
public class a implements b {
    public CharSequence a;
    public CharSequence b;
    public Intent c;

    /* renamed from: d  reason: collision with root package name */
    public char f817d;

    /* renamed from: f  reason: collision with root package name */
    public char f819f;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f821h;

    /* renamed from: i  reason: collision with root package name */
    public Context f822i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f823j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f824k;

    /* renamed from: e  reason: collision with root package name */
    public int f818e = 4096;

    /* renamed from: g  reason: collision with root package name */
    public int f820g = 4096;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f825l = null;
    public PorterDuff.Mode m = null;
    public boolean n = false;
    public boolean o = false;
    public int p = 16;

    public a(Context context, int i2, int i3, int i4, CharSequence charSequence) {
        this.f822i = context;
        this.a = charSequence;
    }

    @Override // e.j.e.a.b
    public b a(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.e.a.b
    public d b() {
        return null;
    }

    public final void c() {
        Drawable drawable = this.f821h;
        if (drawable == null) {
            return;
        }
        if (this.n || this.o) {
            Drawable X1 = m.e.X1(drawable);
            this.f821h = X1;
            Drawable mutate = X1.mutate();
            this.f821h = mutate;
            if (this.n) {
                mutate.setTintList(this.f825l);
            }
            if (this.o) {
                this.f821h.setTintMode(this.m);
            }
        }
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f820g;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f819f;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f823j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f821h;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f825l;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f818e;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f817d;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.b;
        return charSequence != null ? charSequence : this.a;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f824k;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f819f = Character.toLowerCase(c);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        this.f819f = Character.toLowerCase(c);
        this.f820g = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.p = (z ? 1 : 0) | (this.p & -2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.p = (z ? 2 : 0) | (this.p & -3);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription */
    public MenuItem mo4setContentDescription(CharSequence charSequence) {
        this.f823j = charSequence;
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription  reason: collision with other method in class */
    public b mo4setContentDescription(CharSequence charSequence) {
        this.f823j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.p = (z ? 16 : 0) | (this.p & -17);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        Context context = this.f822i;
        Object obj = e.j.b.a.a;
        this.f821h = a.b.b(context, i2);
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f821h = drawable;
        c();
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f825l = colorStateList;
        this.n = true;
        c();
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        this.o = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f817d = c;
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i2) {
        this.f817d = c;
        this.f818e = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f817d = c;
        this.f819f = Character.toLowerCase(c2);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i2, int i3) {
        this.f817d = c;
        this.f818e = KeyEvent.normalizeMetaState(i2);
        this.f819f = Character.toLowerCase(c2);
        this.f820g = KeyEvent.normalizeMetaState(i3);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.a = this.f822i.getResources().getString(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.b = charSequence;
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText */
    public MenuItem mo5setTooltipText(CharSequence charSequence) {
        this.f824k = charSequence;
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText  reason: collision with other method in class */
    public b mo5setTooltipText(CharSequence charSequence) {
        this.f824k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        int i2 = 8;
        int i3 = this.p & 8;
        if (z) {
            i2 = 0;
        }
        this.p = i3 | i2;
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }
}
