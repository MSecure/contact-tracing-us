package b.i.k;

public class c<T> extends b<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f1845c = new Object();

    public c(int i) {
        super(i);
    }

    @Override // b.i.k.b
    public T a() {
        T t;
        synchronized (this.f1845c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // b.i.k.b
    public boolean b(T t) {
        boolean b2;
        synchronized (this.f1845c) {
            b2 = super.b(t);
        }
        return b2;
    }
}
