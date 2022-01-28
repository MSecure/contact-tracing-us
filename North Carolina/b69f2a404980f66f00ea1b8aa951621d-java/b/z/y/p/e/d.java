package b.z.y.p.e;

import android.content.Context;
import android.os.Build;
import b.z.n;
import b.z.y.p.b;
import b.z.y.p.f.g;
import b.z.y.r.p;
import b.z.y.s.s.a;

public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).f2054c);
    }

    @Override // b.z.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1898a == n.CONNECTED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.z.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        if (Build.VERSION.SDK_INT < 26) {
            return true ^ bVar2.f2027a;
        }
        if (!bVar2.f2027a || !bVar2.f2028b) {
            return true;
        }
        return false;
    }
}
