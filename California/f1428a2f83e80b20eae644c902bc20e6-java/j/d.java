package j;

import j.j.a.a;
import j.j.b.e;
import java.io.Serializable;

public final class d<T> implements b<T>, Serializable {
    public a<? extends T> b;
    public volatile Object c = e.a;

    /* renamed from: d  reason: collision with root package name */
    public final Object f3991d = this;

    public d(a aVar, Object obj, int i2) {
        int i3 = i2 & 2;
        e.c(aVar, "initializer");
        this.b = aVar;
    }

    @Override // j.b
    public T getValue() {
        T t;
        T t2 = (T) this.c;
        e eVar = e.a;
        if (t2 != eVar) {
            return t2;
        }
        synchronized (this.f3991d) {
            t = (T) this.c;
            if (t == eVar) {
                a<? extends T> aVar = this.b;
                if (aVar != null) {
                    t = (T) aVar.a();
                    this.c = t;
                    this.b = null;
                } else {
                    NullPointerException nullPointerException = new NullPointerException();
                    e.d(nullPointerException, e.class.getName());
                    throw nullPointerException;
                }
            }
        }
        return t;
    }

    public String toString() {
        return this.c != e.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
