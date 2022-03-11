package f.b.a.f.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import e.a.e.e;
import f.b.a.a.a.s.b;
import f.b.a.f.a.d.a;
import f.b.a.f.a.h.n;
import f.b.a.f.a.h.r;
/* loaded from: classes.dex */
public final class g implements b {
    public final o a;
    public final Context b;

    public g(o oVar, e eVar, Context context) {
        new Handler(Looper.getMainLooper());
        this.a = oVar;
        this.b = context;
    }

    @Override // f.b.a.f.a.a.b
    public final r<a> a() {
        o oVar = this.a;
        String packageName = this.b.getPackageName();
        if (oVar.a == null) {
            o.f3172e.b("onError(%d)", -9);
            a aVar = new a(-9);
            r<a> rVar = new r<>();
            rVar.f(aVar);
            return rVar;
        }
        o.f3172e.d("requestUpdateInfo(%s)", packageName);
        n<?> nVar = new n<>();
        oVar.a.b(new m(oVar, nVar, packageName, nVar), nVar);
        return nVar.a;
    }

    @Override // f.b.a.f.a.a.b
    public final boolean b(a aVar, int i2, f.b.a.f.a.c.a aVar2, int i3) {
        c c = c.c(i2);
        if (aVar != null) {
            if ((aVar.a(c) != null) && !aVar.f3164h) {
                aVar.f3164h = true;
                ((b) aVar2).a.a(new e(aVar.a(c).getIntentSender(), null, 0, 0), null);
                return true;
            }
        }
        return false;
    }
}
