package e.b0.x.q.e;

import android.content.Context;
import android.os.Build;
import e.b0.l;
import e.b0.m;
import e.b0.x.q.b;
import e.b0.x.q.f.g;
import e.b0.x.s.o;
import e.b0.x.t.q.a;

public class e extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1087e = l.e("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.b0.x.q.e.c
    public boolean b(o oVar) {
        return oVar.f1120j.a == m.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.b0.x.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            l.c().a(f1087e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.c) {
            z = false;
        }
        return z;
    }
}
