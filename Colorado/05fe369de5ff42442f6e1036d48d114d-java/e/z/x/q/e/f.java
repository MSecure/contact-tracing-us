package e.z.x.q.e;

import android.content.Context;
import android.os.Build;
import e.z.l;
import e.z.m;
import e.z.x.q.b;
import e.z.x.q.f.g;
import e.z.x.s.o;
import e.z.x.t.q.a;

public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1962e = l.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.z.x.q.e.c
    public boolean b(o oVar) {
        return oVar.f1994j.a == m.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // e.z.x.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            l.c().a(f1962e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.f1958d) {
            z = false;
        }
        return z;
    }
}
