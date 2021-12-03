package f.b.c.k.u;

import f.a.a.a.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l extends a<l> {
    public static final l c = new l(Collections.emptyList());

    public l(List<String> list) {
        super(list);
    }

    public static l r(List<String> list) {
        return list.isEmpty() ? c : new l(list);
    }

    public static l s(String str) {
        if (!str.contains("//")) {
            String[] split = str.split("/");
            ArrayList arrayList = new ArrayList(split.length);
            for (String str2 : split) {
                if (!str2.isEmpty()) {
                    arrayList.add(str2);
                }
            }
            return new l(arrayList);
        }
        throw new IllegalArgumentException(a.d("Invalid path (", str, "). Paths must not contain // in them."));
    }

    @Override // f.b.c.k.u.a
    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (i2 > 0) {
                sb.append("/");
            }
            sb.append(this.b.get(i2));
        }
        return sb.toString();
    }

    /* Return type fixed from 'f.b.c.k.u.a' to match base method */
    @Override // f.b.c.k.u.a
    public l f(List list) {
        return new l(list);
    }
}
