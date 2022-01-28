package c.b.d;

import java.util.List;

public final class n implements y2 {

    /* renamed from: a  reason: collision with root package name */
    public final m f5437a;

    public n(m mVar) {
        n0.b(mVar, "output");
        this.f5437a = mVar;
        mVar.f5425a = this;
    }

    public void a(int i, List<j> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f5437a.a0(i, list.get(i2));
        }
    }

    public void b(int i) {
        this.f5437a.r0(i, 4);
    }

    public void c(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f5437a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += 4;
            }
            this.f5437a.t0(i3);
            while (i2 < list.size()) {
                this.f5437a.e0(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f5437a.d0(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f5437a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += 8;
            }
            this.f5437a.t0(i3);
            while (i2 < list.size()) {
                this.f5437a.g0(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f5437a.f0(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void e(int i, float f2) {
        m mVar = this.f5437a;
        if (mVar != null) {
            mVar.d0(i, Float.floatToRawIntBits(f2));
            return;
        }
        throw null;
    }

    public void f(int i, Object obj, d2 d2Var) {
        m mVar = this.f5437a;
        mVar.r0(i, 3);
        d2Var.j((i1) obj, mVar.f5425a);
        mVar.r0(i, 4);
    }

    public void g(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f5437a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += m.R(list.get(i4).longValue());
            }
            this.f5437a.t0(i3);
            while (i2 < list.size()) {
                this.f5437a.v0(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f5437a.u0(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void h(int i, Object obj, d2 d2Var) {
        this.f5437a.l0(i, (i1) obj, d2Var);
    }

    public final void i(int i, Object obj) {
        if (obj instanceof j) {
            this.f5437a.o0(i, (j) obj);
        } else {
            this.f5437a.n0(i, (i1) obj);
        }
    }

    public void j(int i, int i2) {
        this.f5437a.s0(i, m.S(i2));
    }

    public void k(int i, long j) {
        this.f5437a.u0(i, m.T(j));
    }

    public void l(int i) {
        this.f5437a.r0(i, 3);
    }
}
