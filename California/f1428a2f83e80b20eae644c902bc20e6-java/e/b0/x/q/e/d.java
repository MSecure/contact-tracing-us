package e.b0.x.q.e;

import android.content.Context;
import android.os.Build;
import e.b0.m;
import e.b0.x.q.b;
import e.b0.x.q.f.g;
import e.b0.x.s.o;
import e.b0.x.t.q.a;

public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.b0.x.q.e.c
    public boolean b(o oVar) {
        return oVar.f1120j.a == m.CONNECTED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.b0.x.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        if (Build.VERSION.SDK_INT < 26) {
            return true ^ bVar2.a;
        }
        if (!bVar2.a || !bVar2.b) {
            return true;
        }
        return false;
    }
}
