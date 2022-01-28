package b.z.y.p.e;

import android.content.Context;
import android.os.Build;
import b.z.m;
import b.z.n;
import b.z.y.p.b;
import b.z.y.p.f.g;
import b.z.y.r.p;
import b.z.y.s.s.a;

public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2040e = m.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).f2054c);
    }

    @Override // b.z.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1898a == n.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.z.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            m.c().a(f2040e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.f2027a;
        }
        if (bVar2.f2027a && bVar2.f2030d) {
            z = false;
        }
        return z;
    }
}
