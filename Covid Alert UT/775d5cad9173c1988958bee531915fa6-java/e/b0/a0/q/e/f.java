package e.b0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.b0.a0.q.b;
import e.b0.a0.q.f.g;
import e.b0.a0.s.o;
import e.b0.a0.t.t.a;
import e.b0.n;

public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1086e = n.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.b0.a0.q.e.c
    public boolean b(o oVar) {
        return oVar.f1118j.a == e.b0.o.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.b0.a0.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            n.c().a(f1086e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.f1082d) {
            z = false;
        }
        return z;
    }
}
