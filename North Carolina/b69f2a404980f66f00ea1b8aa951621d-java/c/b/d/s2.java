package c.b.d;

import c.b.d.p2;
import java.util.ArrayList;
import java.util.Map;

public class s2 extends o2<p2, p2.b> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int] */
    @Override // c.b.d.o2
    public void a(p2.b bVar, int i, int i2) {
        p2.c.a c2 = p2.c.c();
        c2.a(i2);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.o2
    public void b(p2.b bVar, int i, long j) {
        p2.c.a c2 = p2.c.c();
        c2.b(j);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, java.lang.Object] */
    @Override // c.b.d.o2
    public void c(p2.b bVar, int i, p2 p2Var) {
        p2.b bVar2 = bVar;
        p2 p2Var2 = p2Var;
        p2.c.a c2 = p2.c.c();
        p2.c cVar = c2.f4038a;
        if (cVar.f4037e == null) {
            cVar.f4037e = new ArrayList();
        }
        c2.f4038a.f4037e.add(p2Var2);
        bVar2.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, c.b.d.j] */
    @Override // c.b.d.o2
    public void d(p2.b bVar, int i, j jVar) {
        p2.c.a c2 = p2.c.c();
        c2.c(jVar);
        bVar.d(i, c2.e());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, long] */
    @Override // c.b.d.o2
    public void e(p2.b bVar, int i, long j) {
        p2.c.a c2 = p2.c.c();
        c2.d(j);
        bVar.d(i, c2.e());
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public p2.b f(Object obj) {
        return ((k0) obj).unknownFields.toBuilder();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public p2 g(Object obj) {
        return ((k0) obj).unknownFields;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public int h(p2 p2Var) {
        return p2Var.getSerializedSize();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public int i(p2 p2Var) {
        return p2Var.a();
    }

    @Override // c.b.d.o2
    public void j(Object obj) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public p2 k(p2 p2Var, p2 p2Var2) {
        p2.b d2 = p2Var.toBuilder();
        d2.g(p2Var2);
        return d2.build();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.d.o2
    public p2.b m() {
        return p2.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public void n(Object obj, p2.b bVar) {
        ((k0) obj).unknownFields = bVar.build();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.d.o2
    public void o(Object obj, p2 p2Var) {
        ((k0) obj).unknownFields = p2Var;
    }

    @Override // c.b.d.o2
    public boolean p(a2 a2Var) {
        return a2Var.N();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.b.d.o2
    public p2 q(p2.b bVar) {
        return bVar.build();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.x2] */
    @Override // c.b.d.o2
    public void r(p2 p2Var, x2 x2Var) {
        p2 p2Var2 = p2Var;
        if (p2Var2 == null) {
            throw null;
        } else if (((n) x2Var) != null) {
            for (Map.Entry<Integer, p2.c> entry : p2Var2.f4028b.entrySet()) {
                p2.c.a(entry.getValue(), entry.getKey().intValue(), x2Var);
            }
        } else {
            throw null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, c.b.d.x2] */
    @Override // c.b.d.o2
    public void s(p2 p2Var, x2 x2Var) {
        p2Var.f(x2Var);
    }
}
