package b.b0.y.p.e;

import android.content.Context;
import android.os.Build;
import b.b0.m;
import b.b0.n;
import b.b0.y.p.b;
import b.b0.y.p.f.g;
import b.b0.y.r.p;
import b.b0.y.s.s.a;

public class e extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1177e = m.e("NetworkMeteredCtrlr");

    public e(Context context, a aVar) {
        super(g.a(context, aVar).f1195c);
    }

    @Override // b.b0.y.p.e.c
    public boolean b(p pVar) {
        return pVar.j.f1009a == n.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // b.b0.y.p.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            m.c().a(f1177e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !bVar2.f1165a;
        }
        if (bVar2.f1165a && bVar2.f1167c) {
            z = false;
        }
        return z;
    }
}
