package e.z.x.q.e;

import android.content.Context;
import android.os.Build;
import e.z.l;
import e.z.m;
import e.z.x.q.b;
import e.z.x.q.f.g;
import e.z.x.s.o;
import e.z.x.t.q.a;

public class e extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1961e = l.e("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.z.x.q.e.c
    public boolean b(o oVar) {
        return oVar.f1994j.a == m.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.z.x.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            l.c().a(f1961e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.c) {
            z = false;
        }
        return z;
    }
}
