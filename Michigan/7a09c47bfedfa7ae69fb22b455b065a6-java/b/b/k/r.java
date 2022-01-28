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
    public d0 f570a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f571b;

    /* renamed from: c  reason: collision with root package name */
    public Window.Callback f572c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f573d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f574e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<a.b> f575f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public final Runnable f576g = new a();
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
                if (!rVar.f572c.onCreatePanelMenu(0, p) || !rVar.f572c.onPreparePanel(0, null, p)) {
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
        public boolean f579b;

        public c() {
        }

        @Override // b.b.p.i.m.a
        public void b(g gVar, boolean z) {
            if (!this.f579b) {
                this.f579b = true;
                r.this.f570a.h();
                Window.Callback callback = r.this.f572c;
                if (callback != null) {
                    callback.onPanelClosed(108, gVar);
                }
                this.f579b = false;
            }
        }

        @Override // b.b.p.i.m.a
        public boolean c(g gVar) {
            Window.Callback callback = r.this.f572c;
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
            if (rVar.f572c == null) {
                return;
            }
            if (rVar.f570a.c()) {
                r.this.f572c.onPanelClosed(108, gVar);
            } else if (r.this.f572c.onPreparePanel(0, null, gVar)) {
                r.this.f572c.onMenuOpened(108, gVar);
            }
        }
    }

    public class e extends h {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // b.b.p.h
        public View onCreatePanelView(int i) {
            return i == 0 ? new View(r.this.f570a.q()) : this.f676b.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = this.f676b.onPreparePanel(i, view, menu);
            if (onPreparePanel) {
                r rVar = r.this;
                if (!rVar.f571b) {
                    rVar.f570a.f();
                    r.this.f571b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public r(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f570a = new a1(toolbar, false);
        e eVar = new e(callback);
        this.f572c = eVar;
        this.f570a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(this.h);
        this.f570a.setWindowTitle(charSequence);
    }

    @Override // b.b.k.a
    public boolean a() {
        return this.f570a.d();
    }

    @Override // b.b.k.a
    public boolean b() {
        if (!this.f570a.u()) {
            return false;
        }
        this.f570a.collapseActionView();
        return true;
    }

    @Override // b.b.k.a
    public void c(boolean z) {
        if (z != this.f574e) {
            this.f574e = z;
            int size = this.f575f.size();
            for (int i = 0; i < size; i++) {
                this.f575f.get(i).a(z);
            }
        }
    }

    @Override // b.b.k.a
    public int d() {
        return this.f570a.j();
    }

    @Override // b.b.k.a
    public Context e() {
        return this.f570a.q();
    }

    @Override // b.b.k.a
    public boolean f() {
        this.f570a.o().removeCallbacks(this.f576g);
        b.i.l.m.N(this.f570a.o(), this.f576g);
        return true;
    }

    @Override // b.b.k.a
    public void g(Configuration configuration) {
    }

    @Override // b.b.k.a
    public void h() {
        this.f570a.o().removeCallbacks(this.f576g);
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
            this.f570a.e();
        }
        return true;
    }

    @Override // b.b.k.a
    public boolean k() {
        return this.f570a.e();
    }

    @Override // b.b.k.a
    public void l(boolean z) {
    }

    @Override // b.b.k.a
    public void m(boolean z) {
    }

    @Override // b.b.k.a
    public void n(CharSequence charSequence) {
        this.f570a.setWindowTitle(charSequence);
    }

    public final Menu p() {
        if (!this.f573d) {
            this.f570a.i(new c(), new d());
            this.f573d = true;
        }
        return this.f570a.l();
    }
}
