package b.b.k;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import b.b.k.a;
import b.b.p.h;
import b.b.p.i.g;
import b.b.p.i.m;
import b.b.q.a1;
import b.b.q.d0;
import java.util.ArrayList;

public class r extends a {

    /* renamed from: a  reason: collision with root package name */
    public d0 f414a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f415b;

    /* renamed from: c  reason: collision with root package name */
    public Window.Callback f416c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f417d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f418e;
    public ArrayList<a.b> f = new ArrayList<>();
    public final Runnable g = new a();
    public final Toolbar.f h = new b();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            r rVar = r.this;
            Menu p = rVar.p();
            g gVar = p instanceof g ? (g) p : null;
            if (gVar != null) {
                gVar.z();
            }
            try {
                p.clear();
                if (!rVar.f416c.onCreatePanelMenu(0, p) || !rVar.f416c.onPreparePanel(0, null, p)) {
                    p.clear();
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

        /* renamed from: b  reason: collision with root package name */
        public boolean f421b;

        public c() {
        }

        @Override // b.b.p.i.m.a
        public void b(g gVar, boolean z) {
            if (!this.f421b) {
                this.f421b = true;
                r.this.f414a.h();
                Window.Callback callback = r.this.f416c;
                if (callback != null) {
                    callback.onPanelClosed(108, gVar);
                }
                this.f421b = false;
            }
        }

        @Override // b.b.p.i.m.a
        public boolean c(g gVar) {
            Window.Callback callback = r.this.f416c;
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

        @Override // b.b.p.i.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // b.b.p.i.g.a
        public void b(g gVar) {
            r rVar = r.this;
            if (rVar.f416c == null) {
                return;
            }
            if (rVar.f414a.c()) {
                r.this.f416c.onPanelClosed(108, gVar);
            } else if (r.this.f416c.onPreparePanel(0, null, gVar)) {
                r.this.f416c.onMenuOpened(108, gVar);
            }
        }
    }

    public class e extends h {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // b.b.p.h
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(r.this.f414a.q()) : this.f504b.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = this.f504b.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                r rVar = r.this;
                if (!rVar.f415b) {
                    rVar.f414a.f();
                    r.this.f415b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public r(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f414a = new a1(toolbar, false);
        e eVar = new e(callback);
        this.f416c = eVar;
        this.f414a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f414a.setWindowTitle(charSequence);
    }

    @Override // b.b.k.a
    public boolean a() {
        return this.f414a.d();
    }

    @Override // b.b.k.a
    public boolean b() {
        if (!this.f414a.u()) {
            return false;
        }
        this.f414a.collapseActionView();
        return true;
    }

    @Override // b.b.k.a
    public void c(boolean z) {
        if (z != this.f418e) {
            this.f418e = z;
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.get(i).a(z);
            }
        }
    }

    @Override // b.b.k.a
    public int d() {
        return this.f414a.j();
    }

    @Override // b.b.k.a
    public Context e() {
        return this.f414a.q();
    }

    @Override // b.b.k.a
    public boolean f() {
        this.f414a.o().removeCallbacks(this.g);
        b.i.l.m.M(this.f414a.o(), this.g);
        return true;
    }

    @Override // b.b.k.a
    public void g(Configuration configuration) {
    }

    @Override // b.b.k.a
    public void h() {
        this.f414a.o().removeCallbacks(this.g);
    }

    @Override // b.b.k.a
    public boolean i(int i, KeyEvent keyEvent) {
        Menu p = p();
        if (p == null) {
            return false;
        }
        boolean z = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z = false;
        }
        p.setQwertyMode(z);
        return p.performShortcut(i, keyEvent, 0);
    }

    @Override // b.b.k.a
    public boolean j(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            this.f414a.e();
        }
        return true;
    }

    @Override // b.b.k.a
    public boolean k() {
        return this.f414a.e();
    }

    @Override // b.b.k.a
    public void l(boolean z) {
    }

    @Override // b.b.k.a
    public void m(boolean z) {
    }

    @Override // b.b.k.a
    public void n(CharSequence charSequence) {
        this.f414a.setWindowTitle(charSequence);
    }

    public final Menu p() {
        if (!this.f417d) {
            this.f414a.i(new c(), new d());
            this.f417d = true;
        }
        return this.f414a.l();
    }
}
