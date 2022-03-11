package f.b.b.a;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;
/* loaded from: classes.dex */
public class i {
    public final String a;

    public i(String str) {
        Objects.requireNonNull(str);
        this.a = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c A[Catch: IOException -> 0x004b, TryCatch #0 {IOException -> 0x004b, blocks: (B:3:0x0009, B:5:0x000f, B:9:0x001f, B:10:0x0023, B:12:0x002c, B:15:0x003f), top: B:23:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final String a(Iterable<?> iterable) {
        CharSequence charSequence;
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
                    charSequence = (CharSequence) next2;
                    sb = sb3;
                    sb2.append(charSequence);
                    if (!it.hasNext()) {
                        sb2.append((CharSequence) this.a);
                        next = it.next();
                        Objects.requireNonNull(next);
                        if (next instanceof CharSequence) {
                            sb3 = sb;
                            next2 = next;
                            charSequence = (CharSequence) next2;
                            sb = sb3;
                            sb2.append(charSequence);
                            if (!it.hasNext()) {
                                sb2 = sb;
                            }
                        }
                        charSequence = next.toString();
                        sb2.append(charSequence);
                        if (!it.hasNext()) {
                        }
                    }
                } else {
                    next = next2;
                    sb = sb2;
                    charSequence = next.toString();
                    sb2.append(charSequence);
                    if (!it.hasNext()) {
                    }
                }
            }
            return sb2.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
