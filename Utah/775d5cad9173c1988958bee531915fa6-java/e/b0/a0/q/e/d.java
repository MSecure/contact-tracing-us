package e.b0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.b0.a0.q.b;
import e.b0.a0.q.f.g;
import e.b0.a0.s.o;
import e.b0.a0.t.t.a;

public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.b0.a0.q.e.c
    public boolean b(o oVar) {
        return oVar.f1118j.a == e.b0.o.CONNECTED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.b0.a0.q.e.c
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
