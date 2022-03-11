package f.b.b.b;

import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public final class f extends k<T> {
    public boolean b;
    public final /* synthetic */ Object c;

    public f(Object obj) {
        this.c = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.b;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    @Override // java.util.Iterator
    public T next() {
        if (!this.b) {
            this.b = true;
            return this.c;
        }
        throw new NoSuchElementException();
    }
}
