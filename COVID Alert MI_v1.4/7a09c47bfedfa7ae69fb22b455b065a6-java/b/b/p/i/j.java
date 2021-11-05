package b.b.p.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import b.i.l.b;
import java.lang.reflect.Method;

public class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final b.i.g.a.b f740d;

    /* renamed from: e  reason: collision with root package name */
    public Method f741e;

    public class a extends b.i.l.b {

        /* renamed from: b  reason: collision with root package name */
        public final ActionProvider f742b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f742b = actionProvider;
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        public b.a f744d;

        public b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // b.i.l.b
        public boolean a() {
            return this.f742b.isVisible();
        }

        @Override // b.i.l.b
        public View b(MenuItem menuItem) {
            return this.f742b.onCreateActionView(menuItem);
        }

        @Override // b.i.l.b
        public boolean c() {
            return this.f742b.overridesItemVisibility();
        }

        @Override // b.i.l.b
        public void d(b.a aVar) {
            this.f744d = aVar;
            this.f742b.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.a aVar = this.f744d;
            if (aVar != null) {
                g gVar = i.this.n;
                gVar.h = true;
                gVar.q(true);
            }
        }
    }

    public static class c extends FrameLayout implements b.b.p.b {

        /* renamed from: b  reason: collision with root package name */
        public final CollapsibleActionView f745b;

        public c(View view) {
            super(view.getContext());
            this.f745b = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // b.b.p.b
        public void c() {
            this.f745b.onActionViewExpanded();
        }

        @Override // b.b.p.b
        public void f() {
            this.f745b.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f746a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f746a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f746a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f746a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f748a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f748a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f748a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, b.i.g.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f740d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f740d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f740d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        b.i.l.b b2 = this.f740d.b();
        if (b2 instanceof a) {
            return ((a) b2).f742b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f740d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).f745b : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f740d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f740d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f740d.getContentDescription();
    }

    public int getGroupId() {
        return this.f740d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f740d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f740d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f740d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f740d.getIntent();
    }

    public int getItemId() {
        return this.f740d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f740d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f740d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f740d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f740d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f740d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f740d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f740d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f740d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f740d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f740d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f740d.isCheckable();
    }

    public boolean isChecked() {
        return this.f740d.isChecked();
    }

    public boolean isEnabled() {
        return this.f740d.isEnabled();
    }

    public boolean isVisible() {
        return this.f740d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.f690a, actionProvider);
        b.i.g.a.b bVar2 = this.f740d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f740d.setActionView(i);
        View actionView = this.f740d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f740d.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f740d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f740d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f740d.setAlphabeticShortcut(c2, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f740d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f740d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f740d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f740d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f740d.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f740d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f740d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f740d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f740d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f740d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.f740d.setNumericShortcut(c2, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f740d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f740d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f740d.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f740d.setShortcut(c2, c3, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        this.f740d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f740d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f740d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f740d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f740d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f740d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f740d.setVisible(z);
    }
}
