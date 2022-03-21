package f.b.b.a;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

public class i {
    public final String a;

    public i(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[Catch:{ IOException -> 0x004b }] */
    public final String a(Iterable<?> iterable) {
        String str;
        StringBuilder sb;
        Object next;
        Iterator<?> it = iterable.iterator();
        StringBuilder sb2 = new StringBuilder();
        try {
            if (it.hasNext()) {
                Object next2 = it.next();
                Objects.requireNonNull(next2);
                if (next2 instanceof CharSequence) {
                    StringBuilder sb3 = sb2;
                    str = (CharSequence) next2;
                    sb = sb3;
                    sb2.append(str);
                    if (it.hasNext()) {
                        sb2.append((CharSequence) this.a);
                        next = it.next();
                        Objects.requireNonNull(next);
                        if (next instanceof CharSequence) {
                            sb3 = sb;
                            next2 = next;
                            str = (CharSequence) next2;
                            sb = sb3;
                            sb2.append(str);
                            if (it.hasNext()) {
                                sb2 = sb;
                            }
                        }
                    }
                    sb2 = sb;
                } else {
                    next = next2;
                    sb = sb2;
                }
                str = next.toString();
                sb2.append(str);
                if (it.hasNext()) {
                }
                sb2 = sb;
            }
            return sb2.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
