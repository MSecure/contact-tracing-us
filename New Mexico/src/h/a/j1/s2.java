package h.a.j1;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.util.Arrays;
import java.util.Map;
/* loaded from: classes.dex */
public final class s2 {
    public final String a;
    public final Map<String, ?> b;

    public s2(String str, Map<String, ?> map) {
        b.A(str, "policyName");
        this.a = str;
        b.A(map, "rawConfigValue");
        this.b = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s2)) {
            return false;
        }
        s2 s2Var = (s2) obj;
        return this.a.equals(s2Var.a) && this.b.equals(s2Var.b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public String toString() {
        k u1 = b.u1(this);
        u1.d("policyName", this.a);
        u1.d("rawConfigValue", this.b);
        return u1.toString();
    }
}
