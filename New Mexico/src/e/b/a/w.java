package e.b.a;

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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import e.b.a.a;
import e.b.e.a;
import e.b.e.f;
import e.b.e.g;
import e.b.e.i.g;
import e.b.f.h0;
import e.j.j.a0;
import e.j.j.v;
import e.j.j.x;
import e.j.j.y;
import e.j.j.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class w extends a implements ActionBarOverlayLayout.d {
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;

    /* renamed from: d */
    public ActionBarContainer f761d;

    /* renamed from: e */
    public h0 f762e;

    /* renamed from: f */
    public ActionBarContextView f763f;

    /* renamed from: g */
    public View f764g;

    /* renamed from: h */
    public boolean f765h;

    /* renamed from: i */
    public d f766i;

    /* renamed from: j */
    public e.b.e.a f767j;

    /* renamed from: k */
    public a.AbstractC0017a f768k;

    /* renamed from: l */
    public boolean f769l;
    public boolean n;
    public boolean q;
    public boolean r;
    public g t;
    public boolean u;
    public boolean v;
    public static final Interpolator z = new AccelerateInterpolator();
    public static final Interpolator A = new DecelerateInterpolator();
    public ArrayList<a.b> m = new ArrayList<>();
    public int o = 0;
    public boolean p = true;
    public boolean s = true;
    public final y w = new a();
    public final y x = new b();
    public final a0 y = new c();

    /* loaded from: classes.dex */
    public class a extends z {
        public a() {
            w.this = r1;
        }

        @Override // e.j.j.y
        public void a(View view) {
            View view2;
            w wVar = w.this;
            if (wVar.p && (view2 = wVar.f764g) != null) {
                view2.setTranslationY(0.0f);
                w.this.f761d.setTranslationY(0.0f);
            }
            w.this.f761d.setVisibility(8);
            w.this.f761d.setTransitioning(false);
            w wVar2 = w.this;
            wVar2.t = null;
            a.AbstractC0017a aVar = wVar2.f768k;
            if (aVar != null) {
                aVar.d(wVar2.f767j);
                wVar2.f767j = null;
                wVar2.f768k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = w.this.c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = v.a;
                v.h.c(actionBarOverlayLayout);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends z {
        public b() {
            w.this = r1;
        }

        @Override // e.j.j.y
        public void a(View view) {
            w wVar = w.this;
            wVar.t = null;
            wVar.f761d.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    public class c implements a0 {
        public c() {
            w.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class d extends e.b.e.a implements g.a {

        /* renamed from: d */
        public final Context f770d;

        /* renamed from: e */
        public final e.b.e.i.g f771e;

        /* renamed from: f */
        public a.AbstractC0017a f772f;

        /* renamed from: g */
        public WeakReference<View> f773g;

        public d(Context context, a.AbstractC0017a aVar) {
            w.this = r1;
            this.f770d = context;
            this.f772f = aVar;
            e.b.e.i.g gVar = new e.b.e.i.g(context);
            gVar.f860l = 1;
            this.f771e = gVar;
            gVar.f853e = this;
        }

        @Override // e.b.e.i.g.a
        public boolean a(e.b.e.i.g gVar, MenuItem menuItem) {
            a.AbstractC0017a aVar = this.f772f;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // e.b.e.i.g.a
        public void b(e.b.e.i.g gVar) {
            if (this.f772f != null) {
                i();
                e.b.f.c cVar = w.this.f763f.f895e;
                if (cVar != null) {
                    cVar.n();
                }
            }
        }

        @Override // e.b.e.a
        public void c() {
            w wVar = w.this;
            if (wVar.f766i == this) {
                if (!(!wVar.q)) {
                    wVar.f767j = this;
                    wVar.f768k = this.f772f;
                } else {
                    this.f772f.d(this);
                }
                this.f772f = null;
                w.this.s(false);
                ActionBarContextView actionBarContextView = w.this.f763f;
                if (actionBarContextView.f65l == null) {
                    actionBarContextView.h();
                }
                w.this.f762e.o().sendAccessibilityEvent(32);
                w wVar2 = w.this;
                wVar2.c.setHideOnContentScrollEnabled(wVar2.v);
                w.this.f766i = null;
            }
        }

        @Override // e.b.e.a
        public View d() {
            WeakReference<View> weakReference = this.f773g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // e.b.e.a
        public Menu e() {
            return this.f771e;
        }

        @Override // e.b.e.a
        public MenuInflater f() {
            return new f(this.f770d);
        }

        @Override // e.b.e.a
        public CharSequence g() {
            return w.this.f763f.getSubtitle();
        }

        @Override // e.b.e.a
        public CharSequence h() {
            return w.this.f763f.getTitle();
        }

        @Override // e.b.e.a
        public void i() {
            if (w.this.f766i == this) {
                this.f771e.z();
                try {
                    this.f772f.a(this, this.f771e);
                } finally {
                    this.f771e.y();
                }
            }
        }

        @Override // e.b.e.a
        public boolean j() {
            return w.this.f763f.t;
        }

        @Override // e.b.e.a
        public void k(View view) {
            w.this.f763f.setCustomView(view);
            this.f773g = new WeakReference<>(view);
        }

        @Override // e.b.e.a
        public void l(int i2) {
            w.this.f763f.setSubtitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void m(CharSequence charSequence) {
            w.this.f763f.setSubtitle(charSequence);
        }

        @Override // e.b.e.a
        public void n(int i2) {
            w.this.f763f.setTitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void o(CharSequence charSequence) {
            w.this.f763f.setTitle(charSequence);
        }

        @Override // e.b.e.a
        public void p(boolean z) {
            this.c = z;
            w.this.f763f.setTitleOptional(z);
        }
    }

    public w(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (!z2) {
            this.f764g = decorView.findViewById(16908290);
        }
    }

    public w(Dialog dialog) {
        new ArrayList();
        t(dialog.getWindow().getDecorView());
    }

    @Override // e.b.a.a
    public boolean b() {
        h0 h0Var = this.f762e;
        if (h0Var == null || !h0Var.u()) {
            return false;
        }
        this.f762e.collapseActionView();
        return true;
    }

    @Override // e.b.a.a
    public void c(boolean z2) {
        if (z2 != this.f769l) {
            this.f769l = z2;
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a(z2);
            }
        }
    }

    @Override // e.b.a.a
    public int d() {
        return this.f762e.j();
    }

    @Override // e.b.a.a
    public Context e() {
        if (this.b == null) {
            TypedValue typedValue = new TypedValue();
            this.a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.b = new ContextThemeWrapper(this.a, i2);
            } else {
                this.b = this.a;
            }
        }
        return this.b;
    }

    @Override // e.b.a.a
    public void g(Configuration configuration) {
        v(this.a.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
    }

    @Override // e.b.a.a
    public boolean i(int i2, KeyEvent keyEvent) {
        e.b.e.i.g gVar;
        d dVar = this.f766i;
        if (dVar == null || (gVar = dVar.f771e) == null) {
            return false;
        }
        boolean z2 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z2 = false;
        }
        gVar.setQwertyMode(z2);
        return gVar.performShortcut(i2, keyEvent, 0);
    }

    @Override // e.b.a.a
    public void l(boolean z2) {
        if (!this.f765h) {
            u(z2 ? 4 : 0, 4);
        }
    }

    @Override // e.b.a.a
    public void m(boolean z2) {
        u(z2 ? 4 : 0, 4);
    }

    @Override // e.b.a.a
    public void n(boolean z2) {
        u(z2 ? 8 : 0, 8);
    }

    @Override // e.b.a.a
    public void o(boolean z2) {
        e.b.e.g gVar;
        this.u = z2;
        if (!z2 && (gVar = this.t) != null) {
            gVar.a();
        }
    }

    @Override // e.b.a.a
    public void p(CharSequence charSequence) {
        this.f762e.setTitle(charSequence);
    }

    @Override // e.b.a.a
    public void q(CharSequence charSequence) {
        this.f762e.setWindowTitle(charSequence);
    }

    @Override // e.b.a.a
    public e.b.e.a r(a.AbstractC0017a aVar) {
        d dVar = this.f766i;
        if (dVar != null) {
            dVar.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f763f.h();
        d dVar2 = new d(this.f763f.getContext(), aVar);
        dVar2.f771e.z();
        try {
            if (!dVar2.f772f.c(dVar2, dVar2.f771e)) {
                return null;
            }
            this.f766i = dVar2;
            dVar2.i();
            this.f763f.f(dVar2);
            s(true);
            this.f763f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.f771e.y();
        }
    }

    public void s(boolean z2) {
        x xVar;
        x xVar2;
        if (z2) {
            if (!this.r) {
                this.r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                w(false);
            }
        } else if (this.r) {
            this.r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            w(false);
        }
        ActionBarContainer actionBarContainer = this.f761d;
        AtomicInteger atomicInteger = v.a;
        if (v.g.c(actionBarContainer)) {
            if (z2) {
                xVar = this.f762e.s(4, 100);
                xVar2 = this.f763f.e(0, 200);
            } else {
                xVar2 = this.f762e.s(0, 200);
                xVar = this.f763f.e(8, 100);
            }
            e.b.e.g gVar = new e.b.e.g();
            gVar.a.add(xVar);
            View view = xVar.a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = xVar2.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.a.add(xVar2);
            gVar.b();
        } else if (z2) {
            this.f762e.k(4);
            this.f763f.setVisibility(0);
        } else {
            this.f762e.k(0);
            this.f763f.setVisibility(8);
        }
    }

    public final void t(View view) {
        h0 h0Var;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R$id.action_bar);
        if (findViewById instanceof h0) {
            h0Var = (h0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            h0Var = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Can't make a decor toolbar out of ");
            h2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(h2.toString());
        }
        this.f762e = h0Var;
        this.f763f = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f761d = actionBarContainer;
        h0 h0Var2 = this.f762e;
        if (h0Var2 == null || this.f763f == null || actionBarContainer == null) {
            throw new IllegalStateException(w.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = h0Var2.q();
        boolean z2 = (this.f762e.j() & 4) != 0;
        if (z2) {
            this.f765h = true;
        }
        Context context = this.a;
        this.f762e.p((context.getApplicationInfo().targetSdkVersion < 14) || z2);
        v(context.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2.f71i) {
                this.v = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f761d;
            AtomicInteger atomicInteger = v.a;
            v.i.s(actionBarContainer2, (float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void u(int i2, int i3) {
        int j2 = this.f762e.j();
        if ((i3 & 4) != 0) {
            this.f765h = true;
        }
        this.f762e.x((i2 & i3) | ((~i3) & j2));
    }

    public final void v(boolean z2) {
        this.n = z2;
        if (!z2) {
            this.f762e.n(null);
            this.f761d.setTabContainer(null);
        } else {
            this.f761d.setTabContainer(null);
            this.f762e.n(null);
        }
        boolean z3 = true;
        boolean z4 = this.f762e.r() == 2;
        this.f762e.w(!this.n && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.c;
        if (this.n || !z4) {
            z3 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    public final void w(boolean z2) {
        View view;
        View view2;
        View view3;
        if (this.r || !this.q) {
            if (!this.s) {
                this.s = true;
                e.b.e.g gVar = this.t;
                if (gVar != null) {
                    gVar.a();
                }
                this.f761d.setVisibility(0);
                if (this.o != 0 || (!this.u && !z2)) {
                    this.f761d.setAlpha(1.0f);
                    this.f761d.setTranslationY(0.0f);
                    if (this.p && (view2 = this.f764g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.x.a(null);
                } else {
                    this.f761d.setTranslationY(0.0f);
                    float f2 = (float) (-this.f761d.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.f761d.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f761d.setTranslationY(f2);
                    e.b.e.g gVar2 = new e.b.e.g();
                    x b2 = v.b(this.f761d);
                    b2.g(0.0f);
                    b2.f(this.y);
                    if (!gVar2.f815e) {
                        gVar2.a.add(b2);
                    }
                    if (this.p && (view3 = this.f764g) != null) {
                        view3.setTranslationY(f2);
                        x b3 = v.b(this.f764g);
                        b3.g(0.0f);
                        if (!gVar2.f815e) {
                            gVar2.a.add(b3);
                        }
                    }
                    Interpolator interpolator = A;
                    boolean z3 = gVar2.f815e;
                    if (!z3) {
                        gVar2.c = interpolator;
                    }
                    if (!z3) {
                        gVar2.b = 250;
                    }
                    y yVar = this.x;
                    if (!z3) {
                        gVar2.f814d = yVar;
                    }
                    this.t = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    AtomicInteger atomicInteger = v.a;
                    v.h.c(actionBarOverlayLayout);
                }
            }
        } else if (this.s) {
            this.s = false;
            e.b.e.g gVar3 = this.t;
            if (gVar3 != null) {
                gVar3.a();
            }
            if (this.o != 0 || (!this.u && !z2)) {
                this.w.a(null);
                return;
            }
            this.f761d.setAlpha(1.0f);
            this.f761d.setTransitioning(true);
            e.b.e.g gVar4 = new e.b.e.g();
            float f3 = (float) (-this.f761d.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f761d.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            x b4 = v.b(this.f761d);
            b4.g(f3);
            b4.f(this.y);
            if (!gVar4.f815e) {
                gVar4.a.add(b4);
            }
            if (this.p && (view = this.f764g) != null) {
                x b5 = v.b(view);
                b5.g(f3);
                if (!gVar4.f815e) {
                    gVar4.a.add(b5);
                }
            }
            Interpolator interpolator2 = z;
            boolean z4 = gVar4.f815e;
            if (!z4) {
                gVar4.c = interpolator2;
            }
            if (!z4) {
                gVar4.b = 250;
            }
            y yVar2 = this.w;
            if (!z4) {
                gVar4.f814d = yVar2;
            }
            this.t = gVar4;
            gVar4.b();
        }
    }
}
