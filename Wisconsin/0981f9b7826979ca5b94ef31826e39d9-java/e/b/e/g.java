package e.b.e;

import android.view.View;
import android.view.animation.Interpolator;
import e.i.i.r;
import e.i.i.s;
import e.i.i.t;
import java.util.ArrayList;
import java.util.Iterator;

public class g {
    public final ArrayList<r> a = new ArrayList<>();
    public long b = -1;
    public Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    public s f748d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f749e;

    /* renamed from: f  reason: collision with root package name */
    public final t f750f = new a();

    public class a extends t {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // e.i.i.s
        public void a(View view) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == g.this.a.size()) {
                s sVar = g.this.f748d;
                if (sVar != null) {
                    sVar.a(null);
                }
                this.b = 0;
                this.a = false;
                g.this.f749e = false;
            }
        }

        @Override // e.i.i.s, e.i.i.t
        public void b(View view) {
            if (!this.a) {
                this.a = true;
                s sVar = g.this.f748d;
                if (sVar != null) {
                    sVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f749e) {
            Iterator<r> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f749e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f749e) {
            Iterator<r> it = this.a.iterator();
            while (it.hasNext()) {
                r next = it.next();
                long j2 = this.b;
                if (j2 >= 0) {
                    next.c(j2);
                }
                Interpolator interpolator = this.c;
                if (!(interpolator == null || (view = next.a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f748d != null) {
                    next.d(this.f750f);
                }
                View view2 = next.a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f749e = true;
        }
    }
}
