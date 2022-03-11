package e.j.i;
/* loaded from: classes.dex */
public class d<T> extends c<T> {
    public final Object c = new Object();

    public d(int i2) {
        super(i2);
    }

    @Override // e.j.i.c
    public T a() {
        T t;
        synchronized (this.c) {
            t = (T) super.a();
        }
        return t;
    }

    @Override // e.j.i.c
    public boolean b(T t) {
        boolean b;
        synchronized (this.c) {
            b = super.b(t);
        }
        return b;
    }
}
