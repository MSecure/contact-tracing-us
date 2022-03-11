package e.b.e;

import android.view.View;
import android.view.animation.Interpolator;
import e.j.j.x;
import e.j.j.y;
import e.j.j.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class g {
    public Interpolator c;

    /* renamed from: d  reason: collision with root package name */
    public y f814d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f815e;
    public long b = -1;

    /* renamed from: f  reason: collision with root package name */
    public final z f816f = new a();
    public final ArrayList<x> a = new ArrayList<>();

    /* loaded from: classes.dex */
    public class a extends z {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // e.j.j.y
        public void a(View view) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == g.this.a.size()) {
                y yVar = g.this.f814d;
                if (yVar != null) {
                    yVar.a(null);
                }
                this.b = 0;
                this.a = false;
                g.this.f815e = false;
            }
        }

        @Override // e.j.j.z, e.j.j.y
        public void b(View view) {
            if (!this.a) {
                this.a = true;
                y yVar = g.this.f814d;
                if (yVar != null) {
                    yVar.b(null);
                }
            }
        }
    }

    public void a() {
        if (this.f815e) {
            Iterator<x> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f815e = false;
        }
    }

    public void b() {
        View view;
        if (!this.f815e) {
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
                if (this.f814d != null) {
                    next.d(this.f816f);
                }
                View view2 = next.a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f815e = true;
        }
    }
}
