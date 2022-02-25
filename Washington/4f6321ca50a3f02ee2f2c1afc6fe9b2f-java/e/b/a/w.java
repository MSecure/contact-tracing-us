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
import e.b.f.d0;
import e.i.i.l;
import e.i.i.r;
import e.i.i.s;
import e.i.i.t;
import e.i.i.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class w extends a implements ActionBarOverlayLayout.d {
    public static final Interpolator A = new DecelerateInterpolator();
    public static final Interpolator z = new AccelerateInterpolator();
    public Context a;
    public Context b;
    public ActionBarOverlayLayout c;

    /* renamed from: d  reason: collision with root package name */
    public ActionBarContainer f695d;

    /* renamed from: e  reason: collision with root package name */
    public d0 f696e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f697f;

    /* renamed from: g  reason: collision with root package name */
    public View f698g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f699h;

    /* renamed from: i  reason: collision with root package name */
    public d f700i;

    /* renamed from: j  reason: collision with root package name */
    public e.b.e.a f701j;

    /* renamed from: k  reason: collision with root package name */
    public a.AbstractC0014a f702k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f703l;
    public ArrayList<a.b> m = new ArrayList<>();
    public boolean n;
    public int o = 0;
    public boolean p = true;
    public boolean q;
    public boolean r;
    public boolean s = true;
    public g t;
    public boolean u;
    public boolean v;
    public final s w = new a();
    public final s x = new b();
    public final u y = new c();

    public class a extends t {
        public a() {
        }

        @Override // e.i.i.s
        public void a(View view) {
            View view2;
            w wVar = w.this;
            if (wVar.p && (view2 = wVar.f698g) != null) {
                view2.setTranslationY(0.0f);
                w.this.f695d.setTranslationY(0.0f);
            }
            w.this.f695d.setVisibility(8);
            w.this.f695d.setTransitioning(false);
            w wVar2 = w.this;
            wVar2.t = null;
            a.AbstractC0014a aVar = wVar2.f702k;
            if (aVar != null) {
                aVar.d(wVar2.f701j);
                wVar2.f701j = null;
                wVar2.f702k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = w.this.c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = l.a;
                actionBarOverlayLayout.requestApplyInsets();
            }
        }
    }

    public class b extends t {
        public b() {
        }

        @Override // e.i.i.s
        public void a(View view) {
            w wVar = w.this;
            wVar.t = null;
            wVar.f695d.requestLayout();
        }
    }

    public class c implements u {
        public c() {
        }
    }

    public class d extends e.b.e.a implements g.a {

        /* renamed from: d  reason: collision with root package name */
        public final Context f704d;

        /* renamed from: e  reason: collision with root package name */
        public final e.b.e.i.g f705e;

        /* renamed from: f  reason: collision with root package name */
        public a.AbstractC0014a f706f;

        /* renamed from: g  reason: collision with root package name */
        public WeakReference<View> f707g;

        public d(Context context, a.AbstractC0014a aVar) {
            this.f704d = context;
            this.f706f = aVar;
            e.b.e.i.g gVar = new e.b.e.i.g(context);
            gVar.f794l = 1;
            this.f705e = gVar;
            gVar.f787e = this;
        }

        @Override // e.b.e.i.g.a
        public boolean a(e.b.e.i.g gVar, MenuItem menuItem) {
            a.AbstractC0014a aVar = this.f706f;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // e.b.e.i.g.a
        public void b(e.b.e.i.g gVar) {
            if (this.f706f != null) {
                i();
                e.b.f.c cVar = w.this.f697f.f829e;
                if (cVar != null) {
                    cVar.n();
                }
            }
        }

        @Override // e.b.e.a
        public void c() {
            w wVar = w.this;
            if (wVar.f700i == this) {
                if (!(!wVar.q)) {
                    wVar.f701j = this;
                    wVar.f702k = this.f706f;
                } else {
                    this.f706f.d(this);
                }
                this.f706f = null;
                w.this.s(false);
                ActionBarContextView actionBarContextView = w.this.f697f;
                if (actionBarContextView.f54l == null) {
                    actionBarContextView.h();
                }
                w.this.f696e.o().sendAccessibilityEvent(32);
                w wVar2 = w.this;
                wVar2.c.setHideOnContentScrollEnabled(wVar2.v);
                w.this.f700i = null;
            }
        }

        @Override // e.b.e.a
        public View d() {
            WeakReference<View> weakReference = this.f707g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // e.b.e.a
        public Menu e() {
            return this.f705e;
        }

        @Override // e.b.e.a
        public MenuInflater f() {
            return new f(this.f704d);
        }

        @Override // e.b.e.a
        public CharSequence g() {
            return w.this.f697f.getSubtitle();
        }

        @Override // e.b.e.a
        public CharSequence h() {
            return w.this.f697f.getTitle();
        }

        @Override // e.b.e.a
        public void i() {
            if (w.this.f700i == this) {
                this.f705e.z();
                try {
                    this.f706f.a(this, this.f705e);
                } finally {
                    this.f705e.y();
                }
            }
        }

        @Override // e.b.e.a
        public boolean j() {
            return w.this.f697f.s;
        }

        @Override // e.b.e.a
        public void k(View view) {
            w.this.f697f.setCustomView(view);
            this.f707g = new WeakReference<>(view);
        }

        @Override // e.b.e.a
        public void l(int i2) {
            w.this.f697f.setSubtitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void m(CharSequence charSequence) {
            w.this.f697f.setSubtitle(charSequence);
        }

        @Override // e.b.e.a
        public void n(int i2) {
            w.this.f697f.setTitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void o(CharSequence charSequence) {
            w.this.f697f.setTitle(charSequence);
        }

        @Override // e.b.e.a
        public void p(boolean z) {
            this.c = z;
            w.this.f697f.setTitleOptional(z);
        }
    }

    public w(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (!z2) {
            this.f698g = decorView.findViewById(16908290);
        }
    }

    public w(Dialog dialog) {
        new ArrayList();
        t(dialog.getWindow().getDecorView());
    }

    @Override // e.b.a.a
    public boolean b() {
        d0 d0Var = this.f696e;
        if (d0Var == null || !d0Var.u()) {
            return false;
        }
        this.f696e.collapseActionView();
        return true;
    }

    @Override // e.b.a.a
    public void c(boolean z2) {
        if (z2 != this.f703l) {
            this.f703l = z2;
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a(z2);
            }
        }
    }

    @Override // e.b.a.a
    public int d() {
        return this.f696e.j();
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
        d dVar = this.f700i;
        if (dVar == null || (gVar = dVar.f705e) == null) {
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
        if (!this.f699h) {
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
        this.f696e.setTitle(charSequence);
    }

    @Override // e.b.a.a
    public void q(CharSequence charSequence) {
        this.f696e.setWindowTitle(charSequence);
    }

    @Override // e.b.a.a
    public e.b.e.a r(a.AbstractC0014a aVar) {
        d dVar = this.f700i;
        if (dVar != null) {
            dVar.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f697f.h();
        d dVar2 = new d(this.f697f.getContext(), aVar);
        dVar2.f705e.z();
        try {
            if (!dVar2.f706f.c(dVar2, dVar2.f705e)) {
                return null;
            }
            this.f700i = dVar2;
            dVar2.i();
            this.f697f.f(dVar2);
            s(true);
            this.f697f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.f705e.y();
        }
    }

    public void s(boolean z2) {
        r rVar;
        r rVar2;
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
        ActionBarContainer actionBarContainer = this.f695d;
        AtomicInteger atomicInteger = l.a;
        if (actionBarContainer.isLaidOut()) {
            if (z2) {
                rVar = this.f696e.s(4, 100);
                rVar2 = this.f697f.e(0, 200);
            } else {
                rVar2 = this.f696e.s(0, 200);
                rVar = this.f697f.e(8, 100);
            }
            e.b.e.g gVar = new e.b.e.g();
            gVar.a.add(rVar);
            View view = rVar.a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = rVar2.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.a.add(rVar2);
            gVar.b();
        } else if (z2) {
            this.f696e.k(4);
            this.f697f.setVisibility(0);
        } else {
            this.f696e.k(0);
            this.f697f.setVisibility(8);
        }
    }

    public final void t(View view) {
        d0 d0Var;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        View findViewById = view.findViewById(R$id.action_bar);
        if (findViewById instanceof d0) {
            d0Var = (d0) findViewById;
        } else if (findViewById instanceof Toolbar) {
            d0Var = ((Toolbar) findViewById).getWrapper();
        } else {
            StringBuilder h2 = f.a.a.a.a.h("Can't make a decor toolbar out of ");
            h2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(h2.toString());
        }
        this.f696e = d0Var;
        this.f697f = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f695d = actionBarContainer;
        d0 d0Var2 = this.f696e;
        if (d0Var2 == null || this.f697f == null || actionBarContainer == null) {
            throw new IllegalStateException(w.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = d0Var2.q();
        boolean z2 = (this.f696e.j() & 4) != 0;
        if (z2) {
            this.f699h = true;
        }
        Context context = this.a;
        this.f696e.p((context.getApplicationInfo().targetSdkVersion < 14) || z2);
        v(context.getResources().getBoolean(R$bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.c;
            if (actionBarOverlayLayout2.f60i) {
                this.v = true;
                actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
            } else {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.f695d;
            AtomicInteger atomicInteger = l.a;
            actionBarContainer2.setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void u(int i2, int i3) {
        int j2 = this.f696e.j();
        if ((i3 & 4) != 0) {
            this.f699h = true;
        }
        this.f696e.x((i2 & i3) | ((~i3) & j2));
    }

    public final void v(boolean z2) {
        this.n = z2;
        if (!z2) {
            this.f696e.n(null);
            this.f695d.setTabContainer(null);
        } else {
            this.f695d.setTabContainer(null);
            this.f696e.n(null);
        }
        boolean z3 = true;
        boolean z4 = this.f696e.r() == 2;
        this.f696e.w(!this.n && z4);
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
                this.f695d.setVisibility(0);
                if (this.o != 0 || (!this.u && !z2)) {
                    this.f695d.setAlpha(1.0f);
                    this.f695d.setTranslationY(0.0f);
                    if (this.p && (view2 = this.f698g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.x.a(null);
                } else {
                    this.f695d.setTranslationY(0.0f);
                    float f2 = (float) (-this.f695d.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.f695d.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f695d.setTranslationY(f2);
                    e.b.e.g gVar2 = new e.b.e.g();
                    r b2 = l.b(this.f695d);
                    b2.g(0.0f);
                    b2.f(this.y);
                    if (!gVar2.f749e) {
                        gVar2.a.add(b2);
                    }
                    if (this.p && (view3 = this.f698g) != null) {
                        view3.setTranslationY(f2);
                        r b3 = l.b(this.f698g);
                        b3.g(0.0f);
                        if (!gVar2.f749e) {
                            gVar2.a.add(b3);
                        }
                    }
                    Interpolator interpolator = A;
                    boolean z3 = gVar2.f749e;
                    if (!z3) {
                        gVar2.c = interpolator;
                    }
                    if (!z3) {
                        gVar2.b = 250;
                    }
                    s sVar = this.x;
                    if (!z3) {
                        gVar2.f748d = sVar;
                    }
                    this.t = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    AtomicInteger atomicInteger = l.a;
                    actionBarOverlayLayout.requestApplyInsets();
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
            this.f695d.setAlpha(1.0f);
            this.f695d.setTransitioning(true);
            e.b.e.g gVar4 = new e.b.e.g();
            float f3 = (float) (-this.f695d.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f695d.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            r b4 = l.b(this.f695d);
            b4.g(f3);
            b4.f(this.y);
            if (!gVar4.f749e) {
                gVar4.a.add(b4);
            }
            if (this.p && (view = this.f698g) != null) {
                r b5 = l.b(view);
                b5.g(f3);
                if (!gVar4.f749e) {
                    gVar4.a.add(b5);
                }
            }
            Interpolator interpolator2 = z;
            boolean z4 = gVar4.f749e;
            if (!z4) {
                gVar4.c = interpolator2;
            }
            if (!z4) {
                gVar4.b = 250;
            }
            s sVar2 = this.w;
            if (!z4) {
                gVar4.f748d = sVar2;
            }
            this.t = gVar4;
            gVar4.b();
        }
    }
}
