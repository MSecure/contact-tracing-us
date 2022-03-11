package e.b.a;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import e.b.a.a;
import e.b.a.m;
import e.b.e.i.g;
import e.b.e.i.m;
import e.b.f.e1;
import e.b.f.h0;
import e.j.j.v;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class t extends a {
    public final h0 a;
    public final Window.Callback b;

    /* renamed from: d  reason: collision with root package name */
    public boolean f753d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f754e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f755f;

    /* renamed from: i  reason: collision with root package name */
    public final Toolbar.f f758i;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList<a.b> f756g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f757h = new a();
    public final m.b c = new e();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t tVar = t.this;
            Menu s = tVar.s();
            g gVar = s instanceof g ? (g) s : null;
            if (gVar != null) {
                gVar.z();
            }
            try {
                s.clear();
                if (!tVar.b.onCreatePanelMenu(0, s) || !tVar.b.onPreparePanel(0, null, s)) {
                    s.clear();
                }
            } finally {
                if (gVar != null) {
                    gVar.y();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Toolbar.f {
        public b() {
        }
    }

    /* loaded from: classes.dex */
    public final class c implements m.a {
        public boolean b;

        public c() {
        }

        @Override // e.b.e.i.m.a
        public void b(g gVar, boolean z) {
            if (!this.b) {
                this.b = true;
                t.this.a.h();
                t.this.b.onPanelClosed(108, gVar);
                this.b = false;
            }
        }

        @Override // e.b.e.i.m.a
        public boolean c(g gVar) {
            t.this.b.onMenuOpened(108, gVar);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class d implements g.a {
        public d() {
        }

        @Override // e.b.e.i.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // e.b.e.i.g.a
        public void b(g gVar) {
            if (t.this.a.c()) {
                t.this.b.onPanelClosed(108, gVar);
            } else if (t.this.b.onPreparePanel(0, null, gVar)) {
                t.this.b.onMenuOpened(108, gVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements m.b {
        public e() {
        }
    }

    public t(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f758i = bVar;
        e1 e1Var = new e1(toolbar, false);
        this.a = e1Var;
        Objects.requireNonNull(callback);
        this.b = callback;
        e1Var.f943l = callback;
        toolbar.setOnMenuItemClickListener(bVar);
        e1Var.setWindowTitle(charSequence);
    }

    @Override // e.b.a.a
    public boolean a() {
        return this.a.d();
    }

    @Override // e.b.a.a
    public boolean b() {
        if (!this.a.u()) {
            return false;
        }
        this.a.collapseActionView();
        return true;
    }

    @Override // e.b.a.a
    public void c(boolean z) {
        if (z != this.f755f) {
            this.f755f = z;
            int size = this.f756g.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f756g.get(i2).a(z);
            }
        }
    }

    @Override // e.b.a.a
    public int d() {
        return this.a.j();
    }

    @Override // e.b.a.a
    public Context e() {
        return this.a.q();
    }

    @Override // e.b.a.a
    public boolean f() {
        this.a.o().removeCallbacks(this.f757h);
        ViewGroup o = this.a.o();
        Runnable runnable = this.f757h;
        AtomicInteger atomicInteger = v.a;
        v.d.m(o, runnable);
        return true;
    }

    @Override // e.b.a.a
    public void g(Configuration configuration) {
    }

    @Override // e.b.a.a
    public void h() {
        this.a.o().removeCallbacks(this.f757h);
    }

    @Override // e.b.a.a
    public boolean i(int i2, KeyEvent keyEvent) {
        Menu s = s();
        if (s == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        s.setQwertyMode(z);
        return s.performShortcut(i2, keyEvent, 0);
    }

    @Override // e.b.a.a
    public boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.a.e();
        }
        return true;
    }

    @Override // e.b.a.a
    public boolean k() {
        return this.a.e();
    }

    @Override // e.b.a.a
    public void l(boolean z) {
    }

    @Override // e.b.a.a
    public void m(boolean z) {
        this.a.x(((z ? 4 : 0) & 4) | (this.a.j() & -5));
    }

    @Override // e.b.a.a
    public void n(boolean z) {
        this.a.x(((z ? 8 : 0) & 8) | (this.a.j() & -9));
    }

    @Override // e.b.a.a
    public void o(boolean z) {
    }

    @Override // e.b.a.a
    public void p(CharSequence charSequence) {
        this.a.setTitle(charSequence);
    }

    @Override // e.b.a.a
    public void q(CharSequence charSequence) {
        this.a.setWindowTitle(charSequence);
    }

    public final Menu s() {
        if (!this.f754e) {
            this.a.i(new c(), new d());
            this.f754e = true;
        }
        return this.a.l();
    }
}
