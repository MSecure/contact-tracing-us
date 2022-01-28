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
    public final ArrayList<r> f667a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public long f668b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f669c;

    /* renamed from: d  reason: collision with root package name */
    public s f670d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f671e;

    /* renamed from: f  reason: collision with root package name */
    public final t f672f = new a();

    public class a extends t {

        /* renamed from: a  reason: collision with root package name */
        public boolean f673a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f674b = 0;

        public a() {
        }

        @Override // b.i.l.s
        public void a(View view) {
            int i = this.f674b + 1;
            this.f674b = i;
            if (i == g.this.f667a.size()) {
                s sVar = g.this.f670d;
                if (sVar != null) {
                    sVar.a(null);
                }
                this.f674b = 0;
                this.f673a = false;
                g.this.f671e = false;
            }
        }

        @Override // b.i.l.t, b.i.l.s
        public void b(View view) {
            if (!this.f673a) {
                this.f673a = true;
                s sVar = g.this.f670d;
                if (sVar != null) {
                    sVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f671e) {
            Iterator<r> it = this.f667a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f671e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f671e) {
            Iterator<r> it = this.f667a.iterator();
            while (it.hasNext()) {
                r next = it.next();
                long j = this.f668b;
                if (j >= 0) {
                    next.c(j);
                }
                Interpolator interpolator = this.f669c;
                if (!(interpolator == null || (view = next.f1880a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f670d != null) {
                    next.d(this.f672f);
                }
                View view2 = next.f1880a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f671e = true;
        }
    }
}
