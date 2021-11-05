package c.b.c.a.j0.a;

public class n1 extends l1<m1, m1> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, c.b.c.a.j0.a.i] */
    @Override // c.b.c.a.j0.a.l1
    public void a(m1 m1Var, int i, i iVar) {
        m1Var.c((i << 3) | 2, iVar);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.c.a.j0.a.l1
    public m1 b(Object obj) {
        y yVar = (y) obj;
        m1 m1Var = yVar.unknownFields;
        if (m1Var != m1.f) {
            return m1Var;
        }
        m1 b2 = m1.b();
        yVar.unknownFields = b2;
        return b2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // c.b.c.a.j0.a.l1
    public m1 d() {
        return m1.b();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // c.b.c.a.j0.a.l1
    public void e(Object obj, m1 m1Var) {
        ((y) obj).unknownFields = m1Var;
    }

    @Override // c.b.c.a.j0.a.l1
    public boolean f(e1 e1Var) {
        return false;
    }
}
