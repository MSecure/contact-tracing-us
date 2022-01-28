package f.b.c.k.t;

import f.b.c.g.a.f;
import f.b.c.k.s.c0;
import f.b.c.k.u.m;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class d0 implements c1 {
    public final Map<c0, d1> a = new HashMap();
    public final j0 b = new j0();
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public m f3274d = m.c;

    /* renamed from: e  reason: collision with root package name */
    public long f3275e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f3276f;

    public d0(b0 b0Var) {
        this.f3276f = b0Var;
    }

    @Override // f.b.c.k.t.c1
    public m a() {
        return this.f3274d;
    }

    @Override // f.b.c.k.t.c1
    public void b(f<f.b.c.k.u.f> fVar, int i2) {
        this.b.b(fVar, i2);
        i0 i0Var = this.f3276f.f3269f;
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                i0Var.a((f.b.c.k.u.f) aVar.next());
            } else {
                return;
            }
        }
    }

    @Override // f.b.c.k.t.c1
    public void c(f<f.b.c.k.u.f> fVar, int i2) {
        this.b.f(fVar, i2);
        i0 i0Var = this.f3276f.f3269f;
        Iterator<f.b.c.k.u.f> it = fVar.iterator();
        while (true) {
            f.a aVar = (f.a) it;
            if (aVar.hasNext()) {
                i0Var.i((f.b.c.k.u.f) aVar.next());
            } else {
                return;
            }
        }
    }

    @Override // f.b.c.k.t.c1
    public void d(d1 d1Var) {
        this.a.put(d1Var.a, d1Var);
        int i2 = d1Var.b;
        if (i2 > this.c) {
            this.c = i2;
        }
        long j2 = d1Var.c;
        if (j2 > this.f3275e) {
            this.f3275e = j2;
        }
    }

    @Override // f.b.c.k.t.c1
    public void e(m mVar) {
        this.f3274d = mVar;
    }

    @Override // f.b.c.k.t.c1
    public int f() {
        return this.c;
    }
}
