package b.b.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import b.b.h;
import b.b.j;
import b.b.p.i.g;
import b.b.p.i.i;
import b.b.p.i.m;
import b.i.l.r;
import b.i.l.t;

public class a1 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f590a;

    /* renamed from: b  reason: collision with root package name */
    public int f591b;

    /* renamed from: c  reason: collision with root package name */
    public View f592c;

    /* renamed from: d  reason: collision with root package name */
    public View f593d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f594e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public c n;
    public int o = 0;
    public int p = 0;
    public Drawable q;

    public class a extends t {

        /* renamed from: a  reason: collision with root package name */
        public boolean f595a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f596b;

        public a(int i) {
            this.f596b = i;
        }

        @Override // b.i.l.s
        public void a(View view) {
            if (!this.f595a) {
                a1.this.f590a.setVisibility(this.f596b);
            }
        }

        @Override // b.i.l.t, b.i.l.s
        public void b(View view) {
            a1.this.f590a.setVisibility(0);
        }

        @Override // b.i.l.t, b.i.l.s
        public void c(View view) {
            this.f595a = true;
        }
    }

    public a1(Toolbar toolbar, boolean z) {
        int i2;
        Drawable drawable;
        int i3 = h.abc_action_bar_up_description;
        this.f590a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        String str = null;
        y0 q2 = y0.q(toolbar.getContext(), null, j.ActionBar, b.b.a.actionBarStyle, 0);
        this.q = q2.g(j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence n2 = q2.n(j.ActionBar_title);
            if (!TextUtils.isEmpty(n2)) {
                this.h = true;
                this.i = n2;
                if ((this.f591b & 8) != 0) {
                    this.f590a.setTitle(n2);
                }
            }
            CharSequence n3 = q2.n(j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(n3)) {
                this.j = n3;
                if ((this.f591b & 8) != 0) {
                    this.f590a.setSubtitle(n3);
                }
            }
            Drawable g2 = q2.g(j.ActionBar_logo);
            if (g2 != null) {
                this.f = g2;
                A();
            }
            Drawable g3 = q2.g(j.ActionBar_icon);
            if (g3 != null) {
                this.f594e = g3;
                A();
            }
            if (this.g == null && (drawable = this.q) != null) {
                this.g = drawable;
                z();
            }
            x(q2.j(j.ActionBar_displayOptions, 0));
            int l2 = q2.l(j.ActionBar_customNavigationLayout, 0);
            if (l2 != 0) {
                View inflate = LayoutInflater.from(this.f590a.getContext()).inflate(l2, (ViewGroup) this.f590a, false);
                View view = this.f593d;
                if (!(view == null || (this.f591b & 16) == 0)) {
                    this.f590a.removeView(view);
                }
                this.f593d = inflate;
                if (!(inflate == null || (this.f591b & 16) == 0)) {
                    this.f590a.addView(inflate);
                }
                x(this.f591b | 16);
            }
            int k2 = q2.k(j.ActionBar_height, 0);
            if (k2 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f590a.getLayoutParams();
                layoutParams.height = k2;
                this.f590a.setLayoutParams(layoutParams);
            }
            int e2 = q2.e(j.ActionBar_contentInsetStart, -1);
            int e3 = q2.e(j.ActionBar_contentInsetEnd, -1);
            if (e2 >= 0 || e3 >= 0) {
                Toolbar toolbar2 = this.f590a;
                int max = Math.max(e2, 0);
                int max2 = Math.max(e3, 0);
                toolbar2.d();
                toolbar2.u.a(max, max2);
            }
            int l3 = q2.l(j.ActionBar_titleTextStyle, 0);
            if (l3 != 0) {
                Toolbar toolbar3 = this.f590a;
                Context context = toolbar3.getContext();
                toolbar3.m = l3;
                TextView textView = toolbar3.f87c;
                if (textView != null) {
                    textView.setTextAppearance(context, l3);
                }
            }
            int l4 = q2.l(j.ActionBar_subtitleTextStyle, 0);
            if (l4 != 0) {
                Toolbar toolbar4 = this.f590a;
                Context context2 = toolbar4.getContext();
                toolbar4.n = l4;
                TextView textView2 = toolbar4.f88d;
                if (textView2 != null) {
                    textView2.setTextAppearance(context2, l4);
                }
            }
            int l5 = q2.l(j.ActionBar_popupTheme, 0);
            if (l5 != 0) {
                this.f590a.setPopupTheme(l5);
            }
        } else {
            if (this.f590a.getNavigationIcon() != null) {
                i2 = 15;
                this.q = this.f590a.getNavigationIcon();
            } else {
                i2 = 11;
            }
            this.f591b = i2;
        }
        q2.f759b.recycle();
        if (i3 != this.p) {
            this.p = i3;
            if (TextUtils.isEmpty(this.f590a.getNavigationContentDescription())) {
                int i4 = this.p;
                this.k = i4 != 0 ? q().getString(i4) : str;
                y();
            }
        }
        this.k = this.f590a.getNavigationContentDescription();
        this.f590a.setNavigationOnClickListener(new z0(this));
    }

    public final void A() {
        Drawable drawable;
        int i2 = this.f591b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f) == null) {
            drawable = this.f594e;
        }
        this.f590a.setLogo(drawable);
    }

    @Override // b.b.q.d0
    public void a(Menu menu, m.a aVar) {
        i iVar;
        if (this.n == null) {
            c cVar = new c(this.f590a.getContext());
            this.n = cVar;
            if (cVar == null) {
                throw null;
            }
        }
        c cVar2 = this.n;
        cVar2.f = aVar;
        Toolbar toolbar = this.f590a;
        g gVar = (g) menu;
        if (gVar != null || toolbar.f86b != null) {
            toolbar.f();
            g gVar2 = toolbar.f86b.q;
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
                    gVar.b(cVar2, toolbar.k);
                    gVar.b(toolbar.L, toolbar.k);
                } else {
                    cVar2.e(toolbar.k, null);
                    Toolbar.d dVar = toolbar.L;
                    g gVar3 = dVar.f93b;
                    if (!(gVar3 == null || (iVar = dVar.f94c) == null)) {
                        gVar3.d(iVar);
                    }
                    dVar.f93b = null;
                    cVar2.j(true);
                    toolbar.L.j(true);
                }
                toolbar.f86b.setPopupTheme(toolbar.l);
                toolbar.f86b.setPresenter(cVar2);
                toolbar.K = cVar2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // b.b.q.d0
    public boolean b() {
        boolean z;
        ActionMenuView actionMenuView = this.f590a.f86b;
        if (actionMenuView != null) {
            c cVar = actionMenuView.u;
            if (cVar != null) {
                if (cVar.w != null || cVar.m()) {
                    z = true;
                    if (z) {
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    @Override // b.b.q.d0
    public boolean c() {
        return this.f590a.o();
    }

    @Override // b.b.q.d0
    public void collapseActionView() {
        Toolbar.d dVar = this.f590a.L;
        i iVar = dVar == null ? null : dVar.f94c;
        if (iVar != null) {
            iVar.collapseActionView();
        }
    }

    @Override // b.b.q.d0
    public boolean d() {
        ActionMenuView actionMenuView = this.f590a.f86b;
        if (actionMenuView != null) {
            c cVar = actionMenuView.u;
            if (cVar != null && cVar.k()) {
                return true;
            }
        }
        return false;
    }

    @Override // b.b.q.d0
    public boolean e() {
        return this.f590a.u();
    }

    @Override // b.b.q.d0
    public void f() {
        this.m = true;
    }

    @Override // b.b.q.d0
    public boolean g() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f590a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f86b) != null && actionMenuView.t;
    }

    @Override // b.b.q.d0
    public CharSequence getTitle() {
        return this.f590a.getTitle();
    }

    @Override // b.b.q.d0
    public void h() {
        c cVar;
        ActionMenuView actionMenuView = this.f590a.f86b;
        if (actionMenuView != null && (cVar = actionMenuView.u) != null) {
            cVar.c();
        }
    }

    @Override // b.b.q.d0
    public void i(m.a aVar, g.a aVar2) {
        Toolbar toolbar = this.f590a;
        toolbar.M = aVar;
        toolbar.N = aVar2;
        ActionMenuView actionMenuView = toolbar.f86b;
        if (actionMenuView != null) {
            actionMenuView.v = aVar;
            actionMenuView.w = aVar2;
        }
    }

    @Override // b.b.q.d0
    public int j() {
        return this.f591b;
    }

    @Override // b.b.q.d0
    public void k(int i2) {
        this.f590a.setVisibility(i2);
    }

    @Override // b.b.q.d0
    public Menu l() {
        return this.f590a.getMenu();
    }

    @Override // b.b.q.d0
    public void m(int i2) {
        this.f = i2 != 0 ? b.b.l.a.a.b(q(), i2) : null;
        A();
    }

    @Override // b.b.q.d0
    public void n(q0 q0Var) {
        Toolbar toolbar;
        View view = this.f592c;
        if (view != null && view.getParent() == (toolbar = this.f590a)) {
            toolbar.removeView(this.f592c);
        }
        this.f592c = null;
    }

    @Override // b.b.q.d0
    public ViewGroup o() {
        return this.f590a;
    }

    @Override // b.b.q.d0
    public void p(boolean z) {
    }

    @Override // b.b.q.d0
    public Context q() {
        return this.f590a.getContext();
    }

    @Override // b.b.q.d0
    public int r() {
        return this.o;
    }

    @Override // b.b.q.d0
    public r s(int i2, long j2) {
        r a2 = b.i.l.m.a(this.f590a);
        a2.a(i2 == 0 ? 1.0f : 0.0f);
        a2.c(j2);
        a aVar = new a(i2);
        View view = a2.f1171a.get();
        if (view != null) {
            a2.e(view, aVar);
        }
        return a2;
    }

    @Override // b.b.q.d0
    public void setIcon(int i2) {
        this.f594e = i2 != 0 ? b.b.l.a.a.b(q(), i2) : null;
        A();
    }

    @Override // b.b.q.d0
    public void setIcon(Drawable drawable) {
        this.f594e = drawable;
        A();
    }

    @Override // b.b.q.d0
    public void setWindowCallback(Window.Callback callback) {
        this.l = callback;
    }

    @Override // b.b.q.d0
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.h) {
            this.i = charSequence;
            if ((this.f591b & 8) != 0) {
                this.f590a.setTitle(charSequence);
            }
        }
    }

    @Override // b.b.q.d0
    public void t() {
    }

    @Override // b.b.q.d0
    public boolean u() {
        Toolbar.d dVar = this.f590a.L;
        return (dVar == null || dVar.f94c == null) ? false : true;
    }

    @Override // b.b.q.d0
    public void v() {
    }

    @Override // b.b.q.d0
    public void w(boolean z) {
        this.f590a.setCollapsible(z);
    }

    @Override // b.b.q.d0
    public void x(int i2) {
        View view;
        CharSequence charSequence;
        Toolbar toolbar;
        int i3 = this.f591b ^ i2;
        this.f591b = i2;
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
                    this.f590a.setTitle(this.i);
                    toolbar = this.f590a;
                    charSequence = this.j;
                } else {
                    charSequence = null;
                    this.f590a.setTitle((CharSequence) null);
                    toolbar = this.f590a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i3 & 16) != 0 && (view = this.f593d) != null) {
                if ((i2 & 16) != 0) {
                    this.f590a.addView(view);
                } else {
                    this.f590a.removeView(view);
                }
            }
        }
    }

    public final void y() {
        if ((this.f591b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.k)) {
            this.f590a.setNavigationContentDescription(this.p);
        } else {
            this.f590a.setNavigationContentDescription(this.k);
        }
    }

    public final void z() {
        Drawable drawable;
        Toolbar toolbar;
        if ((this.f591b & 4) != 0) {
            toolbar = this.f590a;
            drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
        } else {
            toolbar = this.f590a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }
}
