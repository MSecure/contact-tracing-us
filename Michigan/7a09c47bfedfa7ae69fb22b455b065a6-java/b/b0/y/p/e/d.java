package b.b0.y.p.e;

import android.content.Context;
import android.os.Build;
import b.b0.n;
import b.b0.y.p.b;
import b.b0.y.p.f.g;
import b.b0.y.r.p;
import b.b0.y.s.s.a;

public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).f1195c);
    }

    @Override // b.b0.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1009a == n.CONNECTED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.b0.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        if (Build.VERSION.SDK_INT < 26) {
            return true ^ bVar2.f1165a;
        }
        if (!bVar2.f1165a || !bVar2.f1166b) {
            return true;
        }
        return false;
    }
}
