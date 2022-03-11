package j.i;

import j.k.b.e;
import j.m.b;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class a implements b<T> {
    public final /* synthetic */ Object[] a;

    public a(Object[] objArr) {
        this.a = objArr;
    }

    @Override // j.m.b
    public Iterator<T> iterator() {
        Object[] objArr = this.a;
        e.c(objArr, "array");
        return new j.k.b.a(objArr);
    }
}
