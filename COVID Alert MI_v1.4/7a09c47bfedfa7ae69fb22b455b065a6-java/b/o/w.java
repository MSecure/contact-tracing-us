package b.o;

public final class w implements q<X> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f2256a = true;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f2257b;

    public w(n nVar) {
        this.f2257b = nVar;
    }

    @Override // b.o.q
    public void a(X x) {
        Object value = this.f2257b.getValue();
        if (this.f2256a || ((value == null && x != null) || (value != null && !value.equals(x)))) {
            this.f2256a = false;
            this.f2257b.setValue(x);
        }
    }
}
