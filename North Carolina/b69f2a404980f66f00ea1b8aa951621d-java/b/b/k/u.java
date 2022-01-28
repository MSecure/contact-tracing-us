package b.b.k;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import b.b.j;
import b.b.k.a;
import b.b.p.a;
import b.b.p.f;
import b.b.p.g;
import b.b.p.i.g;
import b.b.q.d0;
import b.i.l.m;
import b.i.l.r;
import b.i.l.s;
import b.i.l.t;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class u extends a implements ActionBarOverlayLayout.d {
    public static final Interpolator A = new AccelerateInterpolator();
    public static final Interpolator B = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    public Context f435a;

    /* renamed from: b  reason: collision with root package name */
    public Context f436b;

    /* renamed from: c  reason: collision with root package name */
    public ActionBarOverlayLayout f437c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f438d;

    /* renamed from: e  reason: collision with root package name */
    public d0 f439e;
    public ActionBarContextView f;
    public View g;
    public boolean h;
    public d i;
    public b.b.p.a j;
    public a.AbstractC0009a k;
    public boolean l;
    public ArrayList<a.b> m = new ArrayList<>();
    public boolean n;
    public int o = 0;
    public boolean p = true;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t = true;
    public g u;
    public boolean v;
    public boolean w;
    public final s x = new a();
    public final s y = new b();
    public final b.i.l.u z = new c();

    public class a extends t {
        public a() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            View view2;
            u uVar = u.this;
            if (uVar.p && (view2 = uVar.g) != null) {
                view2.setTranslationY(0.0f);
                u.this.f438d.setTranslationY(0.0f);
            }
            u.this.f438d.setVisibility(8);
            u.this.f438d.setTransitioning(false);
            u uVar2 = u.this;
            uVar2.u = null;
            a.AbstractC0009a aVar = uVar2.k;
            if (aVar != null) {
                aVar.d(uVar2.j);
                uVar2.j = null;
                uVar2.k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = u.this.f437c;
            if (actionBarOverlayLayout != null) {
                m.R(actionBarOverlayLayout);
            }
        }
    }

    public class b extends t {
        public b() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            u uVar = u.this;
            uVar.u = null;
            uVar.f438d.requestLayout();
        }
    }

    public class c implements b.i.l.u {
        public c() {
        }
    }

    public class d extends b.b.p.a implements g.a {

        /* renamed from: d  reason: collision with root package name */
        public final Context f443d;

        /* renamed from: e  reason: collision with root package name */
        public final b.b.p.i.g f444e;
        public a.AbstractC0009a f;
        public WeakReference<View> g;

        public d(Context context, a.AbstractC0009a aVar) {
            this.f443d = context;
            this.f = aVar;
            b.b.p.i.g gVar = new b.b.p.i.g(context);
            gVar.l = 1;
            this.f444e = gVar;
            gVar.f544e = this;
        }

        @Override // b.b.p.i.g.a
        public boolean a(b.b.p.i.g gVar, MenuItem menuItem) {
            a.AbstractC0009a aVar = this.f;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // b.b.p.i.g.a
        public void b(b.b.p.i.g gVar) {
            if (this.f != null) {
                i();
                b.b.q.c cVar = u.this.f.f581e;
                if (cVar != null) {
                    cVar.n();
                }
            }
        }

        @Override // b.b.p.a
        public void c() {
            u uVar = u.this;
            if (uVar.i == this) {
                boolean z = uVar.q;
                boolean z2 = uVar.r;
                boolean z3 = true;
                if (z || z2) {
                    z3 = false;
                }
                if (!z3) {
                    u uVar2 = u.this;
                    uVar2.j = this;
                    uVar2.k = this.f;
                } else {
                    this.f.d(this);
                }
                this.f = null;
                u.this.p(false);
                ActionBarContextView actionBarContextView = u.this.f;
                if (actionBarContextView.l == null) {
                    actionBarContextView.h();
                }
                u.this.f439e.o().sendAccessibilityEvent(32);
                u uVar3 = u.this;
                uVar3.f437c.setHideOnContentScrollEnabled(uVar3.w);
                u.this.i = null;
            }
        }

        @Override // b.b.p.a
        public View d() {
            WeakReference<View> weakReference = this.g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // b.b.p.a
        public Menu e() {
            return this.f444e;
        }

        @Override // b.b.p.a
        public MenuInflater f() {
            return new f(this.f443d);
        }

        @Override // b.b.p.a
        public CharSequence g() {
            return u.this.f.getSubtitle();
        }

        @Override // b.b.p.a
        public CharSequence h() {
            return u.this.f.getTitle();
        }

        @Override // b.b.p.a
        public void i() {
            if (u.this.i == this) {
                this.f444e.z();
                try {
                    this.f.a(this, this.f444e);
                } finally {
                    this.f444e.y();
                }
            }
        }

        @Override // b.b.p.a
        public boolean j() {
            return u.this.f.s;
        }

        @Override // b.b.p.a
        public void k(View view) {
            u.this.f.setCustomView(view);
            this.g = new WeakReference<>(view);
        }

        @Override // b.b.p.a
        public void l(int i) {
            u.this.f.setSubtitle(u.this.f435a.getResources().getString(i));
        }

        @Override // b.b.p.a
        public void m(CharSequence charSequence) {
            u.this.f.setSubtitle(charSequence);
        }

        @Override // b.b.p.a
        public void n(int i) {
            u.this.f.setTitle(u.this.f435a.getResources().getString(i));
        }

        @Override // b.b.p.a
        public void o(CharSequence charSequence) {
            u.this.f.setTitle(charSequence);
        }

        @Override // b.b.p.a
        public void p(boolean z) {
            this.f469c = z;
            u.this.f.setTitleOptional(z);
        }
    }

    public u(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        q(decorView);
        if (!z2) {
            this.g = decorView.findViewById(16908290);
        }
    }

    public u(Dialog dialog) {
        new ArrayList();
        q(dialog.getWindow().getDecorView());
    }

    @Override // b.b.k.a
    public boolean b() {
        d0 d0Var = this.f439e;
        if (d0Var == null || !d0Var.u()) {
            return false;
        }
        this.f439e.collapseActionView();
        return true;
    }

    @Override // b.b.k.a
    public void c(boolean z2) {
        if (z2 != this.l) {
            this.l = z2;
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a(z2);
            }
        }
    }

    @Override // b.b.k.a
    public int d() {
        return this.f439e.j();
    }

    @Override // b.b.k.a
    public Context e() {
        if (this.f436b == null) {
            TypedValue typedValue = new TypedValue();
            this.f435a.getTheme().resolveAttribute(b.b.a.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f436b = new ContextThemeWrapper(this.f435a, i2);
            } else {
                this.f436b = this.f435a;
            }
        }
        return this.f436b;
    }

    @Override // b.b.k.a
    public void g(Configuration configuration) {
        r(this.f435a.getResources().getBoolean(b.b.b.abc_action_bar_embed_tabs));
    }

    @Override // b.b.k.a
    public boolean i(int i2, KeyEvent keyEvent) {
        b.b.p.i.g gVar;
        d dVar = this.i;
        if (dVar == null || (gVar = dVar.f444e) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        gVar.setQwertyMode(z2);
        return gVar.performShortcut(i2, keyEvent, 0);
    }

    @Override // b.b.k.a
    public void l(boolean z2) {
        if (!this.h) {
            int i2 = z2 ? 4 : 0;
            int j2 = this.f439e.j();
            this.h = true;
            this.f439e.x((i2 & 4) | (j2 & -5));
        }
    }

    @Override // b.b.k.a
    public void m(boolean z2) {
        b.b.p.g gVar;
        this.v = z2;
        if (!z2 && (gVar = this.u) != null) {
            gVar.a();
        }
    }

    @Override // b.b.k.a
    public void n(CharSequence charSequence) {
        this.f439e.setWindowTitle(charSequence);
    }

    @Override // b.b.k.a
    public b.b.p.a o(a.AbstractC0009a aVar) {
        d dVar = this.i;
        if (dVar != null) {
            dVar.c();
        }
        this.f437c.setHideOnContentScrollEnabled(false);
        this.f.h();
        d dVar2 = new d(this.f.getContext(), aVar);
        dVar2.f444e.z();
        try {
            if (!dVar2.f.c(dVar2, dVar2.f444e)) {
                return null;
            }
            this.i = dVar2;
            dVar2.i();
            this.f.f(dVar2);
            p(true);
            this.f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.f444e.y();
        }
    }

    public void p(boolean z2) {
        r rVar;
        r rVar2;
        if (z2) {
            if (!this.s) {
                this.s = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                s(false);
            }
        } else if (this.s) {
            this.s = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f437c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            s(false);
        }
        if (m.B(this.f438d)) {
            if (z2) {
                rVar = this.f439e.s(4, 100);
                rVar2 = this.f.e(0, 200);
            } else {
                rVar2 = this.f439e.s(0, 200);
                rVar = this.f.e(8, 100);
            }
            b.b.p.g gVar = new b.b.p.g();
            gVar.f496a.add(rVar);
            View view = rVar.f1171a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = rVar2.f1171a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.f496a.add(rVar2);
            gVar.b();
        } else if (z2) {
            this.f439e.k(4);
            this.f.setVisibility(0);
        } else {
            this.f439e.k(0);
            this.f.setVisibility(8);
        }
    }

    public final void q(View view) {
        d0 d0Var;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(b.b.f.decor_content_parent);
        this.f437c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(b.b.f.action_bar);
        if (findViewById instanceof d0) {
            d0Var = (d0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            d0Var = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder g2 = c.a.a.a.a.g("Can't make a decor toolbar out of ");
            g2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(g2.toString());
        }
        this.f439e = d0Var;
        this.f = (ActionBarContextView) view.findViewById(b.b.f.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(b.b.f.action_bar_container);
        this.f438d = actionBarContainer;
        d0 d0Var2 = this.f439e;
        if (d0Var2 == null || this.f == null || actionBarContainer == null) {
            throw new IllegalStateException(u.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f435a = d0Var2.q();
        boolean z2 = (this.f439e.j() & 4) != 0;
        if (z2) {
            this.h = true;
        }
        Context context = this.f435a;
        this.f439e.p((context.getApplicationInfo().targetSdkVersion < 14) || z2);
        r(context.getResources().getBoolean(b.b.b.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.f435a.obtainStyledAttributes(null, j.ActionBar, b.b.a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(j.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f437c;
            if (actionBarOverlayLayout2.i) {
                this.w = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m.Y(this.f438d, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void r(boolean z2) {
        this.n = z2;
        if (!z2) {
            this.f439e.n(null);
            this.f438d.setTabContainer(null);
        } else {
            this.f438d.setTabContainer(null);
            this.f439e.n(null);
        }
        boolean z3 = true;
        boolean z4 = this.f439e.r() == 2;
        this.f439e.w(!this.n && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
        if (this.n || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    public final void s(boolean z2) {
        View view;
        View view2;
        View view3;
        if (this.s || !this.r) {
            if (!this.t) {
                this.t = true;
                b.b.p.g gVar = this.u;
                if (gVar != null) {
                    gVar.a();
                }
                this.f438d.setVisibility(0);
                if (this.o != 0 || (!this.v && !z2)) {
                    this.f438d.setAlpha(1.0f);
                    this.f438d.setTranslationY(0.0f);
                    if (this.p && (view2 = this.g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.y.a(null);
                } else {
                    this.f438d.setTranslationY(0.0f);
                    float f2 = (float) (-this.f438d.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.f438d.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f438d.setTranslationY(f2);
                    b.b.p.g gVar2 = new b.b.p.g();
                    r a2 = m.a(this.f438d);
                    a2.g(0.0f);
                    a2.f(this.z);
                    if (!gVar2.f500e) {
                        gVar2.f496a.add(a2);
                    }
                    if (this.p && (view3 = this.g) != null) {
                        view3.setTranslationY(f2);
                        r a3 = m.a(this.g);
                        a3.g(0.0f);
                        if (!gVar2.f500e) {
                            gVar2.f496a.add(a3);
                        }
                    }
                    Interpolator interpolator = B;
                    if (!gVar2.f500e) {
                        gVar2.f498c = interpolator;
                    }
                    if (!gVar2.f500e) {
                        gVar2.f497b = 250;
                    }
                    s sVar = this.y;
                    if (!gVar2.f500e) {
                        gVar2.f499d = sVar;
                    }
                    this.u = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.f437c;
                if (actionBarOverlayLayout != null) {
                    m.R(actionBarOverlayLayout);
                }
            }
        } else if (this.t) {
            this.t = false;
            b.b.p.g gVar3 = this.u;
            if (gVar3 != null) {
                gVar3.a();
            }
            if (this.o != 0 || (!this.v && !z2)) {
                this.x.a(null);
                return;
            }
            this.f438d.setAlpha(1.0f);
            this.f438d.setTransitioning(true);
            b.b.p.g gVar4 = new b.b.p.g();
            float f3 = (float) (-this.f438d.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f438d.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            r a4 = m.a(this.f438d);
            a4.g(f3);
            a4.f(this.z);
            if (!gVar4.f500e) {
                gVar4.f496a.add(a4);
            }
            if (this.p && (view = this.g) != null) {
                r a5 = m.a(view);
                a5.g(f3);
                if (!gVar4.f500e) {
                    gVar4.f496a.add(a5);
                }
            }
            Interpolator interpolator2 = A;
            if (!gVar4.f500e) {
                gVar4.f498c = interpolator2;
            }
            if (!gVar4.f500e) {
                gVar4.f497b = 250;
            }
            s sVar2 = this.x;
            if (!gVar4.f500e) {
                gVar4.f499d = sVar2;
            }
            this.u = gVar4;
            gVar4.b();
        }
    }
}
