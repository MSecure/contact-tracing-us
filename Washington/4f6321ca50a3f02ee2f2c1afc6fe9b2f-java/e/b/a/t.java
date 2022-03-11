package e.b.a;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import e.b.a.a;
import e.b.e.h;
import e.b.e.i.g;
import e.b.e.i.m;
import e.b.f.a1;
import e.b.f.d0;
import e.i.i.l;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class t extends a {
    public d0 a;
    public boolean b;
    public Window.Callback c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f688d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f689e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.b> f690f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f691g = new a();

    /* renamed from: h  reason: collision with root package name */
    public final Toolbar.f f692h;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            t tVar = t.this;
            Menu s = tVar.s();
            g gVar = s instanceof g ? (g) s : null;
            if (gVar != null) {
                gVar.z();
            }
            try {
                s.clear();
                if (!tVar.c.onCreatePanelMenu(0, s) || !tVar.c.onPreparePanel(0, null, s)) {
                    s.clear();
                }
            } finally {
                if (gVar != null) {
                    gVar.y();
                }
            }
        }
    }

    public class b implements Toolbar.f {
        public b() {
        }
    }

    public final class c implements m.a {
        public boolean b;

        public c() {
        }

        @Override // e.b.e.i.m.a
        public void b(g gVar, boolean z) {
            if (!this.b) {
                this.b = true;
                t.this.a.h();
                Window.Callback callback = t.this.c;
                if (callback != null) {
                    callback.onPanelClosed(108, gVar);
                }
                this.b = false;
            }
        }

        @Override // e.b.e.i.m.a
        public boolean c(g gVar) {
            Window.Callback callback = t.this.c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }
    }

    public final class d implements g.a {
        public d() {
        }

        @Override // e.b.e.i.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // e.b.e.i.g.a
        public void b(g gVar) {
            t tVar = t.this;
            if (tVar.c == null) {
                return;
            }
            if (tVar.a.c()) {
                t.this.c.onPanelClosed(108, gVar);
            } else if (t.this.c.onPreparePanel(0, null, gVar)) {
                t.this.c.onMenuOpened(108, gVar);
            }
        }
    }

    public class e extends h {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // e.b.e.h
        public View onCreatePanelView(int i2) {
            return i2 == 0 ? new View(t.this.a.q()) : this.b.onCreatePanelView(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            boolean onPreparePanel = this.b.onPreparePanel(i2, view, menu);
            if (onPreparePanel) {
                t tVar = t.this;
                if (!tVar.b) {
                    tVar.a.f();
                    t.this.b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public t(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f692h = bVar;
        this.a = new a1(toolbar, false);
        e eVar = new e(callback);
        this.c = eVar;
        this.a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.a.setWindowTitle(charSequence);
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
        if (z != this.f689e) {
            this.f689e = z;
            int size = this.f690f.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f690f.get(i2).a(z);
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
        this.a.o().removeCallbacks(this.f691g);
        ViewGroup o = this.a.o();
        Runnable runnable = this.f691g;
        AtomicInteger atomicInteger = l.a;
        o.postOnAnimation(runnable);
        return true;
    }

    @Override // e.b.a.a
    public void g(Configuration configuration) {
    }

    @Override // e.b.a.a
    public void h() {
        this.a.o().removeCallbacks(this.f691g);
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
        if (!this.f688d) {
            this.a.i(new c(), new d());
            this.f688d = true;
        }
        return this.a.l();
    }
}
