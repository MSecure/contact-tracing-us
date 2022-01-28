package e.b0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.b0.a0.q.b;
import e.b0.a0.s.o;
import e.b0.a0.t.t.a;

public class g extends c<b> {
    public g(Context context, a aVar) {
        super(e.b0.a0.q.f.g.a(context, aVar).c);
    }

    @Override // e.b0.a0.q.e.c
    public boolean b(o oVar) {
        e.b0.o oVar2 = oVar.f1118j.a;
        return oVar2 == e.b0.o.UNMETERED || (Build.VERSION.SDK_INT >= 30 && oVar2 == e.b0.o.TEMPORARILY_UNMETERED);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.b0.a0.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        return !bVar2.a || bVar2.c;
    }
}
