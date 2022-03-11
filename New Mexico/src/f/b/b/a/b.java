package f.b.b.a;

import f.b.b.a.r;
import java.util.Iterator;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class b<T> implements Iterator<T> {
    public a b = a.NOT_READY;
    public T c;

    /* loaded from: classes.dex */
    public enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004f, code lost:
        if (r4 >= r5) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005d, code lost:
        if (r1.f3380e.a(r1.f3379d.charAt(r4)) == false) goto L_0x0062;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        if (r5 <= r4) goto L_0x0076;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        r9 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0072, code lost:
        if (r1.f3380e.a(r1.f3379d.charAt(r9)) == false) goto L_0x0076;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0074, code lost:
        r5 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        if (r1.f3381f == false) goto L_0x007d;
     */
    @Override // java.util.Iterator
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean hasNext() {
        int i2;
        T t;
        int c;
        a aVar = this.b;
        a aVar2 = a.FAILED;
        f.b.a.c.b.o.b.F(aVar != aVar2);
        int ordinal = this.b.ordinal();
        if (ordinal == 0) {
            return true;
        }
        if (ordinal == 2) {
            return false;
        }
        a aVar3 = a.DONE;
        this.b = aVar2;
        r.a aVar4 = (r.a) this;
        loop0: do {
            i2 = aVar4.f3382g;
            while (true) {
                int i3 = aVar4.f3382g;
                if (i3 == -1) {
                    aVar4.b = aVar3;
                    t = null;
                    break loop0;
                }
                c = aVar4.c(i3);
                if (c == -1) {
                    c = aVar4.f3379d.length();
                    aVar4.f3382g = -1;
                } else {
                    aVar4.f3382g = aVar4.b(c);
                }
                int i4 = aVar4.f3382g;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    aVar4.f3382g = i5;
                    if (i5 > aVar4.f3379d.length()) {
                        aVar4.f3382g = -1;
                    }
                }
            }
        } while (i2 == c);
        int i6 = aVar4.f3383h;
        if (i6 == 1) {
            c = aVar4.f3379d.length();
            aVar4.f3382g = -1;
            while (c > i2) {
                int i7 = c - 1;
                if (!aVar4.f3380e.a(aVar4.f3379d.charAt(i7))) {
                    break;
                }
                c = i7;
            }
        } else {
            aVar4.f3383h = i6 - 1;
        }
        t = (T) aVar4.f3379d.subSequence(i2, c).toString();
        this.c = t;
        if (this.b == aVar3) {
            return false;
        }
        this.b = a.READY;
        return true;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.b = a.NOT_READY;
            T t = this.c;
            this.c = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
