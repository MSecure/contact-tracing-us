package e.b.e;

import android.view.View;
import android.view.animation.Interpolator;
import e.i.i.x;
import e.i.i.y;
import e.i.i.z;
import java.util.ArrayList;
import java.util.Iterator;

public class g {
    public final ArrayList<x> a = new ArrayList<>();
    public long b = -1;
    public Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    public y f750d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f751e;

    /* renamed from: f  reason: collision with root package name */
    public final z f752f = new a();

    public class a extends z {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // e.i.i.y
        public void a(View view) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == g.this.a.size()) {
                y yVar = g.this.f750d;
                if (yVar != null) {
                    yVar.a(null);
                }
                this.b = 0;
                this.a = false;
                g.this.f751e = false;
            }
        }

        @Override // e.i.i.y, e.i.i.z
        public void b(View view) {
            if (!this.a) {
                this.a = true;
                y yVar = g.this.f750d;
                if (yVar != null) {
                    yVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f751e) {
            Iterator<x> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f751e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f751e) {
            Iterator<x> it = this.a.iterator();
            while (it.hasNext()) {
                x next = it.next();
                long j2 = this.b;
                if (j2 >= 0) {
                    next.c(j2);
                }
                Interpolator interpolator = this.c;
                if (!(interpolator == null || (view = next.a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f750d != null) {
                    next.d(this.f752f);
                }
                View view2 = next.a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f751e = true;
        }
    }
}
