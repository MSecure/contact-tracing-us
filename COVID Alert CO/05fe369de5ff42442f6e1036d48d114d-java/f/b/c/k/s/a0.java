package f.b.c.k.s;

import android.content.Context;
import f.b.c.k.s.d;
import f.b.c.k.t.d;
import f.b.c.k.t.f0;
import f.b.c.k.t.h;
import f.b.c.k.t.r;
import f.b.c.k.t.r0;
import f.b.c.k.t.v;
import f.b.c.k.w.h0;
import f.b.c.k.x.c;
import java.util.Objects;

public class a0 extends t {
    @Override // f.b.c.k.s.t
    public d a(d.a aVar) {
        v vVar = ((r0) this.a).f3299g.f3284d;
        c cVar = aVar.b;
        r rVar = this.b;
        Objects.requireNonNull(vVar);
        return new v.d(cVar, rVar);
    }

    @Override // f.b.c.k.s.t
    public f0 b(d.a aVar) {
        h hVar = new h(new h0(aVar.c.a));
        v.a aVar2 = new v.a(aVar.f3218f.f3194e, 10, 1000);
        Context context = aVar.a;
        e eVar = aVar.c;
        return new r0(context, eVar.b, eVar.a, hVar, aVar2);
    }
}
