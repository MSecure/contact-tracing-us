package f.b.c.f;

import f.a.a.a.a;
import java.util.Arrays;
import java.util.List;

public class p extends q {
    public final List<d<?>> b;

    /* JADX WARNING: Illegal instructions before constructor call */
    public p(List<d<?>> list) {
        super(r0.toString());
        StringBuilder h2 = a.h("Dependency cycle detected: ");
        h2.append(Arrays.toString(list.toArray()));
        this.b = list;
    }
}
