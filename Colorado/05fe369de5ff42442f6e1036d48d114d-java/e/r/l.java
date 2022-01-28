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
        int i2 = kVar2.f1585k;
        if (i2 == 0) {
            StringBuilder i3 = a.i("no start destination defined via app:startDestination for ");
            int i4 = kVar2.f1575d;
            if (i4 != 0) {
                if (kVar2.f1576e == null) {
                    kVar2.f1576e = Integer.toString(i4);
                }
                str = kVar2.f1576e;
            } else {
                str = "the root navigation";
            }
            i3.append(str);
            throw new IllegalStateException(i3.toString());
        }
        j o = kVar2.o(i2, false);
        if (o != null) {
            return this.a.c(o.b).b(o, o.h(bundle), oVar, aVar);
        }
        if (kVar2.f1586l == null) {
            kVar2.f1586l = Integer.toString(kVar2.f1585k);
        }
        throw new IllegalArgumentException(a.d("navigation destination ", kVar2.f1586l, " is not a direct child of this NavGraph"));
    }

    @Override // e.r.q
    public boolean e() {
        return true;
    }
}
