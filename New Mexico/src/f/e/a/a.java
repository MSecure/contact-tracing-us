package f.e.a;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    public final String[] a;

    /* loaded from: classes.dex */
    public static final class b {
        public final List<String> a = new ArrayList(20);
    }

    public a(b bVar, C0137a aVar) {
        List<String> list = bVar.a;
        this.a = (String[]) list.toArray(new String[list.size()]);
    }

    public String a(int i2) {
        int i3 = (i2 * 2) + 1;
        if (i3 < 0) {
            return null;
        }
        String[] strArr = this.a;
        if (i3 >= strArr.length) {
            return null;
        }
        return strArr[i3];
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        int length = this.a.length / 2;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            if (i3 >= 0) {
                String[] strArr = this.a;
                if (i3 < strArr.length) {
                    str = strArr[i3];
                    sb.append(str);
                    sb.append(": ");
                    sb.append(a(i2));
                    sb.append("\n");
                }
            }
            str = null;
            sb.append(str);
            sb.append(": ");
            sb.append(a(i2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
