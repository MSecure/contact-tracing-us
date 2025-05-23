package e.b.e.i;

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
import e.i.i.b;
import java.lang.reflect.Method;

public class j extends c implements MenuItem {

    /* renamed from: d  reason: collision with root package name */
    public final e.i.d.a.b f805d;

    /* renamed from: e  reason: collision with root package name */
    public Method f806e;

    public class a extends e.i.i.b {
        public final ActionProvider b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.b = actionProvider;
        }

        @Override // e.i.i.b
        public boolean a() {
            return this.b.hasSubMenu();
        }

        @Override // e.i.i.b
        public View c() {
            return this.b.onCreateActionView();
        }

        @Override // e.i.i.b
        public boolean e() {
            return this.b.onPerformDefaultAction();
        }

        @Override // e.i.i.b
        public void f(SubMenu subMenu) {
            this.b.onPrepareSubMenu(j.this.d(subMenu));
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        public b.a f807d;

        public b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // e.i.i.b
        public boolean b() {
            return this.b.isVisible();
        }

        @Override // e.i.i.b
        public View d(MenuItem menuItem) {
            return this.b.onCreateActionView(menuItem);
        }

        @Override // e.i.i.b
        public boolean g() {
            return this.b.overridesItemVisibility();
        }

        @Override // e.i.i.b
        public void h(b.a aVar) {
            this.f807d = aVar;
            this.b.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.a aVar = this.f807d;
            if (aVar != null) {
                g gVar = i.this.n;
                gVar.f790h = true;
                gVar.q(true);
            }
        }
    }

    public static class c extends FrameLayout implements e.b.e.b {
        public final CollapsibleActionView b;

        public c(View view) {
            super(view.getContext());
            this.b = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // e.b.e.b
        public void c() {
            this.b.onActionViewExpanded();
        }

        @Override // e.b.e.b
        public void e() {
            this.b.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {
        public final MenuItem.OnActionExpandListener a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {
        public final MenuItem.OnMenuItemClickListener a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, e.i.d.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f805d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f805d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f805d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        e.i.i.b b2 = this.f805d.b();
        if (b2 instanceof a) {
            return ((a) b2).b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f805d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).b : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f805d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f805d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f805d.getContentDescription();
    }

    public int getGroupId() {
        return this.f805d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f805d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f805d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f805d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f805d.getIntent();
    }

    public int getItemId() {
        return this.f805d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f805d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f805d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f805d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f805d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f805d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f805d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f805d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f805d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f805d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f805d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f805d.isCheckable();
    }

    public boolean isChecked() {
        return this.f805d.isChecked();
    }

    public boolean isEnabled() {
        return this.f805d.isEnabled();
    }

    public boolean isVisible() {
        return this.f805d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.a, actionProvider);
        e.i.d.a.b bVar2 = this.f805d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i2) {
        this.f805d.setActionView(i2);
        View actionView = this.f805d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f805d.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f805d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f805d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i2) {
        this.f805d.setAlphabeticShortcut(c2, i2);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f805d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f805d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f805d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f805d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f805d.setIcon(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f805d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f805d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f805d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f805d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f805d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i2) {
        this.f805d.setNumericShortcut(c2, i2);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f805d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f805d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f805d.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f805d.setShortcut(c2, c3, i2, i3);
        return this;
    }

    public void setShowAsAction(int i2) {
        this.f805d.setShowAsAction(i2);
    }

    public MenuItem setShowAsActionFlags(int i2) {
        this.f805d.setShowAsActionFlags(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        this.f805d.setTitle(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f805d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f805d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f805d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f805d.setVisible(z);
    }
}
