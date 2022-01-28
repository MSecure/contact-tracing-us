package c.b.d;

import c.b.d.q2;
import java.util.ArrayList;
import java.util.Map;

public class t2 extends p2<q2, q2.b> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // c.b.d.p2
    public void a(q2.b bVar, int i, int i2) {
        q2.c.a c2 = q2.c.c();
        c2.a(i2);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.p2
    public void b(q2.b bVar, int i, long j) {
        q2.c.a c2 = q2.c.c();
        c2.b(j);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // c.b.d.p2
    public void c(q2.b bVar, int i, q2 q2Var) {
        q2.b bVar2 = bVar;
        q2 q2Var2 = q2Var;
        q2.c.a c2 = q2.c.c();
        q2.c cVar = c2.f5494a;
        if (cVar.f5493e == null) {
            cVar.f5493e = new ArrayList();
        }
        c2.f5494a.f5493e.add(q2Var2);
        bVar2.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, c.b.d.j] */
    @Override // c.b.d.p2
    public void d(q2.b bVar, int i, j jVar) {
        q2.c.a c2 = q2.c.c();
        c2.c(jVar);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.p2
    public void e(q2.b bVar, int i, long j) {
        q2.c.a c2 = q2.c.c();
        c2.d(j);
        bVar.d(i, c2.e());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public q2.b f(Object obj) {
        return ((l0) obj).unknownFields.toBuilder();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public q2 g(Object obj) {
        return ((l0) obj).unknownFields;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public int h(q2 q2Var) {
        return q2Var.getSerializedSize();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public int i(q2 q2Var) {
        return q2Var.a();
    }

    @Override // c.b.d.p2
    public void j(Object obj) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public q2 k(q2 q2Var, q2 q2Var2) {
        q2.b d2 = q2Var.toBuilder();
        d2.g(q2Var2);
        return d2.build();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.p2
    public q2.b m() {
        return q2.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public void n(Object obj, q2.b bVar) {
        ((l0) obj).unknownFields = bVar.build();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.p2
    public void o(Object obj, q2 q2Var) {
        ((l0) obj).unknownFields = q2Var;
    }

    @Override // c.b.d.p2
    public boolean p(b2 b2Var) {
        return b2Var.L();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.p2
    public q2 q(q2.b bVar) {
        return bVar.build();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.y2] */
    @Override // c.b.d.p2
    public void r(q2 q2Var, y2 y2Var) {
        q2 q2Var2 = q2Var;
        if (q2Var2 == null) {
            throw null;
        } else if (((n) y2Var) != null) {
            for (Map.Entry<Integer, q2.c> entry : q2Var2.f5484b.entrySet()) {
                q2.c.a(entry.getValue(), entry.getKey().intValue(), y2Var);
            }
        } else {
            throw null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.y2] */
    @Override // c.b.d.p2
    public void s(q2 q2Var, y2 y2Var) {
        q2Var.f(y2Var);
    }
}
