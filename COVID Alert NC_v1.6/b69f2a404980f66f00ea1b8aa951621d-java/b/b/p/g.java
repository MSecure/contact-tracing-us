package b.b.p;

import android.view.View;
import android.view.animation.Interpolator;
import b.i.l.r;
import b.i.l.s;
import b.i.l.t;
import java.util.ArrayList;
import java.util.Iterator;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<r> f496a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public long f497b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f498c;

    /* renamed from: d  reason: collision with root package name */
    public s f499d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f500e;
    public final t f = new a();

    public class a extends t {

        /* renamed from: a  reason: collision with root package name */
        public boolean f501a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f502b = 0;

        public a() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            int i = this.f502b + 1;
            this.f502b = i;
            if (i == g.this.f496a.size()) {
                s sVar = g.this.f499d;
                if (sVar != null) {
                    sVar.a(null);
                }
                this.f502b = 0;
                this.f501a = false;
                g.this.f500e = false;
            }
        }

        @Override // b.i.l.t, b.i.l.s
        public void b(View view) {
            if (!this.f501a) {
                this.f501a = true;
                s sVar = g.this.f499d;
                if (sVar != null) {
                    sVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f500e) {
            Iterator<r> it = this.f496a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f500e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f500e) {
            Iterator<r> it = this.f496a.iterator();
            while (it.hasNext()) {
                r next = it.next();
                long j = this.f497b;
                if (j >= 0) {
                    next.c(j);
                }
                Interpolator interpolator = this.f498c;
                if (!(interpolator == null || (view = next.f1171a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f499d != null) {
                    next.d(this.f);
                }
                View view2 = next.f1171a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f500e = true;
        }
    }
}
