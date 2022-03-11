package e.r;
/* loaded from: classes.dex */
public final class d0 implements t<X> {
    public boolean a = true;
    public final /* synthetic */ q b;

    public d0(q qVar) {
        this.b = qVar;
    }

    @Override // e.r.t
    public void a(X x) {
        T d2 = this.b.d();
        if (this.a || ((d2 == 0 && x != 0) || (d2 != 0 && !d2.equals(x)))) {
            this.a = false;
            this.b.l(x);
        }
    }
}
