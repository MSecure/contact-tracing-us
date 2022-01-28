package b.n;

public final class w implements q<X> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1420a = true;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f1421b;

    public w(n nVar) {
        this.f1421b = nVar;
    }

    @Override // b.n.q
    public void a(X x) {
        Object value = this.f1421b.getValue();
        if (this.f1420a || ((value == null && x != null) || (value != null && !value.equals(x)))) {
            this.f1420a = false;
            this.f1421b.setValue(x);
        }
    }
}
