package b.b0.y.p.e;

import android.content.Context;
import android.os.Build;
import b.b0.m;
import b.b0.n;
import b.b0.y.p.b;
import b.b0.y.p.f.g;
import b.b0.y.r.p;
import b.b0.y.s.s.a;

public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1178e = m.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).f1195c);
    }

    @Override // b.b0.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1009a == n.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.b0.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            m.c().a(f1178e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.f1165a;
        }
        if (bVar2.f1165a && bVar2.f1168d) {
            z = false;
        }
        return z;
    }
}
