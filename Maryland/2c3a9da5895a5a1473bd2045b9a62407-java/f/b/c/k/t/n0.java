package f.b.c.k.t;

import f.b.a.c.b.o.b;
import f.b.c.k.s.s;
import f.b.c.k.t.v;
import f.b.c.k.u.f;

public class n0 implements i0, u {
    public final r0 a;
    public s b;
    public long c = -1;

    /* renamed from: d  reason: collision with root package name */
    public final v f3189d;

    /* renamed from: e  reason: collision with root package name */
    public j0 f3190e;

    public n0(r0 r0Var, v.a aVar) {
        this.a = r0Var;
        this.f3189d = new v(this, aVar);
    }

    @Override // f.b.c.k.t.i0
    public void a(f fVar) {
        j(fVar);
    }

    @Override // f.b.c.k.t.i0
    public void b(f fVar) {
        j(fVar);
    }

    @Override // f.b.c.k.t.i0
    public void c(j0 j0Var) {
        this.f3190e = j0Var;
    }

    @Override // f.b.c.k.t.i0
    public long d() {
        b.b1(this.c != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.c;
    }

    @Override // f.b.c.k.t.i0
    public void e() {
        b.b1(this.c != -1, "Committing a transaction without having started one", new Object[0]);
        this.c = -1;
    }

    @Override // f.b.c.k.t.i0
    public void f(d1 d1Var) {
        this.a.f3201d.d(d1Var.b(d()));
    }

    @Override // f.b.c.k.t.i0
    public void g() {
        b.b1(this.c == -1, "Starting a transaction without committing the previous one", new Object[0]);
        s sVar = this.b;
        long j2 = sVar.a + 1;
        sVar.a = j2;
        this.c = j2;
    }

    @Override // f.b.c.k.t.i0
    public void h(f fVar) {
        j(fVar);
    }

    @Override // f.b.c.k.t.i0
    public void i(f fVar) {
        j(fVar);
    }

    public final void j(f fVar) {
        String s0 = b.s0(fVar.b);
        r0 r0Var = this.a;
        r0Var.f3206i.execSQL("INSERT OR REPLACE INTO target_documents (target_id, path, sequence_number) VALUES (0, ?, ?)", new Object[]{s0, Long.valueOf(d())});
    }
}
