package e.i.h;

public class c<T> extends b<T> {
    public final Object c = new Object();

    public c(int i2) {
        super(i2);
    }

    @Override // e.i.h.b
    public T a() {
        T t;
        synchronized (this.c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // e.i.h.b
    public boolean b(T t) {
        boolean b;
        synchronized (this.c) {
            b = super.b(t);
        }
        return b;
    }
}
