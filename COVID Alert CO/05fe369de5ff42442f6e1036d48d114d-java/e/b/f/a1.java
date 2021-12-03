package e.b.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.m;
import e.i.i.s;
import e.i.i.u;
import java.util.Objects;

public class a1 implements d0 {
    public Toolbar a;
    public int b;
    public View c;

    /* renamed from: d  reason: collision with root package name */
    public View f837d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f838e;

    /* renamed from: f  reason: collision with root package name */
    public Drawable f839f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f840g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f841h;

    /* renamed from: i  reason: collision with root package name */
    public CharSequence f842i;

    /* renamed from: j  reason: collision with root package name */
    public CharSequence f843j;

    /* renamed from: k  reason: collision with root package name */
    public CharSequence f844k;

    /* renamed from: l  reason: collision with root package name */
    public Window.Callback f845l;
    public boolean m;
    public c n;
    public int o = 0;
    public Drawable p;

    public class a extends u {
        public boolean a = false;
        public final /* synthetic */ int b;

        public a(int i2) {
            this.b = i2;
        }

        @Override // e.i.i.t
        public void a(View view) {
            if (!this.a) {
                a1.this.a.setVisibility(this.b);
            }
        }

        @Override // e.i.i.u, e.i.i.t
        public void b(View view) {
            a1.this.a.setVisibility(0);
        }

        @Override // e.i.i.u, e.i.i.t
        public void c(View view) {
            this.a = true;
        }
    }

    public a1(Toolbar toolbar, boolean z) {
        int i2;
        Drawable drawable;
        int i3 = R$string.abc_action_bar_up_description;
        this.a = toolbar;
        this.f842i = toolbar.getTitle();
        this.f843j = toolbar.getSubtitle();
        this.f841h = this.f842i != null;
        this.f840g = toolbar.getNavigationIcon();
        String str = null;
        y0 q = y0.q(toolbar.getContext(), null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        this.p = q.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence n2 = q.n(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(n2)) {
                setTitle(n2);
            }
            CharSequence n3 = q.n(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(n3)) {
                this.f843j = n3;
                if ((this.b & 8) != 0) {
                    this.a.setSubtitle(n3);
                }
            }
            Drawable g2 = q.g(R$styleable.ActionBar_logo);
            if (g2 != null) {
                this.f839f = g2;
                A();
            }
            Drawable g3 = q.g(R$styleable.ActionBar_icon);
            if (g3 != null) {
                this.f838e = g3;
                A();
            }
            if (this.f840g == null && (drawable = this.p) != null) {
                this.f840g = drawable;
                z();
            }
            x(q.j(R$styleable.ActionBar_displayOptions, 0));
            int l2 = q.l(R$styleable.ActionBar_customNavigationLayout, 0);
            if (l2 != 0) {
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(l2, (ViewGroup) this.a, false);
                View view = this.f837d;
                if (!(view == null || (this.b & 16) == 0)) {
                    this.a.removeView(view);
                }
                this.f837d = inflate;
                if (!(inflate == null || (this.b & 16) == 0)) {
                    this.a.addView(inflate);
                }
                x(this.b | 16);
            }
            int k2 = q.k(R$styleable.ActionBar_height, 0);
            if (k2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = k2;
                this.a.setLayoutParams(layoutParams);
            }
            int e2 = q.e(R$styleable.ActionBar_contentInsetStart, -1);
            int e3 = q.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (e2 >= 0 || e3 >= 0) {
                Toolbar toolbar2 = this.a;
                int max = Math.max(e2, 0);
                int max2 = Math.max(e3, 0);
                toolbar2.d();
                toolbar2.u.a(max, max2);
            }
            int l3 = q.l(R$styleable.ActionBar_titleTextStyle, 0);
            if (l3 != 0) {
                Toolbar toolbar3 = this.a;
                Context context = toolbar3.getContext();
                toolbar3.m = l3;
                TextView textView = toolbar3.c;
                if (textView != null) {
                    textView.setTextAppearance(context, l3);
                }
            }
            int l4 = q.l(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (l4 != 0) {
                Toolbar toolbar4 = this.a;
                Context context2 = toolbar4.getContext();
                toolbar4.n = l4;
                TextView textView2 = toolbar4.f92d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, l4);
                }
            }
            int l5 = q.l(R$styleable.ActionBar_popupTheme, 0);
            if (l5 != 0) {
                this.a.setPopupTheme(l5);
            }
        } else {
            if (this.a.getNavigationIcon() != null) {
                i2 = 15;
                this.p = this.a.getNavigationIcon();
            } else {
                i2 = 11;
            }
            this.b = i2;
        }
        q.b.recycle();
        if (i3 != this.o) {
            this.o = i3;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                int i4 = this.o;
                this.f844k = i4 != 0 ? q().getString(i4) : str;
                y();
            }
        }
        this.f844k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new z0(this));
    }

    public final void A() {
        Drawable drawable;
        int i2 = this.b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f839f) == null) {
            drawable = this.f838e;
        }
        this.a.setLogo(drawable);
    }

    @Override // e.b.f.d0
    public void a(Menu menu, m.a aVar) {
        i iVar;
        if (this.n == null) {
            c cVar = new c(this.a.getContext());
            this.n = cVar;
            Objects.requireNonNull(cVar);
        }
        c cVar2 = this.n;
        cVar2.f756f = aVar;
        Toolbar toolbar = this.a;
        g gVar = (g) menu;
        if (gVar != null || toolbar.b != null) {
            toolbar.f();
            g gVar2 = toolbar.b.q;
            if (gVar2 != gVar) {
                if (gVar2 != null) {
                    gVar2.u(toolbar.K);
                    gVar2.u(toolbar.L);
                }
                if (toolbar.L == null) {
                    toolbar.L = new Toolbar.d();
                }
                cVar2.r = true;
                if (gVar != null) {
                    gVar.b(cVar2, toolbar.f99k);
                    gVar.b(toolbar.L, toolbar.f99k);
                } else {
                    cVar2.e(toolbar.f99k, null);
                    Toolbar.d dVar = toolbar.L;
                    g gVar3 = dVar.b;
                    if (!(gVar3 == null || (iVar = dVar.c) == null)) {
                        gVar3.d(iVar);
                    }
                    dVar.b = null;
                    cVar2.j(true);
                    toolbar.L.j(true);
                }
                toolbar.b.setPopupTheme(toolbar.f100l);
                toolbar.b.setPresenter(cVar2);
                toolbar.K = cVar2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0021 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // e.b.f.d0
    public boolean b() {
        boolean z;
        ActionMenuView actionMenuView = this.a.b;
        if (actionMenuView == null) {
            return false;
        }
        c cVar = actionMenuView.u;
        if (cVar != null) {
            if (cVar.w != null || cVar.m()) {
                z = true;
                if (!z) {
                    return true;
                }
                return false;
            }
        }
        z = false;
        if (!z) {
        }
    }

    @Override // e.b.f.d0
    public boolean c() {
        return this.a.p();
    }

    @Override // e.b.f.d0
    public void collapseActionView() {
        Toolbar.d dVar = this.a.L;
        i iVar = dVar == null ? null : dVar.c;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    @Override // e.b.f.d0
    public boolean d() {
        ActionMenuView actionMenuView = this.a.b;
        if (actionMenuView == null) {
            return false;
        }
        c cVar = actionMenuView.u;
        if (cVar != null && cVar.k()) {
            return true;
        }
        return false;
    }

    @Override // e.b.f.d0
    public boolean e() {
        return this.a.v();
    }

    @Override // e.b.f.d0
    public void f() {
        this.m = true;
    }

    @Override // e.b.f.d0
    public boolean g() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.b) != null && actionMenuView.t;
    }

    @Override // e.b.f.d0
    public CharSequence getTitle() {
        return this.a.getTitle();
    }

    @Override // e.b.f.d0
    public void h() {
        c cVar;
        ActionMenuView actionMenuView = this.a.b;
        if (actionMenuView != null && (cVar = actionMenuView.u) != null) {
            cVar.a();
        }
    }

    @Override // e.b.f.d0
    public void i(m.a aVar, g.a aVar2) {
        Toolbar toolbar = this.a;
        toolbar.M = aVar;
        toolbar.N = aVar2;
        ActionMenuView actionMenuView = toolbar.b;
        if (actionMenuView != null) {
            actionMenuView.v = aVar;
            actionMenuView.w = aVar2;
        }
    }

    @Override // e.b.f.d0
    public int j() {
        return this.b;
    }

    @Override // e.b.f.d0
    public void k(int i2) {
        this.a.setVisibility(i2);
    }

    @Override // e.b.f.d0
    public Menu l() {
        return this.a.getMenu();
    }

    @Override // e.b.f.d0
    public void m(int i2) {
        this.f839f = i2 != 0 ? e.b.b.a.a.b(q(), i2) : null;
        A();
    }

    @Override // e.b.f.d0
    public void n(q0 q0Var) {
        Toolbar toolbar;
        View view = this.c;
        if (view != null && view.getParent() == (toolbar = this.a)) {
            toolbar.removeView(this.c);
        }
        this.c = null;
    }

    @Override // e.b.f.d0
    public ViewGroup o() {
        return this.a;
    }

    @Override // e.b.f.d0
    public void p(boolean z) {
    }

    @Override // e.b.f.d0
    public Context q() {
        return this.a.getContext();
    }

    @Override // e.b.f.d0
    public int r() {
        return 0;
    }

    @Override // e.b.f.d0
    public s s(int i2, long j2) {
        s b2 = e.i.i.m.b(this.a);
        b2.a(i2 == 0 ? 1.0f : 0.0f);
        b2.c(j2);
        a aVar = new a(i2);
        View view = b2.a.get();
        if (view != null) {
            b2.e(view, aVar);
        }
        return b2;
    }

    @Override // e.b.f.d0
    public void setIcon(int i2) {
        this.f838e = i2 != 0 ? e.b.b.a.a.b(q(), i2) : null;
        A();
    }

    @Override // e.b.f.d0
    public void setIcon(Drawable drawable) {
        this.f838e = drawable;
        A();
    }

    @Override // e.b.f.d0
    public void setTitle(CharSequence charSequence) {
        this.f841h = true;
        this.f842i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    @Override // e.b.f.d0
    public void setWindowCallback(Window.Callback callback) {
        this.f845l = callback;
    }

    @Override // e.b.f.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f841h) {
            this.f842i = charSequence;
            if ((this.b & 8) != 0) {
                this.a.setTitle(charSequence);
            }
        }
    }

    @Override // e.b.f.d0
    public void t() {
    }

    @Override // e.b.f.d0
    public boolean u() {
        Toolbar.d dVar = this.a.L;
        return (dVar == null || dVar.c == null) ? false : true;
    }

    @Override // e.b.f.d0
    public void v() {
    }

    @Override // e.b.f.d0
    public void w(boolean z) {
        this.a.setCollapsible(z);
    }

    @Override // e.b.f.d0
    public void x(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.b ^ i2;
        this.b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    y();
                }
                z();
            }
            if ((i3 & 3) != 0) {
                A();
            }
            if ((i3 & 8) != 0) {
                if ((i2 & 8) != 0) {
                    this.a.setTitle(this.f842i);
                    toolbar = this.a;
                    charSequence = this.f843j;
                } else {
                    charSequence = null;
                    this.a.setTitle((CharSequence) null);
                    toolbar = this.a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && (view = this.f837d) != null) {
                if ((i2 & 16) != 0) {
                    this.a.addView(view);
                } else {
                    this.a.removeView(view);
                }
            }
        }
    }

    public final void y() {
        if ((this.b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f844k)) {
            this.a.setNavigationContentDescription(this.o);
        } else {
            this.a.setNavigationContentDescription(this.f844k);
        }
    }

    public final void z() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.b & 4) != 0) {
            toolbar = this.a;
            drawable = this.f840g;
            if (drawable == null) {
                drawable = this.p;
            }
        } else {
            toolbar = this.a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }
}
