package f.b.c.f;

import f.b.c.m.a;

public class t<T> implements a<T> {
    public static final Object c = new Object();
    public volatile Object a = c;
    public volatile a<T> b;

    public t(a<T> aVar) {
        this.b = aVar;
    }

    @Override // f.b.c.m.a
    public T get() {
        T t = (T) this.a;
        Object obj = c;
        if (t == obj) {
            synchronized (this) {
                t = this.a;
                if (t == obj) {
                    t = this.b.get();
                    this.a = t;
                    this.b = null;
                }
            }
        }
        return t;
    }
}
