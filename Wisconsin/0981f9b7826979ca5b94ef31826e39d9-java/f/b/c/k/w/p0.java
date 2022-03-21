package f.b.c.k.w;

import f.b.a.c.b.o.b;
import f.b.c.k.u.f;
import f.b.f.j;
import java.util.HashMap;
import java.util.Map;

public final class p0 {
    public int a = 0;
    public final Map<f, f.b.c.k.s.f> b = new HashMap();
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public j f3161d = j.c;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3162e = false;

    public boolean a() {
        return this.a != 0;
    }

    public o0 b() {
        f.b.c.g.a.f<f> fVar = f.c;
        f.b.c.g.a.f<f> fVar2 = fVar;
        f.b.c.g.a.f<f> fVar3 = fVar2;
        f.b.c.g.a.f<f> fVar4 = fVar3;
        for (Map.Entry<f, f.b.c.k.s.f> entry : this.b.entrySet()) {
            f key = entry.getKey();
            f.b.c.k.s.f value = entry.getValue();
            int ordinal = value.ordinal();
            if (ordinal == 0) {
                fVar4 = fVar4.h(key);
            } else if (ordinal == 1) {
                fVar2 = fVar2.h(key);
            } else if (ordinal == 2) {
                fVar3 = fVar3.h(key);
            } else {
                b.z0("Encountered invalid change type: %s", value);
                throw null;
            }
        }
        return new o0(this.f3161d, this.f3162e, fVar2, fVar3, fVar4);
    }

    public void c(j jVar) {
        if (!jVar.isEmpty()) {
            this.c = true;
            this.f3161d = jVar;
        }
    }
}
