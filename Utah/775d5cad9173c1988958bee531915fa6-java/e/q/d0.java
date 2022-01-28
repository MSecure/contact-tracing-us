package e.q;

public final class d0 implements t<X> {
    public boolean a = true;
    public final /* synthetic */ q b;

    public d0(q qVar) {
        this.b = qVar;
    }

    @Override // e.q.t
    public void a(X x) {
        Object d2 = this.b.d();
        if (this.a || ((d2 == null && x != null) || (d2 != null && !d2.equals(x)))) {
            this.a = false;
            this.b.l(x);
        }
    }
}
