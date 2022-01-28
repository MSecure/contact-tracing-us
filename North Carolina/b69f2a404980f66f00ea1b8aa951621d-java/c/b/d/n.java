package c.b.d;

import java.util.List;

public final class n implements x2 {

    /* renamed from: a  reason: collision with root package name */
    public final m f4006a;

    public n(m mVar) {
        m0.b(mVar, "output");
        this.f4006a = mVar;
        mVar.f3993a = this;
    }

    public void a(int i, List<j> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f4006a.a0(i, list.get(i2));
        }
    }

    public void b(int i) {
        this.f4006a.r0(i, 4);
    }

    public void c(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f4006a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).intValue();
                i3 += 4;
            }
            this.f4006a.t0(i3);
            while (i2 < list.size()) {
                this.f4006a.e0(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4006a.d0(i, list.get(i2).intValue());
            i2++;
        }
    }

    public void d(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f4006a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                list.get(i4).longValue();
                i3 += 8;
            }
            this.f4006a.t0(i3);
            while (i2 < list.size()) {
                this.f4006a.g0(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4006a.f0(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void e(int i, float f) {
        m mVar = this.f4006a;
        if (mVar != null) {
            mVar.d0(i, Float.floatToRawIntBits(f));
            return;
        }
        throw null;
    }

    public void f(int i, Object obj, c2 c2Var) {
        m mVar = this.f4006a;
        mVar.r0(i, 3);
        c2Var.j((h1) obj, mVar.f3993a);
        mVar.r0(i, 4);
    }

    public void g(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (z) {
            this.f4006a.r0(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += m.R(list.get(i4).longValue());
            }
            this.f4006a.t0(i3);
            while (i2 < list.size()) {
                this.f4006a.v0(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.f4006a.u0(i, list.get(i2).longValue());
            i2++;
        }
    }

    public void h(int i, Object obj, c2 c2Var) {
        this.f4006a.l0(i, (h1) obj, c2Var);
    }

    public final void i(int i, Object obj) {
        if (obj instanceof j) {
            this.f4006a.o0(i, (j) obj);
        } else {
            this.f4006a.n0(i, (h1) obj);
        }
    }

    public void j(int i, int i2) {
        this.f4006a.s0(i, m.S(i2));
    }

    public void k(int i, long j) {
        this.f4006a.u0(i, m.T(j));
    }

    public void l(int i) {
        this.f4006a.r0(i, 3);
    }
}
