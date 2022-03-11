package j.h;

import j.j.b.e;
import j.l.b;
import java.util.Iterator;

public final class a implements b<T> {
    public final /* synthetic */ Object[] a;

    public a(Object[] objArr) {
        this.a = objArr;
    }

    @Override // j.l.b
    public Iterator<T> iterator() {
        Object[] objArr = this.a;
        e.c(objArr, "array");
        return new j.j.b.a(objArr);
    }
}
