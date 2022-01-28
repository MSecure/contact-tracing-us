package e.b.e;

import android.view.View;
import android.view.animation.Interpolator;
import e.i.i.s;
import e.i.i.t;
import e.i.i.u;
import java.util.ArrayList;
import java.util.Iterator;

public class g {
    public final ArrayList<s> a = new ArrayList<>();
    public long b = -1;
    public Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    public t f742d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f743e;

    /* renamed from: f  reason: collision with root package name */
    public final u f744f = new a();

    public class a extends u {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // e.i.i.t
        public void a(View view) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == g.this.a.size()) {
                t tVar = g.this.f742d;
                if (tVar != null) {
                    tVar.a(null);
                }
                this.b = 0;
                this.a = false;
                g.this.f743e = false;
            }
        }

        @Override // e.i.i.u, e.i.i.t
        public void b(View view) {
            if (!this.a) {
                this.a = true;
                t tVar = g.this.f742d;
                if (tVar != null) {
                    tVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f743e) {
            Iterator<s> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f743e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f743e) {
            Iterator<s> it = this.a.iterator();
            while (it.hasNext()) {
                s next = it.next();
                long j2 = this.b;
                if (j2 >= 0) {
                    next.c(j2);
                }
                Interpolator interpolator = this.c;
                if (!(interpolator == null || (view = next.a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f742d != null) {
                    next.d(this.f744f);
                }
                View view2 = next.a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f743e = true;
        }
    }
}
