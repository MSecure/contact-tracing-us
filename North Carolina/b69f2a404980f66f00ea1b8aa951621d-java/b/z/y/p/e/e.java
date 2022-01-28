package b.z.y.p.e;

import android.content.Context;
import android.os.Build;
import b.z.m;
import b.z.n;
import b.z.y.p.b;
import b.z.y.p.f.g;
import b.z.y.r.p;
import b.z.y.s.s.a;

public class e extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f2039e = m.e("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.a(context, aVar).f2054c);
    }

    @Override // b.z.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1898a == n.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.z.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            m.c().a(f2039e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !bVar2.f2027a;
        }
        if (bVar2.f2027a && bVar2.f2029c) {
            z = false;
        }
        return z;
    }
}
