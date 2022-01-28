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
    public final b.i.g.a.b f554d;

    /* renamed from: e  reason: collision with root package name */
    public Method f555e;

    public class a extends b.i.l.b {

        /* renamed from: b  reason: collision with root package name */
        public final ActionProvider f556b;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f556b = actionProvider;
        }
    }

    public class b extends a implements ActionProvider.VisibilityListener {

        /* renamed from: d  reason: collision with root package name */
        public b.a f558d;

        public b(j jVar, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // b.i.l.b
        public boolean a() {
            return this.f556b.isVisible();
        }

        @Override // b.i.l.b
        public View b(MenuItem menuItem) {
            return this.f556b.onCreateActionView(menuItem);
        }

        @Override // b.i.l.b
        public boolean c() {
            return this.f556b.overridesItemVisibility();
        }

        @Override // b.i.l.b
        public void d(b.a aVar) {
            this.f558d = aVar;
            this.f556b.setVisibilityListener(this);
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            b.a aVar = this.f558d;
            if (aVar != null) {
                g gVar = i.this.n;
                gVar.h = true;
                gVar.q(true);
            }
        }
    }

    public static class c extends FrameLayout implements b.b.p.b {

        /* renamed from: b  reason: collision with root package name */
        public final CollapsibleActionView f559b;

        public c(View view) {
            super(view.getContext());
            this.f559b = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // b.b.p.b
        public void c() {
            this.f559b.onActionViewExpanded();
        }

        @Override // b.b.p.b
        public void f() {
            this.f559b.onActionViewCollapsed();
        }
    }

    public class d implements MenuItem.OnActionExpandListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnActionExpandListener f560a;

        public d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f560a = onActionExpandListener;
        }

        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f560a.onMenuItemActionCollapse(j.this.c(menuItem));
        }

        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f560a.onMenuItemActionExpand(j.this.c(menuItem));
        }
    }

    public class e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final MenuItem.OnMenuItemClickListener f562a;

        public e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f562a = onMenuItemClickListener;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f562a.onMenuItemClick(j.this.c(menuItem));
        }
    }

    public j(Context context, b.i.g.a.b bVar) {
        super(context);
        if (bVar != null) {
            this.f554d = bVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public boolean collapseActionView() {
        return this.f554d.collapseActionView();
    }

    public boolean expandActionView() {
        return this.f554d.expandActionView();
    }

    public ActionProvider getActionProvider() {
        b.i.l.b b2 = this.f554d.b();
        if (b2 instanceof a) {
            return ((a) b2).f556b;
        }
        return null;
    }

    public View getActionView() {
        View actionView = this.f554d.getActionView();
        return actionView instanceof c ? (View) ((c) actionView).f559b : actionView;
    }

    public int getAlphabeticModifiers() {
        return this.f554d.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.f554d.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.f554d.getContentDescription();
    }

    public int getGroupId() {
        return this.f554d.getGroupId();
    }

    public Drawable getIcon() {
        return this.f554d.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.f554d.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f554d.getIconTintMode();
    }

    public Intent getIntent() {
        return this.f554d.getIntent();
    }

    public int getItemId() {
        return this.f554d.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f554d.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.f554d.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.f554d.getNumericShortcut();
    }

    public int getOrder() {
        return this.f554d.getOrder();
    }

    public SubMenu getSubMenu() {
        return d(this.f554d.getSubMenu());
    }

    public CharSequence getTitle() {
        return this.f554d.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.f554d.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.f554d.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.f554d.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.f554d.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.f554d.isCheckable();
    }

    public boolean isChecked() {
        return this.f554d.isChecked();
    }

    public boolean isEnabled() {
        return this.f554d.isEnabled();
    }

    public boolean isVisible() {
        return this.f554d.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        b bVar = new b(this, this.f514a, actionProvider);
        b.i.g.a.b bVar2 = this.f554d;
        if (actionProvider == null) {
            bVar = null;
        }
        bVar2.a(bVar);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f554d.setActionView(i);
        View actionView = this.f554d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f554d.setActionView(new c(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new c(view);
        }
        this.f554d.setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2) {
        this.f554d.setAlphabeticShortcut(c2);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c2, int i) {
        this.f554d.setAlphabeticShortcut(c2, i);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f554d.setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f554d.setChecked(z);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f554d.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f554d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f554d.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f554d.setIcon(drawable);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f554d.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f554d.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f554d.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c2) {
        this.f554d.setNumericShortcut(c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c2, int i) {
        this.f554d.setNumericShortcut(c2, i);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f554d.setOnActionExpandListener(onActionExpandListener != null ? new d(onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f554d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new e(onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3) {
        this.f554d.setShortcut(c2, c3);
        return this;
    }

    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        this.f554d.setShortcut(c2, c3, i, i2);
        return this;
    }

    public void setShowAsAction(int i) {
        this.f554d.setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        this.f554d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f554d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f554d.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f554d.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f554d.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return this.f554d.setVisible(z);
    }
}
