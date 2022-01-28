package b.i.k;

public class d<T> extends c<T> {

    /* renamed from: c  reason: collision with root package name */
    public final Object f1137c = new Object();

    public d(int i) {
        super(i);
    }

    @Override // b.i.k.c
    public T a() {
        T t;
        synchronized (this.f1137c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // b.i.k.c
    public boolean b(T t) {
        boolean b2;
        synchronized (this.f1137c) {
            b2 = super.b(t);
        }
        return b2;
    }
}
