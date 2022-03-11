package e.c0.a0.q.e;

import android.content.Context;
import android.os.Build;
import e.c0.a0.q.b;
import e.c0.a0.q.f.g;
import e.c0.a0.s.o;
import e.c0.a0.t.t.a;
import e.c0.n;
/* loaded from: classes.dex */
public class f extends c<b> {

    /* renamed from: e  reason: collision with root package name */
    public static final String f1165e = n.e("NetworkNotRoamingCtrlr");

    public f(Context context, a aVar) {
        super(g.a(context, aVar).c);
    }

    @Override // e.c0.a0.q.e.c
    public boolean b(o oVar) {
        return oVar.f1197j.a == e.c0.o.NOT_ROAMING;
    }

    @Override // e.c0.a0.q.e.c
    public boolean c(b bVar) {
        b bVar2 = bVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            n.c().a(f1165e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !bVar2.a;
        }
        if (bVar2.a && bVar2.f1161d) {
            z = false;
        }
        return z;
    }
}
