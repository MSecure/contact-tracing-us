package e.r;

import android.os.Bundle;
import e.r.q;
import f.a.a.a.a;

@q.b("navigation")
public class l extends q<k> {
    public final r a;

    public l(r rVar) {
        this.a = rVar;
    }

    /* Return type fixed from 'e.r.j' to match base method */
    @Override // e.r.q
    public k a() {
        return new k(this);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [e.r.j, android.os.Bundle, e.r.o, e.r.q$a] */
    @Override // e.r.q
    public j b(k kVar, Bundle bundle, o oVar, q.a aVar) {
        String str;
        k kVar2 = kVar;
        int i2 = kVar2.f1755k;
        if (i2 == 0) {
            StringBuilder h2 = a.h("no start destination defined via app:startDestination for ");
            int i3 = kVar2.f1745d;
            if (i3 != 0) {
                if (kVar2.f1746e == null) {
                    kVar2.f1746e = Integer.toString(i3);
                }
                str = kVar2.f1746e;
            } else {
                str = "the root navigation";
            }
            h2.append(str);
            throw new IllegalStateException(h2.toString());
        }
        j o = kVar2.o(i2, false);
        if (o != null) {
            return this.a.c(o.b).b(o, o.h(bundle), oVar, aVar);
        }
        if (kVar2.f1756l == null) {
            kVar2.f1756l = Integer.toString(kVar2.f1755k);
        }
        throw new IllegalArgumentException(a.c("navigation destination ", kVar2.f1756l, " is not a direct child of this NavGraph"));
    }

    @Override // e.r.q
    public boolean e() {
        return true;
    }
}
