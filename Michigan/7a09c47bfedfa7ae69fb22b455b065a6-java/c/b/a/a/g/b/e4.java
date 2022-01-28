package c.b.a.a.g.b;

import c.b.a.a.g.b.e4;

public class e4<M extends e4<M>> extends j4 {

    /* renamed from: c  reason: collision with root package name */
    public g4 f3257c;

    @Override // c.b.a.a.g.b.j4
    public void a(c4 c4Var) {
        if (this.f3257c != null) {
            int i = 0;
            while (true) {
                g4 g4Var = this.f3257c;
                if (i < g4Var.f3284d) {
                    g4Var.f3283c[i].b();
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // c.b.a.a.g.b.j4
    public int d() {
        if (this.f3257c != null) {
            int i = 0;
            while (true) {
                g4 g4Var = this.f3257c;
                if (i >= g4Var.f3284d) {
                    break;
                }
                g4Var.f3283c[i].c();
                i++;
            }
        }
        return 0;
    }

    @Override // c.b.a.a.g.b.j4
    public /* synthetic */ j4 e() {
        return (e4) clone();
    }

    /* renamed from: f */
    public M clone() {
        M m = (M) ((e4) super.clone());
        i4.f(this, m);
        return m;
    }
}
