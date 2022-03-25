package e.c0.x.q.e;

import android.content.Context;
import android.os.Build;
import e.c0.l;
import e.c0.m;
import e.c0.x.q.b;
import e.c0.x.q.f.g;
import e.c0.x.s.o;
import e.c0.x.t.q.a;

public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1107e = l.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.c0.x.q.e.c
    public boolean b(o oVar) {
        return oVar.f1139j.a == m.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.c0.x.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            l.c().a(f1107e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.f1103d) {
            z = false;
        }
        return z;
    }
}
