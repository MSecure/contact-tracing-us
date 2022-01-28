package h.a.k1.p;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;

public final class l {
    public static final String[] a = new String[0];
    public static final Charset b = Charset.forName("UTF-8");

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(Class<T> cls, T[] tArr, T[] tArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object[] objArr : tArr) {
            int length = tArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                T t = tArr2[i2];
                if (objArr.equals(t)) {
                    arrayList.add(t);
                    break;
                }
                i2++;
            }
        }
        return (T[]) arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
    }
}
