package f.b.a.f.a.b;

import f.b.a.c.b.o.b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public final /* synthetic */ class k1 implements r1 {
    public final /* synthetic */ s1 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f3257d;

    public /* synthetic */ k1(s1 s1Var, String str, int i2, long j2) {
        this.a = s1Var;
        this.b = str;
        this.c = i2;
        this.f3257d = j2;
    }

    @Override // f.b.a.f.a.b.r1
    public final Object a() {
        s1 s1Var = this.a;
        String str = this.b;
        int i2 = this.c;
        long j2 = this.f3257d;
        Objects.requireNonNull(s1Var);
        p1 p1Var = (p1) ((Map) s1Var.b(new r1(Arrays.asList(str)) { // from class: f.b.a.f.a.b.l1
            public final /* synthetic */ List b;

            {
                this.b = r2;
            }

            @Override // f.b.a.f.a.b.r1
            public final Object a() {
                s1 s1Var2 = s1.this;
                List list = this.b;
                Objects.requireNonNull(s1Var2);
                HashMap hashMap = new HashMap();
                for (p1 p1Var2 : s1Var2.f3303e.values()) {
                    String str2 = p1Var2.c.a;
                    if (list.contains(str2)) {
                        p1 p1Var3 = (p1) hashMap.get(str2);
                        if ((p1Var3 == null ? -1 : p1Var3.a) < p1Var2.a) {
                            hashMap.put(str2, p1Var2);
                        }
                    }
                }
                return hashMap;
            }
        })).get(str);
        if (p1Var == null || b.V1(p1Var.c.f3270d)) {
            s1.f3301g.b(String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        s1Var.a.c(str, i2, j2);
        p1Var.c.f3270d = 4;
        return null;
    }
}
