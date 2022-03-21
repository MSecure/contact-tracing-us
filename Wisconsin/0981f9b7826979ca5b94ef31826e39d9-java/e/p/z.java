package e.p;

public final class z implements r<X> {
    public boolean a = true;
    public final /* synthetic */ o b;

    public z(o oVar) {
        this.b = oVar;
    }

    @Override // e.p.r
    public void a(X x) {
        Object d2 = this.b.d();
        if (this.a || ((d2 == null && x != null) || (d2 != null && !d2.equals(x)))) {
            this.a = false;
            this.b.l(x);
        }
    }
}
