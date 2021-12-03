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
import e.i.i.m;
import e.i.i.s;
import e.i.i.t;
import e.i.i.u;
import e.i.i.v;
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
    public ActionBarContainer f689d;

    /* renamed from: e  reason: collision with root package name */
    public d0 f690e;

    /* renamed from: f  reason: collision with root package name */
    public ActionBarContextView f691f;

    /* renamed from: g  reason: collision with root package name */
    public View f692g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f693h;

    /* renamed from: i  reason: collision with root package name */
    public d f694i;

    /* renamed from: j  reason: collision with root package name */
    public e.b.e.a f695j;

    /* renamed from: k  reason: collision with root package name */
    public a.AbstractC0016a f696k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f697l;
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
    public final t w = new a();
    public final t x = new b();
    public final v y = new c();

    public class a extends u {
        public a() {
        }

        @Override // e.i.i.t
        public void a(View view) {
            View view2;
            w wVar = w.this;
            if (wVar.p && (view2 = wVar.f692g) != null) {
                view2.setTranslationY(0.0f);
                w.this.f689d.setTranslationY(0.0f);
            }
            w.this.f689d.setVisibility(8);
            w.this.f689d.setTransitioning(false);
            w wVar2 = w.this;
            wVar2.t = null;
            a.AbstractC0016a aVar = wVar2.f696k;
            if (aVar != null) {
                aVar.d(wVar2.f695j);
                wVar2.f695j = null;
                wVar2.f696k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = w.this.c;
            if (actionBarOverlayLayout != null) {
                AtomicInteger atomicInteger = m.a;
                actionBarOverlayLayout.requestApplyInsets();
            }
        }
    }

    public class b extends u {
        public b() {
        }

        @Override // e.i.i.t
        public void a(View view) {
            w wVar = w.this;
            wVar.t = null;
            wVar.f689d.requestLayout();
        }
    }

    public class c implements v {
        public c() {
        }
    }

    public class d extends e.b.e.a implements g.a {

        /* renamed from: d  reason: collision with root package name */
        public final Context f698d;

        /* renamed from: e  reason: collision with root package name */
        public final e.b.e.i.g f699e;

        /* renamed from: f  reason: collision with root package name */
        public a.AbstractC0016a f700f;

        /* renamed from: g  reason: collision with root package name */
        public WeakReference<View> f701g;

        public d(Context context, a.AbstractC0016a aVar) {
            this.f698d = context;
            this.f700f = aVar;
            e.b.e.i.g gVar = new e.b.e.i.g(context);
            gVar.f788l = 1;
            this.f699e = gVar;
            gVar.f781e = this;
        }

        @Override // e.b.e.i.g.a
        public boolean a(e.b.e.i.g gVar, MenuItem menuItem) {
            a.AbstractC0016a aVar = this.f700f;
            if (aVar != null) {
                return aVar.b(this, menuItem);
            }
            return false;
        }

        @Override // e.b.e.i.g.a
        public void b(e.b.e.i.g gVar) {
            if (this.f700f != null) {
                i();
                e.b.f.c cVar = w.this.f691f.f823e;
                if (cVar != null) {
                    cVar.n();
                }
            }
        }

        @Override // e.b.e.a
        public void c() {
            w wVar = w.this;
            if (wVar.f694i == this) {
                if (!(!wVar.q)) {
                    wVar.f695j = this;
                    wVar.f696k = this.f700f;
                } else {
                    this.f700f.d(this);
                }
                this.f700f = null;
                w.this.s(false);
                ActionBarContextView actionBarContextView = w.this.f691f;
                if (actionBarContextView.f65l == null) {
                    actionBarContextView.h();
                }
                w.this.f690e.o().sendAccessibilityEvent(32);
                w wVar2 = w.this;
                wVar2.c.setHideOnContentScrollEnabled(wVar2.v);
                w.this.f694i = null;
            }
        }

        @Override // e.b.e.a
        public View d() {
            WeakReference<View> weakReference = this.f701g;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // e.b.e.a
        public Menu e() {
            return this.f699e;
        }

        @Override // e.b.e.a
        public MenuInflater f() {
            return new f(this.f698d);
        }

        @Override // e.b.e.a
        public CharSequence g() {
            return w.this.f691f.getSubtitle();
        }

        @Override // e.b.e.a
        public CharSequence h() {
            return w.this.f691f.getTitle();
        }

        @Override // e.b.e.a
        public void i() {
            if (w.this.f694i == this) {
                this.f699e.z();
                try {
                    this.f700f.a(this, this.f699e);
                } finally {
                    this.f699e.y();
                }
            }
        }

        @Override // e.b.e.a
        public boolean j() {
            return w.this.f691f.s;
        }

        @Override // e.b.e.a
        public void k(View view) {
            w.this.f691f.setCustomView(view);
            this.f701g = new WeakReference<>(view);
        }

        @Override // e.b.e.a
        public void l(int i2) {
            w.this.f691f.setSubtitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void m(CharSequence charSequence) {
            w.this.f691f.setSubtitle(charSequence);
        }

        @Override // e.b.e.a
        public void n(int i2) {
            w.this.f691f.setTitle(w.this.a.getResources().getString(i2));
        }

        @Override // e.b.e.a
        public void o(CharSequence charSequence) {
            w.this.f691f.setTitle(charSequence);
        }

        @Override // e.b.e.a
        public void p(boolean z) {
            this.c = z;
            w.this.f691f.setTitleOptional(z);
        }
    }

    public w(Activity activity, boolean z2) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        t(decorView);
        if (!z2) {
            this.f692g = decorView.findViewById(16908290);
        }
    }

    public w(Dialog dialog) {
        new ArrayList();
        t(dialog.getWindow().getDecorView());
    }

    @Override // e.b.a.a
    public boolean b() {
        d0 d0Var = this.f690e;
        if (d0Var == null || !d0Var.u()) {
            return false;
        }
        this.f690e.collapseActionView();
        return true;
    }

    @Override // e.b.a.a
    public void c(boolean z2) {
        if (z2 != this.f697l) {
            this.f697l = z2;
            int size = this.m.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.m.get(i2).a(z2);
            }
        }
    }

    @Override // e.b.a.a
    public int d() {
        return this.f690e.j();
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
        d dVar = this.f694i;
        if (dVar == null || (gVar = dVar.f699e) == null) {
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
        if (!this.f693h) {
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
        this.f690e.setTitle(charSequence);
    }

    @Override // e.b.a.a
    public void q(CharSequence charSequence) {
        this.f690e.setWindowTitle(charSequence);
    }

    @Override // e.b.a.a
    public e.b.e.a r(a.AbstractC0016a aVar) {
        d dVar = this.f694i;
        if (dVar != null) {
            dVar.c();
        }
        this.c.setHideOnContentScrollEnabled(false);
        this.f691f.h();
        d dVar2 = new d(this.f691f.getContext(), aVar);
        dVar2.f699e.z();
        try {
            if (!dVar2.f700f.c(dVar2, dVar2.f699e)) {
                return null;
            }
            this.f694i = dVar2;
            dVar2.i();
            this.f691f.f(dVar2);
            s(true);
            this.f691f.sendAccessibilityEvent(32);
            return dVar2;
        } finally {
            dVar2.f699e.y();
        }
    }

    public void s(boolean z2) {
        s sVar;
        s sVar2;
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
        ActionBarContainer actionBarContainer = this.f689d;
        AtomicInteger atomicInteger = m.a;
        if (actionBarContainer.isLaidOut()) {
            if (z2) {
                sVar = this.f690e.s(4, 100);
                sVar2 = this.f691f.e(0, 200);
            } else {
                sVar2 = this.f690e.s(0, 200);
                sVar = this.f691f.e(8, 100);
            }
            e.b.e.g gVar = new e.b.e.g();
            gVar.a.add(sVar);
            View view = sVar.a.get();
            long duration = view != null ? view.animate().getDuration() : 0;
            View view2 = sVar2.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(duration);
            }
            gVar.a.add(sVar2);
            gVar.b();
        } else if (z2) {
            this.f690e.k(4);
            this.f691f.setVisibility(0);
        } else {
            this.f690e.k(0);
            this.f691f.setVisibility(8);
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
            StringBuilder i2 = f.a.a.a.a.i("Can't make a decor toolbar out of ");
            i2.append(findViewById != null ? findViewById.getClass().getSimpleName() : "null");
            throw new IllegalStateException(i2.toString());
        }
        this.f690e = d0Var;
        this.f691f = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f689d = actionBarContainer;
        d0 d0Var2 = this.f690e;
        if (d0Var2 == null || this.f691f == null || actionBarContainer == null) {
            throw new IllegalStateException(w.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.a = d0Var2.q();
        boolean z2 = (this.f690e.j() & 4) != 0;
        if (z2) {
            this.f693h = true;
        }
        Context context = this.a;
        this.f690e.p((context.getApplicationInfo().targetSdkVersion < 14) || z2);
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
            ActionBarContainer actionBarContainer2 = this.f689d;
            AtomicInteger atomicInteger = m.a;
            actionBarContainer2.setElevation((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void u(int i2, int i3) {
        int j2 = this.f690e.j();
        if ((i3 & 4) != 0) {
            this.f693h = true;
        }
        this.f690e.x((i2 & i3) | ((~i3) & j2));
    }

    public final void v(boolean z2) {
        this.n = z2;
        if (!z2) {
            this.f690e.n(null);
            this.f689d.setTabContainer(null);
        } else {
            this.f689d.setTabContainer(null);
            this.f690e.n(null);
        }
        boolean z3 = true;
        boolean z4 = this.f690e.r() == 2;
        this.f690e.w(!this.n && z4);
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
                this.f689d.setVisibility(0);
                if (this.o != 0 || (!this.u && !z2)) {
                    this.f689d.setAlpha(1.0f);
                    this.f689d.setTranslationY(0.0f);
                    if (this.p && (view2 = this.f692g) != null) {
                        view2.setTranslationY(0.0f);
                    }
                    this.x.a(null);
                } else {
                    this.f689d.setTranslationY(0.0f);
                    float f2 = (float) (-this.f689d.getHeight());
                    if (z2) {
                        int[] iArr = {0, 0};
                        this.f689d.getLocationInWindow(iArr);
                        f2 -= (float) iArr[1];
                    }
                    this.f689d.setTranslationY(f2);
                    e.b.e.g gVar2 = new e.b.e.g();
                    s b2 = m.b(this.f689d);
                    b2.g(0.0f);
                    b2.f(this.y);
                    if (!gVar2.f743e) {
                        gVar2.a.add(b2);
                    }
                    if (this.p && (view3 = this.f692g) != null) {
                        view3.setTranslationY(f2);
                        s b3 = m.b(this.f692g);
                        b3.g(0.0f);
                        if (!gVar2.f743e) {
                            gVar2.a.add(b3);
                        }
                    }
                    Interpolator interpolator = A;
                    boolean z3 = gVar2.f743e;
                    if (!z3) {
                        gVar2.c = interpolator;
                    }
                    if (!z3) {
                        gVar2.b = 250;
                    }
                    t tVar = this.x;
                    if (!z3) {
                        gVar2.f742d = tVar;
                    }
                    this.t = gVar2;
                    gVar2.b();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.c;
                if (actionBarOverlayLayout != null) {
                    AtomicInteger atomicInteger = m.a;
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
            this.f689d.setAlpha(1.0f);
            this.f689d.setTransitioning(true);
            e.b.e.g gVar4 = new e.b.e.g();
            float f3 = (float) (-this.f689d.getHeight());
            if (z2) {
                int[] iArr2 = {0, 0};
                this.f689d.getLocationInWindow(iArr2);
                f3 -= (float) iArr2[1];
            }
            s b4 = m.b(this.f689d);
            b4.g(f3);
            b4.f(this.y);
            if (!gVar4.f743e) {
                gVar4.a.add(b4);
            }
            if (this.p && (view = this.f692g) != null) {
                s b5 = m.b(view);
                b5.g(f3);
                if (!gVar4.f743e) {
                    gVar4.a.add(b5);
                }
            }
            Interpolator interpolator2 = z;
            boolean z4 = gVar4.f743e;
            if (!z4) {
                gVar4.c = interpolator2;
            }
            if (!z4) {
                gVar4.b = 250;
            }
            t tVar2 = this.w;
            if (!z4) {
                gVar4.f742d = tVar2;
            }
            this.t = gVar4;
            gVar4.b();
        }
    }
}
