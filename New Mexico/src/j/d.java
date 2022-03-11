package j;

import j.k.a.a;
import j.k.b.e;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class d<T> implements b<T>, Serializable {
    public a<? extends T> b;
    public volatile Object c = f.a;

    /* renamed from: d  reason: collision with root package name */
    public final Object f4569d = this;

    public d(a aVar, Object obj, int i2) {
        int i3 = i2 & 2;
        e.c(aVar, "initializer");
        this.b = aVar;
    }

    @Override // j.b
    public T getValue() {
        T t;
        T t2 = (T) this.c;
        f fVar = f.a;
        if (t2 != fVar) {
            return t2;
        }
        synchronized (this.f4569d) {
            t = (T) this.c;
            if (t == fVar) {
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

    @Override // java.lang.Object
    public String toString() {
        return this.c != f.a ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
