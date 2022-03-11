package e.b.e.i;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import e.b.a.m;
import e.j.e.a.b;
import e.j.j.d;
import java.util.Objects;
/* loaded from: classes.dex */
public final class i implements b {
    public d A;
    public MenuItem.OnActionExpandListener B;
    public ContextMenu.ContextMenuInfo D;
    public final int a;
    public final int b;
    public final int c;

    /* renamed from: d */
    public final int f862d;

    /* renamed from: e */
    public CharSequence f863e;

    /* renamed from: f */
    public CharSequence f864f;

    /* renamed from: g */
    public Intent f865g;

    /* renamed from: h */
    public char f866h;

    /* renamed from: j */
    public char f868j;

    /* renamed from: l */
    public Drawable f870l;
    public g n;
    public r o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public int y;
    public View z;

    /* renamed from: i */
    public int f867i = 4096;

    /* renamed from: k */
    public int f869k = 4096;
    public int m = 0;
    public ColorStateList s = null;
    public PorterDuff.Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public boolean C = false;

    /* loaded from: classes.dex */
    public class a implements d.a {
        public a() {
            i.this = r1;
        }
    }

    public i(g gVar, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.y = 0;
        this.n = gVar;
        this.a = i3;
        this.b = i2;
        this.c = i4;
        this.f862d = i5;
        this.f863e = charSequence;
        this.y = i6;
    }

    public static void c(StringBuilder sb, int i2, int i3, String str) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    @Override // e.j.e.a.b
    public b a(d dVar) {
        d dVar2 = this.A;
        if (dVar2 != null) {
            dVar2.a = null;
        }
        this.z = null;
        this.A = dVar;
        this.n.q(true);
        d dVar3 = this.A;
        if (dVar3 != null) {
            dVar3.h(new a());
        }
        return this;
    }

    @Override // e.j.e.a.b
    public d b() {
        return this.A;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.d(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.w && (this.u || this.v)) {
            drawable = m.e.X1(drawable).mutate();
            if (this.u) {
                drawable.setTintList(this.s);
            }
            if (this.v) {
                drawable.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable;
    }

    public char e() {
        return this.n.n() ? this.f868j : this.f866h;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!f()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.f(this);
        }
        return false;
    }

    public boolean f() {
        d dVar;
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null && (dVar = this.A) != null) {
            this.z = dVar.d(this);
        }
        return this.z != null;
    }

    public boolean g() {
        return (this.x & 32) == 32;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        d dVar = this.A;
        if (dVar == null) {
            return null;
        }
        View d2 = dVar.d(this);
        this.z = d2;
        return d2;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f869k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f868j;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f870l;
        if (drawable != null) {
            return d(drawable);
        }
        int i2 = this.m;
        if (i2 == 0) {
            return null;
        }
        Drawable i0 = m.e.i0(this.n.a, i2);
        this.m = 0;
        this.f870l = i0;
        return d(i0);
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.s;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f865g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.D;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f867i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f866h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f863e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f864f;
        return charSequence != null ? charSequence : this.f863e;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.r;
    }

    public boolean h() {
        return (this.x & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    public b i(View view) {
        int i2;
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i2 = this.a) > 0) {
            view.setId(i2);
        }
        this.n.p();
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        d dVar = this.A;
        return (dVar == null || !dVar.g()) ? (this.x & 8) == 0 : (this.x & 8) == 0 && this.A.b();
    }

    public void j(boolean z) {
        int i2 = this.x;
        int i3 = (z ? 2 : 0) | (i2 & -3);
        this.x = i3;
        if (i2 != i3) {
            this.n.q(false);
        }
    }

    public void k(boolean z) {
        this.x = z ? this.x | 32 : this.x & -33;
    }

    public boolean l(boolean z) {
        int i2 = this.x;
        int i3 = (z ? 0 : 8) | (i2 & -9);
        this.x = i3;
        return i2 != i3;
    }

    public boolean m() {
        return this.n.o() && e() != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setActionView(int i2) {
        Context context = this.n.a;
        i(LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        i(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f868j == c) {
            return this;
        }
        this.f868j = Character.toLowerCase(c);
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i2) {
        if (this.f868j == c && this.f869k == i2) {
            return this;
        }
        this.f868j = Character.toLowerCase(c);
        this.f869k = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i2 = this.x;
        int i3 = (z ? 1 : 0) | (i2 & -2);
        this.x = i3;
        if (i2 != i3) {
            this.n.q(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.x & 4) != 0) {
            g gVar = this.n;
            Objects.requireNonNull(gVar);
            int groupId = getGroupId();
            int size = gVar.f854f.size();
            gVar.z();
            for (int i2 = 0; i2 < size; i2++) {
                i iVar = gVar.f854f.get(i2);
                if (iVar.b == groupId && iVar.h() && iVar.isCheckable()) {
                    iVar.j(iVar == this);
                }
            }
            gVar.y();
        } else {
            j(z);
        }
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription */
    public MenuItem mo4setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setContentDescription */
    public b mo4setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.x = z ? this.x | 16 : this.x & -17;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i2) {
        this.f870l = null;
        this.m = i2;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.f870l = drawable;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.u = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.t = mode;
        this.v = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f865g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f866h == c) {
            return this;
        }
        this.f866h = c;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i2) {
        if (this.f866h == c && this.f867i == i2) {
            return this;
        }
        this.f866h = c;
        this.f867i = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f866h = c;
        this.f868j = Character.toLowerCase(c2);
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i2, int i3) {
        this.f866h = c;
        this.f867i = KeyEvent.normalizeMetaState(i2);
        this.f868j = Character.toLowerCase(c2);
        this.f869k = KeyEvent.normalizeMetaState(i3);
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 == 0 || i3 == 1 || i3 == 2) {
            this.y = i2;
            this.n.p();
            return;
        }
        throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i2) {
        setTitle(this.n.a.getString(i2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f863e = charSequence;
        this.n.q(false);
        r rVar = this.o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f864f = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText */
    public MenuItem mo5setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // e.j.e.a.b, android.view.MenuItem
    /* renamed from: setTooltipText */
    public b mo5setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (l(z)) {
            g gVar = this.n;
            gVar.f856h = true;
            gVar.q(true);
        }
        return this;
    }

    @Override // java.lang.Object
    public String toString() {
        CharSequence charSequence = this.f863e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }
}
