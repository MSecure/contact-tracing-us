package e.c0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.c0.a0.q.b;
import e.c0.a0.s.o;
import e.c0.a0.t.t.a;
/* loaded from: classes.dex */
public class g extends c<b> {
    public g(Context context, a aVar) {
        super(e.c0.a0.q.f.g.a(context, aVar).c);
    }

    @Override // e.c0.a0.q.e.c
    public boolean b(o oVar) {
        e.c0.o oVar2 = oVar.f1197j.a;
        return oVar2 == e.c0.o.UNMETERED || (Build.VERSION.SDK_INT >= 30 && oVar2 == e.c0.o.TEMPORARILY_UNMETERED);
    }

    @Override // e.c0.a0.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        return !bVar2.a || bVar2.c;
    }
}
