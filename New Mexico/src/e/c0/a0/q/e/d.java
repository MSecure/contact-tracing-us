package e.c0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.c0.a0.q.b;
import e.c0.a0.q.f.g;
import e.c0.a0.s.o;
import e.c0.a0.t.t.a;
/* loaded from: classes.dex */
public class d extends c<b> {
    public d(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.c0.a0.q.e.c
    public boolean b(o oVar) {
        return oVar.f1197j.a == e.c0.o.CONNECTED;
    }

    @Override // e.c0.a0.q.e.c
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
